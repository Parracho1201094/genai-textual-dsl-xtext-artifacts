<?xml version="1.0" encoding="UTF-8"?>
<model ref="r:efcec103-84b2-480a-91c5-bcd3ff0ec3cb(ltsdsl.generator.steps.filter@generator)">
  <persistence version="9" />
  <languages>
    <devkit ref="a2eb3a43-fcc2-4200-80dc-c60110c4862d(jetbrains.mps.devkit.templates)" />
  </languages>
  <imports>
    <import index="y20r" ref="r:85f52e46-7a19-44f9-bf10-6677b89edd73(ltsdsl.structure)" />
    <import index="33ny" ref="6354ebe7-c22a-4a0f-ac54-50b52ab9b065/java:java.util(JDK/)" />
    <import index="28m1" ref="6354ebe7-c22a-4a0f-ac54-50b52ab9b065/java:java.time(JDK/)" />
    <import index="6a2z" ref="r:1c985b49-e2d4-4b0a-ac27-a43894ccaff0(ltsdsl.generator.tables@generator)" />
    <import index="4z85" ref="r:f197530d-51ad-4216-956c-2f6cb0c55a22(ltsdsl.generator.enums@generator)" />
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
      <concept id="1153417849900" name="jetbrains.mps.baseLanguage.structure.GreaterThanOrEqualsExpression" flags="nn" index="2d3UOw" />
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
      <concept id="1081256982272" name="jetbrains.mps.baseLanguage.structure.InstanceOfExpression" flags="nn" index="2ZW3vV">
        <child id="1081256993305" name="classType" index="2ZW6by" />
        <child id="1081256993304" name="leftExpression" index="2ZW6bz" />
      </concept>
      <concept id="1070534370425" name="jetbrains.mps.baseLanguage.structure.IntegerType" flags="in" index="10Oyi0" />
      <concept id="1070534513062" name="jetbrains.mps.baseLanguage.structure.DoubleType" flags="in" index="10P55v" />
      <concept id="1070534644030" name="jetbrains.mps.baseLanguage.structure.BooleanType" flags="in" index="10P_77" />
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
      <concept id="1079359253375" name="jetbrains.mps.baseLanguage.structure.ParenthesizedExpression" flags="nn" index="1eOMI4">
        <child id="1079359253376" name="expression" index="1eOMHV" />
      </concept>
      <concept id="1081506762703" name="jetbrains.mps.baseLanguage.structure.GreaterThanExpression" flags="nn" index="3eOSWO" />
      <concept id="1081506773034" name="jetbrains.mps.baseLanguage.structure.LessThanExpression" flags="nn" index="3eOVzh" />
      <concept id="1081516740877" name="jetbrains.mps.baseLanguage.structure.NotExpression" flags="nn" index="3fqX7Q">
        <child id="1081516765348" name="expression" index="3fr31v" />
      </concept>
      <concept id="1204053956946" name="jetbrains.mps.baseLanguage.structure.IMethodCall" flags="ngI" index="1ndlxa">
        <reference id="1068499141037" name="baseMethodDeclaration" index="37wK5l" />
        <child id="1068499141038" name="actualArgument" index="37wK5m" />
      </concept>
      <concept id="1212685548494" name="jetbrains.mps.baseLanguage.structure.ClassCreator" flags="nn" index="1pGfFk" />
      <concept id="1107461130800" name="jetbrains.mps.baseLanguage.structure.Classifier" flags="ng" index="3pOWGL">
        <property id="2791683072064593257" name="packageName" index="2HnT6v" />
        <child id="5375687026011219971" name="member" index="jymVt" unordered="true" />
      </concept>
      <concept id="7812454656619025412" name="jetbrains.mps.baseLanguage.structure.LocalMethodCall" flags="nn" index="1rXfSq" />
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
      <concept id="1082113931046" name="jetbrains.mps.baseLanguage.structure.ContinueStatement" flags="nn" index="3N13vt" />
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
  <node concept="312cEu" id="cd93Ye2YNp">
    <property role="TrG5h" value="FilterStepDefault" />
    <property role="2HnT6v" value="program.src.main.java.org.enorm.domain.steps.filterStep" />
    <node concept="3Tm1VV" id="cd93Ye2YNq" role="1B3o_S" />
    <node concept="n94m4" id="cd93Ye2YNr" role="lGtFl" />
    <node concept="3uibUv" id="cd93Ye3le8" role="EKbjA">
      <ref role="3uigEE" node="cd93Ye2YOb" resolve="IFilterStep" />
    </node>
    <node concept="3clFb_" id="cd93Ye3leC" role="jymVt">
      <property role="TrG5h" value="apply" />
      <node concept="3Tm1VV" id="cd93Ye3leE" role="1B3o_S" />
      <node concept="3uibUv" id="cd93Ye3leF" role="3clF45">
        <ref role="3uigEE" to="6a2z:cd93YdJHRJ" resolve="Table" />
      </node>
      <node concept="37vLTG" id="cd93Ye3leG" role="3clF46">
        <property role="TrG5h" value="inputTable" />
        <node concept="3uibUv" id="cd93Ye3leH" role="1tU5fm">
          <ref role="3uigEE" to="6a2z:cd93YdJHRJ" resolve="Table" />
        </node>
      </node>
      <node concept="37vLTG" id="cd93Ye3leI" role="3clF46">
        <property role="TrG5h" value="targetColumn" />
        <node concept="3uibUv" id="cd93Ye3leJ" role="1tU5fm">
          <ref role="3uigEE" to="6a2z:cd93YdJHTQ" resolve="Column" />
        </node>
      </node>
      <node concept="37vLTG" id="cd93Ye3leK" role="3clF46">
        <property role="TrG5h" value="operand" />
        <node concept="3uibUv" id="cd93Ye3leL" role="1tU5fm">
          <ref role="3uigEE" to="wyt6:~Object" resolve="Object" />
        </node>
      </node>
      <node concept="37vLTG" id="cd93Ye3leM" role="3clF46">
        <property role="TrG5h" value="operator" />
        <node concept="3uibUv" id="cd93Ye3leN" role="1tU5fm">
          <ref role="3uigEE" to="4z85:cd93Ye3jBJ" resolve="FilterOperatorType" />
        </node>
      </node>
      <node concept="37vLTG" id="cd93Ye3leO" role="3clF46">
        <property role="TrG5h" value="factoryTable" />
        <node concept="3uibUv" id="cd93Ye3leP" role="1tU5fm">
          <ref role="3uigEE" to="6a2z:cd93YdSsAK" resolve="FactoryTable" />
        </node>
      </node>
      <node concept="3clFbS" id="cd93Ye3leQ" role="3clF47">
        <node concept="3clFbH" id="cd93Ye3lki" role="3cqZAp" />
        <node concept="3cpWs8" id="cd93Ye3lp6" role="3cqZAp">
          <node concept="3cpWsn" id="cd93Ye3lp7" role="3cpWs9">
            <property role="TrG5h" value="resultTable" />
            <node concept="3uibUv" id="cd93Ye3lp8" role="1tU5fm">
              <ref role="3uigEE" to="6a2z:cd93YdJHRJ" resolve="Table" />
            </node>
            <node concept="2OqwBi" id="cd93Ye3lMW" role="33vP2m">
              <node concept="37vLTw" id="cd93Ye3lxo" role="2Oq$k0">
                <ref role="3cqZAo" node="cd93Ye3leO" resolve="factoryTable" />
              </node>
              <node concept="liA8E" id="cd93Ye3m3b" role="2OqNvi">
                <ref role="37wK5l" to="6a2z:cd93YdSsBC" resolve="generateTable" />
              </node>
            </node>
          </node>
        </node>
        <node concept="3cpWs8" id="cd93Ye3m84" role="3cqZAp">
          <node concept="3cpWsn" id="cd93Ye3m87" role="3cpWs9">
            <property role="TrG5h" value="newLineCounter" />
            <node concept="10Oyi0" id="cd93Ye3m82" role="1tU5fm" />
            <node concept="3cmrfG" id="cd93Ye3met" role="33vP2m">
              <property role="3cmrfH" value="1" />
            </node>
          </node>
        </node>
        <node concept="3clFbH" id="cd93Ye3mgz" role="3cqZAp" />
        <node concept="1Dw8fO" id="cd93Ye3p28" role="3cqZAp">
          <node concept="3clFbS" id="cd93Ye3p2a" role="2LFqv$">
            <node concept="3cpWs8" id="cd93Ye3wtI" role="3cqZAp">
              <node concept="3cpWsn" id="cd93Ye3wtJ" role="3cpWs9">
                <property role="TrG5h" value="lineInfo" />
                <node concept="3uibUv" id="cd93Ye3wtG" role="1tU5fm">
                  <ref role="3uigEE" to="33ny:~Map" resolve="Map" />
                  <node concept="3uibUv" id="cd93Ye3wwo" role="11_B2D">
                    <ref role="3uigEE" to="6a2z:cd93YdJHTQ" resolve="Column" />
                  </node>
                  <node concept="3uibUv" id="cd93Ye3w_N" role="11_B2D">
                    <ref role="3uigEE" to="wyt6:~Object" resolve="Object" />
                  </node>
                </node>
                <node concept="2OqwBi" id="cd93Ye3x1c" role="33vP2m">
                  <node concept="37vLTw" id="cd93Ye3wSh" role="2Oq$k0">
                    <ref role="3cqZAo" node="cd93Ye3leG" resolve="inputTable" />
                  </node>
                  <node concept="liA8E" id="cd93Ye3xh9" role="2OqNvi">
                    <ref role="37wK5l" to="6a2z:cd93YdQf6P" resolve="getLineInfo" />
                    <node concept="37vLTw" id="cd93Ye3xl_" role="37wK5m">
                      <ref role="3cqZAo" node="cd93Ye3p2b" resolve="lineIndex" />
                    </node>
                  </node>
                </node>
              </node>
            </node>
            <node concept="3clFbH" id="cd93Ye3xpR" role="3cqZAp" />
            <node concept="3clFbJ" id="cd93Ye3xux" role="3cqZAp">
              <node concept="3clFbS" id="cd93Ye3xuz" role="3clFbx">
                <node concept="3N13vt" id="cd93Ye588i" role="3cqZAp" />
              </node>
              <node concept="3fqX7Q" id="cd93Ye3xza" role="3clFbw">
                <node concept="1rXfSq" id="cd93Ye53Zx" role="3fr31v">
                  <ref role="37wK5l" node="cd93Ye3xTQ" resolve="itApplies" />
                  <node concept="2OqwBi" id="cd93Ye55uV" role="37wK5m">
                    <node concept="37vLTw" id="cd93Ye54K_" role="2Oq$k0">
                      <ref role="3cqZAo" node="cd93Ye3wtJ" resolve="lineInfo" />
                    </node>
                    <node concept="liA8E" id="cd93Ye56un" role="2OqNvi">
                      <ref role="37wK5l" to="33ny:~Map.get(java.lang.Object)" resolve="get" />
                      <node concept="37vLTw" id="cd93Ye56IO" role="37wK5m">
                        <ref role="3cqZAo" node="cd93Ye3leI" resolve="targetColumn" />
                      </node>
                    </node>
                  </node>
                  <node concept="37vLTw" id="cd93Ye57n1" role="37wK5m">
                    <ref role="3cqZAo" node="cd93Ye3leK" resolve="operand" />
                  </node>
                  <node concept="37vLTw" id="cd93Ye57RO" role="37wK5m">
                    <ref role="3cqZAo" node="cd93Ye3leM" resolve="operator" />
                  </node>
                </node>
              </node>
            </node>
            <node concept="3clFbH" id="cd93Ye58k_" role="3cqZAp" />
            <node concept="1DcWWT" id="cd93Ye58Zh" role="3cqZAp">
              <node concept="3clFbS" id="cd93Ye58Zj" role="2LFqv$">
                <node concept="3cpWs8" id="cd93Ye5en5" role="3cqZAp">
                  <node concept="3cpWsn" id="cd93Ye5en6" role="3cpWs9">
                    <property role="TrG5h" value="value" />
                    <node concept="3uibUv" id="cd93Ye5en7" role="1tU5fm">
                      <ref role="3uigEE" to="wyt6:~Object" resolve="Object" />
                    </node>
                    <node concept="2OqwBi" id="cd93Ye5h_D" role="33vP2m">
                      <node concept="37vLTw" id="cd93Ye5g5A" role="2Oq$k0">
                        <ref role="3cqZAo" node="cd93Ye3wtJ" resolve="lineInfo" />
                      </node>
                      <node concept="liA8E" id="cd93Ye5j4N" role="2OqNvi">
                        <ref role="37wK5l" to="33ny:~Map.get(java.lang.Object)" resolve="get" />
                        <node concept="37vLTw" id="cd93Ye5jVI" role="37wK5m">
                          <ref role="3cqZAo" node="cd93Ye58Zk" resolve="column" />
                        </node>
                      </node>
                    </node>
                  </node>
                </node>
                <node concept="3clFbF" id="cd93Ye5lQz" role="3cqZAp">
                  <node concept="2OqwBi" id="cd93Ye5ucc" role="3clFbG">
                    <node concept="2OqwBi" id="cd93Ye5pAC" role="2Oq$k0">
                      <node concept="2OqwBi" id="cd93Ye5mC_" role="2Oq$k0">
                        <node concept="37vLTw" id="cd93Ye5lQx" role="2Oq$k0">
                          <ref role="3cqZAo" node="cd93Ye3lp7" resolve="resultTable" />
                        </node>
                        <node concept="liA8E" id="cd93Ye5nKB" role="2OqNvi">
                          <ref role="37wK5l" to="6a2z:cd93YdQ8ZE" resolve="getColumnInfo" />
                        </node>
                      </node>
                      <node concept="liA8E" id="cd93Ye5rm4" role="2OqNvi">
                        <ref role="37wK5l" to="33ny:~Map.get(java.lang.Object)" resolve="get" />
                        <node concept="37vLTw" id="cd93Ye5smv" role="37wK5m">
                          <ref role="3cqZAo" node="cd93Ye58Zk" resolve="column" />
                        </node>
                      </node>
                    </node>
                    <node concept="liA8E" id="cd93Ye5wfq" role="2OqNvi">
                      <ref role="37wK5l" to="33ny:~Map.put(java.lang.Object,java.lang.Object)" resolve="put" />
                      <node concept="37vLTw" id="cd93Ye5xoH" role="37wK5m">
                        <ref role="3cqZAo" node="cd93Ye3m87" resolve="newLineCounter" />
                      </node>
                      <node concept="37vLTw" id="cd93Ye5$8E" role="37wK5m">
                        <ref role="3cqZAo" node="cd93Ye5en6" resolve="value" />
                      </node>
                    </node>
                  </node>
                </node>
              </node>
              <node concept="3cpWsn" id="cd93Ye58Zk" role="1Duv9x">
                <property role="TrG5h" value="column" />
                <node concept="3uibUv" id="cd93Ye59gL" role="1tU5fm">
                  <ref role="3uigEE" to="6a2z:cd93YdJHTQ" resolve="Column" />
                </node>
              </node>
              <node concept="2OqwBi" id="cd93Ye5b44" role="1DdaDG">
                <node concept="37vLTw" id="cd93Ye5a6k" role="2Oq$k0">
                  <ref role="3cqZAo" node="cd93Ye3wtJ" resolve="lineInfo" />
                </node>
                <node concept="liA8E" id="cd93Ye5cad" role="2OqNvi">
                  <ref role="37wK5l" to="33ny:~Map.keySet()" resolve="keySet" />
                </node>
              </node>
            </node>
            <node concept="3clFbH" id="cd93Ye5_cM" role="3cqZAp" />
            <node concept="3clFbF" id="cd93Ye5B5Z" role="3cqZAp">
              <node concept="3uNrnE" id="cd93Ye5EGo" role="3clFbG">
                <node concept="37vLTw" id="cd93Ye5EGq" role="2$L3a6">
                  <ref role="3cqZAo" node="cd93Ye3m87" resolve="newLineCounter" />
                </node>
              </node>
            </node>
          </node>
          <node concept="3cpWsn" id="cd93Ye3p2b" role="1Duv9x">
            <property role="TrG5h" value="lineIndex" />
            <node concept="10Oyi0" id="cd93Ye3p4r" role="1tU5fm" />
            <node concept="3cmrfG" id="cd93Ye3pcC" role="33vP2m">
              <property role="3cmrfH" value="1" />
            </node>
          </node>
          <node concept="2dkUwp" id="cd93Ye3trS" role="1Dwp0S">
            <node concept="2OqwBi" id="cd93Ye3u8T" role="3uHU7w">
              <node concept="37vLTw" id="cd93Ye3tuu" role="2Oq$k0">
                <ref role="3cqZAo" node="cd93Ye3leG" resolve="inputTable" />
              </node>
              <node concept="liA8E" id="cd93Ye3uha" role="2OqNvi">
                <ref role="37wK5l" to="6a2z:cd93YdR6a9" resolve="getNumLines" />
              </node>
            </node>
            <node concept="37vLTw" id="cd93Ye3pfJ" role="3uHU7B">
              <ref role="3cqZAo" node="cd93Ye3p2b" resolve="lineIndex" />
            </node>
          </node>
          <node concept="3uNrnE" id="cd93Ye3wgm" role="1Dwrff">
            <node concept="37vLTw" id="cd93Ye3wgo" role="2$L3a6">
              <ref role="3cqZAo" node="cd93Ye3p2b" resolve="lineIndex" />
            </node>
          </node>
        </node>
        <node concept="3clFbH" id="6gCHjbamPyl" role="3cqZAp" />
        <node concept="3clFbF" id="6gCHjbambDA" role="3cqZAp">
          <node concept="2YIFZM" id="6gCHjbamkZn" role="3clFbG">
            <ref role="37wK5l" to="810k:6gCHjbahhRx" resolve="log" />
            <ref role="1Pybhc" to="810k:6gCHjbahfKM" resolve="Logger" />
            <node concept="Rm8GO" id="6gCHjbamvYV" role="37wK5m">
              <ref role="Rm8GQ" to="810k:6gCHjbahhiU" resolve="INFO" />
              <ref role="1Px2BO" to="810k:6gCHjbahgOI" resolve="LogLevel" />
            </node>
            <node concept="Xl_RD" id="6gCHjbamBjz" role="37wK5m">
              <property role="Xl_RC" value="FilterStepDefault success." />
            </node>
          </node>
        </node>
        <node concept="3cpWs6" id="cd93Ye5H0j" role="3cqZAp">
          <node concept="37vLTw" id="cd93Ye5IUk" role="3cqZAk">
            <ref role="3cqZAo" node="cd93Ye3lp7" resolve="resultTable" />
          </node>
        </node>
      </node>
      <node concept="2AHcQZ" id="cd93Ye3leR" role="2AJF6D">
        <ref role="2AI5Lk" to="wyt6:~Override" />
      </node>
    </node>
    <node concept="2tJIrI" id="cd93Ye3xC3" role="jymVt" />
    <node concept="2YIFZL" id="cd93Ye3xTQ" role="jymVt">
      <property role="TrG5h" value="itApplies" />
      <node concept="3clFbS" id="cd93Ye3xTT" role="3clF47">
        <node concept="3clFbJ" id="cd93Ye3yh5" role="3cqZAp">
          <node concept="3clFbS" id="cd93Ye3yh7" role="3clFbx">
            <node concept="3cpWs8" id="cd93Ye3zYl" role="3cqZAp">
              <node concept="3cpWsn" id="cd93Ye3zYo" role="3cpWs9">
                <property role="TrG5h" value="numA" />
                <node concept="10P55v" id="cd93Ye3zYj" role="1tU5fm" />
                <node concept="2OqwBi" id="cd93Ye3$qK" role="33vP2m">
                  <node concept="1eOMI4" id="cd93Ye3$3W" role="2Oq$k0">
                    <node concept="10QFUN" id="cd93Ye3$3T" role="1eOMHV">
                      <node concept="37vLTw" id="cd93Ye3$cH" role="10QFUP">
                        <ref role="3cqZAo" node="cd93Ye3xYN" resolve="valueA" />
                      </node>
                      <node concept="3uibUv" id="cd93Ye3$7w" role="10QFUM">
                        <ref role="3uigEE" to="wyt6:~Number" resolve="Number" />
                      </node>
                    </node>
                  </node>
                  <node concept="liA8E" id="cd93Ye3$C9" role="2OqNvi">
                    <ref role="37wK5l" to="wyt6:~Number.doubleValue()" resolve="doubleValue" />
                  </node>
                </node>
              </node>
            </node>
            <node concept="3cpWs8" id="cd93Ye3$E$" role="3cqZAp">
              <node concept="3cpWsn" id="cd93Ye3$E_" role="3cpWs9">
                <property role="TrG5h" value="numB" />
                <node concept="10P55v" id="cd93Ye3$EA" role="1tU5fm" />
                <node concept="2OqwBi" id="cd93Ye3$EB" role="33vP2m">
                  <node concept="1eOMI4" id="cd93Ye3$EC" role="2Oq$k0">
                    <node concept="10QFUN" id="cd93Ye3$ED" role="1eOMHV">
                      <node concept="37vLTw" id="cd93Ye3$EE" role="10QFUP">
                        <ref role="3cqZAo" node="cd93Ye3y2d" resolve="valueB" />
                      </node>
                      <node concept="3uibUv" id="cd93Ye3$EF" role="10QFUM">
                        <ref role="3uigEE" to="wyt6:~Number" resolve="Number" />
                      </node>
                    </node>
                  </node>
                  <node concept="liA8E" id="cd93Ye3$EG" role="2OqNvi">
                    <ref role="37wK5l" to="wyt6:~Number.doubleValue()" resolve="doubleValue" />
                  </node>
                </node>
              </node>
            </node>
            <node concept="3clFbH" id="cd93Ye3$O2" role="3cqZAp" />
            <node concept="3clFbJ" id="cd93Ye3_PN" role="3cqZAp">
              <node concept="3clFbS" id="cd93Ye3_PP" role="3clFbx">
                <node concept="3cpWs6" id="cd93Ye3ChR" role="3cqZAp">
                  <node concept="3clFbC" id="cd93Ye3DRr" role="3cqZAk">
                    <node concept="37vLTw" id="cd93Ye3EUf" role="3uHU7w">
                      <ref role="3cqZAo" node="cd93Ye3$E_" resolve="numB" />
                    </node>
                    <node concept="37vLTw" id="cd93Ye3ClV" role="3uHU7B">
                      <ref role="3cqZAo" node="cd93Ye3zYo" resolve="numA" />
                    </node>
                  </node>
                </node>
              </node>
              <node concept="2OqwBi" id="cd93Ye3B6R" role="3clFbw">
                <node concept="37vLTw" id="cd93Ye3_Tr" role="2Oq$k0">
                  <ref role="3cqZAo" node="cd93Ye3y72" resolve="filterType" />
                </node>
                <node concept="liA8E" id="cd93Ye3BZd" role="2OqNvi">
                  <ref role="37wK5l" to="wyt6:~Enum.equals(java.lang.Object)" resolve="equals" />
                  <node concept="Rm8GO" id="cd93Ye3Caq" role="37wK5m">
                    <ref role="Rm8GQ" to="4z85:cd93Ye3jFO" resolve="EQUALS" />
                    <ref role="1Px2BO" to="4z85:cd93Ye3jBJ" resolve="FilterOperatorType" />
                  </node>
                </node>
              </node>
            </node>
            <node concept="3clFbJ" id="cd93Ye3FUb" role="3cqZAp">
              <node concept="3clFbS" id="cd93Ye3FUc" role="3clFbx">
                <node concept="3cpWs6" id="cd93Ye3FUd" role="3cqZAp">
                  <node concept="3eOVzh" id="cd93Ye3GFY" role="3cqZAk">
                    <node concept="37vLTw" id="cd93Ye3FUg" role="3uHU7B">
                      <ref role="3cqZAo" node="cd93Ye3zYo" resolve="numA" />
                    </node>
                    <node concept="37vLTw" id="cd93Ye3FUf" role="3uHU7w">
                      <ref role="3cqZAo" node="cd93Ye3$E_" resolve="numB" />
                    </node>
                  </node>
                </node>
              </node>
              <node concept="2OqwBi" id="cd93Ye3FUh" role="3clFbw">
                <node concept="37vLTw" id="cd93Ye3FUi" role="2Oq$k0">
                  <ref role="3cqZAo" node="cd93Ye3y72" resolve="filterType" />
                </node>
                <node concept="liA8E" id="cd93Ye3FUj" role="2OqNvi">
                  <ref role="37wK5l" to="wyt6:~Enum.equals(java.lang.Object)" resolve="equals" />
                  <node concept="Rm8GO" id="cd93Ye3G$p" role="37wK5m">
                    <ref role="Rm8GQ" to="4z85:cd93Ye3jHz" resolve="LESS_THAN" />
                    <ref role="1Px2BO" to="4z85:cd93Ye3jBJ" resolve="FilterOperatorType" />
                  </node>
                </node>
              </node>
            </node>
            <node concept="3clFbJ" id="cd93Ye3G0J" role="3cqZAp">
              <node concept="3clFbS" id="cd93Ye3G0K" role="3clFbx">
                <node concept="3cpWs6" id="cd93Ye3G0L" role="3cqZAp">
                  <node concept="2dkUwp" id="cd93Ye3H3Z" role="3cqZAk">
                    <node concept="37vLTw" id="cd93Ye3G0O" role="3uHU7B">
                      <ref role="3cqZAo" node="cd93Ye3zYo" resolve="numA" />
                    </node>
                    <node concept="37vLTw" id="cd93Ye3G0N" role="3uHU7w">
                      <ref role="3cqZAo" node="cd93Ye3$E_" resolve="numB" />
                    </node>
                  </node>
                </node>
              </node>
              <node concept="2OqwBi" id="cd93Ye3G0P" role="3clFbw">
                <node concept="37vLTw" id="cd93Ye3G0Q" role="2Oq$k0">
                  <ref role="3cqZAo" node="cd93Ye3y72" resolve="filterType" />
                </node>
                <node concept="liA8E" id="cd93Ye3G0R" role="2OqNvi">
                  <ref role="37wK5l" to="wyt6:~Enum.equals(java.lang.Object)" resolve="equals" />
                  <node concept="Rm8GO" id="cd93Ye3GWq" role="37wK5m">
                    <ref role="Rm8GQ" to="4z85:cd93Ye3jKO" resolve="LESS_OR_EQUALS_THAN" />
                    <ref role="1Px2BO" to="4z85:cd93Ye3jBJ" resolve="FilterOperatorType" />
                  </node>
                </node>
              </node>
            </node>
            <node concept="3clFbJ" id="cd93Ye3G89" role="3cqZAp">
              <node concept="3clFbS" id="cd93Ye3G8a" role="3clFbx">
                <node concept="3cpWs6" id="cd93Ye3G8b" role="3cqZAp">
                  <node concept="3eOSWO" id="cd93Ye3HYA" role="3cqZAk">
                    <node concept="37vLTw" id="cd93Ye3G8e" role="3uHU7B">
                      <ref role="3cqZAo" node="cd93Ye3zYo" resolve="numA" />
                    </node>
                    <node concept="37vLTw" id="cd93Ye3G8d" role="3uHU7w">
                      <ref role="3cqZAo" node="cd93Ye3$E_" resolve="numB" />
                    </node>
                  </node>
                </node>
              </node>
              <node concept="2OqwBi" id="cd93Ye3G8f" role="3clFbw">
                <node concept="37vLTw" id="cd93Ye3G8g" role="2Oq$k0">
                  <ref role="3cqZAo" node="cd93Ye3y72" resolve="filterType" />
                </node>
                <node concept="liA8E" id="cd93Ye3G8h" role="2OqNvi">
                  <ref role="37wK5l" to="wyt6:~Enum.equals(java.lang.Object)" resolve="equals" />
                  <node concept="Rm8GO" id="cd93Ye3Iea" role="37wK5m">
                    <ref role="Rm8GQ" to="4z85:cd93Ye3k3p" resolve="GREATER_THAN" />
                    <ref role="1Px2BO" to="4z85:cd93Ye3jBJ" resolve="FilterOperatorType" />
                  </node>
                </node>
              </node>
            </node>
            <node concept="3cpWs6" id="cd93Ye3GgT" role="3cqZAp">
              <node concept="2d3UOw" id="cd93Ye3I_m" role="3cqZAk">
                <node concept="37vLTw" id="cd93Ye3GgW" role="3uHU7B">
                  <ref role="3cqZAo" node="cd93Ye3zYo" resolve="numA" />
                </node>
                <node concept="37vLTw" id="cd93Ye3GgV" role="3uHU7w">
                  <ref role="3cqZAo" node="cd93Ye3$E_" resolve="numB" />
                </node>
              </node>
            </node>
            <node concept="3clFbH" id="cd93Ye3$Ez" role="3cqZAp" />
          </node>
          <node concept="1Wc70l" id="cd93Ye3zKi" role="3clFbw">
            <node concept="2ZW3vV" id="cd93Ye3zTh" role="3uHU7w">
              <node concept="3uibUv" id="cd93Ye3zVj" role="2ZW6by">
                <ref role="3uigEE" to="wyt6:~Number" resolve="Number" />
              </node>
              <node concept="37vLTw" id="cd93Ye3zN6" role="2ZW6bz">
                <ref role="3cqZAo" node="cd93Ye3y2d" resolve="valueB" />
              </node>
            </node>
            <node concept="2ZW3vV" id="cd93Ye3yxn" role="3uHU7B">
              <node concept="3uibUv" id="cd93Ye3y$z" role="2ZW6by">
                <ref role="3uigEE" to="wyt6:~Number" resolve="Number" />
              </node>
              <node concept="37vLTw" id="cd93Ye3yjg" role="2ZW6bz">
                <ref role="3cqZAo" node="cd93Ye3xYN" resolve="valueA" />
              </node>
            </node>
          </node>
          <node concept="3eNFk2" id="cd93Ye3IMa" role="3eNLev">
            <node concept="1Wc70l" id="cd93Ye3MbI" role="3eO9$A">
              <node concept="2ZW3vV" id="cd93Ye3MrV" role="3uHU7w">
                <node concept="3uibUv" id="cd93Ye3Mzu" role="2ZW6by">
                  <ref role="3uigEE" to="wyt6:~String" resolve="String" />
                </node>
                <node concept="37vLTw" id="cd93Ye3Mkd" role="2ZW6bz">
                  <ref role="3cqZAo" node="cd93Ye3y2d" resolve="valueB" />
                </node>
              </node>
              <node concept="2ZW3vV" id="cd93Ye3K0g" role="3uHU7B">
                <node concept="3uibUv" id="cd93Ye3K8X" role="2ZW6by">
                  <ref role="3uigEE" to="wyt6:~String" resolve="String" />
                </node>
                <node concept="37vLTw" id="cd93Ye3IXt" role="2ZW6bz">
                  <ref role="3cqZAo" node="cd93Ye3xYN" resolve="valueA" />
                </node>
              </node>
            </node>
            <node concept="3clFbS" id="cd93Ye3IMc" role="3eOfB_">
              <node concept="3cpWs8" id="cd93Ye3NAd" role="3cqZAp">
                <node concept="3cpWsn" id="cd93Ye3NAe" role="3cpWs9">
                  <property role="TrG5h" value="strA" />
                  <node concept="3uibUv" id="cd93Ye3NAf" role="1tU5fm">
                    <ref role="3uigEE" to="wyt6:~String" resolve="String" />
                  </node>
                  <node concept="10QFUN" id="cd93Ye3QpT" role="33vP2m">
                    <node concept="3uibUv" id="cd93Ye3QxZ" role="10QFUM">
                      <ref role="3uigEE" to="wyt6:~String" resolve="String" />
                    </node>
                    <node concept="37vLTw" id="cd93Ye3Qhw" role="10QFUP">
                      <ref role="3cqZAo" node="cd93Ye3xYN" resolve="valueA" />
                    </node>
                  </node>
                </node>
              </node>
              <node concept="3cpWs8" id="cd93Ye3QDy" role="3cqZAp">
                <node concept="3cpWsn" id="cd93Ye3QDz" role="3cpWs9">
                  <property role="TrG5h" value="strB" />
                  <node concept="3uibUv" id="cd93Ye3QD$" role="1tU5fm">
                    <ref role="3uigEE" to="wyt6:~String" resolve="String" />
                  </node>
                  <node concept="10QFUN" id="cd93Ye3QD_" role="33vP2m">
                    <node concept="3uibUv" id="cd93Ye3QDA" role="10QFUM">
                      <ref role="3uigEE" to="wyt6:~String" resolve="String" />
                    </node>
                    <node concept="37vLTw" id="cd93Ye3QDB" role="10QFUP">
                      <ref role="3cqZAo" node="cd93Ye3y2d" resolve="valueB" />
                    </node>
                  </node>
                </node>
              </node>
              <node concept="3clFbH" id="cd93Ye3RN$" role="3cqZAp" />
              <node concept="3clFbJ" id="cd93Ye3RUK" role="3cqZAp">
                <node concept="3clFbS" id="cd93Ye3RUL" role="3clFbx">
                  <node concept="3cpWs6" id="cd93Ye3RUM" role="3cqZAp">
                    <node concept="2OqwBi" id="cd93Ye3UR1" role="3cqZAk">
                      <node concept="37vLTw" id="cd93Ye3RUP" role="2Oq$k0">
                        <ref role="3cqZAo" node="cd93Ye3NAe" resolve="strA" />
                      </node>
                      <node concept="liA8E" id="cd93Ye3WwL" role="2OqNvi">
                        <ref role="37wK5l" to="wyt6:~String.equals(java.lang.Object)" resolve="equals" />
                        <node concept="37vLTw" id="cd93Ye3WJX" role="37wK5m">
                          <ref role="3cqZAo" node="cd93Ye3QDz" resolve="strB" />
                        </node>
                      </node>
                    </node>
                  </node>
                </node>
                <node concept="2OqwBi" id="cd93Ye3RUQ" role="3clFbw">
                  <node concept="37vLTw" id="cd93Ye3RUR" role="2Oq$k0">
                    <ref role="3cqZAo" node="cd93Ye3y72" resolve="filterType" />
                  </node>
                  <node concept="liA8E" id="cd93Ye3RUS" role="2OqNvi">
                    <ref role="37wK5l" to="wyt6:~Enum.equals(java.lang.Object)" resolve="equals" />
                    <node concept="Rm8GO" id="cd93Ye3RUT" role="37wK5m">
                      <ref role="Rm8GQ" to="4z85:cd93Ye3jFO" resolve="EQUALS" />
                      <ref role="1Px2BO" to="4z85:cd93Ye3jBJ" resolve="FilterOperatorType" />
                    </node>
                  </node>
                </node>
              </node>
              <node concept="3clFbJ" id="cd93Ye3RUU" role="3cqZAp">
                <node concept="3clFbS" id="cd93Ye3RUV" role="3clFbx">
                  <node concept="3cpWs6" id="cd93Ye3RUW" role="3cqZAp">
                    <node concept="3eOVzh" id="cd93Ye41VX" role="3cqZAk">
                      <node concept="3cmrfG" id="cd93Ye42c6" role="3uHU7w">
                        <property role="3cmrfH" value="0" />
                      </node>
                      <node concept="2OqwBi" id="cd93Ye3XNC" role="3uHU7B">
                        <node concept="37vLTw" id="cd93Ye3Xop" role="2Oq$k0">
                          <ref role="3cqZAo" node="cd93Ye3NAe" resolve="strA" />
                        </node>
                        <node concept="liA8E" id="cd93Ye3Y4N" role="2OqNvi">
                          <ref role="37wK5l" to="wyt6:~String.compareTo(java.lang.String)" resolve="compareTo" />
                          <node concept="37vLTw" id="cd93Ye3YDv" role="37wK5m">
                            <ref role="3cqZAo" node="cd93Ye3QDz" resolve="strB" />
                          </node>
                        </node>
                      </node>
                    </node>
                  </node>
                </node>
                <node concept="2OqwBi" id="cd93Ye3RV0" role="3clFbw">
                  <node concept="37vLTw" id="cd93Ye3RV1" role="2Oq$k0">
                    <ref role="3cqZAo" node="cd93Ye3y72" resolve="filterType" />
                  </node>
                  <node concept="liA8E" id="cd93Ye3RV2" role="2OqNvi">
                    <ref role="37wK5l" to="wyt6:~Enum.equals(java.lang.Object)" resolve="equals" />
                    <node concept="Rm8GO" id="cd93Ye3RV3" role="37wK5m">
                      <ref role="Rm8GQ" to="4z85:cd93Ye3jHz" resolve="LESS_THAN" />
                      <ref role="1Px2BO" to="4z85:cd93Ye3jBJ" resolve="FilterOperatorType" />
                    </node>
                  </node>
                </node>
              </node>
              <node concept="3clFbJ" id="cd93Ye3RV4" role="3cqZAp">
                <node concept="3clFbS" id="cd93Ye3RV5" role="3clFbx">
                  <node concept="3cpWs6" id="cd93Ye42pj" role="3cqZAp">
                    <node concept="2dkUwp" id="cd93Ye42At" role="3cqZAk">
                      <node concept="2OqwBi" id="cd93Ye42pm" role="3uHU7B">
                        <node concept="37vLTw" id="cd93Ye42pn" role="2Oq$k0">
                          <ref role="3cqZAo" node="cd93Ye3NAe" resolve="strA" />
                        </node>
                        <node concept="liA8E" id="cd93Ye42po" role="2OqNvi">
                          <ref role="37wK5l" to="wyt6:~String.compareTo(java.lang.String)" resolve="compareTo" />
                          <node concept="37vLTw" id="cd93Ye42pp" role="37wK5m">
                            <ref role="3cqZAo" node="cd93Ye3QDz" resolve="strB" />
                          </node>
                        </node>
                      </node>
                      <node concept="3cmrfG" id="cd93Ye42pl" role="3uHU7w">
                        <property role="3cmrfH" value="0" />
                      </node>
                    </node>
                  </node>
                </node>
                <node concept="2OqwBi" id="cd93Ye3RVa" role="3clFbw">
                  <node concept="37vLTw" id="cd93Ye3RVb" role="2Oq$k0">
                    <ref role="3cqZAo" node="cd93Ye3y72" resolve="filterType" />
                  </node>
                  <node concept="liA8E" id="cd93Ye3RVc" role="2OqNvi">
                    <ref role="37wK5l" to="wyt6:~Enum.equals(java.lang.Object)" resolve="equals" />
                    <node concept="Rm8GO" id="cd93Ye3RVd" role="37wK5m">
                      <ref role="Rm8GQ" to="4z85:cd93Ye3jKO" resolve="LESS_OR_EQUALS_THAN" />
                      <ref role="1Px2BO" to="4z85:cd93Ye3jBJ" resolve="FilterOperatorType" />
                    </node>
                  </node>
                </node>
              </node>
              <node concept="3clFbJ" id="cd93Ye3RVe" role="3cqZAp">
                <node concept="3clFbS" id="cd93Ye3RVf" role="3clFbx">
                  <node concept="3cpWs6" id="cd93Ye42Ni" role="3cqZAp">
                    <node concept="3eOSWO" id="cd93Ye44FA" role="3cqZAk">
                      <node concept="2OqwBi" id="cd93Ye42Nl" role="3uHU7B">
                        <node concept="37vLTw" id="cd93Ye42Nm" role="2Oq$k0">
                          <ref role="3cqZAo" node="cd93Ye3NAe" resolve="strA" />
                        </node>
                        <node concept="liA8E" id="cd93Ye42Nn" role="2OqNvi">
                          <ref role="37wK5l" to="wyt6:~String.compareTo(java.lang.String)" resolve="compareTo" />
                          <node concept="37vLTw" id="cd93Ye42No" role="37wK5m">
                            <ref role="3cqZAo" node="cd93Ye3QDz" resolve="strB" />
                          </node>
                        </node>
                      </node>
                      <node concept="3cmrfG" id="cd93Ye42Nk" role="3uHU7w">
                        <property role="3cmrfH" value="0" />
                      </node>
                    </node>
                  </node>
                </node>
                <node concept="2OqwBi" id="cd93Ye3RVk" role="3clFbw">
                  <node concept="37vLTw" id="cd93Ye3RVl" role="2Oq$k0">
                    <ref role="3cqZAo" node="cd93Ye3y72" resolve="filterType" />
                  </node>
                  <node concept="liA8E" id="cd93Ye3RVm" role="2OqNvi">
                    <ref role="37wK5l" to="wyt6:~Enum.equals(java.lang.Object)" resolve="equals" />
                    <node concept="Rm8GO" id="cd93Ye3RVn" role="37wK5m">
                      <ref role="Rm8GQ" to="4z85:cd93Ye3k3p" resolve="GREATER_THAN" />
                      <ref role="1Px2BO" to="4z85:cd93Ye3jBJ" resolve="FilterOperatorType" />
                    </node>
                  </node>
                </node>
              </node>
              <node concept="3cpWs6" id="cd93Ye44SQ" role="3cqZAp">
                <node concept="2d3UOw" id="cd93Ye45kx" role="3cqZAk">
                  <node concept="2OqwBi" id="cd93Ye44ST" role="3uHU7B">
                    <node concept="37vLTw" id="cd93Ye44SU" role="2Oq$k0">
                      <ref role="3cqZAo" node="cd93Ye3NAe" resolve="strA" />
                    </node>
                    <node concept="liA8E" id="cd93Ye44SV" role="2OqNvi">
                      <ref role="37wK5l" to="wyt6:~String.compareTo(java.lang.String)" resolve="compareTo" />
                      <node concept="37vLTw" id="cd93Ye44SW" role="37wK5m">
                        <ref role="3cqZAo" node="cd93Ye3QDz" resolve="strB" />
                      </node>
                    </node>
                  </node>
                  <node concept="3cmrfG" id="cd93Ye44SS" role="3uHU7w">
                    <property role="3cmrfH" value="0" />
                  </node>
                </node>
              </node>
              <node concept="3clFbH" id="cd93Ye3RN_" role="3cqZAp" />
            </node>
          </node>
          <node concept="3eNFk2" id="cd93Ye45Ac" role="3eNLev">
            <node concept="1Wc70l" id="cd93Ye48NF" role="3eO9$A">
              <node concept="2ZW3vV" id="cd93Ye4abq" role="3uHU7w">
                <node concept="3uibUv" id="cd93Ye4apL" role="2ZW6by">
                  <ref role="3uigEE" to="28m1:~LocalDate" resolve="LocalDate" />
                </node>
                <node concept="37vLTw" id="cd93Ye49PI" role="2ZW6bz">
                  <ref role="3cqZAo" node="cd93Ye3y2d" resolve="valueB" />
                </node>
              </node>
              <node concept="2ZW3vV" id="cd93Ye46hs" role="3uHU7B">
                <node concept="3uibUv" id="cd93Ye47lC" role="2ZW6by">
                  <ref role="3uigEE" to="28m1:~LocalDate" resolve="LocalDate" />
                </node>
                <node concept="37vLTw" id="cd93Ye45Vj" role="2ZW6bz">
                  <ref role="3cqZAo" node="cd93Ye3xYN" resolve="valueA" />
                </node>
              </node>
            </node>
            <node concept="3clFbS" id="cd93Ye45Ae" role="3eOfB_">
              <node concept="3cpWs8" id="cd93Ye4d3D" role="3cqZAp">
                <node concept="3cpWsn" id="cd93Ye4d3E" role="3cpWs9">
                  <property role="TrG5h" value="dateA" />
                  <node concept="3uibUv" id="cd93Ye4d3F" role="1tU5fm">
                    <ref role="3uigEE" to="28m1:~LocalDate" resolve="LocalDate" />
                  </node>
                  <node concept="10QFUN" id="cd93Ye4d3G" role="33vP2m">
                    <node concept="3uibUv" id="cd93Ye4d3H" role="10QFUM">
                      <ref role="3uigEE" to="28m1:~LocalDate" resolve="LocalDate" />
                    </node>
                    <node concept="37vLTw" id="cd93Ye4d3I" role="10QFUP">
                      <ref role="3cqZAo" node="cd93Ye3xYN" resolve="valueA" />
                    </node>
                  </node>
                </node>
              </node>
              <node concept="3cpWs8" id="cd93Ye4d3J" role="3cqZAp">
                <node concept="3cpWsn" id="cd93Ye4d3K" role="3cpWs9">
                  <property role="TrG5h" value="dateB" />
                  <node concept="3uibUv" id="cd93Ye4d3L" role="1tU5fm">
                    <ref role="3uigEE" to="28m1:~LocalDate" resolve="LocalDate" />
                  </node>
                  <node concept="10QFUN" id="cd93Ye4d3M" role="33vP2m">
                    <node concept="3uibUv" id="cd93Ye4d3N" role="10QFUM">
                      <ref role="3uigEE" to="28m1:~LocalDate" resolve="LocalDate" />
                    </node>
                    <node concept="37vLTw" id="cd93Ye4d3O" role="10QFUP">
                      <ref role="3cqZAo" node="cd93Ye3y2d" resolve="valueB" />
                    </node>
                  </node>
                </node>
              </node>
              <node concept="3clFbH" id="cd93Ye4cG8" role="3cqZAp" />
              <node concept="3clFbJ" id="cd93Ye4boE" role="3cqZAp">
                <node concept="3clFbS" id="cd93Ye4boF" role="3clFbx">
                  <node concept="3cpWs6" id="cd93Ye4boG" role="3cqZAp">
                    <node concept="2OqwBi" id="cd93Ye4boH" role="3cqZAk">
                      <node concept="liA8E" id="cd93Ye4boJ" role="2OqNvi">
                        <ref role="37wK5l" to="28m1:~LocalDate.equals(java.lang.Object)" resolve="equals" />
                        <node concept="37vLTw" id="cd93Ye4jJe" role="37wK5m">
                          <ref role="3cqZAo" node="cd93Ye4d3K" resolve="dateB" />
                        </node>
                      </node>
                      <node concept="37vLTw" id="cd93Ye4iJT" role="2Oq$k0">
                        <ref role="3cqZAo" node="cd93Ye4d3E" resolve="dateA" />
                      </node>
                    </node>
                  </node>
                </node>
                <node concept="2OqwBi" id="cd93Ye4boL" role="3clFbw">
                  <node concept="37vLTw" id="cd93Ye4boM" role="2Oq$k0">
                    <ref role="3cqZAo" node="cd93Ye3y72" resolve="filterType" />
                  </node>
                  <node concept="liA8E" id="cd93Ye4boN" role="2OqNvi">
                    <ref role="37wK5l" to="wyt6:~Enum.equals(java.lang.Object)" resolve="equals" />
                    <node concept="Rm8GO" id="cd93Ye4boO" role="37wK5m">
                      <ref role="Rm8GQ" to="4z85:cd93Ye3jFO" resolve="EQUALS" />
                      <ref role="1Px2BO" to="4z85:cd93Ye3jBJ" resolve="FilterOperatorType" />
                    </node>
                  </node>
                </node>
              </node>
              <node concept="3clFbJ" id="cd93Ye4boP" role="3cqZAp">
                <node concept="3clFbS" id="cd93Ye4boQ" role="3clFbx">
                  <node concept="3cpWs6" id="cd93Ye4lf2" role="3cqZAp">
                    <node concept="2OqwBi" id="cd93Ye4mN5" role="3cqZAk">
                      <node concept="37vLTw" id="cd93Ye4lye" role="2Oq$k0">
                        <ref role="3cqZAo" node="cd93Ye4d3E" resolve="dateA" />
                      </node>
                      <node concept="liA8E" id="cd93Ye4nTD" role="2OqNvi">
                        <ref role="37wK5l" to="28m1:~LocalDate.isBefore(java.time.chrono.ChronoLocalDate)" resolve="isBefore" />
                        <node concept="37vLTw" id="cd93Ye4odi" role="37wK5m">
                          <ref role="3cqZAo" node="cd93Ye4d3K" resolve="dateB" />
                        </node>
                      </node>
                    </node>
                  </node>
                </node>
                <node concept="2OqwBi" id="cd93Ye4boY" role="3clFbw">
                  <node concept="37vLTw" id="cd93Ye4boZ" role="2Oq$k0">
                    <ref role="3cqZAo" node="cd93Ye3y72" resolve="filterType" />
                  </node>
                  <node concept="liA8E" id="cd93Ye4bp0" role="2OqNvi">
                    <ref role="37wK5l" to="wyt6:~Enum.equals(java.lang.Object)" resolve="equals" />
                    <node concept="Rm8GO" id="cd93Ye4bp1" role="37wK5m">
                      <ref role="Rm8GQ" to="4z85:cd93Ye3jHz" resolve="LESS_THAN" />
                      <ref role="1Px2BO" to="4z85:cd93Ye3jBJ" resolve="FilterOperatorType" />
                    </node>
                  </node>
                </node>
              </node>
              <node concept="3clFbJ" id="cd93Ye4bp2" role="3cqZAp">
                <node concept="3clFbS" id="cd93Ye4bp3" role="3clFbx">
                  <node concept="3cpWs6" id="cd93Ye4oBn" role="3cqZAp">
                    <node concept="22lmx$" id="cd93Ye4u18" role="3cqZAk">
                      <node concept="2OqwBi" id="cd93Ye4wKX" role="3uHU7w">
                        <node concept="37vLTw" id="cd93Ye4vrI" role="2Oq$k0">
                          <ref role="3cqZAo" node="cd93Ye4d3E" resolve="dateA" />
                        </node>
                        <node concept="liA8E" id="cd93Ye4xMO" role="2OqNvi">
                          <ref role="37wK5l" to="28m1:~LocalDate.equals(java.lang.Object)" resolve="equals" />
                          <node concept="37vLTw" id="cd93Ye4y6Q" role="37wK5m">
                            <ref role="3cqZAo" node="cd93Ye4d3K" resolve="dateB" />
                          </node>
                        </node>
                      </node>
                      <node concept="2OqwBi" id="cd93Ye4rc8" role="3uHU7B">
                        <node concept="37vLTw" id="cd93Ye4pRD" role="2Oq$k0">
                          <ref role="3cqZAo" node="cd93Ye4d3E" resolve="dateA" />
                        </node>
                        <node concept="liA8E" id="cd93Ye4sd4" role="2OqNvi">
                          <ref role="37wK5l" to="28m1:~LocalDate.isBefore(java.time.chrono.ChronoLocalDate)" resolve="isBefore" />
                          <node concept="37vLTw" id="cd93Ye4sww" role="37wK5m">
                            <ref role="3cqZAo" node="cd93Ye4d3K" resolve="dateB" />
                          </node>
                        </node>
                      </node>
                    </node>
                  </node>
                </node>
                <node concept="2OqwBi" id="cd93Ye4bpb" role="3clFbw">
                  <node concept="37vLTw" id="cd93Ye4bpc" role="2Oq$k0">
                    <ref role="3cqZAo" node="cd93Ye3y72" resolve="filterType" />
                  </node>
                  <node concept="liA8E" id="cd93Ye4bpd" role="2OqNvi">
                    <ref role="37wK5l" to="wyt6:~Enum.equals(java.lang.Object)" resolve="equals" />
                    <node concept="Rm8GO" id="cd93Ye4bpe" role="37wK5m">
                      <ref role="Rm8GQ" to="4z85:cd93Ye3jKO" resolve="LESS_OR_EQUALS_THAN" />
                      <ref role="1Px2BO" to="4z85:cd93Ye3jBJ" resolve="FilterOperatorType" />
                    </node>
                  </node>
                </node>
              </node>
              <node concept="3clFbJ" id="cd93Ye4bpf" role="3cqZAp">
                <node concept="3clFbS" id="cd93Ye4bpg" role="3clFbx">
                  <node concept="3cpWs6" id="cd93Ye4zNz" role="3cqZAp">
                    <node concept="2OqwBi" id="cd93Ye4_rN" role="3cqZAk">
                      <node concept="37vLTw" id="cd93Ye4$6V" role="2Oq$k0">
                        <ref role="3cqZAo" node="cd93Ye4d3E" resolve="dateA" />
                      </node>
                      <node concept="liA8E" id="cd93Ye4At8" role="2OqNvi">
                        <ref role="37wK5l" to="28m1:~LocalDate.isAfter(java.time.chrono.ChronoLocalDate)" resolve="isAfter" />
                        <node concept="37vLTw" id="cd93Ye4AKX" role="37wK5m">
                          <ref role="3cqZAo" node="cd93Ye4d3K" resolve="dateB" />
                        </node>
                      </node>
                    </node>
                  </node>
                </node>
                <node concept="2OqwBi" id="cd93Ye4bpo" role="3clFbw">
                  <node concept="37vLTw" id="cd93Ye4bpp" role="2Oq$k0">
                    <ref role="3cqZAo" node="cd93Ye3y72" resolve="filterType" />
                  </node>
                  <node concept="liA8E" id="cd93Ye4bpq" role="2OqNvi">
                    <ref role="37wK5l" to="wyt6:~Enum.equals(java.lang.Object)" resolve="equals" />
                    <node concept="Rm8GO" id="cd93Ye4bpr" role="37wK5m">
                      <ref role="Rm8GQ" to="4z85:cd93Ye3k3p" resolve="GREATER_THAN" />
                      <ref role="1Px2BO" to="4z85:cd93Ye3jBJ" resolve="FilterOperatorType" />
                    </node>
                  </node>
                </node>
              </node>
              <node concept="3cpWs6" id="cd93Ye4BdI" role="3cqZAp">
                <node concept="22lmx$" id="cd93Ye4G$T" role="3cqZAk">
                  <node concept="2OqwBi" id="cd93Ye4Jp4" role="3uHU7w">
                    <node concept="37vLTw" id="cd93Ye4I3D" role="2Oq$k0">
                      <ref role="3cqZAo" node="cd93Ye4d3E" resolve="dateA" />
                    </node>
                    <node concept="liA8E" id="cd93Ye4Lp3" role="2OqNvi">
                      <ref role="37wK5l" to="28m1:~LocalDate.equals(java.lang.Object)" resolve="equals" />
                      <node concept="37vLTw" id="cd93Ye4LGZ" role="37wK5m">
                        <ref role="3cqZAo" node="cd93Ye4d3K" resolve="dateB" />
                      </node>
                    </node>
                  </node>
                  <node concept="2OqwBi" id="cd93Ye4DN1" role="3uHU7B">
                    <node concept="37vLTw" id="cd93Ye4Cum" role="2Oq$k0">
                      <ref role="3cqZAo" node="cd93Ye4d3E" resolve="dateA" />
                    </node>
                    <node concept="liA8E" id="cd93Ye4EO9" role="2OqNvi">
                      <ref role="37wK5l" to="28m1:~LocalDate.isAfter(java.time.chrono.ChronoLocalDate)" resolve="isAfter" />
                      <node concept="37vLTw" id="cd93Ye4F7L" role="37wK5m">
                        <ref role="3cqZAo" node="cd93Ye4d3K" resolve="dateB" />
                      </node>
                    </node>
                  </node>
                </node>
              </node>
              <node concept="3clFbH" id="cd93Ye5ZH2" role="3cqZAp" />
            </node>
          </node>
          <node concept="9aQIb" id="cd93Ye4MUh" role="9aQIa">
            <node concept="3clFbS" id="cd93Ye4MUi" role="9aQI4">
              <node concept="3clFbF" id="6gCHjbamWes" role="3cqZAp">
                <node concept="2YIFZM" id="6gCHjbamWet" role="3clFbG">
                  <ref role="37wK5l" to="810k:6gCHjbahhRx" resolve="log" />
                  <ref role="1Pybhc" to="810k:6gCHjbahfKM" resolve="Logger" />
                  <node concept="Rm8GO" id="6gCHjbamZgN" role="37wK5m">
                    <ref role="Rm8GQ" to="810k:6gCHjbahh9p" resolve="ERROR" />
                    <ref role="1Px2BO" to="810k:6gCHjbahgOI" resolve="LogLevel" />
                  </node>
                  <node concept="3cpWs3" id="6gCHjban5A3" role="37wK5m">
                    <node concept="2OqwBi" id="6gCHjban5A4" role="3uHU7w">
                      <node concept="37vLTw" id="6gCHjban5A5" role="2Oq$k0">
                        <ref role="3cqZAo" node="cd93Ye3y2d" resolve="valueB" />
                      </node>
                      <node concept="liA8E" id="6gCHjban5A6" role="2OqNvi">
                        <ref role="37wK5l" to="wyt6:~Object.getClass()" resolve="getClass" />
                      </node>
                    </node>
                    <node concept="3cpWs3" id="6gCHjban5A7" role="3uHU7B">
                      <node concept="3cpWs3" id="6gCHjban5A8" role="3uHU7B">
                        <node concept="Xl_RD" id="6gCHjban5A9" role="3uHU7B">
                          <property role="Xl_RC" value="Unsupported data types for comparison: " />
                        </node>
                        <node concept="2OqwBi" id="6gCHjban5Aa" role="3uHU7w">
                          <node concept="37vLTw" id="6gCHjban5Ab" role="2Oq$k0">
                            <ref role="3cqZAo" node="cd93Ye3xYN" resolve="valueA" />
                          </node>
                          <node concept="liA8E" id="6gCHjban5Ac" role="2OqNvi">
                            <ref role="37wK5l" to="wyt6:~Object.getClass()" resolve="getClass" />
                          </node>
                        </node>
                      </node>
                      <node concept="Xl_RD" id="6gCHjban5Ad" role="3uHU7w">
                        <property role="Xl_RC" value=" and " />
                      </node>
                    </node>
                  </node>
                </node>
              </node>
              <node concept="3clFbH" id="6gCHjbamRST" role="3cqZAp" />
              <node concept="YS8fn" id="cd93Ye4Nyn" role="3cqZAp">
                <node concept="2ShNRf" id="cd93Ye4NQz" role="YScLw">
                  <node concept="1pGfFk" id="cd93Ye4OKF" role="2ShVmc">
                    <property role="373rjd" value="true" />
                    <ref role="37wK5l" to="wyt6:~IllegalArgumentException.&lt;init&gt;(java.lang.String)" resolve="IllegalArgumentException" />
                    <node concept="3cpWs3" id="cd93Ye5041" role="37wK5m">
                      <node concept="2OqwBi" id="cd93Ye52J8" role="3uHU7w">
                        <node concept="37vLTw" id="cd93Ye525q" role="2Oq$k0">
                          <ref role="3cqZAo" node="cd93Ye3y2d" resolve="valueB" />
                        </node>
                        <node concept="liA8E" id="cd93Ye53oj" role="2OqNvi">
                          <ref role="37wK5l" to="wyt6:~Object.getClass()" resolve="getClass" />
                        </node>
                      </node>
                      <node concept="3cpWs3" id="cd93Ye4WKm" role="3uHU7B">
                        <node concept="3cpWs3" id="cd93Ye4Sc3" role="3uHU7B">
                          <node concept="Xl_RD" id="cd93Ye4Q4T" role="3uHU7B">
                            <property role="Xl_RC" value="Unsupported data types for comparison: " />
                          </node>
                          <node concept="2OqwBi" id="cd93Ye4USf" role="3uHU7w">
                            <node concept="37vLTw" id="cd93Ye4SNJ" role="2Oq$k0">
                              <ref role="3cqZAo" node="cd93Ye3xYN" resolve="valueA" />
                            </node>
                            <node concept="liA8E" id="cd93Ye4VfS" role="2OqNvi">
                              <ref role="37wK5l" to="wyt6:~Object.getClass()" resolve="getClass" />
                            </node>
                          </node>
                        </node>
                        <node concept="Xl_RD" id="cd93Ye4X_d" role="3uHU7w">
                          <property role="Xl_RC" value=" and " />
                        </node>
                      </node>
                    </node>
                  </node>
                </node>
              </node>
            </node>
          </node>
        </node>
      </node>
      <node concept="3Tm1VV" id="cd93Ye3xNP" role="1B3o_S" />
      <node concept="10P_77" id="cd93Ye3xSw" role="3clF45" />
      <node concept="37vLTG" id="cd93Ye3xYN" role="3clF46">
        <property role="TrG5h" value="valueA" />
        <node concept="3uibUv" id="cd93Ye3xYM" role="1tU5fm">
          <ref role="3uigEE" to="wyt6:~Object" resolve="Object" />
        </node>
      </node>
      <node concept="37vLTG" id="cd93Ye3y2d" role="3clF46">
        <property role="TrG5h" value="valueB" />
        <node concept="3uibUv" id="cd93Ye3y44" role="1tU5fm">
          <ref role="3uigEE" to="wyt6:~Object" resolve="Object" />
        </node>
      </node>
      <node concept="37vLTG" id="cd93Ye3y72" role="3clF46">
        <property role="TrG5h" value="filterType" />
        <node concept="3uibUv" id="cd93Ye3y8T" role="1tU5fm">
          <ref role="3uigEE" to="4z85:cd93Ye3jBJ" resolve="FilterOperatorType" />
        </node>
      </node>
    </node>
  </node>
  <node concept="3HP615" id="cd93Ye2YOb">
    <property role="TrG5h" value="IFilterStep" />
    <property role="2HnT6v" value="program.src.main.java.org.enorm.domain.steps.filterStep" />
    <node concept="3clFb_" id="cd93Ye2YS_" role="jymVt">
      <property role="TrG5h" value="apply" />
      <node concept="3clFbS" id="cd93Ye2YSC" role="3clF47" />
      <node concept="3Tm1VV" id="cd93Ye2YSD" role="1B3o_S" />
      <node concept="3uibUv" id="cd93Ye2YSr" role="3clF45">
        <ref role="3uigEE" to="6a2z:cd93YdJHRJ" resolve="Table" />
      </node>
      <node concept="37vLTG" id="cd93Ye2YT3" role="3clF46">
        <property role="TrG5h" value="inputTable" />
        <node concept="3uibUv" id="cd93Ye2YT2" role="1tU5fm">
          <ref role="3uigEE" to="6a2z:cd93YdJHRJ" resolve="Table" />
        </node>
      </node>
      <node concept="37vLTG" id="cd93Ye2YUE" role="3clF46">
        <property role="TrG5h" value="targetColumn" />
        <node concept="3uibUv" id="cd93Ye2YV6" role="1tU5fm">
          <ref role="3uigEE" to="6a2z:cd93YdJHTQ" resolve="Column" />
        </node>
      </node>
      <node concept="37vLTG" id="cd93Ye2YXu" role="3clF46">
        <property role="TrG5h" value="operand" />
        <node concept="3uibUv" id="cd93Ye2YXU" role="1tU5fm">
          <ref role="3uigEE" to="wyt6:~Object" resolve="Object" />
        </node>
      </node>
      <node concept="37vLTG" id="cd93Ye2YYJ" role="3clF46">
        <property role="TrG5h" value="operator" />
        <node concept="3uibUv" id="cd93Ye3k_5" role="1tU5fm">
          <ref role="3uigEE" to="4z85:cd93Ye3jBJ" resolve="FilterOperatorType" />
        </node>
      </node>
      <node concept="37vLTG" id="cd93Ye3k_T" role="3clF46">
        <property role="TrG5h" value="factoryTable" />
        <node concept="3uibUv" id="cd93Ye3kAl" role="1tU5fm">
          <ref role="3uigEE" to="6a2z:cd93YdSsAK" resolve="FactoryTable" />
        </node>
      </node>
    </node>
    <node concept="3Tm1VV" id="cd93Ye2YOc" role="1B3o_S" />
    <node concept="n94m4" id="cd93Ye2YOd" role="lGtFl" />
  </node>
  <node concept="312cEu" id="cd93Ye2YOz">
    <property role="TrG5h" value="FactoryFilterStep" />
    <property role="2HnT6v" value="program.src.main.java.org.enorm.domain.steps.filterStep" />
    <node concept="Wx3nA" id="cd93Ye3kCm" role="jymVt">
      <property role="TrG5h" value="step" />
      <node concept="3Tm6S6" id="cd93Ye3kBR" role="1B3o_S" />
      <node concept="3uibUv" id="cd93Ye3kCc" role="1tU5fm">
        <ref role="3uigEE" node="cd93Ye2YOb" resolve="IFilterStep" />
      </node>
    </node>
    <node concept="2tJIrI" id="cd93Ye3kCy" role="jymVt" />
    <node concept="2YIFZL" id="cd93Ye3kD3" role="jymVt">
      <property role="TrG5h" value="setStep" />
      <node concept="3clFbS" id="cd93Ye3kD6" role="3clF47">
        <node concept="3clFbF" id="cd93Ye3kEz" role="3cqZAp">
          <node concept="37vLTI" id="cd93Ye3l7T" role="3clFbG">
            <node concept="37vLTw" id="cd93Ye3l8c" role="37vLTx">
              <ref role="3cqZAo" node="cd93Ye3kDx" resolve="s" />
            </node>
            <node concept="37vLTw" id="cd93Ye3kEy" role="37vLTJ">
              <ref role="3cqZAo" node="cd93Ye3kCm" resolve="step" />
            </node>
          </node>
        </node>
      </node>
      <node concept="3Tm1VV" id="cd93Ye3kCQ" role="1B3o_S" />
      <node concept="3cqZAl" id="cd93Ye3kCT" role="3clF45" />
      <node concept="37vLTG" id="cd93Ye3kDx" role="3clF46">
        <property role="TrG5h" value="s" />
        <node concept="3uibUv" id="cd93Ye3kDw" role="1tU5fm">
          <ref role="3uigEE" node="cd93Ye2YOb" resolve="IFilterStep" />
        </node>
      </node>
    </node>
    <node concept="2tJIrI" id="cd93Ye3l8T" role="jymVt" />
    <node concept="2YIFZL" id="cd93Ye3l9R" role="jymVt">
      <property role="TrG5h" value="getStep" />
      <node concept="3clFbS" id="cd93Ye3l9U" role="3clF47">
        <node concept="3cpWs6" id="cd93Ye3lba" role="3cqZAp">
          <node concept="37vLTw" id="cd93Ye3lcM" role="3cqZAk">
            <ref role="3cqZAo" node="cd93Ye3kCm" resolve="step" />
          </node>
        </node>
      </node>
      <node concept="3Tm1VV" id="cd93Ye3l9a" role="1B3o_S" />
      <node concept="3uibUv" id="cd93Ye3l9D" role="3clF45">
        <ref role="3uigEE" node="cd93Ye2YOb" resolve="IFilterStep" />
      </node>
    </node>
    <node concept="3Tm1VV" id="cd93Ye2YO$" role="1B3o_S" />
    <node concept="n94m4" id="cd93Ye2YO_" role="lGtFl" />
  </node>
  <node concept="bUwia" id="cd93YdZi2Q">
    <property role="TrG5h" value="main" />
    <node concept="3lhOvk" id="cd93YdZi4V" role="3lj3bC">
      <ref role="30HIoZ" to="y20r:59Zp2b9n1iz" resolve="Filter" />
      <ref role="3lhOvi" node="cd93Ye2YNp" resolve="FilterStepDefault" />
    </node>
    <node concept="3lhOvk" id="cd93YdZi4W" role="3lj3bC">
      <ref role="30HIoZ" to="y20r:59Zp2b9n1iz" resolve="Filter" />
      <ref role="3lhOvi" node="cd93Ye2YOz" resolve="FactoryFilterStep" />
    </node>
    <node concept="3lhOvk" id="cd93YdZi4X" role="3lj3bC">
      <ref role="30HIoZ" to="y20r:59Zp2b9n1iz" resolve="Filter" />
      <ref role="3lhOvi" node="cd93Ye2YOb" resolve="IFilterStep" />
    </node>
  </node>
</model>

