package org.enorm.lts.schema

import java.util.LinkedHashMap
import org.eclipse.emf.ecore.EObject
import org.enorm.lts.lts.AggregateStatement
import org.enorm.lts.lts.ColumnDef
import org.enorm.lts.lts.CreateStatement
import org.enorm.lts.lts.DropColumnsStatement
import org.enorm.lts.lts.JoinStatement
import org.enorm.lts.lts.LoadStatement
import org.enorm.lts.lts.Process
import org.enorm.lts.lts.SetColumnStatement
import org.enorm.lts.lts.Statement
import org.enorm.lts.lts.Type

class TableEnvironmentBuilder {

    def TableEnvironment environmentBefore(EObject object) {
        val process = object.eContainerChain.filter(Process).head
        val env = new TableEnvironment
        if (process === null) return env

        for (stmt : process.statements) {
            if (stmt === object || contains(stmt, object)) return env
            env.apply(stmt)
        }
        env
    }

    private def boolean contains(EObject root, EObject child) {
        if (root === child) return true
        root.eAllContents.exists[it === child]
    }

    private def Iterable<EObject> eContainerChain(EObject o) {
        val list = newArrayList
        var cur = o
        while (cur !== null) {
            list.add(cur)
            cur = cur.eContainer
        }
        list
    }
}

class TableEnvironment {
    val tables = new LinkedHashMap<String, TableSchema>

    def TableSchema schemaOf(String name) { tables.get(name) }

    def void define(String name, TableSchema schema) { tables.put(name, schema) }

    def void apply(Statement stmt) {
        switch stmt {
            LoadStatement: define(stmt.name, TableSchema.from(stmt.columns))
            CreateStatement: define(stmt.name, TableSchema.from(stmt.columns))
            AggregateStatement: {
                val source = schemaOf(stmt.source.name)
                if (source !== null) {
                    val result = new TableSchema
                    for (g : stmt.groupColumns) {
                        val c = source.column(g)
                        if (c !== null) result.add(c.name, c.type)
                    }
                    for (a : stmt.aggregations) result.add(a.targetColumn, a.type)
                    define(stmt.name, result)
                }
            }
            JoinStatement: {
                val left = schemaOf(stmt.target.name)?.copy
                val right = schemaOf(stmt.source.name)
                if (left !== null && right !== null) {
                    for (a : stmt.addedColumns) {
                        val c = right.column(a.sourceColumn)
                        if (c !== null) left.add(if (a.targetColumn !== null) a.targetColumn else a.sourceColumn, c.type)
                    }
                    define(stmt.target.name, left)
                }
            }
            SetColumnStatement: {
                val s = schemaOf(stmt.table.name)?.copy
                if (s !== null) {
                    s.addOrReplace(stmt.column, stmt.type)
                    define(stmt.table.name, s)
                }
            }
            DropColumnsStatement: {
                val s = schemaOf(stmt.table.name)?.copy
                if (s !== null) {
                    for (c : stmt.columns) s.remove(c)
                    define(stmt.table.name, s)
                }
            }
        }
    }
}

class TableSchema {
    val columns = new LinkedHashMap<String, ColumnInfo>

    static def from(Iterable<ColumnDef> defs) {
        val s = new TableSchema
        for (d : defs) s.add(d.name, d.type)
        s
    }

    def ColumnInfo column(String name) { columns.get(name) }
    def add(String name, Type type) { columns.put(name, new ColumnInfo(name, type)) }
    def addOrReplace(String name, Type type) { columns.put(name, new ColumnInfo(name, type)) }
    def remove(String name) { columns.remove(name) }
    def copy() {
        val c = new TableSchema
        for (e : columns.entrySet) c.add(e.key, e.value.type)
        c
    }
}

class ColumnInfo {
    public val String name
    public val Type type
    new(String name, Type type) { this.name = name; this.type = type }
}
