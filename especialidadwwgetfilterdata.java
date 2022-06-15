package com.projectthani ;
import com.projectthani.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class especialidadwwgetfilterdata extends GXProcedure
{
   public especialidadwwgetfilterdata( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( especialidadwwgetfilterdata.class ), "" );
   }

   public especialidadwwgetfilterdata( int remoteHandle ,
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
      especialidadwwgetfilterdata.this.aP5 = new String[] {""};
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
      especialidadwwgetfilterdata.this.AV23DDOName = aP0;
      especialidadwwgetfilterdata.this.AV21SearchTxt = aP1;
      especialidadwwgetfilterdata.this.AV22SearchTxtTo = aP2;
      especialidadwwgetfilterdata.this.aP3 = aP3;
      especialidadwwgetfilterdata.this.aP4 = aP4;
      especialidadwwgetfilterdata.this.aP5 = aP5;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      AV26Options = new GXSimpleCollection<String>(String.class, "internal", "") ;
      AV29OptionsDesc = new GXSimpleCollection<String>(String.class, "internal", "") ;
      AV31OptionIndexes = new GXSimpleCollection<String>(String.class, "internal", "") ;
      GXt_boolean1 = AV8IsAuthorized ;
      GXv_boolean2[0] = GXt_boolean1 ;
      new com.projectthani.wwpbaseobjects.secisauthbyfunctionalitykey(remoteHandle, context).execute( "WWEspecialidad", GXv_boolean2) ;
      especialidadwwgetfilterdata.this.GXt_boolean1 = GXv_boolean2[0] ;
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
         if ( GXutil.strcmp(GXutil.upper( AV23DDOName), "DDO_ESPECIALIDADNOMBRE") == 0 )
         {
            /* Execute user subroutine: 'LOADESPECIALIDADNOMBREOPTIONS' */
            S121 ();
            if ( returnInSub )
            {
               returnInSub = true;
               cleanup();
               if (true) return;
            }
         }
         else if ( GXutil.strcmp(GXutil.upper( AV23DDOName), "DDO_ESPECIALIDADDESCRIPCION") == 0 )
         {
            /* Execute user subroutine: 'LOADESPECIALIDADDESCRIPCIONOPTIONS' */
            S131 ();
            if ( returnInSub )
            {
               returnInSub = true;
               cleanup();
               if (true) return;
            }
         }
         else if ( GXutil.strcmp(GXutil.upper( AV23DDOName), "DDO_ESPECIALIDADCODIGO") == 0 )
         {
            /* Execute user subroutine: 'LOADESPECIALIDADCODIGOOPTIONS' */
            S141 ();
            if ( returnInSub )
            {
               returnInSub = true;
               cleanup();
               if (true) return;
            }
         }
      }
      AV27OptionsJson = AV26Options.toJSonString(false) ;
      AV30OptionsDescJson = AV29OptionsDesc.toJSonString(false) ;
      AV32OptionIndexesJson = AV31OptionIndexes.toJSonString(false) ;
      cleanup();
   }

   public void S111( )
   {
      /* 'LOADGRIDSTATE' Routine */
      returnInSub = false ;
      if ( GXutil.strcmp(AV34Session.getValue("EspecialidadWWGridState"), "") == 0 )
      {
         AV36GridState.fromxml(new com.projectthani.wwpbaseobjects.loadgridstate(remoteHandle, context).executeUdp( "EspecialidadWWGridState"), null, null);
      }
      else
      {
         AV36GridState.fromxml(AV34Session.getValue("EspecialidadWWGridState"), null, null);
      }
      AV42GXV1 = 1 ;
      while ( AV42GXV1 <= AV36GridState.getgxTv_SdtWWPGridState_Filtervalues().size() )
      {
         AV37GridStateFilterValue = (com.projectthani.wwpbaseobjects.SdtWWPGridState_FilterValue)((com.projectthani.wwpbaseobjects.SdtWWPGridState_FilterValue)AV36GridState.getgxTv_SdtWWPGridState_Filtervalues().elementAt(-1+AV42GXV1));
         if ( GXutil.strcmp(AV37GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "FILTERFULLTEXT") == 0 )
         {
            AV39FilterFullText = AV37GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV37GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFESPECIALIDADID") == 0 )
         {
            AV11TFEspecialidadId = (short)(GXutil.lval( AV37GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value())) ;
            AV12TFEspecialidadId_To = (short)(GXutil.lval( AV37GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Valueto())) ;
         }
         else if ( GXutil.strcmp(AV37GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFESPECIALIDADNOMBRE") == 0 )
         {
            AV13TFEspecialidadNombre = AV37GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV37GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFESPECIALIDADNOMBRE_SEL") == 0 )
         {
            AV14TFEspecialidadNombre_Sel = AV37GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV37GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFESPECIALIDADDESCRIPCION") == 0 )
         {
            AV15TFEspecialidadDescripcion = AV37GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV37GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFESPECIALIDADDESCRIPCION_SEL") == 0 )
         {
            AV16TFEspecialidadDescripcion_Sel = AV37GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV37GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFESPECIALIDADCODIGO") == 0 )
         {
            AV17TFEspecialidadCodigo = AV37GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV37GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFESPECIALIDADCODIGO_SEL") == 0 )
         {
            AV18TFEspecialidadCodigo_Sel = AV37GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV37GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFESPECIALIDADESTADO_SEL") == 0 )
         {
            AV19TFEspecialidadEstado_SelsJson = AV37GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            AV20TFEspecialidadEstado_Sels.fromJSonString(AV19TFEspecialidadEstado_SelsJson, null);
         }
         AV42GXV1 = (int)(AV42GXV1+1) ;
      }
   }

   public void S121( )
   {
      /* 'LOADESPECIALIDADNOMBREOPTIONS' Routine */
      returnInSub = false ;
      AV13TFEspecialidadNombre = AV21SearchTxt ;
      AV14TFEspecialidadNombre_Sel = "" ;
      AV44Especialidadwwds_1_filterfulltext = AV39FilterFullText ;
      AV45Especialidadwwds_2_tfespecialidadid = AV11TFEspecialidadId ;
      AV46Especialidadwwds_3_tfespecialidadid_to = AV12TFEspecialidadId_To ;
      AV47Especialidadwwds_4_tfespecialidadnombre = AV13TFEspecialidadNombre ;
      AV48Especialidadwwds_5_tfespecialidadnombre_sel = AV14TFEspecialidadNombre_Sel ;
      AV49Especialidadwwds_6_tfespecialidaddescripcion = AV15TFEspecialidadDescripcion ;
      AV50Especialidadwwds_7_tfespecialidaddescripcion_sel = AV16TFEspecialidadDescripcion_Sel ;
      AV51Especialidadwwds_8_tfespecialidadcodigo = AV17TFEspecialidadCodigo ;
      AV52Especialidadwwds_9_tfespecialidadcodigo_sel = AV18TFEspecialidadCodigo_Sel ;
      AV53Especialidadwwds_10_tfespecialidadestado_sels = AV20TFEspecialidadEstado_Sels ;
      pr_default.dynParam(0, new Object[]{ new Object[]{
                                           A156EspecialidadEstado ,
                                           AV53Especialidadwwds_10_tfespecialidadestado_sels ,
                                           AV44Especialidadwwds_1_filterfulltext ,
                                           Short.valueOf(AV45Especialidadwwds_2_tfespecialidadid) ,
                                           Short.valueOf(AV46Especialidadwwds_3_tfespecialidadid_to) ,
                                           AV48Especialidadwwds_5_tfespecialidadnombre_sel ,
                                           AV47Especialidadwwds_4_tfespecialidadnombre ,
                                           AV50Especialidadwwds_7_tfespecialidaddescripcion_sel ,
                                           AV49Especialidadwwds_6_tfespecialidaddescripcion ,
                                           AV52Especialidadwwds_9_tfespecialidadcodigo_sel ,
                                           AV51Especialidadwwds_8_tfespecialidadcodigo ,
                                           Integer.valueOf(AV53Especialidadwwds_10_tfespecialidadestado_sels.size()) ,
                                           Short.valueOf(A32EspecialidadId) ,
                                           A71EspecialidadNombre ,
                                           A154EspecialidadDescripcion ,
                                           A140EspecialidadCodigo } ,
                                           new int[]{
                                           TypeConstants.STRING, TypeConstants.STRING, TypeConstants.SHORT, TypeConstants.SHORT, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING,
                                           TypeConstants.INT, TypeConstants.SHORT, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING
                                           }
      });
      lV44Especialidadwwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV44Especialidadwwds_1_filterfulltext), "%", "") ;
      lV44Especialidadwwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV44Especialidadwwds_1_filterfulltext), "%", "") ;
      lV44Especialidadwwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV44Especialidadwwds_1_filterfulltext), "%", "") ;
      lV44Especialidadwwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV44Especialidadwwds_1_filterfulltext), "%", "") ;
      lV44Especialidadwwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV44Especialidadwwds_1_filterfulltext), "%", "") ;
      lV44Especialidadwwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV44Especialidadwwds_1_filterfulltext), "%", "") ;
      lV47Especialidadwwds_4_tfespecialidadnombre = GXutil.concat( GXutil.rtrim( AV47Especialidadwwds_4_tfespecialidadnombre), "%", "") ;
      lV49Especialidadwwds_6_tfespecialidaddescripcion = GXutil.concat( GXutil.rtrim( AV49Especialidadwwds_6_tfespecialidaddescripcion), "%", "") ;
      lV51Especialidadwwds_8_tfespecialidadcodigo = GXutil.concat( GXutil.rtrim( AV51Especialidadwwds_8_tfespecialidadcodigo), "%", "") ;
      /* Using cursor P00332 */
      pr_default.execute(0, new Object[] {lV44Especialidadwwds_1_filterfulltext, lV44Especialidadwwds_1_filterfulltext, lV44Especialidadwwds_1_filterfulltext, lV44Especialidadwwds_1_filterfulltext, lV44Especialidadwwds_1_filterfulltext, lV44Especialidadwwds_1_filterfulltext, Short.valueOf(AV45Especialidadwwds_2_tfespecialidadid), Short.valueOf(AV46Especialidadwwds_3_tfespecialidadid_to), lV47Especialidadwwds_4_tfespecialidadnombre, AV48Especialidadwwds_5_tfespecialidadnombre_sel, lV49Especialidadwwds_6_tfespecialidaddescripcion, AV50Especialidadwwds_7_tfespecialidaddescripcion_sel, lV51Especialidadwwds_8_tfespecialidadcodigo, AV52Especialidadwwds_9_tfespecialidadcodigo_sel});
      while ( (pr_default.getStatus(0) != 101) )
      {
         brk332 = false ;
         A71EspecialidadNombre = P00332_A71EspecialidadNombre[0] ;
         A32EspecialidadId = P00332_A32EspecialidadId[0] ;
         A156EspecialidadEstado = P00332_A156EspecialidadEstado[0] ;
         A140EspecialidadCodigo = P00332_A140EspecialidadCodigo[0] ;
         A154EspecialidadDescripcion = P00332_A154EspecialidadDescripcion[0] ;
         AV33count = 0 ;
         while ( (pr_default.getStatus(0) != 101) && ( GXutil.strcmp(P00332_A71EspecialidadNombre[0], A71EspecialidadNombre) == 0 ) )
         {
            brk332 = false ;
            A32EspecialidadId = P00332_A32EspecialidadId[0] ;
            AV33count = (long)(AV33count+1) ;
            brk332 = true ;
            pr_default.readNext(0);
         }
         if ( ! (GXutil.strcmp("", A71EspecialidadNombre)==0) )
         {
            AV25Option = A71EspecialidadNombre ;
            AV26Options.add(AV25Option, 0);
            AV31OptionIndexes.add(GXutil.trim( localUtil.format( DecimalUtil.doubleToDec(AV33count), "Z,ZZZ,ZZZ,ZZ9")), 0);
         }
         if ( AV26Options.size() == 50 )
         {
            /* Exit For each command. Update data (if necessary), close cursors & exit. */
            if (true) break;
         }
         if ( ! brk332 )
         {
            brk332 = true ;
            pr_default.readNext(0);
         }
      }
      pr_default.close(0);
   }

   public void S131( )
   {
      /* 'LOADESPECIALIDADDESCRIPCIONOPTIONS' Routine */
      returnInSub = false ;
      AV15TFEspecialidadDescripcion = AV21SearchTxt ;
      AV16TFEspecialidadDescripcion_Sel = "" ;
      AV44Especialidadwwds_1_filterfulltext = AV39FilterFullText ;
      AV45Especialidadwwds_2_tfespecialidadid = AV11TFEspecialidadId ;
      AV46Especialidadwwds_3_tfespecialidadid_to = AV12TFEspecialidadId_To ;
      AV47Especialidadwwds_4_tfespecialidadnombre = AV13TFEspecialidadNombre ;
      AV48Especialidadwwds_5_tfespecialidadnombre_sel = AV14TFEspecialidadNombre_Sel ;
      AV49Especialidadwwds_6_tfespecialidaddescripcion = AV15TFEspecialidadDescripcion ;
      AV50Especialidadwwds_7_tfespecialidaddescripcion_sel = AV16TFEspecialidadDescripcion_Sel ;
      AV51Especialidadwwds_8_tfespecialidadcodigo = AV17TFEspecialidadCodigo ;
      AV52Especialidadwwds_9_tfespecialidadcodigo_sel = AV18TFEspecialidadCodigo_Sel ;
      AV53Especialidadwwds_10_tfespecialidadestado_sels = AV20TFEspecialidadEstado_Sels ;
      pr_default.dynParam(1, new Object[]{ new Object[]{
                                           A156EspecialidadEstado ,
                                           AV53Especialidadwwds_10_tfespecialidadestado_sels ,
                                           AV44Especialidadwwds_1_filterfulltext ,
                                           Short.valueOf(AV45Especialidadwwds_2_tfespecialidadid) ,
                                           Short.valueOf(AV46Especialidadwwds_3_tfespecialidadid_to) ,
                                           AV48Especialidadwwds_5_tfespecialidadnombre_sel ,
                                           AV47Especialidadwwds_4_tfespecialidadnombre ,
                                           AV50Especialidadwwds_7_tfespecialidaddescripcion_sel ,
                                           AV49Especialidadwwds_6_tfespecialidaddescripcion ,
                                           AV52Especialidadwwds_9_tfespecialidadcodigo_sel ,
                                           AV51Especialidadwwds_8_tfespecialidadcodigo ,
                                           Integer.valueOf(AV53Especialidadwwds_10_tfespecialidadestado_sels.size()) ,
                                           Short.valueOf(A32EspecialidadId) ,
                                           A71EspecialidadNombre ,
                                           A154EspecialidadDescripcion ,
                                           A140EspecialidadCodigo } ,
                                           new int[]{
                                           TypeConstants.STRING, TypeConstants.STRING, TypeConstants.SHORT, TypeConstants.SHORT, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING,
                                           TypeConstants.INT, TypeConstants.SHORT, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING
                                           }
      });
      lV44Especialidadwwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV44Especialidadwwds_1_filterfulltext), "%", "") ;
      lV44Especialidadwwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV44Especialidadwwds_1_filterfulltext), "%", "") ;
      lV44Especialidadwwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV44Especialidadwwds_1_filterfulltext), "%", "") ;
      lV44Especialidadwwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV44Especialidadwwds_1_filterfulltext), "%", "") ;
      lV44Especialidadwwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV44Especialidadwwds_1_filterfulltext), "%", "") ;
      lV44Especialidadwwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV44Especialidadwwds_1_filterfulltext), "%", "") ;
      lV47Especialidadwwds_4_tfespecialidadnombre = GXutil.concat( GXutil.rtrim( AV47Especialidadwwds_4_tfespecialidadnombre), "%", "") ;
      lV49Especialidadwwds_6_tfespecialidaddescripcion = GXutil.concat( GXutil.rtrim( AV49Especialidadwwds_6_tfespecialidaddescripcion), "%", "") ;
      lV51Especialidadwwds_8_tfespecialidadcodigo = GXutil.concat( GXutil.rtrim( AV51Especialidadwwds_8_tfespecialidadcodigo), "%", "") ;
      /* Using cursor P00333 */
      pr_default.execute(1, new Object[] {lV44Especialidadwwds_1_filterfulltext, lV44Especialidadwwds_1_filterfulltext, lV44Especialidadwwds_1_filterfulltext, lV44Especialidadwwds_1_filterfulltext, lV44Especialidadwwds_1_filterfulltext, lV44Especialidadwwds_1_filterfulltext, Short.valueOf(AV45Especialidadwwds_2_tfespecialidadid), Short.valueOf(AV46Especialidadwwds_3_tfespecialidadid_to), lV47Especialidadwwds_4_tfespecialidadnombre, AV48Especialidadwwds_5_tfespecialidadnombre_sel, lV49Especialidadwwds_6_tfespecialidaddescripcion, AV50Especialidadwwds_7_tfespecialidaddescripcion_sel, lV51Especialidadwwds_8_tfespecialidadcodigo, AV52Especialidadwwds_9_tfespecialidadcodigo_sel});
      while ( (pr_default.getStatus(1) != 101) )
      {
         brk334 = false ;
         A154EspecialidadDescripcion = P00333_A154EspecialidadDescripcion[0] ;
         A32EspecialidadId = P00333_A32EspecialidadId[0] ;
         A156EspecialidadEstado = P00333_A156EspecialidadEstado[0] ;
         A140EspecialidadCodigo = P00333_A140EspecialidadCodigo[0] ;
         A71EspecialidadNombre = P00333_A71EspecialidadNombre[0] ;
         AV33count = 0 ;
         while ( (pr_default.getStatus(1) != 101) && ( GXutil.strcmp(P00333_A154EspecialidadDescripcion[0], A154EspecialidadDescripcion) == 0 ) )
         {
            brk334 = false ;
            A32EspecialidadId = P00333_A32EspecialidadId[0] ;
            AV33count = (long)(AV33count+1) ;
            brk334 = true ;
            pr_default.readNext(1);
         }
         if ( ! (GXutil.strcmp("", A154EspecialidadDescripcion)==0) )
         {
            AV25Option = A154EspecialidadDescripcion ;
            AV26Options.add(AV25Option, 0);
            AV31OptionIndexes.add(GXutil.trim( localUtil.format( DecimalUtil.doubleToDec(AV33count), "Z,ZZZ,ZZZ,ZZ9")), 0);
         }
         if ( AV26Options.size() == 50 )
         {
            /* Exit For each command. Update data (if necessary), close cursors & exit. */
            if (true) break;
         }
         if ( ! brk334 )
         {
            brk334 = true ;
            pr_default.readNext(1);
         }
      }
      pr_default.close(1);
   }

   public void S141( )
   {
      /* 'LOADESPECIALIDADCODIGOOPTIONS' Routine */
      returnInSub = false ;
      AV17TFEspecialidadCodigo = AV21SearchTxt ;
      AV18TFEspecialidadCodigo_Sel = "" ;
      AV44Especialidadwwds_1_filterfulltext = AV39FilterFullText ;
      AV45Especialidadwwds_2_tfespecialidadid = AV11TFEspecialidadId ;
      AV46Especialidadwwds_3_tfespecialidadid_to = AV12TFEspecialidadId_To ;
      AV47Especialidadwwds_4_tfespecialidadnombre = AV13TFEspecialidadNombre ;
      AV48Especialidadwwds_5_tfespecialidadnombre_sel = AV14TFEspecialidadNombre_Sel ;
      AV49Especialidadwwds_6_tfespecialidaddescripcion = AV15TFEspecialidadDescripcion ;
      AV50Especialidadwwds_7_tfespecialidaddescripcion_sel = AV16TFEspecialidadDescripcion_Sel ;
      AV51Especialidadwwds_8_tfespecialidadcodigo = AV17TFEspecialidadCodigo ;
      AV52Especialidadwwds_9_tfespecialidadcodigo_sel = AV18TFEspecialidadCodigo_Sel ;
      AV53Especialidadwwds_10_tfespecialidadestado_sels = AV20TFEspecialidadEstado_Sels ;
      pr_default.dynParam(2, new Object[]{ new Object[]{
                                           A156EspecialidadEstado ,
                                           AV53Especialidadwwds_10_tfespecialidadestado_sels ,
                                           AV44Especialidadwwds_1_filterfulltext ,
                                           Short.valueOf(AV45Especialidadwwds_2_tfespecialidadid) ,
                                           Short.valueOf(AV46Especialidadwwds_3_tfespecialidadid_to) ,
                                           AV48Especialidadwwds_5_tfespecialidadnombre_sel ,
                                           AV47Especialidadwwds_4_tfespecialidadnombre ,
                                           AV50Especialidadwwds_7_tfespecialidaddescripcion_sel ,
                                           AV49Especialidadwwds_6_tfespecialidaddescripcion ,
                                           AV52Especialidadwwds_9_tfespecialidadcodigo_sel ,
                                           AV51Especialidadwwds_8_tfespecialidadcodigo ,
                                           Integer.valueOf(AV53Especialidadwwds_10_tfespecialidadestado_sels.size()) ,
                                           Short.valueOf(A32EspecialidadId) ,
                                           A71EspecialidadNombre ,
                                           A154EspecialidadDescripcion ,
                                           A140EspecialidadCodigo } ,
                                           new int[]{
                                           TypeConstants.STRING, TypeConstants.STRING, TypeConstants.SHORT, TypeConstants.SHORT, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING,
                                           TypeConstants.INT, TypeConstants.SHORT, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING
                                           }
      });
      lV44Especialidadwwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV44Especialidadwwds_1_filterfulltext), "%", "") ;
      lV44Especialidadwwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV44Especialidadwwds_1_filterfulltext), "%", "") ;
      lV44Especialidadwwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV44Especialidadwwds_1_filterfulltext), "%", "") ;
      lV44Especialidadwwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV44Especialidadwwds_1_filterfulltext), "%", "") ;
      lV44Especialidadwwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV44Especialidadwwds_1_filterfulltext), "%", "") ;
      lV44Especialidadwwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV44Especialidadwwds_1_filterfulltext), "%", "") ;
      lV47Especialidadwwds_4_tfespecialidadnombre = GXutil.concat( GXutil.rtrim( AV47Especialidadwwds_4_tfespecialidadnombre), "%", "") ;
      lV49Especialidadwwds_6_tfespecialidaddescripcion = GXutil.concat( GXutil.rtrim( AV49Especialidadwwds_6_tfespecialidaddescripcion), "%", "") ;
      lV51Especialidadwwds_8_tfespecialidadcodigo = GXutil.concat( GXutil.rtrim( AV51Especialidadwwds_8_tfespecialidadcodigo), "%", "") ;
      /* Using cursor P00334 */
      pr_default.execute(2, new Object[] {lV44Especialidadwwds_1_filterfulltext, lV44Especialidadwwds_1_filterfulltext, lV44Especialidadwwds_1_filterfulltext, lV44Especialidadwwds_1_filterfulltext, lV44Especialidadwwds_1_filterfulltext, lV44Especialidadwwds_1_filterfulltext, Short.valueOf(AV45Especialidadwwds_2_tfespecialidadid), Short.valueOf(AV46Especialidadwwds_3_tfespecialidadid_to), lV47Especialidadwwds_4_tfespecialidadnombre, AV48Especialidadwwds_5_tfespecialidadnombre_sel, lV49Especialidadwwds_6_tfespecialidaddescripcion, AV50Especialidadwwds_7_tfespecialidaddescripcion_sel, lV51Especialidadwwds_8_tfespecialidadcodigo, AV52Especialidadwwds_9_tfespecialidadcodigo_sel});
      while ( (pr_default.getStatus(2) != 101) )
      {
         brk336 = false ;
         A140EspecialidadCodigo = P00334_A140EspecialidadCodigo[0] ;
         A32EspecialidadId = P00334_A32EspecialidadId[0] ;
         A156EspecialidadEstado = P00334_A156EspecialidadEstado[0] ;
         A154EspecialidadDescripcion = P00334_A154EspecialidadDescripcion[0] ;
         A71EspecialidadNombre = P00334_A71EspecialidadNombre[0] ;
         AV33count = 0 ;
         while ( (pr_default.getStatus(2) != 101) && ( GXutil.strcmp(P00334_A140EspecialidadCodigo[0], A140EspecialidadCodigo) == 0 ) )
         {
            brk336 = false ;
            A32EspecialidadId = P00334_A32EspecialidadId[0] ;
            AV33count = (long)(AV33count+1) ;
            brk336 = true ;
            pr_default.readNext(2);
         }
         if ( ! (GXutil.strcmp("", A140EspecialidadCodigo)==0) )
         {
            AV25Option = A140EspecialidadCodigo ;
            AV26Options.add(AV25Option, 0);
            AV31OptionIndexes.add(GXutil.trim( localUtil.format( DecimalUtil.doubleToDec(AV33count), "Z,ZZZ,ZZZ,ZZ9")), 0);
         }
         if ( AV26Options.size() == 50 )
         {
            /* Exit For each command. Update data (if necessary), close cursors & exit. */
            if (true) break;
         }
         if ( ! brk336 )
         {
            brk336 = true ;
            pr_default.readNext(2);
         }
      }
      pr_default.close(2);
   }

   protected void cleanup( )
   {
      this.aP3[0] = especialidadwwgetfilterdata.this.AV27OptionsJson;
      this.aP4[0] = especialidadwwgetfilterdata.this.AV30OptionsDescJson;
      this.aP5[0] = especialidadwwgetfilterdata.this.AV32OptionIndexesJson;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV27OptionsJson = "" ;
      AV30OptionsDescJson = "" ;
      AV32OptionIndexesJson = "" ;
      AV26Options = new GXSimpleCollection<String>(String.class, "internal", "");
      AV29OptionsDesc = new GXSimpleCollection<String>(String.class, "internal", "");
      AV31OptionIndexes = new GXSimpleCollection<String>(String.class, "internal", "");
      GXv_boolean2 = new boolean[1] ;
      AV9WWPContext = new com.projectthani.wwpbaseobjects.SdtWWPContext(remoteHandle, context);
      GXv_SdtWWPContext3 = new com.projectthani.wwpbaseobjects.SdtWWPContext[1] ;
      AV34Session = httpContext.getWebSession();
      AV36GridState = new com.projectthani.wwpbaseobjects.SdtWWPGridState(remoteHandle, context);
      AV37GridStateFilterValue = new com.projectthani.wwpbaseobjects.SdtWWPGridState_FilterValue(remoteHandle, context);
      AV39FilterFullText = "" ;
      AV13TFEspecialidadNombre = "" ;
      AV14TFEspecialidadNombre_Sel = "" ;
      AV15TFEspecialidadDescripcion = "" ;
      AV16TFEspecialidadDescripcion_Sel = "" ;
      AV17TFEspecialidadCodigo = "" ;
      AV18TFEspecialidadCodigo_Sel = "" ;
      AV19TFEspecialidadEstado_SelsJson = "" ;
      AV20TFEspecialidadEstado_Sels = new GXSimpleCollection<String>(String.class, "internal", "");
      A71EspecialidadNombre = "" ;
      AV44Especialidadwwds_1_filterfulltext = "" ;
      AV47Especialidadwwds_4_tfespecialidadnombre = "" ;
      AV48Especialidadwwds_5_tfespecialidadnombre_sel = "" ;
      AV49Especialidadwwds_6_tfespecialidaddescripcion = "" ;
      AV50Especialidadwwds_7_tfespecialidaddescripcion_sel = "" ;
      AV51Especialidadwwds_8_tfespecialidadcodigo = "" ;
      AV52Especialidadwwds_9_tfespecialidadcodigo_sel = "" ;
      AV53Especialidadwwds_10_tfespecialidadestado_sels = new GXSimpleCollection<String>(String.class, "internal", "");
      scmdbuf = "" ;
      lV44Especialidadwwds_1_filterfulltext = "" ;
      lV47Especialidadwwds_4_tfespecialidadnombre = "" ;
      lV49Especialidadwwds_6_tfespecialidaddescripcion = "" ;
      lV51Especialidadwwds_8_tfespecialidadcodigo = "" ;
      A156EspecialidadEstado = "" ;
      A154EspecialidadDescripcion = "" ;
      A140EspecialidadCodigo = "" ;
      P00332_A71EspecialidadNombre = new String[] {""} ;
      P00332_A32EspecialidadId = new short[1] ;
      P00332_A156EspecialidadEstado = new String[] {""} ;
      P00332_A140EspecialidadCodigo = new String[] {""} ;
      P00332_A154EspecialidadDescripcion = new String[] {""} ;
      AV25Option = "" ;
      P00333_A154EspecialidadDescripcion = new String[] {""} ;
      P00333_A32EspecialidadId = new short[1] ;
      P00333_A156EspecialidadEstado = new String[] {""} ;
      P00333_A140EspecialidadCodigo = new String[] {""} ;
      P00333_A71EspecialidadNombre = new String[] {""} ;
      P00334_A140EspecialidadCodigo = new String[] {""} ;
      P00334_A32EspecialidadId = new short[1] ;
      P00334_A156EspecialidadEstado = new String[] {""} ;
      P00334_A154EspecialidadDescripcion = new String[] {""} ;
      P00334_A71EspecialidadNombre = new String[] {""} ;
      pr_default = new DataStoreProvider(context, remoteHandle, new com.projectthani.especialidadwwgetfilterdata__default(),
         new Object[] {
             new Object[] {
            P00332_A71EspecialidadNombre, P00332_A32EspecialidadId, P00332_A156EspecialidadEstado, P00332_A140EspecialidadCodigo, P00332_A154EspecialidadDescripcion
            }
            , new Object[] {
            P00333_A154EspecialidadDescripcion, P00333_A32EspecialidadId, P00333_A156EspecialidadEstado, P00333_A140EspecialidadCodigo, P00333_A71EspecialidadNombre
            }
            , new Object[] {
            P00334_A140EspecialidadCodigo, P00334_A32EspecialidadId, P00334_A156EspecialidadEstado, P00334_A154EspecialidadDescripcion, P00334_A71EspecialidadNombre
            }
         }
      );
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private short AV11TFEspecialidadId ;
   private short AV12TFEspecialidadId_To ;
   private short AV45Especialidadwwds_2_tfespecialidadid ;
   private short AV46Especialidadwwds_3_tfespecialidadid_to ;
   private short A32EspecialidadId ;
   private short Gx_err ;
   private int AV42GXV1 ;
   private int AV53Especialidadwwds_10_tfespecialidadestado_sels_size ;
   private long AV33count ;
   private String scmdbuf ;
   private String A156EspecialidadEstado ;
   private boolean AV8IsAuthorized ;
   private boolean GXt_boolean1 ;
   private boolean GXv_boolean2[] ;
   private boolean returnInSub ;
   private boolean brk332 ;
   private boolean brk334 ;
   private boolean brk336 ;
   private String AV27OptionsJson ;
   private String AV30OptionsDescJson ;
   private String AV32OptionIndexesJson ;
   private String AV19TFEspecialidadEstado_SelsJson ;
   private String AV23DDOName ;
   private String AV21SearchTxt ;
   private String AV22SearchTxtTo ;
   private String AV39FilterFullText ;
   private String AV13TFEspecialidadNombre ;
   private String AV14TFEspecialidadNombre_Sel ;
   private String AV15TFEspecialidadDescripcion ;
   private String AV16TFEspecialidadDescripcion_Sel ;
   private String AV17TFEspecialidadCodigo ;
   private String AV18TFEspecialidadCodigo_Sel ;
   private String A71EspecialidadNombre ;
   private String AV44Especialidadwwds_1_filterfulltext ;
   private String AV47Especialidadwwds_4_tfespecialidadnombre ;
   private String AV48Especialidadwwds_5_tfespecialidadnombre_sel ;
   private String AV49Especialidadwwds_6_tfespecialidaddescripcion ;
   private String AV50Especialidadwwds_7_tfespecialidaddescripcion_sel ;
   private String AV51Especialidadwwds_8_tfespecialidadcodigo ;
   private String AV52Especialidadwwds_9_tfespecialidadcodigo_sel ;
   private String lV44Especialidadwwds_1_filterfulltext ;
   private String lV47Especialidadwwds_4_tfespecialidadnombre ;
   private String lV49Especialidadwwds_6_tfespecialidaddescripcion ;
   private String lV51Especialidadwwds_8_tfespecialidadcodigo ;
   private String A154EspecialidadDescripcion ;
   private String A140EspecialidadCodigo ;
   private String AV25Option ;
   private com.genexus.webpanels.WebSession AV34Session ;
   private String[] aP5 ;
   private String[] aP3 ;
   private String[] aP4 ;
   private IDataStoreProvider pr_default ;
   private String[] P00332_A71EspecialidadNombre ;
   private short[] P00332_A32EspecialidadId ;
   private String[] P00332_A156EspecialidadEstado ;
   private String[] P00332_A140EspecialidadCodigo ;
   private String[] P00332_A154EspecialidadDescripcion ;
   private String[] P00333_A154EspecialidadDescripcion ;
   private short[] P00333_A32EspecialidadId ;
   private String[] P00333_A156EspecialidadEstado ;
   private String[] P00333_A140EspecialidadCodigo ;
   private String[] P00333_A71EspecialidadNombre ;
   private String[] P00334_A140EspecialidadCodigo ;
   private short[] P00334_A32EspecialidadId ;
   private String[] P00334_A156EspecialidadEstado ;
   private String[] P00334_A154EspecialidadDescripcion ;
   private String[] P00334_A71EspecialidadNombre ;
   private GXSimpleCollection<String> AV20TFEspecialidadEstado_Sels ;
   private GXSimpleCollection<String> AV53Especialidadwwds_10_tfespecialidadestado_sels ;
   private GXSimpleCollection<String> AV26Options ;
   private GXSimpleCollection<String> AV29OptionsDesc ;
   private GXSimpleCollection<String> AV31OptionIndexes ;
   private com.projectthani.wwpbaseobjects.SdtWWPContext AV9WWPContext ;
   private com.projectthani.wwpbaseobjects.SdtWWPContext GXv_SdtWWPContext3[] ;
   private com.projectthani.wwpbaseobjects.SdtWWPGridState AV36GridState ;
   private com.projectthani.wwpbaseobjects.SdtWWPGridState_FilterValue AV37GridStateFilterValue ;
}

