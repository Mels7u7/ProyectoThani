package com.projectthani ;
import com.projectthani.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class medicamentowwgetfilterdata extends GXProcedure
{
   public medicamentowwgetfilterdata( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( medicamentowwgetfilterdata.class ), "" );
   }

   public medicamentowwgetfilterdata( int remoteHandle ,
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
      medicamentowwgetfilterdata.this.aP5 = new String[] {""};
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
      medicamentowwgetfilterdata.this.AV21DDOName = aP0;
      medicamentowwgetfilterdata.this.AV19SearchTxt = aP1;
      medicamentowwgetfilterdata.this.AV20SearchTxtTo = aP2;
      medicamentowwgetfilterdata.this.aP3 = aP3;
      medicamentowwgetfilterdata.this.aP4 = aP4;
      medicamentowwgetfilterdata.this.aP5 = aP5;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      AV24Options = new GXSimpleCollection<String>(String.class, "internal", "") ;
      AV27OptionsDesc = new GXSimpleCollection<String>(String.class, "internal", "") ;
      AV29OptionIndexes = new GXSimpleCollection<String>(String.class, "internal", "") ;
      GXt_boolean1 = AV8IsAuthorized ;
      GXv_boolean2[0] = GXt_boolean1 ;
      new com.projectthani.wwpbaseobjects.secisauthbyfunctionalitykey(remoteHandle, context).execute( "WWMedicamento", GXv_boolean2) ;
      medicamentowwgetfilterdata.this.GXt_boolean1 = GXv_boolean2[0] ;
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
         if ( GXutil.strcmp(GXutil.upper( AV21DDOName), "DDO_MEDICAMENTOCODIGO") == 0 )
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
         else if ( GXutil.strcmp(GXutil.upper( AV21DDOName), "DDO_MEDICAMENTONOMBRE") == 0 )
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
         else if ( GXutil.strcmp(GXutil.upper( AV21DDOName), "DDO_MEDICAMENTOFORMAFARM") == 0 )
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
      }
      AV25OptionsJson = AV24Options.toJSonString(false) ;
      AV28OptionsDescJson = AV27OptionsDesc.toJSonString(false) ;
      AV30OptionIndexesJson = AV29OptionIndexes.toJSonString(false) ;
      cleanup();
   }

   public void S111( )
   {
      /* 'LOADGRIDSTATE' Routine */
      returnInSub = false ;
      if ( GXutil.strcmp(AV32Session.getValue("MedicamentoWWGridState"), "") == 0 )
      {
         AV34GridState.fromxml(new com.projectthani.wwpbaseobjects.loadgridstate(remoteHandle, context).executeUdp( "MedicamentoWWGridState"), null, null);
      }
      else
      {
         AV34GridState.fromxml(AV32Session.getValue("MedicamentoWWGridState"), null, null);
      }
      AV40GXV1 = 1 ;
      while ( AV40GXV1 <= AV34GridState.getgxTv_SdtWWPGridState_Filtervalues().size() )
      {
         AV35GridStateFilterValue = (com.projectthani.wwpbaseobjects.SdtWWPGridState_FilterValue)((com.projectthani.wwpbaseobjects.SdtWWPGridState_FilterValue)AV34GridState.getgxTv_SdtWWPGridState_Filtervalues().elementAt(-1+AV40GXV1));
         if ( GXutil.strcmp(AV35GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "FILTERFULLTEXT") == 0 )
         {
            AV37FilterFullText = AV35GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV35GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFMEDICAMENTOID") == 0 )
         {
            AV11TFMedicamentoId = (short)(GXutil.lval( AV35GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value())) ;
            AV12TFMedicamentoId_To = (short)(GXutil.lval( AV35GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Valueto())) ;
         }
         else if ( GXutil.strcmp(AV35GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFMEDICAMENTOCODIGO") == 0 )
         {
            AV13TFMedicamentoCodigo = AV35GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV35GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFMEDICAMENTOCODIGO_SEL") == 0 )
         {
            AV14TFMedicamentoCodigo_Sel = AV35GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV35GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFMEDICAMENTONOMBRE") == 0 )
         {
            AV15TFMedicamentoNombre = AV35GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV35GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFMEDICAMENTONOMBRE_SEL") == 0 )
         {
            AV16TFMedicamentoNombre_Sel = AV35GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV35GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFMEDICAMENTOFORMAFARM") == 0 )
         {
            AV17TFMedicamentoFormaFarm = AV35GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV35GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFMEDICAMENTOFORMAFARM_SEL") == 0 )
         {
            AV18TFMedicamentoFormaFarm_Sel = AV35GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         AV40GXV1 = (int)(AV40GXV1+1) ;
      }
   }

   public void S121( )
   {
      /* 'LOADMEDICAMENTOCODIGOOPTIONS' Routine */
      returnInSub = false ;
      AV13TFMedicamentoCodigo = AV19SearchTxt ;
      AV14TFMedicamentoCodigo_Sel = "" ;
      AV42Medicamentowwds_1_filterfulltext = AV37FilterFullText ;
      AV43Medicamentowwds_2_tfmedicamentoid = AV11TFMedicamentoId ;
      AV44Medicamentowwds_3_tfmedicamentoid_to = AV12TFMedicamentoId_To ;
      AV45Medicamentowwds_4_tfmedicamentocodigo = AV13TFMedicamentoCodigo ;
      AV46Medicamentowwds_5_tfmedicamentocodigo_sel = AV14TFMedicamentoCodigo_Sel ;
      AV47Medicamentowwds_6_tfmedicamentonombre = AV15TFMedicamentoNombre ;
      AV48Medicamentowwds_7_tfmedicamentonombre_sel = AV16TFMedicamentoNombre_Sel ;
      AV49Medicamentowwds_8_tfmedicamentoformafarm = AV17TFMedicamentoFormaFarm ;
      AV50Medicamentowwds_9_tfmedicamentoformafarm_sel = AV18TFMedicamentoFormaFarm_Sel ;
      pr_default.dynParam(0, new Object[]{ new Object[]{
                                           AV42Medicamentowwds_1_filterfulltext ,
                                           Short.valueOf(AV43Medicamentowwds_2_tfmedicamentoid) ,
                                           Short.valueOf(AV44Medicamentowwds_3_tfmedicamentoid_to) ,
                                           AV46Medicamentowwds_5_tfmedicamentocodigo_sel ,
                                           AV45Medicamentowwds_4_tfmedicamentocodigo ,
                                           AV48Medicamentowwds_7_tfmedicamentonombre_sel ,
                                           AV47Medicamentowwds_6_tfmedicamentonombre ,
                                           AV50Medicamentowwds_9_tfmedicamentoformafarm_sel ,
                                           AV49Medicamentowwds_8_tfmedicamentoformafarm ,
                                           Short.valueOf(A42MedicamentoId) ,
                                           A229MedicamentoCodigo ,
                                           A230MedicamentoNombre ,
                                           A231MedicamentoFormaFarm } ,
                                           new int[]{
                                           TypeConstants.STRING, TypeConstants.SHORT, TypeConstants.SHORT, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.SHORT,
                                           TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.BOOLEAN
                                           }
      });
      lV42Medicamentowwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV42Medicamentowwds_1_filterfulltext), "%", "") ;
      lV42Medicamentowwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV42Medicamentowwds_1_filterfulltext), "%", "") ;
      lV42Medicamentowwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV42Medicamentowwds_1_filterfulltext), "%", "") ;
      lV42Medicamentowwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV42Medicamentowwds_1_filterfulltext), "%", "") ;
      lV45Medicamentowwds_4_tfmedicamentocodigo = GXutil.concat( GXutil.rtrim( AV45Medicamentowwds_4_tfmedicamentocodigo), "%", "") ;
      lV47Medicamentowwds_6_tfmedicamentonombre = GXutil.concat( GXutil.rtrim( AV47Medicamentowwds_6_tfmedicamentonombre), "%", "") ;
      lV49Medicamentowwds_8_tfmedicamentoformafarm = GXutil.concat( GXutil.rtrim( AV49Medicamentowwds_8_tfmedicamentoformafarm), "%", "") ;
      /* Using cursor P00392 */
      pr_default.execute(0, new Object[] {lV42Medicamentowwds_1_filterfulltext, lV42Medicamentowwds_1_filterfulltext, lV42Medicamentowwds_1_filterfulltext, lV42Medicamentowwds_1_filterfulltext, Short.valueOf(AV43Medicamentowwds_2_tfmedicamentoid), Short.valueOf(AV44Medicamentowwds_3_tfmedicamentoid_to), lV45Medicamentowwds_4_tfmedicamentocodigo, AV46Medicamentowwds_5_tfmedicamentocodigo_sel, lV47Medicamentowwds_6_tfmedicamentonombre, AV48Medicamentowwds_7_tfmedicamentonombre_sel, lV49Medicamentowwds_8_tfmedicamentoformafarm, AV50Medicamentowwds_9_tfmedicamentoformafarm_sel});
      while ( (pr_default.getStatus(0) != 101) )
      {
         brk392 = false ;
         A229MedicamentoCodigo = P00392_A229MedicamentoCodigo[0] ;
         A42MedicamentoId = P00392_A42MedicamentoId[0] ;
         A231MedicamentoFormaFarm = P00392_A231MedicamentoFormaFarm[0] ;
         n231MedicamentoFormaFarm = P00392_n231MedicamentoFormaFarm[0] ;
         A230MedicamentoNombre = P00392_A230MedicamentoNombre[0] ;
         AV31count = 0 ;
         while ( (pr_default.getStatus(0) != 101) && ( GXutil.strcmp(P00392_A229MedicamentoCodigo[0], A229MedicamentoCodigo) == 0 ) )
         {
            brk392 = false ;
            A42MedicamentoId = P00392_A42MedicamentoId[0] ;
            AV31count = (long)(AV31count+1) ;
            brk392 = true ;
            pr_default.readNext(0);
         }
         if ( ! (GXutil.strcmp("", A229MedicamentoCodigo)==0) )
         {
            AV23Option = A229MedicamentoCodigo ;
            AV24Options.add(AV23Option, 0);
            AV29OptionIndexes.add(GXutil.trim( localUtil.format( DecimalUtil.doubleToDec(AV31count), "Z,ZZZ,ZZZ,ZZ9")), 0);
         }
         if ( AV24Options.size() == 50 )
         {
            /* Exit For each command. Update data (if necessary), close cursors & exit. */
            if (true) break;
         }
         if ( ! brk392 )
         {
            brk392 = true ;
            pr_default.readNext(0);
         }
      }
      pr_default.close(0);
   }

   public void S131( )
   {
      /* 'LOADMEDICAMENTONOMBREOPTIONS' Routine */
      returnInSub = false ;
      AV15TFMedicamentoNombre = AV19SearchTxt ;
      AV16TFMedicamentoNombre_Sel = "" ;
      AV42Medicamentowwds_1_filterfulltext = AV37FilterFullText ;
      AV43Medicamentowwds_2_tfmedicamentoid = AV11TFMedicamentoId ;
      AV44Medicamentowwds_3_tfmedicamentoid_to = AV12TFMedicamentoId_To ;
      AV45Medicamentowwds_4_tfmedicamentocodigo = AV13TFMedicamentoCodigo ;
      AV46Medicamentowwds_5_tfmedicamentocodigo_sel = AV14TFMedicamentoCodigo_Sel ;
      AV47Medicamentowwds_6_tfmedicamentonombre = AV15TFMedicamentoNombre ;
      AV48Medicamentowwds_7_tfmedicamentonombre_sel = AV16TFMedicamentoNombre_Sel ;
      AV49Medicamentowwds_8_tfmedicamentoformafarm = AV17TFMedicamentoFormaFarm ;
      AV50Medicamentowwds_9_tfmedicamentoformafarm_sel = AV18TFMedicamentoFormaFarm_Sel ;
      pr_default.dynParam(1, new Object[]{ new Object[]{
                                           AV42Medicamentowwds_1_filterfulltext ,
                                           Short.valueOf(AV43Medicamentowwds_2_tfmedicamentoid) ,
                                           Short.valueOf(AV44Medicamentowwds_3_tfmedicamentoid_to) ,
                                           AV46Medicamentowwds_5_tfmedicamentocodigo_sel ,
                                           AV45Medicamentowwds_4_tfmedicamentocodigo ,
                                           AV48Medicamentowwds_7_tfmedicamentonombre_sel ,
                                           AV47Medicamentowwds_6_tfmedicamentonombre ,
                                           AV50Medicamentowwds_9_tfmedicamentoformafarm_sel ,
                                           AV49Medicamentowwds_8_tfmedicamentoformafarm ,
                                           Short.valueOf(A42MedicamentoId) ,
                                           A229MedicamentoCodigo ,
                                           A230MedicamentoNombre ,
                                           A231MedicamentoFormaFarm } ,
                                           new int[]{
                                           TypeConstants.STRING, TypeConstants.SHORT, TypeConstants.SHORT, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.SHORT,
                                           TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.BOOLEAN
                                           }
      });
      lV42Medicamentowwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV42Medicamentowwds_1_filterfulltext), "%", "") ;
      lV42Medicamentowwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV42Medicamentowwds_1_filterfulltext), "%", "") ;
      lV42Medicamentowwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV42Medicamentowwds_1_filterfulltext), "%", "") ;
      lV42Medicamentowwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV42Medicamentowwds_1_filterfulltext), "%", "") ;
      lV45Medicamentowwds_4_tfmedicamentocodigo = GXutil.concat( GXutil.rtrim( AV45Medicamentowwds_4_tfmedicamentocodigo), "%", "") ;
      lV47Medicamentowwds_6_tfmedicamentonombre = GXutil.concat( GXutil.rtrim( AV47Medicamentowwds_6_tfmedicamentonombre), "%", "") ;
      lV49Medicamentowwds_8_tfmedicamentoformafarm = GXutil.concat( GXutil.rtrim( AV49Medicamentowwds_8_tfmedicamentoformafarm), "%", "") ;
      /* Using cursor P00393 */
      pr_default.execute(1, new Object[] {lV42Medicamentowwds_1_filterfulltext, lV42Medicamentowwds_1_filterfulltext, lV42Medicamentowwds_1_filterfulltext, lV42Medicamentowwds_1_filterfulltext, Short.valueOf(AV43Medicamentowwds_2_tfmedicamentoid), Short.valueOf(AV44Medicamentowwds_3_tfmedicamentoid_to), lV45Medicamentowwds_4_tfmedicamentocodigo, AV46Medicamentowwds_5_tfmedicamentocodigo_sel, lV47Medicamentowwds_6_tfmedicamentonombre, AV48Medicamentowwds_7_tfmedicamentonombre_sel, lV49Medicamentowwds_8_tfmedicamentoformafarm, AV50Medicamentowwds_9_tfmedicamentoformafarm_sel});
      while ( (pr_default.getStatus(1) != 101) )
      {
         brk394 = false ;
         A230MedicamentoNombre = P00393_A230MedicamentoNombre[0] ;
         A42MedicamentoId = P00393_A42MedicamentoId[0] ;
         A231MedicamentoFormaFarm = P00393_A231MedicamentoFormaFarm[0] ;
         n231MedicamentoFormaFarm = P00393_n231MedicamentoFormaFarm[0] ;
         A229MedicamentoCodigo = P00393_A229MedicamentoCodigo[0] ;
         AV31count = 0 ;
         while ( (pr_default.getStatus(1) != 101) && ( GXutil.strcmp(P00393_A230MedicamentoNombre[0], A230MedicamentoNombre) == 0 ) )
         {
            brk394 = false ;
            A42MedicamentoId = P00393_A42MedicamentoId[0] ;
            AV31count = (long)(AV31count+1) ;
            brk394 = true ;
            pr_default.readNext(1);
         }
         if ( ! (GXutil.strcmp("", A230MedicamentoNombre)==0) )
         {
            AV23Option = A230MedicamentoNombre ;
            AV24Options.add(AV23Option, 0);
            AV29OptionIndexes.add(GXutil.trim( localUtil.format( DecimalUtil.doubleToDec(AV31count), "Z,ZZZ,ZZZ,ZZ9")), 0);
         }
         if ( AV24Options.size() == 50 )
         {
            /* Exit For each command. Update data (if necessary), close cursors & exit. */
            if (true) break;
         }
         if ( ! brk394 )
         {
            brk394 = true ;
            pr_default.readNext(1);
         }
      }
      pr_default.close(1);
   }

   public void S141( )
   {
      /* 'LOADMEDICAMENTOFORMAFARMOPTIONS' Routine */
      returnInSub = false ;
      AV17TFMedicamentoFormaFarm = AV19SearchTxt ;
      AV18TFMedicamentoFormaFarm_Sel = "" ;
      AV42Medicamentowwds_1_filterfulltext = AV37FilterFullText ;
      AV43Medicamentowwds_2_tfmedicamentoid = AV11TFMedicamentoId ;
      AV44Medicamentowwds_3_tfmedicamentoid_to = AV12TFMedicamentoId_To ;
      AV45Medicamentowwds_4_tfmedicamentocodigo = AV13TFMedicamentoCodigo ;
      AV46Medicamentowwds_5_tfmedicamentocodigo_sel = AV14TFMedicamentoCodigo_Sel ;
      AV47Medicamentowwds_6_tfmedicamentonombre = AV15TFMedicamentoNombre ;
      AV48Medicamentowwds_7_tfmedicamentonombre_sel = AV16TFMedicamentoNombre_Sel ;
      AV49Medicamentowwds_8_tfmedicamentoformafarm = AV17TFMedicamentoFormaFarm ;
      AV50Medicamentowwds_9_tfmedicamentoformafarm_sel = AV18TFMedicamentoFormaFarm_Sel ;
      pr_default.dynParam(2, new Object[]{ new Object[]{
                                           AV42Medicamentowwds_1_filterfulltext ,
                                           Short.valueOf(AV43Medicamentowwds_2_tfmedicamentoid) ,
                                           Short.valueOf(AV44Medicamentowwds_3_tfmedicamentoid_to) ,
                                           AV46Medicamentowwds_5_tfmedicamentocodigo_sel ,
                                           AV45Medicamentowwds_4_tfmedicamentocodigo ,
                                           AV48Medicamentowwds_7_tfmedicamentonombre_sel ,
                                           AV47Medicamentowwds_6_tfmedicamentonombre ,
                                           AV50Medicamentowwds_9_tfmedicamentoformafarm_sel ,
                                           AV49Medicamentowwds_8_tfmedicamentoformafarm ,
                                           Short.valueOf(A42MedicamentoId) ,
                                           A229MedicamentoCodigo ,
                                           A230MedicamentoNombre ,
                                           A231MedicamentoFormaFarm } ,
                                           new int[]{
                                           TypeConstants.STRING, TypeConstants.SHORT, TypeConstants.SHORT, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.SHORT,
                                           TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.BOOLEAN
                                           }
      });
      lV42Medicamentowwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV42Medicamentowwds_1_filterfulltext), "%", "") ;
      lV42Medicamentowwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV42Medicamentowwds_1_filterfulltext), "%", "") ;
      lV42Medicamentowwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV42Medicamentowwds_1_filterfulltext), "%", "") ;
      lV42Medicamentowwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV42Medicamentowwds_1_filterfulltext), "%", "") ;
      lV45Medicamentowwds_4_tfmedicamentocodigo = GXutil.concat( GXutil.rtrim( AV45Medicamentowwds_4_tfmedicamentocodigo), "%", "") ;
      lV47Medicamentowwds_6_tfmedicamentonombre = GXutil.concat( GXutil.rtrim( AV47Medicamentowwds_6_tfmedicamentonombre), "%", "") ;
      lV49Medicamentowwds_8_tfmedicamentoformafarm = GXutil.concat( GXutil.rtrim( AV49Medicamentowwds_8_tfmedicamentoformafarm), "%", "") ;
      /* Using cursor P00394 */
      pr_default.execute(2, new Object[] {lV42Medicamentowwds_1_filterfulltext, lV42Medicamentowwds_1_filterfulltext, lV42Medicamentowwds_1_filterfulltext, lV42Medicamentowwds_1_filterfulltext, Short.valueOf(AV43Medicamentowwds_2_tfmedicamentoid), Short.valueOf(AV44Medicamentowwds_3_tfmedicamentoid_to), lV45Medicamentowwds_4_tfmedicamentocodigo, AV46Medicamentowwds_5_tfmedicamentocodigo_sel, lV47Medicamentowwds_6_tfmedicamentonombre, AV48Medicamentowwds_7_tfmedicamentonombre_sel, lV49Medicamentowwds_8_tfmedicamentoformafarm, AV50Medicamentowwds_9_tfmedicamentoformafarm_sel});
      while ( (pr_default.getStatus(2) != 101) )
      {
         brk396 = false ;
         A231MedicamentoFormaFarm = P00394_A231MedicamentoFormaFarm[0] ;
         n231MedicamentoFormaFarm = P00394_n231MedicamentoFormaFarm[0] ;
         A42MedicamentoId = P00394_A42MedicamentoId[0] ;
         A230MedicamentoNombre = P00394_A230MedicamentoNombre[0] ;
         A229MedicamentoCodigo = P00394_A229MedicamentoCodigo[0] ;
         AV31count = 0 ;
         while ( (pr_default.getStatus(2) != 101) && ( GXutil.strcmp(P00394_A231MedicamentoFormaFarm[0], A231MedicamentoFormaFarm) == 0 ) )
         {
            brk396 = false ;
            A42MedicamentoId = P00394_A42MedicamentoId[0] ;
            AV31count = (long)(AV31count+1) ;
            brk396 = true ;
            pr_default.readNext(2);
         }
         if ( ! (GXutil.strcmp("", A231MedicamentoFormaFarm)==0) )
         {
            AV23Option = A231MedicamentoFormaFarm ;
            AV24Options.add(AV23Option, 0);
            AV29OptionIndexes.add(GXutil.trim( localUtil.format( DecimalUtil.doubleToDec(AV31count), "Z,ZZZ,ZZZ,ZZ9")), 0);
         }
         if ( AV24Options.size() == 50 )
         {
            /* Exit For each command. Update data (if necessary), close cursors & exit. */
            if (true) break;
         }
         if ( ! brk396 )
         {
            brk396 = true ;
            pr_default.readNext(2);
         }
      }
      pr_default.close(2);
   }

   protected void cleanup( )
   {
      this.aP3[0] = medicamentowwgetfilterdata.this.AV25OptionsJson;
      this.aP4[0] = medicamentowwgetfilterdata.this.AV28OptionsDescJson;
      this.aP5[0] = medicamentowwgetfilterdata.this.AV30OptionIndexesJson;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV25OptionsJson = "" ;
      AV28OptionsDescJson = "" ;
      AV30OptionIndexesJson = "" ;
      AV24Options = new GXSimpleCollection<String>(String.class, "internal", "");
      AV27OptionsDesc = new GXSimpleCollection<String>(String.class, "internal", "");
      AV29OptionIndexes = new GXSimpleCollection<String>(String.class, "internal", "");
      GXv_boolean2 = new boolean[1] ;
      AV9WWPContext = new com.projectthani.wwpbaseobjects.SdtWWPContext(remoteHandle, context);
      GXv_SdtWWPContext3 = new com.projectthani.wwpbaseobjects.SdtWWPContext[1] ;
      AV32Session = httpContext.getWebSession();
      AV34GridState = new com.projectthani.wwpbaseobjects.SdtWWPGridState(remoteHandle, context);
      AV35GridStateFilterValue = new com.projectthani.wwpbaseobjects.SdtWWPGridState_FilterValue(remoteHandle, context);
      AV37FilterFullText = "" ;
      AV13TFMedicamentoCodigo = "" ;
      AV14TFMedicamentoCodigo_Sel = "" ;
      AV15TFMedicamentoNombre = "" ;
      AV16TFMedicamentoNombre_Sel = "" ;
      AV17TFMedicamentoFormaFarm = "" ;
      AV18TFMedicamentoFormaFarm_Sel = "" ;
      A229MedicamentoCodigo = "" ;
      AV42Medicamentowwds_1_filterfulltext = "" ;
      AV45Medicamentowwds_4_tfmedicamentocodigo = "" ;
      AV46Medicamentowwds_5_tfmedicamentocodigo_sel = "" ;
      AV47Medicamentowwds_6_tfmedicamentonombre = "" ;
      AV48Medicamentowwds_7_tfmedicamentonombre_sel = "" ;
      AV49Medicamentowwds_8_tfmedicamentoformafarm = "" ;
      AV50Medicamentowwds_9_tfmedicamentoformafarm_sel = "" ;
      scmdbuf = "" ;
      lV42Medicamentowwds_1_filterfulltext = "" ;
      lV45Medicamentowwds_4_tfmedicamentocodigo = "" ;
      lV47Medicamentowwds_6_tfmedicamentonombre = "" ;
      lV49Medicamentowwds_8_tfmedicamentoformafarm = "" ;
      A230MedicamentoNombre = "" ;
      A231MedicamentoFormaFarm = "" ;
      P00392_A229MedicamentoCodigo = new String[] {""} ;
      P00392_A42MedicamentoId = new short[1] ;
      P00392_A231MedicamentoFormaFarm = new String[] {""} ;
      P00392_n231MedicamentoFormaFarm = new boolean[] {false} ;
      P00392_A230MedicamentoNombre = new String[] {""} ;
      AV23Option = "" ;
      P00393_A230MedicamentoNombre = new String[] {""} ;
      P00393_A42MedicamentoId = new short[1] ;
      P00393_A231MedicamentoFormaFarm = new String[] {""} ;
      P00393_n231MedicamentoFormaFarm = new boolean[] {false} ;
      P00393_A229MedicamentoCodigo = new String[] {""} ;
      P00394_A231MedicamentoFormaFarm = new String[] {""} ;
      P00394_n231MedicamentoFormaFarm = new boolean[] {false} ;
      P00394_A42MedicamentoId = new short[1] ;
      P00394_A230MedicamentoNombre = new String[] {""} ;
      P00394_A229MedicamentoCodigo = new String[] {""} ;
      pr_default = new DataStoreProvider(context, remoteHandle, new com.projectthani.medicamentowwgetfilterdata__default(),
         new Object[] {
             new Object[] {
            P00392_A229MedicamentoCodigo, P00392_A42MedicamentoId, P00392_A231MedicamentoFormaFarm, P00392_n231MedicamentoFormaFarm, P00392_A230MedicamentoNombre
            }
            , new Object[] {
            P00393_A230MedicamentoNombre, P00393_A42MedicamentoId, P00393_A231MedicamentoFormaFarm, P00393_n231MedicamentoFormaFarm, P00393_A229MedicamentoCodigo
            }
            , new Object[] {
            P00394_A231MedicamentoFormaFarm, P00394_n231MedicamentoFormaFarm, P00394_A42MedicamentoId, P00394_A230MedicamentoNombre, P00394_A229MedicamentoCodigo
            }
         }
      );
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private short AV11TFMedicamentoId ;
   private short AV12TFMedicamentoId_To ;
   private short AV43Medicamentowwds_2_tfmedicamentoid ;
   private short AV44Medicamentowwds_3_tfmedicamentoid_to ;
   private short A42MedicamentoId ;
   private short Gx_err ;
   private int AV40GXV1 ;
   private long AV31count ;
   private String scmdbuf ;
   private boolean AV8IsAuthorized ;
   private boolean GXt_boolean1 ;
   private boolean GXv_boolean2[] ;
   private boolean returnInSub ;
   private boolean brk392 ;
   private boolean n231MedicamentoFormaFarm ;
   private boolean brk394 ;
   private boolean brk396 ;
   private String AV25OptionsJson ;
   private String AV28OptionsDescJson ;
   private String AV30OptionIndexesJson ;
   private String AV21DDOName ;
   private String AV19SearchTxt ;
   private String AV20SearchTxtTo ;
   private String AV37FilterFullText ;
   private String AV13TFMedicamentoCodigo ;
   private String AV14TFMedicamentoCodigo_Sel ;
   private String AV15TFMedicamentoNombre ;
   private String AV16TFMedicamentoNombre_Sel ;
   private String AV17TFMedicamentoFormaFarm ;
   private String AV18TFMedicamentoFormaFarm_Sel ;
   private String A229MedicamentoCodigo ;
   private String AV42Medicamentowwds_1_filterfulltext ;
   private String AV45Medicamentowwds_4_tfmedicamentocodigo ;
   private String AV46Medicamentowwds_5_tfmedicamentocodigo_sel ;
   private String AV47Medicamentowwds_6_tfmedicamentonombre ;
   private String AV48Medicamentowwds_7_tfmedicamentonombre_sel ;
   private String AV49Medicamentowwds_8_tfmedicamentoformafarm ;
   private String AV50Medicamentowwds_9_tfmedicamentoformafarm_sel ;
   private String lV42Medicamentowwds_1_filterfulltext ;
   private String lV45Medicamentowwds_4_tfmedicamentocodigo ;
   private String lV47Medicamentowwds_6_tfmedicamentonombre ;
   private String lV49Medicamentowwds_8_tfmedicamentoformafarm ;
   private String A230MedicamentoNombre ;
   private String A231MedicamentoFormaFarm ;
   private String AV23Option ;
   private com.genexus.webpanels.WebSession AV32Session ;
   private String[] aP5 ;
   private String[] aP3 ;
   private String[] aP4 ;
   private IDataStoreProvider pr_default ;
   private String[] P00392_A229MedicamentoCodigo ;
   private short[] P00392_A42MedicamentoId ;
   private String[] P00392_A231MedicamentoFormaFarm ;
   private boolean[] P00392_n231MedicamentoFormaFarm ;
   private String[] P00392_A230MedicamentoNombre ;
   private String[] P00393_A230MedicamentoNombre ;
   private short[] P00393_A42MedicamentoId ;
   private String[] P00393_A231MedicamentoFormaFarm ;
   private boolean[] P00393_n231MedicamentoFormaFarm ;
   private String[] P00393_A229MedicamentoCodigo ;
   private String[] P00394_A231MedicamentoFormaFarm ;
   private boolean[] P00394_n231MedicamentoFormaFarm ;
   private short[] P00394_A42MedicamentoId ;
   private String[] P00394_A230MedicamentoNombre ;
   private String[] P00394_A229MedicamentoCodigo ;
   private GXSimpleCollection<String> AV24Options ;
   private GXSimpleCollection<String> AV27OptionsDesc ;
   private GXSimpleCollection<String> AV29OptionIndexes ;
   private com.projectthani.wwpbaseobjects.SdtWWPContext AV9WWPContext ;
   private com.projectthani.wwpbaseobjects.SdtWWPContext GXv_SdtWWPContext3[] ;
   private com.projectthani.wwpbaseobjects.SdtWWPGridState AV34GridState ;
   private com.projectthani.wwpbaseobjects.SdtWWPGridState_FilterValue AV35GridStateFilterValue ;
}

