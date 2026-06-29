<?xml version="1.0" encoding="UTF-8"?>
<model ref="r:e14ba563-14ee-40db-8a16-c94c24398270(ltsdsl.generator.steps@generator)">
  <persistence version="9" />
  <languages>
    <devkit ref="a2eb3a43-fcc2-4200-80dc-c60110c4862d(jetbrains.mps.devkit.templates)" />
  </languages>
  <imports>
    <import index="y20r" ref="r:85f52e46-7a19-44f9-bf10-6677b89edd73(ltsdsl.structure)" />
    <import index="jgvc" ref="r:a259c1a4-fe07-4459-93a8-28b00a8a5e65(ltsdsl.generator.steps.join@generator)" />
    <import index="q1tm" ref="r:e2661cc8-007f-44b8-a96a-97c94b2ca103(ltsdsl.generator.steps.groupBy@generator)" />
    <import index="4dg1" ref="r:efcec103-84b2-480a-91c5-bcd3ff0ec3cb(ltsdsl.generator.steps.filter@generator)" />
    <import index="ftb5" ref="r:2f592e62-97d5-41e6-a11a-2a2c1fb0da89(ltsdsl.generator.steps.lookup@generator)" />
    <import index="zehy" ref="r:c01f992f-0133-4abe-af7a-193bd687a68c(ltsdsl.generator.steps.sort@generator)" />
    <import index="6ft3" ref="r:2c93a31c-d6e8-4726-a0df-dcd42a2f4169(ltsdsl.generator.steps.save@generator)" />
    <import index="veih" ref="r:a36eddf6-717d-4a20-ae38-593280be96dd(ltsdsl.generator.steps.strConcat@generator)" />
    <import index="lw5u" ref="r:e233f196-0e07-4645-a64b-ebf9ce935438(ltsdsl.generator.steps.appendRows@generator)" />
    <import index="9y3" ref="r:f71ff201-c99b-4c1b-a27f-dc567abef317(ltsdsl.generator.steps.import_@generator)" />
    <import index="59zy" ref="r:3520cf5b-cc77-4a2e-a334-4aefc1e39a44(ltsdsl.generator.steps.removeDuplicates@generator)" />
  </imports>
  <registry>
    <language id="b401a680-8325-4110-8fd3-84331ff25bef" name="jetbrains.mps.lang.generator">
      <concept id="1095416546421" name="jetbrains.mps.lang.generator.structure.MappingConfiguration" flags="ig" index="bUwia" />
    </language>
    <language id="ceab5195-25ea-4f22-9b92-103b95ca8c0c" name="jetbrains.mps.lang.core">
      <concept id="1169194658468" name="jetbrains.mps.lang.core.structure.INamedConcept" flags="ngI" index="TrEIO">
        <property id="1169194664001" name="name" index="TrG5h" />
      </concept>
    </language>
  </registry>
  <node concept="bUwia" id="cd93YdZiQo">
    <property role="TrG5h" value="main" />
  </node>
</model>

