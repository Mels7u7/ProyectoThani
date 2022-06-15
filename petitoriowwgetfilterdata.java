package com.projectthani ;
import com.projectthani.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class petitoriowwgetfilterdata extends GXProcedure
{
   public petitoriowwgetfilterdata( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( petitoriowwgetfilterdata.class ), "" );
   }

   public petitoriowwgetfilterdata( int remoteHandle ,
                                    ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public String executeUdp( String aP0 ,
                             String aP1 ,
                             String aP2 ,
                             String[] aP3 ,
                             String[] aP4 )
   {
      petitoriowwgetfilterdata.this.aP5 = new String[] {""};
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5);
      return aP5[0];
   }

   public void execute( String aP0 ,
                        String aP1 ,
                        String aP2 ,
                        String[] aP3 ,
                        String[] aP4 ,
                        String[] aP5 )
   {
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5);
   }

   private void execute_int( String aP0 ,
                             String aP1 ,
                             String aP2 ,
                             String[] aP3 ,
                             String[] aP4 ,
                             String[] aP5 )
   {
      petitoriowwgetfilterdata.this.AV33DDOName = aP0;
      petitoriowwgetfilterdata.this.AV31SearchTxt = aP1;
      petitoriowwgetfilterdata.this.AV32SearchTxtTo = aP2;
      petitoriowwgetfilterdata.this.aP3 = aP3;
      petitoriowwgetfilterdata.this.aP4 = aP4;
      petitoriowwgetfilterdata.this.aP5 = aP5;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      AV36Options = new GXSimpleCollection<String>(String.class, "internal", "") ;
      AV39OptionsDesc = new GXSimpleCollection<String>(String.class, "internal", "") ;
      AV41OptionIndexes = new GXSimpleCollection<String>(String.class, "internal", "") ;
      GXt_boolean1 = AV8IsAuthorized ;
      GXv_boolean2[0] = GXt_boolean1 ;
      new com.projectthani.wwpbaseobjects.secisauthbyfunctionalitykey(remoteHandle, context).execute( "WWPetitorio", GXv_boolean2) ;
      petitoriowwgetfilterdata.this.GXt_boolean1 = GXv_boolean2[0] ;
      AV8IsAuthorized = GXt_boolean1 ;
      if ( AV8IsAuthorized )
      {
         GXv_SdtWWPContext3[0] = AV9WWPContext;
         new com.projectthani.wwpbaseobjects.loadwwpcontext(remoteHandle, context).execute( GXv_SdtWWPContext3) ;
         AV9WWPContext = GXv_SdtWWPContext3[0] ;
         /* Execute user subroutine: 'LOADGRIDSTATE' */
         S111 ();
         if ( returnInSub )
         {
            returnInSub = true;
            cleanup();
            if (true) return;
         }
         if ( GXutil.strcmp(GXutil.upper( AV33DDOName), "DDO_PETITORIOPRINCIPIOACTIVO") == 0 )
         {
            /* Execute user subroutine: 'LOADPETITORIOPRINCIPIOACTIVOOPTIONS' */
            S121 ();
            if ( returnInSub )
            {
               returnInSub = true;
               cleanup();
               if (true) return;
            }
         }
         else if ( GXutil.strcmp(GXutil.upper( AV33DDOName), "DDO_PETITORIOPRODUCTO") == 0 )
         {
            /* Execute user subroutine: 'LOADPETITORIOPRODUCTOOPTIONS' */
            S131 ();
            if ( returnInSub )
            {
               returnInSub = true;
               cleanup();
               if (true) return;
            }
         }
         else if ( GXutil.strcmp(GXutil.upper( AV33DDOName), "DDO_PETITORIOCONCENTRACION") == 0 )
         {
            /* Execute user subroutine: 'LOADPETITORIOCONCENTRACIONOPTIONS' */
            S141 ();
            if ( returnInSub )
            {
               returnInSub = true;
               cleanup();
               if (true) return;
            }
         }
         else if ( GXutil.strcmp(GXutil.upper( AV33DDOName), "DDO_PETITORIOPRESENTACION") == 0 )
         {
            /* Execute user subroutine: 'LOADPETITORIOPRESENTACIONOPTIONS' */
            S151 ();
            if ( returnInSub )
            {
               returnInSub = true;
               cleanup();
               if (true) return;
            }
         }
      }
      AV37OptionsJson = AV36Options.toJSonString(false) ;
      AV40OptionsDescJson = AV39OptionsDesc.toJSonString(false) ;
      AV42OptionIndexesJson = AV41OptionIndexes.toJSonString(false) ;
      cleanup();
   }

   public void S111( )
   {
      /* 'LOADGRIDSTATE' Routine */
      returnInSub = false ;
      if ( GXutil.strcmp(AV44Session.getValue("PetitorioWWGridState"), "") == 0 )
      {
         AV46GridState.fromxml(new com.projectthani.wwpbaseobjects.loadgridstate(remoteHandle, context).executeUdp( "PetitorioWWGridState"), null, null);
      }
      else
      {
         AV46GridState.fromxml(AV44Session.getValue("PetitorioWWGridState"), null, null);
      }
      AV52GXV1 = 1 ;
      while ( AV52GXV1 <= AV46GridState.getgxTv_SdtWWPGridState_Filtervalues().size() )
      {
         AV47GridStateFilterValue = (com.projectthani.wwpbaseobjects.SdtWWPGridState_FilterValue)((com.projectthani.wwpbaseobjects.SdtWWPGridState_FilterValue)AV46GridState.getgxTv_SdtWWPGridState_Filtervalues().elementAt(-1+AV52GXV1));
         if ( GXutil.strcmp(AV47GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "FILTERFULLTEXT") == 0 )
         {
            AV49FilterFullText = AV47GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV47GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFPETITORIOID") == 0 )
         {
            AV11TFPetitorioId = (short)(GXutil.lval( AV47GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value())) ;
            AV12TFPetitorioId_To = (short)(GXutil.lval( AV47GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Valueto())) ;
         }
         else if ( GXutil.strcmp(AV47GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFDROGUERIAID") == 0 )
         {
            AV13TFDrogueriaId = (short)(GXutil.lval( AV47GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value())) ;
            AV14TFDrogueriaId_To = (short)(GXutil.lval( AV47GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Valueto())) ;
         }
         else if ( GXutil.strcmp(AV47GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFPETITORIOPRINCIPIOACTIVO") == 0 )
         {
            AV15TFPetitorioPrincipioActivo = AV47GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV47GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFPETITORIOPRINCIPIOACTIVO_SEL") == 0 )
         {
            AV16TFPetitorioPrincipioActivo_Sel = AV47GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV47GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFPETITORIOPRODUCTO") == 0 )
         {
            AV17TFPetitorioProducto = AV47GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV47GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFPETITORIOPRODUCTO_SEL") == 0 )
         {
            AV18TFPetitorioProducto_Sel = AV47GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV47GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFPETITORIOCATEGID") == 0 )
         {
            AV19TFPetitorioCategId = (short)(GXutil.lval( AV47GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value())) ;
            AV20TFPetitorioCategId_To = (short)(GXutil.lval( AV47GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Valueto())) ;
         }
         else if ( GXutil.strcmp(AV47GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFPETITORIOSUBCATEGID") == 0 )
         {
            AV21TFPetitorioSubCategId = (short)(GXutil.lval( AV47GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value())) ;
            AV22TFPetitorioSubCategId_To = (short)(GXutil.lval( AV47GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Valueto())) ;
         }
         else if ( GXutil.strcmp(AV47GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFPETITORIOCONCENTRACION") == 0 )
         {
            AV23TFPetitorioConcentracion = AV47GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV47GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFPETITORIOCONCENTRACION_SEL") == 0 )
         {
            AV24TFPetitorioConcentracion_Sel = AV47GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV47GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFFORMAFARMACEUTICAID") == 0 )
         {
            AV25TFFormaFarmaceuticaId = (short)(GXutil.lval( AV47GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value())) ;
            AV26TFFormaFarmaceuticaId_To = (short)(GXutil.lval( AV47GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Valueto())) ;
         }
         else if ( GXutil.strcmp(AV47GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFPETITORIOPRESENTACION") == 0 )
         {
            AV27TFPetitorioPresentacion = AV47GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV47GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFPETITORIOPRESENTACION_SEL") == 0 )
         {
            AV28TFPetitorioPresentacion_Sel = AV47GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV47GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFPETITORIOPRECIO") == 0 )
         {
            AV29TFPetitorioPrecio = CommonUtil.decimalVal( AV47GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value(), ".") ;
            AV30TFPetitorioPrecio_To = CommonUtil.decimalVal( AV47GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Valueto(), ".") ;
         }
         AV52GXV1 = (int)(AV52GXV1+1) ;
      }
   }

   public void S121( )
   {
      /* 'LOADPETITORIOPRINCIPIOACTIVOOPTIONS' Routine */
      returnInSub = false ;
      AV15TFPetitorioPrincipioActivo = AV31SearchTxt ;
      AV16TFPetitorioPrincipioActivo_Sel = "" ;
      AV54Petitoriowwds_1_filterfulltext = AV49FilterFullText ;
      AV55Petitoriowwds_2_tfpetitorioid = AV11TFPetitorioId ;
      AV56Petitoriowwds_3_tfpetitorioid_to = AV12TFPetitorioId_To ;
      AV57Petitoriowwds_4_tfdrogueriaid = AV13TFDrogueriaId ;
      AV58Petitoriowwds_5_tfdrogueriaid_to = AV14TFDrogueriaId_To ;
      AV59Petitoriowwds_6_tfpetitorioprincipioactivo = AV15TFPetitorioPrincipioActivo ;
      AV60Petitoriowwds_7_tfpetitorioprincipioactivo_sel = AV16TFPetitorioPrincipioActivo_Sel ;
      AV61Petitoriowwds_8_tfpetitorioproducto = AV17TFPetitorioProducto ;
      AV62Petitoriowwds_9_tfpetitorioproducto_sel = AV18TFPetitorioProducto_Sel ;
      AV63Petitoriowwds_10_tfpetitoriocategid = AV19TFPetitorioCategId ;
      AV64Petitoriowwds_11_tfpetitoriocategid_to = AV20TFPetitorioCategId_To ;
      AV65Petitoriowwds_12_tfpetitoriosubcategid = AV21TFPetitorioSubCategId ;
      AV66Petitoriowwds_13_tfpetitoriosubcategid_to = AV22TFPetitorioSubCategId_To ;
      AV67Petitoriowwds_14_tfpetitorioconcentracion = AV23TFPetitorioConcentracion ;
      AV68Petitoriowwds_15_tfpetitorioconcentracion_sel = AV24TFPetitorioConcentracion_Sel ;
      AV69Petitoriowwds_16_tfformafarmaceuticaid = AV25TFFormaFarmaceuticaId ;
      AV70Petitoriowwds_17_tfformafarmaceuticaid_to = AV26TFFormaFarmaceuticaId_To ;
      AV71Petitoriowwds_18_tfpetitoriopresentacion = AV27TFPetitorioPresentacion ;
      AV72Petitoriowwds_19_tfpetitoriopresentacion_sel = AV28TFPetitorioPresentacion_Sel ;
      AV73Petitoriowwds_20_tfpetitorioprecio = AV29TFPetitorioPrecio ;
      AV74Petitoriowwds_21_tfpetitorioprecio_to = AV30TFPetitorioPrecio_To ;
      pr_default.dynParam(0, new Object[]{ new Object[]{
                                           AV54Petitoriowwds_1_filterfulltext ,
                                           Short.valueOf(AV55Petitoriowwds_2_tfpetitorioid) ,
                                           Short.valueOf(AV56Petitoriowwds_3_tfpetitorioid_to) ,
                                           Short.valueOf(AV57Petitoriowwds_4_tfdrogueriaid) ,
                                           Short.valueOf(AV58Petitoriowwds_5_tfdrogueriaid_to) ,
                                           AV60Petitoriowwds_7_tfpetitorioprincipioactivo_sel ,
                                           AV59Petitoriowwds_6_tfpetitorioprincipioactivo ,
                                           AV62Petitoriowwds_9_tfpetitorioproducto_sel ,
                                           AV61Petitoriowwds_8_tfpetitorioproducto ,
                                           Short.valueOf(AV63Petitoriowwds_10_tfpetitoriocategid) ,
                                           Short.valueOf(AV64Petitoriowwds_11_tfpetitoriocategid_to) ,
                                           Short.valueOf(AV65Petitoriowwds_12_tfpetitoriosubcategid) ,
                                           Short.valueOf(AV66Petitoriowwds_13_tfpetitoriosubcategid_to) ,
                                           AV68Petitoriowwds_15_tfpetitorioconcentracion_sel ,
                                           AV67Petitoriowwds_14_tfpetitorioconcentracion ,
                                           Short.valueOf(AV69Petitoriowwds_16_tfformafarmaceuticaid) ,
                                           Short.valueOf(AV70Petitoriowwds_17_tfformafarmaceuticaid_to) ,
                                           AV72Petitoriowwds_19_tfpetitoriopresentacion_sel ,
                                           AV71Petitoriowwds_18_tfpetitoriopresentacion ,
                                           AV73Petitoriowwds_20_tfpetitorioprecio ,
                                           AV74Petitoriowwds_21_tfpetitorioprecio_to ,
                                           Short.valueOf(A25PetitorioId) ,
                                           Short.valueOf(A36DrogueriaId) ,
                                           A262PetitorioPrincipioActivo ,
                                           A263PetitorioProducto ,
                                           Short.valueOf(A49PetitorioCategId) ,
                                           Short.valueOf(A48PetitorioSubCategId) ,
                                           A260PetitorioConcentracion ,
                                           Short.valueOf(A39FormaFarmaceuticaId) ,
                                           A261PetitorioPresentacion ,
                                           A264PetitorioPrecio } ,
                                           new int[]{
                                           TypeConstants.STRING, TypeConstants.SHORT, TypeConstants.SHORT, TypeConstants.SHORT, TypeConstants.SHORT, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.SHORT,
                                           TypeConstants.SHORT, TypeConstants.SHORT, TypeConstants.SHORT, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.SHORT, TypeConstants.SHORT, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.DECIMAL,
                                           TypeConstants.DECIMAL, TypeConstants.SHORT, TypeConstants.SHORT, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.SHORT, TypeConstants.SHORT, TypeConstants.STRING, TypeConstants.SHORT, TypeConstants.STRING,
                                           TypeConstants.DECIMAL
                                           }
      });
      lV54Petitoriowwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV54Petitoriowwds_1_filterfulltext), "%", "") ;
      lV54Petitoriowwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV54Petitoriowwds_1_filterfulltext), "%", "") ;
      lV54Petitoriowwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV54Petitoriowwds_1_filterfulltext), "%", "") ;
      lV54Petitoriowwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV54Petitoriowwds_1_filterfulltext), "%", "") ;
      lV54Petitoriowwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV54Petitoriowwds_1_filterfulltext), "%", "") ;
      lV54Petitoriowwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV54Petitoriowwds_1_filterfulltext), "%", "") ;
      lV54Petitoriowwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV54Petitoriowwds_1_filterfulltext), "%", "") ;
      lV54Petitoriowwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV54Petitoriowwds_1_filterfulltext), "%", "") ;
      lV54Petitoriowwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV54Petitoriowwds_1_filterfulltext), "%", "") ;
      lV54Petitoriowwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV54Petitoriowwds_1_filterfulltext), "%", "") ;
      lV59Petitoriowwds_6_tfpetitorioprincipioactivo = GXutil.concat( GXutil.rtrim( AV59Petitoriowwds_6_tfpetitorioprincipioactivo), "%", "") ;
      lV61Petitoriowwds_8_tfpetitorioproducto = GXutil.concat( GXutil.rtrim( AV61Petitoriowwds_8_tfpetitorioproducto), "%", "") ;
      lV67Petitoriowwds_14_tfpetitorioconcentracion = GXutil.concat( GXutil.rtrim( AV67Petitoriowwds_14_tfpetitorioconcentracion), "%", "") ;
      lV71Petitoriowwds_18_tfpetitoriopresentacion = GXutil.concat( GXutil.rtrim( AV71Petitoriowwds_18_tfpetitoriopresentacion), "%", "") ;
      /* Using cursor P003E2 */
      pr_default.execute(0, new Object[] {lV54Petitoriowwds_1_filterfulltext, lV54Petitoriowwds_1_filterfulltext, lV54Petitoriowwds_1_filterfulltext, lV54Petitoriowwds_1_filterfulltext, lV54Petitoriowwds_1_filterfulltext, lV54Petitoriowwds_1_filterfulltext, lV54Petitoriowwds_1_filterfulltext, lV54Petitoriowwds_1_filterfulltext, lV54Petitoriowwds_1_filterfulltext, lV54Petitoriowwds_1_filterfulltext, Short.valueOf(AV55Petitoriowwds_2_tfpetitorioid), Short.valueOf(AV56Petitoriowwds_3_tfpetitorioid_to), Short.valueOf(AV57Petitoriowwds_4_tfdrogueriaid), Short.valueOf(AV58Petitoriowwds_5_tfdrogueriaid_to), lV59Petitoriowwds_6_tfpetitorioprincipioactivo, AV60Petitoriowwds_7_tfpetitorioprincipioactivo_sel, lV61Petitoriowwds_8_tfpetitorioproducto, AV62Petitoriowwds_9_tfpetitorioproducto_sel, Short.valueOf(AV63Petitoriowwds_10_tfpetitoriocategid), Short.valueOf(AV64Petitoriowwds_11_tfpetitoriocategid_to), Short.valueOf(AV65Petitoriowwds_12_tfpetitoriosubcategid), Short.valueOf(AV66Petitoriowwds_13_tfpetitoriosubcategid_to), lV67Petitoriowwds_14_tfpetitorioconcentracion, AV68Petitoriowwds_15_tfpetitorioconcentracion_sel, Short.valueOf(AV69Petitoriowwds_16_tfformafarmaceuticaid), Short.valueOf(AV70Petitoriowwds_17_tfformafarmaceuticaid_to), lV71Petitoriowwds_18_tfpetitoriopresentacion, AV72Petitoriowwds_19_tfpetitoriopresentacion_sel, AV73Petitoriowwds_20_tfpetitorioprecio, AV74Petitoriowwds_21_tfpetitorioprecio_to});
      while ( (pr_default.getStatus(0) != 101) )
      {
         brk3E2 = false ;
         A262PetitorioPrincipioActivo = P003E2_A262PetitorioPrincipioActivo[0] ;
         A264PetitorioPrecio = P003E2_A264PetitorioPrecio[0] ;
         A39FormaFarmaceuticaId = P003E2_A39FormaFarmaceuticaId[0] ;
         A48PetitorioSubCategId = P003E2_A48PetitorioSubCategId[0] ;
         A49PetitorioCategId = P003E2_A49PetitorioCategId[0] ;
         A36DrogueriaId = P003E2_A36DrogueriaId[0] ;
         A25PetitorioId = P003E2_A25PetitorioId[0] ;
         A261PetitorioPresentacion = P003E2_A261PetitorioPresentacion[0] ;
         A260PetitorioConcentracion = P003E2_A260PetitorioConcentracion[0] ;
         A263PetitorioProducto = P003E2_A263PetitorioProducto[0] ;
         A49PetitorioCategId = P003E2_A49PetitorioCategId[0] ;
         AV43count = 0 ;
         while ( (pr_default.getStatus(0) != 101) && ( GXutil.strcmp(P003E2_A262PetitorioPrincipioActivo[0], A262PetitorioPrincipioActivo) == 0 ) )
         {
            brk3E2 = false ;
            A25PetitorioId = P003E2_A25PetitorioId[0] ;
            AV43count = (long)(AV43count+1) ;
            brk3E2 = true ;
            pr_default.readNext(0);
         }
         if ( ! (GXutil.strcmp("", A262PetitorioPrincipioActivo)==0) )
         {
            AV35Option = A262PetitorioPrincipioActivo ;
            AV36Options.add(AV35Option, 0);
            AV41OptionIndexes.add(GXutil.trim( localUtil.format( DecimalUtil.doubleToDec(AV43count), "Z,ZZZ,ZZZ,ZZ9")), 0);
         }
         if ( AV36Options.size() == 50 )
         {
            /* Exit For each command. Update data (if necessary), close cursors & exit. */
            if (true) break;
         }
         if ( ! brk3E2 )
         {
            brk3E2 = true ;
            pr_default.readNext(0);
         }
      }
      pr_default.close(0);
   }

   public void S131( )
   {
      /* 'LOADPETITORIOPRODUCTOOPTIONS' Routine */
      returnInSub = false ;
      AV17TFPetitorioProducto = AV31SearchTxt ;
      AV18TFPetitorioProducto_Sel = "" ;
      AV54Petitoriowwds_1_filterfulltext = AV49FilterFullText ;
      AV55Petitoriowwds_2_tfpetitorioid = AV11TFPetitorioId ;
      AV56Petitoriowwds_3_tfpetitorioid_to = AV12TFPetitorioId_To ;
      AV57Petitoriowwds_4_tfdrogueriaid = AV13TFDrogueriaId ;
      AV58Petitoriowwds_5_tfdrogueriaid_to = AV14TFDrogueriaId_To ;
      AV59Petitoriowwds_6_tfpetitorioprincipioactivo = AV15TFPetitorioPrincipioActivo ;
      AV60Petitoriowwds_7_tfpetitorioprincipioactivo_sel = AV16TFPetitorioPrincipioActivo_Sel ;
      AV61Petitoriowwds_8_tfpetitorioproducto = AV17TFPetitorioProducto ;
      AV62Petitoriowwds_9_tfpetitorioproducto_sel = AV18TFPetitorioProducto_Sel ;
      AV63Petitoriowwds_10_tfpetitoriocategid = AV19TFPetitorioCategId ;
      AV64Petitoriowwds_11_tfpetitoriocategid_to = AV20TFPetitorioCategId_To ;
      AV65Petitoriowwds_12_tfpetitoriosubcategid = AV21TFPetitorioSubCategId ;
      AV66Petitoriowwds_13_tfpetitoriosubcategid_to = AV22TFPetitorioSubCategId_To ;
      AV67Petitoriowwds_14_tfpetitorioconcentracion = AV23TFPetitorioConcentracion ;
      AV68Petitoriowwds_15_tfpetitorioconcentracion_sel = AV24TFPetitorioConcentracion_Sel ;
      AV69Petitoriowwds_16_tfformafarmaceuticaid = AV25TFFormaFarmaceuticaId ;
      AV70Petitoriowwds_17_tfformafarmaceuticaid_to = AV26TFFormaFarmaceuticaId_To ;
      AV71Petitoriowwds_18_tfpetitoriopresentacion = AV27TFPetitorioPresentacion ;
      AV72Petitoriowwds_19_tfpetitoriopresentacion_sel = AV28TFPetitorioPresentacion_Sel ;
      AV73Petitoriowwds_20_tfpetitorioprecio = AV29TFPetitorioPrecio ;
      AV74Petitoriowwds_21_tfpetitorioprecio_to = AV30TFPetitorioPrecio_To ;
      pr_default.dynParam(1, new Object[]{ new Object[]{
                                           AV54Petitoriowwds_1_filterfulltext ,
                                           Short.valueOf(AV55Petitoriowwds_2_tfpetitorioid) ,
                                           Short.valueOf(AV56Petitoriowwds_3_tfpetitorioid_to) ,
                                           Short.valueOf(AV57Petitoriowwds_4_tfdrogueriaid) ,
                                           Short.valueOf(AV58Petitoriowwds_5_tfdrogueriaid_to) ,
                                           AV60Petitoriowwds_7_tfpetitorioprincipioactivo_sel ,
                                           AV59Petitoriowwds_6_tfpetitorioprincipioactivo ,
                                           AV62Petitoriowwds_9_tfpetitorioproducto_sel ,
                                           AV61Petitoriowwds_8_tfpetitorioproducto ,
                                           Short.valueOf(AV63Petitoriowwds_10_tfpetitoriocategid) ,
                                           Short.valueOf(AV64Petitoriowwds_11_tfpetitoriocategid_to) ,
                                           Short.valueOf(AV65Petitoriowwds_12_tfpetitoriosubcategid) ,
                                           Short.valueOf(AV66Petitoriowwds_13_tfpetitoriosubcategid_to) ,
                                           AV68Petitoriowwds_15_tfpetitorioconcentracion_sel ,
                                           AV67Petitoriowwds_14_tfpetitorioconcentracion ,
                                           Short.valueOf(AV69Petitoriowwds_16_tfformafarmaceuticaid) ,
                                           Short.valueOf(AV70Petitoriowwds_17_tfformafarmaceuticaid_to) ,
                                           AV72Petitoriowwds_19_tfpetitoriopresentacion_sel ,
                                           AV71Petitoriowwds_18_tfpetitoriopresentacion ,
                                           AV73Petitoriowwds_20_tfpetitorioprecio ,
                                           AV74Petitoriowwds_21_tfpetitorioprecio_to ,
                                           Short.valueOf(A25PetitorioId) ,
                                           Short.valueOf(A36DrogueriaId) ,
                                           A262PetitorioPrincipioActivo ,
                                           A263PetitorioProducto ,
                                           Short.valueOf(A49PetitorioCategId) ,
                                           Short.valueOf(A48PetitorioSubCategId) ,
                                           A260PetitorioConcentracion ,
                                           Short.valueOf(A39FormaFarmaceuticaId) ,
                                           A261PetitorioPresentacion ,
                                           A264PetitorioPrecio } ,
                                           new int[]{
                                           TypeConstants.STRING, TypeConstants.SHORT, TypeConstants.SHORT, TypeConstants.SHORT, TypeConstants.SHORT, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.SHORT,
                                           TypeConstants.SHORT, TypeConstants.SHORT, TypeConstants.SHORT, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.SHORT, TypeConstants.SHORT, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.DECIMAL,
                                           TypeConstants.DECIMAL, TypeConstants.SHORT, TypeConstants.SHORT, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.SHORT, TypeConstants.SHORT, TypeConstants.STRING, TypeConstants.SHORT, TypeConstants.STRING,
                                           TypeConstants.DECIMAL
                                           }
      });
      lV54Petitoriowwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV54Petitoriowwds_1_filterfulltext), "%", "") ;
      lV54Petitoriowwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV54Petitoriowwds_1_filterfulltext), "%", "") ;
      lV54Petitoriowwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV54Petitoriowwds_1_filterfulltext), "%", "") ;
      lV54Petitoriowwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV54Petitoriowwds_1_filterfulltext), "%", "") ;
      lV54Petitoriowwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV54Petitoriowwds_1_filterfulltext), "%", "") ;
      lV54Petitoriowwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV54Petitoriowwds_1_filterfulltext), "%", "") ;
      lV54Petitoriowwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV54Petitoriowwds_1_filterfulltext), "%", "") ;
      lV54Petitoriowwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV54Petitoriowwds_1_filterfulltext), "%", "") ;
      lV54Petitoriowwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV54Petitoriowwds_1_filterfulltext), "%", "") ;
      lV54Petitoriowwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV54Petitoriowwds_1_filterfulltext), "%", "") ;
      lV59Petitoriowwds_6_tfpetitorioprincipioactivo = GXutil.concat( GXutil.rtrim( AV59Petitoriowwds_6_tfpetitorioprincipioactivo), "%", "") ;
      lV61Petitoriowwds_8_tfpetitorioproducto = GXutil.concat( GXutil.rtrim( AV61Petitoriowwds_8_tfpetitorioproducto), "%", "") ;
      lV67Petitoriowwds_14_tfpetitorioconcentracion = GXutil.concat( GXutil.rtrim( AV67Petitoriowwds_14_tfpetitorioconcentracion), "%", "") ;
      lV71Petitoriowwds_18_tfpetitoriopresentacion = GXutil.concat( GXutil.rtrim( AV71Petitoriowwds_18_tfpetitoriopresentacion), "%", "") ;
      /* Using cursor P003E3 */
      pr_default.execute(1, new Object[] {lV54Petitoriowwds_1_filterfulltext, lV54Petitoriowwds_1_filterfulltext, lV54Petitoriowwds_1_filterfulltext, lV54Petitoriowwds_1_filterfulltext, lV54Petitoriowwds_1_filterfulltext, lV54Petitoriowwds_1_filterfulltext, lV54Petitoriowwds_1_filterfulltext, lV54Petitoriowwds_1_filterfulltext, lV54Petitoriowwds_1_filterfulltext, lV54Petitoriowwds_1_filterfulltext, Short.valueOf(AV55Petitoriowwds_2_tfpetitorioid), Short.valueOf(AV56Petitoriowwds_3_tfpetitorioid_to), Short.valueOf(AV57Petitoriowwds_4_tfdrogueriaid), Short.valueOf(AV58Petitoriowwds_5_tfdrogueriaid_to), lV59Petitoriowwds_6_tfpetitorioprincipioactivo, AV60Petitoriowwds_7_tfpetitorioprincipioactivo_sel, lV61Petitoriowwds_8_tfpetitorioproducto, AV62Petitoriowwds_9_tfpetitorioproducto_sel, Short.valueOf(AV63Petitoriowwds_10_tfpetitoriocategid), Short.valueOf(AV64Petitoriowwds_11_tfpetitoriocategid_to), Short.valueOf(AV65Petitoriowwds_12_tfpetitoriosubcategid), Short.valueOf(AV66Petitoriowwds_13_tfpetitoriosubcategid_to), lV67Petitoriowwds_14_tfpetitorioconcentracion, AV68Petitoriowwds_15_tfpetitorioconcentracion_sel, Short.valueOf(AV69Petitoriowwds_16_tfformafarmaceuticaid), Short.valueOf(AV70Petitoriowwds_17_tfformafarmaceuticaid_to), lV71Petitoriowwds_18_tfpetitoriopresentacion, AV72Petitoriowwds_19_tfpetitoriopresentacion_sel, AV73Petitoriowwds_20_tfpetitorioprecio, AV74Petitoriowwds_21_tfpetitorioprecio_to});
      while ( (pr_default.getStatus(1) != 101) )
      {
         brk3E4 = false ;
         A263PetitorioProducto = P003E3_A263PetitorioProducto[0] ;
         A264PetitorioPrecio = P003E3_A264PetitorioPrecio[0] ;
         A39FormaFarmaceuticaId = P003E3_A39FormaFarmaceuticaId[0] ;
         A48PetitorioSubCategId = P003E3_A48PetitorioSubCategId[0] ;
         A49PetitorioCategId = P003E3_A49PetitorioCategId[0] ;
         A36DrogueriaId = P003E3_A36DrogueriaId[0] ;
         A25PetitorioId = P003E3_A25PetitorioId[0] ;
         A261PetitorioPresentacion = P003E3_A261PetitorioPresentacion[0] ;
         A260PetitorioConcentracion = P003E3_A260PetitorioConcentracion[0] ;
         A262PetitorioPrincipioActivo = P003E3_A262PetitorioPrincipioActivo[0] ;
         A49PetitorioCategId = P003E3_A49PetitorioCategId[0] ;
         AV43count = 0 ;
         while ( (pr_default.getStatus(1) != 101) && ( GXutil.strcmp(P003E3_A263PetitorioProducto[0], A263PetitorioProducto) == 0 ) )
         {
            brk3E4 = false ;
            A25PetitorioId = P003E3_A25PetitorioId[0] ;
            AV43count = (long)(AV43count+1) ;
            brk3E4 = true ;
            pr_default.readNext(1);
         }
         if ( ! (GXutil.strcmp("", A263PetitorioProducto)==0) )
         {
            AV35Option = A263PetitorioProducto ;
            AV36Options.add(AV35Option, 0);
            AV41OptionIndexes.add(GXutil.trim( localUtil.format( DecimalUtil.doubleToDec(AV43count), "Z,ZZZ,ZZZ,ZZ9")), 0);
         }
         if ( AV36Options.size() == 50 )
         {
            /* Exit For each command. Update data (if necessary), close cursors & exit. */
            if (true) break;
         }
         if ( ! brk3E4 )
         {
            brk3E4 = true ;
            pr_default.readNext(1);
         }
      }
      pr_default.close(1);
   }

   public void S141( )
   {
      /* 'LOADPETITORIOCONCENTRACIONOPTIONS' Routine */
      returnInSub = false ;
      AV23TFPetitorioConcentracion = AV31SearchTxt ;
      AV24TFPetitorioConcentracion_Sel = "" ;
      AV54Petitoriowwds_1_filterfulltext = AV49FilterFullText ;
      AV55Petitoriowwds_2_tfpetitorioid = AV11TFPetitorioId ;
      AV56Petitoriowwds_3_tfpetitorioid_to = AV12TFPetitorioId_To ;
      AV57Petitoriowwds_4_tfdrogueriaid = AV13TFDrogueriaId ;
      AV58Petitoriowwds_5_tfdrogueriaid_to = AV14TFDrogueriaId_To ;
      AV59Petitoriowwds_6_tfpetitorioprincipioactivo = AV15TFPetitorioPrincipioActivo ;
      AV60Petitoriowwds_7_tfpetitorioprincipioactivo_sel = AV16TFPetitorioPrincipioActivo_Sel ;
      AV61Petitoriowwds_8_tfpetitorioproducto = AV17TFPetitorioProducto ;
      AV62Petitoriowwds_9_tfpetitorioproducto_sel = AV18TFPetitorioProducto_Sel ;
      AV63Petitoriowwds_10_tfpetitoriocategid = AV19TFPetitorioCategId ;
      AV64Petitoriowwds_11_tfpetitoriocategid_to = AV20TFPetitorioCategId_To ;
      AV65Petitoriowwds_12_tfpetitoriosubcategid = AV21TFPetitorioSubCategId ;
      AV66Petitoriowwds_13_tfpetitoriosubcategid_to = AV22TFPetitorioSubCategId_To ;
      AV67Petitoriowwds_14_tfpetitorioconcentracion = AV23TFPetitorioConcentracion ;
      AV68Petitoriowwds_15_tfpetitorioconcentracion_sel = AV24TFPetitorioConcentracion_Sel ;
      AV69Petitoriowwds_16_tfformafarmaceuticaid = AV25TFFormaFarmaceuticaId ;
      AV70Petitoriowwds_17_tfformafarmaceuticaid_to = AV26TFFormaFarmaceuticaId_To ;
      AV71Petitoriowwds_18_tfpetitoriopresentacion = AV27TFPetitorioPresentacion ;
      AV72Petitoriowwds_19_tfpetitoriopresentacion_sel = AV28TFPetitorioPresentacion_Sel ;
      AV73Petitoriowwds_20_tfpetitorioprecio = AV29TFPetitorioPrecio ;
      AV74Petitoriowwds_21_tfpetitorioprecio_to = AV30TFPetitorioPrecio_To ;
      pr_default.dynParam(2, new Object[]{ new Object[]{
                                           AV54Petitoriowwds_1_filterfulltext ,
                                           Short.valueOf(AV55Petitoriowwds_2_tfpetitorioid) ,
                                           Short.valueOf(AV56Petitoriowwds_3_tfpetitorioid_to) ,
                                           Short.valueOf(AV57Petitoriowwds_4_tfdrogueriaid) ,
                                           Short.valueOf(AV58Petitoriowwds_5_tfdrogueriaid_to) ,
                                           AV60Petitoriowwds_7_tfpetitorioprincipioactivo_sel ,
                                           AV59Petitoriowwds_6_tfpetitorioprincipioactivo ,
                                           AV62Petitoriowwds_9_tfpetitorioproducto_sel ,
                                           AV61Petitoriowwds_8_tfpetitorioproducto ,
                                           Short.valueOf(AV63Petitoriowwds_10_tfpetitoriocategid) ,
                                           Short.valueOf(AV64Petitoriowwds_11_tfpetitoriocategid_to) ,
                                           Short.valueOf(AV65Petitoriowwds_12_tfpetitoriosubcategid) ,
                                           Short.valueOf(AV66Petitoriowwds_13_tfpetitoriosubcategid_to) ,
                                           AV68Petitoriowwds_15_tfpetitorioconcentracion_sel ,
                                           AV67Petitoriowwds_14_tfpetitorioconcentracion ,
                                           Short.valueOf(AV69Petitoriowwds_16_tfformafarmaceuticaid) ,
                                           Short.valueOf(AV70Petitoriowwds_17_tfformafarmaceuticaid_to) ,
                                           AV72Petitoriowwds_19_tfpetitoriopresentacion_sel ,
                                           AV71Petitoriowwds_18_tfpetitoriopresentacion ,
                                           AV73Petitoriowwds_20_tfpetitorioprecio ,
                                           AV74Petitoriowwds_21_tfpetitorioprecio_to ,
                                           Short.valueOf(A25PetitorioId) ,
                                           Short.valueOf(A36DrogueriaId) ,
                                           A262PetitorioPrincipioActivo ,
                                           A263PetitorioProducto ,
                                           Short.valueOf(A49PetitorioCategId) ,
                                           Short.valueOf(A48PetitorioSubCategId) ,
                                           A260PetitorioConcentracion ,
                                           Short.valueOf(A39FormaFarmaceuticaId) ,
                                           A261PetitorioPresentacion ,
                                           A264PetitorioPrecio } ,
                                           new int[]{
                                           TypeConstants.STRING, TypeConstants.SHORT, TypeConstants.SHORT, TypeConstants.SHORT, TypeConstants.SHORT, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.SHORT,
                                           TypeConstants.SHORT, TypeConstants.SHORT, TypeConstants.SHORT, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.SHORT, TypeConstants.SHORT, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.DECIMAL,
                                           TypeConstants.DECIMAL, TypeConstants.SHORT, TypeConstants.SHORT, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.SHORT, TypeConstants.SHORT, TypeConstants.STRING, TypeConstants.SHORT, TypeConstants.STRING,
                                           TypeConstants.DECIMAL
                                           }
      });
      lV54Petitoriowwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV54Petitoriowwds_1_filterfulltext), "%", "") ;
      lV54Petitoriowwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV54Petitoriowwds_1_filterfulltext), "%", "") ;
      lV54Petitoriowwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV54Petitoriowwds_1_filterfulltext), "%", "") ;
      lV54Petitoriowwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV54Petitoriowwds_1_filterfulltext), "%", "") ;
      lV54Petitoriowwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV54Petitoriowwds_1_filterfulltext), "%", "") ;
      lV54Petitoriowwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV54Petitoriowwds_1_filterfulltext), "%", "") ;
      lV54Petitoriowwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV54Petitoriowwds_1_filterfulltext), "%", "") ;
      lV54Petitoriowwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV54Petitoriowwds_1_filterfulltext), "%", "") ;
      lV54Petitoriowwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV54Petitoriowwds_1_filterfulltext), "%", "") ;
      lV54Petitoriowwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV54Petitoriowwds_1_filterfulltext), "%", "") ;
      lV59Petitoriowwds_6_tfpetitorioprincipioactivo = GXutil.concat( GXutil.rtrim( AV59Petitoriowwds_6_tfpetitorioprincipioactivo), "%", "") ;
      lV61Petitoriowwds_8_tfpetitorioproducto = GXutil.concat( GXutil.rtrim( AV61Petitoriowwds_8_tfpetitorioproducto), "%", "") ;
      lV67Petitoriowwds_14_tfpetitorioconcentracion = GXutil.concat( GXutil.rtrim( AV67Petitoriowwds_14_tfpetitorioconcentracion), "%", "") ;
      lV71Petitoriowwds_18_tfpetitoriopresentacion = GXutil.concat( GXutil.rtrim( AV71Petitoriowwds_18_tfpetitoriopresentacion), "%", "") ;
      /* Using cursor P003E4 */
      pr_default.execute(2, new Object[] {lV54Petitoriowwds_1_filterfulltext, lV54Petitoriowwds_1_filterfulltext, lV54Petitoriowwds_1_filterfulltext, lV54Petitoriowwds_1_filterfulltext, lV54Petitoriowwds_1_filterfulltext, lV54Petitoriowwds_1_filterfulltext, lV54Petitoriowwds_1_filterfulltext, lV54Petitoriowwds_1_filterfulltext, lV54Petitoriowwds_1_filterfulltext, lV54Petitoriowwds_1_filterfulltext, Short.valueOf(AV55Petitoriowwds_2_tfpetitorioid), Short.valueOf(AV56Petitoriowwds_3_tfpetitorioid_to), Short.valueOf(AV57Petitoriowwds_4_tfdrogueriaid), Short.valueOf(AV58Petitoriowwds_5_tfdrogueriaid_to), lV59Petitoriowwds_6_tfpetitorioprincipioactivo, AV60Petitoriowwds_7_tfpetitorioprincipioactivo_sel, lV61Petitoriowwds_8_tfpetitorioproducto, AV62Petitoriowwds_9_tfpetitorioproducto_sel, Short.valueOf(AV63Petitoriowwds_10_tfpetitoriocategid), Short.valueOf(AV64Petitoriowwds_11_tfpetitoriocategid_to), Short.valueOf(AV65Petitoriowwds_12_tfpetitoriosubcategid), Short.valueOf(AV66Petitoriowwds_13_tfpetitoriosubcategid_to), lV67Petitoriowwds_14_tfpetitorioconcentracion, AV68Petitoriowwds_15_tfpetitorioconcentracion_sel, Short.valueOf(AV69Petitoriowwds_16_tfformafarmaceuticaid), Short.valueOf(AV70Petitoriowwds_17_tfformafarmaceuticaid_to), lV71Petitoriowwds_18_tfpetitoriopresentacion, AV72Petitoriowwds_19_tfpetitoriopresentacion_sel, AV73Petitoriowwds_20_tfpetitorioprecio, AV74Petitoriowwds_21_tfpetitorioprecio_to});
      while ( (pr_default.getStatus(2) != 101) )
      {
         brk3E6 = false ;
         A260PetitorioConcentracion = P003E4_A260PetitorioConcentracion[0] ;
         A264PetitorioPrecio = P003E4_A264PetitorioPrecio[0] ;
         A39FormaFarmaceuticaId = P003E4_A39FormaFarmaceuticaId[0] ;
         A48PetitorioSubCategId = P003E4_A48PetitorioSubCategId[0] ;
         A49PetitorioCategId = P003E4_A49PetitorioCategId[0] ;
         A36DrogueriaId = P003E4_A36DrogueriaId[0] ;
         A25PetitorioId = P003E4_A25PetitorioId[0] ;
         A261PetitorioPresentacion = P003E4_A261PetitorioPresentacion[0] ;
         A263PetitorioProducto = P003E4_A263PetitorioProducto[0] ;
         A262PetitorioPrincipioActivo = P003E4_A262PetitorioPrincipioActivo[0] ;
         A49PetitorioCategId = P003E4_A49PetitorioCategId[0] ;
         AV43count = 0 ;
         while ( (pr_default.getStatus(2) != 101) && ( GXutil.strcmp(P003E4_A260PetitorioConcentracion[0], A260PetitorioConcentracion) == 0 ) )
         {
            brk3E6 = false ;
            A25PetitorioId = P003E4_A25PetitorioId[0] ;
            AV43count = (long)(AV43count+1) ;
            brk3E6 = true ;
            pr_default.readNext(2);
         }
         if ( ! (GXutil.strcmp("", A260PetitorioConcentracion)==0) )
         {
            AV35Option = A260PetitorioConcentracion ;
            AV36Options.add(AV35Option, 0);
            AV41OptionIndexes.add(GXutil.trim( localUtil.format( DecimalUtil.doubleToDec(AV43count), "Z,ZZZ,ZZZ,ZZ9")), 0);
         }
         if ( AV36Options.size() == 50 )
         {
            /* Exit For each command. Update data (if necessary), close cursors & exit. */
            if (true) break;
         }
         if ( ! brk3E6 )
         {
            brk3E6 = true ;
            pr_default.readNext(2);
         }
      }
      pr_default.close(2);
   }

   public void S151( )
   {
      /* 'LOADPETITORIOPRESENTACIONOPTIONS' Routine */
      returnInSub = false ;
      AV27TFPetitorioPresentacion = AV31SearchTxt ;
      AV28TFPetitorioPresentacion_Sel = "" ;
      AV54Petitoriowwds_1_filterfulltext = AV49FilterFullText ;
      AV55Petitoriowwds_2_tfpetitorioid = AV11TFPetitorioId ;
      AV56Petitoriowwds_3_tfpetitorioid_to = AV12TFPetitorioId_To ;
      AV57Petitoriowwds_4_tfdrogueriaid = AV13TFDrogueriaId ;
      AV58Petitoriowwds_5_tfdrogueriaid_to = AV14TFDrogueriaId_To ;
      AV59Petitoriowwds_6_tfpetitorioprincipioactivo = AV15TFPetitorioPrincipioActivo ;
      AV60Petitoriowwds_7_tfpetitorioprincipioactivo_sel = AV16TFPetitorioPrincipioActivo_Sel ;
      AV61Petitoriowwds_8_tfpetitorioproducto = AV17TFPetitorioProducto ;
      AV62Petitoriowwds_9_tfpetitorioproducto_sel = AV18TFPetitorioProducto_Sel ;
      AV63Petitoriowwds_10_tfpetitoriocategid = AV19TFPetitorioCategId ;
      AV64Petitoriowwds_11_tfpetitoriocategid_to = AV20TFPetitorioCategId_To ;
      AV65Petitoriowwds_12_tfpetitoriosubcategid = AV21TFPetitorioSubCategId ;
      AV66Petitoriowwds_13_tfpetitoriosubcategid_to = AV22TFPetitorioSubCategId_To ;
      AV67Petitoriowwds_14_tfpetitorioconcentracion = AV23TFPetitorioConcentracion ;
      AV68Petitoriowwds_15_tfpetitorioconcentracion_sel = AV24TFPetitorioConcentracion_Sel ;
      AV69Petitoriowwds_16_tfformafarmaceuticaid = AV25TFFormaFarmaceuticaId ;
      AV70Petitoriowwds_17_tfformafarmaceuticaid_to = AV26TFFormaFarmaceuticaId_To ;
      AV71Petitoriowwds_18_tfpetitoriopresentacion = AV27TFPetitorioPresentacion ;
      AV72Petitoriowwds_19_tfpetitoriopresentacion_sel = AV28TFPetitorioPresentacion_Sel ;
      AV73Petitoriowwds_20_tfpetitorioprecio = AV29TFPetitorioPrecio ;
      AV74Petitoriowwds_21_tfpetitorioprecio_to = AV30TFPetitorioPrecio_To ;
      pr_default.dynParam(3, new Object[]{ new Object[]{
                                           AV54Petitoriowwds_1_filterfulltext ,
                                           Short.valueOf(AV55Petitoriowwds_2_tfpetitorioid) ,
                                           Short.valueOf(AV56Petitoriowwds_3_tfpetitorioid_to) ,
                                           Short.valueOf(AV57Petitoriowwds_4_tfdrogueriaid) ,
                                           Short.valueOf(AV58Petitoriowwds_5_tfdrogueriaid_to) ,
                                           AV60Petitoriowwds_7_tfpetitorioprincipioactivo_sel ,
                                           AV59Petitoriowwds_6_tfpetitorioprincipioactivo ,
                                           AV62Petitoriowwds_9_tfpetitorioproducto_sel ,
                                           AV61Petitoriowwds_8_tfpetitorioproducto ,
                                           Short.valueOf(AV63Petitoriowwds_10_tfpetitoriocategid) ,
                                           Short.valueOf(AV64Petitoriowwds_11_tfpetitoriocategid_to) ,
                                           Short.valueOf(AV65Petitoriowwds_12_tfpetitoriosubcategid) ,
                                           Short.valueOf(AV66Petitoriowwds_13_tfpetitoriosubcategid_to) ,
                                           AV68Petitoriowwds_15_tfpetitorioconcentracion_sel ,
                                           AV67Petitoriowwds_14_tfpetitorioconcentracion ,
                                           Short.valueOf(AV69Petitoriowwds_16_tfformafarmaceuticaid) ,
                                           Short.valueOf(AV70Petitoriowwds_17_tfformafarmaceuticaid_to) ,
                                           AV72Petitoriowwds_19_tfpetitoriopresentacion_sel ,
                                           AV71Petitoriowwds_18_tfpetitoriopresentacion ,
                                           AV73Petitoriowwds_20_tfpetitorioprecio ,
                                           AV74Petitoriowwds_21_tfpetitorioprecio_to ,
                                           Short.valueOf(A25PetitorioId) ,
                                           Short.valueOf(A36DrogueriaId) ,
                                           A262PetitorioPrincipioActivo ,
                                           A263PetitorioProducto ,
                                           Short.valueOf(A49PetitorioCategId) ,
                                           Short.valueOf(A48PetitorioSubCategId) ,
                                           A260PetitorioConcentracion ,
                                           Short.valueOf(A39FormaFarmaceuticaId) ,
                                           A261PetitorioPresentacion ,
                                           A264PetitorioPrecio } ,
                                           new int[]{
                                           TypeConstants.STRING, TypeConstants.SHORT, TypeConstants.SHORT, TypeConstants.SHORT, TypeConstants.SHORT, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.SHORT,
                                           TypeConstants.SHORT, TypeConstants.SHORT, TypeConstants.SHORT, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.SHORT, TypeConstants.SHORT, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.DECIMAL,
                                           TypeConstants.DECIMAL, TypeConstants.SHORT, TypeConstants.SHORT, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.SHORT, TypeConstants.SHORT, TypeConstants.STRING, TypeConstants.SHORT, TypeConstants.STRING,
                                           TypeConstants.DECIMAL
                                           }
      });
      lV54Petitoriowwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV54Petitoriowwds_1_filterfulltext), "%", "") ;
      lV54Petitoriowwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV54Petitoriowwds_1_filterfulltext), "%", "") ;
      lV54Petitoriowwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV54Petitoriowwds_1_filterfulltext), "%", "") ;
      lV54Petitoriowwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV54Petitoriowwds_1_filterfulltext), "%", "") ;
      lV54Petitoriowwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV54Petitoriowwds_1_filterfulltext), "%", "") ;
      lV54Petitoriowwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV54Petitoriowwds_1_filterfulltext), "%", "") ;
      lV54Petitoriowwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV54Petitoriowwds_1_filterfulltext), "%", "") ;
      lV54Petitoriowwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV54Petitoriowwds_1_filterfulltext), "%", "") ;
      lV54Petitoriowwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV54Petitoriowwds_1_filterfulltext), "%", "") ;
      lV54Petitoriowwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV54Petitoriowwds_1_filterfulltext), "%", "") ;
      lV59Petitoriowwds_6_tfpetitorioprincipioactivo = GXutil.concat( GXutil.rtrim( AV59Petitoriowwds_6_tfpetitorioprincipioactivo), "%", "") ;
      lV61Petitoriowwds_8_tfpetitorioproducto = GXutil.concat( GXutil.rtrim( AV61Petitoriowwds_8_tfpetitorioproducto), "%", "") ;
      lV67Petitoriowwds_14_tfpetitorioconcentracion = GXutil.concat( GXutil.rtrim( AV67Petitoriowwds_14_tfpetitorioconcentracion), "%", "") ;
      lV71Petitoriowwds_18_tfpetitoriopresentacion = GXutil.concat( GXutil.rtrim( AV71Petitoriowwds_18_tfpetitoriopresentacion), "%", "") ;
      /* Using cursor P003E5 */
      pr_default.execute(3, new Object[] {lV54Petitoriowwds_1_filterfulltext, lV54Petitoriowwds_1_filterfulltext, lV54Petitoriowwds_1_filterfulltext, lV54Petitoriowwds_1_filterfulltext, lV54Petitoriowwds_1_filterfulltext, lV54Petitoriowwds_1_filterfulltext, lV54Petitoriowwds_1_filterfulltext, lV54Petitoriowwds_1_filterfulltext, lV54Petitoriowwds_1_filterfulltext, lV54Petitoriowwds_1_filterfulltext, Short.valueOf(AV55Petitoriowwds_2_tfpetitorioid), Short.valueOf(AV56Petitoriowwds_3_tfpetitorioid_to), Short.valueOf(AV57Petitoriowwds_4_tfdrogueriaid), Short.valueOf(AV58Petitoriowwds_5_tfdrogueriaid_to), lV59Petitoriowwds_6_tfpetitorioprincipioactivo, AV60Petitoriowwds_7_tfpetitorioprincipioactivo_sel, lV61Petitoriowwds_8_tfpetitorioproducto, AV62Petitoriowwds_9_tfpetitorioproducto_sel, Short.valueOf(AV63Petitoriowwds_10_tfpetitoriocategid), Short.valueOf(AV64Petitoriowwds_11_tfpetitoriocategid_to), Short.valueOf(AV65Petitoriowwds_12_tfpetitoriosubcategid), Short.valueOf(AV66Petitoriowwds_13_tfpetitoriosubcategid_to), lV67Petitoriowwds_14_tfpetitorioconcentracion, AV68Petitoriowwds_15_tfpetitorioconcentracion_sel, Short.valueOf(AV69Petitoriowwds_16_tfformafarmaceuticaid), Short.valueOf(AV70Petitoriowwds_17_tfformafarmaceuticaid_to), lV71Petitoriowwds_18_tfpetitoriopresentacion, AV72Petitoriowwds_19_tfpetitoriopresentacion_sel, AV73Petitoriowwds_20_tfpetitorioprecio, AV74Petitoriowwds_21_tfpetitorioprecio_to});
      while ( (pr_default.getStatus(3) != 101) )
      {
         brk3E8 = false ;
         A261PetitorioPresentacion = P003E5_A261PetitorioPresentacion[0] ;
         A264PetitorioPrecio = P003E5_A264PetitorioPrecio[0] ;
         A39FormaFarmaceuticaId = P003E5_A39FormaFarmaceuticaId[0] ;
         A48PetitorioSubCategId = P003E5_A48PetitorioSubCategId[0] ;
         A49PetitorioCategId = P003E5_A49PetitorioCategId[0] ;
         A36DrogueriaId = P003E5_A36DrogueriaId[0] ;
         A25PetitorioId = P003E5_A25PetitorioId[0] ;
         A260PetitorioConcentracion = P003E5_A260PetitorioConcentracion[0] ;
         A263PetitorioProducto = P003E5_A263PetitorioProducto[0] ;
         A262PetitorioPrincipioActivo = P003E5_A262PetitorioPrincipioActivo[0] ;
         A49PetitorioCategId = P003E5_A49PetitorioCategId[0] ;
         AV43count = 0 ;
         while ( (pr_default.getStatus(3) != 101) && ( GXutil.strcmp(P003E5_A261PetitorioPresentacion[0], A261PetitorioPresentacion) == 0 ) )
         {
            brk3E8 = false ;
            A25PetitorioId = P003E5_A25PetitorioId[0] ;
            AV43count = (long)(AV43count+1) ;
            brk3E8 = true ;
            pr_default.readNext(3);
         }
         if ( ! (GXutil.strcmp("", A261PetitorioPresentacion)==0) )
         {
            AV35Option = A261PetitorioPresentacion ;
            AV36Options.add(AV35Option, 0);
            AV41OptionIndexes.add(GXutil.trim( localUtil.format( DecimalUtil.doubleToDec(AV43count), "Z,ZZZ,ZZZ,ZZ9")), 0);
         }
         if ( AV36Options.size() == 50 )
         {
            /* Exit For each command. Update data (if necessary), close cursors & exit. */
            if (true) break;
         }
         if ( ! brk3E8 )
         {
            brk3E8 = true ;
            pr_default.readNext(3);
         }
      }
      pr_default.close(3);
   }

   protected void cleanup( )
   {
      this.aP3[0] = petitoriowwgetfilterdata.this.AV37OptionsJson;
      this.aP4[0] = petitoriowwgetfilterdata.this.AV40OptionsDescJson;
      this.aP5[0] = petitoriowwgetfilterdata.this.AV42OptionIndexesJson;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV37OptionsJson = "" ;
      AV40OptionsDescJson = "" ;
      AV42OptionIndexesJson = "" ;
      AV36Options = new GXSimpleCollection<String>(String.class, "internal", "");
      AV39OptionsDesc = new GXSimpleCollection<String>(String.class, "internal", "");
      AV41OptionIndexes = new GXSimpleCollection<String>(String.class, "internal", "");
      GXv_boolean2 = new boolean[1] ;
      AV9WWPContext = new com.projectthani.wwpbaseobjects.SdtWWPContext(remoteHandle, context);
      GXv_SdtWWPContext3 = new com.projectthani.wwpbaseobjects.SdtWWPContext[1] ;
      AV44Session = httpContext.getWebSession();
      AV46GridState = new com.projectthani.wwpbaseobjects.SdtWWPGridState(remoteHandle, context);
      AV47GridStateFilterValue = new com.projectthani.wwpbaseobjects.SdtWWPGridState_FilterValue(remoteHandle, context);
      AV49FilterFullText = "" ;
      AV15TFPetitorioPrincipioActivo = "" ;
      AV16TFPetitorioPrincipioActivo_Sel = "" ;
      AV17TFPetitorioProducto = "" ;
      AV18TFPetitorioProducto_Sel = "" ;
      AV23TFPetitorioConcentracion = "" ;
      AV24TFPetitorioConcentracion_Sel = "" ;
      AV27TFPetitorioPresentacion = "" ;
      AV28TFPetitorioPresentacion_Sel = "" ;
      AV29TFPetitorioPrecio = DecimalUtil.ZERO ;
      AV30TFPetitorioPrecio_To = DecimalUtil.ZERO ;
      A262PetitorioPrincipioActivo = "" ;
      AV54Petitoriowwds_1_filterfulltext = "" ;
      AV59Petitoriowwds_6_tfpetitorioprincipioactivo = "" ;
      AV60Petitoriowwds_7_tfpetitorioprincipioactivo_sel = "" ;
      AV61Petitoriowwds_8_tfpetitorioproducto = "" ;
      AV62Petitoriowwds_9_tfpetitorioproducto_sel = "" ;
      AV67Petitoriowwds_14_tfpetitorioconcentracion = "" ;
      AV68Petitoriowwds_15_tfpetitorioconcentracion_sel = "" ;
      AV71Petitoriowwds_18_tfpetitoriopresentacion = "" ;
      AV72Petitoriowwds_19_tfpetitoriopresentacion_sel = "" ;
      AV73Petitoriowwds_20_tfpetitorioprecio = DecimalUtil.ZERO ;
      AV74Petitoriowwds_21_tfpetitorioprecio_to = DecimalUtil.ZERO ;
      scmdbuf = "" ;
      lV54Petitoriowwds_1_filterfulltext = "" ;
      lV59Petitoriowwds_6_tfpetitorioprincipioactivo = "" ;
      lV61Petitoriowwds_8_tfpetitorioproducto = "" ;
      lV67Petitoriowwds_14_tfpetitorioconcentracion = "" ;
      lV71Petitoriowwds_18_tfpetitoriopresentacion = "" ;
      A263PetitorioProducto = "" ;
      A260PetitorioConcentracion = "" ;
      A261PetitorioPresentacion = "" ;
      A264PetitorioPrecio = DecimalUtil.ZERO ;
      P003E2_A262PetitorioPrincipioActivo = new String[] {""} ;
      P003E2_A264PetitorioPrecio = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      P003E2_A39FormaFarmaceuticaId = new short[1] ;
      P003E2_A48PetitorioSubCategId = new short[1] ;
      P003E2_A49PetitorioCategId = new short[1] ;
      P003E2_A36DrogueriaId = new short[1] ;
      P003E2_A25PetitorioId = new short[1] ;
      P003E2_A261PetitorioPresentacion = new String[] {""} ;
      P003E2_A260PetitorioConcentracion = new String[] {""} ;
      P003E2_A263PetitorioProducto = new String[] {""} ;
      AV35Option = "" ;
      P003E3_A263PetitorioProducto = new String[] {""} ;
      P003E3_A264PetitorioPrecio = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      P003E3_A39FormaFarmaceuticaId = new short[1] ;
      P003E3_A48PetitorioSubCategId = new short[1] ;
      P003E3_A49PetitorioCategId = new short[1] ;
      P003E3_A36DrogueriaId = new short[1] ;
      P003E3_A25PetitorioId = new short[1] ;
      P003E3_A261PetitorioPresentacion = new String[] {""} ;
      P003E3_A260PetitorioConcentracion = new String[] {""} ;
      P003E3_A262PetitorioPrincipioActivo = new String[] {""} ;
      P003E4_A260PetitorioConcentracion = new String[] {""} ;
      P003E4_A264PetitorioPrecio = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      P003E4_A39FormaFarmaceuticaId = new short[1] ;
      P003E4_A48PetitorioSubCategId = new short[1] ;
      P003E4_A49PetitorioCategId = new short[1] ;
      P003E4_A36DrogueriaId = new short[1] ;
      P003E4_A25PetitorioId = new short[1] ;
      P003E4_A261PetitorioPresentacion = new String[] {""} ;
      P003E4_A263PetitorioProducto = new String[] {""} ;
      P003E4_A262PetitorioPrincipioActivo = new String[] {""} ;
      P003E5_A261PetitorioPresentacion = new String[] {""} ;
      P003E5_A264PetitorioPrecio = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      P003E5_A39FormaFarmaceuticaId = new short[1] ;
      P003E5_A48PetitorioSubCategId = new short[1] ;
      P003E5_A49PetitorioCategId = new short[1] ;
      P003E5_A36DrogueriaId = new short[1] ;
      P003E5_A25PetitorioId = new short[1] ;
      P003E5_A260PetitorioConcentracion = new String[] {""} ;
      P003E5_A263PetitorioProducto = new String[] {""} ;
      P003E5_A262PetitorioPrincipioActivo = new String[] {""} ;
      pr_default = new DataStoreProvider(context, remoteHandle, new com.projectthani.petitoriowwgetfilterdata__default(),
         new Object[] {
             new Object[] {
            P003E2_A262PetitorioPrincipioActivo, P003E2_A264PetitorioPrecio, P003E2_A39FormaFarmaceuticaId, P003E2_A48PetitorioSubCategId, P003E2_A49PetitorioCategId, P003E2_A36DrogueriaId, P003E2_A25PetitorioId, P003E2_A261PetitorioPresentacion, P003E2_A260PetitorioConcentracion, P003E2_A263PetitorioProducto
            }
            , new Object[] {
            P003E3_A263PetitorioProducto, P003E3_A264PetitorioPrecio, P003E3_A39FormaFarmaceuticaId, P003E3_A48PetitorioSubCategId, P003E3_A49PetitorioCategId, P003E3_A36DrogueriaId, P003E3_A25PetitorioId, P003E3_A261PetitorioPresentacion, P003E3_A260PetitorioConcentracion, P003E3_A262PetitorioPrincipioActivo
            }
            , new Object[] {
            P003E4_A260PetitorioConcentracion, P003E4_A264PetitorioPrecio, P003E4_A39FormaFarmaceuticaId, P003E4_A48PetitorioSubCategId, P003E4_A49PetitorioCategId, P003E4_A36DrogueriaId, P003E4_A25PetitorioId, P003E4_A261PetitorioPresentacion, P003E4_A263PetitorioProducto, P003E4_A262PetitorioPrincipioActivo
            }
            , new Object[] {
            P003E5_A261PetitorioPresentacion, P003E5_A264PetitorioPrecio, P003E5_A39FormaFarmaceuticaId, P003E5_A48PetitorioSubCategId, P003E5_A49PetitorioCategId, P003E5_A36DrogueriaId, P003E5_A25PetitorioId, P003E5_A260PetitorioConcentracion, P003E5_A263PetitorioProducto, P003E5_A262PetitorioPrincipioActivo
            }
         }
      );
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private short AV11TFPetitorioId ;
   private short AV12TFPetitorioId_To ;
   private short AV13TFDrogueriaId ;
   private short AV14TFDrogueriaId_To ;
   private short AV19TFPetitorioCategId ;
   private short AV20TFPetitorioCategId_To ;
   private short AV21TFPetitorioSubCategId ;
   private short AV22TFPetitorioSubCategId_To ;
   private short AV25TFFormaFarmaceuticaId ;
   private short AV26TFFormaFarmaceuticaId_To ;
   private short AV55Petitoriowwds_2_tfpetitorioid ;
   private short AV56Petitoriowwds_3_tfpetitorioid_to ;
   private short AV57Petitoriowwds_4_tfdrogueriaid ;
   private short AV58Petitoriowwds_5_tfdrogueriaid_to ;
   private short AV63Petitoriowwds_10_tfpetitoriocategid ;
   private short AV64Petitoriowwds_11_tfpetitoriocategid_to ;
   private short AV65Petitoriowwds_12_tfpetitoriosubcategid ;
   private short AV66Petitoriowwds_13_tfpetitoriosubcategid_to ;
   private short AV69Petitoriowwds_16_tfformafarmaceuticaid ;
   private short AV70Petitoriowwds_17_tfformafarmaceuticaid_to ;
   private short A25PetitorioId ;
   private short A36DrogueriaId ;
   private short A49PetitorioCategId ;
   private short A48PetitorioSubCategId ;
   private short A39FormaFarmaceuticaId ;
   private short Gx_err ;
   private int AV52GXV1 ;
   private long AV43count ;
   private java.math.BigDecimal AV29TFPetitorioPrecio ;
   private java.math.BigDecimal AV30TFPetitorioPrecio_To ;
   private java.math.BigDecimal AV73Petitoriowwds_20_tfpetitorioprecio ;
   private java.math.BigDecimal AV74Petitoriowwds_21_tfpetitorioprecio_to ;
   private java.math.BigDecimal A264PetitorioPrecio ;
   private String scmdbuf ;
   private boolean AV8IsAuthorized ;
   private boolean GXt_boolean1 ;
   private boolean GXv_boolean2[] ;
   private boolean returnInSub ;
   private boolean brk3E2 ;
   private boolean brk3E4 ;
   private boolean brk3E6 ;
   private boolean brk3E8 ;
   private String AV37OptionsJson ;
   private String AV40OptionsDescJson ;
   private String AV42OptionIndexesJson ;
   private String AV33DDOName ;
   private String AV31SearchTxt ;
   private String AV32SearchTxtTo ;
   private String AV49FilterFullText ;
   private String AV15TFPetitorioPrincipioActivo ;
   private String AV16TFPetitorioPrincipioActivo_Sel ;
   private String AV17TFPetitorioProducto ;
   private String AV18TFPetitorioProducto_Sel ;
   private String AV23TFPetitorioConcentracion ;
   private String AV24TFPetitorioConcentracion_Sel ;
   private String AV27TFPetitorioPresentacion ;
   private String AV28TFPetitorioPresentacion_Sel ;
   private String A262PetitorioPrincipioActivo ;
   private String AV54Petitoriowwds_1_filterfulltext ;
   private String AV59Petitoriowwds_6_tfpetitorioprincipioactivo ;
   private String AV60Petitoriowwds_7_tfpetitorioprincipioactivo_sel ;
   private String AV61Petitoriowwds_8_tfpetitorioproducto ;
   private String AV62Petitoriowwds_9_tfpetitorioproducto_sel ;
   private String AV67Petitoriowwds_14_tfpetitorioconcentracion ;
   private String AV68Petitoriowwds_15_tfpetitorioconcentracion_sel ;
   private String AV71Petitoriowwds_18_tfpetitoriopresentacion ;
   private String AV72Petitoriowwds_19_tfpetitoriopresentacion_sel ;
   private String lV54Petitoriowwds_1_filterfulltext ;
   private String lV59Petitoriowwds_6_tfpetitorioprincipioactivo ;
   private String lV61Petitoriowwds_8_tfpetitorioproducto ;
   private String lV67Petitoriowwds_14_tfpetitorioconcentracion ;
   private String lV71Petitoriowwds_18_tfpetitoriopresentacion ;
   private String A263PetitorioProducto ;
   private String A260PetitorioConcentracion ;
   private String A261PetitorioPresentacion ;
   private String AV35Option ;
   private com.genexus.webpanels.WebSession AV44Session ;
   private String[] aP5 ;
   private String[] aP3 ;
   private String[] aP4 ;
   private IDataStoreProvider pr_default ;
   private String[] P003E2_A262PetitorioPrincipioActivo ;
   private java.math.BigDecimal[] P003E2_A264PetitorioPrecio ;
   private short[] P003E2_A39FormaFarmaceuticaId ;
   private short[] P003E2_A48PetitorioSubCategId ;
   private short[] P003E2_A49PetitorioCategId ;
   private short[] P003E2_A36DrogueriaId ;
   private short[] P003E2_A25PetitorioId ;
   private String[] P003E2_A261PetitorioPresentacion ;
   private String[] P003E2_A260PetitorioConcentracion ;
   private String[] P003E2_A263PetitorioProducto ;
   private String[] P003E3_A263PetitorioProducto ;
   private java.math.BigDecimal[] P003E3_A264PetitorioPrecio ;
   private short[] P003E3_A39FormaFarmaceuticaId ;
   private short[] P003E3_A48PetitorioSubCategId ;
   private short[] P003E3_A49PetitorioCategId ;
   private short[] P003E3_A36DrogueriaId ;
   private short[] P003E3_A25PetitorioId ;
   private String[] P003E3_A261PetitorioPresentacion ;
   private String[] P003E3_A260PetitorioConcentracion ;
   private String[] P003E3_A262PetitorioPrincipioActivo ;
   private String[] P003E4_A260PetitorioConcentracion ;
   private java.math.BigDecimal[] P003E4_A264PetitorioPrecio ;
   private short[] P003E4_A39FormaFarmaceuticaId ;
   private short[] P003E4_A48PetitorioSubCategId ;
   private short[] P003E4_A49PetitorioCategId ;
   private short[] P003E4_A36DrogueriaId ;
   private short[] P003E4_A25PetitorioId ;
   private String[] P003E4_A261PetitorioPresentacion ;
   private String[] P003E4_A263PetitorioProducto ;
   private String[] P003E4_A262PetitorioPrincipioActivo ;
   private String[] P003E5_A261PetitorioPresentacion ;
   private java.math.BigDecimal[] P003E5_A264PetitorioPrecio ;
   private short[] P003E5_A39FormaFarmaceuticaId ;
   private short[] P003E5_A48PetitorioSubCategId ;
   private short[] P003E5_A49PetitorioCategId ;
   private short[] P003E5_A36DrogueriaId ;
   private short[] P003E5_A25PetitorioId ;
   private String[] P003E5_A260PetitorioConcentracion ;
   private String[] P003E5_A263PetitorioProducto ;
   private String[] P003E5_A262PetitorioPrincipioActivo ;
   private GXSimpleCollection<String> AV36Options ;
   private GXSimpleCollection<String> AV39OptionsDesc ;
   private GXSimpleCollection<String> AV41OptionIndexes ;
   private com.projectthani.wwpbaseobjects.SdtWWPContext AV9WWPContext ;
   private com.projectthani.wwpbaseobjects.SdtWWPContext GXv_SdtWWPContext3[] ;
   private com.projectthani.wwpbaseobjects.SdtWWPGridState AV46GridState ;
   private com.projectthani.wwpbaseobjects.SdtWWPGridState_FilterValue AV47GridStateFilterValue ;
}

