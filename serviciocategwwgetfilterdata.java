package com.projectthani ;
import com.projectthani.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class serviciocategwwgetfilterdata extends GXProcedure
{
   public serviciocategwwgetfilterdata( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( serviciocategwwgetfilterdata.class ), "" );
   }

   public serviciocategwwgetfilterdata( int remoteHandle ,
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
      serviciocategwwgetfilterdata.this.aP5 = new String[] {""};
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
      serviciocategwwgetfilterdata.this.AV25DDOName = aP0;
      serviciocategwwgetfilterdata.this.AV23SearchTxt = aP1;
      serviciocategwwgetfilterdata.this.AV24SearchTxtTo = aP2;
      serviciocategwwgetfilterdata.this.aP3 = aP3;
      serviciocategwwgetfilterdata.this.aP4 = aP4;
      serviciocategwwgetfilterdata.this.aP5 = aP5;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      AV28Options = new GXSimpleCollection<String>(String.class, "internal", "") ;
      AV31OptionsDesc = new GXSimpleCollection<String>(String.class, "internal", "") ;
      AV33OptionIndexes = new GXSimpleCollection<String>(String.class, "internal", "") ;
      GXt_boolean1 = AV8IsAuthorized ;
      GXv_boolean2[0] = GXt_boolean1 ;
      new com.projectthani.wwpbaseobjects.secisauthbyfunctionalitykey(remoteHandle, context).execute( "WWServicioCateg", GXv_boolean2) ;
      serviciocategwwgetfilterdata.this.GXt_boolean1 = GXv_boolean2[0] ;
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
         if ( GXutil.strcmp(GXutil.upper( AV25DDOName), "DDO_LABORATORIONOMBRE") == 0 )
         {
            /* Execute user subroutine: 'LOADLABORATORIONOMBREOPTIONS' */
            S121 ();
            if ( returnInSub )
            {
               returnInSub = true;
               cleanup();
               if (true) return;
            }
         }
         else if ( GXutil.strcmp(GXutil.upper( AV25DDOName), "DDO_SERVICIOCATEGNOMBRE") == 0 )
         {
            /* Execute user subroutine: 'LOADSERVICIOCATEGNOMBREOPTIONS' */
            S131 ();
            if ( returnInSub )
            {
               returnInSub = true;
               cleanup();
               if (true) return;
            }
         }
         else if ( GXutil.strcmp(GXutil.upper( AV25DDOName), "DDO_SERVICIOCATEGDESCRIPCION") == 0 )
         {
            /* Execute user subroutine: 'LOADSERVICIOCATEGDESCRIPCIONOPTIONS' */
            S141 ();
            if ( returnInSub )
            {
               returnInSub = true;
               cleanup();
               if (true) return;
            }
         }
      }
      AV29OptionsJson = AV28Options.toJSonString(false) ;
      AV32OptionsDescJson = AV31OptionsDesc.toJSonString(false) ;
      AV34OptionIndexesJson = AV33OptionIndexes.toJSonString(false) ;
      cleanup();
   }

   public void S111( )
   {
      /* 'LOADGRIDSTATE' Routine */
      returnInSub = false ;
      if ( GXutil.strcmp(AV36Session.getValue("ServicioCategWWGridState"), "") == 0 )
      {
         AV38GridState.fromxml(new com.projectthani.wwpbaseobjects.loadgridstate(remoteHandle, context).executeUdp( "ServicioCategWWGridState"), null, null);
      }
      else
      {
         AV38GridState.fromxml(AV36Session.getValue("ServicioCategWWGridState"), null, null);
      }
      AV44GXV1 = 1 ;
      while ( AV44GXV1 <= AV38GridState.getgxTv_SdtWWPGridState_Filtervalues().size() )
      {
         AV39GridStateFilterValue = (com.projectthani.wwpbaseobjects.SdtWWPGridState_FilterValue)((com.projectthani.wwpbaseobjects.SdtWWPGridState_FilterValue)AV38GridState.getgxTv_SdtWWPGridState_Filtervalues().elementAt(-1+AV44GXV1));
         if ( GXutil.strcmp(AV39GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "FILTERFULLTEXT") == 0 )
         {
            AV41FilterFullText = AV39GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV39GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFSERVICIOCATEGID") == 0 )
         {
            AV11TFServicioCategId = (short)(GXutil.lval( AV39GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value())) ;
            AV12TFServicioCategId_To = (short)(GXutil.lval( AV39GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Valueto())) ;
         }
         else if ( GXutil.strcmp(AV39GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFLABORATORIOID") == 0 )
         {
            AV13TFLaboratorioId = (short)(GXutil.lval( AV39GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value())) ;
            AV14TFLaboratorioId_To = (short)(GXutil.lval( AV39GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Valueto())) ;
         }
         else if ( GXutil.strcmp(AV39GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFLABORATORIONOMBRE") == 0 )
         {
            AV15TFLaboratorioNombre = AV39GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV39GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFLABORATORIONOMBRE_SEL") == 0 )
         {
            AV16TFLaboratorioNombre_Sel = AV39GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV39GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFSERVICIOCATEGNOMBRE") == 0 )
         {
            AV17TFServicioCategNombre = AV39GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV39GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFSERVICIOCATEGNOMBRE_SEL") == 0 )
         {
            AV18TFServicioCategNombre_Sel = AV39GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV39GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFSERVICIOCATEGDESCRIPCION") == 0 )
         {
            AV19TFServicioCategDescripcion = AV39GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV39GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFSERVICIOCATEGDESCRIPCION_SEL") == 0 )
         {
            AV20TFServicioCategDescripcion_Sel = AV39GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV39GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFSERVICIOCATEGESTADO_SEL") == 0 )
         {
            AV21TFServicioCategEstado_SelsJson = AV39GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            AV22TFServicioCategEstado_Sels.fromJSonString(AV21TFServicioCategEstado_SelsJson, null);
         }
         AV44GXV1 = (int)(AV44GXV1+1) ;
      }
   }

   public void S121( )
   {
      /* 'LOADLABORATORIONOMBREOPTIONS' Routine */
      returnInSub = false ;
      AV15TFLaboratorioNombre = AV23SearchTxt ;
      AV16TFLaboratorioNombre_Sel = "" ;
      AV46Serviciocategwwds_1_filterfulltext = AV41FilterFullText ;
      AV47Serviciocategwwds_2_tfserviciocategid = AV11TFServicioCategId ;
      AV48Serviciocategwwds_3_tfserviciocategid_to = AV12TFServicioCategId_To ;
      AV49Serviciocategwwds_4_tflaboratorioid = AV13TFLaboratorioId ;
      AV50Serviciocategwwds_5_tflaboratorioid_to = AV14TFLaboratorioId_To ;
      AV51Serviciocategwwds_6_tflaboratorionombre = AV15TFLaboratorioNombre ;
      AV52Serviciocategwwds_7_tflaboratorionombre_sel = AV16TFLaboratorioNombre_Sel ;
      AV53Serviciocategwwds_8_tfserviciocategnombre = AV17TFServicioCategNombre ;
      AV54Serviciocategwwds_9_tfserviciocategnombre_sel = AV18TFServicioCategNombre_Sel ;
      AV55Serviciocategwwds_10_tfserviciocategdescripcion = AV19TFServicioCategDescripcion ;
      AV56Serviciocategwwds_11_tfserviciocategdescripcion_sel = AV20TFServicioCategDescripcion_Sel ;
      AV57Serviciocategwwds_12_tfserviciocategestado_sels = AV22TFServicioCategEstado_Sels ;
      pr_default.dynParam(0, new Object[]{ new Object[]{
                                           A290ServicioCategEstado ,
                                           AV57Serviciocategwwds_12_tfserviciocategestado_sels ,
                                           AV46Serviciocategwwds_1_filterfulltext ,
                                           Short.valueOf(AV47Serviciocategwwds_2_tfserviciocategid) ,
                                           Short.valueOf(AV48Serviciocategwwds_3_tfserviciocategid_to) ,
                                           Short.valueOf(AV49Serviciocategwwds_4_tflaboratorioid) ,
                                           Short.valueOf(AV50Serviciocategwwds_5_tflaboratorioid_to) ,
                                           AV52Serviciocategwwds_7_tflaboratorionombre_sel ,
                                           AV51Serviciocategwwds_6_tflaboratorionombre ,
                                           AV54Serviciocategwwds_9_tfserviciocategnombre_sel ,
                                           AV53Serviciocategwwds_8_tfserviciocategnombre ,
                                           AV56Serviciocategwwds_11_tfserviciocategdescripcion_sel ,
                                           AV55Serviciocategwwds_10_tfserviciocategdescripcion ,
                                           Integer.valueOf(AV57Serviciocategwwds_12_tfserviciocategestado_sels.size()) ,
                                           Short.valueOf(A52ServicioCategId) ,
                                           Short.valueOf(A40LaboratorioId) ,
                                           A165LaboratorioNombre ,
                                           A287ServicioCategNombre ,
                                           A288ServicioCategDescripcion } ,
                                           new int[]{
                                           TypeConstants.STRING, TypeConstants.STRING, TypeConstants.SHORT, TypeConstants.SHORT, TypeConstants.SHORT, TypeConstants.SHORT, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING,
                                           TypeConstants.STRING, TypeConstants.STRING, TypeConstants.INT, TypeConstants.SHORT, TypeConstants.SHORT, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.BOOLEAN
                                           }
      });
      lV46Serviciocategwwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV46Serviciocategwwds_1_filterfulltext), "%", "") ;
      lV46Serviciocategwwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV46Serviciocategwwds_1_filterfulltext), "%", "") ;
      lV46Serviciocategwwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV46Serviciocategwwds_1_filterfulltext), "%", "") ;
      lV46Serviciocategwwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV46Serviciocategwwds_1_filterfulltext), "%", "") ;
      lV46Serviciocategwwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV46Serviciocategwwds_1_filterfulltext), "%", "") ;
      lV46Serviciocategwwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV46Serviciocategwwds_1_filterfulltext), "%", "") ;
      lV46Serviciocategwwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV46Serviciocategwwds_1_filterfulltext), "%", "") ;
      lV51Serviciocategwwds_6_tflaboratorionombre = GXutil.concat( GXutil.rtrim( AV51Serviciocategwwds_6_tflaboratorionombre), "%", "") ;
      lV53Serviciocategwwds_8_tfserviciocategnombre = GXutil.concat( GXutil.rtrim( AV53Serviciocategwwds_8_tfserviciocategnombre), "%", "") ;
      lV55Serviciocategwwds_10_tfserviciocategdescripcion = GXutil.concat( GXutil.rtrim( AV55Serviciocategwwds_10_tfserviciocategdescripcion), "%", "") ;
      /* Using cursor P003Q2 */
      pr_default.execute(0, new Object[] {lV46Serviciocategwwds_1_filterfulltext, lV46Serviciocategwwds_1_filterfulltext, lV46Serviciocategwwds_1_filterfulltext, lV46Serviciocategwwds_1_filterfulltext, lV46Serviciocategwwds_1_filterfulltext, lV46Serviciocategwwds_1_filterfulltext, lV46Serviciocategwwds_1_filterfulltext, Short.valueOf(AV47Serviciocategwwds_2_tfserviciocategid), Short.valueOf(AV48Serviciocategwwds_3_tfserviciocategid_to), Short.valueOf(AV49Serviciocategwwds_4_tflaboratorioid), Short.valueOf(AV50Serviciocategwwds_5_tflaboratorioid_to), lV51Serviciocategwwds_6_tflaboratorionombre, AV52Serviciocategwwds_7_tflaboratorionombre_sel, lV53Serviciocategwwds_8_tfserviciocategnombre, AV54Serviciocategwwds_9_tfserviciocategnombre_sel, lV55Serviciocategwwds_10_tfserviciocategdescripcion, AV56Serviciocategwwds_11_tfserviciocategdescripcion_sel});
      while ( (pr_default.getStatus(0) != 101) )
      {
         brk3Q2 = false ;
         A40LaboratorioId = P003Q2_A40LaboratorioId[0] ;
         A52ServicioCategId = P003Q2_A52ServicioCategId[0] ;
         A290ServicioCategEstado = P003Q2_A290ServicioCategEstado[0] ;
         A288ServicioCategDescripcion = P003Q2_A288ServicioCategDescripcion[0] ;
         n288ServicioCategDescripcion = P003Q2_n288ServicioCategDescripcion[0] ;
         A287ServicioCategNombre = P003Q2_A287ServicioCategNombre[0] ;
         A165LaboratorioNombre = P003Q2_A165LaboratorioNombre[0] ;
         A165LaboratorioNombre = P003Q2_A165LaboratorioNombre[0] ;
         AV35count = 0 ;
         while ( (pr_default.getStatus(0) != 101) && ( P003Q2_A40LaboratorioId[0] == A40LaboratorioId ) )
         {
            brk3Q2 = false ;
            A52ServicioCategId = P003Q2_A52ServicioCategId[0] ;
            AV35count = (long)(AV35count+1) ;
            brk3Q2 = true ;
            pr_default.readNext(0);
         }
         if ( ! (GXutil.strcmp("", A165LaboratorioNombre)==0) )
         {
            AV27Option = A165LaboratorioNombre ;
            AV26InsertIndex = 1 ;
            while ( ( AV26InsertIndex <= AV28Options.size() ) && ( GXutil.strcmp((String)AV28Options.elementAt(-1+AV26InsertIndex), AV27Option) < 0 ) )
            {
               AV26InsertIndex = (int)(AV26InsertIndex+1) ;
            }
            AV28Options.add(AV27Option, AV26InsertIndex);
            AV33OptionIndexes.add(GXutil.trim( localUtil.format( DecimalUtil.doubleToDec(AV35count), "Z,ZZZ,ZZZ,ZZ9")), AV26InsertIndex);
         }
         if ( AV28Options.size() == 50 )
         {
            /* Exit For each command. Update data (if necessary), close cursors & exit. */
            if (true) break;
         }
         if ( ! brk3Q2 )
         {
            brk3Q2 = true ;
            pr_default.readNext(0);
         }
      }
      pr_default.close(0);
   }

   public void S131( )
   {
      /* 'LOADSERVICIOCATEGNOMBREOPTIONS' Routine */
      returnInSub = false ;
      AV17TFServicioCategNombre = AV23SearchTxt ;
      AV18TFServicioCategNombre_Sel = "" ;
      AV46Serviciocategwwds_1_filterfulltext = AV41FilterFullText ;
      AV47Serviciocategwwds_2_tfserviciocategid = AV11TFServicioCategId ;
      AV48Serviciocategwwds_3_tfserviciocategid_to = AV12TFServicioCategId_To ;
      AV49Serviciocategwwds_4_tflaboratorioid = AV13TFLaboratorioId ;
      AV50Serviciocategwwds_5_tflaboratorioid_to = AV14TFLaboratorioId_To ;
      AV51Serviciocategwwds_6_tflaboratorionombre = AV15TFLaboratorioNombre ;
      AV52Serviciocategwwds_7_tflaboratorionombre_sel = AV16TFLaboratorioNombre_Sel ;
      AV53Serviciocategwwds_8_tfserviciocategnombre = AV17TFServicioCategNombre ;
      AV54Serviciocategwwds_9_tfserviciocategnombre_sel = AV18TFServicioCategNombre_Sel ;
      AV55Serviciocategwwds_10_tfserviciocategdescripcion = AV19TFServicioCategDescripcion ;
      AV56Serviciocategwwds_11_tfserviciocategdescripcion_sel = AV20TFServicioCategDescripcion_Sel ;
      AV57Serviciocategwwds_12_tfserviciocategestado_sels = AV22TFServicioCategEstado_Sels ;
      pr_default.dynParam(1, new Object[]{ new Object[]{
                                           A290ServicioCategEstado ,
                                           AV57Serviciocategwwds_12_tfserviciocategestado_sels ,
                                           AV46Serviciocategwwds_1_filterfulltext ,
                                           Short.valueOf(AV47Serviciocategwwds_2_tfserviciocategid) ,
                                           Short.valueOf(AV48Serviciocategwwds_3_tfserviciocategid_to) ,
                                           Short.valueOf(AV49Serviciocategwwds_4_tflaboratorioid) ,
                                           Short.valueOf(AV50Serviciocategwwds_5_tflaboratorioid_to) ,
                                           AV52Serviciocategwwds_7_tflaboratorionombre_sel ,
                                           AV51Serviciocategwwds_6_tflaboratorionombre ,
                                           AV54Serviciocategwwds_9_tfserviciocategnombre_sel ,
                                           AV53Serviciocategwwds_8_tfserviciocategnombre ,
                                           AV56Serviciocategwwds_11_tfserviciocategdescripcion_sel ,
                                           AV55Serviciocategwwds_10_tfserviciocategdescripcion ,
                                           Integer.valueOf(AV57Serviciocategwwds_12_tfserviciocategestado_sels.size()) ,
                                           Short.valueOf(A52ServicioCategId) ,
                                           Short.valueOf(A40LaboratorioId) ,
                                           A165LaboratorioNombre ,
                                           A287ServicioCategNombre ,
                                           A288ServicioCategDescripcion } ,
                                           new int[]{
                                           TypeConstants.STRING, TypeConstants.STRING, TypeConstants.SHORT, TypeConstants.SHORT, TypeConstants.SHORT, TypeConstants.SHORT, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING,
                                           TypeConstants.STRING, TypeConstants.STRING, TypeConstants.INT, TypeConstants.SHORT, TypeConstants.SHORT, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.BOOLEAN
                                           }
      });
      lV46Serviciocategwwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV46Serviciocategwwds_1_filterfulltext), "%", "") ;
      lV46Serviciocategwwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV46Serviciocategwwds_1_filterfulltext), "%", "") ;
      lV46Serviciocategwwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV46Serviciocategwwds_1_filterfulltext), "%", "") ;
      lV46Serviciocategwwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV46Serviciocategwwds_1_filterfulltext), "%", "") ;
      lV46Serviciocategwwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV46Serviciocategwwds_1_filterfulltext), "%", "") ;
      lV46Serviciocategwwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV46Serviciocategwwds_1_filterfulltext), "%", "") ;
      lV46Serviciocategwwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV46Serviciocategwwds_1_filterfulltext), "%", "") ;
      lV51Serviciocategwwds_6_tflaboratorionombre = GXutil.concat( GXutil.rtrim( AV51Serviciocategwwds_6_tflaboratorionombre), "%", "") ;
      lV53Serviciocategwwds_8_tfserviciocategnombre = GXutil.concat( GXutil.rtrim( AV53Serviciocategwwds_8_tfserviciocategnombre), "%", "") ;
      lV55Serviciocategwwds_10_tfserviciocategdescripcion = GXutil.concat( GXutil.rtrim( AV55Serviciocategwwds_10_tfserviciocategdescripcion), "%", "") ;
      /* Using cursor P003Q3 */
      pr_default.execute(1, new Object[] {lV46Serviciocategwwds_1_filterfulltext, lV46Serviciocategwwds_1_filterfulltext, lV46Serviciocategwwds_1_filterfulltext, lV46Serviciocategwwds_1_filterfulltext, lV46Serviciocategwwds_1_filterfulltext, lV46Serviciocategwwds_1_filterfulltext, lV46Serviciocategwwds_1_filterfulltext, Short.valueOf(AV47Serviciocategwwds_2_tfserviciocategid), Short.valueOf(AV48Serviciocategwwds_3_tfserviciocategid_to), Short.valueOf(AV49Serviciocategwwds_4_tflaboratorioid), Short.valueOf(AV50Serviciocategwwds_5_tflaboratorioid_to), lV51Serviciocategwwds_6_tflaboratorionombre, AV52Serviciocategwwds_7_tflaboratorionombre_sel, lV53Serviciocategwwds_8_tfserviciocategnombre, AV54Serviciocategwwds_9_tfserviciocategnombre_sel, lV55Serviciocategwwds_10_tfserviciocategdescripcion, AV56Serviciocategwwds_11_tfserviciocategdescripcion_sel});
      while ( (pr_default.getStatus(1) != 101) )
      {
         brk3Q4 = false ;
         A287ServicioCategNombre = P003Q3_A287ServicioCategNombre[0] ;
         A40LaboratorioId = P003Q3_A40LaboratorioId[0] ;
         A52ServicioCategId = P003Q3_A52ServicioCategId[0] ;
         A290ServicioCategEstado = P003Q3_A290ServicioCategEstado[0] ;
         A288ServicioCategDescripcion = P003Q3_A288ServicioCategDescripcion[0] ;
         n288ServicioCategDescripcion = P003Q3_n288ServicioCategDescripcion[0] ;
         A165LaboratorioNombre = P003Q3_A165LaboratorioNombre[0] ;
         A165LaboratorioNombre = P003Q3_A165LaboratorioNombre[0] ;
         AV35count = 0 ;
         while ( (pr_default.getStatus(1) != 101) && ( GXutil.strcmp(P003Q3_A287ServicioCategNombre[0], A287ServicioCategNombre) == 0 ) )
         {
            brk3Q4 = false ;
            A52ServicioCategId = P003Q3_A52ServicioCategId[0] ;
            AV35count = (long)(AV35count+1) ;
            brk3Q4 = true ;
            pr_default.readNext(1);
         }
         if ( ! (GXutil.strcmp("", A287ServicioCategNombre)==0) )
         {
            AV27Option = A287ServicioCategNombre ;
            AV28Options.add(AV27Option, 0);
            AV33OptionIndexes.add(GXutil.trim( localUtil.format( DecimalUtil.doubleToDec(AV35count), "Z,ZZZ,ZZZ,ZZ9")), 0);
         }
         if ( AV28Options.size() == 50 )
         {
            /* Exit For each command. Update data (if necessary), close cursors & exit. */
            if (true) break;
         }
         if ( ! brk3Q4 )
         {
            brk3Q4 = true ;
            pr_default.readNext(1);
         }
      }
      pr_default.close(1);
   }

   public void S141( )
   {
      /* 'LOADSERVICIOCATEGDESCRIPCIONOPTIONS' Routine */
      returnInSub = false ;
      AV19TFServicioCategDescripcion = AV23SearchTxt ;
      AV20TFServicioCategDescripcion_Sel = "" ;
      AV46Serviciocategwwds_1_filterfulltext = AV41FilterFullText ;
      AV47Serviciocategwwds_2_tfserviciocategid = AV11TFServicioCategId ;
      AV48Serviciocategwwds_3_tfserviciocategid_to = AV12TFServicioCategId_To ;
      AV49Serviciocategwwds_4_tflaboratorioid = AV13TFLaboratorioId ;
      AV50Serviciocategwwds_5_tflaboratorioid_to = AV14TFLaboratorioId_To ;
      AV51Serviciocategwwds_6_tflaboratorionombre = AV15TFLaboratorioNombre ;
      AV52Serviciocategwwds_7_tflaboratorionombre_sel = AV16TFLaboratorioNombre_Sel ;
      AV53Serviciocategwwds_8_tfserviciocategnombre = AV17TFServicioCategNombre ;
      AV54Serviciocategwwds_9_tfserviciocategnombre_sel = AV18TFServicioCategNombre_Sel ;
      AV55Serviciocategwwds_10_tfserviciocategdescripcion = AV19TFServicioCategDescripcion ;
      AV56Serviciocategwwds_11_tfserviciocategdescripcion_sel = AV20TFServicioCategDescripcion_Sel ;
      AV57Serviciocategwwds_12_tfserviciocategestado_sels = AV22TFServicioCategEstado_Sels ;
      pr_default.dynParam(2, new Object[]{ new Object[]{
                                           A290ServicioCategEstado ,
                                           AV57Serviciocategwwds_12_tfserviciocategestado_sels ,
                                           AV46Serviciocategwwds_1_filterfulltext ,
                                           Short.valueOf(AV47Serviciocategwwds_2_tfserviciocategid) ,
                                           Short.valueOf(AV48Serviciocategwwds_3_tfserviciocategid_to) ,
                                           Short.valueOf(AV49Serviciocategwwds_4_tflaboratorioid) ,
                                           Short.valueOf(AV50Serviciocategwwds_5_tflaboratorioid_to) ,
                                           AV52Serviciocategwwds_7_tflaboratorionombre_sel ,
                                           AV51Serviciocategwwds_6_tflaboratorionombre ,
                                           AV54Serviciocategwwds_9_tfserviciocategnombre_sel ,
                                           AV53Serviciocategwwds_8_tfserviciocategnombre ,
                                           AV56Serviciocategwwds_11_tfserviciocategdescripcion_sel ,
                                           AV55Serviciocategwwds_10_tfserviciocategdescripcion ,
                                           Integer.valueOf(AV57Serviciocategwwds_12_tfserviciocategestado_sels.size()) ,
                                           Short.valueOf(A52ServicioCategId) ,
                                           Short.valueOf(A40LaboratorioId) ,
                                           A165LaboratorioNombre ,
                                           A287ServicioCategNombre ,
                                           A288ServicioCategDescripcion } ,
                                           new int[]{
                                           TypeConstants.STRING, TypeConstants.STRING, TypeConstants.SHORT, TypeConstants.SHORT, TypeConstants.SHORT, TypeConstants.SHORT, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING,
                                           TypeConstants.STRING, TypeConstants.STRING, TypeConstants.INT, TypeConstants.SHORT, TypeConstants.SHORT, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.BOOLEAN
                                           }
      });
      lV46Serviciocategwwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV46Serviciocategwwds_1_filterfulltext), "%", "") ;
      lV46Serviciocategwwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV46Serviciocategwwds_1_filterfulltext), "%", "") ;
      lV46Serviciocategwwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV46Serviciocategwwds_1_filterfulltext), "%", "") ;
      lV46Serviciocategwwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV46Serviciocategwwds_1_filterfulltext), "%", "") ;
      lV46Serviciocategwwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV46Serviciocategwwds_1_filterfulltext), "%", "") ;
      lV46Serviciocategwwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV46Serviciocategwwds_1_filterfulltext), "%", "") ;
      lV46Serviciocategwwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV46Serviciocategwwds_1_filterfulltext), "%", "") ;
      lV51Serviciocategwwds_6_tflaboratorionombre = GXutil.concat( GXutil.rtrim( AV51Serviciocategwwds_6_tflaboratorionombre), "%", "") ;
      lV53Serviciocategwwds_8_tfserviciocategnombre = GXutil.concat( GXutil.rtrim( AV53Serviciocategwwds_8_tfserviciocategnombre), "%", "") ;
      lV55Serviciocategwwds_10_tfserviciocategdescripcion = GXutil.concat( GXutil.rtrim( AV55Serviciocategwwds_10_tfserviciocategdescripcion), "%", "") ;
      /* Using cursor P003Q4 */
      pr_default.execute(2, new Object[] {lV46Serviciocategwwds_1_filterfulltext, lV46Serviciocategwwds_1_filterfulltext, lV46Serviciocategwwds_1_filterfulltext, lV46Serviciocategwwds_1_filterfulltext, lV46Serviciocategwwds_1_filterfulltext, lV46Serviciocategwwds_1_filterfulltext, lV46Serviciocategwwds_1_filterfulltext, Short.valueOf(AV47Serviciocategwwds_2_tfserviciocategid), Short.valueOf(AV48Serviciocategwwds_3_tfserviciocategid_to), Short.valueOf(AV49Serviciocategwwds_4_tflaboratorioid), Short.valueOf(AV50Serviciocategwwds_5_tflaboratorioid_to), lV51Serviciocategwwds_6_tflaboratorionombre, AV52Serviciocategwwds_7_tflaboratorionombre_sel, lV53Serviciocategwwds_8_tfserviciocategnombre, AV54Serviciocategwwds_9_tfserviciocategnombre_sel, lV55Serviciocategwwds_10_tfserviciocategdescripcion, AV56Serviciocategwwds_11_tfserviciocategdescripcion_sel});
      while ( (pr_default.getStatus(2) != 101) )
      {
         brk3Q6 = false ;
         A288ServicioCategDescripcion = P003Q4_A288ServicioCategDescripcion[0] ;
         n288ServicioCategDescripcion = P003Q4_n288ServicioCategDescripcion[0] ;
         A40LaboratorioId = P003Q4_A40LaboratorioId[0] ;
         A52ServicioCategId = P003Q4_A52ServicioCategId[0] ;
         A290ServicioCategEstado = P003Q4_A290ServicioCategEstado[0] ;
         A287ServicioCategNombre = P003Q4_A287ServicioCategNombre[0] ;
         A165LaboratorioNombre = P003Q4_A165LaboratorioNombre[0] ;
         A165LaboratorioNombre = P003Q4_A165LaboratorioNombre[0] ;
         AV35count = 0 ;
         while ( (pr_default.getStatus(2) != 101) && ( GXutil.strcmp(P003Q4_A288ServicioCategDescripcion[0], A288ServicioCategDescripcion) == 0 ) )
         {
            brk3Q6 = false ;
            A52ServicioCategId = P003Q4_A52ServicioCategId[0] ;
            AV35count = (long)(AV35count+1) ;
            brk3Q6 = true ;
            pr_default.readNext(2);
         }
         if ( ! (GXutil.strcmp("", A288ServicioCategDescripcion)==0) )
         {
            AV27Option = A288ServicioCategDescripcion ;
            AV28Options.add(AV27Option, 0);
            AV33OptionIndexes.add(GXutil.trim( localUtil.format( DecimalUtil.doubleToDec(AV35count), "Z,ZZZ,ZZZ,ZZ9")), 0);
         }
         if ( AV28Options.size() == 50 )
         {
            /* Exit For each command. Update data (if necessary), close cursors & exit. */
            if (true) break;
         }
         if ( ! brk3Q6 )
         {
            brk3Q6 = true ;
            pr_default.readNext(2);
         }
      }
      pr_default.close(2);
   }

   protected void cleanup( )
   {
      this.aP3[0] = serviciocategwwgetfilterdata.this.AV29OptionsJson;
      this.aP4[0] = serviciocategwwgetfilterdata.this.AV32OptionsDescJson;
      this.aP5[0] = serviciocategwwgetfilterdata.this.AV34OptionIndexesJson;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV29OptionsJson = "" ;
      AV32OptionsDescJson = "" ;
      AV34OptionIndexesJson = "" ;
      AV28Options = new GXSimpleCollection<String>(String.class, "internal", "");
      AV31OptionsDesc = new GXSimpleCollection<String>(String.class, "internal", "");
      AV33OptionIndexes = new GXSimpleCollection<String>(String.class, "internal", "");
      GXv_boolean2 = new boolean[1] ;
      AV9WWPContext = new com.projectthani.wwpbaseobjects.SdtWWPContext(remoteHandle, context);
      GXv_SdtWWPContext3 = new com.projectthani.wwpbaseobjects.SdtWWPContext[1] ;
      AV36Session = httpContext.getWebSession();
      AV38GridState = new com.projectthani.wwpbaseobjects.SdtWWPGridState(remoteHandle, context);
      AV39GridStateFilterValue = new com.projectthani.wwpbaseobjects.SdtWWPGridState_FilterValue(remoteHandle, context);
      AV41FilterFullText = "" ;
      AV15TFLaboratorioNombre = "" ;
      AV16TFLaboratorioNombre_Sel = "" ;
      AV17TFServicioCategNombre = "" ;
      AV18TFServicioCategNombre_Sel = "" ;
      AV19TFServicioCategDescripcion = "" ;
      AV20TFServicioCategDescripcion_Sel = "" ;
      AV21TFServicioCategEstado_SelsJson = "" ;
      AV22TFServicioCategEstado_Sels = new GXSimpleCollection<String>(String.class, "internal", "");
      A165LaboratorioNombre = "" ;
      AV46Serviciocategwwds_1_filterfulltext = "" ;
      AV51Serviciocategwwds_6_tflaboratorionombre = "" ;
      AV52Serviciocategwwds_7_tflaboratorionombre_sel = "" ;
      AV53Serviciocategwwds_8_tfserviciocategnombre = "" ;
      AV54Serviciocategwwds_9_tfserviciocategnombre_sel = "" ;
      AV55Serviciocategwwds_10_tfserviciocategdescripcion = "" ;
      AV56Serviciocategwwds_11_tfserviciocategdescripcion_sel = "" ;
      AV57Serviciocategwwds_12_tfserviciocategestado_sels = new GXSimpleCollection<String>(String.class, "internal", "");
      scmdbuf = "" ;
      lV46Serviciocategwwds_1_filterfulltext = "" ;
      lV51Serviciocategwwds_6_tflaboratorionombre = "" ;
      lV53Serviciocategwwds_8_tfserviciocategnombre = "" ;
      lV55Serviciocategwwds_10_tfserviciocategdescripcion = "" ;
      A290ServicioCategEstado = "" ;
      A287ServicioCategNombre = "" ;
      A288ServicioCategDescripcion = "" ;
      P003Q2_A40LaboratorioId = new short[1] ;
      P003Q2_A52ServicioCategId = new short[1] ;
      P003Q2_A290ServicioCategEstado = new String[] {""} ;
      P003Q2_A288ServicioCategDescripcion = new String[] {""} ;
      P003Q2_n288ServicioCategDescripcion = new boolean[] {false} ;
      P003Q2_A287ServicioCategNombre = new String[] {""} ;
      P003Q2_A165LaboratorioNombre = new String[] {""} ;
      AV27Option = "" ;
      P003Q3_A287ServicioCategNombre = new String[] {""} ;
      P003Q3_A40LaboratorioId = new short[1] ;
      P003Q3_A52ServicioCategId = new short[1] ;
      P003Q3_A290ServicioCategEstado = new String[] {""} ;
      P003Q3_A288ServicioCategDescripcion = new String[] {""} ;
      P003Q3_n288ServicioCategDescripcion = new boolean[] {false} ;
      P003Q3_A165LaboratorioNombre = new String[] {""} ;
      P003Q4_A288ServicioCategDescripcion = new String[] {""} ;
      P003Q4_n288ServicioCategDescripcion = new boolean[] {false} ;
      P003Q4_A40LaboratorioId = new short[1] ;
      P003Q4_A52ServicioCategId = new short[1] ;
      P003Q4_A290ServicioCategEstado = new String[] {""} ;
      P003Q4_A287ServicioCategNombre = new String[] {""} ;
      P003Q4_A165LaboratorioNombre = new String[] {""} ;
      pr_default = new DataStoreProvider(context, remoteHandle, new com.projectthani.serviciocategwwgetfilterdata__default(),
         new Object[] {
             new Object[] {
            P003Q2_A40LaboratorioId, P003Q2_A52ServicioCategId, P003Q2_A290ServicioCategEstado, P003Q2_A288ServicioCategDescripcion, P003Q2_n288ServicioCategDescripcion, P003Q2_A287ServicioCategNombre, P003Q2_A165LaboratorioNombre
            }
            , new Object[] {
            P003Q3_A287ServicioCategNombre, P003Q3_A40LaboratorioId, P003Q3_A52ServicioCategId, P003Q3_A290ServicioCategEstado, P003Q3_A288ServicioCategDescripcion, P003Q3_n288ServicioCategDescripcion, P003Q3_A165LaboratorioNombre
            }
            , new Object[] {
            P003Q4_A288ServicioCategDescripcion, P003Q4_n288ServicioCategDescripcion, P003Q4_A40LaboratorioId, P003Q4_A52ServicioCategId, P003Q4_A290ServicioCategEstado, P003Q4_A287ServicioCategNombre, P003Q4_A165LaboratorioNombre
            }
         }
      );
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private short AV11TFServicioCategId ;
   private short AV12TFServicioCategId_To ;
   private short AV13TFLaboratorioId ;
   private short AV14TFLaboratorioId_To ;
   private short AV47Serviciocategwwds_2_tfserviciocategid ;
   private short AV48Serviciocategwwds_3_tfserviciocategid_to ;
   private short AV49Serviciocategwwds_4_tflaboratorioid ;
   private short AV50Serviciocategwwds_5_tflaboratorioid_to ;
   private short A52ServicioCategId ;
   private short A40LaboratorioId ;
   private short Gx_err ;
   private int AV44GXV1 ;
   private int AV57Serviciocategwwds_12_tfserviciocategestado_sels_size ;
   private int AV26InsertIndex ;
   private long AV35count ;
   private String scmdbuf ;
   private String A290ServicioCategEstado ;
   private boolean AV8IsAuthorized ;
   private boolean GXt_boolean1 ;
   private boolean GXv_boolean2[] ;
   private boolean returnInSub ;
   private boolean brk3Q2 ;
   private boolean n288ServicioCategDescripcion ;
   private boolean brk3Q4 ;
   private boolean brk3Q6 ;
   private String AV29OptionsJson ;
   private String AV32OptionsDescJson ;
   private String AV34OptionIndexesJson ;
   private String AV21TFServicioCategEstado_SelsJson ;
   private String AV25DDOName ;
   private String AV23SearchTxt ;
   private String AV24SearchTxtTo ;
   private String AV41FilterFullText ;
   private String AV15TFLaboratorioNombre ;
   private String AV16TFLaboratorioNombre_Sel ;
   private String AV17TFServicioCategNombre ;
   private String AV18TFServicioCategNombre_Sel ;
   private String AV19TFServicioCategDescripcion ;
   private String AV20TFServicioCategDescripcion_Sel ;
   private String A165LaboratorioNombre ;
   private String AV46Serviciocategwwds_1_filterfulltext ;
   private String AV51Serviciocategwwds_6_tflaboratorionombre ;
   private String AV52Serviciocategwwds_7_tflaboratorionombre_sel ;
   private String AV53Serviciocategwwds_8_tfserviciocategnombre ;
   private String AV54Serviciocategwwds_9_tfserviciocategnombre_sel ;
   private String AV55Serviciocategwwds_10_tfserviciocategdescripcion ;
   private String AV56Serviciocategwwds_11_tfserviciocategdescripcion_sel ;
   private String lV46Serviciocategwwds_1_filterfulltext ;
   private String lV51Serviciocategwwds_6_tflaboratorionombre ;
   private String lV53Serviciocategwwds_8_tfserviciocategnombre ;
   private String lV55Serviciocategwwds_10_tfserviciocategdescripcion ;
   private String A287ServicioCategNombre ;
   private String A288ServicioCategDescripcion ;
   private String AV27Option ;
   private com.genexus.webpanels.WebSession AV36Session ;
   private String[] aP5 ;
   private String[] aP3 ;
   private String[] aP4 ;
   private IDataStoreProvider pr_default ;
   private short[] P003Q2_A40LaboratorioId ;
   private short[] P003Q2_A52ServicioCategId ;
   private String[] P003Q2_A290ServicioCategEstado ;
   private String[] P003Q2_A288ServicioCategDescripcion ;
   private boolean[] P003Q2_n288ServicioCategDescripcion ;
   private String[] P003Q2_A287ServicioCategNombre ;
   private String[] P003Q2_A165LaboratorioNombre ;
   private String[] P003Q3_A287ServicioCategNombre ;
   private short[] P003Q3_A40LaboratorioId ;
   private short[] P003Q3_A52ServicioCategId ;
   private String[] P003Q3_A290ServicioCategEstado ;
   private String[] P003Q3_A288ServicioCategDescripcion ;
   private boolean[] P003Q3_n288ServicioCategDescripcion ;
   private String[] P003Q3_A165LaboratorioNombre ;
   private String[] P003Q4_A288ServicioCategDescripcion ;
   private boolean[] P003Q4_n288ServicioCategDescripcion ;
   private short[] P003Q4_A40LaboratorioId ;
   private short[] P003Q4_A52ServicioCategId ;
   private String[] P003Q4_A290ServicioCategEstado ;
   private String[] P003Q4_A287ServicioCategNombre ;
   private String[] P003Q4_A165LaboratorioNombre ;
   private GXSimpleCollection<String> AV22TFServicioCategEstado_Sels ;
   private GXSimpleCollection<String> AV57Serviciocategwwds_12_tfserviciocategestado_sels ;
   private GXSimpleCollection<String> AV28Options ;
   private GXSimpleCollection<String> AV31OptionsDesc ;
   private GXSimpleCollection<String> AV33OptionIndexes ;
   private com.projectthani.wwpbaseobjects.SdtWWPContext AV9WWPContext ;
   private com.projectthani.wwpbaseobjects.SdtWWPContext GXv_SdtWWPContext3[] ;
   private com.projectthani.wwpbaseobjects.SdtWWPGridState AV38GridState ;
   private com.projectthani.wwpbaseobjects.SdtWWPGridState_FilterValue AV39GridStateFilterValue ;
}

