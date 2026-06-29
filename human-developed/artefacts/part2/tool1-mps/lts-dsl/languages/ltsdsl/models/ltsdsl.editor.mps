<?xml version="1.0" encoding="UTF-8"?>
<model ref="r:adf4e452-e274-424e-951d-a921b07c65c4(ltsdsl.editor)">
  <persistence version="9" />
  <languages>
    <use id="18bc6592-03a6-4e29-a83a-7ff23bde13ba" name="jetbrains.mps.lang.editor" version="14" />
    <use id="aee9cad2-acd4-4608-aef2-0004f6a1cdbd" name="jetbrains.mps.lang.actions" version="4" />
    <devkit ref="fbc25dd2-5da4-483a-8b19-70928e1b62d7(jetbrains.mps.devkit.general-purpose)" />
  </languages>
  <imports>
    <import index="y20r" ref="r:85f52e46-7a19-44f9-bf10-6677b89edd73(ltsdsl.structure)" implicit="true" />
    <import index="tpck" ref="r:00000000-0000-4000-0000-011c89590288(jetbrains.mps.lang.core.structure)" implicit="true" />
  </imports>
  <registry>
    <language id="18bc6592-03a6-4e29-a83a-7ff23bde13ba" name="jetbrains.mps.lang.editor">
      <concept id="1071666914219" name="jetbrains.mps.lang.editor.structure.ConceptEditorDeclaration" flags="ig" index="24kQdi" />
      <concept id="1140524381322" name="jetbrains.mps.lang.editor.structure.CellModel_ListWithRole" flags="ng" index="2czfm3">
        <child id="1140524464360" name="cellLayout" index="2czzBx" />
      </concept>
      <concept id="1106270549637" name="jetbrains.mps.lang.editor.structure.CellLayout_Horizontal" flags="nn" index="2iRfu4" />
      <concept id="1106270571710" name="jetbrains.mps.lang.editor.structure.CellLayout_Vertical" flags="nn" index="2iRkQZ" />
      <concept id="1142886221719" name="jetbrains.mps.lang.editor.structure.QueryFunction_NodeCondition" flags="in" index="pkWqt" />
      <concept id="1142886811589" name="jetbrains.mps.lang.editor.structure.ConceptFunctionParameter_node" flags="nn" index="pncrf" />
      <concept id="1080736578640" name="jetbrains.mps.lang.editor.structure.BaseEditorComponent" flags="ig" index="2wURMF">
        <child id="1080736633877" name="cellModel" index="2wV5jI" />
      </concept>
      <concept id="1186403694788" name="jetbrains.mps.lang.editor.structure.ColorStyleClassItem" flags="ln" index="VaVBg">
        <property id="1186403713874" name="color" index="Vb096" />
      </concept>
      <concept id="1186403751766" name="jetbrains.mps.lang.editor.structure.FontStyleStyleClassItem" flags="ln" index="Vb9p2">
        <property id="1186403771423" name="style" index="Vbekb" />
      </concept>
      <concept id="1186404549998" name="jetbrains.mps.lang.editor.structure.ForegroundColorStyleClassItem" flags="ln" index="VechU" />
      <concept id="1186414928363" name="jetbrains.mps.lang.editor.structure.SelectableStyleSheetItem" flags="ln" index="VPM3Z" />
      <concept id="1233823429331" name="jetbrains.mps.lang.editor.structure.HorizontalGapStyleClassItem" flags="ln" index="15ARfc" />
      <concept id="1088013125922" name="jetbrains.mps.lang.editor.structure.CellModel_RefCell" flags="sg" stub="730538219795941030" index="1iCGBv">
        <child id="1088186146602" name="editorComponent" index="1sWHZn" />
      </concept>
      <concept id="1088185857835" name="jetbrains.mps.lang.editor.structure.InlineEditorComponent" flags="ig" index="1sVBvm" />
      <concept id="1215007762405" name="jetbrains.mps.lang.editor.structure.FloatStyleClassItem" flags="ln" index="3$6MrZ">
        <property id="1215007802031" name="value" index="3$6WeP" />
      </concept>
      <concept id="1139848536355" name="jetbrains.mps.lang.editor.structure.CellModel_WithRole" flags="ng" index="1$h60E">
        <property id="1140017977771" name="readOnly" index="1Intyy" />
        <reference id="1140103550593" name="relationDeclaration" index="1NtTu8" />
      </concept>
      <concept id="1073389214265" name="jetbrains.mps.lang.editor.structure.EditorCellModel" flags="ng" index="3EYTF0">
        <child id="1142887637401" name="renderingCondition" index="pqm2j" />
      </concept>
      <concept id="1073389446423" name="jetbrains.mps.lang.editor.structure.CellModel_Collection" flags="sn" stub="3013115976261988961" index="3EZMnI">
        <child id="1106270802874" name="cellLayout" index="2iSdaV" />
        <child id="1073389446424" name="childCellModel" index="3EZMnx" />
      </concept>
      <concept id="1073389577006" name="jetbrains.mps.lang.editor.structure.CellModel_Constant" flags="sn" stub="3610246225209162225" index="3F0ifn">
        <property id="1073389577007" name="text" index="3F0ifm" />
      </concept>
      <concept id="1073389658414" name="jetbrains.mps.lang.editor.structure.CellModel_Property" flags="sg" stub="730538219796134133" index="3F0A7n" />
      <concept id="1219418625346" name="jetbrains.mps.lang.editor.structure.IStyleContainer" flags="ngI" index="3F0Thp">
        <child id="1219418656006" name="styleItem" index="3F10Kt" />
      </concept>
      <concept id="1073390211982" name="jetbrains.mps.lang.editor.structure.CellModel_RefNodeList" flags="sg" stub="2794558372793454595" index="3F2HdR" />
      <concept id="1198256887712" name="jetbrains.mps.lang.editor.structure.CellModel_Indent" flags="ng" index="3XFhqQ" />
      <concept id="1166049232041" name="jetbrains.mps.lang.editor.structure.AbstractComponent" flags="ng" index="1XWOmA">
        <reference id="1166049300910" name="conceptDeclaration" index="1XX52x" />
      </concept>
    </language>
    <language id="f3061a53-9226-4cc5-a443-f952ceaf5816" name="jetbrains.mps.baseLanguage">
      <concept id="1197027756228" name="jetbrains.mps.baseLanguage.structure.DotExpression" flags="nn" index="2OqwBi">
        <child id="1197027771414" name="operand" index="2Oq$k0" />
        <child id="1197027833540" name="operation" index="2OqNvi" />
      </concept>
      <concept id="1137021947720" name="jetbrains.mps.baseLanguage.structure.ConceptFunction" flags="in" index="2VMwT0">
        <child id="1137022507850" name="body" index="2VODD2" />
      </concept>
      <concept id="1068580123155" name="jetbrains.mps.baseLanguage.structure.ExpressionStatement" flags="nn" index="3clFbF">
        <child id="1068580123156" name="expression" index="3clFbG" />
      </concept>
      <concept id="1068580123136" name="jetbrains.mps.baseLanguage.structure.StatementList" flags="sn" stub="5293379017992965193" index="3clFbS">
        <child id="1068581517665" name="statement" index="3cqZAp" />
      </concept>
    </language>
    <language id="7866978e-a0f0-4cc7-81bc-4d213d9375e1" name="jetbrains.mps.lang.smodel">
      <concept id="7236635212850979475" name="jetbrains.mps.lang.smodel.structure.Node_HasNextSiblingOperation" flags="nn" index="rvlfL" />
    </language>
  </registry>
  <node concept="24kQdi" id="7I27HmZrM4Q">
    <ref role="1XX52x" to="y20r:3YATvlM2MEa" resolve="Model" />
    <node concept="3EZMnI" id="7I27HmZrM4S" role="2wV5jI">
      <node concept="3EZMnI" id="7I27HmZrM4W" role="3EZMnx">
        <node concept="VPM3Z" id="7I27HmZrM4Y" role="3F10Kt" />
        <node concept="15ARfc" id="7I27HmZv6oG" role="3F10Kt">
          <property role="3$6WeP" value="0" />
        </node>
        <node concept="3F0A7n" id="7I27HmZrM54" role="3EZMnx">
          <ref role="1NtTu8" to="tpck:h0TrG11" resolve="name" />
          <node concept="VechU" id="7I27HmZszOp" role="3F10Kt">
            <property role="Vb096" value="fLwANPp/orange" />
          </node>
        </node>
        <node concept="3F0ifn" id="7I27HmZsTSs" role="3EZMnx">
          <property role="3F0ifm" value=":" />
        </node>
        <node concept="2iRfu4" id="7I27HmZrM51" role="2iSdaV" />
      </node>
      <node concept="3EZMnI" id="6gCHjbahyDC" role="3EZMnx">
        <node concept="VPM3Z" id="6gCHjbahyDE" role="3F10Kt" />
        <node concept="3XFhqQ" id="6gCHjbahyEn" role="3EZMnx" />
        <node concept="2iRfu4" id="6gCHjbahyDH" role="2iSdaV" />
        <node concept="3F0ifn" id="6gCHjbahyEt" role="3EZMnx">
          <property role="3F0ifm" value="logs:" />
        </node>
        <node concept="3F0A7n" id="6gCHjbahyE_" role="3EZMnx">
          <ref role="1NtTu8" to="y20r:3YATvlM2RYC" resolve="logs" />
        </node>
      </node>
      <node concept="3EZMnI" id="7I27HmZsuLR" role="3EZMnx">
        <node concept="VPM3Z" id="7I27HmZsuLT" role="3F10Kt" />
        <node concept="3XFhqQ" id="7I27HmZsuMo" role="3EZMnx" />
        <node concept="3EZMnI" id="7I27HmZsuMr" role="3EZMnx">
          <node concept="VPM3Z" id="7I27HmZsuMt" role="3F10Kt" />
          <node concept="3F0ifn" id="7I27HmZsuM$" role="3EZMnx">
            <property role="3F0ifm" value="tables:" />
          </node>
          <node concept="3EZMnI" id="7I27HmZsxiT" role="3EZMnx">
            <node concept="VPM3Z" id="7I27HmZsxiV" role="3F10Kt" />
            <node concept="3XFhqQ" id="7I27HmZsxiZ" role="3EZMnx" />
            <node concept="3F2HdR" id="7I27HmZsxj2" role="3EZMnx">
              <ref role="1NtTu8" to="y20r:2vEFosvwxyL" resolve="tables" />
              <node concept="2iRkQZ" id="7I27HmZsxj5" role="2czzBx" />
              <node concept="VPM3Z" id="7I27HmZsxj6" role="3F10Kt" />
            </node>
            <node concept="2iRfu4" id="7I27HmZsxiY" role="2iSdaV" />
          </node>
          <node concept="2iRkQZ" id="7I27HmZsuMw" role="2iSdaV" />
        </node>
        <node concept="2iRfu4" id="7I27HmZsuLW" role="2iSdaV" />
      </node>
      <node concept="3EZMnI" id="7I27HmZu9mM" role="3EZMnx">
        <node concept="VPM3Z" id="7I27HmZu9mO" role="3F10Kt" />
        <node concept="3XFhqQ" id="7I27HmZu9mS" role="3EZMnx" />
        <node concept="3EZMnI" id="7I27HmZu9mV" role="3EZMnx">
          <node concept="VPM3Z" id="7I27HmZu9mX" role="3F10Kt" />
          <node concept="3F0ifn" id="7I27HmZu9n3" role="3EZMnx">
            <property role="3F0ifm" value="steps:" />
          </node>
          <node concept="3EZMnI" id="7I27HmZu9n6" role="3EZMnx">
            <node concept="VPM3Z" id="7I27HmZu9n8" role="3F10Kt" />
            <node concept="3XFhqQ" id="7I27HmZu9ne" role="3EZMnx" />
            <node concept="3F2HdR" id="7I27HmZu9nh" role="3EZMnx">
              <ref role="1NtTu8" to="y20r:3YATvlM2RYA" resolve="steps" />
              <node concept="2iRkQZ" id="7I27HmZu9nk" role="2czzBx" />
              <node concept="VPM3Z" id="7I27HmZu9nl" role="3F10Kt" />
            </node>
            <node concept="2iRfu4" id="7I27HmZu9nb" role="2iSdaV" />
          </node>
          <node concept="2iRkQZ" id="7I27HmZu9n0" role="2iSdaV" />
        </node>
        <node concept="2iRfu4" id="7I27HmZu9mR" role="2iSdaV" />
      </node>
      <node concept="2iRkQZ" id="7I27HmZrM4V" role="2iSdaV" />
    </node>
  </node>
  <node concept="24kQdi" id="7I27HmZt41l">
    <ref role="1XX52x" to="y20r:3YATvlM33Cc" resolve="Table" />
    <node concept="3EZMnI" id="7I27HmZt41r" role="2wV5jI">
      <node concept="3XFhqQ" id="7I27HmZt41v" role="3EZMnx" />
      <node concept="3EZMnI" id="7I27HmZt41y" role="3EZMnx">
        <node concept="VPM3Z" id="7I27HmZt41$" role="3F10Kt" />
        <node concept="3EZMnI" id="7I27HmZt7kT" role="3EZMnx">
          <node concept="VPM3Z" id="7I27HmZt7kV" role="3F10Kt" />
          <node concept="15ARfc" id="7I27HmZuWEJ" role="3F10Kt">
            <property role="3$6WeP" value="0" />
          </node>
          <node concept="3F0A7n" id="7I27HmZt7kZ" role="3EZMnx">
            <ref role="1NtTu8" to="tpck:h0TrG11" resolve="name" />
            <node concept="15ARfc" id="7I27HmZuvwN" role="3F10Kt">
              <property role="3$6WeP" value="0" />
            </node>
            <node concept="VechU" id="5N3gWgd$Lge" role="3F10Kt">
              <property role="Vb096" value="fLwANPr/green" />
            </node>
          </node>
          <node concept="3F0ifn" id="7I27HmZt7l2" role="3EZMnx">
            <property role="3F0ifm" value=":" />
          </node>
          <node concept="2iRfu4" id="7I27HmZt7kY" role="2iSdaV" />
        </node>
        <node concept="3EZMnI" id="7I27HmZtaDz" role="3EZMnx">
          <node concept="VPM3Z" id="7I27HmZtaD_" role="3F10Kt" />
          <node concept="3XFhqQ" id="7I27HmZtaDD" role="3EZMnx" />
          <node concept="3F2HdR" id="7I27HmZtaDG" role="3EZMnx">
            <ref role="1NtTu8" to="y20r:3YATvlM3aeB" resolve="columns" />
            <node concept="2iRkQZ" id="7I27HmZtaDJ" role="2czzBx" />
            <node concept="VPM3Z" id="7I27HmZtaDK" role="3F10Kt" />
          </node>
          <node concept="2iRfu4" id="7I27HmZtaDC" role="2iSdaV" />
        </node>
        <node concept="3F0ifn" id="7I27HmZtKHr" role="3EZMnx" />
        <node concept="2iRkQZ" id="7I27HmZt41B" role="2iSdaV" />
      </node>
      <node concept="2iRfu4" id="7I27HmZt41u" role="2iSdaV" />
    </node>
  </node>
  <node concept="24kQdi" id="7I27HmZte5k">
    <ref role="1XX52x" to="y20r:3YATvlM33Cf" resolve="Column" />
    <node concept="3EZMnI" id="7I27HmZte5q" role="2wV5jI">
      <node concept="3F0A7n" id="7I27HmZte5u" role="3EZMnx">
        <ref role="1NtTu8" to="tpck:h0TrG11" resolve="name" />
      </node>
      <node concept="3F0ifn" id="7I27HmZte5x" role="3EZMnx">
        <property role="3F0ifm" value="as" />
      </node>
      <node concept="3F0A7n" id="7I27HmZte5$" role="3EZMnx">
        <ref role="1NtTu8" to="y20r:3YATvlM33Cq" resolve="dataType" />
        <node concept="VechU" id="7I27HmZtxJJ" role="3F10Kt">
          <property role="Vb096" value="fLwANPs/magenta" />
        </node>
      </node>
      <node concept="2iRfu4" id="7I27HmZte5t" role="2iSdaV" />
    </node>
  </node>
  <node concept="24kQdi" id="7I27HmZuerG">
    <ref role="1XX52x" to="y20r:2vEFosvwouV" resolve="Import" />
    <node concept="3EZMnI" id="7I27HmZuerM" role="2wV5jI">
      <node concept="3XFhqQ" id="7I27HmZuerR" role="3EZMnx" />
      <node concept="3EZMnI" id="7I27HmZuerU" role="3EZMnx">
        <node concept="VPM3Z" id="7I27HmZuerW" role="3F10Kt" />
        <node concept="3EZMnI" id="7I27HmZues2" role="3EZMnx">
          <node concept="VPM3Z" id="7I27HmZues4" role="3F10Kt" />
          <node concept="3F0ifn" id="7I27HmZues8" role="3EZMnx">
            <property role="3F0ifm" value="IMPORT" />
            <node concept="VechU" id="7I27HmZyLAz" role="3F10Kt">
              <property role="Vb096" value="fLwANPu/blue" />
            </node>
          </node>
          <node concept="3EZMnI" id="7I27HmZyBRE" role="3EZMnx">
            <node concept="VPM3Z" id="7I27HmZyBRG" role="3F10Kt" />
            <node concept="15ARfc" id="7I27HmZyBRV" role="3F10Kt">
              <property role="3$6WeP" value="0" />
            </node>
            <node concept="3F0ifn" id="7I27HmZyBRM" role="3EZMnx">
              <property role="3F0ifm" value="&quot;" />
            </node>
            <node concept="3F0A7n" id="7I27HmZyBRP" role="3EZMnx">
              <ref role="1NtTu8" to="tpck:h0TrG11" resolve="name" />
            </node>
            <node concept="3F0ifn" id="7I27HmZyBRS" role="3EZMnx">
              <property role="3F0ifm" value="&quot; " />
            </node>
            <node concept="3F0ifn" id="7I27HmZD7hU" role="3EZMnx">
              <property role="3F0ifm" value="-&gt;" />
              <node concept="VechU" id="7I27HmZD7hZ" role="3F10Kt">
                <property role="Vb096" value="fLwANPu/blue" />
              </node>
            </node>
            <node concept="2iRfu4" id="7I27HmZyBRJ" role="2iSdaV" />
            <node concept="3F0ifn" id="7I27HmZD7hX" role="3EZMnx">
              <property role="3F0ifm" value=" &quot;" />
            </node>
            <node concept="1iCGBv" id="7I27HmZACyA" role="3EZMnx">
              <ref role="1NtTu8" to="y20r:3YATvlM33C9" resolve="next" />
              <node concept="1sVBvm" id="7I27HmZACyC" role="1sWHZn">
                <node concept="3F0A7n" id="7I27HmZACyG" role="2wV5jI">
                  <property role="1Intyy" value="true" />
                  <ref role="1NtTu8" to="tpck:h0TrG11" resolve="name" />
                </node>
              </node>
            </node>
            <node concept="3F0ifn" id="7I27HmZACyJ" role="3EZMnx">
              <property role="3F0ifm" value="&quot;:" />
            </node>
          </node>
          <node concept="2iRfu4" id="7I27HmZues7" role="2iSdaV" />
        </node>
        <node concept="3EZMnI" id="7I27HmZuesp" role="3EZMnx">
          <node concept="VPM3Z" id="7I27HmZuesr" role="3F10Kt" />
          <node concept="3XFhqQ" id="7I27HmZuesv" role="3EZMnx" />
          <node concept="3F2HdR" id="7I27HmZues$" role="3EZMnx">
            <ref role="1NtTu8" to="y20r:2vEFosvwwgQ" resolve="tablesToImport" />
            <node concept="2iRkQZ" id="7I27HmZuesB" role="2czzBx" />
            <node concept="VPM3Z" id="7I27HmZuesC" role="3F10Kt" />
          </node>
          <node concept="2iRfu4" id="7I27HmZuesu" role="2iSdaV" />
        </node>
        <node concept="3F0ifn" id="7I27HmZBiit" role="3EZMnx" />
        <node concept="2iRkQZ" id="7I27HmZuerZ" role="2iSdaV" />
      </node>
      <node concept="2iRfu4" id="7I27HmZuerP" role="2iSdaV" />
    </node>
  </node>
  <node concept="24kQdi" id="7I27HmZuksg">
    <ref role="1XX52x" to="y20r:2vEFosvwwgI" resolve="TableToImport" />
    <node concept="3EZMnI" id="7I27HmZuksi" role="2wV5jI">
      <node concept="3F0ifn" id="7I27HmZukso" role="3EZMnx">
        <property role="3F0ifm" value="IMPORT FROM" />
      </node>
      <node concept="3EZMnI" id="7I27HmZAkXk" role="3EZMnx">
        <node concept="VPM3Z" id="7I27HmZAkXm" role="3F10Kt" />
        <node concept="15ARfc" id="7I27HmZAkXz" role="3F10Kt">
          <property role="3$6WeP" value="0" />
        </node>
        <node concept="3F0ifn" id="7I27HmZAkXs" role="3EZMnx">
          <property role="3F0ifm" value="&quot;" />
        </node>
        <node concept="2iRfu4" id="7I27HmZAkXp" role="2iSdaV" />
        <node concept="3F0A7n" id="7I27HmZukss" role="3EZMnx">
          <ref role="1NtTu8" to="y20r:2vEFosvwwgM" resolve="path" />
        </node>
        <node concept="3F0ifn" id="7I27HmZAkXw" role="3EZMnx">
          <property role="3F0ifm" value="&quot;" />
        </node>
      </node>
      <node concept="3F0ifn" id="7I27HmZuksx" role="3EZMnx">
        <property role="3F0ifm" value="TO" />
      </node>
      <node concept="1iCGBv" id="7I27HmZuks$" role="3EZMnx">
        <ref role="1NtTu8" to="y20r:2vEFosvwwgK" resolve="table" />
        <node concept="1sVBvm" id="7I27HmZuksA" role="1sWHZn">
          <node concept="3F0A7n" id="7I27HmZuksE" role="2wV5jI">
            <property role="1Intyy" value="true" />
            <ref role="1NtTu8" to="tpck:h0TrG11" resolve="name" />
            <node concept="VechU" id="7I27HmZA1si" role="3F10Kt">
              <property role="Vb096" value="fLwANPr/green" />
            </node>
          </node>
        </node>
      </node>
      <node concept="3F0ifn" id="7I27HmZuksH" role="3EZMnx">
        <property role="3F0ifm" value="WITH DELIMITER" />
      </node>
      <node concept="3EZMnI" id="7I27HmZAuIX" role="3EZMnx">
        <node concept="VPM3Z" id="7I27HmZAuIZ" role="3F10Kt" />
        <node concept="15ARfc" id="7I27HmZAuJa" role="3F10Kt">
          <property role="3$6WeP" value="0" />
        </node>
        <node concept="3F0ifn" id="7I27HmZAuJ3" role="3EZMnx">
          <property role="3F0ifm" value="&quot;" />
        </node>
        <node concept="2iRfu4" id="7I27HmZAuJ2" role="2iSdaV" />
        <node concept="3F0A7n" id="7I27HmZuksK" role="3EZMnx">
          <ref role="1NtTu8" to="y20r:2vEFosvwwgO" resolve="delimiter" />
        </node>
        <node concept="3F0ifn" id="7I27HmZAuJ7" role="3EZMnx">
          <property role="3F0ifm" value="&quot;" />
        </node>
      </node>
      <node concept="3F0ifn" id="7I27HmZuksP" role="3EZMnx">
        <property role="3F0ifm" value="AND DELETE_MISMATCHED_TYPES AS" />
      </node>
      <node concept="3F0A7n" id="7I27HmZuksS" role="3EZMnx">
        <ref role="1NtTu8" to="y20r:2vEFosvwwgN" resolve="deleteMismatchedTypes" />
      </node>
      <node concept="2iRfu4" id="7I27HmZuksl" role="2iSdaV" />
    </node>
  </node>
  <node concept="24kQdi" id="7I27HmZANPd">
    <ref role="1XX52x" to="y20r:59Zp2b9mQGq" resolve="RemoveDuplicates" />
    <node concept="3EZMnI" id="7I27HmZANPf" role="2wV5jI">
      <node concept="3XFhqQ" id="7I27HmZANPj" role="3EZMnx" />
      <node concept="3EZMnI" id="7I27HmZANPm" role="3EZMnx">
        <node concept="VPM3Z" id="7I27HmZANPo" role="3F10Kt" />
        <node concept="3EZMnI" id="7I27HmZANPs" role="3EZMnx">
          <node concept="VPM3Z" id="7I27HmZANPu" role="3F10Kt" />
          <node concept="3F0ifn" id="7I27HmZANPy" role="3EZMnx">
            <property role="3F0ifm" value="REMOVE_DUPLICATES" />
            <node concept="VechU" id="7I27HmZANPZ" role="3F10Kt">
              <property role="Vb096" value="fLwANPu/blue" />
            </node>
          </node>
          <node concept="2iRfu4" id="7I27HmZANPx" role="2iSdaV" />
          <node concept="3EZMnI" id="7I27HmZANP_" role="3EZMnx">
            <node concept="VPM3Z" id="7I27HmZANPB" role="3F10Kt" />
            <node concept="15ARfc" id="7I27HmZANQ1" role="3F10Kt">
              <property role="3$6WeP" value="0" />
            </node>
            <node concept="3F0ifn" id="7I27HmZANPF" role="3EZMnx">
              <property role="3F0ifm" value="&quot;" />
            </node>
            <node concept="2iRfu4" id="7I27HmZANPE" role="2iSdaV" />
            <node concept="3F0A7n" id="7I27HmZANPI" role="3EZMnx">
              <ref role="1NtTu8" to="tpck:h0TrG11" resolve="name" />
            </node>
            <node concept="3F0ifn" id="7I27HmZANPL" role="3EZMnx">
              <property role="3F0ifm" value="&quot; " />
            </node>
            <node concept="3F0ifn" id="7I27HmZC_Pz" role="3EZMnx">
              <property role="3F0ifm" value="-&gt;" />
              <node concept="VechU" id="7I27HmZC_PC" role="3F10Kt">
                <property role="Vb096" value="fLwANPu/blue" />
              </node>
            </node>
            <node concept="3F0ifn" id="7I27HmZC_PA" role="3EZMnx">
              <property role="3F0ifm" value=" &quot;" />
            </node>
            <node concept="1iCGBv" id="7I27HmZANPO" role="3EZMnx">
              <ref role="1NtTu8" to="y20r:3YATvlM33C9" resolve="next" />
              <node concept="1sVBvm" id="7I27HmZANPQ" role="1sWHZn">
                <node concept="3F0A7n" id="7I27HmZANPU" role="2wV5jI">
                  <property role="1Intyy" value="true" />
                  <ref role="1NtTu8" to="tpck:h0TrG11" resolve="name" />
                </node>
              </node>
            </node>
            <node concept="3F0ifn" id="7I27HmZANPX" role="3EZMnx">
              <property role="3F0ifm" value="&quot;:" />
            </node>
          </node>
        </node>
        <node concept="3EZMnI" id="7I27HmZB1_4" role="3EZMnx">
          <node concept="VPM3Z" id="7I27HmZB1_6" role="3F10Kt" />
          <node concept="3XFhqQ" id="7I27HmZB1_a" role="3EZMnx" />
          <node concept="3F0ifn" id="7I27HmZB1_f" role="3EZMnx">
            <property role="3F0ifm" value="ON" />
          </node>
          <node concept="3EZMnI" id="7I27HmZBNsp" role="3EZMnx">
            <node concept="VPM3Z" id="7I27HmZBNsr" role="3F10Kt" />
            <node concept="15ARfc" id="7I27HmZC4sh" role="3F10Kt">
              <property role="3$6WeP" value="0" />
            </node>
            <node concept="1iCGBv" id="7I27HmZB1_i" role="3EZMnx">
              <ref role="1NtTu8" to="y20r:59Zp2b9mQGs" resolve="table" />
              <node concept="1sVBvm" id="7I27HmZB1_k" role="1sWHZn">
                <node concept="3F0A7n" id="7I27HmZB1_o" role="2wV5jI">
                  <property role="1Intyy" value="true" />
                  <ref role="1NtTu8" to="tpck:h0TrG11" resolve="name" />
                  <node concept="VechU" id="7I27HmZCl25" role="3F10Kt">
                    <property role="Vb096" value="fLwANPr/green" />
                  </node>
                </node>
              </node>
            </node>
            <node concept="2iRfu4" id="7I27HmZBNsu" role="2iSdaV" />
            <node concept="3F0ifn" id="7I27HmZB1_r" role="3EZMnx">
              <property role="3F0ifm" value="(" />
            </node>
            <node concept="1iCGBv" id="7I27HmZB1_u" role="3EZMnx">
              <ref role="1NtTu8" to="y20r:59Zp2b9mQGt" resolve="column" />
              <node concept="1sVBvm" id="7I27HmZB1_w" role="1sWHZn">
                <node concept="3F0A7n" id="7I27HmZB1_$" role="2wV5jI">
                  <property role="1Intyy" value="true" />
                  <ref role="1NtTu8" to="tpck:h0TrG11" resolve="name" />
                </node>
              </node>
            </node>
            <node concept="3F0ifn" id="7I27HmZB1_B" role="3EZMnx">
              <property role="3F0ifm" value=")" />
            </node>
          </node>
          <node concept="2iRfu4" id="7I27HmZB1_9" role="2iSdaV" />
        </node>
        <node concept="3F0ifn" id="7I27HmZBiir" role="3EZMnx" />
        <node concept="2iRkQZ" id="7I27HmZANPr" role="2iSdaV" />
      </node>
      <node concept="2iRfu4" id="7I27HmZANPi" role="2iSdaV" />
    </node>
  </node>
  <node concept="24kQdi" id="7I27HmZDnUY">
    <ref role="1XX52x" to="y20r:59Zp2b9n1iz" resolve="Filter" />
    <node concept="3EZMnI" id="7I27HmZDnV0" role="2wV5jI">
      <node concept="3XFhqQ" id="7I27HmZDnV4" role="3EZMnx" />
      <node concept="3EZMnI" id="7I27HmZDnV7" role="3EZMnx">
        <node concept="VPM3Z" id="7I27HmZDnV9" role="3F10Kt" />
        <node concept="3EZMnI" id="7I27HmZDnVd" role="3EZMnx">
          <node concept="VPM3Z" id="7I27HmZDnVf" role="3F10Kt" />
          <node concept="3F0ifn" id="7I27HmZDnVl" role="3EZMnx">
            <property role="3F0ifm" value="FILTER" />
            <node concept="VechU" id="7I27HmZE$cC" role="3F10Kt">
              <property role="Vb096" value="fLwANPu/blue" />
            </node>
          </node>
          <node concept="2iRfu4" id="7I27HmZDnVi" role="2iSdaV" />
          <node concept="3EZMnI" id="7I27HmZDnVo" role="3EZMnx">
            <node concept="VPM3Z" id="7I27HmZDnVq" role="3F10Kt" />
            <node concept="15ARfc" id="7I27HmZDnVT" role="3F10Kt">
              <property role="3$6WeP" value="0" />
            </node>
            <node concept="3F0ifn" id="7I27HmZDnVv" role="3EZMnx">
              <property role="3F0ifm" value="&quot;" />
            </node>
            <node concept="3F0A7n" id="7I27HmZDnVx" role="3EZMnx">
              <ref role="1NtTu8" to="tpck:h0TrG11" resolve="name" />
            </node>
            <node concept="2iRfu4" id="7I27HmZDnVt" role="2iSdaV" />
            <node concept="3F0ifn" id="7I27HmZDnV$" role="3EZMnx">
              <property role="3F0ifm" value="&quot; " />
            </node>
            <node concept="3F0ifn" id="7I27HmZDnVB" role="3EZMnx">
              <property role="3F0ifm" value="-&gt;" />
              <node concept="VechU" id="7I27HmZFe$N" role="3F10Kt">
                <property role="Vb096" value="fLwANPu/blue" />
              </node>
            </node>
            <node concept="3F0ifn" id="7I27HmZDnVE" role="3EZMnx">
              <property role="3F0ifm" value=" &quot;" />
            </node>
            <node concept="1iCGBv" id="7I27HmZDnVH" role="3EZMnx">
              <ref role="1NtTu8" to="y20r:3YATvlM33C9" resolve="next" />
              <node concept="1sVBvm" id="7I27HmZDnVJ" role="1sWHZn">
                <node concept="3F0A7n" id="7I27HmZDnVN" role="2wV5jI">
                  <property role="1Intyy" value="true" />
                  <ref role="1NtTu8" to="tpck:h0TrG11" resolve="name" />
                </node>
              </node>
            </node>
            <node concept="3F0ifn" id="7I27HmZDnVQ" role="3EZMnx">
              <property role="3F0ifm" value="&quot;:" />
            </node>
          </node>
        </node>
        <node concept="3EZMnI" id="7I27HmZERaI" role="3EZMnx">
          <node concept="VPM3Z" id="7I27HmZERaK" role="3F10Kt" />
          <node concept="3XFhqQ" id="7I27HmZERaO" role="3EZMnx" />
          <node concept="3F0ifn" id="7I27HmZERaR" role="3EZMnx">
            <property role="3F0ifm" value="ON" />
          </node>
          <node concept="2iRfu4" id="7I27HmZERaN" role="2iSdaV" />
          <node concept="3EZMnI" id="7I27HmZERaU" role="3EZMnx">
            <node concept="VPM3Z" id="7I27HmZERaW" role="3F10Kt" />
            <node concept="15ARfc" id="7I27HmZERbp" role="3F10Kt">
              <property role="3$6WeP" value="0" />
            </node>
            <node concept="1iCGBv" id="7I27HmZERb0" role="3EZMnx">
              <ref role="1NtTu8" to="y20r:59Zp2b9pJz$" resolve="table" />
              <node concept="1sVBvm" id="7I27HmZERb2" role="1sWHZn">
                <node concept="3F0A7n" id="7I27HmZERb6" role="2wV5jI">
                  <property role="1Intyy" value="true" />
                  <ref role="1NtTu8" to="tpck:h0TrG11" resolve="name" />
                  <node concept="VechU" id="7I27HmZERbn" role="3F10Kt">
                    <property role="Vb096" value="fLwANPr/green" />
                  </node>
                </node>
              </node>
            </node>
            <node concept="2iRfu4" id="7I27HmZERaZ" role="2iSdaV" />
            <node concept="3F0ifn" id="7I27HmZERb9" role="3EZMnx">
              <property role="3F0ifm" value="(" />
            </node>
            <node concept="1iCGBv" id="7I27HmZERbc" role="3EZMnx">
              <ref role="1NtTu8" to="y20r:59Zp2b9pJzz" resolve="column" />
              <node concept="1sVBvm" id="7I27HmZERbe" role="1sWHZn">
                <node concept="3F0A7n" id="7I27HmZERbi" role="2wV5jI">
                  <property role="1Intyy" value="true" />
                  <ref role="1NtTu8" to="tpck:h0TrG11" resolve="name" />
                </node>
              </node>
            </node>
            <node concept="3F0ifn" id="7I27HmZERbl" role="3EZMnx">
              <property role="3F0ifm" value=")" />
            </node>
          </node>
          <node concept="3F0ifn" id="7I27HmZERbt" role="3EZMnx">
            <property role="3F0ifm" value="WHERE VALUES ARE" />
          </node>
          <node concept="3F0A7n" id="7I27HmZERbw" role="3EZMnx">
            <ref role="1NtTu8" to="y20r:59Zp2b9qgtr" resolve="operator" />
            <node concept="Vb9p2" id="7I27HmZF_Yq" role="3F10Kt">
              <property role="Vbekb" value="g1_kEg4/ITALIC" />
            </node>
          </node>
          <node concept="3F0A7n" id="7I27HmZERbz" role="3EZMnx">
            <ref role="1NtTu8" to="y20r:59Zp2b9qgtt" resolve="operand" />
          </node>
        </node>
        <node concept="3F0ifn" id="7I27HmZERbr" role="3EZMnx" />
        <node concept="2iRkQZ" id="7I27HmZDnVc" role="2iSdaV" />
      </node>
      <node concept="2iRfu4" id="7I27HmZDnV3" role="2iSdaV" />
    </node>
  </node>
  <node concept="24kQdi" id="7I27HmZJ4Bl">
    <ref role="1XX52x" to="y20r:3YATvlM33Vi" resolve="ColumnRef" />
    <node concept="3EZMnI" id="7I27HmZJ4Bn" role="2wV5jI">
      <node concept="1iCGBv" id="7I27HmZJ4Br" role="3EZMnx">
        <ref role="1NtTu8" to="y20r:5ZmGmhlmOnj" resolve="column" />
        <node concept="1sVBvm" id="7I27HmZJ4Bt" role="1sWHZn">
          <node concept="3F0A7n" id="7I27HmZJ4Bx" role="2wV5jI">
            <property role="1Intyy" value="true" />
            <ref role="1NtTu8" to="tpck:h0TrG11" resolve="name" />
          </node>
        </node>
      </node>
      <node concept="3F0ifn" id="7I27HmZL27b" role="3EZMnx">
        <property role="3F0ifm" value=", " />
        <node concept="pkWqt" id="7I27HmZMvNQ" role="pqm2j">
          <node concept="3clFbS" id="7I27HmZMvNR" role="2VODD2">
            <node concept="3clFbF" id="7I27HmZMvOk" role="3cqZAp">
              <node concept="2OqwBi" id="7I27HmZMzDg" role="3clFbG">
                <node concept="pncrf" id="7I27HmZMzDh" role="2Oq$k0" />
                <node concept="rvlfL" id="7I27HmZMzDi" role="2OqNvi" />
              </node>
            </node>
          </node>
        </node>
      </node>
      <node concept="2iRfu4" id="7I27HmZJ4Bq" role="2iSdaV" />
      <node concept="15ARfc" id="7I27HmZKz69" role="3F10Kt">
        <property role="3$6WeP" value="0" />
      </node>
    </node>
  </node>
  <node concept="24kQdi" id="5N3gWgdiGmN">
    <ref role="1XX52x" to="y20r:5ZmGmhlaPTB" resolve="AppendRows" />
    <node concept="3EZMnI" id="5N3gWgdiGmQ" role="2wV5jI">
      <node concept="3XFhqQ" id="5N3gWgdiGmX" role="3EZMnx" />
      <node concept="2iRfu4" id="5N3gWgdiGmT" role="2iSdaV" />
      <node concept="3EZMnI" id="5N3gWgdiGn3" role="3EZMnx">
        <node concept="VPM3Z" id="5N3gWgdiGn5" role="3F10Kt" />
        <node concept="3EZMnI" id="5N3gWgdiGnh" role="3EZMnx">
          <node concept="VPM3Z" id="5N3gWgdiGnj" role="3F10Kt" />
          <node concept="3F0ifn" id="5N3gWgdiGnl" role="3EZMnx">
            <property role="3F0ifm" value="APPEND_ROWS" />
            <node concept="VechU" id="5N3gWgdjqli" role="3F10Kt">
              <property role="Vb096" value="fLwANPu/blue" />
            </node>
          </node>
          <node concept="2iRfu4" id="5N3gWgdiGnm" role="2iSdaV" />
          <node concept="3EZMnI" id="5N3gWgdiGnu" role="3EZMnx">
            <node concept="VPM3Z" id="5N3gWgdiGnw" role="3F10Kt" />
            <node concept="15ARfc" id="5N3gWgdjqlp" role="3F10Kt">
              <property role="3$6WeP" value="0" />
            </node>
            <node concept="3F0ifn" id="5N3gWgdiGnD" role="3EZMnx">
              <property role="3F0ifm" value="&quot;" />
            </node>
            <node concept="2iRfu4" id="5N3gWgdiGnz" role="2iSdaV" />
            <node concept="3F0A7n" id="5N3gWgdiGnN" role="3EZMnx">
              <ref role="1NtTu8" to="tpck:h0TrG11" resolve="name" />
            </node>
            <node concept="3F0ifn" id="5N3gWgdiGnV" role="3EZMnx">
              <property role="3F0ifm" value="&quot; " />
            </node>
            <node concept="3F0ifn" id="5N3gWgdiGo5" role="3EZMnx">
              <property role="3F0ifm" value="-&gt;" />
              <node concept="VechU" id="5N3gWgdjqlk" role="3F10Kt">
                <property role="Vb096" value="fLwANPu/blue" />
              </node>
            </node>
            <node concept="3F0ifn" id="5N3gWgdiGoh" role="3EZMnx">
              <property role="3F0ifm" value=" &quot;" />
            </node>
            <node concept="1iCGBv" id="5N3gWgdiGov" role="3EZMnx">
              <ref role="1NtTu8" to="y20r:3YATvlM33C9" resolve="next" />
              <node concept="1sVBvm" id="5N3gWgdiGox" role="1sWHZn">
                <node concept="3F0A7n" id="5N3gWgdiGoH" role="2wV5jI">
                  <property role="1Intyy" value="true" />
                  <ref role="1NtTu8" to="tpck:h0TrG11" resolve="name" />
                </node>
              </node>
            </node>
            <node concept="3F0ifn" id="5N3gWgdiGoU" role="3EZMnx">
              <property role="3F0ifm" value="&quot;:" />
            </node>
          </node>
        </node>
        <node concept="3EZMnI" id="5N3gWgdk8HP" role="3EZMnx">
          <node concept="VPM3Z" id="5N3gWgdk8HR" role="3F10Kt" />
          <node concept="3XFhqQ" id="5N3gWgdk8Ii" role="3EZMnx" />
          <node concept="2iRfu4" id="5N3gWgdk8HU" role="2iSdaV" />
          <node concept="3F0ifn" id="5N3gWgdk8Io" role="3EZMnx">
            <property role="3F0ifm" value="FROM" />
          </node>
          <node concept="1iCGBv" id="5N3gWgdk8Iw" role="3EZMnx">
            <ref role="1NtTu8" to="y20r:5ZmGmhlaVe1" resolve="fromTable" />
            <node concept="1sVBvm" id="5N3gWgdk8Iy" role="1sWHZn">
              <node concept="3F0A7n" id="5N3gWgdk8IF" role="2wV5jI">
                <property role="1Intyy" value="true" />
                <ref role="1NtTu8" to="tpck:h0TrG11" resolve="name" />
                <node concept="VechU" id="5N3gWgdk8Jv" role="3F10Kt">
                  <property role="Vb096" value="fLwANPr/green" />
                </node>
              </node>
            </node>
          </node>
          <node concept="3F0ifn" id="5N3gWgdk8IX" role="3EZMnx">
            <property role="3F0ifm" value="TO" />
          </node>
          <node concept="1iCGBv" id="5N3gWgdk8Jd" role="3EZMnx">
            <ref role="1NtTu8" to="y20r:5ZmGmhlaVe5" resolve="toTable" />
            <node concept="1sVBvm" id="5N3gWgdk8Jf" role="1sWHZn">
              <node concept="3F0A7n" id="5N3gWgdk8Js" role="2wV5jI">
                <property role="1Intyy" value="true" />
                <ref role="1NtTu8" to="tpck:h0TrG11" resolve="name" />
                <node concept="VechU" id="5N3gWgdk8Jx" role="3F10Kt">
                  <property role="Vb096" value="fLwANPr/green" />
                </node>
              </node>
            </node>
          </node>
        </node>
        <node concept="3EZMnI" id="5N3gWgdkTFj" role="3EZMnx">
          <node concept="VPM3Z" id="5N3gWgdkTFl" role="3F10Kt" />
          <node concept="15ARfc" id="5N3gWgdnYNE" role="3F10Kt">
            <property role="3$6WeP" value="0" />
          </node>
          <node concept="3XFhqQ" id="5N3gWgdkTFY" role="3EZMnx" />
          <node concept="2iRfu4" id="5N3gWgdkTFo" role="2iSdaV" />
          <node concept="3F0ifn" id="5N3gWgdkTG8" role="3EZMnx">
            <property role="3F0ifm" value="MAPPING" />
          </node>
          <node concept="3F0ifn" id="5N3gWgdnYNy" role="3EZMnx">
            <property role="3F0ifm" value=":" />
          </node>
        </node>
        <node concept="3EZMnI" id="5N3gWgdlEP9" role="3EZMnx">
          <node concept="VPM3Z" id="5N3gWgdlEPb" role="3F10Kt" />
          <node concept="3XFhqQ" id="5N3gWgdlEPZ" role="3EZMnx" />
          <node concept="2iRfu4" id="5N3gWgdlEPe" role="2iSdaV" />
          <node concept="3XFhqQ" id="5N3gWgdmrW9" role="3EZMnx" />
          <node concept="3F2HdR" id="5N3gWgdkTJe" role="3EZMnx">
            <ref role="1NtTu8" to="y20r:5ZmGmhlbtbL" resolve="mappings" />
            <node concept="2iRkQZ" id="5N3gWgdkTJh" role="2czzBx" />
            <node concept="VPM3Z" id="5N3gWgdkTJi" role="3F10Kt" />
          </node>
        </node>
        <node concept="3F0ifn" id="5N3gWgdndwi" role="3EZMnx" />
        <node concept="2iRkQZ" id="5N3gWgdiGn8" role="2iSdaV" />
      </node>
    </node>
  </node>
  <node concept="24kQdi" id="5N3gWgdoKkG">
    <ref role="1XX52x" to="y20r:5ZmGmhlbkC1" resolve="AppendRowsMap" />
    <node concept="3EZMnI" id="5N3gWgdoKkI" role="2wV5jI">
      <node concept="2iRfu4" id="5N3gWgdoKkL" role="2iSdaV" />
      <node concept="1iCGBv" id="5N3gWgdoKlw" role="3EZMnx">
        <ref role="1NtTu8" to="y20r:5ZmGmhlbkC3" resolve="fromCol" />
        <node concept="1sVBvm" id="5N3gWgdoKly" role="1sWHZn">
          <node concept="3F0A7n" id="5N3gWgdoKlE" role="2wV5jI">
            <property role="1Intyy" value="true" />
            <ref role="1NtTu8" to="tpck:h0TrG11" resolve="name" />
          </node>
        </node>
      </node>
      <node concept="3F0ifn" id="5N3gWgdoKlN" role="3EZMnx">
        <property role="3F0ifm" value="to" />
      </node>
      <node concept="1iCGBv" id="5N3gWgdoKm1" role="3EZMnx">
        <ref role="1NtTu8" to="y20r:5ZmGmhlbkC5" resolve="toCol" />
        <node concept="1sVBvm" id="5N3gWgdoKm3" role="1sWHZn">
          <node concept="3F0A7n" id="5N3gWgdoKmf" role="2wV5jI">
            <property role="1Intyy" value="true" />
            <ref role="1NtTu8" to="tpck:h0TrG11" resolve="name" />
          </node>
        </node>
      </node>
    </node>
  </node>
  <node concept="24kQdi" id="5N3gWgdreJj">
    <ref role="1XX52x" to="y20r:5ZmGmhlJvWA" resolve="Lookup" />
    <node concept="3EZMnI" id="5N3gWgdreJl" role="2wV5jI">
      <node concept="3XFhqQ" id="5N3gWgdreJs" role="3EZMnx" />
      <node concept="2iRfu4" id="5N3gWgdreJo" role="2iSdaV" />
      <node concept="3EZMnI" id="5N3gWgdreJy" role="3EZMnx">
        <node concept="VPM3Z" id="5N3gWgdreJ$" role="3F10Kt" />
        <node concept="3EZMnI" id="5N3gWgdreJK" role="3EZMnx">
          <node concept="VPM3Z" id="5N3gWgdreJM" role="3F10Kt" />
          <node concept="3F0ifn" id="5N3gWgdreJO" role="3EZMnx">
            <property role="3F0ifm" value="LOOKUP" />
            <node concept="VechU" id="5N3gWgdreLw" role="3F10Kt">
              <property role="Vb096" value="fLwANPu/blue" />
            </node>
          </node>
          <node concept="2iRfu4" id="5N3gWgdreJP" role="2iSdaV" />
          <node concept="3EZMnI" id="5N3gWgdreJX" role="3EZMnx">
            <node concept="VPM3Z" id="5N3gWgdreJZ" role="3F10Kt" />
            <node concept="15ARfc" id="5N3gWgdzDk6" role="3F10Kt">
              <property role="3$6WeP" value="0" />
            </node>
            <node concept="3F0ifn" id="5N3gWgdreK8" role="3EZMnx">
              <property role="3F0ifm" value="&quot;" />
            </node>
            <node concept="2iRfu4" id="5N3gWgdreK2" role="2iSdaV" />
            <node concept="3F0A7n" id="5N3gWgdreKe" role="3EZMnx">
              <ref role="1NtTu8" to="tpck:h0TrG11" resolve="name" />
            </node>
            <node concept="3F0ifn" id="5N3gWgdreKm" role="3EZMnx">
              <property role="3F0ifm" value="&quot; " />
            </node>
            <node concept="3F0ifn" id="5N3gWgdreKw" role="3EZMnx">
              <property role="3F0ifm" value="-&gt;" />
              <node concept="VechU" id="5N3gWgdreLG" role="3F10Kt">
                <property role="Vb096" value="fLwANPu/blue" />
              </node>
            </node>
            <node concept="3F0ifn" id="5N3gWgdreKG" role="3EZMnx">
              <property role="3F0ifm" value=" &quot;" />
            </node>
            <node concept="1iCGBv" id="5N3gWgdreKU" role="3EZMnx">
              <ref role="1NtTu8" to="y20r:3YATvlM33C9" resolve="next" />
              <node concept="1sVBvm" id="5N3gWgdreKW" role="1sWHZn">
                <node concept="3F0A7n" id="5N3gWgdreL8" role="2wV5jI">
                  <property role="1Intyy" value="true" />
                  <ref role="1NtTu8" to="tpck:h0TrG11" resolve="name" />
                </node>
              </node>
            </node>
            <node concept="3F0ifn" id="5N3gWgdreLl" role="3EZMnx">
              <property role="3F0ifm" value="&quot;:" />
            </node>
          </node>
        </node>
        <node concept="3EZMnI" id="5N3gWgdreM4" role="3EZMnx">
          <node concept="VPM3Z" id="5N3gWgdreM6" role="3F10Kt" />
          <node concept="3XFhqQ" id="5N3gWgdreMw" role="3EZMnx" />
          <node concept="2iRfu4" id="5N3gWgdreM9" role="2iSdaV" />
          <node concept="3F0ifn" id="5N3gWgdreMA" role="3EZMnx">
            <property role="3F0ifm" value="FROM" />
          </node>
          <node concept="3EZMnI" id="5N3gWgdreMI" role="3EZMnx">
            <node concept="VPM3Z" id="5N3gWgdreMK" role="3F10Kt" />
            <node concept="15ARfc" id="5N3gWgdreQI" role="3F10Kt">
              <property role="3$6WeP" value="0" />
            </node>
            <node concept="1iCGBv" id="5N3gWgdreOz" role="3EZMnx">
              <ref role="1NtTu8" to="y20r:5ZmGmhlJvWE" resolve="table" />
              <node concept="1sVBvm" id="5N3gWgdreO_" role="1sWHZn">
                <node concept="3F0A7n" id="5N3gWgdreOG" role="2wV5jI">
                  <property role="1Intyy" value="true" />
                  <ref role="1NtTu8" to="tpck:h0TrG11" resolve="name" />
                  <node concept="VechU" id="5N3gWgdsds2" role="3F10Kt">
                    <property role="Vb096" value="fLwANPr/green" />
                  </node>
                </node>
              </node>
            </node>
            <node concept="2iRfu4" id="5N3gWgdreMN" role="2iSdaV" />
            <node concept="3F0ifn" id="5N3gWgdreOO" role="3EZMnx">
              <property role="3F0ifm" value="(" />
            </node>
            <node concept="1iCGBv" id="5N3gWgdrePf" role="3EZMnx">
              <ref role="1NtTu8" to="y20r:5ZmGmhlJvWO" resolve="column" />
              <node concept="1sVBvm" id="5N3gWgdrePh" role="1sWHZn">
                <node concept="3F0A7n" id="5N3gWgdrePt" role="2wV5jI">
                  <property role="1Intyy" value="true" />
                  <ref role="1NtTu8" to="tpck:h0TrG11" resolve="name" />
                </node>
              </node>
            </node>
            <node concept="3F0ifn" id="5N3gWgdreP7" role="3EZMnx">
              <property role="3F0ifm" value=")" />
            </node>
          </node>
          <node concept="3F0ifn" id="5N3gWgdreN3" role="3EZMnx">
            <property role="3F0ifm" value="TO" />
          </node>
          <node concept="3EZMnI" id="5N3gWgdreNl" role="3EZMnx">
            <node concept="VPM3Z" id="5N3gWgdreNn" role="3F10Kt" />
            <node concept="15ARfc" id="5N3gWgdreQP" role="3F10Kt">
              <property role="3$6WeP" value="0" />
            </node>
            <node concept="1iCGBv" id="5N3gWgdrePw" role="3EZMnx">
              <ref role="1NtTu8" to="y20r:5ZmGmhlJvWH" resolve="lookupTable" />
              <node concept="1sVBvm" id="5N3gWgdrePy" role="1sWHZn">
                <node concept="3F0A7n" id="5N3gWgdrePD" role="2wV5jI">
                  <property role="1Intyy" value="true" />
                  <ref role="1NtTu8" to="tpck:h0TrG11" resolve="name" />
                  <node concept="VechU" id="5N3gWgdsds4" role="3F10Kt">
                    <property role="Vb096" value="fLwANPr/green" />
                  </node>
                </node>
              </node>
            </node>
            <node concept="2iRfu4" id="5N3gWgdreNq" role="2iSdaV" />
            <node concept="3F0ifn" id="5N3gWgdrePL" role="3EZMnx">
              <property role="3F0ifm" value="(" />
            </node>
            <node concept="1iCGBv" id="5N3gWgdreQq" role="3EZMnx">
              <ref role="1NtTu8" to="y20r:5ZmGmhlJvWQ" resolve="matchColumn" />
              <node concept="1sVBvm" id="5N3gWgdreQs" role="1sWHZn">
                <node concept="3F0A7n" id="5N3gWgdreQC" role="2wV5jI">
                  <property role="1Intyy" value="true" />
                  <ref role="1NtTu8" to="tpck:h0TrG11" resolve="name" />
                </node>
              </node>
            </node>
            <node concept="3F0ifn" id="5N3gWgdreQ4" role="3EZMnx">
              <property role="3F0ifm" value=")" />
            </node>
          </node>
        </node>
        <node concept="3EZMnI" id="5N3gWgdtc4C" role="3EZMnx">
          <node concept="VPM3Z" id="5N3gWgdtc4E" role="3F10Kt" />
          <node concept="3XFhqQ" id="5N3gWgdtc5D" role="3EZMnx" />
          <node concept="3F0ifn" id="5N3gWgdreNO" role="3EZMnx">
            <property role="3F0ifm" value="AND PUT" />
          </node>
          <node concept="3F0A7n" id="5N3gWgdreOh" role="3EZMnx">
            <ref role="1NtTu8" to="y20r:5ZmGmhlJvXa" resolve="operation" />
            <node concept="Vb9p2" id="5N3gWgdreOw" role="3F10Kt">
              <property role="Vbekb" value="g1_kEg4/ITALIC" />
            </node>
          </node>
          <node concept="2iRfu4" id="5N3gWgdtc4H" role="2iSdaV" />
          <node concept="3F0ifn" id="5N3gWgduaGv" role="3EZMnx">
            <property role="3F0ifm" value="(" />
          </node>
          <node concept="3EZMnI" id="5N3gWgduaGY" role="3EZMnx">
            <node concept="VPM3Z" id="5N3gWgduaH0" role="3F10Kt" />
            <node concept="15ARfc" id="5N3gWgdvfFA" role="3F10Kt">
              <property role="3$6WeP" value="0" />
            </node>
            <node concept="2iRfu4" id="5N3gWgduaH3" role="2iSdaV" />
            <node concept="1iCGBv" id="5N3gWgduaIT" role="3EZMnx">
              <ref role="1NtTu8" to="y20r:5ZmGmhlJvWU" resolve="operandColumn" />
              <node concept="1sVBvm" id="5N3gWgduaIV" role="1sWHZn">
                <node concept="3F0A7n" id="5N3gWgduaJ7" role="2wV5jI">
                  <property role="1Intyy" value="true" />
                  <ref role="1NtTu8" to="tpck:h0TrG11" resolve="name" />
                </node>
              </node>
            </node>
          </node>
          <node concept="3F0ifn" id="5N3gWgduaHq" role="3EZMnx">
            <property role="3F0ifm" value="," />
          </node>
          <node concept="3EZMnI" id="5N3gWgduaHO" role="3EZMnx">
            <node concept="VPM3Z" id="5N3gWgduaHQ" role="3F10Kt" />
            <node concept="15ARfc" id="5N3gWgdvfFH" role="3F10Kt">
              <property role="3$6WeP" value="0" />
            </node>
            <node concept="2iRfu4" id="5N3gWgduaHT" role="2iSdaV" />
            <node concept="1iCGBv" id="5N3gWgduaJQ" role="3EZMnx">
              <ref role="1NtTu8" to="y20r:5ZmGmhlJvWY" resolve="lookupColumn" />
              <node concept="1sVBvm" id="5N3gWgduaJS" role="1sWHZn">
                <node concept="3F0A7n" id="5N3gWgduaK4" role="2wV5jI">
                  <property role="1Intyy" value="true" />
                  <ref role="1NtTu8" to="tpck:h0TrG11" resolve="name" />
                </node>
              </node>
            </node>
          </node>
          <node concept="3F0ifn" id="5N3gWgduaGP" role="3EZMnx">
            <property role="3F0ifm" value=")" />
          </node>
        </node>
        <node concept="3EZMnI" id="5N3gWgdxpNW" role="3EZMnx">
          <node concept="VPM3Z" id="5N3gWgdxpNY" role="3F10Kt" />
          <node concept="3XFhqQ" id="5N3gWgdxpPt" role="3EZMnx" />
          <node concept="2iRfu4" id="5N3gWgdxpO1" role="2iSdaV" />
          <node concept="3F0ifn" id="5N3gWgdxpPz" role="3EZMnx">
            <property role="3F0ifm" value="INTO" />
            <node concept="VechU" id="5N3gWgdJedZ" role="3F10Kt">
              <property role="Vb096" value="fLwANPt/cyan" />
            </node>
          </node>
          <node concept="3EZMnI" id="5N3gWgdxpPF" role="3EZMnx">
            <node concept="VPM3Z" id="5N3gWgdxpPH" role="3F10Kt" />
            <node concept="15ARfc" id="5N3gWgdxpQY" role="3F10Kt">
              <property role="3$6WeP" value="0" />
            </node>
            <node concept="1iCGBv" id="5N3gWgdxpPS" role="3EZMnx">
              <ref role="1NtTu8" to="y20r:5ZmGmhlJvXu" resolve="resultTable" />
              <node concept="1sVBvm" id="5N3gWgdxpPU" role="1sWHZn">
                <node concept="3F0A7n" id="5N3gWgdxpQ1" role="2wV5jI">
                  <property role="1Intyy" value="true" />
                  <ref role="1NtTu8" to="tpck:h0TrG11" resolve="name" />
                </node>
              </node>
              <node concept="VechU" id="5N3gWgdyxMs" role="3F10Kt">
                <property role="Vb096" value="fLwANPr/green" />
              </node>
            </node>
            <node concept="2iRfu4" id="5N3gWgdxpPK" role="2iSdaV" />
            <node concept="3F0ifn" id="5N3gWgdxpQ9" role="3EZMnx">
              <property role="3F0ifm" value="(" />
            </node>
            <node concept="1iCGBv" id="5N3gWgdxpQ$" role="3EZMnx">
              <ref role="1NtTu8" to="y20r:5ZmGmhlJvX4" resolve="resultColumn" />
              <node concept="1sVBvm" id="5N3gWgdxpQA" role="1sWHZn">
                <node concept="3F0A7n" id="5N3gWgdxpQM" role="2wV5jI">
                  <property role="1Intyy" value="true" />
                  <ref role="1NtTu8" to="tpck:h0TrG11" resolve="name" />
                </node>
              </node>
            </node>
            <node concept="3F0ifn" id="5N3gWgdxpQs" role="3EZMnx">
              <property role="3F0ifm" value=")" />
            </node>
          </node>
        </node>
        <node concept="3F0ifn" id="5N3gWgdtc28" role="3EZMnx" />
        <node concept="2iRkQZ" id="5N3gWgdreJB" role="2iSdaV" />
      </node>
    </node>
  </node>
  <node concept="24kQdi" id="5N3gWgd_Tcv">
    <ref role="1XX52x" to="y20r:3YATvlM33Va" resolve="Save" />
    <node concept="3EZMnI" id="5N3gWgd_Tcy" role="2wV5jI">
      <node concept="3XFhqQ" id="5N3gWgd_TcD" role="3EZMnx" />
      <node concept="2iRfu4" id="5N3gWgd_Tc_" role="2iSdaV" />
      <node concept="3EZMnI" id="5N3gWgd_TcJ" role="3EZMnx">
        <node concept="VPM3Z" id="5N3gWgd_TcL" role="3F10Kt" />
        <node concept="3EZMnI" id="5N3gWgd_TcU" role="3EZMnx">
          <node concept="VPM3Z" id="5N3gWgd_TcW" role="3F10Kt" />
          <node concept="3F0ifn" id="5N3gWgd_Td4" role="3EZMnx">
            <property role="3F0ifm" value="SAVE" />
            <node concept="VechU" id="5N3gWgd_Tej" role="3F10Kt">
              <property role="Vb096" value="fLwANPu/blue" />
            </node>
          </node>
          <node concept="2iRfu4" id="5N3gWgd_TcZ" role="2iSdaV" />
          <node concept="3EZMnI" id="5N3gWgd_Tda" role="3EZMnx">
            <node concept="VPM3Z" id="5N3gWgd_Tdc" role="3F10Kt" />
            <node concept="15ARfc" id="5N3gWgd_Tes" role="3F10Kt">
              <property role="3$6WeP" value="0" />
            </node>
            <node concept="3F0ifn" id="5N3gWgd_Tdl" role="3EZMnx">
              <property role="3F0ifm" value="&quot;" />
            </node>
            <node concept="2iRfu4" id="5N3gWgd_Tdf" role="2iSdaV" />
            <node concept="3F0A7n" id="5N3gWgd_Tdr" role="3EZMnx">
              <ref role="1NtTu8" to="tpck:h0TrG11" resolve="name" />
            </node>
            <node concept="3F0ifn" id="5N3gWgd_Tdz" role="3EZMnx">
              <property role="3F0ifm" value="&quot;:" />
            </node>
          </node>
        </node>
        <node concept="3EZMnI" id="5N3gWgd_TeJ" role="3EZMnx">
          <node concept="VPM3Z" id="5N3gWgd_TeL" role="3F10Kt" />
          <node concept="3XFhqQ" id="5N3gWgd_Tf5" role="3EZMnx" />
          <node concept="2iRfu4" id="5N3gWgd_TeO" role="2iSdaV" />
          <node concept="3F2HdR" id="5N3gWgd_Tfb" role="3EZMnx">
            <ref role="1NtTu8" to="y20r:3YATvlM33Vh" resolve="tablesToSave" />
            <node concept="2iRkQZ" id="5N3gWgd_Tfe" role="2czzBx" />
            <node concept="VPM3Z" id="5N3gWgd_Tff" role="3F10Kt" />
          </node>
        </node>
        <node concept="3F0ifn" id="5N3gWgdDmmb" role="3EZMnx" />
        <node concept="2iRkQZ" id="5N3gWgd_TcO" role="2iSdaV" />
      </node>
    </node>
  </node>
  <node concept="24kQdi" id="5N3gWgdCaYZ">
    <ref role="1XX52x" to="y20r:3YATvlM53uJ" resolve="TableToSave" />
    <node concept="3EZMnI" id="5N3gWgdCaZ2" role="2wV5jI">
      <node concept="2iRfu4" id="5N3gWgdCaZ5" role="2iSdaV" />
      <node concept="3EZMnI" id="5N3gWgdCaZx" role="3EZMnx">
        <node concept="VPM3Z" id="5N3gWgdCaZz" role="3F10Kt" />
        <node concept="15ARfc" id="5N3gWgdCb2O" role="3F10Kt">
          <property role="3$6WeP" value="0" />
        </node>
        <node concept="1iCGBv" id="5N3gWgdCaZG" role="3EZMnx">
          <ref role="1NtTu8" to="y20r:3YATvlM53uK" resolve="table" />
          <node concept="1sVBvm" id="5N3gWgdCaZI" role="1sWHZn">
            <node concept="3F0A7n" id="5N3gWgdCaZP" role="2wV5jI">
              <property role="1Intyy" value="true" />
              <ref role="1NtTu8" to="tpck:h0TrG11" resolve="name" />
              <node concept="VechU" id="5N3gWgdExsv" role="3F10Kt">
                <property role="Vb096" value="fLwANPr/green" />
              </node>
            </node>
          </node>
        </node>
        <node concept="2iRfu4" id="5N3gWgdCaZA" role="2iSdaV" />
        <node concept="3F0ifn" id="5N3gWgdCaZX" role="3EZMnx">
          <property role="3F0ifm" value="(" />
        </node>
        <node concept="3F2HdR" id="5N3gWgdCb0o" role="3EZMnx">
          <ref role="1NtTu8" to="y20r:3YATvlM53uM" resolve="columns" />
          <node concept="2iRfu4" id="5N3gWgdCb0r" role="2czzBx" />
          <node concept="VPM3Z" id="5N3gWgdCb0s" role="3F10Kt" />
        </node>
        <node concept="3F0ifn" id="5N3gWgdCb0g" role="3EZMnx">
          <property role="3F0ifm" value=")" />
        </node>
      </node>
      <node concept="3F0ifn" id="5N3gWgdCb0O" role="3EZMnx">
        <property role="3F0ifm" value="TO" />
      </node>
      <node concept="3EZMnI" id="5N3gWgdCb1Z" role="3EZMnx">
        <node concept="VPM3Z" id="5N3gWgdCb21" role="3F10Kt" />
        <node concept="15ARfc" id="5N3gWgdCb2H" role="3F10Kt">
          <property role="3$6WeP" value="0" />
        </node>
        <node concept="3F0ifn" id="5N3gWgdCb2m" role="3EZMnx">
          <property role="3F0ifm" value="&quot;" />
        </node>
        <node concept="2iRfu4" id="5N3gWgdCb24" role="2iSdaV" />
        <node concept="3F0A7n" id="5N3gWgdCb2_" role="3EZMnx">
          <ref role="1NtTu8" to="y20r:3YATvlM53uL" resolve="path" />
        </node>
        <node concept="3F0ifn" id="5N3gWgdCb2w" role="3EZMnx">
          <property role="3F0ifm" value="&quot;" />
        </node>
      </node>
    </node>
  </node>
  <node concept="24kQdi" id="5N3gWgdKpmw">
    <ref role="1XX52x" to="y20r:3YATvlM4ZjO" resolve="Sort" />
    <node concept="3EZMnI" id="5N3gWgdKpmy" role="2wV5jI">
      <node concept="3XFhqQ" id="5N3gWgdKpmD" role="3EZMnx" />
      <node concept="2iRfu4" id="5N3gWgdKpm_" role="2iSdaV" />
      <node concept="3EZMnI" id="5N3gWgdKpmJ" role="3EZMnx">
        <node concept="VPM3Z" id="5N3gWgdKpmL" role="3F10Kt" />
        <node concept="3EZMnI" id="5N3gWgdKpmU" role="3EZMnx">
          <node concept="VPM3Z" id="5N3gWgdKpmW" role="3F10Kt" />
          <node concept="3F0ifn" id="5N3gWgdKpn4" role="3EZMnx">
            <property role="3F0ifm" value="SORT" />
            <node concept="VechU" id="5N3gWgdKpoL" role="3F10Kt">
              <property role="Vb096" value="fLwANPu/blue" />
            </node>
          </node>
          <node concept="2iRfu4" id="5N3gWgdKpmZ" role="2iSdaV" />
          <node concept="3EZMnI" id="5N3gWgdKpna" role="3EZMnx">
            <node concept="VPM3Z" id="5N3gWgdKpnc" role="3F10Kt" />
            <node concept="15ARfc" id="5N3gWgdMW$D" role="3F10Kt">
              <property role="3$6WeP" value="0" />
            </node>
            <node concept="3F0ifn" id="5N3gWgdKpnl" role="3EZMnx">
              <property role="3F0ifm" value="&quot;" />
            </node>
            <node concept="2iRfu4" id="5N3gWgdKpnf" role="2iSdaV" />
            <node concept="3F0A7n" id="5N3gWgdKpn$" role="3EZMnx">
              <ref role="1NtTu8" to="tpck:h0TrG11" resolve="name" />
            </node>
            <node concept="3F0ifn" id="5N3gWgdKpnv" role="3EZMnx">
              <property role="3F0ifm" value="&quot; " />
            </node>
            <node concept="3F0ifn" id="5N3gWgdKpnV" role="3EZMnx">
              <property role="3F0ifm" value="-&gt;" />
              <node concept="VechU" id="5N3gWgdKpoJ" role="3F10Kt">
                <property role="Vb096" value="fLwANPu/blue" />
              </node>
            </node>
            <node concept="3F0ifn" id="5N3gWgdKpnO" role="3EZMnx">
              <property role="3F0ifm" value=" &quot;" />
            </node>
            <node concept="1iCGBv" id="5N3gWgdKpo9" role="3EZMnx">
              <ref role="1NtTu8" to="y20r:3YATvlM33C9" resolve="next" />
              <node concept="1sVBvm" id="5N3gWgdKpob" role="1sWHZn">
                <node concept="3F0A7n" id="5N3gWgdKpon" role="2wV5jI">
                  <property role="1Intyy" value="true" />
                  <ref role="1NtTu8" to="tpck:h0TrG11" resolve="name" />
                </node>
              </node>
            </node>
            <node concept="3F0ifn" id="5N3gWgdKpo$" role="3EZMnx">
              <property role="3F0ifm" value="&quot;:" />
            </node>
          </node>
        </node>
        <node concept="3EZMnI" id="5N3gWgdKpp7" role="3EZMnx">
          <node concept="VPM3Z" id="5N3gWgdKpp9" role="3F10Kt" />
          <node concept="3XFhqQ" id="5N3gWgdKppz" role="3EZMnx" />
          <node concept="2iRfu4" id="5N3gWgdKppc" role="2iSdaV" />
          <node concept="3F0ifn" id="5N3gWgdKppT" role="3EZMnx">
            <property role="3F0ifm" value="ON" />
          </node>
          <node concept="3EZMnI" id="5N3gWgdKpq1" role="3EZMnx">
            <node concept="VPM3Z" id="5N3gWgdKpq3" role="3F10Kt" />
            <node concept="15ARfc" id="5N3gWgdKprd" role="3F10Kt">
              <property role="3$6WeP" value="0" />
            </node>
            <node concept="1iCGBv" id="5N3gWgdKpqd" role="3EZMnx">
              <ref role="1NtTu8" to="y20r:3YATvlM4ZjP" resolve="table" />
              <node concept="1sVBvm" id="5N3gWgdKpqf" role="1sWHZn">
                <node concept="3F0A7n" id="5N3gWgdKpqm" role="2wV5jI">
                  <property role="1Intyy" value="true" />
                  <ref role="1NtTu8" to="tpck:h0TrG11" resolve="name" />
                  <node concept="VechU" id="5N3gWgdMW$H" role="3F10Kt">
                    <property role="Vb096" value="fLwANPr/green" />
                  </node>
                </node>
              </node>
            </node>
            <node concept="2iRfu4" id="5N3gWgdKpq6" role="2iSdaV" />
            <node concept="3F0ifn" id="5N3gWgdKpqu" role="3EZMnx">
              <property role="3F0ifm" value="(" />
            </node>
            <node concept="1iCGBv" id="5N3gWgdKpqT" role="3EZMnx">
              <ref role="1NtTu8" to="y20r:3YATvlM4ZjQ" resolve="column" />
              <node concept="1sVBvm" id="5N3gWgdKpqV" role="1sWHZn">
                <node concept="3F0A7n" id="5N3gWgdKpr7" role="2wV5jI">
                  <property role="1Intyy" value="true" />
                  <ref role="1NtTu8" to="tpck:h0TrG11" resolve="name" />
                </node>
              </node>
            </node>
            <node concept="3F0ifn" id="5N3gWgdKpqL" role="3EZMnx">
              <property role="3F0ifm" value=")" />
            </node>
          </node>
          <node concept="3F0ifn" id="5N3gWgdKprx" role="3EZMnx">
            <property role="3F0ifm" value="BY ORDER" />
          </node>
          <node concept="3F0A7n" id="5N3gWgdKps3" role="3EZMnx">
            <ref role="1NtTu8" to="y20r:3YATvlM4ZyP" resolve="order" />
            <node concept="Vb9p2" id="5N3gWgdKpsl" role="3F10Kt">
              <property role="Vbekb" value="g1_kEg4/ITALIC" />
            </node>
          </node>
        </node>
        <node concept="3F0ifn" id="5N3gWgdLFqz" role="3EZMnx" />
        <node concept="2iRkQZ" id="5N3gWgdKpmO" role="2iSdaV" />
      </node>
    </node>
  </node>
  <node concept="24kQdi" id="5N3gWgdOdW0">
    <ref role="1XX52x" to="y20r:35hB$8kwehL" resolve="StrManipulationConcat" />
    <node concept="3EZMnI" id="5N3gWgdOdW2" role="2wV5jI">
      <node concept="3XFhqQ" id="5N3gWgdOdWh" role="3EZMnx" />
      <node concept="2iRfu4" id="5N3gWgdOdW5" role="2iSdaV" />
      <node concept="3EZMnI" id="5N3gWgdOdWn" role="3EZMnx">
        <node concept="VPM3Z" id="5N3gWgdOdWp" role="3F10Kt" />
        <node concept="3EZMnI" id="5N3gWgdOdWy" role="3EZMnx">
          <node concept="VPM3Z" id="5N3gWgdOdW$" role="3F10Kt" />
          <node concept="3F0ifn" id="5N3gWgdOdWG" role="3EZMnx">
            <property role="3F0ifm" value="STR_CONCAT" />
            <node concept="VechU" id="5N3gWgdOdWX" role="3F10Kt">
              <property role="Vb096" value="fLwANPu/blue" />
            </node>
          </node>
          <node concept="2iRfu4" id="5N3gWgdOdWB" role="2iSdaV" />
          <node concept="3EZMnI" id="5N3gWgdOdWM" role="3EZMnx">
            <node concept="VPM3Z" id="5N3gWgdOdWO" role="3F10Kt" />
            <node concept="15ARfc" id="5N3gWgdPEI3" role="3F10Kt">
              <property role="3$6WeP" value="0" />
            </node>
            <node concept="3F0ifn" id="5N3gWgdOdWZ" role="3EZMnx">
              <property role="3F0ifm" value="&quot;" />
            </node>
            <node concept="2iRfu4" id="5N3gWgdOdWR" role="2iSdaV" />
            <node concept="3F0A7n" id="5N3gWgdOdX5" role="3EZMnx">
              <ref role="1NtTu8" to="tpck:h0TrG11" resolve="name" />
            </node>
            <node concept="3F0ifn" id="5N3gWgdOdXd" role="3EZMnx">
              <property role="3F0ifm" value="&quot; " />
            </node>
            <node concept="3F0ifn" id="5N3gWgdOdXn" role="3EZMnx">
              <property role="3F0ifm" value="-&gt;" />
              <node concept="VechU" id="5N3gWgdOe5m" role="3F10Kt">
                <property role="Vb096" value="fLwANPu/blue" />
              </node>
            </node>
            <node concept="3F0ifn" id="5N3gWgdOdXz" role="3EZMnx">
              <property role="3F0ifm" value=" &quot;" />
            </node>
            <node concept="1iCGBv" id="5N3gWgdOdXL" role="3EZMnx">
              <ref role="1NtTu8" to="y20r:3YATvlM33C9" resolve="next" />
              <node concept="1sVBvm" id="5N3gWgdOdXN" role="1sWHZn">
                <node concept="3F0A7n" id="5N3gWgdOdXZ" role="2wV5jI">
                  <property role="1Intyy" value="true" />
                  <ref role="1NtTu8" to="tpck:h0TrG11" resolve="name" />
                </node>
              </node>
            </node>
            <node concept="3F0ifn" id="5N3gWgdOdYc" role="3EZMnx">
              <property role="3F0ifm" value="&quot;:" />
            </node>
          </node>
        </node>
        <node concept="3EZMnI" id="5N3gWgdOdYE" role="3EZMnx">
          <node concept="VPM3Z" id="5N3gWgdOdYG" role="3F10Kt" />
          <node concept="3XFhqQ" id="5N3gWgdOdZ5" role="3EZMnx" />
          <node concept="2iRfu4" id="5N3gWgdOdYJ" role="2iSdaV" />
          <node concept="3F0ifn" id="5N3gWgdOdZb" role="3EZMnx">
            <property role="3F0ifm" value="ON" />
          </node>
          <node concept="3EZMnI" id="5N3gWgdOdZj" role="3EZMnx">
            <node concept="VPM3Z" id="5N3gWgdOdZl" role="3F10Kt" />
            <node concept="15ARfc" id="5N3gWgdOe0C" role="3F10Kt">
              <property role="3$6WeP" value="0" />
            </node>
            <node concept="1iCGBv" id="5N3gWgdOdZv" role="3EZMnx">
              <ref role="1NtTu8" to="y20r:5ZmGmhljubo" resolve="table" />
              <node concept="1sVBvm" id="5N3gWgdOdZx" role="1sWHZn">
                <node concept="3F0A7n" id="5N3gWgdOdZC" role="2wV5jI">
                  <property role="1Intyy" value="true" />
                  <ref role="1NtTu8" to="tpck:h0TrG11" resolve="name" />
                  <node concept="VechU" id="5N3gWgdOdZF" role="3F10Kt">
                    <property role="Vb096" value="fLwANPr/green" />
                  </node>
                </node>
              </node>
            </node>
            <node concept="2iRfu4" id="5N3gWgdOdZo" role="2iSdaV" />
            <node concept="3F0ifn" id="5N3gWgdOdZO" role="3EZMnx">
              <property role="3F0ifm" value="(" />
            </node>
            <node concept="1iCGBv" id="5N3gWgdOe0j" role="3EZMnx">
              <ref role="1NtTu8" to="y20r:35hB$8kwehQ" resolve="sourceA" />
              <node concept="1sVBvm" id="5N3gWgdOe0l" role="1sWHZn">
                <node concept="3F0A7n" id="5N3gWgdOe0y" role="2wV5jI">
                  <property role="1Intyy" value="true" />
                  <ref role="1NtTu8" to="tpck:h0TrG11" resolve="name" />
                </node>
              </node>
            </node>
            <node concept="3F0ifn" id="5N3gWgdSwMa" role="3EZMnx">
              <property role="3F0ifm" value=", " />
            </node>
            <node concept="1iCGBv" id="5N3gWgdSwMy" role="3EZMnx">
              <ref role="1NtTu8" to="y20r:35hB$8kwehT" resolve="sourceB" />
              <node concept="1sVBvm" id="5N3gWgdSwMz" role="1sWHZn">
                <node concept="3F0A7n" id="5N3gWgdSwM$" role="2wV5jI">
                  <property role="1Intyy" value="true" />
                  <ref role="1NtTu8" to="tpck:h0TrG11" resolve="name" />
                </node>
              </node>
            </node>
            <node concept="3F0ifn" id="5N3gWgdOe0a" role="3EZMnx">
              <property role="3F0ifm" value=")" />
            </node>
          </node>
        </node>
        <node concept="3EZMnI" id="5N3gWgdOe3M" role="3EZMnx">
          <node concept="VPM3Z" id="5N3gWgdOe3O" role="3F10Kt" />
          <node concept="3XFhqQ" id="5N3gWgdOe4I" role="3EZMnx" />
          <node concept="3F0ifn" id="5N3gWgdOe4O" role="3EZMnx">
            <property role="3F0ifm" value="INTO" />
            <node concept="VechU" id="5N3gWgdOe5k" role="3F10Kt">
              <property role="Vb096" value="fLwANPt/cyan" />
            </node>
          </node>
          <node concept="3EZMnI" id="5N3gWgdOe4S" role="3EZMnx">
            <node concept="VPM3Z" id="5N3gWgdOe4T" role="3F10Kt" />
            <node concept="15ARfc" id="5N3gWgdOe4U" role="3F10Kt">
              <property role="3$6WeP" value="0" />
            </node>
            <node concept="1iCGBv" id="5N3gWgdOe4V" role="3EZMnx">
              <ref role="1NtTu8" to="y20r:35hB$8kwehV" resolve="resultTable" />
              <node concept="1sVBvm" id="5N3gWgdOe4W" role="1sWHZn">
                <node concept="3F0A7n" id="5N3gWgdOe4X" role="2wV5jI">
                  <property role="1Intyy" value="true" />
                  <ref role="1NtTu8" to="tpck:h0TrG11" resolve="name" />
                  <node concept="VechU" id="5N3gWgdOe4Y" role="3F10Kt">
                    <property role="Vb096" value="fLwANPr/green" />
                  </node>
                </node>
              </node>
            </node>
            <node concept="2iRfu4" id="5N3gWgdOe4Z" role="2iSdaV" />
            <node concept="3F0ifn" id="5N3gWgdOe50" role="3EZMnx">
              <property role="3F0ifm" value="(" />
            </node>
            <node concept="1iCGBv" id="5N3gWgdOe51" role="3EZMnx">
              <ref role="1NtTu8" to="y20r:35hB$8kwehY" resolve="resultColumn" />
              <node concept="1sVBvm" id="5N3gWgdOe52" role="1sWHZn">
                <node concept="3F0A7n" id="5N3gWgdOe53" role="2wV5jI">
                  <property role="1Intyy" value="true" />
                  <ref role="1NtTu8" to="tpck:h0TrG11" resolve="name" />
                </node>
              </node>
            </node>
            <node concept="3F0ifn" id="5N3gWgdOe54" role="3EZMnx">
              <property role="3F0ifm" value=")" />
            </node>
          </node>
          <node concept="2iRfu4" id="5N3gWgdOe3R" role="2iSdaV" />
        </node>
        <node concept="3F0ifn" id="5N3gWgdOe2Y" role="3EZMnx" />
        <node concept="2iRkQZ" id="5N3gWgdOdWs" role="2iSdaV" />
      </node>
    </node>
  </node>
  <node concept="24kQdi" id="5N3gWgd5XAW">
    <ref role="1XX52x" to="y20r:5ZmGmhllUK0" resolve="Join" />
    <node concept="3EZMnI" id="5N3gWgd5XAY" role="2wV5jI">
      <node concept="3XFhqQ" id="5N3gWgd5XB5" role="3EZMnx" />
      <node concept="3EZMnI" id="5N3gWgd5XB7" role="3EZMnx">
        <node concept="VPM3Z" id="5N3gWgd5XB9" role="3F10Kt" />
        <node concept="3EZMnI" id="5N3gWgd5XBg" role="3EZMnx">
          <node concept="VPM3Z" id="5N3gWgd5XBi" role="3F10Kt" />
          <node concept="3F0ifn" id="5N3gWgd5XBo" role="3EZMnx">
            <property role="3F0ifm" value="JOIN" />
            <node concept="VechU" id="5N3gWgd5XBY" role="3F10Kt">
              <property role="Vb096" value="fLwANPu/blue" />
            </node>
          </node>
          <node concept="3F0A7n" id="5N3gWgd92ui" role="3EZMnx">
            <ref role="1NtTu8" to="y20r:5ZmGmhllWUh" resolve="type" />
            <node concept="Vb9p2" id="5N3gWgd92uk" role="3F10Kt">
              <property role="Vbekb" value="g1_kEg4/ITALIC" />
            </node>
          </node>
          <node concept="3EZMnI" id="5N3gWgd5XBr" role="3EZMnx">
            <node concept="VPM3Z" id="5N3gWgd5XBt" role="3F10Kt" />
            <node concept="15ARfc" id="5N3gWgd5XBW" role="3F10Kt">
              <property role="3$6WeP" value="0" />
            </node>
            <node concept="3F0ifn" id="5N3gWgd5XBx" role="3EZMnx">
              <property role="3F0ifm" value="&quot;" />
            </node>
            <node concept="2iRfu4" id="5N3gWgd5XBw" role="2iSdaV" />
            <node concept="3F0A7n" id="5N3gWgd5XB$" role="3EZMnx">
              <ref role="1NtTu8" to="tpck:h0TrG11" resolve="name" />
            </node>
            <node concept="3F0ifn" id="5N3gWgd5XBB" role="3EZMnx">
              <property role="3F0ifm" value="&quot; " />
            </node>
            <node concept="3F0ifn" id="5N3gWgd5XBE" role="3EZMnx">
              <property role="3F0ifm" value="-&gt;" />
              <node concept="VechU" id="5N3gWgd5XBZ" role="3F10Kt">
                <property role="Vb096" value="fLwANPu/blue" />
              </node>
            </node>
            <node concept="3F0ifn" id="5N3gWgd5XBH" role="3EZMnx">
              <property role="3F0ifm" value=" &quot;" />
            </node>
            <node concept="1iCGBv" id="5N3gWgd5XBK" role="3EZMnx">
              <ref role="1NtTu8" to="y20r:3YATvlM33C9" resolve="next" />
              <node concept="1sVBvm" id="5N3gWgd5XBM" role="1sWHZn">
                <node concept="3F0A7n" id="5N3gWgd5XBQ" role="2wV5jI">
                  <property role="1Intyy" value="true" />
                  <ref role="1NtTu8" to="tpck:h0TrG11" resolve="name" />
                </node>
              </node>
            </node>
            <node concept="3F0ifn" id="5N3gWgd5XBT" role="3EZMnx">
              <property role="3F0ifm" value="&quot;:" />
            </node>
          </node>
          <node concept="2iRfu4" id="5N3gWgd5XBl" role="2iSdaV" />
        </node>
        <node concept="3EZMnI" id="5N3gWgd5XC1" role="3EZMnx">
          <node concept="VPM3Z" id="5N3gWgd5XC3" role="3F10Kt" />
          <node concept="3XFhqQ" id="5N3gWgd5XC7" role="3EZMnx" />
          <node concept="3F0ifn" id="5N3gWgd5XCa" role="3EZMnx">
            <property role="3F0ifm" value="ON" />
          </node>
          <node concept="2iRfu4" id="5N3gWgd5XC6" role="2iSdaV" />
          <node concept="3EZMnI" id="5N3gWgd5XCd" role="3EZMnx">
            <node concept="VPM3Z" id="5N3gWgd5XCf" role="3F10Kt" />
            <node concept="15ARfc" id="5N3gWgd5XCF" role="3F10Kt">
              <property role="3$6WeP" value="0" />
            </node>
            <node concept="1iCGBv" id="5N3gWgd5XCj" role="3EZMnx">
              <ref role="1NtTu8" to="y20r:5ZmGmhllUK1" resolve="leftTable" />
              <node concept="1sVBvm" id="5N3gWgd5XCl" role="1sWHZn">
                <node concept="3F0A7n" id="5N3gWgd5XCp" role="2wV5jI">
                  <property role="1Intyy" value="true" />
                  <ref role="1NtTu8" to="tpck:h0TrG11" resolve="name" />
                  <node concept="VechU" id="5N3gWgd79RG" role="3F10Kt">
                    <property role="Vb096" value="fLwANPr/green" />
                  </node>
                </node>
              </node>
            </node>
            <node concept="2iRfu4" id="5N3gWgd5XCi" role="2iSdaV" />
            <node concept="3F0ifn" id="5N3gWgd5XCs" role="3EZMnx">
              <property role="3F0ifm" value="(" />
            </node>
            <node concept="1iCGBv" id="5N3gWgd5XCy" role="3EZMnx">
              <ref role="1NtTu8" to="y20r:5ZmGmhllUK5" resolve="leftColumn" />
              <node concept="1sVBvm" id="5N3gWgd5XC$" role="1sWHZn">
                <node concept="3F0A7n" id="5N3gWgd5XCC" role="2wV5jI">
                  <property role="1Intyy" value="true" />
                  <ref role="1NtTu8" to="tpck:h0TrG11" resolve="name" />
                </node>
              </node>
            </node>
            <node concept="3F0ifn" id="5N3gWgd5XCw" role="3EZMnx">
              <property role="3F0ifm" value=")" />
            </node>
          </node>
          <node concept="3F0ifn" id="5N3gWgd7Mgd" role="3EZMnx">
            <property role="3F0ifm" value="WITH" />
          </node>
          <node concept="3EZMnI" id="5N3gWgd7Mgg" role="3EZMnx">
            <node concept="VPM3Z" id="5N3gWgd7Mgi" role="3F10Kt" />
            <node concept="15ARfc" id="5N3gWgd7Mgn" role="3F10Kt">
              <property role="3$6WeP" value="0" />
            </node>
            <node concept="1iCGBv" id="5N3gWgd7Mgp" role="3EZMnx">
              <ref role="1NtTu8" to="y20r:5ZmGmhllUKa" resolve="rightTable" />
              <node concept="1sVBvm" id="5N3gWgd7Mgr" role="1sWHZn">
                <node concept="3F0A7n" id="5N3gWgd7Mgv" role="2wV5jI">
                  <property role="1Intyy" value="true" />
                  <ref role="1NtTu8" to="tpck:h0TrG11" resolve="name" />
                  <node concept="VechU" id="5N3gWgd8qud" role="3F10Kt">
                    <property role="Vb096" value="fLwANPr/green" />
                  </node>
                </node>
              </node>
            </node>
            <node concept="2iRfu4" id="5N3gWgd7Mgl" role="2iSdaV" />
            <node concept="3F0ifn" id="5N3gWgd7Mgy" role="3EZMnx">
              <property role="3F0ifm" value="(" />
            </node>
            <node concept="1iCGBv" id="5N3gWgd7MgC" role="3EZMnx">
              <ref role="1NtTu8" to="y20r:5ZmGmhllUK8" resolve="rightColumn" />
              <node concept="1sVBvm" id="5N3gWgd7MgE" role="1sWHZn">
                <node concept="3F0A7n" id="5N3gWgd7MgI" role="2wV5jI">
                  <property role="1Intyy" value="true" />
                  <ref role="1NtTu8" to="tpck:h0TrG11" resolve="name" />
                </node>
              </node>
            </node>
            <node concept="3F0ifn" id="5N3gWgd7MgA" role="3EZMnx">
              <property role="3F0ifm" value=")" />
            </node>
          </node>
        </node>
        <node concept="3EZMnI" id="5N3gWgdf75x" role="3EZMnx">
          <node concept="VPM3Z" id="5N3gWgdf75z" role="3F10Kt" />
          <node concept="3XFhqQ" id="5N3gWgdf75B" role="3EZMnx" />
          <node concept="3F0ifn" id="5N3gWgdf75E" role="3EZMnx">
            <property role="3F0ifm" value="SELECTING" />
          </node>
          <node concept="2iRfu4" id="5N3gWgdf75A" role="2iSdaV" />
          <node concept="3EZMnI" id="5N3gWgdf75H" role="3EZMnx">
            <node concept="VPM3Z" id="5N3gWgdf75J" role="3F10Kt" />
            <node concept="3F2HdR" id="5N3gWgdf75O" role="3EZMnx">
              <ref role="1NtTu8" to="y20r:5ZmGmhlm_2E" resolve="selectColumns" />
              <node concept="2iRfu4" id="5N3gWgdf75Q" role="2czzBx" />
            </node>
            <node concept="2iRfu4" id="5N3gWgdf75M" role="2iSdaV" />
          </node>
        </node>
        <node concept="3EZMnI" id="5N3gWgdfMOQ" role="3EZMnx">
          <node concept="VPM3Z" id="5N3gWgdfMOS" role="3F10Kt" />
          <node concept="3XFhqQ" id="5N3gWgdfMOW" role="3EZMnx" />
          <node concept="3F0ifn" id="5N3gWgd9Fd6" role="3EZMnx">
            <property role="3F0ifm" value="INTO" />
            <node concept="VechU" id="5N3gWgd9Fd8" role="3F10Kt">
              <property role="Vb096" value="fLwANPt/cyan" />
            </node>
          </node>
          <node concept="1iCGBv" id="5N3gWgdanfT" role="3EZMnx">
            <ref role="1NtTu8" to="y20r:5ZmGmhlm$9P" resolve="resultTable" />
            <node concept="1sVBvm" id="5N3gWgdanfV" role="1sWHZn">
              <node concept="3F0A7n" id="5N3gWgdanfZ" role="2wV5jI">
                <property role="1Intyy" value="true" />
                <ref role="1NtTu8" to="tpck:h0TrG11" resolve="name" />
                <node concept="VechU" id="5N3gWgdang1" role="3F10Kt">
                  <property role="Vb096" value="fLwANPr/green" />
                </node>
              </node>
            </node>
          </node>
          <node concept="2iRfu4" id="5N3gWgdfMOV" role="2iSdaV" />
        </node>
        <node concept="3F0ifn" id="5N3gWgdhS4D" role="3EZMnx" />
        <node concept="2iRkQZ" id="5N3gWgd5XBc" role="2iSdaV" />
      </node>
      <node concept="2iRfu4" id="5N3gWgd5XB1" role="2iSdaV" />
    </node>
  </node>
  <node concept="24kQdi" id="7I27HmZFXok">
    <ref role="1XX52x" to="y20r:5ZmGmhlCEN7" resolve="Group" />
    <node concept="3EZMnI" id="7I27HmZFXoq" role="2wV5jI">
      <node concept="3XFhqQ" id="7I27HmZFXou" role="3EZMnx" />
      <node concept="2iRfu4" id="7I27HmZFXot" role="2iSdaV" />
      <node concept="3EZMnI" id="7I27HmZFXox" role="3EZMnx">
        <node concept="VPM3Z" id="7I27HmZFXoz" role="3F10Kt" />
        <node concept="3EZMnI" id="7I27HmZFXoC" role="3EZMnx">
          <node concept="VPM3Z" id="7I27HmZFXoE" role="3F10Kt" />
          <node concept="3F0ifn" id="7I27HmZFXoI" role="3EZMnx">
            <property role="3F0ifm" value="GROUP_BY" />
            <node concept="VechU" id="7I27HmZFXoL" role="3F10Kt">
              <property role="Vb096" value="fLwANPu/blue" />
            </node>
          </node>
          <node concept="2iRfu4" id="7I27HmZFXoH" role="2iSdaV" />
          <node concept="3EZMnI" id="7I27HmZFXoN" role="3EZMnx">
            <node concept="VPM3Z" id="7I27HmZFXoP" role="3F10Kt" />
            <node concept="15ARfc" id="7I27HmZGOvJ" role="3F10Kt">
              <property role="3$6WeP" value="0" />
            </node>
            <node concept="3F0ifn" id="7I27HmZFXoT" role="3EZMnx">
              <property role="3F0ifm" value="&quot;" />
            </node>
            <node concept="2iRfu4" id="7I27HmZFXoS" role="2iSdaV" />
            <node concept="3F0A7n" id="7I27HmZFXoW" role="3EZMnx">
              <ref role="1NtTu8" to="tpck:h0TrG11" resolve="name" />
            </node>
            <node concept="3F0ifn" id="7I27HmZFXoZ" role="3EZMnx">
              <property role="3F0ifm" value="&quot; " />
            </node>
            <node concept="3F0ifn" id="7I27HmZFXp2" role="3EZMnx">
              <property role="3F0ifm" value="-&gt;" />
              <node concept="VechU" id="7I27HmZFXp7" role="3F10Kt">
                <property role="Vb096" value="fLwANPu/blue" />
              </node>
            </node>
            <node concept="3F0ifn" id="7I27HmZFXp5" role="3EZMnx">
              <property role="3F0ifm" value=" &quot;" />
            </node>
            <node concept="1iCGBv" id="7I27HmZFXp9" role="3EZMnx">
              <ref role="1NtTu8" to="y20r:3YATvlM33C9" resolve="next" />
              <node concept="1sVBvm" id="7I27HmZFXpb" role="1sWHZn">
                <node concept="3F0A7n" id="7I27HmZFXpf" role="2wV5jI">
                  <property role="1Intyy" value="true" />
                  <ref role="1NtTu8" to="tpck:h0TrG11" resolve="name" />
                </node>
              </node>
            </node>
            <node concept="3F0ifn" id="7I27HmZFXpi" role="3EZMnx">
              <property role="3F0ifm" value="&quot;:" />
            </node>
          </node>
        </node>
        <node concept="3EZMnI" id="7I27HmZFXpl" role="3EZMnx">
          <node concept="VPM3Z" id="7I27HmZFXpn" role="3F10Kt" />
          <node concept="3XFhqQ" id="7I27HmZFXpr" role="3EZMnx" />
          <node concept="2iRfu4" id="7I27HmZFXpq" role="2iSdaV" />
          <node concept="3F0ifn" id="7I27HmZFXpu" role="3EZMnx">
            <property role="3F0ifm" value="ON" />
          </node>
          <node concept="3EZMnI" id="7I27HmZFXpx" role="3EZMnx">
            <node concept="VPM3Z" id="7I27HmZFXpz" role="3F10Kt" />
            <node concept="15ARfc" id="7I27HmZIAH7" role="3F10Kt">
              <property role="3$6WeP" value="0" />
            </node>
            <node concept="1iCGBv" id="7I27HmZFXpB" role="3EZMnx">
              <ref role="1NtTu8" to="y20r:5ZmGmhlCENb" resolve="table" />
              <node concept="1sVBvm" id="7I27HmZFXpD" role="1sWHZn">
                <node concept="3F0A7n" id="7I27HmZFXpH" role="2wV5jI">
                  <property role="1Intyy" value="true" />
                  <ref role="1NtTu8" to="tpck:h0TrG11" resolve="name" />
                  <node concept="VechU" id="7I27HmZO34J" role="3F10Kt">
                    <property role="Vb096" value="fLwANPr/green" />
                  </node>
                </node>
              </node>
            </node>
            <node concept="2iRfu4" id="7I27HmZFXpA" role="2iSdaV" />
            <node concept="3F0ifn" id="7I27HmZFXpM" role="3EZMnx">
              <property role="3F0ifm" value="(" />
            </node>
            <node concept="3F2HdR" id="7I27HmZFXpS" role="3EZMnx">
              <ref role="1NtTu8" to="y20r:5ZmGmhlCENf" resolve="groupBy" />
              <node concept="2iRfu4" id="7I27HmZFXpU" role="2czzBx" />
            </node>
            <node concept="3F0ifn" id="7I27HmZFXpQ" role="3EZMnx">
              <property role="3F0ifm" value=")" />
            </node>
          </node>
          <node concept="3F0ifn" id="7I27HmZHFp1" role="3EZMnx">
            <property role="3F0ifm" value="AND" />
          </node>
          <node concept="3F0A7n" id="7I27HmZHFp5" role="3EZMnx">
            <ref role="1NtTu8" to="y20r:5ZmGmhlDFNm" resolve="operation" />
            <node concept="Vb9p2" id="7I27HmZI99U" role="3F10Kt">
              <property role="Vbekb" value="g1_kEg4/ITALIC" />
            </node>
          </node>
          <node concept="1iCGBv" id="7I27HmZHFp8" role="3EZMnx">
            <ref role="1NtTu8" to="y20r:5ZmGmhlCENj" resolve="operandColumn" />
            <node concept="1sVBvm" id="7I27HmZHFpa" role="1sWHZn">
              <node concept="3F0A7n" id="7I27HmZHFpe" role="2wV5jI">
                <property role="1Intyy" value="true" />
                <ref role="1NtTu8" to="tpck:h0TrG11" resolve="name" />
              </node>
            </node>
          </node>
        </node>
        <node concept="3EZMnI" id="5N3gWgdGS72" role="3EZMnx">
          <node concept="3XFhqQ" id="5N3gWgdI3p8" role="3EZMnx" />
          <node concept="VPM3Z" id="5N3gWgdGS74" role="3F10Kt" />
          <node concept="3F0ifn" id="5N3gWgdcnXQ" role="3EZMnx">
            <property role="3F0ifm" value="INTO" />
            <node concept="VechU" id="5N3gWgdcnXZ" role="3F10Kt">
              <property role="Vb096" value="fLwANPt/cyan" />
            </node>
          </node>
          <node concept="3EZMnI" id="5N3gWgdqoVT" role="3EZMnx">
            <node concept="VPM3Z" id="5N3gWgdqoVV" role="3F10Kt" />
            <node concept="15ARfc" id="5N3gWgdqoXq" role="3F10Kt">
              <property role="3$6WeP" value="0" />
            </node>
            <node concept="1iCGBv" id="5N3gWgdcnXT" role="3EZMnx">
              <ref role="1NtTu8" to="y20r:5ZmGmhlDFNB" resolve="resultTable" />
              <node concept="1sVBvm" id="5N3gWgdcnXV" role="1sWHZn">
                <node concept="3F0A7n" id="5N3gWgdcnY0" role="2wV5jI">
                  <property role="1Intyy" value="true" />
                  <ref role="1NtTu8" to="tpck:h0TrG11" resolve="name" />
                  <node concept="VechU" id="5N3gWgdd3$E" role="3F10Kt">
                    <property role="Vb096" value="fLwANPr/green" />
                  </node>
                </node>
              </node>
            </node>
            <node concept="2iRfu4" id="5N3gWgdqoVY" role="2iSdaV" />
            <node concept="3F0ifn" id="5N3gWgdqoWz" role="3EZMnx">
              <property role="3F0ifm" value="(" />
            </node>
            <node concept="1iCGBv" id="5N3gWgdqoWL" role="3EZMnx">
              <ref role="1NtTu8" to="y20r:5ZmGmhlDFNE" resolve="resultColumn" />
              <node concept="1sVBvm" id="5N3gWgdqoWN" role="1sWHZn">
                <node concept="3F0A7n" id="5N3gWgdqoWZ" role="2wV5jI">
                  <property role="1Intyy" value="true" />
                  <ref role="1NtTu8" to="tpck:h0TrG11" resolve="name" />
                </node>
              </node>
            </node>
            <node concept="3F0ifn" id="5N3gWgdqoXc" role="3EZMnx">
              <property role="3F0ifm" value=")" />
            </node>
          </node>
          <node concept="2iRfu4" id="5N3gWgdGS77" role="2iSdaV" />
        </node>
        <node concept="3F0ifn" id="5N3gWgdGS4b" role="3EZMnx" />
        <node concept="2iRkQZ" id="7I27HmZFXoA" role="2iSdaV" />
      </node>
    </node>
  </node>
</model>

