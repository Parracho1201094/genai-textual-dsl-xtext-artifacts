<?xml version="1.0" encoding="UTF-8"?>
<model ref="r:f197530d-51ad-4216-956c-2f6cb0c55a22(ltsdsl.generator.enums@generator)">
  <persistence version="9" />
  <languages>
    <devkit ref="a2eb3a43-fcc2-4200-80dc-c60110c4862d(jetbrains.mps.devkit.templates)" />
  </languages>
  <imports>
    <import index="y20r" ref="r:85f52e46-7a19-44f9-bf10-6677b89edd73(ltsdsl.structure)" />
    <import index="wyt6" ref="6354ebe7-c22a-4a0f-ac54-50b52ab9b065/java:java.lang(JDK/)" implicit="true" />
  </imports>
  <registry>
    <language id="f3061a53-9226-4cc5-a443-f952ceaf5816" name="jetbrains.mps.baseLanguage">
      <concept id="1083245097125" name="jetbrains.mps.baseLanguage.structure.EnumClass" flags="ig" index="Qs71p">
        <child id="1083245396908" name="enumConstant" index="Qtgdg" />
      </concept>
      <concept id="1083245299891" name="jetbrains.mps.baseLanguage.structure.EnumConstantDeclaration" flags="ig" index="QsSxf" />
      <concept id="1204053956946" name="jetbrains.mps.baseLanguage.structure.IMethodCall" flags="ngI" index="1ndlxa">
        <reference id="1068499141037" name="baseMethodDeclaration" index="37wK5l" />
      </concept>
      <concept id="1107461130800" name="jetbrains.mps.baseLanguage.structure.Classifier" flags="ng" index="3pOWGL">
        <property id="2791683072064593257" name="packageName" index="2HnT6v" />
      </concept>
      <concept id="1178549954367" name="jetbrains.mps.baseLanguage.structure.IVisible" flags="ngI" index="1B3ioH">
        <child id="1178549979242" name="visibility" index="1B3o_S" />
      </concept>
      <concept id="1146644602865" name="jetbrains.mps.baseLanguage.structure.PublicVisibility" flags="nn" index="3Tm1VV" />
    </language>
    <language id="b401a680-8325-4110-8fd3-84331ff25bef" name="jetbrains.mps.lang.generator">
      <concept id="1095416546421" name="jetbrains.mps.lang.generator.structure.MappingConfiguration" flags="ig" index="bUwia">
        <child id="1167514678247" name="rootMappingRule" index="3lj3bC" />
      </concept>
      <concept id="1168619357332" name="jetbrains.mps.lang.generator.structure.RootTemplateAnnotation" flags="lg" index="n94m4" />
      <concept id="1167169308231" name="jetbrains.mps.lang.generator.structure.BaseMappingRule" flags="ng" index="30H$t8">
        <reference id="1167169349424" name="applicableConcept" index="30HIoZ" />
      </concept>
      <concept id="1167514355419" name="jetbrains.mps.lang.generator.structure.Root_MappingRule" flags="lg" index="3lhOvk">
        <reference id="1167514355421" name="template" index="3lhOvi" />
      </concept>
    </language>
    <language id="ceab5195-25ea-4f22-9b92-103b95ca8c0c" name="jetbrains.mps.lang.core">
      <concept id="1133920641626" name="jetbrains.mps.lang.core.structure.BaseConcept" flags="ng" index="2VYdi">
        <child id="5169995583184591170" name="smodelAttribute" index="lGtFl" />
      </concept>
      <concept id="1169194658468" name="jetbrains.mps.lang.core.structure.INamedConcept" flags="ngI" index="TrEIO">
        <property id="1169194664001" name="name" index="TrG5h" />
      </concept>
    </language>
  </registry>
  <node concept="Qs71p" id="cd93YdO8wN">
    <property role="TrG5h" value="DataType" />
    <property role="2HnT6v" value="program.src.main.java.org.enorm.domain.enums" />
    <node concept="3Tm1VV" id="cd93YdO8wO" role="1B3o_S" />
    <node concept="n94m4" id="cd93YdO8wP" role="lGtFl" />
    <node concept="QsSxf" id="cd93YdO8A8" role="Qtgdg">
      <property role="TrG5h" value="TEXT" />
      <ref role="37wK5l" to="wyt6:~Object.&lt;init&gt;()" resolve="Object" />
    </node>
    <node concept="QsSxf" id="cd93YdO8Es" role="Qtgdg">
      <property role="TrG5h" value="NUMBER" />
      <ref role="37wK5l" to="wyt6:~Object.&lt;init&gt;()" />
    </node>
    <node concept="QsSxf" id="cd93YdO8Ms" role="Qtgdg">
      <property role="TrG5h" value="DATE" />
      <ref role="37wK5l" to="wyt6:~Object.&lt;init&gt;()" />
    </node>
  </node>
  <node concept="Qs71p" id="cd93Ye3jBJ">
    <property role="TrG5h" value="FilterOperatorType" />
    <property role="2HnT6v" value="program.src.main.java.org.enorm.domain.enums" />
    <node concept="3Tm1VV" id="cd93Ye3jBK" role="1B3o_S" />
    <node concept="n94m4" id="cd93Ye3jBL" role="lGtFl" />
    <node concept="QsSxf" id="cd93Ye3jFO" role="Qtgdg">
      <property role="TrG5h" value="EQUALS" />
      <ref role="37wK5l" to="wyt6:~Object.&lt;init&gt;()" />
    </node>
    <node concept="QsSxf" id="cd93Ye3jHz" role="Qtgdg">
      <property role="TrG5h" value="LESS_THAN" />
      <ref role="37wK5l" to="wyt6:~Object.&lt;init&gt;()" />
    </node>
    <node concept="QsSxf" id="cd93Ye3jKO" role="Qtgdg">
      <property role="TrG5h" value="LESS_OR_EQUALS_THAN" />
      <ref role="37wK5l" to="wyt6:~Object.&lt;init&gt;()" />
    </node>
    <node concept="QsSxf" id="cd93Ye3k3p" role="Qtgdg">
      <property role="TrG5h" value="GREATER_THAN" />
      <ref role="37wK5l" to="wyt6:~Object.&lt;init&gt;()" />
    </node>
    <node concept="QsSxf" id="cd93Ye3klM" role="Qtgdg">
      <property role="TrG5h" value="GREATER_OR_EQUALS_THAN" />
      <ref role="37wK5l" to="wyt6:~Object.&lt;init&gt;()" />
    </node>
  </node>
  <node concept="Qs71p" id="cd93Ye9gEE">
    <property role="TrG5h" value="JoinType" />
    <property role="2HnT6v" value="program.src.main.java.org.enorm.domain.enums" />
    <node concept="3Tm1VV" id="cd93Ye9gEF" role="1B3o_S" />
    <node concept="n94m4" id="cd93Ye9gEG" role="lGtFl" />
    <node concept="QsSxf" id="cd93Ye9gSj" role="Qtgdg">
      <property role="TrG5h" value="INNER" />
      <ref role="37wK5l" to="wyt6:~Object.&lt;init&gt;()" />
    </node>
    <node concept="QsSxf" id="cd93Ye9gTb" role="Qtgdg">
      <property role="TrG5h" value="FULL" />
      <ref role="37wK5l" to="wyt6:~Object.&lt;init&gt;()" />
    </node>
    <node concept="QsSxf" id="cd93Ye9gY1" role="Qtgdg">
      <property role="TrG5h" value="LEFT" />
      <ref role="37wK5l" to="wyt6:~Object.&lt;init&gt;()" />
    </node>
    <node concept="QsSxf" id="cd93Ye9h7q" role="Qtgdg">
      <property role="TrG5h" value="RIGHT" />
      <ref role="37wK5l" to="wyt6:~Object.&lt;init&gt;()" />
    </node>
  </node>
  <node concept="Qs71p" id="4BP1plxEkQ6">
    <property role="TrG5h" value="LookupOperationType" />
    <property role="2HnT6v" value="program.src.main.java.org.enorm.domain.enums" />
    <node concept="3Tm1VV" id="4BP1plxEkQ7" role="1B3o_S" />
    <node concept="n94m4" id="4BP1plxEkQ8" role="lGtFl" />
    <node concept="QsSxf" id="4BP1plxEmDD" role="Qtgdg">
      <property role="TrG5h" value="NUMERIC_SUM" />
      <ref role="37wK5l" to="wyt6:~Object.&lt;init&gt;()" />
    </node>
    <node concept="QsSxf" id="4BP1plxEmHX" role="Qtgdg">
      <property role="TrG5h" value="NUMERIC_SUBTRACT" />
      <ref role="37wK5l" to="wyt6:~Object.&lt;init&gt;()" />
    </node>
    <node concept="QsSxf" id="4BP1plxEmZr" role="Qtgdg">
      <property role="TrG5h" value="NUMERIC_MULTIPLY" />
      <ref role="37wK5l" to="wyt6:~Object.&lt;init&gt;()" />
    </node>
    <node concept="QsSxf" id="4BP1plxEnkj" role="Qtgdg">
      <property role="TrG5h" value="NUMERIC_DIVIDE" />
      <ref role="37wK5l" to="wyt6:~Object.&lt;init&gt;()" />
    </node>
    <node concept="QsSxf" id="4BP1plxEnwE" role="Qtgdg">
      <property role="TrG5h" value="TEXT_CONCAT" />
      <ref role="37wK5l" to="wyt6:~Object.&lt;init&gt;()" />
    </node>
  </node>
  <node concept="Qs71p" id="4BP1plxMIZT">
    <property role="TrG5h" value="SortType" />
    <property role="2HnT6v" value="program.src.main.java.org.enorm.domain.enums" />
    <node concept="3Tm1VV" id="4BP1plxMIZU" role="1B3o_S" />
    <node concept="n94m4" id="4BP1plxMIZV" role="lGtFl" />
    <node concept="QsSxf" id="4BP1plxMJ4D" role="Qtgdg">
      <property role="TrG5h" value="ASC" />
      <ref role="37wK5l" to="wyt6:~Object.&lt;init&gt;()" />
    </node>
    <node concept="QsSxf" id="4BP1plxMJ5x" role="Qtgdg">
      <property role="TrG5h" value="DESC" />
      <ref role="37wK5l" to="wyt6:~Object.&lt;init&gt;()" />
    </node>
  </node>
  <node concept="Qs71p" id="4BP1plxRthH">
    <property role="TrG5h" value="GroupByOperationType" />
    <property role="2HnT6v" value="program.src.main.java.org.enorm.domain.enums" />
    <node concept="3Tm1VV" id="4BP1plxRthI" role="1B3o_S" />
    <node concept="n94m4" id="4BP1plxRthJ" role="lGtFl" />
    <node concept="QsSxf" id="4BP1plxRtye" role="Qtgdg">
      <property role="TrG5h" value="MAX" />
      <ref role="37wK5l" to="wyt6:~Object.&lt;init&gt;()" />
    </node>
    <node concept="QsSxf" id="4BP1plxRtzX" role="Qtgdg">
      <property role="TrG5h" value="MIN" />
      <ref role="37wK5l" to="wyt6:~Object.&lt;init&gt;()" />
    </node>
    <node concept="QsSxf" id="4BP1plxRtFY" role="Qtgdg">
      <property role="TrG5h" value="COUNT" />
      <ref role="37wK5l" to="wyt6:~Object.&lt;init&gt;()" />
    </node>
    <node concept="QsSxf" id="4BP1plxRtKL" role="Qtgdg">
      <property role="TrG5h" value="SUM" />
      <ref role="37wK5l" to="wyt6:~Object.&lt;init&gt;()" />
    </node>
    <node concept="QsSxf" id="4BP1plxRtU7" role="Qtgdg">
      <property role="TrG5h" value="AVERAGE" />
      <ref role="37wK5l" to="wyt6:~Object.&lt;init&gt;()" />
    </node>
  </node>
  <node concept="bUwia" id="4BP1pl_s5CZ">
    <property role="TrG5h" value="main" />
    <node concept="3lhOvk" id="4BP1pl_s5D0" role="3lj3bC">
      <ref role="30HIoZ" to="y20r:3YATvlM2MEa" resolve="Model" />
      <ref role="3lhOvi" node="cd93YdO8wN" resolve="DataType" />
    </node>
    <node concept="3lhOvk" id="4BP1pl_s5D1" role="3lj3bC">
      <ref role="30HIoZ" to="y20r:59Zp2b9n1iz" resolve="Filter" />
      <ref role="3lhOvi" node="cd93Ye3jBJ" resolve="FilterOperatorType" />
    </node>
    <node concept="3lhOvk" id="4BP1pl_s5D2" role="3lj3bC">
      <ref role="30HIoZ" to="y20r:5ZmGmhlCEN7" resolve="Group" />
      <ref role="3lhOvi" node="4BP1plxRthH" resolve="GroupByOperationType" />
    </node>
    <node concept="3lhOvk" id="4BP1pl_s5D3" role="3lj3bC">
      <ref role="30HIoZ" to="y20r:5ZmGmhllUK0" resolve="Join" />
      <ref role="3lhOvi" node="cd93Ye9gEE" resolve="JoinType" />
    </node>
    <node concept="3lhOvk" id="4BP1pl_s5D4" role="3lj3bC">
      <ref role="30HIoZ" to="y20r:5ZmGmhlJvWA" resolve="Lookup" />
      <ref role="3lhOvi" node="4BP1plxEkQ6" resolve="LookupOperationType" />
    </node>
    <node concept="3lhOvk" id="4BP1pl_s5D5" role="3lj3bC">
      <ref role="30HIoZ" to="y20r:3YATvlM4ZjO" resolve="Sort" />
      <ref role="3lhOvi" node="4BP1plxMIZT" resolve="SortType" />
    </node>
  </node>
</model>