final  class serviciocategwwgetfilterdata__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   protected Object[] conditional_P003Q2( ModelContext context ,
                                          int remoteHandle ,
                                          com.genexus.IHttpContext httpContext ,
                                          String A290ServicioCategEstado ,
                                          GXSimpleCollection<String> AV57Serviciocategwwds_12_tfserviciocategestado_sels ,
                                          String AV46Serviciocategwwds_1_filterfulltext ,
                                          short AV47Serviciocategwwds_2_tfserviciocategid ,
                                          short AV48Serviciocategwwds_3_tfserviciocategid_to ,
                                          short AV49Serviciocategwwds_4_tflaboratorioid ,
                                          short AV50Serviciocategwwds_5_tflaboratorioid_to ,
                                          String AV52Serviciocategwwds_7_tflaboratorionombre_sel ,
                                          String AV51Serviciocategwwds_6_tflaboratorionombre ,
                                          String AV54Serviciocategwwds_9_tfserviciocategnombre_sel ,
                                          String AV53Serviciocategwwds_8_tfserviciocategnombre ,
                                          String AV56Serviciocategwwds_11_tfserviciocategdescripcion_sel ,
                                          String AV55Serviciocategwwds_10_tfserviciocategdescripcion ,
                                          int AV57Serviciocategwwds_12_tfserviciocategestado_sels_size ,
                                          short A52ServicioCategId ,
                                          short A40LaboratorioId ,
                                          String A165LaboratorioNombre ,
                                          String A287ServicioCategNombre ,
                                          String A288ServicioCategDescripcion )
   {
      java.lang.StringBuffer sWhereString = new java.lang.StringBuffer();
      String scmdbuf;
      byte[] GXv_int4 = new byte[17];
      Object[] GXv_Object5 = new Object[2];
      scmdbuf = "SELECT T1.[LaboratorioId], T1.[ServicioCategId], T1.[ServicioCategEstado], T1.[ServicioCategDescripcion], T1.[ServicioCategNombre], T2.[LaboratorioNombre] FROM ([ServicioCateg]" ;
      scmdbuf += " T1 INNER JOIN [Laboratorio] T2 ON T2.[LaboratorioId] = T1.[LaboratorioId])" ;
      if ( ! (GXutil.strcmp("", AV46Serviciocategwwds_1_filterfulltext)==0) )
      {
         addWhere(sWhereString, "(( CONVERT( char(4), CAST(T1.[ServicioCategId] AS decimal(4,0))) like '%' + ?) or ( CONVERT( char(4), CAST(T1.[LaboratorioId] AS decimal(4,0))) like '%' + ?) or ( T2.[LaboratorioNombre] like '%' + ?) or ( T1.[ServicioCategNombre] like '%' + ?) or ( T1.[ServicioCategDescripcion] like '%' + ?) or ( 'activo' like '%' + LOWER(?) and T1.[ServicioCategEstado] = 'A') or ( 'inactivo' like '%' + LOWER(?) and T1.[ServicioCategEstado] = 'I'))");
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
      }
      if ( ! (0==AV47Serviciocategwwds_2_tfserviciocategid) )
      {
         addWhere(sWhereString, "(T1.[ServicioCategId] >= ?)");
      }
      else
      {
         GXv_int4[7] = (byte)(1) ;
      }
      if ( ! (0==AV48Serviciocategwwds_3_tfserviciocategid_to) )
      {
         addWhere(sWhereString, "(T1.[ServicioCategId] <= ?)");
      }
      else
      {
         GXv_int4[8] = (byte)(1) ;
      }
      if ( ! (0==AV49Serviciocategwwds_4_tflaboratorioid) )
      {
         addWhere(sWhereString, "(T1.[LaboratorioId] >= ?)");
      }
      else
      {
         GXv_int4[9] = (byte)(1) ;
      }
      if ( ! (0==AV50Serviciocategwwds_5_tflaboratorioid_to) )
      {
         addWhere(sWhereString, "(T1.[LaboratorioId] <= ?)");
      }
      else
      {
         GXv_int4[10] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV52Serviciocategwwds_7_tflaboratorionombre_sel)==0) && ( ! (GXutil.strcmp("", AV51Serviciocategwwds_6_tflaboratorionombre)==0) ) )
      {
         addWhere(sWhereString, "(T2.[LaboratorioNombre] like ?)");
      }
      else
      {
         GXv_int4[11] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV52Serviciocategwwds_7_tflaboratorionombre_sel)==0) )
      {
         addWhere(sWhereString, "(T2.[LaboratorioNombre] = ?)");
      }
      else
      {
         GXv_int4[12] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV54Serviciocategwwds_9_tfserviciocategnombre_sel)==0) && ( ! (GXutil.strcmp("", AV53Serviciocategwwds_8_tfserviciocategnombre)==0) ) )
      {
         addWhere(sWhereString, "(T1.[ServicioCategNombre] like ?)");
      }
      else
      {
         GXv_int4[13] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV54Serviciocategwwds_9_tfserviciocategnombre_sel)==0) )
      {
         addWhere(sWhereString, "(T1.[ServicioCategNombre] = ?)");
      }
      else
      {
         GXv_int4[14] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV56Serviciocategwwds_11_tfserviciocategdescripcion_sel)==0) && ( ! (GXutil.strcmp("", AV55Serviciocategwwds_10_tfserviciocategdescripcion)==0) ) )
      {
         addWhere(sWhereString, "(T1.[ServicioCategDescripcion] like ?)");
      }
      else
      {
         GXv_int4[15] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV56Serviciocategwwds_11_tfserviciocategdescripcion_sel)==0) )
      {
         addWhere(sWhereString, "(T1.[ServicioCategDescripcion] = ?)");
      }
      else
      {
         GXv_int4[16] = (byte)(1) ;
      }
      if ( AV57Serviciocategwwds_12_tfserviciocategestado_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("sqlserver", AV57Serviciocategwwds_12_tfserviciocategestado_sels, "T1.[ServicioCategEstado] IN (", ")")+")");
      }
      scmdbuf += sWhereString ;
      scmdbuf += " ORDER BY T1.[LaboratorioId]" ;
      GXv_Object5[0] = scmdbuf ;
      GXv_Object5[1] = GXv_int4 ;
      return GXv_Object5 ;
   }

   protected Object[] conditional_P003Q3( ModelContext context ,
                                          int remoteHandle ,
                                          com.genexus.IHttpContext httpContext ,
                                          String A290ServicioCategEstado ,
                                          GXSimpleCollection<String> AV57Serviciocategwwds_12_tfserviciocategestado_sels ,
                                          String AV46Serviciocategwwds_1_filterfulltext ,
                                          short AV47Serviciocategwwds_2_tfserviciocategid ,
                                          short AV48Serviciocategwwds_3_tfserviciocategid_to ,
                                          short AV49Serviciocategwwds_4_tflaboratorioid ,
                                          short AV50Serviciocategwwds_5_tflaboratorioid_to ,
                                          String AV52Serviciocategwwds_7_tflaboratorionombre_sel ,
                                          String AV51Serviciocategwwds_6_tflaboratorionombre ,
                                          String AV54Serviciocategwwds_9_tfserviciocategnombre_sel ,
                                          String AV53Serviciocategwwds_8_tfserviciocategnombre ,
                                          String AV56Serviciocategwwds_11_tfserviciocategdescripcion_sel ,
                                          String AV55Serviciocategwwds_10_tfserviciocategdescripcion ,
                                          int AV57Serviciocategwwds_12_tfserviciocategestado_sels_size ,
                                          short A52ServicioCategId ,
                                          short A40LaboratorioId ,
                                          String A165LaboratorioNombre ,
                                          String A287ServicioCategNombre ,
                                          String A288ServicioCategDescripcion )
   {
      java.lang.StringBuffer sWhereString = new java.lang.StringBuffer();
      String scmdbuf;
      byte[] GXv_int7 = new byte[17];
      Object[] GXv_Object8 = new Object[2];
      scmdbuf = "SELECT T1.[ServicioCategNombre], T1.[LaboratorioId], T1.[ServicioCategId], T1.[ServicioCategEstado], T1.[ServicioCategDescripcion], T2.[LaboratorioNombre] FROM ([ServicioCateg]" ;
      scmdbuf += " T1 INNER JOIN [Laboratorio] T2 ON T2.[LaboratorioId] = T1.[LaboratorioId])" ;
      if ( ! (GXutil.strcmp("", AV46Serviciocategwwds_1_filterfulltext)==0) )
      {
         addWhere(sWhereString, "(( CONVERT( char(4), CAST(T1.[ServicioCategId] AS decimal(4,0))) like '%' + ?) or ( CONVERT( char(4), CAST(T1.[LaboratorioId] AS decimal(4,0))) like '%' + ?) or ( T2.[LaboratorioNombre] like '%' + ?) or ( T1.[ServicioCategNombre] like '%' + ?) or ( T1.[ServicioCategDescripcion] like '%' + ?) or ( 'activo' like '%' + LOWER(?) and T1.[ServicioCategEstado] = 'A') or ( 'inactivo' like '%' + LOWER(?) and T1.[ServicioCategEstado] = 'I'))");
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
      }
      if ( ! (0==AV47Serviciocategwwds_2_tfserviciocategid) )
      {
         addWhere(sWhereString, "(T1.[ServicioCategId] >= ?)");
      }
      else
      {
         GXv_int7[7] = (byte)(1) ;
      }
      if ( ! (0==AV48Serviciocategwwds_3_tfserviciocategid_to) )
      {
         addWhere(sWhereString, "(T1.[ServicioCategId] <= ?)");
      }
      else
      {
         GXv_int7[8] = (byte)(1) ;
      }
      if ( ! (0==AV49Serviciocategwwds_4_tflaboratorioid) )
      {
         addWhere(sWhereString, "(T1.[LaboratorioId] >= ?)");
      }
      else
      {
         GXv_int7[9] = (byte)(1) ;
      }
      if ( ! (0==AV50Serviciocategwwds_5_tflaboratorioid_to) )
      {
         addWhere(sWhereString, "(T1.[LaboratorioId] <= ?)");
      }
      else
      {
         GXv_int7[10] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV52Serviciocategwwds_7_tflaboratorionombre_sel)==0) && ( ! (GXutil.strcmp("", AV51Serviciocategwwds_6_tflaboratorionombre)==0) ) )
      {
         addWhere(sWhereString, "(T2.[LaboratorioNombre] like ?)");
      }
      else
      {
         GXv_int7[11] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV52Serviciocategwwds_7_tflaboratorionombre_sel)==0) )
      {
         addWhere(sWhereString, "(T2.[LaboratorioNombre] = ?)");
      }
      else
      {
         GXv_int7[12] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV54Serviciocategwwds_9_tfserviciocategnombre_sel)==0) && ( ! (GXutil.strcmp("", AV53Serviciocategwwds_8_tfserviciocategnombre)==0) ) )
      {
         addWhere(sWhereString, "(T1.[ServicioCategNombre] like ?)");
      }
      else
      {
         GXv_int7[13] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV54Serviciocategwwds_9_tfserviciocategnombre_sel)==0) )
      {
         addWhere(sWhereString, "(T1.[ServicioCategNombre] = ?)");
      }
      else
      {
         GXv_int7[14] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV56Serviciocategwwds_11_tfserviciocategdescripcion_sel)==0) && ( ! (GXutil.strcmp("", AV55Serviciocategwwds_10_tfserviciocategdescripcion)==0) ) )
      {
         addWhere(sWhereString, "(T1.[ServicioCategDescripcion] like ?)");
      }
      else
      {
         GXv_int7[15] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV56Serviciocategwwds_11_tfserviciocategdescripcion_sel)==0) )
      {
         addWhere(sWhereString, "(T1.[ServicioCategDescripcion] = ?)");
      }
      else
      {
         GXv_int7[16] = (byte)(1) ;
      }
      if ( AV57Serviciocategwwds_12_tfserviciocategestado_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("sqlserver", AV57Serviciocategwwds_12_tfserviciocategestado_sels, "T1.[ServicioCategEstado] IN (", ")")+")");
      }
      scmdbuf += sWhereString ;
      scmdbuf += " ORDER BY T1.[ServicioCategNombre]" ;
      GXv_Object8[0] = scmdbuf ;
      GXv_Object8[1] = GXv_int7 ;
      return GXv_Object8 ;
   }

   protected Object[] conditional_P003Q4( ModelContext context ,
                                          int remoteHandle ,
                                          com.genexus.IHttpContext httpContext ,
                                          String A290ServicioCategEstado ,
                                          GXSimpleCollection<String> AV57Serviciocategwwds_12_tfserviciocategestado_sels ,
                                          String AV46Serviciocategwwds_1_filterfulltext ,
                                          short AV47Serviciocategwwds_2_tfserviciocategid ,
                                          short AV48Serviciocategwwds_3_tfserviciocategid_to ,
                                          short AV49Serviciocategwwds_4_tflaboratorioid ,
                                          short AV50Serviciocategwwds_5_tflaboratorioid_to ,
                                          String AV52Serviciocategwwds_7_tflaboratorionombre_sel ,
                                          String AV51Serviciocategwwds_6_tflaboratorionombre ,
                                          String AV54Serviciocategwwds_9_tfserviciocategnombre_sel ,
                                          String AV53Serviciocategwwds_8_tfserviciocategnombre ,
                                          String AV56Serviciocategwwds_11_tfserviciocategdescripcion_sel ,
                                          String AV55Serviciocategwwds_10_tfserviciocategdescripcion ,
                                          int AV57Serviciocategwwds_12_tfserviciocategestado_sels_size ,
                                          short A52ServicioCategId ,
                                          short A40LaboratorioId ,
                                          String A165LaboratorioNombre ,
                                          String A287ServicioCategNombre ,
                                          String A288ServicioCategDescripcion )
   {
      java.lang.StringBuffer sWhereString = new java.lang.StringBuffer();
      String scmdbuf;
      byte[] GXv_int10 = new byte[17];
      Object[] GXv_Object11 = new Object[2];
      scmdbuf = "SELECT T1.[ServicioCategDescripcion], T1.[LaboratorioId], T1.[ServicioCategId], T1.[ServicioCategEstado], T1.[ServicioCategNombre], T2.[LaboratorioNombre] FROM ([ServicioCateg]" ;
      scmdbuf += " T1 INNER JOIN [Laboratorio] T2 ON T2.[LaboratorioId] = T1.[LaboratorioId])" ;
      if ( ! (GXutil.strcmp("", AV46Serviciocategwwds_1_filterfulltext)==0) )
      {
         addWhere(sWhereString, "(( CONVERT( char(4), CAST(T1.[ServicioCategId] AS decimal(4,0))) like '%' + ?) or ( CONVERT( char(4), CAST(T1.[LaboratorioId] AS decimal(4,0))) like '%' + ?) or ( T2.[LaboratorioNombre] like '%' + ?) or ( T1.[ServicioCategNombre] like '%' + ?) or ( T1.[ServicioCategDescripcion] like '%' + ?) or ( 'activo' like '%' + LOWER(?) and T1.[ServicioCategEstado] = 'A') or ( 'inactivo' like '%' + LOWER(?) and T1.[ServicioCategEstado] = 'I'))");
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
      }
      if ( ! (0==AV47Serviciocategwwds_2_tfserviciocategid) )
      {
         addWhere(sWhereString, "(T1.[ServicioCategId] >= ?)");
      }
      else
      {
         GXv_int10[7] = (byte)(1) ;
      }
      if ( ! (0==AV48Serviciocategwwds_3_tfserviciocategid_to) )
      {
         addWhere(sWhereString, "(T1.[ServicioCategId] <= ?)");
      }
      else
      {
         GXv_int10[8] = (byte)(1) ;
      }
      if ( ! (0==AV49Serviciocategwwds_4_tflaboratorioid) )
      {
         addWhere(sWhereString, "(T1.[LaboratorioId] >= ?)");
      }
      else
      {
         GXv_int10[9] = (byte)(1) ;
      }
      if ( ! (0==AV50Serviciocategwwds_5_tflaboratorioid_to) )
      {
         addWhere(sWhereString, "(T1.[LaboratorioId] <= ?)");
      }
      else
      {
         GXv_int10[10] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV52Serviciocategwwds_7_tflaboratorionombre_sel)==0) && ( ! (GXutil.strcmp("", AV51Serviciocategwwds_6_tflaboratorionombre)==0) ) )
      {
         addWhere(sWhereString, "(T2.[LaboratorioNombre] like ?)");
      }
      else
      {
         GXv_int10[11] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV52Serviciocategwwds_7_tflaboratorionombre_sel)==0) )
      {
         addWhere(sWhereString, "(T2.[LaboratorioNombre] = ?)");
      }
      else
      {
         GXv_int10[12] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV54Serviciocategwwds_9_tfserviciocategnombre_sel)==0) && ( ! (GXutil.strcmp("", AV53Serviciocategwwds_8_tfserviciocategnombre)==0) ) )
      {
         addWhere(sWhereString, "(T1.[ServicioCategNombre] like ?)");
      }
      else
      {
         GXv_int10[13] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV54Serviciocategwwds_9_tfserviciocategnombre_sel)==0) )
      {
         addWhere(sWhereString, "(T1.[ServicioCategNombre] = ?)");
      }
      else
      {
         GXv_int10[14] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV56Serviciocategwwds_11_tfserviciocategdescripcion_sel)==0) && ( ! (GXutil.strcmp("", AV55Serviciocategwwds_10_tfserviciocategdescripcion)==0) ) )
      {
         addWhere(sWhereString, "(T1.[ServicioCategDescripcion] like ?)");
      }
      else
      {
         GXv_int10[15] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV56Serviciocategwwds_11_tfserviciocategdescripcion_sel)==0) )
      {
         addWhere(sWhereString, "(T1.[ServicioCategDescripcion] = ?)");
      }
      else
      {
         GXv_int10[16] = (byte)(1) ;
      }
      if ( AV57Serviciocategwwds_12_tfserviciocategestado_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("sqlserver", AV57Serviciocategwwds_12_tfserviciocategestado_sels, "T1.[ServicioCategEstado] IN (", ")")+")");
      }
      scmdbuf += sWhereString ;
      scmdbuf += " ORDER BY T1.[ServicioCategDescripcion]" ;
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
                  return conditional_P003Q2(context, remoteHandle, httpContext, (String)dynConstraints[0] , (GXSimpleCollection<String>)dynConstraints[1] , (String)dynConstraints[2] , ((Number) dynConstraints[3]).shortValue() , ((Number) dynConstraints[4]).shortValue() , ((Number) dynConstraints[5]).shortValue() , ((Number) dynConstraints[6]).shortValue() , (String)dynConstraints[7] , (String)dynConstraints[8] , (String)dynConstraints[9] , (String)dynConstraints[10] , (String)dynConstraints[11] , (String)dynConstraints[12] , ((Number) dynConstraints[13]).intValue() , ((Number) dynConstraints[14]).shortValue() , ((Number) dynConstraints[15]).shortValue() , (String)dynConstraints[16] , (String)dynConstraints[17] , (String)dynConstraints[18] );
            case 1 :
                  return conditional_P003Q3(context, remoteHandle, httpContext, (String)dynConstraints[0] , (GXSimpleCollection<String>)dynConstraints[1] , (String)dynConstraints[2] , ((Number) dynConstraints[3]).shortValue() , ((Number) dynConstraints[4]).shortValue() , ((Number) dynConstraints[5]).shortValue() , ((Number) dynConstraints[6]).shortValue() , (String)dynConstraints[7] , (String)dynConstraints[8] , (String)dynConstraints[9] , (String)dynConstraints[10] , (String)dynConstraints[11] , (String)dynConstraints[12] , ((Number) dynConstraints[13]).intValue() , ((Number) dynConstraints[14]).shortValue() , ((Number) dynConstraints[15]).shortValue() , (String)dynConstraints[16] , (String)dynConstraints[17] , (String)dynConstraints[18] );
            case 2 :
                  return conditional_P003Q4(context, remoteHandle, httpContext, (String)dynConstraints[0] , (GXSimpleCollection<String>)dynConstraints[1] , (String)dynConstraints[2] , ((Number) dynConstraints[3]).shortValue() , ((Number) dynConstraints[4]).shortValue() , ((Number) dynConstraints[5]).shortValue() , ((Number) dynConstraints[6]).shortValue() , (String)dynConstraints[7] , (String)dynConstraints[8] , (String)dynConstraints[9] , (String)dynConstraints[10] , (String)dynConstraints[11] , (String)dynConstraints[12] , ((Number) dynConstraints[13]).intValue() , ((Number) dynConstraints[14]).shortValue() , ((Number) dynConstraints[15]).shortValue() , (String)dynConstraints[16] , (String)dynConstraints[17] , (String)dynConstraints[18] );
      }
      return super.getDynamicStatement(cursor, context, remoteHandle, httpContext, dynConstraints);
   }

   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P003Q2", "scmdbuf",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("P003Q3", "scmdbuf",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("P003Q4", "scmdbuf",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
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
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((String[]) buf[2])[0] = rslt.getString(3, 1);
               ((String[]) buf[3])[0] = rslt.getVarchar(4);
               ((boolean[]) buf[4])[0] = rslt.wasNull();
               ((String[]) buf[5])[0] = rslt.getVarchar(5);
               ((String[]) buf[6])[0] = rslt.getVarchar(6);
               return;
            case 1 :
               ((String[]) buf[0])[0] = rslt.getVarchar(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((short[]) buf[2])[0] = rslt.getShort(3);
               ((String[]) buf[3])[0] = rslt.getString(4, 1);
               ((String[]) buf[4])[0] = rslt.getVarchar(5);
               ((boolean[]) buf[5])[0] = rslt.wasNull();
               ((String[]) buf[6])[0] = rslt.getVarchar(6);
               return;
            case 2 :
               ((String[]) buf[0])[0] = rslt.getVarchar(1);
               ((boolean[]) buf[1])[0] = rslt.wasNull();
               ((short[]) buf[2])[0] = rslt.getShort(2);
               ((short[]) buf[3])[0] = rslt.getShort(3);
               ((String[]) buf[4])[0] = rslt.getString(4, 1);
               ((String[]) buf[5])[0] = rslt.getVarchar(5);
               ((String[]) buf[6])[0] = rslt.getVarchar(6);
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
                  stmt.setVarchar(sIdx, (String)parms[17], 100);
               }
               if ( ((Number) parms[1]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[18], 100);
               }
               if ( ((Number) parms[2]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[19], 100);
               }
               if ( ((Number) parms[3]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[20], 100);
               }
               if ( ((Number) parms[4]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[21], 100);
               }
               if ( ((Number) parms[5]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[22], 100);
               }
               if ( ((Number) parms[6]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[23], 100);
               }
               if ( ((Number) parms[7]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[24]).shortValue());
               }
               if ( ((Number) parms[8]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[25]).shortValue());
               }
               if ( ((Number) parms[9]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[26]).shortValue());
               }
               if ( ((Number) parms[10]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[27]).shortValue());
               }
               if ( ((Number) parms[11]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[28], 100);
               }
               if ( ((Number) parms[12]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[29], 100);
               }
               if ( ((Number) parms[13]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[30], 100);
               }
               if ( ((Number) parms[14]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[31], 100);
               }
               if ( ((Number) parms[15]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[32], 500);
               }
               if ( ((Number) parms[16]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[33], 500);
               }
               return;
            case 1 :
               sIdx = (short)(0) ;
               if ( ((Number) parms[0]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[17], 100);
               }
               if ( ((Number) parms[1]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[18], 100);
               }
               if ( ((Number) parms[2]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[19], 100);
               }
               if ( ((Number) parms[3]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[20], 100);
               }
               if ( ((Number) parms[4]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[21], 100);
               }
               if ( ((Number) parms[5]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[22], 100);
               }
               if ( ((Number) parms[6]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[23], 100);
               }
               if ( ((Number) parms[7]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[24]).shortValue());
               }
               if ( ((Number) parms[8]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[25]).shortValue());
               }
               if ( ((Number) parms[9]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[26]).shortValue());
               }
               if ( ((Number) parms[10]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[27]).shortValue());
               }
               if ( ((Number) parms[11]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[28], 100);
               }
               if ( ((Number) parms[12]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[29], 100);
               }
               if ( ((Number) parms[13]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[30], 100);
               }
               if ( ((Number) parms[14]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[31], 100);
               }
               if ( ((Number) parms[15]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[32], 500);
               }
               if ( ((Number) parms[16]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[33], 500);
               }
               return;
            case 2 :
               sIdx = (short)(0) ;
               if ( ((Number) parms[0]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[17], 100);
               }
               if ( ((Number) parms[1]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[18], 100);
               }
               if ( ((Number) parms[2]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[19], 100);
               }
               if ( ((Number) parms[3]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[20], 100);
               }
               if ( ((Number) parms[4]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[21], 100);
               }
               if ( ((Number) parms[5]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[22], 100);
               }
               if ( ((Number) parms[6]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[23], 100);
               }
               if ( ((Number) parms[7]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[24]).shortValue());
               }
               if ( ((Number) parms[8]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[25]).shortValue());
               }
               if ( ((Number) parms[9]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[26]).shortValue());
               }
               if ( ((Number) parms[10]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[27]).shortValue());
               }
               if ( ((Number) parms[11]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[28], 100);
               }
               if ( ((Number) parms[12]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[29], 100);
               }
               if ( ((Number) parms[13]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[30], 100);
               }
               if ( ((Number) parms[14]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[31], 100);
               }
               if ( ((Number) parms[15]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[32], 500);
               }
               if ( ((Number) parms[16]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[33], 500);
               }
               return;
      }
   }

}

