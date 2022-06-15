package com.projectthani.wwpbaseobjects ;
import com.projectthani.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class secrolewwgetfilterdata extends GXProcedure
{
   public secrolewwgetfilterdata( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( secrolewwgetfilterdata.class ), "" );
   }

   public secrolewwgetfilterdata( int remoteHandle ,
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
      secrolewwgetfilterdata.this.aP5 = new String[] {""};
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
      secrolewwgetfilterdata.this.AV16DDOName = aP0;
      secrolewwgetfilterdata.this.AV14SearchTxt = aP1;
      secrolewwgetfilterdata.this.AV15SearchTxtTo = aP2;
      secrolewwgetfilterdata.this.aP3 = aP3;
      secrolewwgetfilterdata.this.aP4 = aP4;
      secrolewwgetfilterdata.this.aP5 = aP5;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      AV19Options = new GXSimpleCollection<String>(String.class, "internal", "") ;
      AV22OptionsDesc = new GXSimpleCollection<String>(String.class, "internal", "") ;
      AV24OptionIndexes = new GXSimpleCollection<String>(String.class, "internal", "") ;
      GXt_boolean1 = AV8IsAuthorized ;
      GXv_boolean2[0] = GXt_boolean1 ;
      new com.projectthani.wwpbaseobjects.secisauthbyfunctionalitykey(remoteHandle, context).execute( "WWSecRole", GXv_boolean2) ;
      secrolewwgetfilterdata.this.GXt_boolean1 = GXv_boolean2[0] ;
      AV8IsAuthorized = GXt_boolean1 ;
      if ( AV8IsAuthorized )
      {
         GXv_SdtWWPContext3[0] = AV46WWPContext;
         new com.projectthani.wwpbaseobjects.loadwwpcontext(remoteHandle, context).execute( GXv_SdtWWPContext3) ;
         AV46WWPContext = GXv_SdtWWPContext3[0] ;
         /* Execute user subroutine: 'LOADGRIDSTATE' */
         S111 ();
         if ( returnInSub )
         {
            returnInSub = true;
            cleanup();
            if (true) return;
         }
         if ( GXutil.strcmp(GXutil.upper( AV16DDOName), "DDO_SECROLENAME") == 0 )
         {
            /* Execute user subroutine: 'LOADSECROLENAMEOPTIONS' */
            S121 ();
            if ( returnInSub )
            {
               returnInSub = true;
               cleanup();
               if (true) return;
            }
         }
         else if ( GXutil.strcmp(GXutil.upper( AV16DDOName), "DDO_SECROLEDESCRIPTION") == 0 )
         {
            /* Execute user subroutine: 'LOADSECROLEDESCRIPTIONOPTIONS' */
            S131 ();
            if ( returnInSub )
            {
               returnInSub = true;
               cleanup();
               if (true) return;
            }
         }
      }
      AV20OptionsJson = AV19Options.toJSonString(false) ;
      AV23OptionsDescJson = AV22OptionsDesc.toJSonString(false) ;
      AV25OptionIndexesJson = AV24OptionIndexes.toJSonString(false) ;
      cleanup();
   }

   public void S111( )
   {
      /* 'LOADGRIDSTATE' Routine */
      returnInSub = false ;
      if ( GXutil.strcmp(AV27Session.getValue("WWPBaseObjects.SecRoleWWGridState"), "") == 0 )
      {
         AV29GridState.fromxml(new com.projectthani.wwpbaseobjects.loadgridstate(remoteHandle, context).executeUdp( "WWPBaseObjects.SecRoleWWGridState"), null, null);
      }
      else
      {
         AV29GridState.fromxml(AV27Session.getValue("WWPBaseObjects.SecRoleWWGridState"), null, null);
      }
      AV50GXV1 = 1 ;
      while ( AV50GXV1 <= AV29GridState.getgxTv_SdtWWPGridState_Filtervalues().size() )
      {
         AV30GridStateFilterValue = (com.projectthani.wwpbaseobjects.SdtWWPGridState_FilterValue)((com.projectthani.wwpbaseobjects.SdtWWPGridState_FilterValue)AV29GridState.getgxTv_SdtWWPGridState_Filtervalues().elementAt(-1+AV50GXV1));
         if ( GXutil.strcmp(AV30GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "FILTERFULLTEXT") == 0 )
         {
            AV47FilterFullText = AV30GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV30GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFSECROLENAME") == 0 )
         {
            AV10TFSecRoleName = AV30GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV30GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFSECROLENAME_SEL") == 0 )
         {
            AV11TFSecRoleName_Sel = AV30GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV30GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFSECROLEDESCRIPTION") == 0 )
         {
            AV12TFSecRoleDescription = AV30GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV30GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFSECROLEDESCRIPTION_SEL") == 0 )
         {
            AV13TFSecRoleDescription_Sel = AV30GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         AV50GXV1 = (int)(AV50GXV1+1) ;
      }
   }

   public void S121( )
   {
      /* 'LOADSECROLENAMEOPTIONS' Routine */
      returnInSub = false ;
      AV10TFSecRoleName = AV14SearchTxt ;
      AV11TFSecRoleName_Sel = "" ;
      AV52Wwpbaseobjects_secrolewwds_1_filterfulltext = AV47FilterFullText ;
      AV53Wwpbaseobjects_secrolewwds_2_tfsecrolename = AV10TFSecRoleName ;
      AV54Wwpbaseobjects_secrolewwds_3_tfsecrolename_sel = AV11TFSecRoleName_Sel ;
      AV55Wwpbaseobjects_secrolewwds_4_tfsecroledescription = AV12TFSecRoleDescription ;
      AV56Wwpbaseobjects_secrolewwds_5_tfsecroledescription_sel = AV13TFSecRoleDescription_Sel ;
      pr_default.dynParam(0, new Object[]{ new Object[]{
                                           AV52Wwpbaseobjects_secrolewwds_1_filterfulltext ,
                                           AV54Wwpbaseobjects_secrolewwds_3_tfsecrolename_sel ,
                                           AV53Wwpbaseobjects_secrolewwds_2_tfsecrolename ,
                                           AV56Wwpbaseobjects_secrolewwds_5_tfsecroledescription_sel ,
                                           AV55Wwpbaseobjects_secrolewwds_4_tfsecroledescription ,
                                           A13SecRoleName ,
                                           A12SecRoleDescription } ,
                                           new int[]{
                                           TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING
                                           }
      });
      lV52Wwpbaseobjects_secrolewwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV52Wwpbaseobjects_secrolewwds_1_filterfulltext), "%", "") ;
      lV52Wwpbaseobjects_secrolewwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV52Wwpbaseobjects_secrolewwds_1_filterfulltext), "%", "") ;
      lV53Wwpbaseobjects_secrolewwds_2_tfsecrolename = GXutil.concat( GXutil.rtrim( AV53Wwpbaseobjects_secrolewwds_2_tfsecrolename), "%", "") ;
      lV55Wwpbaseobjects_secrolewwds_4_tfsecroledescription = GXutil.concat( GXutil.rtrim( AV55Wwpbaseobjects_secrolewwds_4_tfsecroledescription), "%", "") ;
      /* Using cursor P00272 */
      pr_default.execute(0, new Object[] {lV52Wwpbaseobjects_secrolewwds_1_filterfulltext, lV52Wwpbaseobjects_secrolewwds_1_filterfulltext, lV53Wwpbaseobjects_secrolewwds_2_tfsecrolename, AV54Wwpbaseobjects_secrolewwds_3_tfsecrolename_sel, lV55Wwpbaseobjects_secrolewwds_4_tfsecroledescription, AV56Wwpbaseobjects_secrolewwds_5_tfsecroledescription_sel});
      while ( (pr_default.getStatus(0) != 101) )
      {
         brk272 = false ;
         A13SecRoleName = P00272_A13SecRoleName[0] ;
         A12SecRoleDescription = P00272_A12SecRoleDescription[0] ;
         A4SecRoleId = P00272_A4SecRoleId[0] ;
         AV26count = 0 ;
         while ( (pr_default.getStatus(0) != 101) && ( GXutil.strcmp(P00272_A13SecRoleName[0], A13SecRoleName) == 0 ) )
         {
            brk272 = false ;
            A4SecRoleId = P00272_A4SecRoleId[0] ;
            AV26count = (long)(AV26count+1) ;
            brk272 = true ;
            pr_default.readNext(0);
         }
         if ( ! (GXutil.strcmp("", A13SecRoleName)==0) )
         {
            AV18Option = A13SecRoleName ;
            AV19Options.add(AV18Option, 0);
            AV24OptionIndexes.add(GXutil.trim( localUtil.format( DecimalUtil.doubleToDec(AV26count), "Z,ZZZ,ZZZ,ZZ9")), 0);
         }
         if ( AV19Options.size() == 50 )
         {
            /* Exit For each command. Update data (if necessary), close cursors & exit. */
            if (true) break;
         }
         if ( ! brk272 )
         {
            brk272 = true ;
            pr_default.readNext(0);
         }
      }
      pr_default.close(0);
   }

   public void S131( )
   {
      /* 'LOADSECROLEDESCRIPTIONOPTIONS' Routine */
      returnInSub = false ;
      AV12TFSecRoleDescription = AV14SearchTxt ;
      AV13TFSecRoleDescription_Sel = "" ;
      AV52Wwpbaseobjects_secrolewwds_1_filterfulltext = AV47FilterFullText ;
      AV53Wwpbaseobjects_secrolewwds_2_tfsecrolename = AV10TFSecRoleName ;
      AV54Wwpbaseobjects_secrolewwds_3_tfsecrolename_sel = AV11TFSecRoleName_Sel ;
      AV55Wwpbaseobjects_secrolewwds_4_tfsecroledescription = AV12TFSecRoleDescription ;
      AV56Wwpbaseobjects_secrolewwds_5_tfsecroledescription_sel = AV13TFSecRoleDescription_Sel ;
      pr_default.dynParam(1, new Object[]{ new Object[]{
                                           AV52Wwpbaseobjects_secrolewwds_1_filterfulltext ,
                                           AV54Wwpbaseobjects_secrolewwds_3_tfsecrolename_sel ,
                                           AV53Wwpbaseobjects_secrolewwds_2_tfsecrolename ,
                                           AV56Wwpbaseobjects_secrolewwds_5_tfsecroledescription_sel ,
                                           AV55Wwpbaseobjects_secrolewwds_4_tfsecroledescription ,
                                           A13SecRoleName ,
                                           A12SecRoleDescription } ,
                                           new int[]{
                                           TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING
                                           }
      });
      lV52Wwpbaseobjects_secrolewwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV52Wwpbaseobjects_secrolewwds_1_filterfulltext), "%", "") ;
      lV52Wwpbaseobjects_secrolewwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV52Wwpbaseobjects_secrolewwds_1_filterfulltext), "%", "") ;
      lV53Wwpbaseobjects_secrolewwds_2_tfsecrolename = GXutil.concat( GXutil.rtrim( AV53Wwpbaseobjects_secrolewwds_2_tfsecrolename), "%", "") ;
      lV55Wwpbaseobjects_secrolewwds_4_tfsecroledescription = GXutil.concat( GXutil.rtrim( AV55Wwpbaseobjects_secrolewwds_4_tfsecroledescription), "%", "") ;
      /* Using cursor P00273 */
      pr_default.execute(1, new Object[] {lV52Wwpbaseobjects_secrolewwds_1_filterfulltext, lV52Wwpbaseobjects_secrolewwds_1_filterfulltext, lV53Wwpbaseobjects_secrolewwds_2_tfsecrolename, AV54Wwpbaseobjects_secrolewwds_3_tfsecrolename_sel, lV55Wwpbaseobjects_secrolewwds_4_tfsecroledescription, AV56Wwpbaseobjects_secrolewwds_5_tfsecroledescription_sel});
      while ( (pr_default.getStatus(1) != 101) )
      {
         brk274 = false ;
         A12SecRoleDescription = P00273_A12SecRoleDescription[0] ;
         A13SecRoleName = P00273_A13SecRoleName[0] ;
         A4SecRoleId = P00273_A4SecRoleId[0] ;
         AV26count = 0 ;
         while ( (pr_default.getStatus(1) != 101) && ( GXutil.strcmp(P00273_A12SecRoleDescription[0], A12SecRoleDescription) == 0 ) )
         {
            brk274 = false ;
            A4SecRoleId = P00273_A4SecRoleId[0] ;
            AV26count = (long)(AV26count+1) ;
            brk274 = true ;
            pr_default.readNext(1);
         }
         if ( ! (GXutil.strcmp("", A12SecRoleDescription)==0) )
         {
            AV18Option = A12SecRoleDescription ;
            AV19Options.add(AV18Option, 0);
            AV24OptionIndexes.add(GXutil.trim( localUtil.format( DecimalUtil.doubleToDec(AV26count), "Z,ZZZ,ZZZ,ZZ9")), 0);
         }
         if ( AV19Options.size() == 50 )
         {
            /* Exit For each command. Update data (if necessary), close cursors & exit. */
            if (true) break;
         }
         if ( ! brk274 )
         {
            brk274 = true ;
            pr_default.readNext(1);
         }
      }
      pr_default.close(1);
   }

   protected void cleanup( )
   {
      this.aP3[0] = secrolewwgetfilterdata.this.AV20OptionsJson;
      this.aP4[0] = secrolewwgetfilterdata.this.AV23OptionsDescJson;
      this.aP5[0] = secrolewwgetfilterdata.this.AV25OptionIndexesJson;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV20OptionsJson = "" ;
      AV23OptionsDescJson = "" ;
      AV25OptionIndexesJson = "" ;
      AV19Options = new GXSimpleCollection<String>(String.class, "internal", "");
      AV22OptionsDesc = new GXSimpleCollection<String>(String.class, "internal", "");
      AV24OptionIndexes = new GXSimpleCollection<String>(String.class, "internal", "");
      GXv_boolean2 = new boolean[1] ;
      AV46WWPContext = new com.projectthani.wwpbaseobjects.SdtWWPContext(remoteHandle, context);
      GXv_SdtWWPContext3 = new com.projectthani.wwpbaseobjects.SdtWWPContext[1] ;
      AV27Session = httpContext.getWebSession();
      AV29GridState = new com.projectthani.wwpbaseobjects.SdtWWPGridState(remoteHandle, context);
      AV30GridStateFilterValue = new com.projectthani.wwpbaseobjects.SdtWWPGridState_FilterValue(remoteHandle, context);
      AV47FilterFullText = "" ;
      AV10TFSecRoleName = "" ;
      AV11TFSecRoleName_Sel = "" ;
      AV12TFSecRoleDescription = "" ;
      AV13TFSecRoleDescription_Sel = "" ;
      A13SecRoleName = "" ;
      AV52Wwpbaseobjects_secrolewwds_1_filterfulltext = "" ;
      AV53Wwpbaseobjects_secrolewwds_2_tfsecrolename = "" ;
      AV54Wwpbaseobjects_secrolewwds_3_tfsecrolename_sel = "" ;
      AV55Wwpbaseobjects_secrolewwds_4_tfsecroledescription = "" ;
      AV56Wwpbaseobjects_secrolewwds_5_tfsecroledescription_sel = "" ;
      scmdbuf = "" ;
      lV52Wwpbaseobjects_secrolewwds_1_filterfulltext = "" ;
      lV53Wwpbaseobjects_secrolewwds_2_tfsecrolename = "" ;
      lV55Wwpbaseobjects_secrolewwds_4_tfsecroledescription = "" ;
      A12SecRoleDescription = "" ;
      P00272_A13SecRoleName = new String[] {""} ;
      P00272_A12SecRoleDescription = new String[] {""} ;
      P00272_A4SecRoleId = new short[1] ;
      AV18Option = "" ;
      P00273_A12SecRoleDescription = new String[] {""} ;
      P00273_A13SecRoleName = new String[] {""} ;
      P00273_A4SecRoleId = new short[1] ;
      pr_default = new DataStoreProvider(context, remoteHandle, new com.projectthani.wwpbaseobjects.secrolewwgetfilterdata__default(),
         new Object[] {
             new Object[] {
            P00272_A13SecRoleName, P00272_A12SecRoleDescription, P00272_A4SecRoleId
            }
            , new Object[] {
            P00273_A12SecRoleDescription, P00273_A13SecRoleName, P00273_A4SecRoleId
            }
         }
      );
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private short A4SecRoleId ;
   private short Gx_err ;
   private int AV50GXV1 ;
   private long AV26count ;
   private String scmdbuf ;
   private boolean AV8IsAuthorized ;
   private boolean GXt_boolean1 ;
   private boolean GXv_boolean2[] ;
   private boolean returnInSub ;
   private boolean brk272 ;
   private boolean brk274 ;
   private String AV20OptionsJson ;
   private String AV23OptionsDescJson ;
   private String AV25OptionIndexesJson ;
   private String AV16DDOName ;
   private String AV14SearchTxt ;
   private String AV15SearchTxtTo ;
   private String AV47FilterFullText ;
   private String AV10TFSecRoleName ;
   private String AV11TFSecRoleName_Sel ;
   private String AV12TFSecRoleDescription ;
   private String AV13TFSecRoleDescription_Sel ;
   private String A13SecRoleName ;
   private String AV52Wwpbaseobjects_secrolewwds_1_filterfulltext ;
   private String AV53Wwpbaseobjects_secrolewwds_2_tfsecrolename ;
   private String AV54Wwpbaseobjects_secrolewwds_3_tfsecrolename_sel ;
   private String AV55Wwpbaseobjects_secrolewwds_4_tfsecroledescription ;
   private String AV56Wwpbaseobjects_secrolewwds_5_tfsecroledescription_sel ;
   private String lV52Wwpbaseobjects_secrolewwds_1_filterfulltext ;
   private String lV53Wwpbaseobjects_secrolewwds_2_tfsecrolename ;
   private String lV55Wwpbaseobjects_secrolewwds_4_tfsecroledescription ;
   private String A12SecRoleDescription ;
   private String AV18Option ;
   private com.genexus.webpanels.WebSession AV27Session ;
   private String[] aP5 ;
   private String[] aP3 ;
   private String[] aP4 ;
   private IDataStoreProvider pr_default ;
   private String[] P00272_A13SecRoleName ;
   private String[] P00272_A12SecRoleDescription ;
   private short[] P00272_A4SecRoleId ;
   private String[] P00273_A12SecRoleDescription ;
   private String[] P00273_A13SecRoleName ;
   private short[] P00273_A4SecRoleId ;
   private GXSimpleCollection<String> AV19Options ;
   private GXSimpleCollection<String> AV22OptionsDesc ;
   private GXSimpleCollection<String> AV24OptionIndexes ;
   private com.projectthani.wwpbaseobjects.SdtWWPGridState AV29GridState ;
   private com.projectthani.wwpbaseobjects.SdtWWPGridState_FilterValue AV30GridStateFilterValue ;
   private com.projectthani.wwpbaseobjects.SdtWWPContext AV46WWPContext ;
   private com.projectthani.wwpbaseobjects.SdtWWPContext GXv_SdtWWPContext3[] ;
}

