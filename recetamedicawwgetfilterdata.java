package com.projectthani ;
import com.projectthani.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class recetamedicawwgetfilterdata extends GXProcedure
{
   public recetamedicawwgetfilterdata( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( recetamedicawwgetfilterdata.class ), "" );
   }

   public recetamedicawwgetfilterdata( int remoteHandle ,
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
      recetamedicawwgetfilterdata.this.aP5 = new String[] {""};
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
      recetamedicawwgetfilterdata.this.AV35DDOName = aP0;
      recetamedicawwgetfilterdata.this.AV33SearchTxt = aP1;
      recetamedicawwgetfilterdata.this.AV34SearchTxtTo = aP2;
      recetamedicawwgetfilterdata.this.aP3 = aP3;
      recetamedicawwgetfilterdata.this.aP4 = aP4;
      recetamedicawwgetfilterdata.this.aP5 = aP5;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      AV38Options = new GXSimpleCollection<String>(String.class, "internal", "") ;
      AV41OptionsDesc = new GXSimpleCollection<String>(String.class, "internal", "") ;
      AV43OptionIndexes = new GXSimpleCollection<String>(String.class, "internal", "") ;
      GXt_boolean1 = AV8IsAuthorized ;
      GXv_boolean2[0] = GXt_boolean1 ;
      new com.projectthani.wwpbaseobjects.secisauthbyfunctionalitykey(remoteHandle, context).execute( "WWRecetaMedica", GXv_boolean2) ;
      recetamedicawwgetfilterdata.this.GXt_boolean1 = GXv_boolean2[0] ;
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
         if ( GXutil.strcmp(GXutil.upper( AV35DDOName), "DDO_MEDICAMENTOCODIGO") == 0 )
         {
            /* Execute user subroutine: 'LOADMEDICAMENTOCODIGOOPTIONS' */
            S121 ();
            if ( returnInSub )
            {
               returnInSub = true;
               cleanup();
               if (true) return;
            }
         }
         else if ( GXutil.strcmp(GXutil.upper( AV35DDOName), "DDO_MEDICAMENTONOMBRE") == 0 )
         {
            /* Execute user subroutine: 'LOADMEDICAMENTONOMBREOPTIONS' */
            S131 ();
            if ( returnInSub )
            {
               returnInSub = true;
               cleanup();
               if (true) return;
            }
         }
         else if ( GXutil.strcmp(GXutil.upper( AV35DDOName), "DDO_MEDICAMENTOFORMAFARM") == 0 )
         {
            /* Execute user subroutine: 'LOADMEDICAMENTOFORMAFARMOPTIONS' */
            S141 ();
            if ( returnInSub )
            {
               returnInSub = true;
               cleanup();
               if (true) return;
            }
         }
         else if ( GXutil.strcmp(GXutil.upper( AV35DDOName), "DDO_RECETAMEDICACONCENTRACION") == 0 )
         {
            /* Execute user subroutine: 'LOADRECETAMEDICACONCENTRACIONOPTIONS' */
            S151 ();
            if ( returnInSub )
            {
               returnInSub = true;
               cleanup();
               if (true) return;
            }
         }
         else if ( GXutil.strcmp(GXutil.upper( AV35DDOName), "DDO_RECETAMEDICAATENCION") == 0 )
         {
            /* Execute user subroutine: 'LOADRECETAMEDICAATENCIONOPTIONS' */
            S161 ();
            if ( returnInSub )
            {
               returnInSub = true;
               cleanup();
               if (true) return;
            }
         }
         else if ( GXutil.strcmp(GXutil.upper( AV35DDOName), "DDO_RECETAINDICACIONES") == 0 )
         {
            /* Execute user subroutine: 'LOADRECETAINDICACIONESOPTIONS' */
            S171 ();
            if ( returnInSub )
            {
               returnInSub = true;
               cleanup();
               if (true) return;
            }
         }
      }
      AV39OptionsJson = AV38Options.toJSonString(false) ;
      AV42OptionsDescJson = AV41OptionsDesc.toJSonString(false) ;
      AV44OptionIndexesJson = AV43OptionIndexes.toJSonString(false) ;
      cleanup();
   }

   public void S111( )
   {
      /* 'LOADGRIDSTATE' Routine */
      returnInSub = false ;
      if ( GXutil.strcmp(AV46Session.getValue("RecetaMedicaWWGridState"), "") == 0 )
      {
         AV48GridState.fromxml(new com.projectthani.wwpbaseobjects.loadgridstate(remoteHandle, context).executeUdp( "RecetaMedicaWWGridState"), null, null);
      }
      else
      {
         AV48GridState.fromxml(AV46Session.getValue("RecetaMedicaWWGridState"), null, null);
      }
      AV56GXV1 = 1 ;
      while ( AV56GXV1 <= AV48GridState.getgxTv_SdtWWPGridState_Filtervalues().size() )
      {
         AV49GridStateFilterValue = (com.projectthani.wwpbaseobjects.SdtWWPGridState_FilterValue)((com.projectthani.wwpbaseobjects.SdtWWPGridState_FilterValue)AV48GridState.getgxTv_SdtWWPGridState_Filtervalues().elementAt(-1+AV56GXV1));
         if ( GXutil.strcmp(AV49GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "FILTERFULLTEXT") == 0 )
         {
            AV51FilterFullText = AV49GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV49GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFRECETAMEDICAID") == 0 )
         {
            AV11TFRecetaMedicaId = (short)(GXutil.lval( AV49GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value())) ;
            AV12TFRecetaMedicaId_To = (short)(GXutil.lval( AV49GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Valueto())) ;
         }
         else if ( GXutil.strcmp(AV49GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFCITAID") == 0 )
         {
            AV13TFCitaId = (int)(GXutil.lval( AV49GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value())) ;
            AV14TFCitaId_To = (int)(GXutil.lval( AV49GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Valueto())) ;
         }
         else if ( GXutil.strcmp(AV49GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFMEDICAMENTOID") == 0 )
         {
            AV15TFMedicamentoId = (short)(GXutil.lval( AV49GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value())) ;
            AV16TFMedicamentoId_To = (short)(GXutil.lval( AV49GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Valueto())) ;
         }
         else if ( GXutil.strcmp(AV49GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFMEDICAMENTOCODIGO") == 0 )
         {
            AV17TFMedicamentoCodigo = AV49GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV49GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFMEDICAMENTOCODIGO_SEL") == 0 )
         {
            AV18TFMedicamentoCodigo_Sel = AV49GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV49GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFMEDICAMENTONOMBRE") == 0 )
         {
            AV19TFMedicamentoNombre = AV49GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV49GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFMEDICAMENTONOMBRE_SEL") == 0 )
         {
            AV20TFMedicamentoNombre_Sel = AV49GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV49GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFMEDICAMENTOFORMAFARM") == 0 )
         {
            AV21TFMedicamentoFormaFarm = AV49GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV49GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFMEDICAMENTOFORMAFARM_SEL") == 0 )
         {
            AV22TFMedicamentoFormaFarm_Sel = AV49GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV49GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFRECETAMEDICACONCENTRACION") == 0 )
         {
            AV23TFRecetaMedicaConcentracion = AV49GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV49GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFRECETAMEDICACONCENTRACION_SEL") == 0 )
         {
            AV24TFRecetaMedicaConcentracion_Sel = AV49GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV49GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFRECETAMEDICACANTIDAD") == 0 )
         {
            AV25TFRecetaMedicaCantidad = (short)(GXutil.lval( AV49GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value())) ;
            AV26TFRecetaMedicaCantidad_To = (short)(GXutil.lval( AV49GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Valueto())) ;
         }
         else if ( GXutil.strcmp(AV49GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFRECETAMEDICAATENCION") == 0 )
         {
            AV27TFRecetaMedicaAtencion = AV49GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV49GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFRECETAMEDICAATENCION_SEL") == 0 )
         {
            AV28TFRecetaMedicaAtencion_Sel = AV49GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV49GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFRECETAMEDICAFLAG") == 0 )
         {
            AV31TFRecetaMedicaFlag = (byte)(GXutil.lval( AV49GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value())) ;
            AV32TFRecetaMedicaFlag_To = (byte)(GXutil.lval( AV49GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Valueto())) ;
         }
         else if ( GXutil.strcmp(AV49GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFRECETAINDICACIONES") == 0 )
         {
            AV52TFRecetaIndicaciones = AV49GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV49GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFRECETAINDICACIONES_SEL") == 0 )
         {
            AV53TFRecetaIndicaciones_Sel = AV49GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         AV56GXV1 = (int)(AV56GXV1+1) ;
      }
   }

   public void S121( )
   {
      /* 'LOADMEDICAMENTOCODIGOOPTIONS' Routine */
      returnInSub = false ;
      AV17TFMedicamentoCodigo = AV33SearchTxt ;
      AV18TFMedicamentoCodigo_Sel = "" ;
      AV58Recetamedicawwds_1_filterfulltext = AV51FilterFullText ;
      AV59Recetamedicawwds_2_tfrecetamedicaid = AV11TFRecetaMedicaId ;
      AV60Recetamedicawwds_3_tfrecetamedicaid_to = AV12TFRecetaMedicaId_To ;
      AV61Recetamedicawwds_4_tfcitaid = AV13TFCitaId ;
      AV62Recetamedicawwds_5_tfcitaid_to = AV14TFCitaId_To ;
      AV63Recetamedicawwds_6_tfmedicamentoid = AV15TFMedicamentoId ;
      AV64Recetamedicawwds_7_tfmedicamentoid_to = AV16TFMedicamentoId_To ;
      AV65Recetamedicawwds_8_tfmedicamentocodigo = AV17TFMedicamentoCodigo ;
      AV66Recetamedicawwds_9_tfmedicamentocodigo_sel = AV18TFMedicamentoCodigo_Sel ;
      AV67Recetamedicawwds_10_tfmedicamentonombre = AV19TFMedicamentoNombre ;
      AV68Recetamedicawwds_11_tfmedicamentonombre_sel = AV20TFMedicamentoNombre_Sel ;
      AV69Recetamedicawwds_12_tfmedicamentoformafarm = AV21TFMedicamentoFormaFarm ;
      AV70Recetamedicawwds_13_tfmedicamentoformafarm_sel = AV22TFMedicamentoFormaFarm_Sel ;
      AV71Recetamedicawwds_14_tfrecetamedicaconcentracion = AV23TFRecetaMedicaConcentracion ;
      AV72Recetamedicawwds_15_tfrecetamedicaconcentracion_sel = AV24TFRecetaMedicaConcentracion_Sel ;
      AV73Recetamedicawwds_16_tfrecetamedicacantidad = AV25TFRecetaMedicaCantidad ;
      AV74Recetamedicawwds_17_tfrecetamedicacantidad_to = AV26TFRecetaMedicaCantidad_To ;
      AV75Recetamedicawwds_18_tfrecetamedicaatencion = AV27TFRecetaMedicaAtencion ;
      AV76Recetamedicawwds_19_tfrecetamedicaatencion_sel = AV28TFRecetaMedicaAtencion_Sel ;
      AV77Recetamedicawwds_20_tfrecetamedicaflag = AV31TFRecetaMedicaFlag ;
      AV78Recetamedicawwds_21_tfrecetamedicaflag_to = AV32TFRecetaMedicaFlag_To ;
      AV79Recetamedicawwds_22_tfrecetaindicaciones = AV52TFRecetaIndicaciones ;
      AV80Recetamedicawwds_23_tfrecetaindicaciones_sel = AV53TFRecetaIndicaciones_Sel ;
      pr_default.dynParam(0, new Object[]{ new Object[]{
                                           AV58Recetamedicawwds_1_filterfulltext ,
                                           Short.valueOf(AV59Recetamedicawwds_2_tfrecetamedicaid) ,
                                           Short.valueOf(AV60Recetamedicawwds_3_tfrecetamedicaid_to) ,
                                           Integer.valueOf(AV61Recetamedicawwds_4_tfcitaid) ,
                                           Integer.valueOf(AV62Recetamedicawwds_5_tfcitaid_to) ,
                                           Short.valueOf(AV63Recetamedicawwds_6_tfmedicamentoid) ,
                                           Short.valueOf(AV64Recetamedicawwds_7_tfmedicamentoid_to) ,
                                           AV66Recetamedicawwds_9_tfmedicamentocodigo_sel ,
                                           AV65Recetamedicawwds_8_tfmedicamentocodigo ,
                                           AV68Recetamedicawwds_11_tfmedicamentonombre_sel ,
                                           AV67Recetamedicawwds_10_tfmedicamentonombre ,
                                           AV70Recetamedicawwds_13_tfmedicamentoformafarm_sel ,
                                           AV69Recetamedicawwds_12_tfmedicamentoformafarm ,
                                           AV72Recetamedicawwds_15_tfrecetamedicaconcentracion_sel ,
                                           AV71Recetamedicawwds_14_tfrecetamedicaconcentracion ,
                                           Short.valueOf(AV73Recetamedicawwds_16_tfrecetamedicacantidad) ,
                                           Short.valueOf(AV74Recetamedicawwds_17_tfrecetamedicacantidad_to) ,
                                           AV76Recetamedicawwds_19_tfrecetamedicaatencion_sel ,
                                           AV75Recetamedicawwds_18_tfrecetamedicaatencion ,
                                           Byte.valueOf(AV77Recetamedicawwds_20_tfrecetamedicaflag) ,
                                           Byte.valueOf(AV78Recetamedicawwds_21_tfrecetamedicaflag_to) ,
                                           AV80Recetamedicawwds_23_tfrecetaindicaciones_sel ,
                                           AV79Recetamedicawwds_22_tfrecetaindicaciones ,
                                           Short.valueOf(A50RecetaMedicaId) ,
                                           Integer.valueOf(A19CitaId) ,
                                           Short.valueOf(A42MedicamentoId) ,
                                           A229MedicamentoCodigo ,
                                           A230MedicamentoNombre ,
                                           A231MedicamentoFormaFarm ,
                                           A268RecetaMedicaConcentracion ,
                                           Short.valueOf(A269RecetaMedicaCantidad) ,
                                           A273RecetaMedicaAtencion ,
                                           Byte.valueOf(A272RecetaMedicaFlag) ,
                                           A332RecetaIndicaciones } ,
                                           new int[]{
                                           TypeConstants.STRING, TypeConstants.SHORT, TypeConstants.SHORT, TypeConstants.INT, TypeConstants.INT, TypeConstants.SHORT, TypeConstants.SHORT, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING,
                                           TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.SHORT, TypeConstants.SHORT, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.BYTE,
                                           TypeConstants.BYTE, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.SHORT, TypeConstants.INT, TypeConstants.SHORT, TypeConstants.BOOLEAN, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING,
                                           TypeConstants.BOOLEAN, TypeConstants.STRING, TypeConstants.BOOLEAN, TypeConstants.SHORT, TypeConstants.BOOLEAN, TypeConstants.STRING, TypeConstants.BOOLEAN, TypeConstants.BYTE, TypeConstants.BOOLEAN, TypeConstants.STRING
                                           }
      });
      lV58Recetamedicawwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV58Recetamedicawwds_1_filterfulltext), "%", "") ;
      lV58Recetamedicawwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV58Recetamedicawwds_1_filterfulltext), "%", "") ;
      lV58Recetamedicawwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV58Recetamedicawwds_1_filterfulltext), "%", "") ;
      lV58Recetamedicawwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV58Recetamedicawwds_1_filterfulltext), "%", "") ;
      lV58Recetamedicawwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV58Recetamedicawwds_1_filterfulltext), "%", "") ;
      lV58Recetamedicawwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV58Recetamedicawwds_1_filterfulltext), "%", "") ;
      lV58Recetamedicawwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV58Recetamedicawwds_1_filterfulltext), "%", "") ;
      lV58Recetamedicawwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV58Recetamedicawwds_1_filterfulltext), "%", "") ;
      lV58Recetamedicawwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV58Recetamedicawwds_1_filterfulltext), "%", "") ;
      lV58Recetamedicawwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV58Recetamedicawwds_1_filterfulltext), "%", "") ;
      lV58Recetamedicawwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV58Recetamedicawwds_1_filterfulltext), "%", "") ;
      lV65Recetamedicawwds_8_tfmedicamentocodigo = GXutil.concat( GXutil.rtrim( AV65Recetamedicawwds_8_tfmedicamentocodigo), "%", "") ;
      lV67Recetamedicawwds_10_tfmedicamentonombre = GXutil.concat( GXutil.rtrim( AV67Recetamedicawwds_10_tfmedicamentonombre), "%", "") ;
      lV69Recetamedicawwds_12_tfmedicamentoformafarm = GXutil.concat( GXutil.rtrim( AV69Recetamedicawwds_12_tfmedicamentoformafarm), "%", "") ;
      lV71Recetamedicawwds_14_tfrecetamedicaconcentracion = GXutil.concat( GXutil.rtrim( AV71Recetamedicawwds_14_tfrecetamedicaconcentracion), "%", "") ;
      lV75Recetamedicawwds_18_tfrecetamedicaatencion = GXutil.concat( GXutil.rtrim( AV75Recetamedicawwds_18_tfrecetamedicaatencion), "%", "") ;
      lV79Recetamedicawwds_22_tfrecetaindicaciones = GXutil.concat( GXutil.rtrim( AV79Recetamedicawwds_22_tfrecetaindicaciones), "%", "") ;
      /* Using cursor P003J2 */
      pr_default.execute(0, new Object[] {lV58Recetamedicawwds_1_filterfulltext, lV58Recetamedicawwds_1_filterfulltext, lV58Recetamedicawwds_1_filterfulltext, lV58Recetamedicawwds_1_filterfulltext, lV58Recetamedicawwds_1_filterfulltext, lV58Recetamedicawwds_1_filterfulltext, lV58Recetamedicawwds_1_filterfulltext, lV58Recetamedicawwds_1_filterfulltext, lV58Recetamedicawwds_1_filterfulltext, lV58Recetamedicawwds_1_filterfulltext, lV58Recetamedicawwds_1_filterfulltext, Short.valueOf(AV59Recetamedicawwds_2_tfrecetamedicaid), Short.valueOf(AV60Recetamedicawwds_3_tfrecetamedicaid_to), Integer.valueOf(AV61Recetamedicawwds_4_tfcitaid), Integer.valueOf(AV62Recetamedicawwds_5_tfcitaid_to), Short.valueOf(AV63Recetamedicawwds_6_tfmedicamentoid), Short.valueOf(AV64Recetamedicawwds_7_tfmedicamentoid_to), lV65Recetamedicawwds_8_tfmedicamentocodigo, AV66Recetamedicawwds_9_tfmedicamentocodigo_sel, lV67Recetamedicawwds_10_tfmedicamentonombre, AV68Recetamedicawwds_11_tfmedicamentonombre_sel, lV69Recetamedicawwds_12_tfmedicamentoformafarm, AV70Recetamedicawwds_13_tfmedicamentoformafarm_sel, lV71Recetamedicawwds_14_tfrecetamedicaconcentracion, AV72Recetamedicawwds_15_tfrecetamedicaconcentracion_sel, Short.valueOf(AV73Recetamedicawwds_16_tfrecetamedicacantidad), Short.valueOf(AV74Recetamedicawwds_17_tfrecetamedicacantidad_to), lV75Recetamedicawwds_18_tfrecetamedicaatencion, AV76Recetamedicawwds_19_tfrecetamedicaatencion_sel, Byte.valueOf(AV77Recetamedicawwds_20_tfrecetamedicaflag), Byte.valueOf(AV78Recetamedicawwds_21_tfrecetamedicaflag_to), lV79Recetamedicawwds_22_tfrecetaindicaciones, AV80Recetamedicawwds_23_tfrecetaindicaciones_sel});
      while ( (pr_default.getStatus(0) != 101) )
      {
         brk3J2 = false ;
         A42MedicamentoId = P003J2_A42MedicamentoId[0] ;
         n42MedicamentoId = P003J2_n42MedicamentoId[0] ;
         A272RecetaMedicaFlag = P003J2_A272RecetaMedicaFlag[0] ;
         n272RecetaMedicaFlag = P003J2_n272RecetaMedicaFlag[0] ;
         A269RecetaMedicaCantidad = P003J2_A269RecetaMedicaCantidad[0] ;
         n269RecetaMedicaCantidad = P003J2_n269RecetaMedicaCantidad[0] ;
         A19CitaId = P003J2_A19CitaId[0] ;
         A50RecetaMedicaId = P003J2_A50RecetaMedicaId[0] ;
         A332RecetaIndicaciones = P003J2_A332RecetaIndicaciones[0] ;
         A273RecetaMedicaAtencion = P003J2_A273RecetaMedicaAtencion[0] ;
         n273RecetaMedicaAtencion = P003J2_n273RecetaMedicaAtencion[0] ;
         A268RecetaMedicaConcentracion = P003J2_A268RecetaMedicaConcentracion[0] ;
         n268RecetaMedicaConcentracion = P003J2_n268RecetaMedicaConcentracion[0] ;
         A231MedicamentoFormaFarm = P003J2_A231MedicamentoFormaFarm[0] ;
         n231MedicamentoFormaFarm = P003J2_n231MedicamentoFormaFarm[0] ;
         A230MedicamentoNombre = P003J2_A230MedicamentoNombre[0] ;
         A229MedicamentoCodigo = P003J2_A229MedicamentoCodigo[0] ;
         A231MedicamentoFormaFarm = P003J2_A231MedicamentoFormaFarm[0] ;
         n231MedicamentoFormaFarm = P003J2_n231MedicamentoFormaFarm[0] ;
         A230MedicamentoNombre = P003J2_A230MedicamentoNombre[0] ;
         A229MedicamentoCodigo = P003J2_A229MedicamentoCodigo[0] ;
         AV45count = 0 ;
         while ( (pr_default.getStatus(0) != 101) && ( P003J2_A42MedicamentoId[0] == A42MedicamentoId ) )
         {
            brk3J2 = false ;
            A50RecetaMedicaId = P003J2_A50RecetaMedicaId[0] ;
            AV45count = (long)(AV45count+1) ;
            brk3J2 = true ;
            pr_default.readNext(0);
         }
         if ( ! (GXutil.strcmp("", A229MedicamentoCodigo)==0) )
         {
            AV37Option = A229MedicamentoCodigo ;
            AV36InsertIndex = 1 ;
            while ( ( AV36InsertIndex <= AV38Options.size() ) && ( GXutil.strcmp((String)AV38Options.elementAt(-1+AV36InsertIndex), AV37Option) < 0 ) )
            {
               AV36InsertIndex = (int)(AV36InsertIndex+1) ;
            }
            AV38Options.add(AV37Option, AV36InsertIndex);
            AV43OptionIndexes.add(GXutil.trim( localUtil.format( DecimalUtil.doubleToDec(AV45count), "Z,ZZZ,ZZZ,ZZ9")), AV36InsertIndex);
         }
         if ( AV38Options.size() == 50 )
         {
            /* Exit For each command. Update data (if necessary), close cursors & exit. */
            if (true) break;
         }
         if ( ! brk3J2 )
         {
            brk3J2 = true ;
            pr_default.readNext(0);
         }
      }
      pr_default.close(0);
   }

   public void S131( )
   {
      /* 'LOADMEDICAMENTONOMBREOPTIONS' Routine */
      returnInSub = false ;
      AV19TFMedicamentoNombre = AV33SearchTxt ;
      AV20TFMedicamentoNombre_Sel = "" ;
      AV58Recetamedicawwds_1_filterfulltext = AV51FilterFullText ;
      AV59Recetamedicawwds_2_tfrecetamedicaid = AV11TFRecetaMedicaId ;
      AV60Recetamedicawwds_3_tfrecetamedicaid_to = AV12TFRecetaMedicaId_To ;
      AV61Recetamedicawwds_4_tfcitaid = AV13TFCitaId ;
      AV62Recetamedicawwds_5_tfcitaid_to = AV14TFCitaId_To ;
      AV63Recetamedicawwds_6_tfmedicamentoid = AV15TFMedicamentoId ;
      AV64Recetamedicawwds_7_tfmedicamentoid_to = AV16TFMedicamentoId_To ;
      AV65Recetamedicawwds_8_tfmedicamentocodigo = AV17TFMedicamentoCodigo ;
      AV66Recetamedicawwds_9_tfmedicamentocodigo_sel = AV18TFMedicamentoCodigo_Sel ;
      AV67Recetamedicawwds_10_tfmedicamentonombre = AV19TFMedicamentoNombre ;
      AV68Recetamedicawwds_11_tfmedicamentonombre_sel = AV20TFMedicamentoNombre_Sel ;
      AV69Recetamedicawwds_12_tfmedicamentoformafarm = AV21TFMedicamentoFormaFarm ;
      AV70Recetamedicawwds_13_tfmedicamentoformafarm_sel = AV22TFMedicamentoFormaFarm_Sel ;
      AV71Recetamedicawwds_14_tfrecetamedicaconcentracion = AV23TFRecetaMedicaConcentracion ;
      AV72Recetamedicawwds_15_tfrecetamedicaconcentracion_sel = AV24TFRecetaMedicaConcentracion_Sel ;
      AV73Recetamedicawwds_16_tfrecetamedicacantidad = AV25TFRecetaMedicaCantidad ;
      AV74Recetamedicawwds_17_tfrecetamedicacantidad_to = AV26TFRecetaMedicaCantidad_To ;
      AV75Recetamedicawwds_18_tfrecetamedicaatencion = AV27TFRecetaMedicaAtencion ;
      AV76Recetamedicawwds_19_tfrecetamedicaatencion_sel = AV28TFRecetaMedicaAtencion_Sel ;
      AV77Recetamedicawwds_20_tfrecetamedicaflag = AV31TFRecetaMedicaFlag ;
      AV78Recetamedicawwds_21_tfrecetamedicaflag_to = AV32TFRecetaMedicaFlag_To ;
      AV79Recetamedicawwds_22_tfrecetaindicaciones = AV52TFRecetaIndicaciones ;
      AV80Recetamedicawwds_23_tfrecetaindicaciones_sel = AV53TFRecetaIndicaciones_Sel ;
      pr_default.dynParam(1, new Object[]{ new Object[]{
                                           AV58Recetamedicawwds_1_filterfulltext ,
                                           Short.valueOf(AV59Recetamedicawwds_2_tfrecetamedicaid) ,
                                           Short.valueOf(AV60Recetamedicawwds_3_tfrecetamedicaid_to) ,
                                           Integer.valueOf(AV61Recetamedicawwds_4_tfcitaid) ,
                                           Integer.valueOf(AV62Recetamedicawwds_5_tfcitaid_to) ,
                                           Short.valueOf(AV63Recetamedicawwds_6_tfmedicamentoid) ,
                                           Short.valueOf(AV64Recetamedicawwds_7_tfmedicamentoid_to) ,
                                           AV66Recetamedicawwds_9_tfmedicamentocodigo_sel ,
                                           AV65Recetamedicawwds_8_tfmedicamentocodigo ,
                                           AV68Recetamedicawwds_11_tfmedicamentonombre_sel ,
                                           AV67Recetamedicawwds_10_tfmedicamentonombre ,
                                           AV70Recetamedicawwds_13_tfmedicamentoformafarm_sel ,
                                           AV69Recetamedicawwds_12_tfmedicamentoformafarm ,
                                           AV72Recetamedicawwds_15_tfrecetamedicaconcentracion_sel ,
                                           AV71Recetamedicawwds_14_tfrecetamedicaconcentracion ,
                                           Short.valueOf(AV73Recetamedicawwds_16_tfrecetamedicacantidad) ,
                                           Short.valueOf(AV74Recetamedicawwds_17_tfrecetamedicacantidad_to) ,
                                           AV76Recetamedicawwds_19_tfrecetamedicaatencion_sel ,
                                           AV75Recetamedicawwds_18_tfrecetamedicaatencion ,
                                           Byte.valueOf(AV77Recetamedicawwds_20_tfrecetamedicaflag) ,
                                           Byte.valueOf(AV78Recetamedicawwds_21_tfrecetamedicaflag_to) ,
                                           AV80Recetamedicawwds_23_tfrecetaindicaciones_sel ,
                                           AV79Recetamedicawwds_22_tfrecetaindicaciones ,
                                           Short.valueOf(A50RecetaMedicaId) ,
                                           Integer.valueOf(A19CitaId) ,
                                           Short.valueOf(A42MedicamentoId) ,
                                           A229MedicamentoCodigo ,
                                           A230MedicamentoNombre ,
                                           A231MedicamentoFormaFarm ,
                                           A268RecetaMedicaConcentracion ,
                                           Short.valueOf(A269RecetaMedicaCantidad) ,
                                           A273RecetaMedicaAtencion ,
                                           Byte.valueOf(A272RecetaMedicaFlag) ,
                                           A332RecetaIndicaciones } ,
                                           new int[]{
                                           TypeConstants.STRING, TypeConstants.SHORT, TypeConstants.SHORT, TypeConstants.INT, TypeConstants.INT, TypeConstants.SHORT, TypeConstants.SHORT, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING,
                                           TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.SHORT, TypeConstants.SHORT, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.BYTE,
                                           TypeConstants.BYTE, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.SHORT, TypeConstants.INT, TypeConstants.SHORT, TypeConstants.BOOLEAN, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING,
                                           TypeConstants.BOOLEAN, TypeConstants.STRING, TypeConstants.BOOLEAN, TypeConstants.SHORT, TypeConstants.BOOLEAN, TypeConstants.STRING, TypeConstants.BOOLEAN, TypeConstants.BYTE, TypeConstants.BOOLEAN, TypeConstants.STRING
                                           }
      });
      lV58Recetamedicawwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV58Recetamedicawwds_1_filterfulltext), "%", "") ;
      lV58Recetamedicawwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV58Recetamedicawwds_1_filterfulltext), "%", "") ;
      lV58Recetamedicawwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV58Recetamedicawwds_1_filterfulltext), "%", "") ;
      lV58Recetamedicawwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV58Recetamedicawwds_1_filterfulltext), "%", "") ;
      lV58Recetamedicawwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV58Recetamedicawwds_1_filterfulltext), "%", "") ;
      lV58Recetamedicawwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV58Recetamedicawwds_1_filterfulltext), "%", "") ;
      lV58Recetamedicawwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV58Recetamedicawwds_1_filterfulltext), "%", "") ;
      lV58Recetamedicawwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV58Recetamedicawwds_1_filterfulltext), "%", "") ;
      lV58Recetamedicawwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV58Recetamedicawwds_1_filterfulltext), "%", "") ;
      lV58Recetamedicawwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV58Recetamedicawwds_1_filterfulltext), "%", "") ;
      lV58Recetamedicawwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV58Recetamedicawwds_1_filterfulltext), "%", "") ;
      lV65Recetamedicawwds_8_tfmedicamentocodigo = GXutil.concat( GXutil.rtrim( AV65Recetamedicawwds_8_tfmedicamentocodigo), "%", "") ;
      lV67Recetamedicawwds_10_tfmedicamentonombre = GXutil.concat( GXutil.rtrim( AV67Recetamedicawwds_10_tfmedicamentonombre), "%", "") ;
      lV69Recetamedicawwds_12_tfmedicamentoformafarm = GXutil.concat( GXutil.rtrim( AV69Recetamedicawwds_12_tfmedicamentoformafarm), "%", "") ;
      lV71Recetamedicawwds_14_tfrecetamedicaconcentracion = GXutil.concat( GXutil.rtrim( AV71Recetamedicawwds_14_tfrecetamedicaconcentracion), "%", "") ;
      lV75Recetamedicawwds_18_tfrecetamedicaatencion = GXutil.concat( GXutil.rtrim( AV75Recetamedicawwds_18_tfrecetamedicaatencion), "%", "") ;
      lV79Recetamedicawwds_22_tfrecetaindicaciones = GXutil.concat( GXutil.rtrim( AV79Recetamedicawwds_22_tfrecetaindicaciones), "%", "") ;
      /* Using cursor P003J3 */
      pr_default.execute(1, new Object[] {lV58Recetamedicawwds_1_filterfulltext, lV58Recetamedicawwds_1_filterfulltext, lV58Recetamedicawwds_1_filterfulltext, lV58Recetamedicawwds_1_filterfulltext, lV58Recetamedicawwds_1_filterfulltext, lV58Recetamedicawwds_1_filterfulltext, lV58Recetamedicawwds_1_filterfulltext, lV58Recetamedicawwds_1_filterfulltext, lV58Recetamedicawwds_1_filterfulltext, lV58Recetamedicawwds_1_filterfulltext, lV58Recetamedicawwds_1_filterfulltext, Short.valueOf(AV59Recetamedicawwds_2_tfrecetamedicaid), Short.valueOf(AV60Recetamedicawwds_3_tfrecetamedicaid_to), Integer.valueOf(AV61Recetamedicawwds_4_tfcitaid), Integer.valueOf(AV62Recetamedicawwds_5_tfcitaid_to), Short.valueOf(AV63Recetamedicawwds_6_tfmedicamentoid), Short.valueOf(AV64Recetamedicawwds_7_tfmedicamentoid_to), lV65Recetamedicawwds_8_tfmedicamentocodigo, AV66Recetamedicawwds_9_tfmedicamentocodigo_sel, lV67Recetamedicawwds_10_tfmedicamentonombre, AV68Recetamedicawwds_11_tfmedicamentonombre_sel, lV69Recetamedicawwds_12_tfmedicamentoformafarm, AV70Recetamedicawwds_13_tfmedicamentoformafarm_sel, lV71Recetamedicawwds_14_tfrecetamedicaconcentracion, AV72Recetamedicawwds_15_tfrecetamedicaconcentracion_sel, Short.valueOf(AV73Recetamedicawwds_16_tfrecetamedicacantidad), Short.valueOf(AV74Recetamedicawwds_17_tfrecetamedicacantidad_to), lV75Recetamedicawwds_18_tfrecetamedicaatencion, AV76Recetamedicawwds_19_tfrecetamedicaatencion_sel, Byte.valueOf(AV77Recetamedicawwds_20_tfrecetamedicaflag), Byte.valueOf(AV78Recetamedicawwds_21_tfrecetamedicaflag_to), lV79Recetamedicawwds_22_tfrecetaindicaciones, AV80Recetamedicawwds_23_tfrecetaindicaciones_sel});
      while ( (pr_default.getStatus(1) != 101) )
      {
         brk3J4 = false ;
         A230MedicamentoNombre = P003J3_A230MedicamentoNombre[0] ;
         A272RecetaMedicaFlag = P003J3_A272RecetaMedicaFlag[0] ;
         n272RecetaMedicaFlag = P003J3_n272RecetaMedicaFlag[0] ;
         A269RecetaMedicaCantidad = P003J3_A269RecetaMedicaCantidad[0] ;
         n269RecetaMedicaCantidad = P003J3_n269RecetaMedicaCantidad[0] ;
         A42MedicamentoId = P003J3_A42MedicamentoId[0] ;
         n42MedicamentoId = P003J3_n42MedicamentoId[0] ;
         A19CitaId = P003J3_A19CitaId[0] ;
         A50RecetaMedicaId = P003J3_A50RecetaMedicaId[0] ;
         A332RecetaIndicaciones = P003J3_A332RecetaIndicaciones[0] ;
         A273RecetaMedicaAtencion = P003J3_A273RecetaMedicaAtencion[0] ;
         n273RecetaMedicaAtencion = P003J3_n273RecetaMedicaAtencion[0] ;
         A268RecetaMedicaConcentracion = P003J3_A268RecetaMedicaConcentracion[0] ;
         n268RecetaMedicaConcentracion = P003J3_n268RecetaMedicaConcentracion[0] ;
         A231MedicamentoFormaFarm = P003J3_A231MedicamentoFormaFarm[0] ;
         n231MedicamentoFormaFarm = P003J3_n231MedicamentoFormaFarm[0] ;
         A229MedicamentoCodigo = P003J3_A229MedicamentoCodigo[0] ;
         A230MedicamentoNombre = P003J3_A230MedicamentoNombre[0] ;
         A231MedicamentoFormaFarm = P003J3_A231MedicamentoFormaFarm[0] ;
         n231MedicamentoFormaFarm = P003J3_n231MedicamentoFormaFarm[0] ;
         A229MedicamentoCodigo = P003J3_A229MedicamentoCodigo[0] ;
         AV45count = 0 ;
         while ( (pr_default.getStatus(1) != 101) && ( GXutil.strcmp(P003J3_A230MedicamentoNombre[0], A230MedicamentoNombre) == 0 ) )
         {
            brk3J4 = false ;
            A42MedicamentoId = P003J3_A42MedicamentoId[0] ;
            n42MedicamentoId = P003J3_n42MedicamentoId[0] ;
            A50RecetaMedicaId = P003J3_A50RecetaMedicaId[0] ;
            AV45count = (long)(AV45count+1) ;
            brk3J4 = true ;
            pr_default.readNext(1);
         }
         if ( ! (GXutil.strcmp("", A230MedicamentoNombre)==0) )
         {
            AV37Option = A230MedicamentoNombre ;
            AV38Options.add(AV37Option, 0);
            AV43OptionIndexes.add(GXutil.trim( localUtil.format( DecimalUtil.doubleToDec(AV45count), "Z,ZZZ,ZZZ,ZZ9")), 0);
         }
         if ( AV38Options.size() == 50 )
         {
            /* Exit For each command. Update data (if necessary), close cursors & exit. */
            if (true) break;
         }
         if ( ! brk3J4 )
         {
            brk3J4 = true ;
            pr_default.readNext(1);
         }
      }
      pr_default.close(1);
   }

   public void S141( )
   {
      /* 'LOADMEDICAMENTOFORMAFARMOPTIONS' Routine */
      returnInSub = false ;
      AV21TFMedicamentoFormaFarm = AV33SearchTxt ;
      AV22TFMedicamentoFormaFarm_Sel = "" ;
      AV58Recetamedicawwds_1_filterfulltext = AV51FilterFullText ;
      AV59Recetamedicawwds_2_tfrecetamedicaid = AV11TFRecetaMedicaId ;
      AV60Recetamedicawwds_3_tfrecetamedicaid_to = AV12TFRecetaMedicaId_To ;
      AV61Recetamedicawwds_4_tfcitaid = AV13TFCitaId ;
      AV62Recetamedicawwds_5_tfcitaid_to = AV14TFCitaId_To ;
      AV63Recetamedicawwds_6_tfmedicamentoid = AV15TFMedicamentoId ;
      AV64Recetamedicawwds_7_tfmedicamentoid_to = AV16TFMedicamentoId_To ;
      AV65Recetamedicawwds_8_tfmedicamentocodigo = AV17TFMedicamentoCodigo ;
      AV66Recetamedicawwds_9_tfmedicamentocodigo_sel = AV18TFMedicamentoCodigo_Sel ;
      AV67Recetamedicawwds_10_tfmedicamentonombre = AV19TFMedicamentoNombre ;
      AV68Recetamedicawwds_11_tfmedicamentonombre_sel = AV20TFMedicamentoNombre_Sel ;
      AV69Recetamedicawwds_12_tfmedicamentoformafarm = AV21TFMedicamentoFormaFarm ;
      AV70Recetamedicawwds_13_tfmedicamentoformafarm_sel = AV22TFMedicamentoFormaFarm_Sel ;
      AV71Recetamedicawwds_14_tfrecetamedicaconcentracion = AV23TFRecetaMedicaConcentracion ;
      AV72Recetamedicawwds_15_tfrecetamedicaconcentracion_sel = AV24TFRecetaMedicaConcentracion_Sel ;
      AV73Recetamedicawwds_16_tfrecetamedicacantidad = AV25TFRecetaMedicaCantidad ;
      AV74Recetamedicawwds_17_tfrecetamedicacantidad_to = AV26TFRecetaMedicaCantidad_To ;
      AV75Recetamedicawwds_18_tfrecetamedicaatencion = AV27TFRecetaMedicaAtencion ;
      AV76Recetamedicawwds_19_tfrecetamedicaatencion_sel = AV28TFRecetaMedicaAtencion_Sel ;
      AV77Recetamedicawwds_20_tfrecetamedicaflag = AV31TFRecetaMedicaFlag ;
      AV78Recetamedicawwds_21_tfrecetamedicaflag_to = AV32TFRecetaMedicaFlag_To ;
      AV79Recetamedicawwds_22_tfrecetaindicaciones = AV52TFRecetaIndicaciones ;
      AV80Recetamedicawwds_23_tfrecetaindicaciones_sel = AV53TFRecetaIndicaciones_Sel ;
      pr_default.dynParam(2, new Object[]{ new Object[]{
                                           AV58Recetamedicawwds_1_filterfulltext ,
                                           Short.valueOf(AV59Recetamedicawwds_2_tfrecetamedicaid) ,
                                           Short.valueOf(AV60Recetamedicawwds_3_tfrecetamedicaid_to) ,
                                           Integer.valueOf(AV61Recetamedicawwds_4_tfcitaid) ,
                                           Integer.valueOf(AV62Recetamedicawwds_5_tfcitaid_to) ,
                                           Short.valueOf(AV63Recetamedicawwds_6_tfmedicamentoid) ,
                                           Short.valueOf(AV64Recetamedicawwds_7_tfmedicamentoid_to) ,
                                           AV66Recetamedicawwds_9_tfmedicamentocodigo_sel ,
                                           AV65Recetamedicawwds_8_tfmedicamentocodigo ,
                                           AV68Recetamedicawwds_11_tfmedicamentonombre_sel ,
                                           AV67Recetamedicawwds_10_tfmedicamentonombre ,
                                           AV70Recetamedicawwds_13_tfmedicamentoformafarm_sel ,
                                           AV69Recetamedicawwds_12_tfmedicamentoformafarm ,
                                           AV72Recetamedicawwds_15_tfrecetamedicaconcentracion_sel ,
                                           AV71Recetamedicawwds_14_tfrecetamedicaconcentracion ,
                                           Short.valueOf(AV73Recetamedicawwds_16_tfrecetamedicacantidad) ,
                                           Short.valueOf(AV74Recetamedicawwds_17_tfrecetamedicacantidad_to) ,
                                           AV76Recetamedicawwds_19_tfrecetamedicaatencion_sel ,
                                           AV75Recetamedicawwds_18_tfrecetamedicaatencion ,
                                           Byte.valueOf(AV77Recetamedicawwds_20_tfrecetamedicaflag) ,
                                           Byte.valueOf(AV78Recetamedicawwds_21_tfrecetamedicaflag_to) ,
                                           AV80Recetamedicawwds_23_tfrecetaindicaciones_sel ,
                                           AV79Recetamedicawwds_22_tfrecetaindicaciones ,
                                           Short.valueOf(A50RecetaMedicaId) ,
                                           Integer.valueOf(A19CitaId) ,
                                           Short.valueOf(A42MedicamentoId) ,
                                           A229MedicamentoCodigo ,
                                           A230MedicamentoNombre ,
                                           A231MedicamentoFormaFarm ,
                                           A268RecetaMedicaConcentracion ,
                                           Short.valueOf(A269RecetaMedicaCantidad) ,
                                           A273RecetaMedicaAtencion ,
                                           Byte.valueOf(A272RecetaMedicaFlag) ,
                                           A332RecetaIndicaciones } ,
                                           new int[]{
                                           TypeConstants.STRING, TypeConstants.SHORT, TypeConstants.SHORT, TypeConstants.INT, TypeConstants.INT, TypeConstants.SHORT, TypeConstants.SHORT, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING,
                                           TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.SHORT, TypeConstants.SHORT, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.BYTE,
                                           TypeConstants.BYTE, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.SHORT, TypeConstants.INT, TypeConstants.SHORT, TypeConstants.BOOLEAN, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING,
                                           TypeConstants.BOOLEAN, TypeConstants.STRING, TypeConstants.BOOLEAN, TypeConstants.SHORT, TypeConstants.BOOLEAN, TypeConstants.STRING, TypeConstants.BOOLEAN, TypeConstants.BYTE, TypeConstants.BOOLEAN, TypeConstants.STRING
                                           }
      });
      lV58Recetamedicawwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV58Recetamedicawwds_1_filterfulltext), "%", "") ;
      lV58Recetamedicawwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV58Recetamedicawwds_1_filterfulltext), "%", "") ;
      lV58Recetamedicawwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV58Recetamedicawwds_1_filterfulltext), "%", "") ;
      lV58Recetamedicawwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV58Recetamedicawwds_1_filterfulltext), "%", "") ;
      lV58Recetamedicawwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV58Recetamedicawwds_1_filterfulltext), "%", "") ;
      lV58Recetamedicawwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV58Recetamedicawwds_1_filterfulltext), "%", "") ;
      lV58Recetamedicawwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV58Recetamedicawwds_1_filterfulltext), "%", "") ;
      lV58Recetamedicawwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV58Recetamedicawwds_1_filterfulltext), "%", "") ;
      lV58Recetamedicawwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV58Recetamedicawwds_1_filterfulltext), "%", "") ;
      lV58Recetamedicawwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV58Recetamedicawwds_1_filterfulltext), "%", "") ;
      lV58Recetamedicawwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV58Recetamedicawwds_1_filterfulltext), "%", "") ;
      lV65Recetamedicawwds_8_tfmedicamentocodigo = GXutil.concat( GXutil.rtrim( AV65Recetamedicawwds_8_tfmedicamentocodigo), "%", "") ;
      lV67Recetamedicawwds_10_tfmedicamentonombre = GXutil.concat( GXutil.rtrim( AV67Recetamedicawwds_10_tfmedicamentonombre), "%", "") ;
      lV69Recetamedicawwds_12_tfmedicamentoformafarm = GXutil.concat( GXutil.rtrim( AV69Recetamedicawwds_12_tfmedicamentoformafarm), "%", "") ;
      lV71Recetamedicawwds_14_tfrecetamedicaconcentracion = GXutil.concat( GXutil.rtrim( AV71Recetamedicawwds_14_tfrecetamedicaconcentracion), "%", "") ;
      lV75Recetamedicawwds_18_tfrecetamedicaatencion = GXutil.concat( GXutil.rtrim( AV75Recetamedicawwds_18_tfrecetamedicaatencion), "%", "") ;
      lV79Recetamedicawwds_22_tfrecetaindicaciones = GXutil.concat( GXutil.rtrim( AV79Recetamedicawwds_22_tfrecetaindicaciones), "%", "") ;
      /* Using cursor P003J4 */
      pr_default.execute(2, new Object[] {lV58Recetamedicawwds_1_filterfulltext, lV58Recetamedicawwds_1_filterfulltext, lV58Recetamedicawwds_1_filterfulltext, lV58Recetamedicawwds_1_filterfulltext, lV58Recetamedicawwds_1_filterfulltext, lV58Recetamedicawwds_1_filterfulltext, lV58Recetamedicawwds_1_filterfulltext, lV58Recetamedicawwds_1_filterfulltext, lV58Recetamedicawwds_1_filterfulltext, lV58Recetamedicawwds_1_filterfulltext, lV58Recetamedicawwds_1_filterfulltext, Short.valueOf(AV59Recetamedicawwds_2_tfrecetamedicaid), Short.valueOf(AV60Recetamedicawwds_3_tfrecetamedicaid_to), Integer.valueOf(AV61Recetamedicawwds_4_tfcitaid), Integer.valueOf(AV62Recetamedicawwds_5_tfcitaid_to), Short.valueOf(AV63Recetamedicawwds_6_tfmedicamentoid), Short.valueOf(AV64Recetamedicawwds_7_tfmedicamentoid_to), lV65Recetamedicawwds_8_tfmedicamentocodigo, AV66Recetamedicawwds_9_tfmedicamentocodigo_sel, lV67Recetamedicawwds_10_tfmedicamentonombre, AV68Recetamedicawwds_11_tfmedicamentonombre_sel, lV69Recetamedicawwds_12_tfmedicamentoformafarm, AV70Recetamedicawwds_13_tfmedicamentoformafarm_sel, lV71Recetamedicawwds_14_tfrecetamedicaconcentracion, AV72Recetamedicawwds_15_tfrecetamedicaconcentracion_sel, Short.valueOf(AV73Recetamedicawwds_16_tfrecetamedicacantidad), Short.valueOf(AV74Recetamedicawwds_17_tfrecetamedicacantidad_to), lV75Recetamedicawwds_18_tfrecetamedicaatencion, AV76Recetamedicawwds_19_tfrecetamedicaatencion_sel, Byte.valueOf(AV77Recetamedicawwds_20_tfrecetamedicaflag), Byte.valueOf(AV78Recetamedicawwds_21_tfrecetamedicaflag_to), lV79Recetamedicawwds_22_tfrecetaindicaciones, AV80Recetamedicawwds_23_tfrecetaindicaciones_sel});
      while ( (pr_default.getStatus(2) != 101) )
      {
         brk3J6 = false ;
         A231MedicamentoFormaFarm = P003J4_A231MedicamentoFormaFarm[0] ;
         n231MedicamentoFormaFarm = P003J4_n231MedicamentoFormaFarm[0] ;
         A272RecetaMedicaFlag = P003J4_A272RecetaMedicaFlag[0] ;
         n272RecetaMedicaFlag = P003J4_n272RecetaMedicaFlag[0] ;
         A269RecetaMedicaCantidad = P003J4_A269RecetaMedicaCantidad[0] ;
         n269RecetaMedicaCantidad = P003J4_n269RecetaMedicaCantidad[0] ;
         A42MedicamentoId = P003J4_A42MedicamentoId[0] ;
         n42MedicamentoId = P003J4_n42MedicamentoId[0] ;
         A19CitaId = P003J4_A19CitaId[0] ;
         A50RecetaMedicaId = P003J4_A50RecetaMedicaId[0] ;
         A332RecetaIndicaciones = P003J4_A332RecetaIndicaciones[0] ;
         A273RecetaMedicaAtencion = P003J4_A273RecetaMedicaAtencion[0] ;
         n273RecetaMedicaAtencion = P003J4_n273RecetaMedicaAtencion[0] ;
         A268RecetaMedicaConcentracion = P003J4_A268RecetaMedicaConcentracion[0] ;
         n268RecetaMedicaConcentracion = P003J4_n268RecetaMedicaConcentracion[0] ;
         A230MedicamentoNombre = P003J4_A230MedicamentoNombre[0] ;
         A229MedicamentoCodigo = P003J4_A229MedicamentoCodigo[0] ;
         A231MedicamentoFormaFarm = P003J4_A231MedicamentoFormaFarm[0] ;
         n231MedicamentoFormaFarm = P003J4_n231MedicamentoFormaFarm[0] ;
         A230MedicamentoNombre = P003J4_A230MedicamentoNombre[0] ;
         A229MedicamentoCodigo = P003J4_A229MedicamentoCodigo[0] ;
         AV45count = 0 ;
         while ( (pr_default.getStatus(2) != 101) && ( GXutil.strcmp(P003J4_A231MedicamentoFormaFarm[0], A231MedicamentoFormaFarm) == 0 ) )
         {
            brk3J6 = false ;
            A42MedicamentoId = P003J4_A42MedicamentoId[0] ;
            n42MedicamentoId = P003J4_n42MedicamentoId[0] ;
            A50RecetaMedicaId = P003J4_A50RecetaMedicaId[0] ;
            AV45count = (long)(AV45count+1) ;
            brk3J6 = true ;
            pr_default.readNext(2);
         }
         if ( ! (GXutil.strcmp("", A231MedicamentoFormaFarm)==0) )
         {
            AV37Option = A231MedicamentoFormaFarm ;
            AV38Options.add(AV37Option, 0);
            AV43OptionIndexes.add(GXutil.trim( localUtil.format( DecimalUtil.doubleToDec(AV45count), "Z,ZZZ,ZZZ,ZZ9")), 0);
         }
         if ( AV38Options.size() == 50 )
         {
            /* Exit For each command. Update data (if necessary), close cursors & exit. */
            if (true) break;
         }
         if ( ! brk3J6 )
         {
            brk3J6 = true ;
            pr_default.readNext(2);
         }
      }
      pr_default.close(2);
   }

   public void S151( )
   {
      /* 'LOADRECETAMEDICACONCENTRACIONOPTIONS' Routine */
      returnInSub = false ;
      AV23TFRecetaMedicaConcentracion = AV33SearchTxt ;
      AV24TFRecetaMedicaConcentracion_Sel = "" ;
      AV58Recetamedicawwds_1_filterfulltext = AV51FilterFullText ;
      AV59Recetamedicawwds_2_tfrecetamedicaid = AV11TFRecetaMedicaId ;
      AV60Recetamedicawwds_3_tfrecetamedicaid_to = AV12TFRecetaMedicaId_To ;
      AV61Recetamedicawwds_4_tfcitaid = AV13TFCitaId ;
      AV62Recetamedicawwds_5_tfcitaid_to = AV14TFCitaId_To ;
      AV63Recetamedicawwds_6_tfmedicamentoid = AV15TFMedicamentoId ;
      AV64Recetamedicawwds_7_tfmedicamentoid_to = AV16TFMedicamentoId_To ;
      AV65Recetamedicawwds_8_tfmedicamentocodigo = AV17TFMedicamentoCodigo ;
      AV66Recetamedicawwds_9_tfmedicamentocodigo_sel = AV18TFMedicamentoCodigo_Sel ;
      AV67Recetamedicawwds_10_tfmedicamentonombre = AV19TFMedicamentoNombre ;
      AV68Recetamedicawwds_11_tfmedicamentonombre_sel = AV20TFMedicamentoNombre_Sel ;
      AV69Recetamedicawwds_12_tfmedicamentoformafarm = AV21TFMedicamentoFormaFarm ;
      AV70Recetamedicawwds_13_tfmedicamentoformafarm_sel = AV22TFMedicamentoFormaFarm_Sel ;
      AV71Recetamedicawwds_14_tfrecetamedicaconcentracion = AV23TFRecetaMedicaConcentracion ;
      AV72Recetamedicawwds_15_tfrecetamedicaconcentracion_sel = AV24TFRecetaMedicaConcentracion_Sel ;
      AV73Recetamedicawwds_16_tfrecetamedicacantidad = AV25TFRecetaMedicaCantidad ;
      AV74Recetamedicawwds_17_tfrecetamedicacantidad_to = AV26TFRecetaMedicaCantidad_To ;
      AV75Recetamedicawwds_18_tfrecetamedicaatencion = AV27TFRecetaMedicaAtencion ;
      AV76Recetamedicawwds_19_tfrecetamedicaatencion_sel = AV28TFRecetaMedicaAtencion_Sel ;
      AV77Recetamedicawwds_20_tfrecetamedicaflag = AV31TFRecetaMedicaFlag ;
      AV78Recetamedicawwds_21_tfrecetamedicaflag_to = AV32TFRecetaMedicaFlag_To ;
      AV79Recetamedicawwds_22_tfrecetaindicaciones = AV52TFRecetaIndicaciones ;
      AV80Recetamedicawwds_23_tfrecetaindicaciones_sel = AV53TFRecetaIndicaciones_Sel ;
      pr_default.dynParam(3, new Object[]{ new Object[]{
                                           AV58Recetamedicawwds_1_filterfulltext ,
                                           Short.valueOf(AV59Recetamedicawwds_2_tfrecetamedicaid) ,
                                           Short.valueOf(AV60Recetamedicawwds_3_tfrecetamedicaid_to) ,
                                           Integer.valueOf(AV61Recetamedicawwds_4_tfcitaid) ,
                                           Integer.valueOf(AV62Recetamedicawwds_5_tfcitaid_to) ,
                                           Short.valueOf(AV63Recetamedicawwds_6_tfmedicamentoid) ,
                                           Short.valueOf(AV64Recetamedicawwds_7_tfmedicamentoid_to) ,
                                           AV66Recetamedicawwds_9_tfmedicamentocodigo_sel ,
                                           AV65Recetamedicawwds_8_tfmedicamentocodigo ,
                                           AV68Recetamedicawwds_11_tfmedicamentonombre_sel ,
                                           AV67Recetamedicawwds_10_tfmedicamentonombre ,
                                           AV70Recetamedicawwds_13_tfmedicamentoformafarm_sel ,
                                           AV69Recetamedicawwds_12_tfmedicamentoformafarm ,
                                           AV72Recetamedicawwds_15_tfrecetamedicaconcentracion_sel ,
                                           AV71Recetamedicawwds_14_tfrecetamedicaconcentracion ,
                                           Short.valueOf(AV73Recetamedicawwds_16_tfrecetamedicacantidad) ,
                                           Short.valueOf(AV74Recetamedicawwds_17_tfrecetamedicacantidad_to) ,
                                           AV76Recetamedicawwds_19_tfrecetamedicaatencion_sel ,
                                           AV75Recetamedicawwds_18_tfrecetamedicaatencion ,
                                           Byte.valueOf(AV77Recetamedicawwds_20_tfrecetamedicaflag) ,
                                           Byte.valueOf(AV78Recetamedicawwds_21_tfrecetamedicaflag_to) ,
                                           AV80Recetamedicawwds_23_tfrecetaindicaciones_sel ,
                                           AV79Recetamedicawwds_22_tfrecetaindicaciones ,
                                           Short.valueOf(A50RecetaMedicaId) ,
                                           Integer.valueOf(A19CitaId) ,
                                           Short.valueOf(A42MedicamentoId) ,
                                           A229MedicamentoCodigo ,
                                           A230MedicamentoNombre ,
                                           A231MedicamentoFormaFarm ,
                                           A268RecetaMedicaConcentracion ,
                                           Short.valueOf(A269RecetaMedicaCantidad) ,
                                           A273RecetaMedicaAtencion ,
                                           Byte.valueOf(A272RecetaMedicaFlag) ,
                                           A332RecetaIndicaciones } ,
                                           new int[]{
                                           TypeConstants.STRING, TypeConstants.SHORT, TypeConstants.SHORT, TypeConstants.INT, TypeConstants.INT, TypeConstants.SHORT, TypeConstants.SHORT, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING,
                                           TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.SHORT, TypeConstants.SHORT, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.BYTE,
                                           TypeConstants.BYTE, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.SHORT, TypeConstants.INT, TypeConstants.SHORT, TypeConstants.BOOLEAN, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING,
                                           TypeConstants.BOOLEAN, TypeConstants.STRING, TypeConstants.BOOLEAN, TypeConstants.SHORT, TypeConstants.BOOLEAN, TypeConstants.STRING, TypeConstants.BOOLEAN, TypeConstants.BYTE, TypeConstants.BOOLEAN, TypeConstants.STRING
                                           }
      });
      lV58Recetamedicawwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV58Recetamedicawwds_1_filterfulltext), "%", "") ;
      lV58Recetamedicawwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV58Recetamedicawwds_1_filterfulltext), "%", "") ;
      lV58Recetamedicawwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV58Recetamedicawwds_1_filterfulltext), "%", "") ;
      lV58Recetamedicawwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV58Recetamedicawwds_1_filterfulltext), "%", "") ;
      lV58Recetamedicawwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV58Recetamedicawwds_1_filterfulltext), "%", "") ;
      lV58Recetamedicawwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV58Recetamedicawwds_1_filterfulltext), "%", "") ;
      lV58Recetamedicawwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV58Recetamedicawwds_1_filterfulltext), "%", "") ;
      lV58Recetamedicawwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV58Recetamedicawwds_1_filterfulltext), "%", "") ;
      lV58Recetamedicawwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV58Recetamedicawwds_1_filterfulltext), "%", "") ;
      lV58Recetamedicawwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV58Recetamedicawwds_1_filterfulltext), "%", "") ;
      lV58Recetamedicawwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV58Recetamedicawwds_1_filterfulltext), "%", "") ;
      lV65Recetamedicawwds_8_tfmedicamentocodigo = GXutil.concat( GXutil.rtrim( AV65Recetamedicawwds_8_tfmedicamentocodigo), "%", "") ;
      lV67Recetamedicawwds_10_tfmedicamentonombre = GXutil.concat( GXutil.rtrim( AV67Recetamedicawwds_10_tfmedicamentonombre), "%", "") ;
      lV69Recetamedicawwds_12_tfmedicamentoformafarm = GXutil.concat( GXutil.rtrim( AV69Recetamedicawwds_12_tfmedicamentoformafarm), "%", "") ;
      lV71Recetamedicawwds_14_tfrecetamedicaconcentracion = GXutil.concat( GXutil.rtrim( AV71Recetamedicawwds_14_tfrecetamedicaconcentracion), "%", "") ;
      lV75Recetamedicawwds_18_tfrecetamedicaatencion = GXutil.concat( GXutil.rtrim( AV75Recetamedicawwds_18_tfrecetamedicaatencion), "%", "") ;
      lV79Recetamedicawwds_22_tfrecetaindicaciones = GXutil.concat( GXutil.rtrim( AV79Recetamedicawwds_22_tfrecetaindicaciones), "%", "") ;
      /* Using cursor P003J5 */
      pr_default.execute(3, new Object[] {lV58Recetamedicawwds_1_filterfulltext, lV58Recetamedicawwds_1_filterfulltext, lV58Recetamedicawwds_1_filterfulltext, lV58Recetamedicawwds_1_filterfulltext, lV58Recetamedicawwds_1_filterfulltext, lV58Recetamedicawwds_1_filterfulltext, lV58Recetamedicawwds_1_filterfulltext, lV58Recetamedicawwds_1_filterfulltext, lV58Recetamedicawwds_1_filterfulltext, lV58Recetamedicawwds_1_filterfulltext, lV58Recetamedicawwds_1_filterfulltext, Short.valueOf(AV59Recetamedicawwds_2_tfrecetamedicaid), Short.valueOf(AV60Recetamedicawwds_3_tfrecetamedicaid_to), Integer.valueOf(AV61Recetamedicawwds_4_tfcitaid), Integer.valueOf(AV62Recetamedicawwds_5_tfcitaid_to), Short.valueOf(AV63Recetamedicawwds_6_tfmedicamentoid), Short.valueOf(AV64Recetamedicawwds_7_tfmedicamentoid_to), lV65Recetamedicawwds_8_tfmedicamentocodigo, AV66Recetamedicawwds_9_tfmedicamentocodigo_sel, lV67Recetamedicawwds_10_tfmedicamentonombre, AV68Recetamedicawwds_11_tfmedicamentonombre_sel, lV69Recetamedicawwds_12_tfmedicamentoformafarm, AV70Recetamedicawwds_13_tfmedicamentoformafarm_sel, lV71Recetamedicawwds_14_tfrecetamedicaconcentracion, AV72Recetamedicawwds_15_tfrecetamedicaconcentracion_sel, Short.valueOf(AV73Recetamedicawwds_16_tfrecetamedicacantidad), Short.valueOf(AV74Recetamedicawwds_17_tfrecetamedicacantidad_to), lV75Recetamedicawwds_18_tfrecetamedicaatencion, AV76Recetamedicawwds_19_tfrecetamedicaatencion_sel, Byte.valueOf(AV77Recetamedicawwds_20_tfrecetamedicaflag), Byte.valueOf(AV78Recetamedicawwds_21_tfrecetamedicaflag_to), lV79Recetamedicawwds_22_tfrecetaindicaciones, AV80Recetamedicawwds_23_tfrecetaindicaciones_sel});
      while ( (pr_default.getStatus(3) != 101) )
      {
         brk3J8 = false ;
         A268RecetaMedicaConcentracion = P003J5_A268RecetaMedicaConcentracion[0] ;
         n268RecetaMedicaConcentracion = P003J5_n268RecetaMedicaConcentracion[0] ;
         A272RecetaMedicaFlag = P003J5_A272RecetaMedicaFlag[0] ;
         n272RecetaMedicaFlag = P003J5_n272RecetaMedicaFlag[0] ;
         A269RecetaMedicaCantidad = P003J5_A269RecetaMedicaCantidad[0] ;
         n269RecetaMedicaCantidad = P003J5_n269RecetaMedicaCantidad[0] ;
         A42MedicamentoId = P003J5_A42MedicamentoId[0] ;
         n42MedicamentoId = P003J5_n42MedicamentoId[0] ;
         A19CitaId = P003J5_A19CitaId[0] ;
         A50RecetaMedicaId = P003J5_A50RecetaMedicaId[0] ;
         A332RecetaIndicaciones = P003J5_A332RecetaIndicaciones[0] ;
         A273RecetaMedicaAtencion = P003J5_A273RecetaMedicaAtencion[0] ;
         n273RecetaMedicaAtencion = P003J5_n273RecetaMedicaAtencion[0] ;
         A231MedicamentoFormaFarm = P003J5_A231MedicamentoFormaFarm[0] ;
         n231MedicamentoFormaFarm = P003J5_n231MedicamentoFormaFarm[0] ;
         A230MedicamentoNombre = P003J5_A230MedicamentoNombre[0] ;
         A229MedicamentoCodigo = P003J5_A229MedicamentoCodigo[0] ;
         A231MedicamentoFormaFarm = P003J5_A231MedicamentoFormaFarm[0] ;
         n231MedicamentoFormaFarm = P003J5_n231MedicamentoFormaFarm[0] ;
         A230MedicamentoNombre = P003J5_A230MedicamentoNombre[0] ;
         A229MedicamentoCodigo = P003J5_A229MedicamentoCodigo[0] ;
         AV45count = 0 ;
         while ( (pr_default.getStatus(3) != 101) && ( GXutil.strcmp(P003J5_A268RecetaMedicaConcentracion[0], A268RecetaMedicaConcentracion) == 0 ) )
         {
            brk3J8 = false ;
            A50RecetaMedicaId = P003J5_A50RecetaMedicaId[0] ;
            AV45count = (long)(AV45count+1) ;
            brk3J8 = true ;
            pr_default.readNext(3);
         }
         if ( ! (GXutil.strcmp("", A268RecetaMedicaConcentracion)==0) )
         {
            AV37Option = A268RecetaMedicaConcentracion ;
            AV38Options.add(AV37Option, 0);
            AV43OptionIndexes.add(GXutil.trim( localUtil.format( DecimalUtil.doubleToDec(AV45count), "Z,ZZZ,ZZZ,ZZ9")), 0);
         }
         if ( AV38Options.size() == 50 )
         {
            /* Exit For each command. Update data (if necessary), close cursors & exit. */
            if (true) break;
         }
         if ( ! brk3J8 )
         {
            brk3J8 = true ;
            pr_default.readNext(3);
         }
      }
      pr_default.close(3);
   }

   public void S161( )
   {
      /* 'LOADRECETAMEDICAATENCIONOPTIONS' Routine */
      returnInSub = false ;
      AV27TFRecetaMedicaAtencion = AV33SearchTxt ;
      AV28TFRecetaMedicaAtencion_Sel = "" ;
      AV58Recetamedicawwds_1_filterfulltext = AV51FilterFullText ;
      AV59Recetamedicawwds_2_tfrecetamedicaid = AV11TFRecetaMedicaId ;
      AV60Recetamedicawwds_3_tfrecetamedicaid_to = AV12TFRecetaMedicaId_To ;
      AV61Recetamedicawwds_4_tfcitaid = AV13TFCitaId ;
      AV62Recetamedicawwds_5_tfcitaid_to = AV14TFCitaId_To ;
      AV63Recetamedicawwds_6_tfmedicamentoid = AV15TFMedicamentoId ;
      AV64Recetamedicawwds_7_tfmedicamentoid_to = AV16TFMedicamentoId_To ;
      AV65Recetamedicawwds_8_tfmedicamentocodigo = AV17TFMedicamentoCodigo ;
      AV66Recetamedicawwds_9_tfmedicamentocodigo_sel = AV18TFMedicamentoCodigo_Sel ;
      AV67Recetamedicawwds_10_tfmedicamentonombre = AV19TFMedicamentoNombre ;
      AV68Recetamedicawwds_11_tfmedicamentonombre_sel = AV20TFMedicamentoNombre_Sel ;
      AV69Recetamedicawwds_12_tfmedicamentoformafarm = AV21TFMedicamentoFormaFarm ;
      AV70Recetamedicawwds_13_tfmedicamentoformafarm_sel = AV22TFMedicamentoFormaFarm_Sel ;
      AV71Recetamedicawwds_14_tfrecetamedicaconcentracion = AV23TFRecetaMedicaConcentracion ;
      AV72Recetamedicawwds_15_tfrecetamedicaconcentracion_sel = AV24TFRecetaMedicaConcentracion_Sel ;
      AV73Recetamedicawwds_16_tfrecetamedicacantidad = AV25TFRecetaMedicaCantidad ;
      AV74Recetamedicawwds_17_tfrecetamedicacantidad_to = AV26TFRecetaMedicaCantidad_To ;
      AV75Recetamedicawwds_18_tfrecetamedicaatencion = AV27TFRecetaMedicaAtencion ;
      AV76Recetamedicawwds_19_tfrecetamedicaatencion_sel = AV28TFRecetaMedicaAtencion_Sel ;
      AV77Recetamedicawwds_20_tfrecetamedicaflag = AV31TFRecetaMedicaFlag ;
      AV78Recetamedicawwds_21_tfrecetamedicaflag_to = AV32TFRecetaMedicaFlag_To ;
      AV79Recetamedicawwds_22_tfrecetaindicaciones = AV52TFRecetaIndicaciones ;
      AV80Recetamedicawwds_23_tfrecetaindicaciones_sel = AV53TFRecetaIndicaciones_Sel ;
      pr_default.dynParam(4, new Object[]{ new Object[]{
                                           AV58Recetamedicawwds_1_filterfulltext ,
                                           Short.valueOf(AV59Recetamedicawwds_2_tfrecetamedicaid) ,
                                           Short.valueOf(AV60Recetamedicawwds_3_tfrecetamedicaid_to) ,
                                           Integer.valueOf(AV61Recetamedicawwds_4_tfcitaid) ,
                                           Integer.valueOf(AV62Recetamedicawwds_5_tfcitaid_to) ,
                                           Short.valueOf(AV63Recetamedicawwds_6_tfmedicamentoid) ,
                                           Short.valueOf(AV64Recetamedicawwds_7_tfmedicamentoid_to) ,
                                           AV66Recetamedicawwds_9_tfmedicamentocodigo_sel ,
                                           AV65Recetamedicawwds_8_tfmedicamentocodigo ,
                                           AV68Recetamedicawwds_11_tfmedicamentonombre_sel ,
                                           AV67Recetamedicawwds_10_tfmedicamentonombre ,
                                           AV70Recetamedicawwds_13_tfmedicamentoformafarm_sel ,
                                           AV69Recetamedicawwds_12_tfmedicamentoformafarm ,
                                           AV72Recetamedicawwds_15_tfrecetamedicaconcentracion_sel ,
                                           AV71Recetamedicawwds_14_tfrecetamedicaconcentracion ,
                                           Short.valueOf(AV73Recetamedicawwds_16_tfrecetamedicacantidad) ,
                                           Short.valueOf(AV74Recetamedicawwds_17_tfrecetamedicacantidad_to) ,
                                           AV76Recetamedicawwds_19_tfrecetamedicaatencion_sel ,
                                           AV75Recetamedicawwds_18_tfrecetamedicaatencion ,
                                           Byte.valueOf(AV77Recetamedicawwds_20_tfrecetamedicaflag) ,
                                           Byte.valueOf(AV78Recetamedicawwds_21_tfrecetamedicaflag_to) ,
                                           AV80Recetamedicawwds_23_tfrecetaindicaciones_sel ,
                                           AV79Recetamedicawwds_22_tfrecetaindicaciones ,
                                           Short.valueOf(A50RecetaMedicaId) ,
                                           Integer.valueOf(A19CitaId) ,
                                           Short.valueOf(A42MedicamentoId) ,
                                           A229MedicamentoCodigo ,
                                           A230MedicamentoNombre ,
                                           A231MedicamentoFormaFarm ,
                                           A268RecetaMedicaConcentracion ,
                                           Short.valueOf(A269RecetaMedicaCantidad) ,
                                           A273RecetaMedicaAtencion ,
                                           Byte.valueOf(A272RecetaMedicaFlag) ,
                                           A332RecetaIndicaciones } ,
                                           new int[]{
                                           TypeConstants.STRING, TypeConstants.SHORT, TypeConstants.SHORT, TypeConstants.INT, TypeConstants.INT, TypeConstants.SHORT, TypeConstants.SHORT, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING,
                                           TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.SHORT, TypeConstants.SHORT, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.BYTE,
                                           TypeConstants.BYTE, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.SHORT, TypeConstants.INT, TypeConstants.SHORT, TypeConstants.BOOLEAN, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING,
                                           TypeConstants.BOOLEAN, TypeConstants.STRING, TypeConstants.BOOLEAN, TypeConstants.SHORT, TypeConstants.BOOLEAN, TypeConstants.STRING, TypeConstants.BOOLEAN, TypeConstants.BYTE, TypeConstants.BOOLEAN, TypeConstants.STRING
                                           }
      });
      lV58Recetamedicawwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV58Recetamedicawwds_1_filterfulltext), "%", "") ;
      lV58Recetamedicawwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV58Recetamedicawwds_1_filterfulltext), "%", "") ;
      lV58Recetamedicawwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV58Recetamedicawwds_1_filterfulltext), "%", "") ;
      lV58Recetamedicawwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV58Recetamedicawwds_1_filterfulltext), "%", "") ;
      lV58Recetamedicawwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV58Recetamedicawwds_1_filterfulltext), "%", "") ;
      lV58Recetamedicawwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV58Recetamedicawwds_1_filterfulltext), "%", "") ;
      lV58Recetamedicawwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV58Recetamedicawwds_1_filterfulltext), "%", "") ;
      lV58Recetamedicawwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV58Recetamedicawwds_1_filterfulltext), "%", "") ;
      lV58Recetamedicawwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV58Recetamedicawwds_1_filterfulltext), "%", "") ;
      lV58Recetamedicawwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV58Recetamedicawwds_1_filterfulltext), "%", "") ;
      lV58Recetamedicawwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV58Recetamedicawwds_1_filterfulltext), "%", "") ;
      lV65Recetamedicawwds_8_tfmedicamentocodigo = GXutil.concat( GXutil.rtrim( AV65Recetamedicawwds_8_tfmedicamentocodigo), "%", "") ;
      lV67Recetamedicawwds_10_tfmedicamentonombre = GXutil.concat( GXutil.rtrim( AV67Recetamedicawwds_10_tfmedicamentonombre), "%", "") ;
      lV69Recetamedicawwds_12_tfmedicamentoformafarm = GXutil.concat( GXutil.rtrim( AV69Recetamedicawwds_12_tfmedicamentoformafarm), "%", "") ;
      lV71Recetamedicawwds_14_tfrecetamedicaconcentracion = GXutil.concat( GXutil.rtrim( AV71Recetamedicawwds_14_tfrecetamedicaconcentracion), "%", "") ;
      lV75Recetamedicawwds_18_tfrecetamedicaatencion = GXutil.concat( GXutil.rtrim( AV75Recetamedicawwds_18_tfrecetamedicaatencion), "%", "") ;
      lV79Recetamedicawwds_22_tfrecetaindicaciones = GXutil.concat( GXutil.rtrim( AV79Recetamedicawwds_22_tfrecetaindicaciones), "%", "") ;
      /* Using cursor P003J6 */
      pr_default.execute(4, new Object[] {lV58Recetamedicawwds_1_filterfulltext, lV58Recetamedicawwds_1_filterfulltext, lV58Recetamedicawwds_1_filterfulltext, lV58Recetamedicawwds_1_filterfulltext, lV58Recetamedicawwds_1_filterfulltext, lV58Recetamedicawwds_1_filterfulltext, lV58Recetamedicawwds_1_filterfulltext, lV58Recetamedicawwds_1_filterfulltext, lV58Recetamedicawwds_1_filterfulltext, lV58Recetamedicawwds_1_filterfulltext, lV58Recetamedicawwds_1_filterfulltext, Short.valueOf(AV59Recetamedicawwds_2_tfrecetamedicaid), Short.valueOf(AV60Recetamedicawwds_3_tfrecetamedicaid_to), Integer.valueOf(AV61Recetamedicawwds_4_tfcitaid), Integer.valueOf(AV62Recetamedicawwds_5_tfcitaid_to), Short.valueOf(AV63Recetamedicawwds_6_tfmedicamentoid), Short.valueOf(AV64Recetamedicawwds_7_tfmedicamentoid_to), lV65Recetamedicawwds_8_tfmedicamentocodigo, AV66Recetamedicawwds_9_tfmedicamentocodigo_sel, lV67Recetamedicawwds_10_tfmedicamentonombre, AV68Recetamedicawwds_11_tfmedicamentonombre_sel, lV69Recetamedicawwds_12_tfmedicamentoformafarm, AV70Recetamedicawwds_13_tfmedicamentoformafarm_sel, lV71Recetamedicawwds_14_tfrecetamedicaconcentracion, AV72Recetamedicawwds_15_tfrecetamedicaconcentracion_sel, Short.valueOf(AV73Recetamedicawwds_16_tfrecetamedicacantidad), Short.valueOf(AV74Recetamedicawwds_17_tfrecetamedicacantidad_to), lV75Recetamedicawwds_18_tfrecetamedicaatencion, AV76Recetamedicawwds_19_tfrecetamedicaatencion_sel, Byte.valueOf(AV77Recetamedicawwds_20_tfrecetamedicaflag), Byte.valueOf(AV78Recetamedicawwds_21_tfrecetamedicaflag_to), lV79Recetamedicawwds_22_tfrecetaindicaciones, AV80Recetamedicawwds_23_tfrecetaindicaciones_sel});
      while ( (pr_default.getStatus(4) != 101) )
      {
         brk3J10 = false ;
         A273RecetaMedicaAtencion = P003J6_A273RecetaMedicaAtencion[0] ;
         n273RecetaMedicaAtencion = P003J6_n273RecetaMedicaAtencion[0] ;
         A272RecetaMedicaFlag = P003J6_A272RecetaMedicaFlag[0] ;
         n272RecetaMedicaFlag = P003J6_n272RecetaMedicaFlag[0] ;
         A269RecetaMedicaCantidad = P003J6_A269RecetaMedicaCantidad[0] ;
         n269RecetaMedicaCantidad = P003J6_n269RecetaMedicaCantidad[0] ;
         A42MedicamentoId = P003J6_A42MedicamentoId[0] ;
         n42MedicamentoId = P003J6_n42MedicamentoId[0] ;
         A19CitaId = P003J6_A19CitaId[0] ;
         A50RecetaMedicaId = P003J6_A50RecetaMedicaId[0] ;
         A332RecetaIndicaciones = P003J6_A332RecetaIndicaciones[0] ;
         A268RecetaMedicaConcentracion = P003J6_A268RecetaMedicaConcentracion[0] ;
         n268RecetaMedicaConcentracion = P003J6_n268RecetaMedicaConcentracion[0] ;
         A231MedicamentoFormaFarm = P003J6_A231MedicamentoFormaFarm[0] ;
         n231MedicamentoFormaFarm = P003J6_n231MedicamentoFormaFarm[0] ;
         A230MedicamentoNombre = P003J6_A230MedicamentoNombre[0] ;
         A229MedicamentoCodigo = P003J6_A229MedicamentoCodigo[0] ;
         A231MedicamentoFormaFarm = P003J6_A231MedicamentoFormaFarm[0] ;
         n231MedicamentoFormaFarm = P003J6_n231MedicamentoFormaFarm[0] ;
         A230MedicamentoNombre = P003J6_A230MedicamentoNombre[0] ;
         A229MedicamentoCodigo = P003J6_A229MedicamentoCodigo[0] ;
         AV45count = 0 ;
         while ( (pr_default.getStatus(4) != 101) && ( GXutil.strcmp(P003J6_A273RecetaMedicaAtencion[0], A273RecetaMedicaAtencion) == 0 ) )
         {
            brk3J10 = false ;
            A50RecetaMedicaId = P003J6_A50RecetaMedicaId[0] ;
            AV45count = (long)(AV45count+1) ;
            brk3J10 = true ;
            pr_default.readNext(4);
         }
         if ( ! (GXutil.strcmp("", A273RecetaMedicaAtencion)==0) )
         {
            AV37Option = A273RecetaMedicaAtencion ;
            AV38Options.add(AV37Option, 0);
            AV43OptionIndexes.add(GXutil.trim( localUtil.format( DecimalUtil.doubleToDec(AV45count), "Z,ZZZ,ZZZ,ZZ9")), 0);
         }
         if ( AV38Options.size() == 50 )
         {
            /* Exit For each command. Update data (if necessary), close cursors & exit. */
            if (true) break;
         }
         if ( ! brk3J10 )
         {
            brk3J10 = true ;
            pr_default.readNext(4);
         }
      }
      pr_default.close(4);
   }

   public void S171( )
   {
      /* 'LOADRECETAINDICACIONESOPTIONS' Routine */
      returnInSub = false ;
      AV52TFRecetaIndicaciones = AV33SearchTxt ;
      AV53TFRecetaIndicaciones_Sel = "" ;
      AV58Recetamedicawwds_1_filterfulltext = AV51FilterFullText ;
      AV59Recetamedicawwds_2_tfrecetamedicaid = AV11TFRecetaMedicaId ;
      AV60Recetamedicawwds_3_tfrecetamedicaid_to = AV12TFRecetaMedicaId_To ;
      AV61Recetamedicawwds_4_tfcitaid = AV13TFCitaId ;
      AV62Recetamedicawwds_5_tfcitaid_to = AV14TFCitaId_To ;
      AV63Recetamedicawwds_6_tfmedicamentoid = AV15TFMedicamentoId ;
      AV64Recetamedicawwds_7_tfmedicamentoid_to = AV16TFMedicamentoId_To ;
      AV65Recetamedicawwds_8_tfmedicamentocodigo = AV17TFMedicamentoCodigo ;
      AV66Recetamedicawwds_9_tfmedicamentocodigo_sel = AV18TFMedicamentoCodigo_Sel ;
      AV67Recetamedicawwds_10_tfmedicamentonombre = AV19TFMedicamentoNombre ;
      AV68Recetamedicawwds_11_tfmedicamentonombre_sel = AV20TFMedicamentoNombre_Sel ;
      AV69Recetamedicawwds_12_tfmedicamentoformafarm = AV21TFMedicamentoFormaFarm ;
      AV70Recetamedicawwds_13_tfmedicamentoformafarm_sel = AV22TFMedicamentoFormaFarm_Sel ;
      AV71Recetamedicawwds_14_tfrecetamedicaconcentracion = AV23TFRecetaMedicaConcentracion ;
      AV72Recetamedicawwds_15_tfrecetamedicaconcentracion_sel = AV24TFRecetaMedicaConcentracion_Sel ;
      AV73Recetamedicawwds_16_tfrecetamedicacantidad = AV25TFRecetaMedicaCantidad ;
      AV74Recetamedicawwds_17_tfrecetamedicacantidad_to = AV26TFRecetaMedicaCantidad_To ;
      AV75Recetamedicawwds_18_tfrecetamedicaatencion = AV27TFRecetaMedicaAtencion ;
      AV76Recetamedicawwds_19_tfrecetamedicaatencion_sel = AV28TFRecetaMedicaAtencion_Sel ;
      AV77Recetamedicawwds_20_tfrecetamedicaflag = AV31TFRecetaMedicaFlag ;
      AV78Recetamedicawwds_21_tfrecetamedicaflag_to = AV32TFRecetaMedicaFlag_To ;
      AV79Recetamedicawwds_22_tfrecetaindicaciones = AV52TFRecetaIndicaciones ;
      AV80Recetamedicawwds_23_tfrecetaindicaciones_sel = AV53TFRecetaIndicaciones_Sel ;
      pr_default.dynParam(5, new Object[]{ new Object[]{
                                           AV58Recetamedicawwds_1_filterfulltext ,
                                           Short.valueOf(AV59Recetamedicawwds_2_tfrecetamedicaid) ,
                                           Short.valueOf(AV60Recetamedicawwds_3_tfrecetamedicaid_to) ,
                                           Integer.valueOf(AV61Recetamedicawwds_4_tfcitaid) ,
                                           Integer.valueOf(AV62Recetamedicawwds_5_tfcitaid_to) ,
                                           Short.valueOf(AV63Recetamedicawwds_6_tfmedicamentoid) ,
                                           Short.valueOf(AV64Recetamedicawwds_7_tfmedicamentoid_to) ,
                                           AV66Recetamedicawwds_9_tfmedicamentocodigo_sel ,
                                           AV65Recetamedicawwds_8_tfmedicamentocodigo ,
                                           AV68Recetamedicawwds_11_tfmedicamentonombre_sel ,
                                           AV67Recetamedicawwds_10_tfmedicamentonombre ,
                                           AV70Recetamedicawwds_13_tfmedicamentoformafarm_sel ,
                                           AV69Recetamedicawwds_12_tfmedicamentoformafarm ,
                                           AV72Recetamedicawwds_15_tfrecetamedicaconcentracion_sel ,
                                           AV71Recetamedicawwds_14_tfrecetamedicaconcentracion ,
                                           Short.valueOf(AV73Recetamedicawwds_16_tfrecetamedicacantidad) ,
                                           Short.valueOf(AV74Recetamedicawwds_17_tfrecetamedicacantidad_to) ,
                                           AV76Recetamedicawwds_19_tfrecetamedicaatencion_sel ,
                                           AV75Recetamedicawwds_18_tfrecetamedicaatencion ,
                                           Byte.valueOf(AV77Recetamedicawwds_20_tfrecetamedicaflag) ,
                                           Byte.valueOf(AV78Recetamedicawwds_21_tfrecetamedicaflag_to) ,
                                           AV80Recetamedicawwds_23_tfrecetaindicaciones_sel ,
                                           AV79Recetamedicawwds_22_tfrecetaindicaciones ,
                                           Short.valueOf(A50RecetaMedicaId) ,
                                           Integer.valueOf(A19CitaId) ,
                                           Short.valueOf(A42MedicamentoId) ,
                                           A229MedicamentoCodigo ,
                                           A230MedicamentoNombre ,
                                           A231MedicamentoFormaFarm ,
                                           A268RecetaMedicaConcentracion ,
                                           Short.valueOf(A269RecetaMedicaCantidad) ,
                                           A273RecetaMedicaAtencion ,
                                           Byte.valueOf(A272RecetaMedicaFlag) ,
                                           A332RecetaIndicaciones } ,
                                           new int[]{
                                           TypeConstants.STRING, TypeConstants.SHORT, TypeConstants.SHORT, TypeConstants.INT, TypeConstants.INT, TypeConstants.SHORT, TypeConstants.SHORT, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING,
                                           TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.SHORT, TypeConstants.SHORT, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.BYTE,
                                           TypeConstants.BYTE, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.SHORT, TypeConstants.INT, TypeConstants.SHORT, TypeConstants.BOOLEAN, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING,
                                           TypeConstants.BOOLEAN, TypeConstants.STRING, TypeConstants.BOOLEAN, TypeConstants.SHORT, TypeConstants.BOOLEAN, TypeConstants.STRING, TypeConstants.BOOLEAN, TypeConstants.BYTE, TypeConstants.BOOLEAN, TypeConstants.STRING
                                           }
      });
      lV58Recetamedicawwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV58Recetamedicawwds_1_filterfulltext), "%", "") ;
      lV58Recetamedicawwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV58Recetamedicawwds_1_filterfulltext), "%", "") ;
      lV58Recetamedicawwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV58Recetamedicawwds_1_filterfulltext), "%", "") ;
      lV58Recetamedicawwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV58Recetamedicawwds_1_filterfulltext), "%", "") ;
      lV58Recetamedicawwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV58Recetamedicawwds_1_filterfulltext), "%", "") ;
      lV58Recetamedicawwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV58Recetamedicawwds_1_filterfulltext), "%", "") ;
      lV58Recetamedicawwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV58Recetamedicawwds_1_filterfulltext), "%", "") ;
      lV58Recetamedicawwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV58Recetamedicawwds_1_filterfulltext), "%", "") ;
      lV58Recetamedicawwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV58Recetamedicawwds_1_filterfulltext), "%", "") ;
      lV58Recetamedicawwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV58Recetamedicawwds_1_filterfulltext), "%", "") ;
      lV58Recetamedicawwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV58Recetamedicawwds_1_filterfulltext), "%", "") ;
      lV65Recetamedicawwds_8_tfmedicamentocodigo = GXutil.concat( GXutil.rtrim( AV65Recetamedicawwds_8_tfmedicamentocodigo), "%", "") ;
      lV67Recetamedicawwds_10_tfmedicamentonombre = GXutil.concat( GXutil.rtrim( AV67Recetamedicawwds_10_tfmedicamentonombre), "%", "") ;
      lV69Recetamedicawwds_12_tfmedicamentoformafarm = GXutil.concat( GXutil.rtrim( AV69Recetamedicawwds_12_tfmedicamentoformafarm), "%", "") ;
      lV71Recetamedicawwds_14_tfrecetamedicaconcentracion = GXutil.concat( GXutil.rtrim( AV71Recetamedicawwds_14_tfrecetamedicaconcentracion), "%", "") ;
      lV75Recetamedicawwds_18_tfrecetamedicaatencion = GXutil.concat( GXutil.rtrim( AV75Recetamedicawwds_18_tfrecetamedicaatencion), "%", "") ;
      lV79Recetamedicawwds_22_tfrecetaindicaciones = GXutil.concat( GXutil.rtrim( AV79Recetamedicawwds_22_tfrecetaindicaciones), "%", "") ;
      /* Using cursor P003J7 */
      pr_default.execute(5, new Object[] {lV58Recetamedicawwds_1_filterfulltext, lV58Recetamedicawwds_1_filterfulltext, lV58Recetamedicawwds_1_filterfulltext, lV58Recetamedicawwds_1_filterfulltext, lV58Recetamedicawwds_1_filterfulltext, lV58Recetamedicawwds_1_filterfulltext, lV58Recetamedicawwds_1_filterfulltext, lV58Recetamedicawwds_1_filterfulltext, lV58Recetamedicawwds_1_filterfulltext, lV58Recetamedicawwds_1_filterfulltext, lV58Recetamedicawwds_1_filterfulltext, Short.valueOf(AV59Recetamedicawwds_2_tfrecetamedicaid), Short.valueOf(AV60Recetamedicawwds_3_tfrecetamedicaid_to), Integer.valueOf(AV61Recetamedicawwds_4_tfcitaid), Integer.valueOf(AV62Recetamedicawwds_5_tfcitaid_to), Short.valueOf(AV63Recetamedicawwds_6_tfmedicamentoid), Short.valueOf(AV64Recetamedicawwds_7_tfmedicamentoid_to), lV65Recetamedicawwds_8_tfmedicamentocodigo, AV66Recetamedicawwds_9_tfmedicamentocodigo_sel, lV67Recetamedicawwds_10_tfmedicamentonombre, AV68Recetamedicawwds_11_tfmedicamentonombre_sel, lV69Recetamedicawwds_12_tfmedicamentoformafarm, AV70Recetamedicawwds_13_tfmedicamentoformafarm_sel, lV71Recetamedicawwds_14_tfrecetamedicaconcentracion, AV72Recetamedicawwds_15_tfrecetamedicaconcentracion_sel, Short.valueOf(AV73Recetamedicawwds_16_tfrecetamedicacantidad), Short.valueOf(AV74Recetamedicawwds_17_tfrecetamedicacantidad_to), lV75Recetamedicawwds_18_tfrecetamedicaatencion, AV76Recetamedicawwds_19_tfrecetamedicaatencion_sel, Byte.valueOf(AV77Recetamedicawwds_20_tfrecetamedicaflag), Byte.valueOf(AV78Recetamedicawwds_21_tfrecetamedicaflag_to), lV79Recetamedicawwds_22_tfrecetaindicaciones, AV80Recetamedicawwds_23_tfrecetaindicaciones_sel});
      while ( (pr_default.getStatus(5) != 101) )
      {
         brk3J12 = false ;
         A332RecetaIndicaciones = P003J7_A332RecetaIndicaciones[0] ;
         A272RecetaMedicaFlag = P003J7_A272RecetaMedicaFlag[0] ;
         n272RecetaMedicaFlag = P003J7_n272RecetaMedicaFlag[0] ;
         A269RecetaMedicaCantidad = P003J7_A269RecetaMedicaCantidad[0] ;
         n269RecetaMedicaCantidad = P003J7_n269RecetaMedicaCantidad[0] ;
         A42MedicamentoId = P003J7_A42MedicamentoId[0] ;
         n42MedicamentoId = P003J7_n42MedicamentoId[0] ;
         A19CitaId = P003J7_A19CitaId[0] ;
         A50RecetaMedicaId = P003J7_A50RecetaMedicaId[0] ;
         A273RecetaMedicaAtencion = P003J7_A273RecetaMedicaAtencion[0] ;
         n273RecetaMedicaAtencion = P003J7_n273RecetaMedicaAtencion[0] ;
         A268RecetaMedicaConcentracion = P003J7_A268RecetaMedicaConcentracion[0] ;
         n268RecetaMedicaConcentracion = P003J7_n268RecetaMedicaConcentracion[0] ;
         A231MedicamentoFormaFarm = P003J7_A231MedicamentoFormaFarm[0] ;
         n231MedicamentoFormaFarm = P003J7_n231MedicamentoFormaFarm[0] ;
         A230MedicamentoNombre = P003J7_A230MedicamentoNombre[0] ;
         A229MedicamentoCodigo = P003J7_A229MedicamentoCodigo[0] ;
         A231MedicamentoFormaFarm = P003J7_A231MedicamentoFormaFarm[0] ;
         n231MedicamentoFormaFarm = P003J7_n231MedicamentoFormaFarm[0] ;
         A230MedicamentoNombre = P003J7_A230MedicamentoNombre[0] ;
         A229MedicamentoCodigo = P003J7_A229MedicamentoCodigo[0] ;
         AV45count = 0 ;
         while ( (pr_default.getStatus(5) != 101) && ( GXutil.strcmp(P003J7_A332RecetaIndicaciones[0], A332RecetaIndicaciones) == 0 ) )
         {
            brk3J12 = false ;
            A50RecetaMedicaId = P003J7_A50RecetaMedicaId[0] ;
            AV45count = (long)(AV45count+1) ;
            brk3J12 = true ;
            pr_default.readNext(5);
         }
         if ( ! (GXutil.strcmp("", A332RecetaIndicaciones)==0) )
         {
            AV37Option = A332RecetaIndicaciones ;
            AV38Options.add(AV37Option, 0);
            AV43OptionIndexes.add(GXutil.trim( localUtil.format( DecimalUtil.doubleToDec(AV45count), "Z,ZZZ,ZZZ,ZZ9")), 0);
         }
         if ( AV38Options.size() == 50 )
         {
            /* Exit For each command. Update data (if necessary), close cursors & exit. */
            if (true) break;
         }
         if ( ! brk3J12 )
         {
            brk3J12 = true ;
            pr_default.readNext(5);
         }
      }
      pr_default.close(5);
   }

   protected void cleanup( )
   {
      this.aP3[0] = recetamedicawwgetfilterdata.this.AV39OptionsJson;
      this.aP4[0] = recetamedicawwgetfilterdata.this.AV42OptionsDescJson;
      this.aP5[0] = recetamedicawwgetfilterdata.this.AV44OptionIndexesJson;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV39OptionsJson = "" ;
      AV42OptionsDescJson = "" ;
      AV44OptionIndexesJson = "" ;
      AV38Options = new GXSimpleCollection<String>(String.class, "internal", "");
      AV41OptionsDesc = new GXSimpleCollection<String>(String.class, "internal", "");
      AV43OptionIndexes = new GXSimpleCollection<String>(String.class, "internal", "");
      GXv_boolean2 = new boolean[1] ;
      AV9WWPContext = new com.projectthani.wwpbaseobjects.SdtWWPContext(remoteHandle, context);
      GXv_SdtWWPContext3 = new com.projectthani.wwpbaseobjects.SdtWWPContext[1] ;
      AV46Session = httpContext.getWebSession();
      AV48GridState = new com.projectthani.wwpbaseobjects.SdtWWPGridState(remoteHandle, context);
      AV49GridStateFilterValue = new com.projectthani.wwpbaseobjects.SdtWWPGridState_FilterValue(remoteHandle, context);
      AV51FilterFullText = "" ;
      AV17TFMedicamentoCodigo = "" ;
      AV18TFMedicamentoCodigo_Sel = "" ;
      AV19TFMedicamentoNombre = "" ;
      AV20TFMedicamentoNombre_Sel = "" ;
      AV21TFMedicamentoFormaFarm = "" ;
      AV22TFMedicamentoFormaFarm_Sel = "" ;
      AV23TFRecetaMedicaConcentracion = "" ;
      AV24TFRecetaMedicaConcentracion_Sel = "" ;
      AV27TFRecetaMedicaAtencion = "" ;
      AV28TFRecetaMedicaAtencion_Sel = "" ;
      AV52TFRecetaIndicaciones = "" ;
      AV53TFRecetaIndicaciones_Sel = "" ;
      A229MedicamentoCodigo = "" ;
      AV58Recetamedicawwds_1_filterfulltext = "" ;
      AV65Recetamedicawwds_8_tfmedicamentocodigo = "" ;
      AV66Recetamedicawwds_9_tfmedicamentocodigo_sel = "" ;
      AV67Recetamedicawwds_10_tfmedicamentonombre = "" ;
      AV68Recetamedicawwds_11_tfmedicamentonombre_sel = "" ;
      AV69Recetamedicawwds_12_tfmedicamentoformafarm = "" ;
      AV70Recetamedicawwds_13_tfmedicamentoformafarm_sel = "" ;
      AV71Recetamedicawwds_14_tfrecetamedicaconcentracion = "" ;
      AV72Recetamedicawwds_15_tfrecetamedicaconcentracion_sel = "" ;
      AV75Recetamedicawwds_18_tfrecetamedicaatencion = "" ;
      AV76Recetamedicawwds_19_tfrecetamedicaatencion_sel = "" ;
      AV79Recetamedicawwds_22_tfrecetaindicaciones = "" ;
      AV80Recetamedicawwds_23_tfrecetaindicaciones_sel = "" ;
      scmdbuf = "" ;
      lV58Recetamedicawwds_1_filterfulltext = "" ;
      lV65Recetamedicawwds_8_tfmedicamentocodigo = "" ;
      lV67Recetamedicawwds_10_tfmedicamentonombre = "" ;
      lV69Recetamedicawwds_12_tfmedicamentoformafarm = "" ;
      lV71Recetamedicawwds_14_tfrecetamedicaconcentracion = "" ;
      lV75Recetamedicawwds_18_tfrecetamedicaatencion = "" ;
      lV79Recetamedicawwds_22_tfrecetaindicaciones = "" ;
      A230MedicamentoNombre = "" ;
      A231MedicamentoFormaFarm = "" ;
      A268RecetaMedicaConcentracion = "" ;
      A273RecetaMedicaAtencion = "" ;
      A332RecetaIndicaciones = "" ;
      P003J2_A42MedicamentoId = new short[1] ;
      P003J2_n42MedicamentoId = new boolean[] {false} ;
      P003J2_A272RecetaMedicaFlag = new byte[1] ;
      P003J2_n272RecetaMedicaFlag = new boolean[] {false} ;
      P003J2_A269RecetaMedicaCantidad = new short[1] ;
      P003J2_n269RecetaMedicaCantidad = new boolean[] {false} ;
      P003J2_A19CitaId = new int[1] ;
      P003J2_A50RecetaMedicaId = new short[1] ;
      P003J2_A332RecetaIndicaciones = new String[] {""} ;
      P003J2_A273RecetaMedicaAtencion = new String[] {""} ;
      P003J2_n273RecetaMedicaAtencion = new boolean[] {false} ;
      P003J2_A268RecetaMedicaConcentracion = new String[] {""} ;
      P003J2_n268RecetaMedicaConcentracion = new boolean[] {false} ;
      P003J2_A231MedicamentoFormaFarm = new String[] {""} ;
      P003J2_n231MedicamentoFormaFarm = new boolean[] {false} ;
      P003J2_A230MedicamentoNombre = new String[] {""} ;
      P003J2_A229MedicamentoCodigo = new String[] {""} ;
      AV37Option = "" ;
      P003J3_A230MedicamentoNombre = new String[] {""} ;
      P003J3_A272RecetaMedicaFlag = new byte[1] ;
      P003J3_n272RecetaMedicaFlag = new boolean[] {false} ;
      P003J3_A269RecetaMedicaCantidad = new short[1] ;
      P003J3_n269RecetaMedicaCantidad = new boolean[] {false} ;
      P003J3_A42MedicamentoId = new short[1] ;
      P003J3_n42MedicamentoId = new boolean[] {false} ;
      P003J3_A19CitaId = new int[1] ;
      P003J3_A50RecetaMedicaId = new short[1] ;
      P003J3_A332RecetaIndicaciones = new String[] {""} ;
      P003J3_A273RecetaMedicaAtencion = new String[] {""} ;
      P003J3_n273RecetaMedicaAtencion = new boolean[] {false} ;
      P003J3_A268RecetaMedicaConcentracion = new String[] {""} ;
      P003J3_n268RecetaMedicaConcentracion = new boolean[] {false} ;
      P003J3_A231MedicamentoFormaFarm = new String[] {""} ;
      P003J3_n231MedicamentoFormaFarm = new boolean[] {false} ;
      P003J3_A229MedicamentoCodigo = new String[] {""} ;
      P003J4_A231MedicamentoFormaFarm = new String[] {""} ;
      P003J4_n231MedicamentoFormaFarm = new boolean[] {false} ;
      P003J4_A272RecetaMedicaFlag = new byte[1] ;
      P003J4_n272RecetaMedicaFlag = new boolean[] {false} ;
      P003J4_A269RecetaMedicaCantidad = new short[1] ;
      P003J4_n269RecetaMedicaCantidad = new boolean[] {false} ;
      P003J4_A42MedicamentoId = new short[1] ;
      P003J4_n42MedicamentoId = new boolean[] {false} ;
      P003J4_A19CitaId = new int[1] ;
      P003J4_A50RecetaMedicaId = new short[1] ;
      P003J4_A332RecetaIndicaciones = new String[] {""} ;
      P003J4_A273RecetaMedicaAtencion = new String[] {""} ;
      P003J4_n273RecetaMedicaAtencion = new boolean[] {false} ;
      P003J4_A268RecetaMedicaConcentracion = new String[] {""} ;
      P003J4_n268RecetaMedicaConcentracion = new boolean[] {false} ;
      P003J4_A230MedicamentoNombre = new String[] {""} ;
      P003J4_A229MedicamentoCodigo = new String[] {""} ;
      P003J5_A268RecetaMedicaConcentracion = new String[] {""} ;
      P003J5_n268RecetaMedicaConcentracion = new boolean[] {false} ;
      P003J5_A272RecetaMedicaFlag = new byte[1] ;
      P003J5_n272RecetaMedicaFlag = new boolean[] {false} ;
      P003J5_A269RecetaMedicaCantidad = new short[1] ;
      P003J5_n269RecetaMedicaCantidad = new boolean[] {false} ;
      P003J5_A42MedicamentoId = new short[1] ;
      P003J5_n42MedicamentoId = new boolean[] {false} ;
      P003J5_A19CitaId = new int[1] ;
      P003J5_A50RecetaMedicaId = new short[1] ;
      P003J5_A332RecetaIndicaciones = new String[] {""} ;
      P003J5_A273RecetaMedicaAtencion = new String[] {""} ;
      P003J5_n273RecetaMedicaAtencion = new boolean[] {false} ;
      P003J5_A231MedicamentoFormaFarm = new String[] {""} ;
      P003J5_n231MedicamentoFormaFarm = new boolean[] {false} ;
      P003J5_A230MedicamentoNombre = new String[] {""} ;
      P003J5_A229MedicamentoCodigo = new String[] {""} ;
      P003J6_A273RecetaMedicaAtencion = new String[] {""} ;
      P003J6_n273RecetaMedicaAtencion = new boolean[] {false} ;
      P003J6_A272RecetaMedicaFlag = new byte[1] ;
      P003J6_n272RecetaMedicaFlag = new boolean[] {false} ;
      P003J6_A269RecetaMedicaCantidad = new short[1] ;
      P003J6_n269RecetaMedicaCantidad = new boolean[] {false} ;
      P003J6_A42MedicamentoId = new short[1] ;
      P003J6_n42MedicamentoId = new boolean[] {false} ;
      P003J6_A19CitaId = new int[1] ;
      P003J6_A50RecetaMedicaId = new short[1] ;
      P003J6_A332RecetaIndicaciones = new String[] {""} ;
      P003J6_A268RecetaMedicaConcentracion = new String[] {""} ;
      P003J6_n268RecetaMedicaConcentracion = new boolean[] {false} ;
      P003J6_A231MedicamentoFormaFarm = new String[] {""} ;
      P003J6_n231MedicamentoFormaFarm = new boolean[] {false} ;
      P003J6_A230MedicamentoNombre = new String[] {""} ;
      P003J6_A229MedicamentoCodigo = new String[] {""} ;
      P003J7_A332RecetaIndicaciones = new String[] {""} ;
      P003J7_A272RecetaMedicaFlag = new byte[1] ;
      P003J7_n272RecetaMedicaFlag = new boolean[] {false} ;
      P003J7_A269RecetaMedicaCantidad = new short[1] ;
      P003J7_n269RecetaMedicaCantidad = new boolean[] {false} ;
      P003J7_A42MedicamentoId = new short[1] ;
      P003J7_n42MedicamentoId = new boolean[] {false} ;
      P003J7_A19CitaId = new int[1] ;
      P003J7_A50RecetaMedicaId = new short[1] ;
      P003J7_A273RecetaMedicaAtencion = new String[] {""} ;
      P003J7_n273RecetaMedicaAtencion = new boolean[] {false} ;
      P003J7_A268RecetaMedicaConcentracion = new String[] {""} ;
      P003J7_n268RecetaMedicaConcentracion = new boolean[] {false} ;
      P003J7_A231MedicamentoFormaFarm = new String[] {""} ;
      P003J7_n231MedicamentoFormaFarm = new boolean[] {false} ;
      P003J7_A230MedicamentoNombre = new String[] {""} ;
      P003J7_A229MedicamentoCodigo = new String[] {""} ;
      pr_default = new DataStoreProvider(context, remoteHandle, new com.projectthani.recetamedicawwgetfilterdata__default(),
         new Object[] {
             new Object[] {
            P003J2_A42MedicamentoId, P003J2_n42MedicamentoId, P003J2_A272RecetaMedicaFlag, P003J2_n272RecetaMedicaFlag, P003J2_A269RecetaMedicaCantidad, P003J2_n269RecetaMedicaCantidad, P003J2_A19CitaId, P003J2_A50RecetaMedicaId, P003J2_A332RecetaIndicaciones, P003J2_A273RecetaMedicaAtencion,
            P003J2_n273RecetaMedicaAtencion, P003J2_A268RecetaMedicaConcentracion, P003J2_n268RecetaMedicaConcentracion, P003J2_A231MedicamentoFormaFarm, P003J2_n231MedicamentoFormaFarm, P003J2_A230MedicamentoNombre, P003J2_A229MedicamentoCodigo
            }
            , new Object[] {
            P003J3_A230MedicamentoNombre, P003J3_A272RecetaMedicaFlag, P003J3_n272RecetaMedicaFlag, P003J3_A269RecetaMedicaCantidad, P003J3_n269RecetaMedicaCantidad, P003J3_A42MedicamentoId, P003J3_n42MedicamentoId, P003J3_A19CitaId, P003J3_A50RecetaMedicaId, P003J3_A332RecetaIndicaciones,
            P003J3_A273RecetaMedicaAtencion, P003J3_n273RecetaMedicaAtencion, P003J3_A268RecetaMedicaConcentracion, P003J3_n268RecetaMedicaConcentracion, P003J3_A231MedicamentoFormaFarm, P003J3_n231MedicamentoFormaFarm, P003J3_A229MedicamentoCodigo
            }
            , new Object[] {
            P003J4_A231MedicamentoFormaFarm, P003J4_n231MedicamentoFormaFarm, P003J4_A272RecetaMedicaFlag, P003J4_n272RecetaMedicaFlag, P003J4_A269RecetaMedicaCantidad, P003J4_n269RecetaMedicaCantidad, P003J4_A42MedicamentoId, P003J4_n42MedicamentoId, P003J4_A19CitaId, P003J4_A50RecetaMedicaId,
            P003J4_A332RecetaIndicaciones, P003J4_A273RecetaMedicaAtencion, P003J4_n273RecetaMedicaAtencion, P003J4_A268RecetaMedicaConcentracion, P003J4_n268RecetaMedicaConcentracion, P003J4_A230MedicamentoNombre, P003J4_A229MedicamentoCodigo
            }
            , new Object[] {
            P003J5_A268RecetaMedicaConcentracion, P003J5_n268RecetaMedicaConcentracion, P003J5_A272RecetaMedicaFlag, P003J5_n272RecetaMedicaFlag, P003J5_A269RecetaMedicaCantidad, P003J5_n269RecetaMedicaCantidad, P003J5_A42MedicamentoId, P003J5_n42MedicamentoId, P003J5_A19CitaId, P003J5_A50RecetaMedicaId,
            P003J5_A332RecetaIndicaciones, P003J5_A273RecetaMedicaAtencion, P003J5_n273RecetaMedicaAtencion, P003J5_A231MedicamentoFormaFarm, P003J5_n231MedicamentoFormaFarm, P003J5_A230MedicamentoNombre, P003J5_A229MedicamentoCodigo
            }
            , new Object[] {
            P003J6_A273RecetaMedicaAtencion, P003J6_n273RecetaMedicaAtencion, P003J6_A272RecetaMedicaFlag, P003J6_n272RecetaMedicaFlag, P003J6_A269RecetaMedicaCantidad, P003J6_n269RecetaMedicaCantidad, P003J6_A42MedicamentoId, P003J6_n42MedicamentoId, P003J6_A19CitaId, P003J6_A50RecetaMedicaId,
            P003J6_A332RecetaIndicaciones, P003J6_A268RecetaMedicaConcentracion, P003J6_n268RecetaMedicaConcentracion, P003J6_A231MedicamentoFormaFarm, P003J6_n231MedicamentoFormaFarm, P003J6_A230MedicamentoNombre, P003J6_A229MedicamentoCodigo
            }
            , new Object[] {
            P003J7_A332RecetaIndicaciones, P003J7_A272RecetaMedicaFlag, P003J7_n272RecetaMedicaFlag, P003J7_A269RecetaMedicaCantidad, P003J7_n269RecetaMedicaCantidad, P003J7_A42MedicamentoId, P003J7_n42MedicamentoId, P003J7_A19CitaId, P003J7_A50RecetaMedicaId, P003J7_A273RecetaMedicaAtencion,
            P003J7_n273RecetaMedicaAtencion, P003J7_A268RecetaMedicaConcentracion, P003J7_n268RecetaMedicaConcentracion, P003J7_A231MedicamentoFormaFarm, P003J7_n231MedicamentoFormaFarm, P003J7_A230MedicamentoNombre, P003J7_A229MedicamentoCodigo
            }
         }
      );
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private byte AV31TFRecetaMedicaFlag ;
   private byte AV32TFRecetaMedicaFlag_To ;
   private byte AV77Recetamedicawwds_20_tfrecetamedicaflag ;
   private byte AV78Recetamedicawwds_21_tfrecetamedicaflag_to ;
   private byte A272RecetaMedicaFlag ;
   private short AV11TFRecetaMedicaId ;
   private short AV12TFRecetaMedicaId_To ;
   private short AV15TFMedicamentoId ;
   private short AV16TFMedicamentoId_To ;
   private short AV25TFRecetaMedicaCantidad ;
   private short AV26TFRecetaMedicaCantidad_To ;
   private short AV59Recetamedicawwds_2_tfrecetamedicaid ;
   private short AV60Recetamedicawwds_3_tfrecetamedicaid_to ;
   private short AV63Recetamedicawwds_6_tfmedicamentoid ;
   private short AV64Recetamedicawwds_7_tfmedicamentoid_to ;
   private short AV73Recetamedicawwds_16_tfrecetamedicacantidad ;
   private short AV74Recetamedicawwds_17_tfrecetamedicacantidad_to ;
   private short A50RecetaMedicaId ;
   private short A42MedicamentoId ;
   private short A269RecetaMedicaCantidad ;
   private short Gx_err ;
   private int AV56GXV1 ;
   private int AV13TFCitaId ;
   private int AV14TFCitaId_To ;
   private int AV61Recetamedicawwds_4_tfcitaid ;
   private int AV62Recetamedicawwds_5_tfcitaid_to ;
   private int A19CitaId ;
   private int AV36InsertIndex ;
   private long AV45count ;
   private String scmdbuf ;
   private boolean AV8IsAuthorized ;
   private boolean GXt_boolean1 ;
   private boolean GXv_boolean2[] ;
   private boolean returnInSub ;
   private boolean brk3J2 ;
   private boolean n42MedicamentoId ;
   private boolean n272RecetaMedicaFlag ;
   private boolean n269RecetaMedicaCantidad ;
   private boolean n273RecetaMedicaAtencion ;
   private boolean n268RecetaMedicaConcentracion ;
   private boolean n231MedicamentoFormaFarm ;
   private boolean brk3J4 ;
   private boolean brk3J6 ;
   private boolean brk3J8 ;
   private boolean brk3J10 ;
   private boolean brk3J12 ;
   private String AV39OptionsJson ;
   private String AV42OptionsDescJson ;
   private String AV44OptionIndexesJson ;
   private String AV35DDOName ;
   private String AV33SearchTxt ;
   private String AV34SearchTxtTo ;
   private String AV51FilterFullText ;
   private String AV17TFMedicamentoCodigo ;
   private String AV18TFMedicamentoCodigo_Sel ;
   private String AV19TFMedicamentoNombre ;
   private String AV20TFMedicamentoNombre_Sel ;
   private String AV21TFMedicamentoFormaFarm ;
   private String AV22TFMedicamentoFormaFarm_Sel ;
   private String AV23TFRecetaMedicaConcentracion ;
   private String AV24TFRecetaMedicaConcentracion_Sel ;
   private String AV27TFRecetaMedicaAtencion ;
   private String AV28TFRecetaMedicaAtencion_Sel ;
   private String AV52TFRecetaIndicaciones ;
   private String AV53TFRecetaIndicaciones_Sel ;
   private String A229MedicamentoCodigo ;
   private String AV58Recetamedicawwds_1_filterfulltext ;
   private String AV65Recetamedicawwds_8_tfmedicamentocodigo ;
   private String AV66Recetamedicawwds_9_tfmedicamentocodigo_sel ;
   private String AV67Recetamedicawwds_10_tfmedicamentonombre ;
   private String AV68Recetamedicawwds_11_tfmedicamentonombre_sel ;
   private String AV69Recetamedicawwds_12_tfmedicamentoformafarm ;
   private String AV70Recetamedicawwds_13_tfmedicamentoformafarm_sel ;
   private String AV71Recetamedicawwds_14_tfrecetamedicaconcentracion ;
   private String AV72Recetamedicawwds_15_tfrecetamedicaconcentracion_sel ;
   private String AV75Recetamedicawwds_18_tfrecetamedicaatencion ;
   private String AV76Recetamedicawwds_19_tfrecetamedicaatencion_sel ;
   private String AV79Recetamedicawwds_22_tfrecetaindicaciones ;
   private String AV80Recetamedicawwds_23_tfrecetaindicaciones_sel ;
   private String lV58Recetamedicawwds_1_filterfulltext ;
   private String lV65Recetamedicawwds_8_tfmedicamentocodigo ;
   private String lV67Recetamedicawwds_10_tfmedicamentonombre ;
   private String lV69Recetamedicawwds_12_tfmedicamentoformafarm ;
   private String lV71Recetamedicawwds_14_tfrecetamedicaconcentracion ;
   private String lV75Recetamedicawwds_18_tfrecetamedicaatencion ;
   private String lV79Recetamedicawwds_22_tfrecetaindicaciones ;
   private String A230MedicamentoNombre ;
   private String A231MedicamentoFormaFarm ;
   private String A268RecetaMedicaConcentracion ;
   private String A273RecetaMedicaAtencion ;
   private String A332RecetaIndicaciones ;
   private String AV37Option ;
   private com.genexus.webpanels.WebSession AV46Session ;
   private String[] aP5 ;
   private String[] aP3 ;
   private String[] aP4 ;
   private IDataStoreProvider pr_default ;
   private short[] P003J2_A42MedicamentoId ;
   private boolean[] P003J2_n42MedicamentoId ;
   private byte[] P003J2_A272RecetaMedicaFlag ;
   private boolean[] P003J2_n272RecetaMedicaFlag ;
   private short[] P003J2_A269RecetaMedicaCantidad ;
   private boolean[] P003J2_n269RecetaMedicaCantidad ;
   private int[] P003J2_A19CitaId ;
   private short[] P003J2_A50RecetaMedicaId ;
   private String[] P003J2_A332RecetaIndicaciones ;
   private String[] P003J2_A273RecetaMedicaAtencion ;
   private boolean[] P003J2_n273RecetaMedicaAtencion ;
   private String[] P003J2_A268RecetaMedicaConcentracion ;
   private boolean[] P003J2_n268RecetaMedicaConcentracion ;
   private String[] P003J2_A231MedicamentoFormaFarm ;
   private boolean[] P003J2_n231MedicamentoFormaFarm ;
   private String[] P003J2_A230MedicamentoNombre ;
   private String[] P003J2_A229MedicamentoCodigo ;
   private String[] P003J3_A230MedicamentoNombre ;
   private byte[] P003J3_A272RecetaMedicaFlag ;
   private boolean[] P003J3_n272RecetaMedicaFlag ;
   private short[] P003J3_A269RecetaMedicaCantidad ;
   private boolean[] P003J3_n269RecetaMedicaCantidad ;
   private short[] P003J3_A42MedicamentoId ;
   private boolean[] P003J3_n42MedicamentoId ;
   private int[] P003J3_A19CitaId ;
   private short[] P003J3_A50RecetaMedicaId ;
   private String[] P003J3_A332RecetaIndicaciones ;
   private String[] P003J3_A273RecetaMedicaAtencion ;
   private boolean[] P003J3_n273RecetaMedicaAtencion ;
   private String[] P003J3_A268RecetaMedicaConcentracion ;
   private boolean[] P003J3_n268RecetaMedicaConcentracion ;
   private String[] P003J3_A231MedicamentoFormaFarm ;
   private boolean[] P003J3_n231MedicamentoFormaFarm ;
   private String[] P003J3_A229MedicamentoCodigo ;
   private String[] P003J4_A231MedicamentoFormaFarm ;
   private boolean[] P003J4_n231MedicamentoFormaFarm ;
   private byte[] P003J4_A272RecetaMedicaFlag ;
   private boolean[] P003J4_n272RecetaMedicaFlag ;
   private short[] P003J4_A269RecetaMedicaCantidad ;
   private boolean[] P003J4_n269RecetaMedicaCantidad ;
   private short[] P003J4_A42MedicamentoId ;
   private boolean[] P003J4_n42MedicamentoId ;
   private int[] P003J4_A19CitaId ;
   private short[] P003J4_A50RecetaMedicaId ;
   private String[] P003J4_A332RecetaIndicaciones ;
   private String[] P003J4_A273RecetaMedicaAtencion ;
   private boolean[] P003J4_n273RecetaMedicaAtencion ;
   private String[] P003J4_A268RecetaMedicaConcentracion ;
   private boolean[] P003J4_n268RecetaMedicaConcentracion ;
   private String[] P003J4_A230MedicamentoNombre ;
   private String[] P003J4_A229MedicamentoCodigo ;
   private String[] P003J5_A268RecetaMedicaConcentracion ;
   private boolean[] P003J5_n268RecetaMedicaConcentracion ;
   private byte[] P003J5_A272RecetaMedicaFlag ;
   private boolean[] P003J5_n272RecetaMedicaFlag ;
   private short[] P003J5_A269RecetaMedicaCantidad ;
   private boolean[] P003J5_n269RecetaMedicaCantidad ;
   private short[] P003J5_A42MedicamentoId ;
   private boolean[] P003J5_n42MedicamentoId ;
   private int[] P003J5_A19CitaId ;
   private short[] P003J5_A50RecetaMedicaId ;
   private String[] P003J5_A332RecetaIndicaciones ;
   private String[] P003J5_A273RecetaMedicaAtencion ;
   private boolean[] P003J5_n273RecetaMedicaAtencion ;
   private String[] P003J5_A231MedicamentoFormaFarm ;
   private boolean[] P003J5_n231MedicamentoFormaFarm ;
   private String[] P003J5_A230MedicamentoNombre ;
   private String[] P003J5_A229MedicamentoCodigo ;
   private String[] P003J6_A273RecetaMedicaAtencion ;
   private boolean[] P003J6_n273RecetaMedicaAtencion ;
   private byte[] P003J6_A272RecetaMedicaFlag ;
   private boolean[] P003J6_n272RecetaMedicaFlag ;
   private short[] P003J6_A269RecetaMedicaCantidad ;
   private boolean[] P003J6_n269RecetaMedicaCantidad ;
   private short[] P003J6_A42MedicamentoId ;
   private boolean[] P003J6_n42MedicamentoId ;
   private int[] P003J6_A19CitaId ;
   private short[] P003J6_A50RecetaMedicaId ;
   private String[] P003J6_A332RecetaIndicaciones ;
   private String[] P003J6_A268RecetaMedicaConcentracion ;
   private boolean[] P003J6_n268RecetaMedicaConcentracion ;
   private String[] P003J6_A231MedicamentoFormaFarm ;
   private boolean[] P003J6_n231MedicamentoFormaFarm ;
   private String[] P003J6_A230MedicamentoNombre ;
   private String[] P003J6_A229MedicamentoCodigo ;
   private String[] P003J7_A332RecetaIndicaciones ;
   private byte[] P003J7_A272RecetaMedicaFlag ;
   private boolean[] P003J7_n272RecetaMedicaFlag ;
   private short[] P003J7_A269RecetaMedicaCantidad ;
   private boolean[] P003J7_n269RecetaMedicaCantidad ;
   private short[] P003J7_A42MedicamentoId ;
   private boolean[] P003J7_n42MedicamentoId ;
   private int[] P003J7_A19CitaId ;
   private short[] P003J7_A50RecetaMedicaId ;
   private String[] P003J7_A273RecetaMedicaAtencion ;
   private boolean[] P003J7_n273RecetaMedicaAtencion ;
   private String[] P003J7_A268RecetaMedicaConcentracion ;
   private boolean[] P003J7_n268RecetaMedicaConcentracion ;
   private String[] P003J7_A231MedicamentoFormaFarm ;
   private boolean[] P003J7_n231MedicamentoFormaFarm ;
   private String[] P003J7_A230MedicamentoNombre ;
   private String[] P003J7_A229MedicamentoCodigo ;
   private GXSimpleCollection<String> AV38Options ;
   private GXSimpleCollection<String> AV41OptionsDesc ;
   private GXSimpleCollection<String> AV43OptionIndexes ;
   private com.projectthani.wwpbaseobjects.SdtWWPContext AV9WWPContext ;
   private com.projectthani.wwpbaseobjects.SdtWWPContext GXv_SdtWWPContext3[] ;
   private com.projectthani.wwpbaseobjects.SdtWWPGridState AV48GridState ;
   private com.projectthani.wwpbaseobjects.SdtWWPGridState_FilterValue AV49GridStateFilterValue ;
}

