package com.projectthani ;
import com.projectthani.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class configwwgetfilterdata extends GXProcedure
{
   public configwwgetfilterdata( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( configwwgetfilterdata.class ), "" );
   }

   public configwwgetfilterdata( int remoteHandle ,
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
      configwwgetfilterdata.this.aP5 = new String[] {""};
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
      configwwgetfilterdata.this.AV21DDOName = aP0;
      configwwgetfilterdata.this.AV19SearchTxt = aP1;
      configwwgetfilterdata.this.AV20SearchTxtTo = aP2;
      configwwgetfilterdata.this.aP3 = aP3;
      configwwgetfilterdata.this.aP4 = aP4;
      configwwgetfilterdata.this.aP5 = aP5;
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
      new com.projectthani.wwpbaseobjects.secisauthbyfunctionalitykey(remoteHandle, context).execute( "WWConfig", GXv_boolean2) ;
      configwwgetfilterdata.this.GXt_boolean1 = GXv_boolean2[0] ;
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
         if ( GXutil.strcmp(GXutil.upper( AV21DDOName), "DDO_CONFIGKEY") == 0 )
         {
            /* Execute user subroutine: 'LOADCONFIGKEYOPTIONS' */
            S121 ();
            if ( returnInSub )
            {
               returnInSub = true;
               cleanup();
               if (true) return;
            }
         }
         else if ( GXutil.strcmp(GXutil.upper( AV21DDOName), "DDO_CONFIGVALUE") == 0 )
         {
            /* Execute user subroutine: 'LOADCONFIGVALUEOPTIONS' */
            S131 ();
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
      if ( GXutil.strcmp(AV32Session.getValue("ConfigWWGridState"), "") == 0 )
      {
         AV34GridState.fromxml(new com.projectthani.wwpbaseobjects.loadgridstate(remoteHandle, context).executeUdp( "ConfigWWGridState"), null, null);
      }
      else
      {
         AV34GridState.fromxml(AV32Session.getValue("ConfigWWGridState"), null, null);
      }
      AV40GXV1 = 1 ;
      while ( AV40GXV1 <= AV34GridState.getgxTv_SdtWWPGridState_Filtervalues().size() )
      {
         AV35GridStateFilterValue = (com.projectthani.wwpbaseobjects.SdtWWPGridState_FilterValue)((com.projectthani.wwpbaseobjects.SdtWWPGridState_FilterValue)AV34GridState.getgxTv_SdtWWPGridState_Filtervalues().elementAt(-1+AV40GXV1));
         if ( GXutil.strcmp(AV35GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "FILTERFULLTEXT") == 0 )
         {
            AV37FilterFullText = AV35GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV35GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFCONFIGID") == 0 )
         {
            AV11TFConfigId = (short)(GXutil.lval( AV35GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value())) ;
            AV12TFConfigId_To = (short)(GXutil.lval( AV35GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Valueto())) ;
         }
         else if ( GXutil.strcmp(AV35GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFCONFIGKEY") == 0 )
         {
            AV13TFConfigKey = AV35GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV35GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFCONFIGKEY_SEL") == 0 )
         {
            AV14TFConfigKey_Sel = AV35GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV35GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFCONFIGVALUE") == 0 )
         {
            AV15TFConfigValue = AV35GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV35GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFCONFIGVALUE_SEL") == 0 )
         {
            AV16TFConfigValue_Sel = AV35GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV35GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFCONFIGESTADOR_SEL") == 0 )
         {
            AV17TFConfigEstadoR_SelsJson = AV35GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            AV18TFConfigEstadoR_Sels.fromJSonString(AV17TFConfigEstadoR_SelsJson, null);
         }
         AV40GXV1 = (int)(AV40GXV1+1) ;
      }
   }

   public void S121( )
   {
      /* 'LOADCONFIGKEYOPTIONS' Routine */
      returnInSub = false ;
      AV13TFConfigKey = AV19SearchTxt ;
      AV14TFConfigKey_Sel = "" ;
      AV42Configwwds_1_filterfulltext = AV37FilterFullText ;
      AV43Configwwds_2_tfconfigid = AV11TFConfigId ;
      AV44Configwwds_3_tfconfigid_to = AV12TFConfigId_To ;
      AV45Configwwds_4_tfconfigkey = AV13TFConfigKey ;
      AV46Configwwds_5_tfconfigkey_sel = AV14TFConfigKey_Sel ;
      AV47Configwwds_6_tfconfigvalue = AV15TFConfigValue ;
      AV48Configwwds_7_tfconfigvalue_sel = AV16TFConfigValue_Sel ;
      AV49Configwwds_8_tfconfigestador_sels = AV18TFConfigEstadoR_Sels ;
      pr_default.dynParam(0, new Object[]{ new Object[]{
                                           A129ConfigEstadoR ,
                                           AV49Configwwds_8_tfconfigestador_sels ,
                                           AV42Configwwds_1_filterfulltext ,
                                           Short.valueOf(AV43Configwwds_2_tfconfigid) ,
                                           Short.valueOf(AV44Configwwds_3_tfconfigid_to) ,
                                           AV46Configwwds_5_tfconfigkey_sel ,
                                           AV45Configwwds_4_tfconfigkey ,
                                           AV48Configwwds_7_tfconfigvalue_sel ,
                                           AV47Configwwds_6_tfconfigvalue ,
                                           Integer.valueOf(AV49Configwwds_8_tfconfigestador_sels.size()) ,
                                           Short.valueOf(A33ConfigId) ,
                                           A127ConfigKey ,
                                           A128ConfigValue } ,
                                           new int[]{
                                           TypeConstants.STRING, TypeConstants.STRING, TypeConstants.SHORT, TypeConstants.SHORT, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.INT, TypeConstants.SHORT,
                                           TypeConstants.STRING, TypeConstants.STRING
                                           }
      });
      lV42Configwwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV42Configwwds_1_filterfulltext), "%", "") ;
      lV42Configwwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV42Configwwds_1_filterfulltext), "%", "") ;
      lV42Configwwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV42Configwwds_1_filterfulltext), "%", "") ;
      lV42Configwwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV42Configwwds_1_filterfulltext), "%", "") ;
      lV42Configwwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV42Configwwds_1_filterfulltext), "%", "") ;
      lV45Configwwds_4_tfconfigkey = GXutil.concat( GXutil.rtrim( AV45Configwwds_4_tfconfigkey), "%", "") ;
      lV47Configwwds_6_tfconfigvalue = GXutil.concat( GXutil.rtrim( AV47Configwwds_6_tfconfigvalue), "%", "") ;
      /* Using cursor P002U2 */
      pr_default.execute(0, new Object[] {lV42Configwwds_1_filterfulltext, lV42Configwwds_1_filterfulltext, lV42Configwwds_1_filterfulltext, lV42Configwwds_1_filterfulltext, lV42Configwwds_1_filterfulltext, Short.valueOf(AV43Configwwds_2_tfconfigid), Short.valueOf(AV44Configwwds_3_tfconfigid_to), lV45Configwwds_4_tfconfigkey, AV46Configwwds_5_tfconfigkey_sel, lV47Configwwds_6_tfconfigvalue, AV48Configwwds_7_tfconfigvalue_sel});
      while ( (pr_default.getStatus(0) != 101) )
      {
         brk2U2 = false ;
         A127ConfigKey = P002U2_A127ConfigKey[0] ;
         A33ConfigId = P002U2_A33ConfigId[0] ;
         A129ConfigEstadoR = P002U2_A129ConfigEstadoR[0] ;
         A128ConfigValue = P002U2_A128ConfigValue[0] ;
         AV31count = 0 ;
         while ( (pr_default.getStatus(0) != 101) && ( GXutil.strcmp(P002U2_A127ConfigKey[0], A127ConfigKey) == 0 ) )
         {
            brk2U2 = false ;
            A33ConfigId = P002U2_A33ConfigId[0] ;
            AV31count = (long)(AV31count+1) ;
            brk2U2 = true ;
            pr_default.readNext(0);
         }
         if ( ! (GXutil.strcmp("", A127ConfigKey)==0) )
         {
            AV23Option = A127ConfigKey ;
            AV24Options.add(AV23Option, 0);
            AV29OptionIndexes.add(GXutil.trim( localUtil.format( DecimalUtil.doubleToDec(AV31count), "Z,ZZZ,ZZZ,ZZ9")), 0);
         }
         if ( AV24Options.size() == 50 )
         {
            /* Exit For each command. Update data (if necessary), close cursors & exit. */
            if (true) break;
         }
         if ( ! brk2U2 )
         {
            brk2U2 = true ;
            pr_default.readNext(0);
         }
      }
      pr_default.close(0);
   }

   public void S131( )
   {
      /* 'LOADCONFIGVALUEOPTIONS' Routine */
      returnInSub = false ;
      AV15TFConfigValue = AV19SearchTxt ;
      AV16TFConfigValue_Sel = "" ;
      AV42Configwwds_1_filterfulltext = AV37FilterFullText ;
      AV43Configwwds_2_tfconfigid = AV11TFConfigId ;
      AV44Configwwds_3_tfconfigid_to = AV12TFConfigId_To ;
      AV45Configwwds_4_tfconfigkey = AV13TFConfigKey ;
      AV46Configwwds_5_tfconfigkey_sel = AV14TFConfigKey_Sel ;
      AV47Configwwds_6_tfconfigvalue = AV15TFConfigValue ;
      AV48Configwwds_7_tfconfigvalue_sel = AV16TFConfigValue_Sel ;
      AV49Configwwds_8_tfconfigestador_sels = AV18TFConfigEstadoR_Sels ;
      pr_default.dynParam(1, new Object[]{ new Object[]{
                                           A129ConfigEstadoR ,
                                           AV49Configwwds_8_tfconfigestador_sels ,
                                           AV42Configwwds_1_filterfulltext ,
                                           Short.valueOf(AV43Configwwds_2_tfconfigid) ,
                                           Short.valueOf(AV44Configwwds_3_tfconfigid_to) ,
                                           AV46Configwwds_5_tfconfigkey_sel ,
                                           AV45Configwwds_4_tfconfigkey ,
                                           AV48Configwwds_7_tfconfigvalue_sel ,
                                           AV47Configwwds_6_tfconfigvalue ,
                                           Integer.valueOf(AV49Configwwds_8_tfconfigestador_sels.size()) ,
                                           Short.valueOf(A33ConfigId) ,
                                           A127ConfigKey ,
                                           A128ConfigValue } ,
                                           new int[]{
                                           TypeConstants.STRING, TypeConstants.STRING, TypeConstants.SHORT, TypeConstants.SHORT, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.INT, TypeConstants.SHORT,
                                           TypeConstants.STRING, TypeConstants.STRING
                                           }
      });
      lV42Configwwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV42Configwwds_1_filterfulltext), "%", "") ;
      lV42Configwwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV42Configwwds_1_filterfulltext), "%", "") ;
      lV42Configwwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV42Configwwds_1_filterfulltext), "%", "") ;
      lV42Configwwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV42Configwwds_1_filterfulltext), "%", "") ;
      lV42Configwwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV42Configwwds_1_filterfulltext), "%", "") ;
      lV45Configwwds_4_tfconfigkey = GXutil.concat( GXutil.rtrim( AV45Configwwds_4_tfconfigkey), "%", "") ;
      lV47Configwwds_6_tfconfigvalue = GXutil.concat( GXutil.rtrim( AV47Configwwds_6_tfconfigvalue), "%", "") ;
      /* Using cursor P002U3 */
      pr_default.execute(1, new Object[] {lV42Configwwds_1_filterfulltext, lV42Configwwds_1_filterfulltext, lV42Configwwds_1_filterfulltext, lV42Configwwds_1_filterfulltext, lV42Configwwds_1_filterfulltext, Short.valueOf(AV43Configwwds_2_tfconfigid), Short.valueOf(AV44Configwwds_3_tfconfigid_to), lV45Configwwds_4_tfconfigkey, AV46Configwwds_5_tfconfigkey_sel, lV47Configwwds_6_tfconfigvalue, AV48Configwwds_7_tfconfigvalue_sel});
      while ( (pr_default.getStatus(1) != 101) )
      {
         brk2U4 = false ;
         A128ConfigValue = P002U3_A128ConfigValue[0] ;
         A33ConfigId = P002U3_A33ConfigId[0] ;
         A129ConfigEstadoR = P002U3_A129ConfigEstadoR[0] ;
         A127ConfigKey = P002U3_A127ConfigKey[0] ;
         AV31count = 0 ;
         while ( (pr_default.getStatus(1) != 101) && ( GXutil.strcmp(P002U3_A128ConfigValue[0], A128ConfigValue) == 0 ) )
         {
            brk2U4 = false ;
            A33ConfigId = P002U3_A33ConfigId[0] ;
            AV31count = (long)(AV31count+1) ;
            brk2U4 = true ;
            pr_default.readNext(1);
         }
         if ( ! (GXutil.strcmp("", A128ConfigValue)==0) )
         {
            AV23Option = A128ConfigValue ;
            AV24Options.add(AV23Option, 0);
            AV29OptionIndexes.add(GXutil.trim( localUtil.format( DecimalUtil.doubleToDec(AV31count), "Z,ZZZ,ZZZ,ZZ9")), 0);
         }
         if ( AV24Options.size() == 50 )
         {
            /* Exit For each command. Update data (if necessary), close cursors & exit. */
            if (true) break;
         }
         if ( ! brk2U4 )
         {
            brk2U4 = true ;
            pr_default.readNext(1);
         }
      }
      pr_default.close(1);
   }

   protected void cleanup( )
   {
      this.aP3[0] = configwwgetfilterdata.this.AV25OptionsJson;
      this.aP4[0] = configwwgetfilterdata.this.AV28OptionsDescJson;
      this.aP5[0] = configwwgetfilterdata.this.AV30OptionIndexesJson;
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
      AV13TFConfigKey = "" ;
      AV14TFConfigKey_Sel = "" ;
      AV15TFConfigValue = "" ;
      AV16TFConfigValue_Sel = "" ;
      AV17TFConfigEstadoR_SelsJson = "" ;
      AV18TFConfigEstadoR_Sels = new GXSimpleCollection<String>(String.class, "internal", "");
      A127ConfigKey = "" ;
      AV42Configwwds_1_filterfulltext = "" ;
      AV45Configwwds_4_tfconfigkey = "" ;
      AV46Configwwds_5_tfconfigkey_sel = "" ;
      AV47Configwwds_6_tfconfigvalue = "" ;
      AV48Configwwds_7_tfconfigvalue_sel = "" ;
      AV49Configwwds_8_tfconfigestador_sels = new GXSimpleCollection<String>(String.class, "internal", "");
      scmdbuf = "" ;
      lV42Configwwds_1_filterfulltext = "" ;
      lV45Configwwds_4_tfconfigkey = "" ;
      lV47Configwwds_6_tfconfigvalue = "" ;
      A129ConfigEstadoR = "" ;
      A128ConfigValue = "" ;
      P002U2_A127ConfigKey = new String[] {""} ;
      P002U2_A33ConfigId = new short[1] ;
      P002U2_A129ConfigEstadoR = new String[] {""} ;
      P002U2_A128ConfigValue = new String[] {""} ;
      AV23Option = "" ;
      P002U3_A128ConfigValue = new String[] {""} ;
      P002U3_A33ConfigId = new short[1] ;
      P002U3_A129ConfigEstadoR = new String[] {""} ;
      P002U3_A127ConfigKey = new String[] {""} ;
      pr_default = new DataStoreProvider(context, remoteHandle, new com.projectthani.configwwgetfilterdata__default(),
         new Object[] {
             new Object[] {
            P002U2_A127ConfigKey, P002U2_A33ConfigId, P002U2_A129ConfigEstadoR, P002U2_A128ConfigValue
            }
            , new Object[] {
            P002U3_A128ConfigValue, P002U3_A33ConfigId, P002U3_A129ConfigEstadoR, P002U3_A127ConfigKey
            }
         }
      );
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private short AV11TFConfigId ;
   private short AV12TFConfigId_To ;
   private short AV43Configwwds_2_tfconfigid ;
   private short AV44Configwwds_3_tfconfigid_to ;
   private short A33ConfigId ;
   private short Gx_err ;
   private int AV40GXV1 ;
   private int AV49Configwwds_8_tfconfigestador_sels_size ;
   private long AV31count ;
   private String scmdbuf ;
   private String A129ConfigEstadoR ;
   private boolean AV8IsAuthorized ;
   private boolean GXt_boolean1 ;
   private boolean GXv_boolean2[] ;
   private boolean returnInSub ;
   private boolean brk2U2 ;
   private boolean brk2U4 ;
   private String AV25OptionsJson ;
   private String AV28OptionsDescJson ;
   private String AV30OptionIndexesJson ;
   private String AV17TFConfigEstadoR_SelsJson ;
   private String AV21DDOName ;
   private String AV19SearchTxt ;
   private String AV20SearchTxtTo ;
   private String AV37FilterFullText ;
   private String AV13TFConfigKey ;
   private String AV14TFConfigKey_Sel ;
   private String AV15TFConfigValue ;
   private String AV16TFConfigValue_Sel ;
   private String A127ConfigKey ;
   private String AV42Configwwds_1_filterfulltext ;
   private String AV45Configwwds_4_tfconfigkey ;
   private String AV46Configwwds_5_tfconfigkey_sel ;
   private String AV47Configwwds_6_tfconfigvalue ;
   private String AV48Configwwds_7_tfconfigvalue_sel ;
   private String lV42Configwwds_1_filterfulltext ;
   private String lV45Configwwds_4_tfconfigkey ;
   private String lV47Configwwds_6_tfconfigvalue ;
   private String A128ConfigValue ;
   private String AV23Option ;
   private com.genexus.webpanels.WebSession AV32Session ;
   private String[] aP5 ;
   private String[] aP3 ;
   private String[] aP4 ;
   private IDataStoreProvider pr_default ;
   private String[] P002U2_A127ConfigKey ;
   private short[] P002U2_A33ConfigId ;
   private String[] P002U2_A129ConfigEstadoR ;
   private String[] P002U2_A128ConfigValue ;
   private String[] P002U3_A128ConfigValue ;
   private short[] P002U3_A33ConfigId ;
   private String[] P002U3_A129ConfigEstadoR ;
   private String[] P002U3_A127ConfigKey ;
   private GXSimpleCollection<String> AV18TFConfigEstadoR_Sels ;
   private GXSimpleCollection<String> AV49Configwwds_8_tfconfigestador_sels ;
   private GXSimpleCollection<String> AV24Options ;
   private GXSimpleCollection<String> AV27OptionsDesc ;
   private GXSimpleCollection<String> AV29OptionIndexes ;
   private com.projectthani.wwpbaseobjects.SdtWWPContext AV9WWPContext ;
   private com.projectthani.wwpbaseobjects.SdtWWPContext GXv_SdtWWPContext3[] ;
   private com.projectthani.wwpbaseobjects.SdtWWPGridState AV34GridState ;
   private com.projectthani.wwpbaseobjects.SdtWWPGridState_FilterValue AV35GridStateFilterValue ;
}

