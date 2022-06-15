package com.projectthani ;
import com.projectthani.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class diagnosticowwgetfilterdata extends GXProcedure
{
   public diagnosticowwgetfilterdata( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( diagnosticowwgetfilterdata.class ), "" );
   }

   public diagnosticowwgetfilterdata( int remoteHandle ,
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
      diagnosticowwgetfilterdata.this.aP5 = new String[] {""};
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
      diagnosticowwgetfilterdata.this.AV25DDOName = aP0;
      diagnosticowwgetfilterdata.this.AV23SearchTxt = aP1;
      diagnosticowwgetfilterdata.this.AV24SearchTxtTo = aP2;
      diagnosticowwgetfilterdata.this.aP3 = aP3;
      diagnosticowwgetfilterdata.this.aP4 = aP4;
      diagnosticowwgetfilterdata.this.aP5 = aP5;
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
      new com.projectthani.wwpbaseobjects.secisauthbyfunctionalitykey(remoteHandle, context).execute( "WWDiagnostico", GXv_boolean2) ;
      diagnosticowwgetfilterdata.this.GXt_boolean1 = GXv_boolean2[0] ;
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
         if ( GXutil.strcmp(GXutil.upper( AV25DDOName), "DDO_DIAGNOSTICOCODIGO") == 0 )
         {
            /* Execute user subroutine: 'LOADDIAGNOSTICOCODIGOOPTIONS' */
            S121 ();
            if ( returnInSub )
            {
               returnInSub = true;
               cleanup();
               if (true) return;
            }
         }
         else if ( GXutil.strcmp(GXutil.upper( AV25DDOName), "DDO_DIAGNOSTICODESCRIPCION") == 0 )
         {
            /* Execute user subroutine: 'LOADDIAGNOSTICODESCRIPCIONOPTIONS' */
            S131 ();
            if ( returnInSub )
            {
               returnInSub = true;
               cleanup();
               if (true) return;
            }
         }
         else if ( GXutil.strcmp(GXutil.upper( AV25DDOName), "DDO_DIAGNOSTICOLONGDESC") == 0 )
         {
            /* Execute user subroutine: 'LOADDIAGNOSTICOLONGDESCOPTIONS' */
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
      if ( GXutil.strcmp(AV36Session.getValue("DiagnosticoWWGridState"), "") == 0 )
      {
         AV38GridState.fromxml(new com.projectthani.wwpbaseobjects.loadgridstate(remoteHandle, context).executeUdp( "DiagnosticoWWGridState"), null, null);
      }
      else
      {
         AV38GridState.fromxml(AV36Session.getValue("DiagnosticoWWGridState"), null, null);
      }
      AV44GXV1 = 1 ;
      while ( AV44GXV1 <= AV38GridState.getgxTv_SdtWWPGridState_Filtervalues().size() )
      {
         AV39GridStateFilterValue = (com.projectthani.wwpbaseobjects.SdtWWPGridState_FilterValue)((com.projectthani.wwpbaseobjects.SdtWWPGridState_FilterValue)AV38GridState.getgxTv_SdtWWPGridState_Filtervalues().elementAt(-1+AV44GXV1));
         if ( GXutil.strcmp(AV39GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "FILTERFULLTEXT") == 0 )
         {
            AV41FilterFullText = AV39GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV39GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFDIAGNOSTICOID") == 0 )
         {
            AV11TFDiagnosticoId = (int)(GXutil.lval( AV39GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value())) ;
            AV12TFDiagnosticoId_To = (int)(GXutil.lval( AV39GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Valueto())) ;
         }
         else if ( GXutil.strcmp(AV39GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFDIAGNOSTICOCODIGO") == 0 )
         {
            AV13TFDiagnosticoCodigo = AV39GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV39GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFDIAGNOSTICOCODIGO_SEL") == 0 )
         {
            AV14TFDiagnosticoCodigo_Sel = AV39GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV39GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFDIAGNOSTICODESCRIPCION") == 0 )
         {
            AV15TFDiagnosticoDescripcion = AV39GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV39GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFDIAGNOSTICODESCRIPCION_SEL") == 0 )
         {
            AV16TFDiagnosticoDescripcion_Sel = AV39GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV39GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFDIAGNOSTICOTIPOSEXO_SEL") == 0 )
         {
            AV17TFDiagnosticoTipoSexo_SelsJson = AV39GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            AV18TFDiagnosticoTipoSexo_Sels.fromJSonString(AV17TFDiagnosticoTipoSexo_SelsJson, null);
         }
         else if ( GXutil.strcmp(AV39GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFDIAGNOSTICOESTADO_SEL") == 0 )
         {
            AV19TFDiagnosticoEstado_SelsJson = AV39GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            AV20TFDiagnosticoEstado_Sels.fromJSonString(AV19TFDiagnosticoEstado_SelsJson, null);
         }
         else if ( GXutil.strcmp(AV39GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFDIAGNOSTICOLONGDESC") == 0 )
         {
            AV21TFDiagnosticoLongDesc = AV39GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV39GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFDIAGNOSTICOLONGDESC_SEL") == 0 )
         {
            AV22TFDiagnosticoLongDesc_Sel = AV39GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         AV44GXV1 = (int)(AV44GXV1+1) ;
      }
   }

   public void S121( )
   {
      /* 'LOADDIAGNOSTICOCODIGOOPTIONS' Routine */
      returnInSub = false ;
      AV13TFDiagnosticoCodigo = AV23SearchTxt ;
      AV14TFDiagnosticoCodigo_Sel = "" ;
      AV46Diagnosticowwds_1_filterfulltext = AV41FilterFullText ;
      AV47Diagnosticowwds_2_tfdiagnosticoid = AV11TFDiagnosticoId ;
      AV48Diagnosticowwds_3_tfdiagnosticoid_to = AV12TFDiagnosticoId_To ;
      AV49Diagnosticowwds_4_tfdiagnosticocodigo = AV13TFDiagnosticoCodigo ;
      AV50Diagnosticowwds_5_tfdiagnosticocodigo_sel = AV14TFDiagnosticoCodigo_Sel ;
      AV51Diagnosticowwds_6_tfdiagnosticodescripcion = AV15TFDiagnosticoDescripcion ;
      AV52Diagnosticowwds_7_tfdiagnosticodescripcion_sel = AV16TFDiagnosticoDescripcion_Sel ;
      AV53Diagnosticowwds_8_tfdiagnosticotiposexo_sels = AV18TFDiagnosticoTipoSexo_Sels ;
      AV54Diagnosticowwds_9_tfdiagnosticoestado_sels = AV20TFDiagnosticoEstado_Sels ;
      AV55Diagnosticowwds_10_tfdiagnosticolongdesc = AV21TFDiagnosticoLongDesc ;
      AV56Diagnosticowwds_11_tfdiagnosticolongdesc_sel = AV22TFDiagnosticoLongDesc_Sel ;
      pr_default.dynParam(0, new Object[]{ new Object[]{
                                           A130DiagnosticoTipoSexo ,
                                           AV53Diagnosticowwds_8_tfdiagnosticotiposexo_sels ,
                                           A131DiagnosticoEstado ,
                                           AV54Diagnosticowwds_9_tfdiagnosticoestado_sels ,
                                           AV46Diagnosticowwds_1_filterfulltext ,
                                           Integer.valueOf(AV47Diagnosticowwds_2_tfdiagnosticoid) ,
                                           Integer.valueOf(AV48Diagnosticowwds_3_tfdiagnosticoid_to) ,
                                           AV50Diagnosticowwds_5_tfdiagnosticocodigo_sel ,
                                           AV49Diagnosticowwds_4_tfdiagnosticocodigo ,
                                           AV52Diagnosticowwds_7_tfdiagnosticodescripcion_sel ,
                                           AV51Diagnosticowwds_6_tfdiagnosticodescripcion ,
                                           Integer.valueOf(AV53Diagnosticowwds_8_tfdiagnosticotiposexo_sels.size()) ,
                                           Integer.valueOf(AV54Diagnosticowwds_9_tfdiagnosticoestado_sels.size()) ,
                                           AV56Diagnosticowwds_11_tfdiagnosticolongdesc_sel ,
                                           AV55Diagnosticowwds_10_tfdiagnosticolongdesc ,
                                           Integer.valueOf(A23DiagnosticoId) ,
                                           A107DiagnosticoCodigo ,
                                           A108DiagnosticoDescripcion } ,
                                           new int[]{
                                           TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.INT, TypeConstants.INT, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.INT,
                                           TypeConstants.INT, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.INT, TypeConstants.STRING, TypeConstants.STRING
                                           }
      });
      lV46Diagnosticowwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV46Diagnosticowwds_1_filterfulltext), "%", "") ;
      lV46Diagnosticowwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV46Diagnosticowwds_1_filterfulltext), "%", "") ;
      lV46Diagnosticowwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV46Diagnosticowwds_1_filterfulltext), "%", "") ;
      lV46Diagnosticowwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV46Diagnosticowwds_1_filterfulltext), "%", "") ;
      lV46Diagnosticowwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV46Diagnosticowwds_1_filterfulltext), "%", "") ;
      lV46Diagnosticowwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV46Diagnosticowwds_1_filterfulltext), "%", "") ;
      lV46Diagnosticowwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV46Diagnosticowwds_1_filterfulltext), "%", "") ;
      lV46Diagnosticowwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV46Diagnosticowwds_1_filterfulltext), "%", "") ;
      lV46Diagnosticowwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV46Diagnosticowwds_1_filterfulltext), "%", "") ;
      lV49Diagnosticowwds_4_tfdiagnosticocodigo = GXutil.concat( GXutil.rtrim( AV49Diagnosticowwds_4_tfdiagnosticocodigo), "%", "") ;
      lV51Diagnosticowwds_6_tfdiagnosticodescripcion = GXutil.concat( GXutil.rtrim( AV51Diagnosticowwds_6_tfdiagnosticodescripcion), "%", "") ;
      lV55Diagnosticowwds_10_tfdiagnosticolongdesc = GXutil.concat( GXutil.rtrim( AV55Diagnosticowwds_10_tfdiagnosticolongdesc), "%", "") ;
      /* Using cursor P002V2 */
      pr_default.execute(0, new Object[] {lV46Diagnosticowwds_1_filterfulltext, lV46Diagnosticowwds_1_filterfulltext, lV46Diagnosticowwds_1_filterfulltext, lV46Diagnosticowwds_1_filterfulltext, lV46Diagnosticowwds_1_filterfulltext, lV46Diagnosticowwds_1_filterfulltext, lV46Diagnosticowwds_1_filterfulltext, lV46Diagnosticowwds_1_filterfulltext, lV46Diagnosticowwds_1_filterfulltext, Integer.valueOf(AV47Diagnosticowwds_2_tfdiagnosticoid), Integer.valueOf(AV48Diagnosticowwds_3_tfdiagnosticoid_to), lV49Diagnosticowwds_4_tfdiagnosticocodigo, AV50Diagnosticowwds_5_tfdiagnosticocodigo_sel, lV51Diagnosticowwds_6_tfdiagnosticodescripcion, AV52Diagnosticowwds_7_tfdiagnosticodescripcion_sel, lV55Diagnosticowwds_10_tfdiagnosticolongdesc, AV56Diagnosticowwds_11_tfdiagnosticolongdesc_sel});
      while ( (pr_default.getStatus(0) != 101) )
      {
         brk2V2 = false ;
         A23DiagnosticoId = P002V2_A23DiagnosticoId[0] ;
         A131DiagnosticoEstado = P002V2_A131DiagnosticoEstado[0] ;
         A130DiagnosticoTipoSexo = P002V2_A130DiagnosticoTipoSexo[0] ;
         A108DiagnosticoDescripcion = P002V2_A108DiagnosticoDescripcion[0] ;
         A107DiagnosticoCodigo = P002V2_A107DiagnosticoCodigo[0] ;
         A132DiagnosticoLongDesc = A107DiagnosticoCodigo + " - " + A108DiagnosticoDescripcion ;
         AV35count = 0 ;
         while ( (pr_default.getStatus(0) != 101) && ( GXutil.strcmp(P002V2_A107DiagnosticoCodigo[0], A107DiagnosticoCodigo) == 0 ) )
         {
            brk2V2 = false ;
            A23DiagnosticoId = P002V2_A23DiagnosticoId[0] ;
            AV35count = (long)(AV35count+1) ;
            brk2V2 = true ;
            pr_default.readNext(0);
         }
         if ( ! (GXutil.strcmp("", A107DiagnosticoCodigo)==0) )
         {
            AV27Option = A107DiagnosticoCodigo ;
            AV28Options.add(AV27Option, 0);
            AV33OptionIndexes.add(GXutil.trim( localUtil.format( DecimalUtil.doubleToDec(AV35count), "Z,ZZZ,ZZZ,ZZ9")), 0);
         }
         if ( AV28Options.size() == 50 )
         {
            /* Exit For each command. Update data (if necessary), close cursors & exit. */
            if (true) break;
         }
         if ( ! brk2V2 )
         {
            brk2V2 = true ;
            pr_default.readNext(0);
         }
      }
      pr_default.close(0);
   }

   public void S131( )
   {
      /* 'LOADDIAGNOSTICODESCRIPCIONOPTIONS' Routine */
      returnInSub = false ;
      AV15TFDiagnosticoDescripcion = AV23SearchTxt ;
      AV16TFDiagnosticoDescripcion_Sel = "" ;
      AV46Diagnosticowwds_1_filterfulltext = AV41FilterFullText ;
      AV47Diagnosticowwds_2_tfdiagnosticoid = AV11TFDiagnosticoId ;
      AV48Diagnosticowwds_3_tfdiagnosticoid_to = AV12TFDiagnosticoId_To ;
      AV49Diagnosticowwds_4_tfdiagnosticocodigo = AV13TFDiagnosticoCodigo ;
      AV50Diagnosticowwds_5_tfdiagnosticocodigo_sel = AV14TFDiagnosticoCodigo_Sel ;
      AV51Diagnosticowwds_6_tfdiagnosticodescripcion = AV15TFDiagnosticoDescripcion ;
      AV52Diagnosticowwds_7_tfdiagnosticodescripcion_sel = AV16TFDiagnosticoDescripcion_Sel ;
      AV53Diagnosticowwds_8_tfdiagnosticotiposexo_sels = AV18TFDiagnosticoTipoSexo_Sels ;
      AV54Diagnosticowwds_9_tfdiagnosticoestado_sels = AV20TFDiagnosticoEstado_Sels ;
      AV55Diagnosticowwds_10_tfdiagnosticolongdesc = AV21TFDiagnosticoLongDesc ;
      AV56Diagnosticowwds_11_tfdiagnosticolongdesc_sel = AV22TFDiagnosticoLongDesc_Sel ;
      pr_default.dynParam(1, new Object[]{ new Object[]{
                                           A130DiagnosticoTipoSexo ,
                                           AV53Diagnosticowwds_8_tfdiagnosticotiposexo_sels ,
                                           A131DiagnosticoEstado ,
                                           AV54Diagnosticowwds_9_tfdiagnosticoestado_sels ,
                                           AV46Diagnosticowwds_1_filterfulltext ,
                                           Integer.valueOf(AV47Diagnosticowwds_2_tfdiagnosticoid) ,
                                           Integer.valueOf(AV48Diagnosticowwds_3_tfdiagnosticoid_to) ,
                                           AV50Diagnosticowwds_5_tfdiagnosticocodigo_sel ,
                                           AV49Diagnosticowwds_4_tfdiagnosticocodigo ,
                                           AV52Diagnosticowwds_7_tfdiagnosticodescripcion_sel ,
                                           AV51Diagnosticowwds_6_tfdiagnosticodescripcion ,
                                           Integer.valueOf(AV53Diagnosticowwds_8_tfdiagnosticotiposexo_sels.size()) ,
                                           Integer.valueOf(AV54Diagnosticowwds_9_tfdiagnosticoestado_sels.size()) ,
                                           AV56Diagnosticowwds_11_tfdiagnosticolongdesc_sel ,
                                           AV55Diagnosticowwds_10_tfdiagnosticolongdesc ,
                                           Integer.valueOf(A23DiagnosticoId) ,
                                           A107DiagnosticoCodigo ,
                                           A108DiagnosticoDescripcion } ,
                                           new int[]{
                                           TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.INT, TypeConstants.INT, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.INT,
                                           TypeConstants.INT, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.INT, TypeConstants.STRING, TypeConstants.STRING
                                           }
      });
      lV46Diagnosticowwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV46Diagnosticowwds_1_filterfulltext), "%", "") ;
      lV46Diagnosticowwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV46Diagnosticowwds_1_filterfulltext), "%", "") ;
      lV46Diagnosticowwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV46Diagnosticowwds_1_filterfulltext), "%", "") ;
      lV46Diagnosticowwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV46Diagnosticowwds_1_filterfulltext), "%", "") ;
      lV46Diagnosticowwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV46Diagnosticowwds_1_filterfulltext), "%", "") ;
      lV46Diagnosticowwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV46Diagnosticowwds_1_filterfulltext), "%", "") ;
      lV46Diagnosticowwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV46Diagnosticowwds_1_filterfulltext), "%", "") ;
      lV46Diagnosticowwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV46Diagnosticowwds_1_filterfulltext), "%", "") ;
      lV46Diagnosticowwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV46Diagnosticowwds_1_filterfulltext), "%", "") ;
      lV49Diagnosticowwds_4_tfdiagnosticocodigo = GXutil.concat( GXutil.rtrim( AV49Diagnosticowwds_4_tfdiagnosticocodigo), "%", "") ;
      lV51Diagnosticowwds_6_tfdiagnosticodescripcion = GXutil.concat( GXutil.rtrim( AV51Diagnosticowwds_6_tfdiagnosticodescripcion), "%", "") ;
      lV55Diagnosticowwds_10_tfdiagnosticolongdesc = GXutil.concat( GXutil.rtrim( AV55Diagnosticowwds_10_tfdiagnosticolongdesc), "%", "") ;
      /* Using cursor P002V3 */
      pr_default.execute(1, new Object[] {lV46Diagnosticowwds_1_filterfulltext, lV46Diagnosticowwds_1_filterfulltext, lV46Diagnosticowwds_1_filterfulltext, lV46Diagnosticowwds_1_filterfulltext, lV46Diagnosticowwds_1_filterfulltext, lV46Diagnosticowwds_1_filterfulltext, lV46Diagnosticowwds_1_filterfulltext, lV46Diagnosticowwds_1_filterfulltext, lV46Diagnosticowwds_1_filterfulltext, Integer.valueOf(AV47Diagnosticowwds_2_tfdiagnosticoid), Integer.valueOf(AV48Diagnosticowwds_3_tfdiagnosticoid_to), lV49Diagnosticowwds_4_tfdiagnosticocodigo, AV50Diagnosticowwds_5_tfdiagnosticocodigo_sel, lV51Diagnosticowwds_6_tfdiagnosticodescripcion, AV52Diagnosticowwds_7_tfdiagnosticodescripcion_sel, lV55Diagnosticowwds_10_tfdiagnosticolongdesc, AV56Diagnosticowwds_11_tfdiagnosticolongdesc_sel});
      while ( (pr_default.getStatus(1) != 101) )
      {
         brk2V4 = false ;
         A23DiagnosticoId = P002V3_A23DiagnosticoId[0] ;
         A131DiagnosticoEstado = P002V3_A131DiagnosticoEstado[0] ;
         A130DiagnosticoTipoSexo = P002V3_A130DiagnosticoTipoSexo[0] ;
         A108DiagnosticoDescripcion = P002V3_A108DiagnosticoDescripcion[0] ;
         A107DiagnosticoCodigo = P002V3_A107DiagnosticoCodigo[0] ;
         A132DiagnosticoLongDesc = A107DiagnosticoCodigo + " - " + A108DiagnosticoDescripcion ;
         AV35count = 0 ;
         while ( (pr_default.getStatus(1) != 101) && ( GXutil.strcmp(P002V3_A108DiagnosticoDescripcion[0], A108DiagnosticoDescripcion) == 0 ) )
         {
            brk2V4 = false ;
            A23DiagnosticoId = P002V3_A23DiagnosticoId[0] ;
            AV35count = (long)(AV35count+1) ;
            brk2V4 = true ;
            pr_default.readNext(1);
         }
         if ( ! (GXutil.strcmp("", A108DiagnosticoDescripcion)==0) )
         {
            AV27Option = A108DiagnosticoDescripcion ;
            AV28Options.add(AV27Option, 0);
            AV33OptionIndexes.add(GXutil.trim( localUtil.format( DecimalUtil.doubleToDec(AV35count), "Z,ZZZ,ZZZ,ZZ9")), 0);
         }
         if ( AV28Options.size() == 50 )
         {
            /* Exit For each command. Update data (if necessary), close cursors & exit. */
            if (true) break;
         }
         if ( ! brk2V4 )
         {
            brk2V4 = true ;
            pr_default.readNext(1);
         }
      }
      pr_default.close(1);
   }

   public void S141( )
   {
      /* 'LOADDIAGNOSTICOLONGDESCOPTIONS' Routine */
      returnInSub = false ;
      AV21TFDiagnosticoLongDesc = AV23SearchTxt ;
      AV22TFDiagnosticoLongDesc_Sel = "" ;
      AV46Diagnosticowwds_1_filterfulltext = AV41FilterFullText ;
      AV47Diagnosticowwds_2_tfdiagnosticoid = AV11TFDiagnosticoId ;
      AV48Diagnosticowwds_3_tfdiagnosticoid_to = AV12TFDiagnosticoId_To ;
      AV49Diagnosticowwds_4_tfdiagnosticocodigo = AV13TFDiagnosticoCodigo ;
      AV50Diagnosticowwds_5_tfdiagnosticocodigo_sel = AV14TFDiagnosticoCodigo_Sel ;
      AV51Diagnosticowwds_6_tfdiagnosticodescripcion = AV15TFDiagnosticoDescripcion ;
      AV52Diagnosticowwds_7_tfdiagnosticodescripcion_sel = AV16TFDiagnosticoDescripcion_Sel ;
      AV53Diagnosticowwds_8_tfdiagnosticotiposexo_sels = AV18TFDiagnosticoTipoSexo_Sels ;
      AV54Diagnosticowwds_9_tfdiagnosticoestado_sels = AV20TFDiagnosticoEstado_Sels ;
      AV55Diagnosticowwds_10_tfdiagnosticolongdesc = AV21TFDiagnosticoLongDesc ;
      AV56Diagnosticowwds_11_tfdiagnosticolongdesc_sel = AV22TFDiagnosticoLongDesc_Sel ;
      pr_default.dynParam(2, new Object[]{ new Object[]{
                                           A130DiagnosticoTipoSexo ,
                                           AV53Diagnosticowwds_8_tfdiagnosticotiposexo_sels ,
                                           A131DiagnosticoEstado ,
                                           AV54Diagnosticowwds_9_tfdiagnosticoestado_sels ,
                                           AV46Diagnosticowwds_1_filterfulltext ,
                                           Integer.valueOf(AV47Diagnosticowwds_2_tfdiagnosticoid) ,
                                           Integer.valueOf(AV48Diagnosticowwds_3_tfdiagnosticoid_to) ,
                                           AV50Diagnosticowwds_5_tfdiagnosticocodigo_sel ,
                                           AV49Diagnosticowwds_4_tfdiagnosticocodigo ,
                                           AV52Diagnosticowwds_7_tfdiagnosticodescripcion_sel ,
                                           AV51Diagnosticowwds_6_tfdiagnosticodescripcion ,
                                           Integer.valueOf(AV53Diagnosticowwds_8_tfdiagnosticotiposexo_sels.size()) ,
                                           Integer.valueOf(AV54Diagnosticowwds_9_tfdiagnosticoestado_sels.size()) ,
                                           AV56Diagnosticowwds_11_tfdiagnosticolongdesc_sel ,
                                           AV55Diagnosticowwds_10_tfdiagnosticolongdesc ,
                                           Integer.valueOf(A23DiagnosticoId) ,
                                           A107DiagnosticoCodigo ,
                                           A108DiagnosticoDescripcion } ,
                                           new int[]{
                                           TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.INT, TypeConstants.INT, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.INT,
                                           TypeConstants.INT, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.INT, TypeConstants.STRING, TypeConstants.STRING
                                           }
      });
      lV46Diagnosticowwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV46Diagnosticowwds_1_filterfulltext), "%", "") ;
      lV46Diagnosticowwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV46Diagnosticowwds_1_filterfulltext), "%", "") ;
      lV46Diagnosticowwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV46Diagnosticowwds_1_filterfulltext), "%", "") ;
      lV46Diagnosticowwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV46Diagnosticowwds_1_filterfulltext), "%", "") ;
      lV46Diagnosticowwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV46Diagnosticowwds_1_filterfulltext), "%", "") ;
      lV46Diagnosticowwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV46Diagnosticowwds_1_filterfulltext), "%", "") ;
      lV46Diagnosticowwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV46Diagnosticowwds_1_filterfulltext), "%", "") ;
      lV46Diagnosticowwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV46Diagnosticowwds_1_filterfulltext), "%", "") ;
      lV46Diagnosticowwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV46Diagnosticowwds_1_filterfulltext), "%", "") ;
      lV49Diagnosticowwds_4_tfdiagnosticocodigo = GXutil.concat( GXutil.rtrim( AV49Diagnosticowwds_4_tfdiagnosticocodigo), "%", "") ;
      lV51Diagnosticowwds_6_tfdiagnosticodescripcion = GXutil.concat( GXutil.rtrim( AV51Diagnosticowwds_6_tfdiagnosticodescripcion), "%", "") ;
      lV55Diagnosticowwds_10_tfdiagnosticolongdesc = GXutil.concat( GXutil.rtrim( AV55Diagnosticowwds_10_tfdiagnosticolongdesc), "%", "") ;
      /* Using cursor P002V4 */
      pr_default.execute(2, new Object[] {lV46Diagnosticowwds_1_filterfulltext, lV46Diagnosticowwds_1_filterfulltext, lV46Diagnosticowwds_1_filterfulltext, lV46Diagnosticowwds_1_filterfulltext, lV46Diagnosticowwds_1_filterfulltext, lV46Diagnosticowwds_1_filterfulltext, lV46Diagnosticowwds_1_filterfulltext, lV46Diagnosticowwds_1_filterfulltext, lV46Diagnosticowwds_1_filterfulltext, Integer.valueOf(AV47Diagnosticowwds_2_tfdiagnosticoid), Integer.valueOf(AV48Diagnosticowwds_3_tfdiagnosticoid_to), lV49Diagnosticowwds_4_tfdiagnosticocodigo, AV50Diagnosticowwds_5_tfdiagnosticocodigo_sel, lV51Diagnosticowwds_6_tfdiagnosticodescripcion, AV52Diagnosticowwds_7_tfdiagnosticodescripcion_sel, lV55Diagnosticowwds_10_tfdiagnosticolongdesc, AV56Diagnosticowwds_11_tfdiagnosticolongdesc_sel});
      while ( (pr_default.getStatus(2) != 101) )
      {
         A23DiagnosticoId = P002V4_A23DiagnosticoId[0] ;
         A131DiagnosticoEstado = P002V4_A131DiagnosticoEstado[0] ;
         A130DiagnosticoTipoSexo = P002V4_A130DiagnosticoTipoSexo[0] ;
         A108DiagnosticoDescripcion = P002V4_A108DiagnosticoDescripcion[0] ;
         A107DiagnosticoCodigo = P002V4_A107DiagnosticoCodigo[0] ;
         A132DiagnosticoLongDesc = A107DiagnosticoCodigo + " - " + A108DiagnosticoDescripcion ;
         if ( ! (GXutil.strcmp("", A132DiagnosticoLongDesc)==0) )
         {
            AV27Option = A132DiagnosticoLongDesc ;
            AV26InsertIndex = 1 ;
            while ( ( AV26InsertIndex <= AV28Options.size() ) && ( GXutil.strcmp((String)AV28Options.elementAt(-1+AV26InsertIndex), AV27Option) < 0 ) )
            {
               AV26InsertIndex = (int)(AV26InsertIndex+1) ;
            }
            if ( ( AV26InsertIndex <= AV28Options.size() ) && ( GXutil.strcmp((String)AV28Options.elementAt(-1+AV26InsertIndex), AV27Option) == 0 ) )
            {
               AV35count = GXutil.lval( (String)AV33OptionIndexes.elementAt(-1+AV26InsertIndex)) ;
               AV35count = (long)(AV35count+1) ;
               AV33OptionIndexes.removeItem(AV26InsertIndex);
               AV33OptionIndexes.add(GXutil.trim( localUtil.format( DecimalUtil.doubleToDec(AV35count), "Z,ZZZ,ZZZ,ZZ9")), AV26InsertIndex);
            }
            else
            {
               AV28Options.add(AV27Option, AV26InsertIndex);
               AV33OptionIndexes.add("1", AV26InsertIndex);
            }
         }
         if ( AV28Options.size() == 50 )
         {
            /* Exit For each command. Update data (if necessary), close cursors & exit. */
            if (true) break;
         }
         pr_default.readNext(2);
      }
      pr_default.close(2);
   }

   protected void cleanup( )
   {
      this.aP3[0] = diagnosticowwgetfilterdata.this.AV29OptionsJson;
      this.aP4[0] = diagnosticowwgetfilterdata.this.AV32OptionsDescJson;
      this.aP5[0] = diagnosticowwgetfilterdata.this.AV34OptionIndexesJson;
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
      AV13TFDiagnosticoCodigo = "" ;
      AV14TFDiagnosticoCodigo_Sel = "" ;
      AV15TFDiagnosticoDescripcion = "" ;
      AV16TFDiagnosticoDescripcion_Sel = "" ;
      AV17TFDiagnosticoTipoSexo_SelsJson = "" ;
      AV18TFDiagnosticoTipoSexo_Sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV19TFDiagnosticoEstado_SelsJson = "" ;
      AV20TFDiagnosticoEstado_Sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV21TFDiagnosticoLongDesc = "" ;
      AV22TFDiagnosticoLongDesc_Sel = "" ;
      A107DiagnosticoCodigo = "" ;
      AV46Diagnosticowwds_1_filterfulltext = "" ;
      AV49Diagnosticowwds_4_tfdiagnosticocodigo = "" ;
      AV50Diagnosticowwds_5_tfdiagnosticocodigo_sel = "" ;
      AV51Diagnosticowwds_6_tfdiagnosticodescripcion = "" ;
      AV52Diagnosticowwds_7_tfdiagnosticodescripcion_sel = "" ;
      AV53Diagnosticowwds_8_tfdiagnosticotiposexo_sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV54Diagnosticowwds_9_tfdiagnosticoestado_sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV55Diagnosticowwds_10_tfdiagnosticolongdesc = "" ;
      AV56Diagnosticowwds_11_tfdiagnosticolongdesc_sel = "" ;
      scmdbuf = "" ;
      lV46Diagnosticowwds_1_filterfulltext = "" ;
      lV49Diagnosticowwds_4_tfdiagnosticocodigo = "" ;
      lV51Diagnosticowwds_6_tfdiagnosticodescripcion = "" ;
      lV55Diagnosticowwds_10_tfdiagnosticolongdesc = "" ;
      A130DiagnosticoTipoSexo = "" ;
      A131DiagnosticoEstado = "" ;
      A108DiagnosticoDescripcion = "" ;
      P002V2_A23DiagnosticoId = new int[1] ;
      P002V2_A131DiagnosticoEstado = new String[] {""} ;
      P002V2_A130DiagnosticoTipoSexo = new String[] {""} ;
      P002V2_A108DiagnosticoDescripcion = new String[] {""} ;
      P002V2_A107DiagnosticoCodigo = new String[] {""} ;
      A132DiagnosticoLongDesc = "" ;
      AV27Option = "" ;
      P002V3_A23DiagnosticoId = new int[1] ;
      P002V3_A131DiagnosticoEstado = new String[] {""} ;
      P002V3_A130DiagnosticoTipoSexo = new String[] {""} ;
      P002V3_A108DiagnosticoDescripcion = new String[] {""} ;
      P002V3_A107DiagnosticoCodigo = new String[] {""} ;
      P002V4_A23DiagnosticoId = new int[1] ;
      P002V4_A131DiagnosticoEstado = new String[] {""} ;
      P002V4_A130DiagnosticoTipoSexo = new String[] {""} ;
      P002V4_A108DiagnosticoDescripcion = new String[] {""} ;
      P002V4_A107DiagnosticoCodigo = new String[] {""} ;
      pr_default = new DataStoreProvider(context, remoteHandle, new com.projectthani.diagnosticowwgetfilterdata__default(),
         new Object[] {
             new Object[] {
            P002V2_A23DiagnosticoId, P002V2_A131DiagnosticoEstado, P002V2_A130DiagnosticoTipoSexo, P002V2_A108DiagnosticoDescripcion, P002V2_A107DiagnosticoCodigo
            }
            , new Object[] {
            P002V3_A23DiagnosticoId, P002V3_A131DiagnosticoEstado, P002V3_A130DiagnosticoTipoSexo, P002V3_A108DiagnosticoDescripcion, P002V3_A107DiagnosticoCodigo
            }
            , new Object[] {
            P002V4_A23DiagnosticoId, P002V4_A131DiagnosticoEstado, P002V4_A130DiagnosticoTipoSexo, P002V4_A108DiagnosticoDescripcion, P002V4_A107DiagnosticoCodigo
            }
         }
      );
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private short Gx_err ;
   private int AV44GXV1 ;
   private int AV11TFDiagnosticoId ;
   private int AV12TFDiagnosticoId_To ;
   private int AV47Diagnosticowwds_2_tfdiagnosticoid ;
   private int AV48Diagnosticowwds_3_tfdiagnosticoid_to ;
   private int AV53Diagnosticowwds_8_tfdiagnosticotiposexo_sels_size ;
   private int AV54Diagnosticowwds_9_tfdiagnosticoestado_sels_size ;
   private int A23DiagnosticoId ;
   private int AV26InsertIndex ;
   private long AV35count ;
   private String scmdbuf ;
   private String A130DiagnosticoTipoSexo ;
   private String A131DiagnosticoEstado ;
   private boolean AV8IsAuthorized ;
   private boolean GXt_boolean1 ;
   private boolean GXv_boolean2[] ;
   private boolean returnInSub ;
   private boolean brk2V2 ;
   private boolean brk2V4 ;
   private String AV29OptionsJson ;
   private String AV32OptionsDescJson ;
   private String AV34OptionIndexesJson ;
   private String AV17TFDiagnosticoTipoSexo_SelsJson ;
   private String AV19TFDiagnosticoEstado_SelsJson ;
   private String AV25DDOName ;
   private String AV23SearchTxt ;
   private String AV24SearchTxtTo ;
   private String AV41FilterFullText ;
   private String AV13TFDiagnosticoCodigo ;
   private String AV14TFDiagnosticoCodigo_Sel ;
   private String AV15TFDiagnosticoDescripcion ;
   private String AV16TFDiagnosticoDescripcion_Sel ;
   private String AV21TFDiagnosticoLongDesc ;
   private String AV22TFDiagnosticoLongDesc_Sel ;
   private String A107DiagnosticoCodigo ;
   private String AV46Diagnosticowwds_1_filterfulltext ;
   private String AV49Diagnosticowwds_4_tfdiagnosticocodigo ;
   private String AV50Diagnosticowwds_5_tfdiagnosticocodigo_sel ;
   private String AV51Diagnosticowwds_6_tfdiagnosticodescripcion ;
   private String AV52Diagnosticowwds_7_tfdiagnosticodescripcion_sel ;
   private String AV55Diagnosticowwds_10_tfdiagnosticolongdesc ;
   private String AV56Diagnosticowwds_11_tfdiagnosticolongdesc_sel ;
   private String lV46Diagnosticowwds_1_filterfulltext ;
   private String lV49Diagnosticowwds_4_tfdiagnosticocodigo ;
   private String lV51Diagnosticowwds_6_tfdiagnosticodescripcion ;
   private String lV55Diagnosticowwds_10_tfdiagnosticolongdesc ;
   private String A108DiagnosticoDescripcion ;
   private String A132DiagnosticoLongDesc ;
   private String AV27Option ;
   private com.genexus.webpanels.WebSession AV36Session ;
   private String[] aP5 ;
   private String[] aP3 ;
   private String[] aP4 ;
   private IDataStoreProvider pr_default ;
   private int[] P002V2_A23DiagnosticoId ;
   private String[] P002V2_A131DiagnosticoEstado ;
   private String[] P002V2_A130DiagnosticoTipoSexo ;
   private String[] P002V2_A108DiagnosticoDescripcion ;
   private String[] P002V2_A107DiagnosticoCodigo ;
   private int[] P002V3_A23DiagnosticoId ;
   private String[] P002V3_A131DiagnosticoEstado ;
   private String[] P002V3_A130DiagnosticoTipoSexo ;
   private String[] P002V3_A108DiagnosticoDescripcion ;
   private String[] P002V3_A107DiagnosticoCodigo ;
   private int[] P002V4_A23DiagnosticoId ;
   private String[] P002V4_A131DiagnosticoEstado ;
   private String[] P002V4_A130DiagnosticoTipoSexo ;
   private String[] P002V4_A108DiagnosticoDescripcion ;
   private String[] P002V4_A107DiagnosticoCodigo ;
   private GXSimpleCollection<String> AV18TFDiagnosticoTipoSexo_Sels ;
   private GXSimpleCollection<String> AV20TFDiagnosticoEstado_Sels ;
   private GXSimpleCollection<String> AV53Diagnosticowwds_8_tfdiagnosticotiposexo_sels ;
   private GXSimpleCollection<String> AV54Diagnosticowwds_9_tfdiagnosticoestado_sels ;
   private GXSimpleCollection<String> AV28Options ;
   private GXSimpleCollection<String> AV31OptionsDesc ;
   private GXSimpleCollection<String> AV33OptionIndexes ;
   private com.projectthani.wwpbaseobjects.SdtWWPContext AV9WWPContext ;
   private com.projectthani.wwpbaseobjects.SdtWWPContext GXv_SdtWWPContext3[] ;
   private com.projectthani.wwpbaseobjects.SdtWWPGridState AV38GridState ;
   private com.projectthani.wwpbaseobjects.SdtWWPGridState_FilterValue AV39GridStateFilterValue ;
}

