package com.projectthani ;
import com.projectthani.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class formafarmaceuticawwgetfilterdata extends GXProcedure
{
   public formafarmaceuticawwgetfilterdata( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( formafarmaceuticawwgetfilterdata.class ), "" );
   }

   public formafarmaceuticawwgetfilterdata( int remoteHandle ,
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
      formafarmaceuticawwgetfilterdata.this.aP5 = new String[] {""};
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
      formafarmaceuticawwgetfilterdata.this.AV23DDOName = aP0;
      formafarmaceuticawwgetfilterdata.this.AV21SearchTxt = aP1;
      formafarmaceuticawwgetfilterdata.this.AV22SearchTxtTo = aP2;
      formafarmaceuticawwgetfilterdata.this.aP3 = aP3;
      formafarmaceuticawwgetfilterdata.this.aP4 = aP4;
      formafarmaceuticawwgetfilterdata.this.aP5 = aP5;
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
      new com.projectthani.wwpbaseobjects.secisauthbyfunctionalitykey(remoteHandle, context).execute( "WWFormaFarmaceutica", GXv_boolean2) ;
      formafarmaceuticawwgetfilterdata.this.GXt_boolean1 = GXv_boolean2[0] ;
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
         if ( GXutil.strcmp(GXutil.upper( AV23DDOName), "DDO_FORMAFARMACEUTICACODIGO") == 0 )
         {
            /* Execute user subroutine: 'LOADFORMAFARMACEUTICACODIGOOPTIONS' */
            S121 ();
            if ( returnInSub )
            {
               returnInSub = true;
               cleanup();
               if (true) return;
            }
         }
         else if ( GXutil.strcmp(GXutil.upper( AV23DDOName), "DDO_FORMAFARMACEUTICADESCRIPCION") == 0 )
         {
            /* Execute user subroutine: 'LOADFORMAFARMACEUTICADESCRIPCIONOPTIONS' */
            S131 ();
            if ( returnInSub )
            {
               returnInSub = true;
               cleanup();
               if (true) return;
            }
         }
         else if ( GXutil.strcmp(GXutil.upper( AV23DDOName), "DDO_FORMAFARMACEUTICADESCRIPCION2") == 0 )
         {
            /* Execute user subroutine: 'LOADFORMAFARMACEUTICADESCRIPCION2OPTIONS' */
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
      if ( GXutil.strcmp(AV34Session.getValue("FormaFarmaceuticaWWGridState"), "") == 0 )
      {
         AV36GridState.fromxml(new com.projectthani.wwpbaseobjects.loadgridstate(remoteHandle, context).executeUdp( "FormaFarmaceuticaWWGridState"), null, null);
      }
      else
      {
         AV36GridState.fromxml(AV34Session.getValue("FormaFarmaceuticaWWGridState"), null, null);
      }
      AV42GXV1 = 1 ;
      while ( AV42GXV1 <= AV36GridState.getgxTv_SdtWWPGridState_Filtervalues().size() )
      {
         AV37GridStateFilterValue = (com.projectthani.wwpbaseobjects.SdtWWPGridState_FilterValue)((com.projectthani.wwpbaseobjects.SdtWWPGridState_FilterValue)AV36GridState.getgxTv_SdtWWPGridState_Filtervalues().elementAt(-1+AV42GXV1));
         if ( GXutil.strcmp(AV37GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "FILTERFULLTEXT") == 0 )
         {
            AV39FilterFullText = AV37GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV37GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFFORMAFARMACEUTICAID") == 0 )
         {
            AV11TFFormaFarmaceuticaId = (short)(GXutil.lval( AV37GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value())) ;
            AV12TFFormaFarmaceuticaId_To = (short)(GXutil.lval( AV37GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Valueto())) ;
         }
         else if ( GXutil.strcmp(AV37GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFFORMAFARMACEUTICACODIGO") == 0 )
         {
            AV13TFFormaFarmaceuticaCodigo = AV37GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV37GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFFORMAFARMACEUTICACODIGO_SEL") == 0 )
         {
            AV14TFFormaFarmaceuticaCodigo_Sel = AV37GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV37GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFFORMAFARMACEUTICADESCRIPCION") == 0 )
         {
            AV15TFFormaFarmaceuticaDescripcion = AV37GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV37GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFFORMAFARMACEUTICADESCRIPCION_SEL") == 0 )
         {
            AV16TFFormaFarmaceuticaDescripcion_Sel = AV37GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV37GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFFORMAFARMACEUTICAESTADO_SEL") == 0 )
         {
            AV17TFFormaFarmaceuticaEstado_SelsJson = AV37GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            AV18TFFormaFarmaceuticaEstado_Sels.fromJSonString(AV17TFFormaFarmaceuticaEstado_SelsJson, null);
         }
         else if ( GXutil.strcmp(AV37GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFFORMAFARMACEUTICADESCRIPCION2") == 0 )
         {
            AV19TFFormaFarmaceuticaDescripcion2 = AV37GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV37GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFFORMAFARMACEUTICADESCRIPCION2_SEL") == 0 )
         {
            AV20TFFormaFarmaceuticaDescripcion2_Sel = AV37GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         AV42GXV1 = (int)(AV42GXV1+1) ;
      }
   }

   public void S121( )
   {
      /* 'LOADFORMAFARMACEUTICACODIGOOPTIONS' Routine */
      returnInSub = false ;
      AV13TFFormaFarmaceuticaCodigo = AV21SearchTxt ;
      AV14TFFormaFarmaceuticaCodigo_Sel = "" ;
      AV44Formafarmaceuticawwds_1_filterfulltext = AV39FilterFullText ;
      AV45Formafarmaceuticawwds_2_tfformafarmaceuticaid = AV11TFFormaFarmaceuticaId ;
      AV46Formafarmaceuticawwds_3_tfformafarmaceuticaid_to = AV12TFFormaFarmaceuticaId_To ;
      AV47Formafarmaceuticawwds_4_tfformafarmaceuticacodigo = AV13TFFormaFarmaceuticaCodigo ;
      AV48Formafarmaceuticawwds_5_tfformafarmaceuticacodigo_sel = AV14TFFormaFarmaceuticaCodigo_Sel ;
      AV49Formafarmaceuticawwds_6_tfformafarmaceuticadescripcion = AV15TFFormaFarmaceuticaDescripcion ;
      AV50Formafarmaceuticawwds_7_tfformafarmaceuticadescripcion_sel = AV16TFFormaFarmaceuticaDescripcion_Sel ;
      AV51Formafarmaceuticawwds_8_tfformafarmaceuticaestado_sels = AV18TFFormaFarmaceuticaEstado_Sels ;
      AV52Formafarmaceuticawwds_9_tfformafarmaceuticadescripcion2 = AV19TFFormaFarmaceuticaDescripcion2 ;
      AV53Formafarmaceuticawwds_10_tfformafarmaceuticadescripcion2_sel = AV20TFFormaFarmaceuticaDescripcion2_Sel ;
      pr_default.dynParam(0, new Object[]{ new Object[]{
                                           A163FormaFarmaceuticaEstado ,
                                           AV51Formafarmaceuticawwds_8_tfformafarmaceuticaestado_sels ,
                                           AV44Formafarmaceuticawwds_1_filterfulltext ,
                                           Short.valueOf(AV45Formafarmaceuticawwds_2_tfformafarmaceuticaid) ,
                                           Short.valueOf(AV46Formafarmaceuticawwds_3_tfformafarmaceuticaid_to) ,
                                           AV48Formafarmaceuticawwds_5_tfformafarmaceuticacodigo_sel ,
                                           AV47Formafarmaceuticawwds_4_tfformafarmaceuticacodigo ,
                                           AV50Formafarmaceuticawwds_7_tfformafarmaceuticadescripcion_sel ,
                                           AV49Formafarmaceuticawwds_6_tfformafarmaceuticadescripcion ,
                                           Integer.valueOf(AV51Formafarmaceuticawwds_8_tfformafarmaceuticaestado_sels.size()) ,
                                           AV53Formafarmaceuticawwds_10_tfformafarmaceuticadescripcion2_sel ,
                                           AV52Formafarmaceuticawwds_9_tfformafarmaceuticadescripcion2 ,
                                           Short.valueOf(A39FormaFarmaceuticaId) ,
                                           A161FormaFarmaceuticaCodigo ,
                                           A162FormaFarmaceuticaDescripcion } ,
                                           new int[]{
                                           TypeConstants.STRING, TypeConstants.STRING, TypeConstants.SHORT, TypeConstants.SHORT, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.INT, TypeConstants.STRING,
                                           TypeConstants.STRING, TypeConstants.SHORT, TypeConstants.STRING, TypeConstants.STRING
                                           }
      });
      lV44Formafarmaceuticawwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV44Formafarmaceuticawwds_1_filterfulltext), "%", "") ;
      lV44Formafarmaceuticawwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV44Formafarmaceuticawwds_1_filterfulltext), "%", "") ;
      lV44Formafarmaceuticawwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV44Formafarmaceuticawwds_1_filterfulltext), "%", "") ;
      lV44Formafarmaceuticawwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV44Formafarmaceuticawwds_1_filterfulltext), "%", "") ;
      lV44Formafarmaceuticawwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV44Formafarmaceuticawwds_1_filterfulltext), "%", "") ;
      lV44Formafarmaceuticawwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV44Formafarmaceuticawwds_1_filterfulltext), "%", "") ;
      lV47Formafarmaceuticawwds_4_tfformafarmaceuticacodigo = GXutil.concat( GXutil.rtrim( AV47Formafarmaceuticawwds_4_tfformafarmaceuticacodigo), "%", "") ;
      lV49Formafarmaceuticawwds_6_tfformafarmaceuticadescripcion = GXutil.concat( GXutil.rtrim( AV49Formafarmaceuticawwds_6_tfformafarmaceuticadescripcion), "%", "") ;
      lV52Formafarmaceuticawwds_9_tfformafarmaceuticadescripcion2 = GXutil.concat( GXutil.rtrim( AV52Formafarmaceuticawwds_9_tfformafarmaceuticadescripcion2), "%", "") ;
      /* Using cursor P00342 */
      pr_default.execute(0, new Object[] {lV44Formafarmaceuticawwds_1_filterfulltext, lV44Formafarmaceuticawwds_1_filterfulltext, lV44Formafarmaceuticawwds_1_filterfulltext, lV44Formafarmaceuticawwds_1_filterfulltext, lV44Formafarmaceuticawwds_1_filterfulltext, lV44Formafarmaceuticawwds_1_filterfulltext, Short.valueOf(AV45Formafarmaceuticawwds_2_tfformafarmaceuticaid), Short.valueOf(AV46Formafarmaceuticawwds_3_tfformafarmaceuticaid_to), lV47Formafarmaceuticawwds_4_tfformafarmaceuticacodigo, AV48Formafarmaceuticawwds_5_tfformafarmaceuticacodigo_sel, lV49Formafarmaceuticawwds_6_tfformafarmaceuticadescripcion, AV50Formafarmaceuticawwds_7_tfformafarmaceuticadescripcion_sel, lV52Formafarmaceuticawwds_9_tfformafarmaceuticadescripcion2, AV53Formafarmaceuticawwds_10_tfformafarmaceuticadescripcion2_sel});
      while ( (pr_default.getStatus(0) != 101) )
      {
         brk342 = false ;
         A39FormaFarmaceuticaId = P00342_A39FormaFarmaceuticaId[0] ;
         A163FormaFarmaceuticaEstado = P00342_A163FormaFarmaceuticaEstado[0] ;
         A162FormaFarmaceuticaDescripcion = P00342_A162FormaFarmaceuticaDescripcion[0] ;
         A161FormaFarmaceuticaCodigo = P00342_A161FormaFarmaceuticaCodigo[0] ;
         A164FormaFarmaceuticaDescripcion2 = A161FormaFarmaceuticaCodigo + " - " + A162FormaFarmaceuticaDescripcion ;
         AV33count = 0 ;
         while ( (pr_default.getStatus(0) != 101) && ( GXutil.strcmp(P00342_A161FormaFarmaceuticaCodigo[0], A161FormaFarmaceuticaCodigo) == 0 ) )
         {
            brk342 = false ;
            A39FormaFarmaceuticaId = P00342_A39FormaFarmaceuticaId[0] ;
            AV33count = (long)(AV33count+1) ;
            brk342 = true ;
            pr_default.readNext(0);
         }
         if ( ! (GXutil.strcmp("", A161FormaFarmaceuticaCodigo)==0) )
         {
            AV25Option = A161FormaFarmaceuticaCodigo ;
            AV26Options.add(AV25Option, 0);
            AV31OptionIndexes.add(GXutil.trim( localUtil.format( DecimalUtil.doubleToDec(AV33count), "Z,ZZZ,ZZZ,ZZ9")), 0);
         }
         if ( AV26Options.size() == 50 )
         {
            /* Exit For each command. Update data (if necessary), close cursors & exit. */
            if (true) break;
         }
         if ( ! brk342 )
         {
            brk342 = true ;
            pr_default.readNext(0);
         }
      }
      pr_default.close(0);
   }

   public void S131( )
   {
      /* 'LOADFORMAFARMACEUTICADESCRIPCIONOPTIONS' Routine */
      returnInSub = false ;
      AV15TFFormaFarmaceuticaDescripcion = AV21SearchTxt ;
      AV16TFFormaFarmaceuticaDescripcion_Sel = "" ;
      AV44Formafarmaceuticawwds_1_filterfulltext = AV39FilterFullText ;
      AV45Formafarmaceuticawwds_2_tfformafarmaceuticaid = AV11TFFormaFarmaceuticaId ;
      AV46Formafarmaceuticawwds_3_tfformafarmaceuticaid_to = AV12TFFormaFarmaceuticaId_To ;
      AV47Formafarmaceuticawwds_4_tfformafarmaceuticacodigo = AV13TFFormaFarmaceuticaCodigo ;
      AV48Formafarmaceuticawwds_5_tfformafarmaceuticacodigo_sel = AV14TFFormaFarmaceuticaCodigo_Sel ;
      AV49Formafarmaceuticawwds_6_tfformafarmaceuticadescripcion = AV15TFFormaFarmaceuticaDescripcion ;
      AV50Formafarmaceuticawwds_7_tfformafarmaceuticadescripcion_sel = AV16TFFormaFarmaceuticaDescripcion_Sel ;
      AV51Formafarmaceuticawwds_8_tfformafarmaceuticaestado_sels = AV18TFFormaFarmaceuticaEstado_Sels ;
      AV52Formafarmaceuticawwds_9_tfformafarmaceuticadescripcion2 = AV19TFFormaFarmaceuticaDescripcion2 ;
      AV53Formafarmaceuticawwds_10_tfformafarmaceuticadescripcion2_sel = AV20TFFormaFarmaceuticaDescripcion2_Sel ;
      pr_default.dynParam(1, new Object[]{ new Object[]{
                                           A163FormaFarmaceuticaEstado ,
                                           AV51Formafarmaceuticawwds_8_tfformafarmaceuticaestado_sels ,
                                           AV44Formafarmaceuticawwds_1_filterfulltext ,
                                           Short.valueOf(AV45Formafarmaceuticawwds_2_tfformafarmaceuticaid) ,
                                           Short.valueOf(AV46Formafarmaceuticawwds_3_tfformafarmaceuticaid_to) ,
                                           AV48Formafarmaceuticawwds_5_tfformafarmaceuticacodigo_sel ,
                                           AV47Formafarmaceuticawwds_4_tfformafarmaceuticacodigo ,
                                           AV50Formafarmaceuticawwds_7_tfformafarmaceuticadescripcion_sel ,
                                           AV49Formafarmaceuticawwds_6_tfformafarmaceuticadescripcion ,
                                           Integer.valueOf(AV51Formafarmaceuticawwds_8_tfformafarmaceuticaestado_sels.size()) ,
                                           AV53Formafarmaceuticawwds_10_tfformafarmaceuticadescripcion2_sel ,
                                           AV52Formafarmaceuticawwds_9_tfformafarmaceuticadescripcion2 ,
                                           Short.valueOf(A39FormaFarmaceuticaId) ,
                                           A161FormaFarmaceuticaCodigo ,
                                           A162FormaFarmaceuticaDescripcion } ,
                                           new int[]{
                                           TypeConstants.STRING, TypeConstants.STRING, TypeConstants.SHORT, TypeConstants.SHORT, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.INT, TypeConstants.STRING,
                                           TypeConstants.STRING, TypeConstants.SHORT, TypeConstants.STRING, TypeConstants.STRING
                                           }
      });
      lV44Formafarmaceuticawwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV44Formafarmaceuticawwds_1_filterfulltext), "%", "") ;
      lV44Formafarmaceuticawwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV44Formafarmaceuticawwds_1_filterfulltext), "%", "") ;
      lV44Formafarmaceuticawwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV44Formafarmaceuticawwds_1_filterfulltext), "%", "") ;
      lV44Formafarmaceuticawwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV44Formafarmaceuticawwds_1_filterfulltext), "%", "") ;
      lV44Formafarmaceuticawwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV44Formafarmaceuticawwds_1_filterfulltext), "%", "") ;
      lV44Formafarmaceuticawwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV44Formafarmaceuticawwds_1_filterfulltext), "%", "") ;
      lV47Formafarmaceuticawwds_4_tfformafarmaceuticacodigo = GXutil.concat( GXutil.rtrim( AV47Formafarmaceuticawwds_4_tfformafarmaceuticacodigo), "%", "") ;
      lV49Formafarmaceuticawwds_6_tfformafarmaceuticadescripcion = GXutil.concat( GXutil.rtrim( AV49Formafarmaceuticawwds_6_tfformafarmaceuticadescripcion), "%", "") ;
      lV52Formafarmaceuticawwds_9_tfformafarmaceuticadescripcion2 = GXutil.concat( GXutil.rtrim( AV52Formafarmaceuticawwds_9_tfformafarmaceuticadescripcion2), "%", "") ;
      /* Using cursor P00343 */
      pr_default.execute(1, new Object[] {lV44Formafarmaceuticawwds_1_filterfulltext, lV44Formafarmaceuticawwds_1_filterfulltext, lV44Formafarmaceuticawwds_1_filterfulltext, lV44Formafarmaceuticawwds_1_filterfulltext, lV44Formafarmaceuticawwds_1_filterfulltext, lV44Formafarmaceuticawwds_1_filterfulltext, Short.valueOf(AV45Formafarmaceuticawwds_2_tfformafarmaceuticaid), Short.valueOf(AV46Formafarmaceuticawwds_3_tfformafarmaceuticaid_to), lV47Formafarmaceuticawwds_4_tfformafarmaceuticacodigo, AV48Formafarmaceuticawwds_5_tfformafarmaceuticacodigo_sel, lV49Formafarmaceuticawwds_6_tfformafarmaceuticadescripcion, AV50Formafarmaceuticawwds_7_tfformafarmaceuticadescripcion_sel, lV52Formafarmaceuticawwds_9_tfformafarmaceuticadescripcion2, AV53Formafarmaceuticawwds_10_tfformafarmaceuticadescripcion2_sel});
      while ( (pr_default.getStatus(1) != 101) )
      {
         brk344 = false ;
         A39FormaFarmaceuticaId = P00343_A39FormaFarmaceuticaId[0] ;
         A163FormaFarmaceuticaEstado = P00343_A163FormaFarmaceuticaEstado[0] ;
         A162FormaFarmaceuticaDescripcion = P00343_A162FormaFarmaceuticaDescripcion[0] ;
         A161FormaFarmaceuticaCodigo = P00343_A161FormaFarmaceuticaCodigo[0] ;
         A164FormaFarmaceuticaDescripcion2 = A161FormaFarmaceuticaCodigo + " - " + A162FormaFarmaceuticaDescripcion ;
         AV33count = 0 ;
         while ( (pr_default.getStatus(1) != 101) && ( GXutil.strcmp(P00343_A162FormaFarmaceuticaDescripcion[0], A162FormaFarmaceuticaDescripcion) == 0 ) )
         {
            brk344 = false ;
            A39FormaFarmaceuticaId = P00343_A39FormaFarmaceuticaId[0] ;
            AV33count = (long)(AV33count+1) ;
            brk344 = true ;
            pr_default.readNext(1);
         }
         if ( ! (GXutil.strcmp("", A162FormaFarmaceuticaDescripcion)==0) )
         {
            AV25Option = A162FormaFarmaceuticaDescripcion ;
            AV26Options.add(AV25Option, 0);
            AV31OptionIndexes.add(GXutil.trim( localUtil.format( DecimalUtil.doubleToDec(AV33count), "Z,ZZZ,ZZZ,ZZ9")), 0);
         }
         if ( AV26Options.size() == 50 )
         {
            /* Exit For each command. Update data (if necessary), close cursors & exit. */
            if (true) break;
         }
         if ( ! brk344 )
         {
            brk344 = true ;
            pr_default.readNext(1);
         }
      }
      pr_default.close(1);
   }

   public void S141( )
   {
      /* 'LOADFORMAFARMACEUTICADESCRIPCION2OPTIONS' Routine */
      returnInSub = false ;
      AV19TFFormaFarmaceuticaDescripcion2 = AV21SearchTxt ;
      AV20TFFormaFarmaceuticaDescripcion2_Sel = "" ;
      AV44Formafarmaceuticawwds_1_filterfulltext = AV39FilterFullText ;
      AV45Formafarmaceuticawwds_2_tfformafarmaceuticaid = AV11TFFormaFarmaceuticaId ;
      AV46Formafarmaceuticawwds_3_tfformafarmaceuticaid_to = AV12TFFormaFarmaceuticaId_To ;
      AV47Formafarmaceuticawwds_4_tfformafarmaceuticacodigo = AV13TFFormaFarmaceuticaCodigo ;
      AV48Formafarmaceuticawwds_5_tfformafarmaceuticacodigo_sel = AV14TFFormaFarmaceuticaCodigo_Sel ;
      AV49Formafarmaceuticawwds_6_tfformafarmaceuticadescripcion = AV15TFFormaFarmaceuticaDescripcion ;
      AV50Formafarmaceuticawwds_7_tfformafarmaceuticadescripcion_sel = AV16TFFormaFarmaceuticaDescripcion_Sel ;
      AV51Formafarmaceuticawwds_8_tfformafarmaceuticaestado_sels = AV18TFFormaFarmaceuticaEstado_Sels ;
      AV52Formafarmaceuticawwds_9_tfformafarmaceuticadescripcion2 = AV19TFFormaFarmaceuticaDescripcion2 ;
      AV53Formafarmaceuticawwds_10_tfformafarmaceuticadescripcion2_sel = AV20TFFormaFarmaceuticaDescripcion2_Sel ;
      pr_default.dynParam(2, new Object[]{ new Object[]{
                                           A163FormaFarmaceuticaEstado ,
                                           AV51Formafarmaceuticawwds_8_tfformafarmaceuticaestado_sels ,
                                           AV44Formafarmaceuticawwds_1_filterfulltext ,
                                           Short.valueOf(AV45Formafarmaceuticawwds_2_tfformafarmaceuticaid) ,
                                           Short.valueOf(AV46Formafarmaceuticawwds_3_tfformafarmaceuticaid_to) ,
                                           AV48Formafarmaceuticawwds_5_tfformafarmaceuticacodigo_sel ,
                                           AV47Formafarmaceuticawwds_4_tfformafarmaceuticacodigo ,
                                           AV50Formafarmaceuticawwds_7_tfformafarmaceuticadescripcion_sel ,
                                           AV49Formafarmaceuticawwds_6_tfformafarmaceuticadescripcion ,
                                           Integer.valueOf(AV51Formafarmaceuticawwds_8_tfformafarmaceuticaestado_sels.size()) ,
                                           AV53Formafarmaceuticawwds_10_tfformafarmaceuticadescripcion2_sel ,
                                           AV52Formafarmaceuticawwds_9_tfformafarmaceuticadescripcion2 ,
                                           Short.valueOf(A39FormaFarmaceuticaId) ,
                                           A161FormaFarmaceuticaCodigo ,
                                           A162FormaFarmaceuticaDescripcion } ,
                                           new int[]{
                                           TypeConstants.STRING, TypeConstants.STRING, TypeConstants.SHORT, TypeConstants.SHORT, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.INT, TypeConstants.STRING,
                                           TypeConstants.STRING, TypeConstants.SHORT, TypeConstants.STRING, TypeConstants.STRING
                                           }
      });
      lV44Formafarmaceuticawwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV44Formafarmaceuticawwds_1_filterfulltext), "%", "") ;
      lV44Formafarmaceuticawwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV44Formafarmaceuticawwds_1_filterfulltext), "%", "") ;
      lV44Formafarmaceuticawwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV44Formafarmaceuticawwds_1_filterfulltext), "%", "") ;
      lV44Formafarmaceuticawwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV44Formafarmaceuticawwds_1_filterfulltext), "%", "") ;
      lV44Formafarmaceuticawwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV44Formafarmaceuticawwds_1_filterfulltext), "%", "") ;
      lV44Formafarmaceuticawwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV44Formafarmaceuticawwds_1_filterfulltext), "%", "") ;
      lV47Formafarmaceuticawwds_4_tfformafarmaceuticacodigo = GXutil.concat( GXutil.rtrim( AV47Formafarmaceuticawwds_4_tfformafarmaceuticacodigo), "%", "") ;
      lV49Formafarmaceuticawwds_6_tfformafarmaceuticadescripcion = GXutil.concat( GXutil.rtrim( AV49Formafarmaceuticawwds_6_tfformafarmaceuticadescripcion), "%", "") ;
      lV52Formafarmaceuticawwds_9_tfformafarmaceuticadescripcion2 = GXutil.concat( GXutil.rtrim( AV52Formafarmaceuticawwds_9_tfformafarmaceuticadescripcion2), "%", "") ;
      /* Using cursor P00344 */
      pr_default.execute(2, new Object[] {lV44Formafarmaceuticawwds_1_filterfulltext, lV44Formafarmaceuticawwds_1_filterfulltext, lV44Formafarmaceuticawwds_1_filterfulltext, lV44Formafarmaceuticawwds_1_filterfulltext, lV44Formafarmaceuticawwds_1_filterfulltext, lV44Formafarmaceuticawwds_1_filterfulltext, Short.valueOf(AV45Formafarmaceuticawwds_2_tfformafarmaceuticaid), Short.valueOf(AV46Formafarmaceuticawwds_3_tfformafarmaceuticaid_to), lV47Formafarmaceuticawwds_4_tfformafarmaceuticacodigo, AV48Formafarmaceuticawwds_5_tfformafarmaceuticacodigo_sel, lV49Formafarmaceuticawwds_6_tfformafarmaceuticadescripcion, AV50Formafarmaceuticawwds_7_tfformafarmaceuticadescripcion_sel, lV52Formafarmaceuticawwds_9_tfformafarmaceuticadescripcion2, AV53Formafarmaceuticawwds_10_tfformafarmaceuticadescripcion2_sel});
      while ( (pr_default.getStatus(2) != 101) )
      {
         A39FormaFarmaceuticaId = P00344_A39FormaFarmaceuticaId[0] ;
         A163FormaFarmaceuticaEstado = P00344_A163FormaFarmaceuticaEstado[0] ;
         A162FormaFarmaceuticaDescripcion = P00344_A162FormaFarmaceuticaDescripcion[0] ;
         A161FormaFarmaceuticaCodigo = P00344_A161FormaFarmaceuticaCodigo[0] ;
         A164FormaFarmaceuticaDescripcion2 = A161FormaFarmaceuticaCodigo + " - " + A162FormaFarmaceuticaDescripcion ;
         if ( ! (GXutil.strcmp("", A164FormaFarmaceuticaDescripcion2)==0) )
         {
            AV25Option = A164FormaFarmaceuticaDescripcion2 ;
            AV24InsertIndex = 1 ;
            while ( ( AV24InsertIndex <= AV26Options.size() ) && ( GXutil.strcmp((String)AV26Options.elementAt(-1+AV24InsertIndex), AV25Option) < 0 ) )
            {
               AV24InsertIndex = (int)(AV24InsertIndex+1) ;
            }
            if ( ( AV24InsertIndex <= AV26Options.size() ) && ( GXutil.strcmp((String)AV26Options.elementAt(-1+AV24InsertIndex), AV25Option) == 0 ) )
            {
               AV33count = GXutil.lval( (String)AV31OptionIndexes.elementAt(-1+AV24InsertIndex)) ;
               AV33count = (long)(AV33count+1) ;
               AV31OptionIndexes.removeItem(AV24InsertIndex);
               AV31OptionIndexes.add(GXutil.trim( localUtil.format( DecimalUtil.doubleToDec(AV33count), "Z,ZZZ,ZZZ,ZZ9")), AV24InsertIndex);
            }
            else
            {
               AV26Options.add(AV25Option, AV24InsertIndex);
               AV31OptionIndexes.add("1", AV24InsertIndex);
            }
         }
         if ( AV26Options.size() == 50 )
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
      this.aP3[0] = formafarmaceuticawwgetfilterdata.this.AV27OptionsJson;
      this.aP4[0] = formafarmaceuticawwgetfilterdata.this.AV30OptionsDescJson;
      this.aP5[0] = formafarmaceuticawwgetfilterdata.this.AV32OptionIndexesJson;
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
      AV13TFFormaFarmaceuticaCodigo = "" ;
      AV14TFFormaFarmaceuticaCodigo_Sel = "" ;
      AV15TFFormaFarmaceuticaDescripcion = "" ;
      AV16TFFormaFarmaceuticaDescripcion_Sel = "" ;
      AV17TFFormaFarmaceuticaEstado_SelsJson = "" ;
      AV18TFFormaFarmaceuticaEstado_Sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV19TFFormaFarmaceuticaDescripcion2 = "" ;
      AV20TFFormaFarmaceuticaDescripcion2_Sel = "" ;
      A161FormaFarmaceuticaCodigo = "" ;
      AV44Formafarmaceuticawwds_1_filterfulltext = "" ;
      AV47Formafarmaceuticawwds_4_tfformafarmaceuticacodigo = "" ;
      AV48Formafarmaceuticawwds_5_tfformafarmaceuticacodigo_sel = "" ;
      AV49Formafarmaceuticawwds_6_tfformafarmaceuticadescripcion = "" ;
      AV50Formafarmaceuticawwds_7_tfformafarmaceuticadescripcion_sel = "" ;
      AV51Formafarmaceuticawwds_8_tfformafarmaceuticaestado_sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV52Formafarmaceuticawwds_9_tfformafarmaceuticadescripcion2 = "" ;
      AV53Formafarmaceuticawwds_10_tfformafarmaceuticadescripcion2_sel = "" ;
      scmdbuf = "" ;
      lV44Formafarmaceuticawwds_1_filterfulltext = "" ;
      lV47Formafarmaceuticawwds_4_tfformafarmaceuticacodigo = "" ;
      lV49Formafarmaceuticawwds_6_tfformafarmaceuticadescripcion = "" ;
      lV52Formafarmaceuticawwds_9_tfformafarmaceuticadescripcion2 = "" ;
      A163FormaFarmaceuticaEstado = "" ;
      A162FormaFarmaceuticaDescripcion = "" ;
      P00342_A39FormaFarmaceuticaId = new short[1] ;
      P00342_A163FormaFarmaceuticaEstado = new String[] {""} ;
      P00342_A162FormaFarmaceuticaDescripcion = new String[] {""} ;
      P00342_A161FormaFarmaceuticaCodigo = new String[] {""} ;
      A164FormaFarmaceuticaDescripcion2 = "" ;
      AV25Option = "" ;
      P00343_A39FormaFarmaceuticaId = new short[1] ;
      P00343_A163FormaFarmaceuticaEstado = new String[] {""} ;
      P00343_A162FormaFarmaceuticaDescripcion = new String[] {""} ;
      P00343_A161FormaFarmaceuticaCodigo = new String[] {""} ;
      P00344_A39FormaFarmaceuticaId = new short[1] ;
      P00344_A163FormaFarmaceuticaEstado = new String[] {""} ;
      P00344_A162FormaFarmaceuticaDescripcion = new String[] {""} ;
      P00344_A161FormaFarmaceuticaCodigo = new String[] {""} ;
      pr_default = new DataStoreProvider(context, remoteHandle, new com.projectthani.formafarmaceuticawwgetfilterdata__default(),
         new Object[] {
             new Object[] {
            P00342_A39FormaFarmaceuticaId, P00342_A163FormaFarmaceuticaEstado, P00342_A162FormaFarmaceuticaDescripcion, P00342_A161FormaFarmaceuticaCodigo
            }
            , new Object[] {
            P00343_A39FormaFarmaceuticaId, P00343_A163FormaFarmaceuticaEstado, P00343_A162FormaFarmaceuticaDescripcion, P00343_A161FormaFarmaceuticaCodigo
            }
            , new Object[] {
            P00344_A39FormaFarmaceuticaId, P00344_A163FormaFarmaceuticaEstado, P00344_A162FormaFarmaceuticaDescripcion, P00344_A161FormaFarmaceuticaCodigo
            }
         }
      );
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private short AV11TFFormaFarmaceuticaId ;
   private short AV12TFFormaFarmaceuticaId_To ;
   private short AV45Formafarmaceuticawwds_2_tfformafarmaceuticaid ;
   private short AV46Formafarmaceuticawwds_3_tfformafarmaceuticaid_to ;
   private short A39FormaFarmaceuticaId ;
   private short Gx_err ;
   private int AV42GXV1 ;
   private int AV51Formafarmaceuticawwds_8_tfformafarmaceuticaestado_sels_size ;
   private int AV24InsertIndex ;
   private long AV33count ;
   private String scmdbuf ;
   private String A163FormaFarmaceuticaEstado ;
   private boolean AV8IsAuthorized ;
   private boolean GXt_boolean1 ;
   private boolean GXv_boolean2[] ;
   private boolean returnInSub ;
   private boolean brk342 ;
   private boolean brk344 ;
   private String AV27OptionsJson ;
   private String AV30OptionsDescJson ;
   private String AV32OptionIndexesJson ;
   private String AV17TFFormaFarmaceuticaEstado_SelsJson ;
   private String AV23DDOName ;
   private String AV21SearchTxt ;
   private String AV22SearchTxtTo ;
   private String AV39FilterFullText ;
   private String AV13TFFormaFarmaceuticaCodigo ;
   private String AV14TFFormaFarmaceuticaCodigo_Sel ;
   private String AV15TFFormaFarmaceuticaDescripcion ;
   private String AV16TFFormaFarmaceuticaDescripcion_Sel ;
   private String AV19TFFormaFarmaceuticaDescripcion2 ;
   private String AV20TFFormaFarmaceuticaDescripcion2_Sel ;
   private String A161FormaFarmaceuticaCodigo ;
   private String AV44Formafarmaceuticawwds_1_filterfulltext ;
   private String AV47Formafarmaceuticawwds_4_tfformafarmaceuticacodigo ;
   private String AV48Formafarmaceuticawwds_5_tfformafarmaceuticacodigo_sel ;
   private String AV49Formafarmaceuticawwds_6_tfformafarmaceuticadescripcion ;
   private String AV50Formafarmaceuticawwds_7_tfformafarmaceuticadescripcion_sel ;
   private String AV52Formafarmaceuticawwds_9_tfformafarmaceuticadescripcion2 ;
   private String AV53Formafarmaceuticawwds_10_tfformafarmaceuticadescripcion2_sel ;
   private String lV44Formafarmaceuticawwds_1_filterfulltext ;
   private String lV47Formafarmaceuticawwds_4_tfformafarmaceuticacodigo ;
   private String lV49Formafarmaceuticawwds_6_tfformafarmaceuticadescripcion ;
   private String lV52Formafarmaceuticawwds_9_tfformafarmaceuticadescripcion2 ;
   private String A162FormaFarmaceuticaDescripcion ;
   private String A164FormaFarmaceuticaDescripcion2 ;
   private String AV25Option ;
   private com.genexus.webpanels.WebSession AV34Session ;
   private String[] aP5 ;
   private String[] aP3 ;
   private String[] aP4 ;
   private IDataStoreProvider pr_default ;
   private short[] P00342_A39FormaFarmaceuticaId ;
   private String[] P00342_A163FormaFarmaceuticaEstado ;
   private String[] P00342_A162FormaFarmaceuticaDescripcion ;
   private String[] P00342_A161FormaFarmaceuticaCodigo ;
   private short[] P00343_A39FormaFarmaceuticaId ;
   private String[] P00343_A163FormaFarmaceuticaEstado ;
   private String[] P00343_A162FormaFarmaceuticaDescripcion ;
   private String[] P00343_A161FormaFarmaceuticaCodigo ;
   private short[] P00344_A39FormaFarmaceuticaId ;
   private String[] P00344_A163FormaFarmaceuticaEstado ;
   private String[] P00344_A162FormaFarmaceuticaDescripcion ;
   private String[] P00344_A161FormaFarmaceuticaCodigo ;
   private GXSimpleCollection<String> AV18TFFormaFarmaceuticaEstado_Sels ;
   private GXSimpleCollection<String> AV51Formafarmaceuticawwds_8_tfformafarmaceuticaestado_sels ;
   private GXSimpleCollection<String> AV26Options ;
   private GXSimpleCollection<String> AV29OptionsDesc ;
   private GXSimpleCollection<String> AV31OptionIndexes ;
   private com.projectthani.wwpbaseobjects.SdtWWPContext AV9WWPContext ;
   private com.projectthani.wwpbaseobjects.SdtWWPContext GXv_SdtWWPContext3[] ;
   private com.projectthani.wwpbaseobjects.SdtWWPGridState AV36GridState ;
   private com.projectthani.wwpbaseobjects.SdtWWPGridState_FilterValue AV37GridStateFilterValue ;
}