final  class especialidadwwgetfilterdata__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   protected Object[] conditional_P00332( ModelContext context ,
                                          int remoteHandle ,
                                          com.genexus.IHttpContext httpContext ,
                                          String A156EspecialidadEstado ,
                                          GXSimpleCollection<String> AV53Especialidadwwds_10_tfespecialidadestado_sels ,
                                          String AV44Especialidadwwds_1_filterfulltext ,
                                          short AV45Especialidadwwds_2_tfespecialidadid ,
                                          short AV46Especialidadwwds_3_tfespecialidadid_to ,
                                          String AV48Especialidadwwds_5_tfespecialidadnombre_sel ,
                                          String AV47Especialidadwwds_4_tfespecialidadnombre ,
                                          String AV50Especialidadwwds_7_tfespecialidaddescripcion_sel ,
                                          String AV49Especialidadwwds_6_tfespecialidaddescripcion ,
                                          String AV52Especialidadwwds_9_tfespecialidadcodigo_sel ,
                                          String AV51Especialidadwwds_8_tfespecialidadcodigo ,
                                          int AV53Especialidadwwds_10_tfespecialidadestado_sels_size ,
                                          short A32EspecialidadId ,
                                          String A71EspecialidadNombre ,
                                          String A154EspecialidadDescripcion ,
                                          String A140EspecialidadCodigo )
   {
      java.lang.StringBuffer sWhereString = new java.lang.StringBuffer();
      String scmdbuf;
      byte[] GXv_int4 = new byte[14];
      Object[] GXv_Object5 = new Object[2];
      scmdbuf = "SELECT [EspecialidadNombre], [EspecialidadId], [EspecialidadEstado], [EspecialidadCodigo], [EspecialidadDescripcion] FROM [Especialidad]" ;
      if ( ! (GXutil.strcmp("", AV44Especialidadwwds_1_filterfulltext)==0) )
      {
         addWhere(sWhereString, "(( CONVERT( char(4), CAST([EspecialidadId] AS decimal(4,0))) like '%' + ?) or ( [EspecialidadNombre] like '%' + ?) or ( [EspecialidadDescripcion] like '%' + ?) or ( [EspecialidadCodigo] like '%' + ?) or ( 'activo' like '%' + LOWER(?) and [EspecialidadEstado] = 'A') or ( 'inactivo' like '%' + LOWER(?) and [EspecialidadEstado] = 'I'))");
      }
      else
      {
         GXv_int4[0] = (byte)(1) ;
         GXv_int4[1] = (byte)(1) ;
         GXv_int4[2] = (byte)(1) ;
         GXv_int4[3] = (byte)(1) ;
         GXv_int4[4] = (byte)(1) ;
         GXv_int4[5] = (byte)(1) ;
      }
      if ( ! (0==AV45Especialidadwwds_2_tfespecialidadid) )
      {
         addWhere(sWhereString, "([EspecialidadId] >= ?)");
      }
      else
      {
         GXv_int4[6] = (byte)(1) ;
      }
      if ( ! (0==AV46Especialidadwwds_3_tfespecialidadid_to) )
      {
         addWhere(sWhereString, "([EspecialidadId] <= ?)");
      }
      else
      {
         GXv_int4[7] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV48Especialidadwwds_5_tfespecialidadnombre_sel)==0) && ( ! (GXutil.strcmp("", AV47Especialidadwwds_4_tfespecialidadnombre)==0) ) )
      {
         addWhere(sWhereString, "([EspecialidadNombre] like ?)");
      }
      else
      {
         GXv_int4[8] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV48Especialidadwwds_5_tfespecialidadnombre_sel)==0) )
      {
         addWhere(sWhereString, "([EspecialidadNombre] = ?)");
      }
      else
      {
         GXv_int4[9] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV50Especialidadwwds_7_tfespecialidaddescripcion_sel)==0) && ( ! (GXutil.strcmp("", AV49Especialidadwwds_6_tfespecialidaddescripcion)==0) ) )
      {
         addWhere(sWhereString, "([EspecialidadDescripcion] like ?)");
      }
      else
      {
         GXv_int4[10] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV50Especialidadwwds_7_tfespecialidaddescripcion_sel)==0) )
      {
         addWhere(sWhereString, "([EspecialidadDescripcion] = ?)");
      }
      else
      {
         GXv_int4[11] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV52Especialidadwwds_9_tfespecialidadcodigo_sel)==0) && ( ! (GXutil.strcmp("", AV51Especialidadwwds_8_tfespecialidadcodigo)==0) ) )
      {
         addWhere(sWhereString, "([EspecialidadCodigo] like ?)");
      }
      else
      {
         GXv_int4[12] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV52Especialidadwwds_9_tfespecialidadcodigo_sel)==0) )
      {
         addWhere(sWhereString, "([EspecialidadCodigo] = ?)");
      }
      else
      {
         GXv_int4[13] = (byte)(1) ;
      }
      if ( AV53Especialidadwwds_10_tfespecialidadestado_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("sqlserver", AV53Especialidadwwds_10_tfespecialidadestado_sels, "[EspecialidadEstado] IN (", ")")+")");
      }
      scmdbuf += sWhereString ;
      scmdbuf += " ORDER BY [EspecialidadNombre]" ;
      GXv_Object5[0] = scmdbuf ;
      GXv_Object5[1] = GXv_int4 ;
      return GXv_Object5 ;
   }

   protected Object[] conditional_P00333( ModelContext context ,
                                          int remoteHandle ,
                                          com.genexus.IHttpContext httpContext ,
                                          String A156EspecialidadEstado ,
                                          GXSimpleCollection<String> AV53Especialidadwwds_10_tfespecialidadestado_sels ,
                                          String AV44Especialidadwwds_1_filterfulltext ,
                                          short AV45Especialidadwwds_2_tfespecialidadid ,
                                          short AV46Especialidadwwds_3_tfespecialidadid_to ,
                                          String AV48Especialidadwwds_5_tfespecialidadnombre_sel ,
                                          String AV47Especialidadwwds_4_tfespecialidadnombre ,
                                          String AV50Especialidadwwds_7_tfespecialidaddescripcion_sel ,
                                          String AV49Especialidadwwds_6_tfespecialidaddescripcion ,
                                          String AV52Especialidadwwds_9_tfespecialidadcodigo_sel ,
                                          String AV51Especialidadwwds_8_tfespecialidadcodigo ,
                                          int AV53Especialidadwwds_10_tfespecialidadestado_sels_size ,
                                          short A32EspecialidadId ,
                                          String A71EspecialidadNombre ,
                                          String A154EspecialidadDescripcion ,
                                          String A140EspecialidadCodigo )
   {
      java.lang.StringBuffer sWhereString = new java.lang.StringBuffer();
      String scmdbuf;
      byte[] GXv_int7 = new byte[14];
      Object[] GXv_Object8 = new Object[2];
      scmdbuf = "SELECT [EspecialidadDescripcion], [EspecialidadId], [EspecialidadEstado], [EspecialidadCodigo], [EspecialidadNombre] FROM [Especialidad]" ;
      if ( ! (GXutil.strcmp("", AV44Especialidadwwds_1_filterfulltext)==0) )
      {
         addWhere(sWhereString, "(( CONVERT( char(4), CAST([EspecialidadId] AS decimal(4,0))) like '%' + ?) or ( [EspecialidadNombre] like '%' + ?) or ( [EspecialidadDescripcion] like '%' + ?) or ( [EspecialidadCodigo] like '%' + ?) or ( 'activo' like '%' + LOWER(?) and [EspecialidadEstado] = 'A') or ( 'inactivo' like '%' + LOWER(?) and [EspecialidadEstado] = 'I'))");
      }
      else
      {
         GXv_int7[0] = (byte)(1) ;
         GXv_int7[1] = (byte)(1) ;
         GXv_int7[2] = (byte)(1) ;
         GXv_int7[3] = (byte)(1) ;
         GXv_int7[4] = (byte)(1) ;
         GXv_int7[5] = (byte)(1) ;
      }
      if ( ! (0==AV45Especialidadwwds_2_tfespecialidadid) )
      {
         addWhere(sWhereString, "([EspecialidadId] >= ?)");
      }
      else
      {
         GXv_int7[6] = (byte)(1) ;
      }
      if ( ! (0==AV46Especialidadwwds_3_tfespecialidadid_to) )
      {
         addWhere(sWhereString, "([EspecialidadId] <= ?)");
      }
      else
      {
         GXv_int7[7] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV48Especialidadwwds_5_tfespecialidadnombre_sel)==0) && ( ! (GXutil.strcmp("", AV47Especialidadwwds_4_tfespecialidadnombre)==0) ) )
      {
         addWhere(sWhereString, "([EspecialidadNombre] like ?)");
      }
      else
      {
         GXv_int7[8] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV48Especialidadwwds_5_tfespecialidadnombre_sel)==0) )
      {
         addWhere(sWhereString, "([EspecialidadNombre] = ?)");
      }
      else
      {
         GXv_int7[9] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV50Especialidadwwds_7_tfespecialidaddescripcion_sel)==0) && ( ! (GXutil.strcmp("", AV49Especialidadwwds_6_tfespecialidaddescripcion)==0) ) )
      {
         addWhere(sWhereString, "([EspecialidadDescripcion] like ?)");
      }
      else
      {
         GXv_int7[10] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV50Especialidadwwds_7_tfespecialidaddescripcion_sel)==0) )
      {
         addWhere(sWhereString, "([EspecialidadDescripcion] = ?)");
      }
      else
      {
         GXv_int7[11] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV52Especialidadwwds_9_tfespecialidadcodigo_sel)==0) && ( ! (GXutil.strcmp("", AV51Especialidadwwds_8_tfespecialidadcodigo)==0) ) )
      {
         addWhere(sWhereString, "([EspecialidadCodigo] like ?)");
      }
      else
      {
         GXv_int7[12] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV52Especialidadwwds_9_tfespecialidadcodigo_sel)==0) )
      {
         addWhere(sWhereString, "([EspecialidadCodigo] = ?)");
      }
      else
      {
         GXv_int7[13] = (byte)(1) ;
      }
      if ( AV53Especialidadwwds_10_tfespecialidadestado_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("sqlserver", AV53Especialidadwwds_10_tfespecialidadestado_sels, "[EspecialidadEstado] IN (", ")")+")");
      }
      scmdbuf += sWhereString ;
      scmdbuf += " ORDER BY [EspecialidadDescripcion]" ;
      GXv_Object8[0] = scmdbuf ;
      GXv_Object8[1] = GXv_int7 ;
      return GXv_Object8 ;
   }

   protected Object[] conditional_P00334( ModelContext context ,
                                          int remoteHandle ,
                                          com.genexus.IHttpContext httpContext ,
                                          String A156EspecialidadEstado ,
                                          GXSimpleCollection<String> AV53Especialidadwwds_10_tfespecialidadestado_sels ,
                                          String AV44Especialidadwwds_1_filterfulltext ,
                                          short AV45Especialidadwwds_2_tfespecialidadid ,
                                          short AV46Especialidadwwds_3_tfespecialidadid_to ,
                                          String AV48Especialidadwwds_5_tfespecialidadnombre_sel ,
                                          String AV47Especialidadwwds_4_tfespecialidadnombre ,
                                          String AV50Especialidadwwds_7_tfespecialidaddescripcion_sel ,
                                          String AV49Especialidadwwds_6_tfespecialidaddescripcion ,
                                          String AV52Especialidadwwds_9_tfespecialidadcodigo_sel ,
                                          String AV51Especialidadwwds_8_tfespecialidadcodigo ,
                                          int AV53Especialidadwwds_10_tfespecialidadestado_sels_size ,
                                          short A32EspecialidadId ,
                                          String A71EspecialidadNombre ,
                                          String A154EspecialidadDescripcion ,
                                          String A140EspecialidadCodigo )
   {
      java.lang.StringBuffer sWhereString = new java.lang.StringBuffer();
      String scmdbuf;
      byte[] GXv_int10 = new byte[14];
      Object[] GXv_Object11 = new Object[2];
      scmdbuf = "SELECT [EspecialidadCodigo], [EspecialidadId], [EspecialidadEstado], [EspecialidadDescripcion], [EspecialidadNombre] FROM [Especialidad]" ;
      if ( ! (GXutil.strcmp("", AV44Especialidadwwds_1_filterfulltext)==0) )
      {
         addWhere(sWhereString, "(( CONVERT( char(4), CAST([EspecialidadId] AS decimal(4,0))) like '%' + ?) or ( [EspecialidadNombre] like '%' + ?) or ( [EspecialidadDescripcion] like '%' + ?) or ( [EspecialidadCodigo] like '%' + ?) or ( 'activo' like '%' + LOWER(?) and [EspecialidadEstado] = 'A') or ( 'inactivo' like '%' + LOWER(?) and [EspecialidadEstado] = 'I'))");
      }
      else
      {
         GXv_int10[0] = (byte)(1) ;
         GXv_int10[1] = (byte)(1) ;
         GXv_int10[2] = (byte)(1) ;
         GXv_int10[3] = (byte)(1) ;
         GXv_int10[4] = (byte)(1) ;
         GXv_int10[5] = (byte)(1) ;
      }
      if ( ! (0==AV45Especialidadwwds_2_tfespecialidadid) )
      {
         addWhere(sWhereString, "([EspecialidadId] >= ?)");
      }
      else
      {
         GXv_int10[6] = (byte)(1) ;
      }
      if ( ! (0==AV46Especialidadwwds_3_tfespecialidadid_to) )
      {
         addWhere(sWhereString, "([EspecialidadId] <= ?)");
      }
      else
      {
         GXv_int10[7] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV48Especialidadwwds_5_tfespecialidadnombre_sel)==0) && ( ! (GXutil.strcmp("", AV47Especialidadwwds_4_tfespecialidadnombre)==0) ) )
      {
         addWhere(sWhereString, "([EspecialidadNombre] like ?)");
      }
      else
      {
         GXv_int10[8] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV48Especialidadwwds_5_tfespecialidadnombre_sel)==0) )
      {
         addWhere(sWhereString, "([EspecialidadNombre] = ?)");
      }
      else
      {
         GXv_int10[9] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV50Especialidadwwds_7_tfespecialidaddescripcion_sel)==0) && ( ! (GXutil.strcmp("", AV49Especialidadwwds_6_tfespecialidaddescripcion)==0) ) )
      {
         addWhere(sWhereString, "([EspecialidadDescripcion] like ?)");
      }
      else
      {
         GXv_int10[10] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV50Especialidadwwds_7_tfespecialidaddescripcion_sel)==0) )
      {
         addWhere(sWhereString, "([EspecialidadDescripcion] = ?)");
      }
      else
      {
         GXv_int10[11] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV52Especialidadwwds_9_tfespecialidadcodigo_sel)==0) && ( ! (GXutil.strcmp("", AV51Especialidadwwds_8_tfespecialidadcodigo)==0) ) )
      {
         addWhere(sWhereString, "([EspecialidadCodigo] like ?)");
      }
      else
      {
         GXv_int10[12] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV52Especialidadwwds_9_tfespecialidadcodigo_sel)==0) )
      {
         addWhere(sWhereString, "([EspecialidadCodigo] = ?)");
      }
      else
      {
         GXv_int10[13] = (byte)(1) ;
      }
      if ( AV53Especialidadwwds_10_tfespecialidadestado_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("sqlserver", AV53Especialidadwwds_10_tfespecialidadestado_sels, "[EspecialidadEstado] IN (", ")")+")");
      }
      scmdbuf += sWhereString ;
      scmdbuf += " ORDER BY [EspecialidadCodigo]" ;
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
                  return conditional_P00332(context, remoteHandle, httpContext, (String)dynConstraints[0] , (GXSimpleCollection<String>)dynConstraints[1] , (String)dynConstraints[2] , ((Number) dynConstraints[3]).shortValue() , ((Number) dynConstraints[4]).shortValue() , (String)dynConstraints[5] , (String)dynConstraints[6] , (String)dynConstraints[7] , (String)dynConstraints[8] , (String)dynConstraints[9] , (String)dynConstraints[10] , ((Number) dynConstraints[11]).intValue() , ((Number) dynConstraints[12]).shortValue() , (String)dynConstraints[13] , (String)dynConstraints[14] , (String)dynConstraints[15] );
            case 1 :
                  return conditional_P00333(context, remoteHandle, httpContext, (String)dynConstraints[0] , (GXSimpleCollection<String>)dynConstraints[1] , (String)dynConstraints[2] , ((Number) dynConstraints[3]).shortValue() , ((Number) dynConstraints[4]).shortValue() , (String)dynConstraints[5] , (String)dynConstraints[6] , (String)dynConstraints[7] , (String)dynConstraints[8] , (String)dynConstraints[9] , (String)dynConstraints[10] , ((Number) dynConstraints[11]).intValue() , ((Number) dynConstraints[12]).shortValue() , (String)dynConstraints[13] , (String)dynConstraints[14] , (String)dynConstraints[15] );
            case 2 :
                  return conditional_P00334(context, remoteHandle, httpContext, (String)dynConstraints[0] , (GXSimpleCollection<String>)dynConstraints[1] , (String)dynConstraints[2] , ((Number) dynConstraints[3]).shortValue() , ((Number) dynConstraints[4]).shortValue() , (String)dynConstraints[5] , (String)dynConstraints[6] , (String)dynConstraints[7] , (String)dynConstraints[8] , (String)dynConstraints[9] , (String)dynConstraints[10] , ((Number) dynConstraints[11]).intValue() , ((Number) dynConstraints[12]).shortValue() , (String)dynConstraints[13] , (String)dynConstraints[14] , (String)dynConstraints[15] );
      }
      return super.getDynamicStatement(cursor, context, remoteHandle, httpContext, dynConstraints);
   }

   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P00332", "scmdbuf",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("P00333", "scmdbuf",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("P00334", "scmdbuf",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
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
               ((String[]) buf[2])[0] = rslt.getString(3, 1);
               ((String[]) buf[3])[0] = rslt.getVarchar(4);
               ((String[]) buf[4])[0] = rslt.getVarchar(5);
               return;
            case 1 :
               ((String[]) buf[0])[0] = rslt.getVarchar(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((String[]) buf[2])[0] = rslt.getString(3, 1);
               ((String[]) buf[3])[0] = rslt.getVarchar(4);
               ((String[]) buf[4])[0] = rslt.getVarchar(5);
               return;
            case 2 :
               ((String[]) buf[0])[0] = rslt.getVarchar(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
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
                  stmt.setVarchar(sIdx, (String)parms[14], 100);
               }
               if ( ((Number) parms[1]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[15], 100);
               }
               if ( ((Number) parms[2]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[16], 100);
               }
               if ( ((Number) parms[3]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[17], 100);
               }
               if ( ((Number) parms[4]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[18], 100);
               }
               if ( ((Number) parms[5]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[19], 100);
               }
               if ( ((Number) parms[6]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[20]).shortValue());
               }
               if ( ((Number) parms[7]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[21]).shortValue());
               }
               if ( ((Number) parms[8]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[22], 40);
               }
               if ( ((Number) parms[9]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[23], 40);
               }
               if ( ((Number) parms[10]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[24], 200);
               }
               if ( ((Number) parms[11]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[25], 200);
               }
               if ( ((Number) parms[12]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[26], 4);
               }
               if ( ((Number) parms[13]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[27], 4);
               }
               return;
            case 1 :
               sIdx = (short)(0) ;
               if ( ((Number) parms[0]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[14], 100);
               }
               if ( ((Number) parms[1]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[15], 100);
               }
               if ( ((Number) parms[2]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[16], 100);
               }
               if ( ((Number) parms[3]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[17], 100);
               }
               if ( ((Number) parms[4]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[18], 100);
               }
               if ( ((Number) parms[5]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[19], 100);
               }
               if ( ((Number) parms[6]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[20]).shortValue());
               }
               if ( ((Number) parms[7]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[21]).shortValue());
               }
               if ( ((Number) parms[8]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[22], 40);
               }
               if ( ((Number) parms[9]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[23], 40);
               }
               if ( ((Number) parms[10]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[24], 200);
               }
               if ( ((Number) parms[11]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[25], 200);
               }
               if ( ((Number) parms[12]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[26], 4);
               }
               if ( ((Number) parms[13]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[27], 4);
               }
               return;
            case 2 :
               sIdx = (short)(0) ;
               if ( ((Number) parms[0]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[14], 100);
               }
               if ( ((Number) parms[1]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[15], 100);
               }
               if ( ((Number) parms[2]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[16], 100);
               }
               if ( ((Number) parms[3]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[17], 100);
               }
               if ( ((Number) parms[4]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[18], 100);
               }
               if ( ((Number) parms[5]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[19], 100);
               }
               if ( ((Number) parms[6]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[20]).shortValue());
               }
               if ( ((Number) parms[7]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[21]).shortValue());
               }
               if ( ((Number) parms[8]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[22], 40);
               }
               if ( ((Number) parms[9]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[23], 40);
               }
               if ( ((Number) parms[10]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[24], 200);
               }
               if ( ((Number) parms[11]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[25], 200);
               }
               if ( ((Number) parms[12]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[26], 4);
               }
               if ( ((Number) parms[13]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[27], 4);
               }
               return;
      }
   }

}

