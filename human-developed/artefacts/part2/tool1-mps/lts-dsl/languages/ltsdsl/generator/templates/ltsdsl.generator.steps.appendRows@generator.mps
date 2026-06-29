<?xml version="1.0" encoding="UTF-8"?>
<model ref="r:e233f196-0e07-4645-a64b-ebf9ce935438(ltsdsl.generator.steps.appendRows@generator)">
  <persistence version="9" />
  <languages>
    <use id="515552c7-fcc0-4ab4-9789-2f3c49344e85" name="jetbrains.mps.baseLanguage.varVariable" version="0" />
    <devkit ref="a2eb3a43-fcc2-4200-80dc-c60110c4862d(jetbrains.mps.devkit.templates)" />
  </languages>
  <imports>
    <import index="y20r" ref="r:85f52e46-7a19-44f9-bf10-6677b89edd73(ltsdsl.structure)" />
    <import index="33ny" ref="6354ebe7-c22a-4a0f-ac54-50b52ab9b065/java:java.util(JDK/)" />
    <import index="6a2z" ref="r:1c985b49-e2d4-4b0a-ac27-a43894ccaff0(ltsdsl.generator.tables@generator)" />
    <import index="810k" ref="r:7a125382-cddb-4c4f-8e8b-3d8533cae26c(ltsdsl.generator.main@generator)" />
    <import index="1ctc" ref="6354ebe7-c22a-4a0f-ac54-50b52ab9b065/java:java.util.stream(JDK/)" implicit="true" />
    <import index="wyt6" ref="6354ebe7-c22a-4a0f-ac54-50b52ab9b065/java:java.lang(JDK/)" implicit="true" />
  </imports>
  <registry>
    <language id="f3061a53-9226-4cc5-a443-f952ceaf5816" name="jetbrains.mps.baseLanguage">
      <concept id="1215693861676" name="jetbrains.mps.baseLanguage.structure.BaseAssignmentExpression" flags="nn" index="d038R">
        <child id="1068498886297" name="rValue" index="37vLTx" />
        <child id="1068498886295" name="lValue" index="37vLTJ" />
      </concept>
      <concept id="1202948039474" name="jetbrains.mps.baseLanguage.structure.InstanceMethodCallOperation" flags="nn" index="liA8E" />
      <concept id="1465982738277781862" name="jetbrains.mps.baseLanguage.structure.PlaceholderMember" flags="nn" index="2tJIrI" />
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
      <concept id="1068580123155" name="jetbrains.mps.baseLanguage.structure.ExpressionStatement" flags="nn" index="3clFbF">
        <child id="1068580123156" name="expression" index="3clFbG" />
      </concept>
      <concept id="1068580123157" name="jetbrains.mps.baseLanguage.structure.Statement" flags="nn" index="3clFbH" />
      <concept id="1068580123136" name="jetbrains.mps.baseLanguage.structure.StatementList" flags="sn" stub="5293379017992965193" index="3clFbS">
        <child id="1068581517665" name="statement" index="3cqZAp" />
      </concept>
      <concept id="1068581242875" name="jetbrains.mps.baseLanguage.structure.PlusExpression" flags="nn" index="3cpWs3" />
      <concept id="1068581242878" name="jetbrains.mps.baseLanguage.structure.ReturnStatement" flags="nn" index="3cpWs6">
        <child id="1068581517676" name="expression" index="3cqZAk" />
      </concept>
      <concept id="1068581242864" name="jetbrains.mps.baseLanguage.structure.LocalVariableDeclarationStatement" flags="nn" index="3cpWs8">
        <child id="1068581242865" name="localVariableDeclaration" index="3cpWs9" />
      </concept>
      <concept id="1068581517677" name="jetbrains.mps.baseLanguage.structure.VoidType" flags="in" index="3cqZAl" />
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
      <concept id="1178549954367" name="jetbrains.mps.baseLanguage.structure.IVisible" flags="ngI" index="1B3ioH">
        <child id="1178549979242" name="visibility" index="1B3o_S" />
      </concept>
      <concept id="1144226303539" name="jetbrains.mps.baseLanguage.structure.ForeachStatement" flags="nn" index="1DcWWT">
        <child id="1144226360166" name="iterable" index="1DdaDG" />
      </concept>
      <concept id="1144230876926" name="jetbrains.mps.baseLanguage.structure.AbstractForStatement" flags="nn" index="1DupvO">
        <child id="1144230900587" name="variable" index="1Duv9x" />
      </concept>
      <concept id="1107796713796" name="jetbrains.mps.baseLanguage.structure.Interface" flags="ig" index="3HP615" />
      <concept id="1146644602865" name="jetbrains.mps.baseLanguage.structure.PublicVisibility" flags="nn" index="3Tm1VV" />
      <concept id="1146644623116" name="jetbrains.mps.baseLanguage.structure.PrivateVisibility" flags="nn" index="3Tm6S6" />
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
    <language id="515552c7-fcc0-4ab4-9789-2f3c49344e85" name="jetbrains.mps.baseLanguage.varVariable">
      <concept id="1177714083117" name="jetbrains.mps.baseLanguage.varVariable.structure.VarType" flags="in" index="PeGgZ" />
      <concept id="1236693300889" name="jetbrains.mps.baseLanguage.varVariable.structure.VarVariableDeclaration" flags="ng" index="3KEzu6" />
    </language>
  </registry>
  <node concept="312cEu" id="cd93YdZi2R">
    <property role="TrG5h" value="AppendRowsStepDefault" />
    <property role="2HnT6v" value="program.src.main.java.org.enorm.domain.steps.appendRowsStep" />
    <node concept="3clFb_" id="cd93YdZrQ3" role="jymVt">
      <property role="TrG5h" value="apply" />
      <node concept="3clFbS" id="cd93YdZrQ6" role="3clF47">
        <node concept="3cpWs8" id="cd93YdZsOE" role="3cqZAp">
          <node concept="3KEzu6" id="cd93YdZsOB" role="3cpWs9">
            <property role="TrG5h" value="appendAfterLine" />
            <node concept="PeGgZ" id="cd93YdZsOC" role="1tU5fm" />
            <node concept="2OqwBi" id="cd93YdZt3Y" role="33vP2m">
              <node concept="37vLTw" id="cd93YdZsY1" role="2Oq$k0">
                <ref role="3cqZAo" node="cd93YdZrS4" resolve="to" />
              </node>
              <node concept="liA8E" id="cd93YdZtoe" role="2OqNvi">
                <ref role="37wK5l" to="6a2z:cd93YdR6a9" resolve="getNumLines" />
              </node>
            </node>
          </node>
        </node>
        <node concept="3clFbH" id="cd93YdZtqh" role="3cqZAp" />
        <node concept="1DcWWT" id="cd93YdZtsS" role="3cqZAp">
          <node concept="3clFbS" id="cd93YdZtsU" role="2LFqv$">
            <node concept="3cpWs8" id="cd93YdZwC1" role="3cqZAp">
              <node concept="3KEzu6" id="cd93YdZwBY" role="3cpWs9">
                <property role="TrG5h" value="sourceCells" />
                <node concept="PeGgZ" id="cd93YdZwBZ" role="1tU5fm" />
                <node concept="2OqwBi" id="cd93YdZFR1" role="33vP2m">
                  <node concept="2OqwBi" id="cd93YdZCHm" role="2Oq$k0">
                    <node concept="37vLTw" id="cd93YdZBuy" role="2Oq$k0">
                      <ref role="3cqZAo" node="cd93YdZrQA" resolve="from" />
                    </node>
                    <node concept="liA8E" id="cd93YdZE40" role="2OqNvi">
                      <ref role="37wK5l" to="6a2z:cd93YdQ8ZE" resolve="getColumnInfo" />
                    </node>
                  </node>
                  <node concept="liA8E" id="cd93YdZJBU" role="2OqNvi">
                    <ref role="37wK5l" to="33ny:~Map.get(java.lang.Object)" resolve="get" />
                    <node concept="2OqwBi" id="cd93YdZMzL" role="37wK5m">
                      <node concept="37vLTw" id="cd93YdZKXy" role="2Oq$k0">
                        <ref role="3cqZAo" node="cd93YdZtw2" resolve="mapping" />
                      </node>
                      <node concept="liA8E" id="cd93YdZQgr" role="2OqNvi">
                        <ref role="37wK5l" to="33ny:~Map$Entry.getKey()" resolve="getKey" />
                      </node>
                    </node>
                  </node>
                </node>
              </node>
            </node>
            <node concept="3cpWs8" id="cd93YdZU0C" role="3cqZAp">
              <node concept="3KEzu6" id="cd93YdZU0_" role="3cpWs9">
                <property role="TrG5h" value="sourceLines" />
                <node concept="PeGgZ" id="cd93YdZU0A" role="1tU5fm" />
                <node concept="2OqwBi" id="cd93Ye0kr6" role="33vP2m">
                  <node concept="2OqwBi" id="cd93Ye0fX5" role="2Oq$k0">
                    <node concept="2OqwBi" id="cd93Ye0avl" role="2Oq$k0">
                      <node concept="37vLTw" id="cd93Ye08DB" role="2Oq$k0">
                        <ref role="3cqZAo" node="cd93YdZwBY" resolve="sourceCells" />
                      </node>
                      <node concept="liA8E" id="cd93Ye0dBK" role="2OqNvi">
                        <ref role="37wK5l" to="33ny:~Map.keySet()" resolve="keySet" />
                      </node>
                    </node>
                    <node concept="liA8E" id="cd93Ye0iwe" role="2OqNvi">
                      <ref role="37wK5l" to="33ny:~Collection.stream()" resolve="stream" />
                    </node>
                  </node>
                  <node concept="liA8E" id="cd93Ye0ogI" role="2OqNvi">
                    <ref role="37wK5l" to="1ctc:~Stream.toList()" resolve="toList" />
                  </node>
                </node>
              </node>
            </node>
            <node concept="3cpWs8" id="cd93Ye0sot" role="3cqZAp">
              <node concept="3KEzu6" id="cd93Ye0soq" role="3cpWs9">
                <property role="TrG5h" value="sourceCellsTransformed" />
                <node concept="PeGgZ" id="cd93Ye0sor" role="1tU5fm" />
                <node concept="2ShNRf" id="cd93Ye0B8u" role="33vP2m">
                  <node concept="1pGfFk" id="cd93Ye0CLt" role="2ShVmc">
                    <property role="373rjd" value="true" />
                    <ref role="37wK5l" to="33ny:~HashMap.&lt;init&gt;()" resolve="HashMap" />
                    <node concept="3uibUv" id="cd93Ye0FCL" role="1pMfVU">
                      <ref role="3uigEE" to="wyt6:~Integer" resolve="Integer" />
                    </node>
                    <node concept="3uibUv" id="cd93Ye0IvZ" role="1pMfVU">
                      <ref role="3uigEE" to="wyt6:~Object" resolve="Object" />
                    </node>
                  </node>
                </node>
              </node>
            </node>
            <node concept="3clFbH" id="cd93Ye0JVI" role="3cqZAp" />
            <node concept="1DcWWT" id="cd93Ye0Ml6" role="3cqZAp">
              <node concept="3clFbS" id="cd93Ye0Ml8" role="2LFqv$">
                <node concept="3clFbF" id="cd93Ye0VCC" role="3cqZAp">
                  <node concept="2OqwBi" id="cd93Ye10rT" role="3clFbG">
                    <node concept="37vLTw" id="cd93Ye0VCA" role="2Oq$k0">
                      <ref role="3cqZAo" node="cd93Ye0soq" resolve="sourceCellsTransformed" />
                    </node>
                    <node concept="liA8E" id="cd93Ye14pT" role="2OqNvi">
                      <ref role="37wK5l" to="33ny:~HashMap.put(java.lang.Object,java.lang.Object)" resolve="put" />
                      <node concept="3cpWs3" id="cd93Ye1b_g" role="37wK5m">
                        <node concept="37vLTw" id="cd93Ye1eBF" role="3uHU7w">
                          <ref role="3cqZAo" node="cd93Ye0ONU" resolve="sourceLine" />
                        </node>
                        <node concept="37vLTw" id="cd93Ye16Xt" role="3uHU7B">
                          <ref role="3cqZAo" node="cd93YdZsOB" resolve="appendAfterLine" />
                        </node>
                      </node>
                      <node concept="2OqwBi" id="cd93Ye1p5N" role="37wK5m">
                        <node concept="37vLTw" id="cd93Ye1lN_" role="2Oq$k0">
                          <ref role="3cqZAo" node="cd93YdZwBY" resolve="sourceCells" />
                        </node>
                        <node concept="liA8E" id="cd93Ye1s$U" role="2OqNvi">
                          <ref role="37wK5l" to="33ny:~Map.get(java.lang.Object)" resolve="get" />
                          <node concept="37vLTw" id="cd93Ye1w1Z" role="37wK5m">
                            <ref role="3cqZAo" node="cd93Ye0ONU" resolve="sourceLine" />
                          </node>
                        </node>
                      </node>
                    </node>
                  </node>
                </node>
              </node>
              <node concept="3KEzu6" id="cd93Ye0ONU" role="1Duv9x">
                <property role="TrG5h" value="sourceLine" />
                <node concept="PeGgZ" id="cd93Ye0ONZ" role="1tU5fm" />
              </node>
              <node concept="37vLTw" id="cd93Ye0Tf6" role="1DdaDG">
                <ref role="3cqZAo" node="cd93YdZU0_" resolve="sourceLines" />
              </node>
            </node>
            <node concept="3clFbH" id="cd93Ye1zKW" role="3cqZAp" />
            <node concept="3cpWs8" id="cd93Ye1AgA" role="3cqZAp">
              <node concept="3KEzu6" id="cd93Ye1Agz" role="3cpWs9">
                <property role="TrG5h" value="destCells" />
                <node concept="PeGgZ" id="cd93Ye1Ag$" role="1tU5fm" />
                <node concept="2OqwBi" id="cd93Ye1XT6" role="33vP2m">
                  <node concept="2OqwBi" id="cd93Ye1S4A" role="2Oq$k0">
                    <node concept="37vLTw" id="cd93Ye1PWg" role="2Oq$k0">
                      <ref role="3cqZAo" node="cd93YdZrS4" resolve="to" />
                    </node>
                    <node concept="liA8E" id="cd93Ye1UFQ" role="2OqNvi">
                      <ref role="37wK5l" to="6a2z:cd93YdQ8ZE" resolve="getColumnInfo" />
                    </node>
                  </node>
                  <node concept="liA8E" id="cd93Ye22g0" role="2OqNvi">
                    <ref role="37wK5l" to="33ny:~Map.get(java.lang.Object)" resolve="get" />
                    <node concept="2OqwBi" id="cd93Ye27Ud" role="37wK5m">
                      <node concept="37vLTw" id="cd93Ye24XW" role="2Oq$k0">
                        <ref role="3cqZAo" node="cd93YdZtw2" resolve="mapping" />
                      </node>
                      <node concept="liA8E" id="cd93Ye2dXI" role="2OqNvi">
                        <ref role="37wK5l" to="33ny:~Map$Entry.getValue()" resolve="getValue" />
                      </node>
                    </node>
                  </node>
                </node>
              </node>
            </node>
            <node concept="3clFbF" id="cd93Ye2lB6" role="3cqZAp">
              <node concept="2OqwBi" id="cd93Ye2qQu" role="3clFbG">
                <node concept="37vLTw" id="cd93Ye2lB4" role="2Oq$k0">
                  <ref role="3cqZAo" node="cd93Ye1Agz" resolve="destCells" />
                </node>
                <node concept="liA8E" id="cd93Ye2urw" role="2OqNvi">
                  <ref role="37wK5l" to="33ny:~Map.putAll(java.util.Map)" resolve="putAll" />
                  <node concept="37vLTw" id="cd93Ye2xk9" role="37wK5m">
                    <ref role="3cqZAo" node="cd93Ye0soq" resolve="sourceCellsTransformed" />
                  </node>
                </node>
              </node>
            </node>
          </node>
          <node concept="3KEzu6" id="cd93YdZtw2" role="1Duv9x">
            <property role="TrG5h" value="mapping" />
            <node concept="PeGgZ" id="cd93YdZtw7" role="1tU5fm" />
          </node>
          <node concept="2OqwBi" id="cd93YdZu$N" role="1DdaDG">
            <node concept="37vLTw" id="cd93YdZtCA" role="2Oq$k0">
              <ref role="3cqZAo" node="cd93YdZrT_" resolve="columnsMapping" />
            </node>
            <node concept="liA8E" id="cd93YdZvoS" role="2OqNvi">
              <ref role="37wK5l" to="33ny:~Map.entrySet()" resolve="entrySet" />
            </node>
          </node>
        </node>
        <node concept="3clFbH" id="6gCHjbam27N" role="3cqZAp" />
        <node concept="3clFbF" id="6gCHjbambDA" role="3cqZAp">
          <node concept="2YIFZM" id="6gCHjbamkZn" role="3clFbG">
            <ref role="37wK5l" to="810k:6gCHjbahhRx" resolve="log" />
            <ref role="1Pybhc" to="810k:6gCHjbahfKM" resolve="Logger" />
            <node concept="Rm8GO" id="6gCHjbamvYV" role="37wK5m">
              <ref role="Rm8GQ" to="810k:6gCHjbahhiU" resolve="INFO" />
              <ref role="1Px2BO" to="810k:6gCHjbahgOI" resolve="LogLevel" />
            </node>
            <node concept="Xl_RD" id="6gCHjbamBjz" role="37wK5m">
              <property role="Xl_RC" value="AppendRowsStepDefault success." />
            </node>
          </node>
        </node>
      </node>
      <node concept="3Tm1VV" id="cd93YdZrPL" role="1B3o_S" />
      <node concept="3cqZAl" id="cd93YdZrPO" role="3clF45" />
      <node concept="37vLTG" id="cd93YdZrQA" role="3clF46">
        <property role="TrG5h" value="from" />
        <node concept="3uibUv" id="cd93YdZrQ_" role="1tU5fm">
          <ref role="3uigEE" to="6a2z:cd93YdJHRJ" resolve="Table" />
        </node>
      </node>
      <node concept="37vLTG" id="cd93YdZrS4" role="3clF46">
        <property role="TrG5h" value="to" />
        <node concept="3uibUv" id="cd93YdZrSA" role="1tU5fm">
          <ref role="3uigEE" to="6a2z:cd93YdJHRJ" resolve="Table" />
        </node>
      </node>
      <node concept="37vLTG" id="cd93YdZrT_" role="3clF46">
        <property role="TrG5h" value="columnsMapping" />
        <node concept="3uibUv" id="cd93YdZrUx" role="1tU5fm">
          <ref role="3uigEE" to="33ny:~Map" resolve="Map" />
          <node concept="3uibUv" id="cd93YdZrXR" role="11_B2D">
            <ref role="3uigEE" to="6a2z:cd93YdJHTQ" resolve="Column" />
          </node>
          <node concept="3uibUv" id="cd93YdZs1k" role="11_B2D">
            <ref role="3uigEE" to="6a2z:cd93YdJHTQ" resolve="Column" />
          </node>
        </node>
      </node>
    </node>
    <node concept="3Tm1VV" id="cd93YdZi2S" role="1B3o_S" />
    <node concept="n94m4" id="cd93YdZi2T" role="lGtFl" />
    <node concept="3uibUv" id="cd93YdZk1K" role="EKbjA">
      <ref role="3uigEE" node="cd93YdZi4q" resolve="IAppendRowsStep" />
    </node>
  </node>
  <node concept="312cEu" id="cd93YdZi3A">
    <property role="TrG5h" value="FactoryAppendRowsStep" />
    <property role="2HnT6v" value="program.src.main.java.org.enorm.domain.steps.appendRowsStep" />
    <node concept="Wx3nA" id="cd93YdZqRF" role="jymVt">
      <property role="TrG5h" value="step" />
      <node concept="3Tm6S6" id="cd93YdZqRl" role="1B3o_S" />
      <node concept="3uibUv" id="cd93YdZqRx" role="1tU5fm">
        <ref role="3uigEE" node="cd93YdZi4q" resolve="IAppendRowsStep" />
      </node>
    </node>
    <node concept="2tJIrI" id="cd93YdZqRR" role="jymVt" />
    <node concept="2YIFZL" id="cd93YdZqSx" role="jymVt">
      <property role="TrG5h" value="setStep" />
      <node concept="3clFbS" id="cd93YdZqS$" role="3clF47">
        <node concept="3clFbF" id="cd93YdZqU_" role="3cqZAp">
          <node concept="37vLTI" id="cd93YdZrJw" role="3clFbG">
            <node concept="37vLTw" id="cd93YdZrKr" role="37vLTx">
              <ref role="3cqZAo" node="cd93YdZqSZ" resolve="s" />
            </node>
            <node concept="37vLTw" id="cd93YdZrlD" role="37vLTJ">
              <ref role="3cqZAo" node="cd93YdZqRF" resolve="step" />
            </node>
          </node>
        </node>
      </node>
      <node concept="3Tm1VV" id="cd93YdZqSb" role="1B3o_S" />
      <node concept="3cqZAl" id="cd93YdZqSn" role="3clF45" />
      <node concept="37vLTG" id="cd93YdZqSZ" role="3clF46">
        <property role="TrG5h" value="s" />
        <node concept="3uibUv" id="cd93YdZqSY" role="1tU5fm">
          <ref role="3uigEE" node="cd93YdZi4q" resolve="IAppendRowsStep" />
        </node>
      </node>
    </node>
    <node concept="2tJIrI" id="cd93YdZrL8" role="jymVt" />
    <node concept="2YIFZL" id="cd93YdZrM6" role="jymVt">
      <property role="TrG5h" value="getStep" />
      <node concept="3clFbS" id="cd93YdZrM9" role="3clF47">
        <node concept="3cpWs6" id="cd93YdZrNp" role="3cqZAp">
          <node concept="37vLTw" id="cd93YdZrOy" role="3cqZAk">
            <ref role="3cqZAo" node="cd93YdZqRF" resolve="step" />
          </node>
        </node>
      </node>
      <node concept="3Tm1VV" id="cd93YdZrLp" role="1B3o_S" />
      <node concept="3uibUv" id="cd93YdZrLS" role="3clF45">
        <ref role="3uigEE" node="cd93YdZi4q" resolve="IAppendRowsStep" />
      </node>
    </node>
    <node concept="3Tm1VV" id="cd93YdZi3B" role="1B3o_S" />
    <node concept="n94m4" id="cd93YdZi3C" role="lGtFl" />
  </node>
  <node concept="3HP615" id="cd93YdZi4q">
    <property role="TrG5h" value="IAppendRowsStep" />
    <property role="2HnT6v" value="program.src.main.java.org.enorm.domain.steps.appendRowsStep" />
    <node concept="3clFb_" id="cd93YdZk2o" role="jymVt">
      <property role="TrG5h" value="apply" />
      <node concept="3clFbS" id="cd93YdZk2r" role="3clF47" />
      <node concept="3Tm1VV" id="cd93YdZk2s" role="1B3o_S" />
      <node concept="3cqZAl" id="cd93YdZk2e" role="3clF45" />
      <node concept="37vLTG" id="cd93YdZk2Q" role="3clF46">
        <property role="TrG5h" value="from" />
        <node concept="3uibUv" id="cd93YdZk2P" role="1tU5fm">
          <ref role="3uigEE" to="6a2z:cd93YdJHRJ" resolve="Table" />
        </node>
      </node>
      <node concept="37vLTG" id="cd93YdZk3i" role="3clF46">
        <property role="TrG5h" value="to" />
        <node concept="3uibUv" id="cd93YdZk3K" role="1tU5fm">
          <ref role="3uigEE" to="6a2z:cd93YdJHRJ" resolve="Table" />
        </node>
      </node>
      <node concept="37vLTG" id="cd93YdZk5s" role="3clF46">
        <property role="TrG5h" value="columnsMapping" />
        <node concept="3uibUv" id="cd93YdZqM1" role="1tU5fm">
          <ref role="3uigEE" to="33ny:~Map" resolve="Map" />
          <node concept="3uibUv" id="cd93YdZqNN" role="11_B2D">
            <ref role="3uigEE" to="6a2z:cd93YdJHTQ" resolve="Column" />
          </node>
          <node concept="3uibUv" id="cd93YdZqOO" role="11_B2D">
            <ref role="3uigEE" to="6a2z:cd93YdJHTQ" resolve="Column" />
          </node>
        </node>
      </node>
    </node>
    <node concept="3Tm1VV" id="cd93YdZi4r" role="1B3o_S" />
    <node concept="n94m4" id="cd93YdZi4s" role="lGtFl" />
  </node>
  <node concept="bUwia" id="cd93YdZi2Q">
    <property role="TrG5h" value="main" />
    <node concept="3lhOvk" id="cd93YdZi4V" role="3lj3bC">
      <ref role="30HIoZ" to="y20r:5ZmGmhlaPTB" resolve="AppendRows" />
      <ref role="3lhOvi" node="cd93YdZi2R" resolve="AppendRowsStepDefault" />
    </node>
    <node concept="3lhOvk" id="cd93YdZi4W" role="3lj3bC">
      <ref role="30HIoZ" to="y20r:5ZmGmhlaPTB" resolve="AppendRows" />
      <ref role="3lhOvi" node="cd93YdZi3A" resolve="FactoryAppendRowsStep" />
    </node>
    <node concept="3lhOvk" id="cd93YdZi4X" role="3lj3bC">
      <ref role="30HIoZ" to="y20r:5ZmGmhlaPTB" resolve="AppendRows" />
      <ref role="3lhOvi" node="cd93YdZi4q" resolve="IAppendRowsStep" />
    </node>
  </node>
</model>

