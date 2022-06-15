package com.projectthani ;
import com.projectthani.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class ubigeowwgetfilterdata extends GXProcedure
{
   public ubigeowwgetfilterdata( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( ubigeowwgetfilterdata.class ), "" );
   }

   public ubigeowwgetfilterdata( int remoteHandle ,
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
      ubigeowwgetfilterdata.this.aP5 = new String[] {""};
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
      ubigeowwgetfilterdata.this.AV31DDOName = aP0;
      ubigeowwgetfilterdata.this.AV29SearchTxt = aP1;
      ubigeowwgetfilterdata.this.AV30SearchTxtTo = aP2;
      ubigeowwgetfilterdata.this.aP3 = aP3;
      ubigeowwgetfilterdata.this.aP4 = aP4;
      ubigeowwgetfilterdata.this.aP5 = aP5;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      AV34Options = new GXSimpleCollection<String>(String.class, "internal", "") ;
      AV37OptionsDesc = new GXSimpleCollection<String>(String.class, "internal", "") ;
      AV39OptionIndexes = new GXSimpleCollection<String>(String.class, "internal", "") ;
      GXt_boolean1 = AV8IsAuthorized ;
      GXv_boolean2[0] = GXt_boolean1 ;
      new com.projectthani.wwpbaseobjects.secisauthbyfunctionalitykey(remoteHandle, context).execute( "WWUbigeo", GXv_boolean2) ;
      ubigeowwgetfilterdata.this.GXt_boolean1 = GXv_boolean2[0] ;
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
         if ( GXutil.strcmp(GXutil.upper( AV31DDOName), "DDO_UBIGEOCODE") == 0 )
         {
            /* Execute user subroutine: 'LOADUBIGEOCODEOPTIONS' */
            S121 ();
            if ( returnInSub )
            {
               returnInSub = true;
               cleanup();
               if (true) return;
            }
         }
         else if ( GXutil.strcmp(GXutil.upper( AV31DDOName), "DDO_UBIGEODEPARTAMENTO") == 0 )
         {
            /* Execute user subroutine: 'LOADUBIGEODEPARTAMENTOOPTIONS' */
            S131 ();
            if ( returnInSub )
            {
               returnInSub = true;
               cleanup();
               if (true) return;
            }
         }
         else if ( GXutil.strcmp(GXutil.upper( AV31DDOName), "DDO_UBIGEODEPARTAMENTOCODE") == 0 )
         {
            /* Execute user subroutine: 'LOADUBIGEODEPARTAMENTOCODEOPTIONS' */
            S141 ();
            if ( returnInSub )
            {
               returnInSub = true;
               cleanup();
               if (true) return;
            }
         }
         else if ( GXutil.strcmp(GXutil.upper( AV31DDOName), "DDO_UBIGEOPROVINCIA") == 0 )
         {
            /* Execute user subroutine: 'LOADUBIGEOPROVINCIAOPTIONS' */
            S151 ();
            if ( returnInSub )
            {
               returnInSub = true;
               cleanup();
               if (true) return;
            }
         }
         else if ( GXutil.strcmp(GXutil.upper( AV31DDOName), "DDO_UBIGEOPROVINCIACODE") == 0 )
         {
            /* Execute user subroutine: 'LOADUBIGEOPROVINCIACODEOPTIONS' */
            S161 ();
            if ( returnInSub )
            {
               returnInSub = true;
               cleanup();
               if (true) return;
            }
         }
         else if ( GXutil.strcmp(GXutil.upper( AV31DDOName), "DDO_UBIGEODISTRITO") == 0 )
         {
            /* Execute user subroutine: 'LOADUBIGEODISTRITOOPTIONS' */
            S171 ();
            if ( returnInSub )
            {
               returnInSub = true;
               cleanup();
               if (true) return;
            }
         }
         else if ( GXutil.strcmp(GXutil.upper( AV31DDOName), "DDO_UBIGEODISTRITOCODE") == 0 )
         {
            /* Execute user subroutine: 'LOADUBIGEODISTRITOCODEOPTIONS' */
            S181 ();
            if ( returnInSub )
            {
               returnInSub = true;
               cleanup();
               if (true) return;
            }
         }
         else if ( GXutil.strcmp(GXutil.upper( AV31DDOName), "DDO_UBIGEONOMBRE") == 0 )
         {
            /* Execute user subroutine: 'LOADUBIGEONOMBREOPTIONS' */
            S191 ();
            if ( returnInSub )
            {
               returnInSub = true;
               cleanup();
               if (true) return;
            }
         }
      }
      AV35OptionsJson = AV34Options.toJSonString(false) ;
      AV38OptionsDescJson = AV37OptionsDesc.toJSonString(false) ;
      AV40OptionIndexesJson = AV39OptionIndexes.toJSonString(false) ;
      cleanup();
   }

   public void S111( )
   {
      /* 'LOADGRIDSTATE' Routine */
      returnInSub = false ;
      if ( GXutil.strcmp(AV42Session.getValue("UbigeoWWGridState"), "") == 0 )
      {
         AV44GridState.fromxml(new com.projectthani.wwpbaseobjects.loadgridstate(remoteHandle, context).executeUdp( "UbigeoWWGridState"), null, null);
      }
      else
      {
         AV44GridState.fromxml(AV42Session.getValue("UbigeoWWGridState"), null, null);
      }
      AV50GXV1 = 1 ;
      while ( AV50GXV1 <= AV44GridState.getgxTv_SdtWWPGridState_Filtervalues().size() )
      {
         AV45GridStateFilterValue = (com.projectthani.wwpbaseobjects.SdtWWPGridState_FilterValue)((com.projectthani.wwpbaseobjects.SdtWWPGridState_FilterValue)AV44GridState.getgxTv_SdtWWPGridState_Filtervalues().elementAt(-1+AV50GXV1));
         if ( GXutil.strcmp(AV45GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "FILTERFULLTEXT") == 0 )
         {
            AV47FilterFullText = AV45GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV45GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFUBIGEOCODE") == 0 )
         {
            AV11TFUbigeoCode = AV45GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV45GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFUBIGEOCODE_SEL") == 0 )
         {
            AV12TFUbigeoCode_Sel = AV45GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV45GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFUBIGEODEPARTAMENTO") == 0 )
         {
            AV13TFUbigeoDepartamento = AV45GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV45GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFUBIGEODEPARTAMENTO_SEL") == 0 )
         {
            AV14TFUbigeoDepartamento_Sel = AV45GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV45GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFUBIGEODEPARTAMENTOCODE") == 0 )
         {
            AV15TFUbigeoDepartamentoCode = AV45GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV45GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFUBIGEODEPARTAMENTOCODE_SEL") == 0 )
         {
            AV16TFUbigeoDepartamentoCode_Sel = AV45GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV45GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFUBIGEOPROVINCIA") == 0 )
         {
            AV17TFUbigeoProvincia = AV45GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV45GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFUBIGEOPROVINCIA_SEL") == 0 )
         {
            AV18TFUbigeoProvincia_Sel = AV45GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV45GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFUBIGEOPROVINCIACODE") == 0 )
         {
            AV19TFUbigeoProvinciaCode = AV45GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV45GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFUBIGEOPROVINCIACODE_SEL") == 0 )
         {
            AV20TFUbigeoProvinciaCode_Sel = AV45GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV45GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFUBIGEODISTRITO") == 0 )
         {
            AV21TFUbigeoDistrito = AV45GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV45GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFUBIGEODISTRITO_SEL") == 0 )
         {
            AV22TFUbigeoDistrito_Sel = AV45GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV45GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFUBIGEODISTRITOCODE") == 0 )
         {
            AV23TFUbigeoDistritoCode = AV45GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV45GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFUBIGEODISTRITOCODE_SEL") == 0 )
         {
            AV24TFUbigeoDistritoCode_Sel = AV45GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV45GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFUBIGEONOMBRE") == 0 )
         {
            AV25TFUbigeoNombre = AV45GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV45GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFUBIGEONOMBRE_SEL") == 0 )
         {
            AV26TFUbigeoNombre_Sel = AV45GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV45GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFUBIGEOESTADO_SEL") == 0 )
         {
            AV27TFUbigeoEstado_SelsJson = AV45GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            AV28TFUbigeoEstado_Sels.fromJSonString(AV27TFUbigeoEstado_SelsJson, null);
         }
         AV50GXV1 = (int)(AV50GXV1+1) ;
      }
   }

   public void S121( )
   {
      /* 'LOADUBIGEOCODEOPTIONS' Routine */
      returnInSub = false ;
      AV11TFUbigeoCode = AV29SearchTxt ;
      AV12TFUbigeoCode_Sel = "" ;
      AV52Ubigeowwds_1_filterfulltext = AV47FilterFullText ;
      AV53Ubigeowwds_2_tfubigeocode = AV11TFUbigeoCode ;
      AV54Ubigeowwds_3_tfubigeocode_sel = AV12TFUbigeoCode_Sel ;
      AV55Ubigeowwds_4_tfubigeodepartamento = AV13TFUbigeoDepartamento ;
      AV56Ubigeowwds_5_tfubigeodepartamento_sel = AV14TFUbigeoDepartamento_Sel ;
      AV57Ubigeowwds_6_tfubigeodepartamentocode = AV15TFUbigeoDepartamentoCode ;
      AV58Ubigeowwds_7_tfubigeodepartamentocode_sel = AV16TFUbigeoDepartamentoCode_Sel ;
      AV59Ubigeowwds_8_tfubigeoprovincia = AV17TFUbigeoProvincia ;
      AV60Ubigeowwds_9_tfubigeoprovincia_sel = AV18TFUbigeoProvincia_Sel ;
      AV61Ubigeowwds_10_tfubigeoprovinciacode = AV19TFUbigeoProvinciaCode ;
      AV62Ubigeowwds_11_tfubigeoprovinciacode_sel = AV20TFUbigeoProvinciaCode_Sel ;
      AV63Ubigeowwds_12_tfubigeodistrito = AV21TFUbigeoDistrito ;
      AV64Ubigeowwds_13_tfubigeodistrito_sel = AV22TFUbigeoDistrito_Sel ;
      AV65Ubigeowwds_14_tfubigeodistritocode = AV23TFUbigeoDistritoCode ;
      AV66Ubigeowwds_15_tfubigeodistritocode_sel = AV24TFUbigeoDistritoCode_Sel ;
      AV67Ubigeowwds_16_tfubigeonombre = AV25TFUbigeoNombre ;
      AV68Ubigeowwds_17_tfubigeonombre_sel = AV26TFUbigeoNombre_Sel ;
      AV69Ubigeowwds_18_tfubigeoestado_sels = AV28TFUbigeoEstado_Sels ;
      pr_default.dynParam(0, new Object[]{ new Object[]{
                                           A294UbigeoEstado ,
                                           AV69Ubigeowwds_18_tfubigeoestado_sels ,
                                           AV52Ubigeowwds_1_filterfulltext ,
                                           AV54Ubigeowwds_3_tfubigeocode_sel ,
                                           AV53Ubigeowwds_2_tfubigeocode ,
                                           AV56Ubigeowwds_5_tfubigeodepartamento_sel ,
                                           AV55Ubigeowwds_4_tfubigeodepartamento ,
                                           AV58Ubigeowwds_7_tfubigeodepartamentocode_sel ,
                                           AV57Ubigeowwds_6_tfubigeodepartamentocode ,
                                           AV60Ubigeowwds_9_tfubigeoprovincia_sel ,
                                           AV59Ubigeowwds_8_tfubigeoprovincia ,
                                           AV62Ubigeowwds_11_tfubigeoprovinciacode_sel ,
                                           AV61Ubigeowwds_10_tfubigeoprovinciacode ,
                                           AV64Ubigeowwds_13_tfubigeodistrito_sel ,
                                           AV63Ubigeowwds_12_tfubigeodistrito ,
                                           AV66Ubigeowwds_15_tfubigeodistritocode_sel ,
                                           AV65Ubigeowwds_14_tfubigeodistritocode ,
                                           AV68Ubigeowwds_17_tfubigeonombre_sel ,
                                           AV67Ubigeowwds_16_tfubigeonombre ,
                                           Integer.valueOf(AV69Ubigeowwds_18_tfubigeoestado_sels.size()) ,
                                           A44UbigeoCode ,
                                           A186UbigeoDepartamento ,
                                           A187UbigeoProvincia ,
                                           A188UbigeoDistrito } ,
                                           new int[]{
                                           TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING,
                                           TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.INT, TypeConstants.STRING,
                                           TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING
                                           }
      });
      lV52Ubigeowwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV52Ubigeowwds_1_filterfulltext), "%", "") ;
      lV52Ubigeowwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV52Ubigeowwds_1_filterfulltext), "%", "") ;
      lV52Ubigeowwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV52Ubigeowwds_1_filterfulltext), "%", "") ;
      lV52Ubigeowwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV52Ubigeowwds_1_filterfulltext), "%", "") ;
      lV52Ubigeowwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV52Ubigeowwds_1_filterfulltext), "%", "") ;
      lV52Ubigeowwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV52Ubigeowwds_1_filterfulltext), "%", "") ;
      lV52Ubigeowwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV52Ubigeowwds_1_filterfulltext), "%", "") ;
      lV52Ubigeowwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV52Ubigeowwds_1_filterfulltext), "%", "") ;
      lV52Ubigeowwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV52Ubigeowwds_1_filterfulltext), "%", "") ;
      lV52Ubigeowwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV52Ubigeowwds_1_filterfulltext), "%", "") ;
      lV53Ubigeowwds_2_tfubigeocode = GXutil.padr( GXutil.rtrim( AV53Ubigeowwds_2_tfubigeocode), 10, "%") ;
      lV55Ubigeowwds_4_tfubigeodepartamento = GXutil.concat( GXutil.rtrim( AV55Ubigeowwds_4_tfubigeodepartamento), "%", "") ;
      lV57Ubigeowwds_6_tfubigeodepartamentocode = GXutil.concat( GXutil.rtrim( AV57Ubigeowwds_6_tfubigeodepartamentocode), "%", "") ;
      lV59Ubigeowwds_8_tfubigeoprovincia = GXutil.concat( GXutil.rtrim( AV59Ubigeowwds_8_tfubigeoprovincia), "%", "") ;
      lV61Ubigeowwds_10_tfubigeoprovinciacode = GXutil.concat( GXutil.rtrim( AV61Ubigeowwds_10_tfubigeoprovinciacode), "%", "") ;
      lV63Ubigeowwds_12_tfubigeodistrito = GXutil.concat( GXutil.rtrim( AV63Ubigeowwds_12_tfubigeodistrito), "%", "") ;
      lV65Ubigeowwds_14_tfubigeodistritocode = GXutil.concat( GXutil.rtrim( AV65Ubigeowwds_14_tfubigeodistritocode), "%", "") ;
      lV67Ubigeowwds_16_tfubigeonombre = GXutil.concat( GXutil.rtrim( AV67Ubigeowwds_16_tfubigeonombre), "%", "") ;
      /* Using cursor P003L2 */
      pr_default.execute(0, new Object[] {lV52Ubigeowwds_1_filterfulltext, lV52Ubigeowwds_1_filterfulltext, lV52Ubigeowwds_1_filterfulltext, lV52Ubigeowwds_1_filterfulltext, lV52Ubigeowwds_1_filterfulltext, lV52Ubigeowwds_1_filterfulltext, lV52Ubigeowwds_1_filterfulltext, lV52Ubigeowwds_1_filterfulltext, lV52Ubigeowwds_1_filterfulltext, lV52Ubigeowwds_1_filterfulltext, lV53Ubigeowwds_2_tfubigeocode, AV54Ubigeowwds_3_tfubigeocode_sel, lV55Ubigeowwds_4_tfubigeodepartamento, AV56Ubigeowwds_5_tfubigeodepartamento_sel, lV57Ubigeowwds_6_tfubigeodepartamentocode, AV58Ubigeowwds_7_tfubigeodepartamentocode_sel, lV59Ubigeowwds_8_tfubigeoprovincia, AV60Ubigeowwds_9_tfubigeoprovincia_sel, lV61Ubigeowwds_10_tfubigeoprovinciacode, AV62Ubigeowwds_11_tfubigeoprovinciacode_sel, lV63Ubigeowwds_12_tfubigeodistrito, AV64Ubigeowwds_13_tfubigeodistrito_sel, lV65Ubigeowwds_14_tfubigeodistritocode, AV66Ubigeowwds_15_tfubigeodistritocode_sel, lV67Ubigeowwds_16_tfubigeonombre, AV68Ubigeowwds_17_tfubigeonombre_sel});
      while ( (pr_default.getStatus(0) != 101) )
      {
         A294UbigeoEstado = P003L2_A294UbigeoEstado[0] ;
         A44UbigeoCode = P003L2_A44UbigeoCode[0] ;
         A188UbigeoDistrito = P003L2_A188UbigeoDistrito[0] ;
         A187UbigeoProvincia = P003L2_A187UbigeoProvincia[0] ;
         A186UbigeoDepartamento = P003L2_A186UbigeoDepartamento[0] ;
         A185UbigeoNombre = A186UbigeoDepartamento + " / " + A187UbigeoProvincia + " / " + A188UbigeoDistrito ;
         A295UbigeoDepartamentoCode = GXutil.substring( A44UbigeoCode, 1, 2) ;
         A296UbigeoProvinciaCode = GXutil.substring( A44UbigeoCode, 3, 2) ;
         A297UbigeoDistritoCode = GXutil.substring( A44UbigeoCode, 5, 2) ;
         if ( ! (GXutil.strcmp("", A44UbigeoCode)==0) )
         {
            AV33Option = A44UbigeoCode ;
            AV34Options.add(AV33Option, 0);
         }
         if ( AV34Options.size() == 50 )
         {
            /* Exit For each command. Update data (if necessary), close cursors & exit. */
            if (true) break;
         }
         pr_default.readNext(0);
      }
      pr_default.close(0);
   }

   public void S131( )
   {
      /* 'LOADUBIGEODEPARTAMENTOOPTIONS' Routine */
      returnInSub = false ;
      AV13TFUbigeoDepartamento = AV29SearchTxt ;
      AV14TFUbigeoDepartamento_Sel = "" ;
      AV52Ubigeowwds_1_filterfulltext = AV47FilterFullText ;
      AV53Ubigeowwds_2_tfubigeocode = AV11TFUbigeoCode ;
      AV54Ubigeowwds_3_tfubigeocode_sel = AV12TFUbigeoCode_Sel ;
      AV55Ubigeowwds_4_tfubigeodepartamento = AV13TFUbigeoDepartamento ;
      AV56Ubigeowwds_5_tfubigeodepartamento_sel = AV14TFUbigeoDepartamento_Sel ;
      AV57Ubigeowwds_6_tfubigeodepartamentocode = AV15TFUbigeoDepartamentoCode ;
      AV58Ubigeowwds_7_tfubigeodepartamentocode_sel = AV16TFUbigeoDepartamentoCode_Sel ;
      AV59Ubigeowwds_8_tfubigeoprovincia = AV17TFUbigeoProvincia ;
      AV60Ubigeowwds_9_tfubigeoprovincia_sel = AV18TFUbigeoProvincia_Sel ;
      AV61Ubigeowwds_10_tfubigeoprovinciacode = AV19TFUbigeoProvinciaCode ;
      AV62Ubigeowwds_11_tfubigeoprovinciacode_sel = AV20TFUbigeoProvinciaCode_Sel ;
      AV63Ubigeowwds_12_tfubigeodistrito = AV21TFUbigeoDistrito ;
      AV64Ubigeowwds_13_tfubigeodistrito_sel = AV22TFUbigeoDistrito_Sel ;
      AV65Ubigeowwds_14_tfubigeodistritocode = AV23TFUbigeoDistritoCode ;
      AV66Ubigeowwds_15_tfubigeodistritocode_sel = AV24TFUbigeoDistritoCode_Sel ;
      AV67Ubigeowwds_16_tfubigeonombre = AV25TFUbigeoNombre ;
      AV68Ubigeowwds_17_tfubigeonombre_sel = AV26TFUbigeoNombre_Sel ;
      AV69Ubigeowwds_18_tfubigeoestado_sels = AV28TFUbigeoEstado_Sels ;
      pr_default.dynParam(1, new Object[]{ new Object[]{
                                           A294UbigeoEstado ,
                                           AV69Ubigeowwds_18_tfubigeoestado_sels ,
                                           AV52Ubigeowwds_1_filterfulltext ,
                                           AV54Ubigeowwds_3_tfubigeocode_sel ,
                                           AV53Ubigeowwds_2_tfubigeocode ,
                                           AV56Ubigeowwds_5_tfubigeodepartamento_sel ,
                                           AV55Ubigeowwds_4_tfubigeodepartamento ,
                                           AV58Ubigeowwds_7_tfubigeodepartamentocode_sel ,
                                           AV57Ubigeowwds_6_tfubigeodepartamentocode ,
                                           AV60Ubigeowwds_9_tfubigeoprovincia_sel ,
                                           AV59Ubigeowwds_8_tfubigeoprovincia ,
                                           AV62Ubigeowwds_11_tfubigeoprovinciacode_sel ,
                                           AV61Ubigeowwds_10_tfubigeoprovinciacode ,
                                           AV64Ubigeowwds_13_tfubigeodistrito_sel ,
                                           AV63Ubigeowwds_12_tfubigeodistrito ,
                                           AV66Ubigeowwds_15_tfubigeodistritocode_sel ,
                                           AV65Ubigeowwds_14_tfubigeodistritocode ,
                                           AV68Ubigeowwds_17_tfubigeonombre_sel ,
                                           AV67Ubigeowwds_16_tfubigeonombre ,
                                           Integer.valueOf(AV69Ubigeowwds_18_tfubigeoestado_sels.size()) ,
                                           A44UbigeoCode ,
                                           A186UbigeoDepartamento ,
                                           A187UbigeoProvincia ,
                                           A188UbigeoDistrito } ,
                                           new int[]{
                                           TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING,
                                           TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.INT, TypeConstants.STRING,
                                           TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING
                                           }
      });
      lV52Ubigeowwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV52Ubigeowwds_1_filterfulltext), "%", "") ;
      lV52Ubigeowwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV52Ubigeowwds_1_filterfulltext), "%", "") ;
      lV52Ubigeowwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV52Ubigeowwds_1_filterfulltext), "%", "") ;
      lV52Ubigeowwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV52Ubigeowwds_1_filterfulltext), "%", "") ;
      lV52Ubigeowwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV52Ubigeowwds_1_filterfulltext), "%", "") ;
      lV52Ubigeowwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV52Ubigeowwds_1_filterfulltext), "%", "") ;
      lV52Ubigeowwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV52Ubigeowwds_1_filterfulltext), "%", "") ;
      lV52Ubigeowwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV52Ubigeowwds_1_filterfulltext), "%", "") ;
      lV52Ubigeowwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV52Ubigeowwds_1_filterfulltext), "%", "") ;
      lV52Ubigeowwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV52Ubigeowwds_1_filterfulltext), "%", "") ;
      lV53Ubigeowwds_2_tfubigeocode = GXutil.padr( GXutil.rtrim( AV53Ubigeowwds_2_tfubigeocode), 10, "%") ;
      lV55Ubigeowwds_4_tfubigeodepartamento = GXutil.concat( GXutil.rtrim( AV55Ubigeowwds_4_tfubigeodepartamento), "%", "") ;
      lV57Ubigeowwds_6_tfubigeodepartamentocode = GXutil.concat( GXutil.rtrim( AV57Ubigeowwds_6_tfubigeodepartamentocode), "%", "") ;
      lV59Ubigeowwds_8_tfubigeoprovincia = GXutil.concat( GXutil.rtrim( AV59Ubigeowwds_8_tfubigeoprovincia), "%", "") ;
      lV61Ubigeowwds_10_tfubigeoprovinciacode = GXutil.concat( GXutil.rtrim( AV61Ubigeowwds_10_tfubigeoprovinciacode), "%", "") ;
      lV63Ubigeowwds_12_tfubigeodistrito = GXutil.concat( GXutil.rtrim( AV63Ubigeowwds_12_tfubigeodistrito), "%", "") ;
      lV65Ubigeowwds_14_tfubigeodistritocode = GXutil.concat( GXutil.rtrim( AV65Ubigeowwds_14_tfubigeodistritocode), "%", "") ;
      lV67Ubigeowwds_16_tfubigeonombre = GXutil.concat( GXutil.rtrim( AV67Ubigeowwds_16_tfubigeonombre), "%", "") ;
      /* Using cursor P003L3 */
      pr_default.execute(1, new Object[] {lV52Ubigeowwds_1_filterfulltext, lV52Ubigeowwds_1_filterfulltext, lV52Ubigeowwds_1_filterfulltext, lV52Ubigeowwds_1_filterfulltext, lV52Ubigeowwds_1_filterfulltext, lV52Ubigeowwds_1_filterfulltext, lV52Ubigeowwds_1_filterfulltext, lV52Ubigeowwds_1_filterfulltext, lV52Ubigeowwds_1_filterfulltext, lV52Ubigeowwds_1_filterfulltext, lV53Ubigeowwds_2_tfubigeocode, AV54Ubigeowwds_3_tfubigeocode_sel, lV55Ubigeowwds_4_tfubigeodepartamento, AV56Ubigeowwds_5_tfubigeodepartamento_sel, lV57Ubigeowwds_6_tfubigeodepartamentocode, AV58Ubigeowwds_7_tfubigeodepartamentocode_sel, lV59Ubigeowwds_8_tfubigeoprovincia, AV60Ubigeowwds_9_tfubigeoprovincia_sel, lV61Ubigeowwds_10_tfubigeoprovinciacode, AV62Ubigeowwds_11_tfubigeoprovinciacode_sel, lV63Ubigeowwds_12_tfubigeodistrito, AV64Ubigeowwds_13_tfubigeodistrito_sel, lV65Ubigeowwds_14_tfubigeodistritocode, AV66Ubigeowwds_15_tfubigeodistritocode_sel, lV67Ubigeowwds_16_tfubigeonombre, AV68Ubigeowwds_17_tfubigeonombre_sel});
      while ( (pr_default.getStatus(1) != 101) )
      {
         brk3L3 = false ;
         A294UbigeoEstado = P003L3_A294UbigeoEstado[0] ;
         A44UbigeoCode = P003L3_A44UbigeoCode[0] ;
         A188UbigeoDistrito = P003L3_A188UbigeoDistrito[0] ;
         A187UbigeoProvincia = P003L3_A187UbigeoProvincia[0] ;
         A186UbigeoDepartamento = P003L3_A186UbigeoDepartamento[0] ;
         A185UbigeoNombre = A186UbigeoDepartamento + " / " + A187UbigeoProvincia + " / " + A188UbigeoDistrito ;
         A295UbigeoDepartamentoCode = GXutil.substring( A44UbigeoCode, 1, 2) ;
         A296UbigeoProvinciaCode = GXutil.substring( A44UbigeoCode, 3, 2) ;
         A297UbigeoDistritoCode = GXutil.substring( A44UbigeoCode, 5, 2) ;
         AV41count = 0 ;
         while ( (pr_default.getStatus(1) != 101) && ( GXutil.strcmp(P003L3_A186UbigeoDepartamento[0], A186UbigeoDepartamento) == 0 ) )
         {
            brk3L3 = false ;
            A44UbigeoCode = P003L3_A44UbigeoCode[0] ;
            AV41count = (long)(AV41count+1) ;
            brk3L3 = true ;
            pr_default.readNext(1);
         }
         if ( ! (GXutil.strcmp("", A186UbigeoDepartamento)==0) )
         {
            AV33Option = A186UbigeoDepartamento ;
            AV34Options.add(AV33Option, 0);
            AV39OptionIndexes.add(GXutil.trim( localUtil.format( DecimalUtil.doubleToDec(AV41count), "Z,ZZZ,ZZZ,ZZ9")), 0);
         }
         if ( AV34Options.size() == 50 )
         {
            /* Exit For each command. Update data (if necessary), close cursors & exit. */
            if (true) break;
         }
         if ( ! brk3L3 )
         {
            brk3L3 = true ;
            pr_default.readNext(1);
         }
      }
      pr_default.close(1);
   }

   public void S141( )
   {
      /* 'LOADUBIGEODEPARTAMENTOCODEOPTIONS' Routine */
      returnInSub = false ;
      AV15TFUbigeoDepartamentoCode = AV29SearchTxt ;
      AV16TFUbigeoDepartamentoCode_Sel = "" ;
      AV52Ubigeowwds_1_filterfulltext = AV47FilterFullText ;
      AV53Ubigeowwds_2_tfubigeocode = AV11TFUbigeoCode ;
      AV54Ubigeowwds_3_tfubigeocode_sel = AV12TFUbigeoCode_Sel ;
      AV55Ubigeowwds_4_tfubigeodepartamento = AV13TFUbigeoDepartamento ;
      AV56Ubigeowwds_5_tfubigeodepartamento_sel = AV14TFUbigeoDepartamento_Sel ;
      AV57Ubigeowwds_6_tfubigeodepartamentocode = AV15TFUbigeoDepartamentoCode ;
      AV58Ubigeowwds_7_tfubigeodepartamentocode_sel = AV16TFUbigeoDepartamentoCode_Sel ;
      AV59Ubigeowwds_8_tfubigeoprovincia = AV17TFUbigeoProvincia ;
      AV60Ubigeowwds_9_tfubigeoprovincia_sel = AV18TFUbigeoProvincia_Sel ;
      AV61Ubigeowwds_10_tfubigeoprovinciacode = AV19TFUbigeoProvinciaCode ;
      AV62Ubigeowwds_11_tfubigeoprovinciacode_sel = AV20TFUbigeoProvinciaCode_Sel ;
      AV63Ubigeowwds_12_tfubigeodistrito = AV21TFUbigeoDistrito ;
      AV64Ubigeowwds_13_tfubigeodistrito_sel = AV22TFUbigeoDistrito_Sel ;
      AV65Ubigeowwds_14_tfubigeodistritocode = AV23TFUbigeoDistritoCode ;
      AV66Ubigeowwds_15_tfubigeodistritocode_sel = AV24TFUbigeoDistritoCode_Sel ;
      AV67Ubigeowwds_16_tfubigeonombre = AV25TFUbigeoNombre ;
      AV68Ubigeowwds_17_tfubigeonombre_sel = AV26TFUbigeoNombre_Sel ;
      AV69Ubigeowwds_18_tfubigeoestado_sels = AV28TFUbigeoEstado_Sels ;
      pr_default.dynParam(2, new Object[]{ new Object[]{
                                           A294UbigeoEstado ,
                                           AV69Ubigeowwds_18_tfubigeoestado_sels ,
                                           AV52Ubigeowwds_1_filterfulltext ,
                                           AV54Ubigeowwds_3_tfubigeocode_sel ,
                                           AV53Ubigeowwds_2_tfubigeocode ,
                                           AV56Ubigeowwds_5_tfubigeodepartamento_sel ,
                                           AV55Ubigeowwds_4_tfubigeodepartamento ,
                                           AV58Ubigeowwds_7_tfubigeodepartamentocode_sel ,
                                           AV57Ubigeowwds_6_tfubigeodepartamentocode ,
                                           AV60Ubigeowwds_9_tfubigeoprovincia_sel ,
                                           AV59Ubigeowwds_8_tfubigeoprovincia ,
                                           AV62Ubigeowwds_11_tfubigeoprovinciacode_sel ,
                                           AV61Ubigeowwds_10_tfubigeoprovinciacode ,
                                           AV64Ubigeowwds_13_tfubigeodistrito_sel ,
                                           AV63Ubigeowwds_12_tfubigeodistrito ,
                                           AV66Ubigeowwds_15_tfubigeodistritocode_sel ,
                                           AV65Ubigeowwds_14_tfubigeodistritocode ,
                                           AV68Ubigeowwds_17_tfubigeonombre_sel ,
                                           AV67Ubigeowwds_16_tfubigeonombre ,
                                           Integer.valueOf(AV69Ubigeowwds_18_tfubigeoestado_sels.size()) ,
                                           A44UbigeoCode ,
                                           A186UbigeoDepartamento ,
                                           A187UbigeoProvincia ,
                                           A188UbigeoDistrito } ,
                                           new int[]{
                                           TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING,
                                           TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.INT, TypeConstants.STRING,
                                           TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING
                                           }
      });
      lV52Ubigeowwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV52Ubigeowwds_1_filterfulltext), "%", "") ;
      lV52Ubigeowwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV52Ubigeowwds_1_filterfulltext), "%", "") ;
      lV52Ubigeowwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV52Ubigeowwds_1_filterfulltext), "%", "") ;
      lV52Ubigeowwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV52Ubigeowwds_1_filterfulltext), "%", "") ;
      lV52Ubigeowwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV52Ubigeowwds_1_filterfulltext), "%", "") ;
      lV52Ubigeowwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV52Ubigeowwds_1_filterfulltext), "%", "") ;
      lV52Ubigeowwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV52Ubigeowwds_1_filterfulltext), "%", "") ;
      lV52Ubigeowwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV52Ubigeowwds_1_filterfulltext), "%", "") ;
      lV52Ubigeowwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV52Ubigeowwds_1_filterfulltext), "%", "") ;
      lV52Ubigeowwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV52Ubigeowwds_1_filterfulltext), "%", "") ;
      lV53Ubigeowwds_2_tfubigeocode = GXutil.padr( GXutil.rtrim( AV53Ubigeowwds_2_tfubigeocode), 10, "%") ;
      lV55Ubigeowwds_4_tfubigeodepartamento = GXutil.concat( GXutil.rtrim( AV55Ubigeowwds_4_tfubigeodepartamento), "%", "") ;
      lV57Ubigeowwds_6_tfubigeodepartamentocode = GXutil.concat( GXutil.rtrim( AV57Ubigeowwds_6_tfubigeodepartamentocode), "%", "") ;
      lV59Ubigeowwds_8_tfubigeoprovincia = GXutil.concat( GXutil.rtrim( AV59Ubigeowwds_8_tfubigeoprovincia), "%", "") ;
      lV61Ubigeowwds_10_tfubigeoprovinciacode = GXutil.concat( GXutil.rtrim( AV61Ubigeowwds_10_tfubigeoprovinciacode), "%", "") ;
      lV63Ubigeowwds_12_tfubigeodistrito = GXutil.concat( GXutil.rtrim( AV63Ubigeowwds_12_tfubigeodistrito), "%", "") ;
      lV65Ubigeowwds_14_tfubigeodistritocode = GXutil.concat( GXutil.rtrim( AV65Ubigeowwds_14_tfubigeodistritocode), "%", "") ;
      lV67Ubigeowwds_16_tfubigeonombre = GXutil.concat( GXutil.rtrim( AV67Ubigeowwds_16_tfubigeonombre), "%", "") ;
      /* Using cursor P003L4 */
      pr_default.execute(2, new Object[] {lV52Ubigeowwds_1_filterfulltext, lV52Ubigeowwds_1_filterfulltext, lV52Ubigeowwds_1_filterfulltext, lV52Ubigeowwds_1_filterfulltext, lV52Ubigeowwds_1_filterfulltext, lV52Ubigeowwds_1_filterfulltext, lV52Ubigeowwds_1_filterfulltext, lV52Ubigeowwds_1_filterfulltext, lV52Ubigeowwds_1_filterfulltext, lV52Ubigeowwds_1_filterfulltext, lV53Ubigeowwds_2_tfubigeocode, AV54Ubigeowwds_3_tfubigeocode_sel, lV55Ubigeowwds_4_tfubigeodepartamento, AV56Ubigeowwds_5_tfubigeodepartamento_sel, lV57Ubigeowwds_6_tfubigeodepartamentocode, AV58Ubigeowwds_7_tfubigeodepartamentocode_sel, lV59Ubigeowwds_8_tfubigeoprovincia, AV60Ubigeowwds_9_tfubigeoprovincia_sel, lV61Ubigeowwds_10_tfubigeoprovinciacode, AV62Ubigeowwds_11_tfubigeoprovinciacode_sel, lV63Ubigeowwds_12_tfubigeodistrito, AV64Ubigeowwds_13_tfubigeodistrito_sel, lV65Ubigeowwds_14_tfubigeodistritocode, AV66Ubigeowwds_15_tfubigeodistritocode_sel, lV67Ubigeowwds_16_tfubigeonombre, AV68Ubigeowwds_17_tfubigeonombre_sel});
      while ( (pr_default.getStatus(2) != 101) )
      {
         A294UbigeoEstado = P003L4_A294UbigeoEstado[0] ;
         A44UbigeoCode = P003L4_A44UbigeoCode[0] ;
         A188UbigeoDistrito = P003L4_A188UbigeoDistrito[0] ;
         A187UbigeoProvincia = P003L4_A187UbigeoProvincia[0] ;
         A186UbigeoDepartamento = P003L4_A186UbigeoDepartamento[0] ;
         A185UbigeoNombre = A186UbigeoDepartamento + " / " + A187UbigeoProvincia + " / " + A188UbigeoDistrito ;
         A295UbigeoDepartamentoCode = GXutil.substring( A44UbigeoCode, 1, 2) ;
         A296UbigeoProvinciaCode = GXutil.substring( A44UbigeoCode, 3, 2) ;
         A297UbigeoDistritoCode = GXutil.substring( A44UbigeoCode, 5, 2) ;
         if ( ! (GXutil.strcmp("", A295UbigeoDepartamentoCode)==0) )
         {
            AV33Option = A295UbigeoDepartamentoCode ;
            AV32InsertIndex = 1 ;
            while ( ( AV32InsertIndex <= AV34Options.size() ) && ( GXutil.strcmp((String)AV34Options.elementAt(-1+AV32InsertIndex), AV33Option) < 0 ) )
            {
               AV32InsertIndex = (int)(AV32InsertIndex+1) ;
            }
            if ( ( AV32InsertIndex <= AV34Options.size() ) && ( GXutil.strcmp((String)AV34Options.elementAt(-1+AV32InsertIndex), AV33Option) == 0 ) )
            {
               AV41count = GXutil.lval( (String)AV39OptionIndexes.elementAt(-1+AV32InsertIndex)) ;
               AV41count = (long)(AV41count+1) ;
               AV39OptionIndexes.removeItem(AV32InsertIndex);
               AV39OptionIndexes.add(GXutil.trim( localUtil.format( DecimalUtil.doubleToDec(AV41count), "Z,ZZZ,ZZZ,ZZ9")), AV32InsertIndex);
            }
            else
            {
               AV34Options.add(AV33Option, AV32InsertIndex);
               AV39OptionIndexes.add("1", AV32InsertIndex);
            }
         }
         if ( AV34Options.size() == 50 )
         {
            /* Exit For each command. Update data (if necessary), close cursors & exit. */
            if (true) break;
         }
         pr_default.readNext(2);
      }
      pr_default.close(2);
   }

   public void S151( )
   {
      /* 'LOADUBIGEOPROVINCIAOPTIONS' Routine */
      returnInSub = false ;
      AV17TFUbigeoProvincia = AV29SearchTxt ;
      AV18TFUbigeoProvincia_Sel = "" ;
      AV52Ubigeowwds_1_filterfulltext = AV47FilterFullText ;
      AV53Ubigeowwds_2_tfubigeocode = AV11TFUbigeoCode ;
      AV54Ubigeowwds_3_tfubigeocode_sel = AV12TFUbigeoCode_Sel ;
      AV55Ubigeowwds_4_tfubigeodepartamento = AV13TFUbigeoDepartamento ;
      AV56Ubigeowwds_5_tfubigeodepartamento_sel = AV14TFUbigeoDepartamento_Sel ;
      AV57Ubigeowwds_6_tfubigeodepartamentocode = AV15TFUbigeoDepartamentoCode ;
      AV58Ubigeowwds_7_tfubigeodepartamentocode_sel = AV16TFUbigeoDepartamentoCode_Sel ;
      AV59Ubigeowwds_8_tfubigeoprovincia = AV17TFUbigeoProvincia ;
      AV60Ubigeowwds_9_tfubigeoprovincia_sel = AV18TFUbigeoProvincia_Sel ;
      AV61Ubigeowwds_10_tfubigeoprovinciacode = AV19TFUbigeoProvinciaCode ;
      AV62Ubigeowwds_11_tfubigeoprovinciacode_sel = AV20TFUbigeoProvinciaCode_Sel ;
      AV63Ubigeowwds_12_tfubigeodistrito = AV21TFUbigeoDistrito ;
      AV64Ubigeowwds_13_tfubigeodistrito_sel = AV22TFUbigeoDistrito_Sel ;
      AV65Ubigeowwds_14_tfubigeodistritocode = AV23TFUbigeoDistritoCode ;
      AV66Ubigeowwds_15_tfubigeodistritocode_sel = AV24TFUbigeoDistritoCode_Sel ;
      AV67Ubigeowwds_16_tfubigeonombre = AV25TFUbigeoNombre ;
      AV68Ubigeowwds_17_tfubigeonombre_sel = AV26TFUbigeoNombre_Sel ;
      AV69Ubigeowwds_18_tfubigeoestado_sels = AV28TFUbigeoEstado_Sels ;
      pr_default.dynParam(3, new Object[]{ new Object[]{
                                           A294UbigeoEstado ,
                                           AV69Ubigeowwds_18_tfubigeoestado_sels ,
                                           AV52Ubigeowwds_1_filterfulltext ,
                                           AV54Ubigeowwds_3_tfubigeocode_sel ,
                                           AV53Ubigeowwds_2_tfubigeocode ,
                                           AV56Ubigeowwds_5_tfubigeodepartamento_sel ,
                                           AV55Ubigeowwds_4_tfubigeodepartamento ,
                                           AV58Ubigeowwds_7_tfubigeodepartamentocode_sel ,
                                           AV57Ubigeowwds_6_tfubigeodepartamentocode ,
                                           AV60Ubigeowwds_9_tfubigeoprovincia_sel ,
                                           AV59Ubigeowwds_8_tfubigeoprovincia ,
                                           AV62Ubigeowwds_11_tfubigeoprovinciacode_sel ,
                                           AV61Ubigeowwds_10_tfubigeoprovinciacode ,
                                           AV64Ubigeowwds_13_tfubigeodistrito_sel ,
                                           AV63Ubigeowwds_12_tfubigeodistrito ,
                                           AV66Ubigeowwds_15_tfubigeodistritocode_sel ,
                                           AV65Ubigeowwds_14_tfubigeodistritocode ,
                                           AV68Ubigeowwds_17_tfubigeonombre_sel ,
                                           AV67Ubigeowwds_16_tfubigeonombre ,
                                           Integer.valueOf(AV69Ubigeowwds_18_tfubigeoestado_sels.size()) ,
                                           A44UbigeoCode ,
                                           A186UbigeoDepartamento ,
                                           A187UbigeoProvincia ,
                                           A188UbigeoDistrito } ,
                                           new int[]{
                                           TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING,
                                           TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.INT, TypeConstants.STRING,
                                           TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING
                                           }
      });
      lV52Ubigeowwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV52Ubigeowwds_1_filterfulltext), "%", "") ;
      lV52Ubigeowwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV52Ubigeowwds_1_filterfulltext), "%", "") ;
      lV52Ubigeowwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV52Ubigeowwds_1_filterfulltext), "%", "") ;
      lV52Ubigeowwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV52Ubigeowwds_1_filterfulltext), "%", "") ;
      lV52Ubigeowwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV52Ubigeowwds_1_filterfulltext), "%", "") ;
      lV52Ubigeowwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV52Ubigeowwds_1_filterfulltext), "%", "") ;
      lV52Ubigeowwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV52Ubigeowwds_1_filterfulltext), "%", "") ;
      lV52Ubigeowwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV52Ubigeowwds_1_filterfulltext), "%", "") ;
      lV52Ubigeowwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV52Ubigeowwds_1_filterfulltext), "%", "") ;
      lV52Ubigeowwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV52Ubigeowwds_1_filterfulltext), "%", "") ;
      lV53Ubigeowwds_2_tfubigeocode = GXutil.padr( GXutil.rtrim( AV53Ubigeowwds_2_tfubigeocode), 10, "%") ;
      lV55Ubigeowwds_4_tfubigeodepartamento = GXutil.concat( GXutil.rtrim( AV55Ubigeowwds_4_tfubigeodepartamento), "%", "") ;
      lV57Ubigeowwds_6_tfubigeodepartamentocode = GXutil.concat( GXutil.rtrim( AV57Ubigeowwds_6_tfubigeodepartamentocode), "%", "") ;
      lV59Ubigeowwds_8_tfubigeoprovincia = GXutil.concat( GXutil.rtrim( AV59Ubigeowwds_8_tfubigeoprovincia), "%", "") ;
      lV61Ubigeowwds_10_tfubigeoprovinciacode = GXutil.concat( GXutil.rtrim( AV61Ubigeowwds_10_tfubigeoprovinciacode), "%", "") ;
      lV63Ubigeowwds_12_tfubigeodistrito = GXutil.concat( GXutil.rtrim( AV63Ubigeowwds_12_tfubigeodistrito), "%", "") ;
      lV65Ubigeowwds_14_tfubigeodistritocode = GXutil.concat( GXutil.rtrim( AV65Ubigeowwds_14_tfubigeodistritocode), "%", "") ;
      lV67Ubigeowwds_16_tfubigeonombre = GXutil.concat( GXutil.rtrim( AV67Ubigeowwds_16_tfubigeonombre), "%", "") ;
      /* Using cursor P003L5 */
      pr_default.execute(3, new Object[] {lV52Ubigeowwds_1_filterfulltext, lV52Ubigeowwds_1_filterfulltext, lV52Ubigeowwds_1_filterfulltext, lV52Ubigeowwds_1_filterfulltext, lV52Ubigeowwds_1_filterfulltext, lV52Ubigeowwds_1_filterfulltext, lV52Ubigeowwds_1_filterfulltext, lV52Ubigeowwds_1_filterfulltext, lV52Ubigeowwds_1_filterfulltext, lV52Ubigeowwds_1_filterfulltext, lV53Ubigeowwds_2_tfubigeocode, AV54Ubigeowwds_3_tfubigeocode_sel, lV55Ubigeowwds_4_tfubigeodepartamento, AV56Ubigeowwds_5_tfubigeodepartamento_sel, lV57Ubigeowwds_6_tfubigeodepartamentocode, AV58Ubigeowwds_7_tfubigeodepartamentocode_sel, lV59Ubigeowwds_8_tfubigeoprovincia, AV60Ubigeowwds_9_tfubigeoprovincia_sel, lV61Ubigeowwds_10_tfubigeoprovinciacode, AV62Ubigeowwds_11_tfubigeoprovinciacode_sel, lV63Ubigeowwds_12_tfubigeodistrito, AV64Ubigeowwds_13_tfubigeodistrito_sel, lV65Ubigeowwds_14_tfubigeodistritocode, AV66Ubigeowwds_15_tfubigeodistritocode_sel, lV67Ubigeowwds_16_tfubigeonombre, AV68Ubigeowwds_17_tfubigeonombre_sel});
      while ( (pr_default.getStatus(3) != 101) )
      {
         brk3L6 = false ;
         A294UbigeoEstado = P003L5_A294UbigeoEstado[0] ;
         A44UbigeoCode = P003L5_A44UbigeoCode[0] ;
         A188UbigeoDistrito = P003L5_A188UbigeoDistrito[0] ;
         A187UbigeoProvincia = P003L5_A187UbigeoProvincia[0] ;
         A186UbigeoDepartamento = P003L5_A186UbigeoDepartamento[0] ;
         A185UbigeoNombre = A186UbigeoDepartamento + " / " + A187UbigeoProvincia + " / " + A188UbigeoDistrito ;
         A295UbigeoDepartamentoCode = GXutil.substring( A44UbigeoCode, 1, 2) ;
         A296UbigeoProvinciaCode = GXutil.substring( A44UbigeoCode, 3, 2) ;
         A297UbigeoDistritoCode = GXutil.substring( A44UbigeoCode, 5, 2) ;
         AV41count = 0 ;
         while ( (pr_default.getStatus(3) != 101) && ( GXutil.strcmp(P003L5_A187UbigeoProvincia[0], A187UbigeoProvincia) == 0 ) )
         {
            brk3L6 = false ;
            A44UbigeoCode = P003L5_A44UbigeoCode[0] ;
            AV41count = (long)(AV41count+1) ;
            brk3L6 = true ;
            pr_default.readNext(3);
         }
         if ( ! (GXutil.strcmp("", A187UbigeoProvincia)==0) )
         {
            AV33Option = A187UbigeoProvincia ;
            AV34Options.add(AV33Option, 0);
            AV39OptionIndexes.add(GXutil.trim( localUtil.format( DecimalUtil.doubleToDec(AV41count), "Z,ZZZ,ZZZ,ZZ9")), 0);
         }
         if ( AV34Options.size() == 50 )
         {
            /* Exit For each command. Update data (if necessary), close cursors & exit. */
            if (true) break;
         }
         if ( ! brk3L6 )
         {
            brk3L6 = true ;
            pr_default.readNext(3);
         }
      }
      pr_default.close(3);
   }

   public void S161( )
   {
      /* 'LOADUBIGEOPROVINCIACODEOPTIONS' Routine */
      returnInSub = false ;
      AV19TFUbigeoProvinciaCode = AV29SearchTxt ;
      AV20TFUbigeoProvinciaCode_Sel = "" ;
      AV52Ubigeowwds_1_filterfulltext = AV47FilterFullText ;
      AV53Ubigeowwds_2_tfubigeocode = AV11TFUbigeoCode ;
      AV54Ubigeowwds_3_tfubigeocode_sel = AV12TFUbigeoCode_Sel ;
      AV55Ubigeowwds_4_tfubigeodepartamento = AV13TFUbigeoDepartamento ;
      AV56Ubigeowwds_5_tfubigeodepartamento_sel = AV14TFUbigeoDepartamento_Sel ;
      AV57Ubigeowwds_6_tfubigeodepartamentocode = AV15TFUbigeoDepartamentoCode ;
      AV58Ubigeowwds_7_tfubigeodepartamentocode_sel = AV16TFUbigeoDepartamentoCode_Sel ;
      AV59Ubigeowwds_8_tfubigeoprovincia = AV17TFUbigeoProvincia ;
      AV60Ubigeowwds_9_tfubigeoprovincia_sel = AV18TFUbigeoProvincia_Sel ;
      AV61Ubigeowwds_10_tfubigeoprovinciacode = AV19TFUbigeoProvinciaCode ;
      AV62Ubigeowwds_11_tfubigeoprovinciacode_sel = AV20TFUbigeoProvinciaCode_Sel ;
      AV63Ubigeowwds_12_tfubigeodistrito = AV21TFUbigeoDistrito ;
      AV64Ubigeowwds_13_tfubigeodistrito_sel = AV22TFUbigeoDistrito_Sel ;
      AV65Ubigeowwds_14_tfubigeodistritocode = AV23TFUbigeoDistritoCode ;
      AV66Ubigeowwds_15_tfubigeodistritocode_sel = AV24TFUbigeoDistritoCode_Sel ;
      AV67Ubigeowwds_16_tfubigeonombre = AV25TFUbigeoNombre ;
      AV68Ubigeowwds_17_tfubigeonombre_sel = AV26TFUbigeoNombre_Sel ;
      AV69Ubigeowwds_18_tfubigeoestado_sels = AV28TFUbigeoEstado_Sels ;
      pr_default.dynParam(4, new Object[]{ new Object[]{
                                           A294UbigeoEstado ,
                                           AV69Ubigeowwds_18_tfubigeoestado_sels ,
                                           AV52Ubigeowwds_1_filterfulltext ,
                                           AV54Ubigeowwds_3_tfubigeocode_sel ,
                                           AV53Ubigeowwds_2_tfubigeocode ,
                                           AV56Ubigeowwds_5_tfubigeodepartamento_sel ,
                                           AV55Ubigeowwds_4_tfubigeodepartamento ,
                                           AV58Ubigeowwds_7_tfubigeodepartamentocode_sel ,
                                           AV57Ubigeowwds_6_tfubigeodepartamentocode ,
                                           AV60Ubigeowwds_9_tfubigeoprovincia_sel ,
                                           AV59Ubigeowwds_8_tfubigeoprovincia ,
                                           AV62Ubigeowwds_11_tfubigeoprovinciacode_sel ,
                                           AV61Ubigeowwds_10_tfubigeoprovinciacode ,
                                           AV64Ubigeowwds_13_tfubigeodistrito_sel ,
                                           AV63Ubigeowwds_12_tfubigeodistrito ,
                                           AV66Ubigeowwds_15_tfubigeodistritocode_sel ,
                                           AV65Ubigeowwds_14_tfubigeodistritocode ,
                                           AV68Ubigeowwds_17_tfubigeonombre_sel ,
                                           AV67Ubigeowwds_16_tfubigeonombre ,
                                           Integer.valueOf(AV69Ubigeowwds_18_tfubigeoestado_sels.size()) ,
                                           A44UbigeoCode ,
                                           A186UbigeoDepartamento ,
                                           A187UbigeoProvincia ,
                                           A188UbigeoDistrito } ,
                                           new int[]{
                                           TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING,
                                           TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.INT, TypeConstants.STRING,
                                           TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING
                                           }
      });
      lV52Ubigeowwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV52Ubigeowwds_1_filterfulltext), "%", "") ;
      lV52Ubigeowwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV52Ubigeowwds_1_filterfulltext), "%", "") ;
      lV52Ubigeowwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV52Ubigeowwds_1_filterfulltext), "%", "") ;
      lV52Ubigeowwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV52Ubigeowwds_1_filterfulltext), "%", "") ;
      lV52Ubigeowwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV52Ubigeowwds_1_filterfulltext), "%", "") ;
      lV52Ubigeowwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV52Ubigeowwds_1_filterfulltext), "%", "") ;
      lV52Ubigeowwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV52Ubigeowwds_1_filterfulltext), "%", "") ;
      lV52Ubigeowwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV52Ubigeowwds_1_filterfulltext), "%", "") ;
      lV52Ubigeowwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV52Ubigeowwds_1_filterfulltext), "%", "") ;
      lV52Ubigeowwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV52Ubigeowwds_1_filterfulltext), "%", "") ;
      lV53Ubigeowwds_2_tfubigeocode = GXutil.padr( GXutil.rtrim( AV53Ubigeowwds_2_tfubigeocode), 10, "%") ;
      lV55Ubigeowwds_4_tfubigeodepartamento = GXutil.concat( GXutil.rtrim( AV55Ubigeowwds_4_tfubigeodepartamento), "%", "") ;
      lV57Ubigeowwds_6_tfubigeodepartamentocode = GXutil.concat( GXutil.rtrim( AV57Ubigeowwds_6_tfubigeodepartamentocode), "%", "") ;
      lV59Ubigeowwds_8_tfubigeoprovincia = GXutil.concat( GXutil.rtrim( AV59Ubigeowwds_8_tfubigeoprovincia), "%", "") ;
      lV61Ubigeowwds_10_tfubigeoprovinciacode = GXutil.concat( GXutil.rtrim( AV61Ubigeowwds_10_tfubigeoprovinciacode), "%", "") ;
      lV63Ubigeowwds_12_tfubigeodistrito = GXutil.concat( GXutil.rtrim( AV63Ubigeowwds_12_tfubigeodistrito), "%", "") ;
      lV65Ubigeowwds_14_tfubigeodistritocode = GXutil.concat( GXutil.rtrim( AV65Ubigeowwds_14_tfubigeodistritocode), "%", "") ;
      lV67Ubigeowwds_16_tfubigeonombre = GXutil.concat( GXutil.rtrim( AV67Ubigeowwds_16_tfubigeonombre), "%", "") ;
      /* Using cursor P003L6 */
      pr_default.execute(4, new Object[] {lV52Ubigeowwds_1_filterfulltext, lV52Ubigeowwds_1_filterfulltext, lV52Ubigeowwds_1_filterfulltext, lV52Ubigeowwds_1_filterfulltext, lV52Ubigeowwds_1_filterfulltext, lV52Ubigeowwds_1_filterfulltext, lV52Ubigeowwds_1_filterfulltext, lV52Ubigeowwds_1_filterfulltext, lV52Ubigeowwds_1_filterfulltext, lV52Ubigeowwds_1_filterfulltext, lV53Ubigeowwds_2_tfubigeocode, AV54Ubigeowwds_3_tfubigeocode_sel, lV55Ubigeowwds_4_tfubigeodepartamento, AV56Ubigeowwds_5_tfubigeodepartamento_sel, lV57Ubigeowwds_6_tfubigeodepartamentocode, AV58Ubigeowwds_7_tfubigeodepartamentocode_sel, lV59Ubigeowwds_8_tfubigeoprovincia, AV60Ubigeowwds_9_tfubigeoprovincia_sel, lV61Ubigeowwds_10_tfubigeoprovinciacode, AV62Ubigeowwds_11_tfubigeoprovinciacode_sel, lV63Ubigeowwds_12_tfubigeodistrito, AV64Ubigeowwds_13_tfubigeodistrito_sel, lV65Ubigeowwds_14_tfubigeodistritocode, AV66Ubigeowwds_15_tfubigeodistritocode_sel, lV67Ubigeowwds_16_tfubigeonombre, AV68Ubigeowwds_17_tfubigeonombre_sel});
      while ( (pr_default.getStatus(4) != 101) )
      {
         A294UbigeoEstado = P003L6_A294UbigeoEstado[0] ;
         A44UbigeoCode = P003L6_A44UbigeoCode[0] ;
         A188UbigeoDistrito = P003L6_A188UbigeoDistrito[0] ;
         A187UbigeoProvincia = P003L6_A187UbigeoProvincia[0] ;
         A186UbigeoDepartamento = P003L6_A186UbigeoDepartamento[0] ;
         A185UbigeoNombre = A186UbigeoDepartamento + " / " + A187UbigeoProvincia + " / " + A188UbigeoDistrito ;
         A295UbigeoDepartamentoCode = GXutil.substring( A44UbigeoCode, 1, 2) ;
         A296UbigeoProvinciaCode = GXutil.substring( A44UbigeoCode, 3, 2) ;
         A297UbigeoDistritoCode = GXutil.substring( A44UbigeoCode, 5, 2) ;
         if ( ! (GXutil.strcmp("", A296UbigeoProvinciaCode)==0) )
         {
            AV33Option = A296UbigeoProvinciaCode ;
            AV32InsertIndex = 1 ;
            while ( ( AV32InsertIndex <= AV34Options.size() ) && ( GXutil.strcmp((String)AV34Options.elementAt(-1+AV32InsertIndex), AV33Option) < 0 ) )
            {
               AV32InsertIndex = (int)(AV32InsertIndex+1) ;
            }
            if ( ( AV32InsertIndex <= AV34Options.size() ) && ( GXutil.strcmp((String)AV34Options.elementAt(-1+AV32InsertIndex), AV33Option) == 0 ) )
            {
               AV41count = GXutil.lval( (String)AV39OptionIndexes.elementAt(-1+AV32InsertIndex)) ;
               AV41count = (long)(AV41count+1) ;
               AV39OptionIndexes.removeItem(AV32InsertIndex);
               AV39OptionIndexes.add(GXutil.trim( localUtil.format( DecimalUtil.doubleToDec(AV41count), "Z,ZZZ,ZZZ,ZZ9")), AV32InsertIndex);
            }
            else
            {
               AV34Options.add(AV33Option, AV32InsertIndex);
               AV39OptionIndexes.add("1", AV32InsertIndex);
            }
         }
         if ( AV34Options.size() == 50 )
         {
            /* Exit For each command. Update data (if necessary), close cursors & exit. */
            if (true) break;
         }
         pr_default.readNext(4);
      }
      pr_default.close(4);
   }

   public void S171( )
   {
      /* 'LOADUBIGEODISTRITOOPTIONS' Routine */
      returnInSub = false ;
      AV21TFUbigeoDistrito = AV29SearchTxt ;
      AV22TFUbigeoDistrito_Sel = "" ;
      AV52Ubigeowwds_1_filterfulltext = AV47FilterFullText ;
      AV53Ubigeowwds_2_tfubigeocode = AV11TFUbigeoCode ;
      AV54Ubigeowwds_3_tfubigeocode_sel = AV12TFUbigeoCode_Sel ;
      AV55Ubigeowwds_4_tfubigeodepartamento = AV13TFUbigeoDepartamento ;
      AV56Ubigeowwds_5_tfubigeodepartamento_sel = AV14TFUbigeoDepartamento_Sel ;
      AV57Ubigeowwds_6_tfubigeodepartamentocode = AV15TFUbigeoDepartamentoCode ;
      AV58Ubigeowwds_7_tfubigeodepartamentocode_sel = AV16TFUbigeoDepartamentoCode_Sel ;
      AV59Ubigeowwds_8_tfubigeoprovincia = AV17TFUbigeoProvincia ;
      AV60Ubigeowwds_9_tfubigeoprovincia_sel = AV18TFUbigeoProvincia_Sel ;
      AV61Ubigeowwds_10_tfubigeoprovinciacode = AV19TFUbigeoProvinciaCode ;
      AV62Ubigeowwds_11_tfubigeoprovinciacode_sel = AV20TFUbigeoProvinciaCode_Sel ;
      AV63Ubigeowwds_12_tfubigeodistrito = AV21TFUbigeoDistrito ;
      AV64Ubigeowwds_13_tfubigeodistrito_sel = AV22TFUbigeoDistrito_Sel ;
      AV65Ubigeowwds_14_tfubigeodistritocode = AV23TFUbigeoDistritoCode ;
      AV66Ubigeowwds_15_tfubigeodistritocode_sel = AV24TFUbigeoDistritoCode_Sel ;
      AV67Ubigeowwds_16_tfubigeonombre = AV25TFUbigeoNombre ;
      AV68Ubigeowwds_17_tfubigeonombre_sel = AV26TFUbigeoNombre_Sel ;
      AV69Ubigeowwds_18_tfubigeoestado_sels = AV28TFUbigeoEstado_Sels ;
      pr_default.dynParam(5, new Object[]{ new Object[]{
                                           A294UbigeoEstado ,
                                           AV69Ubigeowwds_18_tfubigeoestado_sels ,
                                           AV52Ubigeowwds_1_filterfulltext ,
                                           AV54Ubigeowwds_3_tfubigeocode_sel ,
                                           AV53Ubigeowwds_2_tfubigeocode ,
                                           AV56Ubigeowwds_5_tfubigeodepartamento_sel ,
                                           AV55Ubigeowwds_4_tfubigeodepartamento ,
                                           AV58Ubigeowwds_7_tfubigeodepartamentocode_sel ,
                                           AV57Ubigeowwds_6_tfubigeodepartamentocode ,
                                           AV60Ubigeowwds_9_tfubigeoprovincia_sel ,
                                           AV59Ubigeowwds_8_tfubigeoprovincia ,
                                           AV62Ubigeowwds_11_tfubigeoprovinciacode_sel ,
                                           AV61Ubigeowwds_10_tfubigeoprovinciacode ,
                                           AV64Ubigeowwds_13_tfubigeodistrito_sel ,
                                           AV63Ubigeowwds_12_tfubigeodistrito ,
                                           AV66Ubigeowwds_15_tfubigeodistritocode_sel ,
                                           AV65Ubigeowwds_14_tfubigeodistritocode ,
                                           AV68Ubigeowwds_17_tfubigeonombre_sel ,
                                           AV67Ubigeowwds_16_tfubigeonombre ,
                                           Integer.valueOf(AV69Ubigeowwds_18_tfubigeoestado_sels.size()) ,
                                           A44UbigeoCode ,
                                           A186UbigeoDepartamento ,
                                           A187UbigeoProvincia ,
                                           A188UbigeoDistrito } ,
                                           new int[]{
                                           TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING,
                                           TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.INT, TypeConstants.STRING,
                                           TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING
                                           }
      });
      lV52Ubigeowwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV52Ubigeowwds_1_filterfulltext), "%", "") ;
      lV52Ubigeowwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV52Ubigeowwds_1_filterfulltext), "%", "") ;
      lV52Ubigeowwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV52Ubigeowwds_1_filterfulltext), "%", "") ;
      lV52Ubigeowwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV52Ubigeowwds_1_filterfulltext), "%", "") ;
      lV52Ubigeowwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV52Ubigeowwds_1_filterfulltext), "%", "") ;
      lV52Ubigeowwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV52Ubigeowwds_1_filterfulltext), "%", "") ;
      lV52Ubigeowwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV52Ubigeowwds_1_filterfulltext), "%", "") ;
      lV52Ubigeowwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV52Ubigeowwds_1_filterfulltext), "%", "") ;
      lV52Ubigeowwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV52Ubigeowwds_1_filterfulltext), "%", "") ;
      lV52Ubigeowwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV52Ubigeowwds_1_filterfulltext), "%", "") ;
      lV53Ubigeowwds_2_tfubigeocode = GXutil.padr( GXutil.rtrim( AV53Ubigeowwds_2_tfubigeocode), 10, "%") ;
      lV55Ubigeowwds_4_tfubigeodepartamento = GXutil.concat( GXutil.rtrim( AV55Ubigeowwds_4_tfubigeodepartamento), "%", "") ;
      lV57Ubigeowwds_6_tfubigeodepartamentocode = GXutil.concat( GXutil.rtrim( AV57Ubigeowwds_6_tfubigeodepartamentocode), "%", "") ;
      lV59Ubigeowwds_8_tfubigeoprovincia = GXutil.concat( GXutil.rtrim( AV59Ubigeowwds_8_tfubigeoprovincia), "%", "") ;
      lV61Ubigeowwds_10_tfubigeoprovinciacode = GXutil.concat( GXutil.rtrim( AV61Ubigeowwds_10_tfubigeoprovinciacode), "%", "") ;
      lV63Ubigeowwds_12_tfubigeodistrito = GXutil.concat( GXutil.rtrim( AV63Ubigeowwds_12_tfubigeodistrito), "%", "") ;
      lV65Ubigeowwds_14_tfubigeodistritocode = GXutil.concat( GXutil.rtrim( AV65Ubigeowwds_14_tfubigeodistritocode), "%", "") ;
      lV67Ubigeowwds_16_tfubigeonombre = GXutil.concat( GXutil.rtrim( AV67Ubigeowwds_16_tfubigeonombre), "%", "") ;
      /* Using cursor P003L7 */
      pr_default.execute(5, new Object[] {lV52Ubigeowwds_1_filterfulltext, lV52Ubigeowwds_1_filterfulltext, lV52Ubigeowwds_1_filterfulltext, lV52Ubigeowwds_1_filterfulltext, lV52Ubigeowwds_1_filterfulltext, lV52Ubigeowwds_1_filterfulltext, lV52Ubigeowwds_1_filterfulltext, lV52Ubigeowwds_1_filterfulltext, lV52Ubigeowwds_1_filterfulltext, lV52Ubigeowwds_1_filterfulltext, lV53Ubigeowwds_2_tfubigeocode, AV54Ubigeowwds_3_tfubigeocode_sel, lV55Ubigeowwds_4_tfubigeodepartamento, AV56Ubigeowwds_5_tfubigeodepartamento_sel, lV57Ubigeowwds_6_tfubigeodepartamentocode, AV58Ubigeowwds_7_tfubigeodepartamentocode_sel, lV59Ubigeowwds_8_tfubigeoprovincia, AV60Ubigeowwds_9_tfubigeoprovincia_sel, lV61Ubigeowwds_10_tfubigeoprovinciacode, AV62Ubigeowwds_11_tfubigeoprovinciacode_sel, lV63Ubigeowwds_12_tfubigeodistrito, AV64Ubigeowwds_13_tfubigeodistrito_sel, lV65Ubigeowwds_14_tfubigeodistritocode, AV66Ubigeowwds_15_tfubigeodistritocode_sel, lV67Ubigeowwds_16_tfubigeonombre, AV68Ubigeowwds_17_tfubigeonombre_sel});
      while ( (pr_default.getStatus(5) != 101) )
      {
         brk3L9 = false ;
         A294UbigeoEstado = P003L7_A294UbigeoEstado[0] ;
         A44UbigeoCode = P003L7_A44UbigeoCode[0] ;
         A188UbigeoDistrito = P003L7_A188UbigeoDistrito[0] ;
         A187UbigeoProvincia = P003L7_A187UbigeoProvincia[0] ;
         A186UbigeoDepartamento = P003L7_A186UbigeoDepartamento[0] ;
         A185UbigeoNombre = A186UbigeoDepartamento + " / " + A187UbigeoProvincia + " / " + A188UbigeoDistrito ;
         A295UbigeoDepartamentoCode = GXutil.substring( A44UbigeoCode, 1, 2) ;
         A296UbigeoProvinciaCode = GXutil.substring( A44UbigeoCode, 3, 2) ;
         A297UbigeoDistritoCode = GXutil.substring( A44UbigeoCode, 5, 2) ;
         AV41count = 0 ;
         while ( (pr_default.getStatus(5) != 101) && ( GXutil.strcmp(P003L7_A188UbigeoDistrito[0], A188UbigeoDistrito) == 0 ) )
         {
            brk3L9 = false ;
            A44UbigeoCode = P003L7_A44UbigeoCode[0] ;
            AV41count = (long)(AV41count+1) ;
            brk3L9 = true ;
            pr_default.readNext(5);
         }
         if ( ! (GXutil.strcmp("", A188UbigeoDistrito)==0) )
         {
            AV33Option = A188UbigeoDistrito ;
            AV34Options.add(AV33Option, 0);
            AV39OptionIndexes.add(GXutil.trim( localUtil.format( DecimalUtil.doubleToDec(AV41count), "Z,ZZZ,ZZZ,ZZ9")), 0);
         }
         if ( AV34Options.size() == 50 )
         {
            /* Exit For each command. Update data (if necessary), close cursors & exit. */
            if (true) break;
         }
         if ( ! brk3L9 )
         {
            brk3L9 = true ;
            pr_default.readNext(5);
         }
      }
      pr_default.close(5);
   }

   public void S181( )
   {
      /* 'LOADUBIGEODISTRITOCODEOPTIONS' Routine */
      returnInSub = false ;
      AV23TFUbigeoDistritoCode = AV29SearchTxt ;
      AV24TFUbigeoDistritoCode_Sel = "" ;
      AV52Ubigeowwds_1_filterfulltext = AV47FilterFullText ;
      AV53Ubigeowwds_2_tfubigeocode = AV11TFUbigeoCode ;
      AV54Ubigeowwds_3_tfubigeocode_sel = AV12TFUbigeoCode_Sel ;
      AV55Ubigeowwds_4_tfubigeodepartamento = AV13TFUbigeoDepartamento ;
      AV56Ubigeowwds_5_tfubigeodepartamento_sel = AV14TFUbigeoDepartamento_Sel ;
      AV57Ubigeowwds_6_tfubigeodepartamentocode = AV15TFUbigeoDepartamentoCode ;
      AV58Ubigeowwds_7_tfubigeodepartamentocode_sel = AV16TFUbigeoDepartamentoCode_Sel ;
      AV59Ubigeowwds_8_tfubigeoprovincia = AV17TFUbigeoProvincia ;
      AV60Ubigeowwds_9_tfubigeoprovincia_sel = AV18TFUbigeoProvincia_Sel ;
      AV61Ubigeowwds_10_tfubigeoprovinciacode = AV19TFUbigeoProvinciaCode ;
      AV62Ubigeowwds_11_tfubigeoprovinciacode_sel = AV20TFUbigeoProvinciaCode_Sel ;
      AV63Ubigeowwds_12_tfubigeodistrito = AV21TFUbigeoDistrito ;
      AV64Ubigeowwds_13_tfubigeodistrito_sel = AV22TFUbigeoDistrito_Sel ;
      AV65Ubigeowwds_14_tfubigeodistritocode = AV23TFUbigeoDistritoCode ;
      AV66Ubigeowwds_15_tfubigeodistritocode_sel = AV24TFUbigeoDistritoCode_Sel ;
      AV67Ubigeowwds_16_tfubigeonombre = AV25TFUbigeoNombre ;
      AV68Ubigeowwds_17_tfubigeonombre_sel = AV26TFUbigeoNombre_Sel ;
      AV69Ubigeowwds_18_tfubigeoestado_sels = AV28TFUbigeoEstado_Sels ;
      pr_default.dynParam(6, new Object[]{ new Object[]{
                                           A294UbigeoEstado ,
                                           AV69Ubigeowwds_18_tfubigeoestado_sels ,
                                           AV52Ubigeowwds_1_filterfulltext ,
                                           AV54Ubigeowwds_3_tfubigeocode_sel ,
                                           AV53Ubigeowwds_2_tfubigeocode ,
                                           AV56Ubigeowwds_5_tfubigeodepartamento_sel ,
                                           AV55Ubigeowwds_4_tfubigeodepartamento ,
                                           AV58Ubigeowwds_7_tfubigeodepartamentocode_sel ,
                                           AV57Ubigeowwds_6_tfubigeodepartamentocode ,
                                           AV60Ubigeowwds_9_tfubigeoprovincia_sel ,
                                           AV59Ubigeowwds_8_tfubigeoprovincia ,
                                           AV62Ubigeowwds_11_tfubigeoprovinciacode_sel ,
                                           AV61Ubigeowwds_10_tfubigeoprovinciacode ,
                                           AV64Ubigeowwds_13_tfubigeodistrito_sel ,
                                           AV63Ubigeowwds_12_tfubigeodistrito ,
                                           AV66Ubigeowwds_15_tfubigeodistritocode_sel ,
                                           AV65Ubigeowwds_14_tfubigeodistritocode ,
                                           AV68Ubigeowwds_17_tfubigeonombre_sel ,
                                           AV67Ubigeowwds_16_tfubigeonombre ,
                                           Integer.valueOf(AV69Ubigeowwds_18_tfubigeoestado_sels.size()) ,
                                           A44UbigeoCode ,
                                           A186UbigeoDepartamento ,
                                           A187UbigeoProvincia ,
                                           A188UbigeoDistrito } ,
                                           new int[]{
                                           TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING,
                                           TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.INT, TypeConstants.STRING,
                                           TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING
                                           }
      });
      lV52Ubigeowwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV52Ubigeowwds_1_filterfulltext), "%", "") ;
      lV52Ubigeowwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV52Ubigeowwds_1_filterfulltext), "%", "") ;
      lV52Ubigeowwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV52Ubigeowwds_1_filterfulltext), "%", "") ;
      lV52Ubigeowwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV52Ubigeowwds_1_filterfulltext), "%", "") ;
      lV52Ubigeowwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV52Ubigeowwds_1_filterfulltext), "%", "") ;
      lV52Ubigeowwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV52Ubigeowwds_1_filterfulltext), "%", "") ;
      lV52Ubigeowwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV52Ubigeowwds_1_filterfulltext), "%", "") ;
      lV52Ubigeowwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV52Ubigeowwds_1_filterfulltext), "%", "") ;
      lV52Ubigeowwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV52Ubigeowwds_1_filterfulltext), "%", "") ;
      lV52Ubigeowwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV52Ubigeowwds_1_filterfulltext), "%", "") ;
      lV53Ubigeowwds_2_tfubigeocode = GXutil.padr( GXutil.rtrim( AV53Ubigeowwds_2_tfubigeocode), 10, "%") ;
      lV55Ubigeowwds_4_tfubigeodepartamento = GXutil.concat( GXutil.rtrim( AV55Ubigeowwds_4_tfubigeodepartamento), "%", "") ;
      lV57Ubigeowwds_6_tfubigeodepartamentocode = GXutil.concat( GXutil.rtrim( AV57Ubigeowwds_6_tfubigeodepartamentocode), "%", "") ;
      lV59Ubigeowwds_8_tfubigeoprovincia = GXutil.concat( GXutil.rtrim( AV59Ubigeowwds_8_tfubigeoprovincia), "%", "") ;
      lV61Ubigeowwds_10_tfubigeoprovinciacode = GXutil.concat( GXutil.rtrim( AV61Ubigeowwds_10_tfubigeoprovinciacode), "%", "") ;
      lV63Ubigeowwds_12_tfubigeodistrito = GXutil.concat( GXutil.rtrim( AV63Ubigeowwds_12_tfubigeodistrito), "%", "") ;
      lV65Ubigeowwds_14_tfubigeodistritocode = GXutil.concat( GXutil.rtrim( AV65Ubigeowwds_14_tfubigeodistritocode), "%", "") ;
      lV67Ubigeowwds_16_tfubigeonombre = GXutil.concat( GXutil.rtrim( AV67Ubigeowwds_16_tfubigeonombre), "%", "") ;
      /* Using cursor P003L8 */
      pr_default.execute(6, new Object[] {lV52Ubigeowwds_1_filterfulltext, lV52Ubigeowwds_1_filterfulltext, lV52Ubigeowwds_1_filterfulltext, lV52Ubigeowwds_1_filterfulltext, lV52Ubigeowwds_1_filterfulltext, lV52Ubigeowwds_1_filterfulltext, lV52Ubigeowwds_1_filterfulltext, lV52Ubigeowwds_1_filterfulltext, lV52Ubigeowwds_1_filterfulltext, lV52Ubigeowwds_1_filterfulltext, lV53Ubigeowwds_2_tfubigeocode, AV54Ubigeowwds_3_tfubigeocode_sel, lV55Ubigeowwds_4_tfubigeodepartamento, AV56Ubigeowwds_5_tfubigeodepartamento_sel, lV57Ubigeowwds_6_tfubigeodepartamentocode, AV58Ubigeowwds_7_tfubigeodepartamentocode_sel, lV59Ubigeowwds_8_tfubigeoprovincia, AV60Ubigeowwds_9_tfubigeoprovincia_sel, lV61Ubigeowwds_10_tfubigeoprovinciacode, AV62Ubigeowwds_11_tfubigeoprovinciacode_sel, lV63Ubigeowwds_12_tfubigeodistrito, AV64Ubigeowwds_13_tfubigeodistrito_sel, lV65Ubigeowwds_14_tfubigeodistritocode, AV66Ubigeowwds_15_tfubigeodistritocode_sel, lV67Ubigeowwds_16_tfubigeonombre, AV68Ubigeowwds_17_tfubigeonombre_sel});
      while ( (pr_default.getStatus(6) != 101) )
      {
         A294UbigeoEstado = P003L8_A294UbigeoEstado[0] ;
         A44UbigeoCode = P003L8_A44UbigeoCode[0] ;
         A188UbigeoDistrito = P003L8_A188UbigeoDistrito[0] ;
         A187UbigeoProvincia = P003L8_A187UbigeoProvincia[0] ;
         A186UbigeoDepartamento = P003L8_A186UbigeoDepartamento[0] ;
         A185UbigeoNombre = A186UbigeoDepartamento + " / " + A187UbigeoProvincia + " / " + A188UbigeoDistrito ;
         A295UbigeoDepartamentoCode = GXutil.substring( A44UbigeoCode, 1, 2) ;
         A296UbigeoProvinciaCode = GXutil.substring( A44UbigeoCode, 3, 2) ;
         A297UbigeoDistritoCode = GXutil.substring( A44UbigeoCode, 5, 2) ;
         if ( ! (GXutil.strcmp("", A297UbigeoDistritoCode)==0) )
         {
            AV33Option = A297UbigeoDistritoCode ;
            AV32InsertIndex = 1 ;
            while ( ( AV32InsertIndex <= AV34Options.size() ) && ( GXutil.strcmp((String)AV34Options.elementAt(-1+AV32InsertIndex), AV33Option) < 0 ) )
            {
               AV32InsertIndex = (int)(AV32InsertIndex+1) ;
            }
            if ( ( AV32InsertIndex <= AV34Options.size() ) && ( GXutil.strcmp((String)AV34Options.elementAt(-1+AV32InsertIndex), AV33Option) == 0 ) )
            {
               AV41count = GXutil.lval( (String)AV39OptionIndexes.elementAt(-1+AV32InsertIndex)) ;
               AV41count = (long)(AV41count+1) ;
               AV39OptionIndexes.removeItem(AV32InsertIndex);
               AV39OptionIndexes.add(GXutil.trim( localUtil.format( DecimalUtil.doubleToDec(AV41count), "Z,ZZZ,ZZZ,ZZ9")), AV32InsertIndex);
            }
            else
            {
               AV34Options.add(AV33Option, AV32InsertIndex);
               AV39OptionIndexes.add("1", AV32InsertIndex);
            }
         }
         if ( AV34Options.size() == 50 )
         {
            /* Exit For each command. Update data (if necessary), close cursors & exit. */
            if (true) break;
         }
         pr_default.readNext(6);
      }
      pr_default.close(6);
   }

   public void S191( )
   {
      /* 'LOADUBIGEONOMBREOPTIONS' Routine */
      returnInSub = false ;
      AV25TFUbigeoNombre = AV29SearchTxt ;
      AV26TFUbigeoNombre_Sel = "" ;
      AV52Ubigeowwds_1_filterfulltext = AV47FilterFullText ;
      AV53Ubigeowwds_2_tfubigeocode = AV11TFUbigeoCode ;
      AV54Ubigeowwds_3_tfubigeocode_sel = AV12TFUbigeoCode_Sel ;
      AV55Ubigeowwds_4_tfubigeodepartamento = AV13TFUbigeoDepartamento ;
      AV56Ubigeowwds_5_tfubigeodepartamento_sel = AV14TFUbigeoDepartamento_Sel ;
      AV57Ubigeowwds_6_tfubigeodepartamentocode = AV15TFUbigeoDepartamentoCode ;
      AV58Ubigeowwds_7_tfubigeodepartamentocode_sel = AV16TFUbigeoDepartamentoCode_Sel ;
      AV59Ubigeowwds_8_tfubigeoprovincia = AV17TFUbigeoProvincia ;
      AV60Ubigeowwds_9_tfubigeoprovincia_sel = AV18TFUbigeoProvincia_Sel ;
      AV61Ubigeowwds_10_tfubigeoprovinciacode = AV19TFUbigeoProvinciaCode ;
      AV62Ubigeowwds_11_tfubigeoprovinciacode_sel = AV20TFUbigeoProvinciaCode_Sel ;
      AV63Ubigeowwds_12_tfubigeodistrito = AV21TFUbigeoDistrito ;
      AV64Ubigeowwds_13_tfubigeodistrito_sel = AV22TFUbigeoDistrito_Sel ;
      AV65Ubigeowwds_14_tfubigeodistritocode = AV23TFUbigeoDistritoCode ;
      AV66Ubigeowwds_15_tfubigeodistritocode_sel = AV24TFUbigeoDistritoCode_Sel ;
      AV67Ubigeowwds_16_tfubigeonombre = AV25TFUbigeoNombre ;
      AV68Ubigeowwds_17_tfubigeonombre_sel = AV26TFUbigeoNombre_Sel ;
      AV69Ubigeowwds_18_tfubigeoestado_sels = AV28TFUbigeoEstado_Sels ;
      pr_default.dynParam(7, new Object[]{ new Object[]{
                                           A294UbigeoEstado ,
                                           AV69Ubigeowwds_18_tfubigeoestado_sels ,
                                           AV52Ubigeowwds_1_filterfulltext ,
                                           AV54Ubigeowwds_3_tfubigeocode_sel ,
                                           AV53Ubigeowwds_2_tfubigeocode ,
                                           AV56Ubigeowwds_5_tfubigeodepartamento_sel ,
                                           AV55Ubigeowwds_4_tfubigeodepartamento ,
                                           AV58Ubigeowwds_7_tfubigeodepartamentocode_sel ,
                                           AV57Ubigeowwds_6_tfubigeodepartamentocode ,
                                           AV60Ubigeowwds_9_tfubigeoprovincia_sel ,
                                           AV59Ubigeowwds_8_tfubigeoprovincia ,
                                           AV62Ubigeowwds_11_tfubigeoprovinciacode_sel ,
                                           AV61Ubigeowwds_10_tfubigeoprovinciacode ,
                                           AV64Ubigeowwds_13_tfubigeodistrito_sel ,
                                           AV63Ubigeowwds_12_tfubigeodistrito ,
                                           AV66Ubigeowwds_15_tfubigeodistritocode_sel ,
                                           AV65Ubigeowwds_14_tfubigeodistritocode ,
                                           AV68Ubigeowwds_17_tfubigeonombre_sel ,
                                           AV67Ubigeowwds_16_tfubigeonombre ,
                                           Integer.valueOf(AV69Ubigeowwds_18_tfubigeoestado_sels.size()) ,
                                           A44UbigeoCode ,
                                           A186UbigeoDepartamento ,
                                           A187UbigeoProvincia ,
                                           A188UbigeoDistrito } ,
                                           new int[]{
                                           TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING,
                                           TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.INT, TypeConstants.STRING,
                                           TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING
                                           }
      });
      lV52Ubigeowwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV52Ubigeowwds_1_filterfulltext), "%", "") ;
      lV52Ubigeowwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV52Ubigeowwds_1_filterfulltext), "%", "") ;
      lV52Ubigeowwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV52Ubigeowwds_1_filterfulltext), "%", "") ;
      lV52Ubigeowwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV52Ubigeowwds_1_filterfulltext), "%", "") ;
      lV52Ubigeowwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV52Ubigeowwds_1_filterfulltext), "%", "") ;
      lV52Ubigeowwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV52Ubigeowwds_1_filterfulltext), "%", "") ;
      lV52Ubigeowwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV52Ubigeowwds_1_filterfulltext), "%", "") ;
      lV52Ubigeowwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV52Ubigeowwds_1_filterfulltext), "%", "") ;
      lV52Ubigeowwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV52Ubigeowwds_1_filterfulltext), "%", "") ;
      lV52Ubigeowwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV52Ubigeowwds_1_filterfulltext), "%", "") ;
      lV53Ubigeowwds_2_tfubigeocode = GXutil.padr( GXutil.rtrim( AV53Ubigeowwds_2_tfubigeocode), 10, "%") ;
      lV55Ubigeowwds_4_tfubigeodepartamento = GXutil.concat( GXutil.rtrim( AV55Ubigeowwds_4_tfubigeodepartamento), "%", "") ;
      lV57Ubigeowwds_6_tfubigeodepartamentocode = GXutil.concat( GXutil.rtrim( AV57Ubigeowwds_6_tfubigeodepartamentocode), "%", "") ;
      lV59Ubigeowwds_8_tfubigeoprovincia = GXutil.concat( GXutil.rtrim( AV59Ubigeowwds_8_tfubigeoprovincia), "%", "") ;
      lV61Ubigeowwds_10_tfubigeoprovinciacode = GXutil.concat( GXutil.rtrim( AV61Ubigeowwds_10_tfubigeoprovinciacode), "%", "") ;
      lV63Ubigeowwds_12_tfubigeodistrito = GXutil.concat( GXutil.rtrim( AV63Ubigeowwds_12_tfubigeodistrito), "%", "") ;
      lV65Ubigeowwds_14_tfubigeodistritocode = GXutil.concat( GXutil.rtrim( AV65Ubigeowwds_14_tfubigeodistritocode), "%", "") ;
      lV67Ubigeowwds_16_tfubigeonombre = GXutil.concat( GXutil.rtrim( AV67Ubigeowwds_16_tfubigeonombre), "%", "") ;
      /* Using cursor P003L9 */
      pr_default.execute(7, new Object[] {lV52Ubigeowwds_1_filterfulltext, lV52Ubigeowwds_1_filterfulltext, lV52Ubigeowwds_1_filterfulltext, lV52Ubigeowwds_1_filterfulltext, lV52Ubigeowwds_1_filterfulltext, lV52Ubigeowwds_1_filterfulltext, lV52Ubigeowwds_1_filterfulltext, lV52Ubigeowwds_1_filterfulltext, lV52Ubigeowwds_1_filterfulltext, lV52Ubigeowwds_1_filterfulltext, lV53Ubigeowwds_2_tfubigeocode, AV54Ubigeowwds_3_tfubigeocode_sel, lV55Ubigeowwds_4_tfubigeodepartamento, AV56Ubigeowwds_5_tfubigeodepartamento_sel, lV57Ubigeowwds_6_tfubigeodepartamentocode, AV58Ubigeowwds_7_tfubigeodepartamentocode_sel, lV59Ubigeowwds_8_tfubigeoprovincia, AV60Ubigeowwds_9_tfubigeoprovincia_sel, lV61Ubigeowwds_10_tfubigeoprovinciacode, AV62Ubigeowwds_11_tfubigeoprovinciacode_sel, lV63Ubigeowwds_12_tfubigeodistrito, AV64Ubigeowwds_13_tfubigeodistrito_sel, lV65Ubigeowwds_14_tfubigeodistritocode, AV66Ubigeowwds_15_tfubigeodistritocode_sel, lV67Ubigeowwds_16_tfubigeonombre, AV68Ubigeowwds_17_tfubigeonombre_sel});
      while ( (pr_default.getStatus(7) != 101) )
      {
         A294UbigeoEstado = P003L9_A294UbigeoEstado[0] ;
         A44UbigeoCode = P003L9_A44UbigeoCode[0] ;
         A188UbigeoDistrito = P003L9_A188UbigeoDistrito[0] ;
         A187UbigeoProvincia = P003L9_A187UbigeoProvincia[0] ;
         A186UbigeoDepartamento = P003L9_A186UbigeoDepartamento[0] ;
         A185UbigeoNombre = A186UbigeoDepartamento + " / " + A187UbigeoProvincia + " / " + A188UbigeoDistrito ;
         A295UbigeoDepartamentoCode = GXutil.substring( A44UbigeoCode, 1, 2) ;
         A296UbigeoProvinciaCode = GXutil.substring( A44UbigeoCode, 3, 2) ;
         A297UbigeoDistritoCode = GXutil.substring( A44UbigeoCode, 5, 2) ;
         if ( ! (GXutil.strcmp("", A185UbigeoNombre)==0) )
         {
            AV33Option = A185UbigeoNombre ;
            AV32InsertIndex = 1 ;
            while ( ( AV32InsertIndex <= AV34Options.size() ) && ( GXutil.strcmp((String)AV34Options.elementAt(-1+AV32InsertIndex), AV33Option) < 0 ) )
            {
               AV32InsertIndex = (int)(AV32InsertIndex+1) ;
            }
            if ( ( AV32InsertIndex <= AV34Options.size() ) && ( GXutil.strcmp((String)AV34Options.elementAt(-1+AV32InsertIndex), AV33Option) == 0 ) )
            {
               AV41count = GXutil.lval( (String)AV39OptionIndexes.elementAt(-1+AV32InsertIndex)) ;
               AV41count = (long)(AV41count+1) ;
               AV39OptionIndexes.removeItem(AV32InsertIndex);
               AV39OptionIndexes.add(GXutil.trim( localUtil.format( DecimalUtil.doubleToDec(AV41count), "Z,ZZZ,ZZZ,ZZ9")), AV32InsertIndex);
            }
            else
            {
               AV34Options.add(AV33Option, AV32InsertIndex);
               AV39OptionIndexes.add("1", AV32InsertIndex);
            }
         }
         if ( AV34Options.size() == 50 )
         {
            /* Exit For each command. Update data (if necessary), close cursors & exit. */
            if (true) break;
         }
         pr_default.readNext(7);
      }
      pr_default.close(7);
   }

   protected void cleanup( )
   {
      this.aP3[0] = ubigeowwgetfilterdata.this.AV35OptionsJson;
      this.aP4[0] = ubigeowwgetfilterdata.this.AV38OptionsDescJson;
      this.aP5[0] = ubigeowwgetfilterdata.this.AV40OptionIndexesJson;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV35OptionsJson = "" ;
      AV38OptionsDescJson = "" ;
      AV40OptionIndexesJson = "" ;
      AV34Options = new GXSimpleCollection<String>(String.class, "internal", "");
      AV37OptionsDesc = new GXSimpleCollection<String>(String.class, "internal", "");
      AV39OptionIndexes = new GXSimpleCollection<String>(String.class, "internal", "");
      GXv_boolean2 = new boolean[1] ;
      AV9WWPContext = new com.projectthani.wwpbaseobjects.SdtWWPContext(remoteHandle, context);
      GXv_SdtWWPContext3 = new com.projectthani.wwpbaseobjects.SdtWWPContext[1] ;
      AV42Session = httpContext.getWebSession();
      AV44GridState = new com.projectthani.wwpbaseobjects.SdtWWPGridState(remoteHandle, context);
      AV45GridStateFilterValue = new com.projectthani.wwpbaseobjects.SdtWWPGridState_FilterValue(remoteHandle, context);
      AV47FilterFullText = "" ;
      AV11TFUbigeoCode = "" ;
      AV12TFUbigeoCode_Sel = "" ;
      AV13TFUbigeoDepartamento = "" ;
      AV14TFUbigeoDepartamento_Sel = "" ;
      AV15TFUbigeoDepartamentoCode = "" ;
      AV16TFUbigeoDepartamentoCode_Sel = "" ;
      AV17TFUbigeoProvincia = "" ;
      AV18TFUbigeoProvincia_Sel = "" ;
      AV19TFUbigeoProvinciaCode = "" ;
      AV20TFUbigeoProvinciaCode_Sel = "" ;
      AV21TFUbigeoDistrito = "" ;
      AV22TFUbigeoDistrito_Sel = "" ;
      AV23TFUbigeoDistritoCode = "" ;
      AV24TFUbigeoDistritoCode_Sel = "" ;
      AV25TFUbigeoNombre = "" ;
      AV26TFUbigeoNombre_Sel = "" ;
      AV27TFUbigeoEstado_SelsJson = "" ;
      AV28TFUbigeoEstado_Sels = new GXSimpleCollection<String>(String.class, "internal", "");
      A44UbigeoCode = "" ;
      AV52Ubigeowwds_1_filterfulltext = "" ;
      AV53Ubigeowwds_2_tfubigeocode = "" ;
      AV54Ubigeowwds_3_tfubigeocode_sel = "" ;
      AV55Ubigeowwds_4_tfubigeodepartamento = "" ;
      AV56Ubigeowwds_5_tfubigeodepartamento_sel = "" ;
      AV57Ubigeowwds_6_tfubigeodepartamentocode = "" ;
      AV58Ubigeowwds_7_tfubigeodepartamentocode_sel = "" ;
      AV59Ubigeowwds_8_tfubigeoprovincia = "" ;
      AV60Ubigeowwds_9_tfubigeoprovincia_sel = "" ;
      AV61Ubigeowwds_10_tfubigeoprovinciacode = "" ;
      AV62Ubigeowwds_11_tfubigeoprovinciacode_sel = "" ;
      AV63Ubigeowwds_12_tfubigeodistrito = "" ;
      AV64Ubigeowwds_13_tfubigeodistrito_sel = "" ;
      AV65Ubigeowwds_14_tfubigeodistritocode = "" ;
      AV66Ubigeowwds_15_tfubigeodistritocode_sel = "" ;
      AV67Ubigeowwds_16_tfubigeonombre = "" ;
      AV68Ubigeowwds_17_tfubigeonombre_sel = "" ;
      AV69Ubigeowwds_18_tfubigeoestado_sels = new GXSimpleCollection<String>(String.class, "internal", "");
      scmdbuf = "" ;
      lV52Ubigeowwds_1_filterfulltext = "" ;
      lV53Ubigeowwds_2_tfubigeocode = "" ;
      lV55Ubigeowwds_4_tfubigeodepartamento = "" ;
      lV57Ubigeowwds_6_tfubigeodepartamentocode = "" ;
      lV59Ubigeowwds_8_tfubigeoprovincia = "" ;
      lV61Ubigeowwds_10_tfubigeoprovinciacode = "" ;
      lV63Ubigeowwds_12_tfubigeodistrito = "" ;
      lV65Ubigeowwds_14_tfubigeodistritocode = "" ;
      lV67Ubigeowwds_16_tfubigeonombre = "" ;
      A294UbigeoEstado = "" ;
      A186UbigeoDepartamento = "" ;
      A187UbigeoProvincia = "" ;
      A188UbigeoDistrito = "" ;
      P003L2_A294UbigeoEstado = new String[] {""} ;
      P003L2_A44UbigeoCode = new String[] {""} ;
      P003L2_A188UbigeoDistrito = new String[] {""} ;
      P003L2_A187UbigeoProvincia = new String[] {""} ;
      P003L2_A186UbigeoDepartamento = new String[] {""} ;
      A185UbigeoNombre = "" ;
      A295UbigeoDepartamentoCode = "" ;
      A296UbigeoProvinciaCode = "" ;
      A297UbigeoDistritoCode = "" ;
      AV33Option = "" ;
      P003L3_A294UbigeoEstado = new String[] {""} ;
      P003L3_A44UbigeoCode = new String[] {""} ;
      P003L3_A188UbigeoDistrito = new String[] {""} ;
      P003L3_A187UbigeoProvincia = new String[] {""} ;
      P003L3_A186UbigeoDepartamento = new String[] {""} ;
      P003L4_A294UbigeoEstado = new String[] {""} ;
      P003L4_A44UbigeoCode = new String[] {""} ;
      P003L4_A188UbigeoDistrito = new String[] {""} ;
      P003L4_A187UbigeoProvincia = new String[] {""} ;
      P003L4_A186UbigeoDepartamento = new String[] {""} ;
      P003L5_A294UbigeoEstado = new String[] {""} ;
      P003L5_A44UbigeoCode = new String[] {""} ;
      P003L5_A188UbigeoDistrito = new String[] {""} ;
      P003L5_A187UbigeoProvincia = new String[] {""} ;
      P003L5_A186UbigeoDepartamento = new String[] {""} ;
      P003L6_A294UbigeoEstado = new String[] {""} ;
      P003L6_A44UbigeoCode = new String[] {""} ;
      P003L6_A188UbigeoDistrito = new String[] {""} ;
      P003L6_A187UbigeoProvincia = new String[] {""} ;
      P003L6_A186UbigeoDepartamento = new String[] {""} ;
      P003L7_A294UbigeoEstado = new String[] {""} ;
      P003L7_A44UbigeoCode = new String[] {""} ;
      P003L7_A188UbigeoDistrito = new String[] {""} ;
      P003L7_A187UbigeoProvincia = new String[] {""} ;
      P003L7_A186UbigeoDepartamento = new String[] {""} ;
      P003L8_A294UbigeoEstado = new String[] {""} ;
      P003L8_A44UbigeoCode = new String[] {""} ;
      P003L8_A188UbigeoDistrito = new String[] {""} ;
      P003L8_A187UbigeoProvincia = new String[] {""} ;
      P003L8_A186UbigeoDepartamento = new String[] {""} ;
      P003L9_A294UbigeoEstado = new String[] {""} ;
      P003L9_A44UbigeoCode = new String[] {""} ;
      P003L9_A188UbigeoDistrito = new String[] {""} ;
      P003L9_A187UbigeoProvincia = new String[] {""} ;
      P003L9_A186UbigeoDepartamento = new String[] {""} ;
      pr_default = new DataStoreProvider(context, remoteHandle, new com.projectthani.ubigeowwgetfilterdata__default(),
         new Object[] {
             new Object[] {
            P003L2_A294UbigeoEstado, P003L2_A44UbigeoCode, P003L2_A188UbigeoDistrito, P003L2_A187UbigeoProvincia, P003L2_A186UbigeoDepartamento
            }
            , new Object[] {
            P003L3_A294UbigeoEstado, P003L3_A44UbigeoCode, P003L3_A188UbigeoDistrito, P003L3_A187UbigeoProvincia, P003L3_A186UbigeoDepartamento
            }
            , new Object[] {
            P003L4_A294UbigeoEstado, P003L4_A44UbigeoCode, P003L4_A188UbigeoDistrito, P003L4_A187UbigeoProvincia, P003L4_A186UbigeoDepartamento
            }
            , new Object[] {
            P003L5_A294UbigeoEstado, P003L5_A44UbigeoCode, P003L5_A188UbigeoDistrito, P003L5_A187UbigeoProvincia, P003L5_A186UbigeoDepartamento
            }
            , new Object[] {
            P003L6_A294UbigeoEstado, P003L6_A44UbigeoCode, P003L6_A188UbigeoDistrito, P003L6_A187UbigeoProvincia, P003L6_A186UbigeoDepartamento
            }
            , new Object[] {
            P003L7_A294UbigeoEstado, P003L7_A44UbigeoCode, P003L7_A188UbigeoDistrito, P003L7_A187UbigeoProvincia, P003L7_A186UbigeoDepartamento
            }
            , new Object[] {
            P003L8_A294UbigeoEstado, P003L8_A44UbigeoCode, P003L8_A188UbigeoDistrito, P003L8_A187UbigeoProvincia, P003L8_A186UbigeoDepartamento
            }
            , new Object[] {
            P003L9_A294UbigeoEstado, P003L9_A44UbigeoCode, P003L9_A188UbigeoDistrito, P003L9_A187UbigeoProvincia, P003L9_A186UbigeoDepartamento
            }
         }
      );
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private short Gx_err ;
   private int AV50GXV1 ;
   private int AV69Ubigeowwds_18_tfubigeoestado_sels_size ;
   private int AV32InsertIndex ;
   private long AV41count ;
   private String AV11TFUbigeoCode ;
   private String AV12TFUbigeoCode_Sel ;
   private String A44UbigeoCode ;
   private String AV53Ubigeowwds_2_tfubigeocode ;
   private String AV54Ubigeowwds_3_tfubigeocode_sel ;
   private String scmdbuf ;
   private String lV53Ubigeowwds_2_tfubigeocode ;
   private String A294UbigeoEstado ;
   private boolean AV8IsAuthorized ;
   private boolean GXt_boolean1 ;
   private boolean GXv_boolean2[] ;
   private boolean returnInSub ;
   private boolean brk3L3 ;
   private boolean brk3L6 ;
   private boolean brk3L9 ;
   private String AV35OptionsJson ;
   private String AV38OptionsDescJson ;
   private String AV40OptionIndexesJson ;
   private String AV27TFUbigeoEstado_SelsJson ;
   private String AV31DDOName ;
   private String AV29SearchTxt ;
   private String AV30SearchTxtTo ;
   private String AV47FilterFullText ;
   private String AV13TFUbigeoDepartamento ;
   private String AV14TFUbigeoDepartamento_Sel ;
   private String AV15TFUbigeoDepartamentoCode ;
   private String AV16TFUbigeoDepartamentoCode_Sel ;
   private String AV17TFUbigeoProvincia ;
   private String AV18TFUbigeoProvincia_Sel ;
   private String AV19TFUbigeoProvinciaCode ;
   private String AV20TFUbigeoProvinciaCode_Sel ;
   private String AV21TFUbigeoDistrito ;
   private String AV22TFUbigeoDistrito_Sel ;
   private String AV23TFUbigeoDistritoCode ;
   private String AV24TFUbigeoDistritoCode_Sel ;
   private String AV25TFUbigeoNombre ;
   private String AV26TFUbigeoNombre_Sel ;
   private String AV52Ubigeowwds_1_filterfulltext ;
   private String AV55Ubigeowwds_4_tfubigeodepartamento ;
   private String AV56Ubigeowwds_5_tfubigeodepartamento_sel ;
   private String AV57Ubigeowwds_6_tfubigeodepartamentocode ;
   private String AV58Ubigeowwds_7_tfubigeodepartamentocode_sel ;
   private String AV59Ubigeowwds_8_tfubigeoprovincia ;
   private String AV60Ubigeowwds_9_tfubigeoprovincia_sel ;
   private String AV61Ubigeowwds_10_tfubigeoprovinciacode ;
   private String AV62Ubigeowwds_11_tfubigeoprovinciacode_sel ;
   private String AV63Ubigeowwds_12_tfubigeodistrito ;
   private String AV64Ubigeowwds_13_tfubigeodistrito_sel ;
   private String AV65Ubigeowwds_14_tfubigeodistritocode ;
   private String AV66Ubigeowwds_15_tfubigeodistritocode_sel ;
   private String AV67Ubigeowwds_16_tfubigeonombre ;
   private String AV68Ubigeowwds_17_tfubigeonombre_sel ;
   private String lV52Ubigeowwds_1_filterfulltext ;
   private String lV55Ubigeowwds_4_tfubigeodepartamento ;
   private String lV57Ubigeowwds_6_tfubigeodepartamentocode ;
   private String lV59Ubigeowwds_8_tfubigeoprovincia ;
   private String lV61Ubigeowwds_10_tfubigeoprovinciacode ;
   private String lV63Ubigeowwds_12_tfubigeodistrito ;
   private String lV65Ubigeowwds_14_tfubigeodistritocode ;
   private String lV67Ubigeowwds_16_tfubigeonombre ;
   private String A186UbigeoDepartamento ;
   private String A187UbigeoProvincia ;
   private String A188UbigeoDistrito ;
   private String A185UbigeoNombre ;
   private String A295UbigeoDepartamentoCode ;
   private String A296UbigeoProvinciaCode ;
   private String A297UbigeoDistritoCode ;
   private String AV33Option ;
   private com.genexus.webpanels.WebSession AV42Session ;
   private String[] aP5 ;
   private String[] aP3 ;
   private String[] aP4 ;
   private IDataStoreProvider pr_default ;
   private String[] P003L2_A294UbigeoEstado ;
   private String[] P003L2_A44UbigeoCode ;
   private String[] P003L2_A188UbigeoDistrito ;
   private String[] P003L2_A187UbigeoProvincia ;
   private String[] P003L2_A186UbigeoDepartamento ;
   private String[] P003L3_A294UbigeoEstado ;
   private String[] P003L3_A44UbigeoCode ;
   private String[] P003L3_A188UbigeoDistrito ;
   private String[] P003L3_A187UbigeoProvincia ;
   private String[] P003L3_A186UbigeoDepartamento ;
   private String[] P003L4_A294UbigeoEstado ;
   private String[] P003L4_A44UbigeoCode ;
   private String[] P003L4_A188UbigeoDistrito ;
   private String[] P003L4_A187UbigeoProvincia ;
   private String[] P003L4_A186UbigeoDepartamento ;
   private String[] P003L5_A294UbigeoEstado ;
   private String[] P003L5_A44UbigeoCode ;
   private String[] P003L5_A188UbigeoDistrito ;
   private String[] P003L5_A187UbigeoProvincia ;
   private String[] P003L5_A186UbigeoDepartamento ;
   private String[] P003L6_A294UbigeoEstado ;
   private String[] P003L6_A44UbigeoCode ;
   private String[] P003L6_A188UbigeoDistrito ;
   private String[] P003L6_A187UbigeoProvincia ;
   private String[] P003L6_A186UbigeoDepartamento ;
   private String[] P003L7_A294UbigeoEstado ;
   private String[] P003L7_A44UbigeoCode ;
   private String[] P003L7_A188UbigeoDistrito ;
   private String[] P003L7_A187UbigeoProvincia ;
   private String[] P003L7_A186UbigeoDepartamento ;
   private String[] P003L8_A294UbigeoEstado ;
   private String[] P003L8_A44UbigeoCode ;
   private String[] P003L8_A188UbigeoDistrito ;
   private String[] P003L8_A187UbigeoProvincia ;
   private String[] P003L8_A186UbigeoDepartamento ;
   private String[] P003L9_A294UbigeoEstado ;
   private String[] P003L9_A44UbigeoCode ;
   private String[] P003L9_A188UbigeoDistrito ;
   private String[] P003L9_A187UbigeoProvincia ;
   private String[] P003L9_A186UbigeoDepartamento ;
   private GXSimpleCollection<String> AV28TFUbigeoEstado_Sels ;
   private GXSimpleCollection<String> AV69Ubigeowwds_18_tfubigeoestado_sels ;
   private GXSimpleCollection<String> AV34Options ;
   private GXSimpleCollection<String> AV37OptionsDesc ;
   private GXSimpleCollection<String> AV39OptionIndexes ;
   private com.projectthani.wwpbaseobjects.SdtWWPContext AV9WWPContext ;
   private com.projectthani.wwpbaseobjects.SdtWWPContext GXv_SdtWWPContext3[] ;
   private com.projectthani.wwpbaseobjects.SdtWWPGridState AV44GridState ;
   private com.projectthani.wwpbaseobjects.SdtWWPGridState_FilterValue AV45GridStateFilterValue ;
}