final  class configwwgetfilterdata__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   protected Object[] conditional_P002U2( ModelContext context ,
                                          int remoteHandle ,
                                          com.genexus.IHttpContext httpContext ,
                                          String A129ConfigEstadoR ,
                                          GXSimpleCollection<String> AV49Configwwds_8_tfconfigestador_sels ,
                                          String AV42Configwwds_1_filterfulltext ,
                                          short AV43Configwwds_2_tfconfigid ,
                                          short AV44Configwwds_3_tfconfigid_to ,
                                          String AV46Configwwds_5_tfconfigkey_sel ,
                                          String AV45Configwwds_4_tfconfigkey ,
                                          String AV48Configwwds_7_tfconfigvalue_sel ,
                                          String AV47Configwwds_6_tfconfigvalue ,
                                          int AV49Configwwds_8_tfconfigestador_sels_size ,
                                          short A33ConfigId ,
                                          String A127ConfigKey ,
                                          String A128ConfigValue )
   {
      java.lang.StringBuffer sWhereString = new java.lang.StringBuffer();
      String scmdbuf;
      byte[] GXv_int4 = new byte[11];
      Object[] GXv_Object5 = new Object[2];
      scmdbuf = "SELECT [ConfigKey], [ConfigId], [ConfigEstadoR], [ConfigValue] FROM [Config]" ;
      if ( ! (GXutil.strcmp("", AV42Configwwds_1_filterfulltext)==0) )
      {
         addWhere(sWhereString, "(( CONVERT( char(4), CAST([ConfigId] AS decimal(4,0))) like '%' + ?) or ( [ConfigKey] like '%' + ?) or ( [ConfigValue] like '%' + ?) or ( 'activo' like '%' + LOWER(?) and [ConfigEstadoR] = 'A') or ( 'inactivo' like '%' + LOWER(?) and [ConfigEstadoR] = 'I'))");
      }
      else
      {
         GXv_int4[0] = (byte)(1) ;
         GXv_int4[1] = (byte)(1) ;
         GXv_int4[2] = (byte)(1) ;
         GXv_int4[3] = (byte)(1) ;
         GXv_int4[4] = (byte)(1) ;
      }
      if ( ! (0==AV43Configwwds_2_tfconfigid) )
      {
         addWhere(sWhereString, "([ConfigId] >= ?)");
      }
      else
      {
         GXv_int4[5] = (byte)(1) ;
      }
      if ( ! (0==AV44Configwwds_3_tfconfigid_to) )
      {
         addWhere(sWhereString, "([ConfigId] <= ?)");
      }
      else
      {
         GXv_int4[6] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV46Configwwds_5_tfconfigkey_sel)==0) && ( ! (GXutil.strcmp("", AV45Configwwds_4_tfconfigkey)==0) ) )
      {
         addWhere(sWhereString, "([ConfigKey] like ?)");
      }
      else
      {
         GXv_int4[7] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV46Configwwds_5_tfconfigkey_sel)==0) )
      {
         addWhere(sWhereString, "([ConfigKey] = ?)");
      }
      else
      {
         GXv_int4[8] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV48Configwwds_7_tfconfigvalue_sel)==0) && ( ! (GXutil.strcmp("", AV47Configwwds_6_tfconfigvalue)==0) ) )
      {
         addWhere(sWhereString, "([ConfigValue] like ?)");
      }
      else
      {
         GXv_int4[9] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV48Configwwds_7_tfconfigvalue_sel)==0) )
      {
         addWhere(sWhereString, "([ConfigValue] = ?)");
      }
      else
      {
         GXv_int4[10] = (byte)(1) ;
      }
      if ( AV49Configwwds_8_tfconfigestador_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("sqlserver", AV49Configwwds_8_tfconfigestador_sels, "[ConfigEstadoR] IN (", ")")+")");
      }
      scmdbuf += sWhereString ;
      scmdbuf += " ORDER BY [ConfigKey]" ;
      GXv_Object5[0] = scmdbuf ;
      GXv_Object5[1] = GXv_int4 ;
      return GXv_Object5 ;
   }

   protected Object[] conditional_P002U3( ModelContext context ,
                                          int remoteHandle ,
                                          com.genexus.IHttpContext httpContext ,
                                          String A129ConfigEstadoR ,
                                          GXSimpleCollection<String> AV49Configwwds_8_tfconfigestador_sels ,
                                          String AV42Configwwds_1_filterfulltext ,
                                          short AV43Configwwds_2_tfconfigid ,
                                          short AV44Configwwds_3_tfconfigid_to ,
                                          String AV46Configwwds_5_tfconfigkey_sel ,
                                          String AV45Configwwds_4_tfconfigkey ,
                                          String AV48Configwwds_7_tfconfigvalue_sel ,
                                          String AV47Configwwds_6_tfconfigvalue ,
                                          int AV49Configwwds_8_tfconfigestador_sels_size ,
                                          short A33ConfigId ,
                                          String A127ConfigKey ,
                                          String A128ConfigValue )
   {
      java.lang.StringBuffer sWhereString = new java.lang.StringBuffer();
      String scmdbuf;
      byte[] GXv_int7 = new byte[11];
      Object[] GXv_Object8 = new Object[2];
      scmdbuf = "SELECT [ConfigValue], [ConfigId], [ConfigEstadoR], [ConfigKey] FROM [Config]" ;
      if ( ! (GXutil.strcmp("", AV42Configwwds_1_filterfulltext)==0) )
      {
         addWhere(sWhereString, "(( CONVERT( char(4), CAST([ConfigId] AS decimal(4,0))) like '%' + ?) or ( [ConfigKey] like '%' + ?) or ( [ConfigValue] like '%' + ?) or ( 'activo' like '%' + LOWER(?) and [ConfigEstadoR] = 'A') or ( 'inactivo' like '%' + LOWER(?) and [ConfigEstadoR] = 'I'))");
      }
      else
      {
         GXv_int7[0] = (byte)(1) ;
         GXv_int7[1] = (byte)(1) ;
         GXv_int7[2] = (byte)(1) ;
         GXv_int7[3] = (byte)(1) ;
         GXv_int7[4] = (byte)(1) ;
      }
      if ( ! (0==AV43Configwwds_2_tfconfigid) )
      {
         addWhere(sWhereString, "([ConfigId] >= ?)");
      }
      else
      {
         GXv_int7[5] = (byte)(1) ;
      }
      if ( ! (0==AV44Configwwds_3_tfconfigid_to) )
      {
         addWhere(sWhereString, "([ConfigId] <= ?)");
      }
      else
      {
         GXv_int7[6] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV46Configwwds_5_tfconfigkey_sel)==0) && ( ! (GXutil.strcmp("", AV45Configwwds_4_tfconfigkey)==0) ) )
      {
         addWhere(sWhereString, "([ConfigKey] like ?)");
      }
      else
      {
         GXv_int7[7] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV46Configwwds_5_tfconfigkey_sel)==0) )
      {
         addWhere(sWhereString, "([ConfigKey] = ?)");
      }
      else
      {
         GXv_int7[8] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV48Configwwds_7_tfconfigvalue_sel)==0) && ( ! (GXutil.strcmp("", AV47Configwwds_6_tfconfigvalue)==0) ) )
      {
         addWhere(sWhereString, "([ConfigValue] like ?)");
      }
      else
      {
         GXv_int7[9] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV48Configwwds_7_tfconfigvalue_sel)==0) )
      {
         addWhere(sWhereString, "([ConfigValue] = ?)");
      }
      else
      {
         GXv_int7[10] = (byte)(1) ;
      }
      if ( AV49Configwwds_8_tfconfigestador_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("sqlserver", AV49Configwwds_8_tfconfigestador_sels, "[ConfigEstadoR] IN (", ")")+")");
      }
      scmdbuf += sWhereString ;
      scmdbuf += " ORDER BY [ConfigValue]" ;
      GXv_Object8[0] = scmdbuf ;
      GXv_Object8[1] = GXv_int7 ;
      return GXv_Object8 ;
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
                  return conditional_P002U2(context, remoteHandle, httpContext, (String)dynConstraints[0] , (GXSimpleCollection<String>)dynConstraints[1] , (String)dynConstraints[2] , ((Number) dynConstraints[3]).shortValue() , ((Number) dynConstraints[4]).shortValue() , (String)dynConstraints[5] , (String)dynConstraints[6] , (String)dynConstraints[7] , (String)dynConstraints[8] , ((Number) dynConstraints[9]).intValue() , ((Number) dynConstraints[10]).shortValue() , (String)dynConstraints[11] , (String)dynConstraints[12] );
            case 1 :
                  return conditional_P002U3(context, remoteHandle, httpContext, (String)dynConstraints[0] , (GXSimpleCollection<String>)dynConstraints[1] , (String)dynConstraints[2] , ((Number) dynConstraints[3]).shortValue() , ((Number) dynConstraints[4]).shortValue() , (String)dynConstraints[5] , (String)dynConstraints[6] , (String)dynConstraints[7] , (String)dynConstraints[8] , ((Number) dynConstraints[9]).intValue() , ((Number) dynConstraints[10]).shortValue() , (String)dynConstraints[11] , (String)dynConstraints[12] );
      }
      return super.getDynamicStatement(cursor, context, remoteHandle, httpContext, dynConstraints);
   }

   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P002U2", "scmdbuf",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("P002U3", "scmdbuf",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
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
               return;
            case 1 :
               ((String[]) buf[0])[0] = rslt.getVarchar(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((String[]) buf[2])[0] = rslt.getString(3, 1);
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
                  stmt.setVarchar(sIdx, (String)parms[11], 100);
               }
               if ( ((Number) parms[1]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[12], 100);
               }
               if ( ((Number) parms[2]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[13], 100);
               }
               if ( ((Number) parms[3]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[14], 100);
               }
               if ( ((Number) parms[4]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[15], 100);
               }
               if ( ((Number) parms[5]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[16]).shortValue());
               }
               if ( ((Number) parms[6]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[17]).shortValue());
               }
               if ( ((Number) parms[7]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[18], 100);
               }
               if ( ((Number) parms[8]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[19], 100);
               }
               if ( ((Number) parms[9]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[20], 500);
               }
               if ( ((Number) parms[10]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[21], 500);
               }
               return;
            case 1 :
               sIdx = (short)(0) ;
               if ( ((Number) parms[0]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[11], 100);
               }
               if ( ((Number) parms[1]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[12], 100);
               }
               if ( ((Number) parms[2]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[13], 100);
               }
               if ( ((Number) parms[3]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[14], 100);
               }
               if ( ((Number) parms[4]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[15], 100);
               }
               if ( ((Number) parms[5]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[16]).shortValue());
               }
               if ( ((Number) parms[6]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[17]).shortValue());
               }
               if ( ((Number) parms[7]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[18], 100);
               }
               if ( ((Number) parms[8]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[19], 100);
               }
               if ( ((Number) parms[9]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[20], 500);
               }
               if ( ((Number) parms[10]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[21], 500);
               }
               return;
      }
   }

}

