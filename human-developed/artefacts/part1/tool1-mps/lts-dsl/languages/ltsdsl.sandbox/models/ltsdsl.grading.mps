<?xml version="1.0" encoding="UTF-8"?>
<model ref="r:03998d8b-bfb5-41a4-93e7-a68debc54884(ltsdsl.grading)">
  <persistence version="9" />
  <languages>
    <use id="1f55f171-d454-489b-bbc2-2455ab34472f" name="ltsdsl" version="0" />
  </languages>
  <imports />
  <registry>
    <language id="1f55f171-d454-489b-bbc2-2455ab34472f" name="ltsdsl">
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
      <concept id="6905902123105247955" name="ltsdsl.structure.StrManipulation" flags="ng" index="aAPeR">
        <reference id="6905902123105247960" name="table" index="aAPeW" />
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
      <concept id="3553795587621053553" name="ltsdsl.structure.StrManipulationConcat" flags="ng" index="_OnCN">
        <reference id="3553795587621053558" name="sourceA" index="_OnCO" />
        <reference id="3553795587621053563" name="resultTable" index="_OnCT" />
        <reference id="3553795587621053561" name="sourceB" index="_OnCV" />
        <reference id="3553795587621053566" name="resultColumn" index="_OnCW" />
      </concept>
      <concept id="2876302107890287662" name="ltsdsl.structure.TableToImport" flags="ng" index="SqaAD">
        <property id="2876302107890287668" name="delimiter" index="SqaAN" />
        <property id="2876302107890287667" name="deleteMismatchedTypes" index="SqaAO" />
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
    </language>
    <language id="ceab5195-25ea-4f22-9b92-103b95ca8c0c" name="jetbrains.mps.lang.core">
      <concept id="1169194658468" name="jetbrains.mps.lang.core.structure.INamedConcept" flags="ngI" index="TrEIO">
        <property id="1169194664001" name="name" index="TrG5h" />
      </concept>
    </language>
  </registry>
  <node concept="1dFsXZ" id="5Z8cvS2CwIV">
    <property role="TrG5h" value="Grading" />
    <property role="1dFpDt" value="true" />
    <node concept="1dEHZT" id="5Z8cvS2CwIW" role="SqbkQ">
      <property role="TrG5h" value="Students" />
      <node concept="1dEHZU" id="5Z8cvS2CwIX" role="1dE$pi">
        <property role="TrG5h" value="studentID" />
        <property role="1dEHZJ" value="3YATvlM33Cl/NUMBER" />
      </node>
      <node concept="1dEHZU" id="5Z8cvS2CwJ5" role="1dE$pi">
        <property role="TrG5h" value="firstName" />
        <property role="1dEHZJ" value="3YATvlM33Cj/TEXT" />
      </node>
      <node concept="1dEHZU" id="5Z8cvS2CwJ8" role="1dE$pi">
        <property role="TrG5h" value="lastName" />
        <property role="1dEHZJ" value="3YATvlM33Cj/TEXT" />
      </node>
    </node>
    <node concept="1dEHZT" id="5Z8cvS2CwJc" role="SqbkQ">
      <property role="TrG5h" value="Courses" />
      <node concept="1dEHZU" id="5Z8cvS2CwJd" role="1dE$pi">
        <property role="TrG5h" value="courseID" />
        <property role="1dEHZJ" value="3YATvlM33Cl/NUMBER" />
      </node>
      <node concept="1dEHZU" id="5Z8cvS2CwJm" role="1dE$pi">
        <property role="TrG5h" value="courseName" />
        <property role="1dEHZJ" value="3YATvlM33Cj/TEXT" />
      </node>
      <node concept="1dEHZU" id="5Z8cvS2CwJp" role="1dE$pi">
        <property role="TrG5h" value="studentID" />
        <property role="1dEHZJ" value="3YATvlM33Cl/NUMBER" />
      </node>
    </node>
    <node concept="1dEHZT" id="5Z8cvS2CwJt" role="SqbkQ">
      <property role="TrG5h" value="Grades" />
      <node concept="1dEHZU" id="5Z8cvS2CwJu" role="1dE$pi">
        <property role="TrG5h" value="gradeID" />
        <property role="1dEHZJ" value="3YATvlM33Cl/NUMBER" />
      </node>
      <node concept="1dEHZU" id="5Z8cvS2CwJF" role="1dE$pi">
        <property role="TrG5h" value="courseID" />
        <property role="1dEHZJ" value="3YATvlM33Cl/NUMBER" />
      </node>
      <node concept="1dEHZU" id="5Z8cvS2CwJI" role="1dE$pi">
        <property role="TrG5h" value="studentID" />
        <property role="1dEHZJ" value="3YATvlM33Cl/NUMBER" />
      </node>
      <node concept="1dEHZU" id="5Z8cvS2CwJM" role="1dE$pi">
        <property role="TrG5h" value="grade" />
        <property role="1dEHZJ" value="3YATvlM33Cl/NUMBER" />
      </node>
    </node>
    <node concept="1dEHZT" id="5Z8cvS2CwJR" role="SqbkQ">
      <property role="TrG5h" value="GradesAverage" />
      <node concept="1dEHZU" id="5Z8cvS2CwJS" role="1dE$pi">
        <property role="TrG5h" value="studentID" />
        <property role="1dEHZJ" value="3YATvlM33Cl/NUMBER" />
      </node>
      <node concept="1dEHZU" id="5Z8cvS2CwKa" role="1dE$pi">
        <property role="TrG5h" value="courseID" />
        <property role="1dEHZJ" value="3YATvlM33Cl/NUMBER" />
      </node>
      <node concept="1dEHZU" id="5Z8cvS2CwKd" role="1dE$pi">
        <property role="TrG5h" value="gradeAvg" />
        <property role="1dEHZJ" value="3YATvlM33Cl/NUMBER" />
      </node>
    </node>
    <node concept="1dEHZT" id="5Z8cvS2CwKh" role="SqbkQ">
      <property role="TrG5h" value="GradesAverageJoinCourses" />
      <node concept="1dEHZU" id="5Z8cvS2CwKi" role="1dE$pi">
        <property role="TrG5h" value="studentID" />
        <property role="1dEHZJ" value="3YATvlM33Cl/NUMBER" />
      </node>
      <node concept="1dEHZU" id="5Z8cvS2CwKC" role="1dE$pi">
        <property role="TrG5h" value="courseID" />
        <property role="1dEHZJ" value="3YATvlM33Cl/NUMBER" />
      </node>
      <node concept="1dEHZU" id="5Z8cvS2CwKF" role="1dE$pi">
        <property role="TrG5h" value="gradeAvg" />
        <property role="1dEHZJ" value="3YATvlM33Cl/NUMBER" />
      </node>
      <node concept="1dEHZU" id="5Z8cvS2CwKJ" role="1dE$pi">
        <property role="TrG5h" value="courseName" />
        <property role="1dEHZJ" value="3YATvlM33Cj/TEXT" />
      </node>
    </node>
    <node concept="1dEHZT" id="5Z8cvS2CwKY" role="SqbkQ">
      <property role="TrG5h" value="Final" />
      <node concept="1dEHZU" id="5Z8cvS2CwKZ" role="1dE$pi">
        <property role="TrG5h" value="studentID" />
        <property role="1dEHZJ" value="3YATvlM33Cl/NUMBER" />
      </node>
      <node concept="1dEHZU" id="5Z8cvS2CwLq" role="1dE$pi">
        <property role="TrG5h" value="courseID" />
        <property role="1dEHZJ" value="3YATvlM33Cl/NUMBER" />
      </node>
      <node concept="1dEHZU" id="5Z8cvS2CwLt" role="1dE$pi">
        <property role="TrG5h" value="gradeAvg" />
        <property role="1dEHZJ" value="3YATvlM33Cl/NUMBER" />
      </node>
      <node concept="1dEHZU" id="5Z8cvS2CwLx" role="1dE$pi">
        <property role="TrG5h" value="courseName" />
        <property role="1dEHZJ" value="3YATvlM33Cj/TEXT" />
      </node>
      <node concept="1dEHZU" id="5Z8cvS2CwLA" role="1dE$pi">
        <property role="TrG5h" value="studentName" />
        <property role="1dEHZJ" value="3YATvlM33Cj/TEXT" />
      </node>
    </node>
    <node concept="SqMCW" id="5Z8cvS2CwLG" role="1dFpDj">
      <property role="TrG5h" value="import" />
      <ref role="1dEHZW" node="5Z8cvS2CwMb" resolve="removeDuplicates" />
      <node concept="SqaAD" id="5Z8cvS2CwLI" role="SqaAL">
        <property role="SqaAO" value="true" />
        <property role="SqaAN" value=";" />
        <property role="SqaAP" value="./students.csv" />
        <ref role="SqaAR" node="5Z8cvS2CwIW" resolve="Students" />
      </node>
      <node concept="SqaAD" id="5Z8cvS2CwLT" role="SqaAL">
        <property role="SqaAP" value="./courses.csv" />
        <property role="SqaAN" value=";" />
        <property role="SqaAO" value="true" />
        <ref role="SqaAR" node="5Z8cvS2CwJc" resolve="Courses" />
      </node>
      <node concept="SqaAD" id="5Z8cvS2CwLY" role="SqaAL">
        <property role="SqaAO" value="true" />
        <property role="SqaAN" value=";" />
        <property role="SqaAP" value="./grades.csv" />
        <ref role="SqaAR" node="5Z8cvS2CwJt" resolve="Grades" />
      </node>
    </node>
    <node concept="2r90WS" id="5Z8cvS2CwMb" role="1dFpDj">
      <property role="TrG5h" value="removeDuplicates" />
      <ref role="2r90WY" node="5Z8cvS2CwJt" resolve="Grades" />
      <ref role="2r90WZ" node="5Z8cvS2CwJu" resolve="gradeID" />
      <ref role="1dEHZW" node="5Z8cvS2CwMw" resolve="groupStudentsToGetAVGNotes" />
    </node>
    <node concept="at1Qz" id="5Z8cvS2CwMw" role="1dFpDj">
      <property role="TrG5h" value="groupStudentsToGetAVGNotes" />
      <property role="as0QM" value="5ZmGmhlDFNz/AVG" />
      <ref role="at1QJ" node="5Z8cvS2CwJt" resolve="Grades" />
      <ref role="at1QR" node="5Z8cvS2CwJM" resolve="grade" />
      <ref role="as0Q3" node="5Z8cvS2CwJR" resolve="GradesAverage" />
      <ref role="as0Qe" node="5Z8cvS2CwKd" resolve="gradeAvg" />
      <ref role="1dEHZW" node="5Z8cvS2CwN0" resolve="JoinGradesAverageWithCourses" />
      <node concept="1dEHGB" id="5Z8cvS2CwMy" role="at1QF">
        <ref role="azviR" node="5Z8cvS2CwJI" resolve="studentID" />
      </node>
    </node>
    <node concept="awhP$" id="5Z8cvS2CwN0" role="1dFpDj">
      <property role="TrG5h" value="JoinGradesAverageWithCourses" />
      <property role="awnZP" value="5ZmGmhllUKd/INNER" />
      <ref role="awhP_" node="5Z8cvS2CwJR" resolve="GradesAverage" />
      <ref role="awhPx" node="5Z8cvS2CwKa" resolve="courseID" />
      <ref role="awhPI" node="5Z8cvS2CwJc" resolve="Courses" />
      <ref role="awhPG" node="5Z8cvS2CwJd" resolve="courseID" />
      <ref role="azfch" node="5Z8cvS2CwKh" resolve="GradesAverageJoinCourses" />
      <ref role="1dEHZW" node="5Z8cvS2CwNT" resolve="appendToFinal" />
      <node concept="1dEHGB" id="5Z8cvS2CwN2" role="aze7e">
        <ref role="azviR" node="5Z8cvS2CwJS" resolve="studentID" />
      </node>
      <node concept="1dEHGB" id="5Z8cvS2CwNl" role="aze7e">
        <ref role="azviR" node="5Z8cvS2CwKa" resolve="courseID" />
      </node>
      <node concept="1dEHGB" id="5Z8cvS2CwNp" role="aze7e">
        <ref role="azviR" node="5Z8cvS2CwKd" resolve="gradeAvg" />
      </node>
      <node concept="1dEHGB" id="5Z8cvS2CwNu" role="aze7e">
        <ref role="azviR" node="5Z8cvS2CwJm" resolve="courseName" />
      </node>
    </node>
    <node concept="aZuW3" id="5Z8cvS2CwNT" role="1dFpDj">
      <property role="TrG5h" value="appendToFinal" />
      <ref role="aZgbx" node="5Z8cvS2CwKY" resolve="Final" />
      <ref role="aZgb_" node="5Z8cvS2CwKh" resolve="GradesAverageJoinCourses" />
      <ref role="1dEHZW" node="5Z8cvS2CwOU" resolve="concatFirstWithLastName" />
      <node concept="aYZH_" id="5Z8cvS2CwNV" role="aYQel">
        <ref role="aYZHB" node="5Z8cvS2CwKi" resolve="studentID" />
        <ref role="aYZHx" node="5Z8cvS2CwKZ" resolve="studentID" />
      </node>
      <node concept="aYZH_" id="5Z8cvS2CwOi" role="aYQel">
        <ref role="aYZHB" node="5Z8cvS2CwKC" resolve="courseID" />
        <ref role="aYZHx" node="5Z8cvS2CwLq" resolve="courseID" />
      </node>
      <node concept="aYZH_" id="5Z8cvS2CwOo" role="aYQel">
        <ref role="aYZHB" node="5Z8cvS2CwKF" resolve="gradeAvg" />
        <ref role="aYZHx" node="5Z8cvS2CwLt" resolve="gradeAvg" />
      </node>
      <node concept="aYZH_" id="5Z8cvS2CwOu" role="aYQel">
        <ref role="aYZHB" node="5Z8cvS2CwKJ" resolve="courseName" />
        <ref role="aYZHx" node="5Z8cvS2CwLx" resolve="courseName" />
      </node>
    </node>
    <node concept="_OnCN" id="5Z8cvS2CwOU" role="1dFpDj">
      <property role="TrG5h" value="concatFirstWithLastName" />
      <ref role="1dEHZW" node="5Z8cvS2CwPI" resolve="saveFinal" />
      <ref role="aAPeW" node="5Z8cvS2CwIW" resolve="Students" />
      <ref role="_OnCT" node="5Z8cvS2CwKY" resolve="Final" />
      <ref role="_OnCO" node="5Z8cvS2CwJ5" resolve="firstName" />
      <ref role="_OnCV" node="5Z8cvS2CwJ8" resolve="lastName" />
      <ref role="_OnCW" node="5Z8cvS2CwLA" resolve="studentName" />
    </node>
    <node concept="1dEHGZ" id="5Z8cvS2CwPI" role="1dFpDj">
      <property role="TrG5h" value="saveFinal" />
      <node concept="1dGH9q" id="5Z8cvS2CwPK" role="1dEHG$">
        <property role="1dGH94" value="./output-grading.csv" />
        <ref role="1dGH95" node="5Z8cvS2CwKY" resolve="Final" />
        <node concept="1dEHGB" id="5Z8cvS2CwPM" role="1dGH97">
          <ref role="azviR" node="5Z8cvS2CwKZ" resolve="studentID" />
        </node>
        <node concept="1dEHGB" id="5Z8cvS2CxFj" role="1dGH97">
          <ref role="azviR" node="5Z8cvS2CwLq" resolve="courseID" />
        </node>
        <node concept="1dEHGB" id="5Z8cvS2CxFm" role="1dGH97">
          <ref role="azviR" node="5Z8cvS2CwLt" resolve="gradeAvg" />
        </node>
        <node concept="1dEHGB" id="5Z8cvS2CxFq" role="1dGH97">
          <ref role="azviR" node="5Z8cvS2CwLx" resolve="courseName" />
        </node>
        <node concept="1dEHGB" id="5Z8cvS2CxFv" role="1dGH97">
          <ref role="azviR" node="5Z8cvS2CwLA" resolve="studentName" />
        </node>
      </node>
    </node>
  </node>
</model>