final  class ubigeowwgetfilterdata__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   protected Object[] conditional_P003L2( ModelContext context ,
                                          int remoteHandle ,
                                          com.genexus.IHttpContext httpContext ,
                                          String A294UbigeoEstado ,
                                          GXSimpleCollection<String> AV69Ubigeowwds_18_tfubigeoestado_sels ,
                                          String AV52Ubigeowwds_1_filterfulltext ,
                                          String AV54Ubigeowwds_3_tfubigeocode_sel ,
                                          String AV53Ubigeowwds_2_tfubigeocode ,
                                          String AV56Ubigeowwds_5_tfubigeodepartamento_sel ,
                                          String AV55Ubigeowwds_4_tfubigeodepartamento ,
                                          String AV58Ubigeowwds_7_tfubigeodepartamentocode_sel ,
                                          String AV57Ubigeowwds_6_tfubigeodepartamentocode ,
                                          String AV60Ubigeowwds_9_tfubigeoprovincia_sel ,
                                          String AV59Ubigeowwds_8_tfubigeoprovincia ,
                                          String AV62Ubigeowwds_11_tfubigeoprovinciacode_sel ,
                                          String AV61Ubigeowwds_10_tfubigeoprovinciacode ,
                                          String AV64Ubigeowwds_13_tfubigeodistrito_sel ,
                                          String AV63Ubigeowwds_12_tfubigeodistrito ,
                                          String AV66Ubigeowwds_15_tfubigeodistritocode_sel ,
                                          String AV65Ubigeowwds_14_tfubigeodistritocode ,
                                          String AV68Ubigeowwds_17_tfubigeonombre_sel ,
                                          String AV67Ubigeowwds_16_tfubigeonombre ,
                                          int AV69Ubigeowwds_18_tfubigeoestado_sels_size ,
                                          String A44UbigeoCode ,
                                          String A186UbigeoDepartamento ,
                                          String A187UbigeoProvincia ,
                                          String A188UbigeoDistrito )
   {
      java.lang.StringBuffer sWhereString = new java.lang.StringBuffer();
      String scmdbuf;
      byte[] GXv_int4 = new byte[26];
      Object[] GXv_Object5 = new Object[2];
      scmdbuf = "SELECT DISTINCT NULL AS [UbigeoEstado], [UbigeoCode], NULL AS [UbigeoDistrito], NULL AS [UbigeoProvincia], NULL AS [UbigeoDepartamento] FROM ( SELECT TOP(100) PERCENT" ;
      scmdbuf += " [UbigeoEstado], [UbigeoCode], [UbigeoDistrito], [UbigeoProvincia], [UbigeoDepartamento] FROM [Ubigeo]" ;
      if ( ! (GXutil.strcmp("", AV52Ubigeowwds_1_filterfulltext)==0) )
      {
         addWhere(sWhereString, "(( [UbigeoCode] like '%' + ?) or ( [UbigeoDepartamento] like '%' + ?) or ( SUBSTRING([UbigeoCode], 1, 2) like '%' + ?) or ( [UbigeoProvincia] like '%' + ?) or ( SUBSTRING([UbigeoCode], 3, 2) like '%' + ?) or ( [UbigeoDistrito] like '%' + ?) or ( SUBSTRING([UbigeoCode], 5, 2) like '%' + ?) or ( [UbigeoDepartamento] + ' / ' + [UbigeoProvincia] + ' / ' + [UbigeoDistrito] like '%' + ?) or ( 'activo' like '%' + LOWER(?) and [UbigeoEstado] = 'A') or ( 'inactivo' like '%' + LOWER(?) and [UbigeoEstado] = 'I'))");
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
      if ( (GXutil.strcmp("", AV54Ubigeowwds_3_tfubigeocode_sel)==0) && ( ! (GXutil.strcmp("", AV53Ubigeowwds_2_tfubigeocode)==0) ) )
      {
         addWhere(sWhereString, "([UbigeoCode] like ?)");
      }
      else
      {
         GXv_int4[10] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV54Ubigeowwds_3_tfubigeocode_sel)==0) )
      {
         addWhere(sWhereString, "([UbigeoCode] = ?)");
      }
      else
      {
         GXv_int4[11] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV56Ubigeowwds_5_tfubigeodepartamento_sel)==0) && ( ! (GXutil.strcmp("", AV55Ubigeowwds_4_tfubigeodepartamento)==0) ) )
      {
         addWhere(sWhereString, "([UbigeoDepartamento] like ?)");
      }
      else
      {
         GXv_int4[12] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV56Ubigeowwds_5_tfubigeodepartamento_sel)==0) )
      {
         addWhere(sWhereString, "([UbigeoDepartamento] = ?)");
      }
      else
      {
         GXv_int4[13] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV58Ubigeowwds_7_tfubigeodepartamentocode_sel)==0) && ( ! (GXutil.strcmp("", AV57Ubigeowwds_6_tfubigeodepartamentocode)==0) ) )
      {
         addWhere(sWhereString, "(SUBSTRING([UbigeoCode], 1, 2) like ?)");
      }
      else
      {
         GXv_int4[14] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV58Ubigeowwds_7_tfubigeodepartamentocode_sel)==0) )
      {
         addWhere(sWhereString, "(SUBSTRING([UbigeoCode], 1, 2) = ?)");
      }
      else
      {
         GXv_int4[15] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV60Ubigeowwds_9_tfubigeoprovincia_sel)==0) && ( ! (GXutil.strcmp("", AV59Ubigeowwds_8_tfubigeoprovincia)==0) ) )
      {
         addWhere(sWhereString, "([UbigeoProvincia] like ?)");
      }
      else
      {
         GXv_int4[16] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV60Ubigeowwds_9_tfubigeoprovincia_sel)==0) )
      {
         addWhere(sWhereString, "([UbigeoProvincia] = ?)");
      }
      else
      {
         GXv_int4[17] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV62Ubigeowwds_11_tfubigeoprovinciacode_sel)==0) && ( ! (GXutil.strcmp("", AV61Ubigeowwds_10_tfubigeoprovinciacode)==0) ) )
      {
         addWhere(sWhereString, "(SUBSTRING([UbigeoCode], 3, 2) like ?)");
      }
      else
      {
         GXv_int4[18] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV62Ubigeowwds_11_tfubigeoprovinciacode_sel)==0) )
      {
         addWhere(sWhereString, "(SUBSTRING([UbigeoCode], 3, 2) = ?)");
      }
      else
      {
         GXv_int4[19] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV64Ubigeowwds_13_tfubigeodistrito_sel)==0) && ( ! (GXutil.strcmp("", AV63Ubigeowwds_12_tfubigeodistrito)==0) ) )
      {
         addWhere(sWhereString, "([UbigeoDistrito] like ?)");
      }
      else
      {
         GXv_int4[20] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV64Ubigeowwds_13_tfubigeodistrito_sel)==0) )
      {
         addWhere(sWhereString, "([UbigeoDistrito] = ?)");
      }
      else
      {
         GXv_int4[21] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV66Ubigeowwds_15_tfubigeodistritocode_sel)==0) && ( ! (GXutil.strcmp("", AV65Ubigeowwds_14_tfubigeodistritocode)==0) ) )
      {
         addWhere(sWhereString, "(SUBSTRING([UbigeoCode], 5, 2) like ?)");
      }
      else
      {
         GXv_int4[22] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV66Ubigeowwds_15_tfubigeodistritocode_sel)==0) )
      {
         addWhere(sWhereString, "(SUBSTRING([UbigeoCode], 5, 2) = ?)");
      }
      else
      {
         GXv_int4[23] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV68Ubigeowwds_17_tfubigeonombre_sel)==0) && ( ! (GXutil.strcmp("", AV67Ubigeowwds_16_tfubigeonombre)==0) ) )
      {
         addWhere(sWhereString, "([UbigeoDepartamento] + ' / ' + [UbigeoProvincia] + ' / ' + [UbigeoDistrito] like ?)");
      }
      else
      {
         GXv_int4[24] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV68Ubigeowwds_17_tfubigeonombre_sel)==0) )
      {
         addWhere(sWhereString, "([UbigeoDepartamento] + ' / ' + [UbigeoProvincia] + ' / ' + [UbigeoDistrito] = ?)");
      }
      else
      {
         GXv_int4[25] = (byte)(1) ;
      }
      if ( AV69Ubigeowwds_18_tfubigeoestado_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("sqlserver", AV69Ubigeowwds_18_tfubigeoestado_sels, "[UbigeoEstado] IN (", ")")+")");
      }
      scmdbuf += sWhereString ;
      scmdbuf += " ORDER BY [UbigeoCode]" ;
      scmdbuf += ") DistinctT" ;
      scmdbuf += " ORDER BY [UbigeoCode]" ;
      GXv_Object5[0] = scmdbuf ;
      GXv_Object5[1] = GXv_int4 ;
      return GXv_Object5 ;
   }

   protected Object[] conditional_P003L3( ModelContext context ,
                                          int remoteHandle ,
                                          com.genexus.IHttpContext httpContext ,
                                          String A294UbigeoEstado ,
                                          GXSimpleCollection<String> AV69Ubigeowwds_18_tfubigeoestado_sels ,
                                          String AV52Ubigeowwds_1_filterfulltext ,
                                          String AV54Ubigeowwds_3_tfubigeocode_sel ,
                                          String AV53Ubigeowwds_2_tfubigeocode ,
                                          String AV56Ubigeowwds_5_tfubigeodepartamento_sel ,
                                          String AV55Ubigeowwds_4_tfubigeodepartamento ,
                                          String AV58Ubigeowwds_7_tfubigeodepartamentocode_sel ,
                                          String AV57Ubigeowwds_6_tfubigeodepartamentocode ,
                                          String AV60Ubigeowwds_9_tfubigeoprovincia_sel ,
                                          String AV59Ubigeowwds_8_tfubigeoprovincia ,
                                          String AV62Ubigeowwds_11_tfubigeoprovinciacode_sel ,
                                          String AV61Ubigeowwds_10_tfubigeoprovinciacode ,
                                          String AV64Ubigeowwds_13_tfubigeodistrito_sel ,
                                          String AV63Ubigeowwds_12_tfubigeodistrito ,
                                          String AV66Ubigeowwds_15_tfubigeodistritocode_sel ,
                                          String AV65Ubigeowwds_14_tfubigeodistritocode ,
                                          String AV68Ubigeowwds_17_tfubigeonombre_sel ,
                                          String AV67Ubigeowwds_16_tfubigeonombre ,
                                          int AV69Ubigeowwds_18_tfubigeoestado_sels_size ,
                                          String A44UbigeoCode ,
                                          String A186UbigeoDepartamento ,
                                          String A187UbigeoProvincia ,
                                          String A188UbigeoDistrito )
   {
      java.lang.StringBuffer sWhereString = new java.lang.StringBuffer();
      String scmdbuf;
      byte[] GXv_int7 = new byte[26];
      Object[] GXv_Object8 = new Object[2];
      scmdbuf = "SELECT [UbigeoEstado], [UbigeoCode], [UbigeoDistrito], [UbigeoProvincia], [UbigeoDepartamento] FROM [Ubigeo]" ;
      if ( ! (GXutil.strcmp("", AV52Ubigeowwds_1_filterfulltext)==0) )
      {
         addWhere(sWhereString, "(( [UbigeoCode] like '%' + ?) or ( [UbigeoDepartamento] like '%' + ?) or ( SUBSTRING([UbigeoCode], 1, 2) like '%' + ?) or ( [UbigeoProvincia] like '%' + ?) or ( SUBSTRING([UbigeoCode], 3, 2) like '%' + ?) or ( [UbigeoDistrito] like '%' + ?) or ( SUBSTRING([UbigeoCode], 5, 2) like '%' + ?) or ( [UbigeoDepartamento] + ' / ' + [UbigeoProvincia] + ' / ' + [UbigeoDistrito] like '%' + ?) or ( 'activo' like '%' + LOWER(?) and [UbigeoEstado] = 'A') or ( 'inactivo' like '%' + LOWER(?) and [UbigeoEstado] = 'I'))");
      }
      else
      {
         GXv_int7[0] = (byte)(1) ;
         GXv_int7[1] = (byte)(1) ;
         GXv_int7[2] = (byte)(1) ;
         GXv_int7[3] = (byte)(1) ;
         GXv_int7[4] = (byte)(1) ;
         GXv_int7[5] = (byte)(1) ;
         GXv_int7[6] = (byte)(1) ;
         GXv_int7[7] = (byte)(1) ;
         GXv_int7[8] = (byte)(1) ;
         GXv_int7[9] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV54Ubigeowwds_3_tfubigeocode_sel)==0) && ( ! (GXutil.strcmp("", AV53Ubigeowwds_2_tfubigeocode)==0) ) )
      {
         addWhere(sWhereString, "([UbigeoCode] like ?)");
      }
      else
      {
         GXv_int7[10] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV54Ubigeowwds_3_tfubigeocode_sel)==0) )
      {
         addWhere(sWhereString, "([UbigeoCode] = ?)");
      }
      else
      {
         GXv_int7[11] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV56Ubigeowwds_5_tfubigeodepartamento_sel)==0) && ( ! (GXutil.strcmp("", AV55Ubigeowwds_4_tfubigeodepartamento)==0) ) )
      {
         addWhere(sWhereString, "([UbigeoDepartamento] like ?)");
      }
      else
      {
         GXv_int7[12] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV56Ubigeowwds_5_tfubigeodepartamento_sel)==0) )
      {
         addWhere(sWhereString, "([UbigeoDepartamento] = ?)");
      }
      else
      {
         GXv_int7[13] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV58Ubigeowwds_7_tfubigeodepartamentocode_sel)==0) && ( ! (GXutil.strcmp("", AV57Ubigeowwds_6_tfubigeodepartamentocode)==0) ) )
      {
         addWhere(sWhereString, "(SUBSTRING([UbigeoCode], 1, 2) like ?)");
      }
      else
      {
         GXv_int7[14] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV58Ubigeowwds_7_tfubigeodepartamentocode_sel)==0) )
      {
         addWhere(sWhereString, "(SUBSTRING([UbigeoCode], 1, 2) = ?)");
      }
      else
      {
         GXv_int7[15] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV60Ubigeowwds_9_tfubigeoprovincia_sel)==0) && ( ! (GXutil.strcmp("", AV59Ubigeowwds_8_tfubigeoprovincia)==0) ) )
      {
         addWhere(sWhereString, "([UbigeoProvincia] like ?)");
      }
      else
      {
         GXv_int7[16] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV60Ubigeowwds_9_tfubigeoprovincia_sel)==0) )
      {
         addWhere(sWhereString, "([UbigeoProvincia] = ?)");
      }
      else
      {
         GXv_int7[17] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV62Ubigeowwds_11_tfubigeoprovinciacode_sel)==0) && ( ! (GXutil.strcmp("", AV61Ubigeowwds_10_tfubigeoprovinciacode)==0) ) )
      {
         addWhere(sWhereString, "(SUBSTRING([UbigeoCode], 3, 2) like ?)");
      }
      else
      {
         GXv_int7[18] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV62Ubigeowwds_11_tfubigeoprovinciacode_sel)==0) )
      {
         addWhere(sWhereString, "(SUBSTRING([UbigeoCode], 3, 2) = ?)");
      }
      else
      {
         GXv_int7[19] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV64Ubigeowwds_13_tfubigeodistrito_sel)==0) && ( ! (GXutil.strcmp("", AV63Ubigeowwds_12_tfubigeodistrito)==0) ) )
      {
         addWhere(sWhereString, "([UbigeoDistrito] like ?)");
      }
      else
      {
         GXv_int7[20] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV64Ubigeowwds_13_tfubigeodistrito_sel)==0) )
      {
         addWhere(sWhereString, "([UbigeoDistrito] = ?)");
      }
      else
      {
         GXv_int7[21] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV66Ubigeowwds_15_tfubigeodistritocode_sel)==0) && ( ! (GXutil.strcmp("", AV65Ubigeowwds_14_tfubigeodistritocode)==0) ) )
      {
         addWhere(sWhereString, "(SUBSTRING([UbigeoCode], 5, 2) like ?)");
      }
      else
      {
         GXv_int7[22] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV66Ubigeowwds_15_tfubigeodistritocode_sel)==0) )
      {
         addWhere(sWhereString, "(SUBSTRING([UbigeoCode], 5, 2) = ?)");
      }
      else
      {
         GXv_int7[23] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV68Ubigeowwds_17_tfubigeonombre_sel)==0) && ( ! (GXutil.strcmp("", AV67Ubigeowwds_16_tfubigeonombre)==0) ) )
      {
         addWhere(sWhereString, "([UbigeoDepartamento] + ' / ' + [UbigeoProvincia] + ' / ' + [UbigeoDistrito] like ?)");
      }
      else
      {
         GXv_int7[24] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV68Ubigeowwds_17_tfubigeonombre_sel)==0) )
      {
         addWhere(sWhereString, "([UbigeoDepartamento] + ' / ' + [UbigeoProvincia] + ' / ' + [UbigeoDistrito] = ?)");
      }
      else
      {
         GXv_int7[25] = (byte)(1) ;
      }
      if ( AV69Ubigeowwds_18_tfubigeoestado_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("sqlserver", AV69Ubigeowwds_18_tfubigeoestado_sels, "[UbigeoEstado] IN (", ")")+")");
      }
      scmdbuf += sWhereString ;
      scmdbuf += " ORDER BY [UbigeoDepartamento]" ;
      GXv_Object8[0] = scmdbuf ;
      GXv_Object8[1] = GXv_int7 ;
      return GXv_Object8 ;
   }

   protected Object[] conditional_P003L4( ModelContext context ,
                                          int remoteHandle ,
                                          com.genexus.IHttpContext httpContext ,
                                          String A294UbigeoEstado ,
                                          GXSimpleCollection<String> AV69Ubigeowwds_18_tfubigeoestado_sels ,
                                          String AV52Ubigeowwds_1_filterfulltext ,
                                          String AV54Ubigeowwds_3_tfubigeocode_sel ,
                                          String AV53Ubigeowwds_2_tfubigeocode ,
                                          String AV56Ubigeowwds_5_tfubigeodepartamento_sel ,
                                          String AV55Ubigeowwds_4_tfubigeodepartamento ,
                                          String AV58Ubigeowwds_7_tfubigeodepartamentocode_sel ,
                                          String AV57Ubigeowwds_6_tfubigeodepartamentocode ,
                                          String AV60Ubigeowwds_9_tfubigeoprovincia_sel ,
                                          String AV59Ubigeowwds_8_tfubigeoprovincia ,
                                          String AV62Ubigeowwds_11_tfubigeoprovinciacode_sel ,
                                          String AV61Ubigeowwds_10_tfubigeoprovinciacode ,
                                          String AV64Ubigeowwds_13_tfubigeodistrito_sel ,
                                          String AV63Ubigeowwds_12_tfubigeodistrito ,
                                          String AV66Ubigeowwds_15_tfubigeodistritocode_sel ,
                                          String AV65Ubigeowwds_14_tfubigeodistritocode ,
                                          String AV68Ubigeowwds_17_tfubigeonombre_sel ,
                                          String AV67Ubigeowwds_16_tfubigeonombre ,
                                          int AV69Ubigeowwds_18_tfubigeoestado_sels_size ,
                                          String A44UbigeoCode ,
                                          String A186UbigeoDepartamento ,
                                          String A187UbigeoProvincia ,
                                          String A188UbigeoDistrito )
   {
      java.lang.StringBuffer sWhereString = new java.lang.StringBuffer();
      String scmdbuf;
      byte[] GXv_int10 = new byte[26];
      Object[] GXv_Object11 = new Object[2];
      scmdbuf = "SELECT [UbigeoEstado], [UbigeoCode], [UbigeoDistrito], [UbigeoProvincia], [UbigeoDepartamento] FROM [Ubigeo]" ;
      if ( ! (GXutil.strcmp("", AV52Ubigeowwds_1_filterfulltext)==0) )
      {
         addWhere(sWhereString, "(( [UbigeoCode] like '%' + ?) or ( [UbigeoDepartamento] like '%' + ?) or ( SUBSTRING([UbigeoCode], 1, 2) like '%' + ?) or ( [UbigeoProvincia] like '%' + ?) or ( SUBSTRING([UbigeoCode], 3, 2) like '%' + ?) or ( [UbigeoDistrito] like '%' + ?) or ( SUBSTRING([UbigeoCode], 5, 2) like '%' + ?) or ( [UbigeoDepartamento] + ' / ' + [UbigeoProvincia] + ' / ' + [UbigeoDistrito] like '%' + ?) or ( 'activo' like '%' + LOWER(?) and [UbigeoEstado] = 'A') or ( 'inactivo' like '%' + LOWER(?) and [UbigeoEstado] = 'I'))");
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
      if ( (GXutil.strcmp("", AV54Ubigeowwds_3_tfubigeocode_sel)==0) && ( ! (GXutil.strcmp("", AV53Ubigeowwds_2_tfubigeocode)==0) ) )
      {
         addWhere(sWhereString, "([UbigeoCode] like ?)");
      }
      else
      {
         GXv_int10[10] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV54Ubigeowwds_3_tfubigeocode_sel)==0) )
      {
         addWhere(sWhereString, "([UbigeoCode] = ?)");
      }
      else
      {
         GXv_int10[11] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV56Ubigeowwds_5_tfubigeodepartamento_sel)==0) && ( ! (GXutil.strcmp("", AV55Ubigeowwds_4_tfubigeodepartamento)==0) ) )
      {
         addWhere(sWhereString, "([UbigeoDepartamento] like ?)");
      }
      else
      {
         GXv_int10[12] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV56Ubigeowwds_5_tfubigeodepartamento_sel)==0) )
      {
         addWhere(sWhereString, "([UbigeoDepartamento] = ?)");
      }
      else
      {
         GXv_int10[13] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV58Ubigeowwds_7_tfubigeodepartamentocode_sel)==0) && ( ! (GXutil.strcmp("", AV57Ubigeowwds_6_tfubigeodepartamentocode)==0) ) )
      {
         addWhere(sWhereString, "(SUBSTRING([UbigeoCode], 1, 2) like ?)");
      }
      else
      {
         GXv_int10[14] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV58Ubigeowwds_7_tfubigeodepartamentocode_sel)==0) )
      {
         addWhere(sWhereString, "(SUBSTRING([UbigeoCode], 1, 2) = ?)");
      }
      else
      {
         GXv_int10[15] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV60Ubigeowwds_9_tfubigeoprovincia_sel)==0) && ( ! (GXutil.strcmp("", AV59Ubigeowwds_8_tfubigeoprovincia)==0) ) )
      {
         addWhere(sWhereString, "([UbigeoProvincia] like ?)");
      }
      else
      {
         GXv_int10[16] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV60Ubigeowwds_9_tfubigeoprovincia_sel)==0) )
      {
         addWhere(sWhereString, "([UbigeoProvincia] = ?)");
      }
      else
      {
         GXv_int10[17] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV62Ubigeowwds_11_tfubigeoprovinciacode_sel)==0) && ( ! (GXutil.strcmp("", AV61Ubigeowwds_10_tfubigeoprovinciacode)==0) ) )
      {
         addWhere(sWhereString, "(SUBSTRING([UbigeoCode], 3, 2) like ?)");
      }
      else
      {
         GXv_int10[18] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV62Ubigeowwds_11_tfubigeoprovinciacode_sel)==0) )
      {
         addWhere(sWhereString, "(SUBSTRING([UbigeoCode], 3, 2) = ?)");
      }
      else
      {
         GXv_int10[19] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV64Ubigeowwds_13_tfubigeodistrito_sel)==0) && ( ! (GXutil.strcmp("", AV63Ubigeowwds_12_tfubigeodistrito)==0) ) )
      {
         addWhere(sWhereString, "([UbigeoDistrito] like ?)");
      }
      else
      {
         GXv_int10[20] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV64Ubigeowwds_13_tfubigeodistrito_sel)==0) )
      {
         addWhere(sWhereString, "([UbigeoDistrito] = ?)");
      }
      else
      {
         GXv_int10[21] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV66Ubigeowwds_15_tfubigeodistritocode_sel)==0) && ( ! (GXutil.strcmp("", AV65Ubigeowwds_14_tfubigeodistritocode)==0) ) )
      {
         addWhere(sWhereString, "(SUBSTRING([UbigeoCode], 5, 2) like ?)");
      }
      else
      {
         GXv_int10[22] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV66Ubigeowwds_15_tfubigeodistritocode_sel)==0) )
      {
         addWhere(sWhereString, "(SUBSTRING([UbigeoCode], 5, 2) = ?)");
      }
      else
      {
         GXv_int10[23] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV68Ubigeowwds_17_tfubigeonombre_sel)==0) && ( ! (GXutil.strcmp("", AV67Ubigeowwds_16_tfubigeonombre)==0) ) )
      {
         addWhere(sWhereString, "([UbigeoDepartamento] + ' / ' + [UbigeoProvincia] + ' / ' + [UbigeoDistrito] like ?)");
      }
      else
      {
         GXv_int10[24] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV68Ubigeowwds_17_tfubigeonombre_sel)==0) )
      {
         addWhere(sWhereString, "([UbigeoDepartamento] + ' / ' + [UbigeoProvincia] + ' / ' + [UbigeoDistrito] = ?)");
      }
      else
      {
         GXv_int10[25] = (byte)(1) ;
      }
      if ( AV69Ubigeowwds_18_tfubigeoestado_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("sqlserver", AV69Ubigeowwds_18_tfubigeoestado_sels, "[UbigeoEstado] IN (", ")")+")");
      }
      scmdbuf += sWhereString ;
      scmdbuf += " ORDER BY [UbigeoCode]" ;
      GXv_Object11[0] = scmdbuf ;
      GXv_Object11[1] = GXv_int10 ;
      return GXv_Object11 ;
   }

   protected Object[] conditional_P003L5( ModelContext context ,
                                          int remoteHandle ,
                                          com.genexus.IHttpContext httpContext ,
                                          String A294UbigeoEstado ,
                                          GXSimpleCollection<String> AV69Ubigeowwds_18_tfubigeoestado_sels ,
                                          String AV52Ubigeowwds_1_filterfulltext ,
                                          String AV54Ubigeowwds_3_tfubigeocode_sel ,
                                          String AV53Ubigeowwds_2_tfubigeocode ,
                                          String AV56Ubigeowwds_5_tfubigeodepartamento_sel ,
                                          String AV55Ubigeowwds_4_tfubigeodepartamento ,
                                          String AV58Ubigeowwds_7_tfubigeodepartamentocode_sel ,
                                          String AV57Ubigeowwds_6_tfubigeodepartamentocode ,
                                          String AV60Ubigeowwds_9_tfubigeoprovincia_sel ,
                                          String AV59Ubigeowwds_8_tfubigeoprovincia ,
                                          String AV62Ubigeowwds_11_tfubigeoprovinciacode_sel ,
                                          String AV61Ubigeowwds_10_tfubigeoprovinciacode ,
                                          String AV64Ubigeowwds_13_tfubigeodistrito_sel ,
                                          String AV63Ubigeowwds_12_tfubigeodistrito ,
                                          String AV66Ubigeowwds_15_tfubigeodistritocode_sel ,
                                          String AV65Ubigeowwds_14_tfubigeodistritocode ,
                                          String AV68Ubigeowwds_17_tfubigeonombre_sel ,
                                          String AV67Ubigeowwds_16_tfubigeonombre ,
                                          int AV69Ubigeowwds_18_tfubigeoestado_sels_size ,
                                          String A44UbigeoCode ,
                                          String A186UbigeoDepartamento ,
                                          String A187UbigeoProvincia ,
                                          String A188UbigeoDistrito )
   {
      java.lang.StringBuffer sWhereString = new java.lang.StringBuffer();
      String scmdbuf;
      byte[] GXv_int13 = new byte[26];
      Object[] GXv_Object14 = new Object[2];
      scmdbuf = "SELECT [UbigeoEstado], [UbigeoCode], [UbigeoDistrito], [UbigeoProvincia], [UbigeoDepartamento] FROM [Ubigeo]" ;
      if ( ! (GXutil.strcmp("", AV52Ubigeowwds_1_filterfulltext)==0) )
      {
         addWhere(sWhereString, "(( [UbigeoCode] like '%' + ?) or ( [UbigeoDepartamento] like '%' + ?) or ( SUBSTRING([UbigeoCode], 1, 2) like '%' + ?) or ( [UbigeoProvincia] like '%' + ?) or ( SUBSTRING([UbigeoCode], 3, 2) like '%' + ?) or ( [UbigeoDistrito] like '%' + ?) or ( SUBSTRING([UbigeoCode], 5, 2) like '%' + ?) or ( [UbigeoDepartamento] + ' / ' + [UbigeoProvincia] + ' / ' + [UbigeoDistrito] like '%' + ?) or ( 'activo' like '%' + LOWER(?) and [UbigeoEstado] = 'A') or ( 'inactivo' like '%' + LOWER(?) and [UbigeoEstado] = 'I'))");
      }
      else
      {
         GXv_int13[0] = (byte)(1) ;
         GXv_int13[1] = (byte)(1) ;
         GXv_int13[2] = (byte)(1) ;
         GXv_int13[3] = (byte)(1) ;
         GXv_int13[4] = (byte)(1) ;
         GXv_int13[5] = (byte)(1) ;
         GXv_int13[6] = (byte)(1) ;
         GXv_int13[7] = (byte)(1) ;
         GXv_int13[8] = (byte)(1) ;
         GXv_int13[9] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV54Ubigeowwds_3_tfubigeocode_sel)==0) && ( ! (GXutil.strcmp("", AV53Ubigeowwds_2_tfubigeocode)==0) ) )
      {
         addWhere(sWhereString, "([UbigeoCode] like ?)");
      }
      else
      {
         GXv_int13[10] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV54Ubigeowwds_3_tfubigeocode_sel)==0) )
      {
         addWhere(sWhereString, "([UbigeoCode] = ?)");
      }
      else
      {
         GXv_int13[11] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV56Ubigeowwds_5_tfubigeodepartamento_sel)==0) && ( ! (GXutil.strcmp("", AV55Ubigeowwds_4_tfubigeodepartamento)==0) ) )
      {
         addWhere(sWhereString, "([UbigeoDepartamento] like ?)");
      }
      else
      {
         GXv_int13[12] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV56Ubigeowwds_5_tfubigeodepartamento_sel)==0) )
      {
         addWhere(sWhereString, "([UbigeoDepartamento] = ?)");
      }
      else
      {
         GXv_int13[13] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV58Ubigeowwds_7_tfubigeodepartamentocode_sel)==0) && ( ! (GXutil.strcmp("", AV57Ubigeowwds_6_tfubigeodepartamentocode)==0) ) )
      {
         addWhere(sWhereString, "(SUBSTRING([UbigeoCode], 1, 2) like ?)");
      }
      else
      {
         GXv_int13[14] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV58Ubigeowwds_7_tfubigeodepartamentocode_sel)==0) )
      {
         addWhere(sWhereString, "(SUBSTRING([UbigeoCode], 1, 2) = ?)");
      }
      else
      {
         GXv_int13[15] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV60Ubigeowwds_9_tfubigeoprovincia_sel)==0) && ( ! (GXutil.strcmp("", AV59Ubigeowwds_8_tfubigeoprovincia)==0) ) )
      {
         addWhere(sWhereString, "([UbigeoProvincia] like ?)");
      }
      else
      {
         GXv_int13[16] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV60Ubigeowwds_9_tfubigeoprovincia_sel)==0) )
      {
         addWhere(sWhereString, "([UbigeoProvincia] = ?)");
      }
      else
      {
         GXv_int13[17] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV62Ubigeowwds_11_tfubigeoprovinciacode_sel)==0) && ( ! (GXutil.strcmp("", AV61Ubigeowwds_10_tfubigeoprovinciacode)==0) ) )
      {
         addWhere(sWhereString, "(SUBSTRING([UbigeoCode], 3, 2) like ?)");
      }
      else
      {
         GXv_int13[18] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV62Ubigeowwds_11_tfubigeoprovinciacode_sel)==0) )
      {
         addWhere(sWhereString, "(SUBSTRING([UbigeoCode], 3, 2) = ?)");
      }
      else
      {
         GXv_int13[19] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV64Ubigeowwds_13_tfubigeodistrito_sel)==0) && ( ! (GXutil.strcmp("", AV63Ubigeowwds_12_tfubigeodistrito)==0) ) )
      {
         addWhere(sWhereString, "([UbigeoDistrito] like ?)");
      }
      else
      {
         GXv_int13[20] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV64Ubigeowwds_13_tfubigeodistrito_sel)==0) )
      {
         addWhere(sWhereString, "([UbigeoDistrito] = ?)");
      }
      else
      {
         GXv_int13[21] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV66Ubigeowwds_15_tfubigeodistritocode_sel)==0) && ( ! (GXutil.strcmp("", AV65Ubigeowwds_14_tfubigeodistritocode)==0) ) )
      {
         addWhere(sWhereString, "(SUBSTRING([UbigeoCode], 5, 2) like ?)");
      }
      else
      {
         GXv_int13[22] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV66Ubigeowwds_15_tfubigeodistritocode_sel)==0) )
      {
         addWhere(sWhereString, "(SUBSTRING([UbigeoCode], 5, 2) = ?)");
      }
      else
      {
         GXv_int13[23] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV68Ubigeowwds_17_tfubigeonombre_sel)==0) && ( ! (GXutil.strcmp("", AV67Ubigeowwds_16_tfubigeonombre)==0) ) )
      {
         addWhere(sWhereString, "([UbigeoDepartamento] + ' / ' + [UbigeoProvincia] + ' / ' + [UbigeoDistrito] like ?)");
      }
      else
      {
         GXv_int13[24] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV68Ubigeowwds_17_tfubigeonombre_sel)==0) )
      {
         addWhere(sWhereString, "([UbigeoDepartamento] + ' / ' + [UbigeoProvincia] + ' / ' + [UbigeoDistrito] = ?)");
      }
      else
      {
         GXv_int13[25] = (byte)(1) ;
      }
      if ( AV69Ubigeowwds_18_tfubigeoestado_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("sqlserver", AV69Ubigeowwds_18_tfubigeoestado_sels, "[UbigeoEstado] IN (", ")")+")");
      }
      scmdbuf += sWhereString ;
      scmdbuf += " ORDER BY [UbigeoProvincia]" ;
      GXv_Object14[0] = scmdbuf ;
      GXv_Object14[1] = GXv_int13 ;
      return GXv_Object14 ;
   }

   protected Object[] conditional_P003L6( ModelContext context ,
                                          int remoteHandle ,
                                          com.genexus.IHttpContext httpContext ,
                                          String A294UbigeoEstado ,
                                          GXSimpleCollection<String> AV69Ubigeowwds_18_tfubigeoestado_sels ,
                                          String AV52Ubigeowwds_1_filterfulltext ,
                                          String AV54Ubigeowwds_3_tfubigeocode_sel ,
                                          String AV53Ubigeowwds_2_tfubigeocode ,
                                          String AV56Ubigeowwds_5_tfubigeodepartamento_sel ,
                                          String AV55Ubigeowwds_4_tfubigeodepartamento ,
                                          String AV58Ubigeowwds_7_tfubigeodepartamentocode_sel ,
                                          String AV57Ubigeowwds_6_tfubigeodepartamentocode ,
                                          String AV60Ubigeowwds_9_tfubigeoprovincia_sel ,
                                          String AV59Ubigeowwds_8_tfubigeoprovincia ,
                                          String AV62Ubigeowwds_11_tfubigeoprovinciacode_sel ,
                                          String AV61Ubigeowwds_10_tfubigeoprovinciacode ,
                                          String AV64Ubigeowwds_13_tfubigeodistrito_sel ,
                                          String AV63Ubigeowwds_12_tfubigeodistrito ,
                                          String AV66Ubigeowwds_15_tfubigeodistritocode_sel ,
                                          String AV65Ubigeowwds_14_tfubigeodistritocode ,
                                          String AV68Ubigeowwds_17_tfubigeonombre_sel ,
                                          String AV67Ubigeowwds_16_tfubigeonombre ,
                                          int AV69Ubigeowwds_18_tfubigeoestado_sels_size ,
                                          String A44UbigeoCode ,
                                          String A186UbigeoDepartamento ,
                                          String A187UbigeoProvincia ,
                                          String A188UbigeoDistrito )
   {
      java.lang.StringBuffer sWhereString = new java.lang.StringBuffer();
      String scmdbuf;
      byte[] GXv_int16 = new byte[26];
      Object[] GXv_Object17 = new Object[2];
      scmdbuf = "SELECT [UbigeoEstado], [UbigeoCode], [UbigeoDistrito], [UbigeoProvincia], [UbigeoDepartamento] FROM [Ubigeo]" ;
      if ( ! (GXutil.strcmp("", AV52Ubigeowwds_1_filterfulltext)==0) )
      {
         addWhere(sWhereString, "(( [UbigeoCode] like '%' + ?) or ( [UbigeoDepartamento] like '%' + ?) or ( SUBSTRING([UbigeoCode], 1, 2) like '%' + ?) or ( [UbigeoProvincia] like '%' + ?) or ( SUBSTRING([UbigeoCode], 3, 2) like '%' + ?) or ( [UbigeoDistrito] like '%' + ?) or ( SUBSTRING([UbigeoCode], 5, 2) like '%' + ?) or ( [UbigeoDepartamento] + ' / ' + [UbigeoProvincia] + ' / ' + [UbigeoDistrito] like '%' + ?) or ( 'activo' like '%' + LOWER(?) and [UbigeoEstado] = 'A') or ( 'inactivo' like '%' + LOWER(?) and [UbigeoEstado] = 'I'))");
      }
      else
      {
         GXv_int16[0] = (byte)(1) ;
         GXv_int16[1] = (byte)(1) ;
         GXv_int16[2] = (byte)(1) ;
         GXv_int16[3] = (byte)(1) ;
         GXv_int16[4] = (byte)(1) ;
         GXv_int16[5] = (byte)(1) ;
         GXv_int16[6] = (byte)(1) ;
         GXv_int16[7] = (byte)(1) ;
         GXv_int16[8] = (byte)(1) ;
         GXv_int16[9] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV54Ubigeowwds_3_tfubigeocode_sel)==0) && ( ! (GXutil.strcmp("", AV53Ubigeowwds_2_tfubigeocode)==0) ) )
      {
         addWhere(sWhereString, "([UbigeoCode] like ?)");
      }
      else
      {
         GXv_int16[10] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV54Ubigeowwds_3_tfubigeocode_sel)==0) )
      {
         addWhere(sWhereString, "([UbigeoCode] = ?)");
      }
      else
      {
         GXv_int16[11] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV56Ubigeowwds_5_tfubigeodepartamento_sel)==0) && ( ! (GXutil.strcmp("", AV55Ubigeowwds_4_tfubigeodepartamento)==0) ) )
      {
         addWhere(sWhereString, "([UbigeoDepartamento] like ?)");
      }
      else
      {
         GXv_int16[12] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV56Ubigeowwds_5_tfubigeodepartamento_sel)==0) )
      {
         addWhere(sWhereString, "([UbigeoDepartamento] = ?)");
      }
      else
      {
         GXv_int16[13] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV58Ubigeowwds_7_tfubigeodepartamentocode_sel)==0) && ( ! (GXutil.strcmp("", AV57Ubigeowwds_6_tfubigeodepartamentocode)==0) ) )
      {
         addWhere(sWhereString, "(SUBSTRING([UbigeoCode], 1, 2) like ?)");
      }
      else
      {
         GXv_int16[14] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV58Ubigeowwds_7_tfubigeodepartamentocode_sel)==0) )
      {
         addWhere(sWhereString, "(SUBSTRING([UbigeoCode], 1, 2) = ?)");
      }
      else
      {
         GXv_int16[15] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV60Ubigeowwds_9_tfubigeoprovincia_sel)==0) && ( ! (GXutil.strcmp("", AV59Ubigeowwds_8_tfubigeoprovincia)==0) ) )
      {
         addWhere(sWhereString, "([UbigeoProvincia] like ?)");
      }
      else
      {
         GXv_int16[16] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV60Ubigeowwds_9_tfubigeoprovincia_sel)==0) )
      {
         addWhere(sWhereString, "([UbigeoProvincia] = ?)");
      }
      else
      {
         GXv_int16[17] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV62Ubigeowwds_11_tfubigeoprovinciacode_sel)==0) && ( ! (GXutil.strcmp("", AV61Ubigeowwds_10_tfubigeoprovinciacode)==0) ) )
      {
         addWhere(sWhereString, "(SUBSTRING([UbigeoCode], 3, 2) like ?)");
      }
      else
      {
         GXv_int16[18] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV62Ubigeowwds_11_tfubigeoprovinciacode_sel)==0) )
      {
         addWhere(sWhereString, "(SUBSTRING([UbigeoCode], 3, 2) = ?)");
      }
      else
      {
         GXv_int16[19] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV64Ubigeowwds_13_tfubigeodistrito_sel)==0) && ( ! (GXutil.strcmp("", AV63Ubigeowwds_12_tfubigeodistrito)==0) ) )
      {
         addWhere(sWhereString, "([UbigeoDistrito] like ?)");
      }
      else
      {
         GXv_int16[20] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV64Ubigeowwds_13_tfubigeodistrito_sel)==0) )
      {
         addWhere(sWhereString, "([UbigeoDistrito] = ?)");
      }
      else
      {
         GXv_int16[21] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV66Ubigeowwds_15_tfubigeodistritocode_sel)==0) && ( ! (GXutil.strcmp("", AV65Ubigeowwds_14_tfubigeodistritocode)==0) ) )
      {
         addWhere(sWhereString, "(SUBSTRING([UbigeoCode], 5, 2) like ?)");
      }
      else
      {
         GXv_int16[22] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV66Ubigeowwds_15_tfubigeodistritocode_sel)==0) )
      {
         addWhere(sWhereString, "(SUBSTRING([UbigeoCode], 5, 2) = ?)");
      }
      else
      {
         GXv_int16[23] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV68Ubigeowwds_17_tfubigeonombre_sel)==0) && ( ! (GXutil.strcmp("", AV67Ubigeowwds_16_tfubigeonombre)==0) ) )
      {
         addWhere(sWhereString, "([UbigeoDepartamento] + ' / ' + [UbigeoProvincia] + ' / ' + [UbigeoDistrito] like ?)");
      }
      else
      {
         GXv_int16[24] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV68Ubigeowwds_17_tfubigeonombre_sel)==0) )
      {
         addWhere(sWhereString, "([UbigeoDepartamento] + ' / ' + [UbigeoProvincia] + ' / ' + [UbigeoDistrito] = ?)");
      }
      else
      {
         GXv_int16[25] = (byte)(1) ;
      }
      if ( AV69Ubigeowwds_18_tfubigeoestado_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("sqlserver", AV69Ubigeowwds_18_tfubigeoestado_sels, "[UbigeoEstado] IN (", ")")+")");
      }
      scmdbuf += sWhereString ;
      scmdbuf += " ORDER BY [UbigeoCode]" ;
      GXv_Object17[0] = scmdbuf ;
      GXv_Object17[1] = GXv_int16 ;
      return GXv_Object17 ;
   }

   protected Object[] conditional_P003L7( ModelContext context ,
                                          int remoteHandle ,
                                          com.genexus.IHttpContext httpContext ,
                                          String A294UbigeoEstado ,
                                          GXSimpleCollection<String> AV69Ubigeowwds_18_tfubigeoestado_sels ,
                                          String AV52Ubigeowwds_1_filterfulltext ,
                                          String AV54Ubigeowwds_3_tfubigeocode_sel ,
                                          String AV53Ubigeowwds_2_tfubigeocode ,
                                          String AV56Ubigeowwds_5_tfubigeodepartamento_sel ,
                                          String AV55Ubigeowwds_4_tfubigeodepartamento ,
                                          String AV58Ubigeowwds_7_tfubigeodepartamentocode_sel ,
                                          String AV57Ubigeowwds_6_tfubigeodepartamentocode ,
                                          String AV60Ubigeowwds_9_tfubigeoprovincia_sel ,
                                          String AV59Ubigeowwds_8_tfubigeoprovincia ,
                                          String AV62Ubigeowwds_11_tfubigeoprovinciacode_sel ,
                                          String AV61Ubigeowwds_10_tfubigeoprovinciacode ,
                                          String AV64Ubigeowwds_13_tfubigeodistrito_sel ,
                                          String AV63Ubigeowwds_12_tfubigeodistrito ,
                                          String AV66Ubigeowwds_15_tfubigeodistritocode_sel ,
                                          String AV65Ubigeowwds_14_tfubigeodistritocode ,
                                          String AV68Ubigeowwds_17_tfubigeonombre_sel ,
                                          String AV67Ubigeowwds_16_tfubigeonombre ,
                                          int AV69Ubigeowwds_18_tfubigeoestado_sels_size ,
                                          String A44UbigeoCode ,
                                          String A186UbigeoDepartamento ,
                                          String A187UbigeoProvincia ,
                                          String A188UbigeoDistrito )
   {
      java.lang.StringBuffer sWhereString = new java.lang.StringBuffer();
      String scmdbuf;
      byte[] GXv_int19 = new byte[26];
      Object[] GXv_Object20 = new Object[2];
      scmdbuf = "SELECT [UbigeoEstado], [UbigeoCode], [UbigeoDistrito], [UbigeoProvincia], [UbigeoDepartamento] FROM [Ubigeo]" ;
      if ( ! (GXutil.strcmp("", AV52Ubigeowwds_1_filterfulltext)==0) )
      {
         addWhere(sWhereString, "(( [UbigeoCode] like '%' + ?) or ( [UbigeoDepartamento] like '%' + ?) or ( SUBSTRING([UbigeoCode], 1, 2) like '%' + ?) or ( [UbigeoProvincia] like '%' + ?) or ( SUBSTRING([UbigeoCode], 3, 2) like '%' + ?) or ( [UbigeoDistrito] like '%' + ?) or ( SUBSTRING([UbigeoCode], 5, 2) like '%' + ?) or ( [UbigeoDepartamento] + ' / ' + [UbigeoProvincia] + ' / ' + [UbigeoDistrito] like '%' + ?) or ( 'activo' like '%' + LOWER(?) and [UbigeoEstado] = 'A') or ( 'inactivo' like '%' + LOWER(?) and [UbigeoEstado] = 'I'))");
      }
      else
      {
         GXv_int19[0] = (byte)(1) ;
         GXv_int19[1] = (byte)(1) ;
         GXv_int19[2] = (byte)(1) ;
         GXv_int19[3] = (byte)(1) ;
         GXv_int19[4] = (byte)(1) ;
         GXv_int19[5] = (byte)(1) ;
         GXv_int19[6] = (byte)(1) ;
         GXv_int19[7] = (byte)(1) ;
         GXv_int19[8] = (byte)(1) ;
         GXv_int19[9] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV54Ubigeowwds_3_tfubigeocode_sel)==0) && ( ! (GXutil.strcmp("", AV53Ubigeowwds_2_tfubigeocode)==0) ) )
      {
         addWhere(sWhereString, "([UbigeoCode] like ?)");
      }
      else
      {
         GXv_int19[10] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV54Ubigeowwds_3_tfubigeocode_sel)==0) )
      {
         addWhere(sWhereString, "([UbigeoCode] = ?)");
      }
      else
      {
         GXv_int19[11] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV56Ubigeowwds_5_tfubigeodepartamento_sel)==0) && ( ! (GXutil.strcmp("", AV55Ubigeowwds_4_tfubigeodepartamento)==0) ) )
      {
         addWhere(sWhereString, "([UbigeoDepartamento] like ?)");
      }
      else
      {
         GXv_int19[12] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV56Ubigeowwds_5_tfubigeodepartamento_sel)==0) )
      {
         addWhere(sWhereString, "([UbigeoDepartamento] = ?)");
      }
      else
      {
         GXv_int19[13] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV58Ubigeowwds_7_tfubigeodepartamentocode_sel)==0) && ( ! (GXutil.strcmp("", AV57Ubigeowwds_6_tfubigeodepartamentocode)==0) ) )
      {
         addWhere(sWhereString, "(SUBSTRING([UbigeoCode], 1, 2) like ?)");
      }
      else
      {
         GXv_int19[14] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV58Ubigeowwds_7_tfubigeodepartamentocode_sel)==0) )
      {
         addWhere(sWhereString, "(SUBSTRING([UbigeoCode], 1, 2) = ?)");
      }
      else
      {
         GXv_int19[15] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV60Ubigeowwds_9_tfubigeoprovincia_sel)==0) && ( ! (GXutil.strcmp("", AV59Ubigeowwds_8_tfubigeoprovincia)==0) ) )
      {
         addWhere(sWhereString, "([UbigeoProvincia] like ?)");
      }
      else
      {
         GXv_int19[16] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV60Ubigeowwds_9_tfubigeoprovincia_sel)==0) )
      {
         addWhere(sWhereString, "([UbigeoProvincia] = ?)");
      }
      else
      {
         GXv_int19[17] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV62Ubigeowwds_11_tfubigeoprovinciacode_sel)==0) && ( ! (GXutil.strcmp("", AV61Ubigeowwds_10_tfubigeoprovinciacode)==0) ) )
      {
         addWhere(sWhereString, "(SUBSTRING([UbigeoCode], 3, 2) like ?)");
      }
      else
      {
         GXv_int19[18] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV62Ubigeowwds_11_tfubigeoprovinciacode_sel)==0) )
      {
         addWhere(sWhereString, "(SUBSTRING([UbigeoCode], 3, 2) = ?)");
      }
      else
      {
         GXv_int19[19] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV64Ubigeowwds_13_tfubigeodistrito_sel)==0) && ( ! (GXutil.strcmp("", AV63Ubigeowwds_12_tfubigeodistrito)==0) ) )
      {
         addWhere(sWhereString, "([UbigeoDistrito] like ?)");
      }
      else
      {
         GXv_int19[20] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV64Ubigeowwds_13_tfubigeodistrito_sel)==0) )
      {
         addWhere(sWhereString, "([UbigeoDistrito] = ?)");
      }
      else
      {
         GXv_int19[21] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV66Ubigeowwds_15_tfubigeodistritocode_sel)==0) && ( ! (GXutil.strcmp("", AV65Ubigeowwds_14_tfubigeodistritocode)==0) ) )
      {
         addWhere(sWhereString, "(SUBSTRING([UbigeoCode], 5, 2) like ?)");
      }
      else
      {
         GXv_int19[22] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV66Ubigeowwds_15_tfubigeodistritocode_sel)==0) )
      {
         addWhere(sWhereString, "(SUBSTRING([UbigeoCode], 5, 2) = ?)");
      }
      else
      {
         GXv_int19[23] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV68Ubigeowwds_17_tfubigeonombre_sel)==0) && ( ! (GXutil.strcmp("", AV67Ubigeowwds_16_tfubigeonombre)==0) ) )
      {
         addWhere(sWhereString, "([UbigeoDepartamento] + ' / ' + [UbigeoProvincia] + ' / ' + [UbigeoDistrito] like ?)");
      }
      else
      {
         GXv_int19[24] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV68Ubigeowwds_17_tfubigeonombre_sel)==0) )
      {
         addWhere(sWhereString, "([UbigeoDepartamento] + ' / ' + [UbigeoProvincia] + ' / ' + [UbigeoDistrito] = ?)");
      }
      else
      {
         GXv_int19[25] = (byte)(1) ;
      }
      if ( AV69Ubigeowwds_18_tfubigeoestado_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("sqlserver", AV69Ubigeowwds_18_tfubigeoestado_sels, "[UbigeoEstado] IN (", ")")+")");
      }
      scmdbuf += sWhereString ;
      scmdbuf += " ORDER BY [UbigeoDistrito]" ;
      GXv_Object20[0] = scmdbuf ;
      GXv_Object20[1] = GXv_int19 ;
      return GXv_Object20 ;
   }

   protected Object[] conditional_P003L8( ModelContext context ,
                                          int remoteHandle ,
                                          com.genexus.IHttpContext httpContext ,
                                          String A294UbigeoEstado ,
                                          GXSimpleCollection<String> AV69Ubigeowwds_18_tfubigeoestado_sels ,
                                          String AV52Ubigeowwds_1_filterfulltext ,
                                          String AV54Ubigeowwds_3_tfubigeocode_sel ,
                                          String AV53Ubigeowwds_2_tfubigeocode ,
                                          String AV56Ubigeowwds_5_tfubigeodepartamento_sel ,
                                          String AV55Ubigeowwds_4_tfubigeodepartamento ,
                                          String AV58Ubigeowwds_7_tfubigeodepartamentocode_sel ,
                                          String AV57Ubigeowwds_6_tfubigeodepartamentocode ,
                                          String AV60Ubigeowwds_9_tfubigeoprovincia_sel ,
                                          String AV59Ubigeowwds_8_tfubigeoprovincia ,
                                          String AV62Ubigeowwds_11_tfubigeoprovinciacode_sel ,
                                          String AV61Ubigeowwds_10_tfubigeoprovinciacode ,
                                          String AV64Ubigeowwds_13_tfubigeodistrito_sel ,
                                          String AV63Ubigeowwds_12_tfubigeodistrito ,
                                          String AV66Ubigeowwds_15_tfubigeodistritocode_sel ,
                                          String AV65Ubigeowwds_14_tfubigeodistritocode ,
                                          String AV68Ubigeowwds_17_tfubigeonombre_sel ,
                                          String AV67Ubigeowwds_16_tfubigeonombre ,
                                          int AV69Ubigeowwds_18_tfubigeoestado_sels_size ,
                                          String A44UbigeoCode ,
                                          String A186UbigeoDepartamento ,
                                          String A187UbigeoProvincia ,
                                          String A188UbigeoDistrito )
   {
      java.lang.StringBuffer sWhereString = new java.lang.StringBuffer();
      String scmdbuf;
      byte[] GXv_int22 = new byte[26];
      Object[] GXv_Object23 = new Object[2];
      scmdbuf = "SELECT [UbigeoEstado], [UbigeoCode], [UbigeoDistrito], [UbigeoProvincia], [UbigeoDepartamento] FROM [Ubigeo]" ;
      if ( ! (GXutil.strcmp("", AV52Ubigeowwds_1_filterfulltext)==0) )
      {
         addWhere(sWhereString, "(( [UbigeoCode] like '%' + ?) or ( [UbigeoDepartamento] like '%' + ?) or ( SUBSTRING([UbigeoCode], 1, 2) like '%' + ?) or ( [UbigeoProvincia] like '%' + ?) or ( SUBSTRING([UbigeoCode], 3, 2) like '%' + ?) or ( [UbigeoDistrito] like '%' + ?) or ( SUBSTRING([UbigeoCode], 5, 2) like '%' + ?) or ( [UbigeoDepartamento] + ' / ' + [UbigeoProvincia] + ' / ' + [UbigeoDistrito] like '%' + ?) or ( 'activo' like '%' + LOWER(?) and [UbigeoEstado] = 'A') or ( 'inactivo' like '%' + LOWER(?) and [UbigeoEstado] = 'I'))");
      }
      else
      {
         GXv_int22[0] = (byte)(1) ;
         GXv_int22[1] = (byte)(1) ;
         GXv_int22[2] = (byte)(1) ;
         GXv_int22[3] = (byte)(1) ;
         GXv_int22[4] = (byte)(1) ;
         GXv_int22[5] = (byte)(1) ;
         GXv_int22[6] = (byte)(1) ;
         GXv_int22[7] = (byte)(1) ;
         GXv_int22[8] = (byte)(1) ;
         GXv_int22[9] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV54Ubigeowwds_3_tfubigeocode_sel)==0) && ( ! (GXutil.strcmp("", AV53Ubigeowwds_2_tfubigeocode)==0) ) )
      {
         addWhere(sWhereString, "([UbigeoCode] like ?)");
      }
      else
      {
         GXv_int22[10] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV54Ubigeowwds_3_tfubigeocode_sel)==0) )
      {
         addWhere(sWhereString, "([UbigeoCode] = ?)");
      }
      else
      {
         GXv_int22[11] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV56Ubigeowwds_5_tfubigeodepartamento_sel)==0) && ( ! (GXutil.strcmp("", AV55Ubigeowwds_4_tfubigeodepartamento)==0) ) )
      {
         addWhere(sWhereString, "([UbigeoDepartamento] like ?)");
      }
      else
      {
         GXv_int22[12] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV56Ubigeowwds_5_tfubigeodepartamento_sel)==0) )
      {
         addWhere(sWhereString, "([UbigeoDepartamento] = ?)");
      }
      else
      {
         GXv_int22[13] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV58Ubigeowwds_7_tfubigeodepartamentocode_sel)==0) && ( ! (GXutil.strcmp("", AV57Ubigeowwds_6_tfubigeodepartamentocode)==0) ) )
      {
         addWhere(sWhereString, "(SUBSTRING([UbigeoCode], 1, 2) like ?)");
      }
      else
      {
         GXv_int22[14] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV58Ubigeowwds_7_tfubigeodepartamentocode_sel)==0) )
      {
         addWhere(sWhereString, "(SUBSTRING([UbigeoCode], 1, 2) = ?)");
      }
      else
      {
         GXv_int22[15] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV60Ubigeowwds_9_tfubigeoprovincia_sel)==0) && ( ! (GXutil.strcmp("", AV59Ubigeowwds_8_tfubigeoprovincia)==0) ) )
      {
         addWhere(sWhereString, "([UbigeoProvincia] like ?)");
      }
      else
      {
         GXv_int22[16] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV60Ubigeowwds_9_tfubigeoprovincia_sel)==0) )
      {
         addWhere(sWhereString, "([UbigeoProvincia] = ?)");
      }
      else
      {
         GXv_int22[17] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV62Ubigeowwds_11_tfubigeoprovinciacode_sel)==0) && ( ! (GXutil.strcmp("", AV61Ubigeowwds_10_tfubigeoprovinciacode)==0) ) )
      {
         addWhere(sWhereString, "(SUBSTRING([UbigeoCode], 3, 2) like ?)");
      }
      else
      {
         GXv_int22[18] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV62Ubigeowwds_11_tfubigeoprovinciacode_sel)==0) )
      {
         addWhere(sWhereString, "(SUBSTRING([UbigeoCode], 3, 2) = ?)");
      }
      else
      {
         GXv_int22[19] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV64Ubigeowwds_13_tfubigeodistrito_sel)==0) && ( ! (GXutil.strcmp("", AV63Ubigeowwds_12_tfubigeodistrito)==0) ) )
      {
         addWhere(sWhereString, "([UbigeoDistrito] like ?)");
      }
      else
      {
         GXv_int22[20] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV64Ubigeowwds_13_tfubigeodistrito_sel)==0) )
      {
         addWhere(sWhereString, "([UbigeoDistrito] = ?)");
      }
      else
      {
         GXv_int22[21] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV66Ubigeowwds_15_tfubigeodistritocode_sel)==0) && ( ! (GXutil.strcmp("", AV65Ubigeowwds_14_tfubigeodistritocode)==0) ) )
      {
         addWhere(sWhereString, "(SUBSTRING([UbigeoCode], 5, 2) like ?)");
      }
      else
      {
         GXv_int22[22] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV66Ubigeowwds_15_tfubigeodistritocode_sel)==0) )
      {
         addWhere(sWhereString, "(SUBSTRING([UbigeoCode], 5, 2) = ?)");
      }
      else
      {
         GXv_int22[23] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV68Ubigeowwds_17_tfubigeonombre_sel)==0) && ( ! (GXutil.strcmp("", AV67Ubigeowwds_16_tfubigeonombre)==0) ) )
      {
         addWhere(sWhereString, "([UbigeoDepartamento] + ' / ' + [UbigeoProvincia] + ' / ' + [UbigeoDistrito] like ?)");
      }
      else
      {
         GXv_int22[24] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV68Ubigeowwds_17_tfubigeonombre_sel)==0) )
      {
         addWhere(sWhereString, "([UbigeoDepartamento] + ' / ' + [UbigeoProvincia] + ' / ' + [UbigeoDistrito] = ?)");
      }
      else
      {
         GXv_int22[25] = (byte)(1) ;
      }
      if ( AV69Ubigeowwds_18_tfubigeoestado_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("sqlserver", AV69Ubigeowwds_18_tfubigeoestado_sels, "[UbigeoEstado] IN (", ")")+")");
      }
      scmdbuf += sWhereString ;
      scmdbuf += " ORDER BY [UbigeoCode]" ;
      GXv_Object23[0] = scmdbuf ;
      GXv_Object23[1] = GXv_int22 ;
      return GXv_Object23 ;
   }

   protected Object[] conditional_P003L9( ModelContext context ,
                                          int remoteHandle ,
                                          com.genexus.IHttpContext httpContext ,
                                          String A294UbigeoEstado ,
                                          GXSimpleCollection<String> AV69Ubigeowwds_18_tfubigeoestado_sels ,
                                          String AV52Ubigeowwds_1_filterfulltext ,
                                          String AV54Ubigeowwds_3_tfubigeocode_sel ,
                                          String AV53Ubigeowwds_2_tfubigeocode ,
                                          String AV56Ubigeowwds_5_tfubigeodepartamento_sel ,
                                          String AV55Ubigeowwds_4_tfubigeodepartamento ,
                                          String AV58Ubigeowwds_7_tfubigeodepartamentocode_sel ,
                                          String AV57Ubigeowwds_6_tfubigeodepartamentocode ,
                                          String AV60Ubigeowwds_9_tfubigeoprovincia_sel ,
                                          String AV59Ubigeowwds_8_tfubigeoprovincia ,
                                          String AV62Ubigeowwds_11_tfubigeoprovinciacode_sel ,
                                          String AV61Ubigeowwds_10_tfubigeoprovinciacode ,
                                          String AV64Ubigeowwds_13_tfubigeodistrito_sel ,
                                          String AV63Ubigeowwds_12_tfubigeodistrito ,
                                          String AV66Ubigeowwds_15_tfubigeodistritocode_sel ,
                                          String AV65Ubigeowwds_14_tfubigeodistritocode ,
                                          String AV68Ubigeowwds_17_tfubigeonombre_sel ,
                                          String AV67Ubigeowwds_16_tfubigeonombre ,
                                          int AV69Ubigeowwds_18_tfubigeoestado_sels_size ,
                                          String A44UbigeoCode ,
                                          String A186UbigeoDepartamento ,
                                          String A187UbigeoProvincia ,
                                          String A188UbigeoDistrito )
   {
      java.lang.StringBuffer sWhereString = new java.lang.StringBuffer();
      String scmdbuf;
      byte[] GXv_int25 = new byte[26];
      Object[] GXv_Object26 = new Object[2];
      scmdbuf = "SELECT [UbigeoEstado], [UbigeoCode], [UbigeoDistrito], [UbigeoProvincia], [UbigeoDepartamento] FROM [Ubigeo]" ;
      if ( ! (GXutil.strcmp("", AV52Ubigeowwds_1_filterfulltext)==0) )
      {
         addWhere(sWhereString, "(( [UbigeoCode] like '%' + ?) or ( [UbigeoDepartamento] like '%' + ?) or ( SUBSTRING([UbigeoCode], 1, 2) like '%' + ?) or ( [UbigeoProvincia] like '%' + ?) or ( SUBSTRING([UbigeoCode], 3, 2) like '%' + ?) or ( [UbigeoDistrito] like '%' + ?) or ( SUBSTRING([UbigeoCode], 5, 2) like '%' + ?) or ( [UbigeoDepartamento] + ' / ' + [UbigeoProvincia] + ' / ' + [UbigeoDistrito] like '%' + ?) or ( 'activo' like '%' + LOWER(?) and [UbigeoEstado] = 'A') or ( 'inactivo' like '%' + LOWER(?) and [UbigeoEstado] = 'I'))");
      }
      else
      {
         GXv_int25[0] = (byte)(1) ;
         GXv_int25[1] = (byte)(1) ;
         GXv_int25[2] = (byte)(1) ;
         GXv_int25[3] = (byte)(1) ;
         GXv_int25[4] = (byte)(1) ;
         GXv_int25[5] = (byte)(1) ;
         GXv_int25[6] = (byte)(1) ;
         GXv_int25[7] = (byte)(1) ;
         GXv_int25[8] = (byte)(1) ;
         GXv_int25[9] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV54Ubigeowwds_3_tfubigeocode_sel)==0) && ( ! (GXutil.strcmp("", AV53Ubigeowwds_2_tfubigeocode)==0) ) )
      {
         addWhere(sWhereString, "([UbigeoCode] like ?)");
      }
      else
      {
         GXv_int25[10] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV54Ubigeowwds_3_tfubigeocode_sel)==0) )
      {
         addWhere(sWhereString, "([UbigeoCode] = ?)");
      }
      else
      {
         GXv_int25[11] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV56Ubigeowwds_5_tfubigeodepartamento_sel)==0) && ( ! (GXutil.strcmp("", AV55Ubigeowwds_4_tfubigeodepartamento)==0) ) )
      {
         addWhere(sWhereString, "([UbigeoDepartamento] like ?)");
      }
      else
      {
         GXv_int25[12] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV56Ubigeowwds_5_tfubigeodepartamento_sel)==0) )
      {
         addWhere(sWhereString, "([UbigeoDepartamento] = ?)");
      }
      else
      {
         GXv_int25[13] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV58Ubigeowwds_7_tfubigeodepartamentocode_sel)==0) && ( ! (GXutil.strcmp("", AV57Ubigeowwds_6_tfubigeodepartamentocode)==0) ) )
      {
         addWhere(sWhereString, "(SUBSTRING([UbigeoCode], 1, 2) like ?)");
      }
      else
      {
         GXv_int25[14] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV58Ubigeowwds_7_tfubigeodepartamentocode_sel)==0) )
      {
         addWhere(sWhereString, "(SUBSTRING([UbigeoCode], 1, 2) = ?)");
      }
      else
      {
         GXv_int25[15] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV60Ubigeowwds_9_tfubigeoprovincia_sel)==0) && ( ! (GXutil.strcmp("", AV59Ubigeowwds_8_tfubigeoprovincia)==0) ) )
      {
         addWhere(sWhereString, "([UbigeoProvincia] like ?)");
      }
      else
      {
         GXv_int25[16] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV60Ubigeowwds_9_tfubigeoprovincia_sel)==0) )
      {
         addWhere(sWhereString, "([UbigeoProvincia] = ?)");
      }
      else
      {
         GXv_int25[17] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV62Ubigeowwds_11_tfubigeoprovinciacode_sel)==0) && ( ! (GXutil.strcmp("", AV61Ubigeowwds_10_tfubigeoprovinciacode)==0) ) )
      {
         addWhere(sWhereString, "(SUBSTRING([UbigeoCode], 3, 2) like ?)");
      }
      else
      {
         GXv_int25[18] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV62Ubigeowwds_11_tfubigeoprovinciacode_sel)==0) )
      {
         addWhere(sWhereString, "(SUBSTRING([UbigeoCode], 3, 2) = ?)");
      }
      else
      {
         GXv_int25[19] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV64Ubigeowwds_13_tfubigeodistrito_sel)==0) && ( ! (GXutil.strcmp("", AV63Ubigeowwds_12_tfubigeodistrito)==0) ) )
      {
         addWhere(sWhereString, "([UbigeoDistrito] like ?)");
      }
      else
      {
         GXv_int25[20] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV64Ubigeowwds_13_tfubigeodistrito_sel)==0) )
      {
         addWhere(sWhereString, "([UbigeoDistrito] = ?)");
      }
      else
      {
         GXv_int25[21] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV66Ubigeowwds_15_tfubigeodistritocode_sel)==0) && ( ! (GXutil.strcmp("", AV65Ubigeowwds_14_tfubigeodistritocode)==0) ) )
      {
         addWhere(sWhereString, "(SUBSTRING([UbigeoCode], 5, 2) like ?)");
      }
      else
      {
         GXv_int25[22] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV66Ubigeowwds_15_tfubigeodistritocode_sel)==0) )
      {
         addWhere(sWhereString, "(SUBSTRING([UbigeoCode], 5, 2) = ?)");
      }
      else
      {
         GXv_int25[23] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV68Ubigeowwds_17_tfubigeonombre_sel)==0) && ( ! (GXutil.strcmp("", AV67Ubigeowwds_16_tfubigeonombre)==0) ) )
      {
         addWhere(sWhereString, "([UbigeoDepartamento] + ' / ' + [UbigeoProvincia] + ' / ' + [UbigeoDistrito] like ?)");
      }
      else
      {
         GXv_int25[24] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV68Ubigeowwds_17_tfubigeonombre_sel)==0) )
      {
         addWhere(sWhereString, "([UbigeoDepartamento] + ' / ' + [UbigeoProvincia] + ' / ' + [UbigeoDistrito] = ?)");
      }
      else
      {
         GXv_int25[25] = (byte)(1) ;
      }
      if ( AV69Ubigeowwds_18_tfubigeoestado_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("sqlserver", AV69Ubigeowwds_18_tfubigeoestado_sels, "[UbigeoEstado] IN (", ")")+")");
      }
      scmdbuf += sWhereString ;
      scmdbuf += " ORDER BY [UbigeoCode]" ;
      GXv_Object26[0] = scmdbuf ;
      GXv_Object26[1] = GXv_int25 ;
      return GXv_Object26 ;
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
                  return conditional_P003L2(context, remoteHandle, httpContext, (String)dynConstraints[0] , (GXSimpleCollection<String>)dynConstraints[1] , (String)dynConstraints[2] , (String)dynConstraints[3] , (String)dynConstraints[4] , (String)dynConstraints[5] , (String)dynConstraints[6] , (String)dynConstraints[7] , (String)dynConstraints[8] , (String)dynConstraints[9] , (String)dynConstraints[10] , (String)dynConstraints[11] , (String)dynConstraints[12] , (String)dynConstraints[13] , (String)dynConstraints[14] , (String)dynConstraints[15] , (String)dynConstraints[16] , (String)dynConstraints[17] , (String)dynConstraints[18] , ((Number) dynConstraints[19]).intValue() , (String)dynConstraints[20] , (String)dynConstraints[21] , (String)dynConstraints[22] , (String)dynConstraints[23] );
            case 1 :
                  return conditional_P003L3(context, remoteHandle, httpContext, (String)dynConstraints[0] , (GXSimpleCollection<String>)dynConstraints[1] , (String)dynConstraints[2] , (String)dynConstraints[3] , (String)dynConstraints[4] , (String)dynConstraints[5] , (String)dynConstraints[6] , (String)dynConstraints[7] , (String)dynConstraints[8] , (String)dynConstraints[9] , (String)dynConstraints[10] , (String)dynConstraints[11] , (String)dynConstraints[12] , (String)dynConstraints[13] , (String)dynConstraints[14] , (String)dynConstraints[15] , (String)dynConstraints[16] , (String)dynConstraints[17] , (String)dynConstraints[18] , ((Number) dynConstraints[19]).intValue() , (String)dynConstraints[20] , (String)dynConstraints[21] , (String)dynConstraints[22] , (String)dynConstraints[23] );
            case 2 :
                  return conditional_P003L4(context, remoteHandle, httpContext, (String)dynConstraints[0] , (GXSimpleCollection<String>)dynConstraints[1] , (String)dynConstraints[2] , (String)dynConstraints[3] , (String)dynConstraints[4] , (String)dynConstraints[5] , (String)dynConstraints[6] , (String)dynConstraints[7] , (String)dynConstraints[8] , (String)dynConstraints[9] , (String)dynConstraints[10] , (String)dynConstraints[11] , (String)dynConstraints[12] , (String)dynConstraints[13] , (String)dynConstraints[14] , (String)dynConstraints[15] , (String)dynConstraints[16] , (String)dynConstraints[17] , (String)dynConstraints[18] , ((Number) dynConstraints[19]).intValue() , (String)dynConstraints[20] , (String)dynConstraints[21] , (String)dynConstraints[22] , (String)dynConstraints[23] );
            case 3 :
                  return conditional_P003L5(context, remoteHandle, httpContext, (String)dynConstraints[0] , (GXSimpleCollection<String>)dynConstraints[1] , (String)dynConstraints[2] , (String)dynConstraints[3] , (String)dynConstraints[4] , (String)dynConstraints[5] , (String)dynConstraints[6] , (String)dynConstraints[7] , (String)dynConstraints[8] , (String)dynConstraints[9] , (String)dynConstraints[10] , (String)dynConstraints[11] , (String)dynConstraints[12] , (String)dynConstraints[13] , (String)dynConstraints[14] , (String)dynConstraints[15] , (String)dynConstraints[16] , (String)dynConstraints[17] , (String)dynConstraints[18] , ((Number) dynConstraints[19]).intValue() , (String)dynConstraints[20] , (String)dynConstraints[21] , (String)dynConstraints[22] , (String)dynConstraints[23] );
            case 4 :
                  return conditional_P003L6(context, remoteHandle, httpContext, (String)dynConstraints[0] , (GXSimpleCollection<String>)dynConstraints[1] , (String)dynConstraints[2] , (String)dynConstraints[3] , (String)dynConstraints[4] , (String)dynConstraints[5] , (String)dynConstraints[6] , (String)dynConstraints[7] , (String)dynConstraints[8] , (String)dynConstraints[9] , (String)dynConstraints[10] , (String)dynConstraints[11] , (String)dynConstraints[12] , (String)dynConstraints[13] , (String)dynConstraints[14] , (String)dynConstraints[15] , (String)dynConstraints[16] , (String)dynConstraints[17] , (String)dynConstraints[18] , ((Number) dynConstraints[19]).intValue() , (String)dynConstraints[20] , (String)dynConstraints[21] , (String)dynConstraints[22] , (String)dynConstraints[23] );
            case 5 :
                  return conditional_P003L7(context, remoteHandle, httpContext, (String)dynConstraints[0] , (GXSimpleCollection<String>)dynConstraints[1] , (String)dynConstraints[2] , (String)dynConstraints[3] , (String)dynConstraints[4] , (String)dynConstraints[5] , (String)dynConstraints[6] , (String)dynConstraints[7] , (String)dynConstraints[8] , (String)dynConstraints[9] , (String)dynConstraints[10] , (String)dynConstraints[11] , (String)dynConstraints[12] , (String)dynConstraints[13] , (String)dynConstraints[14] , (String)dynConstraints[15] , (String)dynConstraints[16] , (String)dynConstraints[17] , (String)dynConstraints[18] , ((Number) dynConstraints[19]).intValue() , (String)dynConstraints[20] , (String)dynConstraints[21] , (String)dynConstraints[22] , (String)dynConstraints[23] );
            case 6 :
                  return conditional_P003L8(context, remoteHandle, httpContext, (String)dynConstraints[0] , (GXSimpleCollection<String>)dynConstraints[1] , (String)dynConstraints[2] , (String)dynConstraints[3] , (String)dynConstraints[4] , (String)dynConstraints[5] , (String)dynConstraints[6] , (String)dynConstraints[7] , (String)dynConstraints[8] , (String)dynConstraints[9] , (String)dynConstraints[10] , (String)dynConstraints[11] , (String)dynConstraints[12] , (String)dynConstraints[13] , (String)dynConstraints[14] , (String)dynConstraints[15] , (String)dynConstraints[16] , (String)dynConstraints[17] , (String)dynConstraints[18] , ((Number) dynConstraints[19]).intValue() , (String)dynConstraints[20] , (String)dynConstraints[21] , (String)dynConstraints[22] , (String)dynConstraints[23] );
            case 7 :
                  return conditional_P003L9(context, remoteHandle, httpContext, (String)dynConstraints[0] , (GXSimpleCollection<String>)dynConstraints[1] , (String)dynConstraints[2] , (String)dynConstraints[3] , (String)dynConstraints[4] , (String)dynConstraints[5] , (String)dynConstraints[6] , (String)dynConstraints[7] , (String)dynConstraints[8] , (String)dynConstraints[9] , (String)dynConstraints[10] , (String)dynConstraints[11] , (String)dynConstraints[12] , (String)dynConstraints[13] , (String)dynConstraints[14] , (String)dynConstraints[15] , (String)dynConstraints[16] , (String)dynConstraints[17] , (String)dynConstraints[18] , ((Number) dynConstraints[19]).intValue() , (String)dynConstraints[20] , (String)dynConstraints[21] , (String)dynConstraints[22] , (String)dynConstraints[23] );
      }
      return super.getDynamicStatement(cursor, context, remoteHandle, httpContext, dynConstraints);
   }

   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P003L2", "scmdbuf",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("P003L3", "scmdbuf",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("P003L4", "scmdbuf",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("P003L5", "scmdbuf",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("P003L6", "scmdbuf",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("P003L7", "scmdbuf",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("P003L8", "scmdbuf",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("P003L9", "scmdbuf",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
      };
   }

   public void getResults( int cursor ,
                           IFieldGetter rslt ,
                           Object[] buf ) throws SQLException
   {
      switch ( cursor )
      {
            case 0 :
               ((String[]) buf[0])[0] = rslt.getString(1, 1);
               ((String[]) buf[1])[0] = rslt.getString(2, 10);
               ((String[]) buf[2])[0] = rslt.getVarchar(3);
               ((String[]) buf[3])[0] = rslt.getVarchar(4);
               ((String[]) buf[4])[0] = rslt.getVarchar(5);
               return;
            case 1 :
               ((String[]) buf[0])[0] = rslt.getString(1, 1);
               ((String[]) buf[1])[0] = rslt.getString(2, 10);
               ((String[]) buf[2])[0] = rslt.getVarchar(3);
               ((String[]) buf[3])[0] = rslt.getVarchar(4);
               ((String[]) buf[4])[0] = rslt.getVarchar(5);
               return;
            case 2 :
               ((String[]) buf[0])[0] = rslt.getString(1, 1);
               ((String[]) buf[1])[0] = rslt.getString(2, 10);
               ((String[]) buf[2])[0] = rslt.getVarchar(3);
               ((String[]) buf[3])[0] = rslt.getVarchar(4);
               ((String[]) buf[4])[0] = rslt.getVarchar(5);
               return;
            case 3 :
               ((String[]) buf[0])[0] = rslt.getString(1, 1);
               ((String[]) buf[1])[0] = rslt.getString(2, 10);
               ((String[]) buf[2])[0] = rslt.getVarchar(3);
               ((String[]) buf[3])[0] = rslt.getVarchar(4);
               ((String[]) buf[4])[0] = rslt.getVarchar(5);
               return;
            case 4 :
               ((String[]) buf[0])[0] = rslt.getString(1, 1);
               ((String[]) buf[1])[0] = rslt.getString(2, 10);
               ((String[]) buf[2])[0] = rslt.getVarchar(3);
               ((String[]) buf[3])[0] = rslt.getVarchar(4);
               ((String[]) buf[4])[0] = rslt.getVarchar(5);
               return;
            case 5 :
               ((String[]) buf[0])[0] = rslt.getString(1, 1);
               ((String[]) buf[1])[0] = rslt.getString(2, 10);
               ((String[]) buf[2])[0] = rslt.getVarchar(3);
               ((String[]) buf[3])[0] = rslt.getVarchar(4);
               ((String[]) buf[4])[0] = rslt.getVarchar(5);
               return;
            case 6 :
               ((String[]) buf[0])[0] = rslt.getString(1, 1);
               ((String[]) buf[1])[0] = rslt.getString(2, 10);
               ((String[]) buf[2])[0] = rslt.getVarchar(3);
               ((String[]) buf[3])[0] = rslt.getVarchar(4);
               ((String[]) buf[4])[0] = rslt.getVarchar(5);
               return;
            case 7 :
               ((String[]) buf[0])[0] = rslt.getString(1, 1);
               ((String[]) buf[1])[0] = rslt.getString(2, 10);
               ((String[]) buf[2])[0] = rslt.getVarchar(3);
               ((String[]) buf[3])[0] = rslt.getVarchar(4);
               ((String[]) buf[4])[0] = rslt.getVarchar(5);
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
                  stmt.setVarchar(sIdx, (String)parms[26], 100);
               }
               if ( ((Number) parms[1]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[27], 100);
               }
               if ( ((Number) parms[2]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[28], 100);
               }
               if ( ((Number) parms[3]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[29], 100);
               }
               if ( ((Number) parms[4]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[30], 100);
               }
               if ( ((Number) parms[5]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[31], 100);
               }
               if ( ((Number) parms[6]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[32], 100);
               }
               if ( ((Number) parms[7]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[33], 100);
               }
               if ( ((Number) parms[8]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[34], 100);
               }
               if ( ((Number) parms[9]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[35], 100);
               }
               if ( ((Number) parms[10]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setString(sIdx, (String)parms[36], 10);
               }
               if ( ((Number) parms[11]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setString(sIdx, (String)parms[37], 10);
               }
               if ( ((Number) parms[12]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[38], 100);
               }
               if ( ((Number) parms[13]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[39], 100);
               }
               if ( ((Number) parms[14]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[40], 2);
               }
               if ( ((Number) parms[15]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[41], 2);
               }
               if ( ((Number) parms[16]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[42], 100);
               }
               if ( ((Number) parms[17]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[43], 100);
               }
               if ( ((Number) parms[18]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[44], 2);
               }
               if ( ((Number) parms[19]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[45], 2);
               }
               if ( ((Number) parms[20]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[46], 100);
               }
               if ( ((Number) parms[21]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[47], 100);
               }
               if ( ((Number) parms[22]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[48], 2);
               }
               if ( ((Number) parms[23]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[49], 2);
               }
               if ( ((Number) parms[24]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[50], 100);
               }
               if ( ((Number) parms[25]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[51], 100);
               }
               return;
            case 1 :
               sIdx = (short)(0) ;
               if ( ((Number) parms[0]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[26], 100);
               }
               if ( ((Number) parms[1]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[27], 100);
               }
               if ( ((Number) parms[2]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[28], 100);
               }
               if ( ((Number) parms[3]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[29], 100);
               }
               if ( ((Number) parms[4]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[30], 100);
               }
               if ( ((Number) parms[5]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[31], 100);
               }
               if ( ((Number) parms[6]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[32], 100);
               }
               if ( ((Number) parms[7]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[33], 100);
               }
               if ( ((Number) parms[8]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[34], 100);
               }
               if ( ((Number) parms[9]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[35], 100);
               }
               if ( ((Number) parms[10]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setString(sIdx, (String)parms[36], 10);
               }
               if ( ((Number) parms[11]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setString(sIdx, (String)parms[37], 10);
               }
               if ( ((Number) parms[12]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[38], 100);
               }
               if ( ((Number) parms[13]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[39], 100);
               }
               if ( ((Number) parms[14]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[40], 2);
               }
               if ( ((Number) parms[15]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[41], 2);
               }
               if ( ((Number) parms[16]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[42], 100);
               }
               if ( ((Number) parms[17]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[43], 100);
               }
               if ( ((Number) parms[18]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[44], 2);
               }
               if ( ((Number) parms[19]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[45], 2);
               }
               if ( ((Number) parms[20]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[46], 100);
               }
               if ( ((Number) parms[21]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[47], 100);
               }
               if ( ((Number) parms[22]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[48], 2);
               }
               if ( ((Number) parms[23]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[49], 2);
               }
               if ( ((Number) parms[24]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[50], 100);
               }
               if ( ((Number) parms[25]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[51], 100);
               }
               return;
            case 2 :
               sIdx = (short)(0) ;
               if ( ((Number) parms[0]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[26], 100);
               }
               if ( ((Number) parms[1]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[27], 100);
               }
               if ( ((Number) parms[2]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[28], 100);
               }
               if ( ((Number) parms[3]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[29], 100);
               }
               if ( ((Number) parms[4]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[30], 100);
               }
               if ( ((Number) parms[5]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[31], 100);
               }
               if ( ((Number) parms[6]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[32], 100);
               }
               if ( ((Number) parms[7]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[33], 100);
               }
               if ( ((Number) parms[8]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[34], 100);
               }
               if ( ((Number) parms[9]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[35], 100);
               }
               if ( ((Number) parms[10]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setString(sIdx, (String)parms[36], 10);
               }
               if ( ((Number) parms[11]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setString(sIdx, (String)parms[37], 10);
               }
               if ( ((Number) parms[12]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[38], 100);
               }
               if ( ((Number) parms[13]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[39], 100);
               }
               if ( ((Number) parms[14]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[40], 2);
               }
               if ( ((Number) parms[15]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[41], 2);
               }
               if ( ((Number) parms[16]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[42], 100);
               }
               if ( ((Number) parms[17]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[43], 100);
               }
               if ( ((Number) parms[18]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[44], 2);
               }
               if ( ((Number) parms[19]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[45], 2);
               }
               if ( ((Number) parms[20]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[46], 100);
               }
               if ( ((Number) parms[21]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[47], 100);
               }
               if ( ((Number) parms[22]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[48], 2);
               }
               if ( ((Number) parms[23]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[49], 2);
               }
               if ( ((Number) parms[24]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[50], 100);
               }
               if ( ((Number) parms[25]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[51], 100);
               }
               return;
            case 3 :
               sIdx = (short)(0) ;
               if ( ((Number) parms[0]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[26], 100);
               }
               if ( ((Number) parms[1]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[27], 100);
               }
               if ( ((Number) parms[2]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[28], 100);
               }
               if ( ((Number) parms[3]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[29], 100);
               }
               if ( ((Number) parms[4]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[30], 100);
               }
               if ( ((Number) parms[5]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[31], 100);
               }
               if ( ((Number) parms[6]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[32], 100);
               }
               if ( ((Number) parms[7]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[33], 100);
               }
               if ( ((Number) parms[8]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[34], 100);
               }
               if ( ((Number) parms[9]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[35], 100);
               }
               if ( ((Number) parms[10]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setString(sIdx, (String)parms[36], 10);
               }
               if ( ((Number) parms[11]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setString(sIdx, (String)parms[37], 10);
               }
               if ( ((Number) parms[12]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[38], 100);
               }
               if ( ((Number) parms[13]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[39], 100);
               }
               if ( ((Number) parms[14]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[40], 2);
               }
               if ( ((Number) parms[15]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[41], 2);
               }
               if ( ((Number) parms[16]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[42], 100);
               }
               if ( ((Number) parms[17]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[43], 100);
               }
               if ( ((Number) parms[18]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[44], 2);
               }
               if ( ((Number) parms[19]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[45], 2);
               }
               if ( ((Number) parms[20]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[46], 100);
               }
               if ( ((Number) parms[21]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[47], 100);
               }
               if ( ((Number) parms[22]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[48], 2);
               }
               if ( ((Number) parms[23]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[49], 2);
               }
               if ( ((Number) parms[24]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[50], 100);
               }
               if ( ((Number) parms[25]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[51], 100);
               }
               return;
            case 4 :
               sIdx = (short)(0) ;
               if ( ((Number) parms[0]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[26], 100);
               }
               if ( ((Number) parms[1]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[27], 100);
               }
               if ( ((Number) parms[2]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[28], 100);
               }
               if ( ((Number) parms[3]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[29], 100);
               }
               if ( ((Number) parms[4]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[30], 100);
               }
               if ( ((Number) parms[5]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[31], 100);
               }
               if ( ((Number) parms[6]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[32], 100);
               }
               if ( ((Number) parms[7]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[33], 100);
               }
               if ( ((Number) parms[8]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[34], 100);
               }
               if ( ((Number) parms[9]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[35], 100);
               }
               if ( ((Number) parms[10]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setString(sIdx, (String)parms[36], 10);
               }
               if ( ((Number) parms[11]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setString(sIdx, (String)parms[37], 10);
               }
               if ( ((Number) parms[12]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[38], 100);
               }
               if ( ((Number) parms[13]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[39], 100);
               }
               if ( ((Number) parms[14]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[40], 2);
               }
               if ( ((Number) parms[15]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[41], 2);
               }
               if ( ((Number) parms[16]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[42], 100);
               }
               if ( ((Number) parms[17]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[43], 100);
               }
               if ( ((Number) parms[18]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[44], 2);
               }
               if ( ((Number) parms[19]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[45], 2);
               }
               if ( ((Number) parms[20]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[46], 100);
               }
               if ( ((Number) parms[21]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[47], 100);
               }
               if ( ((Number) parms[22]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[48], 2);
               }
               if ( ((Number) parms[23]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[49], 2);
               }
               if ( ((Number) parms[24]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[50], 100);
               }
               if ( ((Number) parms[25]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[51], 100);
               }
               return;
            case 5 :
               sIdx = (short)(0) ;
               if ( ((Number) parms[0]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[26], 100);
               }
               if ( ((Number) parms[1]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[27], 100);
               }
               if ( ((Number) parms[2]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[28], 100);
               }
               if ( ((Number) parms[3]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[29], 100);
               }
               if ( ((Number) parms[4]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[30], 100);
               }
               if ( ((Number) parms[5]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[31], 100);
               }
               if ( ((Number) parms[6]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[32], 100);
               }
               if ( ((Number) parms[7]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[33], 100);
               }
               if ( ((Number) parms[8]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[34], 100);
               }
               if ( ((Number) parms[9]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[35], 100);
               }
               if ( ((Number) parms[10]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setString(sIdx, (String)parms[36], 10);
               }
               if ( ((Number) parms[11]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setString(sIdx, (String)parms[37], 10);
               }
               if ( ((Number) parms[12]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[38], 100);
               }
               if ( ((Number) parms[13]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[39], 100);
               }
               if ( ((Number) parms[14]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[40], 2);
               }
               if ( ((Number) parms[15]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[41], 2);
               }
               if ( ((Number) parms[16]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[42], 100);
               }
               if ( ((Number) parms[17]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[43], 100);
               }
               if ( ((Number) parms[18]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[44], 2);
               }
               if ( ((Number) parms[19]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[45], 2);
               }
               if ( ((Number) parms[20]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[46], 100);
               }
               if ( ((Number) parms[21]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[47], 100);
               }
               if ( ((Number) parms[22]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[48], 2);
               }
               if ( ((Number) parms[23]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[49], 2);
               }
               if ( ((Number) parms[24]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[50], 100);
               }
               if ( ((Number) parms[25]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[51], 100);
               }
               return;
            case 6 :
               sIdx = (short)(0) ;
               if ( ((Number) parms[0]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[26], 100);
               }
               if ( ((Number) parms[1]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[27], 100);
               }
               if ( ((Number) parms[2]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[28], 100);
               }
               if ( ((Number) parms[3]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[29], 100);
               }
               if ( ((Number) parms[4]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[30], 100);
               }
               if ( ((Number) parms[5]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[31], 100);
               }
               if ( ((Number) parms[6]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[32], 100);
               }
               if ( ((Number) parms[7]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[33], 100);
               }
               if ( ((Number) parms[8]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[34], 100);
               }
               if ( ((Number) parms[9]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[35], 100);
               }
               if ( ((Number) parms[10]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setString(sIdx, (String)parms[36], 10);
               }
               if ( ((Number) parms[11]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setString(sIdx, (String)parms[37], 10);
               }
               if ( ((Number) parms[12]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[38], 100);
               }
               if ( ((Number) parms[13]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[39], 100);
               }
               if ( ((Number) parms[14]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[40], 2);
               }
               if ( ((Number) parms[15]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[41], 2);
               }
               if ( ((Number) parms[16]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[42], 100);
               }
               if ( ((Number) parms[17]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[43], 100);
               }
               if ( ((Number) parms[18]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[44], 2);
               }
               if ( ((Number) parms[19]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[45], 2);
               }
               if ( ((Number) parms[20]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[46], 100);
               }
               if ( ((Number) parms[21]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[47], 100);
               }
               if ( ((Number) parms[22]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[48], 2);
               }
               if ( ((Number) parms[23]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[49], 2);
               }
               if ( ((Number) parms[24]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[50], 100);
               }
               if ( ((Number) parms[25]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[51], 100);
               }
               return;
            case 7 :
               sIdx = (short)(0) ;
               if ( ((Number) parms[0]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[26], 100);
               }
               if ( ((Number) parms[1]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[27], 100);
               }
               if ( ((Number) parms[2]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[28], 100);
               }
               if ( ((Number) parms[3]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[29], 100);
               }
               if ( ((Number) parms[4]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[30], 100);
               }
               if ( ((Number) parms[5]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[31], 100);
               }
               if ( ((Number) parms[6]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[32], 100);
               }
               if ( ((Number) parms[7]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[33], 100);
               }
               if ( ((Number) parms[8]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[34], 100);
               }
               if ( ((Number) parms[9]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[35], 100);
               }
               if ( ((Number) parms[10]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setString(sIdx, (String)parms[36], 10);
               }
               if ( ((Number) parms[11]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setString(sIdx, (String)parms[37], 10);
               }
               if ( ((Number) parms[12]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[38], 100);
               }
               if ( ((Number) parms[13]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[39], 100);
               }
               if ( ((Number) parms[14]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[40], 2);
               }
               if ( ((Number) parms[15]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[41], 2);
               }
               if ( ((Number) parms[16]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[42], 100);
               }
               if ( ((Number) parms[17]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[43], 100);
               }
               if ( ((Number) parms[18]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[44], 2);
               }
               if ( ((Number) parms[19]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[45], 2);
               }
               if ( ((Number) parms[20]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[46], 100);
               }
               if ( ((Number) parms[21]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[47], 100);
               }
               if ( ((Number) parms[22]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[48], 2);
               }
               if ( ((Number) parms[23]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[49], 2);
               }
               if ( ((Number) parms[24]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[50], 100);
               }
               if ( ((Number) parms[25]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[51], 100);
               }
               return;
      }
   }

}

