package com.projectthani ;
import com.projectthani.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class drogueriawwgetfilterdata extends GXProcedure
{
   public drogueriawwgetfilterdata( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( drogueriawwgetfilterdata.class ), "" );
   }

   public drogueriawwgetfilterdata( int remoteHandle ,
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
      drogueriawwgetfilterdata.this.aP5 = new String[] {""};
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
      drogueriawwgetfilterdata.this.AV27DDOName = aP0;
      drogueriawwgetfilterdata.this.AV25SearchTxt = aP1;
      drogueriawwgetfilterdata.this.AV26SearchTxtTo = aP2;
      drogueriawwgetfilterdata.this.aP3 = aP3;
      drogueriawwgetfilterdata.this.aP4 = aP4;
      drogueriawwgetfilterdata.this.aP5 = aP5;
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
      new com.projectthani.wwpbaseobjects.secisauthbyfunctionalitykey(remoteHandle, context).execute( "WWDrogueria", GXv_boolean2) ;
      drogueriawwgetfilterdata.this.GXt_boolean1 = GXv_boolean2[0] ;
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
         if ( GXutil.strcmp(GXutil.upper( AV27DDOName), "DDO_DROGUERIANOMBRE") == 0 )
         {
            /* Execute user subroutine: 'LOADDROGUERIANOMBREOPTIONS' */
            S121 ();
            if ( returnInSub )
            {
               returnInSub = true;
               cleanup();
               if (true) return;
            }
         }
         else if ( GXutil.strcmp(GXutil.upper( AV27DDOName), "DDO_DROGUERIADESCRIPCION") == 0 )
         {
            /* Execute user subroutine: 'LOADDROGUERIADESCRIPCIONOPTIONS' */
            S131 ();
            if ( returnInSub )
            {
               returnInSub = true;
               cleanup();
               if (true) return;
            }
         }
         else if ( GXutil.strcmp(GXutil.upper( AV27DDOName), "DDO_DROGUERIANRODOCUMENTO") == 0 )
         {
            /* Execute user subroutine: 'LOADDROGUERIANRODOCUMENTOOPTIONS' */
            S141 ();
            if ( returnInSub )
            {
               returnInSub = true;
               cleanup();
               if (true) return;
            }
         }
         else if ( GXutil.strcmp(GXutil.upper( AV27DDOName), "DDO_DROGUERIADIRECCION") == 0 )
         {
            /* Execute user subroutine: 'LOADDROGUERIADIRECCIONOPTIONS' */
            S151 ();
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
      if ( GXutil.strcmp(AV38Session.getValue("DrogueriaWWGridState"), "") == 0 )
      {
         AV40GridState.fromxml(new com.projectthani.wwpbaseobjects.loadgridstate(remoteHandle, context).executeUdp( "DrogueriaWWGridState"), null, null);
      }
      else
      {
         AV40GridState.fromxml(AV38Session.getValue("DrogueriaWWGridState"), null, null);
      }
      AV46GXV1 = 1 ;
      while ( AV46GXV1 <= AV40GridState.getgxTv_SdtWWPGridState_Filtervalues().size() )
      {
         AV41GridStateFilterValue = (com.projectthani.wwpbaseobjects.SdtWWPGridState_FilterValue)((com.projectthani.wwpbaseobjects.SdtWWPGridState_FilterValue)AV40GridState.getgxTv_SdtWWPGridState_Filtervalues().elementAt(-1+AV46GXV1));
         if ( GXutil.strcmp(AV41GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "FILTERFULLTEXT") == 0 )
         {
            AV43FilterFullText = AV41GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV41GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFDROGUERIAID") == 0 )
         {
            AV11TFDrogueriaId = (short)(GXutil.lval( AV41GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value())) ;
            AV12TFDrogueriaId_To = (short)(GXutil.lval( AV41GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Valueto())) ;
         }
         else if ( GXutil.strcmp(AV41GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFDROGUERIANOMBRE") == 0 )
         {
            AV13TFDrogueriaNombre = AV41GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV41GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFDROGUERIANOMBRE_SEL") == 0 )
         {
            AV14TFDrogueriaNombre_Sel = AV41GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV41GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFDROGUERIADESCRIPCION") == 0 )
         {
            AV15TFDrogueriaDescripcion = AV41GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV41GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFDROGUERIADESCRIPCION_SEL") == 0 )
         {
            AV16TFDrogueriaDescripcion_Sel = AV41GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV41GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFDROGUERIATIPODOCUMENTO_SEL") == 0 )
         {
            AV17TFDrogueriaTipoDocumento_SelsJson = AV41GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            AV18TFDrogueriaTipoDocumento_Sels.fromJSonString(AV17TFDrogueriaTipoDocumento_SelsJson, null);
         }
         else if ( GXutil.strcmp(AV41GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFDROGUERIANRODOCUMENTO") == 0 )
         {
            AV19TFDrogueriaNroDocumento = AV41GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV41GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFDROGUERIANRODOCUMENTO_SEL") == 0 )
         {
            AV20TFDrogueriaNroDocumento_Sel = AV41GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV41GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFDROGUERIADIRECCION") == 0 )
         {
            AV21TFDrogueriaDireccion = AV41GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV41GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFDROGUERIADIRECCION_SEL") == 0 )
         {
            AV22TFDrogueriaDireccion_Sel = AV41GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV41GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFDROGUERIAESTADO_SEL") == 0 )
         {
            AV23TFDrogueriaEstado_SelsJson = AV41GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            AV24TFDrogueriaEstado_Sels.fromJSonString(AV23TFDrogueriaEstado_SelsJson, null);
         }
         AV46GXV1 = (int)(AV46GXV1+1) ;
      }
   }

   public void S121( )
   {
      /* 'LOADDROGUERIANOMBREOPTIONS' Routine */
      returnInSub = false ;
      AV13TFDrogueriaNombre = AV25SearchTxt ;
      AV14TFDrogueriaNombre_Sel = "" ;
      AV48Drogueriawwds_1_filterfulltext = AV43FilterFullText ;
      AV49Drogueriawwds_2_tfdrogueriaid = AV11TFDrogueriaId ;
      AV50Drogueriawwds_3_tfdrogueriaid_to = AV12TFDrogueriaId_To ;
      AV51Drogueriawwds_4_tfdroguerianombre = AV13TFDrogueriaNombre ;
      AV52Drogueriawwds_5_tfdroguerianombre_sel = AV14TFDrogueriaNombre_Sel ;
      AV53Drogueriawwds_6_tfdrogueriadescripcion = AV15TFDrogueriaDescripcion ;
      AV54Drogueriawwds_7_tfdrogueriadescripcion_sel = AV16TFDrogueriaDescripcion_Sel ;
      AV55Drogueriawwds_8_tfdrogueriatipodocumento_sels = AV18TFDrogueriaTipoDocumento_Sels ;
      AV56Drogueriawwds_9_tfdroguerianrodocumento = AV19TFDrogueriaNroDocumento ;
      AV57Drogueriawwds_10_tfdroguerianrodocumento_sel = AV20TFDrogueriaNroDocumento_Sel ;
      AV58Drogueriawwds_11_tfdrogueriadireccion = AV21TFDrogueriaDireccion ;
      AV59Drogueriawwds_12_tfdrogueriadireccion_sel = AV22TFDrogueriaDireccion_Sel ;
      AV60Drogueriawwds_13_tfdrogueriaestado_sels = AV24TFDrogueriaEstado_Sels ;
      pr_default.dynParam(0, new Object[]{ new Object[]{
                                           A143DrogueriaTipoDocumento ,
                                           AV55Drogueriawwds_8_tfdrogueriatipodocumento_sels ,
                                           A147DrogueriaEstado ,
                                           AV60Drogueriawwds_13_tfdrogueriaestado_sels ,
                                           AV48Drogueriawwds_1_filterfulltext ,
                                           Short.valueOf(AV49Drogueriawwds_2_tfdrogueriaid) ,
                                           Short.valueOf(AV50Drogueriawwds_3_tfdrogueriaid_to) ,
                                           AV52Drogueriawwds_5_tfdroguerianombre_sel ,
                                           AV51Drogueriawwds_4_tfdroguerianombre ,
                                           AV54Drogueriawwds_7_tfdrogueriadescripcion_sel ,
                                           AV53Drogueriawwds_6_tfdrogueriadescripcion ,
                                           Integer.valueOf(AV55Drogueriawwds_8_tfdrogueriatipodocumento_sels.size()) ,
                                           AV57Drogueriawwds_10_tfdroguerianrodocumento_sel ,
                                           AV56Drogueriawwds_9_tfdroguerianrodocumento ,
                                           AV59Drogueriawwds_12_tfdrogueriadireccion_sel ,
                                           AV58Drogueriawwds_11_tfdrogueriadireccion ,
                                           Integer.valueOf(AV60Drogueriawwds_13_tfdrogueriaestado_sels.size()) ,
                                           Short.valueOf(A36DrogueriaId) ,
                                           A141DrogueriaNombre ,
                                           A142DrogueriaDescripcion ,
                                           A144DrogueriaNroDocumento ,
                                           A145DrogueriaDireccion } ,
                                           new int[]{
                                           TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.SHORT, TypeConstants.SHORT, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.INT,
                                           TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.INT, TypeConstants.SHORT, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING
                                           }
      });
      lV48Drogueriawwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV48Drogueriawwds_1_filterfulltext), "%", "") ;
      lV48Drogueriawwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV48Drogueriawwds_1_filterfulltext), "%", "") ;
      lV48Drogueriawwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV48Drogueriawwds_1_filterfulltext), "%", "") ;
      lV48Drogueriawwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV48Drogueriawwds_1_filterfulltext), "%", "") ;
      lV48Drogueriawwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV48Drogueriawwds_1_filterfulltext), "%", "") ;
      lV48Drogueriawwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV48Drogueriawwds_1_filterfulltext), "%", "") ;
      lV48Drogueriawwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV48Drogueriawwds_1_filterfulltext), "%", "") ;
      lV48Drogueriawwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV48Drogueriawwds_1_filterfulltext), "%", "") ;
      lV48Drogueriawwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV48Drogueriawwds_1_filterfulltext), "%", "") ;
      lV48Drogueriawwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV48Drogueriawwds_1_filterfulltext), "%", "") ;
      lV48Drogueriawwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV48Drogueriawwds_1_filterfulltext), "%", "") ;
      lV48Drogueriawwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV48Drogueriawwds_1_filterfulltext), "%", "") ;
      lV48Drogueriawwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV48Drogueriawwds_1_filterfulltext), "%", "") ;
      lV51Drogueriawwds_4_tfdroguerianombre = GXutil.concat( GXutil.rtrim( AV51Drogueriawwds_4_tfdroguerianombre), "%", "") ;
      lV53Drogueriawwds_6_tfdrogueriadescripcion = GXutil.concat( GXutil.rtrim( AV53Drogueriawwds_6_tfdrogueriadescripcion), "%", "") ;
      lV56Drogueriawwds_9_tfdroguerianrodocumento = GXutil.concat( GXutil.rtrim( AV56Drogueriawwds_9_tfdroguerianrodocumento), "%", "") ;
      lV58Drogueriawwds_11_tfdrogueriadireccion = GXutil.concat( GXutil.rtrim( AV58Drogueriawwds_11_tfdrogueriadireccion), "%", "") ;
      /* Using cursor P002Z2 */
      pr_default.execute(0, new Object[] {lV48Drogueriawwds_1_filterfulltext, lV48Drogueriawwds_1_filterfulltext, lV48Drogueriawwds_1_filterfulltext, lV48Drogueriawwds_1_filterfulltext, lV48Drogueriawwds_1_filterfulltext, lV48Drogueriawwds_1_filterfulltext, lV48Drogueriawwds_1_filterfulltext, lV48Drogueriawwds_1_filterfulltext, lV48Drogueriawwds_1_filterfulltext, lV48Drogueriawwds_1_filterfulltext, lV48Drogueriawwds_1_filterfulltext, lV48Drogueriawwds_1_filterfulltext, lV48Drogueriawwds_1_filterfulltext, Short.valueOf(AV49Drogueriawwds_2_tfdrogueriaid), Short.valueOf(AV50Drogueriawwds_3_tfdrogueriaid_to), lV51Drogueriawwds_4_tfdroguerianombre, AV52Drogueriawwds_5_tfdroguerianombre_sel, lV53Drogueriawwds_6_tfdrogueriadescripcion, AV54Drogueriawwds_7_tfdrogueriadescripcion_sel, lV56Drogueriawwds_9_tfdroguerianrodocumento, AV57Drogueriawwds_10_tfdroguerianrodocumento_sel, lV58Drogueriawwds_11_tfdrogueriadireccion, AV59Drogueriawwds_12_tfdrogueriadireccion_sel});
      while ( (pr_default.getStatus(0) != 101) )
      {
         brk2Z2 = false ;
         A141DrogueriaNombre = P002Z2_A141DrogueriaNombre[0] ;
         A36DrogueriaId = P002Z2_A36DrogueriaId[0] ;
         A147DrogueriaEstado = P002Z2_A147DrogueriaEstado[0] ;
         A145DrogueriaDireccion = P002Z2_A145DrogueriaDireccion[0] ;
         A144DrogueriaNroDocumento = P002Z2_A144DrogueriaNroDocumento[0] ;
         A143DrogueriaTipoDocumento = P002Z2_A143DrogueriaTipoDocumento[0] ;
         A142DrogueriaDescripcion = P002Z2_A142DrogueriaDescripcion[0] ;
         AV37count = 0 ;
         while ( (pr_default.getStatus(0) != 101) && ( GXutil.strcmp(P002Z2_A141DrogueriaNombre[0], A141DrogueriaNombre) == 0 ) )
         {
            brk2Z2 = false ;
            A36DrogueriaId = P002Z2_A36DrogueriaId[0] ;
            AV37count = (long)(AV37count+1) ;
            brk2Z2 = true ;
            pr_default.readNext(0);
         }
         if ( ! (GXutil.strcmp("", A141DrogueriaNombre)==0) )
         {
            AV29Option = A141DrogueriaNombre ;
            AV30Options.add(AV29Option, 0);
            AV35OptionIndexes.add(GXutil.trim( localUtil.format( DecimalUtil.doubleToDec(AV37count), "Z,ZZZ,ZZZ,ZZ9")), 0);
         }
         if ( AV30Options.size() == 50 )
         {
            /* Exit For each command. Update data (if necessary), close cursors & exit. */
            if (true) break;
         }
         if ( ! brk2Z2 )
         {
            brk2Z2 = true ;
            pr_default.readNext(0);
         }
      }
      pr_default.close(0);
   }

   public void S131( )
   {
      /* 'LOADDROGUERIADESCRIPCIONOPTIONS' Routine */
      returnInSub = false ;
      AV15TFDrogueriaDescripcion = AV25SearchTxt ;
      AV16TFDrogueriaDescripcion_Sel = "" ;
      AV48Drogueriawwds_1_filterfulltext = AV43FilterFullText ;
      AV49Drogueriawwds_2_tfdrogueriaid = AV11TFDrogueriaId ;
      AV50Drogueriawwds_3_tfdrogueriaid_to = AV12TFDrogueriaId_To ;
      AV51Drogueriawwds_4_tfdroguerianombre = AV13TFDrogueriaNombre ;
      AV52Drogueriawwds_5_tfdroguerianombre_sel = AV14TFDrogueriaNombre_Sel ;
      AV53Drogueriawwds_6_tfdrogueriadescripcion = AV15TFDrogueriaDescripcion ;
      AV54Drogueriawwds_7_tfdrogueriadescripcion_sel = AV16TFDrogueriaDescripcion_Sel ;
      AV55Drogueriawwds_8_tfdrogueriatipodocumento_sels = AV18TFDrogueriaTipoDocumento_Sels ;
      AV56Drogueriawwds_9_tfdroguerianrodocumento = AV19TFDrogueriaNroDocumento ;
      AV57Drogueriawwds_10_tfdroguerianrodocumento_sel = AV20TFDrogueriaNroDocumento_Sel ;
      AV58Drogueriawwds_11_tfdrogueriadireccion = AV21TFDrogueriaDireccion ;
      AV59Drogueriawwds_12_tfdrogueriadireccion_sel = AV22TFDrogueriaDireccion_Sel ;
      AV60Drogueriawwds_13_tfdrogueriaestado_sels = AV24TFDrogueriaEstado_Sels ;
      pr_default.dynParam(1, new Object[]{ new Object[]{
                                           A143DrogueriaTipoDocumento ,
                                           AV55Drogueriawwds_8_tfdrogueriatipodocumento_sels ,
                                           A147DrogueriaEstado ,
                                           AV60Drogueriawwds_13_tfdrogueriaestado_sels ,
                                           AV48Drogueriawwds_1_filterfulltext ,
                                           Short.valueOf(AV49Drogueriawwds_2_tfdrogueriaid) ,
                                           Short.valueOf(AV50Drogueriawwds_3_tfdrogueriaid_to) ,
                                           AV52Drogueriawwds_5_tfdroguerianombre_sel ,
                                           AV51Drogueriawwds_4_tfdroguerianombre ,
                                           AV54Drogueriawwds_7_tfdrogueriadescripcion_sel ,
                                           AV53Drogueriawwds_6_tfdrogueriadescripcion ,
                                           Integer.valueOf(AV55Drogueriawwds_8_tfdrogueriatipodocumento_sels.size()) ,
                                           AV57Drogueriawwds_10_tfdroguerianrodocumento_sel ,
                                           AV56Drogueriawwds_9_tfdroguerianrodocumento ,
                                           AV59Drogueriawwds_12_tfdrogueriadireccion_sel ,
                                           AV58Drogueriawwds_11_tfdrogueriadireccion ,
                                           Integer.valueOf(AV60Drogueriawwds_13_tfdrogueriaestado_sels.size()) ,
                                           Short.valueOf(A36DrogueriaId) ,
                                           A141DrogueriaNombre ,
                                           A142DrogueriaDescripcion ,
                                           A144DrogueriaNroDocumento ,
                                           A145DrogueriaDireccion } ,
                                           new int[]{
                                           TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.SHORT, TypeConstants.SHORT, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.INT,
                                           TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.INT, TypeConstants.SHORT, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING
                                           }
      });
      lV48Drogueriawwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV48Drogueriawwds_1_filterfulltext), "%", "") ;
      lV48Drogueriawwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV48Drogueriawwds_1_filterfulltext), "%", "") ;
      lV48Drogueriawwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV48Drogueriawwds_1_filterfulltext), "%", "") ;
      lV48Drogueriawwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV48Drogueriawwds_1_filterfulltext), "%", "") ;
      lV48Drogueriawwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV48Drogueriawwds_1_filterfulltext), "%", "") ;
      lV48Drogueriawwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV48Drogueriawwds_1_filterfulltext), "%", "") ;
      lV48Drogueriawwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV48Drogueriawwds_1_filterfulltext), "%", "") ;
      lV48Drogueriawwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV48Drogueriawwds_1_filterfulltext), "%", "") ;
      lV48Drogueriawwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV48Drogueriawwds_1_filterfulltext), "%", "") ;
      lV48Drogueriawwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV48Drogueriawwds_1_filterfulltext), "%", "") ;
      lV48Drogueriawwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV48Drogueriawwds_1_filterfulltext), "%", "") ;
      lV48Drogueriawwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV48Drogueriawwds_1_filterfulltext), "%", "") ;
      lV48Drogueriawwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV48Drogueriawwds_1_filterfulltext), "%", "") ;
      lV51Drogueriawwds_4_tfdroguerianombre = GXutil.concat( GXutil.rtrim( AV51Drogueriawwds_4_tfdroguerianombre), "%", "") ;
      lV53Drogueriawwds_6_tfdrogueriadescripcion = GXutil.concat( GXutil.rtrim( AV53Drogueriawwds_6_tfdrogueriadescripcion), "%", "") ;
      lV56Drogueriawwds_9_tfdroguerianrodocumento = GXutil.concat( GXutil.rtrim( AV56Drogueriawwds_9_tfdroguerianrodocumento), "%", "") ;
      lV58Drogueriawwds_11_tfdrogueriadireccion = GXutil.concat( GXutil.rtrim( AV58Drogueriawwds_11_tfdrogueriadireccion), "%", "") ;
      /* Using cursor P002Z3 */
      pr_default.execute(1, new Object[] {lV48Drogueriawwds_1_filterfulltext, lV48Drogueriawwds_1_filterfulltext, lV48Drogueriawwds_1_filterfulltext, lV48Drogueriawwds_1_filterfulltext, lV48Drogueriawwds_1_filterfulltext, lV48Drogueriawwds_1_filterfulltext, lV48Drogueriawwds_1_filterfulltext, lV48Drogueriawwds_1_filterfulltext, lV48Drogueriawwds_1_filterfulltext, lV48Drogueriawwds_1_filterfulltext, lV48Drogueriawwds_1_filterfulltext, lV48Drogueriawwds_1_filterfulltext, lV48Drogueriawwds_1_filterfulltext, Short.valueOf(AV49Drogueriawwds_2_tfdrogueriaid), Short.valueOf(AV50Drogueriawwds_3_tfdrogueriaid_to), lV51Drogueriawwds_4_tfdroguerianombre, AV52Drogueriawwds_5_tfdroguerianombre_sel, lV53Drogueriawwds_6_tfdrogueriadescripcion, AV54Drogueriawwds_7_tfdrogueriadescripcion_sel, lV56Drogueriawwds_9_tfdroguerianrodocumento, AV57Drogueriawwds_10_tfdroguerianrodocumento_sel, lV58Drogueriawwds_11_tfdrogueriadireccion, AV59Drogueriawwds_12_tfdrogueriadireccion_sel});
      while ( (pr_default.getStatus(1) != 101) )
      {
         brk2Z4 = false ;
         A142DrogueriaDescripcion = P002Z3_A142DrogueriaDescripcion[0] ;
         A36DrogueriaId = P002Z3_A36DrogueriaId[0] ;
         A147DrogueriaEstado = P002Z3_A147DrogueriaEstado[0] ;
         A145DrogueriaDireccion = P002Z3_A145DrogueriaDireccion[0] ;
         A144DrogueriaNroDocumento = P002Z3_A144DrogueriaNroDocumento[0] ;
         A143DrogueriaTipoDocumento = P002Z3_A143DrogueriaTipoDocumento[0] ;
         A141DrogueriaNombre = P002Z3_A141DrogueriaNombre[0] ;
         AV37count = 0 ;
         while ( (pr_default.getStatus(1) != 101) && ( GXutil.strcmp(P002Z3_A142DrogueriaDescripcion[0], A142DrogueriaDescripcion) == 0 ) )
         {
            brk2Z4 = false ;
            A36DrogueriaId = P002Z3_A36DrogueriaId[0] ;
            AV37count = (long)(AV37count+1) ;
            brk2Z4 = true ;
            pr_default.readNext(1);
         }
         if ( ! (GXutil.strcmp("", A142DrogueriaDescripcion)==0) )
         {
            AV29Option = A142DrogueriaDescripcion ;
            AV30Options.add(AV29Option, 0);
            AV35OptionIndexes.add(GXutil.trim( localUtil.format( DecimalUtil.doubleToDec(AV37count), "Z,ZZZ,ZZZ,ZZ9")), 0);
         }
         if ( AV30Options.size() == 50 )
         {
            /* Exit For each command. Update data (if necessary), close cursors & exit. */
            if (true) break;
         }
         if ( ! brk2Z4 )
         {
            brk2Z4 = true ;
            pr_default.readNext(1);
         }
      }
      pr_default.close(1);
   }

   public void S141( )
   {
      /* 'LOADDROGUERIANRODOCUMENTOOPTIONS' Routine */
      returnInSub = false ;
      AV19TFDrogueriaNroDocumento = AV25SearchTxt ;
      AV20TFDrogueriaNroDocumento_Sel = "" ;
      AV48Drogueriawwds_1_filterfulltext = AV43FilterFullText ;
      AV49Drogueriawwds_2_tfdrogueriaid = AV11TFDrogueriaId ;
      AV50Drogueriawwds_3_tfdrogueriaid_to = AV12TFDrogueriaId_To ;
      AV51Drogueriawwds_4_tfdroguerianombre = AV13TFDrogueriaNombre ;
      AV52Drogueriawwds_5_tfdroguerianombre_sel = AV14TFDrogueriaNombre_Sel ;
      AV53Drogueriawwds_6_tfdrogueriadescripcion = AV15TFDrogueriaDescripcion ;
      AV54Drogueriawwds_7_tfdrogueriadescripcion_sel = AV16TFDrogueriaDescripcion_Sel ;
      AV55Drogueriawwds_8_tfdrogueriatipodocumento_sels = AV18TFDrogueriaTipoDocumento_Sels ;
      AV56Drogueriawwds_9_tfdroguerianrodocumento = AV19TFDrogueriaNroDocumento ;
      AV57Drogueriawwds_10_tfdroguerianrodocumento_sel = AV20TFDrogueriaNroDocumento_Sel ;
      AV58Drogueriawwds_11_tfdrogueriadireccion = AV21TFDrogueriaDireccion ;
      AV59Drogueriawwds_12_tfdrogueriadireccion_sel = AV22TFDrogueriaDireccion_Sel ;
      AV60Drogueriawwds_13_tfdrogueriaestado_sels = AV24TFDrogueriaEstado_Sels ;
      pr_default.dynParam(2, new Object[]{ new Object[]{
                                           A143DrogueriaTipoDocumento ,
                                           AV55Drogueriawwds_8_tfdrogueriatipodocumento_sels ,
                                           A147DrogueriaEstado ,
                                           AV60Drogueriawwds_13_tfdrogueriaestado_sels ,
                                           AV48Drogueriawwds_1_filterfulltext ,
                                           Short.valueOf(AV49Drogueriawwds_2_tfdrogueriaid) ,
                                           Short.valueOf(AV50Drogueriawwds_3_tfdrogueriaid_to) ,
                                           AV52Drogueriawwds_5_tfdroguerianombre_sel ,
                                           AV51Drogueriawwds_4_tfdroguerianombre ,
                                           AV54Drogueriawwds_7_tfdrogueriadescripcion_sel ,
                                           AV53Drogueriawwds_6_tfdrogueriadescripcion ,
                                           Integer.valueOf(AV55Drogueriawwds_8_tfdrogueriatipodocumento_sels.size()) ,
                                           AV57Drogueriawwds_10_tfdroguerianrodocumento_sel ,
                                           AV56Drogueriawwds_9_tfdroguerianrodocumento ,
                                           AV59Drogueriawwds_12_tfdrogueriadireccion_sel ,
                                           AV58Drogueriawwds_11_tfdrogueriadireccion ,
                                           Integer.valueOf(AV60Drogueriawwds_13_tfdrogueriaestado_sels.size()) ,
                                           Short.valueOf(A36DrogueriaId) ,
                                           A141DrogueriaNombre ,
                                           A142DrogueriaDescripcion ,
                                           A144DrogueriaNroDocumento ,
                                           A145DrogueriaDireccion } ,
                                           new int[]{
                                           TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.SHORT, TypeConstants.SHORT, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.INT,
                                           TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.INT, TypeConstants.SHORT, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING
                                           }
      });
      lV48Drogueriawwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV48Drogueriawwds_1_filterfulltext), "%", "") ;
      lV48Drogueriawwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV48Drogueriawwds_1_filterfulltext), "%", "") ;
      lV48Drogueriawwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV48Drogueriawwds_1_filterfulltext), "%", "") ;
      lV48Drogueriawwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV48Drogueriawwds_1_filterfulltext), "%", "") ;
      lV48Drogueriawwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV48Drogueriawwds_1_filterfulltext), "%", "") ;
      lV48Drogueriawwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV48Drogueriawwds_1_filterfulltext), "%", "") ;
      lV48Drogueriawwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV48Drogueriawwds_1_filterfulltext), "%", "") ;
      lV48Drogueriawwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV48Drogueriawwds_1_filterfulltext), "%", "") ;
      lV48Drogueriawwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV48Drogueriawwds_1_filterfulltext), "%", "") ;
      lV48Drogueriawwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV48Drogueriawwds_1_filterfulltext), "%", "") ;
      lV48Drogueriawwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV48Drogueriawwds_1_filterfulltext), "%", "") ;
      lV48Drogueriawwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV48Drogueriawwds_1_filterfulltext), "%", "") ;
      lV48Drogueriawwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV48Drogueriawwds_1_filterfulltext), "%", "") ;
      lV51Drogueriawwds_4_tfdroguerianombre = GXutil.concat( GXutil.rtrim( AV51Drogueriawwds_4_tfdroguerianombre), "%", "") ;
      lV53Drogueriawwds_6_tfdrogueriadescripcion = GXutil.concat( GXutil.rtrim( AV53Drogueriawwds_6_tfdrogueriadescripcion), "%", "") ;
      lV56Drogueriawwds_9_tfdroguerianrodocumento = GXutil.concat( GXutil.rtrim( AV56Drogueriawwds_9_tfdroguerianrodocumento), "%", "") ;
      lV58Drogueriawwds_11_tfdrogueriadireccion = GXutil.concat( GXutil.rtrim( AV58Drogueriawwds_11_tfdrogueriadireccion), "%", "") ;
      /* Using cursor P002Z4 */
      pr_default.execute(2, new Object[] {lV48Drogueriawwds_1_filterfulltext, lV48Drogueriawwds_1_filterfulltext, lV48Drogueriawwds_1_filterfulltext, lV48Drogueriawwds_1_filterfulltext, lV48Drogueriawwds_1_filterfulltext, lV48Drogueriawwds_1_filterfulltext, lV48Drogueriawwds_1_filterfulltext, lV48Drogueriawwds_1_filterfulltext, lV48Drogueriawwds_1_filterfulltext, lV48Drogueriawwds_1_filterfulltext, lV48Drogueriawwds_1_filterfulltext, lV48Drogueriawwds_1_filterfulltext, lV48Drogueriawwds_1_filterfulltext, Short.valueOf(AV49Drogueriawwds_2_tfdrogueriaid), Short.valueOf(AV50Drogueriawwds_3_tfdrogueriaid_to), lV51Drogueriawwds_4_tfdroguerianombre, AV52Drogueriawwds_5_tfdroguerianombre_sel, lV53Drogueriawwds_6_tfdrogueriadescripcion, AV54Drogueriawwds_7_tfdrogueriadescripcion_sel, lV56Drogueriawwds_9_tfdroguerianrodocumento, AV57Drogueriawwds_10_tfdroguerianrodocumento_sel, lV58Drogueriawwds_11_tfdrogueriadireccion, AV59Drogueriawwds_12_tfdrogueriadireccion_sel});
      while ( (pr_default.getStatus(2) != 101) )
      {
         brk2Z6 = false ;
         A144DrogueriaNroDocumento = P002Z4_A144DrogueriaNroDocumento[0] ;
         A36DrogueriaId = P002Z4_A36DrogueriaId[0] ;
         A147DrogueriaEstado = P002Z4_A147DrogueriaEstado[0] ;
         A145DrogueriaDireccion = P002Z4_A145DrogueriaDireccion[0] ;
         A143DrogueriaTipoDocumento = P002Z4_A143DrogueriaTipoDocumento[0] ;
         A142DrogueriaDescripcion = P002Z4_A142DrogueriaDescripcion[0] ;
         A141DrogueriaNombre = P002Z4_A141DrogueriaNombre[0] ;
         AV37count = 0 ;
         while ( (pr_default.getStatus(2) != 101) && ( GXutil.strcmp(P002Z4_A144DrogueriaNroDocumento[0], A144DrogueriaNroDocumento) == 0 ) )
         {
            brk2Z6 = false ;
            A36DrogueriaId = P002Z4_A36DrogueriaId[0] ;
            AV37count = (long)(AV37count+1) ;
            brk2Z6 = true ;
            pr_default.readNext(2);
         }
         if ( ! (GXutil.strcmp("", A144DrogueriaNroDocumento)==0) )
         {
            AV29Option = A144DrogueriaNroDocumento ;
            AV30Options.add(AV29Option, 0);
            AV35OptionIndexes.add(GXutil.trim( localUtil.format( DecimalUtil.doubleToDec(AV37count), "Z,ZZZ,ZZZ,ZZ9")), 0);
         }
         if ( AV30Options.size() == 50 )
         {
            /* Exit For each command. Update data (if necessary), close cursors & exit. */
            if (true) break;
         }
         if ( ! brk2Z6 )
         {
            brk2Z6 = true ;
            pr_default.readNext(2);
         }
      }
      pr_default.close(2);
   }

   public void S151( )
   {
      /* 'LOADDROGUERIADIRECCIONOPTIONS' Routine */
      returnInSub = false ;
      AV21TFDrogueriaDireccion = AV25SearchTxt ;
      AV22TFDrogueriaDireccion_Sel = "" ;
      AV48Drogueriawwds_1_filterfulltext = AV43FilterFullText ;
      AV49Drogueriawwds_2_tfdrogueriaid = AV11TFDrogueriaId ;
      AV50Drogueriawwds_3_tfdrogueriaid_to = AV12TFDrogueriaId_To ;
      AV51Drogueriawwds_4_tfdroguerianombre = AV13TFDrogueriaNombre ;
      AV52Drogueriawwds_5_tfdroguerianombre_sel = AV14TFDrogueriaNombre_Sel ;
      AV53Drogueriawwds_6_tfdrogueriadescripcion = AV15TFDrogueriaDescripcion ;
      AV54Drogueriawwds_7_tfdrogueriadescripcion_sel = AV16TFDrogueriaDescripcion_Sel ;
      AV55Drogueriawwds_8_tfdrogueriatipodocumento_sels = AV18TFDrogueriaTipoDocumento_Sels ;
      AV56Drogueriawwds_9_tfdroguerianrodocumento = AV19TFDrogueriaNroDocumento ;
      AV57Drogueriawwds_10_tfdroguerianrodocumento_sel = AV20TFDrogueriaNroDocumento_Sel ;
      AV58Drogueriawwds_11_tfdrogueriadireccion = AV21TFDrogueriaDireccion ;
      AV59Drogueriawwds_12_tfdrogueriadireccion_sel = AV22TFDrogueriaDireccion_Sel ;
      AV60Drogueriawwds_13_tfdrogueriaestado_sels = AV24TFDrogueriaEstado_Sels ;
      pr_default.dynParam(3, new Object[]{ new Object[]{
                                           A143DrogueriaTipoDocumento ,
                                           AV55Drogueriawwds_8_tfdrogueriatipodocumento_sels ,
                                           A147DrogueriaEstado ,
                                           AV60Drogueriawwds_13_tfdrogueriaestado_sels ,
                                           AV48Drogueriawwds_1_filterfulltext ,
                                           Short.valueOf(AV49Drogueriawwds_2_tfdrogueriaid) ,
                                           Short.valueOf(AV50Drogueriawwds_3_tfdrogueriaid_to) ,
                                           AV52Drogueriawwds_5_tfdroguerianombre_sel ,
                                           AV51Drogueriawwds_4_tfdroguerianombre ,
                                           AV54Drogueriawwds_7_tfdrogueriadescripcion_sel ,
                                           AV53Drogueriawwds_6_tfdrogueriadescripcion ,
                                           Integer.valueOf(AV55Drogueriawwds_8_tfdrogueriatipodocumento_sels.size()) ,
                                           AV57Drogueriawwds_10_tfdroguerianrodocumento_sel ,
                                           AV56Drogueriawwds_9_tfdroguerianrodocumento ,
                                           AV59Drogueriawwds_12_tfdrogueriadireccion_sel ,
                                           AV58Drogueriawwds_11_tfdrogueriadireccion ,
                                           Integer.valueOf(AV60Drogueriawwds_13_tfdrogueriaestado_sels.size()) ,
                                           Short.valueOf(A36DrogueriaId) ,
                                           A141DrogueriaNombre ,
                                           A142DrogueriaDescripcion ,
                                           A144DrogueriaNroDocumento ,
                                           A145DrogueriaDireccion } ,
                                           new int[]{
                                           TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.SHORT, TypeConstants.SHORT, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.INT,
                                           TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.INT, TypeConstants.SHORT, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING
                                           }
      });
      lV48Drogueriawwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV48Drogueriawwds_1_filterfulltext), "%", "") ;
      lV48Drogueriawwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV48Drogueriawwds_1_filterfulltext), "%", "") ;
      lV48Drogueriawwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV48Drogueriawwds_1_filterfulltext), "%", "") ;
      lV48Drogueriawwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV48Drogueriawwds_1_filterfulltext), "%", "") ;
      lV48Drogueriawwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV48Drogueriawwds_1_filterfulltext), "%", "") ;
      lV48Drogueriawwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV48Drogueriawwds_1_filterfulltext), "%", "") ;
      lV48Drogueriawwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV48Drogueriawwds_1_filterfulltext), "%", "") ;
      lV48Drogueriawwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV48Drogueriawwds_1_filterfulltext), "%", "") ;
      lV48Drogueriawwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV48Drogueriawwds_1_filterfulltext), "%", "") ;
      lV48Drogueriawwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV48Drogueriawwds_1_filterfulltext), "%", "") ;
      lV48Drogueriawwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV48Drogueriawwds_1_filterfulltext), "%", "") ;
      lV48Drogueriawwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV48Drogueriawwds_1_filterfulltext), "%", "") ;
      lV48Drogueriawwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV48Drogueriawwds_1_filterfulltext), "%", "") ;
      lV51Drogueriawwds_4_tfdroguerianombre = GXutil.concat( GXutil.rtrim( AV51Drogueriawwds_4_tfdroguerianombre), "%", "") ;
      lV53Drogueriawwds_6_tfdrogueriadescripcion = GXutil.concat( GXutil.rtrim( AV53Drogueriawwds_6_tfdrogueriadescripcion), "%", "") ;
      lV56Drogueriawwds_9_tfdroguerianrodocumento = GXutil.concat( GXutil.rtrim( AV56Drogueriawwds_9_tfdroguerianrodocumento), "%", "") ;
      lV58Drogueriawwds_11_tfdrogueriadireccion = GXutil.concat( GXutil.rtrim( AV58Drogueriawwds_11_tfdrogueriadireccion), "%", "") ;
      /* Using cursor P002Z5 */
      pr_default.execute(3, new Object[] {lV48Drogueriawwds_1_filterfulltext, lV48Drogueriawwds_1_filterfulltext, lV48Drogueriawwds_1_filterfulltext, lV48Drogueriawwds_1_filterfulltext, lV48Drogueriawwds_1_filterfulltext, lV48Drogueriawwds_1_filterfulltext, lV48Drogueriawwds_1_filterfulltext, lV48Drogueriawwds_1_filterfulltext, lV48Drogueriawwds_1_filterfulltext, lV48Drogueriawwds_1_filterfulltext, lV48Drogueriawwds_1_filterfulltext, lV48Drogueriawwds_1_filterfulltext, lV48Drogueriawwds_1_filterfulltext, Short.valueOf(AV49Drogueriawwds_2_tfdrogueriaid), Short.valueOf(AV50Drogueriawwds_3_tfdrogueriaid_to), lV51Drogueriawwds_4_tfdroguerianombre, AV52Drogueriawwds_5_tfdroguerianombre_sel, lV53Drogueriawwds_6_tfdrogueriadescripcion, AV54Drogueriawwds_7_tfdrogueriadescripcion_sel, lV56Drogueriawwds_9_tfdroguerianrodocumento, AV57Drogueriawwds_10_tfdroguerianrodocumento_sel, lV58Drogueriawwds_11_tfdrogueriadireccion, AV59Drogueriawwds_12_tfdrogueriadireccion_sel});
      while ( (pr_default.getStatus(3) != 101) )
      {
         brk2Z8 = false ;
         A145DrogueriaDireccion = P002Z5_A145DrogueriaDireccion[0] ;
         A36DrogueriaId = P002Z5_A36DrogueriaId[0] ;
         A147DrogueriaEstado = P002Z5_A147DrogueriaEstado[0] ;
         A144DrogueriaNroDocumento = P002Z5_A144DrogueriaNroDocumento[0] ;
         A143DrogueriaTipoDocumento = P002Z5_A143DrogueriaTipoDocumento[0] ;
         A142DrogueriaDescripcion = P002Z5_A142DrogueriaDescripcion[0] ;
         A141DrogueriaNombre = P002Z5_A141DrogueriaNombre[0] ;
         AV37count = 0 ;
         while ( (pr_default.getStatus(3) != 101) && ( GXutil.strcmp(P002Z5_A145DrogueriaDireccion[0], A145DrogueriaDireccion) == 0 ) )
         {
            brk2Z8 = false ;
            A36DrogueriaId = P002Z5_A36DrogueriaId[0] ;
            AV37count = (long)(AV37count+1) ;
            brk2Z8 = true ;
            pr_default.readNext(3);
         }
         if ( ! (GXutil.strcmp("", A145DrogueriaDireccion)==0) )
         {
            AV29Option = A145DrogueriaDireccion ;
            AV30Options.add(AV29Option, 0);
            AV35OptionIndexes.add(GXutil.trim( localUtil.format( DecimalUtil.doubleToDec(AV37count), "Z,ZZZ,ZZZ,ZZ9")), 0);
         }
         if ( AV30Options.size() == 50 )
         {
            /* Exit For each command. Update data (if necessary), close cursors & exit. */
            if (true) break;
         }
         if ( ! brk2Z8 )
         {
            brk2Z8 = true ;
            pr_default.readNext(3);
         }
      }
      pr_default.close(3);
   }

   protected void cleanup( )
   {
      this.aP3[0] = drogueriawwgetfilterdata.this.AV31OptionsJson;
      this.aP4[0] = drogueriawwgetfilterdata.this.AV34OptionsDescJson;
      this.aP5[0] = drogueriawwgetfilterdata.this.AV36OptionIndexesJson;
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
      AV13TFDrogueriaNombre = "" ;
      AV14TFDrogueriaNombre_Sel = "" ;
      AV15TFDrogueriaDescripcion = "" ;
      AV16TFDrogueriaDescripcion_Sel = "" ;
      AV17TFDrogueriaTipoDocumento_SelsJson = "" ;
      AV18TFDrogueriaTipoDocumento_Sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV19TFDrogueriaNroDocumento = "" ;
      AV20TFDrogueriaNroDocumento_Sel = "" ;
      AV21TFDrogueriaDireccion = "" ;
      AV22TFDrogueriaDireccion_Sel = "" ;
      AV23TFDrogueriaEstado_SelsJson = "" ;
      AV24TFDrogueriaEstado_Sels = new GXSimpleCollection<String>(String.class, "internal", "");
      A141DrogueriaNombre = "" ;
      AV48Drogueriawwds_1_filterfulltext = "" ;
      AV51Drogueriawwds_4_tfdroguerianombre = "" ;
      AV52Drogueriawwds_5_tfdroguerianombre_sel = "" ;
      AV53Drogueriawwds_6_tfdrogueriadescripcion = "" ;
      AV54Drogueriawwds_7_tfdrogueriadescripcion_sel = "" ;
      AV55Drogueriawwds_8_tfdrogueriatipodocumento_sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV56Drogueriawwds_9_tfdroguerianrodocumento = "" ;
      AV57Drogueriawwds_10_tfdroguerianrodocumento_sel = "" ;
      AV58Drogueriawwds_11_tfdrogueriadireccion = "" ;
      AV59Drogueriawwds_12_tfdrogueriadireccion_sel = "" ;
      AV60Drogueriawwds_13_tfdrogueriaestado_sels = new GXSimpleCollection<String>(String.class, "internal", "");
      scmdbuf = "" ;
      lV48Drogueriawwds_1_filterfulltext = "" ;
      lV51Drogueriawwds_4_tfdroguerianombre = "" ;
      lV53Drogueriawwds_6_tfdrogueriadescripcion = "" ;
      lV56Drogueriawwds_9_tfdroguerianrodocumento = "" ;
      lV58Drogueriawwds_11_tfdrogueriadireccion = "" ;
      A143DrogueriaTipoDocumento = "" ;
      A147DrogueriaEstado = "" ;
      A142DrogueriaDescripcion = "" ;
      A144DrogueriaNroDocumento = "" ;
      A145DrogueriaDireccion = "" ;
      P002Z2_A141DrogueriaNombre = new String[] {""} ;
      P002Z2_A36DrogueriaId = new short[1] ;
      P002Z2_A147DrogueriaEstado = new String[] {""} ;
      P002Z2_A145DrogueriaDireccion = new String[] {""} ;
      P002Z2_A144DrogueriaNroDocumento = new String[] {""} ;
      P002Z2_A143DrogueriaTipoDocumento = new String[] {""} ;
      P002Z2_A142DrogueriaDescripcion = new String[] {""} ;
      AV29Option = "" ;
      P002Z3_A142DrogueriaDescripcion = new String[] {""} ;
      P002Z3_A36DrogueriaId = new short[1] ;
      P002Z3_A147DrogueriaEstado = new String[] {""} ;
      P002Z3_A145DrogueriaDireccion = new String[] {""} ;
      P002Z3_A144DrogueriaNroDocumento = new String[] {""} ;
      P002Z3_A143DrogueriaTipoDocumento = new String[] {""} ;
      P002Z3_A141DrogueriaNombre = new String[] {""} ;
      P002Z4_A144DrogueriaNroDocumento = new String[] {""} ;
      P002Z4_A36DrogueriaId = new short[1] ;
      P002Z4_A147DrogueriaEstado = new String[] {""} ;
      P002Z4_A145DrogueriaDireccion = new String[] {""} ;
      P002Z4_A143DrogueriaTipoDocumento = new String[] {""} ;
      P002Z4_A142DrogueriaDescripcion = new String[] {""} ;
      P002Z4_A141DrogueriaNombre = new String[] {""} ;
      P002Z5_A145DrogueriaDireccion = new String[] {""} ;
      P002Z5_A36DrogueriaId = new short[1] ;
      P002Z5_A147DrogueriaEstado = new String[] {""} ;
      P002Z5_A144DrogueriaNroDocumento = new String[] {""} ;
      P002Z5_A143DrogueriaTipoDocumento = new String[] {""} ;
      P002Z5_A142DrogueriaDescripcion = new String[] {""} ;
      P002Z5_A141DrogueriaNombre = new String[] {""} ;
      pr_default = new DataStoreProvider(context, remoteHandle, new com.projectthani.drogueriawwgetfilterdata__default(),
         new Object[] {
             new Object[] {
            P002Z2_A141DrogueriaNombre, P002Z2_A36DrogueriaId, P002Z2_A147DrogueriaEstado, P002Z2_A145DrogueriaDireccion, P002Z2_A144DrogueriaNroDocumento, P002Z2_A143DrogueriaTipoDocumento, P002Z2_A142DrogueriaDescripcion
            }
            , new Object[] {
            P002Z3_A142DrogueriaDescripcion, P002Z3_A36DrogueriaId, P002Z3_A147DrogueriaEstado, P002Z3_A145DrogueriaDireccion, P002Z3_A144DrogueriaNroDocumento, P002Z3_A143DrogueriaTipoDocumento, P002Z3_A141DrogueriaNombre
            }
            , new Object[] {
            P002Z4_A144DrogueriaNroDocumento, P002Z4_A36DrogueriaId, P002Z4_A147DrogueriaEstado, P002Z4_A145DrogueriaDireccion, P002Z4_A143DrogueriaTipoDocumento, P002Z4_A142DrogueriaDescripcion, P002Z4_A141DrogueriaNombre
            }
            , new Object[] {
            P002Z5_A145DrogueriaDireccion, P002Z5_A36DrogueriaId, P002Z5_A147DrogueriaEstado, P002Z5_A144DrogueriaNroDocumento, P002Z5_A143DrogueriaTipoDocumento, P002Z5_A142DrogueriaDescripcion, P002Z5_A141DrogueriaNombre
            }
         }
      );
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private short AV11TFDrogueriaId ;
   private short AV12TFDrogueriaId_To ;
   private short AV49Drogueriawwds_2_tfdrogueriaid ;
   private short AV50Drogueriawwds_3_tfdrogueriaid_to ;
   private short A36DrogueriaId ;
   private short Gx_err ;
   private int AV46GXV1 ;
   private int AV55Drogueriawwds_8_tfdrogueriatipodocumento_sels_size ;
   private int AV60Drogueriawwds_13_tfdrogueriaestado_sels_size ;
   private long AV37count ;
   private String scmdbuf ;
   private String A143DrogueriaTipoDocumento ;
   private String A147DrogueriaEstado ;
   private boolean AV8IsAuthorized ;
   private boolean GXt_boolean1 ;
   private boolean GXv_boolean2[] ;
   private boolean returnInSub ;
   private boolean brk2Z2 ;
   private boolean brk2Z4 ;
   private boolean brk2Z6 ;
   private boolean brk2Z8 ;
   private String AV31OptionsJson ;
   private String AV34OptionsDescJson ;
   private String AV36OptionIndexesJson ;
   private String AV17TFDrogueriaTipoDocumento_SelsJson ;
   private String AV23TFDrogueriaEstado_SelsJson ;
   private String AV27DDOName ;
   private String AV25SearchTxt ;
   private String AV26SearchTxtTo ;
   private String AV43FilterFullText ;
   private String AV13TFDrogueriaNombre ;
   private String AV14TFDrogueriaNombre_Sel ;
   private String AV15TFDrogueriaDescripcion ;
   private String AV16TFDrogueriaDescripcion_Sel ;
   private String AV19TFDrogueriaNroDocumento ;
   private String AV20TFDrogueriaNroDocumento_Sel ;
   private String AV21TFDrogueriaDireccion ;
   private String AV22TFDrogueriaDireccion_Sel ;
   private String A141DrogueriaNombre ;
   private String AV48Drogueriawwds_1_filterfulltext ;
   private String AV51Drogueriawwds_4_tfdroguerianombre ;
   private String AV52Drogueriawwds_5_tfdroguerianombre_sel ;
   private String AV53Drogueriawwds_6_tfdrogueriadescripcion ;
   private String AV54Drogueriawwds_7_tfdrogueriadescripcion_sel ;
   private String AV56Drogueriawwds_9_tfdroguerianrodocumento ;
   private String AV57Drogueriawwds_10_tfdroguerianrodocumento_sel ;
   private String AV58Drogueriawwds_11_tfdrogueriadireccion ;
   private String AV59Drogueriawwds_12_tfdrogueriadireccion_sel ;
   private String lV48Drogueriawwds_1_filterfulltext ;
   private String lV51Drogueriawwds_4_tfdroguerianombre ;
   private String lV53Drogueriawwds_6_tfdrogueriadescripcion ;
   private String lV56Drogueriawwds_9_tfdroguerianrodocumento ;
   private String lV58Drogueriawwds_11_tfdrogueriadireccion ;
   private String A142DrogueriaDescripcion ;
   private String A144DrogueriaNroDocumento ;
   private String A145DrogueriaDireccion ;
   private String AV29Option ;
   private com.genexus.webpanels.WebSession AV38Session ;
   private String[] aP5 ;
   private String[] aP3 ;
   private String[] aP4 ;
   private IDataStoreProvider pr_default ;
   private String[] P002Z2_A141DrogueriaNombre ;
   private short[] P002Z2_A36DrogueriaId ;
   private String[] P002Z2_A147DrogueriaEstado ;
   private String[] P002Z2_A145DrogueriaDireccion ;
   private String[] P002Z2_A144DrogueriaNroDocumento ;
   private String[] P002Z2_A143DrogueriaTipoDocumento ;
   private String[] P002Z2_A142DrogueriaDescripcion ;
   private String[] P002Z3_A142DrogueriaDescripcion ;
   private short[] P002Z3_A36DrogueriaId ;
   private String[] P002Z3_A147DrogueriaEstado ;
   private String[] P002Z3_A145DrogueriaDireccion ;
   private String[] P002Z3_A144DrogueriaNroDocumento ;
   private String[] P002Z3_A143DrogueriaTipoDocumento ;
   private String[] P002Z3_A141DrogueriaNombre ;
   private String[] P002Z4_A144DrogueriaNroDocumento ;
   private short[] P002Z4_A36DrogueriaId ;
   private String[] P002Z4_A147DrogueriaEstado ;
   private String[] P002Z4_A145DrogueriaDireccion ;
   private String[] P002Z4_A143DrogueriaTipoDocumento ;
   private String[] P002Z4_A142DrogueriaDescripcion ;
   private String[] P002Z4_A141DrogueriaNombre ;
   private String[] P002Z5_A145DrogueriaDireccion ;
   private short[] P002Z5_A36DrogueriaId ;
   private String[] P002Z5_A147DrogueriaEstado ;
   private String[] P002Z5_A144DrogueriaNroDocumento ;
   private String[] P002Z5_A143DrogueriaTipoDocumento ;
   private String[] P002Z5_A142DrogueriaDescripcion ;
   private String[] P002Z5_A141DrogueriaNombre ;
   private GXSimpleCollection<String> AV18TFDrogueriaTipoDocumento_Sels ;
   private GXSimpleCollection<String> AV24TFDrogueriaEstado_Sels ;
   private GXSimpleCollection<String> AV55Drogueriawwds_8_tfdrogueriatipodocumento_sels ;
   private GXSimpleCollection<String> AV60Drogueriawwds_13_tfdrogueriaestado_sels ;
   private GXSimpleCollection<String> AV30Options ;
   private GXSimpleCollection<String> AV33OptionsDesc ;
   private GXSimpleCollection<String> AV35OptionIndexes ;
   private com.projectthani.wwpbaseobjects.SdtWWPContext AV9WWPContext ;
   private com.projectthani.wwpbaseobjects.SdtWWPContext GXv_SdtWWPContext3[] ;
   private com.projectthani.wwpbaseobjects.SdtWWPGridState AV40GridState ;
   private com.projectthani.wwpbaseobjects.SdtWWPGridState_FilterValue AV41GridStateFilterValue ;
}

