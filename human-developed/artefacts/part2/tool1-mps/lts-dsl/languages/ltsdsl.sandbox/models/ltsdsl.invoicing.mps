<?xml version="1.0" encoding="UTF-8"?>
<model ref="r:591886ee-70ce-4b80-981d-dd2a66958a1f(ltsdsl.invoicing)">
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
      <concept id="5944580133722264739" name="ltsdsl.structure.Filter" flags="ng" index="2r8R21">
        <property id="5944580133723113307" name="operator" index="2r5AdT" />
        <property id="5944580133723113309" name="operand" index="2r5AdZ" />
        <reference id="5944580133722978531" name="column" index="2r6pN1" />
        <reference id="5944580133722978532" name="table" index="2r6pN6" />
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
    </language>
    <language id="ceab5195-25ea-4f22-9b92-103b95ca8c0c" name="jetbrains.mps.lang.core">
      <concept id="1169194658468" name="jetbrains.mps.lang.core.structure.INamedConcept" flags="ngI" index="TrEIO">
        <property id="1169194664001" name="name" index="TrG5h" />
      </concept>
    </language>
  </registry>
  <node concept="1dFsXZ" id="5tEOHMSFuS">
    <property role="TrG5h" value="Invoicing" />
    <property role="1dFpDt" value="true" />
    <node concept="1dEHZT" id="5tEOHMSFuT" role="SqbkQ">
      <property role="TrG5h" value="Clients" />
      <node concept="1dEHZU" id="5tEOHMSFuU" role="1dE$pi">
        <property role="TrG5h" value="id_client" />
        <property role="1dEHZJ" value="3YATvlM33Cl/NUMBER" />
      </node>
      <node concept="1dEHZU" id="5tEOHMSFv2" role="1dE$pi">
        <property role="TrG5h" value="name_client" />
        <property role="1dEHZJ" value="3YATvlM33Cj/TEXT" />
      </node>
      <node concept="1dEHZU" id="5tEOHMSFv3" role="1dE$pi">
        <property role="TrG5h" value="nif" />
        <property role="1dEHZJ" value="3YATvlM33Cj/TEXT" />
      </node>
    </node>
    <node concept="1dEHZT" id="5tEOHMSFv4" role="SqbkQ">
      <property role="TrG5h" value="Products" />
      <node concept="1dEHZU" id="5tEOHMSFv5" role="1dE$pi">
        <property role="TrG5h" value="id_product" />
        <property role="1dEHZJ" value="3YATvlM33Cl/NUMBER" />
      </node>
      <node concept="1dEHZU" id="5tEOHMSFv8" role="1dE$pi">
        <property role="TrG5h" value="name_product" />
        <property role="1dEHZJ" value="3YATvlM33Cj/TEXT" />
      </node>
      <node concept="1dEHZU" id="5tEOHMSFv9" role="1dE$pi">
        <property role="TrG5h" value="price" />
        <property role="1dEHZJ" value="3YATvlM33Cl/NUMBER" />
      </node>
    </node>
    <node concept="1dEHZT" id="5tEOHMSFva" role="SqbkQ">
      <property role="TrG5h" value="Sales" />
      <node concept="1dEHZU" id="5tEOHMSFvb" role="1dE$pi">
        <property role="TrG5h" value="id_sale" />
        <property role="1dEHZJ" value="3YATvlM33Cl/NUMBER" />
      </node>
      <node concept="1dEHZU" id="5tEOHMSFve" role="1dE$pi">
        <property role="TrG5h" value="id_client" />
        <property role="1dEHZJ" value="3YATvlM33Cl/NUMBER" />
      </node>
      <node concept="1dEHZU" id="5tEOHMSFvf" role="1dE$pi">
        <property role="TrG5h" value="id_product" />
        <property role="1dEHZJ" value="3YATvlM33Cl/NUMBER" />
      </node>
      <node concept="1dEHZU" id="5tEOHMSFvg" role="1dE$pi">
        <property role="TrG5h" value="quantity" />
        <property role="1dEHZJ" value="3YATvlM33Cl/NUMBER" />
      </node>
    </node>
    <node concept="1dEHZT" id="5tEOHMSFvh" role="SqbkQ">
      <property role="TrG5h" value="SalesGroupedByClientProductWithQuantity" />
      <node concept="1dEHZU" id="5tEOHMSFvi" role="1dE$pi">
        <property role="TrG5h" value="id_sale" />
        <property role="1dEHZJ" value="3YATvlM33Cl/NUMBER" />
      </node>
      <node concept="1dEHZU" id="5tEOHMSFvl" role="1dE$pi">
        <property role="TrG5h" value="id_client" />
        <property role="1dEHZJ" value="3YATvlM33Cl/NUMBER" />
      </node>
      <node concept="1dEHZU" id="5tEOHMSFvm" role="1dE$pi">
        <property role="TrG5h" value="id_product" />
        <property role="1dEHZJ" value="3YATvlM33Cl/NUMBER" />
      </node>
      <node concept="1dEHZU" id="5tEOHMSFvn" role="1dE$pi">
        <property role="TrG5h" value="quantity" />
        <property role="1dEHZJ" value="3YATvlM33Cl/NUMBER" />
      </node>
    </node>
    <node concept="1dEHZT" id="5tEOHMSFvo" role="SqbkQ">
      <property role="TrG5h" value="SalesWithPrice" />
      <node concept="1dEHZU" id="5tEOHMSFvs" role="1dE$pi">
        <property role="TrG5h" value="id_client" />
        <property role="1dEHZJ" value="3YATvlM33Cl/NUMBER" />
      </node>
      <node concept="1dEHZU" id="5tEOHMSFvt" role="1dE$pi">
        <property role="TrG5h" value="id_product" />
        <property role="1dEHZJ" value="3YATvlM33Cl/NUMBER" />
      </node>
      <node concept="1dEHZU" id="5tEOHMSFvu" role="1dE$pi">
        <property role="TrG5h" value="quantity" />
        <property role="1dEHZJ" value="3YATvlM33Cl/NUMBER" />
      </node>
      <node concept="1dEHZU" id="5tEOHMSFvv" role="1dE$pi">
        <property role="TrG5h" value="price" />
        <property role="1dEHZJ" value="3YATvlM33Cl/NUMBER" />
      </node>
    </node>
    <node concept="1dEHZT" id="5tEOHMSFvw" role="SqbkQ">
      <property role="TrG5h" value="SalesWithTotal" />
      <node concept="1dEHZU" id="5tEOHMSFv$" role="1dE$pi">
        <property role="TrG5h" value="id_client" />
        <property role="1dEHZJ" value="3YATvlM33Cl/NUMBER" />
      </node>
      <node concept="1dEHZU" id="5tEOHMSFv_" role="1dE$pi">
        <property role="TrG5h" value="id_product" />
        <property role="1dEHZJ" value="3YATvlM33Cl/NUMBER" />
      </node>
      <node concept="1dEHZU" id="5tEOHMSFvA" role="1dE$pi">
        <property role="TrG5h" value="quantity" />
        <property role="1dEHZJ" value="3YATvlM33Cl/NUMBER" />
      </node>
      <node concept="1dEHZU" id="5tEOHMSFvB" role="1dE$pi">
        <property role="TrG5h" value="price" />
        <property role="1dEHZJ" value="3YATvlM33Cl/NUMBER" />
      </node>
      <node concept="1dEHZU" id="5tEOHMSFvC" role="1dE$pi">
        <property role="TrG5h" value="total" />
        <property role="1dEHZJ" value="3YATvlM33Cl/NUMBER" />
      </node>
    </node>
    <node concept="1dEHZT" id="5tEOHMSFvD" role="SqbkQ">
      <property role="TrG5h" value="GroupedByIdClientSumTotal" />
      <node concept="1dEHZU" id="5tEOHMSFvE" role="1dE$pi">
        <property role="TrG5h" value="id_client" />
        <property role="1dEHZJ" value="3YATvlM33Cl/NUMBER" />
      </node>
      <node concept="1dEHZU" id="5tEOHMSFvH" role="1dE$pi">
        <property role="TrG5h" value="total" />
        <property role="1dEHZJ" value="3YATvlM33Cl/NUMBER" />
      </node>
    </node>
    <node concept="1dEHZT" id="5tEOHMSFvI" role="SqbkQ">
      <property role="TrG5h" value="Final" />
      <node concept="1dEHZU" id="5tEOHMSFvJ" role="1dE$pi">
        <property role="TrG5h" value="id_client" />
        <property role="1dEHZJ" value="3YATvlM33Cl/NUMBER" />
      </node>
      <node concept="1dEHZU" id="5tEOHMSFvM" role="1dE$pi">
        <property role="TrG5h" value="name_client" />
        <property role="1dEHZJ" value="3YATvlM33Cj/TEXT" />
      </node>
      <node concept="1dEHZU" id="5tEOHMSFvN" role="1dE$pi">
        <property role="TrG5h" value="nif" />
        <property role="1dEHZJ" value="3YATvlM33Cj/TEXT" />
      </node>
      <node concept="1dEHZU" id="5tEOHMSFvO" role="1dE$pi">
        <property role="TrG5h" value="total" />
        <property role="1dEHZJ" value="3YATvlM33Cl/NUMBER" />
      </node>
    </node>
    <node concept="SqMCW" id="5tEOHMSFvP" role="1dFpDj">
      <property role="TrG5h" value="import" />
      <ref role="1dEHZW" node="5tEOHMSFw4" resolve="RemoveDuplicatesBySalesId" />
      <node concept="SqaAD" id="5tEOHMSFvR" role="SqaAL">
        <property role="SqaAN" value="," />
        <property role="SqaAP" value="/clients.csv" />
        <ref role="SqaAR" node="5tEOHMSFuT" resolve="Clients" />
      </node>
      <node concept="SqaAD" id="5tEOHMSFvW" role="SqaAL">
        <property role="SqaAP" value="/products.csv" />
        <property role="SqaAN" value=";" />
        <ref role="SqaAR" node="5tEOHMSFv4" resolve="Products" />
      </node>
      <node concept="SqaAD" id="5tEOHMSFvZ" role="SqaAL">
        <property role="SqaAP" value="/sales.csv" />
        <property role="SqaAN" value="," />
        <ref role="SqaAR" node="5tEOHMSFva" resolve="Sales" />
      </node>
    </node>
    <node concept="2r90WS" id="5tEOHMSFw4" role="1dFpDj">
      <property role="TrG5h" value="RemoveDuplicatesBySalesId" />
      <ref role="2r90WY" node="5tEOHMSFva" resolve="Sales" />
      <ref role="2r90WZ" node="5tEOHMSFvb" resolve="saleID" />
      <ref role="1dEHZW" node="5tEOHMSFwc" resolve="FilterQuantitiesHigherThan10" />
    </node>
    <node concept="2r8R21" id="5tEOHMSFwc" role="1dFpDj">
      <property role="TrG5h" value="FilterQuantitiesHigherThan10" />
      <property role="2r5AdZ" value="1" />
      <property role="2r5AdT" value="59Zp2b9qgth/GREATER_THAN" />
      <ref role="2r6pN6" node="5tEOHMSFva" resolve="Sales" />
      <ref role="2r6pN1" node="5tEOHMSFvg" resolve="quantity" />
      <ref role="1dEHZW" node="5tEOHMSKcX" resolve="GroupByClientAndSumQuantity" />
    </node>
    <node concept="at1Qz" id="5tEOHMSKcX" role="1dFpDj">
      <property role="TrG5h" value="GroupByClientAndSumQuantity" />
      <property role="as0QM" value="5ZmGmhlDFNy/SUM" />
      <ref role="as0Qe" node="5tEOHMSFvn" resolve="quantity" />
      <ref role="as0Q3" node="5tEOHMSFvh" resolve="SalesGroupedByClientProductWithQuantity" />
      <ref role="1dEHZW" node="5tEOHMSKdj" resolve="JoinGroupedWithPrice" />
      <ref role="at1QR" node="5tEOHMSFvg" resolve="quantity" />
      <ref role="at1QJ" node="5tEOHMSFva" resolve="Sales" />
      <node concept="1dEHGB" id="5tEOHMSKcZ" role="at1QF">
        <ref role="azviR" node="5tEOHMSFve" resolve="id_client" />
      </node>
      <node concept="1dEHGB" id="5tEOHMSKdd" role="at1QF">
        <ref role="azviR" node="5tEOHMSFvf" resolve="id_product" />
      </node>
    </node>
    <node concept="awhP$" id="5tEOHMSKdj" role="1dFpDj">
      <property role="TrG5h" value="JoinGroupedWithPrice" />
      <property role="awnZP" value="5ZmGmhllUKd/INNER" />
      <ref role="awhP_" node="5tEOHMSFv4" resolve="Products" />
      <ref role="awhPx" node="5tEOHMSFv5" resolve="productID" />
      <ref role="awhPI" node="5tEOHMSFvh" resolve="SalesGroupedByClientProductWithQuantity" />
      <ref role="awhPG" node="5tEOHMSFvm" resolve="productID" />
      <ref role="azfch" node="5tEOHMSFvo" resolve="SalesWithPrice" />
      <ref role="1dEHZW" node="5tEOHMSKdG" resolve="ParseToTotalSchema" />
      <node concept="1dEHGB" id="5tEOHMSKdl" role="aze7e">
        <ref role="azviR" node="5tEOHMSFv9" resolve="price" />
      </node>
      <node concept="1dEHGB" id="5tEOHMSKdw" role="aze7e">
        <ref role="azviR" node="5tEOHMSFvl" resolve="clientID" />
      </node>
      <node concept="1dEHGB" id="5tEOHMSKdz" role="aze7e">
        <ref role="azviR" node="5tEOHMSFv5" resolve="productID" />
      </node>
      <node concept="1dEHGB" id="5tEOHMSKdA" role="aze7e">
        <ref role="azviR" node="5tEOHMSFvn" resolve="quantity" />
      </node>
    </node>
    <node concept="aZuW3" id="5tEOHMSKdG" role="1dFpDj">
      <property role="TrG5h" value="ParseToTotalSchema" />
      <ref role="aZgb_" node="5tEOHMSFvo" resolve="SalesWithPrice" />
      <ref role="aZgbx" node="5tEOHMSFvw" resolve="SalesWithTotal" />
      <ref role="1dEHZW" node="5tEOHMSKe7" resolve="GetTheTotal" />
      <node concept="aYZH_" id="5tEOHMSKdR" role="aYQel">
        <ref role="aYZHB" node="5tEOHMSFvs" resolve="clientID" />
        <ref role="aYZHx" node="5tEOHMSFv$" resolve="clientID" />
      </node>
      <node concept="aYZH_" id="5tEOHMSKdU" role="aYQel">
        <ref role="aYZHB" node="5tEOHMSFvt" resolve="productID" />
        <ref role="aYZHx" node="5tEOHMSFv_" resolve="productID" />
      </node>
      <node concept="aYZH_" id="5tEOHMSKdY" role="aYQel">
        <ref role="aYZHB" node="5tEOHMSFvu" resolve="quantity" />
        <ref role="aYZHx" node="5tEOHMSFvA" resolve="quantity" />
      </node>
      <node concept="aYZH_" id="5tEOHMSKe1" role="aYQel">
        <ref role="aYZHB" node="5tEOHMSFvv" resolve="price" />
        <ref role="aYZHx" node="5tEOHMSFvB" resolve="price" />
      </node>
    </node>
    <node concept="aqOT2" id="5tEOHMSKe7" role="1dFpDj">
      <property role="TrG5h" value="GetTheTotal" />
      <property role="aqOSI" value="5ZmGmhlJvXk/NUMERIC_MULTIPLY" />
      <ref role="aqOTe" node="5tEOHMSFvw" resolve="SalesWithTotal" />
      <ref role="aqOT9" node="5tEOHMSFvw" resolve="SalesWithTotal" />
      <ref role="aqOTg" node="5tEOHMSFv$" resolve="id_client" />
      <ref role="aqOTu" node="5tEOHMSFvA" resolve="quantity" />
      <ref role="aqOTq" node="5tEOHMSFvB" resolve="price" />
      <ref role="aqOSU" node="5tEOHMSFvw" resolve="SalesWithTotal" />
      <ref role="aqOSw" node="5tEOHMSFvC" resolve="total" />
      <ref role="1dEHZW" node="5tEOHMSKen" resolve="GroupsTheSumQuantityToPay" />
      <ref role="aqOTi" node="5tEOHMSFv$" resolve="id_client" />
    </node>
    <node concept="at1Qz" id="5tEOHMSKen" role="1dFpDj">
      <property role="TrG5h" value="GroupsTheSumQuantityToPay" />
      <property role="as0QM" value="5ZmGmhlDFNy/SUM" />
      <ref role="at1QJ" node="5tEOHMSFvw" resolve="SalesWithTotal" />
      <ref role="at1QR" node="5tEOHMSFvC" resolve="total" />
      <ref role="as0Q3" node="5tEOHMSFvD" resolve="GroupedByIdClientSumTotal" />
      <ref role="as0Qe" node="5tEOHMSFvH" resolve="total" />
      <ref role="1dEHZW" node="5tEOHMSKeA" resolve="JoinIntoClientToFinalize" />
      <node concept="1dEHGB" id="5tEOHMSKep" role="at1QF">
        <ref role="azviR" node="5tEOHMSFv$" resolve="clientID" />
      </node>
    </node>
    <node concept="awhP$" id="5tEOHMSKeA" role="1dFpDj">
      <property role="TrG5h" value="JoinIntoClientToFinalize" />
      <property role="awnZP" value="5ZmGmhllUKd/INNER" />
      <ref role="awhP_" node="5tEOHMSFvD" resolve="GroupedByIdClientSumTotal" />
      <ref role="awhPx" node="5tEOHMSFvE" resolve="clientID" />
      <ref role="awhPI" node="5tEOHMSFuT" resolve="Clients" />
      <ref role="awhPG" node="5tEOHMSFuU" resolve="clientID" />
      <ref role="azfch" node="5tEOHMSFvI" resolve="Final" />
      <ref role="1dEHZW" node="5tEOHMSKeY" resolve="save" />
      <node concept="1dEHGB" id="5tEOHMSKeC" role="aze7e">
        <ref role="azviR" node="5tEOHMSFvE" resolve="clientID" />
      </node>
      <node concept="1dEHGB" id="5tEOHMSKeN" role="aze7e">
        <ref role="azviR" node="5tEOHMSFv2" resolve="clientName" />
      </node>
      <node concept="1dEHGB" id="5tEOHMSKeQ" role="aze7e">
        <ref role="azviR" node="5tEOHMSFv3" resolve="nif" />
      </node>
      <node concept="1dEHGB" id="5tEOHMSKeT" role="aze7e">
        <ref role="azviR" node="5tEOHMSFvH" resolve="total" />
      </node>
    </node>
    <node concept="1dEHGZ" id="5tEOHMSKeY" role="1dFpDj">
      <property role="TrG5h" value="save" />
      <node concept="1dGH9q" id="5tEOHMSKf0" role="1dEHG$">
        <property role="1dGH94" value="output-invoicing" />
        <ref role="1dGH95" node="5tEOHMSFvI" resolve="Final" />
        <node concept="1dEHGB" id="5tEOHMSKf2" role="1dGH97">
          <ref role="azviR" node="5tEOHMSFvJ" resolve="clientID" />
        </node>
        <node concept="1dEHGB" id="5tEOHMSKf4" role="1dGH97">
          <ref role="azviR" node="5tEOHMSFvM" resolve="clientName" />
        </node>
        <node concept="1dEHGB" id="5tEOHMSKf5" role="1dGH97">
          <ref role="azviR" node="5tEOHMSFvN" resolve="nif" />
        </node>
      </node>
    </node>
  </node>
</model>

