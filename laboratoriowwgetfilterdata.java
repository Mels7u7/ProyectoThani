package com.projectthani ;
import com.projectthani.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class laboratoriowwgetfilterdata extends GXProcedure
{
   public laboratoriowwgetfilterdata( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( laboratoriowwgetfilterdata.class ), "" );
   }

   public laboratoriowwgetfilterdata( int remoteHandle ,
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
      laboratoriowwgetfilterdata.this.aP5 = new String[] {""};
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
      laboratoriowwgetfilterdata.this.AV27DDOName = aP0;
      laboratoriowwgetfilterdata.this.AV25SearchTxt = aP1;
      laboratoriowwgetfilterdata.this.AV26SearchTxtTo = aP2;
      laboratoriowwgetfilterdata.this.aP3 = aP3;
      laboratoriowwgetfilterdata.this.aP4 = aP4;
      laboratoriowwgetfilterdata.this.aP5 = aP5;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      AV30Options = new GXSimpleCollection<String>(String.class, "internal", "") ;
      AV33OptionsDesc = new GXSimpleCollection<String>(String.class, "internal", "") ;
      AV35OptionIndexes = new GXSimpleCollection<String>(String.class, "internal", "") ;
      GXt_boolean1 = AV8IsAuthorized ;
      GXv_boolean2[0] = GXt_boolean1 ;
      new com.projectthani.wwpbaseobjects.secisauthbyfunctionalitykey(remoteHandle, context).execute( "WWLaboratorio", GXv_boolean2) ;
      laboratoriowwgetfilterdata.this.GXt_boolean1 = GXv_boolean2[0] ;
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
         if ( GXutil.strcmp(GXutil.upper( AV27DDOName), "DDO_LABORATORIONOMBRE") == 0 )
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
         else if ( GXutil.strcmp(GXutil.upper( AV27DDOName), "DDO_LABORATORIODESCRIPCION") == 0 )
         {
            /* Execute user subroutine: 'LOADLABORATORIODESCRIPCIONOPTIONS' */
            S131 ();
            if ( returnInSub )
            {
               returnInSub = true;
               cleanup();
               if (true) return;
            }
         }
         else if ( GXutil.strcmp(GXutil.upper( AV27DDOName), "DDO_LABORATORIONRODOCUMENTO") == 0 )
         {
            /* Execute user subroutine: 'LOADLABORATORIONRODOCUMENTOOPTIONS' */
            S141 ();
            if ( returnInSub )
            {
               returnInSub = true;
               cleanup();
               if (true) return;
            }
         }
      }
      AV31OptionsJson = AV30Options.toJSonString(false) ;
      AV34OptionsDescJson = AV33OptionsDesc.toJSonString(false) ;
      AV36OptionIndexesJson = AV35OptionIndexes.toJSonString(false) ;
      cleanup();
   }

   public void S111( )
   {
      /* 'LOADGRIDSTATE' Routine */
      returnInSub = false ;
      if ( GXutil.strcmp(AV38Session.getValue("LaboratorioWWGridState"), "") == 0 )
      {
         AV40GridState.fromxml(new com.projectthani.wwpbaseobjects.loadgridstate(remoteHandle, context).executeUdp( "LaboratorioWWGridState"), null, null);
      }
      else
      {
         AV40GridState.fromxml(AV38Session.getValue("LaboratorioWWGridState"), null, null);
      }
      AV46GXV1 = 1 ;
      while ( AV46GXV1 <= AV40GridState.getgxTv_SdtWWPGridState_Filtervalues().size() )
      {
         AV41GridStateFilterValue = (com.projectthani.wwpbaseobjects.SdtWWPGridState_FilterValue)((com.projectthani.wwpbaseobjects.SdtWWPGridState_FilterValue)AV40GridState.getgxTv_SdtWWPGridState_Filtervalues().elementAt(-1+AV46GXV1));
         if ( GXutil.strcmp(AV41GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "FILTERFULLTEXT") == 0 )
         {
            AV43FilterFullText = AV41GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV41GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFLABORATORIOID") == 0 )
         {
            AV11TFLaboratorioId = (short)(GXutil.lval( AV41GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value())) ;
            AV12TFLaboratorioId_To = (short)(GXutil.lval( AV41GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Valueto())) ;
         }
         else if ( GXutil.strcmp(AV41GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFLABORATORIONOMBRE") == 0 )
         {
            AV13TFLaboratorioNombre = AV41GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV41GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFLABORATORIONOMBRE_SEL") == 0 )
         {
            AV14TFLaboratorioNombre_Sel = AV41GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV41GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFLABORATORIODESCRIPCION") == 0 )
         {
            AV15TFLaboratorioDescripcion = AV41GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV41GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFLABORATORIODESCRIPCION_SEL") == 0 )
         {
            AV16TFLaboratorioDescripcion_Sel = AV41GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV41GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFLABORATORIOTIPODOCUMENTO_SEL") == 0 )
         {
            AV17TFLaboratorioTipoDocumento_SelsJson = AV41GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            AV18TFLaboratorioTipoDocumento_Sels.fromJSonString(AV17TFLaboratorioTipoDocumento_SelsJson, null);
         }
         else if ( GXutil.strcmp(AV41GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFLABORATORIONRODOCUMENTO") == 0 )
         {
            AV19TFLaboratorioNroDocumento = AV41GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV41GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFLABORATORIONRODOCUMENTO_SEL") == 0 )
         {
            AV20TFLaboratorioNroDocumento_Sel = AV41GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV41GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFLABORATORIOCOMISION") == 0 )
         {
            AV21TFLaboratorioComision = (short)(GXutil.lval( AV41GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value())) ;
            AV22TFLaboratorioComision_To = (short)(GXutil.lval( AV41GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Valueto())) ;
         }
         else if ( GXutil.strcmp(AV41GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFLABORATORIOESTADO_SEL") == 0 )
         {
            AV23TFLaboratorioEstado_SelsJson = AV41GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            AV24TFLaboratorioEstado_Sels.fromJSonString(AV23TFLaboratorioEstado_SelsJson, null);
         }
         AV46GXV1 = (int)(AV46GXV1+1) ;
      }
   }

   public void S121( )
   {
      /* 'LOADLABORATORIONOMBREOPTIONS' Routine */
      returnInSub = false ;
      AV13TFLaboratorioNombre = AV25SearchTxt ;
      AV14TFLaboratorioNombre_Sel = "" ;
      AV48Laboratoriowwds_1_filterfulltext = AV43FilterFullText ;
      AV49Laboratoriowwds_2_tflaboratorioid = AV11TFLaboratorioId ;
      AV50Laboratoriowwds_3_tflaboratorioid_to = AV12TFLaboratorioId_To ;
      AV51Laboratoriowwds_4_tflaboratorionombre = AV13TFLaboratorioNombre ;
      AV52Laboratoriowwds_5_tflaboratorionombre_sel = AV14TFLaboratorioNombre_Sel ;
      AV53Laboratoriowwds_6_tflaboratoriodescripcion = AV15TFLaboratorioDescripcion ;
      AV54Laboratoriowwds_7_tflaboratoriodescripcion_sel = AV16TFLaboratorioDescripcion_Sel ;
      AV55Laboratoriowwds_8_tflaboratoriotipodocumento_sels = AV18TFLaboratorioTipoDocumento_Sels ;
      AV56Laboratoriowwds_9_tflaboratorionrodocumento = AV19TFLaboratorioNroDocumento ;
      AV57Laboratoriowwds_10_tflaboratorionrodocumento_sel = AV20TFLaboratorioNroDocumento_Sel ;
      AV58Laboratoriowwds_11_tflaboratoriocomision = AV21TFLaboratorioComision ;
      AV59Laboratoriowwds_12_tflaboratoriocomision_to = AV22TFLaboratorioComision_To ;
      AV60Laboratoriowwds_13_tflaboratorioestado_sels = AV24TFLaboratorioEstado_Sels ;
      pr_default.dynParam(0, new Object[]{ new Object[]{
                                           A167LaboratorioTipoDocumento ,
                                           AV55Laboratoriowwds_8_tflaboratoriotipodocumento_sels ,
                                           A171LaboratorioEstado ,
                                           AV60Laboratoriowwds_13_tflaboratorioestado_sels ,
                                           AV48Laboratoriowwds_1_filterfulltext ,
                                           Short.valueOf(AV49Laboratoriowwds_2_tflaboratorioid) ,
                                           Short.valueOf(AV50Laboratoriowwds_3_tflaboratorioid_to) ,
                                           AV52Laboratoriowwds_5_tflaboratorionombre_sel ,
                                           AV51Laboratoriowwds_4_tflaboratorionombre ,
                                           AV54Laboratoriowwds_7_tflaboratoriodescripcion_sel ,
                                           AV53Laboratoriowwds_6_tflaboratoriodescripcion ,
                                           Integer.valueOf(AV55Laboratoriowwds_8_tflaboratoriotipodocumento_sels.size()) ,
                                           AV57Laboratoriowwds_10_tflaboratorionrodocumento_sel ,
                                           AV56Laboratoriowwds_9_tflaboratorionrodocumento ,
                                           Short.valueOf(AV58Laboratoriowwds_11_tflaboratoriocomision) ,
                                           Short.valueOf(AV59Laboratoriowwds_12_tflaboratoriocomision_to) ,
                                           Integer.valueOf(AV60Laboratoriowwds_13_tflaboratorioestado_sels.size()) ,
                                           Short.valueOf(A40LaboratorioId) ,
                                           A165LaboratorioNombre ,
                                           A166LaboratorioDescripcion ,
                                           A168LaboratorioNroDocumento ,
                                           Short.valueOf(A170LaboratorioComision) } ,
                                           new int[]{
                                           TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.SHORT, TypeConstants.SHORT, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.INT,
                                           TypeConstants.STRING, TypeConstants.STRING, TypeConstants.SHORT, TypeConstants.SHORT, TypeConstants.INT, TypeConstants.SHORT, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.SHORT
                                           }
      });
      lV48Laboratoriowwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV48Laboratoriowwds_1_filterfulltext), "%", "") ;
      lV48Laboratoriowwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV48Laboratoriowwds_1_filterfulltext), "%", "") ;
      lV48Laboratoriowwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV48Laboratoriowwds_1_filterfulltext), "%", "") ;
      lV48Laboratoriowwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV48Laboratoriowwds_1_filterfulltext), "%", "") ;
      lV48Laboratoriowwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV48Laboratoriowwds_1_filterfulltext), "%", "") ;
      lV48Laboratoriowwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV48Laboratoriowwds_1_filterfulltext), "%", "") ;
      lV48Laboratoriowwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV48Laboratoriowwds_1_filterfulltext), "%", "") ;
      lV48Laboratoriowwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV48Laboratoriowwds_1_filterfulltext), "%", "") ;
      lV48Laboratoriowwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV48Laboratoriowwds_1_filterfulltext), "%", "") ;
      lV51Laboratoriowwds_4_tflaboratorionombre = GXutil.concat( GXutil.rtrim( AV51Laboratoriowwds_4_tflaboratorionombre), "%", "") ;
      lV53Laboratoriowwds_6_tflaboratoriodescripcion = GXutil.concat( GXutil.rtrim( AV53Laboratoriowwds_6_tflaboratoriodescripcion), "%", "") ;
      lV56Laboratoriowwds_9_tflaboratorionrodocumento = GXutil.concat( GXutil.rtrim( AV56Laboratoriowwds_9_tflaboratorionrodocumento), "%", "") ;
      /* Using cursor P00362 */
      pr_default.execute(0, new Object[] {lV48Laboratoriowwds_1_filterfulltext, lV48Laboratoriowwds_1_filterfulltext, lV48Laboratoriowwds_1_filterfulltext, lV48Laboratoriowwds_1_filterfulltext, lV48Laboratoriowwds_1_filterfulltext, lV48Laboratoriowwds_1_filterfulltext, lV48Laboratoriowwds_1_filterfulltext, lV48Laboratoriowwds_1_filterfulltext, lV48Laboratoriowwds_1_filterfulltext, Short.valueOf(AV49Laboratoriowwds_2_tflaboratorioid), Short.valueOf(AV50Laboratoriowwds_3_tflaboratorioid_to), lV51Laboratoriowwds_4_tflaboratorionombre, AV52Laboratoriowwds_5_tflaboratorionombre_sel, lV53Laboratoriowwds_6_tflaboratoriodescripcion, AV54Laboratoriowwds_7_tflaboratoriodescripcion_sel, lV56Laboratoriowwds_9_tflaboratorionrodocumento, AV57Laboratoriowwds_10_tflaboratorionrodocumento_sel, Short.valueOf(AV58Laboratoriowwds_11_tflaboratoriocomision), Short.valueOf(AV59Laboratoriowwds_12_tflaboratoriocomision_to)});
      while ( (pr_default.getStatus(0) != 101) )
      {
         brk362 = false ;
         A165LaboratorioNombre = P00362_A165LaboratorioNombre[0] ;
         A170LaboratorioComision = P00362_A170LaboratorioComision[0] ;
         A40LaboratorioId = P00362_A40LaboratorioId[0] ;
         A171LaboratorioEstado = P00362_A171LaboratorioEstado[0] ;
         A168LaboratorioNroDocumento = P00362_A168LaboratorioNroDocumento[0] ;
         A167LaboratorioTipoDocumento = P00362_A167LaboratorioTipoDocumento[0] ;
         A166LaboratorioDescripcion = P00362_A166LaboratorioDescripcion[0] ;
         AV37count = 0 ;
         while ( (pr_default.getStatus(0) != 101) && ( GXutil.strcmp(P00362_A165LaboratorioNombre[0], A165LaboratorioNombre) == 0 ) )
         {
            brk362 = false ;
            A40LaboratorioId = P00362_A40LaboratorioId[0] ;
            AV37count = (long)(AV37count+1) ;
            brk362 = true ;
            pr_default.readNext(0);
         }
         if ( ! (GXutil.strcmp("", A165LaboratorioNombre)==0) )
         {
            AV29Option = A165LaboratorioNombre ;
            AV30Options.add(AV29Option, 0);
            AV35OptionIndexes.add(GXutil.trim( localUtil.format( DecimalUtil.doubleToDec(AV37count), "Z,ZZZ,ZZZ,ZZ9")), 0);
         }
         if ( AV30Options.size() == 50 )
         {
            /* Exit For each command. Update data (if necessary), close cursors & exit. */
            if (true) break;
         }
         if ( ! brk362 )
         {
            brk362 = true ;
            pr_default.readNext(0);
         }
      }
      pr_default.close(0);
   }

   public void S131( )
   {
      /* 'LOADLABORATORIODESCRIPCIONOPTIONS' Routine */
      returnInSub = false ;
      AV15TFLaboratorioDescripcion = AV25SearchTxt ;
      AV16TFLaboratorioDescripcion_Sel = "" ;
      AV48Laboratoriowwds_1_filterfulltext = AV43FilterFullText ;
      AV49Laboratoriowwds_2_tflaboratorioid = AV11TFLaboratorioId ;
      AV50Laboratoriowwds_3_tflaboratorioid_to = AV12TFLaboratorioId_To ;
      AV51Laboratoriowwds_4_tflaboratorionombre = AV13TFLaboratorioNombre ;
      AV52Laboratoriowwds_5_tflaboratorionombre_sel = AV14TFLaboratorioNombre_Sel ;
      AV53Laboratoriowwds_6_tflaboratoriodescripcion = AV15TFLaboratorioDescripcion ;
      AV54Laboratoriowwds_7_tflaboratoriodescripcion_sel = AV16TFLaboratorioDescripcion_Sel ;
      AV55Laboratoriowwds_8_tflaboratoriotipodocumento_sels = AV18TFLaboratorioTipoDocumento_Sels ;
      AV56Laboratoriowwds_9_tflaboratorionrodocumento = AV19TFLaboratorioNroDocumento ;
      AV57Laboratoriowwds_10_tflaboratorionrodocumento_sel = AV20TFLaboratorioNroDocumento_Sel ;
      AV58Laboratoriowwds_11_tflaboratoriocomision = AV21TFLaboratorioComision ;
      AV59Laboratoriowwds_12_tflaboratoriocomision_to = AV22TFLaboratorioComision_To ;
      AV60Laboratoriowwds_13_tflaboratorioestado_sels = AV24TFLaboratorioEstado_Sels ;
      pr_default.dynParam(1, new Object[]{ new Object[]{
                                           A167LaboratorioTipoDocumento ,
                                           AV55Laboratoriowwds_8_tflaboratoriotipodocumento_sels ,
                                           A171LaboratorioEstado ,
                                           AV60Laboratoriowwds_13_tflaboratorioestado_sels ,
                                           AV48Laboratoriowwds_1_filterfulltext ,
                                           Short.valueOf(AV49Laboratoriowwds_2_tflaboratorioid) ,
                                           Short.valueOf(AV50Laboratoriowwds_3_tflaboratorioid_to) ,
                                           AV52Laboratoriowwds_5_tflaboratorionombre_sel ,
                                           AV51Laboratoriowwds_4_tflaboratorionombre ,
                                           AV54Laboratoriowwds_7_tflaboratoriodescripcion_sel ,
                                           AV53Laboratoriowwds_6_tflaboratoriodescripcion ,
                                           Integer.valueOf(AV55Laboratoriowwds_8_tflaboratoriotipodocumento_sels.size()) ,
                                           AV57Laboratoriowwds_10_tflaboratorionrodocumento_sel ,
                                           AV56Laboratoriowwds_9_tflaboratorionrodocumento ,
                                           Short.valueOf(AV58Laboratoriowwds_11_tflaboratoriocomision) ,
                                           Short.valueOf(AV59Laboratoriowwds_12_tflaboratoriocomision_to) ,
                                           Integer.valueOf(AV60Laboratoriowwds_13_tflaboratorioestado_sels.size()) ,
                                           Short.valueOf(A40LaboratorioId) ,
                                           A165LaboratorioNombre ,
                                           A166LaboratorioDescripcion ,
                                           A168LaboratorioNroDocumento ,
                                           Short.valueOf(A170LaboratorioComision) } ,
                                           new int[]{
                                           TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.SHORT, TypeConstants.SHORT, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.INT,
                                           TypeConstants.STRING, TypeConstants.STRING, TypeConstants.SHORT, TypeConstants.SHORT, TypeConstants.INT, TypeConstants.SHORT, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.SHORT
                                           }
      });
      lV48Laboratoriowwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV48Laboratoriowwds_1_filterfulltext), "%", "") ;
      lV48Laboratoriowwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV48Laboratoriowwds_1_filterfulltext), "%", "") ;
      lV48Laboratoriowwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV48Laboratoriowwds_1_filterfulltext), "%", "") ;
      lV48Laboratoriowwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV48Laboratoriowwds_1_filterfulltext), "%", "") ;
      lV48Laboratoriowwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV48Laboratoriowwds_1_filterfulltext), "%", "") ;
      lV48Laboratoriowwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV48Laboratoriowwds_1_filterfulltext), "%", "") ;
      lV48Laboratoriowwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV48Laboratoriowwds_1_filterfulltext), "%", "") ;
      lV48Laboratoriowwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV48Laboratoriowwds_1_filterfulltext), "%", "") ;
      lV48Laboratoriowwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV48Laboratoriowwds_1_filterfulltext), "%", "") ;
      lV51Laboratoriowwds_4_tflaboratorionombre = GXutil.concat( GXutil.rtrim( AV51Laboratoriowwds_4_tflaboratorionombre), "%", "") ;
      lV53Laboratoriowwds_6_tflaboratoriodescripcion = GXutil.concat( GXutil.rtrim( AV53Laboratoriowwds_6_tflaboratoriodescripcion), "%", "") ;
      lV56Laboratoriowwds_9_tflaboratorionrodocumento = GXutil.concat( GXutil.rtrim( AV56Laboratoriowwds_9_tflaboratorionrodocumento), "%", "") ;
      /* Using cursor P00363 */
      pr_default.execute(1, new Object[] {lV48Laboratoriowwds_1_filterfulltext, lV48Laboratoriowwds_1_filterfulltext, lV48Laboratoriowwds_1_filterfulltext, lV48Laboratoriowwds_1_filterfulltext, lV48Laboratoriowwds_1_filterfulltext, lV48Laboratoriowwds_1_filterfulltext, lV48Laboratoriowwds_1_filterfulltext, lV48Laboratoriowwds_1_filterfulltext, lV48Laboratoriowwds_1_filterfulltext, Short.valueOf(AV49Laboratoriowwds_2_tflaboratorioid), Short.valueOf(AV50Laboratoriowwds_3_tflaboratorioid_to), lV51Laboratoriowwds_4_tflaboratorionombre, AV52Laboratoriowwds_5_tflaboratorionombre_sel, lV53Laboratoriowwds_6_tflaboratoriodescripcion, AV54Laboratoriowwds_7_tflaboratoriodescripcion_sel, lV56Laboratoriowwds_9_tflaboratorionrodocumento, AV57Laboratoriowwds_10_tflaboratorionrodocumento_sel, Short.valueOf(AV58Laboratoriowwds_11_tflaboratoriocomision), Short.valueOf(AV59Laboratoriowwds_12_tflaboratoriocomision_to)});
      while ( (pr_default.getStatus(1) != 101) )
      {
         brk364 = false ;
         A166LaboratorioDescripcion = P00363_A166LaboratorioDescripcion[0] ;
         A170LaboratorioComision = P00363_A170LaboratorioComision[0] ;
         A40LaboratorioId = P00363_A40LaboratorioId[0] ;
         A171LaboratorioEstado = P00363_A171LaboratorioEstado[0] ;
         A168LaboratorioNroDocumento = P00363_A168LaboratorioNroDocumento[0] ;
         A167LaboratorioTipoDocumento = P00363_A167LaboratorioTipoDocumento[0] ;
         A165LaboratorioNombre = P00363_A165LaboratorioNombre[0] ;
         AV37count = 0 ;
         while ( (pr_default.getStatus(1) != 101) && ( GXutil.strcmp(P00363_A166LaboratorioDescripcion[0], A166LaboratorioDescripcion) == 0 ) )
         {
            brk364 = false ;
            A40LaboratorioId = P00363_A40LaboratorioId[0] ;
            AV37count = (long)(AV37count+1) ;
            brk364 = true ;
            pr_default.readNext(1);
         }
         if ( ! (GXutil.strcmp("", A166LaboratorioDescripcion)==0) )
         {
            AV29Option = A166LaboratorioDescripcion ;
            AV30Options.add(AV29Option, 0);
            AV35OptionIndexes.add(GXutil.trim( localUtil.format( DecimalUtil.doubleToDec(AV37count), "Z,ZZZ,ZZZ,ZZ9")), 0);
         }
         if ( AV30Options.size() == 50 )
         {
            /* Exit For each command. Update data (if necessary), close cursors & exit. */
            if (true) break;
         }
         if ( ! brk364 )
         {
            brk364 = true ;
            pr_default.readNext(1);
         }
      }
      pr_default.close(1);
   }

   public void S141( )
   {
      /* 'LOADLABORATORIONRODOCUMENTOOPTIONS' Routine */
      returnInSub = false ;
      AV19TFLaboratorioNroDocumento = AV25SearchTxt ;
      AV20TFLaboratorioNroDocumento_Sel = "" ;
      AV48Laboratoriowwds_1_filterfulltext = AV43FilterFullText ;
      AV49Laboratoriowwds_2_tflaboratorioid = AV11TFLaboratorioId ;
      AV50Laboratoriowwds_3_tflaboratorioid_to = AV12TFLaboratorioId_To ;
      AV51Laboratoriowwds_4_tflaboratorionombre = AV13TFLaboratorioNombre ;
      AV52Laboratoriowwds_5_tflaboratorionombre_sel = AV14TFLaboratorioNombre_Sel ;
      AV53Laboratoriowwds_6_tflaboratoriodescripcion = AV15TFLaboratorioDescripcion ;
      AV54Laboratoriowwds_7_tflaboratoriodescripcion_sel = AV16TFLaboratorioDescripcion_Sel ;
      AV55Laboratoriowwds_8_tflaboratoriotipodocumento_sels = AV18TFLaboratorioTipoDocumento_Sels ;
      AV56Laboratoriowwds_9_tflaboratorionrodocumento = AV19TFLaboratorioNroDocumento ;
      AV57Laboratoriowwds_10_tflaboratorionrodocumento_sel = AV20TFLaboratorioNroDocumento_Sel ;
      AV58Laboratoriowwds_11_tflaboratoriocomision = AV21TFLaboratorioComision ;
      AV59Laboratoriowwds_12_tflaboratoriocomision_to = AV22TFLaboratorioComision_To ;
      AV60Laboratoriowwds_13_tflaboratorioestado_sels = AV24TFLaboratorioEstado_Sels ;
      pr_default.dynParam(2, new Object[]{ new Object[]{
                                           A167LaboratorioTipoDocumento ,
                                           AV55Laboratoriowwds_8_tflaboratoriotipodocumento_sels ,
                                           A171LaboratorioEstado ,
                                           AV60Laboratoriowwds_13_tflaboratorioestado_sels ,
                                           AV48Laboratoriowwds_1_filterfulltext ,
                                           Short.valueOf(AV49Laboratoriowwds_2_tflaboratorioid) ,
                                           Short.valueOf(AV50Laboratoriowwds_3_tflaboratorioid_to) ,
                                           AV52Laboratoriowwds_5_tflaboratorionombre_sel ,
                                           AV51Laboratoriowwds_4_tflaboratorionombre ,
                                           AV54Laboratoriowwds_7_tflaboratoriodescripcion_sel ,
                                           AV53Laboratoriowwds_6_tflaboratoriodescripcion ,
                                           Integer.valueOf(AV55Laboratoriowwds_8_tflaboratoriotipodocumento_sels.size()) ,
                                           AV57Laboratoriowwds_10_tflaboratorionrodocumento_sel ,
                                           AV56Laboratoriowwds_9_tflaboratorionrodocumento ,
                                           Short.valueOf(AV58Laboratoriowwds_11_tflaboratoriocomision) ,
                                           Short.valueOf(AV59Laboratoriowwds_12_tflaboratoriocomision_to) ,
                                           Integer.valueOf(AV60Laboratoriowwds_13_tflaboratorioestado_sels.size()) ,
                                           Short.valueOf(A40LaboratorioId) ,
                                           A165LaboratorioNombre ,
                                           A166LaboratorioDescripcion ,
                                           A168LaboratorioNroDocumento ,
                                           Short.valueOf(A170LaboratorioComision) } ,
                                           new int[]{
                                           TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.SHORT, TypeConstants.SHORT, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.INT,
                                           TypeConstants.STRING, TypeConstants.STRING, TypeConstants.SHORT, TypeConstants.SHORT, TypeConstants.INT, TypeConstants.SHORT, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.SHORT
                                           }
      });
      lV48Laboratoriowwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV48Laboratoriowwds_1_filterfulltext), "%", "") ;
      lV48Laboratoriowwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV48Laboratoriowwds_1_filterfulltext), "%", "") ;
      lV48Laboratoriowwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV48Laboratoriowwds_1_filterfulltext), "%", "") ;
      lV48Laboratoriowwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV48Laboratoriowwds_1_filterfulltext), "%", "") ;
      lV48Laboratoriowwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV48Laboratoriowwds_1_filterfulltext), "%", "") ;
      lV48Laboratoriowwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV48Laboratoriowwds_1_filterfulltext), "%", "") ;
      lV48Laboratoriowwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV48Laboratoriowwds_1_filterfulltext), "%", "") ;
      lV48Laboratoriowwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV48Laboratoriowwds_1_filterfulltext), "%", "") ;
      lV48Laboratoriowwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV48Laboratoriowwds_1_filterfulltext), "%", "") ;
      lV51Laboratoriowwds_4_tflaboratorionombre = GXutil.concat( GXutil.rtrim( AV51Laboratoriowwds_4_tflaboratorionombre), "%", "") ;
      lV53Laboratoriowwds_6_tflaboratoriodescripcion = GXutil.concat( GXutil.rtrim( AV53Laboratoriowwds_6_tflaboratoriodescripcion), "%", "") ;
      lV56Laboratoriowwds_9_tflaboratorionrodocumento = GXutil.concat( GXutil.rtrim( AV56Laboratoriowwds_9_tflaboratorionrodocumento), "%", "") ;
      /* Using cursor P00364 */
      pr_default.execute(2, new Object[] {lV48Laboratoriowwds_1_filterfulltext, lV48Laboratoriowwds_1_filterfulltext, lV48Laboratoriowwds_1_filterfulltext, lV48Laboratoriowwds_1_filterfulltext, lV48Laboratoriowwds_1_filterfulltext, lV48Laboratoriowwds_1_filterfulltext, lV48Laboratoriowwds_1_filterfulltext, lV48Laboratoriowwds_1_filterfulltext, lV48Laboratoriowwds_1_filterfulltext, Short.valueOf(AV49Laboratoriowwds_2_tflaboratorioid), Short.valueOf(AV50Laboratoriowwds_3_tflaboratorioid_to), lV51Laboratoriowwds_4_tflaboratorionombre, AV52Laboratoriowwds_5_tflaboratorionombre_sel, lV53Laboratoriowwds_6_tflaboratoriodescripcion, AV54Laboratoriowwds_7_tflaboratoriodescripcion_sel, lV56Laboratoriowwds_9_tflaboratorionrodocumento, AV57Laboratoriowwds_10_tflaboratorionrodocumento_sel, Short.valueOf(AV58Laboratoriowwds_11_tflaboratoriocomision), Short.valueOf(AV59Laboratoriowwds_12_tflaboratoriocomision_to)});
      while ( (pr_default.getStatus(2) != 101) )
      {
         brk366 = false ;
         A168LaboratorioNroDocumento = P00364_A168LaboratorioNroDocumento[0] ;
         A170LaboratorioComision = P00364_A170LaboratorioComision[0] ;
         A40LaboratorioId = P00364_A40LaboratorioId[0] ;
         A171LaboratorioEstado = P00364_A171LaboratorioEstado[0] ;
         A167LaboratorioTipoDocumento = P00364_A167LaboratorioTipoDocumento[0] ;
         A166LaboratorioDescripcion = P00364_A166LaboratorioDescripcion[0] ;
         A165LaboratorioNombre = P00364_A165LaboratorioNombre[0] ;
         AV37count = 0 ;
         while ( (pr_default.getStatus(2) != 101) && ( GXutil.strcmp(P00364_A168LaboratorioNroDocumento[0], A168LaboratorioNroDocumento) == 0 ) )
         {
            brk366 = false ;
            A40LaboratorioId = P00364_A40LaboratorioId[0] ;
            AV37count = (long)(AV37count+1) ;
            brk366 = true ;
            pr_default.readNext(2);
         }
         if ( ! (GXutil.strcmp("", A168LaboratorioNroDocumento)==0) )
         {
            AV29Option = A168LaboratorioNroDocumento ;
            AV30Options.add(AV29Option, 0);
            AV35OptionIndexes.add(GXutil.trim( localUtil.format( DecimalUtil.doubleToDec(AV37count), "Z,ZZZ,ZZZ,ZZ9")), 0);
         }
         if ( AV30Options.size() == 50 )
         {
            /* Exit For each command. Update data (if necessary), close cursors & exit. */
            if (true) break;
         }
         if ( ! brk366 )
         {
            brk366 = true ;
            pr_default.readNext(2);
         }
      }
      pr_default.close(2);
   }

   protected void cleanup( )
   {
      this.aP3[0] = laboratoriowwgetfilterdata.this.AV31OptionsJson;
      this.aP4[0] = laboratoriowwgetfilterdata.this.AV34OptionsDescJson;
      this.aP5[0] = laboratoriowwgetfilterdata.this.AV36OptionIndexesJson;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV31OptionsJson = "" ;
      AV34OptionsDescJson = "" ;
      AV36OptionIndexesJson = "" ;
      AV30Options = new GXSimpleCollection<String>(String.class, "internal", "");
      AV33OptionsDesc = new GXSimpleCollection<String>(String.class, "internal", "");
      AV35OptionIndexes = new GXSimpleCollection<String>(String.class, "internal", "");
      GXv_boolean2 = new boolean[1] ;
      AV9WWPContext = new com.projectthani.wwpbaseobjects.SdtWWPContext(remoteHandle, context);
      GXv_SdtWWPContext3 = new com.projectthani.wwpbaseobjects.SdtWWPContext[1] ;
      AV38Session = httpContext.getWebSession();
      AV40GridState = new com.projectthani.wwpbaseobjects.SdtWWPGridState(remoteHandle, context);
      AV41GridStateFilterValue = new com.projectthani.wwpbaseobjects.SdtWWPGridState_FilterValue(remoteHandle, context);
      AV43FilterFullText = "" ;
      AV13TFLaboratorioNombre = "" ;
      AV14TFLaboratorioNombre_Sel = "" ;
      AV15TFLaboratorioDescripcion = "" ;
      AV16TFLaboratorioDescripcion_Sel = "" ;
      AV17TFLaboratorioTipoDocumento_SelsJson = "" ;
      AV18TFLaboratorioTipoDocumento_Sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV19TFLaboratorioNroDocumento = "" ;
      AV20TFLaboratorioNroDocumento_Sel = "" ;
      AV23TFLaboratorioEstado_SelsJson = "" ;
      AV24TFLaboratorioEstado_Sels = new GXSimpleCollection<String>(String.class, "internal", "");
      A165LaboratorioNombre = "" ;
      AV48Laboratoriowwds_1_filterfulltext = "" ;
      AV51Laboratoriowwds_4_tflaboratorionombre = "" ;
      AV52Laboratoriowwds_5_tflaboratorionombre_sel = "" ;
      AV53Laboratoriowwds_6_tflaboratoriodescripcion = "" ;
      AV54Laboratoriowwds_7_tflaboratoriodescripcion_sel = "" ;
      AV55Laboratoriowwds_8_tflaboratoriotipodocumento_sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV56Laboratoriowwds_9_tflaboratorionrodocumento = "" ;
      AV57Laboratoriowwds_10_tflaboratorionrodocumento_sel = "" ;
      AV60Laboratoriowwds_13_tflaboratorioestado_sels = new GXSimpleCollection<String>(String.class, "internal", "");
      scmdbuf = "" ;
      lV48Laboratoriowwds_1_filterfulltext = "" ;
      lV51Laboratoriowwds_4_tflaboratorionombre = "" ;
      lV53Laboratoriowwds_6_tflaboratoriodescripcion = "" ;
      lV56Laboratoriowwds_9_tflaboratorionrodocumento = "" ;
      A167LaboratorioTipoDocumento = "" ;
      A171LaboratorioEstado = "" ;
      A166LaboratorioDescripcion = "" ;
      A168LaboratorioNroDocumento = "" ;
      P00362_A165LaboratorioNombre = new String[] {""} ;
      P00362_A170LaboratorioComision = new short[1] ;
      P00362_A40LaboratorioId = new short[1] ;
      P00362_A171LaboratorioEstado = new String[] {""} ;
      P00362_A168LaboratorioNroDocumento = new String[] {""} ;
      P00362_A167LaboratorioTipoDocumento = new String[] {""} ;
      P00362_A166LaboratorioDescripcion = new String[] {""} ;
      AV29Option = "" ;
      P00363_A166LaboratorioDescripcion = new String[] {""} ;
      P00363_A170LaboratorioComision = new short[1] ;
      P00363_A40LaboratorioId = new short[1] ;
      P00363_A171LaboratorioEstado = new String[] {""} ;
      P00363_A168LaboratorioNroDocumento = new String[] {""} ;
      P00363_A167LaboratorioTipoDocumento = new String[] {""} ;
      P00363_A165LaboratorioNombre = new String[] {""} ;
      P00364_A168LaboratorioNroDocumento = new String[] {""} ;
      P00364_A170LaboratorioComision = new short[1] ;
      P00364_A40LaboratorioId = new short[1] ;
      P00364_A171LaboratorioEstado = new String[] {""} ;
      P00364_A167LaboratorioTipoDocumento = new String[] {""} ;
      P00364_A166LaboratorioDescripcion = new String[] {""} ;
      P00364_A165LaboratorioNombre = new String[] {""} ;
      pr_default = new DataStoreProvider(context, remoteHandle, new com.projectthani.laboratoriowwgetfilterdata__default(),
         new Object[] {
             new Object[] {
            P00362_A165LaboratorioNombre, P00362_A170LaboratorioComision, P00362_A40LaboratorioId, P00362_A171LaboratorioEstado, P00362_A168LaboratorioNroDocumento, P00362_A167LaboratorioTipoDocumento, P00362_A166LaboratorioDescripcion
            }
            , new Object[] {
            P00363_A166LaboratorioDescripcion, P00363_A170LaboratorioComision, P00363_A40LaboratorioId, P00363_A171LaboratorioEstado, P00363_A168LaboratorioNroDocumento, P00363_A167LaboratorioTipoDocumento, P00363_A165LaboratorioNombre
            }
            , new Object[] {
            P00364_A168LaboratorioNroDocumento, P00364_A170LaboratorioComision, P00364_A40LaboratorioId, P00364_A171LaboratorioEstado, P00364_A167LaboratorioTipoDocumento, P00364_A166LaboratorioDescripcion, P00364_A165LaboratorioNombre
            }
         }
      );
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private short AV11TFLaboratorioId ;
   private short AV12TFLaboratorioId_To ;
   private short AV21TFLaboratorioComision ;
   private short AV22TFLaboratorioComision_To ;
   private short AV49Laboratoriowwds_2_tflaboratorioid ;
   private short AV50Laboratoriowwds_3_tflaboratorioid_to ;
   private short AV58Laboratoriowwds_11_tflaboratoriocomision ;
   private short AV59Laboratoriowwds_12_tflaboratoriocomision_to ;
   private short A40LaboratorioId ;
   private short A170LaboratorioComision ;
   private short Gx_err ;
   private int AV46GXV1 ;
   private int AV55Laboratoriowwds_8_tflaboratoriotipodocumento_sels_size ;
   private int AV60Laboratoriowwds_13_tflaboratorioestado_sels_size ;
   private long AV37count ;
   private String scmdbuf ;
   private String A167LaboratorioTipoDocumento ;
   private String A171LaboratorioEstado ;
   private boolean AV8IsAuthorized ;
   private boolean GXt_boolean1 ;
   private boolean GXv_boolean2[] ;
   private boolean returnInSub ;
   private boolean brk362 ;
   private boolean brk364 ;
   private boolean brk366 ;
   private String AV31OptionsJson ;
   private String AV34OptionsDescJson ;
   private String AV36OptionIndexesJson ;
   private String AV17TFLaboratorioTipoDocumento_SelsJson ;
   private String AV23TFLaboratorioEstado_SelsJson ;
   private String AV27DDOName ;
   private String AV25SearchTxt ;
   private String AV26SearchTxtTo ;
   private String AV43FilterFullText ;
   private String AV13TFLaboratorioNombre ;
   private String AV14TFLaboratorioNombre_Sel ;
   private String AV15TFLaboratorioDescripcion ;
   private String AV16TFLaboratorioDescripcion_Sel ;
   private String AV19TFLaboratorioNroDocumento ;
   private String AV20TFLaboratorioNroDocumento_Sel ;
   private String A165LaboratorioNombre ;
   private String AV48Laboratoriowwds_1_filterfulltext ;
   private String AV51Laboratoriowwds_4_tflaboratorionombre ;
   private String AV52Laboratoriowwds_5_tflaboratorionombre_sel ;
   private String AV53Laboratoriowwds_6_tflaboratoriodescripcion ;
   private String AV54Laboratoriowwds_7_tflaboratoriodescripcion_sel ;
   private String AV56Laboratoriowwds_9_tflaboratorionrodocumento ;
   private String AV57Laboratoriowwds_10_tflaboratorionrodocumento_sel ;
   private String lV48Laboratoriowwds_1_filterfulltext ;
   private String lV51Laboratoriowwds_4_tflaboratorionombre ;
   private String lV53Laboratoriowwds_6_tflaboratoriodescripcion ;
   private String lV56Laboratoriowwds_9_tflaboratorionrodocumento ;
   private String A166LaboratorioDescripcion ;
   private String A168LaboratorioNroDocumento ;
   private String AV29Option ;
   private com.genexus.webpanels.WebSession AV38Session ;
   private String[] aP5 ;
   private String[] aP3 ;
   private String[] aP4 ;
   private IDataStoreProvider pr_default ;
   private String[] P00362_A165LaboratorioNombre ;
   private short[] P00362_A170LaboratorioComision ;
   private short[] P00362_A40LaboratorioId ;
   private String[] P00362_A171LaboratorioEstado ;
   private String[] P00362_A168LaboratorioNroDocumento ;
   private String[] P00362_A167LaboratorioTipoDocumento ;
   private String[] P00362_A166LaboratorioDescripcion ;
   private String[] P00363_A166LaboratorioDescripcion ;
   private short[] P00363_A170LaboratorioComision ;
   private short[] P00363_A40LaboratorioId ;
   private String[] P00363_A171LaboratorioEstado ;
   private String[] P00363_A168LaboratorioNroDocumento ;
   private String[] P00363_A167LaboratorioTipoDocumento ;
   private String[] P00363_A165LaboratorioNombre ;
   private String[] P00364_A168LaboratorioNroDocumento ;
   private short[] P00364_A170LaboratorioComision ;
   private short[] P00364_A40LaboratorioId ;
   private String[] P00364_A171LaboratorioEstado ;
   private String[] P00364_A167LaboratorioTipoDocumento ;
   private String[] P00364_A166LaboratorioDescripcion ;
   private String[] P00364_A165LaboratorioNombre ;
   private GXSimpleCollection<String> AV18TFLaboratorioTipoDocumento_Sels ;
   private GXSimpleCollection<String> AV24TFLaboratorioEstado_Sels ;
   private GXSimpleCollection<String> AV55Laboratoriowwds_8_tflaboratoriotipodocumento_sels ;
   private GXSimpleCollection<String> AV60Laboratoriowwds_13_tflaboratorioestado_sels ;
   private GXSimpleCollection<String> AV30Options ;
   private GXSimpleCollection<String> AV33OptionsDesc ;
   private GXSimpleCollection<String> AV35OptionIndexes ;
   private com.projectthani.wwpbaseobjects.SdtWWPContext AV9WWPContext ;
   private com.projectthani.wwpbaseobjects.SdtWWPContext GXv_SdtWWPContext3[] ;
   private com.projectthani.wwpbaseobjects.SdtWWPGridState AV40GridState ;
   private com.projectthani.wwpbaseobjects.SdtWWPGridState_FilterValue AV41GridStateFilterValue ;
}