final  class recetamedicawwgetfilterdata__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   protected Object[] conditional_P003J2( ModelContext context ,
                                          int remoteHandle ,
                                          com.genexus.IHttpContext httpContext ,
                                          String AV58Recetamedicawwds_1_filterfulltext ,
                                          short AV59Recetamedicawwds_2_tfrecetamedicaid ,
                                          short AV60Recetamedicawwds_3_tfrecetamedicaid_to ,
                                          int AV61Recetamedicawwds_4_tfcitaid ,
                                          int AV62Recetamedicawwds_5_tfcitaid_to ,
                                          short AV63Recetamedicawwds_6_tfmedicamentoid ,
                                          short AV64Recetamedicawwds_7_tfmedicamentoid_to ,
                                          String AV66Recetamedicawwds_9_tfmedicamentocodigo_sel ,
                                          String AV65Recetamedicawwds_8_tfmedicamentocodigo ,
                                          String AV68Recetamedicawwds_11_tfmedicamentonombre_sel ,
                                          String AV67Recetamedicawwds_10_tfmedicamentonombre ,
                                          String AV70Recetamedicawwds_13_tfmedicamentoformafarm_sel ,
                                          String AV69Recetamedicawwds_12_tfmedicamentoformafarm ,
                                          String AV72Recetamedicawwds_15_tfrecetamedicaconcentracion_sel ,
                                          String AV71Recetamedicawwds_14_tfrecetamedicaconcentracion ,
                                          short AV73Recetamedicawwds_16_tfrecetamedicacantidad ,
                                          short AV74Recetamedicawwds_17_tfrecetamedicacantidad_to ,
                                          String AV76Recetamedicawwds_19_tfrecetamedicaatencion_sel ,
                                          String AV75Recetamedicawwds_18_tfrecetamedicaatencion ,
                                          byte AV77Recetamedicawwds_20_tfrecetamedicaflag ,
                                          byte AV78Recetamedicawwds_21_tfrecetamedicaflag_to ,
                                          String AV80Recetamedicawwds_23_tfrecetaindicaciones_sel ,
                                          String AV79Recetamedicawwds_22_tfrecetaindicaciones ,
                                          short A50RecetaMedicaId ,
                                          int A19CitaId ,
                                          short A42MedicamentoId ,
                                          String A229MedicamentoCodigo ,
                                          String A230MedicamentoNombre ,
                                          String A231MedicamentoFormaFarm ,
                                          String A268RecetaMedicaConcentracion ,
                                          short A269RecetaMedicaCantidad ,
                                          String A273RecetaMedicaAtencion ,
                                          byte A272RecetaMedicaFlag ,
                                          String A332RecetaIndicaciones )
   {
      java.lang.StringBuffer sWhereString = new java.lang.StringBuffer();
      String scmdbuf;
      byte[] GXv_int4 = new byte[33];
      Object[] GXv_Object5 = new Object[2];
      scmdbuf = "SELECT T1.[MedicamentoId], T1.[RecetaMedicaFlag], T1.[RecetaMedicaCantidad], T1.[CitaId], T1.[RecetaMedicaId], T1.[RecetaIndicaciones], T1.[RecetaMedicaAtencion]," ;
      scmdbuf += " T1.[RecetaMedicaConcentracion], T2.[MedicamentoFormaFarm], T2.[MedicamentoNombre], T2.[MedicamentoCodigo] FROM ([RecetaMedica] T1 LEFT JOIN [Medicamento] T2 ON" ;
      scmdbuf += " T2.[MedicamentoId] = T1.[MedicamentoId])" ;
      if ( ! (GXutil.strcmp("", AV58Recetamedicawwds_1_filterfulltext)==0) )
      {
         addWhere(sWhereString, "(( CONVERT( char(4), CAST(T1.[RecetaMedicaId] AS decimal(4,0))) like '%' + ?) or ( CONVERT( char(8), CAST(T1.[CitaId] AS decimal(8,0))) like '%' + ?) or ( CONVERT( char(4), CAST(T1.[MedicamentoId] AS decimal(4,0))) like '%' + ?) or ( T2.[MedicamentoCodigo] like '%' + ?) or ( T2.[MedicamentoNombre] like '%' + ?) or ( T2.[MedicamentoFormaFarm] like '%' + ?) or ( T1.[RecetaMedicaConcentracion] like '%' + ?) or ( CONVERT( char(4), CAST(T1.[RecetaMedicaCantidad] AS decimal(4,0))) like '%' + ?) or ( T1.[RecetaMedicaAtencion] like '%' + ?) or ( CONVERT( char(1), CAST(T1.[RecetaMedicaFlag] AS decimal(1,0))) like '%' + ?) or ( T1.[RecetaIndicaciones] like '%' + ?))");
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
         GXv_int4[10] = (byte)(1) ;
      }
      if ( ! (0==AV59Recetamedicawwds_2_tfrecetamedicaid) )
      {
         addWhere(sWhereString, "(T1.[RecetaMedicaId] >= ?)");
      }
      else
      {
         GXv_int4[11] = (byte)(1) ;
      }
      if ( ! (0==AV60Recetamedicawwds_3_tfrecetamedicaid_to) )
      {
         addWhere(sWhereString, "(T1.[RecetaMedicaId] <= ?)");
      }
      else
      {
         GXv_int4[12] = (byte)(1) ;
      }
      if ( ! (0==AV61Recetamedicawwds_4_tfcitaid) )
      {
         addWhere(sWhereString, "(T1.[CitaId] >= ?)");
      }
      else
      {
         GXv_int4[13] = (byte)(1) ;
      }
      if ( ! (0==AV62Recetamedicawwds_5_tfcitaid_to) )
      {
         addWhere(sWhereString, "(T1.[CitaId] <= ?)");
      }
      else
      {
         GXv_int4[14] = (byte)(1) ;
      }
      if ( ! (0==AV63Recetamedicawwds_6_tfmedicamentoid) )
      {
         addWhere(sWhereString, "(T1.[MedicamentoId] >= ?)");
      }
      else
      {
         GXv_int4[15] = (byte)(1) ;
      }
      if ( ! (0==AV64Recetamedicawwds_7_tfmedicamentoid_to) )
      {
         addWhere(sWhereString, "(T1.[MedicamentoId] <= ?)");
      }
      else
      {
         GXv_int4[16] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV66Recetamedicawwds_9_tfmedicamentocodigo_sel)==0) && ( ! (GXutil.strcmp("", AV65Recetamedicawwds_8_tfmedicamentocodigo)==0) ) )
      {
         addWhere(sWhereString, "(T2.[MedicamentoCodigo] like ?)");
      }
      else
      {
         GXv_int4[17] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV66Recetamedicawwds_9_tfmedicamentocodigo_sel)==0) )
      {
         addWhere(sWhereString, "(T2.[MedicamentoCodigo] = ?)");
      }
      else
      {
         GXv_int4[18] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV68Recetamedicawwds_11_tfmedicamentonombre_sel)==0) && ( ! (GXutil.strcmp("", AV67Recetamedicawwds_10_tfmedicamentonombre)==0) ) )
      {
         addWhere(sWhereString, "(T2.[MedicamentoNombre] like ?)");
      }
      else
      {
         GXv_int4[19] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV68Recetamedicawwds_11_tfmedicamentonombre_sel)==0) )
      {
         addWhere(sWhereString, "(T2.[MedicamentoNombre] = ?)");
      }
      else
      {
         GXv_int4[20] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV70Recetamedicawwds_13_tfmedicamentoformafarm_sel)==0) && ( ! (GXutil.strcmp("", AV69Recetamedicawwds_12_tfmedicamentoformafarm)==0) ) )
      {
         addWhere(sWhereString, "(T2.[MedicamentoFormaFarm] like ?)");
      }
      else
      {
         GXv_int4[21] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV70Recetamedicawwds_13_tfmedicamentoformafarm_sel)==0) )
      {
         addWhere(sWhereString, "(T2.[MedicamentoFormaFarm] = ?)");
      }
      else
      {
         GXv_int4[22] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV72Recetamedicawwds_15_tfrecetamedicaconcentracion_sel)==0) && ( ! (GXutil.strcmp("", AV71Recetamedicawwds_14_tfrecetamedicaconcentracion)==0) ) )
      {
         addWhere(sWhereString, "(T1.[RecetaMedicaConcentracion] like ?)");
      }
      else
      {
         GXv_int4[23] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV72Recetamedicawwds_15_tfrecetamedicaconcentracion_sel)==0) )
      {
         addWhere(sWhereString, "(T1.[RecetaMedicaConcentracion] = ?)");
      }
      else
      {
         GXv_int4[24] = (byte)(1) ;
      }
      if ( ! (0==AV73Recetamedicawwds_16_tfrecetamedicacantidad) )
      {
         addWhere(sWhereString, "(T1.[RecetaMedicaCantidad] >= ?)");
      }
      else
      {
         GXv_int4[25] = (byte)(1) ;
      }
      if ( ! (0==AV74Recetamedicawwds_17_tfrecetamedicacantidad_to) )
      {
         addWhere(sWhereString, "(T1.[RecetaMedicaCantidad] <= ?)");
      }
      else
      {
         GXv_int4[26] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV76Recetamedicawwds_19_tfrecetamedicaatencion_sel)==0) && ( ! (GXutil.strcmp("", AV75Recetamedicawwds_18_tfrecetamedicaatencion)==0) ) )
      {
         addWhere(sWhereString, "(T1.[RecetaMedicaAtencion] like ?)");
      }
      else
      {
         GXv_int4[27] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV76Recetamedicawwds_19_tfrecetamedicaatencion_sel)==0) )
      {
         addWhere(sWhereString, "(T1.[RecetaMedicaAtencion] = ?)");
      }
      else
      {
         GXv_int4[28] = (byte)(1) ;
      }
      if ( ! (0==AV77Recetamedicawwds_20_tfrecetamedicaflag) )
      {
         addWhere(sWhereString, "(T1.[RecetaMedicaFlag] >= ?)");
      }
      else
      {
         GXv_int4[29] = (byte)(1) ;
      }
      if ( ! (0==AV78Recetamedicawwds_21_tfrecetamedicaflag_to) )
      {
         addWhere(sWhereString, "(T1.[RecetaMedicaFlag] <= ?)");
      }
      else
      {
         GXv_int4[30] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV80Recetamedicawwds_23_tfrecetaindicaciones_sel)==0) && ( ! (GXutil.strcmp("", AV79Recetamedicawwds_22_tfrecetaindicaciones)==0) ) )
      {
         addWhere(sWhereString, "(T1.[RecetaIndicaciones] like ?)");
      }
      else
      {
         GXv_int4[31] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV80Recetamedicawwds_23_tfrecetaindicaciones_sel)==0) )
      {
         addWhere(sWhereString, "(T1.[RecetaIndicaciones] = ?)");
      }
      else
      {
         GXv_int4[32] = (byte)(1) ;
      }
      scmdbuf += sWhereString ;
      scmdbuf += " ORDER BY T1.[MedicamentoId]" ;
      GXv_Object5[0] = scmdbuf ;
      GXv_Object5[1] = GXv_int4 ;
      return GXv_Object5 ;
   }

   protected Object[] conditional_P003J3( ModelContext context ,
                                          int remoteHandle ,
                                          com.genexus.IHttpContext httpContext ,
                                          String AV58Recetamedicawwds_1_filterfulltext ,
                                          short AV59Recetamedicawwds_2_tfrecetamedicaid ,
                                          short AV60Recetamedicawwds_3_tfrecetamedicaid_to ,
                                          int AV61Recetamedicawwds_4_tfcitaid ,
                                          int AV62Recetamedicawwds_5_tfcitaid_to ,
                                          short AV63Recetamedicawwds_6_tfmedicamentoid ,
                                          short AV64Recetamedicawwds_7_tfmedicamentoid_to ,
                                          String AV66Recetamedicawwds_9_tfmedicamentocodigo_sel ,
                                          String AV65Recetamedicawwds_8_tfmedicamentocodigo ,
                                          String AV68Recetamedicawwds_11_tfmedicamentonombre_sel ,
                                          String AV67Recetamedicawwds_10_tfmedicamentonombre ,
                                          String AV70Recetamedicawwds_13_tfmedicamentoformafarm_sel ,
                                          String AV69Recetamedicawwds_12_tfmedicamentoformafarm ,
                                          String AV72Recetamedicawwds_15_tfrecetamedicaconcentracion_sel ,
                                          String AV71Recetamedicawwds_14_tfrecetamedicaconcentracion ,
                                          short AV73Recetamedicawwds_16_tfrecetamedicacantidad ,
                                          short AV74Recetamedicawwds_17_tfrecetamedicacantidad_to ,
                                          String AV76Recetamedicawwds_19_tfrecetamedicaatencion_sel ,
                                          String AV75Recetamedicawwds_18_tfrecetamedicaatencion ,
                                          byte AV77Recetamedicawwds_20_tfrecetamedicaflag ,
                                          byte AV78Recetamedicawwds_21_tfrecetamedicaflag_to ,
                                          String AV80Recetamedicawwds_23_tfrecetaindicaciones_sel ,
                                          String AV79Recetamedicawwds_22_tfrecetaindicaciones ,
                                          short A50RecetaMedicaId ,
                                          int A19CitaId ,
                                          short A42MedicamentoId ,
                                          String A229MedicamentoCodigo ,
                                          String A230MedicamentoNombre ,
                                          String A231MedicamentoFormaFarm ,
                                          String A268RecetaMedicaConcentracion ,
                                          short A269RecetaMedicaCantidad ,
                                          String A273RecetaMedicaAtencion ,
                                          byte A272RecetaMedicaFlag ,
                                          String A332RecetaIndicaciones )
   {
      java.lang.StringBuffer sWhereString = new java.lang.StringBuffer();
      String scmdbuf;
      byte[] GXv_int6 = new byte[33];
      Object[] GXv_Object7 = new Object[2];
      scmdbuf = "SELECT T2.[MedicamentoNombre], T1.[RecetaMedicaFlag], T1.[RecetaMedicaCantidad], T1.[MedicamentoId], T1.[CitaId], T1.[RecetaMedicaId], T1.[RecetaIndicaciones], T1.[RecetaMedicaAtencion]," ;
      scmdbuf += " T1.[RecetaMedicaConcentracion], T2.[MedicamentoFormaFarm], T2.[MedicamentoCodigo] FROM ([RecetaMedica] T1 LEFT JOIN [Medicamento] T2 ON T2.[MedicamentoId] = T1.[MedicamentoId])" ;
      if ( ! (GXutil.strcmp("", AV58Recetamedicawwds_1_filterfulltext)==0) )
      {
         addWhere(sWhereString, "(( CONVERT( char(4), CAST(T1.[RecetaMedicaId] AS decimal(4,0))) like '%' + ?) or ( CONVERT( char(8), CAST(T1.[CitaId] AS decimal(8,0))) like '%' + ?) or ( CONVERT( char(4), CAST(T1.[MedicamentoId] AS decimal(4,0))) like '%' + ?) or ( T2.[MedicamentoCodigo] like '%' + ?) or ( T2.[MedicamentoNombre] like '%' + ?) or ( T2.[MedicamentoFormaFarm] like '%' + ?) or ( T1.[RecetaMedicaConcentracion] like '%' + ?) or ( CONVERT( char(4), CAST(T1.[RecetaMedicaCantidad] AS decimal(4,0))) like '%' + ?) or ( T1.[RecetaMedicaAtencion] like '%' + ?) or ( CONVERT( char(1), CAST(T1.[RecetaMedicaFlag] AS decimal(1,0))) like '%' + ?) or ( T1.[RecetaIndicaciones] like '%' + ?))");
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
         GXv_int6[10] = (byte)(1) ;
      }
      if ( ! (0==AV59Recetamedicawwds_2_tfrecetamedicaid) )
      {
         addWhere(sWhereString, "(T1.[RecetaMedicaId] >= ?)");
      }
      else
      {
         GXv_int6[11] = (byte)(1) ;
      }
      if ( ! (0==AV60Recetamedicawwds_3_tfrecetamedicaid_to) )
      {
         addWhere(sWhereString, "(T1.[RecetaMedicaId] <= ?)");
      }
      else
      {
         GXv_int6[12] = (byte)(1) ;
      }
      if ( ! (0==AV61Recetamedicawwds_4_tfcitaid) )
      {
         addWhere(sWhereString, "(T1.[CitaId] >= ?)");
      }
      else
      {
         GXv_int6[13] = (byte)(1) ;
      }
      if ( ! (0==AV62Recetamedicawwds_5_tfcitaid_to) )
      {
         addWhere(sWhereString, "(T1.[CitaId] <= ?)");
      }
      else
      {
         GXv_int6[14] = (byte)(1) ;
      }
      if ( ! (0==AV63Recetamedicawwds_6_tfmedicamentoid) )
      {
         addWhere(sWhereString, "(T1.[MedicamentoId] >= ?)");
      }
      else
      {
         GXv_int6[15] = (byte)(1) ;
      }
      if ( ! (0==AV64Recetamedicawwds_7_tfmedicamentoid_to) )
      {
         addWhere(sWhereString, "(T1.[MedicamentoId] <= ?)");
      }
      else
      {
         GXv_int6[16] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV66Recetamedicawwds_9_tfmedicamentocodigo_sel)==0) && ( ! (GXutil.strcmp("", AV65Recetamedicawwds_8_tfmedicamentocodigo)==0) ) )
      {
         addWhere(sWhereString, "(T2.[MedicamentoCodigo] like ?)");
      }
      else
      {
         GXv_int6[17] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV66Recetamedicawwds_9_tfmedicamentocodigo_sel)==0) )
      {
         addWhere(sWhereString, "(T2.[MedicamentoCodigo] = ?)");
      }
      else
      {
         GXv_int6[18] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV68Recetamedicawwds_11_tfmedicamentonombre_sel)==0) && ( ! (GXutil.strcmp("", AV67Recetamedicawwds_10_tfmedicamentonombre)==0) ) )
      {
         addWhere(sWhereString, "(T2.[MedicamentoNombre] like ?)");
      }
      else
      {
         GXv_int6[19] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV68Recetamedicawwds_11_tfmedicamentonombre_sel)==0) )
      {
         addWhere(sWhereString, "(T2.[MedicamentoNombre] = ?)");
      }
      else
      {
         GXv_int6[20] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV70Recetamedicawwds_13_tfmedicamentoformafarm_sel)==0) && ( ! (GXutil.strcmp("", AV69Recetamedicawwds_12_tfmedicamentoformafarm)==0) ) )
      {
         addWhere(sWhereString, "(T2.[MedicamentoFormaFarm] like ?)");
      }
      else
      {
         GXv_int6[21] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV70Recetamedicawwds_13_tfmedicamentoformafarm_sel)==0) )
      {
         addWhere(sWhereString, "(T2.[MedicamentoFormaFarm] = ?)");
      }
      else
      {
         GXv_int6[22] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV72Recetamedicawwds_15_tfrecetamedicaconcentracion_sel)==0) && ( ! (GXutil.strcmp("", AV71Recetamedicawwds_14_tfrecetamedicaconcentracion)==0) ) )
      {
         addWhere(sWhereString, "(T1.[RecetaMedicaConcentracion] like ?)");
      }
      else
      {
         GXv_int6[23] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV72Recetamedicawwds_15_tfrecetamedicaconcentracion_sel)==0) )
      {
         addWhere(sWhereString, "(T1.[RecetaMedicaConcentracion] = ?)");
      }
      else
      {
         GXv_int6[24] = (byte)(1) ;
      }
      if ( ! (0==AV73Recetamedicawwds_16_tfrecetamedicacantidad) )
      {
         addWhere(sWhereString, "(T1.[RecetaMedicaCantidad] >= ?)");
      }
      else
      {
         GXv_int6[25] = (byte)(1) ;
      }
      if ( ! (0==AV74Recetamedicawwds_17_tfrecetamedicacantidad_to) )
      {
         addWhere(sWhereString, "(T1.[RecetaMedicaCantidad] <= ?)");
      }
      else
      {
         GXv_int6[26] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV76Recetamedicawwds_19_tfrecetamedicaatencion_sel)==0) && ( ! (GXutil.strcmp("", AV75Recetamedicawwds_18_tfrecetamedicaatencion)==0) ) )
      {
         addWhere(sWhereString, "(T1.[RecetaMedicaAtencion] like ?)");
      }
      else
      {
         GXv_int6[27] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV76Recetamedicawwds_19_tfrecetamedicaatencion_sel)==0) )
      {
         addWhere(sWhereString, "(T1.[RecetaMedicaAtencion] = ?)");
      }
      else
      {
         GXv_int6[28] = (byte)(1) ;
      }
      if ( ! (0==AV77Recetamedicawwds_20_tfrecetamedicaflag) )
      {
         addWhere(sWhereString, "(T1.[RecetaMedicaFlag] >= ?)");
      }
      else
      {
         GXv_int6[29] = (byte)(1) ;
      }
      if ( ! (0==AV78Recetamedicawwds_21_tfrecetamedicaflag_to) )
      {
         addWhere(sWhereString, "(T1.[RecetaMedicaFlag] <= ?)");
      }
      else
      {
         GXv_int6[30] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV80Recetamedicawwds_23_tfrecetaindicaciones_sel)==0) && ( ! (GXutil.strcmp("", AV79Recetamedicawwds_22_tfrecetaindicaciones)==0) ) )
      {
         addWhere(sWhereString, "(T1.[RecetaIndicaciones] like ?)");
      }
      else
      {
         GXv_int6[31] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV80Recetamedicawwds_23_tfrecetaindicaciones_sel)==0) )
      {
         addWhere(sWhereString, "(T1.[RecetaIndicaciones] = ?)");
      }
      else
      {
         GXv_int6[32] = (byte)(1) ;
      }
      scmdbuf += sWhereString ;
      scmdbuf += " ORDER BY T2.[MedicamentoNombre]" ;
      GXv_Object7[0] = scmdbuf ;
      GXv_Object7[1] = GXv_int6 ;
      return GXv_Object7 ;
   }

   protected Object[] conditional_P003J4( ModelContext context ,
                                          int remoteHandle ,
                                          com.genexus.IHttpContext httpContext ,
                                          String AV58Recetamedicawwds_1_filterfulltext ,
                                          short AV59Recetamedicawwds_2_tfrecetamedicaid ,
                                          short AV60Recetamedicawwds_3_tfrecetamedicaid_to ,
                                          int AV61Recetamedicawwds_4_tfcitaid ,
                                          int AV62Recetamedicawwds_5_tfcitaid_to ,
                                          short AV63Recetamedicawwds_6_tfmedicamentoid ,
                                          short AV64Recetamedicawwds_7_tfmedicamentoid_to ,
                                          String AV66Recetamedicawwds_9_tfmedicamentocodigo_sel ,
                                          String AV65Recetamedicawwds_8_tfmedicamentocodigo ,
                                          String AV68Recetamedicawwds_11_tfmedicamentonombre_sel ,
                                          String AV67Recetamedicawwds_10_tfmedicamentonombre ,
                                          String AV70Recetamedicawwds_13_tfmedicamentoformafarm_sel ,
                                          String AV69Recetamedicawwds_12_tfmedicamentoformafarm ,
                                          String AV72Recetamedicawwds_15_tfrecetamedicaconcentracion_sel ,
                                          String AV71Recetamedicawwds_14_tfrecetamedicaconcentracion ,
                                          short AV73Recetamedicawwds_16_tfrecetamedicacantidad ,
                                          short AV74Recetamedicawwds_17_tfrecetamedicacantidad_to ,
                                          String AV76Recetamedicawwds_19_tfrecetamedicaatencion_sel ,
                                          String AV75Recetamedicawwds_18_tfrecetamedicaatencion ,
                                          byte AV77Recetamedicawwds_20_tfrecetamedicaflag ,
                                          byte AV78Recetamedicawwds_21_tfrecetamedicaflag_to ,
                                          String AV80Recetamedicawwds_23_tfrecetaindicaciones_sel ,
                                          String AV79Recetamedicawwds_22_tfrecetaindicaciones ,
                                          short A50RecetaMedicaId ,
                                          int A19CitaId ,
                                          short A42MedicamentoId ,
                                          String A229MedicamentoCodigo ,
                                          String A230MedicamentoNombre ,
                                          String A231MedicamentoFormaFarm ,
                                          String A268RecetaMedicaConcentracion ,
                                          short A269RecetaMedicaCantidad ,
                                          String A273RecetaMedicaAtencion ,
                                          byte A272RecetaMedicaFlag ,
                                          String A332RecetaIndicaciones )
   {
      java.lang.StringBuffer sWhereString = new java.lang.StringBuffer();
      String scmdbuf;
      byte[] GXv_int8 = new byte[33];
      Object[] GXv_Object9 = new Object[2];
      scmdbuf = "SELECT T2.[MedicamentoFormaFarm], T1.[RecetaMedicaFlag], T1.[RecetaMedicaCantidad], T1.[MedicamentoId], T1.[CitaId], T1.[RecetaMedicaId], T1.[RecetaIndicaciones]," ;
      scmdbuf += " T1.[RecetaMedicaAtencion], T1.[RecetaMedicaConcentracion], T2.[MedicamentoNombre], T2.[MedicamentoCodigo] FROM ([RecetaMedica] T1 LEFT JOIN [Medicamento] T2 ON" ;
      scmdbuf += " T2.[MedicamentoId] = T1.[MedicamentoId])" ;
      if ( ! (GXutil.strcmp("", AV58Recetamedicawwds_1_filterfulltext)==0) )
      {
         addWhere(sWhereString, "(( CONVERT( char(4), CAST(T1.[RecetaMedicaId] AS decimal(4,0))) like '%' + ?) or ( CONVERT( char(8), CAST(T1.[CitaId] AS decimal(8,0))) like '%' + ?) or ( CONVERT( char(4), CAST(T1.[MedicamentoId] AS decimal(4,0))) like '%' + ?) or ( T2.[MedicamentoCodigo] like '%' + ?) or ( T2.[MedicamentoNombre] like '%' + ?) or ( T2.[MedicamentoFormaFarm] like '%' + ?) or ( T1.[RecetaMedicaConcentracion] like '%' + ?) or ( CONVERT( char(4), CAST(T1.[RecetaMedicaCantidad] AS decimal(4,0))) like '%' + ?) or ( T1.[RecetaMedicaAtencion] like '%' + ?) or ( CONVERT( char(1), CAST(T1.[RecetaMedicaFlag] AS decimal(1,0))) like '%' + ?) or ( T1.[RecetaIndicaciones] like '%' + ?))");
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
         GXv_int8[10] = (byte)(1) ;
      }
      if ( ! (0==AV59Recetamedicawwds_2_tfrecetamedicaid) )
      {
         addWhere(sWhereString, "(T1.[RecetaMedicaId] >= ?)");
      }
      else
      {
         GXv_int8[11] = (byte)(1) ;
      }
      if ( ! (0==AV60Recetamedicawwds_3_tfrecetamedicaid_to) )
      {
         addWhere(sWhereString, "(T1.[RecetaMedicaId] <= ?)");
      }
      else
      {
         GXv_int8[12] = (byte)(1) ;
      }
      if ( ! (0==AV61Recetamedicawwds_4_tfcitaid) )
      {
         addWhere(sWhereString, "(T1.[CitaId] >= ?)");
      }
      else
      {
         GXv_int8[13] = (byte)(1) ;
      }
      if ( ! (0==AV62Recetamedicawwds_5_tfcitaid_to) )
      {
         addWhere(sWhereString, "(T1.[CitaId] <= ?)");
      }
      else
      {
         GXv_int8[14] = (byte)(1) ;
      }
      if ( ! (0==AV63Recetamedicawwds_6_tfmedicamentoid) )
      {
         addWhere(sWhereString, "(T1.[MedicamentoId] >= ?)");
      }
      else
      {
         GXv_int8[15] = (byte)(1) ;
      }
      if ( ! (0==AV64Recetamedicawwds_7_tfmedicamentoid_to) )
      {
         addWhere(sWhereString, "(T1.[MedicamentoId] <= ?)");
      }
      else
      {
         GXv_int8[16] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV66Recetamedicawwds_9_tfmedicamentocodigo_sel)==0) && ( ! (GXutil.strcmp("", AV65Recetamedicawwds_8_tfmedicamentocodigo)==0) ) )
      {
         addWhere(sWhereString, "(T2.[MedicamentoCodigo] like ?)");
      }
      else
      {
         GXv_int8[17] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV66Recetamedicawwds_9_tfmedicamentocodigo_sel)==0) )
      {
         addWhere(sWhereString, "(T2.[MedicamentoCodigo] = ?)");
      }
      else
      {
         GXv_int8[18] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV68Recetamedicawwds_11_tfmedicamentonombre_sel)==0) && ( ! (GXutil.strcmp("", AV67Recetamedicawwds_10_tfmedicamentonombre)==0) ) )
      {
         addWhere(sWhereString, "(T2.[MedicamentoNombre] like ?)");
      }
      else
      {
         GXv_int8[19] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV68Recetamedicawwds_11_tfmedicamentonombre_sel)==0) )
      {
         addWhere(sWhereString, "(T2.[MedicamentoNombre] = ?)");
      }
      else
      {
         GXv_int8[20] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV70Recetamedicawwds_13_tfmedicamentoformafarm_sel)==0) && ( ! (GXutil.strcmp("", AV69Recetamedicawwds_12_tfmedicamentoformafarm)==0) ) )
      {
         addWhere(sWhereString, "(T2.[MedicamentoFormaFarm] like ?)");
      }
      else
      {
         GXv_int8[21] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV70Recetamedicawwds_13_tfmedicamentoformafarm_sel)==0) )
      {
         addWhere(sWhereString, "(T2.[MedicamentoFormaFarm] = ?)");
      }
      else
      {
         GXv_int8[22] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV72Recetamedicawwds_15_tfrecetamedicaconcentracion_sel)==0) && ( ! (GXutil.strcmp("", AV71Recetamedicawwds_14_tfrecetamedicaconcentracion)==0) ) )
      {
         addWhere(sWhereString, "(T1.[RecetaMedicaConcentracion] like ?)");
      }
      else
      {
         GXv_int8[23] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV72Recetamedicawwds_15_tfrecetamedicaconcentracion_sel)==0) )
      {
         addWhere(sWhereString, "(T1.[RecetaMedicaConcentracion] = ?)");
      }
      else
      {
         GXv_int8[24] = (byte)(1) ;
      }
      if ( ! (0==AV73Recetamedicawwds_16_tfrecetamedicacantidad) )
      {
         addWhere(sWhereString, "(T1.[RecetaMedicaCantidad] >= ?)");
      }
      else
      {
         GXv_int8[25] = (byte)(1) ;
      }
      if ( ! (0==AV74Recetamedicawwds_17_tfrecetamedicacantidad_to) )
      {
         addWhere(sWhereString, "(T1.[RecetaMedicaCantidad] <= ?)");
      }
      else
      {
         GXv_int8[26] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV76Recetamedicawwds_19_tfrecetamedicaatencion_sel)==0) && ( ! (GXutil.strcmp("", AV75Recetamedicawwds_18_tfrecetamedicaatencion)==0) ) )
      {
         addWhere(sWhereString, "(T1.[RecetaMedicaAtencion] like ?)");
      }
      else
      {
         GXv_int8[27] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV76Recetamedicawwds_19_tfrecetamedicaatencion_sel)==0) )
      {
         addWhere(sWhereString, "(T1.[RecetaMedicaAtencion] = ?)");
      }
      else
      {
         GXv_int8[28] = (byte)(1) ;
      }
      if ( ! (0==AV77Recetamedicawwds_20_tfrecetamedicaflag) )
      {
         addWhere(sWhereString, "(T1.[RecetaMedicaFlag] >= ?)");
      }
      else
      {
         GXv_int8[29] = (byte)(1) ;
      }
      if ( ! (0==AV78Recetamedicawwds_21_tfrecetamedicaflag_to) )
      {
         addWhere(sWhereString, "(T1.[RecetaMedicaFlag] <= ?)");
      }
      else
      {
         GXv_int8[30] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV80Recetamedicawwds_23_tfrecetaindicaciones_sel)==0) && ( ! (GXutil.strcmp("", AV79Recetamedicawwds_22_tfrecetaindicaciones)==0) ) )
      {
         addWhere(sWhereString, "(T1.[RecetaIndicaciones] like ?)");
      }
      else
      {
         GXv_int8[31] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV80Recetamedicawwds_23_tfrecetaindicaciones_sel)==0) )
      {
         addWhere(sWhereString, "(T1.[RecetaIndicaciones] = ?)");
      }
      else
      {
         GXv_int8[32] = (byte)(1) ;
      }
      scmdbuf += sWhereString ;
      scmdbuf += " ORDER BY T2.[MedicamentoFormaFarm]" ;
      GXv_Object9[0] = scmdbuf ;
      GXv_Object9[1] = GXv_int8 ;
      return GXv_Object9 ;
   }

   protected Object[] conditional_P003J5( ModelContext context ,
                                          int remoteHandle ,
                                          com.genexus.IHttpContext httpContext ,
                                          String AV58Recetamedicawwds_1_filterfulltext ,
                                          short AV59Recetamedicawwds_2_tfrecetamedicaid ,
                                          short AV60Recetamedicawwds_3_tfrecetamedicaid_to ,
                                          int AV61Recetamedicawwds_4_tfcitaid ,
                                          int AV62Recetamedicawwds_5_tfcitaid_to ,
                                          short AV63Recetamedicawwds_6_tfmedicamentoid ,
                                          short AV64Recetamedicawwds_7_tfmedicamentoid_to ,
                                          String AV66Recetamedicawwds_9_tfmedicamentocodigo_sel ,
                                          String AV65Recetamedicawwds_8_tfmedicamentocodigo ,
                                          String AV68Recetamedicawwds_11_tfmedicamentonombre_sel ,
                                          String AV67Recetamedicawwds_10_tfmedicamentonombre ,
                                          String AV70Recetamedicawwds_13_tfmedicamentoformafarm_sel ,
                                          String AV69Recetamedicawwds_12_tfmedicamentoformafarm ,
                                          String AV72Recetamedicawwds_15_tfrecetamedicaconcentracion_sel ,
                                          String AV71Recetamedicawwds_14_tfrecetamedicaconcentracion ,
                                          short AV73Recetamedicawwds_16_tfrecetamedicacantidad ,
                                          short AV74Recetamedicawwds_17_tfrecetamedicacantidad_to ,
                                          String AV76Recetamedicawwds_19_tfrecetamedicaatencion_sel ,
                                          String AV75Recetamedicawwds_18_tfrecetamedicaatencion ,
                                          byte AV77Recetamedicawwds_20_tfrecetamedicaflag ,
                                          byte AV78Recetamedicawwds_21_tfrecetamedicaflag_to ,
                                          String AV80Recetamedicawwds_23_tfrecetaindicaciones_sel ,
                                          String AV79Recetamedicawwds_22_tfrecetaindicaciones ,
                                          short A50RecetaMedicaId ,
                                          int A19CitaId ,
                                          short A42MedicamentoId ,
                                          String A229MedicamentoCodigo ,
                                          String A230MedicamentoNombre ,
                                          String A231MedicamentoFormaFarm ,
                                          String A268RecetaMedicaConcentracion ,
                                          short A269RecetaMedicaCantidad ,
                                          String A273RecetaMedicaAtencion ,
                                          byte A272RecetaMedicaFlag ,
                                          String A332RecetaIndicaciones )
   {
      java.lang.StringBuffer sWhereString = new java.lang.StringBuffer();
      String scmdbuf;
      byte[] GXv_int10 = new byte[33];
      Object[] GXv_Object11 = new Object[2];
      scmdbuf = "SELECT T1.[RecetaMedicaConcentracion], T1.[RecetaMedicaFlag], T1.[RecetaMedicaCantidad], T1.[MedicamentoId], T1.[CitaId], T1.[RecetaMedicaId], T1.[RecetaIndicaciones]," ;
      scmdbuf += " T1.[RecetaMedicaAtencion], T2.[MedicamentoFormaFarm], T2.[MedicamentoNombre], T2.[MedicamentoCodigo] FROM ([RecetaMedica] T1 LEFT JOIN [Medicamento] T2 ON T2.[MedicamentoId]" ;
      scmdbuf += " = T1.[MedicamentoId])" ;
      if ( ! (GXutil.strcmp("", AV58Recetamedicawwds_1_filterfulltext)==0) )
      {
         addWhere(sWhereString, "(( CONVERT( char(4), CAST(T1.[RecetaMedicaId] AS decimal(4,0))) like '%' + ?) or ( CONVERT( char(8), CAST(T1.[CitaId] AS decimal(8,0))) like '%' + ?) or ( CONVERT( char(4), CAST(T1.[MedicamentoId] AS decimal(4,0))) like '%' + ?) or ( T2.[MedicamentoCodigo] like '%' + ?) or ( T2.[MedicamentoNombre] like '%' + ?) or ( T2.[MedicamentoFormaFarm] like '%' + ?) or ( T1.[RecetaMedicaConcentracion] like '%' + ?) or ( CONVERT( char(4), CAST(T1.[RecetaMedicaCantidad] AS decimal(4,0))) like '%' + ?) or ( T1.[RecetaMedicaAtencion] like '%' + ?) or ( CONVERT( char(1), CAST(T1.[RecetaMedicaFlag] AS decimal(1,0))) like '%' + ?) or ( T1.[RecetaIndicaciones] like '%' + ?))");
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
         GXv_int10[10] = (byte)(1) ;
      }
      if ( ! (0==AV59Recetamedicawwds_2_tfrecetamedicaid) )
      {
         addWhere(sWhereString, "(T1.[RecetaMedicaId] >= ?)");
      }
      else
      {
         GXv_int10[11] = (byte)(1) ;
      }
      if ( ! (0==AV60Recetamedicawwds_3_tfrecetamedicaid_to) )
      {
         addWhere(sWhereString, "(T1.[RecetaMedicaId] <= ?)");
      }
      else
      {
         GXv_int10[12] = (byte)(1) ;
      }
      if ( ! (0==AV61Recetamedicawwds_4_tfcitaid) )
      {
         addWhere(sWhereString, "(T1.[CitaId] >= ?)");
      }
      else
      {
         GXv_int10[13] = (byte)(1) ;
      }
      if ( ! (0==AV62Recetamedicawwds_5_tfcitaid_to) )
      {
         addWhere(sWhereString, "(T1.[CitaId] <= ?)");
      }
      else
      {
         GXv_int10[14] = (byte)(1) ;
      }
      if ( ! (0==AV63Recetamedicawwds_6_tfmedicamentoid) )
      {
         addWhere(sWhereString, "(T1.[MedicamentoId] >= ?)");
      }
      else
      {
         GXv_int10[15] = (byte)(1) ;
      }
      if ( ! (0==AV64Recetamedicawwds_7_tfmedicamentoid_to) )
      {
         addWhere(sWhereString, "(T1.[MedicamentoId] <= ?)");
      }
      else
      {
         GXv_int10[16] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV66Recetamedicawwds_9_tfmedicamentocodigo_sel)==0) && ( ! (GXutil.strcmp("", AV65Recetamedicawwds_8_tfmedicamentocodigo)==0) ) )
      {
         addWhere(sWhereString, "(T2.[MedicamentoCodigo] like ?)");
      }
      else
      {
         GXv_int10[17] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV66Recetamedicawwds_9_tfmedicamentocodigo_sel)==0) )
      {
         addWhere(sWhereString, "(T2.[MedicamentoCodigo] = ?)");
      }
      else
      {
         GXv_int10[18] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV68Recetamedicawwds_11_tfmedicamentonombre_sel)==0) && ( ! (GXutil.strcmp("", AV67Recetamedicawwds_10_tfmedicamentonombre)==0) ) )
      {
         addWhere(sWhereString, "(T2.[MedicamentoNombre] like ?)");
      }
      else
      {
         GXv_int10[19] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV68Recetamedicawwds_11_tfmedicamentonombre_sel)==0) )
      {
         addWhere(sWhereString, "(T2.[MedicamentoNombre] = ?)");
      }
      else
      {
         GXv_int10[20] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV70Recetamedicawwds_13_tfmedicamentoformafarm_sel)==0) && ( ! (GXutil.strcmp("", AV69Recetamedicawwds_12_tfmedicamentoformafarm)==0) ) )
      {
         addWhere(sWhereString, "(T2.[MedicamentoFormaFarm] like ?)");
      }
      else
      {
         GXv_int10[21] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV70Recetamedicawwds_13_tfmedicamentoformafarm_sel)==0) )
      {
         addWhere(sWhereString, "(T2.[MedicamentoFormaFarm] = ?)");
      }
      else
      {
         GXv_int10[22] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV72Recetamedicawwds_15_tfrecetamedicaconcentracion_sel)==0) && ( ! (GXutil.strcmp("", AV71Recetamedicawwds_14_tfrecetamedicaconcentracion)==0) ) )
      {
         addWhere(sWhereString, "(T1.[RecetaMedicaConcentracion] like ?)");
      }
      else
      {
         GXv_int10[23] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV72Recetamedicawwds_15_tfrecetamedicaconcentracion_sel)==0) )
      {
         addWhere(sWhereString, "(T1.[RecetaMedicaConcentracion] = ?)");
      }
      else
      {
         GXv_int10[24] = (byte)(1) ;
      }
      if ( ! (0==AV73Recetamedicawwds_16_tfrecetamedicacantidad) )
      {
         addWhere(sWhereString, "(T1.[RecetaMedicaCantidad] >= ?)");
      }
      else
      {
         GXv_int10[25] = (byte)(1) ;
      }
      if ( ! (0==AV74Recetamedicawwds_17_tfrecetamedicacantidad_to) )
      {
         addWhere(sWhereString, "(T1.[RecetaMedicaCantidad] <= ?)");
      }
      else
      {
         GXv_int10[26] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV76Recetamedicawwds_19_tfrecetamedicaatencion_sel)==0) && ( ! (GXutil.strcmp("", AV75Recetamedicawwds_18_tfrecetamedicaatencion)==0) ) )
      {
         addWhere(sWhereString, "(T1.[RecetaMedicaAtencion] like ?)");
      }
      else
      {
         GXv_int10[27] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV76Recetamedicawwds_19_tfrecetamedicaatencion_sel)==0) )
      {
         addWhere(sWhereString, "(T1.[RecetaMedicaAtencion] = ?)");
      }
      else
      {
         GXv_int10[28] = (byte)(1) ;
      }
      if ( ! (0==AV77Recetamedicawwds_20_tfrecetamedicaflag) )
      {
         addWhere(sWhereString, "(T1.[RecetaMedicaFlag] >= ?)");
      }
      else
      {
         GXv_int10[29] = (byte)(1) ;
      }
      if ( ! (0==AV78Recetamedicawwds_21_tfrecetamedicaflag_to) )
      {
         addWhere(sWhereString, "(T1.[RecetaMedicaFlag] <= ?)");
      }
      else
      {
         GXv_int10[30] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV80Recetamedicawwds_23_tfrecetaindicaciones_sel)==0) && ( ! (GXutil.strcmp("", AV79Recetamedicawwds_22_tfrecetaindicaciones)==0) ) )
      {
         addWhere(sWhereString, "(T1.[RecetaIndicaciones] like ?)");
      }
      else
      {
         GXv_int10[31] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV80Recetamedicawwds_23_tfrecetaindicaciones_sel)==0) )
      {
         addWhere(sWhereString, "(T1.[RecetaIndicaciones] = ?)");
      }
      else
      {
         GXv_int10[32] = (byte)(1) ;
      }
      scmdbuf += sWhereString ;
      scmdbuf += " ORDER BY T1.[RecetaMedicaConcentracion]" ;
      GXv_Object11[0] = scmdbuf ;
      GXv_Object11[1] = GXv_int10 ;
      return GXv_Object11 ;
   }

   protected Object[] conditional_P003J6( ModelContext context ,
                                          int remoteHandle ,
                                          com.genexus.IHttpContext httpContext ,
                                          String AV58Recetamedicawwds_1_filterfulltext ,
                                          short AV59Recetamedicawwds_2_tfrecetamedicaid ,
                                          short AV60Recetamedicawwds_3_tfrecetamedicaid_to ,
                                          int AV61Recetamedicawwds_4_tfcitaid ,
                                          int AV62Recetamedicawwds_5_tfcitaid_to ,
                                          short AV63Recetamedicawwds_6_tfmedicamentoid ,
                                          short AV64Recetamedicawwds_7_tfmedicamentoid_to ,
                                          String AV66Recetamedicawwds_9_tfmedicamentocodigo_sel ,
                                          String AV65Recetamedicawwds_8_tfmedicamentocodigo ,
                                          String AV68Recetamedicawwds_11_tfmedicamentonombre_sel ,
                                          String AV67Recetamedicawwds_10_tfmedicamentonombre ,
                                          String AV70Recetamedicawwds_13_tfmedicamentoformafarm_sel ,
                                          String AV69Recetamedicawwds_12_tfmedicamentoformafarm ,
                                          String AV72Recetamedicawwds_15_tfrecetamedicaconcentracion_sel ,
                                          String AV71Recetamedicawwds_14_tfrecetamedicaconcentracion ,
                                          short AV73Recetamedicawwds_16_tfrecetamedicacantidad ,
                                          short AV74Recetamedicawwds_17_tfrecetamedicacantidad_to ,
                                          String AV76Recetamedicawwds_19_tfrecetamedicaatencion_sel ,
                                          String AV75Recetamedicawwds_18_tfrecetamedicaatencion ,
                                          byte AV77Recetamedicawwds_20_tfrecetamedicaflag ,
                                          byte AV78Recetamedicawwds_21_tfrecetamedicaflag_to ,
                                          String AV80Recetamedicawwds_23_tfrecetaindicaciones_sel ,
                                          String AV79Recetamedicawwds_22_tfrecetaindicaciones ,
                                          short A50RecetaMedicaId ,
                                          int A19CitaId ,
                                          short A42MedicamentoId ,
                                          String A229MedicamentoCodigo ,
                                          String A230MedicamentoNombre ,
                                          String A231MedicamentoFormaFarm ,
                                          String A268RecetaMedicaConcentracion ,
                                          short A269RecetaMedicaCantidad ,
                                          String A273RecetaMedicaAtencion ,
                                          byte A272RecetaMedicaFlag ,
                                          String A332RecetaIndicaciones )
   {
      java.lang.StringBuffer sWhereString = new java.lang.StringBuffer();
      String scmdbuf;
      byte[] GXv_int12 = new byte[33];
      Object[] GXv_Object13 = new Object[2];
      scmdbuf = "SELECT T1.[RecetaMedicaAtencion], T1.[RecetaMedicaFlag], T1.[RecetaMedicaCantidad], T1.[MedicamentoId], T1.[CitaId], T1.[RecetaMedicaId], T1.[RecetaIndicaciones]," ;
      scmdbuf += " T1.[RecetaMedicaConcentracion], T2.[MedicamentoFormaFarm], T2.[MedicamentoNombre], T2.[MedicamentoCodigo] FROM ([RecetaMedica] T1 LEFT JOIN [Medicamento] T2 ON" ;
      scmdbuf += " T2.[MedicamentoId] = T1.[MedicamentoId])" ;
      if ( ! (GXutil.strcmp("", AV58Recetamedicawwds_1_filterfulltext)==0) )
      {
         addWhere(sWhereString, "(( CONVERT( char(4), CAST(T1.[RecetaMedicaId] AS decimal(4,0))) like '%' + ?) or ( CONVERT( char(8), CAST(T1.[CitaId] AS decimal(8,0))) like '%' + ?) or ( CONVERT( char(4), CAST(T1.[MedicamentoId] AS decimal(4,0))) like '%' + ?) or ( T2.[MedicamentoCodigo] like '%' + ?) or ( T2.[MedicamentoNombre] like '%' + ?) or ( T2.[MedicamentoFormaFarm] like '%' + ?) or ( T1.[RecetaMedicaConcentracion] like '%' + ?) or ( CONVERT( char(4), CAST(T1.[RecetaMedicaCantidad] AS decimal(4,0))) like '%' + ?) or ( T1.[RecetaMedicaAtencion] like '%' + ?) or ( CONVERT( char(1), CAST(T1.[RecetaMedicaFlag] AS decimal(1,0))) like '%' + ?) or ( T1.[RecetaIndicaciones] like '%' + ?))");
      }
      else
      {
         GXv_int12[0] = (byte)(1) ;
         GXv_int12[1] = (byte)(1) ;
         GXv_int12[2] = (byte)(1) ;
         GXv_int12[3] = (byte)(1) ;
         GXv_int12[4] = (byte)(1) ;
         GXv_int12[5] = (byte)(1) ;
         GXv_int12[6] = (byte)(1) ;
         GXv_int12[7] = (byte)(1) ;
         GXv_int12[8] = (byte)(1) ;
         GXv_int12[9] = (byte)(1) ;
         GXv_int12[10] = (byte)(1) ;
      }
      if ( ! (0==AV59Recetamedicawwds_2_tfrecetamedicaid) )
      {
         addWhere(sWhereString, "(T1.[RecetaMedicaId] >= ?)");
      }
      else
      {
         GXv_int12[11] = (byte)(1) ;
      }
      if ( ! (0==AV60Recetamedicawwds_3_tfrecetamedicaid_to) )
      {
         addWhere(sWhereString, "(T1.[RecetaMedicaId] <= ?)");
      }
      else
      {
         GXv_int12[12] = (byte)(1) ;
      }
      if ( ! (0==AV61Recetamedicawwds_4_tfcitaid) )
      {
         addWhere(sWhereString, "(T1.[CitaId] >= ?)");
      }
      else
      {
         GXv_int12[13] = (byte)(1) ;
      }
      if ( ! (0==AV62Recetamedicawwds_5_tfcitaid_to) )
      {
         addWhere(sWhereString, "(T1.[CitaId] <= ?)");
      }
      else
      {
         GXv_int12[14] = (byte)(1) ;
      }
      if ( ! (0==AV63Recetamedicawwds_6_tfmedicamentoid) )
      {
         addWhere(sWhereString, "(T1.[MedicamentoId] >= ?)");
      }
      else
      {
         GXv_int12[15] = (byte)(1) ;
      }
      if ( ! (0==AV64Recetamedicawwds_7_tfmedicamentoid_to) )
      {
         addWhere(sWhereString, "(T1.[MedicamentoId] <= ?)");
      }
      else
      {
         GXv_int12[16] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV66Recetamedicawwds_9_tfmedicamentocodigo_sel)==0) && ( ! (GXutil.strcmp("", AV65Recetamedicawwds_8_tfmedicamentocodigo)==0) ) )
      {
         addWhere(sWhereString, "(T2.[MedicamentoCodigo] like ?)");
      }
      else
      {
         GXv_int12[17] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV66Recetamedicawwds_9_tfmedicamentocodigo_sel)==0) )
      {
         addWhere(sWhereString, "(T2.[MedicamentoCodigo] = ?)");
      }
      else
      {
         GXv_int12[18] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV68Recetamedicawwds_11_tfmedicamentonombre_sel)==0) && ( ! (GXutil.strcmp("", AV67Recetamedicawwds_10_tfmedicamentonombre)==0) ) )
      {
         addWhere(sWhereString, "(T2.[MedicamentoNombre] like ?)");
      }
      else
      {
         GXv_int12[19] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV68Recetamedicawwds_11_tfmedicamentonombre_sel)==0) )
      {
         addWhere(sWhereString, "(T2.[MedicamentoNombre] = ?)");
      }
      else
      {
         GXv_int12[20] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV70Recetamedicawwds_13_tfmedicamentoformafarm_sel)==0) && ( ! (GXutil.strcmp("", AV69Recetamedicawwds_12_tfmedicamentoformafarm)==0) ) )
      {
         addWhere(sWhereString, "(T2.[MedicamentoFormaFarm] like ?)");
      }
      else
      {
         GXv_int12[21] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV70Recetamedicawwds_13_tfmedicamentoformafarm_sel)==0) )
      {
         addWhere(sWhereString, "(T2.[MedicamentoFormaFarm] = ?)");
      }
      else
      {
         GXv_int12[22] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV72Recetamedicawwds_15_tfrecetamedicaconcentracion_sel)==0) && ( ! (GXutil.strcmp("", AV71Recetamedicawwds_14_tfrecetamedicaconcentracion)==0) ) )
      {
         addWhere(sWhereString, "(T1.[RecetaMedicaConcentracion] like ?)");
      }
      else
      {
         GXv_int12[23] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV72Recetamedicawwds_15_tfrecetamedicaconcentracion_sel)==0) )
      {
         addWhere(sWhereString, "(T1.[RecetaMedicaConcentracion] = ?)");
      }
      else
      {
         GXv_int12[24] = (byte)(1) ;
      }
      if ( ! (0==AV73Recetamedicawwds_16_tfrecetamedicacantidad) )
      {
         addWhere(sWhereString, "(T1.[RecetaMedicaCantidad] >= ?)");
      }
      else
      {
         GXv_int12[25] = (byte)(1) ;
      }
      if ( ! (0==AV74Recetamedicawwds_17_tfrecetamedicacantidad_to) )
      {
         addWhere(sWhereString, "(T1.[RecetaMedicaCantidad] <= ?)");
      }
      else
      {
         GXv_int12[26] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV76Recetamedicawwds_19_tfrecetamedicaatencion_sel)==0) && ( ! (GXutil.strcmp("", AV75Recetamedicawwds_18_tfrecetamedicaatencion)==0) ) )
      {
         addWhere(sWhereString, "(T1.[RecetaMedicaAtencion] like ?)");
      }
      else
      {
         GXv_int12[27] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV76Recetamedicawwds_19_tfrecetamedicaatencion_sel)==0) )
      {
         addWhere(sWhereString, "(T1.[RecetaMedicaAtencion] = ?)");
      }
      else
      {
         GXv_int12[28] = (byte)(1) ;
      }
      if ( ! (0==AV77Recetamedicawwds_20_tfrecetamedicaflag) )
      {
         addWhere(sWhereString, "(T1.[RecetaMedicaFlag] >= ?)");
      }
      else
      {
         GXv_int12[29] = (byte)(1) ;
      }
      if ( ! (0==AV78Recetamedicawwds_21_tfrecetamedicaflag_to) )
      {
         addWhere(sWhereString, "(T1.[RecetaMedicaFlag] <= ?)");
      }
      else
      {
         GXv_int12[30] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV80Recetamedicawwds_23_tfrecetaindicaciones_sel)==0) && ( ! (GXutil.strcmp("", AV79Recetamedicawwds_22_tfrecetaindicaciones)==0) ) )
      {
         addWhere(sWhereString, "(T1.[RecetaIndicaciones] like ?)");
      }
      else
      {
         GXv_int12[31] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV80Recetamedicawwds_23_tfrecetaindicaciones_sel)==0) )
      {
         addWhere(sWhereString, "(T1.[RecetaIndicaciones] = ?)");
      }
      else
      {
         GXv_int12[32] = (byte)(1) ;
      }
      scmdbuf += sWhereString ;
      scmdbuf += " ORDER BY T1.[RecetaMedicaAtencion]" ;
      GXv_Object13[0] = scmdbuf ;
      GXv_Object13[1] = GXv_int12 ;
      return GXv_Object13 ;
   }

   protected Object[] conditional_P003J7( ModelContext context ,
                                          int remoteHandle ,
                                          com.genexus.IHttpContext httpContext ,
                                          String AV58Recetamedicawwds_1_filterfulltext ,
                                          short AV59Recetamedicawwds_2_tfrecetamedicaid ,
                                          short AV60Recetamedicawwds_3_tfrecetamedicaid_to ,
                                          int AV61Recetamedicawwds_4_tfcitaid ,
                                          int AV62Recetamedicawwds_5_tfcitaid_to ,
                                          short AV63Recetamedicawwds_6_tfmedicamentoid ,
                                          short AV64Recetamedicawwds_7_tfmedicamentoid_to ,
                                          String AV66Recetamedicawwds_9_tfmedicamentocodigo_sel ,
                                          String AV65Recetamedicawwds_8_tfmedicamentocodigo ,
                                          String AV68Recetamedicawwds_11_tfmedicamentonombre_sel ,
                                          String AV67Recetamedicawwds_10_tfmedicamentonombre ,
                                          String AV70Recetamedicawwds_13_tfmedicamentoformafarm_sel ,
                                          String AV69Recetamedicawwds_12_tfmedicamentoformafarm ,
                                          String AV72Recetamedicawwds_15_tfrecetamedicaconcentracion_sel ,
                                          String AV71Recetamedicawwds_14_tfrecetamedicaconcentracion ,
                                          short AV73Recetamedicawwds_16_tfrecetamedicacantidad ,
                                          short AV74Recetamedicawwds_17_tfrecetamedicacantidad_to ,
                                          String AV76Recetamedicawwds_19_tfrecetamedicaatencion_sel ,
                                          String AV75Recetamedicawwds_18_tfrecetamedicaatencion ,
                                          byte AV77Recetamedicawwds_20_tfrecetamedicaflag ,
                                          byte AV78Recetamedicawwds_21_tfrecetamedicaflag_to ,
                                          String AV80Recetamedicawwds_23_tfrecetaindicaciones_sel ,
                                          String AV79Recetamedicawwds_22_tfrecetaindicaciones ,
                                          short A50RecetaMedicaId ,
                                          int A19CitaId ,
                                          short A42MedicamentoId ,
                                          String A229MedicamentoCodigo ,
                                          String A230MedicamentoNombre ,
                                          String A231MedicamentoFormaFarm ,
                                          String A268RecetaMedicaConcentracion ,
                                          short A269RecetaMedicaCantidad ,
                                          String A273RecetaMedicaAtencion ,
                                          byte A272RecetaMedicaFlag ,
                                          String A332RecetaIndicaciones )
   {
      java.lang.StringBuffer sWhereString = new java.lang.StringBuffer();
      String scmdbuf;
      byte[] GXv_int14 = new byte[33];
      Object[] GXv_Object15 = new Object[2];
      scmdbuf = "SELECT T1.[RecetaIndicaciones], T1.[RecetaMedicaFlag], T1.[RecetaMedicaCantidad], T1.[MedicamentoId], T1.[CitaId], T1.[RecetaMedicaId], T1.[RecetaMedicaAtencion]," ;
      scmdbuf += " T1.[RecetaMedicaConcentracion], T2.[MedicamentoFormaFarm], T2.[MedicamentoNombre], T2.[MedicamentoCodigo] FROM ([RecetaMedica] T1 LEFT JOIN [Medicamento] T2 ON" ;
      scmdbuf += " T2.[MedicamentoId] = T1.[MedicamentoId])" ;
      if ( ! (GXutil.strcmp("", AV58Recetamedicawwds_1_filterfulltext)==0) )
      {
         addWhere(sWhereString, "(( CONVERT( char(4), CAST(T1.[RecetaMedicaId] AS decimal(4,0))) like '%' + ?) or ( CONVERT( char(8), CAST(T1.[CitaId] AS decimal(8,0))) like '%' + ?) or ( CONVERT( char(4), CAST(T1.[MedicamentoId] AS decimal(4,0))) like '%' + ?) or ( T2.[MedicamentoCodigo] like '%' + ?) or ( T2.[MedicamentoNombre] like '%' + ?) or ( T2.[MedicamentoFormaFarm] like '%' + ?) or ( T1.[RecetaMedicaConcentracion] like '%' + ?) or ( CONVERT( char(4), CAST(T1.[RecetaMedicaCantidad] AS decimal(4,0))) like '%' + ?) or ( T1.[RecetaMedicaAtencion] like '%' + ?) or ( CONVERT( char(1), CAST(T1.[RecetaMedicaFlag] AS decimal(1,0))) like '%' + ?) or ( T1.[RecetaIndicaciones] like '%' + ?))");
      }
      else
      {
         GXv_int14[0] = (byte)(1) ;
         GXv_int14[1] = (byte)(1) ;
         GXv_int14[2] = (byte)(1) ;
         GXv_int14[3] = (byte)(1) ;
         GXv_int14[4] = (byte)(1) ;
         GXv_int14[5] = (byte)(1) ;
         GXv_int14[6] = (byte)(1) ;
         GXv_int14[7] = (byte)(1) ;
         GXv_int14[8] = (byte)(1) ;
         GXv_int14[9] = (byte)(1) ;
         GXv_int14[10] = (byte)(1) ;
      }
      if ( ! (0==AV59Recetamedicawwds_2_tfrecetamedicaid) )
      {
         addWhere(sWhereString, "(T1.[RecetaMedicaId] >= ?)");
      }
      else
      {
         GXv_int14[11] = (byte)(1) ;
      }
      if ( ! (0==AV60Recetamedicawwds_3_tfrecetamedicaid_to) )
      {
         addWhere(sWhereString, "(T1.[RecetaMedicaId] <= ?)");
      }
      else
      {
         GXv_int14[12] = (byte)(1) ;
      }
      if ( ! (0==AV61Recetamedicawwds_4_tfcitaid) )
      {
         addWhere(sWhereString, "(T1.[CitaId] >= ?)");
      }
      else
      {
         GXv_int14[13] = (byte)(1) ;
      }
      if ( ! (0==AV62Recetamedicawwds_5_tfcitaid_to) )
      {
         addWhere(sWhereString, "(T1.[CitaId] <= ?)");
      }
      else
      {
         GXv_int14[14] = (byte)(1) ;
      }
      if ( ! (0==AV63Recetamedicawwds_6_tfmedicamentoid) )
      {
         addWhere(sWhereString, "(T1.[MedicamentoId] >= ?)");
      }
      else
      {
         GXv_int14[15] = (byte)(1) ;
      }
      if ( ! (0==AV64Recetamedicawwds_7_tfmedicamentoid_to) )
      {
         addWhere(sWhereString, "(T1.[MedicamentoId] <= ?)");
      }
      else
      {
         GXv_int14[16] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV66Recetamedicawwds_9_tfmedicamentocodigo_sel)==0) && ( ! (GXutil.strcmp("", AV65Recetamedicawwds_8_tfmedicamentocodigo)==0) ) )
      {
         addWhere(sWhereString, "(T2.[MedicamentoCodigo] like ?)");
      }
      else
      {
         GXv_int14[17] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV66Recetamedicawwds_9_tfmedicamentocodigo_sel)==0) )
      {
         addWhere(sWhereString, "(T2.[MedicamentoCodigo] = ?)");
      }
      else
      {
         GXv_int14[18] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV68Recetamedicawwds_11_tfmedicamentonombre_sel)==0) && ( ! (GXutil.strcmp("", AV67Recetamedicawwds_10_tfmedicamentonombre)==0) ) )
      {
         addWhere(sWhereString, "(T2.[MedicamentoNombre] like ?)");
      }
      else
      {
         GXv_int14[19] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV68Recetamedicawwds_11_tfmedicamentonombre_sel)==0) )
      {
         addWhere(sWhereString, "(T2.[MedicamentoNombre] = ?)");
      }
      else
      {
         GXv_int14[20] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV70Recetamedicawwds_13_tfmedicamentoformafarm_sel)==0) && ( ! (GXutil.strcmp("", AV69Recetamedicawwds_12_tfmedicamentoformafarm)==0) ) )
      {
         addWhere(sWhereString, "(T2.[MedicamentoFormaFarm] like ?)");
      }
      else
      {
         GXv_int14[21] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV70Recetamedicawwds_13_tfmedicamentoformafarm_sel)==0) )
      {
         addWhere(sWhereString, "(T2.[MedicamentoFormaFarm] = ?)");
      }
      else
      {
         GXv_int14[22] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV72Recetamedicawwds_15_tfrecetamedicaconcentracion_sel)==0) && ( ! (GXutil.strcmp("", AV71Recetamedicawwds_14_tfrecetamedicaconcentracion)==0) ) )
      {
         addWhere(sWhereString, "(T1.[RecetaMedicaConcentracion] like ?)");
      }
      else
      {
         GXv_int14[23] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV72Recetamedicawwds_15_tfrecetamedicaconcentracion_sel)==0) )
      {
         addWhere(sWhereString, "(T1.[RecetaMedicaConcentracion] = ?)");
      }
      else
      {
         GXv_int14[24] = (byte)(1) ;
      }
      if ( ! (0==AV73Recetamedicawwds_16_tfrecetamedicacantidad) )
      {
         addWhere(sWhereString, "(T1.[RecetaMedicaCantidad] >= ?)");
      }
      else
      {
         GXv_int14[25] = (byte)(1) ;
      }
      if ( ! (0==AV74Recetamedicawwds_17_tfrecetamedicacantidad_to) )
      {
         addWhere(sWhereString, "(T1.[RecetaMedicaCantidad] <= ?)");
      }
      else
      {
         GXv_int14[26] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV76Recetamedicawwds_19_tfrecetamedicaatencion_sel)==0) && ( ! (GXutil.strcmp("", AV75Recetamedicawwds_18_tfrecetamedicaatencion)==0) ) )
      {
         addWhere(sWhereString, "(T1.[RecetaMedicaAtencion] like ?)");
      }
      else
      {
         GXv_int14[27] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV76Recetamedicawwds_19_tfrecetamedicaatencion_sel)==0) )
      {
         addWhere(sWhereString, "(T1.[RecetaMedicaAtencion] = ?)");
      }
      else
      {
         GXv_int14[28] = (byte)(1) ;
      }
      if ( ! (0==AV77Recetamedicawwds_20_tfrecetamedicaflag) )
      {
         addWhere(sWhereString, "(T1.[RecetaMedicaFlag] >= ?)");
      }
      else
      {
         GXv_int14[29] = (byte)(1) ;
      }
      if ( ! (0==AV78Recetamedicawwds_21_tfrecetamedicaflag_to) )
      {
         addWhere(sWhereString, "(T1.[RecetaMedicaFlag] <= ?)");
      }
      else
      {
         GXv_int14[30] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV80Recetamedicawwds_23_tfrecetaindicaciones_sel)==0) && ( ! (GXutil.strcmp("", AV79Recetamedicawwds_22_tfrecetaindicaciones)==0) ) )
      {
         addWhere(sWhereString, "(T1.[RecetaIndicaciones] like ?)");
      }
      else
      {
         GXv_int14[31] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV80Recetamedicawwds_23_tfrecetaindicaciones_sel)==0) )
      {
         addWhere(sWhereString, "(T1.[RecetaIndicaciones] = ?)");
      }
      else
      {
         GXv_int14[32] = (byte)(1) ;
      }
      scmdbuf += sWhereString ;
      scmdbuf += " ORDER BY T1.[RecetaIndicaciones]" ;
      GXv_Object15[0] = scmdbuf ;
      GXv_Object15[1] = GXv_int14 ;
      return GXv_Object15 ;
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
                  return conditional_P003J2(context, remoteHandle, httpContext, (String)dynConstraints[0] , ((Number) dynConstraints[1]).shortValue() , ((Number) dynConstraints[2]).shortValue() , ((Number) dynConstraints[3]).intValue() , ((Number) dynConstraints[4]).intValue() , ((Number) dynConstraints[5]).shortValue() , ((Number) dynConstraints[6]).shortValue() , (String)dynConstraints[7] , (String)dynConstraints[8] , (String)dynConstraints[9] , (String)dynConstraints[10] , (String)dynConstraints[11] , (String)dynConstraints[12] , (String)dynConstraints[13] , (String)dynConstraints[14] , ((Number) dynConstraints[15]).shortValue() , ((Number) dynConstraints[16]).shortValue() , (String)dynConstraints[17] , (String)dynConstraints[18] , ((Number) dynConstraints[19]).byteValue() , ((Number) dynConstraints[20]).byteValue() , (String)dynConstraints[21] , (String)dynConstraints[22] , ((Number) dynConstraints[23]).shortValue() , ((Number) dynConstraints[24]).intValue() , ((Number) dynConstraints[25]).shortValue() , (String)dynConstraints[26] , (String)dynConstraints[27] , (String)dynConstraints[28] , (String)dynConstraints[29] , ((Number) dynConstraints[30]).shortValue() , (String)dynConstraints[31] , ((Number) dynConstraints[32]).byteValue() , (String)dynConstraints[33] );
            case 1 :
                  return conditional_P003J3(context, remoteHandle, httpContext, (String)dynConstraints[0] , ((Number) dynConstraints[1]).shortValue() , ((Number) dynConstraints[2]).shortValue() , ((Number) dynConstraints[3]).intValue() , ((Number) dynConstraints[4]).intValue() , ((Number) dynConstraints[5]).shortValue() , ((Number) dynConstraints[6]).shortValue() , (String)dynConstraints[7] , (String)dynConstraints[8] , (String)dynConstraints[9] , (String)dynConstraints[10] , (String)dynConstraints[11] , (String)dynConstraints[12] , (String)dynConstraints[13] , (String)dynConstraints[14] , ((Number) dynConstraints[15]).shortValue() , ((Number) dynConstraints[16]).shortValue() , (String)dynConstraints[17] , (String)dynConstraints[18] , ((Number) dynConstraints[19]).byteValue() , ((Number) dynConstraints[20]).byteValue() , (String)dynConstraints[21] , (String)dynConstraints[22] , ((Number) dynConstraints[23]).shortValue() , ((Number) dynConstraints[24]).intValue() , ((Number) dynConstraints[25]).shortValue() , (String)dynConstraints[26] , (String)dynConstraints[27] , (String)dynConstraints[28] , (String)dynConstraints[29] , ((Number) dynConstraints[30]).shortValue() , (String)dynConstraints[31] , ((Number) dynConstraints[32]).byteValue() , (String)dynConstraints[33] );
            case 2 :
                  return conditional_P003J4(context, remoteHandle, httpContext, (String)dynConstraints[0] , ((Number) dynConstraints[1]).shortValue() , ((Number) dynConstraints[2]).shortValue() , ((Number) dynConstraints[3]).intValue() , ((Number) dynConstraints[4]).intValue() , ((Number) dynConstraints[5]).shortValue() , ((Number) dynConstraints[6]).shortValue() , (String)dynConstraints[7] , (String)dynConstraints[8] , (String)dynConstraints[9] , (String)dynConstraints[10] , (String)dynConstraints[11] , (String)dynConstraints[12] , (String)dynConstraints[13] , (String)dynConstraints[14] , ((Number) dynConstraints[15]).shortValue() , ((Number) dynConstraints[16]).shortValue() , (String)dynConstraints[17] , (String)dynConstraints[18] , ((Number) dynConstraints[19]).byteValue() , ((Number) dynConstraints[20]).byteValue() , (String)dynConstraints[21] , (String)dynConstraints[22] , ((Number) dynConstraints[23]).shortValue() , ((Number) dynConstraints[24]).intValue() , ((Number) dynConstraints[25]).shortValue() , (String)dynConstraints[26] , (String)dynConstraints[27] , (String)dynConstraints[28] , (String)dynConstraints[29] , ((Number) dynConstraints[30]).shortValue() , (String)dynConstraints[31] , ((Number) dynConstraints[32]).byteValue() , (String)dynConstraints[33] );
            case 3 :
                  return conditional_P003J5(context, remoteHandle, httpContext, (String)dynConstraints[0] , ((Number) dynConstraints[1]).shortValue() , ((Number) dynConstraints[2]).shortValue() , ((Number) dynConstraints[3]).intValue() , ((Number) dynConstraints[4]).intValue() , ((Number) dynConstraints[5]).shortValue() , ((Number) dynConstraints[6]).shortValue() , (String)dynConstraints[7] , (String)dynConstraints[8] , (String)dynConstraints[9] , (String)dynConstraints[10] , (String)dynConstraints[11] , (String)dynConstraints[12] , (String)dynConstraints[13] , (String)dynConstraints[14] , ((Number) dynConstraints[15]).shortValue() , ((Number) dynConstraints[16]).shortValue() , (String)dynConstraints[17] , (String)dynConstraints[18] , ((Number) dynConstraints[19]).byteValue() , ((Number) dynConstraints[20]).byteValue() , (String)dynConstraints[21] , (String)dynConstraints[22] , ((Number) dynConstraints[23]).shortValue() , ((Number) dynConstraints[24]).intValue() , ((Number) dynConstraints[25]).shortValue() , (String)dynConstraints[26] , (String)dynConstraints[27] , (String)dynConstraints[28] , (String)dynConstraints[29] , ((Number) dynConstraints[30]).shortValue() , (String)dynConstraints[31] , ((Number) dynConstraints[32]).byteValue() , (String)dynConstraints[33] );
            case 4 :
                  return conditional_P003J6(context, remoteHandle, httpContext, (String)dynConstraints[0] , ((Number) dynConstraints[1]).shortValue() , ((Number) dynConstraints[2]).shortValue() , ((Number) dynConstraints[3]).intValue() , ((Number) dynConstraints[4]).intValue() , ((Number) dynConstraints[5]).shortValue() , ((Number) dynConstraints[6]).shortValue() , (String)dynConstraints[7] , (String)dynConstraints[8] , (String)dynConstraints[9] , (String)dynConstraints[10] , (String)dynConstraints[11] , (String)dynConstraints[12] , (String)dynConstraints[13] , (String)dynConstraints[14] , ((Number) dynConstraints[15]).shortValue() , ((Number) dynConstraints[16]).shortValue() , (String)dynConstraints[17] , (String)dynConstraints[18] , ((Number) dynConstraints[19]).byteValue() , ((Number) dynConstraints[20]).byteValue() , (String)dynConstraints[21] , (String)dynConstraints[22] , ((Number) dynConstraints[23]).shortValue() , ((Number) dynConstraints[24]).intValue() , ((Number) dynConstraints[25]).shortValue() , (String)dynConstraints[26] , (String)dynConstraints[27] , (String)dynConstraints[28] , (String)dynConstraints[29] , ((Number) dynConstraints[30]).shortValue() , (String)dynConstraints[31] , ((Number) dynConstraints[32]).byteValue() , (String)dynConstraints[33] );
            case 5 :
                  return conditional_P003J7(context, remoteHandle, httpContext, (String)dynConstraints[0] , ((Number) dynConstraints[1]).shortValue() , ((Number) dynConstraints[2]).shortValue() , ((Number) dynConstraints[3]).intValue() , ((Number) dynConstraints[4]).intValue() , ((Number) dynConstraints[5]).shortValue() , ((Number) dynConstraints[6]).shortValue() , (String)dynConstraints[7] , (String)dynConstraints[8] , (String)dynConstraints[9] , (String)dynConstraints[10] , (String)dynConstraints[11] , (String)dynConstraints[12] , (String)dynConstraints[13] , (String)dynConstraints[14] , ((Number) dynConstraints[15]).shortValue() , ((Number) dynConstraints[16]).shortValue() , (String)dynConstraints[17] , (String)dynConstraints[18] , ((Number) dynConstraints[19]).byteValue() , ((Number) dynConstraints[20]).byteValue() , (String)dynConstraints[21] , (String)dynConstraints[22] , ((Number) dynConstraints[23]).shortValue() , ((Number) dynConstraints[24]).intValue() , ((Number) dynConstraints[25]).shortValue() , (String)dynConstraints[26] , (String)dynConstraints[27] , (String)dynConstraints[28] , (String)dynConstraints[29] , ((Number) dynConstraints[30]).shortValue() , (String)dynConstraints[31] , ((Number) dynConstraints[32]).byteValue() , (String)dynConstraints[33] );
      }
      return super.getDynamicStatement(cursor, context, remoteHandle, httpContext, dynConstraints);
   }

   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P003J2", "scmdbuf",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("P003J3", "scmdbuf",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("P003J4", "scmdbuf",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("P003J5", "scmdbuf",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("P003J6", "scmdbuf",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("P003J7", "scmdbuf",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
      };
   }

   public void getResults( int cursor ,
                           IFieldGetter rslt ,
                           Object[] buf ) throws SQLException
   {
      switch ( cursor )
      {
            case 0 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               ((boolean[]) buf[1])[0] = rslt.wasNull();
               ((byte[]) buf[2])[0] = rslt.getByte(2);
               ((boolean[]) buf[3])[0] = rslt.wasNull();
               ((short[]) buf[4])[0] = rslt.getShort(3);
               ((boolean[]) buf[5])[0] = rslt.wasNull();
               ((int[]) buf[6])[0] = rslt.getInt(4);
               ((short[]) buf[7])[0] = rslt.getShort(5);
               ((String[]) buf[8])[0] = rslt.getVarchar(6);
               ((String[]) buf[9])[0] = rslt.getVarchar(7);
               ((boolean[]) buf[10])[0] = rslt.wasNull();
               ((String[]) buf[11])[0] = rslt.getVarchar(8);
               ((boolean[]) buf[12])[0] = rslt.wasNull();
               ((String[]) buf[13])[0] = rslt.getVarchar(9);
               ((boolean[]) buf[14])[0] = rslt.wasNull();
               ((String[]) buf[15])[0] = rslt.getVarchar(10);
               ((String[]) buf[16])[0] = rslt.getVarchar(11);
               return;
            case 1 :
               ((String[]) buf[0])[0] = rslt.getVarchar(1);
               ((byte[]) buf[1])[0] = rslt.getByte(2);
               ((boolean[]) buf[2])[0] = rslt.wasNull();
               ((short[]) buf[3])[0] = rslt.getShort(3);
               ((boolean[]) buf[4])[0] = rslt.wasNull();
               ((short[]) buf[5])[0] = rslt.getShort(4);
               ((boolean[]) buf[6])[0] = rslt.wasNull();
               ((int[]) buf[7])[0] = rslt.getInt(5);
               ((short[]) buf[8])[0] = rslt.getShort(6);
               ((String[]) buf[9])[0] = rslt.getVarchar(7);
               ((String[]) buf[10])[0] = rslt.getVarchar(8);
               ((boolean[]) buf[11])[0] = rslt.wasNull();
               ((String[]) buf[12])[0] = rslt.getVarchar(9);
               ((boolean[]) buf[13])[0] = rslt.wasNull();
               ((String[]) buf[14])[0] = rslt.getVarchar(10);
               ((boolean[]) buf[15])[0] = rslt.wasNull();
               ((String[]) buf[16])[0] = rslt.getVarchar(11);
               return;
            case 2 :
               ((String[]) buf[0])[0] = rslt.getVarchar(1);
               ((boolean[]) buf[1])[0] = rslt.wasNull();
               ((byte[]) buf[2])[0] = rslt.getByte(2);
               ((boolean[]) buf[3])[0] = rslt.wasNull();
               ((short[]) buf[4])[0] = rslt.getShort(3);
               ((boolean[]) buf[5])[0] = rslt.wasNull();
               ((short[]) buf[6])[0] = rslt.getShort(4);
               ((boolean[]) buf[7])[0] = rslt.wasNull();
               ((int[]) buf[8])[0] = rslt.getInt(5);
               ((short[]) buf[9])[0] = rslt.getShort(6);
               ((String[]) buf[10])[0] = rslt.getVarchar(7);
               ((String[]) buf[11])[0] = rslt.getVarchar(8);
               ((boolean[]) buf[12])[0] = rslt.wasNull();
               ((String[]) buf[13])[0] = rslt.getVarchar(9);
               ((boolean[]) buf[14])[0] = rslt.wasNull();
               ((String[]) buf[15])[0] = rslt.getVarchar(10);
               ((String[]) buf[16])[0] = rslt.getVarchar(11);
               return;
            case 3 :
               ((String[]) buf[0])[0] = rslt.getVarchar(1);
               ((boolean[]) buf[1])[0] = rslt.wasNull();
               ((byte[]) buf[2])[0] = rslt.getByte(2);
               ((boolean[]) buf[3])[0] = rslt.wasNull();
               ((short[]) buf[4])[0] = rslt.getShort(3);
               ((boolean[]) buf[5])[0] = rslt.wasNull();
               ((short[]) buf[6])[0] = rslt.getShort(4);
               ((boolean[]) buf[7])[0] = rslt.wasNull();
               ((int[]) buf[8])[0] = rslt.getInt(5);
               ((short[]) buf[9])[0] = rslt.getShort(6);
               ((String[]) buf[10])[0] = rslt.getVarchar(7);
               ((String[]) buf[11])[0] = rslt.getVarchar(8);
               ((boolean[]) buf[12])[0] = rslt.wasNull();
               ((String[]) buf[13])[0] = rslt.getVarchar(9);
               ((boolean[]) buf[14])[0] = rslt.wasNull();
               ((String[]) buf[15])[0] = rslt.getVarchar(10);
               ((String[]) buf[16])[0] = rslt.getVarchar(11);
               return;
            case 4 :
               ((String[]) buf[0])[0] = rslt.getVarchar(1);
               ((boolean[]) buf[1])[0] = rslt.wasNull();
               ((byte[]) buf[2])[0] = rslt.getByte(2);
               ((boolean[]) buf[3])[0] = rslt.wasNull();
               ((short[]) buf[4])[0] = rslt.getShort(3);
               ((boolean[]) buf[5])[0] = rslt.wasNull();
               ((short[]) buf[6])[0] = rslt.getShort(4);
               ((boolean[]) buf[7])[0] = rslt.wasNull();
               ((int[]) buf[8])[0] = rslt.getInt(5);
               ((short[]) buf[9])[0] = rslt.getShort(6);
               ((String[]) buf[10])[0] = rslt.getVarchar(7);
               ((String[]) buf[11])[0] = rslt.getVarchar(8);
               ((boolean[]) buf[12])[0] = rslt.wasNull();
               ((String[]) buf[13])[0] = rslt.getVarchar(9);
               ((boolean[]) buf[14])[0] = rslt.wasNull();
               ((String[]) buf[15])[0] = rslt.getVarchar(10);
               ((String[]) buf[16])[0] = rslt.getVarchar(11);
               return;
            case 5 :
               ((String[]) buf[0])[0] = rslt.getVarchar(1);
               ((byte[]) buf[1])[0] = rslt.getByte(2);
               ((boolean[]) buf[2])[0] = rslt.wasNull();
               ((short[]) buf[3])[0] = rslt.getShort(3);
               ((boolean[]) buf[4])[0] = rslt.wasNull();
               ((short[]) buf[5])[0] = rslt.getShort(4);
               ((boolean[]) buf[6])[0] = rslt.wasNull();
               ((int[]) buf[7])[0] = rslt.getInt(5);
               ((short[]) buf[8])[0] = rslt.getShort(6);
               ((String[]) buf[9])[0] = rslt.getVarchar(7);
               ((boolean[]) buf[10])[0] = rslt.wasNull();
               ((String[]) buf[11])[0] = rslt.getVarchar(8);
               ((boolean[]) buf[12])[0] = rslt.wasNull();
               ((String[]) buf[13])[0] = rslt.getVarchar(9);
               ((boolean[]) buf[14])[0] = rslt.wasNull();
               ((String[]) buf[15])[0] = rslt.getVarchar(10);
               ((String[]) buf[16])[0] = rslt.getVarchar(11);
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
                  stmt.setVarchar(sIdx, (String)parms[33], 100);
               }
               if ( ((Number) parms[1]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[34], 100);
               }
               if ( ((Number) parms[2]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[35], 100);
               }
               if ( ((Number) parms[3]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[36], 100);
               }
               if ( ((Number) parms[4]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[37], 100);
               }
               if ( ((Number) parms[5]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[38], 100);
               }
               if ( ((Number) parms[6]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[39], 100);
               }
               if ( ((Number) parms[7]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[40], 100);
               }
               if ( ((Number) parms[8]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[41], 100);
               }
               if ( ((Number) parms[9]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[42], 100);
               }
               if ( ((Number) parms[10]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[43], 100);
               }
               if ( ((Number) parms[11]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[44]).shortValue());
               }
               if ( ((Number) parms[12]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[45]).shortValue());
               }
               if ( ((Number) parms[13]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[46]).intValue());
               }
               if ( ((Number) parms[14]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[47]).intValue());
               }
               if ( ((Number) parms[15]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[48]).shortValue());
               }
               if ( ((Number) parms[16]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[49]).shortValue());
               }
               if ( ((Number) parms[17]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[50], 15);
               }
               if ( ((Number) parms[18]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[51], 15);
               }
               if ( ((Number) parms[19]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[52], 100);
               }
               if ( ((Number) parms[20]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[53], 100);
               }
               if ( ((Number) parms[21]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[54], 40);
               }
               if ( ((Number) parms[22]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[55], 40);
               }
               if ( ((Number) parms[23]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[56], 40);
               }
               if ( ((Number) parms[24]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[57], 40);
               }
               if ( ((Number) parms[25]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[58]).shortValue());
               }
               if ( ((Number) parms[26]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[59]).shortValue());
               }
               if ( ((Number) parms[27]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[60], 40);
               }
               if ( ((Number) parms[28]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[61], 40);
               }
               if ( ((Number) parms[29]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setByte(sIdx, ((Number) parms[62]).byteValue());
               }
               if ( ((Number) parms[30]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setByte(sIdx, ((Number) parms[63]).byteValue());
               }
               if ( ((Number) parms[31]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[64], 300);
               }
               if ( ((Number) parms[32]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[65], 300);
               }
               return;
            case 1 :
               sIdx = (short)(0) ;
               if ( ((Number) parms[0]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[33], 100);
               }
               if ( ((Number) parms[1]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[34], 100);
               }
               if ( ((Number) parms[2]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[35], 100);
               }
               if ( ((Number) parms[3]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[36], 100);
               }
               if ( ((Number) parms[4]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[37], 100);
               }
               if ( ((Number) parms[5]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[38], 100);
               }
               if ( ((Number) parms[6]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[39], 100);
               }
               if ( ((Number) parms[7]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[40], 100);
               }
               if ( ((Number) parms[8]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[41], 100);
               }
               if ( ((Number) parms[9]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[42], 100);
               }
               if ( ((Number) parms[10]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[43], 100);
               }
               if ( ((Number) parms[11]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[44]).shortValue());
               }
               if ( ((Number) parms[12]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[45]).shortValue());
               }
               if ( ((Number) parms[13]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[46]).intValue());
               }
               if ( ((Number) parms[14]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[47]).intValue());
               }
               if ( ((Number) parms[15]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[48]).shortValue());
               }
               if ( ((Number) parms[16]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[49]).shortValue());
               }
               if ( ((Number) parms[17]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[50], 15);
               }
               if ( ((Number) parms[18]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[51], 15);
               }
               if ( ((Number) parms[19]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[52], 100);
               }
               if ( ((Number) parms[20]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[53], 100);
               }
               if ( ((Number) parms[21]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[54], 40);
               }
               if ( ((Number) parms[22]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[55], 40);
               }
               if ( ((Number) parms[23]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[56], 40);
               }
               if ( ((Number) parms[24]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[57], 40);
               }
               if ( ((Number) parms[25]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[58]).shortValue());
               }
               if ( ((Number) parms[26]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[59]).shortValue());
               }
               if ( ((Number) parms[27]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[60], 40);
               }
               if ( ((Number) parms[28]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[61], 40);
               }
               if ( ((Number) parms[29]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setByte(sIdx, ((Number) parms[62]).byteValue());
               }
               if ( ((Number) parms[30]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setByte(sIdx, ((Number) parms[63]).byteValue());
               }
               if ( ((Number) parms[31]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[64], 300);
               }
               if ( ((Number) parms[32]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[65], 300);
               }
               return;
            case 2 :
               sIdx = (short)(0) ;
               if ( ((Number) parms[0]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[33], 100);
               }
               if ( ((Number) parms[1]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[34], 100);
               }
               if ( ((Number) parms[2]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[35], 100);
               }
               if ( ((Number) parms[3]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[36], 100);
               }
               if ( ((Number) parms[4]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[37], 100);
               }
               if ( ((Number) parms[5]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[38], 100);
               }
               if ( ((Number) parms[6]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[39], 100);
               }
               if ( ((Number) parms[7]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[40], 100);
               }
               if ( ((Number) parms[8]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[41], 100);
               }
               if ( ((Number) parms[9]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[42], 100);
               }
               if ( ((Number) parms[10]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[43], 100);
               }
               if ( ((Number) parms[11]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[44]).shortValue());
               }
               if ( ((Number) parms[12]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[45]).shortValue());
               }
               if ( ((Number) parms[13]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[46]).intValue());
               }
               if ( ((Number) parms[14]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[47]).intValue());
               }
               if ( ((Number) parms[15]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[48]).shortValue());
               }
               if ( ((Number) parms[16]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[49]).shortValue());
               }
               if ( ((Number) parms[17]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[50], 15);
               }
               if ( ((Number) parms[18]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[51], 15);
               }
               if ( ((Number) parms[19]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[52], 100);
               }
               if ( ((Number) parms[20]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[53], 100);
               }
               if ( ((Number) parms[21]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[54], 40);
               }
               if ( ((Number) parms[22]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[55], 40);
               }
               if ( ((Number) parms[23]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[56], 40);
               }
               if ( ((Number) parms[24]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[57], 40);
               }
               if ( ((Number) parms[25]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[58]).shortValue());
               }
               if ( ((Number) parms[26]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[59]).shortValue());
               }
               if ( ((Number) parms[27]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[60], 40);
               }
               if ( ((Number) parms[28]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[61], 40);
               }
               if ( ((Number) parms[29]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setByte(sIdx, ((Number) parms[62]).byteValue());
               }
               if ( ((Number) parms[30]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setByte(sIdx, ((Number) parms[63]).byteValue());
               }
               if ( ((Number) parms[31]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[64], 300);
               }
               if ( ((Number) parms[32]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[65], 300);
               }
               return;
            case 3 :
               sIdx = (short)(0) ;
               if ( ((Number) parms[0]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[33], 100);
               }
               if ( ((Number) parms[1]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[34], 100);
               }
               if ( ((Number) parms[2]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[35], 100);
               }
               if ( ((Number) parms[3]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[36], 100);
               }
               if ( ((Number) parms[4]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[37], 100);
               }
               if ( ((Number) parms[5]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[38], 100);
               }
               if ( ((Number) parms[6]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[39], 100);
               }
               if ( ((Number) parms[7]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[40], 100);
               }
               if ( ((Number) parms[8]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[41], 100);
               }
               if ( ((Number) parms[9]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[42], 100);
               }
               if ( ((Number) parms[10]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[43], 100);
               }
               if ( ((Number) parms[11]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[44]).shortValue());
               }
               if ( ((Number) parms[12]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[45]).shortValue());
               }
               if ( ((Number) parms[13]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[46]).intValue());
               }
               if ( ((Number) parms[14]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[47]).intValue());
               }
               if ( ((Number) parms[15]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[48]).shortValue());
               }
               if ( ((Number) parms[16]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[49]).shortValue());
               }
               if ( ((Number) parms[17]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[50], 15);
               }
               if ( ((Number) parms[18]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[51], 15);
               }
               if ( ((Number) parms[19]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[52], 100);
               }
               if ( ((Number) parms[20]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[53], 100);
               }
               if ( ((Number) parms[21]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[54], 40);
               }
               if ( ((Number) parms[22]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[55], 40);
               }
               if ( ((Number) parms[23]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[56], 40);
               }
               if ( ((Number) parms[24]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[57], 40);
               }
               if ( ((Number) parms[25]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[58]).shortValue());
               }
               if ( ((Number) parms[26]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[59]).shortValue());
               }
               if ( ((Number) parms[27]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[60], 40);
               }
               if ( ((Number) parms[28]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[61], 40);
               }
               if ( ((Number) parms[29]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setByte(sIdx, ((Number) parms[62]).byteValue());
               }
               if ( ((Number) parms[30]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setByte(sIdx, ((Number) parms[63]).byteValue());
               }
               if ( ((Number) parms[31]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[64], 300);
               }
               if ( ((Number) parms[32]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[65], 300);
               }
               return;
            case 4 :
               sIdx = (short)(0) ;
               if ( ((Number) parms[0]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[33], 100);
               }
               if ( ((Number) parms[1]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[34], 100);
               }
               if ( ((Number) parms[2]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[35], 100);
               }
               if ( ((Number) parms[3]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[36], 100);
               }
               if ( ((Number) parms[4]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[37], 100);
               }
               if ( ((Number) parms[5]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[38], 100);
               }
               if ( ((Number) parms[6]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[39], 100);
               }
               if ( ((Number) parms[7]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[40], 100);
               }
               if ( ((Number) parms[8]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[41], 100);
               }
               if ( ((Number) parms[9]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[42], 100);
               }
               if ( ((Number) parms[10]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[43], 100);
               }
               if ( ((Number) parms[11]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[44]).shortValue());
               }
               if ( ((Number) parms[12]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[45]).shortValue());
               }
               if ( ((Number) parms[13]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[46]).intValue());
               }
               if ( ((Number) parms[14]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[47]).intValue());
               }
               if ( ((Number) parms[15]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[48]).shortValue());
               }
               if ( ((Number) parms[16]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[49]).shortValue());
               }
               if ( ((Number) parms[17]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[50], 15);
               }
               if ( ((Number) parms[18]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[51], 15);
               }
               if ( ((Number) parms[19]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[52], 100);
               }
               if ( ((Number) parms[20]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[53], 100);
               }
               if ( ((Number) parms[21]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[54], 40);
               }
               if ( ((Number) parms[22]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[55], 40);
               }
               if ( ((Number) parms[23]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[56], 40);
               }
               if ( ((Number) parms[24]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[57], 40);
               }
               if ( ((Number) parms[25]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[58]).shortValue());
               }
               if ( ((Number) parms[26]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[59]).shortValue());
               }
               if ( ((Number) parms[27]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[60], 40);
               }
               if ( ((Number) parms[28]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[61], 40);
               }
               if ( ((Number) parms[29]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setByte(sIdx, ((Number) parms[62]).byteValue());
               }
               if ( ((Number) parms[30]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setByte(sIdx, ((Number) parms[63]).byteValue());
               }
               if ( ((Number) parms[31]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[64], 300);
               }
               if ( ((Number) parms[32]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[65], 300);
               }
               return;
            case 5 :
               sIdx = (short)(0) ;
               if ( ((Number) parms[0]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[33], 100);
               }
               if ( ((Number) parms[1]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[34], 100);
               }
               if ( ((Number) parms[2]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[35], 100);
               }
               if ( ((Number) parms[3]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[36], 100);
               }
               if ( ((Number) parms[4]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[37], 100);
               }
               if ( ((Number) parms[5]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[38], 100);
               }
               if ( ((Number) parms[6]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[39], 100);
               }
               if ( ((Number) parms[7]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[40], 100);
               }
               if ( ((Number) parms[8]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[41], 100);
               }
               if ( ((Number) parms[9]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[42], 100);
               }
               if ( ((Number) parms[10]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[43], 100);
               }
               if ( ((Number) parms[11]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[44]).shortValue());
               }
               if ( ((Number) parms[12]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[45]).shortValue());
               }
               if ( ((Number) parms[13]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[46]).intValue());
               }
               if ( ((Number) parms[14]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[47]).intValue());
               }
               if ( ((Number) parms[15]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[48]).shortValue());
               }
               if ( ((Number) parms[16]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[49]).shortValue());
               }
               if ( ((Number) parms[17]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[50], 15);
               }
               if ( ((Number) parms[18]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[51], 15);
               }
               if ( ((Number) parms[19]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[52], 100);
               }
               if ( ((Number) parms[20]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[53], 100);
               }
               if ( ((Number) parms[21]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[54], 40);
               }
               if ( ((Number) parms[22]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[55], 40);
               }
               if ( ((Number) parms[23]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[56], 40);
               }
               if ( ((Number) parms[24]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[57], 40);
               }
               if ( ((Number) parms[25]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[58]).shortValue());
               }
               if ( ((Number) parms[26]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[59]).shortValue());
               }
               if ( ((Number) parms[27]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[60], 40);
               }
               if ( ((Number) parms[28]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[61], 40);
               }
               if ( ((Number) parms[29]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setByte(sIdx, ((Number) parms[62]).byteValue());
               }
               if ( ((Number) parms[30]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setByte(sIdx, ((Number) parms[63]).byteValue());
               }
               if ( ((Number) parms[31]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[64], 300);
               }
               if ( ((Number) parms[32]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[65], 300);
               }
               return;
      }
   }

}