final  class petitoriowwgetfilterdata__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   protected Object[] conditional_P003E2( ModelContext context ,
                                          int remoteHandle ,
                                          com.genexus.IHttpContext httpContext ,
                                          String AV54Petitoriowwds_1_filterfulltext ,
                                          short AV55Petitoriowwds_2_tfpetitorioid ,
                                          short AV56Petitoriowwds_3_tfpetitorioid_to ,
                                          short AV57Petitoriowwds_4_tfdrogueriaid ,
                                          short AV58Petitoriowwds_5_tfdrogueriaid_to ,
                                          String AV60Petitoriowwds_7_tfpetitorioprincipioactivo_sel ,
                                          String AV59Petitoriowwds_6_tfpetitorioprincipioactivo ,
                                          String AV62Petitoriowwds_9_tfpetitorioproducto_sel ,
                                          String AV61Petitoriowwds_8_tfpetitorioproducto ,
                                          short AV63Petitoriowwds_10_tfpetitoriocategid ,
                                          short AV64Petitoriowwds_11_tfpetitoriocategid_to ,
                                          short AV65Petitoriowwds_12_tfpetitoriosubcategid ,
                                          short AV66Petitoriowwds_13_tfpetitoriosubcategid_to ,
                                          String AV68Petitoriowwds_15_tfpetitorioconcentracion_sel ,
                                          String AV67Petitoriowwds_14_tfpetitorioconcentracion ,
                                          short AV69Petitoriowwds_16_tfformafarmaceuticaid ,
                                          short AV70Petitoriowwds_17_tfformafarmaceuticaid_to ,
                                          String AV72Petitoriowwds_19_tfpetitoriopresentacion_sel ,
                                          String AV71Petitoriowwds_18_tfpetitoriopresentacion ,
                                          java.math.BigDecimal AV73Petitoriowwds_20_tfpetitorioprecio ,
                                          java.math.BigDecimal AV74Petitoriowwds_21_tfpetitorioprecio_to ,
                                          short A25PetitorioId ,
                                          short A36DrogueriaId ,
                                          String A262PetitorioPrincipioActivo ,
                                          String A263PetitorioProducto ,
                                          short A49PetitorioCategId ,
                                          short A48PetitorioSubCategId ,
                                          String A260PetitorioConcentracion ,
                                          short A39FormaFarmaceuticaId ,
                                          String A261PetitorioPresentacion ,
                                          java.math.BigDecimal A264PetitorioPrecio )
   {
      java.lang.StringBuffer sWhereString = new java.lang.StringBuffer();
      String scmdbuf;
      byte[] GXv_int4 = new byte[30];
      Object[] GXv_Object5 = new Object[2];
      scmdbuf = "SELECT T1.[PetitorioPrincipioActivo], T1.[PetitorioPrecio], T1.[FormaFarmaceuticaId], T1.[PetitorioSubCategId], T2.[PetitorioCategId], T1.[DrogueriaId], T1.[PetitorioId]," ;
      scmdbuf += " T1.[PetitorioPresentacion], T1.[PetitorioConcentracion], T1.[PetitorioProducto] FROM ([Petitorio] T1 INNER JOIN [PetitorioSubCateg] T2 ON T2.[PetitorioSubCategId]" ;
      scmdbuf += " = T1.[PetitorioSubCategId])" ;
      if ( ! (GXutil.strcmp("", AV54Petitoriowwds_1_filterfulltext)==0) )
      {
         addWhere(sWhereString, "(( CONVERT( char(4), CAST(T1.[PetitorioId] AS decimal(4,0))) like '%' + ?) or ( CONVERT( char(4), CAST(T1.[DrogueriaId] AS decimal(4,0))) like '%' + ?) or ( T1.[PetitorioPrincipioActivo] like '%' + ?) or ( T1.[PetitorioProducto] like '%' + ?) or ( CONVERT( char(4), CAST(T2.[PetitorioCategId] AS decimal(4,0))) like '%' + ?) or ( CONVERT( char(4), CAST(T1.[PetitorioSubCategId] AS decimal(4,0))) like '%' + ?) or ( T1.[PetitorioConcentracion] like '%' + ?) or ( CONVERT( char(4), CAST(T1.[FormaFarmaceuticaId] AS decimal(4,0))) like '%' + ?) or ( T1.[PetitorioPresentacion] like '%' + ?) or ( CONVERT( char(7), CAST(T1.[PetitorioPrecio] AS decimal(7,2))) like '%' + ?))");
      }
      else
      {
         GXv_int4[0] = (byte)(1) ;
         GXv_int4[1] = (byte)(1) ;
         GXv_int4[2] = (byte)(1) ;
         GXv_int4[3] = (byte)(1) ;
         GXv_int4[4] = (byte)(1) ;
         GXv_int4[5] = (byte)(1) ;
         GXv_int4[6] = (byte)(1) ;
         GXv_int4[7] = (byte)(1) ;
         GXv_int4[8] = (byte)(1) ;
         GXv_int4[9] = (byte)(1) ;
      }
      if ( ! (0==AV55Petitoriowwds_2_tfpetitorioid) )
      {
         addWhere(sWhereString, "(T1.[PetitorioId] >= ?)");
      }
      else
      {
         GXv_int4[10] = (byte)(1) ;
      }
      if ( ! (0==AV56Petitoriowwds_3_tfpetitorioid_to) )
      {
         addWhere(sWhereString, "(T1.[PetitorioId] <= ?)");
      }
      else
      {
         GXv_int4[11] = (byte)(1) ;
      }
      if ( ! (0==AV57Petitoriowwds_4_tfdrogueriaid) )
      {
         addWhere(sWhereString, "(T1.[DrogueriaId] >= ?)");
      }
      else
      {
         GXv_int4[12] = (byte)(1) ;
      }
      if ( ! (0==AV58Petitoriowwds_5_tfdrogueriaid_to) )
      {
         addWhere(sWhereString, "(T1.[DrogueriaId] <= ?)");
      }
      else
      {
         GXv_int4[13] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV60Petitoriowwds_7_tfpetitorioprincipioactivo_sel)==0) && ( ! (GXutil.strcmp("", AV59Petitoriowwds_6_tfpetitorioprincipioactivo)==0) ) )
      {
         addWhere(sWhereString, "(T1.[PetitorioPrincipioActivo] like ?)");
      }
      else
      {
         GXv_int4[14] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV60Petitoriowwds_7_tfpetitorioprincipioactivo_sel)==0) )
      {
         addWhere(sWhereString, "(T1.[PetitorioPrincipioActivo] = ?)");
      }
      else
      {
         GXv_int4[15] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV62Petitoriowwds_9_tfpetitorioproducto_sel)==0) && ( ! (GXutil.strcmp("", AV61Petitoriowwds_8_tfpetitorioproducto)==0) ) )
      {
         addWhere(sWhereString, "(T1.[PetitorioProducto] like ?)");
      }
      else
      {
         GXv_int4[16] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV62Petitoriowwds_9_tfpetitorioproducto_sel)==0) )
      {
         addWhere(sWhereString, "(T1.[PetitorioProducto] = ?)");
      }
      else
      {
         GXv_int4[17] = (byte)(1) ;
      }
      if ( ! (0==AV63Petitoriowwds_10_tfpetitoriocategid) )
      {
         addWhere(sWhereString, "(T2.[PetitorioCategId] >= ?)");
      }
      else
      {
         GXv_int4[18] = (byte)(1) ;
      }
      if ( ! (0==AV64Petitoriowwds_11_tfpetitoriocategid_to) )
      {
         addWhere(sWhereString, "(T2.[PetitorioCategId] <= ?)");
      }
      else
      {
         GXv_int4[19] = (byte)(1) ;
      }
      if ( ! (0==AV65Petitoriowwds_12_tfpetitoriosubcategid) )
      {
         addWhere(sWhereString, "(T1.[PetitorioSubCategId] >= ?)");
      }
      else
      {
         GXv_int4[20] = (byte)(1) ;
      }
      if ( ! (0==AV66Petitoriowwds_13_tfpetitoriosubcategid_to) )
      {
         addWhere(sWhereString, "(T1.[PetitorioSubCategId] <= ?)");
      }
      else
      {
         GXv_int4[21] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV68Petitoriowwds_15_tfpetitorioconcentracion_sel)==0) && ( ! (GXutil.strcmp("", AV67Petitoriowwds_14_tfpetitorioconcentracion)==0) ) )
      {
         addWhere(sWhereString, "(T1.[PetitorioConcentracion] like ?)");
      }
      else
      {
         GXv_int4[22] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV68Petitoriowwds_15_tfpetitorioconcentracion_sel)==0) )
      {
         addWhere(sWhereString, "(T1.[PetitorioConcentracion] = ?)");
      }
      else
      {
         GXv_int4[23] = (byte)(1) ;
      }
      if ( ! (0==AV69Petitoriowwds_16_tfformafarmaceuticaid) )
      {
         addWhere(sWhereString, "(T1.[FormaFarmaceuticaId] >= ?)");
      }
      else
      {
         GXv_int4[24] = (byte)(1) ;
      }
      if ( ! (0==AV70Petitoriowwds_17_tfformafarmaceuticaid_to) )
      {
         addWhere(sWhereString, "(T1.[FormaFarmaceuticaId] <= ?)");
      }
      else
      {
         GXv_int4[25] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV72Petitoriowwds_19_tfpetitoriopresentacion_sel)==0) && ( ! (GXutil.strcmp("", AV71Petitoriowwds_18_tfpetitoriopresentacion)==0) ) )
      {
         addWhere(sWhereString, "(T1.[PetitorioPresentacion] like ?)");
      }
      else
      {
         GXv_int4[26] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV72Petitoriowwds_19_tfpetitoriopresentacion_sel)==0) )
      {
         addWhere(sWhereString, "(T1.[PetitorioPresentacion] = ?)");
      }
      else
      {
         GXv_int4[27] = (byte)(1) ;
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV73Petitoriowwds_20_tfpetitorioprecio)==0) )
      {
         addWhere(sWhereString, "(T1.[PetitorioPrecio] >= ?)");
      }
      else
      {
         GXv_int4[28] = (byte)(1) ;
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV74Petitoriowwds_21_tfpetitorioprecio_to)==0) )
      {
         addWhere(sWhereString, "(T1.[PetitorioPrecio] <= ?)");
      }
      else
      {
         GXv_int4[29] = (byte)(1) ;
      }
      scmdbuf += sWhereString ;
      scmdbuf += " ORDER BY T1.[PetitorioPrincipioActivo]" ;
      GXv_Object5[0] = scmdbuf ;
      GXv_Object5[1] = GXv_int4 ;
      return GXv_Object5 ;
   }

   protected Object[] conditional_P003E3( ModelContext context ,
                                          int remoteHandle ,
                                          com.genexus.IHttpContext httpContext ,
                                          String AV54Petitoriowwds_1_filterfulltext ,
                                          short AV55Petitoriowwds_2_tfpetitorioid ,
                                          short AV56Petitoriowwds_3_tfpetitorioid_to ,
                                          short AV57Petitoriowwds_4_tfdrogueriaid ,
                                          short AV58Petitoriowwds_5_tfdrogueriaid_to ,
                                          String AV60Petitoriowwds_7_tfpetitorioprincipioactivo_sel ,
                                          String AV59Petitoriowwds_6_tfpetitorioprincipioactivo ,
                                          String AV62Petitoriowwds_9_tfpetitorioproducto_sel ,
                                          String AV61Petitoriowwds_8_tfpetitorioproducto ,
                                          short AV63Petitoriowwds_10_tfpetitoriocategid ,
                                          short AV64Petitoriowwds_11_tfpetitoriocategid_to ,
                                          short AV65Petitoriowwds_12_tfpetitoriosubcategid ,
                                          short AV66Petitoriowwds_13_tfpetitoriosubcategid_to ,
                                          String AV68Petitoriowwds_15_tfpetitorioconcentracion_sel ,
                                          String AV67Petitoriowwds_14_tfpetitorioconcentracion ,
                                          short AV69Petitoriowwds_16_tfformafarmaceuticaid ,
                                          short AV70Petitoriowwds_17_tfformafarmaceuticaid_to ,
                                          String AV72Petitoriowwds_19_tfpetitoriopresentacion_sel ,
                                          String AV71Petitoriowwds_18_tfpetitoriopresentacion ,
                                          java.math.BigDecimal AV73Petitoriowwds_20_tfpetitorioprecio ,
                                          java.math.BigDecimal AV74Petitoriowwds_21_tfpetitorioprecio_to ,
                                          short A25PetitorioId ,
                                          short A36DrogueriaId ,
                                          String A262PetitorioPrincipioActivo ,
                                          String A263PetitorioProducto ,
                                          short A49PetitorioCategId ,
                                          short A48PetitorioSubCategId ,
                                          String A260PetitorioConcentracion ,
                                          short A39FormaFarmaceuticaId ,
                                          String A261PetitorioPresentacion ,
                                          java.math.BigDecimal A264PetitorioPrecio )
   {
      java.lang.StringBuffer sWhereString = new java.lang.StringBuffer();
      String scmdbuf;
      byte[] GXv_int6 = new byte[30];
      Object[] GXv_Object7 = new Object[2];
      scmdbuf = "SELECT T1.[PetitorioProducto], T1.[PetitorioPrecio], T1.[FormaFarmaceuticaId], T1.[PetitorioSubCategId], T2.[PetitorioCategId], T1.[DrogueriaId], T1.[PetitorioId]," ;
      scmdbuf += " T1.[PetitorioPresentacion], T1.[PetitorioConcentracion], T1.[PetitorioPrincipioActivo] FROM ([Petitorio] T1 INNER JOIN [PetitorioSubCateg] T2 ON T2.[PetitorioSubCategId]" ;
      scmdbuf += " = T1.[PetitorioSubCategId])" ;
      if ( ! (GXutil.strcmp("", AV54Petitoriowwds_1_filterfulltext)==0) )
      {
         addWhere(sWhereString, "(( CONVERT( char(4), CAST(T1.[PetitorioId] AS decimal(4,0))) like '%' + ?) or ( CONVERT( char(4), CAST(T1.[DrogueriaId] AS decimal(4,0))) like '%' + ?) or ( T1.[PetitorioPrincipioActivo] like '%' + ?) or ( T1.[PetitorioProducto] like '%' + ?) or ( CONVERT( char(4), CAST(T2.[PetitorioCategId] AS decimal(4,0))) like '%' + ?) or ( CONVERT( char(4), CAST(T1.[PetitorioSubCategId] AS decimal(4,0))) like '%' + ?) or ( T1.[PetitorioConcentracion] like '%' + ?) or ( CONVERT( char(4), CAST(T1.[FormaFarmaceuticaId] AS decimal(4,0))) like '%' + ?) or ( T1.[PetitorioPresentacion] like '%' + ?) or ( CONVERT( char(7), CAST(T1.[PetitorioPrecio] AS decimal(7,2))) like '%' + ?))");
      }
      else
      {
         GXv_int6[0] = (byte)(1) ;
         GXv_int6[1] = (byte)(1) ;
         GXv_int6[2] = (byte)(1) ;
         GXv_int6[3] = (byte)(1) ;
         GXv_int6[4] = (byte)(1) ;
         GXv_int6[5] = (byte)(1) ;
         GXv_int6[6] = (byte)(1) ;
         GXv_int6[7] = (byte)(1) ;
         GXv_int6[8] = (byte)(1) ;
         GXv_int6[9] = (byte)(1) ;
      }
      if ( ! (0==AV55Petitoriowwds_2_tfpetitorioid) )
      {
         addWhere(sWhereString, "(T1.[PetitorioId] >= ?)");
      }
      else
      {
         GXv_int6[10] = (byte)(1) ;
      }
      if ( ! (0==AV56Petitoriowwds_3_tfpetitorioid_to) )
      {
         addWhere(sWhereString, "(T1.[PetitorioId] <= ?)");
      }
      else
      {
         GXv_int6[11] = (byte)(1) ;
      }
      if ( ! (0==AV57Petitoriowwds_4_tfdrogueriaid) )
      {
         addWhere(sWhereString, "(T1.[DrogueriaId] >= ?)");
      }
      else
      {
         GXv_int6[12] = (byte)(1) ;
      }
      if ( ! (0==AV58Petitoriowwds_5_tfdrogueriaid_to) )
      {
         addWhere(sWhereString, "(T1.[DrogueriaId] <= ?)");
      }
      else
      {
         GXv_int6[13] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV60Petitoriowwds_7_tfpetitorioprincipioactivo_sel)==0) && ( ! (GXutil.strcmp("", AV59Petitoriowwds_6_tfpetitorioprincipioactivo)==0) ) )
      {
         addWhere(sWhereString, "(T1.[PetitorioPrincipioActivo] like ?)");
      }
      else
      {
         GXv_int6[14] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV60Petitoriowwds_7_tfpetitorioprincipioactivo_sel)==0) )
      {
         addWhere(sWhereString, "(T1.[PetitorioPrincipioActivo] = ?)");
      }
      else
      {
         GXv_int6[15] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV62Petitoriowwds_9_tfpetitorioproducto_sel)==0) && ( ! (GXutil.strcmp("", AV61Petitoriowwds_8_tfpetitorioproducto)==0) ) )
      {
         addWhere(sWhereString, "(T1.[PetitorioProducto] like ?)");
      }
      else
      {
         GXv_int6[16] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV62Petitoriowwds_9_tfpetitorioproducto_sel)==0) )
      {
         addWhere(sWhereString, "(T1.[PetitorioProducto] = ?)");
      }
      else
      {
         GXv_int6[17] = (byte)(1) ;
      }
      if ( ! (0==AV63Petitoriowwds_10_tfpetitoriocategid) )
      {
         addWhere(sWhereString, "(T2.[PetitorioCategId] >= ?)");
      }
      else
      {
         GXv_int6[18] = (byte)(1) ;
      }
      if ( ! (0==AV64Petitoriowwds_11_tfpetitoriocategid_to) )
      {
         addWhere(sWhereString, "(T2.[PetitorioCategId] <= ?)");
      }
      else
      {
         GXv_int6[19] = (byte)(1) ;
      }
      if ( ! (0==AV65Petitoriowwds_12_tfpetitoriosubcategid) )
      {
         addWhere(sWhereString, "(T1.[PetitorioSubCategId] >= ?)");
      }
      else
      {
         GXv_int6[20] = (byte)(1) ;
      }
      if ( ! (0==AV66Petitoriowwds_13_tfpetitoriosubcategid_to) )
      {
         addWhere(sWhereString, "(T1.[PetitorioSubCategId] <= ?)");
      }
      else
      {
         GXv_int6[21] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV68Petitoriowwds_15_tfpetitorioconcentracion_sel)==0) && ( ! (GXutil.strcmp("", AV67Petitoriowwds_14_tfpetitorioconcentracion)==0) ) )
      {
         addWhere(sWhereString, "(T1.[PetitorioConcentracion] like ?)");
      }
      else
      {
         GXv_int6[22] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV68Petitoriowwds_15_tfpetitorioconcentracion_sel)==0) )
      {
         addWhere(sWhereString, "(T1.[PetitorioConcentracion] = ?)");
      }
      else
      {
         GXv_int6[23] = (byte)(1) ;
      }
      if ( ! (0==AV69Petitoriowwds_16_tfformafarmaceuticaid) )
      {
         addWhere(sWhereString, "(T1.[FormaFarmaceuticaId] >= ?)");
      }
      else
      {
         GXv_int6[24] = (byte)(1) ;
      }
      if ( ! (0==AV70Petitoriowwds_17_tfformafarmaceuticaid_to) )
      {
         addWhere(sWhereString, "(T1.[FormaFarmaceuticaId] <= ?)");
      }
      else
      {
         GXv_int6[25] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV72Petitoriowwds_19_tfpetitoriopresentacion_sel)==0) && ( ! (GXutil.strcmp("", AV71Petitoriowwds_18_tfpetitoriopresentacion)==0) ) )
      {
         addWhere(sWhereString, "(T1.[PetitorioPresentacion] like ?)");
      }
      else
      {
         GXv_int6[26] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV72Petitoriowwds_19_tfpetitoriopresentacion_sel)==0) )
      {
         addWhere(sWhereString, "(T1.[PetitorioPresentacion] = ?)");
      }
      else
      {
         GXv_int6[27] = (byte)(1) ;
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV73Petitoriowwds_20_tfpetitorioprecio)==0) )
      {
         addWhere(sWhereString, "(T1.[PetitorioPrecio] >= ?)");
      }
      else
      {
         GXv_int6[28] = (byte)(1) ;
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV74Petitoriowwds_21_tfpetitorioprecio_to)==0) )
      {
         addWhere(sWhereString, "(T1.[PetitorioPrecio] <= ?)");
      }
      else
      {
         GXv_int6[29] = (byte)(1) ;
      }
      scmdbuf += sWhereString ;
      scmdbuf += " ORDER BY T1.[PetitorioProducto]" ;
      GXv_Object7[0] = scmdbuf ;
      GXv_Object7[1] = GXv_int6 ;
      return GXv_Object7 ;
   }

   protected Object[] conditional_P003E4( ModelContext context ,
                                          int remoteHandle ,
                                          com.genexus.IHttpContext httpContext ,
                                          String AV54Petitoriowwds_1_filterfulltext ,
                                          short AV55Petitoriowwds_2_tfpetitorioid ,
                                          short AV56Petitoriowwds_3_tfpetitorioid_to ,
                                          short AV57Petitoriowwds_4_tfdrogueriaid ,
                                          short AV58Petitoriowwds_5_tfdrogueriaid_to ,
                                          String AV60Petitoriowwds_7_tfpetitorioprincipioactivo_sel ,
                                          String AV59Petitoriowwds_6_tfpetitorioprincipioactivo ,
                                          String AV62Petitoriowwds_9_tfpetitorioproducto_sel ,
                                          String AV61Petitoriowwds_8_tfpetitorioproducto ,
                                          short AV63Petitoriowwds_10_tfpetitoriocategid ,
                                          short AV64Petitoriowwds_11_tfpetitoriocategid_to ,
                                          short AV65Petitoriowwds_12_tfpetitoriosubcategid ,
                                          short AV66Petitoriowwds_13_tfpetitoriosubcategid_to ,
                                          String AV68Petitoriowwds_15_tfpetitorioconcentracion_sel ,
                                          String AV67Petitoriowwds_14_tfpetitorioconcentracion ,
                                          short AV69Petitoriowwds_16_tfformafarmaceuticaid ,
                                          short AV70Petitoriowwds_17_tfformafarmaceuticaid_to ,
                                          String AV72Petitoriowwds_19_tfpetitoriopresentacion_sel ,
                                          String AV71Petitoriowwds_18_tfpetitoriopresentacion ,
                                          java.math.BigDecimal AV73Petitoriowwds_20_tfpetitorioprecio ,
                                          java.math.BigDecimal AV74Petitoriowwds_21_tfpetitorioprecio_to ,
                                          short A25PetitorioId ,
                                          short A36DrogueriaId ,
                                          String A262PetitorioPrincipioActivo ,
                                          String A263PetitorioProducto ,
                                          short A49PetitorioCategId ,
                                          short A48PetitorioSubCategId ,
                                          String A260PetitorioConcentracion ,
                                          short A39FormaFarmaceuticaId ,
                                          String A261PetitorioPresentacion ,
                                          java.math.BigDecimal A264PetitorioPrecio )
   {
      java.lang.StringBuffer sWhereString = new java.lang.StringBuffer();
      String scmdbuf;
      byte[] GXv_int8 = new byte[30];
      Object[] GXv_Object9 = new Object[2];
      scmdbuf = "SELECT T1.[PetitorioConcentracion], T1.[PetitorioPrecio], T1.[FormaFarmaceuticaId], T1.[PetitorioSubCategId], T2.[PetitorioCategId], T1.[DrogueriaId], T1.[PetitorioId]," ;
      scmdbuf += " T1.[PetitorioPresentacion], T1.[PetitorioProducto], T1.[PetitorioPrincipioActivo] FROM ([Petitorio] T1 INNER JOIN [PetitorioSubCateg] T2 ON T2.[PetitorioSubCategId]" ;
      scmdbuf += " = T1.[PetitorioSubCategId])" ;
      if ( ! (GXutil.strcmp("", AV54Petitoriowwds_1_filterfulltext)==0) )
      {
         addWhere(sWhereString, "(( CONVERT( char(4), CAST(T1.[PetitorioId] AS decimal(4,0))) like '%' + ?) or ( CONVERT( char(4), CAST(T1.[DrogueriaId] AS decimal(4,0))) like '%' + ?) or ( T1.[PetitorioPrincipioActivo] like '%' + ?) or ( T1.[PetitorioProducto] like '%' + ?) or ( CONVERT( char(4), CAST(T2.[PetitorioCategId] AS decimal(4,0))) like '%' + ?) or ( CONVERT( char(4), CAST(T1.[PetitorioSubCategId] AS decimal(4,0))) like '%' + ?) or ( T1.[PetitorioConcentracion] like '%' + ?) or ( CONVERT( char(4), CAST(T1.[FormaFarmaceuticaId] AS decimal(4,0))) like '%' + ?) or ( T1.[PetitorioPresentacion] like '%' + ?) or ( CONVERT( char(7), CAST(T1.[PetitorioPrecio] AS decimal(7,2))) like '%' + ?))");
      }
      else
      {
         GXv_int8[0] = (byte)(1) ;
         GXv_int8[1] = (byte)(1) ;
         GXv_int8[2] = (byte)(1) ;
         GXv_int8[3] = (byte)(1) ;
         GXv_int8[4] = (byte)(1) ;
         GXv_int8[5] = (byte)(1) ;
         GXv_int8[6] = (byte)(1) ;
         GXv_int8[7] = (byte)(1) ;
         GXv_int8[8] = (byte)(1) ;
         GXv_int8[9] = (byte)(1) ;
      }
      if ( ! (0==AV55Petitoriowwds_2_tfpetitorioid) )
      {
         addWhere(sWhereString, "(T1.[PetitorioId] >= ?)");
      }
      else
      {
         GXv_int8[10] = (byte)(1) ;
      }
      if ( ! (0==AV56Petitoriowwds_3_tfpetitorioid_to) )
      {
         addWhere(sWhereString, "(T1.[PetitorioId] <= ?)");
      }
      else
      {
         GXv_int8[11] = (byte)(1) ;
      }
      if ( ! (0==AV57Petitoriowwds_4_tfdrogueriaid) )
      {
         addWhere(sWhereString, "(T1.[DrogueriaId] >= ?)");
      }
      else
      {
         GXv_int8[12] = (byte)(1) ;
      }
      if ( ! (0==AV58Petitoriowwds_5_tfdrogueriaid_to) )
      {
         addWhere(sWhereString, "(T1.[DrogueriaId] <= ?)");
      }
      else
      {
         GXv_int8[13] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV60Petitoriowwds_7_tfpetitorioprincipioactivo_sel)==0) && ( ! (GXutil.strcmp("", AV59Petitoriowwds_6_tfpetitorioprincipioactivo)==0) ) )
      {
         addWhere(sWhereString, "(T1.[PetitorioPrincipioActivo] like ?)");
      }
      else
      {
         GXv_int8[14] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV60Petitoriowwds_7_tfpetitorioprincipioactivo_sel)==0) )
      {
         addWhere(sWhereString, "(T1.[PetitorioPrincipioActivo] = ?)");
      }
      else
      {
         GXv_int8[15] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV62Petitoriowwds_9_tfpetitorioproducto_sel)==0) && ( ! (GXutil.strcmp("", AV61Petitoriowwds_8_tfpetitorioproducto)==0) ) )
      {
         addWhere(sWhereString, "(T1.[PetitorioProducto] like ?)");
      }
      else
      {
         GXv_int8[16] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV62Petitoriowwds_9_tfpetitorioproducto_sel)==0) )
      {
         addWhere(sWhereString, "(T1.[PetitorioProducto] = ?)");
      }
      else
      {
         GXv_int8[17] = (byte)(1) ;
      }
      if ( ! (0==AV63Petitoriowwds_10_tfpetitoriocategid) )
      {
         addWhere(sWhereString, "(T2.[PetitorioCategId] >= ?)");
      }
      else
      {
         GXv_int8[18] = (byte)(1) ;
      }
      if ( ! (0==AV64Petitoriowwds_11_tfpetitoriocategid_to) )
      {
         addWhere(sWhereString, "(T2.[PetitorioCategId] <= ?)");
      }
      else
      {
         GXv_int8[19] = (byte)(1) ;
      }
      if ( ! (0==AV65Petitoriowwds_12_tfpetitoriosubcategid) )
      {
         addWhere(sWhereString, "(T1.[PetitorioSubCategId] >= ?)");
      }
      else
      {
         GXv_int8[20] = (byte)(1) ;
      }
      if ( ! (0==AV66Petitoriowwds_13_tfpetitoriosubcategid_to) )
      {
         addWhere(sWhereString, "(T1.[PetitorioSubCategId] <= ?)");
      }
      else
      {
         GXv_int8[21] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV68Petitoriowwds_15_tfpetitorioconcentracion_sel)==0) && ( ! (GXutil.strcmp("", AV67Petitoriowwds_14_tfpetitorioconcentracion)==0) ) )
      {
         addWhere(sWhereString, "(T1.[PetitorioConcentracion] like ?)");
      }
      else
      {
         GXv_int8[22] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV68Petitoriowwds_15_tfpetitorioconcentracion_sel)==0) )
      {
         addWhere(sWhereString, "(T1.[PetitorioConcentracion] = ?)");
      }
      else
      {
         GXv_int8[23] = (byte)(1) ;
      }
      if ( ! (0==AV69Petitoriowwds_16_tfformafarmaceuticaid) )
      {
         addWhere(sWhereString, "(T1.[FormaFarmaceuticaId] >= ?)");
      }
      else
      {
         GXv_int8[24] = (byte)(1) ;
      }
      if ( ! (0==AV70Petitoriowwds_17_tfformafarmaceuticaid_to) )
      {
         addWhere(sWhereString, "(T1.[FormaFarmaceuticaId] <= ?)");
      }
      else
      {
         GXv_int8[25] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV72Petitoriowwds_19_tfpetitoriopresentacion_sel)==0) && ( ! (GXutil.strcmp("", AV71Petitoriowwds_18_tfpetitoriopresentacion)==0) ) )
      {
         addWhere(sWhereString, "(T1.[PetitorioPresentacion] like ?)");
      }
      else
      {
         GXv_int8[26] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV72Petitoriowwds_19_tfpetitoriopresentacion_sel)==0) )
      {
         addWhere(sWhereString, "(T1.[PetitorioPresentacion] = ?)");
      }
      else
      {
         GXv_int8[27] = (byte)(1) ;
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV73Petitoriowwds_20_tfpetitorioprecio)==0) )
      {
         addWhere(sWhereString, "(T1.[PetitorioPrecio] >= ?)");
      }
      else
      {
         GXv_int8[28] = (byte)(1) ;
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV74Petitoriowwds_21_tfpetitorioprecio_to)==0) )
      {
         addWhere(sWhereString, "(T1.[PetitorioPrecio] <= ?)");
      }
      else
      {
         GXv_int8[29] = (byte)(1) ;
      }
      scmdbuf += sWhereString ;
      scmdbuf += " ORDER BY T1.[PetitorioConcentracion]" ;
      GXv_Object9[0] = scmdbuf ;
      GXv_Object9[1] = GXv_int8 ;
      return GXv_Object9 ;
   }

   protected Object[] conditional_P003E5( ModelContext context ,
                                          int remoteHandle ,
                                          com.genexus.IHttpContext httpContext ,
                                          String AV54Petitoriowwds_1_filterfulltext ,
                                          short AV55Petitoriowwds_2_tfpetitorioid ,
                                          short AV56Petitoriowwds_3_tfpetitorioid_to ,
                                          short AV57Petitoriowwds_4_tfdrogueriaid ,
                                          short AV58Petitoriowwds_5_tfdrogueriaid_to ,
                                          String AV60Petitoriowwds_7_tfpetitorioprincipioactivo_sel ,
                                          String AV59Petitoriowwds_6_tfpetitorioprincipioactivo ,
                                          String AV62Petitoriowwds_9_tfpetitorioproducto_sel ,
                                          String AV61Petitoriowwds_8_tfpetitorioproducto ,
                                          short AV63Petitoriowwds_10_tfpetitoriocategid ,
                                          short AV64Petitoriowwds_11_tfpetitoriocategid_to ,
                                          short AV65Petitoriowwds_12_tfpetitoriosubcategid ,
                                          short AV66Petitoriowwds_13_tfpetitoriosubcategid_to ,
                                          String AV68Petitoriowwds_15_tfpetitorioconcentracion_sel ,
                                          String AV67Petitoriowwds_14_tfpetitorioconcentracion ,
                                          short AV69Petitoriowwds_16_tfformafarmaceuticaid ,
                                          short AV70Petitoriowwds_17_tfformafarmaceuticaid_to ,
                                          String AV72Petitoriowwds_19_tfpetitoriopresentacion_sel ,
                                          String AV71Petitoriowwds_18_tfpetitoriopresentacion ,
                                          java.math.BigDecimal AV73Petitoriowwds_20_tfpetitorioprecio ,
                                          java.math.BigDecimal AV74Petitoriowwds_21_tfpetitorioprecio_to ,
                                          short A25PetitorioId ,
                                          short A36DrogueriaId ,
                                          String A262PetitorioPrincipioActivo ,
                                          String A263PetitorioProducto ,
                                          short A49PetitorioCategId ,
                                          short A48PetitorioSubCategId ,
                                          String A260PetitorioConcentracion ,
                                          short A39FormaFarmaceuticaId ,
                                          String A261PetitorioPresentacion ,
                                          java.math.BigDecimal A264PetitorioPrecio )
   {
      java.lang.StringBuffer sWhereString = new java.lang.StringBuffer();
      String scmdbuf;
      byte[] GXv_int10 = new byte[30];
      Object[] GXv_Object11 = new Object[2];
      scmdbuf = "SELECT T1.[PetitorioPresentacion], T1.[PetitorioPrecio], T1.[FormaFarmaceuticaId], T1.[PetitorioSubCategId], T2.[PetitorioCategId], T1.[DrogueriaId], T1.[PetitorioId]," ;
      scmdbuf += " T1.[PetitorioConcentracion], T1.[PetitorioProducto], T1.[PetitorioPrincipioActivo] FROM ([Petitorio] T1 INNER JOIN [PetitorioSubCateg] T2 ON T2.[PetitorioSubCategId]" ;
      scmdbuf += " = T1.[PetitorioSubCategId])" ;
      if ( ! (GXutil.strcmp("", AV54Petitoriowwds_1_filterfulltext)==0) )
      {
         addWhere(sWhereString, "(( CONVERT( char(4), CAST(T1.[PetitorioId] AS decimal(4,0))) like '%' + ?) or ( CONVERT( char(4), CAST(T1.[DrogueriaId] AS decimal(4,0))) like '%' + ?) or ( T1.[PetitorioPrincipioActivo] like '%' + ?) or ( T1.[PetitorioProducto] like '%' + ?) or ( CONVERT( char(4), CAST(T2.[PetitorioCategId] AS decimal(4,0))) like '%' + ?) or ( CONVERT( char(4), CAST(T1.[PetitorioSubCategId] AS decimal(4,0))) like '%' + ?) or ( T1.[PetitorioConcentracion] like '%' + ?) or ( CONVERT( char(4), CAST(T1.[FormaFarmaceuticaId] AS decimal(4,0))) like '%' + ?) or ( T1.[PetitorioPresentacion] like '%' + ?) or ( CONVERT( char(7), CAST(T1.[PetitorioPrecio] AS decimal(7,2))) like '%' + ?))");
      }
      else
      {
         GXv_int10[0] = (byte)(1) ;
         GXv_int10[1] = (byte)(1) ;
         GXv_int10[2] = (byte)(1) ;
         GXv_int10[3] = (byte)(1) ;
         GXv_int10[4] = (byte)(1) ;
         GXv_int10[5] = (byte)(1) ;
         GXv_int10[6] = (byte)(1) ;
         GXv_int10[7] = (byte)(1) ;
         GXv_int10[8] = (byte)(1) ;
         GXv_int10[9] = (byte)(1) ;
      }
      if ( ! (0==AV55Petitoriowwds_2_tfpetitorioid) )
      {
         addWhere(sWhereString, "(T1.[PetitorioId] >= ?)");
      }
      else
      {
         GXv_int10[10] = (byte)(1) ;
      }
      if ( ! (0==AV56Petitoriowwds_3_tfpetitorioid_to) )
      {
         addWhere(sWhereString, "(T1.[PetitorioId] <= ?)");
      }
      else
      {
         GXv_int10[11] = (byte)(1) ;
      }
      if ( ! (0==AV57Petitoriowwds_4_tfdrogueriaid) )
      {
         addWhere(sWhereString, "(T1.[DrogueriaId] >= ?)");
      }
      else
      {
         GXv_int10[12] = (byte)(1) ;
      }
      if ( ! (0==AV58Petitoriowwds_5_tfdrogueriaid_to) )
      {
         addWhere(sWhereString, "(T1.[DrogueriaId] <= ?)");
      }
      else
      {
         GXv_int10[13] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV60Petitoriowwds_7_tfpetitorioprincipioactivo_sel)==0) && ( ! (GXutil.strcmp("", AV59Petitoriowwds_6_tfpetitorioprincipioactivo)==0) ) )
      {
         addWhere(sWhereString, "(T1.[PetitorioPrincipioActivo] like ?)");
      }
      else
      {
         GXv_int10[14] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV60Petitoriowwds_7_tfpetitorioprincipioactivo_sel)==0) )
      {
         addWhere(sWhereString, "(T1.[PetitorioPrincipioActivo] = ?)");
      }
      else
      {
         GXv_int10[15] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV62Petitoriowwds_9_tfpetitorioproducto_sel)==0) && ( ! (GXutil.strcmp("", AV61Petitoriowwds_8_tfpetitorioproducto)==0) ) )
      {
         addWhere(sWhereString, "(T1.[PetitorioProducto] like ?)");
      }
      else
      {
         GXv_int10[16] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV62Petitoriowwds_9_tfpetitorioproducto_sel)==0) )
      {
         addWhere(sWhereString, "(T1.[PetitorioProducto] = ?)");
      }
      else
      {
         GXv_int10[17] = (byte)(1) ;
      }
      if ( ! (0==AV63Petitoriowwds_10_tfpetitoriocategid) )
      {
         addWhere(sWhereString, "(T2.[PetitorioCategId] >= ?)");
      }
      else
      {
         GXv_int10[18] = (byte)(1) ;
      }
      if ( ! (0==AV64Petitoriowwds_11_tfpetitoriocategid_to) )
      {
         addWhere(sWhereString, "(T2.[PetitorioCategId] <= ?)");
      }
      else
      {
         GXv_int10[19] = (byte)(1) ;
      }
      if ( ! (0==AV65Petitoriowwds_12_tfpetitoriosubcategid) )
      {
         addWhere(sWhereString, "(T1.[PetitorioSubCategId] >= ?)");
      }
      else
      {
         GXv_int10[20] = (byte)(1) ;
      }
      if ( ! (0==AV66Petitoriowwds_13_tfpetitoriosubcategid_to) )
      {
         addWhere(sWhereString, "(T1.[PetitorioSubCategId] <= ?)");
      }
      else
      {
         GXv_int10[21] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV68Petitoriowwds_15_tfpetitorioconcentracion_sel)==0) && ( ! (GXutil.strcmp("", AV67Petitoriowwds_14_tfpetitorioconcentracion)==0) ) )
      {
         addWhere(sWhereString, "(T1.[PetitorioConcentracion] like ?)");
      }
      else
      {
         GXv_int10[22] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV68Petitoriowwds_15_tfpetitorioconcentracion_sel)==0) )
      {
         addWhere(sWhereString, "(T1.[PetitorioConcentracion] = ?)");
      }
      else
      {
         GXv_int10[23] = (byte)(1) ;
      }
      if ( ! (0==AV69Petitoriowwds_16_tfformafarmaceuticaid) )
      {
         addWhere(sWhereString, "(T1.[FormaFarmaceuticaId] >= ?)");
      }
      else
      {
         GXv_int10[24] = (byte)(1) ;
      }
      if ( ! (0==AV70Petitoriowwds_17_tfformafarmaceuticaid_to) )
      {
         addWhere(sWhereString, "(T1.[FormaFarmaceuticaId] <= ?)");
      }
      else
      {
         GXv_int10[25] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV72Petitoriowwds_19_tfpetitoriopresentacion_sel)==0) && ( ! (GXutil.strcmp("", AV71Petitoriowwds_18_tfpetitoriopresentacion)==0) ) )
      {
         addWhere(sWhereString, "(T1.[PetitorioPresentacion] like ?)");
      }
      else
      {
         GXv_int10[26] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV72Petitoriowwds_19_tfpetitoriopresentacion_sel)==0) )
      {
         addWhere(sWhereString, "(T1.[PetitorioPresentacion] = ?)");
      }
      else
      {
         GXv_int10[27] = (byte)(1) ;
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV73Petitoriowwds_20_tfpetitorioprecio)==0) )
      {
         addWhere(sWhereString, "(T1.[PetitorioPrecio] >= ?)");
      }
      else
      {
         GXv_int10[28] = (byte)(1) ;
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV74Petitoriowwds_21_tfpetitorioprecio_to)==0) )
      {
         addWhere(sWhereString, "(T1.[PetitorioPrecio] <= ?)");
      }
      else
      {
         GXv_int10[29] = (byte)(1) ;
      }
      scmdbuf += sWhereString ;
      scmdbuf += " ORDER BY T1.[PetitorioPresentacion]" ;
      GXv_Object11[0] = scmdbuf ;
      GXv_Object11[1] = GXv_int10 ;
      return GXv_Object11 ;
   }

   public Object [] getDynamicStatement( int cursor ,
                                         ModelContext context ,
                                         int remoteHandle ,
                                         com.genexus.IHttpContext httpContext ,
                                         Object [] dynConstraints )
   {
      switch ( cursor )
      {
            case 0 :
                  return conditional_P003E2(context, remoteHandle, httpContext, (String)dynConstraints[0] , ((Number) dynConstraints[1]).shortValue() , ((Number) dynConstraints[2]).shortValue() , ((Number) dynConstraints[3]).shortValue() , ((Number) dynConstraints[4]).shortValue() , (String)dynConstraints[5] , (String)dynConstraints[6] , (String)dynConstraints[7] , (String)dynConstraints[8] , ((Number) dynConstraints[9]).shortValue() , ((Number) dynConstraints[10]).shortValue() , ((Number) dynConstraints[11]).shortValue() , ((Number) dynConstraints[12]).shortValue() , (String)dynConstraints[13] , (String)dynConstraints[14] , ((Number) dynConstraints[15]).shortValue() , ((Number) dynConstraints[16]).shortValue() , (String)dynConstraints[17] , (String)dynConstraints[18] , (java.math.BigDecimal)dynConstraints[19] , (java.math.BigDecimal)dynConstraints[20] , ((Number) dynConstraints[21]).shortValue() , ((Number) dynConstraints[22]).shortValue() , (String)dynConstraints[23] , (String)dynConstraints[24] , ((Number) dynConstraints[25]).shortValue() , ((Number) dynConstraints[26]).shortValue() , (String)dynConstraints[27] , ((Number) dynConstraints[28]).shortValue() , (String)dynConstraints[29] , (java.math.BigDecimal)dynConstraints[30] );
            case 1 :
                  return conditional_P003E3(context, remoteHandle, httpContext, (String)dynConstraints[0] , ((Number) dynConstraints[1]).shortValue() , ((Number) dynConstraints[2]).shortValue() , ((Number) dynConstraints[3]).shortValue() , ((Number) dynConstraints[4]).shortValue() , (String)dynConstraints[5] , (String)dynConstraints[6] , (String)dynConstraints[7] , (String)dynConstraints[8] , ((Number) dynConstraints[9]).shortValue() , ((Number) dynConstraints[10]).shortValue() , ((Number) dynConstraints[11]).shortValue() , ((Number) dynConstraints[12]).shortValue() , (String)dynConstraints[13] , (String)dynConstraints[14] , ((Number) dynConstraints[15]).shortValue() , ((Number) dynConstraints[16]).shortValue() , (String)dynConstraints[17] , (String)dynConstraints[18] , (java.math.BigDecimal)dynConstraints[19] , (java.math.BigDecimal)dynConstraints[20] , ((Number) dynConstraints[21]).shortValue() , ((Number) dynConstraints[22]).shortValue() , (String)dynConstraints[23] , (String)dynConstraints[24] , ((Number) dynConstraints[25]).shortValue() , ((Number) dynConstraints[26]).shortValue() , (String)dynConstraints[27] , ((Number) dynConstraints[28]).shortValue() , (String)dynConstraints[29] , (java.math.BigDecimal)dynConstraints[30] );
            case 2 :
                  return conditional_P003E4(context, remoteHandle, httpContext, (String)dynConstraints[0] , ((Number) dynConstraints[1]).shortValue() , ((Number) dynConstraints[2]).shortValue() , ((Number) dynConstraints[3]).shortValue() , ((Number) dynConstraints[4]).shortValue() , (String)dynConstraints[5] , (String)dynConstraints[6] , (String)dynConstraints[7] , (String)dynConstraints[8] , ((Number) dynConstraints[9]).shortValue() , ((Number) dynConstraints[10]).shortValue() , ((Number) dynConstraints[11]).shortValue() , ((Number) dynConstraints[12]).shortValue() , (String)dynConstraints[13] , (String)dynConstraints[14] , ((Number) dynConstraints[15]).shortValue() , ((Number) dynConstraints[16]).shortValue() , (String)dynConstraints[17] , (String)dynConstraints[18] , (java.math.BigDecimal)dynConstraints[19] , (java.math.BigDecimal)dynConstraints[20] , ((Number) dynConstraints[21]).shortValue() , ((Number) dynConstraints[22]).shortValue() , (String)dynConstraints[23] , (String)dynConstraints[24] , ((Number) dynConstraints[25]).shortValue() , ((Number) dynConstraints[26]).shortValue() , (String)dynConstraints[27] , ((Number) dynConstraints[28]).shortValue() , (String)dynConstraints[29] , (java.math.BigDecimal)dynConstraints[30] );
            case 3 :
                  return conditional_P003E5(context, remoteHandle, httpContext, (String)dynConstraints[0] , ((Number) dynConstraints[1]).shortValue() , ((Number) dynConstraints[2]).shortValue() , ((Number) dynConstraints[3]).shortValue() , ((Number) dynConstraints[4]).shortValue() , (String)dynConstraints[5] , (String)dynConstraints[6] , (String)dynConstraints[7] , (String)dynConstraints[8] , ((Number) dynConstraints[9]).shortValue() , ((Number) dynConstraints[10]).shortValue() , ((Number) dynConstraints[11]).shortValue() , ((Number) dynConstraints[12]).shortValue() , (String)dynConstraints[13] , (String)dynConstraints[14] , ((Number) dynConstraints[15]).shortValue() , ((Number) dynConstraints[16]).shortValue() , (String)dynConstraints[17] , (String)dynConstraints[18] , (java.math.BigDecimal)dynConstraints[19] , (java.math.BigDecimal)dynConstraints[20] , ((Number) dynConstraints[21]).shortValue() , ((Number) dynConstraints[22]).shortValue() , (String)dynConstraints[23] , (String)dynConstraints[24] , ((Number) dynConstraints[25]).shortValue() , ((Number) dynConstraints[26]).shortValue() , (String)dynConstraints[27] , ((Number) dynConstraints[28]).shortValue() , (String)dynConstraints[29] , (java.math.BigDecimal)dynConstraints[30] );
      }
      return super.getDynamicStatement(cursor, context, remoteHandle, httpContext, dynConstraints);
   }

   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P003E2", "scmdbuf",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("P003E3", "scmdbuf",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("P003E4", "scmdbuf",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("P003E5", "scmdbuf",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
      };
   }

   public void getResults( int cursor ,
                           IFieldGetter rslt ,
                           Object[] buf ) throws SQLException
   {
      switch ( cursor )
      {
            case 0 :
               ((String[]) buf[0])[0] = rslt.getVarchar(1);
               ((java.math.BigDecimal[]) buf[1])[0] = rslt.getBigDecimal(2,2);
               ((short[]) buf[2])[0] = rslt.getShort(3);
               ((short[]) buf[3])[0] = rslt.getShort(4);
               ((short[]) buf[4])[0] = rslt.getShort(5);
               ((short[]) buf[5])[0] = rslt.getShort(6);
               ((short[]) buf[6])[0] = rslt.getShort(7);
               ((String[]) buf[7])[0] = rslt.getVarchar(8);
               ((String[]) buf[8])[0] = rslt.getVarchar(9);
               ((String[]) buf[9])[0] = rslt.getVarchar(10);
               return;
            case 1 :
               ((String[]) buf[0])[0] = rslt.getVarchar(1);
               ((java.math.BigDecimal[]) buf[1])[0] = rslt.getBigDecimal(2,2);
               ((short[]) buf[2])[0] = rslt.getShort(3);
               ((short[]) buf[3])[0] = rslt.getShort(4);
               ((short[]) buf[4])[0] = rslt.getShort(5);
               ((short[]) buf[5])[0] = rslt.getShort(6);
               ((short[]) buf[6])[0] = rslt.getShort(7);
               ((String[]) buf[7])[0] = rslt.getVarchar(8);
               ((String[]) buf[8])[0] = rslt.getVarchar(9);
               ((String[]) buf[9])[0] = rslt.getVarchar(10);
               return;
            case 2 :
               ((String[]) buf[0])[0] = rslt.getVarchar(1);
               ((java.math.BigDecimal[]) buf[1])[0] = rslt.getBigDecimal(2,2);
               ((short[]) buf[2])[0] = rslt.getShort(3);
               ((short[]) buf[3])[0] = rslt.getShort(4);
               ((short[]) buf[4])[0] = rslt.getShort(5);
               ((short[]) buf[5])[0] = rslt.getShort(6);
               ((short[]) buf[6])[0] = rslt.getShort(7);
               ((String[]) buf[7])[0] = rslt.getVarchar(8);
               ((String[]) buf[8])[0] = rslt.getVarchar(9);
               ((String[]) buf[9])[0] = rslt.getVarchar(10);
               return;
            case 3 :
               ((String[]) buf[0])[0] = rslt.getVarchar(1);
               ((java.math.BigDecimal[]) buf[1])[0] = rslt.getBigDecimal(2,2);
               ((short[]) buf[2])[0] = rslt.getShort(3);
               ((short[]) buf[3])[0] = rslt.getShort(4);
               ((short[]) buf[4])[0] = rslt.getShort(5);
               ((short[]) buf[5])[0] = rslt.getShort(6);
               ((short[]) buf[6])[0] = rslt.getShort(7);
               ((String[]) buf[7])[0] = rslt.getVarchar(8);
               ((String[]) buf[8])[0] = rslt.getVarchar(9);
               ((String[]) buf[9])[0] = rslt.getVarchar(10);
               return;
      }
   }

   public void setParameters( int cursor ,
                              IFieldSetter stmt ,
                              Object[] parms ) throws SQLException
   {
      short sIdx;
      switch ( cursor )
      {
            case 0 :
               sIdx = (short)(0) ;
               if ( ((Number) parms[0]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[30], 100);
               }
               if ( ((Number) parms[1]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[31], 100);
               }
               if ( ((Number) parms[2]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[32], 100);
               }
               if ( ((Number) parms[3]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[33], 100);
               }
               if ( ((Number) parms[4]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[34], 100);
               }
               if ( ((Number) parms[5]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[35], 100);
               }
               if ( ((Number) parms[6]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[36], 100);
               }
               if ( ((Number) parms[7]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[37], 100);
               }
               if ( ((Number) parms[8]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[38], 100);
               }
               if ( ((Number) parms[9]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[39], 100);
               }
               if ( ((Number) parms[10]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[40]).shortValue());
               }
               if ( ((Number) parms[11]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[41]).shortValue());
               }
               if ( ((Number) parms[12]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[42]).shortValue());
               }
               if ( ((Number) parms[13]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[43]).shortValue());
               }
               if ( ((Number) parms[14]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[44], 200);
               }
               if ( ((Number) parms[15]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[45], 200);
               }
               if ( ((Number) parms[16]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[46], 100);
               }
               if ( ((Number) parms[17]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[47], 100);
               }
               if ( ((Number) parms[18]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[48]).shortValue());
               }
               if ( ((Number) parms[19]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[49]).shortValue());
               }
               if ( ((Number) parms[20]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[50]).shortValue());
               }
               if ( ((Number) parms[21]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[51]).shortValue());
               }
               if ( ((Number) parms[22]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[52], 40);
               }
               if ( ((Number) parms[23]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[53], 40);
               }
               if ( ((Number) parms[24]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[54]).shortValue());
               }
               if ( ((Number) parms[25]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[55]).shortValue());
               }
               if ( ((Number) parms[26]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[56], 40);
               }
               if ( ((Number) parms[27]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[57], 40);
               }
               if ( ((Number) parms[28]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setBigDecimal(sIdx, (java.math.BigDecimal)parms[58], 2);
               }
               if ( ((Number) parms[29]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setBigDecimal(sIdx, (java.math.BigDecimal)parms[59], 2);
               }
               return;
            case 1 :
               sIdx = (short)(0) ;
               if ( ((Number) parms[0]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[30], 100);
               }
               if ( ((Number) parms[1]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[31], 100);
               }
               if ( ((Number) parms[2]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[32], 100);
               }
               if ( ((Number) parms[3]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[33], 100);
               }
               if ( ((Number) parms[4]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[34], 100);
               }
               if ( ((Number) parms[5]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[35], 100);
               }
               if ( ((Number) parms[6]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[36], 100);
               }
               if ( ((Number) parms[7]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[37], 100);
               }
               if ( ((Number) parms[8]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[38], 100);
               }
               if ( ((Number) parms[9]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[39], 100);
               }
               if ( ((Number) parms[10]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[40]).shortValue());
               }
               if ( ((Number) parms[11]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[41]).shortValue());
               }
               if ( ((Number) parms[12]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[42]).shortValue());
               }
               if ( ((Number) parms[13]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[43]).shortValue());
               }
               if ( ((Number) parms[14]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[44], 200);
               }
               if ( ((Number) parms[15]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[45], 200);
               }
               if ( ((Number) parms[16]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[46], 100);
               }
               if ( ((Number) parms[17]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[47], 100);
               }
               if ( ((Number) parms[18]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[48]).shortValue());
               }
               if ( ((Number) parms[19]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[49]).shortValue());
               }
               if ( ((Number) parms[20]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[50]).shortValue());
               }
               if ( ((Number) parms[21]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[51]).shortValue());
               }
               if ( ((Number) parms[22]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[52], 40);
               }
               if ( ((Number) parms[23]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[53], 40);
               }
               if ( ((Number) parms[24]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[54]).shortValue());
               }
               if ( ((Number) parms[25]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[55]).shortValue());
               }
               if ( ((Number) parms[26]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[56], 40);
               }
               if ( ((Number) parms[27]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[57], 40);
               }
               if ( ((Number) parms[28]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setBigDecimal(sIdx, (java.math.BigDecimal)parms[58], 2);
               }
               if ( ((Number) parms[29]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setBigDecimal(sIdx, (java.math.BigDecimal)parms[59], 2);
               }
               return;
            case 2 :
               sIdx = (short)(0) ;
               if ( ((Number) parms[0]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[30], 100);
               }
               if ( ((Number) parms[1]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[31], 100);
               }
               if ( ((Number) parms[2]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[32], 100);
               }
               if ( ((Number) parms[3]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[33], 100);
               }
               if ( ((Number) parms[4]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[34], 100);
               }
               if ( ((Number) parms[5]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[35], 100);
               }
               if ( ((Number) parms[6]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[36], 100);
               }
               if ( ((Number) parms[7]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[37], 100);
               }
               if ( ((Number) parms[8]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[38], 100);
               }
               if ( ((Number) parms[9]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[39], 100);
               }
               if ( ((Number) parms[10]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[40]).shortValue());
               }
               if ( ((Number) parms[11]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[41]).shortValue());
               }
               if ( ((Number) parms[12]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[42]).shortValue());
               }
               if ( ((Number) parms[13]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[43]).shortValue());
               }
               if ( ((Number) parms[14]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[44], 200);
               }
               if ( ((Number) parms[15]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[45], 200);
               }
               if ( ((Number) parms[16]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[46], 100);
               }
               if ( ((Number) parms[17]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[47], 100);
               }
               if ( ((Number) parms[18]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[48]).shortValue());
               }
               if ( ((Number) parms[19]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[49]).shortValue());
               }
               if ( ((Number) parms[20]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[50]).shortValue());
               }
               if ( ((Number) parms[21]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[51]).shortValue());
               }
               if ( ((Number) parms[22]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[52], 40);
               }
               if ( ((Number) parms[23]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[53], 40);
               }
               if ( ((Number) parms[24]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[54]).shortValue());
               }
               if ( ((Number) parms[25]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[55]).shortValue());
               }
               if ( ((Number) parms[26]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[56], 40);
               }
               if ( ((Number) parms[27]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[57], 40);
               }
               if ( ((Number) parms[28]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setBigDecimal(sIdx, (java.math.BigDecimal)parms[58], 2);
               }
               if ( ((Number) parms[29]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setBigDecimal(sIdx, (java.math.BigDecimal)parms[59], 2);
               }
               return;
            case 3 :
               sIdx = (short)(0) ;
               if ( ((Number) parms[0]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[30], 100);
               }
               if ( ((Number) parms[1]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[31], 100);
               }
               if ( ((Number) parms[2]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[32], 100);
               }
               if ( ((Number) parms[3]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[33], 100);
               }
               if ( ((Number) parms[4]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[34], 100);
               }
               if ( ((Number) parms[5]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[35], 100);
               }
               if ( ((Number) parms[6]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[36], 100);
               }
               if ( ((Number) parms[7]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[37], 100);
               }
               if ( ((Number) parms[8]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[38], 100);
               }
               if ( ((Number) parms[9]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[39], 100);
               }
               if ( ((Number) parms[10]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[40]).shortValue());
               }
               if ( ((Number) parms[11]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[41]).shortValue());
               }
               if ( ((Number) parms[12]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[42]).shortValue());
               }
               if ( ((Number) parms[13]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[43]).shortValue());
               }
               if ( ((Number) parms[14]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[44], 200);
               }
               if ( ((Number) parms[15]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[45], 200);
               }
               if ( ((Number) parms[16]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[46], 100);
               }
               if ( ((Number) parms[17]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[47], 100);
               }
               if ( ((Number) parms[18]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[48]).shortValue());
               }
               if ( ((Number) parms[19]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[49]).shortValue());
               }
               if ( ((Number) parms[20]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[50]).shortValue());
               }
               if ( ((Number) parms[21]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[51]).shortValue());
               }
               if ( ((Number) parms[22]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[52], 40);
               }
               if ( ((Number) parms[23]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[53], 40);
               }
               if ( ((Number) parms[24]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[54]).shortValue());
               }
               if ( ((Number) parms[25]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[55]).shortValue());
               }
               if ( ((Number) parms[26]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[56], 40);
               }
               if ( ((Number) parms[27]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[57], 40);
               }
               if ( ((Number) parms[28]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setBigDecimal(sIdx, (java.math.BigDecimal)parms[58], 2);
               }
               if ( ((Number) parms[29]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setBigDecimal(sIdx, (java.math.BigDecimal)parms[59], 2);
               }
               return;
      }
   }

}

