<?xml version="1.0" encoding="UTF-8"?>
<model ref="r:85f52e46-7a19-44f9-bf10-6677b89edd73(ltsdsl.structure)">
  <persistence version="9" />
  <languages>
    <devkit ref="78434eb8-b0e5-444b-850d-e7c4ad2da9ab(jetbrains.mps.devkit.aspect.structure)" />
  </languages>
  <imports>
    <import index="tpck" ref="r:00000000-0000-4000-0000-011c89590288(jetbrains.mps.lang.core.structure)" implicit="true" />
  </imports>
  <registry>
    <language id="c72da2b9-7cce-4447-8389-f407dc1158b7" name="jetbrains.mps.lang.structure">
      <concept id="3348158742936976480" name="jetbrains.mps.lang.structure.structure.EnumerationMemberDeclaration" flags="ng" index="25R33">
        <property id="1421157252384165432" name="memberId" index="3tVfz5" />
      </concept>
      <concept id="3348158742936976479" name="jetbrains.mps.lang.structure.structure.EnumerationDeclaration" flags="ng" index="25R3W">
        <child id="3348158742936976577" name="members" index="25R1y" />
      </concept>
      <concept id="1082978164218" name="jetbrains.mps.lang.structure.structure.DataTypeDeclaration" flags="ng" index="AxPO6">
        <property id="7791109065626895363" name="datatypeId" index="3F6X1D" />
      </concept>
      <concept id="1169125787135" name="jetbrains.mps.lang.structure.structure.AbstractConceptDeclaration" flags="ig" index="PkWjJ">
        <property id="6714410169261853888" name="conceptId" index="EcuMT" />
        <property id="4628067390765956802" name="abstract" index="R5$K7" />
        <child id="1071489727083" name="linkDeclaration" index="1TKVEi" />
        <child id="1071489727084" name="propertyDeclaration" index="1TKVEl" />
      </concept>
      <concept id="1169127622168" name="jetbrains.mps.lang.structure.structure.InterfaceConceptReference" flags="ig" index="PrWs8">
        <reference id="1169127628841" name="intfc" index="PrY4T" />
      </concept>
      <concept id="1071489090640" name="jetbrains.mps.lang.structure.structure.ConceptDeclaration" flags="ig" index="1TIwiD">
        <property id="1096454100552" name="rootable" index="19KtqR" />
        <reference id="1071489389519" name="extends" index="1TJDcQ" />
        <child id="1169129564478" name="implements" index="PzmwI" />
      </concept>
      <concept id="1071489288299" name="jetbrains.mps.lang.structure.structure.PropertyDeclaration" flags="ig" index="1TJgyi">
        <property id="241647608299431129" name="propertyId" index="IQ2nx" />
        <reference id="1082985295845" name="dataType" index="AX2Wp" />
      </concept>
      <concept id="1071489288298" name="jetbrains.mps.lang.structure.structure.LinkDeclaration" flags="ig" index="1TJgyj">
        <property id="1071599776563" name="role" index="20kJfa" />
        <property id="1071599893252" name="sourceCardinality" index="20lbJX" />
        <property id="1071599937831" name="metaClass" index="20lmBu" />
        <property id="241647608299431140" name="linkId" index="IQ2ns" />
        <reference id="1071599976176" name="target" index="20lvS9" />
      </concept>
    </language>
    <language id="ceab5195-25ea-4f22-9b92-103b95ca8c0c" name="jetbrains.mps.lang.core">
      <concept id="1169194658468" name="jetbrains.mps.lang.core.structure.INamedConcept" flags="ngI" index="TrEIO">
        <property id="1169194664001" name="name" index="TrG5h" />
      </concept>
    </language>
  </registry>
  <node concept="1TIwiD" id="3YATvlM2MEa">
    <property role="EcuMT" value="4586606112866511498" />
    <property role="TrG5h" value="Model" />
    <property role="19KtqR" value="true" />
    <ref role="1TJDcQ" to="tpck:gw2VY9q" />
    <node concept="PrWs8" id="3YATvlM2RYz" role="PzmwI">
      <ref role="PrY4T" to="tpck:h0TrEE$" resolve="INamedConcept" />
    </node>
    <node concept="1TJgyj" id="2vEFosvwxyL" role="1TKVEi">
      <property role="IQ2ns" value="2876302107890292913" />
      <property role="20lmBu" value="fLJjDmT/aggregation" />
      <property role="20kJfa" value="tables" />
      <property role="20lbJX" value="fLJekj6/_1__n" />
      <ref role="20lvS9" node="3YATvlM33Cc" resolve="Table" />
    </node>
    <node concept="1TJgyj" id="3YATvlM2RYA" role="1TKVEi">
      <property role="IQ2ns" value="4586606112866533286" />
      <property role="20lmBu" value="fLJjDmT/aggregation" />
      <property role="20kJfa" value="steps" />
      <property role="20lbJX" value="fLJekj6/_1__n" />
      <ref role="20lvS9" node="3YATvlM2RY$" resolve="Step" />
    </node>
    <node concept="1TJgyi" id="3YATvlM2RYC" role="1TKVEl">
      <property role="IQ2nx" value="4586606112866533288" />
      <property role="TrG5h" value="logs" />
      <ref role="AX2Wp" to="tpck:fKAQMTB" resolve="boolean" />
    </node>
  </node>
  <node concept="1TIwiD" id="3YATvlM2RY$">
    <property role="EcuMT" value="4586606112866533284" />
    <property role="TrG5h" value="Step" />
    <property role="R5$K7" value="true" />
    <ref role="1TJDcQ" to="tpck:gw2VY9q" />
    <node concept="PrWs8" id="3YATvlM2RY_" role="PzmwI">
      <ref role="PrY4T" to="tpck:h0TrEE$" resolve="INamedConcept" />
    </node>
  </node>
  <node concept="1TIwiD" id="3YATvlM33C5">
    <property role="EcuMT" value="4586606112866580997" />
    <property role="TrG5h" value="FlowStep" />
    <property role="R5$K7" value="true" />
    <ref role="1TJDcQ" node="3YATvlM2RY$" resolve="Step" />
    <node concept="1TJgyj" id="3YATvlM33C9" role="1TKVEi">
      <property role="IQ2ns" value="4586606112866581001" />
      <property role="20kJfa" value="next" />
      <property role="20lbJX" value="fLJekj4/_1" />
      <ref role="20lvS9" node="3YATvlM2RY$" resolve="Step" />
    </node>
  </node>
  <node concept="1TIwiD" id="3YATvlM33Ca">
    <property role="EcuMT" value="4586606112866581002" />
    <property role="TrG5h" value="FinalStep" />
    <property role="R5$K7" value="true" />
    <ref role="1TJDcQ" node="3YATvlM2RY$" resolve="Step" />
  </node>
  <node concept="1TIwiD" id="3YATvlM33Cc">
    <property role="EcuMT" value="4586606112866581004" />
    <property role="TrG5h" value="Table" />
    <ref role="1TJDcQ" to="tpck:gw2VY9q" />
    <node concept="PrWs8" id="3YATvlM33Cd" role="PzmwI">
      <ref role="PrY4T" to="tpck:h0TrEE$" resolve="INamedConcept" />
    </node>
    <node concept="1TJgyj" id="3YATvlM3aeB" role="1TKVEi">
      <property role="IQ2ns" value="4586606112866608039" />
      <property role="20lmBu" value="fLJjDmT/aggregation" />
      <property role="20kJfa" value="columns" />
      <property role="20lbJX" value="fLJekj6/_1__n" />
      <ref role="20lvS9" node="3YATvlM33Cf" resolve="Column" />
    </node>
  </node>
  <node concept="1TIwiD" id="3YATvlM33Cf">
    <property role="EcuMT" value="4586606112866581007" />
    <property role="TrG5h" value="Column" />
    <ref role="1TJDcQ" to="tpck:gw2VY9q" />
    <node concept="PrWs8" id="3YATvlM33Cg" role="PzmwI">
      <ref role="PrY4T" to="tpck:h0TrEE$" resolve="INamedConcept" />
    </node>
    <node concept="1TJgyi" id="3YATvlM33Cq" role="1TKVEl">
      <property role="IQ2nx" value="4586606112866581018" />
      <property role="TrG5h" value="dataType" />
      <ref role="AX2Wp" node="3YATvlM33Ci" resolve="DataType" />
    </node>
  </node>
  <node concept="25R3W" id="3YATvlM33Ci">
    <property role="3F6X1D" value="4586606112866581010" />
    <property role="TrG5h" value="DataType" />
    <node concept="25R33" id="3YATvlM33Cj" role="25R1y">
      <property role="3tVfz5" value="4586606112866581011" />
      <property role="TrG5h" value="TEXT" />
    </node>
    <node concept="25R33" id="3YATvlM33Cl" role="25R1y">
      <property role="3tVfz5" value="4586606112866581013" />
      <property role="TrG5h" value="NUMBER" />
    </node>
    <node concept="25R33" id="3YATvlM33Cm" role="25R1y">
      <property role="3tVfz5" value="4586606112866581014" />
      <property role="TrG5h" value="DATE" />
    </node>
  </node>
  <node concept="1TIwiD" id="3YATvlM33Va">
    <property role="EcuMT" value="4586606112866582218" />
    <property role="TrG5h" value="Save" />
    <ref role="1TJDcQ" node="3YATvlM33Ca" resolve="FinalStep" />
    <node concept="1TJgyj" id="3YATvlM33Vh" role="1TKVEi">
      <property role="IQ2ns" value="4586606112866582225" />
      <property role="20lmBu" value="fLJjDmT/aggregation" />
      <property role="20kJfa" value="tablesToSave" />
      <property role="20lbJX" value="fLJekj6/_1__n" />
      <ref role="20lvS9" node="3YATvlM53uJ" resolve="TableToSave" />
    </node>
  </node>
  <node concept="1TIwiD" id="3YATvlM33Vi">
    <property role="EcuMT" value="4586606112866582226" />
    <property role="TrG5h" value="ColumnRef" />
    <ref role="1TJDcQ" to="tpck:gw2VY9q" />
    <node concept="1TJgyj" id="5ZmGmhlmOnj" role="1TKVEi">
      <property role="IQ2ns" value="6905902123106125267" />
      <property role="20lbJX" value="fLJekj4/_1" />
      <property role="20kJfa" value="column" />
      <ref role="20lvS9" node="3YATvlM33Cf" resolve="Column" />
    </node>
  </node>
  <node concept="1TIwiD" id="3YATvlM4ZjO">
    <property role="EcuMT" value="4586606112867087604" />
    <property role="TrG5h" value="Sort" />
    <ref role="1TJDcQ" node="3YATvlM33C5" resolve="FlowStep" />
    <node concept="1TJgyj" id="3YATvlM4ZjP" role="1TKVEi">
      <property role="IQ2ns" value="4586606112867087605" />
      <property role="20kJfa" value="table" />
      <property role="20lbJX" value="fLJekj4/_1" />
      <ref role="20lvS9" node="3YATvlM33Cc" resolve="Table" />
    </node>
    <node concept="1TJgyj" id="3YATvlM4ZjQ" role="1TKVEi">
      <property role="IQ2ns" value="4586606112867087606" />
      <property role="20kJfa" value="column" />
      <property role="20lbJX" value="fLJekj4/_1" />
      <ref role="20lvS9" node="3YATvlM33Cf" resolve="Column" />
    </node>
    <node concept="1TJgyi" id="3YATvlM4ZyP" role="1TKVEl">
      <property role="IQ2nx" value="4586606112867088565" />
      <property role="TrG5h" value="order" />
      <ref role="AX2Wp" node="3YATvlM4ZjT" resolve="OrderType" />
    </node>
  </node>
  <node concept="25R3W" id="3YATvlM4ZjT">
    <property role="3F6X1D" value="4586606112867087609" />
    <property role="TrG5h" value="OrderType" />
    <node concept="25R33" id="3YATvlM4ZjU" role="25R1y">
      <property role="3tVfz5" value="4586606112867087610" />
      <property role="TrG5h" value="ASC" />
    </node>
    <node concept="25R33" id="3YATvlM4ZjW" role="25R1y">
      <property role="3tVfz5" value="4586606112867087612" />
      <property role="TrG5h" value="DESC" />
    </node>
  </node>
  <node concept="1TIwiD" id="3YATvlM53uJ">
    <property role="EcuMT" value="4586606112867104687" />
    <property role="TrG5h" value="TableToSave" />
    <ref role="1TJDcQ" to="tpck:gw2VY9q" />
    <node concept="1TJgyj" id="3YATvlM53uK" role="1TKVEi">
      <property role="IQ2ns" value="4586606112867104688" />
      <property role="20kJfa" value="table" />
      <property role="20lbJX" value="fLJekj4/_1" />
      <ref role="20lvS9" node="3YATvlM33Cc" resolve="Table" />
    </node>
    <node concept="1TJgyi" id="3YATvlM53uL" role="1TKVEl">
      <property role="IQ2nx" value="4586606112867104689" />
      <property role="TrG5h" value="path" />
      <ref role="AX2Wp" to="tpck:fKAOsGN" resolve="string" />
    </node>
    <node concept="1TJgyj" id="3YATvlM53uM" role="1TKVEi">
      <property role="IQ2ns" value="4586606112867104690" />
      <property role="20lmBu" value="fLJjDmT/aggregation" />
      <property role="20kJfa" value="columns" />
      <property role="20lbJX" value="fLJekj6/_1__n" />
      <ref role="20lvS9" node="3YATvlM33Vi" resolve="ColumnRef" />
    </node>
  </node>
  <node concept="1TIwiD" id="2vEFosvwouV">
    <property role="EcuMT" value="2876302107890255803" />
    <property role="TrG5h" value="Import" />
    <ref role="1TJDcQ" node="3YATvlM33C5" resolve="FlowStep" />
    <node concept="1TJgyj" id="2vEFosvwwgQ" role="1TKVEi">
      <property role="IQ2ns" value="2876302107890287670" />
      <property role="20lmBu" value="fLJjDmT/aggregation" />
      <property role="20kJfa" value="tablesToImport" />
      <property role="20lbJX" value="fLJekj6/_1__n" />
      <ref role="20lvS9" node="2vEFosvwwgI" resolve="TableToImport" />
    </node>
  </node>
  <node concept="1TIwiD" id="2vEFosvwwgI">
    <property role="EcuMT" value="2876302107890287662" />
    <property role="TrG5h" value="TableToImport" />
    <ref role="1TJDcQ" to="tpck:gw2VY9q" />
    <node concept="1TJgyi" id="2vEFosvwwgM" role="1TKVEl">
      <property role="IQ2nx" value="2876302107890287666" />
      <property role="TrG5h" value="path" />
      <ref role="AX2Wp" to="tpck:fKAOsGN" resolve="string" />
    </node>
    <node concept="1TJgyi" id="2vEFosvwwgN" role="1TKVEl">
      <property role="IQ2nx" value="2876302107890287667" />
      <property role="TrG5h" value="deleteMismatchedTypes" />
      <ref role="AX2Wp" to="tpck:fKAQMTB" resolve="boolean" />
    </node>
    <node concept="1TJgyi" id="2vEFosvwwgO" role="1TKVEl">
      <property role="IQ2nx" value="2876302107890287668" />
      <property role="TrG5h" value="delimiter" />
      <ref role="AX2Wp" to="tpck:fKAOsGN" resolve="string" />
    </node>
    <node concept="1TJgyj" id="2vEFosvwwgK" role="1TKVEi">
      <property role="IQ2ns" value="2876302107890287664" />
      <property role="20kJfa" value="table" />
      <property role="20lbJX" value="fLJekj4/_1" />
      <ref role="20lvS9" node="3YATvlM33Cc" resolve="Table" />
    </node>
  </node>
  <node concept="1TIwiD" id="59Zp2b9mQGq">
    <property role="EcuMT" value="5944580133722221338" />
    <property role="TrG5h" value="RemoveDuplicates" />
    <ref role="1TJDcQ" node="3YATvlM33C5" resolve="FlowStep" />
    <node concept="1TJgyj" id="59Zp2b9mQGs" role="1TKVEi">
      <property role="IQ2ns" value="5944580133722221340" />
      <property role="20kJfa" value="table" />
      <property role="20lbJX" value="fLJekj4/_1" />
      <ref role="20lvS9" node="3YATvlM33Cc" resolve="Table" />
    </node>
    <node concept="1TJgyj" id="59Zp2b9mQGt" role="1TKVEi">
      <property role="IQ2ns" value="5944580133722221341" />
      <property role="20kJfa" value="column" />
      <property role="20lbJX" value="fLJekj4/_1" />
      <ref role="20lvS9" node="3YATvlM33Cf" resolve="Column" />
    </node>
  </node>
  <node concept="1TIwiD" id="59Zp2b9n1iz">
    <property role="EcuMT" value="5944580133722264739" />
    <property role="TrG5h" value="Filter" />
    <ref role="1TJDcQ" node="3YATvlM33C5" resolve="FlowStep" />
    <node concept="1TJgyj" id="59Zp2b9pJz$" role="1TKVEi">
      <property role="IQ2ns" value="5944580133722978532" />
      <property role="20kJfa" value="table" />
      <property role="20lbJX" value="fLJekj4/_1" />
      <ref role="20lvS9" node="3YATvlM33Cc" resolve="Table" />
    </node>
    <node concept="1TJgyj" id="59Zp2b9pJzz" role="1TKVEi">
      <property role="IQ2ns" value="5944580133722978531" />
      <property role="20kJfa" value="column" />
      <property role="20lbJX" value="fLJekj4/_1" />
      <ref role="20lvS9" node="3YATvlM33Cf" resolve="Column" />
    </node>
    <node concept="1TJgyi" id="59Zp2b9qgtr" role="1TKVEl">
      <property role="IQ2nx" value="5944580133723113307" />
      <property role="TrG5h" value="operator" />
      <ref role="AX2Wp" node="59Zp2b9qgtb" resolve="FilterOperatorType" />
    </node>
    <node concept="1TJgyi" id="59Zp2b9qgtt" role="1TKVEl">
      <property role="IQ2nx" value="5944580133723113309" />
      <property role="TrG5h" value="operand" />
      <ref role="AX2Wp" to="tpck:fKAOsGN" resolve="string" />
    </node>
  </node>
  <node concept="25R3W" id="59Zp2b9qgtb">
    <property role="3F6X1D" value="5944580133723113291" />
    <property role="TrG5h" value="FilterOperatorType" />
    <node concept="25R33" id="59Zp2b9qgtc" role="25R1y">
      <property role="3tVfz5" value="5944580133723113292" />
      <property role="TrG5h" value="EQUALS" />
    </node>
    <node concept="25R33" id="59Zp2b9qgte" role="25R1y">
      <property role="3tVfz5" value="5944580133723113294" />
      <property role="TrG5h" value="LESS_THAN" />
    </node>
    <node concept="25R33" id="59Zp2b9qgth" role="25R1y">
      <property role="3tVfz5" value="5944580133723113297" />
      <property role="TrG5h" value="GREATER_THAN" />
    </node>
    <node concept="25R33" id="59Zp2b9qgtj" role="25R1y">
      <property role="3tVfz5" value="5944580133723113299" />
      <property role="TrG5h" value="LESS_OR_EQUALS_THAN" />
    </node>
    <node concept="25R33" id="59Zp2b9qgtm" role="25R1y">
      <property role="3tVfz5" value="5944580133723113302" />
      <property role="TrG5h" value="GREATER_OR_EQUALS_THAN" />
    </node>
  </node>
  <node concept="1TIwiD" id="5ZmGmhlaPTB">
    <property role="EcuMT" value="6905902123102985831" />
    <property role="TrG5h" value="AppendRows" />
    <ref role="1TJDcQ" node="3YATvlM33C5" resolve="FlowStep" />
    <node concept="1TJgyj" id="5ZmGmhlaVe1" role="1TKVEi">
      <property role="IQ2ns" value="6905902123103007617" />
      <property role="20kJfa" value="fromTable" />
      <property role="20lbJX" value="fLJekj4/_1" />
      <ref role="20lvS9" node="3YATvlM33Cc" resolve="Table" />
    </node>
    <node concept="1TJgyj" id="5ZmGmhlaVe5" role="1TKVEi">
      <property role="IQ2ns" value="6905902123103007621" />
      <property role="20kJfa" value="toTable" />
      <property role="20lbJX" value="fLJekj4/_1" />
      <ref role="20lvS9" node="3YATvlM33Cc" resolve="Table" />
    </node>
    <node concept="1TJgyj" id="5ZmGmhlbtbL" role="1TKVEi">
      <property role="IQ2ns" value="6905902123103146737" />
      <property role="20lmBu" value="fLJjDmT/aggregation" />
      <property role="20kJfa" value="mappings" />
      <property role="20lbJX" value="fLJekj6/_1__n" />
      <ref role="20lvS9" node="5ZmGmhlbkC1" resolve="AppendRowsMap" />
    </node>
  </node>
  <node concept="1TIwiD" id="5ZmGmhlbkC1">
    <property role="EcuMT" value="6905902123103111681" />
    <property role="TrG5h" value="AppendRowsMap" />
    <ref role="1TJDcQ" to="tpck:gw2VY9q" />
    <node concept="1TJgyj" id="5ZmGmhlbkC3" role="1TKVEi">
      <property role="IQ2ns" value="6905902123103111683" />
      <property role="20kJfa" value="fromCol" />
      <property role="20lbJX" value="fLJekj4/_1" />
      <ref role="20lvS9" node="3YATvlM33Cf" resolve="Column" />
    </node>
    <node concept="1TJgyj" id="5ZmGmhlbkC5" role="1TKVEi">
      <property role="IQ2ns" value="6905902123103111685" />
      <property role="20kJfa" value="toCol" />
      <property role="20lbJX" value="fLJekj4/_1" />
      <ref role="20lvS9" node="3YATvlM33Cf" resolve="Column" />
    </node>
  </node>
  <node concept="1TIwiD" id="5ZmGmhljubj">
    <property role="EcuMT" value="6905902123105247955" />
    <property role="TrG5h" value="StrManipulation" />
    <property role="R5$K7" value="true" />
    <ref role="1TJDcQ" node="3YATvlM33C5" resolve="FlowStep" />
    <node concept="1TJgyj" id="5ZmGmhljubo" role="1TKVEi">
      <property role="IQ2ns" value="6905902123105247960" />
      <property role="20kJfa" value="table" />
      <property role="20lbJX" value="fLJekj4/_1" />
      <ref role="20lvS9" node="3YATvlM33Cc" resolve="Table" />
    </node>
  </node>
  <node concept="1TIwiD" id="5ZmGmhljuVw">
    <property role="EcuMT" value="6905902123105251040" />
    <property role="TrG5h" value="StrManipulationExtract" />
    <ref role="1TJDcQ" node="5ZmGmhljubj" resolve="StrManipulation" />
    <node concept="1TJgyj" id="5ZmGmhljuVz" role="1TKVEi">
      <property role="IQ2ns" value="6905902123105251043" />
      <property role="20kJfa" value="column" />
      <property role="20lbJX" value="fLJekj4/_1" />
      <ref role="20lvS9" node="3YATvlM33Cf" resolve="Column" />
    </node>
    <node concept="1TJgyi" id="5ZmGmhljuVA" role="1TKVEl">
      <property role="IQ2nx" value="6905902123105251046" />
      <property role="TrG5h" value="lbCharIndex" />
      <ref role="AX2Wp" to="tpck:fKAOsGN" resolve="string" />
    </node>
    <node concept="1TJgyi" id="5ZmGmhljuVC" role="1TKVEl">
      <property role="IQ2nx" value="6905902123105251048" />
      <property role="TrG5h" value="ubCharIndex" />
      <ref role="AX2Wp" to="tpck:fKAOsGN" resolve="string" />
    </node>
    <node concept="1TJgyi" id="5ZmGmhljuVF" role="1TKVEl">
      <property role="IQ2nx" value="6905902123105251051" />
      <property role="TrG5h" value="regexPattern" />
      <ref role="AX2Wp" to="tpck:fKAOsGN" resolve="string" />
    </node>
  </node>
  <node concept="1TIwiD" id="5ZmGmhllUK0">
    <property role="EcuMT" value="6905902123105889280" />
    <property role="TrG5h" value="Join" />
    <ref role="1TJDcQ" node="3YATvlM33C5" resolve="FlowStep" />
    <node concept="1TJgyj" id="5ZmGmhllUK1" role="1TKVEi">
      <property role="IQ2ns" value="6905902123105889281" />
      <property role="20kJfa" value="leftTable" />
      <property role="20lbJX" value="fLJekj4/_1" />
      <ref role="20lvS9" node="3YATvlM33Cc" resolve="Table" />
    </node>
    <node concept="1TJgyj" id="5ZmGmhllUK5" role="1TKVEi">
      <property role="IQ2ns" value="6905902123105889285" />
      <property role="20kJfa" value="leftColumn" />
      <property role="20lbJX" value="fLJekj4/_1" />
      <ref role="20lvS9" node="3YATvlM33Cf" resolve="Column" />
    </node>
    <node concept="1TJgyj" id="5ZmGmhllUKa" role="1TKVEi">
      <property role="IQ2ns" value="6905902123105889290" />
      <property role="20kJfa" value="rightTable" />
      <property role="20lbJX" value="fLJekj4/_1" />
      <ref role="20lvS9" node="3YATvlM33Cc" resolve="Table" />
    </node>
    <node concept="1TJgyj" id="5ZmGmhllUK8" role="1TKVEi">
      <property role="IQ2ns" value="6905902123105889288" />
      <property role="20kJfa" value="rightColumn" />
      <property role="20lbJX" value="fLJekj4/_1" />
      <ref role="20lvS9" node="3YATvlM33Cf" resolve="Column" />
    </node>
    <node concept="1TJgyj" id="5ZmGmhlm$9P" role="1TKVEi">
      <property role="IQ2ns" value="6905902123106058869" />
      <property role="20kJfa" value="resultTable" />
      <property role="20lbJX" value="fLJekj4/_1" />
      <ref role="20lvS9" node="3YATvlM33Cc" resolve="Table" />
    </node>
    <node concept="1TJgyi" id="5ZmGmhllWUh" role="1TKVEl">
      <property role="IQ2nx" value="6905902123105898129" />
      <property role="TrG5h" value="type" />
      <ref role="AX2Wp" node="5ZmGmhllUKc" resolve="JoinType" />
    </node>
    <node concept="1TJgyj" id="5ZmGmhlm_2E" role="1TKVEi">
      <property role="IQ2ns" value="6905902123106062506" />
      <property role="20lmBu" value="fLJjDmT/aggregation" />
      <property role="20kJfa" value="selectColumns" />
      <property role="20lbJX" value="fLJekj6/_1__n" />
      <ref role="20lvS9" node="3YATvlM33Vi" resolve="ColumnRef" />
    </node>
  </node>
  <node concept="25R3W" id="5ZmGmhllUKc">
    <property role="3F6X1D" value="6905902123105889292" />
    <property role="TrG5h" value="JoinType" />
    <node concept="25R33" id="5ZmGmhllUKd" role="25R1y">
      <property role="3tVfz5" value="6905902123105889293" />
      <property role="TrG5h" value="INNER" />
    </node>
    <node concept="25R33" id="5ZmGmhllUKf" role="25R1y">
      <property role="3tVfz5" value="6905902123105889295" />
      <property role="TrG5h" value="FULL" />
    </node>
    <node concept="25R33" id="5ZmGmhllUKi" role="25R1y">
      <property role="3tVfz5" value="6905902123105889298" />
      <property role="TrG5h" value="LEFT" />
    </node>
    <node concept="25R33" id="5ZmGmhllUKk" role="25R1y">
      <property role="3tVfz5" value="6905902123105889300" />
      <property role="TrG5h" value="RIGHT" />
    </node>
  </node>
  <node concept="1TIwiD" id="5ZmGmhlCEN7">
    <property role="EcuMT" value="6905902123110804679" />
    <property role="TrG5h" value="Group" />
    <ref role="1TJDcQ" node="3YATvlM33C5" resolve="FlowStep" />
    <node concept="1TJgyj" id="5ZmGmhlCENb" role="1TKVEi">
      <property role="IQ2ns" value="6905902123110804683" />
      <property role="20kJfa" value="table" />
      <property role="20lbJX" value="fLJekj4/_1" />
      <ref role="20lvS9" node="3YATvlM33Cc" resolve="Table" />
    </node>
    <node concept="1TJgyj" id="5ZmGmhlCENj" role="1TKVEi">
      <property role="IQ2ns" value="6905902123110804691" />
      <property role="20kJfa" value="operandColumn" />
      <property role="20lbJX" value="fLJekj4/_1" />
      <ref role="20lvS9" node="3YATvlM33Cf" resolve="Column" />
    </node>
    <node concept="1TJgyj" id="5ZmGmhlDFNB" role="1TKVEi">
      <property role="IQ2ns" value="6905902123111070951" />
      <property role="20kJfa" value="resultTable" />
      <property role="20lbJX" value="fLJekj4/_1" />
      <ref role="20lvS9" node="3YATvlM33Cc" resolve="Table" />
    </node>
    <node concept="1TJgyj" id="5ZmGmhlDFNE" role="1TKVEi">
      <property role="IQ2ns" value="6905902123111070954" />
      <property role="20kJfa" value="resultColumn" />
      <property role="20lbJX" value="fLJekj4/_1" />
      <ref role="20lvS9" node="3YATvlM33Cf" resolve="Column" />
    </node>
    <node concept="1TJgyj" id="5ZmGmhlCENf" role="1TKVEi">
      <property role="IQ2ns" value="6905902123110804687" />
      <property role="20lmBu" value="fLJjDmT/aggregation" />
      <property role="20kJfa" value="groupBy" />
      <property role="20lbJX" value="fLJekj6/_1__n" />
      <ref role="20lvS9" node="3YATvlM33Vi" resolve="ColumnRef" />
    </node>
    <node concept="1TJgyi" id="5ZmGmhlDFNm" role="1TKVEl">
      <property role="IQ2nx" value="6905902123111070934" />
      <property role="TrG5h" value="operation" />
      <ref role="AX2Wp" node="5ZmGmhlDFNr" resolve="GroupOperationType" />
    </node>
  </node>
  <node concept="25R3W" id="5ZmGmhlDFNr">
    <property role="3F6X1D" value="6905902123111070939" />
    <property role="TrG5h" value="GroupOperationType" />
    <node concept="25R33" id="5ZmGmhlDFNs" role="25R1y">
      <property role="3tVfz5" value="6905902123111070940" />
      <property role="TrG5h" value="MAX" />
    </node>
    <node concept="25R33" id="5ZmGmhlDFNu" role="25R1y">
      <property role="3tVfz5" value="6905902123111070942" />
      <property role="TrG5h" value="MIN" />
    </node>
    <node concept="25R33" id="5ZmGmhlDFNw" role="25R1y">
      <property role="3tVfz5" value="6905902123111070944" />
      <property role="TrG5h" value="COUNT" />
    </node>
    <node concept="25R33" id="5ZmGmhlDFNy" role="25R1y">
      <property role="3tVfz5" value="6905902123111070946" />
      <property role="TrG5h" value="SUM" />
    </node>
    <node concept="25R33" id="5ZmGmhlDFNz" role="25R1y">
      <property role="3tVfz5" value="6905902123111070947" />
      <property role="TrG5h" value="AVERAGE" />
    </node>
  </node>
  <node concept="1TIwiD" id="5ZmGmhlJvWA">
    <property role="EcuMT" value="6905902123112595238" />
    <property role="TrG5h" value="Lookup" />
    <ref role="1TJDcQ" node="3YATvlM33C5" resolve="FlowStep" />
    <node concept="1TJgyj" id="5ZmGmhlJvWE" role="1TKVEi">
      <property role="IQ2ns" value="6905902123112595242" />
      <property role="20kJfa" value="table" />
      <property role="20lbJX" value="fLJekj4/_1" />
      <ref role="20lvS9" node="3YATvlM33Cc" resolve="Table" />
    </node>
    <node concept="1TJgyj" id="5ZmGmhlJvWH" role="1TKVEi">
      <property role="IQ2ns" value="6905902123112595245" />
      <property role="20kJfa" value="lookupTable" />
      <property role="20lbJX" value="fLJekj4/_1" />
      <ref role="20lvS9" node="3YATvlM33Cc" resolve="Table" />
    </node>
    <node concept="1TJgyj" id="5ZmGmhlJvWO" role="1TKVEi">
      <property role="IQ2ns" value="6905902123112595252" />
      <property role="20kJfa" value="column" />
      <property role="20lbJX" value="fLJekj4/_1" />
      <ref role="20lvS9" node="3YATvlM33Cf" resolve="Column" />
    </node>
    <node concept="1TJgyj" id="5ZmGmhlJvWQ" role="1TKVEi">
      <property role="IQ2ns" value="6905902123112595254" />
      <property role="20kJfa" value="matchColumn" />
      <property role="20lbJX" value="fLJekj4/_1" />
      <ref role="20lvS9" node="3YATvlM33Cf" resolve="Column" />
    </node>
    <node concept="1TJgyj" id="5ZmGmhlJvWU" role="1TKVEi">
      <property role="IQ2ns" value="6905902123112595258" />
      <property role="20kJfa" value="operandColumn" />
      <property role="20lbJX" value="fLJekj4/_1" />
      <ref role="20lvS9" node="3YATvlM33Cf" resolve="Column" />
    </node>
    <node concept="1TJgyj" id="5ZmGmhlJvWY" role="1TKVEi">
      <property role="IQ2ns" value="6905902123112595262" />
      <property role="20kJfa" value="lookupColumn" />
      <property role="20lbJX" value="fLJekj4/_1" />
      <ref role="20lvS9" node="3YATvlM33Cf" resolve="Column" />
    </node>
    <node concept="1TJgyj" id="5ZmGmhlJvXu" role="1TKVEi">
      <property role="IQ2ns" value="6905902123112595294" />
      <property role="20kJfa" value="resultTable" />
      <property role="20lbJX" value="fLJekj4/_1" />
      <ref role="20lvS9" node="3YATvlM33Cc" resolve="Table" />
    </node>
    <node concept="1TJgyj" id="5ZmGmhlJvX4" role="1TKVEi">
      <property role="IQ2ns" value="6905902123112595268" />
      <property role="20kJfa" value="resultColumn" />
      <property role="20lbJX" value="fLJekj4/_1" />
      <ref role="20lvS9" node="3YATvlM33Cf" resolve="Column" />
    </node>
    <node concept="1TJgyi" id="5ZmGmhlJvXa" role="1TKVEl">
      <property role="IQ2nx" value="6905902123112595274" />
      <property role="TrG5h" value="operation" />
      <ref role="AX2Wp" node="5ZmGmhlJvXc" resolve="LookupOperationType" />
    </node>
  </node>
  <node concept="25R3W" id="5ZmGmhlJvXc">
    <property role="3F6X1D" value="6905902123112595276" />
    <property role="TrG5h" value="LookupOperationType" />
    <node concept="25R33" id="5ZmGmhlJvXd" role="25R1y">
      <property role="3tVfz5" value="6905902123112595277" />
      <property role="TrG5h" value="NUMERIC_SUM" />
    </node>
    <node concept="25R33" id="5ZmGmhlJvXh" role="25R1y">
      <property role="3tVfz5" value="6905902123112595281" />
      <property role="TrG5h" value="NUMERIC_SUBTRACT" />
    </node>
    <node concept="25R33" id="5ZmGmhlJvXk" role="25R1y">
      <property role="3tVfz5" value="6905902123112595284" />
      <property role="TrG5h" value="NUMERIC_MULTIPLY" />
    </node>
    <node concept="25R33" id="5ZmGmhlJvXo" role="25R1y">
      <property role="3tVfz5" value="6905902123112595288" />
      <property role="TrG5h" value="NUMERIC_DIVIDE" />
    </node>
    <node concept="25R33" id="5ZmGmhlJvXr" role="25R1y">
      <property role="3tVfz5" value="6905902123112595291" />
      <property role="TrG5h" value="TEXT_CONCAT" />
    </node>
  </node>
  <node concept="1TIwiD" id="35hB$8kwehL">
    <property role="EcuMT" value="3553795587621053553" />
    <property role="TrG5h" value="StrManipulationConcat" />
    <ref role="1TJDcQ" node="5ZmGmhljubj" resolve="StrManipulation" />
    <node concept="1TJgyj" id="35hB$8kwehQ" role="1TKVEi">
      <property role="IQ2ns" value="3553795587621053558" />
      <property role="20kJfa" value="sourceA" />
      <property role="20lbJX" value="fLJekj4/_1" />
      <ref role="20lvS9" node="3YATvlM33Cf" resolve="Column" />
    </node>
    <node concept="1TJgyj" id="35hB$8kwehT" role="1TKVEi">
      <property role="IQ2ns" value="3553795587621053561" />
      <property role="20kJfa" value="sourceB" />
      <property role="20lbJX" value="fLJekj4/_1" />
      <ref role="20lvS9" node="3YATvlM33Cf" resolve="Column" />
    </node>
    <node concept="1TJgyj" id="35hB$8kwehV" role="1TKVEi">
      <property role="IQ2ns" value="3553795587621053563" />
      <property role="20kJfa" value="resultTable" />
      <property role="20lbJX" value="fLJekj4/_1" />
      <ref role="20lvS9" node="3YATvlM33Cc" resolve="Table" />
    </node>
    <node concept="1TJgyj" id="35hB$8kwehY" role="1TKVEi">
      <property role="IQ2ns" value="3553795587621053566" />
      <property role="20kJfa" value="resultColumn" />
      <property role="20lbJX" value="fLJekj4/_1" />
      <ref role="20lvS9" node="3YATvlM33Cf" resolve="Column" />
    </node>
  </node>
  <node concept="1TIwiD" id="35hB$8kCJDu">
    <property role="EcuMT" value="3553795587623287390" />
    <property role="TrG5h" value="StrManipulationSplit" />
    <ref role="1TJDcQ" node="5ZmGmhljubj" resolve="StrManipulation" />
    <node concept="1TJgyj" id="35hB$8kCJDw" role="1TKVEi">
      <property role="IQ2ns" value="3553795587623287392" />
      <property role="20kJfa" value="source" />
      <property role="20lbJX" value="fLJekj4/_1" />
      <ref role="20lvS9" node="3YATvlM33Cf" resolve="Column" />
    </node>
    <node concept="1TJgyj" id="35hB$8kCJDC" role="1TKVEi">
      <property role="IQ2ns" value="3553795587623287400" />
      <property role="20kJfa" value="resultTable" />
      <property role="20lbJX" value="fLJekj4/_1" />
      <ref role="20lvS9" node="3YATvlM33Cc" resolve="Table" />
    </node>
    <node concept="1TJgyj" id="35hB$8kCJDE" role="1TKVEi">
      <property role="IQ2ns" value="3553795587623287402" />
      <property role="20kJfa" value="resultColumnA" />
      <property role="20lbJX" value="fLJekj4/_1" />
      <ref role="20lvS9" node="3YATvlM33Cf" resolve="Column" />
    </node>
    <node concept="1TJgyj" id="35hB$8kCJDH" role="1TKVEi">
      <property role="IQ2ns" value="3553795587623287405" />
      <property role="20kJfa" value="resultColumnB" />
      <property role="20lbJX" value="fLJekj4/_1" />
      <ref role="20lvS9" node="3YATvlM33Cf" resolve="Column" />
    </node>
    <node concept="1TJgyi" id="35hB$8kCJDy" role="1TKVEl">
      <property role="IQ2nx" value="3553795587623287394" />
      <property role="TrG5h" value="delimter" />
      <ref role="AX2Wp" to="tpck:fKAOsGN" resolve="string" />
    </node>
    <node concept="1TJgyi" id="35hB$8kCJD_" role="1TKVEl">
      <property role="IQ2nx" value="3553795587623287397" />
      <property role="TrG5h" value="atCharIndex" />
      <ref role="AX2Wp" to="tpck:fKAOsGN" resolve="string" />
    </node>
  </node>
</model>

