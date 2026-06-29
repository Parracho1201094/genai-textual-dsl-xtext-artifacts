<?xml version="1.0" encoding="UTF-8"?>
<model ref="r:49d75c6c-867c-43e3-b2ea-09fd612ecfe3(ltsdsl.salary)">
  <persistence version="9" />
  <languages>
    <use id="1f55f171-d454-489b-bbc2-2455ab34472f" name="ltsdsl" version="0" />
  </languages>
  <imports />
  <registry>
    <language id="1f55f171-d454-489b-bbc2-2455ab34472f" name="ltsdsl">
      <concept id="6905902123112595238" name="ltsdsl.structure.Lookup" flags="ng" index="aqOT2">
        <property id="6905902123112595274" name="operation" index="aqOSI" />
        <reference id="6905902123112595268" name="resultColumn" index="aqOSw" />
        <reference id="6905902123112595294" name="resultTable" index="aqOSU" />
        <reference id="6905902123112595245" name="lookupTable" index="aqOT9" />
        <reference id="6905902123112595242" name="table" index="aqOTe" />
        <reference id="6905902123112595252" name="column" index="aqOTg" />
        <reference id="6905902123112595254" name="matchColumn" index="aqOTi" />
        <reference id="6905902123112595262" name="lookupColumn" index="aqOTq" />
        <reference id="6905902123112595258" name="operandColumn" index="aqOTu" />
      </concept>
      <concept id="6905902123110804679" name="ltsdsl.structure.Group" flags="ng" index="at1Qz">
        <property id="6905902123111070934" name="operation" index="as0QM" />
        <reference id="6905902123111070951" name="resultTable" index="as0Q3" />
        <reference id="6905902123111070954" name="resultColumn" index="as0Qe" />
        <reference id="6905902123110804683" name="table" index="at1QJ" />
        <reference id="6905902123110804691" name="operandColumn" index="at1QR" />
        <child id="6905902123110804687" name="groupBy" index="at1QF" />
      </concept>
      <concept id="6905902123105889280" name="ltsdsl.structure.Join" flags="ng" index="awhP$">
        <property id="6905902123105898129" name="type" index="awnZP" />
        <reference id="6905902123105889285" name="leftColumn" index="awhPx" />
        <reference id="6905902123105889281" name="leftTable" index="awhP_" />
        <reference id="6905902123105889288" name="rightColumn" index="awhPG" />
        <reference id="6905902123105889290" name="rightTable" index="awhPI" />
        <reference id="6905902123106058869" name="resultTable" index="azfch" />
        <child id="6905902123106062506" name="selectColumns" index="aze7e" />
      </concept>
      <concept id="6905902123103111681" name="ltsdsl.structure.AppendRowsMap" flags="ng" index="aYZH_">
        <reference id="6905902123103111685" name="toCol" index="aYZHx" />
        <reference id="6905902123103111683" name="fromCol" index="aYZHB" />
      </concept>
      <concept id="6905902123102985831" name="ltsdsl.structure.AppendRows" flags="ng" index="aZuW3">
        <reference id="6905902123103007621" name="toTable" index="aZgbx" />
        <reference id="6905902123103007617" name="fromTable" index="aZgb_" />
        <child id="6905902123103146737" name="mappings" index="aYQel" />
      </concept>
      <concept id="5944580133722221338" name="ltsdsl.structure.RemoveDuplicates" flags="ng" index="2r90WS">
        <reference id="5944580133722221340" name="table" index="2r90WY" />
        <reference id="5944580133722221341" name="column" index="2r90WZ" />
      </concept>
      <concept id="2876302107890287662" name="ltsdsl.structure.TableToImport" flags="ng" index="SqaAD">
        <property id="2876302107890287668" name="delimiter" index="SqaAN" />
        <property id="2876302107890287666" name="path" index="SqaAP" />
        <reference id="2876302107890287664" name="table" index="SqaAR" />
      </concept>
      <concept id="2876302107890255803" name="ltsdsl.structure.Import" flags="ng" index="SqMCW">
        <child id="2876302107890287670" name="tablesToImport" index="SqaAL" />
      </concept>
      <concept id="4586606112866582226" name="ltsdsl.structure.ColumnRef" flags="ng" index="1dEHGB">
        <reference id="6905902123106125267" name="column" index="azviR" />
      </concept>
      <concept id="4586606112866582218" name="ltsdsl.structure.Save" flags="ng" index="1dEHGZ">
        <child id="4586606112866582225" name="tablesToSave" index="1dEHG$" />
      </concept>
      <concept id="4586606112866580997" name="ltsdsl.structure.FlowStep" flags="ng" index="1dEHZK">
        <reference id="4586606112866581001" name="next" index="1dEHZW" />
      </concept>
      <concept id="4586606112866581004" name="ltsdsl.structure.Table" flags="ng" index="1dEHZT">
        <child id="4586606112866608039" name="columns" index="1dE$pi" />
      </concept>
      <concept id="4586606112866581007" name="ltsdsl.structure.Column" flags="ng" index="1dEHZU">
        <property id="4586606112866581018" name="dataType" index="1dEHZJ" />
      </concept>
      <concept id="4586606112866511498" name="ltsdsl.structure.Model" flags="ng" index="1dFsXZ">
        <property id="4586606112866533288" name="logs" index="1dFpDt" />
        <child id="2876302107890292913" name="tables" index="SqbkQ" />
        <child id="4586606112866533286" name="steps" index="1dFpDj" />
      </concept>
      <concept id="4586606112867104687" name="ltsdsl.structure.TableToSave" flags="ng" index="1dGH9q">
        <property id="4586606112867104689" name="path" index="1dGH94" />
        <reference id="4586606112867104688" name="table" index="1dGH95" />
        <child id="4586606112867104690" name="columns" index="1dGH97" />
      </concept>
      <concept id="4586606112867087604" name="ltsdsl.structure.Sort" flags="ng" index="1dHh41">
        <property id="4586606112867088565" name="order" index="1dHhP0" />
        <reference id="4586606112867087605" name="table" index="1dHh40" />
        <reference id="4586606112867087606" name="column" index="1dHh43" />
      </concept>
    </language>
    <language id="ceab5195-25ea-4f22-9b92-103b95ca8c0c" name="jetbrains.mps.lang.core">
      <concept id="1169194658468" name="jetbrains.mps.lang.core.structure.INamedConcept" flags="ngI" index="TrEIO">
        <property id="1169194664001" name="name" index="TrG5h" />
      </concept>
    </language>
  </registry>
  <node concept="1dFsXZ" id="6v$U1VGXbtK">
    <property role="TrG5h" value="Salary" />
    <property role="1dFpDt" value="true" />
    <node concept="SqMCW" id="5Z8cvS2CwzB" role="1dFpDj">
      <property role="TrG5h" value="Import" />
      <ref role="1dEHZW" node="6v$U1VGXbv0" resolve="sortEmployeeTableByID" />
      <node concept="SqaAD" id="5Z8cvS2CxFD" role="SqaAL">
        <property role="SqaAP" value="/employees.csv" />
        <property role="SqaAN" value="," />
        <ref role="SqaAR" node="6v$U1VGXbtL" resolve="Employee" />
      </node>
      <node concept="SqaAD" id="5Z8cvS2CxFE" role="SqaAL">
        <property role="SqaAP" value="/categories.csv" />
        <property role="SqaAN" value="," />
        <ref role="SqaAR" node="6v$U1VGXbui" resolve="Category" />
      </node>
      <node concept="SqaAD" id="5Z8cvS2CxFF" role="SqaAL">
        <property role="SqaAN" value="," />
        <property role="SqaAP" value="/workedhours.csv" />
        <ref role="SqaAR" node="5Z8cvS2CfPJ" resolve="WorkedHours" />
      </node>
    </node>
    <node concept="1dEHZT" id="6v$U1VGXbtL" role="SqbkQ">
      <property role="TrG5h" value="Employees" />
      <node concept="1dEHZU" id="6v$U1VGXbtM" role="1dE$pi">
        <property role="TrG5h" value="id_employee" />
        <property role="1dEHZJ" value="3YATvlM33Cl/NUMBER" />
      </node>
      <node concept="1dEHZU" id="6v$U1VGXbtU" role="1dE$pi">
        <property role="TrG5h" value="name_employee" />
        <property role="1dEHZJ" value="3YATvlM33Cj/TEXT" />
      </node>
      <node concept="1dEHZU" id="6v$U1VGXbtX" role="1dE$pi">
        <property role="TrG5h" value="id_category" />
        <property role="1dEHZJ" value="3YATvlM33Cl/NUMBER" />
      </node>
    </node>
    <node concept="1dEHZT" id="6v$U1VGXbui" role="SqbkQ">
      <property role="TrG5h" value="Categories" />
      <node concept="1dEHZU" id="6v$U1VGXbuj" role="1dE$pi">
        <property role="TrG5h" value="id_category" />
        <property role="1dEHZJ" value="3YATvlM33Cl/NUMBER" />
      </node>
      <node concept="1dEHZU" id="6v$U1VGXbuw" role="1dE$pi">
        <property role="TrG5h" value="name_category" />
        <property role="1dEHZJ" value="3YATvlM33Cj/TEXT" />
      </node>
      <node concept="1dEHZU" id="6v$U1VGXbuz" role="1dE$pi">
        <property role="TrG5h" value="value_worked_hours" />
        <property role="1dEHZJ" value="3YATvlM33Cl/NUMBER" />
      </node>
    </node>
    <node concept="1dEHZT" id="5Z8cvS2CfPJ" role="SqbkQ">
      <property role="TrG5h" value="WorkedHours" />
      <node concept="1dEHZU" id="5Z8cvS2CfPK" role="1dE$pi">
        <property role="TrG5h" value="id_employee" />
        <property role="1dEHZJ" value="3YATvlM33Cl/NUMBER" />
      </node>
      <node concept="1dEHZU" id="5Z8cvS2CfQp" role="1dE$pi">
        <property role="TrG5h" value="date" />
        <property role="1dEHZJ" value="3YATvlM33Cm/DATE" />
      </node>
      <node concept="1dEHZU" id="5Z8cvS2CfQs" role="1dE$pi">
        <property role="TrG5h" value="worked_hours" />
        <property role="1dEHZJ" value="3YATvlM33Cl/NUMBER" />
      </node>
    </node>
    <node concept="1dEHZT" id="5Z8cvS2CfJ5" role="SqbkQ">
      <property role="TrG5h" value="EmployeeJoinCategory" />
      <node concept="1dEHZU" id="5Z8cvS2CfJ6" role="1dE$pi">
        <property role="TrG5h" value="id_employee" />
        <property role="1dEHZJ" value="3YATvlM33Cl/NUMBER" />
      </node>
      <node concept="1dEHZU" id="5Z8cvS2CfJA" role="1dE$pi">
        <property role="TrG5h" value="name_employee" />
        <property role="1dEHZJ" value="3YATvlM33Cj/TEXT" />
      </node>
      <node concept="1dEHZU" id="5Z8cvS2CfJD" role="1dE$pi">
        <property role="TrG5h" value="id_category" />
        <property role="1dEHZJ" value="3YATvlM33Cl/NUMBER" />
      </node>
      <node concept="1dEHZU" id="5Z8cvS2CfJH" role="1dE$pi">
        <property role="TrG5h" value="name_category" />
        <property role="1dEHZJ" value="3YATvlM33Cj/TEXT" />
      </node>
      <node concept="1dEHZU" id="5Z8cvS2CfJM" role="1dE$pi">
        <property role="TrG5h" value="value_worked_hours" />
        <property role="1dEHZJ" value="3YATvlM33Cl/NUMBER" />
      </node>
    </node>
    <node concept="1dEHZT" id="5Z8cvS2CfJS" role="SqbkQ">
      <property role="TrG5h" value="SumWorkedHours" />
      <node concept="1dEHZU" id="5Z8cvS2CfJT" role="1dE$pi">
        <property role="TrG5h" value="id_employee" />
        <property role="1dEHZJ" value="3YATvlM33Cl/NUMBER" />
      </node>
      <node concept="1dEHZU" id="5Z8cvS2CfKv" role="1dE$pi">
        <property role="TrG5h" value="worked_hours" />
        <property role="1dEHZJ" value="3YATvlM33Cl/NUMBER" />
      </node>
    </node>
    <node concept="1dEHZT" id="5Z8cvS2CfKy" role="SqbkQ">
      <property role="TrG5h" value="EmployeeJoinCategoryJoinSumWorkedHours" />
      <node concept="1dEHZU" id="5Z8cvS2CfKz" role="1dE$pi">
        <property role="TrG5h" value="id_employee" />
        <property role="1dEHZJ" value="3YATvlM33Cl/NUMBER" />
      </node>
      <node concept="1dEHZU" id="5Z8cvS2CfLc" role="1dE$pi">
        <property role="TrG5h" value="name_employee" />
        <property role="1dEHZJ" value="3YATvlM33Cj/TEXT" />
      </node>
      <node concept="1dEHZU" id="5Z8cvS2CfLf" role="1dE$pi">
        <property role="TrG5h" value="id_category" />
        <property role="1dEHZJ" value="3YATvlM33Cl/NUMBER" />
      </node>
      <node concept="1dEHZU" id="5Z8cvS2CfLj" role="1dE$pi">
        <property role="TrG5h" value="name_category" />
        <property role="1dEHZJ" value="3YATvlM33Cj/TEXT" />
      </node>
      <node concept="1dEHZU" id="5Z8cvS2CfLo" role="1dE$pi">
        <property role="TrG5h" value="value_worked_hours" />
        <property role="1dEHZJ" value="3YATvlM33Cl/NUMBER" />
      </node>
      <node concept="1dEHZU" id="5Z8cvS2CfLu" role="1dE$pi">
        <property role="TrG5h" value="worked_hours" />
        <property role="1dEHZJ" value="3YATvlM33Cl/NUMBER" />
      </node>
    </node>
    <node concept="1dEHZT" id="6v$U1VGXbvy" role="SqbkQ">
      <property role="TrG5h" value="Payments" />
      <node concept="1dEHZU" id="6v$U1VGXbvz" role="1dE$pi">
        <property role="TrG5h" value="id_employee" />
        <property role="1dEHZJ" value="3YATvlM33Cl/NUMBER" />
      </node>
      <node concept="1dEHZU" id="6v$U1VGXbvM" role="1dE$pi">
        <property role="TrG5h" value="name_employee" />
        <property role="1dEHZJ" value="3YATvlM33Cj/TEXT" />
      </node>
      <node concept="1dEHZU" id="6v$U1VGXbvP" role="1dE$pi">
        <property role="TrG5h" value="id_category" />
        <property role="1dEHZJ" value="3YATvlM33Cl/NUMBER" />
      </node>
      <node concept="1dEHZU" id="6v$U1VGXbvT" role="1dE$pi">
        <property role="TrG5h" value="name_category" />
        <property role="1dEHZJ" value="3YATvlM33Cj/TEXT" />
      </node>
      <node concept="1dEHZU" id="6v$U1VGXbvY" role="1dE$pi">
        <property role="TrG5h" value="value_worked_hours" />
        <property role="1dEHZJ" value="3YATvlM33Cl/NUMBER" />
      </node>
      <node concept="1dEHZU" id="6v$U1VGXbw4" role="1dE$pi">
        <property role="TrG5h" value="total_worked_hours" />
        <property role="1dEHZJ" value="3YATvlM33Cl/NUMBER" />
      </node>
      <node concept="1dEHZU" id="6v$U1VGXbwb" role="1dE$pi">
        <property role="TrG5h" value="payment" />
        <property role="1dEHZJ" value="3YATvlM33Cl/NUMBER" />
      </node>
    </node>
    <node concept="1dEHZT" id="6v$U1VGXb$K" role="SqbkQ">
      <property role="TrG5h" value="PaymentsFinal" />
      <node concept="1dEHZU" id="6v$U1VGXb_b" role="1dE$pi">
        <property role="TrG5h" value="id_employee" />
        <property role="1dEHZJ" value="3YATvlM33Cl/NUMBER" />
      </node>
      <node concept="1dEHZU" id="6v$U1VGXb_c" role="1dE$pi">
        <property role="TrG5h" value="name_employee" />
        <property role="1dEHZJ" value="3YATvlM33Cj/TEXT" />
      </node>
      <node concept="1dEHZU" id="6v$U1VGXb_d" role="1dE$pi">
        <property role="TrG5h" value="id_category" />
        <property role="1dEHZJ" value="3YATvlM33Cl/NUMBER" />
      </node>
      <node concept="1dEHZU" id="6v$U1VGXb_e" role="1dE$pi">
        <property role="TrG5h" value="name_category" />
        <property role="1dEHZJ" value="3YATvlM33Cj/TEXT" />
      </node>
      <node concept="1dEHZU" id="6v$U1VGXb_h" role="1dE$pi">
        <property role="TrG5h" value="payment" />
        <property role="1dEHZJ" value="3YATvlM33Cl/NUMBER" />
      </node>
    </node>
    <node concept="1dHh41" id="6v$U1VGXbv0" role="1dFpDj">
      <property role="TrG5h" value="SortByEmployeeId" />
      <property role="1dHhP0" value="3YATvlM4ZjW/DESC" />
      <ref role="1dHh40" node="6v$U1VGXbtL" resolve="Employees" />
      <ref role="1dEHZW" node="6v$U1VGXbvg" resolve="RemoveDuplicatedEmployeeIds" />
      <ref role="1dHh43" node="6v$U1VGXbtM" resolve="id_employee" />
    </node>
    <node concept="2r90WS" id="6v$U1VGXbvg" role="1dFpDj">
      <property role="TrG5h" value="RemoveDuplicatedEmployeeIds" />
      <ref role="2r90WZ" node="6v$U1VGXbtM" resolve="id_employee" />
      <ref role="2r90WY" node="6v$U1VGXbtL" resolve="Employees" />
      <ref role="1dEHZW" node="5Z8cvS2CfNQ" resolve="EmployeeWithCategory" />
    </node>
    <node concept="awhP$" id="5Z8cvS2CfNQ" role="1dFpDj">
      <property role="TrG5h" value="EmployeeWithCategory" />
      <property role="awnZP" value="5ZmGmhllUKd/INNER" />
      <ref role="azfch" node="5Z8cvS2CfJ5" resolve="EmployeeJoinCategory" />
      <ref role="awhP_" node="6v$U1VGXbtL" resolve="Employee" />
      <ref role="awhPx" node="6v$U1VGXbtX" resolve="categoryID" />
      <ref role="awhPI" node="6v$U1VGXbui" resolve="Category" />
      <ref role="awhPG" node="6v$U1VGXbuj" resolve="categoryID" />
      <ref role="1dEHZW" node="5Z8cvS2CfOK" resolve="groupByEmployeeAndSumWorkedHours" />
      <node concept="1dEHGB" id="5Z8cvS2CfNS" role="aze7e">
        <ref role="azviR" node="6v$U1VGXbtM" resolve="employeeID" />
      </node>
      <node concept="1dEHGB" id="5Z8cvS2CfO9" role="aze7e">
        <ref role="azviR" node="6v$U1VGXbtU" resolve="employeeName" />
      </node>
      <node concept="1dEHGB" id="5Z8cvS2CfOc" role="aze7e">
        <ref role="azviR" node="6v$U1VGXbtX" resolve="categoryID" />
      </node>
      <node concept="1dEHGB" id="5Z8cvS2CfOg" role="aze7e">
        <ref role="azviR" node="6v$U1VGXbuw" resolve="categoryName" />
      </node>
      <node concept="1dEHGB" id="5Z8cvS2CfOl" role="aze7e">
        <ref role="azviR" node="6v$U1VGXbuz" resolve="valueOfWorkedHour" />
      </node>
    </node>
    <node concept="at1Qz" id="5Z8cvS2CfOK" role="1dFpDj">
      <property role="TrG5h" value="EmployeeIdAndSumWorkedHours" />
      <property role="as0QM" value="5ZmGmhlDFNy/SUM" />
      <ref role="at1QJ" node="5Z8cvS2CfPJ" resolve="WorkedHours" />
      <ref role="at1QR" node="5Z8cvS2CfQs" resolve="worked_hours" />
      <ref role="as0Q3" node="5Z8cvS2CfJS" resolve="SumWorkedHours" />
      <ref role="as0Qe" node="5Z8cvS2CfKv" resolve="totalWorkedHours" />
      <ref role="1dEHZW" node="5Z8cvS2CfTy" resolve="EmployeeJoinCategoryJoinSumWorkedHours" />
      <node concept="1dEHGB" id="5Z8cvS2CfOM" role="at1QF">
        <ref role="azviR" node="5Z8cvS2CfPK" resolve="id_employee" />
      </node>
    </node>
    <node concept="awhP$" id="5Z8cvS2CfTy" role="1dFpDj">
      <property role="TrG5h" value="EmployeeJoinCategoryJoinSumWorkedHours" />
      <property role="awnZP" value="5ZmGmhllUKd/INNER" />
      <ref role="awhP_" node="5Z8cvS2CfJ5" resolve="EmployeeJoinCategory" />
      <ref role="azfch" node="5Z8cvS2CfKy" resolve="EmployeeJoinCategoryJoinSumWorkedHours" />
      <ref role="awhPx" node="5Z8cvS2CfJ6" resolve="employeeID" />
      <ref role="awhPI" node="5Z8cvS2CfJS" resolve="SumWorkedHours" />
      <ref role="awhPG" node="5Z8cvS2CfJT" resolve="id_employee" />
      <ref role="1dEHZW" node="5Z8cvS2CfUG" resolve="appendToPayments" />
      <node concept="1dEHGB" id="5Z8cvS2CfT$" role="aze7e">
        <ref role="azviR" node="5Z8cvS2CfJ6" resolve="employeeID" />
      </node>
      <node concept="1dEHGB" id="5Z8cvS2CfTX" role="aze7e">
        <ref role="azviR" node="5Z8cvS2CfJD" resolve="id_category" />
      </node>
      <node concept="1dEHGB" id="6gCHjbaMtVQ" role="aze7e">
        <ref role="azviR" node="5Z8cvS2CfJA" resolve="name_employee" />
      </node>
      <node concept="1dEHGB" id="5Z8cvS2CfU0" role="aze7e">
        <ref role="azviR" node="5Z8cvS2CfJH" resolve="categoryName" />
      </node>
      <node concept="1dEHGB" id="6gCHjbb7PHz" role="aze7e">
        <ref role="azviR" node="5Z8cvS2CfJM" resolve="value_worked_hours" />
      </node>
      <node concept="1dEHGB" id="6gCHjbb7PHD" role="aze7e">
        <ref role="azviR" node="5Z8cvS2CfKv" resolve="worked_hours" />
      </node>
    </node>
    <node concept="aZuW3" id="5Z8cvS2CfUG" role="1dFpDj">
      <property role="TrG5h" value="MoveToPaymentsTable" />
      <ref role="aZgb_" node="5Z8cvS2CfKy" resolve="EmployeeJoinCategoryJoinSumWorkedHours" />
      <ref role="aZgbx" node="6v$U1VGXbvy" resolve="Payments" />
      <ref role="1dEHZW" node="5Z8cvS2CfWa" resolve="calculatePayment" />
      <node concept="aYZH_" id="5Z8cvS2CfUI" role="aYQel">
        <ref role="aYZHB" node="5Z8cvS2CfKz" resolve="employeeID" />
        <ref role="aYZHx" node="6v$U1VGXbvz" resolve="employeeID" />
      </node>
      <node concept="aYZH_" id="5Z8cvS2CfVd" role="aYQel">
        <ref role="aYZHB" node="5Z8cvS2CfLc" resolve="employeeName" />
        <ref role="aYZHx" node="6v$U1VGXbvM" resolve="employeeName" />
      </node>
      <node concept="aYZH_" id="5Z8cvS2CfVg" role="aYQel">
        <ref role="aYZHB" node="5Z8cvS2CfLf" resolve="categoryID" />
        <ref role="aYZHx" node="6v$U1VGXbvP" resolve="categoryID" />
      </node>
      <node concept="aYZH_" id="5Z8cvS2CfVk" role="aYQel">
        <ref role="aYZHB" node="5Z8cvS2CfLj" resolve="categoryName" />
        <ref role="aYZHx" node="6v$U1VGXbvT" resolve="categoryName" />
      </node>
      <node concept="aYZH_" id="5Z8cvS2CfVp" role="aYQel">
        <ref role="aYZHB" node="5Z8cvS2CfLo" resolve="valueOfWorkedHour" />
        <ref role="aYZHx" node="6v$U1VGXbvY" resolve="valueOfWorkedHour" />
      </node>
      <node concept="aYZH_" id="5Z8cvS2CfVv" role="aYQel">
        <ref role="aYZHB" node="5Z8cvS2CfLu" resolve="totalWorkedHours" />
        <ref role="aYZHx" node="6v$U1VGXbw4" resolve="workedHours" />
      </node>
    </node>
    <node concept="aqOT2" id="5Z8cvS2CfWa" role="1dFpDj">
      <property role="TrG5h" value="TotalPayPerEmployee" />
      <property role="aqOSI" value="5ZmGmhlJvXk/NUMERIC_MULTIPLY" />
      <ref role="aqOTe" node="6v$U1VGXbvy" resolve="Payments" />
      <ref role="aqOT9" node="6v$U1VGXbvy" resolve="Payments" />
      <ref role="aqOTg" node="6v$U1VGXbvz" resolve="employeeID" />
      <ref role="aqOTi" node="6v$U1VGXbvz" resolve="employeeID" />
      <ref role="aqOTu" node="6v$U1VGXbvY" resolve="valueOfWorkedHour" />
      <ref role="aqOTq" node="6v$U1VGXbw4" resolve="workedHours" />
      <ref role="aqOSU" node="6v$U1VGXbvy" resolve="Payments" />
      <ref role="aqOSw" node="6v$U1VGXbwb" resolve="payment" />
      <ref role="1dEHZW" node="5Z8cvS2CfXk" resolve="appendToPaymentsFinal" />
    </node>
    <node concept="aZuW3" id="5Z8cvS2CfXk" role="1dFpDj">
      <property role="TrG5h" value="MoveToPaymentsFinal" />
      <ref role="aZgb_" node="6v$U1VGXbvy" resolve="Payments" />
      <ref role="aZgbx" node="6v$U1VGXb$K" resolve="PaymentsFinal" />
      <ref role="1dEHZW" node="6v$U1VGXbuD" resolve="save" />
      <node concept="aYZH_" id="5Z8cvS2CfXm" role="aYQel">
        <ref role="aYZHB" node="6v$U1VGXbvz" resolve="employeeID" />
        <ref role="aYZHx" node="6v$U1VGXb_b" resolve="employeeID" />
      </node>
      <node concept="aYZH_" id="5Z8cvS2CfXX" role="aYQel">
        <ref role="aYZHB" node="6v$U1VGXbvM" resolve="employeeName" />
        <ref role="aYZHx" node="6v$U1VGXb_c" resolve="employeeName" />
      </node>
      <node concept="aYZH_" id="5Z8cvS2CfY0" role="aYQel">
        <ref role="aYZHB" node="6v$U1VGXbvP" resolve="categoryID" />
        <ref role="aYZHx" node="6v$U1VGXb_d" resolve="categoryID" />
      </node>
      <node concept="aYZH_" id="5Z8cvS2CfY4" role="aYQel">
        <ref role="aYZHB" node="6v$U1VGXbvT" resolve="categoryName" />
        <ref role="aYZHx" node="6v$U1VGXb_e" resolve="categoryName" />
      </node>
      <node concept="aYZH_" id="5Z8cvS2CfY9" role="aYQel">
        <ref role="aYZHB" node="6v$U1VGXbwb" resolve="payment" />
        <ref role="aYZHx" node="6v$U1VGXb_h" resolve="payment" />
      </node>
    </node>
    <node concept="1dEHGZ" id="6v$U1VGXbuD" role="1dFpDj">
      <property role="TrG5h" value="SavePaymentsFinalTable" />
      <node concept="1dGH9q" id="6v$U1VGXbA9" role="1dEHG$">
        <property role="1dGH94" value="output-salary" />
        <ref role="1dGH95" node="6v$U1VGXb$K" resolve="PaymentsFinal" />
        <node concept="1dEHGB" id="6v$U1VGXbAa" role="1dGH97">
          <ref role="azviR" node="6v$U1VGXb_b" resolve="employeeID" />
        </node>
        <node concept="1dEHGB" id="6v$U1VGXbAd" role="1dGH97">
          <ref role="azviR" node="6v$U1VGXb_c" resolve="employeeName" />
        </node>
        <node concept="1dEHGB" id="6v$U1VGXbAg" role="1dGH97">
          <ref role="azviR" node="6v$U1VGXb_d" resolve="categoryID" />
        </node>
        <node concept="1dEHGB" id="6v$U1VGXbAk" role="1dGH97">
          <ref role="azviR" node="6v$U1VGXb_e" resolve="categoryName" />
        </node>
        <node concept="1dEHGB" id="6v$U1VGXbAp" role="1dGH97">
          <ref role="azviR" node="6v$U1VGXb_h" resolve="payment" />
        </node>
      </node>
    </node>
  </node>
</model>