final  class drogueriawwgetfilterdata__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   protected Object[] conditional_P002Z2( ModelContext context ,
                                          int remoteHandle ,
                                          com.genexus.IHttpContext httpContext ,
                                          String A143DrogueriaTipoDocumento ,
                                          GXSimpleCollection<String> AV55Drogueriawwds_8_tfdrogueriatipodocumento_sels ,
                                          String A147DrogueriaEstado ,
                                          GXSimpleCollection<String> AV60Drogueriawwds_13_tfdrogueriaestado_sels ,
                                          String AV48Drogueriawwds_1_filterfulltext ,
                                          short AV49Drogueriawwds_2_tfdrogueriaid ,
                                          short AV50Drogueriawwds_3_tfdrogueriaid_to ,
                                          String AV52Drogueriawwds_5_tfdroguerianombre_sel ,
                                          String AV51Drogueriawwds_4_tfdroguerianombre ,
                                          String AV54Drogueriawwds_7_tfdrogueriadescripcion_sel ,
                                          String AV53Drogueriawwds_6_tfdrogueriadescripcion ,
                                          int AV55Drogueriawwds_8_tfdrogueriatipodocumento_sels_size ,
                                          String AV57Drogueriawwds_10_tfdroguerianrodocumento_sel ,
                                          String AV56Drogueriawwds_9_tfdroguerianrodocumento ,
                                          String AV59Drogueriawwds_12_tfdrogueriadireccion_sel ,
                                          String AV58Drogueriawwds_11_tfdrogueriadireccion ,
                                          int AV60Drogueriawwds_13_tfdrogueriaestado_sels_size ,
                                          short A36DrogueriaId ,
                                          String A141DrogueriaNombre ,
                                          String A142DrogueriaDescripcion ,
                                          String A144DrogueriaNroDocumento ,
                                          String A145DrogueriaDireccion )
   {
      java.lang.StringBuffer sWhereString = new java.lang.StringBuffer();
      String scmdbuf;
      byte[] GXv_int4 = new byte[23];
      Object[] GXv_Object5 = new Object[2];
      scmdbuf = "SELECT [DrogueriaNombre], [DrogueriaId], [DrogueriaEstado], [DrogueriaDireccion], [DrogueriaNroDocumento], [DrogueriaTipoDocumento], [DrogueriaDescripcion] FROM" ;
      scmdbuf += " [Drogueria]" ;
      if ( ! (GXutil.strcmp("", AV48Drogueriawwds_1_filterfulltext)==0) )
      {
         addWhere(sWhereString, "(( CONVERT( char(4), CAST([DrogueriaId] AS decimal(4,0))) like '%' + ?) or ( [DrogueriaNombre] like '%' + ?) or ( [DrogueriaDescripcion] like '%' + ?) or ( 'dni' like '%' + LOWER(?) and [DrogueriaTipoDocumento] = '1') or ( 'ruc' like '%' + LOWER(?) and [DrogueriaTipoDocumento] = '6') or ( 'libreta electoral' like '%' + LOWER(?) and [DrogueriaTipoDocumento] = '2') or ( 'carnet de extranjeria' like '%' + LOWER(?) and [DrogueriaTipoDocumento] = '4') or ( 'pasaporte' like '%' + LOWER(?) and [DrogueriaTipoDocumento] = '7') or ( 'sin documento' like '%' + LOWER(?) and [DrogueriaTipoDocumento] = '0') or ( [DrogueriaNroDocumento] like '%' + ?) or ( [DrogueriaDireccion] like '%' + ?) or ( 'activo' like '%' + LOWER(?) and [DrogueriaEstado] = 'A') or ( 'inactivo' like '%' + LOWER(?) and [DrogueriaEstado] = 'I'))");
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
         GXv_int4[11] = (byte)(1) ;
         GXv_int4[12] = (byte)(1) ;
      }
      if ( ! (0==AV49Drogueriawwds_2_tfdrogueriaid) )
      {
         addWhere(sWhereString, "([DrogueriaId] >= ?)");
      }
      else
      {
         GXv_int4[13] = (byte)(1) ;
      }
      if ( ! (0==AV50Drogueriawwds_3_tfdrogueriaid_to) )
      {
         addWhere(sWhereString, "([DrogueriaId] <= ?)");
      }
      else
      {
         GXv_int4[14] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV52Drogueriawwds_5_tfdroguerianombre_sel)==0) && ( ! (GXutil.strcmp("", AV51Drogueriawwds_4_tfdroguerianombre)==0) ) )
      {
         addWhere(sWhereString, "([DrogueriaNombre] like ?)");
      }
      else
      {
         GXv_int4[15] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV52Drogueriawwds_5_tfdroguerianombre_sel)==0) )
      {
         addWhere(sWhereString, "([DrogueriaNombre] = ?)");
      }
      else
      {
         GXv_int4[16] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV54Drogueriawwds_7_tfdrogueriadescripcion_sel)==0) && ( ! (GXutil.strcmp("", AV53Drogueriawwds_6_tfdrogueriadescripcion)==0) ) )
      {
         addWhere(sWhereString, "([DrogueriaDescripcion] like ?)");
      }
      else
      {
         GXv_int4[17] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV54Drogueriawwds_7_tfdrogueriadescripcion_sel)==0) )
      {
         addWhere(sWhereString, "([DrogueriaDescripcion] = ?)");
      }
      else
      {
         GXv_int4[18] = (byte)(1) ;
      }
      if ( AV55Drogueriawwds_8_tfdrogueriatipodocumento_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("sqlserver", AV55Drogueriawwds_8_tfdrogueriatipodocumento_sels, "[DrogueriaTipoDocumento] IN (", ")")+")");
      }
      if ( (GXutil.strcmp("", AV57Drogueriawwds_10_tfdroguerianrodocumento_sel)==0) && ( ! (GXutil.strcmp("", AV56Drogueriawwds_9_tfdroguerianrodocumento)==0) ) )
      {
         addWhere(sWhereString, "([DrogueriaNroDocumento] like ?)");
      }
      else
      {
         GXv_int4[19] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV57Drogueriawwds_10_tfdroguerianrodocumento_sel)==0) )
      {
         addWhere(sWhereString, "([DrogueriaNroDocumento] = ?)");
      }
      else
      {
         GXv_int4[20] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV59Drogueriawwds_12_tfdrogueriadireccion_sel)==0) && ( ! (GXutil.strcmp("", AV58Drogueriawwds_11_tfdrogueriadireccion)==0) ) )
      {
         addWhere(sWhereString, "([DrogueriaDireccion] like ?)");
      }
      else
      {
         GXv_int4[21] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV59Drogueriawwds_12_tfdrogueriadireccion_sel)==0) )
      {
         addWhere(sWhereString, "([DrogueriaDireccion] = ?)");
      }
      else
      {
         GXv_int4[22] = (byte)(1) ;
      }
      if ( AV60Drogueriawwds_13_tfdrogueriaestado_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("sqlserver", AV60Drogueriawwds_13_tfdrogueriaestado_sels, "[DrogueriaEstado] IN (", ")")+")");
      }
      scmdbuf += sWhereString ;
      scmdbuf += " ORDER BY [DrogueriaNombre]" ;
      GXv_Object5[0] = scmdbuf ;
      GXv_Object5[1] = GXv_int4 ;
      return GXv_Object5 ;
   }

   protected Object[] conditional_P002Z3( ModelContext context ,
                                          int remoteHandle ,
                                          com.genexus.IHttpContext httpContext ,
                                          String A143DrogueriaTipoDocumento ,
                                          GXSimpleCollection<String> AV55Drogueriawwds_8_tfdrogueriatipodocumento_sels ,
                                          String A147DrogueriaEstado ,
                                          GXSimpleCollection<String> AV60Drogueriawwds_13_tfdrogueriaestado_sels ,
                                          String AV48Drogueriawwds_1_filterfulltext ,
                                          short AV49Drogueriawwds_2_tfdrogueriaid ,
                                          short AV50Drogueriawwds_3_tfdrogueriaid_to ,
                                          String AV52Drogueriawwds_5_tfdroguerianombre_sel ,
                                          String AV51Drogueriawwds_4_tfdroguerianombre ,
                                          String AV54Drogueriawwds_7_tfdrogueriadescripcion_sel ,
                                          String AV53Drogueriawwds_6_tfdrogueriadescripcion ,
                                          int AV55Drogueriawwds_8_tfdrogueriatipodocumento_sels_size ,
                                          String AV57Drogueriawwds_10_tfdroguerianrodocumento_sel ,
                                          String AV56Drogueriawwds_9_tfdroguerianrodocumento ,
                                          String AV59Drogueriawwds_12_tfdrogueriadireccion_sel ,
                                          String AV58Drogueriawwds_11_tfdrogueriadireccion ,
                                          int AV60Drogueriawwds_13_tfdrogueriaestado_sels_size ,
                                          short A36DrogueriaId ,
                                          String A141DrogueriaNombre ,
                                          String A142DrogueriaDescripcion ,
                                          String A144DrogueriaNroDocumento ,
                                          String A145DrogueriaDireccion )
   {
      java.lang.StringBuffer sWhereString = new java.lang.StringBuffer();
      String scmdbuf;
      byte[] GXv_int7 = new byte[23];
      Object[] GXv_Object8 = new Object[2];
      scmdbuf = "SELECT [DrogueriaDescripcion], [DrogueriaId], [DrogueriaEstado], [DrogueriaDireccion], [DrogueriaNroDocumento], [DrogueriaTipoDocumento], [DrogueriaNombre] FROM" ;
      scmdbuf += " [Drogueria]" ;
      if ( ! (GXutil.strcmp("", AV48Drogueriawwds_1_filterfulltext)==0) )
      {
         addWhere(sWhereString, "(( CONVERT( char(4), CAST([DrogueriaId] AS decimal(4,0))) like '%' + ?) or ( [DrogueriaNombre] like '%' + ?) or ( [DrogueriaDescripcion] like '%' + ?) or ( 'dni' like '%' + LOWER(?) and [DrogueriaTipoDocumento] = '1') or ( 'ruc' like '%' + LOWER(?) and [DrogueriaTipoDocumento] = '6') or ( 'libreta electoral' like '%' + LOWER(?) and [DrogueriaTipoDocumento] = '2') or ( 'carnet de extranjeria' like '%' + LOWER(?) and [DrogueriaTipoDocumento] = '4') or ( 'pasaporte' like '%' + LOWER(?) and [DrogueriaTipoDocumento] = '7') or ( 'sin documento' like '%' + LOWER(?) and [DrogueriaTipoDocumento] = '0') or ( [DrogueriaNroDocumento] like '%' + ?) or ( [DrogueriaDireccion] like '%' + ?) or ( 'activo' like '%' + LOWER(?) and [DrogueriaEstado] = 'A') or ( 'inactivo' like '%' + LOWER(?) and [DrogueriaEstado] = 'I'))");
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
         GXv_int7[11] = (byte)(1) ;
         GXv_int7[12] = (byte)(1) ;
      }
      if ( ! (0==AV49Drogueriawwds_2_tfdrogueriaid) )
      {
         addWhere(sWhereString, "([DrogueriaId] >= ?)");
      }
      else
      {
         GXv_int7[13] = (byte)(1) ;
      }
      if ( ! (0==AV50Drogueriawwds_3_tfdrogueriaid_to) )
      {
         addWhere(sWhereString, "([DrogueriaId] <= ?)");
      }
      else
      {
         GXv_int7[14] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV52Drogueriawwds_5_tfdroguerianombre_sel)==0) && ( ! (GXutil.strcmp("", AV51Drogueriawwds_4_tfdroguerianombre)==0) ) )
      {
         addWhere(sWhereString, "([DrogueriaNombre] like ?)");
      }
      else
      {
         GXv_int7[15] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV52Drogueriawwds_5_tfdroguerianombre_sel)==0) )
      {
         addWhere(sWhereString, "([DrogueriaNombre] = ?)");
      }
      else
      {
         GXv_int7[16] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV54Drogueriawwds_7_tfdrogueriadescripcion_sel)==0) && ( ! (GXutil.strcmp("", AV53Drogueriawwds_6_tfdrogueriadescripcion)==0) ) )
      {
         addWhere(sWhereString, "([DrogueriaDescripcion] like ?)");
      }
      else
      {
         GXv_int7[17] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV54Drogueriawwds_7_tfdrogueriadescripcion_sel)==0) )
      {
         addWhere(sWhereString, "([DrogueriaDescripcion] = ?)");
      }
      else
      {
         GXv_int7[18] = (byte)(1) ;
      }
      if ( AV55Drogueriawwds_8_tfdrogueriatipodocumento_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("sqlserver", AV55Drogueriawwds_8_tfdrogueriatipodocumento_sels, "[DrogueriaTipoDocumento] IN (", ")")+")");
      }
      if ( (GXutil.strcmp("", AV57Drogueriawwds_10_tfdroguerianrodocumento_sel)==0) && ( ! (GXutil.strcmp("", AV56Drogueriawwds_9_tfdroguerianrodocumento)==0) ) )
      {
         addWhere(sWhereString, "([DrogueriaNroDocumento] like ?)");
      }
      else
      {
         GXv_int7[19] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV57Drogueriawwds_10_tfdroguerianrodocumento_sel)==0) )
      {
         addWhere(sWhereString, "([DrogueriaNroDocumento] = ?)");
      }
      else
      {
         GXv_int7[20] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV59Drogueriawwds_12_tfdrogueriadireccion_sel)==0) && ( ! (GXutil.strcmp("", AV58Drogueriawwds_11_tfdrogueriadireccion)==0) ) )
      {
         addWhere(sWhereString, "([DrogueriaDireccion] like ?)");
      }
      else
      {
         GXv_int7[21] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV59Drogueriawwds_12_tfdrogueriadireccion_sel)==0) )
      {
         addWhere(sWhereString, "([DrogueriaDireccion] = ?)");
      }
      else
      {
         GXv_int7[22] = (byte)(1) ;
      }
      if ( AV60Drogueriawwds_13_tfdrogueriaestado_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("sqlserver", AV60Drogueriawwds_13_tfdrogueriaestado_sels, "[DrogueriaEstado] IN (", ")")+")");
      }
      scmdbuf += sWhereString ;
      scmdbuf += " ORDER BY [DrogueriaDescripcion]" ;
      GXv_Object8[0] = scmdbuf ;
      GXv_Object8[1] = GXv_int7 ;
      return GXv_Object8 ;
   }

   protected Object[] conditional_P002Z4( ModelContext context ,
                                          int remoteHandle ,
                                          com.genexus.IHttpContext httpContext ,
                                          String A143DrogueriaTipoDocumento ,
                                          GXSimpleCollection<String> AV55Drogueriawwds_8_tfdrogueriatipodocumento_sels ,
                                          String A147DrogueriaEstado ,
                                          GXSimpleCollection<String> AV60Drogueriawwds_13_tfdrogueriaestado_sels ,
                                          String AV48Drogueriawwds_1_filterfulltext ,
                                          short AV49Drogueriawwds_2_tfdrogueriaid ,
                                          short AV50Drogueriawwds_3_tfdrogueriaid_to ,
                                          String AV52Drogueriawwds_5_tfdroguerianombre_sel ,
                                          String AV51Drogueriawwds_4_tfdroguerianombre ,
                                          String AV54Drogueriawwds_7_tfdrogueriadescripcion_sel ,
                                          String AV53Drogueriawwds_6_tfdrogueriadescripcion ,
                                          int AV55Drogueriawwds_8_tfdrogueriatipodocumento_sels_size ,
                                          String AV57Drogueriawwds_10_tfdroguerianrodocumento_sel ,
                                          String AV56Drogueriawwds_9_tfdroguerianrodocumento ,
                                          String AV59Drogueriawwds_12_tfdrogueriadireccion_sel ,
                                          String AV58Drogueriawwds_11_tfdrogueriadireccion ,
                                          int AV60Drogueriawwds_13_tfdrogueriaestado_sels_size ,
                                          short A36DrogueriaId ,
                                          String A141DrogueriaNombre ,
                                          String A142DrogueriaDescripcion ,
                                          String A144DrogueriaNroDocumento ,
                                          String A145DrogueriaDireccion )
   {
      java.lang.StringBuffer sWhereString = new java.lang.StringBuffer();
      String scmdbuf;
      byte[] GXv_int10 = new byte[23];
      Object[] GXv_Object11 = new Object[2];
      scmdbuf = "SELECT [DrogueriaNroDocumento], [DrogueriaId], [DrogueriaEstado], [DrogueriaDireccion], [DrogueriaTipoDocumento], [DrogueriaDescripcion], [DrogueriaNombre] FROM" ;
      scmdbuf += " [Drogueria]" ;
      if ( ! (GXutil.strcmp("", AV48Drogueriawwds_1_filterfulltext)==0) )
      {
         addWhere(sWhereString, "(( CONVERT( char(4), CAST([DrogueriaId] AS decimal(4,0))) like '%' + ?) or ( [DrogueriaNombre] like '%' + ?) or ( [DrogueriaDescripcion] like '%' + ?) or ( 'dni' like '%' + LOWER(?) and [DrogueriaTipoDocumento] = '1') or ( 'ruc' like '%' + LOWER(?) and [DrogueriaTipoDocumento] = '6') or ( 'libreta electoral' like '%' + LOWER(?) and [DrogueriaTipoDocumento] = '2') or ( 'carnet de extranjeria' like '%' + LOWER(?) and [DrogueriaTipoDocumento] = '4') or ( 'pasaporte' like '%' + LOWER(?) and [DrogueriaTipoDocumento] = '7') or ( 'sin documento' like '%' + LOWER(?) and [DrogueriaTipoDocumento] = '0') or ( [DrogueriaNroDocumento] like '%' + ?) or ( [DrogueriaDireccion] like '%' + ?) or ( 'activo' like '%' + LOWER(?) and [DrogueriaEstado] = 'A') or ( 'inactivo' like '%' + LOWER(?) and [DrogueriaEstado] = 'I'))");
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
         GXv_int10[11] = (byte)(1) ;
         GXv_int10[12] = (byte)(1) ;
      }
      if ( ! (0==AV49Drogueriawwds_2_tfdrogueriaid) )
      {
         addWhere(sWhereString, "([DrogueriaId] >= ?)");
      }
      else
      {
         GXv_int10[13] = (byte)(1) ;
      }
      if ( ! (0==AV50Drogueriawwds_3_tfdrogueriaid_to) )
      {
         addWhere(sWhereString, "([DrogueriaId] <= ?)");
      }
      else
      {
         GXv_int10[14] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV52Drogueriawwds_5_tfdroguerianombre_sel)==0) && ( ! (GXutil.strcmp("", AV51Drogueriawwds_4_tfdroguerianombre)==0) ) )
      {
         addWhere(sWhereString, "([DrogueriaNombre] like ?)");
      }
      else
      {
         GXv_int10[15] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV52Drogueriawwds_5_tfdroguerianombre_sel)==0) )
      {
         addWhere(sWhereString, "([DrogueriaNombre] = ?)");
      }
      else
      {
         GXv_int10[16] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV54Drogueriawwds_7_tfdrogueriadescripcion_sel)==0) && ( ! (GXutil.strcmp("", AV53Drogueriawwds_6_tfdrogueriadescripcion)==0) ) )
      {
         addWhere(sWhereString, "([DrogueriaDescripcion] like ?)");
      }
      else
      {
         GXv_int10[17] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV54Drogueriawwds_7_tfdrogueriadescripcion_sel)==0) )
      {
         addWhere(sWhereString, "([DrogueriaDescripcion] = ?)");
      }
      else
      {
         GXv_int10[18] = (byte)(1) ;
      }
      if ( AV55Drogueriawwds_8_tfdrogueriatipodocumento_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("sqlserver", AV55Drogueriawwds_8_tfdrogueriatipodocumento_sels, "[DrogueriaTipoDocumento] IN (", ")")+")");
      }
      if ( (GXutil.strcmp("", AV57Drogueriawwds_10_tfdroguerianrodocumento_sel)==0) && ( ! (GXutil.strcmp("", AV56Drogueriawwds_9_tfdroguerianrodocumento)==0) ) )
      {
         addWhere(sWhereString, "([DrogueriaNroDocumento] like ?)");
      }
      else
      {
         GXv_int10[19] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV57Drogueriawwds_10_tfdroguerianrodocumento_sel)==0) )
      {
         addWhere(sWhereString, "([DrogueriaNroDocumento] = ?)");
      }
      else
      {
         GXv_int10[20] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV59Drogueriawwds_12_tfdrogueriadireccion_sel)==0) && ( ! (GXutil.strcmp("", AV58Drogueriawwds_11_tfdrogueriadireccion)==0) ) )
      {
         addWhere(sWhereString, "([DrogueriaDireccion] like ?)");
      }
      else
      {
         GXv_int10[21] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV59Drogueriawwds_12_tfdrogueriadireccion_sel)==0) )
      {
         addWhere(sWhereString, "([DrogueriaDireccion] = ?)");
      }
      else
      {
         GXv_int10[22] = (byte)(1) ;
      }
      if ( AV60Drogueriawwds_13_tfdrogueriaestado_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("sqlserver", AV60Drogueriawwds_13_tfdrogueriaestado_sels, "[DrogueriaEstado] IN (", ")")+")");
      }
      scmdbuf += sWhereString ;
      scmdbuf += " ORDER BY [DrogueriaNroDocumento]" ;
      GXv_Object11[0] = scmdbuf ;
      GXv_Object11[1] = GXv_int10 ;
      return GXv_Object11 ;
   }

   protected Object[] conditional_P002Z5( ModelContext context ,
                                          int remoteHandle ,
                                          com.genexus.IHttpContext httpContext ,
                                          String A143DrogueriaTipoDocumento ,
                                          GXSimpleCollection<String> AV55Drogueriawwds_8_tfdrogueriatipodocumento_sels ,
                                          String A147DrogueriaEstado ,
                                          GXSimpleCollection<String> AV60Drogueriawwds_13_tfdrogueriaestado_sels ,
                                          String AV48Drogueriawwds_1_filterfulltext ,
                                          short AV49Drogueriawwds_2_tfdrogueriaid ,
                                          short AV50Drogueriawwds_3_tfdrogueriaid_to ,
                                          String AV52Drogueriawwds_5_tfdroguerianombre_sel ,
                                          String AV51Drogueriawwds_4_tfdroguerianombre ,
                                          String AV54Drogueriawwds_7_tfdrogueriadescripcion_sel ,
                                          String AV53Drogueriawwds_6_tfdrogueriadescripcion ,
                                          int AV55Drogueriawwds_8_tfdrogueriatipodocumento_sels_size ,
                                          String AV57Drogueriawwds_10_tfdroguerianrodocumento_sel ,
                                          String AV56Drogueriawwds_9_tfdroguerianrodocumento ,
                                          String AV59Drogueriawwds_12_tfdrogueriadireccion_sel ,
                                          String AV58Drogueriawwds_11_tfdrogueriadireccion ,
                                          int AV60Drogueriawwds_13_tfdrogueriaestado_sels_size ,
                                          short A36DrogueriaId ,
                                          String A141DrogueriaNombre ,
                                          String A142DrogueriaDescripcion ,
                                          String A144DrogueriaNroDocumento ,
                                          String A145DrogueriaDireccion )
   {
      java.lang.StringBuffer sWhereString = new java.lang.StringBuffer();
      String scmdbuf;
      byte[] GXv_int13 = new byte[23];
      Object[] GXv_Object14 = new Object[2];
      scmdbuf = "SELECT [DrogueriaDireccion], [DrogueriaId], [DrogueriaEstado], [DrogueriaNroDocumento], [DrogueriaTipoDocumento], [DrogueriaDescripcion], [DrogueriaNombre] FROM" ;
      scmdbuf += " [Drogueria]" ;
      if ( ! (GXutil.strcmp("", AV48Drogueriawwds_1_filterfulltext)==0) )
      {
         addWhere(sWhereString, "(( CONVERT( char(4), CAST([DrogueriaId] AS decimal(4,0))) like '%' + ?) or ( [DrogueriaNombre] like '%' + ?) or ( [DrogueriaDescripcion] like '%' + ?) or ( 'dni' like '%' + LOWER(?) and [DrogueriaTipoDocumento] = '1') or ( 'ruc' like '%' + LOWER(?) and [DrogueriaTipoDocumento] = '6') or ( 'libreta electoral' like '%' + LOWER(?) and [DrogueriaTipoDocumento] = '2') or ( 'carnet de extranjeria' like '%' + LOWER(?) and [DrogueriaTipoDocumento] = '4') or ( 'pasaporte' like '%' + LOWER(?) and [DrogueriaTipoDocumento] = '7') or ( 'sin documento' like '%' + LOWER(?) and [DrogueriaTipoDocumento] = '0') or ( [DrogueriaNroDocumento] like '%' + ?) or ( [DrogueriaDireccion] like '%' + ?) or ( 'activo' like '%' + LOWER(?) and [DrogueriaEstado] = 'A') or ( 'inactivo' like '%' + LOWER(?) and [DrogueriaEstado] = 'I'))");
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
         GXv_int13[11] = (byte)(1) ;
         GXv_int13[12] = (byte)(1) ;
      }
      if ( ! (0==AV49Drogueriawwds_2_tfdrogueriaid) )
      {
         addWhere(sWhereString, "([DrogueriaId] >= ?)");
      }
      else
      {
         GXv_int13[13] = (byte)(1) ;
      }
      if ( ! (0==AV50Drogueriawwds_3_tfdrogueriaid_to) )
      {
         addWhere(sWhereString, "([DrogueriaId] <= ?)");
      }
      else
      {
         GXv_int13[14] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV52Drogueriawwds_5_tfdroguerianombre_sel)==0) && ( ! (GXutil.strcmp("", AV51Drogueriawwds_4_tfdroguerianombre)==0) ) )
      {
         addWhere(sWhereString, "([DrogueriaNombre] like ?)");
      }
      else
      {
         GXv_int13[15] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV52Drogueriawwds_5_tfdroguerianombre_sel)==0) )
      {
         addWhere(sWhereString, "([DrogueriaNombre] = ?)");
      }
      else
      {
         GXv_int13[16] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV54Drogueriawwds_7_tfdrogueriadescripcion_sel)==0) && ( ! (GXutil.strcmp("", AV53Drogueriawwds_6_tfdrogueriadescripcion)==0) ) )
      {
         addWhere(sWhereString, "([DrogueriaDescripcion] like ?)");
      }
      else
      {
         GXv_int13[17] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV54Drogueriawwds_7_tfdrogueriadescripcion_sel)==0) )
      {
         addWhere(sWhereString, "([DrogueriaDescripcion] = ?)");
      }
      else
      {
         GXv_int13[18] = (byte)(1) ;
      }
      if ( AV55Drogueriawwds_8_tfdrogueriatipodocumento_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("sqlserver", AV55Drogueriawwds_8_tfdrogueriatipodocumento_sels, "[DrogueriaTipoDocumento] IN (", ")")+")");
      }
      if ( (GXutil.strcmp("", AV57Drogueriawwds_10_tfdroguerianrodocumento_sel)==0) && ( ! (GXutil.strcmp("", AV56Drogueriawwds_9_tfdroguerianrodocumento)==0) ) )
      {
         addWhere(sWhereString, "([DrogueriaNroDocumento] like ?)");
      }
      else
      {
         GXv_int13[19] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV57Drogueriawwds_10_tfdroguerianrodocumento_sel)==0) )
      {
         addWhere(sWhereString, "([DrogueriaNroDocumento] = ?)");
      }
      else
      {
         GXv_int13[20] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV59Drogueriawwds_12_tfdrogueriadireccion_sel)==0) && ( ! (GXutil.strcmp("", AV58Drogueriawwds_11_tfdrogueriadireccion)==0) ) )
      {
         addWhere(sWhereString, "([DrogueriaDireccion] like ?)");
      }
      else
      {
         GXv_int13[21] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV59Drogueriawwds_12_tfdrogueriadireccion_sel)==0) )
      {
         addWhere(sWhereString, "([DrogueriaDireccion] = ?)");
      }
      else
      {
         GXv_int13[22] = (byte)(1) ;
      }
      if ( AV60Drogueriawwds_13_tfdrogueriaestado_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("sqlserver", AV60Drogueriawwds_13_tfdrogueriaestado_sels, "[DrogueriaEstado] IN (", ")")+")");
      }
      scmdbuf += sWhereString ;
      scmdbuf += " ORDER BY [DrogueriaDireccion]" ;
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
                  return conditional_P002Z2(context, remoteHandle, httpContext, (String)dynConstraints[0] , (GXSimpleCollection<String>)dynConstraints[1] , (String)dynConstraints[2] , (GXSimpleCollection<String>)dynConstraints[3] , (String)dynConstraints[4] , ((Number) dynConstraints[5]).shortValue() , ((Number) dynConstraints[6]).shortValue() , (String)dynConstraints[7] , (String)dynConstraints[8] , (String)dynConstraints[9] , (String)dynConstraints[10] , ((Number) dynConstraints[11]).intValue() , (String)dynConstraints[12] , (String)dynConstraints[13] , (String)dynConstraints[14] , (String)dynConstraints[15] , ((Number) dynConstraints[16]).intValue() , ((Number) dynConstraints[17]).shortValue() , (String)dynConstraints[18] , (String)dynConstraints[19] , (String)dynConstraints[20] , (String)dynConstraints[21] );
            case 1 :
                  return conditional_P002Z3(context, remoteHandle, httpContext, (String)dynConstraints[0] , (GXSimpleCollection<String>)dynConstraints[1] , (String)dynConstraints[2] , (GXSimpleCollection<String>)dynConstraints[3] , (String)dynConstraints[4] , ((Number) dynConstraints[5]).shortValue() , ((Number) dynConstraints[6]).shortValue() , (String)dynConstraints[7] , (String)dynConstraints[8] , (String)dynConstraints[9] , (String)dynConstraints[10] , ((Number) dynConstraints[11]).intValue() , (String)dynConstraints[12] , (String)dynConstraints[13] , (String)dynConstraints[14] , (String)dynConstraints[15] , ((Number) dynConstraints[16]).intValue() , ((Number) dynConstraints[17]).shortValue() , (String)dynConstraints[18] , (String)dynConstraints[19] , (String)dynConstraints[20] , (String)dynConstraints[21] );
            case 2 :
                  return conditional_P002Z4(context, remoteHandle, httpContext, (String)dynConstraints[0] , (GXSimpleCollection<String>)dynConstraints[1] , (String)dynConstraints[2] , (GXSimpleCollection<String>)dynConstraints[3] , (String)dynConstraints[4] , ((Number) dynConstraints[5]).shortValue() , ((Number) dynConstraints[6]).shortValue() , (String)dynConstraints[7] , (String)dynConstraints[8] , (String)dynConstraints[9] , (String)dynConstraints[10] , ((Number) dynConstraints[11]).intValue() , (String)dynConstraints[12] , (String)dynConstraints[13] , (String)dynConstraints[14] , (String)dynConstraints[15] , ((Number) dynConstraints[16]).intValue() , ((Number) dynConstraints[17]).shortValue() , (String)dynConstraints[18] , (String)dynConstraints[19] , (String)dynConstraints[20] , (String)dynConstraints[21] );
            case 3 :
                  return conditional_P002Z5(context, remoteHandle, httpContext, (String)dynConstraints[0] , (GXSimpleCollection<String>)dynConstraints[1] , (String)dynConstraints[2] , (GXSimpleCollection<String>)dynConstraints[3] , (String)dynConstraints[4] , ((Number) dynConstraints[5]).shortValue() , ((Number) dynConstraints[6]).shortValue() , (String)dynConstraints[7] , (String)dynConstraints[8] , (String)dynConstraints[9] , (String)dynConstraints[10] , ((Number) dynConstraints[11]).intValue() , (String)dynConstraints[12] , (String)dynConstraints[13] , (String)dynConstraints[14] , (String)dynConstraints[15] , ((Number) dynConstraints[16]).intValue() , ((Number) dynConstraints[17]).shortValue() , (String)dynConstraints[18] , (String)dynConstraints[19] , (String)dynConstraints[20] , (String)dynConstraints[21] );
      }
      return super.getDynamicStatement(cursor, context, remoteHandle, httpContext, dynConstraints);
   }

   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P002Z2", "scmdbuf",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("P002Z3", "scmdbuf",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("P002Z4", "scmdbuf",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("P002Z5", "scmdbuf",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
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
               ((String[]) buf[5])[0] = rslt.getString(6, 1);
               ((String[]) buf[6])[0] = rslt.getVarchar(7);
               return;
            case 1 :
               ((String[]) buf[0])[0] = rslt.getVarchar(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((String[]) buf[2])[0] = rslt.getString(3, 1);
               ((String[]) buf[3])[0] = rslt.getVarchar(4);
               ((String[]) buf[4])[0] = rslt.getVarchar(5);
               ((String[]) buf[5])[0] = rslt.getString(6, 1);
               ((String[]) buf[6])[0] = rslt.getVarchar(7);
               return;
            case 2 :
               ((String[]) buf[0])[0] = rslt.getVarchar(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((String[]) buf[2])[0] = rslt.getString(3, 1);
               ((String[]) buf[3])[0] = rslt.getVarchar(4);
               ((String[]) buf[4])[0] = rslt.getString(5, 1);
               ((String[]) buf[5])[0] = rslt.getVarchar(6);
               ((String[]) buf[6])[0] = rslt.getVarchar(7);
               return;
            case 3 :
               ((String[]) buf[0])[0] = rslt.getVarchar(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((String[]) buf[2])[0] = rslt.getString(3, 1);
               ((String[]) buf[3])[0] = rslt.getVarchar(4);
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
                  stmt.setVarchar(sIdx, (String)parms[23], 100);
               }
               if ( ((Number) parms[1]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[24], 100);
               }
               if ( ((Number) parms[2]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[25], 100);
               }
               if ( ((Number) parms[3]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[26], 100);
               }
               if ( ((Number) parms[4]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[27], 100);
               }
               if ( ((Number) parms[5]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[28], 100);
               }
               if ( ((Number) parms[6]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[29], 100);
               }
               if ( ((Number) parms[7]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[30], 100);
               }
               if ( ((Number) parms[8]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[31], 100);
               }
               if ( ((Number) parms[9]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[32], 100);
               }
               if ( ((Number) parms[10]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[33], 100);
               }
               if ( ((Number) parms[11]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[34], 100);
               }
               if ( ((Number) parms[12]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[35], 100);
               }
               if ( ((Number) parms[13]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[36]).shortValue());
               }
               if ( ((Number) parms[14]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[37]).shortValue());
               }
               if ( ((Number) parms[15]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[38], 80);
               }
               if ( ((Number) parms[16]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[39], 80);
               }
               if ( ((Number) parms[17]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[40], 100);
               }
               if ( ((Number) parms[18]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[41], 100);
               }
               if ( ((Number) parms[19]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[42], 15);
               }
               if ( ((Number) parms[20]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[43], 15);
               }
               if ( ((Number) parms[21]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[44], 100);
               }
               if ( ((Number) parms[22]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[45], 100);
               }
               return;
            case 1 :
               sIdx = (short)(0) ;
               if ( ((Number) parms[0]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[23], 100);
               }
               if ( ((Number) parms[1]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[24], 100);
               }
               if ( ((Number) parms[2]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[25], 100);
               }
               if ( ((Number) parms[3]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[26], 100);
               }
               if ( ((Number) parms[4]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[27], 100);
               }
               if ( ((Number) parms[5]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[28], 100);
               }
               if ( ((Number) parms[6]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[29], 100);
               }
               if ( ((Number) parms[7]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[30], 100);
               }
               if ( ((Number) parms[8]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[31], 100);
               }
               if ( ((Number) parms[9]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[32], 100);
               }
               if ( ((Number) parms[10]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[33], 100);
               }
               if ( ((Number) parms[11]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[34], 100);
               }
               if ( ((Number) parms[12]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[35], 100);
               }
               if ( ((Number) parms[13]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[36]).shortValue());
               }
               if ( ((Number) parms[14]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[37]).shortValue());
               }
               if ( ((Number) parms[15]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[38], 80);
               }
               if ( ((Number) parms[16]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[39], 80);
               }
               if ( ((Number) parms[17]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[40], 100);
               }
               if ( ((Number) parms[18]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[41], 100);
               }
               if ( ((Number) parms[19]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[42], 15);
               }
               if ( ((Number) parms[20]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[43], 15);
               }
               if ( ((Number) parms[21]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[44], 100);
               }
               if ( ((Number) parms[22]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[45], 100);
               }
               return;
            case 2 :
               sIdx = (short)(0) ;
               if ( ((Number) parms[0]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[23], 100);
               }
               if ( ((Number) parms[1]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[24], 100);
               }
               if ( ((Number) parms[2]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[25], 100);
               }
               if ( ((Number) parms[3]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[26], 100);
               }
               if ( ((Number) parms[4]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[27], 100);
               }
               if ( ((Number) parms[5]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[28], 100);
               }
               if ( ((Number) parms[6]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[29], 100);
               }
               if ( ((Number) parms[7]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[30], 100);
               }
               if ( ((Number) parms[8]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[31], 100);
               }
               if ( ((Number) parms[9]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[32], 100);
               }
               if ( ((Number) parms[10]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[33], 100);
               }
               if ( ((Number) parms[11]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[34], 100);
               }
               if ( ((Number) parms[12]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[35], 100);
               }
               if ( ((Number) parms[13]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[36]).shortValue());
               }
               if ( ((Number) parms[14]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[37]).shortValue());
               }
               if ( ((Number) parms[15]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[38], 80);
               }
               if ( ((Number) parms[16]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[39], 80);
               }
               if ( ((Number) parms[17]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[40], 100);
               }
               if ( ((Number) parms[18]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[41], 100);
               }
               if ( ((Number) parms[19]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[42], 15);
               }
               if ( ((Number) parms[20]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[43], 15);
               }
               if ( ((Number) parms[21]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[44], 100);
               }
               if ( ((Number) parms[22]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[45], 100);
               }
               return;
            case 3 :
               sIdx = (short)(0) ;
               if ( ((Number) parms[0]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[23], 100);
               }
               if ( ((Number) parms[1]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[24], 100);
               }
               if ( ((Number) parms[2]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[25], 100);
               }
               if ( ((Number) parms[3]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[26], 100);
               }
               if ( ((Number) parms[4]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[27], 100);
               }
               if ( ((Number) parms[5]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[28], 100);
               }
               if ( ((Number) parms[6]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[29], 100);
               }
               if ( ((Number) parms[7]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[30], 100);
               }
               if ( ((Number) parms[8]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[31], 100);
               }
               if ( ((Number) parms[9]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[32], 100);
               }
               if ( ((Number) parms[10]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[33], 100);
               }
               if ( ((Number) parms[11]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[34], 100);
               }
               if ( ((Number) parms[12]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[35], 100);
               }
               if ( ((Number) parms[13]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[36]).shortValue());
               }
               if ( ((Number) parms[14]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[37]).shortValue());
               }
               if ( ((Number) parms[15]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[38], 80);
               }
               if ( ((Number) parms[16]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[39], 80);
               }
               if ( ((Number) parms[17]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[40], 100);
               }
               if ( ((Number) parms[18]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[41], 100);
               }
               if ( ((Number) parms[19]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[42], 15);
               }
               if ( ((Number) parms[20]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[43], 15);
               }
               if ( ((Number) parms[21]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[44], 100);
               }
               if ( ((Number) parms[22]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[45], 100);
               }
               return;
      }
   }

}

