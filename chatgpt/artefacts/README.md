# ENORM LTS Xtext Starter Package

This zip contains the important files for a focused Xtext/textual implementation of the ENORM LTS DSL.

It is split into two parts:

1. `xtext/` contains the Xtext grammar plus representative Xtend validator, scope provider, quick fix, generator, schema inference, and test skeletons. These files are intended to be copied into a normal Eclipse Xtext project generated with the Xtext wizard.
2. `runtime-java/` is a standalone Java demo runtime with hand-generated Java for the three required LTS models: Salary, Invoicing, and Grading. This part can be compiled and executed immediately to test the intended generated code architecture.

## Fast test

From the extracted zip, with Maven:

```bash
cd runtime-java
mvn test
./run-all.sh
```

With only a JDK:

```bash
cd runtime-java
./run-all-javac.sh
```

On Windows PowerShell, use `run-all.ps1` or `run-all-javac.ps1`.

The output CSV and log files are written to `runtime-java/out/`.

## Xtext usage

Create a standard Xtext project in Eclipse named `org.enorm.lts`, then replace or copy in the files under `xtext/org.enorm.lts/src`. The Xtend files are deliberately concise and may require package/import adjustment depending on the project wizard version you use. The grammar is the authoritative artifact.

This is not a complete pre-generated Eclipse workspace; it is a portable starter package with the implementation files and a runnable Java target architecture.
