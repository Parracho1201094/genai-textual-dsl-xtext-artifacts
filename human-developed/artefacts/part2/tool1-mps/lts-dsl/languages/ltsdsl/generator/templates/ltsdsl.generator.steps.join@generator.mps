<?xml version="1.0" encoding="UTF-8"?>
<model ref="r:a259c1a4-fe07-4459-93a8-28b00a8a5e65(ltsdsl.generator.steps.join@generator)">
  <persistence version="9" />
  <languages>
    <use id="515552c7-fcc0-4ab4-9789-2f3c49344e85" name="jetbrains.mps.baseLanguage.varVariable" version="0" />
    <devkit ref="a2eb3a43-fcc2-4200-80dc-c60110c4862d(jetbrains.mps.devkit.templates)" />
  </languages>
  <imports>
    <import index="y20r" ref="r:85f52e46-7a19-44f9-bf10-6677b89edd73(ltsdsl.structure)" />
    <import index="33ny" ref="6354ebe7-c22a-4a0f-ac54-50b52ab9b065/java:java.util(JDK/)" />
    <import index="6a2z" ref="r:1c985b49-e2d4-4b0a-ac27-a43894ccaff0(ltsdsl.generator.tables@generator)" />
    <import index="4z85" ref="r:f197530d-51ad-4216-956c-2f6cb0c55a22(ltsdsl.generator.enums@generator)" />
    <import index="810k" ref="r:7a125382-cddb-4c4f-8e8b-3d8533cae26c(ltsdsl.generator.main@generator)" />
    <import index="wyt6" ref="6354ebe7-c22a-4a0f-ac54-50b52ab9b065/java:java.lang(JDK/)" implicit="true" />
  </imports>
  <registry>
    <language id="f3061a53-9226-4cc5-a443-f952ceaf5816" name="jetbrains.mps.baseLanguage">
      <concept id="1082485599095" name="jetbrains.mps.baseLanguage.structure.BlockStatement" flags="nn" index="9aQIb">
        <child id="1082485599096" name="statements" index="9aQI4" />
      </concept>
      <concept id="1215693861676" name="jetbrains.mps.baseLanguage.structure.BaseAssignmentExpression" flags="nn" index="d038R">
        <child id="1068498886297" name="rValue" index="37vLTx" />
        <child id="1068498886295" name="lValue" index="37vLTJ" />
      </concept>
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
      <concept id="1068580123159" name="jetbrains.mps.baseLanguage.structure.IfStatement" flags="nn" index="3clFbJ">
        <child id="1082485599094" name="ifFalseStatement" index="9aQIa" />
        <child id="1068580123160" name="condition" index="3clFbw" />
        <child id="1068580123161" name="ifTrue" index="3clFbx" />
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
      <concept id="1204053956946" name="jetbrains.mps.baseLanguage.structure.IMethodCall" flags="ngI" index="1ndlxa">
        <reference id="1068499141037" name="baseMethodDeclaration" index="37wK5l" />
        <child id="1068499141038" name="actualArgument" index="37wK5m" />
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
  <node concept="312cEu" id="7mnL6ODDBJh">
    <property role="TrG5h" value="JoinStepDefault" />
    <property role="2HnT6v" value="program.src.main.java.org.enorm.domain.steps.joinStep" />
    <node concept="3clFb_" id="7mnL6ODDD4Q" role="jymVt">
      <property role="TrG5h" value="apply" />
      <node concept="3Tm1VV" id="7mnL6ODDD4R" role="1B3o_S" />
      <node concept="3uibUv" id="7mnL6ODDD4S" role="3clF45">
        <ref role="3uigEE" to="6a2z:cd93YdJHRJ" resolve="Table" />
      </node>
      <node concept="37vLTG" id="7mnL6ODDD4T" role="3clF46">
        <property role="TrG5h" value="leftTable" />
        <node concept="3uibUv" id="7mnL6ODDD4U" role="1tU5fm">
          <ref role="3uigEE" to="6a2z:cd93YdJHRJ" resolve="Table" />
        </node>
      </node>
      <node concept="37vLTG" id="7mnL6ODDD4V" role="3clF46">
        <property role="TrG5h" value="rightTable" />
        <node concept="3uibUv" id="7mnL6ODDD4W" role="1tU5fm">
          <ref role="3uigEE" to="6a2z:cd93YdJHRJ" resolve="Table" />
        </node>
      </node>
      <node concept="37vLTG" id="7mnL6ODDD4X" role="3clF46">
        <property role="TrG5h" value="leftColumn" />
        <node concept="3uibUv" id="7mnL6ODDD4Y" role="1tU5fm">
          <ref role="3uigEE" to="6a2z:cd93YdJHTQ" resolve="Column" />
        </node>
      </node>
      <node concept="37vLTG" id="7mnL6ODDD4Z" role="3clF46">
        <property role="TrG5h" value="rightColumn" />
        <node concept="3uibUv" id="7mnL6ODDD50" role="1tU5fm">
          <ref role="3uigEE" to="6a2z:cd93YdJHTQ" resolve="Column" />
        </node>
      </node>
      <node concept="37vLTG" id="7mnL6ODDD51" role="3clF46">
        <property role="TrG5h" value="type" />
        <node concept="3uibUv" id="7mnL6ODDD52" role="1tU5fm">
          <ref role="3uigEE" to="4z85:cd93Ye9gEE" resolve="JoinType" />
        </node>
      </node>
      <node concept="37vLTG" id="7mnL6ODDD53" role="3clF46">
        <property role="TrG5h" value="resultFactoryTable" />
        <node concept="3uibUv" id="7mnL6ODDD54" role="1tU5fm">
          <ref role="3uigEE" to="6a2z:cd93YdSsAK" resolve="FactoryTable" />
        </node>
      </node>
      <node concept="37vLTG" id="7mnL6ODDD55" role="3clF46">
        <property role="TrG5h" value="selectColumns" />
        <node concept="3uibUv" id="7mnL6ODDD56" role="1tU5fm">
          <ref role="3uigEE" to="33ny:~List" resolve="List" />
          <node concept="3uibUv" id="7mnL6ODDD57" role="11_B2D">
            <ref role="3uigEE" to="6a2z:cd93YdJHTQ" resolve="Column" />
          </node>
        </node>
      </node>
      <node concept="3clFbS" id="7mnL6ODDD58" role="3clF47">
        <node concept="3clFbH" id="7mnL6ODDD59" role="3cqZAp" />
        <node concept="3cpWs8" id="7mnL6ODDD5a" role="3cqZAp">
          <node concept="3KEzu6" id="7mnL6ODDD5b" role="3cpWs9">
            <property role="TrG5h" value="leftCells" />
            <node concept="PeGgZ" id="7mnL6ODDD5c" role="1tU5fm" />
            <node concept="2OqwBi" id="7mnL6ODDD5d" role="33vP2m">
              <node concept="2OqwBi" id="7mnL6ODDD5e" role="2Oq$k0">
                <node concept="37vLTw" id="7mnL6ODDD5f" role="2Oq$k0">
                  <ref role="3cqZAo" node="7mnL6ODDD4T" resolve="leftTable" />
                </node>
                <node concept="liA8E" id="7mnL6ODDD5g" role="2OqNvi">
                  <ref role="37wK5l" to="6a2z:cd93YdQ8ZE" resolve="getColumnInfo" />
                </node>
              </node>
              <node concept="liA8E" id="7mnL6ODDD5h" role="2OqNvi">
                <ref role="37wK5l" to="33ny:~Map.get(java.lang.Object)" resolve="get" />
                <node concept="37vLTw" id="7mnL6ODDD5i" role="37wK5m">
                  <ref role="3cqZAo" node="7mnL6ODDD4X" resolve="leftColumn" />
                </node>
              </node>
            </node>
          </node>
        </node>
        <node concept="3cpWs8" id="7mnL6ODDD5j" role="3cqZAp">
          <node concept="3KEzu6" id="7mnL6ODDD5k" role="3cpWs9">
            <property role="TrG5h" value="rightCells" />
            <node concept="PeGgZ" id="7mnL6ODDD5l" role="1tU5fm" />
            <node concept="2OqwBi" id="7mnL6ODDD5m" role="33vP2m">
              <node concept="2OqwBi" id="7mnL6ODDD5n" role="2Oq$k0">
                <node concept="37vLTw" id="7mnL6ODDD5o" role="2Oq$k0">
                  <ref role="3cqZAo" node="7mnL6ODDD4V" resolve="rightTable" />
                </node>
                <node concept="liA8E" id="7mnL6ODDD5p" role="2OqNvi">
                  <ref role="37wK5l" to="6a2z:cd93YdQ8ZE" resolve="getColumnInfo" />
                </node>
              </node>
              <node concept="liA8E" id="7mnL6ODDD5q" role="2OqNvi">
                <ref role="37wK5l" to="33ny:~Map.get(java.lang.Object)" resolve="get" />
                <node concept="37vLTw" id="7mnL6ODDD5r" role="37wK5m">
                  <ref role="3cqZAo" node="7mnL6ODDD4Z" resolve="rightColumn" />
                </node>
              </node>
            </node>
          </node>
        </node>
        <node concept="3cpWs8" id="7mnL6ODDD5s" role="3cqZAp">
          <node concept="3KEzu6" id="7mnL6ODDD5t" role="3cpWs9">
            <property role="TrG5h" value="resultTable" />
            <node concept="PeGgZ" id="7mnL6ODDD5u" role="1tU5fm" />
            <node concept="2OqwBi" id="7mnL6ODDD5v" role="33vP2m">
              <node concept="37vLTw" id="7mnL6ODDD5w" role="2Oq$k0">
                <ref role="3cqZAo" node="7mnL6ODDD53" resolve="resultFactoryTable" />
              </node>
              <node concept="liA8E" id="7mnL6ODDD5x" role="2OqNvi">
                <ref role="37wK5l" to="6a2z:cd93YdSsBC" resolve="generateTable" />
              </node>
            </node>
          </node>
        </node>
        <node concept="3cpWs8" id="7mnL6ODDD5y" role="3cqZAp">
          <node concept="3KEzu6" id="7mnL6ODDD5z" role="3cpWs9">
            <property role="TrG5h" value="lineCounter" />
            <node concept="PeGgZ" id="7mnL6ODDD5$" role="1tU5fm" />
            <node concept="3cmrfG" id="7mnL6ODDD5_" role="33vP2m">
              <property role="3cmrfH" value="1" />
            </node>
          </node>
        </node>
        <node concept="3clFbH" id="7mnL6ODDD5A" role="3cqZAp" />
        <node concept="1DcWWT" id="7mnL6ODDD5B" role="3cqZAp">
          <node concept="3clFbS" id="7mnL6ODDD5C" role="2LFqv$">
            <node concept="3cpWs8" id="7mnL6ODDD5D" role="3cqZAp">
              <node concept="3KEzu6" id="7mnL6ODDD5E" role="3cpWs9">
                <property role="TrG5h" value="leftValue" />
                <node concept="PeGgZ" id="7mnL6ODDD5F" role="1tU5fm" />
                <node concept="2OqwBi" id="7mnL6ODDD5G" role="33vP2m">
                  <node concept="37vLTw" id="7mnL6ODDD5H" role="2Oq$k0">
                    <ref role="3cqZAo" node="7mnL6ODDD5b" resolve="leftCells" />
                  </node>
                  <node concept="liA8E" id="7mnL6ODDD5I" role="2OqNvi">
                    <ref role="37wK5l" to="33ny:~Map.get(java.lang.Object)" resolve="get" />
                    <node concept="37vLTw" id="7mnL6ODDD5J" role="37wK5m">
                      <ref role="3cqZAo" node="7mnL6ODDD6i" resolve="leftCellLine" />
                    </node>
                  </node>
                </node>
              </node>
            </node>
            <node concept="3clFbH" id="7mnL6ODDD5K" role="3cqZAp" />
            <node concept="1DcWWT" id="7mnL6ODDD5L" role="3cqZAp">
              <node concept="3clFbS" id="7mnL6ODDD5M" role="2LFqv$">
                <node concept="3cpWs8" id="7mnL6ODDD5N" role="3cqZAp">
                  <node concept="3KEzu6" id="7mnL6ODDD5O" role="3cpWs9">
                    <property role="TrG5h" value="rightValue" />
                    <node concept="PeGgZ" id="7mnL6ODDD5P" role="1tU5fm" />
                    <node concept="2OqwBi" id="7mnL6ODDD5Q" role="33vP2m">
                      <node concept="37vLTw" id="7mnL6ODDD5R" role="2Oq$k0">
                        <ref role="3cqZAo" node="7mnL6ODDD5k" resolve="rightCells" />
                      </node>
                      <node concept="liA8E" id="7mnL6ODDD5S" role="2OqNvi">
                        <ref role="37wK5l" to="33ny:~Map.get(java.lang.Object)" resolve="get" />
                        <node concept="37vLTw" id="7mnL6ODDD5T" role="37wK5m">
                          <ref role="3cqZAo" node="7mnL6ODDD6d" resolve="rightCellLine" />
                        </node>
                      </node>
                    </node>
                  </node>
                </node>
                <node concept="3clFbH" id="7mnL6ODDD5U" role="3cqZAp" />
                <node concept="3clFbJ" id="7mnL6ODDD5V" role="3cqZAp">
                  <node concept="3clFbS" id="7mnL6ODDD5W" role="3clFbx">
                    <node concept="3clFbF" id="7mnL6ODDD5X" role="3cqZAp">
                      <node concept="1rXfSq" id="7mnL6ODDD5Y" role="3clFbG">
                        <ref role="37wK5l" node="7mnL6ODE3G8" resolve="collectValues" />
                        <node concept="37vLTw" id="7mnL6ODDD5Z" role="37wK5m">
                          <ref role="3cqZAo" node="7mnL6ODDD4T" resolve="leftTable" />
                        </node>
                        <node concept="37vLTw" id="7mnL6ODDD60" role="37wK5m">
                          <ref role="3cqZAo" node="7mnL6ODDD6i" resolve="leftCellLine" />
                        </node>
                        <node concept="37vLTw" id="7mnL6ODDD61" role="37wK5m">
                          <ref role="3cqZAo" node="7mnL6ODDD4V" resolve="rightTable" />
                        </node>
                        <node concept="37vLTw" id="7mnL6ODDD62" role="37wK5m">
                          <ref role="3cqZAo" node="7mnL6ODDD6d" resolve="rightCellLine" />
                        </node>
                        <node concept="37vLTw" id="7mnL6ODDD63" role="37wK5m">
                          <ref role="3cqZAo" node="7mnL6ODDD5t" resolve="resultTable" />
                        </node>
                        <node concept="37vLTw" id="7mnL6ODDD64" role="37wK5m">
                          <ref role="3cqZAo" node="7mnL6ODDD55" resolve="selectColumns" />
                        </node>
                        <node concept="37vLTw" id="7mnL6ODDD65" role="37wK5m">
                          <ref role="3cqZAo" node="7mnL6ODDD5z" resolve="lineCounter" />
                        </node>
                      </node>
                    </node>
                    <node concept="3clFbF" id="7mnL6ODDD66" role="3cqZAp">
                      <node concept="3uNrnE" id="7mnL6ODDD67" role="3clFbG">
                        <node concept="37vLTw" id="7mnL6ODDD68" role="2$L3a6">
                          <ref role="3cqZAo" node="7mnL6ODDD5z" resolve="lineCounter" />
                        </node>
                      </node>
                    </node>
                  </node>
                  <node concept="2OqwBi" id="7mnL6ODDD69" role="3clFbw">
                    <node concept="37vLTw" id="7mnL6ODDD6a" role="2Oq$k0">
                      <ref role="3cqZAo" node="7mnL6ODDD5E" resolve="leftValue" />
                    </node>
                    <node concept="liA8E" id="7mnL6ODDD6b" role="2OqNvi">
                      <ref role="37wK5l" to="wyt6:~Object.equals(java.lang.Object)" resolve="equals" />
                      <node concept="37vLTw" id="7mnL6ODDD6c" role="37wK5m">
                        <ref role="3cqZAo" node="7mnL6ODDD5O" resolve="rightValue" />
                      </node>
                    </node>
                  </node>
                </node>
              </node>
              <node concept="3KEzu6" id="7mnL6ODDD6d" role="1Duv9x">
                <property role="TrG5h" value="rightCellLine" />
                <node concept="PeGgZ" id="7mnL6ODDD6e" role="1tU5fm" />
              </node>
              <node concept="2OqwBi" id="7mnL6ODDD6f" role="1DdaDG">
                <node concept="37vLTw" id="7mnL6ODDD6g" role="2Oq$k0">
                  <ref role="3cqZAo" node="7mnL6ODDD5k" resolve="rightCells" />
                </node>
                <node concept="liA8E" id="7mnL6ODDD6h" role="2OqNvi">
                  <ref role="37wK5l" to="33ny:~Map.keySet()" resolve="keySet" />
                </node>
              </node>
            </node>
          </node>
          <node concept="3KEzu6" id="7mnL6ODDD6i" role="1Duv9x">
            <property role="TrG5h" value="leftCellLine" />
            <node concept="PeGgZ" id="7mnL6ODDD6j" role="1tU5fm" />
          </node>
          <node concept="2OqwBi" id="7mnL6ODDD6k" role="1DdaDG">
            <node concept="37vLTw" id="7mnL6ODDD6l" role="2Oq$k0">
              <ref role="3cqZAo" node="7mnL6ODDD5b" resolve="leftCells" />
            </node>
            <node concept="liA8E" id="7mnL6ODDD6m" role="2OqNvi">
              <ref role="37wK5l" to="33ny:~Map.keySet()" resolve="keySet" />
            </node>
          </node>
        </node>
        <node concept="3clFbF" id="6gCHjbaq5v$" role="3cqZAp">
          <node concept="2YIFZM" id="6gCHjbaq5v_" role="3clFbG">
            <ref role="37wK5l" to="810k:6gCHjbahhRx" resolve="log" />
            <ref role="1Pybhc" to="810k:6gCHjbahfKM" resolve="Logger" />
            <node concept="Rm8GO" id="6gCHjbaq9Lu" role="37wK5m">
              <ref role="Rm8GQ" to="810k:6gCHjbahhiU" resolve="INFO" />
              <ref role="1Px2BO" to="810k:6gCHjbahgOI" resolve="LogLevel" />
            </node>
            <node concept="Xl_RD" id="6gCHjbaq5vD" role="37wK5m">
              <property role="Xl_RC" value="JoinStepDefault success." />
            </node>
          </node>
        </node>
        <node concept="3clFbH" id="6gCHjbaqzKB" role="3cqZAp" />
        <node concept="3cpWs6" id="7mnL6ODDD6n" role="3cqZAp">
          <node concept="37vLTw" id="7mnL6ODDD6o" role="3cqZAk">
            <ref role="3cqZAo" node="7mnL6ODDD5t" resolve="resultTable" />
          </node>
        </node>
      </node>
      <node concept="2AHcQZ" id="7mnL6ODDD6p" role="2AJF6D">
        <ref role="2AI5Lk" to="wyt6:~Override" />
      </node>
    </node>
    <node concept="2tJIrI" id="7mnL6ODDD6q" role="jymVt" />
    <node concept="3clFb_" id="7mnL6ODE3G8" role="jymVt">
      <property role="TrG5h" value="collectValues" />
      <node concept="3clFbS" id="7mnL6ODE3G9" role="3clF47">
        <node concept="3clFbH" id="7mnL6ODE3Ga" role="3cqZAp" />
        <node concept="1DcWWT" id="7mnL6ODE3Gb" role="3cqZAp">
          <node concept="3clFbS" id="7mnL6ODE3Gc" role="2LFqv$">
            <node concept="3cpWs8" id="7mnL6ODE3Gd" role="3cqZAp">
              <node concept="3cpWsn" id="7mnL6ODE3Ge" role="3cpWs9">
                <property role="TrG5h" value="value" />
                <node concept="3uibUv" id="7mnL6ODE3Gf" role="1tU5fm">
                  <ref role="3uigEE" to="wyt6:~Object" resolve="Object" />
                </node>
              </node>
            </node>
            <node concept="3clFbH" id="7mnL6ODE3Gg" role="3cqZAp" />
            <node concept="3clFbJ" id="7mnL6ODE3Gh" role="3cqZAp">
              <node concept="3clFbS" id="7mnL6ODE3Gi" role="3clFbx">
                <node concept="3clFbF" id="7mnL6ODE3Gj" role="3cqZAp">
                  <node concept="37vLTI" id="7mnL6ODE3Gk" role="3clFbG">
                    <node concept="2OqwBi" id="7mnL6ODE3Gl" role="37vLTx">
                      <node concept="2OqwBi" id="7mnL6ODE3Gm" role="2Oq$k0">
                        <node concept="2OqwBi" id="7mnL6ODE3Gn" role="2Oq$k0">
                          <node concept="37vLTw" id="7mnL6ODE3Go" role="2Oq$k0">
                            <ref role="3cqZAo" node="7mnL6ODE3H3" resolve="leftTable" />
                          </node>
                          <node concept="liA8E" id="7mnL6ODE3Gp" role="2OqNvi">
                            <ref role="37wK5l" to="6a2z:cd93YdQ8ZE" resolve="getColumnInfo" />
                          </node>
                        </node>
                        <node concept="liA8E" id="7mnL6ODE3Gq" role="2OqNvi">
                          <ref role="37wK5l" to="33ny:~Map.get(java.lang.Object)" resolve="get" />
                          <node concept="37vLTw" id="7mnL6ODE3Gr" role="37wK5m">
                            <ref role="3cqZAo" node="7mnL6ODE3GY" resolve="column" />
                          </node>
                        </node>
                      </node>
                      <node concept="liA8E" id="7mnL6ODE3Gs" role="2OqNvi">
                        <ref role="37wK5l" to="33ny:~Map.get(java.lang.Object)" resolve="get" />
                        <node concept="37vLTw" id="7mnL6ODE3Gt" role="37wK5m">
                          <ref role="3cqZAo" node="7mnL6ODE3H5" resolve="leftCellLine" />
                        </node>
                      </node>
                    </node>
                    <node concept="37vLTw" id="7mnL6ODE3Gu" role="37vLTJ">
                      <ref role="3cqZAo" node="7mnL6ODE3Ge" resolve="value" />
                    </node>
                  </node>
                </node>
              </node>
              <node concept="2OqwBi" id="7mnL6ODE3Gv" role="3clFbw">
                <node concept="2OqwBi" id="7mnL6ODE3Gw" role="2Oq$k0">
                  <node concept="37vLTw" id="7mnL6ODE3Gx" role="2Oq$k0">
                    <ref role="3cqZAo" node="7mnL6ODE3H3" resolve="leftTable" />
                  </node>
                  <node concept="liA8E" id="7mnL6ODE3Gy" role="2OqNvi">
                    <ref role="37wK5l" to="6a2z:cd93YdQ8ZE" resolve="getColumnInfo" />
                  </node>
                </node>
                <node concept="liA8E" id="7mnL6ODE3Gz" role="2OqNvi">
                  <ref role="37wK5l" to="33ny:~Map.containsKey(java.lang.Object)" resolve="containsKey" />
                  <node concept="37vLTw" id="7mnL6ODE3G$" role="37wK5m">
                    <ref role="3cqZAo" node="7mnL6ODE3GY" resolve="column" />
                  </node>
                </node>
              </node>
              <node concept="9aQIb" id="7mnL6ODE3G_" role="9aQIa">
                <node concept="3clFbS" id="7mnL6ODE3GA" role="9aQI4">
                  <node concept="3clFbF" id="7mnL6ODE3GB" role="3cqZAp">
                    <node concept="37vLTI" id="7mnL6ODE3GC" role="3clFbG">
                      <node concept="2OqwBi" id="7mnL6ODE3GD" role="37vLTx">
                        <node concept="2OqwBi" id="7mnL6ODE3GE" role="2Oq$k0">
                          <node concept="2OqwBi" id="7mnL6ODE3GF" role="2Oq$k0">
                            <node concept="37vLTw" id="7mnL6ODE3GG" role="2Oq$k0">
                              <ref role="3cqZAo" node="7mnL6ODE3H7" resolve="rightTable" />
                            </node>
                            <node concept="liA8E" id="7mnL6ODE3GH" role="2OqNvi">
                              <ref role="37wK5l" to="6a2z:cd93YdQ8ZE" resolve="getColumnInfo" />
                            </node>
                          </node>
                          <node concept="liA8E" id="7mnL6ODE3GI" role="2OqNvi">
                            <ref role="37wK5l" to="33ny:~Map.get(java.lang.Object)" resolve="get" />
                            <node concept="37vLTw" id="7mnL6ODE3GJ" role="37wK5m">
                              <ref role="3cqZAo" node="7mnL6ODE3GY" resolve="column" />
                            </node>
                          </node>
                        </node>
                        <node concept="liA8E" id="7mnL6ODE3GK" role="2OqNvi">
                          <ref role="37wK5l" to="33ny:~Map.get(java.lang.Object)" resolve="get" />
                          <node concept="37vLTw" id="7mnL6ODE3GL" role="37wK5m">
                            <ref role="3cqZAo" node="7mnL6ODE3H9" resolve="rightCellLine" />
                          </node>
                        </node>
                      </node>
                      <node concept="37vLTw" id="7mnL6ODE3GM" role="37vLTJ">
                        <ref role="3cqZAo" node="7mnL6ODE3Ge" resolve="value" />
                      </node>
                    </node>
                  </node>
                </node>
              </node>
            </node>
            <node concept="3clFbF" id="7mnL6ODE3GN" role="3cqZAp">
              <node concept="2OqwBi" id="7mnL6ODE3GO" role="3clFbG">
                <node concept="2OqwBi" id="7mnL6ODE3GP" role="2Oq$k0">
                  <node concept="2OqwBi" id="7mnL6ODE3GQ" role="2Oq$k0">
                    <node concept="37vLTw" id="7mnL6ODE3GR" role="2Oq$k0">
                      <ref role="3cqZAo" node="7mnL6ODE3Hb" resolve="resultTable" />
                    </node>
                    <node concept="liA8E" id="7mnL6ODE3GS" role="2OqNvi">
                      <ref role="37wK5l" to="6a2z:cd93YdQ8ZE" resolve="getColumnInfo" />
                    </node>
                  </node>
                  <node concept="liA8E" id="7mnL6ODE3GT" role="2OqNvi">
                    <ref role="37wK5l" to="33ny:~Map.get(java.lang.Object)" resolve="get" />
                    <node concept="37vLTw" id="7mnL6ODE3GU" role="37wK5m">
                      <ref role="3cqZAo" node="7mnL6ODE3GY" resolve="column" />
                    </node>
                  </node>
                </node>
                <node concept="liA8E" id="7mnL6ODE3GV" role="2OqNvi">
                  <ref role="37wK5l" to="33ny:~Map.put(java.lang.Object,java.lang.Object)" resolve="put" />
                  <node concept="37vLTw" id="7mnL6ODE3GW" role="37wK5m">
                    <ref role="3cqZAo" node="7mnL6ODE3Hg" resolve="resultLine" />
                  </node>
                  <node concept="37vLTw" id="7mnL6ODE3GX" role="37wK5m">
                    <ref role="3cqZAo" node="7mnL6ODE3Ge" resolve="value" />
                  </node>
                </node>
              </node>
            </node>
          </node>
          <node concept="3KEzu6" id="7mnL6ODE3GY" role="1Duv9x">
            <property role="TrG5h" value="column" />
            <node concept="PeGgZ" id="7mnL6ODE3GZ" role="1tU5fm" />
          </node>
          <node concept="37vLTw" id="7mnL6ODE3H0" role="1DdaDG">
            <ref role="3cqZAo" node="7mnL6ODE3Hd" resolve="selectColumns" />
          </node>
        </node>
      </node>
      <node concept="3Tm6S6" id="7mnL6ODE3H1" role="1B3o_S" />
      <node concept="3cqZAl" id="7mnL6ODE3H2" role="3clF45" />
      <node concept="37vLTG" id="7mnL6ODE3H3" role="3clF46">
        <property role="TrG5h" value="leftTable" />
        <node concept="3uibUv" id="7mnL6ODE3H4" role="1tU5fm">
          <ref role="3uigEE" to="6a2z:cd93YdJHRJ" resolve="Table" />
        </node>
      </node>
      <node concept="37vLTG" id="7mnL6ODE3H5" role="3clF46">
        <property role="TrG5h" value="leftCellLine" />
        <node concept="3uibUv" id="7mnL6ODE3H6" role="1tU5fm">
          <ref role="3uigEE" to="wyt6:~Integer" resolve="Integer" />
        </node>
      </node>
      <node concept="37vLTG" id="7mnL6ODE3H7" role="3clF46">
        <property role="TrG5h" value="rightTable" />
        <node concept="3uibUv" id="7mnL6ODE3H8" role="1tU5fm">
          <ref role="3uigEE" to="6a2z:cd93YdJHRJ" resolve="Table" />
        </node>
      </node>
      <node concept="37vLTG" id="7mnL6ODE3H9" role="3clF46">
        <property role="TrG5h" value="rightCellLine" />
        <node concept="3uibUv" id="7mnL6ODE3Ha" role="1tU5fm">
          <ref role="3uigEE" to="wyt6:~Integer" resolve="Integer" />
        </node>
      </node>
      <node concept="37vLTG" id="7mnL6ODE3Hb" role="3clF46">
        <property role="TrG5h" value="resultTable" />
        <node concept="3uibUv" id="7mnL6ODE3Hc" role="1tU5fm">
          <ref role="3uigEE" to="6a2z:cd93YdJHRJ" resolve="Table" />
        </node>
      </node>
      <node concept="37vLTG" id="7mnL6ODE3Hd" role="3clF46">
        <property role="TrG5h" value="selectColumns" />
        <node concept="3uibUv" id="7mnL6ODE3He" role="1tU5fm">
          <ref role="3uigEE" to="33ny:~List" resolve="List" />
          <node concept="3uibUv" id="7mnL6ODE3Hf" role="11_B2D">
            <ref role="3uigEE" to="6a2z:cd93YdJHTQ" resolve="Column" />
          </node>
        </node>
      </node>
      <node concept="37vLTG" id="7mnL6ODE3Hg" role="3clF46">
        <property role="TrG5h" value="resultLine" />
        <node concept="3uibUv" id="7mnL6ODE3Hh" role="1tU5fm">
          <ref role="3uigEE" to="wyt6:~Integer" resolve="Integer" />
        </node>
      </node>
    </node>
    <node concept="2tJIrI" id="7mnL6ODDD4P" role="jymVt" />
    <node concept="3Tm1VV" id="7mnL6ODDBJi" role="1B3o_S" />
    <node concept="n94m4" id="7mnL6ODDBJj" role="lGtFl" />
    <node concept="3uibUv" id="7mnL6ODE_3q" role="EKbjA">
      <ref role="3uigEE" node="7mnL6ODDKst" resolve="IJoinStep" />
    </node>
  </node>
  <node concept="3HP615" id="7mnL6ODDKst">
    <property role="TrG5h" value="IJoinStep" />
    <property role="2HnT6v" value="program.src.main.java.org.enorm.domain.steps.joinStep" />
    <node concept="3clFb_" id="7mnL6ODDKtU" role="jymVt">
      <property role="TrG5h" value="apply" />
      <node concept="3clFbS" id="7mnL6ODDKtV" role="3clF47" />
      <node concept="3Tm1VV" id="7mnL6ODDKtW" role="1B3o_S" />
      <node concept="3uibUv" id="7mnL6ODDKtX" role="3clF45">
        <ref role="3uigEE" to="6a2z:cd93YdJHRJ" resolve="Table" />
      </node>
      <node concept="37vLTG" id="7mnL6ODDKtY" role="3clF46">
        <property role="TrG5h" value="leftTable" />
        <node concept="3uibUv" id="7mnL6ODDKtZ" role="1tU5fm">
          <ref role="3uigEE" to="6a2z:cd93YdJHRJ" resolve="Table" />
        </node>
      </node>
      <node concept="37vLTG" id="7mnL6ODDKu0" role="3clF46">
        <property role="TrG5h" value="rightTable" />
        <node concept="3uibUv" id="7mnL6ODDKu1" role="1tU5fm">
          <ref role="3uigEE" to="6a2z:cd93YdJHRJ" resolve="Table" />
        </node>
      </node>
      <node concept="37vLTG" id="7mnL6ODDKu2" role="3clF46">
        <property role="TrG5h" value="leftColumn" />
        <node concept="3uibUv" id="7mnL6ODDKu3" role="1tU5fm">
          <ref role="3uigEE" to="6a2z:cd93YdJHTQ" resolve="Column" />
        </node>
      </node>
      <node concept="37vLTG" id="7mnL6ODDKu4" role="3clF46">
        <property role="TrG5h" value="rightColumn" />
        <node concept="3uibUv" id="7mnL6ODDKu5" role="1tU5fm">
          <ref role="3uigEE" to="6a2z:cd93YdJHTQ" resolve="Column" />
        </node>
      </node>
      <node concept="37vLTG" id="7mnL6ODDKu6" role="3clF46">
        <property role="TrG5h" value="type" />
        <node concept="3uibUv" id="7mnL6ODDKu7" role="1tU5fm">
          <ref role="3uigEE" to="4z85:cd93Ye9gEE" resolve="JoinType" />
        </node>
      </node>
      <node concept="37vLTG" id="7mnL6ODDKu8" role="3clF46">
        <property role="TrG5h" value="resultFactoryTable" />
        <node concept="3uibUv" id="7mnL6ODDKu9" role="1tU5fm">
          <ref role="3uigEE" to="6a2z:cd93YdSsAK" resolve="FactoryTable" />
        </node>
      </node>
      <node concept="37vLTG" id="7mnL6ODDKua" role="3clF46">
        <property role="TrG5h" value="selectColumns" />
        <node concept="3uibUv" id="7mnL6ODDKub" role="1tU5fm">
          <ref role="3uigEE" to="33ny:~List" resolve="List" />
          <node concept="3uibUv" id="7mnL6ODDKuc" role="11_B2D">
            <ref role="3uigEE" to="6a2z:cd93YdJHTQ" resolve="Column" />
          </node>
        </node>
      </node>
    </node>
    <node concept="2tJIrI" id="7mnL6ODDKtT" role="jymVt" />
    <node concept="3Tm1VV" id="7mnL6ODDKsu" role="1B3o_S" />
    <node concept="n94m4" id="7mnL6ODDKsv" role="lGtFl" />
  </node>
  <node concept="312cEu" id="7mnL6ODEgXk">
    <property role="TrG5h" value="FactoryJoinStep" />
    <property role="2HnT6v" value="program.src.main.java.org.enorm.domain.steps.joinStep" />
    <node concept="Wx3nA" id="7mnL6ODEgZh" role="jymVt">
      <property role="TrG5h" value="step" />
      <node concept="3Tm6S6" id="7mnL6ODEgZi" role="1B3o_S" />
      <node concept="3uibUv" id="7mnL6ODEgZj" role="1tU5fm">
        <ref role="3uigEE" node="7mnL6ODDKst" resolve="IJoinStep" />
      </node>
    </node>
    <node concept="2tJIrI" id="7mnL6ODEgZk" role="jymVt" />
    <node concept="2YIFZL" id="7mnL6ODEgZl" role="jymVt">
      <property role="TrG5h" value="setStep" />
      <node concept="3clFbS" id="7mnL6ODEgZm" role="3clF47">
        <node concept="3clFbF" id="7mnL6ODEgZn" role="3cqZAp">
          <node concept="37vLTI" id="7mnL6ODEgZo" role="3clFbG">
            <node concept="37vLTw" id="7mnL6ODEgZp" role="37vLTx">
              <ref role="3cqZAo" node="7mnL6ODEgZs" resolve="s" />
            </node>
            <node concept="37vLTw" id="7mnL6ODEgZw" role="37vLTJ">
              <ref role="3cqZAo" node="7mnL6ODEgZh" resolve="step" />
            </node>
          </node>
        </node>
      </node>
      <node concept="3Tm1VV" id="7mnL6ODEgZq" role="1B3o_S" />
      <node concept="3cqZAl" id="7mnL6ODEgZr" role="3clF45" />
      <node concept="37vLTG" id="7mnL6ODEgZs" role="3clF46">
        <property role="TrG5h" value="s" />
        <node concept="3uibUv" id="7mnL6ODEgZt" role="1tU5fm">
          <ref role="3uigEE" node="7mnL6ODDKst" resolve="IJoinStep" />
        </node>
      </node>
    </node>
    <node concept="2tJIrI" id="7mnL6ODEgZy" role="jymVt" />
    <node concept="2YIFZL" id="7mnL6ODEgZz" role="jymVt">
      <property role="TrG5h" value="getStep" />
      <node concept="3clFbS" id="7mnL6ODEgZ$" role="3clF47">
        <node concept="3cpWs6" id="7mnL6ODEgZ_" role="3cqZAp">
          <node concept="37vLTw" id="7mnL6ODEgZE" role="3cqZAk">
            <ref role="3cqZAo" node="7mnL6ODEgZh" resolve="step" />
          </node>
        </node>
      </node>
      <node concept="3Tm1VV" id="7mnL6ODEgZA" role="1B3o_S" />
      <node concept="3uibUv" id="7mnL6ODEgZB" role="3clF45">
        <ref role="3uigEE" node="7mnL6ODDKst" resolve="IJoinStep" />
      </node>
    </node>
    <node concept="2tJIrI" id="7mnL6ODEgZg" role="jymVt" />
    <node concept="3Tm1VV" id="7mnL6ODEgXl" role="1B3o_S" />
    <node concept="n94m4" id="7mnL6ODEgXm" role="lGtFl" />
  </node>
  <node concept="bUwia" id="7mnL6ODEIcj">
    <property role="TrG5h" value="main" />
    <node concept="3lhOvk" id="7mnL6ODEIck" role="3lj3bC">
      <ref role="30HIoZ" to="y20r:5ZmGmhllUK0" resolve="Join" />
      <ref role="3lhOvi" node="7mnL6ODDBJh" resolve="JoinStepDefault" />
    </node>
    <node concept="3lhOvk" id="7mnL6ODEIcl" role="3lj3bC">
      <ref role="30HIoZ" to="y20r:5ZmGmhllUK0" resolve="Join" />
      <ref role="3lhOvi" node="7mnL6ODEgXk" resolve="FactoryJoinStep" />
    </node>
    <node concept="3lhOvk" id="7mnL6ODEIcm" role="3lj3bC">
      <ref role="30HIoZ" to="y20r:5ZmGmhllUK0" resolve="Join" />
      <ref role="3lhOvi" node="7mnL6ODDKst" resolve="IJoinStep" />
    </node>
  </node>
</model>

