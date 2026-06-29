<?xml version="1.0" encoding="UTF-8"?>
<model ref="r:e2661cc8-007f-44b8-a96a-97c94b2ca103(ltsdsl.generator.steps.groupBy@generator)">
  <persistence version="9" />
  <languages>
    <use id="acfc188d-d5d6-4598-b370-6f4a983f05b2" name="jetbrains.mps.baseLanguage.methodReferences" version="0" />
    <use id="515552c7-fcc0-4ab4-9789-2f3c49344e85" name="jetbrains.mps.baseLanguage.varVariable" version="0" />
    <devkit ref="a2eb3a43-fcc2-4200-80dc-c60110c4862d(jetbrains.mps.devkit.templates)" />
  </languages>
  <imports>
    <import index="y20r" ref="r:85f52e46-7a19-44f9-bf10-6677b89edd73(ltsdsl.structure)" />
    <import index="33ny" ref="6354ebe7-c22a-4a0f-ac54-50b52ab9b065/java:java.util(JDK/)" />
    <import index="xlxw" ref="6354ebe7-c22a-4a0f-ac54-50b52ab9b065/java:java.math(JDK/)" />
    <import index="6a2z" ref="r:1c985b49-e2d4-4b0a-ac27-a43894ccaff0(ltsdsl.generator.tables@generator)" />
    <import index="bhzw" ref="r:85bdddc6-187d-4220-9afc-b13727e2590d(ltsdsl.generator.utils@generator)" />
    <import index="4z85" ref="r:f197530d-51ad-4216-956c-2f6cb0c55a22(ltsdsl.generator.enums@generator)" />
    <import index="4dg1" ref="r:efcec103-84b2-480a-91c5-bcd3ff0ec3cb(ltsdsl.generator.steps.filter@generator)" />
    <import index="810k" ref="r:7a125382-cddb-4c4f-8e8b-3d8533cae26c(ltsdsl.generator.main@generator)" />
    <import index="wyt6" ref="6354ebe7-c22a-4a0f-ac54-50b52ab9b065/java:java.lang(JDK/)" implicit="true" />
    <import index="1ctc" ref="6354ebe7-c22a-4a0f-ac54-50b52ab9b065/java:java.util.stream(JDK/)" implicit="true" />
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
      <concept id="4836112446988635817" name="jetbrains.mps.baseLanguage.structure.UndefinedType" flags="in" index="2jxLKc" />
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
      <concept id="1095950406618" name="jetbrains.mps.baseLanguage.structure.DivExpression" flags="nn" index="FJ1c_" />
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
      <concept id="1070533707846" name="jetbrains.mps.baseLanguage.structure.StaticFieldReference" flags="nn" index="10M0yZ">
        <reference id="1144433057691" name="classifier" index="1PxDUh" />
      </concept>
      <concept id="1070534058343" name="jetbrains.mps.baseLanguage.structure.NullLiteral" flags="nn" index="10Nm6u" />
      <concept id="1070534370425" name="jetbrains.mps.baseLanguage.structure.IntegerType" flags="in" index="10Oyi0" />
      <concept id="1070534513062" name="jetbrains.mps.baseLanguage.structure.DoubleType" flags="in" index="10P55v" />
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
    <language id="fd392034-7849-419d-9071-12563d152375" name="jetbrains.mps.baseLanguage.closures">
      <concept id="2524418899405758586" name="jetbrains.mps.baseLanguage.closures.structure.InferredClosureParameterDeclaration" flags="ig" index="gl6BB" />
      <concept id="1199569711397" name="jetbrains.mps.baseLanguage.closures.structure.ClosureLiteral" flags="nn" index="1bVj0M">
        <child id="1199569906740" name="parameter" index="1bW2Oz" />
        <child id="1199569916463" name="body" index="1bW5cS" />
      </concept>
    </language>
    <language id="acfc188d-d5d6-4598-b370-6f4a983f05b2" name="jetbrains.mps.baseLanguage.methodReferences">
      <concept id="7915009415671748557" name="jetbrains.mps.baseLanguage.methodReferences.structure.MethodReferenceTypeTargetExpression" flags="ng" index="2FaPjH">
        <child id="7915009415671751864" name="type" index="2FaQuo" />
      </concept>
      <concept id="237887375562511215" name="jetbrains.mps.baseLanguage.methodReferences.structure.MethodReference" flags="ng" index="37Ijox" />
      <concept id="3507059745126391419" name="jetbrains.mps.baseLanguage.methodReferences.structure.IMethodReference" flags="ngI" index="3UZKCU">
        <reference id="237887375562511297" name="method" index="37Ijqf" />
        <child id="962278442658307079" name="target" index="wWaWy" />
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
  <node concept="312cEu" id="4BP1plxRt8M">
    <property role="TrG5h" value="FactoryGroupByStep" />
    <property role="2HnT6v" value="program.src.main.java.org.enorm.domain.steps.groupByStep" />
    <node concept="Wx3nA" id="4BP1plxS9rt" role="jymVt">
      <property role="TrG5h" value="step" />
      <node concept="3Tm6S6" id="4BP1plxS9qY" role="1B3o_S" />
      <node concept="3uibUv" id="4BP1plxS9rj" role="1tU5fm">
        <ref role="3uigEE" node="4BP1plxRt9a" resolve="IGroupByStep" />
      </node>
    </node>
    <node concept="2tJIrI" id="4BP1plxS9qO" role="jymVt" />
    <node concept="2YIFZL" id="4BP1plxS9oz" role="jymVt">
      <property role="TrG5h" value="setStep" />
      <node concept="3clFbS" id="4BP1plxS9oA" role="3clF47">
        <node concept="3clFbF" id="4BP1plxS9sy" role="3cqZAp">
          <node concept="37vLTI" id="4BP1plxS9Wn" role="3clFbG">
            <node concept="37vLTw" id="4BP1plxSa36" role="37vLTx">
              <ref role="3cqZAo" node="4BP1plxS9p1" resolve="s" />
            </node>
            <node concept="37vLTw" id="4BP1plxS9sx" role="37vLTJ">
              <ref role="3cqZAo" node="4BP1plxS9rt" resolve="step" />
            </node>
          </node>
        </node>
      </node>
      <node concept="3Tm1VV" id="7mnL6OEnlp7" role="1B3o_S" />
      <node concept="3cqZAl" id="4BP1plxS9op" role="3clF45" />
      <node concept="37vLTG" id="4BP1plxS9p1" role="3clF46">
        <property role="TrG5h" value="s" />
        <node concept="3uibUv" id="4BP1plxS9p0" role="1tU5fm">
          <ref role="3uigEE" node="4BP1plxRt9a" resolve="IGroupByStep" />
        </node>
      </node>
    </node>
    <node concept="2tJIrI" id="4BP1plxSa3N" role="jymVt" />
    <node concept="2YIFZL" id="4BP1plxSa4L" role="jymVt">
      <property role="TrG5h" value="getStep" />
      <node concept="3clFbS" id="4BP1plxSa4O" role="3clF47">
        <node concept="3cpWs6" id="4BP1plxSa64" role="3cqZAp">
          <node concept="37vLTw" id="4BP1plxSa6E" role="3cqZAk">
            <ref role="3cqZAo" node="4BP1plxS9rt" resolve="step" />
          </node>
        </node>
      </node>
      <node concept="3Tm1VV" id="4BP1plxSa44" role="1B3o_S" />
      <node concept="3uibUv" id="4BP1plxSa4z" role="3clF45">
        <ref role="3uigEE" node="4BP1plxRt9a" resolve="IGroupByStep" />
      </node>
    </node>
    <node concept="3Tm1VV" id="4BP1plxRt8N" role="1B3o_S" />
    <node concept="n94m4" id="4BP1plxRt8O" role="lGtFl" />
  </node>
  <node concept="312cEu" id="4BP1plxRt8Y">
    <property role="TrG5h" value="GroupByStepDefault" />
    <property role="2HnT6v" value="program.src.main.java.org.enorm.domain.steps.groupByStep" />
    <node concept="3Tm1VV" id="4BP1plxRt8Z" role="1B3o_S" />
    <node concept="n94m4" id="4BP1plxRt90" role="lGtFl" />
    <node concept="3uibUv" id="4BP1plxSa81" role="EKbjA">
      <ref role="3uigEE" node="4BP1plxRt9a" resolve="IGroupByStep" />
    </node>
    <node concept="3clFb_" id="4BP1plxSa8x" role="jymVt">
      <property role="TrG5h" value="apply" />
      <node concept="3Tm1VV" id="4BP1plxSa8z" role="1B3o_S" />
      <node concept="3uibUv" id="4BP1plxSa8$" role="3clF45">
        <ref role="3uigEE" to="6a2z:cd93YdJHRJ" resolve="Table" />
      </node>
      <node concept="37vLTG" id="4BP1plxSa8_" role="3clF46">
        <property role="TrG5h" value="inputTable" />
        <node concept="3uibUv" id="4BP1plxSa8A" role="1tU5fm">
          <ref role="3uigEE" to="6a2z:cd93YdJHRJ" resolve="Table" />
        </node>
      </node>
      <node concept="37vLTG" id="4BP1plxSa8B" role="3clF46">
        <property role="TrG5h" value="groupBy" />
        <node concept="3uibUv" id="4BP1plxSa8C" role="1tU5fm">
          <ref role="3uigEE" to="33ny:~List" resolve="List" />
          <node concept="3uibUv" id="4BP1plxSa8D" role="11_B2D">
            <ref role="3uigEE" to="6a2z:cd93YdJHTQ" resolve="Column" />
          </node>
        </node>
      </node>
      <node concept="37vLTG" id="4BP1plxSa8E" role="3clF46">
        <property role="TrG5h" value="operandColumn" />
        <node concept="3uibUv" id="4BP1plxSa8F" role="1tU5fm">
          <ref role="3uigEE" to="6a2z:cd93YdJHTQ" resolve="Column" />
        </node>
      </node>
      <node concept="37vLTG" id="4BP1plxSa8G" role="3clF46">
        <property role="TrG5h" value="operation" />
        <node concept="3uibUv" id="4BP1plxSa8H" role="1tU5fm">
          <ref role="3uigEE" to="4z85:4BP1plxRthH" resolve="GroupByOperationType" />
        </node>
      </node>
      <node concept="37vLTG" id="4BP1plxSa8I" role="3clF46">
        <property role="TrG5h" value="factoryTable" />
        <node concept="3uibUv" id="4BP1plxSa8J" role="1tU5fm">
          <ref role="3uigEE" to="6a2z:cd93YdSsAK" resolve="FactoryTable" />
        </node>
      </node>
      <node concept="3clFbS" id="4BP1plxSa8K" role="3clF47">
        <node concept="3clFbH" id="4BP1plxSaem" role="3cqZAp" />
        <node concept="3cpWs8" id="4BP1plxSahC" role="3cqZAp">
          <node concept="3cpWsn" id="4BP1plxSahI" role="3cpWs9">
            <property role="TrG5h" value="orderedGroupBy" />
            <node concept="3uibUv" id="4BP1plxSahK" role="1tU5fm">
              <ref role="3uigEE" to="33ny:~List" resolve="List" />
              <node concept="3uibUv" id="4BP1plxSajq" role="11_B2D">
                <ref role="3uigEE" to="6a2z:cd93YdJHTQ" resolve="Column" />
              </node>
            </node>
            <node concept="2YIFZM" id="4BP1plxSaz0" role="33vP2m">
              <ref role="37wK5l" to="bhzw:cd93Ye7Hv8" resolve="reorderListBasedOnAnother" />
              <ref role="1Pybhc" to="bhzw:cd93Ye7Hbb" resolve="ListUtils" />
              <node concept="2OqwBi" id="4BP1plxSaIi" role="37wK5m">
                <node concept="37vLTw" id="4BP1plxSa_I" role="2Oq$k0">
                  <ref role="3cqZAo" node="4BP1plxSa8_" resolve="inputTable" />
                </node>
                <node concept="liA8E" id="4BP1plxSaQ9" role="2OqNvi">
                  <ref role="37wK5l" to="6a2z:cd93YdP6bz" resolve="getColumnList" />
                </node>
              </node>
              <node concept="37vLTw" id="4BP1plxSaYV" role="37wK5m">
                <ref role="3cqZAo" node="4BP1plxSa8B" resolve="groupBy" />
              </node>
            </node>
          </node>
        </node>
        <node concept="3cpWs8" id="4BP1plxSbcX" role="3cqZAp">
          <node concept="3cpWsn" id="4BP1plxSbcY" role="3cpWs9">
            <property role="TrG5h" value="groupedData" />
            <node concept="3uibUv" id="4BP1plxSbcV" role="1tU5fm">
              <ref role="3uigEE" to="33ny:~Map" resolve="Map" />
              <node concept="3uibUv" id="4BP1plxSbh_" role="11_B2D">
                <ref role="3uigEE" to="33ny:~List" resolve="List" />
                <node concept="3uibUv" id="4BP1plxSbmD" role="11_B2D">
                  <ref role="3uigEE" to="wyt6:~Object" resolve="Object" />
                </node>
              </node>
              <node concept="3uibUv" id="4BP1plxSbwb" role="11_B2D">
                <ref role="3uigEE" to="33ny:~List" resolve="List" />
                <node concept="3uibUv" id="4BP1plxSb_n" role="11_B2D">
                  <ref role="3uigEE" to="wyt6:~Object" resolve="Object" />
                </node>
              </node>
            </node>
            <node concept="2ShNRf" id="4BP1plxSbYn" role="33vP2m">
              <node concept="1pGfFk" id="4BP1plxScJD" role="2ShVmc">
                <property role="373rjd" value="true" />
                <ref role="37wK5l" to="33ny:~HashMap.&lt;init&gt;()" resolve="HashMap" />
              </node>
            </node>
          </node>
        </node>
        <node concept="3clFbH" id="4BP1plxScSm" role="3cqZAp" />
        <node concept="1Dw8fO" id="4BP1plxSdaM" role="3cqZAp">
          <node concept="3clFbS" id="4BP1plxSdaO" role="2LFqv$">
            <node concept="3cpWs8" id="4BP1plxSl6D" role="3cqZAp">
              <node concept="3cpWsn" id="4BP1plxSl6E" role="3cpWs9">
                <property role="TrG5h" value="columnInfoInThisLine" />
                <node concept="3uibUv" id="4BP1plxSl6B" role="1tU5fm">
                  <ref role="3uigEE" to="33ny:~Map" resolve="Map" />
                  <node concept="3uibUv" id="4BP1plxSlg2" role="11_B2D">
                    <ref role="3uigEE" to="6a2z:cd93YdJHTQ" resolve="Column" />
                  </node>
                  <node concept="3uibUv" id="4BP1plxSlyN" role="11_B2D">
                    <ref role="3uigEE" to="wyt6:~Object" resolve="Object" />
                  </node>
                </node>
                <node concept="2OqwBi" id="4BP1plxSmxe" role="33vP2m">
                  <node concept="37vLTw" id="4BP1plxSmhA" role="2Oq$k0">
                    <ref role="3cqZAo" node="4BP1plxSa8_" resolve="inputTable" />
                  </node>
                  <node concept="liA8E" id="4BP1plxSmKK" role="2OqNvi">
                    <ref role="37wK5l" to="6a2z:cd93YdQf6P" resolve="getLineInfo" />
                    <node concept="37vLTw" id="4BP1plxSmWk" role="37wK5m">
                      <ref role="3cqZAo" node="4BP1plxSdaP" resolve="lineIndex" />
                    </node>
                  </node>
                </node>
              </node>
            </node>
            <node concept="3cpWs8" id="4BP1plxSnpT" role="3cqZAp">
              <node concept="3cpWsn" id="4BP1plxSnpZ" role="3cpWs9">
                <property role="TrG5h" value="columnsToGroup" />
                <node concept="3uibUv" id="4BP1plxSnq1" role="1tU5fm">
                  <ref role="3uigEE" to="33ny:~List" resolve="List" />
                  <node concept="3uibUv" id="4BP1plxSn_8" role="11_B2D">
                    <ref role="3uigEE" to="6a2z:cd93YdJHTQ" resolve="Column" />
                  </node>
                </node>
                <node concept="2OqwBi" id="4BP1plxSwV0" role="33vP2m">
                  <node concept="2OqwBi" id="4BP1plxSrJd" role="2Oq$k0">
                    <node concept="2OqwBi" id="4BP1plxSpPS" role="2Oq$k0">
                      <node concept="2OqwBi" id="4BP1plxSovK" role="2Oq$k0">
                        <node concept="37vLTw" id="4BP1plxSo66" role="2Oq$k0">
                          <ref role="3cqZAo" node="4BP1plxSa8_" resolve="inputTable" />
                        </node>
                        <node concept="liA8E" id="4BP1plxSoKH" role="2OqNvi">
                          <ref role="37wK5l" to="6a2z:cd93YdP6bz" resolve="getColumnList" />
                        </node>
                      </node>
                      <node concept="liA8E" id="4BP1plxSr72" role="2OqNvi">
                        <ref role="37wK5l" to="33ny:~Collection.stream()" resolve="stream" />
                      </node>
                    </node>
                    <node concept="liA8E" id="4BP1plxSsF_" role="2OqNvi">
                      <ref role="37wK5l" to="1ctc:~Stream.filter(java.util.function.Predicate)" resolve="filter" />
                      <node concept="37Ijox" id="4BP1plxSvCX" role="37wK5m">
                        <ref role="37Ijqf" to="33ny:~List.contains(java.lang.Object)" resolve="contains" />
                        <node concept="37vLTw" id="4BP1plxSt5d" role="wWaWy">
                          <ref role="3cqZAo" node="4BP1plxSahI" resolve="orderedGroupBy" />
                        </node>
                      </node>
                    </node>
                  </node>
                  <node concept="liA8E" id="4BP1plxSyiC" role="2OqNvi">
                    <ref role="37wK5l" to="1ctc:~Stream.toList()" resolve="toList" />
                  </node>
                </node>
              </node>
            </node>
            <node concept="3clFbH" id="4BP1plxSyUM" role="3cqZAp" />
            <node concept="3cpWs8" id="4BP1plxSzHF" role="3cqZAp">
              <node concept="3cpWsn" id="4BP1plxSzHL" role="3cpWs9">
                <property role="TrG5h" value="valuesToGroup" />
                <node concept="3uibUv" id="4BP1plxSzHN" role="1tU5fm">
                  <ref role="3uigEE" to="33ny:~List" resolve="List" />
                  <node concept="3uibUv" id="4BP1plxS$uM" role="11_B2D">
                    <ref role="3uigEE" to="wyt6:~Object" resolve="Object" />
                  </node>
                </node>
                <node concept="2ShNRf" id="4BP1plxSBid" role="33vP2m">
                  <node concept="1pGfFk" id="4BP1plxSBUG" role="2ShVmc">
                    <property role="373rjd" value="true" />
                    <ref role="37wK5l" to="33ny:~ArrayList.&lt;init&gt;()" resolve="ArrayList" />
                  </node>
                </node>
              </node>
            </node>
            <node concept="1DcWWT" id="4BP1plxSD2m" role="3cqZAp">
              <node concept="3clFbS" id="4BP1plxSD2o" role="2LFqv$">
                <node concept="3clFbF" id="4BP1plxSFLn" role="3cqZAp">
                  <node concept="2OqwBi" id="4BP1plxSHQH" role="3clFbG">
                    <node concept="37vLTw" id="4BP1plxSFLl" role="2Oq$k0">
                      <ref role="3cqZAo" node="4BP1plxSzHL" resolve="valuesToGroup" />
                    </node>
                    <node concept="liA8E" id="4BP1plxSJHi" role="2OqNvi">
                      <ref role="37wK5l" to="33ny:~List.add(java.lang.Object)" resolve="add" />
                      <node concept="2OqwBi" id="4BP1plxSQY8" role="37wK5m">
                        <node concept="37vLTw" id="4BP1plxSKTD" role="2Oq$k0">
                          <ref role="3cqZAo" node="4BP1plxSl6E" resolve="columnInfoInThisLine" />
                        </node>
                        <node concept="liA8E" id="4BP1plxSSIw" role="2OqNvi">
                          <ref role="37wK5l" to="33ny:~Map.get(java.lang.Object)" resolve="get" />
                          <node concept="37vLTw" id="4BP1plxSTPp" role="37wK5m">
                            <ref role="3cqZAo" node="4BP1plxSD2p" resolve="column" />
                          </node>
                        </node>
                      </node>
                    </node>
                  </node>
                </node>
              </node>
              <node concept="3cpWsn" id="4BP1plxSD2p" role="1Duv9x">
                <property role="TrG5h" value="column" />
                <node concept="3uibUv" id="4BP1plxSDIE" role="1tU5fm">
                  <ref role="3uigEE" to="6a2z:cd93YdJHTQ" resolve="Column" />
                </node>
              </node>
              <node concept="37vLTw" id="4BP1plxSEO0" role="1DdaDG">
                <ref role="3cqZAo" node="4BP1plxSnpZ" resolve="columnsToGroup" />
              </node>
            </node>
            <node concept="3clFbH" id="4BP1plxSV1a" role="3cqZAp" />
            <node concept="3cpWs8" id="4BP1plxSXUy" role="3cqZAp">
              <node concept="3cpWsn" id="4BP1plxSXUz" role="3cpWs9">
                <property role="TrG5h" value="operandResult" />
                <node concept="3uibUv" id="4BP1plxSXU$" role="1tU5fm">
                  <ref role="3uigEE" to="wyt6:~Object" resolve="Object" />
                </node>
                <node concept="2OqwBi" id="4BP1plxT6fZ" role="33vP2m">
                  <node concept="37vLTw" id="4BP1plxT4qW" role="2Oq$k0">
                    <ref role="3cqZAo" node="4BP1plxSl6E" resolve="columnInfoInThisLine" />
                  </node>
                  <node concept="liA8E" id="4BP1plxT8co" role="2OqNvi">
                    <ref role="37wK5l" to="33ny:~Map.get(java.lang.Object)" resolve="get" />
                    <node concept="37vLTw" id="4BP1plxT9m$" role="37wK5m">
                      <ref role="3cqZAo" node="4BP1plxSa8E" resolve="operandColumn" />
                    </node>
                  </node>
                </node>
              </node>
            </node>
            <node concept="3clFbH" id="4BP1plxTaAc" role="3cqZAp" />
            <node concept="3clFbJ" id="4BP1plxTcfT" role="3cqZAp">
              <node concept="3clFbS" id="4BP1plxTcfV" role="3clFbx">
                <node concept="3clFbF" id="4BP1plxTpg3" role="3cqZAp">
                  <node concept="2OqwBi" id="4BP1plxTrjs" role="3clFbG">
                    <node concept="37vLTw" id="4BP1plxTpg1" role="2Oq$k0">
                      <ref role="3cqZAo" node="4BP1plxSbcY" resolve="groupedData" />
                    </node>
                    <node concept="liA8E" id="4BP1plxTtug" role="2OqNvi">
                      <ref role="37wK5l" to="33ny:~Map.put(java.lang.Object,java.lang.Object)" resolve="put" />
                      <node concept="37vLTw" id="4BP1plxTv5m" role="37wK5m">
                        <ref role="3cqZAo" node="4BP1plxSzHL" resolve="valuesToGroup" />
                      </node>
                      <node concept="2ShNRf" id="4BP1plxTx$Z" role="37wK5m">
                        <node concept="1pGfFk" id="4BP1plxTznf" role="2ShVmc">
                          <property role="373rjd" value="true" />
                          <ref role="37wK5l" to="33ny:~ArrayList.&lt;init&gt;(java.util.Collection)" resolve="ArrayList" />
                          <node concept="2YIFZM" id="4BP1plxUPh9" role="37wK5m">
                            <ref role="37wK5l" to="33ny:~List.of(java.lang.Object)" resolve="of" />
                            <ref role="1Pybhc" to="33ny:~List" resolve="List" />
                            <node concept="37vLTw" id="6gCHjb9qNlT" role="37wK5m">
                              <ref role="3cqZAo" node="4BP1plxSXUz" resolve="operandResult" />
                            </node>
                          </node>
                          <node concept="3uibUv" id="4BP1plxUGE2" role="1pMfVU">
                            <ref role="3uigEE" to="wyt6:~Object" resolve="Object" />
                          </node>
                        </node>
                      </node>
                    </node>
                  </node>
                </node>
              </node>
              <node concept="3clFbC" id="4BP1plxTlRu" role="3clFbw">
                <node concept="10Nm6u" id="4BP1plxTnYr" role="3uHU7w" />
                <node concept="2OqwBi" id="4BP1plxTfCd" role="3uHU7B">
                  <node concept="37vLTw" id="4BP1plxTdJl" role="2Oq$k0">
                    <ref role="3cqZAo" node="4BP1plxSbcY" resolve="groupedData" />
                  </node>
                  <node concept="liA8E" id="4BP1plxThKR" role="2OqNvi">
                    <ref role="37wK5l" to="33ny:~Map.get(java.lang.Object)" resolve="get" />
                    <node concept="37vLTw" id="4BP1plxTje5" role="37wK5m">
                      <ref role="3cqZAo" node="4BP1plxSzHL" resolve="valuesToGroup" />
                    </node>
                  </node>
                </node>
              </node>
              <node concept="9aQIb" id="4BP1plxTIHq" role="9aQIa">
                <node concept="3clFbS" id="4BP1plxTIHr" role="9aQI4">
                  <node concept="3cpWs8" id="4BP1plxTKhE" role="3cqZAp">
                    <node concept="3cpWsn" id="4BP1plxTKhH" role="3cpWs9">
                      <property role="TrG5h" value="newList" />
                      <node concept="3uibUv" id="4BP1plxTKhJ" role="1tU5fm">
                        <ref role="3uigEE" to="33ny:~List" resolve="List" />
                        <node concept="3uibUv" id="4BP1plxTLDU" role="11_B2D">
                          <ref role="3uigEE" to="wyt6:~Object" resolve="Object" />
                        </node>
                      </node>
                      <node concept="2ShNRf" id="4BP1plxTSqO" role="33vP2m">
                        <node concept="1pGfFk" id="4BP1plxTU1L" role="2ShVmc">
                          <property role="373rjd" value="true" />
                          <ref role="37wK5l" to="33ny:~ArrayList.&lt;init&gt;(java.util.Collection)" resolve="ArrayList" />
                          <node concept="2OqwBi" id="4BP1plxTZ83" role="37wK5m">
                            <node concept="37vLTw" id="4BP1plxTVsU" role="2Oq$k0">
                              <ref role="3cqZAo" node="4BP1plxSbcY" resolve="groupedData" />
                            </node>
                            <node concept="liA8E" id="4BP1plxU1IZ" role="2OqNvi">
                              <ref role="37wK5l" to="33ny:~Map.get(java.lang.Object)" resolve="get" />
                              <node concept="37vLTw" id="4BP1plxU3op" role="37wK5m">
                                <ref role="3cqZAo" node="4BP1plxSzHL" resolve="valuesToGroup" />
                              </node>
                            </node>
                          </node>
                          <node concept="3uibUv" id="4BP1plxUBzy" role="1pMfVU">
                            <ref role="3uigEE" to="wyt6:~Object" resolve="Object" />
                          </node>
                        </node>
                      </node>
                    </node>
                  </node>
                  <node concept="3clFbF" id="4BP1plxU6Ob" role="3cqZAp">
                    <node concept="2OqwBi" id="4BP1plxUaTV" role="3clFbG">
                      <node concept="37vLTw" id="4BP1plxU6O9" role="2Oq$k0">
                        <ref role="3cqZAo" node="4BP1plxTKhH" resolve="newList" />
                      </node>
                      <node concept="liA8E" id="4BP1plxUdqj" role="2OqNvi">
                        <ref role="37wK5l" to="33ny:~List.add(java.lang.Object)" resolve="add" />
                        <node concept="37vLTw" id="4BP1plxUiKb" role="37wK5m">
                          <ref role="3cqZAo" node="4BP1plxSXUz" resolve="operandResult" />
                        </node>
                      </node>
                    </node>
                  </node>
                  <node concept="3clFbF" id="4BP1plxUnxz" role="3cqZAp">
                    <node concept="2OqwBi" id="4BP1plxUqar" role="3clFbG">
                      <node concept="37vLTw" id="4BP1plxUnxx" role="2Oq$k0">
                        <ref role="3cqZAo" node="4BP1plxSbcY" resolve="groupedData" />
                      </node>
                      <node concept="liA8E" id="4BP1plxUsVW" role="2OqNvi">
                        <ref role="37wK5l" to="33ny:~Map.put(java.lang.Object,java.lang.Object)" resolve="put" />
                        <node concept="37vLTw" id="4BP1plxUvZI" role="37wK5m">
                          <ref role="3cqZAo" node="4BP1plxSzHL" resolve="valuesToGroup" />
                        </node>
                        <node concept="37vLTw" id="4BP1plxUzY_" role="37wK5m">
                          <ref role="3cqZAo" node="4BP1plxTKhH" resolve="newList" />
                        </node>
                      </node>
                    </node>
                  </node>
                </node>
              </node>
            </node>
          </node>
          <node concept="3cpWsn" id="4BP1plxSdaP" role="1Duv9x">
            <property role="TrG5h" value="lineIndex" />
            <node concept="10Oyi0" id="4BP1plxSdjO" role="1tU5fm" />
            <node concept="3cmrfG" id="4BP1plxSei_" role="33vP2m">
              <property role="3cmrfH" value="1" />
            </node>
          </node>
          <node concept="2dkUwp" id="4BP1plxSgPJ" role="1Dwp0S">
            <node concept="2OqwBi" id="4BP1plxSi8i" role="3uHU7w">
              <node concept="37vLTw" id="4BP1plxShnf" role="2Oq$k0">
                <ref role="3cqZAo" node="4BP1plxSa8_" resolve="inputTable" />
              </node>
              <node concept="liA8E" id="4BP1plxSiug" role="2OqNvi">
                <ref role="37wK5l" to="6a2z:cd93YdR6a9" resolve="getNumLines" />
              </node>
            </node>
            <node concept="37vLTw" id="4BP1plxSerG" role="3uHU7B">
              <ref role="3cqZAo" node="4BP1plxSdaP" resolve="lineIndex" />
            </node>
          </node>
          <node concept="3uNrnE" id="4BP1plxSkNf" role="1Dwrff">
            <node concept="37vLTw" id="4BP1plxSkNh" role="2$L3a6">
              <ref role="3cqZAo" node="4BP1plxSdaP" resolve="lineIndex" />
            </node>
          </node>
        </node>
        <node concept="3clFbH" id="4BP1plxUVrg" role="3cqZAp" />
        <node concept="3cpWs8" id="4BP1plxUY4W" role="3cqZAp">
          <node concept="3cpWsn" id="4BP1plxUY52" role="3cpWs9">
            <property role="TrG5h" value="finalGroupedData" />
            <node concept="3uibUv" id="4BP1plxUY54" role="1tU5fm">
              <ref role="3uigEE" to="33ny:~Map" resolve="Map" />
              <node concept="3uibUv" id="4BP1plxV0In" role="11_B2D">
                <ref role="3uigEE" to="33ny:~List" resolve="List" />
                <node concept="3uibUv" id="4BP1plxV4A5" role="11_B2D">
                  <ref role="3uigEE" to="wyt6:~Object" resolve="Object" />
                </node>
              </node>
              <node concept="3uibUv" id="4BP1plxV8lf" role="11_B2D">
                <ref role="3uigEE" to="wyt6:~Object" resolve="Object" />
              </node>
            </node>
            <node concept="2ShNRf" id="4BP1plxVn0y" role="33vP2m">
              <node concept="1pGfFk" id="4BP1plxVpto" role="2ShVmc">
                <property role="373rjd" value="true" />
                <ref role="37wK5l" to="33ny:~HashMap.&lt;init&gt;()" resolve="HashMap" />
              </node>
            </node>
          </node>
        </node>
        <node concept="3clFbH" id="4BP1plxVt60" role="3cqZAp" />
        <node concept="1DcWWT" id="4BP1plxVw5S" role="3cqZAp">
          <node concept="3clFbS" id="4BP1plxVw5U" role="2LFqv$">
            <node concept="3cpWs8" id="4BP1plxVNxP" role="3cqZAp">
              <node concept="3cpWsn" id="4BP1plxVNxV" role="3cpWs9">
                <property role="TrG5h" value="value" />
                <node concept="3uibUv" id="4BP1plxVNxX" role="1tU5fm">
                  <ref role="3uigEE" to="33ny:~List" resolve="List" />
                  <node concept="3uibUv" id="4BP1plxVS4z" role="11_B2D">
                    <ref role="3uigEE" to="wyt6:~Object" resolve="Object" />
                  </node>
                </node>
                <node concept="2OqwBi" id="4BP1plxWcpP" role="33vP2m">
                  <node concept="37vLTw" id="4BP1plxW9eQ" role="2Oq$k0">
                    <ref role="3cqZAo" node="4BP1plxSbcY" resolve="groupedData" />
                  </node>
                  <node concept="liA8E" id="4BP1plxWg9J" role="2OqNvi">
                    <ref role="37wK5l" to="33ny:~Map.get(java.lang.Object)" resolve="get" />
                    <node concept="37vLTw" id="4BP1plxWiPF" role="37wK5m">
                      <ref role="3cqZAo" node="4BP1plxVw5V" resolve="key" />
                    </node>
                  </node>
                </node>
              </node>
            </node>
            <node concept="3clFbH" id="4BP1plxWnij" role="3cqZAp" />
            <node concept="3clFbJ" id="4BP1plxWqim" role="3cqZAp">
              <node concept="3clFbS" id="4BP1plxWqio" role="3clFbx">
                <node concept="3clFbF" id="4BP1plyn4YN" role="3cqZAp">
                  <node concept="2OqwBi" id="4BP1plynewU" role="3clFbG">
                    <node concept="37vLTw" id="4BP1plyn4YL" role="2Oq$k0">
                      <ref role="3cqZAo" node="4BP1plxUY52" resolve="finalGroupedData" />
                    </node>
                    <node concept="liA8E" id="4BP1plynnWi" role="2OqNvi">
                      <ref role="37wK5l" to="33ny:~Map.put(java.lang.Object,java.lang.Object)" resolve="put" />
                      <node concept="37vLTw" id="4BP1plynyR0" role="37wK5m">
                        <ref role="3cqZAo" node="4BP1plxVw5V" resolve="key" />
                      </node>
                      <node concept="1rXfSq" id="4BP1plynIVw" role="37wK5m">
                        <ref role="37wK5l" node="4BP1plxX2z3" resolve="sumValues" />
                        <node concept="37vLTw" id="4BP1plynT2e" role="37wK5m">
                          <ref role="3cqZAo" node="4BP1plxVNxV" resolve="value" />
                        </node>
                      </node>
                    </node>
                  </node>
                </node>
              </node>
              <node concept="2OqwBi" id="4BP1plxWB9Z" role="3clFbw">
                <node concept="37vLTw" id="4BP1plxW$3E" role="2Oq$k0">
                  <ref role="3cqZAo" node="4BP1plxSa8G" resolve="operation" />
                </node>
                <node concept="liA8E" id="4BP1plxWEWC" role="2OqNvi">
                  <ref role="37wK5l" to="wyt6:~Enum.equals(java.lang.Object)" resolve="equals" />
                  <node concept="Rm8GO" id="4BP1plxWPet" role="37wK5m">
                    <ref role="Rm8GQ" to="4z85:4BP1plxRtKL" resolve="SUM" />
                    <ref role="1Px2BO" to="4z85:4BP1plxRthH" resolve="GroupByOperationType" />
                  </node>
                </node>
              </node>
              <node concept="3eNFk2" id="4BP1plyo3mH" role="3eNLev">
                <node concept="2OqwBi" id="4BP1plyox$S" role="3eO9$A">
                  <node concept="37vLTw" id="4BP1plyorTX" role="2Oq$k0">
                    <ref role="3cqZAo" node="4BP1plxSa8G" resolve="operation" />
                  </node>
                  <node concept="liA8E" id="4BP1plyoExU" role="2OqNvi">
                    <ref role="37wK5l" to="wyt6:~Enum.equals(java.lang.Object)" resolve="equals" />
                    <node concept="Rm8GO" id="4BP1plyp7Q5" role="37wK5m">
                      <ref role="Rm8GQ" to="4z85:4BP1plxRtye" resolve="MAX" />
                      <ref role="1Px2BO" to="4z85:4BP1plxRthH" resolve="GroupByOperationType" />
                    </node>
                  </node>
                </node>
                <node concept="3clFbS" id="4BP1plyo3mJ" role="3eOfB_">
                  <node concept="3clFbF" id="4BP1plypeTg" role="3cqZAp">
                    <node concept="2OqwBi" id="4BP1plypk$L" role="3clFbG">
                      <node concept="37vLTw" id="4BP1plypeTf" role="2Oq$k0">
                        <ref role="3cqZAo" node="4BP1plxUY52" resolve="finalGroupedData" />
                      </node>
                      <node concept="liA8E" id="4BP1plypwKr" role="2OqNvi">
                        <ref role="37wK5l" to="33ny:~Map.put(java.lang.Object,java.lang.Object)" resolve="put" />
                        <node concept="37vLTw" id="4BP1plypFk2" role="37wK5m">
                          <ref role="3cqZAo" node="4BP1plxVw5V" resolve="key" />
                        </node>
                        <node concept="1rXfSq" id="4BP1plypVFy" role="37wK5m">
                          <ref role="37wK5l" node="4BP1plxYJCa" resolve="maxValues" />
                          <node concept="37vLTw" id="4BP1plyq2Wl" role="37wK5m">
                            <ref role="3cqZAo" node="4BP1plxVNxV" resolve="value" />
                          </node>
                        </node>
                      </node>
                    </node>
                  </node>
                </node>
              </node>
              <node concept="3eNFk2" id="4BP1plyqeua" role="3eNLev">
                <node concept="2OqwBi" id="4BP1plyqJIH" role="3eO9$A">
                  <node concept="37vLTw" id="4BP1plyqEx4" role="2Oq$k0">
                    <ref role="3cqZAo" node="4BP1plxSa8G" resolve="operation" />
                  </node>
                  <node concept="liA8E" id="4BP1plyqQzs" role="2OqNvi">
                    <ref role="37wK5l" to="wyt6:~Enum.equals(java.lang.Object)" resolve="equals" />
                    <node concept="Rm8GO" id="4BP1plyrh$Y" role="37wK5m">
                      <ref role="Rm8GQ" to="4z85:4BP1plxRtzX" resolve="MIN" />
                      <ref role="1Px2BO" to="4z85:4BP1plxRthH" resolve="GroupByOperationType" />
                    </node>
                  </node>
                </node>
                <node concept="3clFbS" id="4BP1plyqeuc" role="3eOfB_">
                  <node concept="3clFbF" id="4BP1plyrnFS" role="3cqZAp">
                    <node concept="2OqwBi" id="4BP1plyrwFV" role="3clFbG">
                      <node concept="37vLTw" id="4BP1plyrnFR" role="2Oq$k0">
                        <ref role="3cqZAo" node="4BP1plxUY52" resolve="finalGroupedData" />
                      </node>
                      <node concept="liA8E" id="4BP1plyrDFo" role="2OqNvi">
                        <ref role="37wK5l" to="33ny:~Map.put(java.lang.Object,java.lang.Object)" resolve="put" />
                        <node concept="37vLTw" id="4BP1plyrNc7" role="37wK5m">
                          <ref role="3cqZAo" node="4BP1plxVw5V" resolve="key" />
                        </node>
                        <node concept="1rXfSq" id="4BP1plys3PW" role="37wK5m">
                          <ref role="37wK5l" node="4BP1plxZzTW" resolve="minValues" />
                          <node concept="37vLTw" id="4BP1plyseOG" role="37wK5m">
                            <ref role="3cqZAo" node="4BP1plxVNxV" resolve="value" />
                          </node>
                        </node>
                      </node>
                    </node>
                  </node>
                </node>
              </node>
              <node concept="3eNFk2" id="4BP1plysmWP" role="3eNLev">
                <node concept="2OqwBi" id="4BP1plysHGw" role="3eO9$A">
                  <node concept="37vLTw" id="4BP1plysypw" role="2Oq$k0">
                    <ref role="3cqZAo" node="4BP1plxSa8G" resolve="operation" />
                  </node>
                  <node concept="liA8E" id="4BP1plysPcV" role="2OqNvi">
                    <ref role="37wK5l" to="wyt6:~Enum.equals(java.lang.Object)" resolve="equals" />
                    <node concept="Rm8GO" id="4BP1plytjL$" role="37wK5m">
                      <ref role="Rm8GQ" to="4z85:4BP1plxRtFY" resolve="COUNT" />
                      <ref role="1Px2BO" to="4z85:4BP1plxRthH" resolve="GroupByOperationType" />
                    </node>
                  </node>
                </node>
                <node concept="3clFbS" id="4BP1plysmWR" role="3eOfB_">
                  <node concept="3clFbF" id="4BP1plytqiM" role="3cqZAp">
                    <node concept="2OqwBi" id="4BP1plytAFE" role="3clFbG">
                      <node concept="37vLTw" id="4BP1plytqiL" role="2Oq$k0">
                        <ref role="3cqZAo" node="4BP1plxUY52" resolve="finalGroupedData" />
                      </node>
                      <node concept="liA8E" id="4BP1plytN5C" role="2OqNvi">
                        <ref role="37wK5l" to="33ny:~Map.put(java.lang.Object,java.lang.Object)" resolve="put" />
                        <node concept="37vLTw" id="4BP1plytUx9" role="37wK5m">
                          <ref role="3cqZAo" node="4BP1plxVw5V" resolve="key" />
                        </node>
                        <node concept="10QFUN" id="4BP1plyuzm3" role="37wK5m">
                          <node concept="10P55v" id="4BP1plyuHfk" role="10QFUM" />
                          <node concept="2OqwBi" id="4BP1plyuhAP" role="10QFUP">
                            <node concept="37vLTw" id="4BP1plyubGI" role="2Oq$k0">
                              <ref role="3cqZAo" node="4BP1plxVNxV" resolve="value" />
                            </node>
                            <node concept="liA8E" id="4BP1plyunsw" role="2OqNvi">
                              <ref role="37wK5l" to="33ny:~List.size()" resolve="size" />
                            </node>
                          </node>
                        </node>
                      </node>
                    </node>
                  </node>
                </node>
              </node>
              <node concept="3eNFk2" id="4BP1plyuSfz" role="3eNLev">
                <node concept="2OqwBi" id="4BP1plyv7GW" role="3eO9$A">
                  <node concept="37vLTw" id="4BP1plyuZVz" role="2Oq$k0">
                    <ref role="3cqZAo" node="4BP1plxSa8G" resolve="operation" />
                  </node>
                  <node concept="liA8E" id="4BP1plyvjx0" role="2OqNvi">
                    <ref role="37wK5l" to="wyt6:~Enum.equals(java.lang.Object)" resolve="equals" />
                    <node concept="Rm8GO" id="4BP1plyvMIH" role="37wK5m">
                      <ref role="Rm8GQ" to="4z85:4BP1plxRtU7" resolve="AVG" />
                      <ref role="1Px2BO" to="4z85:4BP1plxRthH" resolve="GroupByOperationType" />
                    </node>
                  </node>
                </node>
                <node concept="3clFbS" id="4BP1plyuSf_" role="3eOfB_">
                  <node concept="3clFbF" id="4BP1plyvUXS" role="3cqZAp">
                    <node concept="2OqwBi" id="4BP1plyw0KN" role="3clFbG">
                      <node concept="37vLTw" id="4BP1plyvUXR" role="2Oq$k0">
                        <ref role="3cqZAo" node="4BP1plxUY52" resolve="finalGroupedData" />
                      </node>
                      <node concept="liA8E" id="4BP1plyw90m" role="2OqNvi">
                        <ref role="37wK5l" to="33ny:~Map.put(java.lang.Object,java.lang.Object)" resolve="put" />
                        <node concept="37vLTw" id="4BP1plywioI" role="37wK5m">
                          <ref role="3cqZAo" node="4BP1plxVw5V" resolve="key" />
                        </node>
                        <node concept="1rXfSq" id="4BP1plywzBk" role="37wK5m">
                          <ref role="37wK5l" node="4BP1ply02o0" resolve="avgValues" />
                          <node concept="37vLTw" id="4BP1plywJIg" role="37wK5m">
                            <ref role="3cqZAo" node="4BP1plxVNxV" resolve="value" />
                          </node>
                        </node>
                      </node>
                    </node>
                  </node>
                </node>
              </node>
            </node>
          </node>
          <node concept="3cpWsn" id="4BP1plxVw5V" role="1Duv9x">
            <property role="TrG5h" value="key" />
            <node concept="3uibUv" id="4BP1plxVyOc" role="1tU5fm">
              <ref role="3uigEE" to="33ny:~List" resolve="List" />
              <node concept="3uibUv" id="4BP1plxV$KT" role="11_B2D">
                <ref role="3uigEE" to="wyt6:~Object" resolve="Object" />
              </node>
            </node>
          </node>
          <node concept="2OqwBi" id="4BP1plxVHrf" role="1DdaDG">
            <node concept="37vLTw" id="4BP1plxVEDD" role="2Oq$k0">
              <ref role="3cqZAo" node="4BP1plxSbcY" resolve="groupedData" />
            </node>
            <node concept="liA8E" id="4BP1plxVK$P" role="2OqNvi">
              <ref role="37wK5l" to="33ny:~Map.keySet()" resolve="keySet" />
            </node>
          </node>
        </node>
        <node concept="3clFbH" id="4BP1plywTuz" role="3cqZAp" />
        <node concept="3cpWs8" id="4BP1plyxhJS" role="3cqZAp">
          <node concept="3cpWsn" id="4BP1plyxhJT" role="3cpWs9">
            <property role="TrG5h" value="resultTable" />
            <node concept="3uibUv" id="4BP1plyxhJU" role="1tU5fm">
              <ref role="3uigEE" to="6a2z:cd93YdJHRJ" resolve="Table" />
            </node>
            <node concept="2OqwBi" id="4BP1plyxNgt" role="33vP2m">
              <node concept="37vLTw" id="4BP1plyxHZD" role="2Oq$k0">
                <ref role="3cqZAo" node="4BP1plxSa8I" resolve="factoryTable" />
              </node>
              <node concept="liA8E" id="4BP1plyxZlr" role="2OqNvi">
                <ref role="37wK5l" to="6a2z:cd93YdSsBC" resolve="generateTable" />
              </node>
            </node>
          </node>
        </node>
        <node concept="3clFbF" id="4BP1plyyh3X" role="3cqZAp">
          <node concept="1rXfSq" id="4BP1plyyh3V" role="3clFbG">
            <ref role="37wK5l" node="4BP1ply1ghG" resolve="loadFromGroupByData" />
            <node concept="37vLTw" id="4BP1plyyutO" role="37wK5m">
              <ref role="3cqZAo" node="4BP1plyxhJT" resolve="resultTable" />
            </node>
            <node concept="37vLTw" id="4BP1plyyOoF" role="37wK5m">
              <ref role="3cqZAo" node="4BP1plxSahI" resolve="orderedGroupBy" />
            </node>
            <node concept="37vLTw" id="4BP1plyz4c9" role="37wK5m">
              <ref role="3cqZAo" node="4BP1plxUY52" resolve="finalGroupedData" />
            </node>
            <node concept="37vLTw" id="4BP1plyze5_" role="37wK5m">
              <ref role="3cqZAo" node="4BP1plxSa8E" resolve="operandColumn" />
            </node>
          </node>
        </node>
        <node concept="3clFbH" id="6gCHjbanqOM" role="3cqZAp" />
        <node concept="3clFbF" id="6gCHjbambDA" role="3cqZAp">
          <node concept="2YIFZM" id="6gCHjbamkZn" role="3clFbG">
            <ref role="37wK5l" to="810k:6gCHjbahhRx" resolve="log" />
            <ref role="1Pybhc" to="810k:6gCHjbahfKM" resolve="Logger" />
            <node concept="Rm8GO" id="6gCHjbamvYV" role="37wK5m">
              <ref role="Rm8GQ" to="810k:6gCHjbahhiU" resolve="INFO" />
              <ref role="1Px2BO" to="810k:6gCHjbahgOI" resolve="LogLevel" />
            </node>
            <node concept="Xl_RD" id="6gCHjbamBjz" role="37wK5m">
              <property role="Xl_RC" value="GroupByStepDefault success." />
            </node>
          </node>
        </node>
        <node concept="3clFbH" id="6gCHjbaoiGD" role="3cqZAp" />
        <node concept="3cpWs6" id="4BP1plyzxTJ" role="3cqZAp">
          <node concept="37vLTw" id="4BP1plyzCjd" role="3cqZAk">
            <ref role="3cqZAo" node="4BP1plyxhJT" resolve="resultTable" />
          </node>
        </node>
      </node>
      <node concept="2AHcQZ" id="4BP1plxSa8L" role="2AJF6D">
        <ref role="2AI5Lk" to="wyt6:~Override" />
      </node>
    </node>
    <node concept="2tJIrI" id="4BP1plxWRSw" role="jymVt" />
    <node concept="2YIFZL" id="4BP1plxX2z3" role="jymVt">
      <property role="TrG5h" value="sumValues" />
      <node concept="3clFbS" id="4BP1plxX2z6" role="3clF47">
        <node concept="3clFbJ" id="4BP1plxXtdB" role="3cqZAp">
          <node concept="2YIFZM" id="4BP1plxXwSD" role="3clFbw">
            <ref role="37wK5l" to="bhzw:cd93Ye8veC" resolve="allIntegers" />
            <ref role="1Pybhc" to="bhzw:cd93Ye7HaD" resolve="EnumUtils" />
            <node concept="37vLTw" id="4BP1plxXwVA" role="37wK5m">
              <ref role="3cqZAo" node="4BP1plxX7yF" resolve="values" />
            </node>
          </node>
          <node concept="3clFbS" id="4BP1plxXtdD" role="3clFbx">
            <node concept="3cpWs6" id="4BP1plxXwYY" role="3cqZAp">
              <node concept="2OqwBi" id="4BP1plxXFUU" role="3cqZAk">
                <node concept="2OqwBi" id="4BP1plxX_sK" role="2Oq$k0">
                  <node concept="2OqwBi" id="4BP1plxXxXe" role="2Oq$k0">
                    <node concept="37vLTw" id="4BP1plxXx2_" role="2Oq$k0">
                      <ref role="3cqZAo" node="4BP1plxX7yF" resolve="values" />
                    </node>
                    <node concept="liA8E" id="4BP1plxX$m0" role="2OqNvi">
                      <ref role="37wK5l" to="33ny:~Collection.stream()" resolve="stream" />
                    </node>
                  </node>
                  <node concept="liA8E" id="4BP1plxXAEN" role="2OqNvi">
                    <ref role="37wK5l" to="1ctc:~Stream.mapToInt(java.util.function.ToIntFunction)" resolve="mapToInt" />
                    <node concept="1bVj0M" id="4BP1plxXB2K" role="37wK5m">
                      <node concept="gl6BB" id="4BP1plxXB2Q" role="1bW2Oz">
                        <property role="TrG5h" value="e" />
                        <node concept="2jxLKc" id="4BP1plxXB2R" role="1tU5fm" />
                      </node>
                      <node concept="3clFbS" id="4BP1plxXB2U" role="1bW5cS">
                        <node concept="3clFbF" id="4BP1plxYykJ" role="3cqZAp">
                          <node concept="1eOMI4" id="4BP1plxYyDl" role="3clFbG">
                            <node concept="10QFUN" id="4BP1plxYyDi" role="1eOMHV">
                              <node concept="3uibUv" id="4BP1plxYz3q" role="10QFUM">
                                <ref role="3uigEE" to="wyt6:~Integer" resolve="Integer" />
                              </node>
                              <node concept="37vLTw" id="4BP1plxYyDn" role="10QFUP">
                                <ref role="3cqZAo" node="4BP1plxXB2Q" resolve="e" />
                              </node>
                            </node>
                          </node>
                        </node>
                      </node>
                    </node>
                  </node>
                </node>
                <node concept="liA8E" id="4BP1plxXHg7" role="2OqNvi">
                  <ref role="37wK5l" to="1ctc:~IntStream.sum()" resolve="sum" />
                </node>
              </node>
            </node>
          </node>
          <node concept="9aQIb" id="4BP1plxXUNm" role="9aQIa">
            <node concept="3clFbS" id="4BP1plxXUNn" role="9aQI4">
              <node concept="3cpWs6" id="4BP1plxXV7j" role="3cqZAp">
                <node concept="2OqwBi" id="4BP1plxYuhM" role="3cqZAk">
                  <node concept="2OqwBi" id="4BP1plxXYWz" role="2Oq$k0">
                    <node concept="2OqwBi" id="4BP1plxXWwH" role="2Oq$k0">
                      <node concept="37vLTw" id="4BP1plxXVs4" role="2Oq$k0">
                        <ref role="3cqZAo" node="4BP1plxX7yF" resolve="values" />
                      </node>
                      <node concept="liA8E" id="4BP1plxXXHV" role="2OqNvi">
                        <ref role="37wK5l" to="33ny:~Collection.stream()" resolve="stream" />
                      </node>
                    </node>
                    <node concept="liA8E" id="4BP1plxY00B" role="2OqNvi">
                      <ref role="37wK5l" to="1ctc:~Stream.mapToDouble(java.util.function.ToDoubleFunction)" resolve="mapToDouble" />
                      <node concept="37Ijox" id="4BP1plxY26_" role="37wK5m">
                        <ref role="37Ijqf" node="4BP1plxYg5_" resolve="toDouble" />
                        <node concept="2FaPjH" id="4BP1plxY26B" role="wWaWy">
                          <node concept="3uibUv" id="4BP1plxY26C" role="2FaQuo">
                            <ref role="3uigEE" node="4BP1plxRt8Y" resolve="GroupByStepDefault" />
                          </node>
                        </node>
                      </node>
                    </node>
                  </node>
                  <node concept="liA8E" id="4BP1plxYwy3" role="2OqNvi">
                    <ref role="37wK5l" to="1ctc:~DoubleStream.sum()" resolve="sum" />
                  </node>
                </node>
              </node>
            </node>
          </node>
        </node>
      </node>
      <node concept="3Tm6S6" id="4BP1plxWXuy" role="1B3o_S" />
      <node concept="3uibUv" id="4BP1plxX13R" role="3clF45">
        <ref role="3uigEE" to="wyt6:~Object" resolve="Object" />
      </node>
      <node concept="37vLTG" id="4BP1plxX7yF" role="3clF46">
        <property role="TrG5h" value="values" />
        <node concept="3uibUv" id="4BP1plxX7yE" role="1tU5fm">
          <ref role="3uigEE" to="33ny:~List" resolve="List" />
          <node concept="3uibUv" id="4BP1plxX7OP" role="11_B2D">
            <ref role="3uigEE" to="wyt6:~Object" resolve="Object" />
          </node>
        </node>
      </node>
    </node>
    <node concept="2tJIrI" id="4BP1plxYzrl" role="jymVt" />
    <node concept="2YIFZL" id="4BP1plxYJCa" role="jymVt">
      <property role="TrG5h" value="maxValues" />
      <node concept="3clFbS" id="4BP1plxYJCd" role="3clF47">
        <node concept="3clFbJ" id="4BP1plxYPVL" role="3cqZAp">
          <node concept="2YIFZM" id="4BP1plxYQ3c" role="3clFbw">
            <ref role="37wK5l" to="bhzw:cd93Ye8veC" resolve="allIntegers" />
            <ref role="1Pybhc" to="bhzw:cd93Ye7HaD" resolve="EnumUtils" />
            <node concept="37vLTw" id="4BP1plxYQ6y" role="37wK5m">
              <ref role="3cqZAo" node="4BP1plxYNXC" resolve="values" />
            </node>
          </node>
          <node concept="3clFbS" id="4BP1plxYPVN" role="3clFbx">
            <node concept="3cpWs6" id="4BP1plxYQa1" role="3cqZAp">
              <node concept="2OqwBi" id="4BP1plxYYeR" role="3cqZAk">
                <node concept="2OqwBi" id="4BP1plxYWaM" role="2Oq$k0">
                  <node concept="2OqwBi" id="4BP1plxYTg6" role="2Oq$k0">
                    <node concept="2OqwBi" id="4BP1plxYR94" role="2Oq$k0">
                      <node concept="37vLTw" id="4BP1plxYQer" role="2Oq$k0">
                        <ref role="3cqZAo" node="4BP1plxYNXC" resolve="values" />
                      </node>
                      <node concept="liA8E" id="4BP1plxYS59" role="2OqNvi">
                        <ref role="37wK5l" to="33ny:~Collection.stream()" resolve="stream" />
                      </node>
                    </node>
                    <node concept="liA8E" id="4BP1plxYUgf" role="2OqNvi">
                      <ref role="37wK5l" to="1ctc:~Stream.mapToInt(java.util.function.ToIntFunction)" resolve="mapToInt" />
                      <node concept="1bVj0M" id="4BP1plxYUJ9" role="37wK5m">
                        <node concept="gl6BB" id="4BP1plxYUJf" role="1bW2Oz">
                          <property role="TrG5h" value="e" />
                          <node concept="2jxLKc" id="4BP1plxYUJg" role="1tU5fm" />
                        </node>
                        <node concept="3clFbS" id="4BP1plxYUJj" role="1bW5cS">
                          <node concept="3clFbF" id="4BP1plxYVhW" role="3cqZAp">
                            <node concept="10QFUN" id="4BP1plxYVtT" role="3clFbG">
                              <node concept="37vLTw" id="4BP1plxYVtS" role="10QFUP">
                                <ref role="3cqZAo" node="4BP1plxYUJf" resolve="e" />
                              </node>
                              <node concept="3uibUv" id="4BP1plxYVCF" role="10QFUM">
                                <ref role="3uigEE" to="wyt6:~Integer" resolve="Integer" />
                              </node>
                            </node>
                          </node>
                        </node>
                      </node>
                    </node>
                  </node>
                  <node concept="liA8E" id="4BP1plxYXJl" role="2OqNvi">
                    <ref role="37wK5l" to="1ctc:~IntStream.max()" resolve="max" />
                  </node>
                </node>
                <node concept="liA8E" id="4BP1plxYZbI" role="2OqNvi">
                  <ref role="37wK5l" to="33ny:~OptionalInt.orElse(int)" resolve="orElse" />
                  <node concept="10M0yZ" id="4BP1plxYZZ8" role="37wK5m">
                    <ref role="3cqZAo" to="wyt6:~Integer.MIN_VALUE" resolve="MIN_VALUE" />
                    <ref role="1PxDUh" to="wyt6:~Integer" resolve="Integer" />
                  </node>
                </node>
              </node>
            </node>
          </node>
          <node concept="9aQIb" id="4BP1plxZ0$5" role="9aQIa">
            <node concept="3clFbS" id="4BP1plxZ0$6" role="9aQI4">
              <node concept="3cpWs6" id="4BP1plxZ182" role="3cqZAp">
                <node concept="2OqwBi" id="4BP1plxZgxi" role="3cqZAk">
                  <node concept="2OqwBi" id="4BP1plxZdt1" role="2Oq$k0">
                    <node concept="2OqwBi" id="4BP1plxZ6wQ" role="2Oq$k0">
                      <node concept="2OqwBi" id="4BP1plxZ2vc" role="2Oq$k0">
                        <node concept="37vLTw" id="4BP1plxZ1kL" role="2Oq$k0">
                          <ref role="3cqZAo" node="4BP1plxYNXC" resolve="values" />
                        </node>
                        <node concept="liA8E" id="4BP1plxZ516" role="2OqNvi">
                          <ref role="37wK5l" to="33ny:~Collection.stream()" resolve="stream" />
                        </node>
                      </node>
                      <node concept="liA8E" id="4BP1plxZ8N6" role="2OqNvi">
                        <ref role="37wK5l" to="1ctc:~Stream.mapToDouble(java.util.function.ToDoubleFunction)" resolve="mapToDouble" />
                        <node concept="37Ijox" id="4BP1plxZb2p" role="37wK5m">
                          <ref role="37Ijqf" node="4BP1plxYg5_" resolve="toDouble" />
                          <node concept="2FaPjH" id="4BP1plxZb2r" role="wWaWy">
                            <node concept="3uibUv" id="4BP1plxZb2s" role="2FaQuo">
                              <ref role="3uigEE" node="4BP1plxRt8Y" resolve="GroupByStepDefault" />
                            </node>
                          </node>
                        </node>
                      </node>
                    </node>
                    <node concept="liA8E" id="4BP1plxZfWi" role="2OqNvi">
                      <ref role="37wK5l" to="1ctc:~DoubleStream.max()" resolve="max" />
                    </node>
                  </node>
                  <node concept="liA8E" id="4BP1plxZiks" role="2OqNvi">
                    <ref role="37wK5l" to="33ny:~OptionalDouble.orElse(double)" resolve="orElse" />
                    <node concept="10M0yZ" id="4BP1plxZk2Z" role="37wK5m">
                      <ref role="3cqZAo" to="wyt6:~Double.MIN_VALUE" resolve="MIN_VALUE" />
                      <ref role="1PxDUh" to="wyt6:~Double" resolve="Double" />
                    </node>
                  </node>
                </node>
              </node>
            </node>
          </node>
        </node>
      </node>
      <node concept="3Tm6S6" id="4BP1plxYCis" role="1B3o_S" />
      <node concept="3uibUv" id="4BP1plxYIAu" role="3clF45">
        <ref role="3uigEE" to="wyt6:~Object" resolve="Object" />
      </node>
      <node concept="37vLTG" id="4BP1plxYNXC" role="3clF46">
        <property role="TrG5h" value="values" />
        <node concept="3uibUv" id="4BP1plxYNXB" role="1tU5fm">
          <ref role="3uigEE" to="33ny:~List" resolve="List" />
          <node concept="3uibUv" id="4BP1plxYORo" role="11_B2D">
            <ref role="3uigEE" to="wyt6:~Object" resolve="Object" />
          </node>
        </node>
      </node>
    </node>
    <node concept="2tJIrI" id="4BP1plxY55m" role="jymVt" />
    <node concept="2YIFZL" id="4BP1plxZzTW" role="jymVt">
      <property role="TrG5h" value="minValues" />
      <node concept="3clFbS" id="4BP1plxZzTX" role="3clF47">
        <node concept="3clFbJ" id="4BP1plxZzTY" role="3cqZAp">
          <node concept="2YIFZM" id="4BP1plxZzTZ" role="3clFbw">
            <ref role="37wK5l" to="bhzw:cd93Ye8veC" resolve="allIntegers" />
            <ref role="1Pybhc" to="bhzw:cd93Ye7HaD" resolve="EnumUtils" />
            <node concept="37vLTw" id="4BP1plxZzU0" role="37wK5m">
              <ref role="3cqZAo" node="4BP1plxZzUB" resolve="values" />
            </node>
          </node>
          <node concept="3clFbS" id="4BP1plxZzU1" role="3clFbx">
            <node concept="3cpWs6" id="4BP1plxZzU2" role="3cqZAp">
              <node concept="2OqwBi" id="4BP1plxZzU3" role="3cqZAk">
                <node concept="2OqwBi" id="4BP1plxZzU4" role="2Oq$k0">
                  <node concept="2OqwBi" id="4BP1plxZzU5" role="2Oq$k0">
                    <node concept="2OqwBi" id="4BP1plxZzU6" role="2Oq$k0">
                      <node concept="37vLTw" id="4BP1plxZzU7" role="2Oq$k0">
                        <ref role="3cqZAo" node="4BP1plxZzUB" resolve="values" />
                      </node>
                      <node concept="liA8E" id="4BP1plxZzU8" role="2OqNvi">
                        <ref role="37wK5l" to="33ny:~Collection.stream()" resolve="stream" />
                      </node>
                    </node>
                    <node concept="liA8E" id="4BP1plxZzU9" role="2OqNvi">
                      <ref role="37wK5l" to="1ctc:~Stream.mapToInt(java.util.function.ToIntFunction)" resolve="mapToInt" />
                      <node concept="1bVj0M" id="4BP1plxZzUa" role="37wK5m">
                        <node concept="gl6BB" id="4BP1plxZzUb" role="1bW2Oz">
                          <property role="TrG5h" value="e" />
                          <node concept="2jxLKc" id="4BP1plxZzUc" role="1tU5fm" />
                        </node>
                        <node concept="3clFbS" id="4BP1plxZzUd" role="1bW5cS">
                          <node concept="3clFbF" id="4BP1plxZzUe" role="3cqZAp">
                            <node concept="10QFUN" id="4BP1plxZzUf" role="3clFbG">
                              <node concept="37vLTw" id="4BP1plxZzUg" role="10QFUP">
                                <ref role="3cqZAo" node="4BP1plxZzUb" resolve="e" />
                              </node>
                              <node concept="3uibUv" id="4BP1plxZzUh" role="10QFUM">
                                <ref role="3uigEE" to="wyt6:~Integer" resolve="Integer" />
                              </node>
                            </node>
                          </node>
                        </node>
                      </node>
                    </node>
                  </node>
                  <node concept="liA8E" id="4BP1plxZzUi" role="2OqNvi">
                    <ref role="37wK5l" to="1ctc:~IntStream.min()" resolve="min" />
                  </node>
                </node>
                <node concept="liA8E" id="4BP1plxZzUj" role="2OqNvi">
                  <ref role="37wK5l" to="33ny:~OptionalInt.orElse(int)" resolve="orElse" />
                  <node concept="10M0yZ" id="4BP1plxZJr6" role="37wK5m">
                    <ref role="3cqZAo" to="wyt6:~Integer.MAX_VALUE" resolve="MAX_VALUE" />
                    <ref role="1PxDUh" to="wyt6:~Integer" resolve="Integer" />
                  </node>
                </node>
              </node>
            </node>
          </node>
          <node concept="9aQIb" id="4BP1plxZzUl" role="9aQIa">
            <node concept="3clFbS" id="4BP1plxZzUm" role="9aQI4">
              <node concept="3cpWs6" id="4BP1plxZzUn" role="3cqZAp">
                <node concept="2OqwBi" id="4BP1plxZzUo" role="3cqZAk">
                  <node concept="2OqwBi" id="4BP1plxZzUp" role="2Oq$k0">
                    <node concept="2OqwBi" id="4BP1plxZzUq" role="2Oq$k0">
                      <node concept="2OqwBi" id="4BP1plxZzUr" role="2Oq$k0">
                        <node concept="37vLTw" id="4BP1plxZzUs" role="2Oq$k0">
                          <ref role="3cqZAo" node="4BP1plxZzUB" resolve="values" />
                        </node>
                        <node concept="liA8E" id="4BP1plxZzUt" role="2OqNvi">
                          <ref role="37wK5l" to="33ny:~Collection.stream()" resolve="stream" />
                        </node>
                      </node>
                      <node concept="liA8E" id="4BP1plxZzUu" role="2OqNvi">
                        <ref role="37wK5l" to="1ctc:~Stream.mapToDouble(java.util.function.ToDoubleFunction)" resolve="mapToDouble" />
                        <node concept="37Ijox" id="4BP1plxZzUv" role="37wK5m">
                          <ref role="37Ijqf" node="4BP1plxYg5_" resolve="toDouble" />
                          <node concept="2FaPjH" id="4BP1plxZzUw" role="wWaWy">
                            <node concept="3uibUv" id="4BP1plxZzUx" role="2FaQuo">
                              <ref role="3uigEE" node="4BP1plxRt8Y" resolve="GroupByStepDefault" />
                            </node>
                          </node>
                        </node>
                      </node>
                    </node>
                    <node concept="liA8E" id="4BP1plxZzUy" role="2OqNvi">
                      <ref role="37wK5l" to="1ctc:~DoubleStream.min()" resolve="min" />
                    </node>
                  </node>
                  <node concept="liA8E" id="4BP1plxZzUz" role="2OqNvi">
                    <ref role="37wK5l" to="33ny:~OptionalDouble.orElse(double)" resolve="orElse" />
                    <node concept="10M0yZ" id="4BP1plxZMxi" role="37wK5m">
                      <ref role="3cqZAo" to="wyt6:~Double.MAX_VALUE" resolve="MAX_VALUE" />
                      <ref role="1PxDUh" to="wyt6:~Double" resolve="Double" />
                    </node>
                  </node>
                </node>
              </node>
            </node>
          </node>
        </node>
      </node>
      <node concept="3Tm6S6" id="4BP1plxZzU_" role="1B3o_S" />
      <node concept="3uibUv" id="4BP1plxZzUA" role="3clF45">
        <ref role="3uigEE" to="wyt6:~Object" resolve="Object" />
      </node>
      <node concept="37vLTG" id="4BP1plxZzUB" role="3clF46">
        <property role="TrG5h" value="values" />
        <node concept="3uibUv" id="4BP1plxZzUC" role="1tU5fm">
          <ref role="3uigEE" to="33ny:~List" resolve="List" />
          <node concept="3uibUv" id="4BP1plxZzUD" role="11_B2D">
            <ref role="3uigEE" to="wyt6:~Object" resolve="Object" />
          </node>
        </node>
      </node>
    </node>
    <node concept="2tJIrI" id="4BP1plxZMU3" role="jymVt" />
    <node concept="2YIFZL" id="4BP1ply02o0" role="jymVt">
      <property role="TrG5h" value="avgValues" />
      <node concept="3clFbS" id="4BP1ply02o3" role="3clF47">
        <node concept="3cpWs8" id="4BP1ply0bV3" role="3cqZAp">
          <node concept="3cpWsn" id="4BP1ply0bV6" role="3cpWs9">
            <property role="TrG5h" value="sum" />
            <node concept="10P55v" id="4BP1ply0bV2" role="1tU5fm" />
            <node concept="2OqwBi" id="4BP1ply0l4y" role="33vP2m">
              <node concept="2OqwBi" id="4BP1ply0fo7" role="2Oq$k0">
                <node concept="2OqwBi" id="4BP1ply0d8e" role="2Oq$k0">
                  <node concept="37vLTw" id="4BP1ply0c45" role="2Oq$k0">
                    <ref role="3cqZAo" node="4BP1ply09Cz" resolve="values" />
                  </node>
                  <node concept="liA8E" id="4BP1ply0e3U" role="2OqNvi">
                    <ref role="37wK5l" to="33ny:~Collection.stream()" resolve="stream" />
                  </node>
                </node>
                <node concept="liA8E" id="4BP1ply0gw3" role="2OqNvi">
                  <ref role="37wK5l" to="1ctc:~Stream.mapToDouble(java.util.function.ToDoubleFunction)" resolve="mapToDouble" />
                  <node concept="37Ijox" id="4BP1ply0j3b" role="37wK5m">
                    <ref role="37Ijqf" node="4BP1plxYg5_" resolve="toDouble" />
                    <node concept="2FaPjH" id="4BP1ply0j3d" role="wWaWy">
                      <node concept="3uibUv" id="4BP1ply0j3e" role="2FaQuo">
                        <ref role="3uigEE" node="4BP1plxRt8Y" resolve="GroupByStepDefault" />
                      </node>
                    </node>
                  </node>
                </node>
              </node>
              <node concept="liA8E" id="4BP1ply0nsS" role="2OqNvi">
                <ref role="37wK5l" to="1ctc:~DoubleStream.sum()" resolve="sum" />
              </node>
            </node>
          </node>
        </node>
        <node concept="3cpWs8" id="4BP1ply0o7z" role="3cqZAp">
          <node concept="3cpWsn" id="4BP1ply0o7A" role="3cpWs9">
            <property role="TrG5h" value="avg" />
            <node concept="10P55v" id="4BP1ply0o7x" role="1tU5fm" />
            <node concept="FJ1c_" id="4BP1ply0rwu" role="33vP2m">
              <node concept="2OqwBi" id="4BP1ply0sSb" role="3uHU7w">
                <node concept="37vLTw" id="4BP1ply0rHX" role="2Oq$k0">
                  <ref role="3cqZAo" node="4BP1ply09Cz" resolve="values" />
                </node>
                <node concept="liA8E" id="4BP1ply0uwQ" role="2OqNvi">
                  <ref role="37wK5l" to="33ny:~List.size()" resolve="size" />
                </node>
              </node>
              <node concept="37vLTw" id="4BP1ply0oQt" role="3uHU7B">
                <ref role="3cqZAo" node="4BP1ply0bV6" resolve="sum" />
              </node>
            </node>
          </node>
        </node>
        <node concept="3cpWs8" id="4BP1ply0w5u" role="3cqZAp">
          <node concept="3cpWsn" id="4BP1ply0w5x" role="3cpWs9">
            <property role="TrG5h" value="rounded" />
            <node concept="10P55v" id="4BP1ply0w5s" role="1tU5fm" />
            <node concept="2OqwBi" id="4BP1ply0DAo" role="33vP2m">
              <node concept="2OqwBi" id="4BP1ply0zNC" role="2Oq$k0">
                <node concept="2YIFZM" id="4BP1ply0y3F" role="2Oq$k0">
                  <ref role="37wK5l" to="xlxw:~BigDecimal.valueOf(double)" resolve="valueOf" />
                  <ref role="1Pybhc" to="xlxw:~BigDecimal" resolve="BigDecimal" />
                  <node concept="37vLTw" id="4BP1ply0ytx" role="37wK5m">
                    <ref role="3cqZAo" node="4BP1ply0o7A" resolve="avg" />
                  </node>
                </node>
                <node concept="liA8E" id="4BP1ply0__w" role="2OqNvi">
                  <ref role="37wK5l" to="xlxw:~BigDecimal.setScale(int,java.math.RoundingMode)" resolve="setScale" />
                  <node concept="3cmrfG" id="4BP1ply0A2Q" role="37wK5m">
                    <property role="3cmrfH" value="2" />
                  </node>
                  <node concept="Rm8GO" id="4BP1ply0Ch0" role="37wK5m">
                    <ref role="Rm8GQ" to="xlxw:~RoundingMode.HALF_UP" resolve="HALF_UP" />
                    <ref role="1Px2BO" to="xlxw:~RoundingMode" resolve="RoundingMode" />
                  </node>
                </node>
              </node>
              <node concept="liA8E" id="4BP1ply0FBY" role="2OqNvi">
                <ref role="37wK5l" to="xlxw:~BigDecimal.doubleValue()" resolve="doubleValue" />
              </node>
            </node>
          </node>
        </node>
        <node concept="3clFbJ" id="4BP1ply0HA6" role="3cqZAp">
          <node concept="3clFbS" id="4BP1ply0HA8" role="3clFbx">
            <node concept="3cpWs6" id="4BP1ply0Tf6" role="3cqZAp">
              <node concept="10QFUN" id="4BP1ply0TTa" role="3cqZAk">
                <node concept="10Oyi0" id="4BP1ply0V_u" role="10QFUM" />
                <node concept="37vLTw" id="4BP1ply0Tyj" role="10QFUP">
                  <ref role="3cqZAo" node="4BP1ply0w5x" resolve="rounded" />
                </node>
              </node>
            </node>
          </node>
          <node concept="1Wc70l" id="4BP1ply0MWY" role="3clFbw">
            <node concept="3clFbC" id="4BP1ply0POJ" role="3uHU7w">
              <node concept="2YIFZM" id="4BP1ply0RzC" role="3uHU7w">
                <ref role="37wK5l" to="wyt6:~Math.floor(double)" resolve="floor" />
                <ref role="1Pybhc" to="wyt6:~Math" resolve="Math" />
                <node concept="37vLTw" id="4BP1ply0SWm" role="37wK5m">
                  <ref role="3cqZAo" node="4BP1ply0w5x" resolve="rounded" />
                </node>
              </node>
              <node concept="37vLTw" id="4BP1ply0NT8" role="3uHU7B">
                <ref role="3cqZAo" node="4BP1ply0w5x" resolve="rounded" />
              </node>
            </node>
            <node concept="2YIFZM" id="4BP1ply0JXq" role="3uHU7B">
              <ref role="37wK5l" to="bhzw:cd93Ye8veC" resolve="allIntegers" />
              <ref role="1Pybhc" to="bhzw:cd93Ye7HaD" resolve="EnumUtils" />
              <node concept="37vLTw" id="4BP1ply0Kg7" role="37wK5m">
                <ref role="3cqZAo" node="4BP1ply09Cz" resolve="values" />
              </node>
            </node>
          </node>
          <node concept="9aQIb" id="4BP1ply0WSp" role="9aQIa">
            <node concept="3clFbS" id="4BP1ply0WSq" role="9aQI4">
              <node concept="3cpWs6" id="4BP1ply0Xbr" role="3cqZAp">
                <node concept="37vLTw" id="4BP1ply0XtY" role="3cqZAk">
                  <ref role="3cqZAo" node="4BP1ply0w5x" resolve="rounded" />
                </node>
              </node>
            </node>
          </node>
        </node>
      </node>
      <node concept="3Tm6S6" id="4BP1plxZUN2" role="1B3o_S" />
      <node concept="3uibUv" id="4BP1ply00qM" role="3clF45">
        <ref role="3uigEE" to="wyt6:~Object" resolve="Object" />
      </node>
      <node concept="37vLTG" id="4BP1ply09Cz" role="3clF46">
        <property role="TrG5h" value="values" />
        <node concept="3uibUv" id="4BP1ply09Cy" role="1tU5fm">
          <ref role="3uigEE" to="33ny:~List" resolve="List" />
          <node concept="3uibUv" id="4BP1ply0ayB" role="11_B2D">
            <ref role="3uigEE" to="wyt6:~Object" resolve="Object" />
          </node>
        </node>
      </node>
    </node>
    <node concept="2tJIrI" id="4BP1plxZkrL" role="jymVt" />
    <node concept="2YIFZL" id="4BP1plxYg5_" role="jymVt">
      <property role="TrG5h" value="toDouble" />
      <node concept="3clFbS" id="4BP1plxYg5C" role="3clF47">
        <node concept="3clFbJ" id="4BP1plxYnn0" role="3cqZAp">
          <node concept="2ZW3vV" id="4BP1plxYnzI" role="3clFbw">
            <node concept="3uibUv" id="4BP1plxYnBm" role="2ZW6by">
              <ref role="3uigEE" to="wyt6:~Integer" resolve="Integer" />
            </node>
            <node concept="37vLTw" id="4BP1plxYnps" role="2ZW6bz">
              <ref role="3cqZAo" node="4BP1plxYmhU" resolve="e" />
            </node>
          </node>
          <node concept="3clFbS" id="4BP1plxYnn2" role="3clFbx">
            <node concept="3cpWs6" id="4BP1plxYraM" role="3cqZAp">
              <node concept="2OqwBi" id="4BP1plxYpLj" role="3cqZAk">
                <node concept="1eOMI4" id="4BP1plxYodx" role="2Oq$k0">
                  <node concept="10QFUN" id="4BP1plxYodu" role="1eOMHV">
                    <node concept="3uibUv" id="4BP1plxYodz" role="10QFUM">
                      <ref role="3uigEE" to="wyt6:~Integer" resolve="Integer" />
                    </node>
                    <node concept="37vLTw" id="4BP1plxYod$" role="10QFUP">
                      <ref role="3cqZAo" node="4BP1plxYmhU" resolve="e" />
                    </node>
                  </node>
                </node>
                <node concept="liA8E" id="4BP1plxYr2Z" role="2OqNvi">
                  <ref role="37wK5l" to="wyt6:~Integer.doubleValue()" resolve="doubleValue" />
                </node>
              </node>
            </node>
          </node>
          <node concept="3eNFk2" id="4BP1plxYrgs" role="3eNLev">
            <node concept="2ZW3vV" id="4BP1plxYruM" role="3eO9$A">
              <node concept="3uibUv" id="4BP1plxYryj" role="2ZW6by">
                <ref role="3uigEE" to="wyt6:~Double" resolve="Double" />
              </node>
              <node concept="37vLTw" id="4BP1plxYrjV" role="2ZW6bz">
                <ref role="3cqZAo" node="4BP1plxYmhU" resolve="e" />
              </node>
            </node>
            <node concept="3clFbS" id="4BP1plxYrgu" role="3eOfB_">
              <node concept="3cpWs6" id="4BP1plxYr_W" role="3cqZAp">
                <node concept="1eOMI4" id="4BP1plxYrJB" role="3cqZAk">
                  <node concept="10QFUN" id="4BP1plxYrJ$" role="1eOMHV">
                    <node concept="3uibUv" id="4BP1plxYrJD" role="10QFUM">
                      <ref role="3uigEE" to="wyt6:~Double" resolve="Double" />
                    </node>
                    <node concept="37vLTw" id="4BP1plxYrJE" role="10QFUP">
                      <ref role="3cqZAo" node="4BP1plxYmhU" resolve="e" />
                    </node>
                  </node>
                </node>
              </node>
            </node>
          </node>
          <node concept="9aQIb" id="4BP1plxYrR9" role="9aQIa">
            <node concept="3clFbS" id="4BP1plxYrRa" role="9aQI4">
              <node concept="3clFbF" id="6gCHjbaoRQW" role="3cqZAp">
                <node concept="2YIFZM" id="6gCHjbaoRQX" role="3clFbG">
                  <ref role="37wK5l" to="810k:6gCHjbahhRx" resolve="log" />
                  <ref role="1Pybhc" to="810k:6gCHjbahfKM" resolve="Logger" />
                  <node concept="Rm8GO" id="6gCHjbapfSk" role="37wK5m">
                    <ref role="Rm8GQ" to="810k:6gCHjbahh9p" resolve="ERROR" />
                    <ref role="1Px2BO" to="810k:6gCHjbahgOI" resolve="LogLevel" />
                  </node>
                  <node concept="Xl_RD" id="6gCHjbaoRQZ" role="37wK5m">
                    <property role="Xl_RC" value="Error in GroupByStepDefault: unsupported number type." />
                  </node>
                </node>
              </node>
              <node concept="YS8fn" id="4BP1plxYrVd" role="3cqZAp">
                <node concept="2ShNRf" id="4BP1plxYrVE" role="YScLw">
                  <node concept="1pGfFk" id="4BP1plxYsFK" role="2ShVmc">
                    <property role="373rjd" value="true" />
                    <ref role="37wK5l" to="wyt6:~IllegalArgumentException.&lt;init&gt;(java.lang.String)" resolve="IllegalArgumentException" />
                    <node concept="Xl_RD" id="4BP1plxYsTp" role="37wK5m">
                      <property role="Xl_RC" value="Unsupported number type" />
                    </node>
                  </node>
                </node>
              </node>
            </node>
          </node>
        </node>
      </node>
      <node concept="3Tm6S6" id="4BP1plxYbdA" role="1B3o_S" />
      <node concept="10P55v" id="4BP1plxYg3N" role="3clF45" />
      <node concept="37vLTG" id="4BP1plxYmhU" role="3clF46">
        <property role="TrG5h" value="e" />
        <node concept="3uibUv" id="4BP1plxYmhT" role="1tU5fm">
          <ref role="3uigEE" to="wyt6:~Object" resolve="Object" />
        </node>
      </node>
    </node>
    <node concept="2tJIrI" id="4BP1ply0ZrC" role="jymVt" />
    <node concept="3clFb_" id="4BP1ply1ghG" role="jymVt">
      <property role="TrG5h" value="loadFromGroupByData" />
      <node concept="3clFbS" id="4BP1ply1ghJ" role="3clF47">
        <node concept="3clFbH" id="4BP1ply1R_8" role="3cqZAp" />
        <node concept="1DcWWT" id="4BP1ply21h5" role="3cqZAp">
          <node concept="3clFbS" id="4BP1ply21h7" role="2LFqv$">
            <node concept="3cpWs8" id="4BP1ply2wob" role="3cqZAp">
              <node concept="3cpWsn" id="4BP1ply2woe" role="3cpWs9">
                <property role="TrG5h" value="indexColumnListReceived" />
                <node concept="10Oyi0" id="4BP1ply2wo9" role="1tU5fm" />
                <node concept="2OqwBi" id="4BP1ply3agc" role="33vP2m">
                  <node concept="37vLTw" id="4BP1ply33PG" role="2Oq$k0">
                    <ref role="3cqZAo" node="4BP1ply1wzF" resolve="groupByList" />
                  </node>
                  <node concept="liA8E" id="4BP1ply3i5b" role="2OqNvi">
                    <ref role="37wK5l" to="33ny:~List.indexOf(java.lang.Object)" resolve="indexOf" />
                    <node concept="37vLTw" id="4BP1ply3p5o" role="37wK5m">
                      <ref role="3cqZAo" node="4BP1ply21h8" resolve="column" />
                    </node>
                  </node>
                </node>
              </node>
            </node>
            <node concept="3clFbJ" id="4BP1ply3Wtv" role="3cqZAp">
              <node concept="3clFbS" id="4BP1ply3Wtx" role="3clFbx">
                <node concept="3N13vt" id="4BP1ply4TAw" role="3cqZAp" />
              </node>
              <node concept="22lmx$" id="4BP1ply4m3y" role="3clFbw">
                <node concept="2OqwBi" id="4BP1ply4zbJ" role="3uHU7w">
                  <node concept="37vLTw" id="4BP1ply4vpd" role="2Oq$k0">
                    <ref role="3cqZAo" node="4BP1ply21h8" resolve="column" />
                  </node>
                  <node concept="liA8E" id="4BP1ply4Get" role="2OqNvi">
                    <ref role="37wK5l" to="6a2z:cd93YdOgHi" resolve="equals" />
                    <node concept="37vLTw" id="4BP1ply4KvV" role="37wK5m">
                      <ref role="3cqZAo" node="4BP1ply1L3l" resolve="operandColumn" />
                    </node>
                  </node>
                </node>
                <node concept="3clFbC" id="4BP1ply4aC$" role="3uHU7B">
                  <node concept="37vLTw" id="4BP1ply40Kb" role="3uHU7B">
                    <ref role="3cqZAo" node="4BP1ply2woe" resolve="indexColumnListReceived" />
                  </node>
                  <node concept="3cmrfG" id="4BP1ply4e_N" role="3uHU7w">
                    <property role="3cmrfH" value="-1" />
                  </node>
                </node>
              </node>
            </node>
            <node concept="3clFbH" id="4BP1ply91fI" role="3cqZAp" />
            <node concept="3cpWs8" id="4BP1ply57Wp" role="3cqZAp">
              <node concept="3cpWsn" id="4BP1ply57Wv" role="3cpWs9">
                <property role="TrG5h" value="columnLineInfo" />
                <node concept="3uibUv" id="4BP1ply57Wx" role="1tU5fm">
                  <ref role="3uigEE" to="33ny:~Map" resolve="Map" />
                  <node concept="3uibUv" id="4BP1ply5dW0" role="11_B2D">
                    <ref role="3uigEE" to="wyt6:~Integer" resolve="Integer" />
                  </node>
                  <node concept="3uibUv" id="4BP1ply5ptF" role="11_B2D">
                    <ref role="3uigEE" to="wyt6:~Object" resolve="Object" />
                  </node>
                </node>
                <node concept="2ShNRf" id="4BP1ply6lMY" role="33vP2m">
                  <node concept="1pGfFk" id="4BP1ply6uZk" role="2ShVmc">
                    <property role="373rjd" value="true" />
                    <ref role="37wK5l" to="33ny:~HashMap.&lt;init&gt;()" resolve="HashMap" />
                  </node>
                </node>
              </node>
            </node>
            <node concept="3clFbH" id="4BP1ply6$At" role="3cqZAp" />
            <node concept="3cpWs8" id="4BP1ply6Gkp" role="3cqZAp">
              <node concept="3cpWsn" id="4BP1ply6Gks" role="3cpWs9">
                <property role="TrG5h" value="lineCounter" />
                <node concept="10Oyi0" id="4BP1ply6Gkn" role="1tU5fm" />
                <node concept="3cmrfG" id="4BP1ply7aDf" role="33vP2m">
                  <property role="3cmrfH" value="1" />
                </node>
              </node>
            </node>
            <node concept="1DcWWT" id="4BP1ply7ll5" role="3cqZAp">
              <node concept="3clFbS" id="4BP1ply7ll7" role="2LFqv$">
                <node concept="3cpWs8" id="4BP1ply8db6" role="3cqZAp">
                  <node concept="3cpWsn" id="4BP1ply8db7" role="3cpWs9">
                    <property role="TrG5h" value="valueToString" />
                    <node concept="3uibUv" id="4BP1ply8db8" role="1tU5fm">
                      <ref role="3uigEE" to="wyt6:~String" resolve="String" />
                    </node>
                    <node concept="2OqwBi" id="4BP1ply9xFW" role="33vP2m">
                      <node concept="2OqwBi" id="4BP1ply8Bmj" role="2Oq$k0">
                        <node concept="37vLTw" id="4BP1ply8ygG" role="2Oq$k0">
                          <ref role="3cqZAo" node="4BP1ply7ll8" resolve="key" />
                        </node>
                        <node concept="liA8E" id="4BP1ply8LrI" role="2OqNvi">
                          <ref role="37wK5l" to="33ny:~List.get(int)" resolve="get" />
                          <node concept="37vLTw" id="4BP1ply9nUK" role="37wK5m">
                            <ref role="3cqZAo" node="4BP1ply2woe" resolve="indexColumnListReceived" />
                          </node>
                        </node>
                      </node>
                      <node concept="liA8E" id="4BP1ply9BKL" role="2OqNvi">
                        <ref role="37wK5l" to="wyt6:~Object.toString()" resolve="toString" />
                      </node>
                    </node>
                  </node>
                </node>
                <node concept="3cpWs8" id="4BP1ply9UFx" role="3cqZAp">
                  <node concept="3cpWsn" id="4BP1ply9UFy" role="3cpWs9">
                    <property role="TrG5h" value="value" />
                    <node concept="3uibUv" id="4BP1ply9UFz" role="1tU5fm">
                      <ref role="3uigEE" to="wyt6:~Object" resolve="Object" />
                    </node>
                    <node concept="2YIFZM" id="4BP1plyahAq" role="33vP2m">
                      <ref role="37wK5l" to="bhzw:cd93Ye8jAj" resolve="parseValue" />
                      <ref role="1Pybhc" to="bhzw:cd93Ye7HaD" resolve="EnumUtils" />
                      <node concept="37vLTw" id="4BP1plyamQU" role="37wK5m">
                        <ref role="3cqZAo" node="4BP1ply8db7" resolve="valueToString" />
                      </node>
                      <node concept="2OqwBi" id="4BP1plyaDjK" role="37wK5m">
                        <node concept="37vLTw" id="4BP1plyazBf" role="2Oq$k0">
                          <ref role="3cqZAo" node="4BP1ply21h8" resolve="column" />
                        </node>
                        <node concept="liA8E" id="4BP1plyaL9T" role="2OqNvi">
                          <ref role="37wK5l" to="6a2z:cd93YdOdyB" resolve="type" />
                        </node>
                      </node>
                    </node>
                  </node>
                </node>
                <node concept="3clFbH" id="4BP1plyaR8O" role="3cqZAp" />
                <node concept="3clFbF" id="4BP1plyb0W8" role="3cqZAp">
                  <node concept="2OqwBi" id="4BP1plybasH" role="3clFbG">
                    <node concept="37vLTw" id="4BP1plyb0W6" role="2Oq$k0">
                      <ref role="3cqZAo" node="4BP1ply57Wv" resolve="columnLineInfo" />
                    </node>
                    <node concept="liA8E" id="4BP1plybgSe" role="2OqNvi">
                      <ref role="37wK5l" to="33ny:~Map.put(java.lang.Object,java.lang.Object)" resolve="put" />
                      <node concept="3uNrnE" id="4BP1plybyG$" role="37wK5m">
                        <node concept="37vLTw" id="4BP1plybyGA" role="2$L3a6">
                          <ref role="3cqZAo" node="4BP1ply6Gks" resolve="lineCounter" />
                        </node>
                      </node>
                      <node concept="37vLTw" id="4BP1plybFUZ" role="37wK5m">
                        <ref role="3cqZAo" node="4BP1ply9UFy" resolve="value" />
                      </node>
                    </node>
                  </node>
                </node>
              </node>
              <node concept="3cpWsn" id="4BP1ply7ll8" role="1Duv9x">
                <property role="TrG5h" value="key" />
                <node concept="3uibUv" id="4BP1ply7uq1" role="1tU5fm">
                  <ref role="3uigEE" to="33ny:~List" resolve="List" />
                  <node concept="3uibUv" id="4BP1ply7yJa" role="11_B2D">
                    <ref role="3uigEE" to="wyt6:~Object" resolve="Object" />
                  </node>
                </node>
              </node>
              <node concept="2OqwBi" id="4BP1ply7OwS" role="1DdaDG">
                <node concept="37vLTw" id="4BP1ply7K6t" role="2Oq$k0">
                  <ref role="3cqZAo" node="4BP1ply1_kg" resolve="data" />
                </node>
                <node concept="liA8E" id="4BP1ply7YmF" role="2OqNvi">
                  <ref role="37wK5l" to="33ny:~Map.keySet()" resolve="keySet" />
                </node>
              </node>
            </node>
            <node concept="3clFbH" id="4BP1ply91fK" role="3cqZAp" />
            <node concept="3clFbF" id="4BP1plybM69" role="3cqZAp">
              <node concept="2OqwBi" id="4BP1plycdVY" role="3clFbG">
                <node concept="2OqwBi" id="4BP1plybWBP" role="2Oq$k0">
                  <node concept="37vLTw" id="4BP1plybM67" role="2Oq$k0">
                    <ref role="3cqZAo" node="4BP1ply1pV2" resolve="resultTable" />
                  </node>
                  <node concept="liA8E" id="4BP1plyc2QG" role="2OqNvi">
                    <ref role="37wK5l" to="6a2z:cd93YdQ8ZE" resolve="getColumnInfo" />
                  </node>
                </node>
                <node concept="liA8E" id="4BP1plycl2B" role="2OqNvi">
                  <ref role="37wK5l" to="33ny:~Map.put(java.lang.Object,java.lang.Object)" resolve="put" />
                  <node concept="37vLTw" id="4BP1plycv0_" role="37wK5m">
                    <ref role="3cqZAo" node="4BP1ply21h8" resolve="column" />
                  </node>
                  <node concept="37vLTw" id="4BP1plycCDZ" role="37wK5m">
                    <ref role="3cqZAo" node="4BP1ply57Wv" resolve="columnLineInfo" />
                  </node>
                </node>
              </node>
            </node>
          </node>
          <node concept="3cpWsn" id="4BP1ply21h8" role="1Duv9x">
            <property role="TrG5h" value="column" />
            <node concept="3uibUv" id="4BP1ply24YJ" role="1tU5fm">
              <ref role="3uigEE" to="6a2z:cd93YdJHTQ" resolve="Column" />
            </node>
          </node>
          <node concept="2OqwBi" id="4BP1ply2jsh" role="1DdaDG">
            <node concept="37vLTw" id="4BP1ply2gdv" role="2Oq$k0">
              <ref role="3cqZAo" node="4BP1ply1pV2" resolve="resultTable" />
            </node>
            <node concept="liA8E" id="4BP1ply2r5A" role="2OqNvi">
              <ref role="37wK5l" to="6a2z:cd93YdP6bz" resolve="getColumnList" />
            </node>
          </node>
        </node>
        <node concept="3clFbH" id="4BP1plycNdQ" role="3cqZAp" />
        <node concept="3cpWs8" id="4BP1plyd1zB" role="3cqZAp">
          <node concept="3cpWsn" id="4BP1plyd1zC" role="3cpWs9">
            <property role="TrG5h" value="columnLineInfo" />
            <node concept="3uibUv" id="4BP1plyd1z_" role="1tU5fm">
              <ref role="3uigEE" to="33ny:~Map" resolve="Map" />
              <node concept="3uibUv" id="4BP1plydcmp" role="11_B2D">
                <ref role="3uigEE" to="wyt6:~Integer" resolve="Integer" />
              </node>
              <node concept="3uibUv" id="4BP1plydrV4" role="11_B2D">
                <ref role="3uigEE" to="wyt6:~Object" resolve="Object" />
              </node>
            </node>
            <node concept="2ShNRf" id="4BP1plyefJ$" role="33vP2m">
              <node concept="1pGfFk" id="4BP1plyeodB" role="2ShVmc">
                <property role="373rjd" value="true" />
                <ref role="37wK5l" to="33ny:~HashMap.&lt;init&gt;()" resolve="HashMap" />
              </node>
            </node>
          </node>
        </node>
        <node concept="3cpWs8" id="4BP1plyeASo" role="3cqZAp">
          <node concept="3cpWsn" id="4BP1plyeASr" role="3cpWs9">
            <property role="TrG5h" value="lineCounter" />
            <node concept="10Oyi0" id="4BP1plyeASm" role="1tU5fm" />
            <node concept="3cmrfG" id="4BP1plyeFyj" role="33vP2m">
              <property role="3cmrfH" value="1" />
            </node>
          </node>
        </node>
        <node concept="1DcWWT" id="4BP1plyeZ0s" role="3cqZAp">
          <node concept="3clFbS" id="4BP1plyeZ0u" role="2LFqv$">
            <node concept="3cpWs8" id="4BP1plyfMro" role="3cqZAp">
              <node concept="3cpWsn" id="4BP1plyfMrp" role="3cpWs9">
                <property role="TrG5h" value="value" />
                <node concept="3uibUv" id="4BP1plyfMrq" role="1tU5fm">
                  <ref role="3uigEE" to="wyt6:~Object" resolve="Object" />
                </node>
                <node concept="2YIFZM" id="4BP1plyghX$" role="33vP2m">
                  <ref role="37wK5l" to="bhzw:cd93Ye8jAj" resolve="parseValue" />
                  <ref role="1Pybhc" to="bhzw:cd93Ye7HaD" resolve="EnumUtils" />
                  <node concept="2OqwBi" id="4BP1plygPyR" role="37wK5m">
                    <node concept="37vLTw" id="4BP1plygrJ9" role="2Oq$k0">
                      <ref role="3cqZAo" node="4BP1plyeZ0v" resolve="key" />
                    </node>
                    <node concept="liA8E" id="4BP1plygZlE" role="2OqNvi">
                      <ref role="37wK5l" to="wyt6:~Object.toString()" resolve="toString" />
                    </node>
                  </node>
                  <node concept="2OqwBi" id="4BP1plyhlop" role="37wK5m">
                    <node concept="37vLTw" id="4BP1plyhcvZ" role="2Oq$k0">
                      <ref role="3cqZAo" node="4BP1ply1L3l" resolve="operandColumn" />
                    </node>
                    <node concept="liA8E" id="4BP1plyhuco" role="2OqNvi">
                      <ref role="37wK5l" to="6a2z:cd93YdOdyB" resolve="type" />
                    </node>
                  </node>
                </node>
              </node>
            </node>
            <node concept="3clFbF" id="4BP1plyhGw3" role="3cqZAp">
              <node concept="2OqwBi" id="4BP1plyhLWv" role="3clFbG">
                <node concept="37vLTw" id="4BP1plyhGw1" role="2Oq$k0">
                  <ref role="3cqZAo" node="4BP1plyd1zC" resolve="columnLineInfo" />
                </node>
                <node concept="liA8E" id="4BP1plyhU8h" role="2OqNvi">
                  <ref role="37wK5l" to="33ny:~Map.put(java.lang.Object,java.lang.Object)" resolve="put" />
                  <node concept="3uNrnE" id="4BP1plyicIO" role="37wK5m">
                    <node concept="37vLTw" id="4BP1plyicIQ" role="2$L3a6">
                      <ref role="3cqZAo" node="4BP1plyeASr" resolve="lineCounter" />
                    </node>
                  </node>
                  <node concept="37vLTw" id="4BP1plyinOU" role="37wK5m">
                    <ref role="3cqZAo" node="4BP1plyfMrp" resolve="value" />
                  </node>
                </node>
              </node>
            </node>
          </node>
          <node concept="3cpWsn" id="4BP1plyeZ0v" role="1Duv9x">
            <property role="TrG5h" value="key" />
            <node concept="3uibUv" id="4BP1plyf5_w" role="1tU5fm">
              <ref role="3uigEE" to="wyt6:~Object" resolve="Object" />
            </node>
          </node>
          <node concept="2OqwBi" id="4BP1plyfqE3" role="1DdaDG">
            <node concept="37vLTw" id="4BP1plyfllX" role="2Oq$k0">
              <ref role="3cqZAo" node="4BP1ply1_kg" resolve="data" />
            </node>
            <node concept="liA8E" id="4BP1plyfA0_" role="2OqNvi">
              <ref role="37wK5l" to="33ny:~Map.values()" resolve="values" />
            </node>
          </node>
        </node>
        <node concept="3clFbH" id="4BP1plyiwCx" role="3cqZAp" />
        <node concept="3cpWs8" id="4BP1plyiOdJ" role="3cqZAp">
          <node concept="3cpWsn" id="4BP1plyiOdK" role="3cpWs9">
            <property role="TrG5h" value="referencedExistingColumn" />
            <node concept="3uibUv" id="4BP1plyiOdL" role="1tU5fm">
              <ref role="3uigEE" to="6a2z:cd93YdJHTQ" resolve="Column" />
            </node>
            <node concept="2OqwBi" id="4BP1plyluC4" role="33vP2m">
              <node concept="2OqwBi" id="4BP1plyl9XD" role="2Oq$k0">
                <node concept="2OqwBi" id="4BP1plyjYc9" role="2Oq$k0">
                  <node concept="2OqwBi" id="4BP1plyjF6Q" role="2Oq$k0">
                    <node concept="2OqwBi" id="4BP1plyjokT" role="2Oq$k0">
                      <node concept="37vLTw" id="4BP1plyjkp7" role="2Oq$k0">
                        <ref role="3cqZAo" node="4BP1ply1pV2" resolve="resultTable" />
                      </node>
                      <node concept="liA8E" id="4BP1plyjyKA" role="2OqNvi">
                        <ref role="37wK5l" to="6a2z:cd93YdP6bz" resolve="getColumnList" />
                      </node>
                    </node>
                    <node concept="liA8E" id="4BP1plyjR3$" role="2OqNvi">
                      <ref role="37wK5l" to="33ny:~Collection.stream()" resolve="stream" />
                    </node>
                  </node>
                  <node concept="liA8E" id="4BP1plyk9Vd" role="2OqNvi">
                    <ref role="37wK5l" to="1ctc:~Stream.filter(java.util.function.Predicate)" resolve="filter" />
                    <node concept="1bVj0M" id="4BP1plykgP1" role="37wK5m">
                      <node concept="gl6BB" id="4BP1plykgPj" role="1bW2Oz">
                        <property role="TrG5h" value="c" />
                        <node concept="2jxLKc" id="4BP1plykgPk" role="1tU5fm" />
                      </node>
                      <node concept="3clFbS" id="4BP1plykgPn" role="1bW5cS">
                        <node concept="3clFbF" id="4BP1plykyUy" role="3cqZAp">
                          <node concept="2OqwBi" id="4BP1plykBLD" role="3clFbG">
                            <node concept="37vLTw" id="4BP1plykyUx" role="2Oq$k0">
                              <ref role="3cqZAo" node="4BP1plykgPj" resolve="c" />
                            </node>
                            <node concept="liA8E" id="4BP1plykNJm" role="2OqNvi">
                              <ref role="37wK5l" to="6a2z:cd93YdOgHi" resolve="equals" />
                              <node concept="37vLTw" id="4BP1plykYsY" role="37wK5m">
                                <ref role="3cqZAo" node="4BP1ply1L3l" resolve="operandColumn" />
                              </node>
                            </node>
                          </node>
                        </node>
                      </node>
                    </node>
                  </node>
                </node>
                <node concept="liA8E" id="4BP1plyliGM" role="2OqNvi">
                  <ref role="37wK5l" to="1ctc:~Stream.findFirst()" resolve="findFirst" />
                </node>
              </node>
              <node concept="liA8E" id="4BP1plylAfP" role="2OqNvi">
                <ref role="37wK5l" to="33ny:~Optional.get()" resolve="get" />
              </node>
            </node>
          </node>
        </node>
        <node concept="3clFbH" id="4BP1ply4ZPH" role="3cqZAp" />
        <node concept="3clFbF" id="4BP1plylS2f" role="3cqZAp">
          <node concept="2OqwBi" id="4BP1plymm2k" role="3clFbG">
            <node concept="2OqwBi" id="4BP1plym2PY" role="2Oq$k0">
              <node concept="37vLTw" id="4BP1plylS2d" role="2Oq$k0">
                <ref role="3cqZAo" node="4BP1ply1pV2" resolve="resultTable" />
              </node>
              <node concept="liA8E" id="4BP1plymefs" role="2OqNvi">
                <ref role="37wK5l" to="6a2z:cd93YdQ8ZE" resolve="getColumnInfo" />
              </node>
            </node>
            <node concept="liA8E" id="4BP1plymyau" role="2OqNvi">
              <ref role="37wK5l" to="33ny:~Map.put(java.lang.Object,java.lang.Object)" resolve="put" />
              <node concept="37vLTw" id="4BP1plymC9L" role="37wK5m">
                <ref role="3cqZAo" node="4BP1plyiOdK" resolve="referencedExistingColumn" />
              </node>
              <node concept="37vLTw" id="4BP1plymVlv" role="37wK5m">
                <ref role="3cqZAo" node="4BP1plyd1zC" resolve="columnLineInfo" />
              </node>
            </node>
          </node>
        </node>
      </node>
      <node concept="3Tm6S6" id="4BP1ply17wD" role="1B3o_S" />
      <node concept="3cqZAl" id="4BP1ply1gf_" role="3clF45" />
      <node concept="37vLTG" id="4BP1ply1pV2" role="3clF46">
        <property role="TrG5h" value="resultTable" />
        <node concept="3uibUv" id="4BP1ply1pV1" role="1tU5fm">
          <ref role="3uigEE" to="6a2z:cd93YdJHRJ" resolve="Table" />
        </node>
      </node>
      <node concept="37vLTG" id="4BP1ply1wzF" role="3clF46">
        <property role="TrG5h" value="groupByList" />
        <node concept="3uibUv" id="4BP1ply1$gy" role="1tU5fm">
          <ref role="3uigEE" to="33ny:~List" resolve="List" />
          <node concept="3uibUv" id="4BP1ply1_b2" role="11_B2D">
            <ref role="3uigEE" to="6a2z:cd93YdJHTQ" resolve="Column" />
          </node>
        </node>
      </node>
      <node concept="37vLTG" id="4BP1ply1_kg" role="3clF46">
        <property role="TrG5h" value="data" />
        <node concept="3uibUv" id="4BP1ply1Cwo" role="1tU5fm">
          <ref role="3uigEE" to="33ny:~Map" resolve="Map" />
          <node concept="3uibUv" id="4BP1ply1Gfm" role="11_B2D">
            <ref role="3uigEE" to="33ny:~List" resolve="List" />
            <node concept="3uibUv" id="4BP1ply1Hat" role="11_B2D">
              <ref role="3uigEE" to="wyt6:~Object" resolve="Object" />
            </node>
          </node>
          <node concept="3uibUv" id="4BP1ply1IV9" role="11_B2D">
            <ref role="3uigEE" to="wyt6:~Object" resolve="Object" />
          </node>
        </node>
      </node>
      <node concept="37vLTG" id="4BP1ply1L3l" role="3clF46">
        <property role="TrG5h" value="operandColumn" />
        <node concept="3uibUv" id="4BP1ply1Q$_" role="1tU5fm">
          <ref role="3uigEE" to="6a2z:cd93YdJHTQ" resolve="Column" />
        </node>
      </node>
    </node>
  </node>
  <node concept="3HP615" id="4BP1plxRt9a">
    <property role="TrG5h" value="IGroupByStep" />
    <property role="2HnT6v" value="program.src.main.java.org.enorm.domain.steps.groupByStep" />
    <node concept="3clFb_" id="4BP1plxRtaM" role="jymVt">
      <property role="TrG5h" value="apply" />
      <node concept="3clFbS" id="4BP1plxRtaP" role="3clF47" />
      <node concept="3Tm1VV" id="4BP1plxRtaQ" role="1B3o_S" />
      <node concept="3uibUv" id="4BP1plxRtaC" role="3clF45">
        <ref role="3uigEE" to="6a2z:cd93YdJHRJ" resolve="Table" />
      </node>
      <node concept="37vLTG" id="4BP1plxRtbg" role="3clF46">
        <property role="TrG5h" value="inputTable" />
        <node concept="3uibUv" id="4BP1plxRtbf" role="1tU5fm">
          <ref role="3uigEE" to="6a2z:cd93YdJHRJ" resolve="Table" />
        </node>
      </node>
      <node concept="37vLTG" id="4BP1plxRtdg" role="3clF46">
        <property role="TrG5h" value="groupBy" />
        <node concept="3uibUv" id="4BP1plxRtdI" role="1tU5fm">
          <ref role="3uigEE" to="33ny:~List" resolve="List" />
          <node concept="3uibUv" id="4BP1plxRtef" role="11_B2D">
            <ref role="3uigEE" to="6a2z:cd93YdJHTQ" resolve="Column" />
          </node>
        </node>
      </node>
      <node concept="37vLTG" id="4BP1plxRtfC" role="3clF46">
        <property role="TrG5h" value="operandColumn" />
        <node concept="3uibUv" id="4BP1plxRtg4" role="1tU5fm">
          <ref role="3uigEE" to="6a2z:cd93YdJHTQ" resolve="Column" />
        </node>
      </node>
      <node concept="37vLTG" id="4BP1plxRthh" role="3clF46">
        <property role="TrG5h" value="operation" />
        <node concept="3uibUv" id="4BP1plxS8ZN" role="1tU5fm">
          <ref role="3uigEE" to="4z85:4BP1plxRthH" resolve="GroupByOperationType" />
        </node>
      </node>
      <node concept="37vLTG" id="4BP1plxS90B" role="3clF46">
        <property role="TrG5h" value="factoryTable" />
        <node concept="3uibUv" id="4BP1plxS913" role="1tU5fm">
          <ref role="3uigEE" to="6a2z:cd93YdSsAK" resolve="FactoryTable" />
        </node>
      </node>
    </node>
    <node concept="3Tm1VV" id="4BP1plxRt9b" role="1B3o_S" />
    <node concept="n94m4" id="4BP1plxRt9c" role="lGtFl" />
  </node>
  <node concept="bUwia" id="7mnL6ODCnxj">
    <property role="TrG5h" value="main" />
    <node concept="3lhOvk" id="7mnL6ODCnxk" role="3lj3bC">
      <ref role="30HIoZ" to="y20r:5ZmGmhlCEN7" resolve="Group" />
      <ref role="3lhOvi" node="4BP1plxRt8Y" resolve="GroupByStepDefault" />
    </node>
    <node concept="3lhOvk" id="7mnL6ODCnxl" role="3lj3bC">
      <ref role="30HIoZ" to="y20r:5ZmGmhlCEN7" resolve="Group" />
      <ref role="3lhOvi" node="4BP1plxRt8M" resolve="FactoryGroupByStep" />
    </node>
    <node concept="3lhOvk" id="7mnL6ODCnxm" role="3lj3bC">
      <ref role="30HIoZ" to="y20r:5ZmGmhlCEN7" resolve="Group" />
      <ref role="3lhOvi" node="4BP1plxRt9a" resolve="IGroupByStep" />
    </node>
  </node>
</model>