final  class diagnosticowwgetfilterdata__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   protected Object[] conditional_P002V2( ModelContext context ,
                                          int remoteHandle ,
                                          com.genexus.IHttpContext httpContext ,
                                          String A130DiagnosticoTipoSexo ,
                                          GXSimpleCollection<String> AV53Diagnosticowwds_8_tfdiagnosticotiposexo_sels ,
                                          String A131DiagnosticoEstado ,
                                          GXSimpleCollection<String> AV54Diagnosticowwds_9_tfdiagnosticoestado_sels ,
                                          String AV46Diagnosticowwds_1_filterfulltext ,
                                          int AV47Diagnosticowwds_2_tfdiagnosticoid ,
                                          int AV48Diagnosticowwds_3_tfdiagnosticoid_to ,
                                          String AV50Diagnosticowwds_5_tfdiagnosticocodigo_sel ,
                                          String AV49Diagnosticowwds_4_tfdiagnosticocodigo ,
                                          String AV52Diagnosticowwds_7_tfdiagnosticodescripcion_sel ,
                                          String AV51Diagnosticowwds_6_tfdiagnosticodescripcion ,
                                          int AV53Diagnosticowwds_8_tfdiagnosticotiposexo_sels_size ,
                                          int AV54Diagnosticowwds_9_tfdiagnosticoestado_sels_size ,
                                          String AV56Diagnosticowwds_11_tfdiagnosticolongdesc_sel ,
                                          String AV55Diagnosticowwds_10_tfdiagnosticolongdesc ,
                                          int A23DiagnosticoId ,
                                          String A107DiagnosticoCodigo ,
                                          String A108DiagnosticoDescripcion )
   {
      java.lang.StringBuffer sWhereString = new java.lang.StringBuffer();
      String scmdbuf;
      byte[] GXv_int4 = new byte[17];
      Object[] GXv_Object5 = new Object[2];
      scmdbuf = "SELECT [DiagnosticoId], [DiagnosticoEstado], [DiagnosticoTipoSexo], [DiagnosticoDescripcion], [DiagnosticoCodigo] FROM [Diagnostico]" ;
      if ( ! (GXutil.strcmp("", AV46Diagnosticowwds_1_filterfulltext)==0) )
      {
         addWhere(sWhereString, "(( CONVERT( char(8), CAST([DiagnosticoId] AS decimal(8,0))) like '%' + ?) or ( [DiagnosticoCodigo] like '%' + ?) or ( [DiagnosticoDescripcion] like '%' + ?) or ( 'masculino' like '%' + LOWER(?) and [DiagnosticoTipoSexo] = 'M') or ( 'femenino' like '%' + LOWER(?) and [DiagnosticoTipoSexo] = 'F') or ( 'ambos' like '%' + LOWER(?) and [DiagnosticoTipoSexo] = 'A') or ( 'activo' like '%' + LOWER(?) and [DiagnosticoEstado] = 'A') or ( 'inactivo' like '%' + LOWER(?) and [DiagnosticoEstado] = 'I') or ( [DiagnosticoCodigo] + ' - ' + [DiagnosticoDescripcion] like '%' + ?))");
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
      }
      if ( ! (0==AV47Diagnosticowwds_2_tfdiagnosticoid) )
      {
         addWhere(sWhereString, "([DiagnosticoId] >= ?)");
      }
      else
      {
         GXv_int4[9] = (byte)(1) ;
      }
      if ( ! (0==AV48Diagnosticowwds_3_tfdiagnosticoid_to) )
      {
         addWhere(sWhereString, "([DiagnosticoId] <= ?)");
      }
      else
      {
         GXv_int4[10] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV50Diagnosticowwds_5_tfdiagnosticocodigo_sel)==0) && ( ! (GXutil.strcmp("", AV49Diagnosticowwds_4_tfdiagnosticocodigo)==0) ) )
      {
         addWhere(sWhereString, "([DiagnosticoCodigo] like ?)");
      }
      else
      {
         GXv_int4[11] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV50Diagnosticowwds_5_tfdiagnosticocodigo_sel)==0) )
      {
         addWhere(sWhereString, "([DiagnosticoCodigo] = ?)");
      }
      else
      {
         GXv_int4[12] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV52Diagnosticowwds_7_tfdiagnosticodescripcion_sel)==0) && ( ! (GXutil.strcmp("", AV51Diagnosticowwds_6_tfdiagnosticodescripcion)==0) ) )
      {
         addWhere(sWhereString, "([DiagnosticoDescripcion] like ?)");
      }
      else
      {
         GXv_int4[13] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV52Diagnosticowwds_7_tfdiagnosticodescripcion_sel)==0) )
      {
         addWhere(sWhereString, "([DiagnosticoDescripcion] = ?)");
      }
      else
      {
         GXv_int4[14] = (byte)(1) ;
      }
      if ( AV53Diagnosticowwds_8_tfdiagnosticotiposexo_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("sqlserver", AV53Diagnosticowwds_8_tfdiagnosticotiposexo_sels, "[DiagnosticoTipoSexo] IN (", ")")+")");
      }
      if ( AV54Diagnosticowwds_9_tfdiagnosticoestado_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("sqlserver", AV54Diagnosticowwds_9_tfdiagnosticoestado_sels, "[DiagnosticoEstado] IN (", ")")+")");
      }
      if ( (GXutil.strcmp("", AV56Diagnosticowwds_11_tfdiagnosticolongdesc_sel)==0) && ( ! (GXutil.strcmp("", AV55Diagnosticowwds_10_tfdiagnosticolongdesc)==0) ) )
      {
         addWhere(sWhereString, "([DiagnosticoCodigo] + ' - ' + [DiagnosticoDescripcion] like ?)");
      }
      else
      {
         GXv_int4[15] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV56Diagnosticowwds_11_tfdiagnosticolongdesc_sel)==0) )
      {
         addWhere(sWhereString, "([DiagnosticoCodigo] + ' - ' + [DiagnosticoDescripcion] = ?)");
      }
      else
      {
         GXv_int4[16] = (byte)(1) ;
      }
      scmdbuf += sWhereString ;
      scmdbuf += " ORDER BY [DiagnosticoCodigo]" ;
      GXv_Object5[0] = scmdbuf ;
      GXv_Object5[1] = GXv_int4 ;
      return GXv_Object5 ;
   }

   protected Object[] conditional_P002V3( ModelContext context ,
                                          int remoteHandle ,
                                          com.genexus.IHttpContext httpContext ,
                                          String A130DiagnosticoTipoSexo ,
                                          GXSimpleCollection<String> AV53Diagnosticowwds_8_tfdiagnosticotiposexo_sels ,
                                          String A131DiagnosticoEstado ,
                                          GXSimpleCollection<String> AV54Diagnosticowwds_9_tfdiagnosticoestado_sels ,
                                          String AV46Diagnosticowwds_1_filterfulltext ,
                                          int AV47Diagnosticowwds_2_tfdiagnosticoid ,
                                          int AV48Diagnosticowwds_3_tfdiagnosticoid_to ,
                                          String AV50Diagnosticowwds_5_tfdiagnosticocodigo_sel ,
                                          String AV49Diagnosticowwds_4_tfdiagnosticocodigo ,
                                          String AV52Diagnosticowwds_7_tfdiagnosticodescripcion_sel ,
                                          String AV51Diagnosticowwds_6_tfdiagnosticodescripcion ,
                                          int AV53Diagnosticowwds_8_tfdiagnosticotiposexo_sels_size ,
                                          int AV54Diagnosticowwds_9_tfdiagnosticoestado_sels_size ,
                                          String AV56Diagnosticowwds_11_tfdiagnosticolongdesc_sel ,
                                          String AV55Diagnosticowwds_10_tfdiagnosticolongdesc ,
                                          int A23DiagnosticoId ,
                                          String A107DiagnosticoCodigo ,
                                          String A108DiagnosticoDescripcion )
   {
      java.lang.StringBuffer sWhereString = new java.lang.StringBuffer();
      String scmdbuf;
      byte[] GXv_int7 = new byte[17];
      Object[] GXv_Object8 = new Object[2];
      scmdbuf = "SELECT [DiagnosticoId], [DiagnosticoEstado], [DiagnosticoTipoSexo], [DiagnosticoDescripcion], [DiagnosticoCodigo] FROM [Diagnostico]" ;
      if ( ! (GXutil.strcmp("", AV46Diagnosticowwds_1_filterfulltext)==0) )
      {
         addWhere(sWhereString, "(( CONVERT( char(8), CAST([DiagnosticoId] AS decimal(8,0))) like '%' + ?) or ( [DiagnosticoCodigo] like '%' + ?) or ( [DiagnosticoDescripcion] like '%' + ?) or ( 'masculino' like '%' + LOWER(?) and [DiagnosticoTipoSexo] = 'M') or ( 'femenino' like '%' + LOWER(?) and [DiagnosticoTipoSexo] = 'F') or ( 'ambos' like '%' + LOWER(?) and [DiagnosticoTipoSexo] = 'A') or ( 'activo' like '%' + LOWER(?) and [DiagnosticoEstado] = 'A') or ( 'inactivo' like '%' + LOWER(?) and [DiagnosticoEstado] = 'I') or ( [DiagnosticoCodigo] + ' - ' + [DiagnosticoDescripcion] like '%' + ?))");
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
      }
      if ( ! (0==AV47Diagnosticowwds_2_tfdiagnosticoid) )
      {
         addWhere(sWhereString, "([DiagnosticoId] >= ?)");
      }
      else
      {
         GXv_int7[9] = (byte)(1) ;
      }
      if ( ! (0==AV48Diagnosticowwds_3_tfdiagnosticoid_to) )
      {
         addWhere(sWhereString, "([DiagnosticoId] <= ?)");
      }
      else
      {
         GXv_int7[10] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV50Diagnosticowwds_5_tfdiagnosticocodigo_sel)==0) && ( ! (GXutil.strcmp("", AV49Diagnosticowwds_4_tfdiagnosticocodigo)==0) ) )
      {
         addWhere(sWhereString, "([DiagnosticoCodigo] like ?)");
      }
      else
      {
         GXv_int7[11] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV50Diagnosticowwds_5_tfdiagnosticocodigo_sel)==0) )
      {
         addWhere(sWhereString, "([DiagnosticoCodigo] = ?)");
      }
      else
      {
         GXv_int7[12] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV52Diagnosticowwds_7_tfdiagnosticodescripcion_sel)==0) && ( ! (GXutil.strcmp("", AV51Diagnosticowwds_6_tfdiagnosticodescripcion)==0) ) )
      {
         addWhere(sWhereString, "([DiagnosticoDescripcion] like ?)");
      }
      else
      {
         GXv_int7[13] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV52Diagnosticowwds_7_tfdiagnosticodescripcion_sel)==0) )
      {
         addWhere(sWhereString, "([DiagnosticoDescripcion] = ?)");
      }
      else
      {
         GXv_int7[14] = (byte)(1) ;
      }
      if ( AV53Diagnosticowwds_8_tfdiagnosticotiposexo_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("sqlserver", AV53Diagnosticowwds_8_tfdiagnosticotiposexo_sels, "[DiagnosticoTipoSexo] IN (", ")")+")");
      }
      if ( AV54Diagnosticowwds_9_tfdiagnosticoestado_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("sqlserver", AV54Diagnosticowwds_9_tfdiagnosticoestado_sels, "[DiagnosticoEstado] IN (", ")")+")");
      }
      if ( (GXutil.strcmp("", AV56Diagnosticowwds_11_tfdiagnosticolongdesc_sel)==0) && ( ! (GXutil.strcmp("", AV55Diagnosticowwds_10_tfdiagnosticolongdesc)==0) ) )
      {
         addWhere(sWhereString, "([DiagnosticoCodigo] + ' - ' + [DiagnosticoDescripcion] like ?)");
      }
      else
      {
         GXv_int7[15] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV56Diagnosticowwds_11_tfdiagnosticolongdesc_sel)==0) )
      {
         addWhere(sWhereString, "([DiagnosticoCodigo] + ' - ' + [DiagnosticoDescripcion] = ?)");
      }
      else
      {
         GXv_int7[16] = (byte)(1) ;
      }
      scmdbuf += sWhereString ;
      scmdbuf += " ORDER BY [DiagnosticoDescripcion]" ;
      GXv_Object8[0] = scmdbuf ;
      GXv_Object8[1] = GXv_int7 ;
      return GXv_Object8 ;
   }

   protected Object[] conditional_P002V4( ModelContext context ,
                                          int remoteHandle ,
                                          com.genexus.IHttpContext httpContext ,
                                          String A130DiagnosticoTipoSexo ,
                                          GXSimpleCollection<String> AV53Diagnosticowwds_8_tfdiagnosticotiposexo_sels ,
                                          String A131DiagnosticoEstado ,
                                          GXSimpleCollection<String> AV54Diagnosticowwds_9_tfdiagnosticoestado_sels ,
                                          String AV46Diagnosticowwds_1_filterfulltext ,
                                          int AV47Diagnosticowwds_2_tfdiagnosticoid ,
                                          int AV48Diagnosticowwds_3_tfdiagnosticoid_to ,
                                          String AV50Diagnosticowwds_5_tfdiagnosticocodigo_sel ,
                                          String AV49Diagnosticowwds_4_tfdiagnosticocodigo ,
                                          String AV52Diagnosticowwds_7_tfdiagnosticodescripcion_sel ,
                                          String AV51Diagnosticowwds_6_tfdiagnosticodescripcion ,
                                          int AV53Diagnosticowwds_8_tfdiagnosticotiposexo_sels_size ,
                                          int AV54Diagnosticowwds_9_tfdiagnosticoestado_sels_size ,
                                          String AV56Diagnosticowwds_11_tfdiagnosticolongdesc_sel ,
                                          String AV55Diagnosticowwds_10_tfdiagnosticolongdesc ,
                                          int A23DiagnosticoId ,
                                          String A107DiagnosticoCodigo ,
                                          String A108DiagnosticoDescripcion )
   {
      java.lang.StringBuffer sWhereString = new java.lang.StringBuffer();
      String scmdbuf;
      byte[] GXv_int10 = new byte[17];
      Object[] GXv_Object11 = new Object[2];
      scmdbuf = "SELECT [DiagnosticoId], [DiagnosticoEstado], [DiagnosticoTipoSexo], [DiagnosticoDescripcion], [DiagnosticoCodigo] FROM [Diagnostico]" ;
      if ( ! (GXutil.strcmp("", AV46Diagnosticowwds_1_filterfulltext)==0) )
      {
         addWhere(sWhereString, "(( CONVERT( char(8), CAST([DiagnosticoId] AS decimal(8,0))) like '%' + ?) or ( [DiagnosticoCodigo] like '%' + ?) or ( [DiagnosticoDescripcion] like '%' + ?) or ( 'masculino' like '%' + LOWER(?) and [DiagnosticoTipoSexo] = 'M') or ( 'femenino' like '%' + LOWER(?) and [DiagnosticoTipoSexo] = 'F') or ( 'ambos' like '%' + LOWER(?) and [DiagnosticoTipoSexo] = 'A') or ( 'activo' like '%' + LOWER(?) and [DiagnosticoEstado] = 'A') or ( 'inactivo' like '%' + LOWER(?) and [DiagnosticoEstado] = 'I') or ( [DiagnosticoCodigo] + ' - ' + [DiagnosticoDescripcion] like '%' + ?))");
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
      }
      if ( ! (0==AV47Diagnosticowwds_2_tfdiagnosticoid) )
      {
         addWhere(sWhereString, "([DiagnosticoId] >= ?)");
      }
      else
      {
         GXv_int10[9] = (byte)(1) ;
      }
      if ( ! (0==AV48Diagnosticowwds_3_tfdiagnosticoid_to) )
      {
         addWhere(sWhereString, "([DiagnosticoId] <= ?)");
      }
      else
      {
         GXv_int10[10] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV50Diagnosticowwds_5_tfdiagnosticocodigo_sel)==0) && ( ! (GXutil.strcmp("", AV49Diagnosticowwds_4_tfdiagnosticocodigo)==0) ) )
      {
         addWhere(sWhereString, "([DiagnosticoCodigo] like ?)");
      }
      else
      {
         GXv_int10[11] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV50Diagnosticowwds_5_tfdiagnosticocodigo_sel)==0) )
      {
         addWhere(sWhereString, "([DiagnosticoCodigo] = ?)");
      }
      else
      {
         GXv_int10[12] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV52Diagnosticowwds_7_tfdiagnosticodescripcion_sel)==0) && ( ! (GXutil.strcmp("", AV51Diagnosticowwds_6_tfdiagnosticodescripcion)==0) ) )
      {
         addWhere(sWhereString, "([DiagnosticoDescripcion] like ?)");
      }
      else
      {
         GXv_int10[13] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV52Diagnosticowwds_7_tfdiagnosticodescripcion_sel)==0) )
      {
         addWhere(sWhereString, "([DiagnosticoDescripcion] = ?)");
      }
      else
      {
         GXv_int10[14] = (byte)(1) ;
      }
      if ( AV53Diagnosticowwds_8_tfdiagnosticotiposexo_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("sqlserver", AV53Diagnosticowwds_8_tfdiagnosticotiposexo_sels, "[DiagnosticoTipoSexo] IN (", ")")+")");
      }
      if ( AV54Diagnosticowwds_9_tfdiagnosticoestado_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("sqlserver", AV54Diagnosticowwds_9_tfdiagnosticoestado_sels, "[DiagnosticoEstado] IN (", ")")+")");
      }
      if ( (GXutil.strcmp("", AV56Diagnosticowwds_11_tfdiagnosticolongdesc_sel)==0) && ( ! (GXutil.strcmp("", AV55Diagnosticowwds_10_tfdiagnosticolongdesc)==0) ) )
      {
         addWhere(sWhereString, "([DiagnosticoCodigo] + ' - ' + [DiagnosticoDescripcion] like ?)");
      }
      else
      {
         GXv_int10[15] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV56Diagnosticowwds_11_tfdiagnosticolongdesc_sel)==0) )
      {
         addWhere(sWhereString, "([DiagnosticoCodigo] + ' - ' + [DiagnosticoDescripcion] = ?)");
      }
      else
      {
         GXv_int10[16] = (byte)(1) ;
      }
      scmdbuf += sWhereString ;
      scmdbuf += " ORDER BY [DiagnosticoId]" ;
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
                  return conditional_P002V2(context, remoteHandle, httpContext, (String)dynConstraints[0] , (GXSimpleCollection<String>)dynConstraints[1] , (String)dynConstraints[2] , (GXSimpleCollection<String>)dynConstraints[3] , (String)dynConstraints[4] , ((Number) dynConstraints[5]).intValue() , ((Number) dynConstraints[6]).intValue() , (String)dynConstraints[7] , (String)dynConstraints[8] , (String)dynConstraints[9] , (String)dynConstraints[10] , ((Number) dynConstraints[11]).intValue() , ((Number) dynConstraints[12]).intValue() , (String)dynConstraints[13] , (String)dynConstraints[14] , ((Number) dynConstraints[15]).intValue() , (String)dynConstraints[16] , (String)dynConstraints[17] );
            case 1 :
                  return conditional_P002V3(context, remoteHandle, httpContext, (String)dynConstraints[0] , (GXSimpleCollection<String>)dynConstraints[1] , (String)dynConstraints[2] , (GXSimpleCollection<String>)dynConstraints[3] , (String)dynConstraints[4] , ((Number) dynConstraints[5]).intValue() , ((Number) dynConstraints[6]).intValue() , (String)dynConstraints[7] , (String)dynConstraints[8] , (String)dynConstraints[9] , (String)dynConstraints[10] , ((Number) dynConstraints[11]).intValue() , ((Number) dynConstraints[12]).intValue() , (String)dynConstraints[13] , (String)dynConstraints[14] , ((Number) dynConstraints[15]).intValue() , (String)dynConstraints[16] , (String)dynConstraints[17] );
            case 2 :
                  return conditional_P002V4(context, remoteHandle, httpContext, (String)dynConstraints[0] , (GXSimpleCollection<String>)dynConstraints[1] , (String)dynConstraints[2] , (GXSimpleCollection<String>)dynConstraints[3] , (String)dynConstraints[4] , ((Number) dynConstraints[5]).intValue() , ((Number) dynConstraints[6]).intValue() , (String)dynConstraints[7] , (String)dynConstraints[8] , (String)dynConstraints[9] , (String)dynConstraints[10] , ((Number) dynConstraints[11]).intValue() , ((Number) dynConstraints[12]).intValue() , (String)dynConstraints[13] , (String)dynConstraints[14] , ((Number) dynConstraints[15]).intValue() , (String)dynConstraints[16] , (String)dynConstraints[17] );
      }
      return super.getDynamicStatement(cursor, context, remoteHandle, httpContext, dynConstraints);
   }

   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P002V2", "scmdbuf",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("P002V3", "scmdbuf",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("P002V4", "scmdbuf",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
      };
   }

   public void getResults( int cursor ,
                           IFieldGetter rslt ,
                           Object[] buf ) throws SQLException
   {
      switch ( cursor )
      {
            case 0 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((String[]) buf[1])[0] = rslt.getString(2, 1);
               ((String[]) buf[2])[0] = rslt.getString(3, 1);
               ((String[]) buf[3])[0] = rslt.getVarchar(4);
               ((String[]) buf[4])[0] = rslt.getVarchar(5);
               return;
            case 1 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((String[]) buf[1])[0] = rslt.getString(2, 1);
               ((String[]) buf[2])[0] = rslt.getString(3, 1);
               ((String[]) buf[3])[0] = rslt.getVarchar(4);
               ((String[]) buf[4])[0] = rslt.getVarchar(5);
               return;
            case 2 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((String[]) buf[1])[0] = rslt.getString(2, 1);
               ((String[]) buf[2])[0] = rslt.getString(3, 1);
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
                  stmt.setVarchar(sIdx, (String)parms[24], 100);
               }
               if ( ((Number) parms[8]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[25], 100);
               }
               if ( ((Number) parms[9]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[26]).intValue());
               }
               if ( ((Number) parms[10]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[27]).intValue());
               }
               if ( ((Number) parms[11]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[28], 40);
               }
               if ( ((Number) parms[12]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[29], 40);
               }
               if ( ((Number) parms[13]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[30], 1000);
               }
               if ( ((Number) parms[14]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[31], 1000);
               }
               if ( ((Number) parms[15]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[32], 300);
               }
               if ( ((Number) parms[16]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[33], 300);
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
                  stmt.setVarchar(sIdx, (String)parms[24], 100);
               }
               if ( ((Number) parms[8]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[25], 100);
               }
               if ( ((Number) parms[9]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[26]).intValue());
               }
               if ( ((Number) parms[10]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[27]).intValue());
               }
               if ( ((Number) parms[11]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[28], 40);
               }
               if ( ((Number) parms[12]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[29], 40);
               }
               if ( ((Number) parms[13]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[30], 1000);
               }
               if ( ((Number) parms[14]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[31], 1000);
               }
               if ( ((Number) parms[15]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[32], 300);
               }
               if ( ((Number) parms[16]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[33], 300);
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
                  stmt.setVarchar(sIdx, (String)parms[24], 100);
               }
               if ( ((Number) parms[8]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[25], 100);
               }
               if ( ((Number) parms[9]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[26]).intValue());
               }
               if ( ((Number) parms[10]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[27]).intValue());
               }
               if ( ((Number) parms[11]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[28], 40);
               }
               if ( ((Number) parms[12]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[29], 40);
               }
               if ( ((Number) parms[13]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[30], 1000);
               }
               if ( ((Number) parms[14]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[31], 1000);
               }
               if ( ((Number) parms[15]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[32], 300);
               }
               if ( ((Number) parms[16]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[33], 300);
               }
               return;
      }
   }

}