final  class laboratoriowwgetfilterdata__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   protected Object[] conditional_P00362( ModelContext context ,
                                          int remoteHandle ,
                                          com.genexus.IHttpContext httpContext ,
                                          String A167LaboratorioTipoDocumento ,
                                          GXSimpleCollection<String> AV55Laboratoriowwds_8_tflaboratoriotipodocumento_sels ,
                                          String A171LaboratorioEstado ,
                                          GXSimpleCollection<String> AV60Laboratoriowwds_13_tflaboratorioestado_sels ,
                                          String AV48Laboratoriowwds_1_filterfulltext ,
                                          short AV49Laboratoriowwds_2_tflaboratorioid ,
                                          short AV50Laboratoriowwds_3_tflaboratorioid_to ,
                                          String AV52Laboratoriowwds_5_tflaboratorionombre_sel ,
                                          String AV51Laboratoriowwds_4_tflaboratorionombre ,
                                          String AV54Laboratoriowwds_7_tflaboratoriodescripcion_sel ,
                                          String AV53Laboratoriowwds_6_tflaboratoriodescripcion ,
                                          int AV55Laboratoriowwds_8_tflaboratoriotipodocumento_sels_size ,
                                          String AV57Laboratoriowwds_10_tflaboratorionrodocumento_sel ,
                                          String AV56Laboratoriowwds_9_tflaboratorionrodocumento ,
                                          short AV58Laboratoriowwds_11_tflaboratoriocomision ,
                                          short AV59Laboratoriowwds_12_tflaboratoriocomision_to ,
                                          int AV60Laboratoriowwds_13_tflaboratorioestado_sels_size ,
                                          short A40LaboratorioId ,
                                          String A165LaboratorioNombre ,
                                          String A166LaboratorioDescripcion ,
                                          String A168LaboratorioNroDocumento ,
                                          short A170LaboratorioComision )
   {
      java.lang.StringBuffer sWhereString = new java.lang.StringBuffer();
      String scmdbuf;
      byte[] GXv_int4 = new byte[19];
      Object[] GXv_Object5 = new Object[2];
      scmdbuf = "SELECT [LaboratorioNombre], [LaboratorioComision], [LaboratorioId], [LaboratorioEstado], [LaboratorioNroDocumento], [LaboratorioTipoDocumento], [LaboratorioDescripcion]" ;
      scmdbuf += " FROM [Laboratorio]" ;
      if ( ! (GXutil.strcmp("", AV48Laboratoriowwds_1_filterfulltext)==0) )
      {
         addWhere(sWhereString, "(( CONVERT( char(4), CAST([LaboratorioId] AS decimal(4,0))) like '%' + ?) or ( [LaboratorioNombre] like '%' + ?) or ( [LaboratorioDescripcion] like '%' + ?) or ( 'ruc' like '%' + LOWER(?) and [LaboratorioTipoDocumento] = '6') or ( 'dni' like '%' + LOWER(?) and [LaboratorioTipoDocumento] = '1') or ( [LaboratorioNroDocumento] like '%' + ?) or ( CONVERT( char(4), CAST([LaboratorioComision] AS decimal(4,0))) like '%' + ?) or ( 'activo' like '%' + LOWER(?) and [LaboratorioEstado] = 'A') or ( 'inactivo' like '%' + LOWER(?) and [LaboratorioEstado] = 'I'))");
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
      if ( ! (0==AV49Laboratoriowwds_2_tflaboratorioid) )
      {
         addWhere(sWhereString, "([LaboratorioId] >= ?)");
      }
      else
      {
         GXv_int4[9] = (byte)(1) ;
      }
      if ( ! (0==AV50Laboratoriowwds_3_tflaboratorioid_to) )
      {
         addWhere(sWhereString, "([LaboratorioId] <= ?)");
      }
      else
      {
         GXv_int4[10] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV52Laboratoriowwds_5_tflaboratorionombre_sel)==0) && ( ! (GXutil.strcmp("", AV51Laboratoriowwds_4_tflaboratorionombre)==0) ) )
      {
         addWhere(sWhereString, "([LaboratorioNombre] like ?)");
      }
      else
      {
         GXv_int4[11] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV52Laboratoriowwds_5_tflaboratorionombre_sel)==0) )
      {
         addWhere(sWhereString, "([LaboratorioNombre] = ?)");
      }
      else
      {
         GXv_int4[12] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV54Laboratoriowwds_7_tflaboratoriodescripcion_sel)==0) && ( ! (GXutil.strcmp("", AV53Laboratoriowwds_6_tflaboratoriodescripcion)==0) ) )
      {
         addWhere(sWhereString, "([LaboratorioDescripcion] like ?)");
      }
      else
      {
         GXv_int4[13] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV54Laboratoriowwds_7_tflaboratoriodescripcion_sel)==0) )
      {
         addWhere(sWhereString, "([LaboratorioDescripcion] = ?)");
      }
      else
      {
         GXv_int4[14] = (byte)(1) ;
      }
      if ( AV55Laboratoriowwds_8_tflaboratoriotipodocumento_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("sqlserver", AV55Laboratoriowwds_8_tflaboratoriotipodocumento_sels, "[LaboratorioTipoDocumento] IN (", ")")+")");
      }
      if ( (GXutil.strcmp("", AV57Laboratoriowwds_10_tflaboratorionrodocumento_sel)==0) && ( ! (GXutil.strcmp("", AV56Laboratoriowwds_9_tflaboratorionrodocumento)==0) ) )
      {
         addWhere(sWhereString, "([LaboratorioNroDocumento] like ?)");
      }
      else
      {
         GXv_int4[15] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV57Laboratoriowwds_10_tflaboratorionrodocumento_sel)==0) )
      {
         addWhere(sWhereString, "([LaboratorioNroDocumento] = ?)");
      }
      else
      {
         GXv_int4[16] = (byte)(1) ;
      }
      if ( ! (0==AV58Laboratoriowwds_11_tflaboratoriocomision) )
      {
         addWhere(sWhereString, "([LaboratorioComision] >= ?)");
      }
      else
      {
         GXv_int4[17] = (byte)(1) ;
      }
      if ( ! (0==AV59Laboratoriowwds_12_tflaboratoriocomision_to) )
      {
         addWhere(sWhereString, "([LaboratorioComision] <= ?)");
      }
      else
      {
         GXv_int4[18] = (byte)(1) ;
      }
      if ( AV60Laboratoriowwds_13_tflaboratorioestado_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("sqlserver", AV60Laboratoriowwds_13_tflaboratorioestado_sels, "[LaboratorioEstado] IN (", ")")+")");
      }
      scmdbuf += sWhereString ;
      scmdbuf += " ORDER BY [LaboratorioNombre]" ;
      GXv_Object5[0] = scmdbuf ;
      GXv_Object5[1] = GXv_int4 ;
      return GXv_Object5 ;
   }

   protected Object[] conditional_P00363( ModelContext context ,
                                          int remoteHandle ,
                                          com.genexus.IHttpContext httpContext ,
                                          String A167LaboratorioTipoDocumento ,
                                          GXSimpleCollection<String> AV55Laboratoriowwds_8_tflaboratoriotipodocumento_sels ,
                                          String A171LaboratorioEstado ,
                                          GXSimpleCollection<String> AV60Laboratoriowwds_13_tflaboratorioestado_sels ,
                                          String AV48Laboratoriowwds_1_filterfulltext ,
                                          short AV49Laboratoriowwds_2_tflaboratorioid ,
                                          short AV50Laboratoriowwds_3_tflaboratorioid_to ,
                                          String AV52Laboratoriowwds_5_tflaboratorionombre_sel ,
                                          String AV51Laboratoriowwds_4_tflaboratorionombre ,
                                          String AV54Laboratoriowwds_7_tflaboratoriodescripcion_sel ,
                                          String AV53Laboratoriowwds_6_tflaboratoriodescripcion ,
                                          int AV55Laboratoriowwds_8_tflaboratoriotipodocumento_sels_size ,
                                          String AV57Laboratoriowwds_10_tflaboratorionrodocumento_sel ,
                                          String AV56Laboratoriowwds_9_tflaboratorionrodocumento ,
                                          short AV58Laboratoriowwds_11_tflaboratoriocomision ,
                                          short AV59Laboratoriowwds_12_tflaboratoriocomision_to ,
                                          int AV60Laboratoriowwds_13_tflaboratorioestado_sels_size ,
                                          short A40LaboratorioId ,
                                          String A165LaboratorioNombre ,
                                          String A166LaboratorioDescripcion ,
                                          String A168LaboratorioNroDocumento ,
                                          short A170LaboratorioComision )
   {
      java.lang.StringBuffer sWhereString = new java.lang.StringBuffer();
      String scmdbuf;
      byte[] GXv_int7 = new byte[19];
      Object[] GXv_Object8 = new Object[2];
      scmdbuf = "SELECT [LaboratorioDescripcion], [LaboratorioComision], [LaboratorioId], [LaboratorioEstado], [LaboratorioNroDocumento], [LaboratorioTipoDocumento], [LaboratorioNombre]" ;
      scmdbuf += " FROM [Laboratorio]" ;
      if ( ! (GXutil.strcmp("", AV48Laboratoriowwds_1_filterfulltext)==0) )
      {
         addWhere(sWhereString, "(( CONVERT( char(4), CAST([LaboratorioId] AS decimal(4,0))) like '%' + ?) or ( [LaboratorioNombre] like '%' + ?) or ( [LaboratorioDescripcion] like '%' + ?) or ( 'ruc' like '%' + LOWER(?) and [LaboratorioTipoDocumento] = '6') or ( 'dni' like '%' + LOWER(?) and [LaboratorioTipoDocumento] = '1') or ( [LaboratorioNroDocumento] like '%' + ?) or ( CONVERT( char(4), CAST([LaboratorioComision] AS decimal(4,0))) like '%' + ?) or ( 'activo' like '%' + LOWER(?) and [LaboratorioEstado] = 'A') or ( 'inactivo' like '%' + LOWER(?) and [LaboratorioEstado] = 'I'))");
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
      if ( ! (0==AV49Laboratoriowwds_2_tflaboratorioid) )
      {
         addWhere(sWhereString, "([LaboratorioId] >= ?)");
      }
      else
      {
         GXv_int7[9] = (byte)(1) ;
      }
      if ( ! (0==AV50Laboratoriowwds_3_tflaboratorioid_to) )
      {
         addWhere(sWhereString, "([LaboratorioId] <= ?)");
      }
      else
      {
         GXv_int7[10] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV52Laboratoriowwds_5_tflaboratorionombre_sel)==0) && ( ! (GXutil.strcmp("", AV51Laboratoriowwds_4_tflaboratorionombre)==0) ) )
      {
         addWhere(sWhereString, "([LaboratorioNombre] like ?)");
      }
      else
      {
         GXv_int7[11] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV52Laboratoriowwds_5_tflaboratorionombre_sel)==0) )
      {
         addWhere(sWhereString, "([LaboratorioNombre] = ?)");
      }
      else
      {
         GXv_int7[12] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV54Laboratoriowwds_7_tflaboratoriodescripcion_sel)==0) && ( ! (GXutil.strcmp("", AV53Laboratoriowwds_6_tflaboratoriodescripcion)==0) ) )
      {
         addWhere(sWhereString, "([LaboratorioDescripcion] like ?)");
      }
      else
      {
         GXv_int7[13] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV54Laboratoriowwds_7_tflaboratoriodescripcion_sel)==0) )
      {
         addWhere(sWhereString, "([LaboratorioDescripcion] = ?)");
      }
      else
      {
         GXv_int7[14] = (byte)(1) ;
      }
      if ( AV55Laboratoriowwds_8_tflaboratoriotipodocumento_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("sqlserver", AV55Laboratoriowwds_8_tflaboratoriotipodocumento_sels, "[LaboratorioTipoDocumento] IN (", ")")+")");
      }
      if ( (GXutil.strcmp("", AV57Laboratoriowwds_10_tflaboratorionrodocumento_sel)==0) && ( ! (GXutil.strcmp("", AV56Laboratoriowwds_9_tflaboratorionrodocumento)==0) ) )
      {
         addWhere(sWhereString, "([LaboratorioNroDocumento] like ?)");
      }
      else
      {
         GXv_int7[15] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV57Laboratoriowwds_10_tflaboratorionrodocumento_sel)==0) )
      {
         addWhere(sWhereString, "([LaboratorioNroDocumento] = ?)");
      }
      else
      {
         GXv_int7[16] = (byte)(1) ;
      }
      if ( ! (0==AV58Laboratoriowwds_11_tflaboratoriocomision) )
      {
         addWhere(sWhereString, "([LaboratorioComision] >= ?)");
      }
      else
      {
         GXv_int7[17] = (byte)(1) ;
      }
      if ( ! (0==AV59Laboratoriowwds_12_tflaboratoriocomision_to) )
      {
         addWhere(sWhereString, "([LaboratorioComision] <= ?)");
      }
      else
      {
         GXv_int7[18] = (byte)(1) ;
      }
      if ( AV60Laboratoriowwds_13_tflaboratorioestado_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("sqlserver", AV60Laboratoriowwds_13_tflaboratorioestado_sels, "[LaboratorioEstado] IN (", ")")+")");
      }
      scmdbuf += sWhereString ;
      scmdbuf += " ORDER BY [LaboratorioDescripcion]" ;
      GXv_Object8[0] = scmdbuf ;
      GXv_Object8[1] = GXv_int7 ;
      return GXv_Object8 ;
   }

   protected Object[] conditional_P00364( ModelContext context ,
                                          int remoteHandle ,
                                          com.genexus.IHttpContext httpContext ,
                                          String A167LaboratorioTipoDocumento ,
                                          GXSimpleCollection<String> AV55Laboratoriowwds_8_tflaboratoriotipodocumento_sels ,
                                          String A171LaboratorioEstado ,
                                          GXSimpleCollection<String> AV60Laboratoriowwds_13_tflaboratorioestado_sels ,
                                          String AV48Laboratoriowwds_1_filterfulltext ,
                                          short AV49Laboratoriowwds_2_tflaboratorioid ,
                                          short AV50Laboratoriowwds_3_tflaboratorioid_to ,
                                          String AV52Laboratoriowwds_5_tflaboratorionombre_sel ,
                                          String AV51Laboratoriowwds_4_tflaboratorionombre ,
                                          String AV54Laboratoriowwds_7_tflaboratoriodescripcion_sel ,
                                          String AV53Laboratoriowwds_6_tflaboratoriodescripcion ,
                                          int AV55Laboratoriowwds_8_tflaboratoriotipodocumento_sels_size ,
                                          String AV57Laboratoriowwds_10_tflaboratorionrodocumento_sel ,
                                          String AV56Laboratoriowwds_9_tflaboratorionrodocumento ,
                                          short AV58Laboratoriowwds_11_tflaboratoriocomision ,
                                          short AV59Laboratoriowwds_12_tflaboratoriocomision_to ,
                                          int AV60Laboratoriowwds_13_tflaboratorioestado_sels_size ,
                                          short A40LaboratorioId ,
                                          String A165LaboratorioNombre ,
                                          String A166LaboratorioDescripcion ,
                                          String A168LaboratorioNroDocumento ,
                                          short A170LaboratorioComision )
   {
      java.lang.StringBuffer sWhereString = new java.lang.StringBuffer();
      String scmdbuf;
      byte[] GXv_int10 = new byte[19];
      Object[] GXv_Object11 = new Object[2];
      scmdbuf = "SELECT [LaboratorioNroDocumento], [LaboratorioComision], [LaboratorioId], [LaboratorioEstado], [LaboratorioTipoDocumento], [LaboratorioDescripcion], [LaboratorioNombre]" ;
      scmdbuf += " FROM [Laboratorio]" ;
      if ( ! (GXutil.strcmp("", AV48Laboratoriowwds_1_filterfulltext)==0) )
      {
         addWhere(sWhereString, "(( CONVERT( char(4), CAST([LaboratorioId] AS decimal(4,0))) like '%' + ?) or ( [LaboratorioNombre] like '%' + ?) or ( [LaboratorioDescripcion] like '%' + ?) or ( 'ruc' like '%' + LOWER(?) and [LaboratorioTipoDocumento] = '6') or ( 'dni' like '%' + LOWER(?) and [LaboratorioTipoDocumento] = '1') or ( [LaboratorioNroDocumento] like '%' + ?) or ( CONVERT( char(4), CAST([LaboratorioComision] AS decimal(4,0))) like '%' + ?) or ( 'activo' like '%' + LOWER(?) and [LaboratorioEstado] = 'A') or ( 'inactivo' like '%' + LOWER(?) and [LaboratorioEstado] = 'I'))");
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
      if ( ! (0==AV49Laboratoriowwds_2_tflaboratorioid) )
      {
         addWhere(sWhereString, "([LaboratorioId] >= ?)");
      }
      else
      {
         GXv_int10[9] = (byte)(1) ;
      }
      if ( ! (0==AV50Laboratoriowwds_3_tflaboratorioid_to) )
      {
         addWhere(sWhereString, "([LaboratorioId] <= ?)");
      }
      else
      {
         GXv_int10[10] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV52Laboratoriowwds_5_tflaboratorionombre_sel)==0) && ( ! (GXutil.strcmp("", AV51Laboratoriowwds_4_tflaboratorionombre)==0) ) )
      {
         addWhere(sWhereString, "([LaboratorioNombre] like ?)");
      }
      else
      {
         GXv_int10[11] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV52Laboratoriowwds_5_tflaboratorionombre_sel)==0) )
      {
         addWhere(sWhereString, "([LaboratorioNombre] = ?)");
      }
      else
      {
         GXv_int10[12] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV54Laboratoriowwds_7_tflaboratoriodescripcion_sel)==0) && ( ! (GXutil.strcmp("", AV53Laboratoriowwds_6_tflaboratoriodescripcion)==0) ) )
      {
         addWhere(sWhereString, "([LaboratorioDescripcion] like ?)");
      }
      else
      {
         GXv_int10[13] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV54Laboratoriowwds_7_tflaboratoriodescripcion_sel)==0) )
      {
         addWhere(sWhereString, "([LaboratorioDescripcion] = ?)");
      }
      else
      {
         GXv_int10[14] = (byte)(1) ;
      }
      if ( AV55Laboratoriowwds_8_tflaboratoriotipodocumento_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("sqlserver", AV55Laboratoriowwds_8_tflaboratoriotipodocumento_sels, "[LaboratorioTipoDocumento] IN (", ")")+")");
      }
      if ( (GXutil.strcmp("", AV57Laboratoriowwds_10_tflaboratorionrodocumento_sel)==0) && ( ! (GXutil.strcmp("", AV56Laboratoriowwds_9_tflaboratorionrodocumento)==0) ) )
      {
         addWhere(sWhereString, "([LaboratorioNroDocumento] like ?)");
      }
      else
      {
         GXv_int10[15] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV57Laboratoriowwds_10_tflaboratorionrodocumento_sel)==0) )
      {
         addWhere(sWhereString, "([LaboratorioNroDocumento] = ?)");
      }
      else
      {
         GXv_int10[16] = (byte)(1) ;
      }
      if ( ! (0==AV58Laboratoriowwds_11_tflaboratoriocomision) )
      {
         addWhere(sWhereString, "([LaboratorioComision] >= ?)");
      }
      else
      {
         GXv_int10[17] = (byte)(1) ;
      }
      if ( ! (0==AV59Laboratoriowwds_12_tflaboratoriocomision_to) )
      {
         addWhere(sWhereString, "([LaboratorioComision] <= ?)");
      }
      else
      {
         GXv_int10[18] = (byte)(1) ;
      }
      if ( AV60Laboratoriowwds_13_tflaboratorioestado_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("sqlserver", AV60Laboratoriowwds_13_tflaboratorioestado_sels, "[LaboratorioEstado] IN (", ")")+")");
      }
      scmdbuf += sWhereString ;
      scmdbuf += " ORDER BY [LaboratorioNroDocumento]" ;
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
                  return conditional_P00362(context, remoteHandle, httpContext, (String)dynConstraints[0] , (GXSimpleCollection<String>)dynConstraints[1] , (String)dynConstraints[2] , (GXSimpleCollection<String>)dynConstraints[3] , (String)dynConstraints[4] , ((Number) dynConstraints[5]).shortValue() , ((Number) dynConstraints[6]).shortValue() , (String)dynConstraints[7] , (String)dynConstraints[8] , (String)dynConstraints[9] , (String)dynConstraints[10] , ((Number) dynConstraints[11]).intValue() , (String)dynConstraints[12] , (String)dynConstraints[13] , ((Number) dynConstraints[14]).shortValue() , ((Number) dynConstraints[15]).shortValue() , ((Number) dynConstraints[16]).intValue() , ((Number) dynConstraints[17]).shortValue() , (String)dynConstraints[18] , (String)dynConstraints[19] , (String)dynConstraints[20] , ((Number) dynConstraints[21]).shortValue() );
            case 1 :
                  return conditional_P00363(context, remoteHandle, httpContext, (String)dynConstraints[0] , (GXSimpleCollection<String>)dynConstraints[1] , (String)dynConstraints[2] , (GXSimpleCollection<String>)dynConstraints[3] , (String)dynConstraints[4] , ((Number) dynConstraints[5]).shortValue() , ((Number) dynConstraints[6]).shortValue() , (String)dynConstraints[7] , (String)dynConstraints[8] , (String)dynConstraints[9] , (String)dynConstraints[10] , ((Number) dynConstraints[11]).intValue() , (String)dynConstraints[12] , (String)dynConstraints[13] , ((Number) dynConstraints[14]).shortValue() , ((Number) dynConstraints[15]).shortValue() , ((Number) dynConstraints[16]).intValue() , ((Number) dynConstraints[17]).shortValue() , (String)dynConstraints[18] , (String)dynConstraints[19] , (String)dynConstraints[20] , ((Number) dynConstraints[21]).shortValue() );
            case 2 :
                  return conditional_P00364(context, remoteHandle, httpContext, (String)dynConstraints[0] , (GXSimpleCollection<String>)dynConstraints[1] , (String)dynConstraints[2] , (GXSimpleCollection<String>)dynConstraints[3] , (String)dynConstraints[4] , ((Number) dynConstraints[5]).shortValue() , ((Number) dynConstraints[6]).shortValue() , (String)dynConstraints[7] , (String)dynConstraints[8] , (String)dynConstraints[9] , (String)dynConstraints[10] , ((Number) dynConstraints[11]).intValue() , (String)dynConstraints[12] , (String)dynConstraints[13] , ((Number) dynConstraints[14]).shortValue() , ((Number) dynConstraints[15]).shortValue() , ((Number) dynConstraints[16]).intValue() , ((Number) dynConstraints[17]).shortValue() , (String)dynConstraints[18] , (String)dynConstraints[19] , (String)dynConstraints[20] , ((Number) dynConstraints[21]).shortValue() );
      }
      return super.getDynamicStatement(cursor, context, remoteHandle, httpContext, dynConstraints);
   }

   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P00362", "scmdbuf",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("P00363", "scmdbuf",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("P00364", "scmdbuf",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
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
               ((String[]) buf[3])[0] = rslt.getString(4, 1);
               ((String[]) buf[4])[0] = rslt.getVarchar(5);
               ((String[]) buf[5])[0] = rslt.getString(6, 1);
               ((String[]) buf[6])[0] = rslt.getVarchar(7);
               return;
            case 1 :
               ((String[]) buf[0])[0] = rslt.getVarchar(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((short[]) buf[2])[0] = rslt.getShort(3);
               ((String[]) buf[3])[0] = rslt.getString(4, 1);
               ((String[]) buf[4])[0] = rslt.getVarchar(5);
               ((String[]) buf[5])[0] = rslt.getString(6, 1);
               ((String[]) buf[6])[0] = rslt.getVarchar(7);
               return;
            case 2 :
               ((String[]) buf[0])[0] = rslt.getVarchar(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((short[]) buf[2])[0] = rslt.getShort(3);
               ((String[]) buf[3])[0] = rslt.getString(4, 1);
               ((String[]) buf[4])[0] = rslt.getString(5, 1);
               ((String[]) buf[5])[0] = rslt.getVarchar(6);
               ((String[]) buf[6])[0] = rslt.getVarchar(7);
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
                  stmt.setVarchar(sIdx, (String)parms[19], 100);
               }
               if ( ((Number) parms[1]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[20], 100);
               }
               if ( ((Number) parms[2]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[21], 100);
               }
               if ( ((Number) parms[3]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[22], 100);
               }
               if ( ((Number) parms[4]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[23], 100);
               }
               if ( ((Number) parms[5]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[24], 100);
               }
               if ( ((Number) parms[6]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[25], 100);
               }
               if ( ((Number) parms[7]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[26], 100);
               }
               if ( ((Number) parms[8]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[27], 100);
               }
               if ( ((Number) parms[9]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[28]).shortValue());
               }
               if ( ((Number) parms[10]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[29]).shortValue());
               }
               if ( ((Number) parms[11]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[30], 100);
               }
               if ( ((Number) parms[12]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[31], 100);
               }
               if ( ((Number) parms[13]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[32], 500);
               }
               if ( ((Number) parms[14]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[33], 500);
               }
               if ( ((Number) parms[15]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[34], 20);
               }
               if ( ((Number) parms[16]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[35], 20);
               }
               if ( ((Number) parms[17]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[36]).shortValue());
               }
               if ( ((Number) parms[18]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[37]).shortValue());
               }
               return;
            case 1 :
               sIdx = (short)(0) ;
               if ( ((Number) parms[0]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[19], 100);
               }
               if ( ((Number) parms[1]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[20], 100);
               }
               if ( ((Number) parms[2]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[21], 100);
               }
               if ( ((Number) parms[3]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[22], 100);
               }
               if ( ((Number) parms[4]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[23], 100);
               }
               if ( ((Number) parms[5]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[24], 100);
               }
               if ( ((Number) parms[6]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[25], 100);
               }
               if ( ((Number) parms[7]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[26], 100);
               }
               if ( ((Number) parms[8]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[27], 100);
               }
               if ( ((Number) parms[9]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[28]).shortValue());
               }
               if ( ((Number) parms[10]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[29]).shortValue());
               }
               if ( ((Number) parms[11]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[30], 100);
               }
               if ( ((Number) parms[12]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[31], 100);
               }
               if ( ((Number) parms[13]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[32], 500);
               }
               if ( ((Number) parms[14]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[33], 500);
               }
               if ( ((Number) parms[15]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[34], 20);
               }
               if ( ((Number) parms[16]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[35], 20);
               }
               if ( ((Number) parms[17]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[36]).shortValue());
               }
               if ( ((Number) parms[18]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[37]).shortValue());
               }
               return;
            case 2 :
               sIdx = (short)(0) ;
               if ( ((Number) parms[0]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[19], 100);
               }
               if ( ((Number) parms[1]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[20], 100);
               }
               if ( ((Number) parms[2]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[21], 100);
               }
               if ( ((Number) parms[3]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[22], 100);
               }
               if ( ((Number) parms[4]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[23], 100);
               }
               if ( ((Number) parms[5]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[24], 100);
               }
               if ( ((Number) parms[6]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[25], 100);
               }
               if ( ((Number) parms[7]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[26], 100);
               }
               if ( ((Number) parms[8]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[27], 100);
               }
               if ( ((Number) parms[9]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[28]).shortValue());
               }
               if ( ((Number) parms[10]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[29]).shortValue());
               }
               if ( ((Number) parms[11]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[30], 100);
               }
               if ( ((Number) parms[12]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[31], 100);
               }
               if ( ((Number) parms[13]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[32], 500);
               }
               if ( ((Number) parms[14]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[33], 500);
               }
               if ( ((Number) parms[15]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[34], 20);
               }
               if ( ((Number) parms[16]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[35], 20);
               }
               if ( ((Number) parms[17]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[36]).shortValue());
               }
               if ( ((Number) parms[18]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[37]).shortValue());
               }
               return;
      }
   }

}