final  class formafarmaceuticawwgetfilterdata__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   protected Object[] conditional_P00342( ModelContext context ,
                                          int remoteHandle ,
                                          com.genexus.IHttpContext httpContext ,
                                          String A163FormaFarmaceuticaEstado ,
                                          GXSimpleCollection<String> AV51Formafarmaceuticawwds_8_tfformafarmaceuticaestado_sels ,
                                          String AV44Formafarmaceuticawwds_1_filterfulltext ,
                                          short AV45Formafarmaceuticawwds_2_tfformafarmaceuticaid ,
                                          short AV46Formafarmaceuticawwds_3_tfformafarmaceuticaid_to ,
                                          String AV48Formafarmaceuticawwds_5_tfformafarmaceuticacodigo_sel ,
                                          String AV47Formafarmaceuticawwds_4_tfformafarmaceuticacodigo ,
                                          String AV50Formafarmaceuticawwds_7_tfformafarmaceuticadescripcion_sel ,
                                          String AV49Formafarmaceuticawwds_6_tfformafarmaceuticadescripcion ,
                                          int AV51Formafarmaceuticawwds_8_tfformafarmaceuticaestado_sels_size ,
                                          String AV53Formafarmaceuticawwds_10_tfformafarmaceuticadescripcion2_sel ,
                                          String AV52Formafarmaceuticawwds_9_tfformafarmaceuticadescripcion2 ,
                                          short A39FormaFarmaceuticaId ,
                                          String A161FormaFarmaceuticaCodigo ,
                                          String A162FormaFarmaceuticaDescripcion )
   {
      java.lang.StringBuffer sWhereString = new java.lang.StringBuffer();
      String scmdbuf;
      byte[] GXv_int4 = new byte[14];
      Object[] GXv_Object5 = new Object[2];
      scmdbuf = "SELECT [FormaFarmaceuticaId], [FormaFarmaceuticaEstado], [FormaFarmaceuticaDescripcion], [FormaFarmaceuticaCodigo] FROM [FormaFarmaceutica]" ;
      if ( ! (GXutil.strcmp("", AV44Formafarmaceuticawwds_1_filterfulltext)==0) )
      {
         addWhere(sWhereString, "(( CONVERT( char(4), CAST([FormaFarmaceuticaId] AS decimal(4,0))) like '%' + ?) or ( [FormaFarmaceuticaCodigo] like '%' + ?) or ( [FormaFarmaceuticaDescripcion] like '%' + ?) or ( 'activo' like '%' + LOWER(?) and [FormaFarmaceuticaEstado] = 'A') or ( 'inactivo' like '%' + LOWER(?) and [FormaFarmaceuticaEstado] = 'I') or ( [FormaFarmaceuticaCodigo] + ' - ' + [FormaFarmaceuticaDescripcion] like '%' + ?))");
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
      if ( ! (0==AV45Formafarmaceuticawwds_2_tfformafarmaceuticaid) )
      {
         addWhere(sWhereString, "([FormaFarmaceuticaId] >= ?)");
      }
      else
      {
         GXv_int4[6] = (byte)(1) ;
      }
      if ( ! (0==AV46Formafarmaceuticawwds_3_tfformafarmaceuticaid_to) )
      {
         addWhere(sWhereString, "([FormaFarmaceuticaId] <= ?)");
      }
      else
      {
         GXv_int4[7] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV48Formafarmaceuticawwds_5_tfformafarmaceuticacodigo_sel)==0) && ( ! (GXutil.strcmp("", AV47Formafarmaceuticawwds_4_tfformafarmaceuticacodigo)==0) ) )
      {
         addWhere(sWhereString, "([FormaFarmaceuticaCodigo] like ?)");
      }
      else
      {
         GXv_int4[8] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV48Formafarmaceuticawwds_5_tfformafarmaceuticacodigo_sel)==0) )
      {
         addWhere(sWhereString, "([FormaFarmaceuticaCodigo] = ?)");
      }
      else
      {
         GXv_int4[9] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV50Formafarmaceuticawwds_7_tfformafarmaceuticadescripcion_sel)==0) && ( ! (GXutil.strcmp("", AV49Formafarmaceuticawwds_6_tfformafarmaceuticadescripcion)==0) ) )
      {
         addWhere(sWhereString, "([FormaFarmaceuticaDescripcion] like ?)");
      }
      else
      {
         GXv_int4[10] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV50Formafarmaceuticawwds_7_tfformafarmaceuticadescripcion_sel)==0) )
      {
         addWhere(sWhereString, "([FormaFarmaceuticaDescripcion] = ?)");
      }
      else
      {
         GXv_int4[11] = (byte)(1) ;
      }
      if ( AV51Formafarmaceuticawwds_8_tfformafarmaceuticaestado_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("sqlserver", AV51Formafarmaceuticawwds_8_tfformafarmaceuticaestado_sels, "[FormaFarmaceuticaEstado] IN (", ")")+")");
      }
      if ( (GXutil.strcmp("", AV53Formafarmaceuticawwds_10_tfformafarmaceuticadescripcion2_sel)==0) && ( ! (GXutil.strcmp("", AV52Formafarmaceuticawwds_9_tfformafarmaceuticadescripcion2)==0) ) )
      {
         addWhere(sWhereString, "([FormaFarmaceuticaCodigo] + ' - ' + [FormaFarmaceuticaDescripcion] like ?)");
      }
      else
      {
         GXv_int4[12] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV53Formafarmaceuticawwds_10_tfformafarmaceuticadescripcion2_sel)==0) )
      {
         addWhere(sWhereString, "([FormaFarmaceuticaCodigo] + ' - ' + [FormaFarmaceuticaDescripcion] = ?)");
      }
      else
      {
         GXv_int4[13] = (byte)(1) ;
      }
      scmdbuf += sWhereString ;
      scmdbuf += " ORDER BY [FormaFarmaceuticaCodigo]" ;
      GXv_Object5[0] = scmdbuf ;
      GXv_Object5[1] = GXv_int4 ;
      return GXv_Object5 ;
   }

   protected Object[] conditional_P00343( ModelContext context ,
                                          int remoteHandle ,
                                          com.genexus.IHttpContext httpContext ,
                                          String A163FormaFarmaceuticaEstado ,
                                          GXSimpleCollection<String> AV51Formafarmaceuticawwds_8_tfformafarmaceuticaestado_sels ,
                                          String AV44Formafarmaceuticawwds_1_filterfulltext ,
                                          short AV45Formafarmaceuticawwds_2_tfformafarmaceuticaid ,
                                          short AV46Formafarmaceuticawwds_3_tfformafarmaceuticaid_to ,
                                          String AV48Formafarmaceuticawwds_5_tfformafarmaceuticacodigo_sel ,
                                          String AV47Formafarmaceuticawwds_4_tfformafarmaceuticacodigo ,
                                          String AV50Formafarmaceuticawwds_7_tfformafarmaceuticadescripcion_sel ,
                                          String AV49Formafarmaceuticawwds_6_tfformafarmaceuticadescripcion ,
                                          int AV51Formafarmaceuticawwds_8_tfformafarmaceuticaestado_sels_size ,
                                          String AV53Formafarmaceuticawwds_10_tfformafarmaceuticadescripcion2_sel ,
                                          String AV52Formafarmaceuticawwds_9_tfformafarmaceuticadescripcion2 ,
                                          short A39FormaFarmaceuticaId ,
                                          String A161FormaFarmaceuticaCodigo ,
                                          String A162FormaFarmaceuticaDescripcion )
   {
      java.lang.StringBuffer sWhereString = new java.lang.StringBuffer();
      String scmdbuf;
      byte[] GXv_int7 = new byte[14];
      Object[] GXv_Object8 = new Object[2];
      scmdbuf = "SELECT [FormaFarmaceuticaId], [FormaFarmaceuticaEstado], [FormaFarmaceuticaDescripcion], [FormaFarmaceuticaCodigo] FROM [FormaFarmaceutica]" ;
      if ( ! (GXutil.strcmp("", AV44Formafarmaceuticawwds_1_filterfulltext)==0) )
      {
         addWhere(sWhereString, "(( CONVERT( char(4), CAST([FormaFarmaceuticaId] AS decimal(4,0))) like '%' + ?) or ( [FormaFarmaceuticaCodigo] like '%' + ?) or ( [FormaFarmaceuticaDescripcion] like '%' + ?) or ( 'activo' like '%' + LOWER(?) and [FormaFarmaceuticaEstado] = 'A') or ( 'inactivo' like '%' + LOWER(?) and [FormaFarmaceuticaEstado] = 'I') or ( [FormaFarmaceuticaCodigo] + ' - ' + [FormaFarmaceuticaDescripcion] like '%' + ?))");
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
      if ( ! (0==AV45Formafarmaceuticawwds_2_tfformafarmaceuticaid) )
      {
         addWhere(sWhereString, "([FormaFarmaceuticaId] >= ?)");
      }
      else
      {
         GXv_int7[6] = (byte)(1) ;
      }
      if ( ! (0==AV46Formafarmaceuticawwds_3_tfformafarmaceuticaid_to) )
      {
         addWhere(sWhereString, "([FormaFarmaceuticaId] <= ?)");
      }
      else
      {
         GXv_int7[7] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV48Formafarmaceuticawwds_5_tfformafarmaceuticacodigo_sel)==0) && ( ! (GXutil.strcmp("", AV47Formafarmaceuticawwds_4_tfformafarmaceuticacodigo)==0) ) )
      {
         addWhere(sWhereString, "([FormaFarmaceuticaCodigo] like ?)");
      }
      else
      {
         GXv_int7[8] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV48Formafarmaceuticawwds_5_tfformafarmaceuticacodigo_sel)==0) )
      {
         addWhere(sWhereString, "([FormaFarmaceuticaCodigo] = ?)");
      }
      else
      {
         GXv_int7[9] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV50Formafarmaceuticawwds_7_tfformafarmaceuticadescripcion_sel)==0) && ( ! (GXutil.strcmp("", AV49Formafarmaceuticawwds_6_tfformafarmaceuticadescripcion)==0) ) )
      {
         addWhere(sWhereString, "([FormaFarmaceuticaDescripcion] like ?)");
      }
      else
      {
         GXv_int7[10] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV50Formafarmaceuticawwds_7_tfformafarmaceuticadescripcion_sel)==0) )
      {
         addWhere(sWhereString, "([FormaFarmaceuticaDescripcion] = ?)");
      }
      else
      {
         GXv_int7[11] = (byte)(1) ;
      }
      if ( AV51Formafarmaceuticawwds_8_tfformafarmaceuticaestado_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("sqlserver", AV51Formafarmaceuticawwds_8_tfformafarmaceuticaestado_sels, "[FormaFarmaceuticaEstado] IN (", ")")+")");
      }
      if ( (GXutil.strcmp("", AV53Formafarmaceuticawwds_10_tfformafarmaceuticadescripcion2_sel)==0) && ( ! (GXutil.strcmp("", AV52Formafarmaceuticawwds_9_tfformafarmaceuticadescripcion2)==0) ) )
      {
         addWhere(sWhereString, "([FormaFarmaceuticaCodigo] + ' - ' + [FormaFarmaceuticaDescripcion] like ?)");
      }
      else
      {
         GXv_int7[12] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV53Formafarmaceuticawwds_10_tfformafarmaceuticadescripcion2_sel)==0) )
      {
         addWhere(sWhereString, "([FormaFarmaceuticaCodigo] + ' - ' + [FormaFarmaceuticaDescripcion] = ?)");
      }
      else
      {
         GXv_int7[13] = (byte)(1) ;
      }
      scmdbuf += sWhereString ;
      scmdbuf += " ORDER BY [FormaFarmaceuticaDescripcion]" ;
      GXv_Object8[0] = scmdbuf ;
      GXv_Object8[1] = GXv_int7 ;
      return GXv_Object8 ;
   }

   protected Object[] conditional_P00344( ModelContext context ,
                                          int remoteHandle ,
                                          com.genexus.IHttpContext httpContext ,
                                          String A163FormaFarmaceuticaEstado ,
                                          GXSimpleCollection<String> AV51Formafarmaceuticawwds_8_tfformafarmaceuticaestado_sels ,
                                          String AV44Formafarmaceuticawwds_1_filterfulltext ,
                                          short AV45Formafarmaceuticawwds_2_tfformafarmaceuticaid ,
                                          short AV46Formafarmaceuticawwds_3_tfformafarmaceuticaid_to ,
                                          String AV48Formafarmaceuticawwds_5_tfformafarmaceuticacodigo_sel ,
                                          String AV47Formafarmaceuticawwds_4_tfformafarmaceuticacodigo ,
                                          String AV50Formafarmaceuticawwds_7_tfformafarmaceuticadescripcion_sel ,
                                          String AV49Formafarmaceuticawwds_6_tfformafarmaceuticadescripcion ,
                                          int AV51Formafarmaceuticawwds_8_tfformafarmaceuticaestado_sels_size ,
                                          String AV53Formafarmaceuticawwds_10_tfformafarmaceuticadescripcion2_sel ,
                                          String AV52Formafarmaceuticawwds_9_tfformafarmaceuticadescripcion2 ,
                                          short A39FormaFarmaceuticaId ,
                                          String A161FormaFarmaceuticaCodigo ,
                                          String A162FormaFarmaceuticaDescripcion )
   {
      java.lang.StringBuffer sWhereString = new java.lang.StringBuffer();
      String scmdbuf;
      byte[] GXv_int10 = new byte[14];
      Object[] GXv_Object11 = new Object[2];
      scmdbuf = "SELECT [FormaFarmaceuticaId], [FormaFarmaceuticaEstado], [FormaFarmaceuticaDescripcion], [FormaFarmaceuticaCodigo] FROM [FormaFarmaceutica]" ;
      if ( ! (GXutil.strcmp("", AV44Formafarmaceuticawwds_1_filterfulltext)==0) )
      {
         addWhere(sWhereString, "(( CONVERT( char(4), CAST([FormaFarmaceuticaId] AS decimal(4,0))) like '%' + ?) or ( [FormaFarmaceuticaCodigo] like '%' + ?) or ( [FormaFarmaceuticaDescripcion] like '%' + ?) or ( 'activo' like '%' + LOWER(?) and [FormaFarmaceuticaEstado] = 'A') or ( 'inactivo' like '%' + LOWER(?) and [FormaFarmaceuticaEstado] = 'I') or ( [FormaFarmaceuticaCodigo] + ' - ' + [FormaFarmaceuticaDescripcion] like '%' + ?))");
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
      if ( ! (0==AV45Formafarmaceuticawwds_2_tfformafarmaceuticaid) )
      {
         addWhere(sWhereString, "([FormaFarmaceuticaId] >= ?)");
      }
      else
      {
         GXv_int10[6] = (byte)(1) ;
      }
      if ( ! (0==AV46Formafarmaceuticawwds_3_tfformafarmaceuticaid_to) )
      {
         addWhere(sWhereString, "([FormaFarmaceuticaId] <= ?)");
      }
      else
      {
         GXv_int10[7] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV48Formafarmaceuticawwds_5_tfformafarmaceuticacodigo_sel)==0) && ( ! (GXutil.strcmp("", AV47Formafarmaceuticawwds_4_tfformafarmaceuticacodigo)==0) ) )
      {
         addWhere(sWhereString, "([FormaFarmaceuticaCodigo] like ?)");
      }
      else
      {
         GXv_int10[8] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV48Formafarmaceuticawwds_5_tfformafarmaceuticacodigo_sel)==0) )
      {
         addWhere(sWhereString, "([FormaFarmaceuticaCodigo] = ?)");
      }
      else
      {
         GXv_int10[9] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV50Formafarmaceuticawwds_7_tfformafarmaceuticadescripcion_sel)==0) && ( ! (GXutil.strcmp("", AV49Formafarmaceuticawwds_6_tfformafarmaceuticadescripcion)==0) ) )
      {
         addWhere(sWhereString, "([FormaFarmaceuticaDescripcion] like ?)");
      }
      else
      {
         GXv_int10[10] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV50Formafarmaceuticawwds_7_tfformafarmaceuticadescripcion_sel)==0) )
      {
         addWhere(sWhereString, "([FormaFarmaceuticaDescripcion] = ?)");
      }
      else
      {
         GXv_int10[11] = (byte)(1) ;
      }
      if ( AV51Formafarmaceuticawwds_8_tfformafarmaceuticaestado_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("sqlserver", AV51Formafarmaceuticawwds_8_tfformafarmaceuticaestado_sels, "[FormaFarmaceuticaEstado] IN (", ")")+")");
      }
      if ( (GXutil.strcmp("", AV53Formafarmaceuticawwds_10_tfformafarmaceuticadescripcion2_sel)==0) && ( ! (GXutil.strcmp("", AV52Formafarmaceuticawwds_9_tfformafarmaceuticadescripcion2)==0) ) )
      {
         addWhere(sWhereString, "([FormaFarmaceuticaCodigo] + ' - ' + [FormaFarmaceuticaDescripcion] like ?)");
      }
      else
      {
         GXv_int10[12] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV53Formafarmaceuticawwds_10_tfformafarmaceuticadescripcion2_sel)==0) )
      {
         addWhere(sWhereString, "([FormaFarmaceuticaCodigo] + ' - ' + [FormaFarmaceuticaDescripcion] = ?)");
      }
      else
      {
         GXv_int10[13] = (byte)(1) ;
      }
      scmdbuf += sWhereString ;
      scmdbuf += " ORDER BY [FormaFarmaceuticaId]" ;
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
                  return conditional_P00342(context, remoteHandle, httpContext, (String)dynConstraints[0] , (GXSimpleCollection<String>)dynConstraints[1] , (String)dynConstraints[2] , ((Number) dynConstraints[3]).shortValue() , ((Number) dynConstraints[4]).shortValue() , (String)dynConstraints[5] , (String)dynConstraints[6] , (String)dynConstraints[7] , (String)dynConstraints[8] , ((Number) dynConstraints[9]).intValue() , (String)dynConstraints[10] , (String)dynConstraints[11] , ((Number) dynConstraints[12]).shortValue() , (String)dynConstraints[13] , (String)dynConstraints[14] );
            case 1 :
                  return conditional_P00343(context, remoteHandle, httpContext, (String)dynConstraints[0] , (GXSimpleCollection<String>)dynConstraints[1] , (String)dynConstraints[2] , ((Number) dynConstraints[3]).shortValue() , ((Number) dynConstraints[4]).shortValue() , (String)dynConstraints[5] , (String)dynConstraints[6] , (String)dynConstraints[7] , (String)dynConstraints[8] , ((Number) dynConstraints[9]).intValue() , (String)dynConstraints[10] , (String)dynConstraints[11] , ((Number) dynConstraints[12]).shortValue() , (String)dynConstraints[13] , (String)dynConstraints[14] );
            case 2 :
                  return conditional_P00344(context, remoteHandle, httpContext, (String)dynConstraints[0] , (GXSimpleCollection<String>)dynConstraints[1] , (String)dynConstraints[2] , ((Number) dynConstraints[3]).shortValue() , ((Number) dynConstraints[4]).shortValue() , (String)dynConstraints[5] , (String)dynConstraints[6] , (String)dynConstraints[7] , (String)dynConstraints[8] , ((Number) dynConstraints[9]).intValue() , (String)dynConstraints[10] , (String)dynConstraints[11] , ((Number) dynConstraints[12]).shortValue() , (String)dynConstraints[13] , (String)dynConstraints[14] );
      }
      return super.getDynamicStatement(cursor, context, remoteHandle, httpContext, dynConstraints);
   }

   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P00342", "scmdbuf",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("P00343", "scmdbuf",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("P00344", "scmdbuf",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
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
               ((String[]) buf[1])[0] = rslt.getString(2, 1);
               ((String[]) buf[2])[0] = rslt.getVarchar(3);
               ((String[]) buf[3])[0] = rslt.getVarchar(4);
               return;
            case 1 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               ((String[]) buf[1])[0] = rslt.getString(2, 1);
               ((String[]) buf[2])[0] = rslt.getVarchar(3);
               ((String[]) buf[3])[0] = rslt.getVarchar(4);
               return;
            case 2 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               ((String[]) buf[1])[0] = rslt.getString(2, 1);
               ((String[]) buf[2])[0] = rslt.getVarchar(3);
               ((String[]) buf[3])[0] = rslt.getVarchar(4);
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
                  stmt.setVarchar(sIdx, (String)parms[24], 1000);
               }
               if ( ((Number) parms[11]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[25], 1000);
               }
               if ( ((Number) parms[12]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[26], 40);
               }
               if ( ((Number) parms[13]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[27], 40);
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
                  stmt.setVarchar(sIdx, (String)parms[24], 1000);
               }
               if ( ((Number) parms[11]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[25], 1000);
               }
               if ( ((Number) parms[12]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[26], 40);
               }
               if ( ((Number) parms[13]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[27], 40);
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
                  stmt.setVarchar(sIdx, (String)parms[24], 1000);
               }
               if ( ((Number) parms[11]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[25], 1000);
               }
               if ( ((Number) parms[12]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[26], 40);
               }
               if ( ((Number) parms[13]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[27], 40);
               }
               return;
      }
   }

}

