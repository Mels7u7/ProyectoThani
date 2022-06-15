package com.projectthani ;
import com.projectthani.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class serviciowwgetfilterdata extends GXProcedure
{
   public serviciowwgetfilterdata( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( serviciowwgetfilterdata.class ), "" );
   }

   public serviciowwgetfilterdata( int remoteHandle ,
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
      serviciowwgetfilterdata.this.aP5 = new String[] {""};
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
      serviciowwgetfilterdata.this.AV33DDOName = aP0;
      serviciowwgetfilterdata.this.AV31SearchTxt = aP1;
      serviciowwgetfilterdata.this.AV32SearchTxtTo = aP2;
      serviciowwgetfilterdata.this.aP3 = aP3;
      serviciowwgetfilterdata.this.aP4 = aP4;
      serviciowwgetfilterdata.this.aP5 = aP5;
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
      new com.projectthani.wwpbaseobjects.secisauthbyfunctionalitykey(remoteHandle, context).execute( "WWServicio", GXv_boolean2) ;
      serviciowwgetfilterdata.this.GXt_boolean1 = GXv_boolean2[0] ;
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
         if ( GXutil.strcmp(GXutil.upper( AV33DDOName), "DDO_SERVICIONOMBRE") == 0 )
         {
            /* Execute user subroutine: 'LOADSERVICIONOMBREOPTIONS' */
            S121 ();
            if ( returnInSub )
            {
               returnInSub = true;
               cleanup();
               if (true) return;
            }
         }
         else if ( GXutil.strcmp(GXutil.upper( AV33DDOName), "DDO_SERVICIODESCRIPCION") == 0 )
         {
            /* Execute user subroutine: 'LOADSERVICIODESCRIPCIONOPTIONS' */
            S131 ();
            if ( returnInSub )
            {
               returnInSub = true;
               cleanup();
               if (true) return;
            }
         }
         else if ( GXutil.strcmp(GXutil.upper( AV33DDOName), "DDO_LABORATORIONOMBRE") == 0 )
         {
            /* Execute user subroutine: 'LOADLABORATORIONOMBREOPTIONS' */
            S141 ();
            if ( returnInSub )
            {
               returnInSub = true;
               cleanup();
               if (true) return;
            }
         }
         else if ( GXutil.strcmp(GXutil.upper( AV33DDOName), "DDO_SERVICIOOBSERVACION") == 0 )
         {
            /* Execute user subroutine: 'LOADSERVICIOOBSERVACIONOPTIONS' */
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
      if ( GXutil.strcmp(AV44Session.getValue("ServicioWWGridState"), "") == 0 )
      {
         AV46GridState.fromxml(new com.projectthani.wwpbaseobjects.loadgridstate(remoteHandle, context).executeUdp( "ServicioWWGridState"), null, null);
      }
      else
      {
         AV46GridState.fromxml(AV44Session.getValue("ServicioWWGridState"), null, null);
      }
      AV52GXV1 = 1 ;
      while ( AV52GXV1 <= AV46GridState.getgxTv_SdtWWPGridState_Filtervalues().size() )
      {
         AV47GridStateFilterValue = (com.projectthani.wwpbaseobjects.SdtWWPGridState_FilterValue)((com.projectthani.wwpbaseobjects.SdtWWPGridState_FilterValue)AV46GridState.getgxTv_SdtWWPGridState_Filtervalues().elementAt(-1+AV52GXV1));
         if ( GXutil.strcmp(AV47GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "FILTERFULLTEXT") == 0 )
         {
            AV49FilterFullText = AV47GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV47GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFSERVICIOID") == 0 )
         {
            AV11TFServicioId = (short)(GXutil.lval( AV47GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value())) ;
            AV12TFServicioId_To = (short)(GXutil.lval( AV47GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Valueto())) ;
         }
         else if ( GXutil.strcmp(AV47GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFSERVICIONOMBRE") == 0 )
         {
            AV13TFServicioNombre = AV47GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV47GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFSERVICIONOMBRE_SEL") == 0 )
         {
            AV14TFServicioNombre_Sel = AV47GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV47GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFSERVICIODESCRIPCION") == 0 )
         {
            AV15TFServicioDescripcion = AV47GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV47GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFSERVICIODESCRIPCION_SEL") == 0 )
         {
            AV16TFServicioDescripcion_Sel = AV47GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV47GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFSERVICIOCOSTO") == 0 )
         {
            AV17TFServicioCosto = CommonUtil.decimalVal( AV47GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value(), ".") ;
            AV18TFServicioCosto_To = CommonUtil.decimalVal( AV47GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Valueto(), ".") ;
         }
         else if ( GXutil.strcmp(AV47GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFSERVICIOCATEGID") == 0 )
         {
            AV19TFServicioCategId = (short)(GXutil.lval( AV47GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value())) ;
            AV20TFServicioCategId_To = (short)(GXutil.lval( AV47GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Valueto())) ;
         }
         else if ( GXutil.strcmp(AV47GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFLABORATORIOID") == 0 )
         {
            AV21TFLaboratorioId = (short)(GXutil.lval( AV47GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value())) ;
            AV22TFLaboratorioId_To = (short)(GXutil.lval( AV47GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Valueto())) ;
         }
         else if ( GXutil.strcmp(AV47GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFLABORATORIONOMBRE") == 0 )
         {
            AV23TFLaboratorioNombre = AV47GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV47GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFLABORATORIONOMBRE_SEL") == 0 )
         {
            AV24TFLaboratorioNombre_Sel = AV47GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV47GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFSERVICIOCOMISION") == 0 )
         {
            AV25TFServicioComision = (short)(GXutil.lval( AV47GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value())) ;
            AV26TFServicioComision_To = (short)(GXutil.lval( AV47GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Valueto())) ;
         }
         else if ( GXutil.strcmp(AV47GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFSERVICIOOBSERVACION") == 0 )
         {
            AV27TFServicioObservacion = AV47GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV47GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFSERVICIOOBSERVACION_SEL") == 0 )
         {
            AV28TFServicioObservacion_Sel = AV47GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV47GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFSERVICIOESTADO_SEL") == 0 )
         {
            AV29TFServicioEstado_SelsJson = AV47GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            AV30TFServicioEstado_Sels.fromJSonString(AV29TFServicioEstado_SelsJson, null);
         }
         AV52GXV1 = (int)(AV52GXV1+1) ;
      }
   }

   public void S121( )
   {
      /* 'LOADSERVICIONOMBREOPTIONS' Routine */
      returnInSub = false ;
      AV13TFServicioNombre = AV31SearchTxt ;
      AV14TFServicioNombre_Sel = "" ;
      AV54Serviciowwds_1_filterfulltext = AV49FilterFullText ;
      AV55Serviciowwds_2_tfservicioid = AV11TFServicioId ;
      AV56Serviciowwds_3_tfservicioid_to = AV12TFServicioId_To ;
      AV57Serviciowwds_4_tfservicionombre = AV13TFServicioNombre ;
      AV58Serviciowwds_5_tfservicionombre_sel = AV14TFServicioNombre_Sel ;
      AV59Serviciowwds_6_tfserviciodescripcion = AV15TFServicioDescripcion ;
      AV60Serviciowwds_7_tfserviciodescripcion_sel = AV16TFServicioDescripcion_Sel ;
      AV61Serviciowwds_8_tfserviciocosto = AV17TFServicioCosto ;
      AV62Serviciowwds_9_tfserviciocosto_to = AV18TFServicioCosto_To ;
      AV63Serviciowwds_10_tfserviciocategid = AV19TFServicioCategId ;
      AV64Serviciowwds_11_tfserviciocategid_to = AV20TFServicioCategId_To ;
      AV65Serviciowwds_12_tflaboratorioid = AV21TFLaboratorioId ;
      AV66Serviciowwds_13_tflaboratorioid_to = AV22TFLaboratorioId_To ;
      AV67Serviciowwds_14_tflaboratorionombre = AV23TFLaboratorioNombre ;
      AV68Serviciowwds_15_tflaboratorionombre_sel = AV24TFLaboratorioNombre_Sel ;
      AV69Serviciowwds_16_tfserviciocomision = AV25TFServicioComision ;
      AV70Serviciowwds_17_tfserviciocomision_to = AV26TFServicioComision_To ;
      AV71Serviciowwds_18_tfservicioobservacion = AV27TFServicioObservacion ;
      AV72Serviciowwds_19_tfservicioobservacion_sel = AV28TFServicioObservacion_Sel ;
      AV73Serviciowwds_20_tfservicioestado_sels = AV30TFServicioEstado_Sels ;
      pr_default.dynParam(0, new Object[]{ new Object[]{
                                           A286ServicioEstado ,
                                           AV73Serviciowwds_20_tfservicioestado_sels ,
                                           AV54Serviciowwds_1_filterfulltext ,
                                           Short.valueOf(AV55Serviciowwds_2_tfservicioid) ,
                                           Short.valueOf(AV56Serviciowwds_3_tfservicioid_to) ,
                                           AV58Serviciowwds_5_tfservicionombre_sel ,
                                           AV57Serviciowwds_4_tfservicionombre ,
                                           AV60Serviciowwds_7_tfserviciodescripcion_sel ,
                                           AV59Serviciowwds_6_tfserviciodescripcion ,
                                           AV61Serviciowwds_8_tfserviciocosto ,
                                           AV62Serviciowwds_9_tfserviciocosto_to ,
                                           Short.valueOf(AV63Serviciowwds_10_tfserviciocategid) ,
                                           Short.valueOf(AV64Serviciowwds_11_tfserviciocategid_to) ,
                                           Short.valueOf(AV65Serviciowwds_12_tflaboratorioid) ,
                                           Short.valueOf(AV66Serviciowwds_13_tflaboratorioid_to) ,
                                           AV68Serviciowwds_15_tflaboratorionombre_sel ,
                                           AV67Serviciowwds_14_tflaboratorionombre ,
                                           Short.valueOf(AV69Serviciowwds_16_tfserviciocomision) ,
                                           Short.valueOf(AV70Serviciowwds_17_tfserviciocomision_to) ,
                                           AV72Serviciowwds_19_tfservicioobservacion_sel ,
                                           AV71Serviciowwds_18_tfservicioobservacion ,
                                           Integer.valueOf(AV73Serviciowwds_20_tfservicioestado_sels.size()) ,
                                           Short.valueOf(A27ServicioId) ,
                                           A281ServicioNombre ,
                                           A282ServicioDescripcion ,
                                           A283ServicioCosto ,
                                           Short.valueOf(A52ServicioCategId) ,
                                           Short.valueOf(A40LaboratorioId) ,
                                           A165LaboratorioNombre ,
                                           Short.valueOf(A284ServicioComision) ,
                                           A285ServicioObservacion } ,
                                           new int[]{
                                           TypeConstants.STRING, TypeConstants.STRING, TypeConstants.SHORT, TypeConstants.SHORT, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.DECIMAL, TypeConstants.DECIMAL,
                                           TypeConstants.SHORT, TypeConstants.SHORT, TypeConstants.SHORT, TypeConstants.SHORT, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.SHORT, TypeConstants.SHORT, TypeConstants.STRING, TypeConstants.STRING,
                                           TypeConstants.INT, TypeConstants.SHORT, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.DECIMAL, TypeConstants.SHORT, TypeConstants.SHORT, TypeConstants.STRING, TypeConstants.SHORT, TypeConstants.STRING
                                           }
      });
      lV54Serviciowwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV54Serviciowwds_1_filterfulltext), "%", "") ;
      lV54Serviciowwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV54Serviciowwds_1_filterfulltext), "%", "") ;
      lV54Serviciowwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV54Serviciowwds_1_filterfulltext), "%", "") ;
      lV54Serviciowwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV54Serviciowwds_1_filterfulltext), "%", "") ;
      lV54Serviciowwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV54Serviciowwds_1_filterfulltext), "%", "") ;
      lV54Serviciowwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV54Serviciowwds_1_filterfulltext), "%", "") ;
      lV54Serviciowwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV54Serviciowwds_1_filterfulltext), "%", "") ;
      lV54Serviciowwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV54Serviciowwds_1_filterfulltext), "%", "") ;
      lV54Serviciowwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV54Serviciowwds_1_filterfulltext), "%", "") ;
      lV54Serviciowwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV54Serviciowwds_1_filterfulltext), "%", "") ;
      lV54Serviciowwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV54Serviciowwds_1_filterfulltext), "%", "") ;
      lV57Serviciowwds_4_tfservicionombre = GXutil.concat( GXutil.rtrim( AV57Serviciowwds_4_tfservicionombre), "%", "") ;
      lV59Serviciowwds_6_tfserviciodescripcion = GXutil.concat( GXutil.rtrim( AV59Serviciowwds_6_tfserviciodescripcion), "%", "") ;
      lV67Serviciowwds_14_tflaboratorionombre = GXutil.concat( GXutil.rtrim( AV67Serviciowwds_14_tflaboratorionombre), "%", "") ;
      lV71Serviciowwds_18_tfservicioobservacion = GXutil.concat( GXutil.rtrim( AV71Serviciowwds_18_tfservicioobservacion), "%", "") ;
      /* Using cursor P003O2 */
      pr_default.execute(0, new Object[] {lV54Serviciowwds_1_filterfulltext, lV54Serviciowwds_1_filterfulltext, lV54Serviciowwds_1_filterfulltext, lV54Serviciowwds_1_filterfulltext, lV54Serviciowwds_1_filterfulltext, lV54Serviciowwds_1_filterfulltext, lV54Serviciowwds_1_filterfulltext, lV54Serviciowwds_1_filterfulltext, lV54Serviciowwds_1_filterfulltext, lV54Serviciowwds_1_filterfulltext, lV54Serviciowwds_1_filterfulltext, Short.valueOf(AV55Serviciowwds_2_tfservicioid), Short.valueOf(AV56Serviciowwds_3_tfservicioid_to), lV57Serviciowwds_4_tfservicionombre, AV58Serviciowwds_5_tfservicionombre_sel, lV59Serviciowwds_6_tfserviciodescripcion, AV60Serviciowwds_7_tfserviciodescripcion_sel, AV61Serviciowwds_8_tfserviciocosto, AV62Serviciowwds_9_tfserviciocosto_to, Short.valueOf(AV63Serviciowwds_10_tfserviciocategid), Short.valueOf(AV64Serviciowwds_11_tfserviciocategid_to), Short.valueOf(AV65Serviciowwds_12_tflaboratorioid), Short.valueOf(AV66Serviciowwds_13_tflaboratorioid_to), lV67Serviciowwds_14_tflaboratorionombre, AV68Serviciowwds_15_tflaboratorionombre_sel, Short.valueOf(AV69Serviciowwds_16_tfserviciocomision), Short.valueOf(AV70Serviciowwds_17_tfserviciocomision_to), lV71Serviciowwds_18_tfservicioobservacion, AV72Serviciowwds_19_tfservicioobservacion_sel});
      while ( (pr_default.getStatus(0) != 101) )
      {
         brk3O2 = false ;
         A281ServicioNombre = P003O2_A281ServicioNombre[0] ;
         A284ServicioComision = P003O2_A284ServicioComision[0] ;
         A40LaboratorioId = P003O2_A40LaboratorioId[0] ;
         A52ServicioCategId = P003O2_A52ServicioCategId[0] ;
         A283ServicioCosto = P003O2_A283ServicioCosto[0] ;
         A27ServicioId = P003O2_A27ServicioId[0] ;
         A286ServicioEstado = P003O2_A286ServicioEstado[0] ;
         A285ServicioObservacion = P003O2_A285ServicioObservacion[0] ;
         A165LaboratorioNombre = P003O2_A165LaboratorioNombre[0] ;
         A282ServicioDescripcion = P003O2_A282ServicioDescripcion[0] ;
         A40LaboratorioId = P003O2_A40LaboratorioId[0] ;
         A165LaboratorioNombre = P003O2_A165LaboratorioNombre[0] ;
         AV43count = 0 ;
         while ( (pr_default.getStatus(0) != 101) && ( GXutil.strcmp(P003O2_A281ServicioNombre[0], A281ServicioNombre) == 0 ) )
         {
            brk3O2 = false ;
            A27ServicioId = P003O2_A27ServicioId[0] ;
            AV43count = (long)(AV43count+1) ;
            brk3O2 = true ;
            pr_default.readNext(0);
         }
         if ( ! (GXutil.strcmp("", A281ServicioNombre)==0) )
         {
            AV35Option = A281ServicioNombre ;
            AV36Options.add(AV35Option, 0);
            AV41OptionIndexes.add(GXutil.trim( localUtil.format( DecimalUtil.doubleToDec(AV43count), "Z,ZZZ,ZZZ,ZZ9")), 0);
         }
         if ( AV36Options.size() == 50 )
         {
            /* Exit For each command. Update data (if necessary), close cursors & exit. */
            if (true) break;
         }
         if ( ! brk3O2 )
         {
            brk3O2 = true ;
            pr_default.readNext(0);
         }
      }
      pr_default.close(0);
   }

   public void S131( )
   {
      /* 'LOADSERVICIODESCRIPCIONOPTIONS' Routine */
      returnInSub = false ;
      AV15TFServicioDescripcion = AV31SearchTxt ;
      AV16TFServicioDescripcion_Sel = "" ;
      AV54Serviciowwds_1_filterfulltext = AV49FilterFullText ;
      AV55Serviciowwds_2_tfservicioid = AV11TFServicioId ;
      AV56Serviciowwds_3_tfservicioid_to = AV12TFServicioId_To ;
      AV57Serviciowwds_4_tfservicionombre = AV13TFServicioNombre ;
      AV58Serviciowwds_5_tfservicionombre_sel = AV14TFServicioNombre_Sel ;
      AV59Serviciowwds_6_tfserviciodescripcion = AV15TFServicioDescripcion ;
      AV60Serviciowwds_7_tfserviciodescripcion_sel = AV16TFServicioDescripcion_Sel ;
      AV61Serviciowwds_8_tfserviciocosto = AV17TFServicioCosto ;
      AV62Serviciowwds_9_tfserviciocosto_to = AV18TFServicioCosto_To ;
      AV63Serviciowwds_10_tfserviciocategid = AV19TFServicioCategId ;
      AV64Serviciowwds_11_tfserviciocategid_to = AV20TFServicioCategId_To ;
      AV65Serviciowwds_12_tflaboratorioid = AV21TFLaboratorioId ;
      AV66Serviciowwds_13_tflaboratorioid_to = AV22TFLaboratorioId_To ;
      AV67Serviciowwds_14_tflaboratorionombre = AV23TFLaboratorioNombre ;
      AV68Serviciowwds_15_tflaboratorionombre_sel = AV24TFLaboratorioNombre_Sel ;
      AV69Serviciowwds_16_tfserviciocomision = AV25TFServicioComision ;
      AV70Serviciowwds_17_tfserviciocomision_to = AV26TFServicioComision_To ;
      AV71Serviciowwds_18_tfservicioobservacion = AV27TFServicioObservacion ;
      AV72Serviciowwds_19_tfservicioobservacion_sel = AV28TFServicioObservacion_Sel ;
      AV73Serviciowwds_20_tfservicioestado_sels = AV30TFServicioEstado_Sels ;
      pr_default.dynParam(1, new Object[]{ new Object[]{
                                           A286ServicioEstado ,
                                           AV73Serviciowwds_20_tfservicioestado_sels ,
                                           AV54Serviciowwds_1_filterfulltext ,
                                           Short.valueOf(AV55Serviciowwds_2_tfservicioid) ,
                                           Short.valueOf(AV56Serviciowwds_3_tfservicioid_to) ,
                                           AV58Serviciowwds_5_tfservicionombre_sel ,
                                           AV57Serviciowwds_4_tfservicionombre ,
                                           AV60Serviciowwds_7_tfserviciodescripcion_sel ,
                                           AV59Serviciowwds_6_tfserviciodescripcion ,
                                           AV61Serviciowwds_8_tfserviciocosto ,
                                           AV62Serviciowwds_9_tfserviciocosto_to ,
                                           Short.valueOf(AV63Serviciowwds_10_tfserviciocategid) ,
                                           Short.valueOf(AV64Serviciowwds_11_tfserviciocategid_to) ,
                                           Short.valueOf(AV65Serviciowwds_12_tflaboratorioid) ,
                                           Short.valueOf(AV66Serviciowwds_13_tflaboratorioid_to) ,
                                           AV68Serviciowwds_15_tflaboratorionombre_sel ,
                                           AV67Serviciowwds_14_tflaboratorionombre ,
                                           Short.valueOf(AV69Serviciowwds_16_tfserviciocomision) ,
                                           Short.valueOf(AV70Serviciowwds_17_tfserviciocomision_to) ,
                                           AV72Serviciowwds_19_tfservicioobservacion_sel ,
                                           AV71Serviciowwds_18_tfservicioobservacion ,
                                           Integer.valueOf(AV73Serviciowwds_20_tfservicioestado_sels.size()) ,
                                           Short.valueOf(A27ServicioId) ,
                                           A281ServicioNombre ,
                                           A282ServicioDescripcion ,
                                           A283ServicioCosto ,
                                           Short.valueOf(A52ServicioCategId) ,
                                           Short.valueOf(A40LaboratorioId) ,
                                           A165LaboratorioNombre ,
                                           Short.valueOf(A284ServicioComision) ,
                                           A285ServicioObservacion } ,
                                           new int[]{
                                           TypeConstants.STRING, TypeConstants.STRING, TypeConstants.SHORT, TypeConstants.SHORT, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.DECIMAL, TypeConstants.DECIMAL,
                                           TypeConstants.SHORT, TypeConstants.SHORT, TypeConstants.SHORT, TypeConstants.SHORT, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.SHORT, TypeConstants.SHORT, TypeConstants.STRING, TypeConstants.STRING,
                                           TypeConstants.INT, TypeConstants.SHORT, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.DECIMAL, TypeConstants.SHORT, TypeConstants.SHORT, TypeConstants.STRING, TypeConstants.SHORT, TypeConstants.STRING
                                           }
      });
      lV54Serviciowwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV54Serviciowwds_1_filterfulltext), "%", "") ;
      lV54Serviciowwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV54Serviciowwds_1_filterfulltext), "%", "") ;
      lV54Serviciowwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV54Serviciowwds_1_filterfulltext), "%", "") ;
      lV54Serviciowwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV54Serviciowwds_1_filterfulltext), "%", "") ;
      lV54Serviciowwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV54Serviciowwds_1_filterfulltext), "%", "") ;
      lV54Serviciowwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV54Serviciowwds_1_filterfulltext), "%", "") ;
      lV54Serviciowwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV54Serviciowwds_1_filterfulltext), "%", "") ;
      lV54Serviciowwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV54Serviciowwds_1_filterfulltext), "%", "") ;
      lV54Serviciowwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV54Serviciowwds_1_filterfulltext), "%", "") ;
      lV54Serviciowwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV54Serviciowwds_1_filterfulltext), "%", "") ;
      lV54Serviciowwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV54Serviciowwds_1_filterfulltext), "%", "") ;
      lV57Serviciowwds_4_tfservicionombre = GXutil.concat( GXutil.rtrim( AV57Serviciowwds_4_tfservicionombre), "%", "") ;
      lV59Serviciowwds_6_tfserviciodescripcion = GXutil.concat( GXutil.rtrim( AV59Serviciowwds_6_tfserviciodescripcion), "%", "") ;
      lV67Serviciowwds_14_tflaboratorionombre = GXutil.concat( GXutil.rtrim( AV67Serviciowwds_14_tflaboratorionombre), "%", "") ;
      lV71Serviciowwds_18_tfservicioobservacion = GXutil.concat( GXutil.rtrim( AV71Serviciowwds_18_tfservicioobservacion), "%", "") ;
      /* Using cursor P003O3 */
      pr_default.execute(1, new Object[] {lV54Serviciowwds_1_filterfulltext, lV54Serviciowwds_1_filterfulltext, lV54Serviciowwds_1_filterfulltext, lV54Serviciowwds_1_filterfulltext, lV54Serviciowwds_1_filterfulltext, lV54Serviciowwds_1_filterfulltext, lV54Serviciowwds_1_filterfulltext, lV54Serviciowwds_1_filterfulltext, lV54Serviciowwds_1_filterfulltext, lV54Serviciowwds_1_filterfulltext, lV54Serviciowwds_1_filterfulltext, Short.valueOf(AV55Serviciowwds_2_tfservicioid), Short.valueOf(AV56Serviciowwds_3_tfservicioid_to), lV57Serviciowwds_4_tfservicionombre, AV58Serviciowwds_5_tfservicionombre_sel, lV59Serviciowwds_6_tfserviciodescripcion, AV60Serviciowwds_7_tfserviciodescripcion_sel, AV61Serviciowwds_8_tfserviciocosto, AV62Serviciowwds_9_tfserviciocosto_to, Short.valueOf(AV63Serviciowwds_10_tfserviciocategid), Short.valueOf(AV64Serviciowwds_11_tfserviciocategid_to), Short.valueOf(AV65Serviciowwds_12_tflaboratorioid), Short.valueOf(AV66Serviciowwds_13_tflaboratorioid_to), lV67Serviciowwds_14_tflaboratorionombre, AV68Serviciowwds_15_tflaboratorionombre_sel, Short.valueOf(AV69Serviciowwds_16_tfserviciocomision), Short.valueOf(AV70Serviciowwds_17_tfserviciocomision_to), lV71Serviciowwds_18_tfservicioobservacion, AV72Serviciowwds_19_tfservicioobservacion_sel});
      while ( (pr_default.getStatus(1) != 101) )
      {
         brk3O4 = false ;
         A282ServicioDescripcion = P003O3_A282ServicioDescripcion[0] ;
         A284ServicioComision = P003O3_A284ServicioComision[0] ;
         A40LaboratorioId = P003O3_A40LaboratorioId[0] ;
         A52ServicioCategId = P003O3_A52ServicioCategId[0] ;
         A283ServicioCosto = P003O3_A283ServicioCosto[0] ;
         A27ServicioId = P003O3_A27ServicioId[0] ;
         A286ServicioEstado = P003O3_A286ServicioEstado[0] ;
         A285ServicioObservacion = P003O3_A285ServicioObservacion[0] ;
         A165LaboratorioNombre = P003O3_A165LaboratorioNombre[0] ;
         A281ServicioNombre = P003O3_A281ServicioNombre[0] ;
         A40LaboratorioId = P003O3_A40LaboratorioId[0] ;
         A165LaboratorioNombre = P003O3_A165LaboratorioNombre[0] ;
         AV43count = 0 ;
         while ( (pr_default.getStatus(1) != 101) && ( GXutil.strcmp(P003O3_A282ServicioDescripcion[0], A282ServicioDescripcion) == 0 ) )
         {
            brk3O4 = false ;
            A27ServicioId = P003O3_A27ServicioId[0] ;
            AV43count = (long)(AV43count+1) ;
            brk3O4 = true ;
            pr_default.readNext(1);
         }
         if ( ! (GXutil.strcmp("", A282ServicioDescripcion)==0) )
         {
            AV35Option = A282ServicioDescripcion ;
            AV36Options.add(AV35Option, 0);
            AV41OptionIndexes.add(GXutil.trim( localUtil.format( DecimalUtil.doubleToDec(AV43count), "Z,ZZZ,ZZZ,ZZ9")), 0);
         }
         if ( AV36Options.size() == 50 )
         {
            /* Exit For each command. Update data (if necessary), close cursors & exit. */
            if (true) break;
         }
         if ( ! brk3O4 )
         {
            brk3O4 = true ;
            pr_default.readNext(1);
         }
      }
      pr_default.close(1);
   }

   public void S141( )
   {
      /* 'LOADLABORATORIONOMBREOPTIONS' Routine */
      returnInSub = false ;
      AV23TFLaboratorioNombre = AV31SearchTxt ;
      AV24TFLaboratorioNombre_Sel = "" ;
      AV54Serviciowwds_1_filterfulltext = AV49FilterFullText ;
      AV55Serviciowwds_2_tfservicioid = AV11TFServicioId ;
      AV56Serviciowwds_3_tfservicioid_to = AV12TFServicioId_To ;
      AV57Serviciowwds_4_tfservicionombre = AV13TFServicioNombre ;
      AV58Serviciowwds_5_tfservicionombre_sel = AV14TFServicioNombre_Sel ;
      AV59Serviciowwds_6_tfserviciodescripcion = AV15TFServicioDescripcion ;
      AV60Serviciowwds_7_tfserviciodescripcion_sel = AV16TFServicioDescripcion_Sel ;
      AV61Serviciowwds_8_tfserviciocosto = AV17TFServicioCosto ;
      AV62Serviciowwds_9_tfserviciocosto_to = AV18TFServicioCosto_To ;
      AV63Serviciowwds_10_tfserviciocategid = AV19TFServicioCategId ;
      AV64Serviciowwds_11_tfserviciocategid_to = AV20TFServicioCategId_To ;
      AV65Serviciowwds_12_tflaboratorioid = AV21TFLaboratorioId ;
      AV66Serviciowwds_13_tflaboratorioid_to = AV22TFLaboratorioId_To ;
      AV67Serviciowwds_14_tflaboratorionombre = AV23TFLaboratorioNombre ;
      AV68Serviciowwds_15_tflaboratorionombre_sel = AV24TFLaboratorioNombre_Sel ;
      AV69Serviciowwds_16_tfserviciocomision = AV25TFServicioComision ;
      AV70Serviciowwds_17_tfserviciocomision_to = AV26TFServicioComision_To ;
      AV71Serviciowwds_18_tfservicioobservacion = AV27TFServicioObservacion ;
      AV72Serviciowwds_19_tfservicioobservacion_sel = AV28TFServicioObservacion_Sel ;
      AV73Serviciowwds_20_tfservicioestado_sels = AV30TFServicioEstado_Sels ;
      pr_default.dynParam(2, new Object[]{ new Object[]{
                                           A286ServicioEstado ,
                                           AV73Serviciowwds_20_tfservicioestado_sels ,
                                           AV54Serviciowwds_1_filterfulltext ,
                                           Short.valueOf(AV55Serviciowwds_2_tfservicioid) ,
                                           Short.valueOf(AV56Serviciowwds_3_tfservicioid_to) ,
                                           AV58Serviciowwds_5_tfservicionombre_sel ,
                                           AV57Serviciowwds_4_tfservicionombre ,
                                           AV60Serviciowwds_7_tfserviciodescripcion_sel ,
                                           AV59Serviciowwds_6_tfserviciodescripcion ,
                                           AV61Serviciowwds_8_tfserviciocosto ,
                                           AV62Serviciowwds_9_tfserviciocosto_to ,
                                           Short.valueOf(AV63Serviciowwds_10_tfserviciocategid) ,
                                           Short.valueOf(AV64Serviciowwds_11_tfserviciocategid_to) ,
                                           Short.valueOf(AV65Serviciowwds_12_tflaboratorioid) ,
                                           Short.valueOf(AV66Serviciowwds_13_tflaboratorioid_to) ,
                                           AV68Serviciowwds_15_tflaboratorionombre_sel ,
                                           AV67Serviciowwds_14_tflaboratorionombre ,
                                           Short.valueOf(AV69Serviciowwds_16_tfserviciocomision) ,
                                           Short.valueOf(AV70Serviciowwds_17_tfserviciocomision_to) ,
                                           AV72Serviciowwds_19_tfservicioobservacion_sel ,
                                           AV71Serviciowwds_18_tfservicioobservacion ,
                                           Integer.valueOf(AV73Serviciowwds_20_tfservicioestado_sels.size()) ,
                                           Short.valueOf(A27ServicioId) ,
                                           A281ServicioNombre ,
                                           A282ServicioDescripcion ,
                                           A283ServicioCosto ,
                                           Short.valueOf(A52ServicioCategId) ,
                                           Short.valueOf(A40LaboratorioId) ,
                                           A165LaboratorioNombre ,
                                           Short.valueOf(A284ServicioComision) ,
                                           A285ServicioObservacion } ,
                                           new int[]{
                                           TypeConstants.STRING, TypeConstants.STRING, TypeConstants.SHORT, TypeConstants.SHORT, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.DECIMAL, TypeConstants.DECIMAL,
                                           TypeConstants.SHORT, TypeConstants.SHORT, TypeConstants.SHORT, TypeConstants.SHORT, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.SHORT, TypeConstants.SHORT, TypeConstants.STRING, TypeConstants.STRING,
                                           TypeConstants.INT, TypeConstants.SHORT, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.DECIMAL, TypeConstants.SHORT, TypeConstants.SHORT, TypeConstants.STRING, TypeConstants.SHORT, TypeConstants.STRING
                                           }
      });
      lV54Serviciowwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV54Serviciowwds_1_filterfulltext), "%", "") ;
      lV54Serviciowwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV54Serviciowwds_1_filterfulltext), "%", "") ;
      lV54Serviciowwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV54Serviciowwds_1_filterfulltext), "%", "") ;
      lV54Serviciowwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV54Serviciowwds_1_filterfulltext), "%", "") ;
      lV54Serviciowwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV54Serviciowwds_1_filterfulltext), "%", "") ;
      lV54Serviciowwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV54Serviciowwds_1_filterfulltext), "%", "") ;
      lV54Serviciowwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV54Serviciowwds_1_filterfulltext), "%", "") ;
      lV54Serviciowwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV54Serviciowwds_1_filterfulltext), "%", "") ;
      lV54Serviciowwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV54Serviciowwds_1_filterfulltext), "%", "") ;
      lV54Serviciowwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV54Serviciowwds_1_filterfulltext), "%", "") ;
      lV54Serviciowwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV54Serviciowwds_1_filterfulltext), "%", "") ;
      lV57Serviciowwds_4_tfservicionombre = GXutil.concat( GXutil.rtrim( AV57Serviciowwds_4_tfservicionombre), "%", "") ;
      lV59Serviciowwds_6_tfserviciodescripcion = GXutil.concat( GXutil.rtrim( AV59Serviciowwds_6_tfserviciodescripcion), "%", "") ;
      lV67Serviciowwds_14_tflaboratorionombre = GXutil.concat( GXutil.rtrim( AV67Serviciowwds_14_tflaboratorionombre), "%", "") ;
      lV71Serviciowwds_18_tfservicioobservacion = GXutil.concat( GXutil.rtrim( AV71Serviciowwds_18_tfservicioobservacion), "%", "") ;
      /* Using cursor P003O4 */
      pr_default.execute(2, new Object[] {lV54Serviciowwds_1_filterfulltext, lV54Serviciowwds_1_filterfulltext, lV54Serviciowwds_1_filterfulltext, lV54Serviciowwds_1_filterfulltext, lV54Serviciowwds_1_filterfulltext, lV54Serviciowwds_1_filterfulltext, lV54Serviciowwds_1_filterfulltext, lV54Serviciowwds_1_filterfulltext, lV54Serviciowwds_1_filterfulltext, lV54Serviciowwds_1_filterfulltext, lV54Serviciowwds_1_filterfulltext, Short.valueOf(AV55Serviciowwds_2_tfservicioid), Short.valueOf(AV56Serviciowwds_3_tfservicioid_to), lV57Serviciowwds_4_tfservicionombre, AV58Serviciowwds_5_tfservicionombre_sel, lV59Serviciowwds_6_tfserviciodescripcion, AV60Serviciowwds_7_tfserviciodescripcion_sel, AV61Serviciowwds_8_tfserviciocosto, AV62Serviciowwds_9_tfserviciocosto_to, Short.valueOf(AV63Serviciowwds_10_tfserviciocategid), Short.valueOf(AV64Serviciowwds_11_tfserviciocategid_to), Short.valueOf(AV65Serviciowwds_12_tflaboratorioid), Short.valueOf(AV66Serviciowwds_13_tflaboratorioid_to), lV67Serviciowwds_14_tflaboratorionombre, AV68Serviciowwds_15_tflaboratorionombre_sel, Short.valueOf(AV69Serviciowwds_16_tfserviciocomision), Short.valueOf(AV70Serviciowwds_17_tfserviciocomision_to), lV71Serviciowwds_18_tfservicioobservacion, AV72Serviciowwds_19_tfservicioobservacion_sel});
      while ( (pr_default.getStatus(2) != 101) )
      {
         brk3O6 = false ;
         A165LaboratorioNombre = P003O4_A165LaboratorioNombre[0] ;
         A284ServicioComision = P003O4_A284ServicioComision[0] ;
         A40LaboratorioId = P003O4_A40LaboratorioId[0] ;
         A52ServicioCategId = P003O4_A52ServicioCategId[0] ;
         A283ServicioCosto = P003O4_A283ServicioCosto[0] ;
         A27ServicioId = P003O4_A27ServicioId[0] ;
         A286ServicioEstado = P003O4_A286ServicioEstado[0] ;
         A285ServicioObservacion = P003O4_A285ServicioObservacion[0] ;
         A282ServicioDescripcion = P003O4_A282ServicioDescripcion[0] ;
         A281ServicioNombre = P003O4_A281ServicioNombre[0] ;
         A40LaboratorioId = P003O4_A40LaboratorioId[0] ;
         A165LaboratorioNombre = P003O4_A165LaboratorioNombre[0] ;
         AV43count = 0 ;
         while ( (pr_default.getStatus(2) != 101) && ( GXutil.strcmp(P003O4_A165LaboratorioNombre[0], A165LaboratorioNombre) == 0 ) )
         {
            brk3O6 = false ;
            A40LaboratorioId = P003O4_A40LaboratorioId[0] ;
            A52ServicioCategId = P003O4_A52ServicioCategId[0] ;
            A27ServicioId = P003O4_A27ServicioId[0] ;
            A40LaboratorioId = P003O4_A40LaboratorioId[0] ;
            AV43count = (long)(AV43count+1) ;
            brk3O6 = true ;
            pr_default.readNext(2);
         }
         if ( ! (GXutil.strcmp("", A165LaboratorioNombre)==0) )
         {
            AV35Option = A165LaboratorioNombre ;
            AV36Options.add(AV35Option, 0);
            AV41OptionIndexes.add(GXutil.trim( localUtil.format( DecimalUtil.doubleToDec(AV43count), "Z,ZZZ,ZZZ,ZZ9")), 0);
         }
         if ( AV36Options.size() == 50 )
         {
            /* Exit For each command. Update data (if necessary), close cursors & exit. */
            if (true) break;
         }
         if ( ! brk3O6 )
         {
            brk3O6 = true ;
            pr_default.readNext(2);
         }
      }
      pr_default.close(2);
   }

   public void S151( )
   {
      /* 'LOADSERVICIOOBSERVACIONOPTIONS' Routine */
      returnInSub = false ;
      AV27TFServicioObservacion = AV31SearchTxt ;
      AV28TFServicioObservacion_Sel = "" ;
      AV54Serviciowwds_1_filterfulltext = AV49FilterFullText ;
      AV55Serviciowwds_2_tfservicioid = AV11TFServicioId ;
      AV56Serviciowwds_3_tfservicioid_to = AV12TFServicioId_To ;
      AV57Serviciowwds_4_tfservicionombre = AV13TFServicioNombre ;
      AV58Serviciowwds_5_tfservicionombre_sel = AV14TFServicioNombre_Sel ;
      AV59Serviciowwds_6_tfserviciodescripcion = AV15TFServicioDescripcion ;
      AV60Serviciowwds_7_tfserviciodescripcion_sel = AV16TFServicioDescripcion_Sel ;
      AV61Serviciowwds_8_tfserviciocosto = AV17TFServicioCosto ;
      AV62Serviciowwds_9_tfserviciocosto_to = AV18TFServicioCosto_To ;
      AV63Serviciowwds_10_tfserviciocategid = AV19TFServicioCategId ;
      AV64Serviciowwds_11_tfserviciocategid_to = AV20TFServicioCategId_To ;
      AV65Serviciowwds_12_tflaboratorioid = AV21TFLaboratorioId ;
      AV66Serviciowwds_13_tflaboratorioid_to = AV22TFLaboratorioId_To ;
      AV67Serviciowwds_14_tflaboratorionombre = AV23TFLaboratorioNombre ;
      AV68Serviciowwds_15_tflaboratorionombre_sel = AV24TFLaboratorioNombre_Sel ;
      AV69Serviciowwds_16_tfserviciocomision = AV25TFServicioComision ;
      AV70Serviciowwds_17_tfserviciocomision_to = AV26TFServicioComision_To ;
      AV71Serviciowwds_18_tfservicioobservacion = AV27TFServicioObservacion ;
      AV72Serviciowwds_19_tfservicioobservacion_sel = AV28TFServicioObservacion_Sel ;
      AV73Serviciowwds_20_tfservicioestado_sels = AV30TFServicioEstado_Sels ;
      pr_default.dynParam(3, new Object[]{ new Object[]{
                                           A286ServicioEstado ,
                                           AV73Serviciowwds_20_tfservicioestado_sels ,
                                           AV54Serviciowwds_1_filterfulltext ,
                                           Short.valueOf(AV55Serviciowwds_2_tfservicioid) ,
                                           Short.valueOf(AV56Serviciowwds_3_tfservicioid_to) ,
                                           AV58Serviciowwds_5_tfservicionombre_sel ,
                                           AV57Serviciowwds_4_tfservicionombre ,
                                           AV60Serviciowwds_7_tfserviciodescripcion_sel ,
                                           AV59Serviciowwds_6_tfserviciodescripcion ,
                                           AV61Serviciowwds_8_tfserviciocosto ,
                                           AV62Serviciowwds_9_tfserviciocosto_to ,
                                           Short.valueOf(AV63Serviciowwds_10_tfserviciocategid) ,
                                           Short.valueOf(AV64Serviciowwds_11_tfserviciocategid_to) ,
                                           Short.valueOf(AV65Serviciowwds_12_tflaboratorioid) ,
                                           Short.valueOf(AV66Serviciowwds_13_tflaboratorioid_to) ,
                                           AV68Serviciowwds_15_tflaboratorionombre_sel ,
                                           AV67Serviciowwds_14_tflaboratorionombre ,
                                           Short.valueOf(AV69Serviciowwds_16_tfserviciocomision) ,
                                           Short.valueOf(AV70Serviciowwds_17_tfserviciocomision_to) ,
                                           AV72Serviciowwds_19_tfservicioobservacion_sel ,
                                           AV71Serviciowwds_18_tfservicioobservacion ,
                                           Integer.valueOf(AV73Serviciowwds_20_tfservicioestado_sels.size()) ,
                                           Short.valueOf(A27ServicioId) ,
                                           A281ServicioNombre ,
                                           A282ServicioDescripcion ,
                                           A283ServicioCosto ,
                                           Short.valueOf(A52ServicioCategId) ,
                                           Short.valueOf(A40LaboratorioId) ,
                                           A165LaboratorioNombre ,
                                           Short.valueOf(A284ServicioComision) ,
                                           A285ServicioObservacion } ,
                                           new int[]{
                                           TypeConstants.STRING, TypeConstants.STRING, TypeConstants.SHORT, TypeConstants.SHORT, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.DECIMAL, TypeConstants.DECIMAL,
                                           TypeConstants.SHORT, TypeConstants.SHORT, TypeConstants.SHORT, TypeConstants.SHORT, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.SHORT, TypeConstants.SHORT, TypeConstants.STRING, TypeConstants.STRING,
                                           TypeConstants.INT, TypeConstants.SHORT, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.DECIMAL, TypeConstants.SHORT, TypeConstants.SHORT, TypeConstants.STRING, TypeConstants.SHORT, TypeConstants.STRING
                                           }
      });
      lV54Serviciowwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV54Serviciowwds_1_filterfulltext), "%", "") ;
      lV54Serviciowwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV54Serviciowwds_1_filterfulltext), "%", "") ;
      lV54Serviciowwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV54Serviciowwds_1_filterfulltext), "%", "") ;
      lV54Serviciowwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV54Serviciowwds_1_filterfulltext), "%", "") ;
      lV54Serviciowwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV54Serviciowwds_1_filterfulltext), "%", "") ;
      lV54Serviciowwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV54Serviciowwds_1_filterfulltext), "%", "") ;
      lV54Serviciowwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV54Serviciowwds_1_filterfulltext), "%", "") ;
      lV54Serviciowwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV54Serviciowwds_1_filterfulltext), "%", "") ;
      lV54Serviciowwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV54Serviciowwds_1_filterfulltext), "%", "") ;
      lV54Serviciowwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV54Serviciowwds_1_filterfulltext), "%", "") ;
      lV54Serviciowwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV54Serviciowwds_1_filterfulltext), "%", "") ;
      lV57Serviciowwds_4_tfservicionombre = GXutil.concat( GXutil.rtrim( AV57Serviciowwds_4_tfservicionombre), "%", "") ;
      lV59Serviciowwds_6_tfserviciodescripcion = GXutil.concat( GXutil.rtrim( AV59Serviciowwds_6_tfserviciodescripcion), "%", "") ;
      lV67Serviciowwds_14_tflaboratorionombre = GXutil.concat( GXutil.rtrim( AV67Serviciowwds_14_tflaboratorionombre), "%", "") ;
      lV71Serviciowwds_18_tfservicioobservacion = GXutil.concat( GXutil.rtrim( AV71Serviciowwds_18_tfservicioobservacion), "%", "") ;
      /* Using cursor P003O5 */
      pr_default.execute(3, new Object[] {lV54Serviciowwds_1_filterfulltext, lV54Serviciowwds_1_filterfulltext, lV54Serviciowwds_1_filterfulltext, lV54Serviciowwds_1_filterfulltext, lV54Serviciowwds_1_filterfulltext, lV54Serviciowwds_1_filterfulltext, lV54Serviciowwds_1_filterfulltext, lV54Serviciowwds_1_filterfulltext, lV54Serviciowwds_1_filterfulltext, lV54Serviciowwds_1_filterfulltext, lV54Serviciowwds_1_filterfulltext, Short.valueOf(AV55Serviciowwds_2_tfservicioid), Short.valueOf(AV56Serviciowwds_3_tfservicioid_to), lV57Serviciowwds_4_tfservicionombre, AV58Serviciowwds_5_tfservicionombre_sel, lV59Serviciowwds_6_tfserviciodescripcion, AV60Serviciowwds_7_tfserviciodescripcion_sel, AV61Serviciowwds_8_tfserviciocosto, AV62Serviciowwds_9_tfserviciocosto_to, Short.valueOf(AV63Serviciowwds_10_tfserviciocategid), Short.valueOf(AV64Serviciowwds_11_tfserviciocategid_to), Short.valueOf(AV65Serviciowwds_12_tflaboratorioid), Short.valueOf(AV66Serviciowwds_13_tflaboratorioid_to), lV67Serviciowwds_14_tflaboratorionombre, AV68Serviciowwds_15_tflaboratorionombre_sel, Short.valueOf(AV69Serviciowwds_16_tfserviciocomision), Short.valueOf(AV70Serviciowwds_17_tfserviciocomision_to), lV71Serviciowwds_18_tfservicioobservacion, AV72Serviciowwds_19_tfservicioobservacion_sel});
      while ( (pr_default.getStatus(3) != 101) )
      {
         brk3O8 = false ;
         A285ServicioObservacion = P003O5_A285ServicioObservacion[0] ;
         A284ServicioComision = P003O5_A284ServicioComision[0] ;
         A40LaboratorioId = P003O5_A40LaboratorioId[0] ;
         A52ServicioCategId = P003O5_A52ServicioCategId[0] ;
         A283ServicioCosto = P003O5_A283ServicioCosto[0] ;
         A27ServicioId = P003O5_A27ServicioId[0] ;
         A286ServicioEstado = P003O5_A286ServicioEstado[0] ;
         A165LaboratorioNombre = P003O5_A165LaboratorioNombre[0] ;
         A282ServicioDescripcion = P003O5_A282ServicioDescripcion[0] ;
         A281ServicioNombre = P003O5_A281ServicioNombre[0] ;
         A40LaboratorioId = P003O5_A40LaboratorioId[0] ;
         A165LaboratorioNombre = P003O5_A165LaboratorioNombre[0] ;
         AV43count = 0 ;
         while ( (pr_default.getStatus(3) != 101) && ( GXutil.strcmp(P003O5_A285ServicioObservacion[0], A285ServicioObservacion) == 0 ) )
         {
            brk3O8 = false ;
            A27ServicioId = P003O5_A27ServicioId[0] ;
            AV43count = (long)(AV43count+1) ;
            brk3O8 = true ;
            pr_default.readNext(3);
         }
         if ( ! (GXutil.strcmp("", A285ServicioObservacion)==0) )
         {
            AV35Option = A285ServicioObservacion ;
            AV36Options.add(AV35Option, 0);
            AV41OptionIndexes.add(GXutil.trim( localUtil.format( DecimalUtil.doubleToDec(AV43count), "Z,ZZZ,ZZZ,ZZ9")), 0);
         }
         if ( AV36Options.size() == 50 )
         {
            /* Exit For each command. Update data (if necessary), close cursors & exit. */
            if (true) break;
         }
         if ( ! brk3O8 )
         {
            brk3O8 = true ;
            pr_default.readNext(3);
         }
      }
      pr_default.close(3);
   }

   protected void cleanup( )
   {
      this.aP3[0] = serviciowwgetfilterdata.this.AV37OptionsJson;
      this.aP4[0] = serviciowwgetfilterdata.this.AV40OptionsDescJson;
      this.aP5[0] = serviciowwgetfilterdata.this.AV42OptionIndexesJson;
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
      AV13TFServicioNombre = "" ;
      AV14TFServicioNombre_Sel = "" ;
      AV15TFServicioDescripcion = "" ;
      AV16TFServicioDescripcion_Sel = "" ;
      AV17TFServicioCosto = DecimalUtil.ZERO ;
      AV18TFServicioCosto_To = DecimalUtil.ZERO ;
      AV23TFLaboratorioNombre = "" ;
      AV24TFLaboratorioNombre_Sel = "" ;
      AV27TFServicioObservacion = "" ;
      AV28TFServicioObservacion_Sel = "" ;
      AV29TFServicioEstado_SelsJson = "" ;
      AV30TFServicioEstado_Sels = new GXSimpleCollection<String>(String.class, "internal", "");
      A281ServicioNombre = "" ;
      AV54Serviciowwds_1_filterfulltext = "" ;
      AV57Serviciowwds_4_tfservicionombre = "" ;
      AV58Serviciowwds_5_tfservicionombre_sel = "" ;
      AV59Serviciowwds_6_tfserviciodescripcion = "" ;
      AV60Serviciowwds_7_tfserviciodescripcion_sel = "" ;
      AV61Serviciowwds_8_tfserviciocosto = DecimalUtil.ZERO ;
      AV62Serviciowwds_9_tfserviciocosto_to = DecimalUtil.ZERO ;
      AV67Serviciowwds_14_tflaboratorionombre = "" ;
      AV68Serviciowwds_15_tflaboratorionombre_sel = "" ;
      AV71Serviciowwds_18_tfservicioobservacion = "" ;
      AV72Serviciowwds_19_tfservicioobservacion_sel = "" ;
      AV73Serviciowwds_20_tfservicioestado_sels = new GXSimpleCollection<String>(String.class, "internal", "");
      scmdbuf = "" ;
      lV54Serviciowwds_1_filterfulltext = "" ;
      lV57Serviciowwds_4_tfservicionombre = "" ;
      lV59Serviciowwds_6_tfserviciodescripcion = "" ;
      lV67Serviciowwds_14_tflaboratorionombre = "" ;
      lV71Serviciowwds_18_tfservicioobservacion = "" ;
      A286ServicioEstado = "" ;
      A282ServicioDescripcion = "" ;
      A283ServicioCosto = DecimalUtil.ZERO ;
      A165LaboratorioNombre = "" ;
      A285ServicioObservacion = "" ;
      P003O2_A281ServicioNombre = new String[] {""} ;
      P003O2_A284ServicioComision = new short[1] ;
      P003O2_A40LaboratorioId = new short[1] ;
      P003O2_A52ServicioCategId = new short[1] ;
      P003O2_A283ServicioCosto = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      P003O2_A27ServicioId = new short[1] ;
      P003O2_A286ServicioEstado = new String[] {""} ;
      P003O2_A285ServicioObservacion = new String[] {""} ;
      P003O2_A165LaboratorioNombre = new String[] {""} ;
      P003O2_A282ServicioDescripcion = new String[] {""} ;
      AV35Option = "" ;
      P003O3_A282ServicioDescripcion = new String[] {""} ;
      P003O3_A284ServicioComision = new short[1] ;
      P003O3_A40LaboratorioId = new short[1] ;
      P003O3_A52ServicioCategId = new short[1] ;
      P003O3_A283ServicioCosto = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      P003O3_A27ServicioId = new short[1] ;
      P003O3_A286ServicioEstado = new String[] {""} ;
      P003O3_A285ServicioObservacion = new String[] {""} ;
      P003O3_A165LaboratorioNombre = new String[] {""} ;
      P003O3_A281ServicioNombre = new String[] {""} ;
      P003O4_A165LaboratorioNombre = new String[] {""} ;
      P003O4_A284ServicioComision = new short[1] ;
      P003O4_A40LaboratorioId = new short[1] ;
      P003O4_A52ServicioCategId = new short[1] ;
      P003O4_A283ServicioCosto = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      P003O4_A27ServicioId = new short[1] ;
      P003O4_A286ServicioEstado = new String[] {""} ;
      P003O4_A285ServicioObservacion = new String[] {""} ;
      P003O4_A282ServicioDescripcion = new String[] {""} ;
      P003O4_A281ServicioNombre = new String[] {""} ;
      P003O5_A285ServicioObservacion = new String[] {""} ;
      P003O5_A284ServicioComision = new short[1] ;
      P003O5_A40LaboratorioId = new short[1] ;
      P003O5_A52ServicioCategId = new short[1] ;
      P003O5_A283ServicioCosto = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      P003O5_A27ServicioId = new short[1] ;
      P003O5_A286ServicioEstado = new String[] {""} ;
      P003O5_A165LaboratorioNombre = new String[] {""} ;
      P003O5_A282ServicioDescripcion = new String[] {""} ;
      P003O5_A281ServicioNombre = new String[] {""} ;
      pr_default = new DataStoreProvider(context, remoteHandle, new com.projectthani.serviciowwgetfilterdata__default(),
         new Object[] {
             new Object[] {
            P003O2_A281ServicioNombre, P003O2_A284ServicioComision, P003O2_A40LaboratorioId, P003O2_A52ServicioCategId, P003O2_A283ServicioCosto, P003O2_A27ServicioId, P003O2_A286ServicioEstado, P003O2_A285ServicioObservacion, P003O2_A165LaboratorioNombre, P003O2_A282ServicioDescripcion
            }
            , new Object[] {
            P003O3_A282ServicioDescripcion, P003O3_A284ServicioComision, P003O3_A40LaboratorioId, P003O3_A52ServicioCategId, P003O3_A283ServicioCosto, P003O3_A27ServicioId, P003O3_A286ServicioEstado, P003O3_A285ServicioObservacion, P003O3_A165LaboratorioNombre, P003O3_A281ServicioNombre
            }
            , new Object[] {
            P003O4_A165LaboratorioNombre, P003O4_A284ServicioComision, P003O4_A40LaboratorioId, P003O4_A52ServicioCategId, P003O4_A283ServicioCosto, P003O4_A27ServicioId, P003O4_A286ServicioEstado, P003O4_A285ServicioObservacion, P003O4_A282ServicioDescripcion, P003O4_A281ServicioNombre
            }
            , new Object[] {
            P003O5_A285ServicioObservacion, P003O5_A284ServicioComision, P003O5_A40LaboratorioId, P003O5_A52ServicioCategId, P003O5_A283ServicioCosto, P003O5_A27ServicioId, P003O5_A286ServicioEstado, P003O5_A165LaboratorioNombre, P003O5_A282ServicioDescripcion, P003O5_A281ServicioNombre
            }
         }
      );
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private short AV11TFServicioId ;
   private short AV12TFServicioId_To ;
   private short AV19TFServicioCategId ;
   private short AV20TFServicioCategId_To ;
   private short AV21TFLaboratorioId ;
   private short AV22TFLaboratorioId_To ;
   private short AV25TFServicioComision ;
   private short AV26TFServicioComision_To ;
   private short AV55Serviciowwds_2_tfservicioid ;
   private short AV56Serviciowwds_3_tfservicioid_to ;
   private short AV63Serviciowwds_10_tfserviciocategid ;
   private short AV64Serviciowwds_11_tfserviciocategid_to ;
   private short AV65Serviciowwds_12_tflaboratorioid ;
   private short AV66Serviciowwds_13_tflaboratorioid_to ;
   private short AV69Serviciowwds_16_tfserviciocomision ;
   private short AV70Serviciowwds_17_tfserviciocomision_to ;
   private short A27ServicioId ;
   private short A52ServicioCategId ;
   private short A40LaboratorioId ;
   private short A284ServicioComision ;
   private short Gx_err ;
   private int AV52GXV1 ;
   private int AV73Serviciowwds_20_tfservicioestado_sels_size ;
   private long AV43count ;
   private java.math.BigDecimal AV17TFServicioCosto ;
   private java.math.BigDecimal AV18TFServicioCosto_To ;
   private java.math.BigDecimal AV61Serviciowwds_8_tfserviciocosto ;
   private java.math.BigDecimal AV62Serviciowwds_9_tfserviciocosto_to ;
   private java.math.BigDecimal A283ServicioCosto ;
   private String scmdbuf ;
   private String A286ServicioEstado ;
   private boolean AV8IsAuthorized ;
   private boolean GXt_boolean1 ;
   private boolean GXv_boolean2[] ;
   private boolean returnInSub ;
   private boolean brk3O2 ;
   private boolean brk3O4 ;
   private boolean brk3O6 ;
   private boolean brk3O8 ;
   private String AV37OptionsJson ;
   private String AV40OptionsDescJson ;
   private String AV42OptionIndexesJson ;
   private String AV29TFServicioEstado_SelsJson ;
   private String AV33DDOName ;
   private String AV31SearchTxt ;
   private String AV32SearchTxtTo ;
   private String AV49FilterFullText ;
   private String AV13TFServicioNombre ;
   private String AV14TFServicioNombre_Sel ;
   private String AV15TFServicioDescripcion ;
   private String AV16TFServicioDescripcion_Sel ;
   private String AV23TFLaboratorioNombre ;
   private String AV24TFLaboratorioNombre_Sel ;
   private String AV27TFServicioObservacion ;
   private String AV28TFServicioObservacion_Sel ;
   private String A281ServicioNombre ;
   private String AV54Serviciowwds_1_filterfulltext ;
   private String AV57Serviciowwds_4_tfservicionombre ;
   private String AV58Serviciowwds_5_tfservicionombre_sel ;
   private String AV59Serviciowwds_6_tfserviciodescripcion ;
   private String AV60Serviciowwds_7_tfserviciodescripcion_sel ;
   private String AV67Serviciowwds_14_tflaboratorionombre ;
   private String AV68Serviciowwds_15_tflaboratorionombre_sel ;
   private String AV71Serviciowwds_18_tfservicioobservacion ;
   private String AV72Serviciowwds_19_tfservicioobservacion_sel ;
   private String lV54Serviciowwds_1_filterfulltext ;
   private String lV57Serviciowwds_4_tfservicionombre ;
   private String lV59Serviciowwds_6_tfserviciodescripcion ;
   private String lV67Serviciowwds_14_tflaboratorionombre ;
   private String lV71Serviciowwds_18_tfservicioobservacion ;
   private String A282ServicioDescripcion ;
   private String A165LaboratorioNombre ;
   private String A285ServicioObservacion ;
   private String AV35Option ;
   private com.genexus.webpanels.WebSession AV44Session ;
   private String[] aP5 ;
   private String[] aP3 ;
   private String[] aP4 ;
   private IDataStoreProvider pr_default ;
   private String[] P003O2_A281ServicioNombre ;
   private short[] P003O2_A284ServicioComision ;
   private short[] P003O2_A40LaboratorioId ;
   private short[] P003O2_A52ServicioCategId ;
   private java.math.BigDecimal[] P003O2_A283ServicioCosto ;
   private short[] P003O2_A27ServicioId ;
   private String[] P003O2_A286ServicioEstado ;
   private String[] P003O2_A285ServicioObservacion ;
   private String[] P003O2_A165LaboratorioNombre ;
   private String[] P003O2_A282ServicioDescripcion ;
   private String[] P003O3_A282ServicioDescripcion ;
   private short[] P003O3_A284ServicioComision ;
   private short[] P003O3_A40LaboratorioId ;
   private short[] P003O3_A52ServicioCategId ;
   private java.math.BigDecimal[] P003O3_A283ServicioCosto ;
   private short[] P003O3_A27ServicioId ;
   private String[] P003O3_A286ServicioEstado ;
   private String[] P003O3_A285ServicioObservacion ;
   private String[] P003O3_A165LaboratorioNombre ;
   private String[] P003O3_A281ServicioNombre ;
   private String[] P003O4_A165LaboratorioNombre ;
   private short[] P003O4_A284ServicioComision ;
   private short[] P003O4_A40LaboratorioId ;
   private short[] P003O4_A52ServicioCategId ;
   private java.math.BigDecimal[] P003O4_A283ServicioCosto ;
   private short[] P003O4_A27ServicioId ;
   private String[] P003O4_A286ServicioEstado ;
   private String[] P003O4_A285ServicioObservacion ;
   private String[] P003O4_A282ServicioDescripcion ;
   private String[] P003O4_A281ServicioNombre ;
   private String[] P003O5_A285ServicioObservacion ;
   private short[] P003O5_A284ServicioComision ;
   private short[] P003O5_A40LaboratorioId ;
   private short[] P003O5_A52ServicioCategId ;
   private java.math.BigDecimal[] P003O5_A283ServicioCosto ;
   private short[] P003O5_A27ServicioId ;
   private String[] P003O5_A286ServicioEstado ;
   private String[] P003O5_A165LaboratorioNombre ;
   private String[] P003O5_A282ServicioDescripcion ;
   private String[] P003O5_A281ServicioNombre ;
   private GXSimpleCollection<String> AV30TFServicioEstado_Sels ;
   private GXSimpleCollection<String> AV73Serviciowwds_20_tfservicioestado_sels ;
   private GXSimpleCollection<String> AV36Options ;
   private GXSimpleCollection<String> AV39OptionsDesc ;
   private GXSimpleCollection<String> AV41OptionIndexes ;
   private com.projectthani.wwpbaseobjects.SdtWWPContext AV9WWPContext ;
   private com.projectthani.wwpbaseobjects.SdtWWPContext GXv_SdtWWPContext3[] ;
   private com.projectthani.wwpbaseobjects.SdtWWPGridState AV46GridState ;
   private com.projectthani.wwpbaseobjects.SdtWWPGridState_FilterValue AV47GridStateFilterValue ;
}