final  class medicamentowwgetfilterdata__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   protected Object[] conditional_P00392( ModelContext context ,
                                          int remoteHandle ,
                                          com.genexus.IHttpContext httpContext ,
                                          String AV42Medicamentowwds_1_filterfulltext ,
                                          short AV43Medicamentowwds_2_tfmedicamentoid ,
                                          short AV44Medicamentowwds_3_tfmedicamentoid_to ,
                                          String AV46Medicamentowwds_5_tfmedicamentocodigo_sel ,
                                          String AV45Medicamentowwds_4_tfmedicamentocodigo ,
                                          String AV48Medicamentowwds_7_tfmedicamentonombre_sel ,
                                          String AV47Medicamentowwds_6_tfmedicamentonombre ,
                                          String AV50Medicamentowwds_9_tfmedicamentoformafarm_sel ,
                                          String AV49Medicamentowwds_8_tfmedicamentoformafarm ,
                                          short A42MedicamentoId ,
                                          String A229MedicamentoCodigo ,
                                          String A230MedicamentoNombre ,
                                          String A231MedicamentoFormaFarm )
   {
      java.lang.StringBuffer sWhereString = new java.lang.StringBuffer();
      String scmdbuf;
      byte[] GXv_int4 = new byte[12];
      Object[] GXv_Object5 = new Object[2];
      scmdbuf = "SELECT [MedicamentoCodigo], [MedicamentoId], [MedicamentoFormaFarm], [MedicamentoNombre] FROM [Medicamento]" ;
      if ( ! (GXutil.strcmp("", AV42Medicamentowwds_1_filterfulltext)==0) )
      {
         addWhere(sWhereString, "(( CONVERT( char(4), CAST([MedicamentoId] AS decimal(4,0))) like '%' + ?) or ( [MedicamentoCodigo] like '%' + ?) or ( [MedicamentoNombre] like '%' + ?) or ( [MedicamentoFormaFarm] like '%' + ?))");
      }
      else
      {
         GXv_int4[0] = (byte)(1) ;
         GXv_int4[1] = (byte)(1) ;
         GXv_int4[2] = (byte)(1) ;
         GXv_int4[3] = (byte)(1) ;
      }
      if ( ! (0==AV43Medicamentowwds_2_tfmedicamentoid) )
      {
         addWhere(sWhereString, "([MedicamentoId] >= ?)");
      }
      else
      {
         GXv_int4[4] = (byte)(1) ;
      }
      if ( ! (0==AV44Medicamentowwds_3_tfmedicamentoid_to) )
      {
         addWhere(sWhereString, "([MedicamentoId] <= ?)");
      }
      else
      {
         GXv_int4[5] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV46Medicamentowwds_5_tfmedicamentocodigo_sel)==0) && ( ! (GXutil.strcmp("", AV45Medicamentowwds_4_tfmedicamentocodigo)==0) ) )
      {
         addWhere(sWhereString, "([MedicamentoCodigo] like ?)");
      }
      else
      {
         GXv_int4[6] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV46Medicamentowwds_5_tfmedicamentocodigo_sel)==0) )
      {
         addWhere(sWhereString, "([MedicamentoCodigo] = ?)");
      }
      else
      {
         GXv_int4[7] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV48Medicamentowwds_7_tfmedicamentonombre_sel)==0) && ( ! (GXutil.strcmp("", AV47Medicamentowwds_6_tfmedicamentonombre)==0) ) )
      {
         addWhere(sWhereString, "([MedicamentoNombre] like ?)");
      }
      else
      {
         GXv_int4[8] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV48Medicamentowwds_7_tfmedicamentonombre_sel)==0) )
      {
         addWhere(sWhereString, "([MedicamentoNombre] = ?)");
      }
      else
      {
         GXv_int4[9] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV50Medicamentowwds_9_tfmedicamentoformafarm_sel)==0) && ( ! (GXutil.strcmp("", AV49Medicamentowwds_8_tfmedicamentoformafarm)==0) ) )
      {
         addWhere(sWhereString, "([MedicamentoFormaFarm] like ?)");
      }
      else
      {
         GXv_int4[10] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV50Medicamentowwds_9_tfmedicamentoformafarm_sel)==0) )
      {
         addWhere(sWhereString, "([MedicamentoFormaFarm] = ?)");
      }
      else
      {
         GXv_int4[11] = (byte)(1) ;
      }
      scmdbuf += sWhereString ;
      scmdbuf += " ORDER BY [MedicamentoCodigo]" ;
      GXv_Object5[0] = scmdbuf ;
      GXv_Object5[1] = GXv_int4 ;
      return GXv_Object5 ;
   }

   protected Object[] conditional_P00393( ModelContext context ,
                                          int remoteHandle ,
                                          com.genexus.IHttpContext httpContext ,
                                          String AV42Medicamentowwds_1_filterfulltext ,
                                          short AV43Medicamentowwds_2_tfmedicamentoid ,
                                          short AV44Medicamentowwds_3_tfmedicamentoid_to ,
                                          String AV46Medicamentowwds_5_tfmedicamentocodigo_sel ,
                                          String AV45Medicamentowwds_4_tfmedicamentocodigo ,
                                          String AV48Medicamentowwds_7_tfmedicamentonombre_sel ,
                                          String AV47Medicamentowwds_6_tfmedicamentonombre ,
                                          String AV50Medicamentowwds_9_tfmedicamentoformafarm_sel ,
                                          String AV49Medicamentowwds_8_tfmedicamentoformafarm ,
                                          short A42MedicamentoId ,
                                          String A229MedicamentoCodigo ,
                                          String A230MedicamentoNombre ,
                                          String A231MedicamentoFormaFarm )
   {
      java.lang.StringBuffer sWhereString = new java.lang.StringBuffer();
      String scmdbuf;
      byte[] GXv_int6 = new byte[12];
      Object[] GXv_Object7 = new Object[2];
      scmdbuf = "SELECT [MedicamentoNombre], [MedicamentoId], [MedicamentoFormaFarm], [MedicamentoCodigo] FROM [Medicamento]" ;
      if ( ! (GXutil.strcmp("", AV42Medicamentowwds_1_filterfulltext)==0) )
      {
         addWhere(sWhereString, "(( CONVERT( char(4), CAST([MedicamentoId] AS decimal(4,0))) like '%' + ?) or ( [MedicamentoCodigo] like '%' + ?) or ( [MedicamentoNombre] like '%' + ?) or ( [MedicamentoFormaFarm] like '%' + ?))");
      }
      else
      {
         GXv_int6[0] = (byte)(1) ;
         GXv_int6[1] = (byte)(1) ;
         GXv_int6[2] = (byte)(1) ;
         GXv_int6[3] = (byte)(1) ;
      }
      if ( ! (0==AV43Medicamentowwds_2_tfmedicamentoid) )
      {
         addWhere(sWhereString, "([MedicamentoId] >= ?)");
      }
      else
      {
         GXv_int6[4] = (byte)(1) ;
      }
      if ( ! (0==AV44Medicamentowwds_3_tfmedicamentoid_to) )
      {
         addWhere(sWhereString, "([MedicamentoId] <= ?)");
      }
      else
      {
         GXv_int6[5] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV46Medicamentowwds_5_tfmedicamentocodigo_sel)==0) && ( ! (GXutil.strcmp("", AV45Medicamentowwds_4_tfmedicamentocodigo)==0) ) )
      {
         addWhere(sWhereString, "([MedicamentoCodigo] like ?)");
      }
      else
      {
         GXv_int6[6] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV46Medicamentowwds_5_tfmedicamentocodigo_sel)==0) )
      {
         addWhere(sWhereString, "([MedicamentoCodigo] = ?)");
      }
      else
      {
         GXv_int6[7] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV48Medicamentowwds_7_tfmedicamentonombre_sel)==0) && ( ! (GXutil.strcmp("", AV47Medicamentowwds_6_tfmedicamentonombre)==0) ) )
      {
         addWhere(sWhereString, "([MedicamentoNombre] like ?)");
      }
      else
      {
         GXv_int6[8] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV48Medicamentowwds_7_tfmedicamentonombre_sel)==0) )
      {
         addWhere(sWhereString, "([MedicamentoNombre] = ?)");
      }
      else
      {
         GXv_int6[9] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV50Medicamentowwds_9_tfmedicamentoformafarm_sel)==0) && ( ! (GXutil.strcmp("", AV49Medicamentowwds_8_tfmedicamentoformafarm)==0) ) )
      {
         addWhere(sWhereString, "([MedicamentoFormaFarm] like ?)");
      }
      else
      {
         GXv_int6[10] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV50Medicamentowwds_9_tfmedicamentoformafarm_sel)==0) )
      {
         addWhere(sWhereString, "([MedicamentoFormaFarm] = ?)");
      }
      else
      {
         GXv_int6[11] = (byte)(1) ;
      }
      scmdbuf += sWhereString ;
      scmdbuf += " ORDER BY [MedicamentoNombre]" ;
      GXv_Object7[0] = scmdbuf ;
      GXv_Object7[1] = GXv_int6 ;
      return GXv_Object7 ;
   }

   protected Object[] conditional_P00394( ModelContext context ,
                                          int remoteHandle ,
                                          com.genexus.IHttpContext httpContext ,
                                          String AV42Medicamentowwds_1_filterfulltext ,
                                          short AV43Medicamentowwds_2_tfmedicamentoid ,
                                          short AV44Medicamentowwds_3_tfmedicamentoid_to ,
                                          String AV46Medicamentowwds_5_tfmedicamentocodigo_sel ,
                                          String AV45Medicamentowwds_4_tfmedicamentocodigo ,
                                          String AV48Medicamentowwds_7_tfmedicamentonombre_sel ,
                                          String AV47Medicamentowwds_6_tfmedicamentonombre ,
                                          String AV50Medicamentowwds_9_tfmedicamentoformafarm_sel ,
                                          String AV49Medicamentowwds_8_tfmedicamentoformafarm ,
                                          short A42MedicamentoId ,
                                          String A229MedicamentoCodigo ,
                                          String A230MedicamentoNombre ,
                                          String A231MedicamentoFormaFarm )
   {
      java.lang.StringBuffer sWhereString = new java.lang.StringBuffer();
      String scmdbuf;
      byte[] GXv_int8 = new byte[12];
      Object[] GXv_Object9 = new Object[2];
      scmdbuf = "SELECT [MedicamentoFormaFarm], [MedicamentoId], [MedicamentoNombre], [MedicamentoCodigo] FROM [Medicamento]" ;
      if ( ! (GXutil.strcmp("", AV42Medicamentowwds_1_filterfulltext)==0) )
      {
         addWhere(sWhereString, "(( CONVERT( char(4), CAST([MedicamentoId] AS decimal(4,0))) like '%' + ?) or ( [MedicamentoCodigo] like '%' + ?) or ( [MedicamentoNombre] like '%' + ?) or ( [MedicamentoFormaFarm] like '%' + ?))");
      }
      else
      {
         GXv_int8[0] = (byte)(1) ;
         GXv_int8[1] = (byte)(1) ;
         GXv_int8[2] = (byte)(1) ;
         GXv_int8[3] = (byte)(1) ;
      }
      if ( ! (0==AV43Medicamentowwds_2_tfmedicamentoid) )
      {
         addWhere(sWhereString, "([MedicamentoId] >= ?)");
      }
      else
      {
         GXv_int8[4] = (byte)(1) ;
      }
      if ( ! (0==AV44Medicamentowwds_3_tfmedicamentoid_to) )
      {
         addWhere(sWhereString, "([MedicamentoId] <= ?)");
      }
      else
      {
         GXv_int8[5] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV46Medicamentowwds_5_tfmedicamentocodigo_sel)==0) && ( ! (GXutil.strcmp("", AV45Medicamentowwds_4_tfmedicamentocodigo)==0) ) )
      {
         addWhere(sWhereString, "([MedicamentoCodigo] like ?)");
      }
      else
      {
         GXv_int8[6] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV46Medicamentowwds_5_tfmedicamentocodigo_sel)==0) )
      {
         addWhere(sWhereString, "([MedicamentoCodigo] = ?)");
      }
      else
      {
         GXv_int8[7] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV48Medicamentowwds_7_tfmedicamentonombre_sel)==0) && ( ! (GXutil.strcmp("", AV47Medicamentowwds_6_tfmedicamentonombre)==0) ) )
      {
         addWhere(sWhereString, "([MedicamentoNombre] like ?)");
      }
      else
      {
         GXv_int8[8] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV48Medicamentowwds_7_tfmedicamentonombre_sel)==0) )
      {
         addWhere(sWhereString, "([MedicamentoNombre] = ?)");
      }
      else
      {
         GXv_int8[9] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV50Medicamentowwds_9_tfmedicamentoformafarm_sel)==0) && ( ! (GXutil.strcmp("", AV49Medicamentowwds_8_tfmedicamentoformafarm)==0) ) )
      {
         addWhere(sWhereString, "([MedicamentoFormaFarm] like ?)");
      }
      else
      {
         GXv_int8[10] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV50Medicamentowwds_9_tfmedicamentoformafarm_sel)==0) )
      {
         addWhere(sWhereString, "([MedicamentoFormaFarm] = ?)");
      }
      else
      {
         GXv_int8[11] = (byte)(1) ;
      }
      scmdbuf += sWhereString ;
      scmdbuf += " ORDER BY [MedicamentoFormaFarm]" ;
      GXv_Object9[0] = scmdbuf ;
      GXv_Object9[1] = GXv_int8 ;
      return GXv_Object9 ;
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
                  return conditional_P00392(context, remoteHandle, httpContext, (String)dynConstraints[0] , ((Number) dynConstraints[1]).shortValue() , ((Number) dynConstraints[2]).shortValue() , (String)dynConstraints[3] , (String)dynConstraints[4] , (String)dynConstraints[5] , (String)dynConstraints[6] , (String)dynConstraints[7] , (String)dynConstraints[8] , ((Number) dynConstraints[9]).shortValue() , (String)dynConstraints[10] , (String)dynConstraints[11] , (String)dynConstraints[12] );
            case 1 :
                  return conditional_P00393(context, remoteHandle, httpContext, (String)dynConstraints[0] , ((Number) dynConstraints[1]).shortValue() , ((Number) dynConstraints[2]).shortValue() , (String)dynConstraints[3] , (String)dynConstraints[4] , (String)dynConstraints[5] , (String)dynConstraints[6] , (String)dynConstraints[7] , (String)dynConstraints[8] , ((Number) dynConstraints[9]).shortValue() , (String)dynConstraints[10] , (String)dynConstraints[11] , (String)dynConstraints[12] );
            case 2 :
                  return conditional_P00394(context, remoteHandle, httpContext, (String)dynConstraints[0] , ((Number) dynConstraints[1]).shortValue() , ((Number) dynConstraints[2]).shortValue() , (String)dynConstraints[3] , (String)dynConstraints[4] , (String)dynConstraints[5] , (String)dynConstraints[6] , (String)dynConstraints[7] , (String)dynConstraints[8] , ((Number) dynConstraints[9]).shortValue() , (String)dynConstraints[10] , (String)dynConstraints[11] , (String)dynConstraints[12] );
      }
      return super.getDynamicStatement(cursor, context, remoteHandle, httpContext, dynConstraints);
   }

   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P00392", "scmdbuf",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("P00393", "scmdbuf",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("P00394", "scmdbuf",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
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
               ((String[]) buf[2])[0] = rslt.getVarchar(3);
               ((boolean[]) buf[3])[0] = rslt.wasNull();
               ((String[]) buf[4])[0] = rslt.getVarchar(4);
               return;
            case 1 :
               ((String[]) buf[0])[0] = rslt.getVarchar(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((String[]) buf[2])[0] = rslt.getVarchar(3);
               ((boolean[]) buf[3])[0] = rslt.wasNull();
               ((String[]) buf[4])[0] = rslt.getVarchar(4);
               return;
            case 2 :
               ((String[]) buf[0])[0] = rslt.getVarchar(1);
               ((boolean[]) buf[1])[0] = rslt.wasNull();
               ((short[]) buf[2])[0] = rslt.getShort(2);
               ((String[]) buf[3])[0] = rslt.getVarchar(3);
               ((String[]) buf[4])[0] = rslt.getVarchar(4);
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
                  stmt.setVarchar(sIdx, (String)parms[12], 100);
               }
               if ( ((Number) parms[1]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[13], 100);
               }
               if ( ((Number) parms[2]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[14], 100);
               }
               if ( ((Number) parms[3]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[15], 100);
               }
               if ( ((Number) parms[4]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[16]).shortValue());
               }
               if ( ((Number) parms[5]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[17]).shortValue());
               }
               if ( ((Number) parms[6]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[18], 15);
               }
               if ( ((Number) parms[7]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[19], 15);
               }
               if ( ((Number) parms[8]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[20], 100);
               }
               if ( ((Number) parms[9]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[21], 100);
               }
               if ( ((Number) parms[10]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[22], 40);
               }
               if ( ((Number) parms[11]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[23], 40);
               }
               return;
            case 1 :
               sIdx = (short)(0) ;
               if ( ((Number) parms[0]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[12], 100);
               }
               if ( ((Number) parms[1]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[13], 100);
               }
               if ( ((Number) parms[2]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[14], 100);
               }
               if ( ((Number) parms[3]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[15], 100);
               }
               if ( ((Number) parms[4]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[16]).shortValue());
               }
               if ( ((Number) parms[5]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[17]).shortValue());
               }
               if ( ((Number) parms[6]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[18], 15);
               }
               if ( ((Number) parms[7]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[19], 15);
               }
               if ( ((Number) parms[8]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[20], 100);
               }
               if ( ((Number) parms[9]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[21], 100);
               }
               if ( ((Number) parms[10]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[22], 40);
               }
               if ( ((Number) parms[11]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[23], 40);
               }
               return;
            case 2 :
               sIdx = (short)(0) ;
               if ( ((Number) parms[0]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[12], 100);
               }
               if ( ((Number) parms[1]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[13], 100);
               }
               if ( ((Number) parms[2]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[14], 100);
               }
               if ( ((Number) parms[3]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[15], 100);
               }
               if ( ((Number) parms[4]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[16]).shortValue());
               }
               if ( ((Number) parms[5]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[17]).shortValue());
               }
               if ( ((Number) parms[6]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[18], 15);
               }
               if ( ((Number) parms[7]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[19], 15);
               }
               if ( ((Number) parms[8]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[20], 100);
               }
               if ( ((Number) parms[9]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[21], 100);
               }
               if ( ((Number) parms[10]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[22], 40);
               }
               if ( ((Number) parms[11]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[23], 40);
               }
               return;
      }
   }

}