final  class secrolewwgetfilterdata__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   protected Object[] conditional_P00272( ModelContext context ,
                                          int remoteHandle ,
                                          com.genexus.IHttpContext httpContext ,
                                          String AV52Wwpbaseobjects_secrolewwds_1_filterfulltext ,
                                          String AV54Wwpbaseobjects_secrolewwds_3_tfsecrolename_sel ,
                                          String AV53Wwpbaseobjects_secrolewwds_2_tfsecrolename ,
                                          String AV56Wwpbaseobjects_secrolewwds_5_tfsecroledescription_sel ,
                                          String AV55Wwpbaseobjects_secrolewwds_4_tfsecroledescription ,
                                          String A13SecRoleName ,
                                          String A12SecRoleDescription )
   {
      java.lang.StringBuffer sWhereString = new java.lang.StringBuffer();
      String scmdbuf;
      byte[] GXv_int4 = new byte[6];
      Object[] GXv_Object5 = new Object[2];
      scmdbuf = "SELECT [SecRoleName], [SecRoleDescription], [SecRoleId] FROM [SecRole]" ;
      if ( ! (GXutil.strcmp("", AV52Wwpbaseobjects_secrolewwds_1_filterfulltext)==0) )
      {
         addWhere(sWhereString, "(( [SecRoleName] like '%' + ?) or ( [SecRoleDescription] like '%' + ?))");
      }
      else
      {
         GXv_int4[0] = (byte)(1) ;
         GXv_int4[1] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV54Wwpbaseobjects_secrolewwds_3_tfsecrolename_sel)==0) && ( ! (GXutil.strcmp("", AV53Wwpbaseobjects_secrolewwds_2_tfsecrolename)==0) ) )
      {
         addWhere(sWhereString, "([SecRoleName] like ?)");
      }
      else
      {
         GXv_int4[2] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV54Wwpbaseobjects_secrolewwds_3_tfsecrolename_sel)==0) )
      {
         addWhere(sWhereString, "([SecRoleName] = ?)");
      }
      else
      {
         GXv_int4[3] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV56Wwpbaseobjects_secrolewwds_5_tfsecroledescription_sel)==0) && ( ! (GXutil.strcmp("", AV55Wwpbaseobjects_secrolewwds_4_tfsecroledescription)==0) ) )
      {
         addWhere(sWhereString, "([SecRoleDescription] like ?)");
      }
      else
      {
         GXv_int4[4] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV56Wwpbaseobjects_secrolewwds_5_tfsecroledescription_sel)==0) )
      {
         addWhere(sWhereString, "([SecRoleDescription] = ?)");
      }
      else
      {
         GXv_int4[5] = (byte)(1) ;
      }
      scmdbuf += sWhereString ;
      scmdbuf += " ORDER BY [SecRoleName]" ;
      GXv_Object5[0] = scmdbuf ;
      GXv_Object5[1] = GXv_int4 ;
      return GXv_Object5 ;
   }

   protected Object[] conditional_P00273( ModelContext context ,
                                          int remoteHandle ,
                                          com.genexus.IHttpContext httpContext ,
                                          String AV52Wwpbaseobjects_secrolewwds_1_filterfulltext ,
                                          String AV54Wwpbaseobjects_secrolewwds_3_tfsecrolename_sel ,
                                          String AV53Wwpbaseobjects_secrolewwds_2_tfsecrolename ,
                                          String AV56Wwpbaseobjects_secrolewwds_5_tfsecroledescription_sel ,
                                          String AV55Wwpbaseobjects_secrolewwds_4_tfsecroledescription ,
                                          String A13SecRoleName ,
                                          String A12SecRoleDescription )
   {
      java.lang.StringBuffer sWhereString = new java.lang.StringBuffer();
      String scmdbuf;
      byte[] GXv_int6 = new byte[6];
      Object[] GXv_Object7 = new Object[2];
      scmdbuf = "SELECT [SecRoleDescription], [SecRoleName], [SecRoleId] FROM [SecRole]" ;
      if ( ! (GXutil.strcmp("", AV52Wwpbaseobjects_secrolewwds_1_filterfulltext)==0) )
      {
         addWhere(sWhereString, "(( [SecRoleName] like '%' + ?) or ( [SecRoleDescription] like '%' + ?))");
      }
      else
      {
         GXv_int6[0] = (byte)(1) ;
         GXv_int6[1] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV54Wwpbaseobjects_secrolewwds_3_tfsecrolename_sel)==0) && ( ! (GXutil.strcmp("", AV53Wwpbaseobjects_secrolewwds_2_tfsecrolename)==0) ) )
      {
         addWhere(sWhereString, "([SecRoleName] like ?)");
      }
      else
      {
         GXv_int6[2] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV54Wwpbaseobjects_secrolewwds_3_tfsecrolename_sel)==0) )
      {
         addWhere(sWhereString, "([SecRoleName] = ?)");
      }
      else
      {
         GXv_int6[3] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV56Wwpbaseobjects_secrolewwds_5_tfsecroledescription_sel)==0) && ( ! (GXutil.strcmp("", AV55Wwpbaseobjects_secrolewwds_4_tfsecroledescription)==0) ) )
      {
         addWhere(sWhereString, "([SecRoleDescription] like ?)");
      }
      else
      {
         GXv_int6[4] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV56Wwpbaseobjects_secrolewwds_5_tfsecroledescription_sel)==0) )
      {
         addWhere(sWhereString, "([SecRoleDescription] = ?)");
      }
      else
      {
         GXv_int6[5] = (byte)(1) ;
      }
      scmdbuf += sWhereString ;
      scmdbuf += " ORDER BY [SecRoleDescription]" ;
      GXv_Object7[0] = scmdbuf ;
      GXv_Object7[1] = GXv_int6 ;
      return GXv_Object7 ;
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
                  return conditional_P00272(context, remoteHandle, httpContext, (String)dynConstraints[0] , (String)dynConstraints[1] , (String)dynConstraints[2] , (String)dynConstraints[3] , (String)dynConstraints[4] , (String)dynConstraints[5] , (String)dynConstraints[6] );
            case 1 :
                  return conditional_P00273(context, remoteHandle, httpContext, (String)dynConstraints[0] , (String)dynConstraints[1] , (String)dynConstraints[2] , (String)dynConstraints[3] , (String)dynConstraints[4] , (String)dynConstraints[5] , (String)dynConstraints[6] );
      }
      return super.getDynamicStatement(cursor, context, remoteHandle, httpContext, dynConstraints);
   }

   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P00272", "scmdbuf",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("P00273", "scmdbuf",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
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
               ((String[]) buf[1])[0] = rslt.getVarchar(2);
               ((short[]) buf[2])[0] = rslt.getShort(3);
               return;
            case 1 :
               ((String[]) buf[0])[0] = rslt.getVarchar(1);
               ((String[]) buf[1])[0] = rslt.getVarchar(2);
               ((short[]) buf[2])[0] = rslt.getShort(3);
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
                  stmt.setVarchar(sIdx, (String)parms[6], 100);
               }
               if ( ((Number) parms[1]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[7], 100);
               }
               if ( ((Number) parms[2]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[8], 40);
               }
               if ( ((Number) parms[3]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[9], 40);
               }
               if ( ((Number) parms[4]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[10], 120);
               }
               if ( ((Number) parms[5]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[11], 120);
               }
               return;
            case 1 :
               sIdx = (short)(0) ;
               if ( ((Number) parms[0]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[6], 100);
               }
               if ( ((Number) parms[1]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[7], 100);
               }
               if ( ((Number) parms[2]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[8], 40);
               }
               if ( ((Number) parms[3]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[9], 40);
               }
               if ( ((Number) parms[4]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[10], 120);
               }
               if ( ((Number) parms[5]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[11], 120);
               }
               return;
      }
   }

}