final  class serviciowwgetfilterdata__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   protected Object[] conditional_P003O2( ModelContext context ,
                                          int remoteHandle ,
                                          com.genexus.IHttpContext httpContext ,
                                          String A286ServicioEstado ,
                                          GXSimpleCollection<String> AV73Serviciowwds_20_tfservicioestado_sels ,
                                          String AV54Serviciowwds_1_filterfulltext ,
                                          short AV55Serviciowwds_2_tfservicioid ,
                                          short AV56Serviciowwds_3_tfservicioid_to ,
                                          String AV58Serviciowwds_5_tfservicionombre_sel ,
                                          String AV57Serviciowwds_4_tfservicionombre ,
                                          String AV60Serviciowwds_7_tfserviciodescripcion_sel ,
                                          String AV59Serviciowwds_6_tfserviciodescripcion ,
                                          java.math.BigDecimal AV61Serviciowwds_8_tfserviciocosto ,
                                          java.math.BigDecimal AV62Serviciowwds_9_tfserviciocosto_to ,
                                          short AV63Serviciowwds_10_tfserviciocategid ,
                                          short AV64Serviciowwds_11_tfserviciocategid_to ,
                                          short AV65Serviciowwds_12_tflaboratorioid ,
                                          short AV66Serviciowwds_13_tflaboratorioid_to ,
                                          String AV68Serviciowwds_15_tflaboratorionombre_sel ,
                                          String AV67Serviciowwds_14_tflaboratorionombre ,
                                          short AV69Serviciowwds_16_tfserviciocomision ,
                                          short AV70Serviciowwds_17_tfserviciocomision_to ,
                                          String AV72Serviciowwds_19_tfservicioobservacion_sel ,
                                          String AV71Serviciowwds_18_tfservicioobservacion ,
                                          int AV73Serviciowwds_20_tfservicioestado_sels_size ,
                                          short A27ServicioId ,
                                          String A281ServicioNombre ,
                                          String A282ServicioDescripcion ,
                                          java.math.BigDecimal A283ServicioCosto ,
                                          short A52ServicioCategId ,
                                          short A40LaboratorioId ,
                                          String A165LaboratorioNombre ,
                                          short A284ServicioComision ,
                                          String A285ServicioObservacion )
   {
      java.lang.StringBuffer sWhereString = new java.lang.StringBuffer();
      String scmdbuf;
      byte[] GXv_int4 = new byte[29];
      Object[] GXv_Object5 = new Object[2];
      scmdbuf = "SELECT T1.[ServicioNombre], T1.[ServicioComision], T2.[LaboratorioId], T1.[ServicioCategId], T1.[ServicioCosto], T1.[ServicioId], T1.[ServicioEstado], T1.[ServicioObservacion]," ;
      scmdbuf += " T3.[LaboratorioNombre], T1.[ServicioDescripcion] FROM (([Servicio] T1 INNER JOIN [ServicioCateg] T2 ON T2.[ServicioCategId] = T1.[ServicioCategId]) INNER JOIN [Laboratorio]" ;
      scmdbuf += " T3 ON T3.[LaboratorioId] = T2.[LaboratorioId])" ;
      if ( ! (GXutil.strcmp("", AV54Serviciowwds_1_filterfulltext)==0) )
      {
         addWhere(sWhereString, "(( CONVERT( char(4), CAST(T1.[ServicioId] AS decimal(4,0))) like '%' + ?) or ( T1.[ServicioNombre] like '%' + ?) or ( T1.[ServicioDescripcion] like '%' + ?) or ( CONVERT( char(6), CAST(T1.[ServicioCosto] AS decimal(6,2))) like '%' + ?) or ( CONVERT( char(4), CAST(T1.[ServicioCategId] AS decimal(4,0))) like '%' + ?) or ( CONVERT( char(4), CAST(T2.[LaboratorioId] AS decimal(4,0))) like '%' + ?) or ( T3.[LaboratorioNombre] like '%' + ?) or ( CONVERT( char(4), CAST(T1.[ServicioComision] AS decimal(4,0))) like '%' + ?) or ( T1.[ServicioObservacion] like '%' + ?) or ( 'activo' like '%' + LOWER(?) and T1.[ServicioEstado] = 'A') or ( 'inactivo' like '%' + LOWER(?) and T1.[ServicioEstado] = 'I'))");
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
      if ( ! (0==AV55Serviciowwds_2_tfservicioid) )
      {
         addWhere(sWhereString, "(T1.[ServicioId] >= ?)");
      }
      else
      {
         GXv_int4[11] = (byte)(1) ;
      }
      if ( ! (0==AV56Serviciowwds_3_tfservicioid_to) )
      {
         addWhere(sWhereString, "(T1.[ServicioId] <= ?)");
      }
      else
      {
         GXv_int4[12] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV58Serviciowwds_5_tfservicionombre_sel)==0) && ( ! (GXutil.strcmp("", AV57Serviciowwds_4_tfservicionombre)==0) ) )
      {
         addWhere(sWhereString, "(T1.[ServicioNombre] like ?)");
      }
      else
      {
         GXv_int4[13] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV58Serviciowwds_5_tfservicionombre_sel)==0) )
      {
         addWhere(sWhereString, "(T1.[ServicioNombre] = ?)");
      }
      else
      {
         GXv_int4[14] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV60Serviciowwds_7_tfserviciodescripcion_sel)==0) && ( ! (GXutil.strcmp("", AV59Serviciowwds_6_tfserviciodescripcion)==0) ) )
      {
         addWhere(sWhereString, "(T1.[ServicioDescripcion] like ?)");
      }
      else
      {
         GXv_int4[15] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV60Serviciowwds_7_tfserviciodescripcion_sel)==0) )
      {
         addWhere(sWhereString, "(T1.[ServicioDescripcion] = ?)");
      }
      else
      {
         GXv_int4[16] = (byte)(1) ;
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV61Serviciowwds_8_tfserviciocosto)==0) )
      {
         addWhere(sWhereString, "(T1.[ServicioCosto] >= ?)");
      }
      else
      {
         GXv_int4[17] = (byte)(1) ;
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV62Serviciowwds_9_tfserviciocosto_to)==0) )
      {
         addWhere(sWhereString, "(T1.[ServicioCosto] <= ?)");
      }
      else
      {
         GXv_int4[18] = (byte)(1) ;
      }
      if ( ! (0==AV63Serviciowwds_10_tfserviciocategid) )
      {
         addWhere(sWhereString, "(T1.[ServicioCategId] >= ?)");
      }
      else
      {
         GXv_int4[19] = (byte)(1) ;
      }
      if ( ! (0==AV64Serviciowwds_11_tfserviciocategid_to) )
      {
         addWhere(sWhereString, "(T1.[ServicioCategId] <= ?)");
      }
      else
      {
         GXv_int4[20] = (byte)(1) ;
      }
      if ( ! (0==AV65Serviciowwds_12_tflaboratorioid) )
      {
         addWhere(sWhereString, "(T2.[LaboratorioId] >= ?)");
      }
      else
      {
         GXv_int4[21] = (byte)(1) ;
      }
      if ( ! (0==AV66Serviciowwds_13_tflaboratorioid_to) )
      {
         addWhere(sWhereString, "(T2.[LaboratorioId] <= ?)");
      }
      else
      {
         GXv_int4[22] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV68Serviciowwds_15_tflaboratorionombre_sel)==0) && ( ! (GXutil.strcmp("", AV67Serviciowwds_14_tflaboratorionombre)==0) ) )
      {
         addWhere(sWhereString, "(T3.[LaboratorioNombre] like ?)");
      }
      else
      {
         GXv_int4[23] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV68Serviciowwds_15_tflaboratorionombre_sel)==0) )
      {
         addWhere(sWhereString, "(T3.[LaboratorioNombre] = ?)");
      }
      else
      {
         GXv_int4[24] = (byte)(1) ;
      }
      if ( ! (0==AV69Serviciowwds_16_tfserviciocomision) )
      {
         addWhere(sWhereString, "(T1.[ServicioComision] >= ?)");
      }
      else
      {
         GXv_int4[25] = (byte)(1) ;
      }
      if ( ! (0==AV70Serviciowwds_17_tfserviciocomision_to) )
      {
         addWhere(sWhereString, "(T1.[ServicioComision] <= ?)");
      }
      else
      {
         GXv_int4[26] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV72Serviciowwds_19_tfservicioobservacion_sel)==0) && ( ! (GXutil.strcmp("", AV71Serviciowwds_18_tfservicioobservacion)==0) ) )
      {
         addWhere(sWhereString, "(T1.[ServicioObservacion] like ?)");
      }
      else
      {
         GXv_int4[27] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV72Serviciowwds_19_tfservicioobservacion_sel)==0) )
      {
         addWhere(sWhereString, "(T1.[ServicioObservacion] = ?)");
      }
      else
      {
         GXv_int4[28] = (byte)(1) ;
      }
      if ( AV73Serviciowwds_20_tfservicioestado_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("sqlserver", AV73Serviciowwds_20_tfservicioestado_sels, "T1.[ServicioEstado] IN (", ")")+")");
      }
      scmdbuf += sWhereString ;
      scmdbuf += " ORDER BY T1.[ServicioNombre]" ;
      GXv_Object5[0] = scmdbuf ;
      GXv_Object5[1] = GXv_int4 ;
      return GXv_Object5 ;
   }

   protected Object[] conditional_P003O3( ModelContext context ,
                                          int remoteHandle ,
                                          com.genexus.IHttpContext httpContext ,
                                          String A286ServicioEstado ,
                                          GXSimpleCollection<String> AV73Serviciowwds_20_tfservicioestado_sels ,
                                          String AV54Serviciowwds_1_filterfulltext ,
                                          short AV55Serviciowwds_2_tfservicioid ,
                                          short AV56Serviciowwds_3_tfservicioid_to ,
                                          String AV58Serviciowwds_5_tfservicionombre_sel ,
                                          String AV57Serviciowwds_4_tfservicionombre ,
                                          String AV60Serviciowwds_7_tfserviciodescripcion_sel ,
                                          String AV59Serviciowwds_6_tfserviciodescripcion ,
                                          java.math.BigDecimal AV61Serviciowwds_8_tfserviciocosto ,
                                          java.math.BigDecimal AV62Serviciowwds_9_tfserviciocosto_to ,
                                          short AV63Serviciowwds_10_tfserviciocategid ,
                                          short AV64Serviciowwds_11_tfserviciocategid_to ,
                                          short AV65Serviciowwds_12_tflaboratorioid ,
                                          short AV66Serviciowwds_13_tflaboratorioid_to ,
                                          String AV68Serviciowwds_15_tflaboratorionombre_sel ,
                                          String AV67Serviciowwds_14_tflaboratorionombre ,
                                          short AV69Serviciowwds_16_tfserviciocomision ,
                                          short AV70Serviciowwds_17_tfserviciocomision_to ,
                                          String AV72Serviciowwds_19_tfservicioobservacion_sel ,
                                          String AV71Serviciowwds_18_tfservicioobservacion ,
                                          int AV73Serviciowwds_20_tfservicioestado_sels_size ,
                                          short A27ServicioId ,
                                          String A281ServicioNombre ,
                                          String A282ServicioDescripcion ,
                                          java.math.BigDecimal A283ServicioCosto ,
                                          short A52ServicioCategId ,
                                          short A40LaboratorioId ,
                                          String A165LaboratorioNombre ,
                                          short A284ServicioComision ,
                                          String A285ServicioObservacion )
   {
      java.lang.StringBuffer sWhereString = new java.lang.StringBuffer();
      String scmdbuf;
      byte[] GXv_int7 = new byte[29];
      Object[] GXv_Object8 = new Object[2];
      scmdbuf = "SELECT T1.[ServicioDescripcion], T1.[ServicioComision], T2.[LaboratorioId], T1.[ServicioCategId], T1.[ServicioCosto], T1.[ServicioId], T1.[ServicioEstado], T1.[ServicioObservacion]," ;
      scmdbuf += " T3.[LaboratorioNombre], T1.[ServicioNombre] FROM (([Servicio] T1 INNER JOIN [ServicioCateg] T2 ON T2.[ServicioCategId] = T1.[ServicioCategId]) INNER JOIN [Laboratorio]" ;
      scmdbuf += " T3 ON T3.[LaboratorioId] = T2.[LaboratorioId])" ;
      if ( ! (GXutil.strcmp("", AV54Serviciowwds_1_filterfulltext)==0) )
      {
         addWhere(sWhereString, "(( CONVERT( char(4), CAST(T1.[ServicioId] AS decimal(4,0))) like '%' + ?) or ( T1.[ServicioNombre] like '%' + ?) or ( T1.[ServicioDescripcion] like '%' + ?) or ( CONVERT( char(6), CAST(T1.[ServicioCosto] AS decimal(6,2))) like '%' + ?) or ( CONVERT( char(4), CAST(T1.[ServicioCategId] AS decimal(4,0))) like '%' + ?) or ( CONVERT( char(4), CAST(T2.[LaboratorioId] AS decimal(4,0))) like '%' + ?) or ( T3.[LaboratorioNombre] like '%' + ?) or ( CONVERT( char(4), CAST(T1.[ServicioComision] AS decimal(4,0))) like '%' + ?) or ( T1.[ServicioObservacion] like '%' + ?) or ( 'activo' like '%' + LOWER(?) and T1.[ServicioEstado] = 'A') or ( 'inactivo' like '%' + LOWER(?) and T1.[ServicioEstado] = 'I'))");
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
         GXv_int7[10] = (byte)(1) ;
      }
      if ( ! (0==AV55Serviciowwds_2_tfservicioid) )
      {
         addWhere(sWhereString, "(T1.[ServicioId] >= ?)");
      }
      else
      {
         GXv_int7[11] = (byte)(1) ;
      }
      if ( ! (0==AV56Serviciowwds_3_tfservicioid_to) )
      {
         addWhere(sWhereString, "(T1.[ServicioId] <= ?)");
      }
      else
      {
         GXv_int7[12] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV58Serviciowwds_5_tfservicionombre_sel)==0) && ( ! (GXutil.strcmp("", AV57Serviciowwds_4_tfservicionombre)==0) ) )
      {
         addWhere(sWhereString, "(T1.[ServicioNombre] like ?)");
      }
      else
      {
         GXv_int7[13] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV58Serviciowwds_5_tfservicionombre_sel)==0) )
      {
         addWhere(sWhereString, "(T1.[ServicioNombre] = ?)");
      }
      else
      {
         GXv_int7[14] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV60Serviciowwds_7_tfserviciodescripcion_sel)==0) && ( ! (GXutil.strcmp("", AV59Serviciowwds_6_tfserviciodescripcion)==0) ) )
      {
         addWhere(sWhereString, "(T1.[ServicioDescripcion] like ?)");
      }
      else
      {
         GXv_int7[15] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV60Serviciowwds_7_tfserviciodescripcion_sel)==0) )
      {
         addWhere(sWhereString, "(T1.[ServicioDescripcion] = ?)");
      }
      else
      {
         GXv_int7[16] = (byte)(1) ;
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV61Serviciowwds_8_tfserviciocosto)==0) )
      {
         addWhere(sWhereString, "(T1.[ServicioCosto] >= ?)");
      }
      else
      {
         GXv_int7[17] = (byte)(1) ;
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV62Serviciowwds_9_tfserviciocosto_to)==0) )
      {
         addWhere(sWhereString, "(T1.[ServicioCosto] <= ?)");
      }
      else
      {
         GXv_int7[18] = (byte)(1) ;
      }
      if ( ! (0==AV63Serviciowwds_10_tfserviciocategid) )
      {
         addWhere(sWhereString, "(T1.[ServicioCategId] >= ?)");
      }
      else
      {
         GXv_int7[19] = (byte)(1) ;
      }
      if ( ! (0==AV64Serviciowwds_11_tfserviciocategid_to) )
      {
         addWhere(sWhereString, "(T1.[ServicioCategId] <= ?)");
      }
      else
      {
         GXv_int7[20] = (byte)(1) ;
      }
      if ( ! (0==AV65Serviciowwds_12_tflaboratorioid) )
      {
         addWhere(sWhereString, "(T2.[LaboratorioId] >= ?)");
      }
      else
      {
         GXv_int7[21] = (byte)(1) ;
      }
      if ( ! (0==AV66Serviciowwds_13_tflaboratorioid_to) )
      {
         addWhere(sWhereString, "(T2.[LaboratorioId] <= ?)");
      }
      else
      {
         GXv_int7[22] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV68Serviciowwds_15_tflaboratorionombre_sel)==0) && ( ! (GXutil.strcmp("", AV67Serviciowwds_14_tflaboratorionombre)==0) ) )
      {
         addWhere(sWhereString, "(T3.[LaboratorioNombre] like ?)");
      }
      else
      {
         GXv_int7[23] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV68Serviciowwds_15_tflaboratorionombre_sel)==0) )
      {
         addWhere(sWhereString, "(T3.[LaboratorioNombre] = ?)");
      }
      else
      {
         GXv_int7[24] = (byte)(1) ;
      }
      if ( ! (0==AV69Serviciowwds_16_tfserviciocomision) )
      {
         addWhere(sWhereString, "(T1.[ServicioComision] >= ?)");
      }
      else
      {
         GXv_int7[25] = (byte)(1) ;
      }
      if ( ! (0==AV70Serviciowwds_17_tfserviciocomision_to) )
      {
         addWhere(sWhereString, "(T1.[ServicioComision] <= ?)");
      }
      else
      {
         GXv_int7[26] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV72Serviciowwds_19_tfservicioobservacion_sel)==0) && ( ! (GXutil.strcmp("", AV71Serviciowwds_18_tfservicioobservacion)==0) ) )
      {
         addWhere(sWhereString, "(T1.[ServicioObservacion] like ?)");
      }
      else
      {
         GXv_int7[27] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV72Serviciowwds_19_tfservicioobservacion_sel)==0) )
      {
         addWhere(sWhereString, "(T1.[ServicioObservacion] = ?)");
      }
      else
      {
         GXv_int7[28] = (byte)(1) ;
      }
      if ( AV73Serviciowwds_20_tfservicioestado_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("sqlserver", AV73Serviciowwds_20_tfservicioestado_sels, "T1.[ServicioEstado] IN (", ")")+")");
      }
      scmdbuf += sWhereString ;
      scmdbuf += " ORDER BY T1.[ServicioDescripcion]" ;
      GXv_Object8[0] = scmdbuf ;
      GXv_Object8[1] = GXv_int7 ;
      return GXv_Object8 ;
   }

   protected Object[] conditional_P003O4( ModelContext context ,
                                          int remoteHandle ,
                                          com.genexus.IHttpContext httpContext ,
                                          String A286ServicioEstado ,
                                          GXSimpleCollection<String> AV73Serviciowwds_20_tfservicioestado_sels ,
                                          String AV54Serviciowwds_1_filterfulltext ,
                                          short AV55Serviciowwds_2_tfservicioid ,
                                          short AV56Serviciowwds_3_tfservicioid_to ,
                                          String AV58Serviciowwds_5_tfservicionombre_sel ,
                                          String AV57Serviciowwds_4_tfservicionombre ,
                                          String AV60Serviciowwds_7_tfserviciodescripcion_sel ,
                                          String AV59Serviciowwds_6_tfserviciodescripcion ,
                                          java.math.BigDecimal AV61Serviciowwds_8_tfserviciocosto ,
                                          java.math.BigDecimal AV62Serviciowwds_9_tfserviciocosto_to ,
                                          short AV63Serviciowwds_10_tfserviciocategid ,
                                          short AV64Serviciowwds_11_tfserviciocategid_to ,
                                          short AV65Serviciowwds_12_tflaboratorioid ,
                                          short AV66Serviciowwds_13_tflaboratorioid_to ,
                                          String AV68Serviciowwds_15_tflaboratorionombre_sel ,
                                          String AV67Serviciowwds_14_tflaboratorionombre ,
                                          short AV69Serviciowwds_16_tfserviciocomision ,
                                          short AV70Serviciowwds_17_tfserviciocomision_to ,
                                          String AV72Serviciowwds_19_tfservicioobservacion_sel ,
                                          String AV71Serviciowwds_18_tfservicioobservacion ,
                                          int AV73Serviciowwds_20_tfservicioestado_sels_size ,
                                          short A27ServicioId ,
                                          String A281ServicioNombre ,
                                          String A282ServicioDescripcion ,
                                          java.math.BigDecimal A283ServicioCosto ,
                                          short A52ServicioCategId ,
                                          short A40LaboratorioId ,
                                          String A165LaboratorioNombre ,
                                          short A284ServicioComision ,
                                          String A285ServicioObservacion )
   {
      java.lang.StringBuffer sWhereString = new java.lang.StringBuffer();
      String scmdbuf;
      byte[] GXv_int10 = new byte[29];
      Object[] GXv_Object11 = new Object[2];
      scmdbuf = "SELECT T3.[LaboratorioNombre], T1.[ServicioComision], T2.[LaboratorioId], T1.[ServicioCategId], T1.[ServicioCosto], T1.[ServicioId], T1.[ServicioEstado], T1.[ServicioObservacion]," ;
      scmdbuf += " T1.[ServicioDescripcion], T1.[ServicioNombre] FROM (([Servicio] T1 INNER JOIN [ServicioCateg] T2 ON T2.[ServicioCategId] = T1.[ServicioCategId]) INNER JOIN [Laboratorio]" ;
      scmdbuf += " T3 ON T3.[LaboratorioId] = T2.[LaboratorioId])" ;
      if ( ! (GXutil.strcmp("", AV54Serviciowwds_1_filterfulltext)==0) )
      {
         addWhere(sWhereString, "(( CONVERT( char(4), CAST(T1.[ServicioId] AS decimal(4,0))) like '%' + ?) or ( T1.[ServicioNombre] like '%' + ?) or ( T1.[ServicioDescripcion] like '%' + ?) or ( CONVERT( char(6), CAST(T1.[ServicioCosto] AS decimal(6,2))) like '%' + ?) or ( CONVERT( char(4), CAST(T1.[ServicioCategId] AS decimal(4,0))) like '%' + ?) or ( CONVERT( char(4), CAST(T2.[LaboratorioId] AS decimal(4,0))) like '%' + ?) or ( T3.[LaboratorioNombre] like '%' + ?) or ( CONVERT( char(4), CAST(T1.[ServicioComision] AS decimal(4,0))) like '%' + ?) or ( T1.[ServicioObservacion] like '%' + ?) or ( 'activo' like '%' + LOWER(?) and T1.[ServicioEstado] = 'A') or ( 'inactivo' like '%' + LOWER(?) and T1.[ServicioEstado] = 'I'))");
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
      if ( ! (0==AV55Serviciowwds_2_tfservicioid) )
      {
         addWhere(sWhereString, "(T1.[ServicioId] >= ?)");
      }
      else
      {
         GXv_int10[11] = (byte)(1) ;
      }
      if ( ! (0==AV56Serviciowwds_3_tfservicioid_to) )
      {
         addWhere(sWhereString, "(T1.[ServicioId] <= ?)");
      }
      else
      {
         GXv_int10[12] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV58Serviciowwds_5_tfservicionombre_sel)==0) && ( ! (GXutil.strcmp("", AV57Serviciowwds_4_tfservicionombre)==0) ) )
      {
         addWhere(sWhereString, "(T1.[ServicioNombre] like ?)");
      }
      else
      {
         GXv_int10[13] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV58Serviciowwds_5_tfservicionombre_sel)==0) )
      {
         addWhere(sWhereString, "(T1.[ServicioNombre] = ?)");
      }
      else
      {
         GXv_int10[14] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV60Serviciowwds_7_tfserviciodescripcion_sel)==0) && ( ! (GXutil.strcmp("", AV59Serviciowwds_6_tfserviciodescripcion)==0) ) )
      {
         addWhere(sWhereString, "(T1.[ServicioDescripcion] like ?)");
      }
      else
      {
         GXv_int10[15] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV60Serviciowwds_7_tfserviciodescripcion_sel)==0) )
      {
         addWhere(sWhereString, "(T1.[ServicioDescripcion] = ?)");
      }
      else
      {
         GXv_int10[16] = (byte)(1) ;
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV61Serviciowwds_8_tfserviciocosto)==0) )
      {
         addWhere(sWhereString, "(T1.[ServicioCosto] >= ?)");
      }
      else
      {
         GXv_int10[17] = (byte)(1) ;
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV62Serviciowwds_9_tfserviciocosto_to)==0) )
      {
         addWhere(sWhereString, "(T1.[ServicioCosto] <= ?)");
      }
      else
      {
         GXv_int10[18] = (byte)(1) ;
      }
      if ( ! (0==AV63Serviciowwds_10_tfserviciocategid) )
      {
         addWhere(sWhereString, "(T1.[ServicioCategId] >= ?)");
      }
      else
      {
         GXv_int10[19] = (byte)(1) ;
      }
      if ( ! (0==AV64Serviciowwds_11_tfserviciocategid_to) )
      {
         addWhere(sWhereString, "(T1.[ServicioCategId] <= ?)");
      }
      else
      {
         GXv_int10[20] = (byte)(1) ;
      }
      if ( ! (0==AV65Serviciowwds_12_tflaboratorioid) )
      {
         addWhere(sWhereString, "(T2.[LaboratorioId] >= ?)");
      }
      else
      {
         GXv_int10[21] = (byte)(1) ;
      }
      if ( ! (0==AV66Serviciowwds_13_tflaboratorioid_to) )
      {
         addWhere(sWhereString, "(T2.[LaboratorioId] <= ?)");
      }
      else
      {
         GXv_int10[22] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV68Serviciowwds_15_tflaboratorionombre_sel)==0) && ( ! (GXutil.strcmp("", AV67Serviciowwds_14_tflaboratorionombre)==0) ) )
      {
         addWhere(sWhereString, "(T3.[LaboratorioNombre] like ?)");
      }
      else
      {
         GXv_int10[23] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV68Serviciowwds_15_tflaboratorionombre_sel)==0) )
      {
         addWhere(sWhereString, "(T3.[LaboratorioNombre] = ?)");
      }
      else
      {
         GXv_int10[24] = (byte)(1) ;
      }
      if ( ! (0==AV69Serviciowwds_16_tfserviciocomision) )
      {
         addWhere(sWhereString, "(T1.[ServicioComision] >= ?)");
      }
      else
      {
         GXv_int10[25] = (byte)(1) ;
      }
      if ( ! (0==AV70Serviciowwds_17_tfserviciocomision_to) )
      {
         addWhere(sWhereString, "(T1.[ServicioComision] <= ?)");
      }
      else
      {
         GXv_int10[26] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV72Serviciowwds_19_tfservicioobservacion_sel)==0) && ( ! (GXutil.strcmp("", AV71Serviciowwds_18_tfservicioobservacion)==0) ) )
      {
         addWhere(sWhereString, "(T1.[ServicioObservacion] like ?)");
      }
      else
      {
         GXv_int10[27] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV72Serviciowwds_19_tfservicioobservacion_sel)==0) )
      {
         addWhere(sWhereString, "(T1.[ServicioObservacion] = ?)");
      }
      else
      {
         GXv_int10[28] = (byte)(1) ;
      }
      if ( AV73Serviciowwds_20_tfservicioestado_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("sqlserver", AV73Serviciowwds_20_tfservicioestado_sels, "T1.[ServicioEstado] IN (", ")")+")");
      }
      scmdbuf += sWhereString ;
      scmdbuf += " ORDER BY T3.[LaboratorioNombre]" ;
      GXv_Object11[0] = scmdbuf ;
      GXv_Object11[1] = GXv_int10 ;
      return GXv_Object11 ;
   }

   protected Object[] conditional_P003O5( ModelContext context ,
                                          int remoteHandle ,
                                          com.genexus.IHttpContext httpContext ,
                                          String A286ServicioEstado ,
                                          GXSimpleCollection<String> AV73Serviciowwds_20_tfservicioestado_sels ,
                                          String AV54Serviciowwds_1_filterfulltext ,
                                          short AV55Serviciowwds_2_tfservicioid ,
                                          short AV56Serviciowwds_3_tfservicioid_to ,
                                          String AV58Serviciowwds_5_tfservicionombre_sel ,
                                          String AV57Serviciowwds_4_tfservicionombre ,
                                          String AV60Serviciowwds_7_tfserviciodescripcion_sel ,
                                          String AV59Serviciowwds_6_tfserviciodescripcion ,
                                          java.math.BigDecimal AV61Serviciowwds_8_tfserviciocosto ,
                                          java.math.BigDecimal AV62Serviciowwds_9_tfserviciocosto_to ,
                                          short AV63Serviciowwds_10_tfserviciocategid ,
                                          short AV64Serviciowwds_11_tfserviciocategid_to ,
                                          short AV65Serviciowwds_12_tflaboratorioid ,
                                          short AV66Serviciowwds_13_tflaboratorioid_to ,
                                          String AV68Serviciowwds_15_tflaboratorionombre_sel ,
                                          String AV67Serviciowwds_14_tflaboratorionombre ,
                                          short AV69Serviciowwds_16_tfserviciocomision ,
                                          short AV70Serviciowwds_17_tfserviciocomision_to ,
                                          String AV72Serviciowwds_19_tfservicioobservacion_sel ,
                                          String AV71Serviciowwds_18_tfservicioobservacion ,
                                          int AV73Serviciowwds_20_tfservicioestado_sels_size ,
                                          short A27ServicioId ,
                                          String A281ServicioNombre ,
                                          String A282ServicioDescripcion ,
                                          java.math.BigDecimal A283ServicioCosto ,
                                          short A52ServicioCategId ,
                                          short A40LaboratorioId ,
                                          String A165LaboratorioNombre ,
                                          short A284ServicioComision ,
                                          String A285ServicioObservacion )
   {
      java.lang.StringBuffer sWhereString = new java.lang.StringBuffer();
      String scmdbuf;
      byte[] GXv_int13 = new byte[29];
      Object[] GXv_Object14 = new Object[2];
      scmdbuf = "SELECT T1.[ServicioObservacion], T1.[ServicioComision], T2.[LaboratorioId], T1.[ServicioCategId], T1.[ServicioCosto], T1.[ServicioId], T1.[ServicioEstado], T3.[LaboratorioNombre]," ;
      scmdbuf += " T1.[ServicioDescripcion], T1.[ServicioNombre] FROM (([Servicio] T1 INNER JOIN [ServicioCateg] T2 ON T2.[ServicioCategId] = T1.[ServicioCategId]) INNER JOIN [Laboratorio]" ;
      scmdbuf += " T3 ON T3.[LaboratorioId] = T2.[LaboratorioId])" ;
      if ( ! (GXutil.strcmp("", AV54Serviciowwds_1_filterfulltext)==0) )
      {
         addWhere(sWhereString, "(( CONVERT( char(4), CAST(T1.[ServicioId] AS decimal(4,0))) like '%' + ?) or ( T1.[ServicioNombre] like '%' + ?) or ( T1.[ServicioDescripcion] like '%' + ?) or ( CONVERT( char(6), CAST(T1.[ServicioCosto] AS decimal(6,2))) like '%' + ?) or ( CONVERT( char(4), CAST(T1.[ServicioCategId] AS decimal(4,0))) like '%' + ?) or ( CONVERT( char(4), CAST(T2.[LaboratorioId] AS decimal(4,0))) like '%' + ?) or ( T3.[LaboratorioNombre] like '%' + ?) or ( CONVERT( char(4), CAST(T1.[ServicioComision] AS decimal(4,0))) like '%' + ?) or ( T1.[ServicioObservacion] like '%' + ?) or ( 'activo' like '%' + LOWER(?) and T1.[ServicioEstado] = 'A') or ( 'inactivo' like '%' + LOWER(?) and T1.[ServicioEstado] = 'I'))");
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
         GXv_int13[10] = (byte)(1) ;
      }
      if ( ! (0==AV55Serviciowwds_2_tfservicioid) )
      {
         addWhere(sWhereString, "(T1.[ServicioId] >= ?)");
      }
      else
      {
         GXv_int13[11] = (byte)(1) ;
      }
      if ( ! (0==AV56Serviciowwds_3_tfservicioid_to) )
      {
         addWhere(sWhereString, "(T1.[ServicioId] <= ?)");
      }
      else
      {
         GXv_int13[12] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV58Serviciowwds_5_tfservicionombre_sel)==0) && ( ! (GXutil.strcmp("", AV57Serviciowwds_4_tfservicionombre)==0) ) )
      {
         addWhere(sWhereString, "(T1.[ServicioNombre] like ?)");
      }
      else
      {
         GXv_int13[13] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV58Serviciowwds_5_tfservicionombre_sel)==0) )
      {
         addWhere(sWhereString, "(T1.[ServicioNombre] = ?)");
      }
      else
      {
         GXv_int13[14] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV60Serviciowwds_7_tfserviciodescripcion_sel)==0) && ( ! (GXutil.strcmp("", AV59Serviciowwds_6_tfserviciodescripcion)==0) ) )
      {
         addWhere(sWhereString, "(T1.[ServicioDescripcion] like ?)");
      }
      else
      {
         GXv_int13[15] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV60Serviciowwds_7_tfserviciodescripcion_sel)==0) )
      {
         addWhere(sWhereString, "(T1.[ServicioDescripcion] = ?)");
      }
      else
      {
         GXv_int13[16] = (byte)(1) ;
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV61Serviciowwds_8_tfserviciocosto)==0) )
      {
         addWhere(sWhereString, "(T1.[ServicioCosto] >= ?)");
      }
      else
      {
         GXv_int13[17] = (byte)(1) ;
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV62Serviciowwds_9_tfserviciocosto_to)==0) )
      {
         addWhere(sWhereString, "(T1.[ServicioCosto] <= ?)");
      }
      else
      {
         GXv_int13[18] = (byte)(1) ;
      }
      if ( ! (0==AV63Serviciowwds_10_tfserviciocategid) )
      {
         addWhere(sWhereString, "(T1.[ServicioCategId] >= ?)");
      }
      else
      {
         GXv_int13[19] = (byte)(1) ;
      }
      if ( ! (0==AV64Serviciowwds_11_tfserviciocategid_to) )
      {
         addWhere(sWhereString, "(T1.[ServicioCategId] <= ?)");
      }
      else
      {
         GXv_int13[20] = (byte)(1) ;
      }
      if ( ! (0==AV65Serviciowwds_12_tflaboratorioid) )
      {
         addWhere(sWhereString, "(T2.[LaboratorioId] >= ?)");
      }
      else
      {
         GXv_int13[21] = (byte)(1) ;
      }
      if ( ! (0==AV66Serviciowwds_13_tflaboratorioid_to) )
      {
         addWhere(sWhereString, "(T2.[LaboratorioId] <= ?)");
      }
      else
      {
         GXv_int13[22] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV68Serviciowwds_15_tflaboratorionombre_sel)==0) && ( ! (GXutil.strcmp("", AV67Serviciowwds_14_tflaboratorionombre)==0) ) )
      {
         addWhere(sWhereString, "(T3.[LaboratorioNombre] like ?)");
      }
      else
      {
         GXv_int13[23] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV68Serviciowwds_15_tflaboratorionombre_sel)==0) )
      {
         addWhere(sWhereString, "(T3.[LaboratorioNombre] = ?)");
      }
      else
      {
         GXv_int13[24] = (byte)(1) ;
      }
      if ( ! (0==AV69Serviciowwds_16_tfserviciocomision) )
      {
         addWhere(sWhereString, "(T1.[ServicioComision] >= ?)");
      }
      else
      {
         GXv_int13[25] = (byte)(1) ;
      }
      if ( ! (0==AV70Serviciowwds_17_tfserviciocomision_to) )
      {
         addWhere(sWhereString, "(T1.[ServicioComision] <= ?)");
      }
      else
      {
         GXv_int13[26] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV72Serviciowwds_19_tfservicioobservacion_sel)==0) && ( ! (GXutil.strcmp("", AV71Serviciowwds_18_tfservicioobservacion)==0) ) )
      {
         addWhere(sWhereString, "(T1.[ServicioObservacion] like ?)");
      }
      else
      {
         GXv_int13[27] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV72Serviciowwds_19_tfservicioobservacion_sel)==0) )
      {
         addWhere(sWhereString, "(T1.[ServicioObservacion] = ?)");
      }
      else
      {
         GXv_int13[28] = (byte)(1) ;
      }
      if ( AV73Serviciowwds_20_tfservicioestado_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("sqlserver", AV73Serviciowwds_20_tfservicioestado_sels, "T1.[ServicioEstado] IN (", ")")+")");
      }
      scmdbuf += sWhereString ;
      scmdbuf += " ORDER BY T1.[ServicioObservacion]" ;
      GXv_Object14[0] = scmdbuf ;
      GXv_Object14[1] = GXv_int13 ;
      return GXv_Object14 ;
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
                  return conditional_P003O2(context, remoteHandle, httpContext, (String)dynConstraints[0] , (GXSimpleCollection<String>)dynConstraints[1] , (String)dynConstraints[2] , ((Number) dynConstraints[3]).shortValue() , ((Number) dynConstraints[4]).shortValue() , (String)dynConstraints[5] , (String)dynConstraints[6] , (String)dynConstraints[7] , (String)dynConstraints[8] , (java.math.BigDecimal)dynConstraints[9] , (java.math.BigDecimal)dynConstraints[10] , ((Number) dynConstraints[11]).shortValue() , ((Number) dynConstraints[12]).shortValue() , ((Number) dynConstraints[13]).shortValue() , ((Number) dynConstraints[14]).shortValue() , (String)dynConstraints[15] , (String)dynConstraints[16] , ((Number) dynConstraints[17]).shortValue() , ((Number) dynConstraints[18]).shortValue() , (String)dynConstraints[19] , (String)dynConstraints[20] , ((Number) dynConstraints[21]).intValue() , ((Number) dynConstraints[22]).shortValue() , (String)dynConstraints[23] , (String)dynConstraints[24] , (java.math.BigDecimal)dynConstraints[25] , ((Number) dynConstraints[26]).shortValue() , ((Number) dynConstraints[27]).shortValue() , (String)dynConstraints[28] , ((Number) dynConstraints[29]).shortValue() , (String)dynConstraints[30] );
            case 1 :
                  return conditional_P003O3(context, remoteHandle, httpContext, (String)dynConstraints[0] , (GXSimpleCollection<String>)dynConstraints[1] , (String)dynConstraints[2] , ((Number) dynConstraints[3]).shortValue() , ((Number) dynConstraints[4]).shortValue() , (String)dynConstraints[5] , (String)dynConstraints[6] , (String)dynConstraints[7] , (String)dynConstraints[8] , (java.math.BigDecimal)dynConstraints[9] , (java.math.BigDecimal)dynConstraints[10] , ((Number) dynConstraints[11]).shortValue() , ((Number) dynConstraints[12]).shortValue() , ((Number) dynConstraints[13]).shortValue() , ((Number) dynConstraints[14]).shortValue() , (String)dynConstraints[15] , (String)dynConstraints[16] , ((Number) dynConstraints[17]).shortValue() , ((Number) dynConstraints[18]).shortValue() , (String)dynConstraints[19] , (String)dynConstraints[20] , ((Number) dynConstraints[21]).intValue() , ((Number) dynConstraints[22]).shortValue() , (String)dynConstraints[23] , (String)dynConstraints[24] , (java.math.BigDecimal)dynConstraints[25] , ((Number) dynConstraints[26]).shortValue() , ((Number) dynConstraints[27]).shortValue() , (String)dynConstraints[28] , ((Number) dynConstraints[29]).shortValue() , (String)dynConstraints[30] );
            case 2 :
                  return conditional_P003O4(context, remoteHandle, httpContext, (String)dynConstraints[0] , (GXSimpleCollection<String>)dynConstraints[1] , (String)dynConstraints[2] , ((Number) dynConstraints[3]).shortValue() , ((Number) dynConstraints[4]).shortValue() , (String)dynConstraints[5] , (String)dynConstraints[6] , (String)dynConstraints[7] , (String)dynConstraints[8] , (java.math.BigDecimal)dynConstraints[9] , (java.math.BigDecimal)dynConstraints[10] , ((Number) dynConstraints[11]).shortValue() , ((Number) dynConstraints[12]).shortValue() , ((Number) dynConstraints[13]).shortValue() , ((Number) dynConstraints[14]).shortValue() , (String)dynConstraints[15] , (String)dynConstraints[16] , ((Number) dynConstraints[17]).shortValue() , ((Number) dynConstraints[18]).shortValue() , (String)dynConstraints[19] , (String)dynConstraints[20] , ((Number) dynConstraints[21]).intValue() , ((Number) dynConstraints[22]).shortValue() , (String)dynConstraints[23] , (String)dynConstraints[24] , (java.math.BigDecimal)dynConstraints[25] , ((Number) dynConstraints[26]).shortValue() , ((Number) dynConstraints[27]).shortValue() , (String)dynConstraints[28] , ((Number) dynConstraints[29]).shortValue() , (String)dynConstraints[30] );
            case 3 :
                  return conditional_P003O5(context, remoteHandle, httpContext, (String)dynConstraints[0] , (GXSimpleCollection<String>)dynConstraints[1] , (String)dynConstraints[2] , ((Number) dynConstraints[3]).shortValue() , ((Number) dynConstraints[4]).shortValue() , (String)dynConstraints[5] , (String)dynConstraints[6] , (String)dynConstraints[7] , (String)dynConstraints[8] , (java.math.BigDecimal)dynConstraints[9] , (java.math.BigDecimal)dynConstraints[10] , ((Number) dynConstraints[11]).shortValue() , ((Number) dynConstraints[12]).shortValue() , ((Number) dynConstraints[13]).shortValue() , ((Number) dynConstraints[14]).shortValue() , (String)dynConstraints[15] , (String)dynConstraints[16] , ((Number) dynConstraints[17]).shortValue() , ((Number) dynConstraints[18]).shortValue() , (String)dynConstraints[19] , (String)dynConstraints[20] , ((Number) dynConstraints[21]).intValue() , ((Number) dynConstraints[22]).shortValue() , (String)dynConstraints[23] , (String)dynConstraints[24] , (java.math.BigDecimal)dynConstraints[25] , ((Number) dynConstraints[26]).shortValue() , ((Number) dynConstraints[27]).shortValue() , (String)dynConstraints[28] , ((Number) dynConstraints[29]).shortValue() , (String)dynConstraints[30] );
      }
      return super.getDynamicStatement(cursor, context, remoteHandle, httpContext, dynConstraints);
   }

   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P003O2", "scmdbuf",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("P003O3", "scmdbuf",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("P003O4", "scmdbuf",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("P003O5", "scmdbuf",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
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
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((short[]) buf[2])[0] = rslt.getShort(3);
               ((short[]) buf[3])[0] = rslt.getShort(4);
               ((java.math.BigDecimal[]) buf[4])[0] = rslt.getBigDecimal(5,2);
               ((short[]) buf[5])[0] = rslt.getShort(6);
               ((String[]) buf[6])[0] = rslt.getString(7, 1);
               ((String[]) buf[7])[0] = rslt.getVarchar(8);
               ((String[]) buf[8])[0] = rslt.getVarchar(9);
               ((String[]) buf[9])[0] = rslt.getVarchar(10);
               return;
            case 1 :
               ((String[]) buf[0])[0] = rslt.getVarchar(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((short[]) buf[2])[0] = rslt.getShort(3);
               ((short[]) buf[3])[0] = rslt.getShort(4);
               ((java.math.BigDecimal[]) buf[4])[0] = rslt.getBigDecimal(5,2);
               ((short[]) buf[5])[0] = rslt.getShort(6);
               ((String[]) buf[6])[0] = rslt.getString(7, 1);
               ((String[]) buf[7])[0] = rslt.getVarchar(8);
               ((String[]) buf[8])[0] = rslt.getVarchar(9);
               ((String[]) buf[9])[0] = rslt.getVarchar(10);
               return;
            case 2 :
               ((String[]) buf[0])[0] = rslt.getVarchar(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((short[]) buf[2])[0] = rslt.getShort(3);
               ((short[]) buf[3])[0] = rslt.getShort(4);
               ((java.math.BigDecimal[]) buf[4])[0] = rslt.getBigDecimal(5,2);
               ((short[]) buf[5])[0] = rslt.getShort(6);
               ((String[]) buf[6])[0] = rslt.getString(7, 1);
               ((String[]) buf[7])[0] = rslt.getVarchar(8);
               ((String[]) buf[8])[0] = rslt.getVarchar(9);
               ((String[]) buf[9])[0] = rslt.getVarchar(10);
               return;
            case 3 :
               ((String[]) buf[0])[0] = rslt.getVarchar(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((short[]) buf[2])[0] = rslt.getShort(3);
               ((short[]) buf[3])[0] = rslt.getShort(4);
               ((java.math.BigDecimal[]) buf[4])[0] = rslt.getBigDecimal(5,2);
               ((short[]) buf[5])[0] = rslt.getShort(6);
               ((String[]) buf[6])[0] = rslt.getString(7, 1);
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
                  stmt.setVarchar(sIdx, (String)parms[29], 100);
               }
               if ( ((Number) parms[1]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[30], 100);
               }
               if ( ((Number) parms[2]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[31], 100);
               }
               if ( ((Number) parms[3]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[32], 100);
               }
               if ( ((Number) parms[4]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[33], 100);
               }
               if ( ((Number) parms[5]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[34], 100);
               }
               if ( ((Number) parms[6]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[35], 100);
               }
               if ( ((Number) parms[7]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[36], 100);
               }
               if ( ((Number) parms[8]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[37], 100);
               }
               if ( ((Number) parms[9]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[38], 100);
               }
               if ( ((Number) parms[10]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[39], 100);
               }
               if ( ((Number) parms[11]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[40]).shortValue());
               }
               if ( ((Number) parms[12]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[41]).shortValue());
               }
               if ( ((Number) parms[13]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[42], 40);
               }
               if ( ((Number) parms[14]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[43], 40);
               }
               if ( ((Number) parms[15]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[44], 100);
               }
               if ( ((Number) parms[16]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[45], 100);
               }
               if ( ((Number) parms[17]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setBigDecimal(sIdx, (java.math.BigDecimal)parms[46], 2);
               }
               if ( ((Number) parms[18]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setBigDecimal(sIdx, (java.math.BigDecimal)parms[47], 2);
               }
               if ( ((Number) parms[19]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[48]).shortValue());
               }
               if ( ((Number) parms[20]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[49]).shortValue());
               }
               if ( ((Number) parms[21]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[50]).shortValue());
               }
               if ( ((Number) parms[22]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[51]).shortValue());
               }
               if ( ((Number) parms[23]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[52], 100);
               }
               if ( ((Number) parms[24]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[53], 100);
               }
               if ( ((Number) parms[25]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[54]).shortValue());
               }
               if ( ((Number) parms[26]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[55]).shortValue());
               }
               if ( ((Number) parms[27]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[56], 100);
               }
               if ( ((Number) parms[28]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[57], 100);
               }
               return;
            case 1 :
               sIdx = (short)(0) ;
               if ( ((Number) parms[0]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[29], 100);
               }
               if ( ((Number) parms[1]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[30], 100);
               }
               if ( ((Number) parms[2]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[31], 100);
               }
               if ( ((Number) parms[3]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[32], 100);
               }
               if ( ((Number) parms[4]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[33], 100);
               }
               if ( ((Number) parms[5]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[34], 100);
               }
               if ( ((Number) parms[6]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[35], 100);
               }
               if ( ((Number) parms[7]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[36], 100);
               }
               if ( ((Number) parms[8]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[37], 100);
               }
               if ( ((Number) parms[9]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[38], 100);
               }
               if ( ((Number) parms[10]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[39], 100);
               }
               if ( ((Number) parms[11]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[40]).shortValue());
               }
               if ( ((Number) parms[12]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[41]).shortValue());
               }
               if ( ((Number) parms[13]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[42], 40);
               }
               if ( ((Number) parms[14]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[43], 40);
               }
               if ( ((Number) parms[15]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[44], 100);
               }
               if ( ((Number) parms[16]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[45], 100);
               }
               if ( ((Number) parms[17]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setBigDecimal(sIdx, (java.math.BigDecimal)parms[46], 2);
               }
               if ( ((Number) parms[18]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setBigDecimal(sIdx, (java.math.BigDecimal)parms[47], 2);
               }
               if ( ((Number) parms[19]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[48]).shortValue());
               }
               if ( ((Number) parms[20]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[49]).shortValue());
               }
               if ( ((Number) parms[21]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[50]).shortValue());
               }
               if ( ((Number) parms[22]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[51]).shortValue());
               }
               if ( ((Number) parms[23]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[52], 100);
               }
               if ( ((Number) parms[24]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[53], 100);
               }
               if ( ((Number) parms[25]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[54]).shortValue());
               }
               if ( ((Number) parms[26]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[55]).shortValue());
               }
               if ( ((Number) parms[27]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[56], 100);
               }
               if ( ((Number) parms[28]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[57], 100);
               }
               return;
            case 2 :
               sIdx = (short)(0) ;
               if ( ((Number) parms[0]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[29], 100);
               }
               if ( ((Number) parms[1]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[30], 100);
               }
               if ( ((Number) parms[2]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[31], 100);
               }
               if ( ((Number) parms[3]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[32], 100);
               }
               if ( ((Number) parms[4]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[33], 100);
               }
               if ( ((Number) parms[5]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[34], 100);
               }
               if ( ((Number) parms[6]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[35], 100);
               }
               if ( ((Number) parms[7]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[36], 100);
               }
               if ( ((Number) parms[8]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[37], 100);
               }
               if ( ((Number) parms[9]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[38], 100);
               }
               if ( ((Number) parms[10]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[39], 100);
               }
               if ( ((Number) parms[11]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[40]).shortValue());
               }
               if ( ((Number) parms[12]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[41]).shortValue());
               }
               if ( ((Number) parms[13]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[42], 40);
               }
               if ( ((Number) parms[14]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[43], 40);
               }
               if ( ((Number) parms[15]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[44], 100);
               }
               if ( ((Number) parms[16]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[45], 100);
               }
               if ( ((Number) parms[17]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setBigDecimal(sIdx, (java.math.BigDecimal)parms[46], 2);
               }
               if ( ((Number) parms[18]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setBigDecimal(sIdx, (java.math.BigDecimal)parms[47], 2);
               }
               if ( ((Number) parms[19]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[48]).shortValue());
               }
               if ( ((Number) parms[20]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[49]).shortValue());
               }
               if ( ((Number) parms[21]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[50]).shortValue());
               }
               if ( ((Number) parms[22]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[51]).shortValue());
               }
               if ( ((Number) parms[23]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[52], 100);
               }
               if ( ((Number) parms[24]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[53], 100);
               }
               if ( ((Number) parms[25]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[54]).shortValue());
               }
               if ( ((Number) parms[26]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[55]).shortValue());
               }
               if ( ((Number) parms[27]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[56], 100);
               }
               if ( ((Number) parms[28]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[57], 100);
               }
               return;
            case 3 :
               sIdx = (short)(0) ;
               if ( ((Number) parms[0]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[29], 100);
               }
               if ( ((Number) parms[1]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[30], 100);
               }
               if ( ((Number) parms[2]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[31], 100);
               }
               if ( ((Number) parms[3]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[32], 100);
               }
               if ( ((Number) parms[4]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[33], 100);
               }
               if ( ((Number) parms[5]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[34], 100);
               }
               if ( ((Number) parms[6]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[35], 100);
               }
               if ( ((Number) parms[7]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[36], 100);
               }
               if ( ((Number) parms[8]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[37], 100);
               }
               if ( ((Number) parms[9]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[38], 100);
               }
               if ( ((Number) parms[10]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[39], 100);
               }
               if ( ((Number) parms[11]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[40]).shortValue());
               }
               if ( ((Number) parms[12]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[41]).shortValue());
               }
               if ( ((Number) parms[13]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[42], 40);
               }
               if ( ((Number) parms[14]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[43], 40);
               }
               if ( ((Number) parms[15]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[44], 100);
               }
               if ( ((Number) parms[16]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[45], 100);
               }
               if ( ((Number) parms[17]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setBigDecimal(sIdx, (java.math.BigDecimal)parms[46], 2);
               }
               if ( ((Number) parms[18]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setBigDecimal(sIdx, (java.math.BigDecimal)parms[47], 2);
               }
               if ( ((Number) parms[19]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[48]).shortValue());
               }
               if ( ((Number) parms[20]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[49]).shortValue());
               }
               if ( ((Number) parms[21]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[50]).shortValue());
               }
               if ( ((Number) parms[22]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[51]).shortValue());
               }
               if ( ((Number) parms[23]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[52], 100);
               }
               if ( ((Number) parms[24]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[53], 100);
               }
               if ( ((Number) parms[25]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[54]).shortValue());
               }
               if ( ((Number) parms[26]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[55]).shortValue());
               }
               if ( ((Number) parms[27]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[56], 100);
               }
               if ( ((Number) parms[28]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[57], 100);
               }
               return;
      }
   }

}

