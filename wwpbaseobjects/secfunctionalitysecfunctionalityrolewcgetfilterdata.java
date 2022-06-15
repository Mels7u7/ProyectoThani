package com.projectthani.wwpbaseobjects ;
import com.projectthani.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class secfunctionalitysecfunctionalityrolewcgetfilterdata extends GXProcedure
{
   public secfunctionalitysecfunctionalityrolewcgetfilterdata( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( secfunctionalitysecfunctionalityrolewcgetfilterdata.class ), "" );
   }

   public secfunctionalitysecfunctionalityrolewcgetfilterdata( int remoteHandle ,
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
      secfunctionalitysecfunctionalityrolewcgetfilterdata.this.aP5 = new String[] {""};
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
      secfunctionalitysecfunctionalityrolewcgetfilterdata.this.AV16DDOName = aP0;
      secfunctionalitysecfunctionalityrolewcgetfilterdata.this.AV14SearchTxt = aP1;
      secfunctionalitysecfunctionalityrolewcgetfilterdata.this.AV15SearchTxtTo = aP2;
      secfunctionalitysecfunctionalityrolewcgetfilterdata.this.aP3 = aP3;
      secfunctionalitysecfunctionalityrolewcgetfilterdata.this.aP4 = aP4;
      secfunctionalitysecfunctionalityrolewcgetfilterdata.this.aP5 = aP5;
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
      new com.projectthani.wwpbaseobjects.secisauthbyfunctionalitykey(remoteHandle, context).execute( "WWSecFunctionality", GXv_boolean2) ;
      secfunctionalitysecfunctionalityrolewcgetfilterdata.this.GXt_boolean1 = GXv_boolean2[0] ;
      AV8IsAuthorized = GXt_boolean1 ;
      if ( AV8IsAuthorized )
      {
         GXv_SdtWWPContext3[0] = AV33WWPContext;
         new com.projectthani.wwpbaseobjects.loadwwpcontext(remoteHandle, context).execute( GXv_SdtWWPContext3) ;
         AV33WWPContext = GXv_SdtWWPContext3[0] ;
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
      if ( GXutil.strcmp(AV27Session.getValue("WWPBaseObjects.SecFunctionalitySecFunctionalityRoleWCGridState"), "") == 0 )
      {
         AV29GridState.fromxml(new com.projectthani.wwpbaseobjects.loadgridstate(remoteHandle, context).executeUdp( "WWPBaseObjects.SecFunctionalitySecFunctionalityRoleWCGridState"), null, null);
      }
      else
      {
         AV29GridState.fromxml(AV27Session.getValue("WWPBaseObjects.SecFunctionalitySecFunctionalityRoleWCGridState"), null, null);
      }
      AV37GXV1 = 1 ;
      while ( AV37GXV1 <= AV29GridState.getgxTv_SdtWWPGridState_Filtervalues().size() )
      {
         AV30GridStateFilterValue = (com.projectthani.wwpbaseobjects.SdtWWPGridState_FilterValue)((com.projectthani.wwpbaseobjects.SdtWWPGridState_FilterValue)AV29GridState.getgxTv_SdtWWPGridState_Filtervalues().elementAt(-1+AV37GXV1));
         if ( GXutil.strcmp(AV30GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "FILTERFULLTEXT") == 0 )
         {
            AV34FilterFullText = AV30GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
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
         else if ( GXutil.strcmp(AV30GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "PARM_&SECFUNCTIONALITYID") == 0 )
         {
            AV32SecFunctionalityId = GXutil.lval( AV30GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value()) ;
         }
         AV37GXV1 = (int)(AV37GXV1+1) ;
      }
   }

   public void S121( )
   {
      /* 'LOADSECROLENAMEOPTIONS' Routine */
      returnInSub = false ;
      AV10TFSecRoleName = AV14SearchTxt ;
      AV11TFSecRoleName_Sel = "" ;
      pr_default.dynParam(0, new Object[]{ new Object[]{
                                           AV34FilterFullText ,
                                           AV11TFSecRoleName_Sel ,
                                           AV10TFSecRoleName ,
                                           AV13TFSecRoleDescription_Sel ,
                                           AV12TFSecRoleDescription ,
                                           A13SecRoleName ,
                                           A12SecRoleDescription ,
                                           Long.valueOf(AV32SecFunctionalityId) ,
                                           Long.valueOf(A1SecFunctionalityId) } ,
                                           new int[]{
                                           TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.LONG, TypeConstants.LONG
                                           }
      });
      lV34FilterFullText = GXutil.concat( GXutil.rtrim( AV34FilterFullText), "%", "") ;
      lV34FilterFullText = GXutil.concat( GXutil.rtrim( AV34FilterFullText), "%", "") ;
      lV10TFSecRoleName = GXutil.concat( GXutil.rtrim( AV10TFSecRoleName), "%", "") ;
      lV12TFSecRoleDescription = GXutil.concat( GXutil.rtrim( AV12TFSecRoleDescription), "%", "") ;
      /* Using cursor P001X2 */
      pr_default.execute(0, new Object[] {Long.valueOf(AV32SecFunctionalityId), lV34FilterFullText, lV34FilterFullText, lV10TFSecRoleName, AV11TFSecRoleName_Sel, lV12TFSecRoleDescription, AV13TFSecRoleDescription_Sel});
      while ( (pr_default.getStatus(0) != 101) )
      {
         brk1X2 = false ;
         A4SecRoleId = P001X2_A4SecRoleId[0] ;
         A1SecFunctionalityId = P001X2_A1SecFunctionalityId[0] ;
         A13SecRoleName = P001X2_A13SecRoleName[0] ;
         A12SecRoleDescription = P001X2_A12SecRoleDescription[0] ;
         A13SecRoleName = P001X2_A13SecRoleName[0] ;
         A12SecRoleDescription = P001X2_A12SecRoleDescription[0] ;
         AV26count = 0 ;
         while ( (pr_default.getStatus(0) != 101) && ( P001X2_A1SecFunctionalityId[0] == A1SecFunctionalityId ) && ( GXutil.strcmp(P001X2_A13SecRoleName[0], A13SecRoleName) == 0 ) )
         {
            brk1X2 = false ;
            A4SecRoleId = P001X2_A4SecRoleId[0] ;
            AV26count = (long)(AV26count+1) ;
            brk1X2 = true ;
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
         if ( ! brk1X2 )
         {
            brk1X2 = true ;
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
      pr_default.dynParam(1, new Object[]{ new Object[]{
                                           AV34FilterFullText ,
                                           AV11TFSecRoleName_Sel ,
                                           AV10TFSecRoleName ,
                                           AV13TFSecRoleDescription_Sel ,
                                           AV12TFSecRoleDescription ,
                                           A13SecRoleName ,
                                           A12SecRoleDescription ,
                                           Long.valueOf(AV32SecFunctionalityId) ,
                                           Long.valueOf(A1SecFunctionalityId) } ,
                                           new int[]{
                                           TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.LONG, TypeConstants.LONG
                                           }
      });
      lV34FilterFullText = GXutil.concat( GXutil.rtrim( AV34FilterFullText), "%", "") ;
      lV34FilterFullText = GXutil.concat( GXutil.rtrim( AV34FilterFullText), "%", "") ;
      lV10TFSecRoleName = GXutil.concat( GXutil.rtrim( AV10TFSecRoleName), "%", "") ;
      lV12TFSecRoleDescription = GXutil.concat( GXutil.rtrim( AV12TFSecRoleDescription), "%", "") ;
      /* Using cursor P001X3 */
      pr_default.execute(1, new Object[] {Long.valueOf(AV32SecFunctionalityId), lV34FilterFullText, lV34FilterFullText, lV10TFSecRoleName, AV11TFSecRoleName_Sel, lV12TFSecRoleDescription, AV13TFSecRoleDescription_Sel});
      while ( (pr_default.getStatus(1) != 101) )
      {
         brk1X4 = false ;
         A4SecRoleId = P001X3_A4SecRoleId[0] ;
         A1SecFunctionalityId = P001X3_A1SecFunctionalityId[0] ;
         A12SecRoleDescription = P001X3_A12SecRoleDescription[0] ;
         A13SecRoleName = P001X3_A13SecRoleName[0] ;
         A12SecRoleDescription = P001X3_A12SecRoleDescription[0] ;
         A13SecRoleName = P001X3_A13SecRoleName[0] ;
         AV26count = 0 ;
         while ( (pr_default.getStatus(1) != 101) && ( P001X3_A1SecFunctionalityId[0] == A1SecFunctionalityId ) && ( GXutil.strcmp(P001X3_A12SecRoleDescription[0], A12SecRoleDescription) == 0 ) )
         {
            brk1X4 = false ;
            A4SecRoleId = P001X3_A4SecRoleId[0] ;
            AV26count = (long)(AV26count+1) ;
            brk1X4 = true ;
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
         if ( ! brk1X4 )
         {
            brk1X4 = true ;
            pr_default.readNext(1);
         }
      }
      pr_default.close(1);
   }

   protected void cleanup( )
   {
      this.aP3[0] = secfunctionalitysecfunctionalityrolewcgetfilterdata.this.AV20OptionsJson;
      this.aP4[0] = secfunctionalitysecfunctionalityrolewcgetfilterdata.this.AV23OptionsDescJson;
      this.aP5[0] = secfunctionalitysecfunctionalityrolewcgetfilterdata.this.AV25OptionIndexesJson;
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
      AV33WWPContext = new com.projectthani.wwpbaseobjects.SdtWWPContext(remoteHandle, context);
      GXv_SdtWWPContext3 = new com.projectthani.wwpbaseobjects.SdtWWPContext[1] ;
      AV27Session = httpContext.getWebSession();
      AV29GridState = new com.projectthani.wwpbaseobjects.SdtWWPGridState(remoteHandle, context);
      AV30GridStateFilterValue = new com.projectthani.wwpbaseobjects.SdtWWPGridState_FilterValue(remoteHandle, context);
      AV34FilterFullText = "" ;
      AV10TFSecRoleName = "" ;
      AV11TFSecRoleName_Sel = "" ;
      AV12TFSecRoleDescription = "" ;
      AV13TFSecRoleDescription_Sel = "" ;
      scmdbuf = "" ;
      lV34FilterFullText = "" ;
      lV10TFSecRoleName = "" ;
      lV12TFSecRoleDescription = "" ;
      A13SecRoleName = "" ;
      A12SecRoleDescription = "" ;
      P001X2_A4SecRoleId = new short[1] ;
      P001X2_A1SecFunctionalityId = new long[1] ;
      P001X2_A13SecRoleName = new String[] {""} ;
      P001X2_A12SecRoleDescription = new String[] {""} ;
      AV18Option = "" ;
      P001X3_A4SecRoleId = new short[1] ;
      P001X3_A1SecFunctionalityId = new long[1] ;
      P001X3_A12SecRoleDescription = new String[] {""} ;
      P001X3_A13SecRoleName = new String[] {""} ;
      pr_default = new DataStoreProvider(context, remoteHandle, new com.projectthani.wwpbaseobjects.secfunctionalitysecfunctionalityrolewcgetfilterdata__default(),
         new Object[] {
             new Object[] {
            P001X2_A4SecRoleId, P001X2_A1SecFunctionalityId, P001X2_A13SecRoleName, P001X2_A12SecRoleDescription
            }
            , new Object[] {
            P001X3_A4SecRoleId, P001X3_A1SecFunctionalityId, P001X3_A12SecRoleDescription, P001X3_A13SecRoleName
            }
         }
      );
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private short A4SecRoleId ;
   private short Gx_err ;
   private int AV37GXV1 ;
   private long AV32SecFunctionalityId ;
   private long A1SecFunctionalityId ;
   private long AV26count ;
   private String scmdbuf ;
   private boolean AV8IsAuthorized ;
   private boolean GXt_boolean1 ;
   private boolean GXv_boolean2[] ;
   private boolean returnInSub ;
   private boolean brk1X2 ;
   private boolean brk1X4 ;
   private String AV20OptionsJson ;
   private String AV23OptionsDescJson ;
   private String AV25OptionIndexesJson ;
   private String AV16DDOName ;
   private String AV14SearchTxt ;
   private String AV15SearchTxtTo ;
   private String AV34FilterFullText ;
   private String AV10TFSecRoleName ;
   private String AV11TFSecRoleName_Sel ;
   private String AV12TFSecRoleDescription ;
   private String AV13TFSecRoleDescription_Sel ;
   private String lV34FilterFullText ;
   private String lV10TFSecRoleName ;
   private String lV12TFSecRoleDescription ;
   private String A13SecRoleName ;
   private String A12SecRoleDescription ;
   private String AV18Option ;
   private com.genexus.webpanels.WebSession AV27Session ;
   private String[] aP5 ;
   private String[] aP3 ;
   private String[] aP4 ;
   private IDataStoreProvider pr_default ;
   private short[] P001X2_A4SecRoleId ;
   private long[] P001X2_A1SecFunctionalityId ;
   private String[] P001X2_A13SecRoleName ;
   private String[] P001X2_A12SecRoleDescription ;
   private short[] P001X3_A4SecRoleId ;
   private long[] P001X3_A1SecFunctionalityId ;
   private String[] P001X3_A12SecRoleDescription ;
   private String[] P001X3_A13SecRoleName ;
   private GXSimpleCollection<String> AV19Options ;
   private GXSimpleCollection<String> AV22OptionsDesc ;
   private GXSimpleCollection<String> AV24OptionIndexes ;
   private com.projectthani.wwpbaseobjects.SdtWWPGridState AV29GridState ;
   private com.projectthani.wwpbaseobjects.SdtWWPGridState_FilterValue AV30GridStateFilterValue ;
   private com.projectthani.wwpbaseobjects.SdtWWPContext AV33WWPContext ;
   private com.projectthani.wwpbaseobjects.SdtWWPContext GXv_SdtWWPContext3[] ;
}

final  class secfunctionalitysecfunctionalityrolewcgetfilterdata__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   protected Object[] conditional_P001X2( ModelContext context ,
                                          int remoteHandle ,
                                          com.genexus.IHttpContext httpContext ,
                                          String AV34FilterFullText ,
                                          String AV11TFSecRoleName_Sel ,
                                          String AV10TFSecRoleName ,
                                          String AV13TFSecRoleDescription_Sel ,
                                          String AV12TFSecRoleDescription ,
                                          String A13SecRoleName ,
                                          String A12SecRoleDescription ,
                                          long AV32SecFunctionalityId ,
                                          long A1SecFunctionalityId )
   {
      java.lang.StringBuffer sWhereString = new java.lang.StringBuffer();
      String scmdbuf;
      byte[] GXv_int4 = new byte[7];
      Object[] GXv_Object5 = new Object[2];
      scmdbuf = "SELECT T1.[SecRoleId], T1.[SecFunctionalityId], T2.[SecRoleName], T2.[SecRoleDescription] FROM ([SecFunctionalityRole] T1 INNER JOIN [SecRole] T2 ON T2.[SecRoleId]" ;
      scmdbuf += " = T1.[SecRoleId])" ;
      addWhere(sWhereString, "(T1.[SecFunctionalityId] = ?)");
      if ( ! (GXutil.strcmp("", AV34FilterFullText)==0) )
      {
         addWhere(sWhereString, "(( T2.[SecRoleName] like '%' + ?) or ( T2.[SecRoleDescription] like '%' + ?))");
      }
      else
      {
         GXv_int4[1] = (byte)(1) ;
         GXv_int4[2] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV11TFSecRoleName_Sel)==0) && ( ! (GXutil.strcmp("", AV10TFSecRoleName)==0) ) )
      {
         addWhere(sWhereString, "(T2.[SecRoleName] like ?)");
      }
      else
      {
         GXv_int4[3] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV11TFSecRoleName_Sel)==0) )
      {
         addWhere(sWhereString, "(T2.[SecRoleName] = ?)");
      }
      else
      {
         GXv_int4[4] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV13TFSecRoleDescription_Sel)==0) && ( ! (GXutil.strcmp("", AV12TFSecRoleDescription)==0) ) )
      {
         addWhere(sWhereString, "(T2.[SecRoleDescription] like ?)");
      }
      else
      {
         GXv_int4[5] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV13TFSecRoleDescription_Sel)==0) )
      {
         addWhere(sWhereString, "(T2.[SecRoleDescription] = ?)");
      }
      else
      {
         GXv_int4[6] = (byte)(1) ;
      }
      scmdbuf += sWhereString ;
      scmdbuf += " ORDER BY T1.[SecFunctionalityId], T2.[SecRoleName]" ;
      GXv_Object5[0] = scmdbuf ;
      GXv_Object5[1] = GXv_int4 ;
      return GXv_Object5 ;
   }

   protected Object[] conditional_P001X3( ModelContext context ,
                                          int remoteHandle ,
                                          com.genexus.IHttpContext httpContext ,
                                          String AV34FilterFullText ,
                                          String AV11TFSecRoleName_Sel ,
                                          String AV10TFSecRoleName ,
                                          String AV13TFSecRoleDescription_Sel ,
                                          String AV12TFSecRoleDescription ,
                                          String A13SecRoleName ,
                                          String A12SecRoleDescription ,
                                          long AV32SecFunctionalityId ,
                                          long A1SecFunctionalityId )
   {
      java.lang.StringBuffer sWhereString = new java.lang.StringBuffer();
      String scmdbuf;
      byte[] GXv_int6 = new byte[7];
      Object[] GXv_Object7 = new Object[2];
      scmdbuf = "SELECT T1.[SecRoleId], T1.[SecFunctionalityId], T2.[SecRoleDescription], T2.[SecRoleName] FROM ([SecFunctionalityRole] T1 INNER JOIN [SecRole] T2 ON T2.[SecRoleId]" ;
      scmdbuf += " = T1.[SecRoleId])" ;
      addWhere(sWhereString, "(T1.[SecFunctionalityId] = ?)");
      if ( ! (GXutil.strcmp("", AV34FilterFullText)==0) )
      {
         addWhere(sWhereString, "(( T2.[SecRoleName] like '%' + ?) or ( T2.[SecRoleDescription] like '%' + ?))");
      }
      else
      {
         GXv_int6[1] = (byte)(1) ;
         GXv_int6[2] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV11TFSecRoleName_Sel)==0) && ( ! (GXutil.strcmp("", AV10TFSecRoleName)==0) ) )
      {
         addWhere(sWhereString, "(T2.[SecRoleName] like ?)");
      }
      else
      {
         GXv_int6[3] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV11TFSecRoleName_Sel)==0) )
      {
         addWhere(sWhereString, "(T2.[SecRoleName] = ?)");
      }
      else
      {
         GXv_int6[4] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV13TFSecRoleDescription_Sel)==0) && ( ! (GXutil.strcmp("", AV12TFSecRoleDescription)==0) ) )
      {
         addWhere(sWhereString, "(T2.[SecRoleDescription] like ?)");
      }
      else
      {
         GXv_int6[5] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV13TFSecRoleDescription_Sel)==0) )
      {
         addWhere(sWhereString, "(T2.[SecRoleDescription] = ?)");
      }
      else
      {
         GXv_int6[6] = (byte)(1) ;
      }
      scmdbuf += sWhereString ;
      scmdbuf += " ORDER BY T1.[SecFunctionalityId], T2.[SecRoleDescription]" ;
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
                  return conditional_P001X2(context, remoteHandle, httpContext, (String)dynConstraints[0] , (String)dynConstraints[1] , (String)dynConstraints[2] , (String)dynConstraints[3] , (String)dynConstraints[4] , (String)dynConstraints[5] , (String)dynConstraints[6] , ((Number) dynConstraints[7]).longValue() , ((Number) dynConstraints[8]).longValue() );
            case 1 :
                  return conditional_P001X3(context, remoteHandle, httpContext, (String)dynConstraints[0] , (String)dynConstraints[1] , (String)dynConstraints[2] , (String)dynConstraints[3] , (String)dynConstraints[4] , (String)dynConstraints[5] , (String)dynConstraints[6] , ((Number) dynConstraints[7]).longValue() , ((Number) dynConstraints[8]).longValue() );
      }
      return super.getDynamicStatement(cursor, context, remoteHandle, httpContext, dynConstraints);
   }

   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P001X2", "scmdbuf",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("P001X3", "scmdbuf",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
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
               ((long[]) buf[1])[0] = rslt.getLong(2);
               ((String[]) buf[2])[0] = rslt.getVarchar(3);
               ((String[]) buf[3])[0] = rslt.getVarchar(4);
               return;
            case 1 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               ((long[]) buf[1])[0] = rslt.getLong(2);
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
                  stmt.setLong(sIdx, ((Number) parms[7]).longValue());
               }
               if ( ((Number) parms[1]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[8], 100);
               }
               if ( ((Number) parms[2]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[9], 100);
               }
               if ( ((Number) parms[3]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[10], 40);
               }
               if ( ((Number) parms[4]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[11], 40);
               }
               if ( ((Number) parms[5]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[12], 120);
               }
               if ( ((Number) parms[6]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[13], 120);
               }
               return;
            case 1 :
               sIdx = (short)(0) ;
               if ( ((Number) parms[0]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setLong(sIdx, ((Number) parms[7]).longValue());
               }
               if ( ((Number) parms[1]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[8], 100);
               }
               if ( ((Number) parms[2]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[9], 100);
               }
               if ( ((Number) parms[3]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[10], 40);
               }
               if ( ((Number) parms[4]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[11], 40);
               }
               if ( ((Number) parms[5]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[12], 120);
               }
               if ( ((Number) parms[6]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[13], 120);
               }
               return;
      }
   }

}

