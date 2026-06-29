<?xml version="1.0" encoding="UTF-8"?>
<model ref="r:a36eddf6-717d-4a20-ae38-593280be96dd(ltsdsl.generator.steps.strConcat@generator)">
  <persistence version="9" />
  <languages>
    <devkit ref="a2eb3a43-fcc2-4200-80dc-c60110c4862d(jetbrains.mps.devkit.templates)" />
  </languages>
  <imports>
    <import index="y20r" ref="r:85f52e46-7a19-44f9-bf10-6677b89edd73(ltsdsl.structure)" />
    <import index="33ny" ref="6354ebe7-c22a-4a0f-ac54-50b52ab9b065/java:java.util(JDK/)" />
    <import index="6a2z" ref="r:1c985b49-e2d4-4b0a-ac27-a43894ccaff0(ltsdsl.generator.tables@generator)" />
    <import index="810k" ref="r:7a125382-cddb-4c4f-8e8b-3d8533cae26c(ltsdsl.generator.main@generator)" />
    <import index="wyt6" ref="6354ebe7-c22a-4a0f-ac54-50b52ab9b065/java:java.lang(JDK/)" implicit="true" />
  </imports>
  <registry>
    <language id="f3061a53-9226-4cc5-a443-f952ceaf5816" name="jetbrains.mps.baseLanguage">
      <concept id="1080223426719" name="jetbrains.mps.baseLanguage.structure.OrExpression" flags="nn" index="22lmx$" />
      <concept id="1082485599095" name="jetbrains.mps.baseLanguage.structure.BlockStatement" flags="nn" index="9aQIb">
        <child id="1082485599096" name="statements" index="9aQI4" />
      </concept>
      <concept id="1215693861676" name="jetbrains.mps.baseLanguage.structure.BaseAssignmentExpression" flags="nn" index="d038R">
        <child id="1068498886297" name="rValue" index="37vLTx" />
        <child id="1068498886295" name="lValue" index="37vLTJ" />
      </concept>
      <concept id="1153422305557" name="jetbrains.mps.baseLanguage.structure.LessThanOrEqualsExpression" flags="nn" index="2dkUwp" />
      <concept id="1202948039474" name="jetbrains.mps.baseLanguage.structure.InstanceMethodCallOperation" flags="nn" index="liA8E" />
      <concept id="1465982738277781862" name="jetbrains.mps.baseLanguage.structure.PlaceholderMember" flags="nn" index="2tJIrI" />
      <concept id="1239714755177" name="jetbrains.mps.baseLanguage.structure.AbstractUnaryNumberOperation" flags="nn" index="2$Kvd9">
        <child id="1239714902950" name="expression" index="2$L3a6" />
      </concept>
      <concept id="1188207840427" name="jetbrains.mps.baseLanguage.structure.AnnotationInstance" flags="nn" index="2AHcQZ">
        <reference id="1188208074048" name="annotation" index="2AI5Lk" />
      </concept>
      <concept id="1188208481402" name="jetbrains.mps.baseLanguage.structure.HasAnnotation" flags="ngI" index="2AJDlI">
        <child id="1188208488637" name="annotation" index="2AJF6D" />
      </concept>
      <concept id="1154032098014" name="jetbrains.mps.baseLanguage.structure.AbstractLoopStatement" flags="nn" index="2LF5Ji">
        <child id="1154032183016" name="body" index="2LFqv$" />
      </concept>
      <concept id="1197027756228" name="jetbrains.mps.baseLanguage.structure.DotExpression" flags="nn" index="2OqwBi">
        <child id="1197027771414" name="operand" index="2Oq$k0" />
        <child id="1197027833540" name="operation" index="2OqNvi" />
      </concept>
      <concept id="1083260308424" name="jetbrains.mps.baseLanguage.structure.EnumConstantReference" flags="nn" index="Rm8GO">
        <reference id="1083260308426" name="enumConstantDeclaration" index="Rm8GQ" />
        <reference id="1144432896254" name="enumClass" index="1Px2BO" />
      </concept>
      <concept id="1145552977093" name="jetbrains.mps.baseLanguage.structure.GenericNewExpression" flags="nn" index="2ShNRf">
        <child id="1145553007750" name="creator" index="2ShVmc" />
      </concept>
      <concept id="1070462154015" name="jetbrains.mps.baseLanguage.structure.StaticFieldDeclaration" flags="ig" index="Wx3nA" />
      <concept id="1070475926800" name="jetbrains.mps.baseLanguage.structure.StringLiteral" flags="nn" index="Xl_RD">
        <property id="1070475926801" name="value" index="Xl_RC" />
      </concept>
      <concept id="1081236700938" name="jetbrains.mps.baseLanguage.structure.StaticMethodDeclaration" flags="ig" index="2YIFZL" />
      <concept id="1081236700937" name="jetbrains.mps.baseLanguage.structure.StaticMethodCall" flags="nn" index="2YIFZM">
        <reference id="1144433194310" name="classConcept" index="1Pybhc" />
      </concept>
      <concept id="1164991038168" name="jetbrains.mps.baseLanguage.structure.ThrowStatement" flags="nn" index="YS8fn">
        <child id="1164991057263" name="throwable" index="YScLw" />
      </concept>
      <concept id="1070534058343" name="jetbrains.mps.baseLanguage.structure.NullLiteral" flags="nn" index="10Nm6u" />
      <concept id="1070534370425" name="jetbrains.mps.baseLanguage.structure.IntegerType" flags="in" index="10Oyi0" />
      <concept id="1070534934090" name="jetbrains.mps.baseLanguage.structure.CastExpression" flags="nn" index="10QFUN">
        <child id="1070534934091" name="type" index="10QFUM" />
        <child id="1070534934092" name="expression" index="10QFUP" />
      </concept>
      <concept id="1068390468198" name="jetbrains.mps.baseLanguage.structure.ClassConcept" flags="ig" index="312cEu">
        <child id="1095933932569" name="implementedInterface" index="EKbjA" />
      </concept>
      <concept id="1068431474542" name="jetbrains.mps.baseLanguage.structure.VariableDeclaration" flags="ng" index="33uBYm">
        <child id="1068431790190" name="initializer" index="33vP2m" />
      </concept>
      <concept id="1513279640923991009" name="jetbrains.mps.baseLanguage.structure.IGenericClassCreator" flags="ngI" index="366HgL">
        <property id="1513279640906337053" name="inferTypeParams" index="373rjd" />
      </concept>
      <concept id="1068498886296" name="jetbrains.mps.baseLanguage.structure.VariableReference" flags="nn" index="37vLTw">
        <reference id="1068581517664" name="variableDeclaration" index="3cqZAo" />
      </concept>
      <concept id="1068498886292" name="jetbrains.mps.baseLanguage.structure.ParameterDeclaration" flags="ir" index="37vLTG" />
      <concept id="1068498886294" name="jetbrains.mps.baseLanguage.structure.AssignmentExpression" flags="nn" index="37vLTI" />
      <concept id="4972933694980447171" name="jetbrains.mps.baseLanguage.structure.BaseVariableDeclaration" flags="ng" index="19Szcq">
        <child id="5680397130376446158" name="type" index="1tU5fm" />
      </concept>
      <concept id="1068580123132" name="jetbrains.mps.baseLanguage.structure.BaseMethodDeclaration" flags="ng" index="3clF44">
        <child id="1068580123133" name="returnType" index="3clF45" />
        <child id="1068580123134" name="parameter" index="3clF46" />
        <child id="1068580123135" name="body" index="3clF47" />
      </concept>
      <concept id="1068580123165" name="jetbrains.mps.baseLanguage.structure.InstanceMethodDeclaration" flags="ig" index="3clFb_" />
      <concept id="1068580123152" name="jetbrains.mps.baseLanguage.structure.EqualsExpression" flags="nn" index="3clFbC" />
      <concept id="1068580123155" name="jetbrains.mps.baseLanguage.structure.ExpressionStatement" flags="nn" index="3clFbF">
        <child id="1068580123156" name="expression" index="3clFbG" />
      </concept>
      <concept id="1068580123157" name="jetbrains.mps.baseLanguage.structure.Statement" flags="nn" index="3clFbH" />
      <concept id="1068580123159" name="jetbrains.mps.baseLanguage.structure.IfStatement" flags="nn" index="3clFbJ">
        <child id="1082485599094" name="ifFalseStatement" index="9aQIa" />
        <child id="1068580123160" name="condition" index="3clFbw" />
        <child id="1068580123161" name="ifTrue" index="3clFbx" />
        <child id="1206060520071" name="elsifClauses" index="3eNLev" />
      </concept>
      <concept id="1068580123136" name="jetbrains.mps.baseLanguage.structure.StatementList" flags="sn" stub="5293379017992965193" index="3clFbS">
        <child id="1068581517665" name="statement" index="3cqZAp" />
      </concept>
      <concept id="1068580320020" name="jetbrains.mps.baseLanguage.structure.IntegerConstant" flags="nn" index="3cmrfG">
        <property id="1068580320021" name="value" index="3cmrfH" />
      </concept>
      <concept id="1068581242875" name="jetbrains.mps.baseLanguage.structure.PlusExpression" flags="nn" index="3cpWs3" />
      <concept id="1068581242878" name="jetbrains.mps.baseLanguage.structure.ReturnStatement" flags="nn" index="3cpWs6">
        <child id="1068581517676" name="expression" index="3cqZAk" />
      </concept>
      <concept id="1068581242864" name="jetbrains.mps.baseLanguage.structure.LocalVariableDeclarationStatement" flags="nn" index="3cpWs8">
        <child id="1068581242865" name="localVariableDeclaration" index="3cpWs9" />
      </concept>
      <concept id="1068581242863" name="jetbrains.mps.baseLanguage.structure.LocalVariableDeclaration" flags="nr" index="3cpWsn" />
      <concept id="1068581517677" name="jetbrains.mps.baseLanguage.structure.VoidType" flags="in" index="3cqZAl" />
      <concept id="1206060495898" name="jetbrains.mps.baseLanguage.structure.ElsifClause" flags="ng" index="3eNFk2">
        <child id="1206060619838" name="condition" index="3eO9$A" />
        <child id="1206060644605" name="statementList" index="3eOfB_" />
      </concept>
      <concept id="1204053956946" name="jetbrains.mps.baseLanguage.structure.IMethodCall" flags="ngI" index="1ndlxa">
        <reference id="1068499141037" name="baseMethodDeclaration" index="37wK5l" />
        <child id="1068499141038" name="actualArgument" index="37wK5m" />
      </concept>
      <concept id="1212685548494" name="jetbrains.mps.baseLanguage.structure.ClassCreator" flags="nn" index="1pGfFk">
        <child id="1212687122400" name="typeParameter" index="1pMfVU" />
      </concept>
      <concept id="1107461130800" name="jetbrains.mps.baseLanguage.structure.Classifier" flags="ng" index="3pOWGL">
        <property id="2791683072064593257" name="packageName" index="2HnT6v" />
        <child id="5375687026011219971" name="member" index="jymVt" unordered="true" />
      </concept>
      <concept id="1107535904670" name="jetbrains.mps.baseLanguage.structure.ClassifierType" flags="in" index="3uibUv">
        <reference id="1107535924139" name="classifier" index="3uigEE" />
        <child id="1109201940907" name="parameter" index="11_B2D" />
      </concept>
      <concept id="1081773326031" name="jetbrains.mps.baseLanguage.structure.BinaryOperation" flags="nn" index="3uHJSO">
        <child id="1081773367579" name="rightExpression" index="3uHU7w" />
        <child id="1081773367580" name="leftExpression" index="3uHU7B" />
      </concept>
      <concept id="1214918800624" name="jetbrains.mps.baseLanguage.structure.PostfixIncrementExpression" flags="nn" index="3uNrnE" />
      <concept id="1178549954367" name="jetbrains.mps.baseLanguage.structure.IVisible" flags="ngI" index="1B3ioH">
        <child id="1178549979242" name="visibility" index="1B3o_S" />
      </concept>
      <concept id="1144226303539" name="jetbrains.mps.baseLanguage.structure.ForeachStatement" flags="nn" index="1DcWWT">
        <child id="1144226360166" name="iterable" index="1DdaDG" />
      </concept>
      <concept id="1144230876926" name="jetbrains.mps.baseLanguage.structure.AbstractForStatement" flags="nn" index="1DupvO">
        <child id="1144230900587" name="variable" index="1Duv9x" />
      </concept>
      <concept id="1144231330558" name="jetbrains.mps.baseLanguage.structure.ForStatement" flags="nn" index="1Dw8fO">
        <child id="1144231399730" name="condition" index="1Dwp0S" />
        <child id="1144231408325" name="iteration" index="1Dwrff" />
      </concept>
      <concept id="1107796713796" name="jetbrains.mps.baseLanguage.structure.Interface" flags="ig" index="3HP615" />
      <concept id="1146644602865" name="jetbrains.mps.baseLanguage.structure.PublicVisibility" flags="nn" index="3Tm1VV" />
      <concept id="1146644623116" name="jetbrains.mps.baseLanguage.structure.PrivateVisibility" flags="nn" index="3Tm6S6" />
      <concept id="1080120340718" name="jetbrains.mps.baseLanguage.structure.AndExpression" flags="nn" index="1Wc70l" />
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
  <node concept="312cEu" id="4BP1ply_kKr">
    <property role="TrG5h" value="FactoryStrManipulationConcatStep" />
    <property role="2HnT6v" value="program.src.main.java.org.enorm.domain.steps.StrManipulationConcatStep" />
    <node concept="Wx3nA" id="4BP1ply_kWi" role="jymVt">
      <property role="TrG5h" value="step" />
      <node concept="3Tm6S6" id="4BP1ply_kVN" role="1B3o_S" />
      <node concept="3uibUv" id="4BP1ply_kW8" role="1tU5fm">
        <ref role="3uigEE" node="4BP1ply_kKO" resolve="IStrManipulationConcatStep" />
      </node>
    </node>
    <node concept="2tJIrI" id="4BP1ply_kWu" role="jymVt" />
    <node concept="2YIFZL" id="4BP1ply_kWQ" role="jymVt">
      <property role="TrG5h" value="setStep" />
      <node concept="3clFbS" id="4BP1ply_kWT" role="3clF47">
        <node concept="3clFbF" id="4BP1ply_kYA" role="3cqZAp">
          <node concept="37vLTI" id="4BP1ply_lSo" role="3clFbG">
            <node concept="37vLTw" id="4BP1ply_lTj" role="37vLTx">
              <ref role="3cqZAo" node="4BP1ply_kXk" resolve="s" />
            </node>
            <node concept="37vLTw" id="4BP1ply_kY_" role="37vLTJ">
              <ref role="3cqZAo" node="4BP1ply_kWi" resolve="step" />
            </node>
          </node>
        </node>
      </node>
      <node concept="3Tm1VV" id="4BP1ply_kWD" role="1B3o_S" />
      <node concept="3cqZAl" id="4BP1ply_kWG" role="3clF45" />
      <node concept="37vLTG" id="4BP1ply_kXk" role="3clF46">
        <property role="TrG5h" value="s" />
        <node concept="3uibUv" id="4BP1ply_kXj" role="1tU5fm">
          <ref role="3uigEE" node="4BP1ply_kKO" resolve="IStrManipulationConcatStep" />
        </node>
      </node>
    </node>
    <node concept="2tJIrI" id="4BP1ply_lU0" role="jymVt" />
    <node concept="2YIFZL" id="4BP1ply_lUY" role="jymVt">
      <property role="TrG5h" value="getStep" />
      <node concept="3clFbS" id="4BP1ply_lV1" role="3clF47">
        <node concept="3cpWs6" id="4BP1ply_lWh" role="3cqZAp">
          <node concept="37vLTw" id="4BP1ply_lWR" role="3cqZAk">
            <ref role="3cqZAo" node="4BP1ply_kWi" resolve="step" />
          </node>
        </node>
      </node>
      <node concept="3Tm1VV" id="4BP1ply_lUh" role="1B3o_S" />
      <node concept="3uibUv" id="4BP1ply_lUK" role="3clF45">
        <ref role="3uigEE" node="4BP1ply_kKO" resolve="IStrManipulationConcatStep" />
      </node>
    </node>
    <node concept="3Tm1VV" id="4BP1ply_kKs" role="1B3o_S" />
    <node concept="n94m4" id="4BP1ply_kKt" role="lGtFl" />
  </node>
  <node concept="3HP615" id="4BP1ply_kKO">
    <property role="TrG5h" value="IStrManipulationConcatStep" />
    <property role="2HnT6v" value="program.src.main.java.org.enorm.domain.steps.StrManipulationConcatStep" />
    <node concept="3clFb_" id="4BP1ply_kMx" role="jymVt">
      <property role="TrG5h" value="apply" />
      <node concept="3clFbS" id="4BP1ply_kM$" role="3clF47" />
      <node concept="3Tm1VV" id="4BP1ply_kM_" role="1B3o_S" />
      <node concept="3uibUv" id="4BP1ply_kMn" role="3clF45">
        <ref role="3uigEE" to="6a2z:cd93YdJHRJ" resolve="Table" />
      </node>
      <node concept="37vLTG" id="4BP1ply_kMZ" role="3clF46">
        <property role="TrG5h" value="inputTable" />
        <node concept="3uibUv" id="4BP1ply_kMY" role="1tU5fm">
          <ref role="3uigEE" to="6a2z:cd93YdJHRJ" resolve="Table" />
        </node>
      </node>
      <node concept="37vLTG" id="4BP1ply_kOA" role="3clF46">
        <property role="TrG5h" value="columnA" />
        <node concept="3uibUv" id="4BP1ply_kP2" role="1tU5fm">
          <ref role="3uigEE" to="6a2z:cd93YdJHTQ" resolve="Column" />
        </node>
      </node>
      <node concept="37vLTG" id="4BP1ply_kQf" role="3clF46">
        <property role="TrG5h" value="columnB" />
        <node concept="3uibUv" id="4BP1ply_kQF" role="1tU5fm">
          <ref role="3uigEE" to="6a2z:cd93YdJHTQ" resolve="Column" />
        </node>
      </node>
      <node concept="37vLTG" id="4BP1ply_kRS" role="3clF46">
        <property role="TrG5h" value="columnName" />
        <node concept="3uibUv" id="4BP1ply_kSm" role="1tU5fm">
          <ref role="3uigEE" to="wyt6:~String" resolve="String" />
        </node>
      </node>
      <node concept="37vLTG" id="4BP1ply_kTa" role="3clF46">
        <property role="TrG5h" value="factoryTable" />
        <node concept="3uibUv" id="4BP1ply_kTA" role="1tU5fm">
          <ref role="3uigEE" to="6a2z:cd93YdSsAK" resolve="FactoryTable" />
        </node>
      </node>
    </node>
    <node concept="3Tm1VV" id="4BP1ply_kKP" role="1B3o_S" />
    <node concept="n94m4" id="4BP1ply_kKQ" role="lGtFl" />
  </node>
  <node concept="312cEu" id="4BP1ply_kL5">
    <property role="TrG5h" value="StrManipulationConcatStepDefault" />
    <property role="2HnT6v" value="program.src.main.java.org.enorm.domain.steps.StrManipulationConcatStep" />
    <node concept="3Tm1VV" id="4BP1ply_kL6" role="1B3o_S" />
    <node concept="n94m4" id="4BP1ply_kL7" role="lGtFl" />
    <node concept="3uibUv" id="4BP1ply_lYg" role="EKbjA">
      <ref role="3uigEE" node="4BP1ply_kKO" resolve="IStrManipulationConcatStep" />
    </node>
    <node concept="3clFb_" id="4BP1ply_lYW" role="jymVt">
      <property role="TrG5h" value="apply" />
      <node concept="3Tm1VV" id="4BP1ply_lYY" role="1B3o_S" />
      <node concept="3uibUv" id="4BP1ply_lYZ" role="3clF45">
        <ref role="3uigEE" to="6a2z:cd93YdJHRJ" resolve="Table" />
      </node>
      <node concept="37vLTG" id="4BP1ply_lZ0" role="3clF46">
        <property role="TrG5h" value="inputTable" />
        <node concept="3uibUv" id="4BP1ply_lZ1" role="1tU5fm">
          <ref role="3uigEE" to="6a2z:cd93YdJHRJ" resolve="Table" />
        </node>
      </node>
      <node concept="37vLTG" id="4BP1ply_lZ2" role="3clF46">
        <property role="TrG5h" value="columnA" />
        <node concept="3uibUv" id="4BP1ply_lZ3" role="1tU5fm">
          <ref role="3uigEE" to="6a2z:cd93YdJHTQ" resolve="Column" />
        </node>
      </node>
      <node concept="37vLTG" id="4BP1ply_lZ4" role="3clF46">
        <property role="TrG5h" value="columnB" />
        <node concept="3uibUv" id="4BP1ply_lZ5" role="1tU5fm">
          <ref role="3uigEE" to="6a2z:cd93YdJHTQ" resolve="Column" />
        </node>
      </node>
      <node concept="37vLTG" id="4BP1ply_lZ6" role="3clF46">
        <property role="TrG5h" value="columnName" />
        <node concept="3uibUv" id="4BP1ply_lZ7" role="1tU5fm">
          <ref role="3uigEE" to="wyt6:~String" resolve="String" />
        </node>
      </node>
      <node concept="37vLTG" id="4BP1ply_lZ8" role="3clF46">
        <property role="TrG5h" value="factoryTable" />
        <node concept="3uibUv" id="4BP1ply_lZ9" role="1tU5fm">
          <ref role="3uigEE" to="6a2z:cd93YdSsAK" resolve="FactoryTable" />
        </node>
      </node>
      <node concept="3clFbS" id="4BP1ply_lZa" role="3clF47">
        <node concept="3cpWs8" id="4BP1ply_m7J" role="3cqZAp">
          <node concept="3cpWsn" id="4BP1ply_m7K" role="3cpWs9">
            <property role="TrG5h" value="resultTable" />
            <node concept="3uibUv" id="4BP1ply_m7L" role="1tU5fm">
              <ref role="3uigEE" to="6a2z:cd93YdJHRJ" resolve="Table" />
            </node>
            <node concept="2OqwBi" id="4BP1ply_m_j" role="33vP2m">
              <node concept="37vLTw" id="4BP1ply_mif" role="2Oq$k0">
                <ref role="3cqZAo" node="4BP1ply_lZ8" resolve="factoryTable" />
              </node>
              <node concept="liA8E" id="4BP1ply_mPy" role="2OqNvi">
                <ref role="37wK5l" to="6a2z:cd93YdSsBC" resolve="generateTable" />
              </node>
            </node>
          </node>
        </node>
        <node concept="3cpWs8" id="4BP1ply_mWl" role="3cqZAp">
          <node concept="3cpWsn" id="4BP1ply_mWm" role="3cpWs9">
            <property role="TrG5h" value="resultColumn" />
            <node concept="3uibUv" id="4BP1ply_mWn" role="1tU5fm">
              <ref role="3uigEE" to="6a2z:cd93YdJHTQ" resolve="Column" />
            </node>
            <node concept="2OqwBi" id="4BP1ply_nc4" role="33vP2m">
              <node concept="37vLTw" id="4BP1ply_n3W" role="2Oq$k0">
                <ref role="3cqZAo" node="4BP1ply_m7K" resolve="resultTable" />
              </node>
              <node concept="liA8E" id="4BP1ply_nkh" role="2OqNvi">
                <ref role="37wK5l" to="6a2z:cd93YdP8j9" resolve="getColumnByName" />
                <node concept="37vLTw" id="4BP1ply_nnt" role="37wK5m">
                  <ref role="3cqZAo" node="4BP1ply_lZ6" resolve="columnName" />
                </node>
              </node>
            </node>
          </node>
        </node>
        <node concept="3clFbH" id="4BP1ply_nqg" role="3cqZAp" />
        <node concept="3clFbJ" id="4BP1ply_ntD" role="3cqZAp">
          <node concept="3clFbS" id="4BP1ply_ntF" role="3clFbx">
            <node concept="3clFbF" id="6gCHjbasz$9" role="3cqZAp">
              <node concept="2YIFZM" id="6gCHjbasz$a" role="3clFbG">
                <ref role="37wK5l" to="810k:6gCHjbahhRx" resolve="log" />
                <ref role="1Pybhc" to="810k:6gCHjbahfKM" resolve="Logger" />
                <node concept="Rm8GO" id="6gCHjbat2Cz" role="37wK5m">
                  <ref role="Rm8GQ" to="810k:6gCHjbahh9p" resolve="ERROR" />
                  <ref role="1Px2BO" to="810k:6gCHjbahgOI" resolve="LogLevel" />
                </node>
                <node concept="Xl_RD" id="6gCHjbasz$c" role="37wK5m">
                  <property role="Xl_RC" value="Error in StrManipulationConcatStepDefault: Columns must not be null" />
                </node>
              </node>
            </node>
            <node concept="YS8fn" id="4BP1ply_ojm" role="3cqZAp">
              <node concept="2ShNRf" id="4BP1ply_ojP" role="YScLw">
                <node concept="1pGfFk" id="4BP1ply_oOc" role="2ShVmc">
                  <property role="373rjd" value="true" />
                  <ref role="37wK5l" to="wyt6:~IllegalArgumentException.&lt;init&gt;(java.lang.String)" resolve="IllegalArgumentException" />
                  <node concept="Xl_RD" id="4BP1ply_oUB" role="37wK5m">
                    <property role="Xl_RC" value="Columns must not be null." />
                  </node>
                </node>
              </node>
            </node>
          </node>
          <node concept="22lmx$" id="4BP1ply_nTJ" role="3clFbw">
            <node concept="3clFbC" id="4BP1ply_o8B" role="3uHU7w">
              <node concept="10Nm6u" id="4BP1ply_ofm" role="3uHU7w" />
              <node concept="37vLTw" id="4BP1ply_nY4" role="3uHU7B">
                <ref role="3cqZAo" node="4BP1ply_mWm" resolve="resultColumn" />
              </node>
            </node>
            <node concept="22lmx$" id="4BP1ply_nJm" role="3uHU7B">
              <node concept="3clFbC" id="4BP1ply_nFO" role="3uHU7B">
                <node concept="37vLTw" id="4BP1ply_nxR" role="3uHU7B">
                  <ref role="3cqZAo" node="4BP1ply_lZ2" resolve="columnA" />
                </node>
                <node concept="10Nm6u" id="4BP1ply_nGr" role="3uHU7w" />
              </node>
              <node concept="3clFbC" id="4BP1ply_nPU" role="3uHU7w">
                <node concept="37vLTw" id="4BP1ply_nMO" role="3uHU7B">
                  <ref role="3cqZAo" node="4BP1ply_lZ4" resolve="columnB" />
                </node>
                <node concept="10Nm6u" id="4BP1ply_nQx" role="3uHU7w" />
              </node>
            </node>
          </node>
        </node>
        <node concept="3clFbH" id="4BP1ply_pDd" role="3cqZAp" />
        <node concept="3cpWs8" id="4BP1ply_pHh" role="3cqZAp">
          <node concept="3cpWsn" id="4BP1ply_pHn" role="3cpWs9">
            <property role="TrG5h" value="resultColumns" />
            <node concept="3uibUv" id="4BP1ply_pHp" role="1tU5fm">
              <ref role="3uigEE" to="33ny:~List" resolve="List" />
              <node concept="3uibUv" id="4BP1ply_pLj" role="11_B2D">
                <ref role="3uigEE" to="6a2z:cd93YdJHTQ" resolve="Column" />
              </node>
            </node>
            <node concept="2ShNRf" id="4BP1ply_q68" role="33vP2m">
              <node concept="1pGfFk" id="4BP1ply_qnD" role="2ShVmc">
                <property role="373rjd" value="true" />
                <ref role="37wK5l" to="33ny:~ArrayList.&lt;init&gt;(java.util.Collection)" resolve="ArrayList" />
                <node concept="2OqwBi" id="4BP1ply_qIL" role="37wK5m">
                  <node concept="37vLTw" id="4BP1ply_qvb" role="2Oq$k0">
                    <ref role="3cqZAo" node="4BP1ply_lZ0" resolve="inputTable" />
                  </node>
                  <node concept="liA8E" id="4BP1ply_qVg" role="2OqNvi">
                    <ref role="37wK5l" to="6a2z:cd93YdP6bz" resolve="getColumnList" />
                  </node>
                </node>
                <node concept="3uibUv" id="4BP1ply_rmH" role="1pMfVU">
                  <ref role="3uigEE" to="6a2z:cd93YdJHTQ" resolve="Column" />
                </node>
              </node>
            </node>
          </node>
        </node>
        <node concept="3clFbF" id="4BP1ply_rXR" role="3cqZAp">
          <node concept="2OqwBi" id="4BP1ply_tnw" role="3clFbG">
            <node concept="37vLTw" id="4BP1ply_rXP" role="2Oq$k0">
              <ref role="3cqZAo" node="4BP1ply_pHn" resolve="resultColumns" />
            </node>
            <node concept="liA8E" id="4BP1ply_uzx" role="2OqNvi">
              <ref role="37wK5l" to="33ny:~List.add(java.lang.Object)" resolve="add" />
              <node concept="37vLTw" id="4BP1ply_v0a" role="37wK5m">
                <ref role="3cqZAo" node="4BP1ply_mWm" resolve="resultColumn" />
              </node>
            </node>
          </node>
        </node>
        <node concept="3clFbH" id="4BP1ply_vvE" role="3cqZAp" />
        <node concept="3cpWs8" id="4BP1ply_w8T" role="3cqZAp">
          <node concept="3cpWsn" id="4BP1ply_w8Z" role="3cpWs9">
            <property role="TrG5h" value="resultColumnInfo" />
            <node concept="3uibUv" id="4BP1ply_w91" role="1tU5fm">
              <ref role="3uigEE" to="33ny:~Map" resolve="Map" />
              <node concept="3uibUv" id="4BP1ply_woy" role="11_B2D">
                <ref role="3uigEE" to="6a2z:cd93YdJHTQ" resolve="Column" />
              </node>
              <node concept="3uibUv" id="4BP1ply_wLz" role="11_B2D">
                <ref role="3uigEE" to="33ny:~Map" resolve="Map" />
                <node concept="3uibUv" id="4BP1ply_wYm" role="11_B2D">
                  <ref role="3uigEE" to="wyt6:~Integer" resolve="Integer" />
                </node>
                <node concept="3uibUv" id="4BP1ply_xbC" role="11_B2D">
                  <ref role="3uigEE" to="wyt6:~Object" resolve="Object" />
                </node>
              </node>
            </node>
            <node concept="2ShNRf" id="4BP1ply_yo4" role="33vP2m">
              <node concept="1pGfFk" id="4BP1ply_yNd" role="2ShVmc">
                <property role="373rjd" value="true" />
                <ref role="37wK5l" to="33ny:~HashMap.&lt;init&gt;()" resolve="HashMap" />
              </node>
            </node>
          </node>
        </node>
        <node concept="1DcWWT" id="4BP1ply_zok" role="3cqZAp">
          <node concept="3clFbS" id="4BP1ply_zom" role="2LFqv$">
            <node concept="3clFbF" id="4BP1ply__uB" role="3cqZAp">
              <node concept="2OqwBi" id="4BP1ply_B5m" role="3clFbG">
                <node concept="37vLTw" id="4BP1ply__u_" role="2Oq$k0">
                  <ref role="3cqZAo" node="4BP1ply_w8Z" resolve="resultColumnInfo" />
                </node>
                <node concept="liA8E" id="4BP1ply_CTG" role="2OqNvi">
                  <ref role="37wK5l" to="33ny:~Map.put(java.lang.Object,java.lang.Object)" resolve="put" />
                  <node concept="37vLTw" id="4BP1ply_DRB" role="37wK5m">
                    <ref role="3cqZAo" node="4BP1ply_zon" resolve="col" />
                  </node>
                  <node concept="2ShNRf" id="4BP1ply_Gru" role="37wK5m">
                    <node concept="1pGfFk" id="4BP1ply_H_a" role="2ShVmc">
                      <property role="373rjd" value="true" />
                      <ref role="37wK5l" to="33ny:~HashMap.&lt;init&gt;()" resolve="HashMap" />
                    </node>
                  </node>
                </node>
              </node>
            </node>
          </node>
          <node concept="3cpWsn" id="4BP1ply_zon" role="1Duv9x">
            <property role="TrG5h" value="col" />
            <node concept="3uibUv" id="4BP1ply_zTt" role="1tU5fm">
              <ref role="3uigEE" to="6a2z:cd93YdJHTQ" resolve="Column" />
            </node>
          </node>
          <node concept="37vLTw" id="4BP1ply_$Gm" role="1DdaDG">
            <ref role="3cqZAo" node="4BP1ply_pHn" resolve="resultColumns" />
          </node>
        </node>
        <node concept="3clFbH" id="4BP1ply_IKi" role="3cqZAp" />
        <node concept="1Dw8fO" id="4BP1ply_K10" role="3cqZAp">
          <node concept="3clFbS" id="4BP1ply_K12" role="2LFqv$">
            <node concept="1DcWWT" id="4BP1plyA47d" role="3cqZAp">
              <node concept="3clFbS" id="4BP1plyA47f" role="2LFqv$">
                <node concept="3clFbF" id="4BP1plyAba8" role="3cqZAp">
                  <node concept="2OqwBi" id="4BP1plyAk$L" role="3clFbG">
                    <node concept="2OqwBi" id="4BP1plyAdrr" role="2Oq$k0">
                      <node concept="37vLTw" id="4BP1plyAba6" role="2Oq$k0">
                        <ref role="3cqZAo" node="4BP1ply_w8Z" resolve="resultColumnInfo" />
                      </node>
                      <node concept="liA8E" id="4BP1plyAfHn" role="2OqNvi">
                        <ref role="37wK5l" to="33ny:~Map.get(java.lang.Object)" resolve="get" />
                        <node concept="37vLTw" id="4BP1plyAhVk" role="37wK5m">
                          <ref role="3cqZAo" node="4BP1plyA47g" resolve="col" />
                        </node>
                      </node>
                    </node>
                    <node concept="liA8E" id="4BP1plyAn8Y" role="2OqNvi">
                      <ref role="37wK5l" to="33ny:~Map.put(java.lang.Object,java.lang.Object)" resolve="put" />
                      <node concept="37vLTw" id="4BP1plyAoSv" role="37wK5m">
                        <ref role="3cqZAo" node="4BP1ply_K13" resolve="i" />
                      </node>
                      <node concept="2OqwBi" id="4BP1plyAGAK" role="37wK5m">
                        <node concept="2OqwBi" id="4BP1plyA$pm" role="2Oq$k0">
                          <node concept="2OqwBi" id="4BP1plyAwLV" role="2Oq$k0">
                            <node concept="37vLTw" id="4BP1plyAuMZ" role="2Oq$k0">
                              <ref role="3cqZAo" node="4BP1ply_lZ0" resolve="inputTable" />
                            </node>
                            <node concept="liA8E" id="4BP1plyAywL" role="2OqNvi">
                              <ref role="37wK5l" to="6a2z:cd93YdQ8ZE" resolve="getColumnInfo" />
                            </node>
                          </node>
                          <node concept="liA8E" id="4BP1plyAB1o" role="2OqNvi">
                            <ref role="37wK5l" to="33ny:~Map.get(java.lang.Object)" resolve="get" />
                            <node concept="37vLTw" id="4BP1plyADYL" role="37wK5m">
                              <ref role="3cqZAo" node="4BP1plyA47g" resolve="col" />
                            </node>
                          </node>
                        </node>
                        <node concept="liA8E" id="4BP1plyAJmM" role="2OqNvi">
                          <ref role="37wK5l" to="33ny:~Map.get(java.lang.Object)" resolve="get" />
                          <node concept="37vLTw" id="4BP1plyALgK" role="37wK5m">
                            <ref role="3cqZAo" node="4BP1ply_K13" resolve="i" />
                          </node>
                        </node>
                      </node>
                    </node>
                  </node>
                </node>
              </node>
              <node concept="3cpWsn" id="4BP1plyA47g" role="1Duv9x">
                <property role="TrG5h" value="col" />
                <node concept="3uibUv" id="4BP1plyA51I" role="1tU5fm">
                  <ref role="3uigEE" to="6a2z:cd93YdJHTQ" resolve="Column" />
                </node>
              </node>
              <node concept="2OqwBi" id="4BP1plyA8yK" role="1DdaDG">
                <node concept="37vLTw" id="4BP1plyA6Qw" role="2Oq$k0">
                  <ref role="3cqZAo" node="4BP1ply_lZ0" resolve="inputTable" />
                </node>
                <node concept="liA8E" id="4BP1plyA9JZ" role="2OqNvi">
                  <ref role="37wK5l" to="6a2z:cd93YdP6bz" resolve="getColumnList" />
                </node>
              </node>
            </node>
            <node concept="3clFbH" id="4BP1plyAUo5" role="3cqZAp" />
            <node concept="3cpWs8" id="4BP1plyAYPl" role="3cqZAp">
              <node concept="3cpWsn" id="4BP1plyAYPm" role="3cpWs9">
                <property role="TrG5h" value="valueA" />
                <node concept="3uibUv" id="4BP1plyAYPn" role="1tU5fm">
                  <ref role="3uigEE" to="wyt6:~String" resolve="String" />
                </node>
                <node concept="10QFUN" id="4BP1plyBtnU" role="33vP2m">
                  <node concept="3uibUv" id="4BP1plyBwIQ" role="10QFUM">
                    <ref role="3uigEE" to="wyt6:~String" resolve="String" />
                  </node>
                  <node concept="2OqwBi" id="4BP1plyBk74" role="10QFUP">
                    <node concept="2OqwBi" id="4BP1plyBbmK" role="2Oq$k0">
                      <node concept="2OqwBi" id="4BP1plyB79P" role="2Oq$k0">
                        <node concept="37vLTw" id="4BP1plyB5mJ" role="2Oq$k0">
                          <ref role="3cqZAo" node="4BP1ply_lZ0" resolve="inputTable" />
                        </node>
                        <node concept="liA8E" id="4BP1plyB9hz" role="2OqNvi">
                          <ref role="37wK5l" to="6a2z:cd93YdQ8ZE" resolve="getColumnInfo" />
                        </node>
                      </node>
                      <node concept="liA8E" id="4BP1plyBfmz" role="2OqNvi">
                        <ref role="37wK5l" to="33ny:~Map.get(java.lang.Object)" resolve="get" />
                        <node concept="37vLTw" id="4BP1plyBh_7" role="37wK5m">
                          <ref role="3cqZAo" node="4BP1ply_lZ2" resolve="columnA" />
                        </node>
                      </node>
                    </node>
                    <node concept="liA8E" id="4BP1plyBmUc" role="2OqNvi">
                      <ref role="37wK5l" to="33ny:~Map.get(java.lang.Object)" resolve="get" />
                      <node concept="37vLTw" id="4BP1plyBqgt" role="37wK5m">
                        <ref role="3cqZAo" node="4BP1ply_K13" resolve="i" />
                      </node>
                    </node>
                  </node>
                </node>
              </node>
            </node>
            <node concept="3cpWs8" id="4BP1plyBz2q" role="3cqZAp">
              <node concept="3cpWsn" id="4BP1plyBz2r" role="3cpWs9">
                <property role="TrG5h" value="valueB" />
                <node concept="3uibUv" id="4BP1plyBz2s" role="1tU5fm">
                  <ref role="3uigEE" to="wyt6:~String" resolve="String" />
                </node>
                <node concept="10QFUN" id="4BP1plyBz2t" role="33vP2m">
                  <node concept="3uibUv" id="4BP1plyBz2u" role="10QFUM">
                    <ref role="3uigEE" to="wyt6:~String" resolve="String" />
                  </node>
                  <node concept="2OqwBi" id="4BP1plyBz2v" role="10QFUP">
                    <node concept="2OqwBi" id="4BP1plyBz2w" role="2Oq$k0">
                      <node concept="2OqwBi" id="4BP1plyBz2x" role="2Oq$k0">
                        <node concept="37vLTw" id="4BP1plyBz2y" role="2Oq$k0">
                          <ref role="3cqZAo" node="4BP1ply_lZ0" resolve="inputTable" />
                        </node>
                        <node concept="liA8E" id="4BP1plyBz2z" role="2OqNvi">
                          <ref role="37wK5l" to="6a2z:cd93YdQ8ZE" resolve="getColumnInfo" />
                        </node>
                      </node>
                      <node concept="liA8E" id="4BP1plyBz2$" role="2OqNvi">
                        <ref role="37wK5l" to="33ny:~Map.get(java.lang.Object)" resolve="get" />
                        <node concept="37vLTw" id="4BP1plyBz2_" role="37wK5m">
                          <ref role="3cqZAo" node="4BP1ply_lZ4" resolve="columnB" />
                        </node>
                      </node>
                    </node>
                    <node concept="liA8E" id="4BP1plyBz2A" role="2OqNvi">
                      <ref role="37wK5l" to="33ny:~Map.get(java.lang.Object)" resolve="get" />
                      <node concept="37vLTw" id="4BP1plyBz2B" role="37wK5m">
                        <ref role="3cqZAo" node="4BP1ply_K13" resolve="i" />
                      </node>
                    </node>
                  </node>
                </node>
              </node>
            </node>
            <node concept="3clFbH" id="4BP1plyBFpK" role="3cqZAp" />
            <node concept="3cpWs8" id="4BP1plyBMzV" role="3cqZAp">
              <node concept="3cpWsn" id="4BP1plyBMzW" role="3cpWs9">
                <property role="TrG5h" value="concatenatedValue" />
                <node concept="3uibUv" id="4BP1plyBMzX" role="1tU5fm">
                  <ref role="3uigEE" to="wyt6:~String" resolve="String" />
                </node>
              </node>
            </node>
            <node concept="3clFbJ" id="4BP1plyBXz7" role="3cqZAp">
              <node concept="3clFbS" id="4BP1plyBXz9" role="3clFbx">
                <node concept="3clFbF" id="4BP1plyClmC" role="3cqZAp">
                  <node concept="37vLTI" id="4BP1plyCqTw" role="3clFbG">
                    <node concept="10Nm6u" id="4BP1plyCtgA" role="37vLTx" />
                    <node concept="37vLTw" id="4BP1plyClmA" role="37vLTJ">
                      <ref role="3cqZAo" node="4BP1plyBMzW" resolve="concatenatedValue" />
                    </node>
                  </node>
                </node>
              </node>
              <node concept="1Wc70l" id="4BP1plyC9X5" role="3clFbw">
                <node concept="3clFbC" id="4BP1plyCfeQ" role="3uHU7w">
                  <node concept="10Nm6u" id="4BP1plyCjjA" role="3uHU7w" />
                  <node concept="37vLTw" id="4BP1plyCc0z" role="3uHU7B">
                    <ref role="3cqZAo" node="4BP1plyBz2r" resolve="valueB" />
                  </node>
                </node>
                <node concept="3clFbC" id="4BP1plyC3vU" role="3uHU7B">
                  <node concept="37vLTw" id="4BP1plyC0nV" role="3uHU7B">
                    <ref role="3cqZAo" node="4BP1plyAYPm" resolve="valueA" />
                  </node>
                  <node concept="10Nm6u" id="4BP1plyC7AS" role="3uHU7w" />
                </node>
              </node>
              <node concept="3eNFk2" id="4BP1plyCvjy" role="3eNLev">
                <node concept="3clFbC" id="4BP1plyCEtN" role="3eO9$A">
                  <node concept="10Nm6u" id="4BP1plyCHh0" role="3uHU7w" />
                  <node concept="37vLTw" id="4BP1plyCxnd" role="3uHU7B">
                    <ref role="3cqZAo" node="4BP1plyAYPm" resolve="valueA" />
                  </node>
                </node>
                <node concept="3clFbS" id="4BP1plyCvj$" role="3eOfB_">
                  <node concept="3clFbF" id="4BP1plyCKAX" role="3cqZAp">
                    <node concept="37vLTI" id="4BP1plyCUtI" role="3clFbG">
                      <node concept="37vLTw" id="4BP1plyCWxY" role="37vLTx">
                        <ref role="3cqZAo" node="4BP1plyBz2r" resolve="valueB" />
                      </node>
                      <node concept="37vLTw" id="4BP1plyCKAW" role="37vLTJ">
                        <ref role="3cqZAo" node="4BP1plyBMzW" resolve="concatenatedValue" />
                      </node>
                    </node>
                  </node>
                </node>
              </node>
              <node concept="3eNFk2" id="4BP1plyCY_7" role="3eNLev">
                <node concept="3clFbC" id="4BP1plyD54w" role="3eO9$A">
                  <node concept="10Nm6u" id="4BP1plyD8RP" role="3uHU7w" />
                  <node concept="37vLTw" id="4BP1plyD1VC" role="3uHU7B">
                    <ref role="3cqZAo" node="4BP1plyBz2r" resolve="valueB" />
                  </node>
                </node>
                <node concept="3clFbS" id="4BP1plyCY_9" role="3eOfB_">
                  <node concept="3clFbF" id="4BP1plyDbdA" role="3cqZAp">
                    <node concept="37vLTI" id="4BP1plyDemG" role="3clFbG">
                      <node concept="37vLTw" id="4BP1plyDnao" role="37vLTx">
                        <ref role="3cqZAo" node="4BP1plyAYPm" resolve="valueA" />
                      </node>
                      <node concept="37vLTw" id="4BP1plyDbd_" role="37vLTJ">
                        <ref role="3cqZAo" node="4BP1plyBMzW" resolve="concatenatedValue" />
                      </node>
                    </node>
                  </node>
                </node>
              </node>
              <node concept="9aQIb" id="4BP1plyDA2K" role="9aQIa">
                <node concept="3clFbS" id="4BP1plyDA2L" role="9aQI4">
                  <node concept="3clFbF" id="4BP1plyDDpi" role="3cqZAp">
                    <node concept="37vLTI" id="4BP1plyDGy$" role="3clFbG">
                      <node concept="3cpWs3" id="4BP1plyDN39" role="37vLTx">
                        <node concept="37vLTw" id="4BP1plyDPno" role="3uHU7w">
                          <ref role="3cqZAo" node="4BP1plyBz2r" resolve="valueB" />
                        </node>
                        <node concept="37vLTw" id="4BP1plyDIBe" role="3uHU7B">
                          <ref role="3cqZAo" node="4BP1plyAYPm" resolve="valueA" />
                        </node>
                      </node>
                      <node concept="37vLTw" id="4BP1plyDDph" role="37vLTJ">
                        <ref role="3cqZAo" node="4BP1plyBMzW" resolve="concatenatedValue" />
                      </node>
                    </node>
                  </node>
                </node>
              </node>
            </node>
            <node concept="3clFbH" id="4BP1plyDRKR" role="3cqZAp" />
            <node concept="3clFbF" id="4BP1plyDWgh" role="3cqZAp">
              <node concept="2OqwBi" id="4BP1plyEbmV" role="3clFbG">
                <node concept="2OqwBi" id="4BP1plyE0J7" role="2Oq$k0">
                  <node concept="37vLTw" id="4BP1plyDWgf" role="2Oq$k0">
                    <ref role="3cqZAo" node="4BP1ply_w8Z" resolve="resultColumnInfo" />
                  </node>
                  <node concept="liA8E" id="4BP1plyE4nj" role="2OqNvi">
                    <ref role="37wK5l" to="33ny:~Map.get(java.lang.Object)" resolve="get" />
                    <node concept="37vLTw" id="4BP1plyE7AC" role="37wK5m">
                      <ref role="3cqZAo" node="4BP1ply_mWm" resolve="resultColumn" />
                    </node>
                  </node>
                </node>
                <node concept="liA8E" id="4BP1plyEeAN" role="2OqNvi">
                  <ref role="37wK5l" to="33ny:~Map.put(java.lang.Object,java.lang.Object)" resolve="put" />
                  <node concept="37vLTw" id="4BP1plyEiuc" role="37wK5m">
                    <ref role="3cqZAo" node="4BP1ply_K13" resolve="i" />
                  </node>
                  <node concept="37vLTw" id="4BP1plyEp2E" role="37wK5m">
                    <ref role="3cqZAo" node="4BP1plyBMzW" resolve="concatenatedValue" />
                  </node>
                </node>
              </node>
            </node>
          </node>
          <node concept="3cpWsn" id="4BP1ply_K13" role="1Duv9x">
            <property role="TrG5h" value="i" />
            <node concept="10Oyi0" id="4BP1ply_L1R" role="1tU5fm" />
            <node concept="3cmrfG" id="4BP1ply_MNo" role="33vP2m">
              <property role="3cmrfH" value="1" />
            </node>
          </node>
          <node concept="2dkUwp" id="4BP1ply_VmI" role="1Dwp0S">
            <node concept="2OqwBi" id="4BP1ply_XKU" role="3uHU7w">
              <node concept="37vLTw" id="4BP1ply_WfW" role="2Oq$k0">
                <ref role="3cqZAo" node="4BP1ply_lZ0" resolve="inputTable" />
              </node>
              <node concept="liA8E" id="4BP1ply_YPh" role="2OqNvi">
                <ref role="37wK5l" to="6a2z:cd93YdR6a9" resolve="getNumLines" />
              </node>
            </node>
            <node concept="37vLTw" id="4BP1ply_NGq" role="3uHU7B">
              <ref role="3cqZAo" node="4BP1ply_K13" resolve="i" />
            </node>
          </node>
          <node concept="3uNrnE" id="4BP1plyA2zo" role="1Dwrff">
            <node concept="37vLTw" id="4BP1plyA2zq" role="2$L3a6">
              <ref role="3cqZAo" node="4BP1ply_K13" resolve="i" />
            </node>
          </node>
        </node>
        <node concept="3clFbH" id="4BP1plyEsgP" role="3cqZAp" />
        <node concept="3clFbF" id="4BP1plyExeF" role="3cqZAp">
          <node concept="37vLTI" id="4BP1plyE$FV" role="3clFbG">
            <node concept="2ShNRf" id="4BP1plyECNO" role="37vLTx">
              <node concept="1pGfFk" id="4BP1plyEFeY" role="2ShVmc">
                <property role="373rjd" value="true" />
                <ref role="37wK5l" to="6a2z:cd93YdORmc" resolve="Table" />
                <node concept="37vLTw" id="4BP1plyEJlx" role="37wK5m">
                  <ref role="3cqZAo" node="4BP1ply_pHn" resolve="resultColumns" />
                </node>
                <node concept="2OqwBi" id="4BP1plyERYc" role="37wK5m">
                  <node concept="37vLTw" id="4BP1plyENM1" role="2Oq$k0">
                    <ref role="3cqZAo" node="4BP1ply_lZ0" resolve="inputTable" />
                  </node>
                  <node concept="liA8E" id="4BP1plyEUXg" role="2OqNvi">
                    <ref role="37wK5l" to="6a2z:cd93YdP4PB" resolve="getName" />
                  </node>
                </node>
              </node>
            </node>
            <node concept="37vLTw" id="4BP1plyExeD" role="37vLTJ">
              <ref role="3cqZAo" node="4BP1ply_m7K" resolve="resultTable" />
            </node>
          </node>
        </node>
        <node concept="1DcWWT" id="4BP1plyF0xz" role="3cqZAp">
          <node concept="3clFbS" id="4BP1plyF0x_" role="2LFqv$">
            <node concept="3clFbF" id="4BP1plyFOvz" role="3cqZAp">
              <node concept="2OqwBi" id="4BP1plyG12t" role="3clFbG">
                <node concept="2OqwBi" id="4BP1plyFRyb" role="2Oq$k0">
                  <node concept="37vLTw" id="4BP1plyFOvx" role="2Oq$k0">
                    <ref role="3cqZAo" node="4BP1ply_m7K" resolve="resultTable" />
                  </node>
                  <node concept="liA8E" id="4BP1plyFVi1" role="2OqNvi">
                    <ref role="37wK5l" to="6a2z:cd93YdQ8ZE" resolve="getColumnInfo" />
                  </node>
                </node>
                <node concept="liA8E" id="4BP1plyG4X_" role="2OqNvi">
                  <ref role="37wK5l" to="33ny:~Map.put(java.lang.Object,java.lang.Object)" resolve="put" />
                  <node concept="2OqwBi" id="4BP1plyGdEu" role="37wK5m">
                    <node concept="37vLTw" id="4BP1plyG87y" role="2Oq$k0">
                      <ref role="3cqZAo" node="4BP1plyF0xA" resolve="entry" />
                    </node>
                    <node concept="liA8E" id="4BP1plyGh5p" role="2OqNvi">
                      <ref role="37wK5l" to="33ny:~Map$Entry.getKey()" resolve="getKey" />
                    </node>
                  </node>
                  <node concept="2OqwBi" id="4BP1plyGpU1" role="37wK5m">
                    <node concept="37vLTw" id="4BP1plyGlAb" role="2Oq$k0">
                      <ref role="3cqZAo" node="4BP1plyF0xA" resolve="entry" />
                    </node>
                    <node concept="liA8E" id="4BP1plyGu7j" role="2OqNvi">
                      <ref role="37wK5l" to="33ny:~Map$Entry.getValue()" resolve="getValue" />
                    </node>
                  </node>
                </node>
              </node>
            </node>
          </node>
          <node concept="3cpWsn" id="4BP1plyF0xA" role="1Duv9x">
            <property role="TrG5h" value="entry" />
            <node concept="3uibUv" id="4BP1plyF5KH" role="1tU5fm">
              <ref role="3uigEE" to="33ny:~Map$Entry" resolve="Entry" />
              <node concept="3uibUv" id="4BP1plyFc8g" role="11_B2D">
                <ref role="3uigEE" to="6a2z:cd93YdJHTQ" resolve="Column" />
              </node>
              <node concept="3uibUv" id="4BP1plyFgAv" role="11_B2D">
                <ref role="3uigEE" to="33ny:~Map" resolve="Map" />
                <node concept="3uibUv" id="4BP1plyFkIw" role="11_B2D">
                  <ref role="3uigEE" to="wyt6:~Integer" resolve="Integer" />
                </node>
                <node concept="3uibUv" id="4BP1plyFmwc" role="11_B2D">
                  <ref role="3uigEE" to="wyt6:~Object" resolve="Object" />
                </node>
              </node>
            </node>
          </node>
          <node concept="2OqwBi" id="4BP1plyF$AH" role="1DdaDG">
            <node concept="37vLTw" id="4BP1plyFxok" role="2Oq$k0">
              <ref role="3cqZAo" node="4BP1ply_w8Z" resolve="resultColumnInfo" />
            </node>
            <node concept="liA8E" id="4BP1plyFDBd" role="2OqNvi">
              <ref role="37wK5l" to="33ny:~Map.entrySet()" resolve="entrySet" />
            </node>
          </node>
        </node>
        <node concept="3clFbH" id="6gCHjbatzxr" role="3cqZAp" />
        <node concept="3clFbF" id="6gCHjbator6" role="3cqZAp">
          <node concept="2YIFZM" id="6gCHjbator7" role="3clFbG">
            <ref role="37wK5l" to="810k:6gCHjbahhRx" resolve="log" />
            <ref role="1Pybhc" to="810k:6gCHjbahfKM" resolve="Logger" />
            <node concept="Rm8GO" id="6gCHjbatC6y" role="37wK5m">
              <ref role="Rm8GQ" to="810k:6gCHjbahhiU" resolve="INFO" />
              <ref role="1Px2BO" to="810k:6gCHjbahgOI" resolve="LogLevel" />
            </node>
            <node concept="Xl_RD" id="6gCHjbator9" role="37wK5m">
              <property role="Xl_RC" value="StrManipulationConcatStepDefault success." />
            </node>
          </node>
        </node>
        <node concept="3cpWs6" id="4BP1plyGGi7" role="3cqZAp">
          <node concept="37vLTw" id="4BP1plyGUtW" role="3cqZAk">
            <ref role="3cqZAo" node="4BP1ply_m7K" resolve="resultTable" />
          </node>
        </node>
      </node>
      <node concept="2AHcQZ" id="4BP1ply_lZb" role="2AJF6D">
        <ref role="2AI5Lk" to="wyt6:~Override" />
      </node>
    </node>
  </node>
  <node concept="bUwia" id="cd93YdZi2Q">
    <property role="TrG5h" value="main" />
    <node concept="3lhOvk" id="cd93YdZi4V" role="3lj3bC">
      <ref role="30HIoZ" to="y20r:35hB$8kwehL" resolve="StrManipulationConcat" />
      <ref role="3lhOvi" node="4BP1ply_kL5" resolve="StrManipulationConcatStepDefault" />
    </node>
    <node concept="3lhOvk" id="cd93YdZi4W" role="3lj3bC">
      <ref role="30HIoZ" to="y20r:35hB$8kwehL" resolve="StrManipulationConcat" />
      <ref role="3lhOvi" node="4BP1ply_kKr" resolve="FactoryStrManipulationConcatStep" />
    </node>
    <node concept="3lhOvk" id="cd93YdZi4X" role="3lj3bC">
      <ref role="30HIoZ" to="y20r:35hB$8kwehL" resolve="StrManipulationConcat" />
      <ref role="3lhOvi" node="4BP1ply_kKO" resolve="IStrManipulationConcatStep" />
    </node>
  </node>
</model>

