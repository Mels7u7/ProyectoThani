package com.projectthani ;
import com.projectthani.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class sedeloaddvcombo extends GXProcedure
{
   public sedeloaddvcombo( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( sedeloaddvcombo.class ), "" );
   }

   public sedeloaddvcombo( int remoteHandle ,
                           ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public String executeUdp( String aP0 ,
                             String aP1 ,
                             boolean aP2 ,
                             short aP3 ,
                             String aP4 ,
                             String[] aP5 ,
                             String[] aP6 )
   {
      sedeloaddvcombo.this.aP7 = new String[] {""};
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5, aP6, aP7);
      return aP7[0];
   }

   public void execute( String aP0 ,
                        String aP1 ,
                        boolean aP2 ,
                        short aP3 ,
                        String aP4 ,
                        String[] aP5 ,
                        String[] aP6 ,
                        String[] aP7 )
   {
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5, aP6, aP7);
   }

   private void execute_int( String aP0 ,
                             String aP1 ,
                             boolean aP2 ,
                             short aP3 ,
                             String aP4 ,
                             String[] aP5 ,
                             String[] aP6 ,
                             String[] aP7 )
   {
      sedeloaddvcombo.this.AV17ComboName = aP0;
      sedeloaddvcombo.this.AV19TrnMode = aP1;
      sedeloaddvcombo.this.AV21IsDynamicCall = aP2;
      sedeloaddvcombo.this.AV26SedeId = aP3;
      sedeloaddvcombo.this.AV12SearchTxt = aP4;
      sedeloaddvcombo.this.aP5 = aP5;
      sedeloaddvcombo.this.aP6 = aP6;
      sedeloaddvcombo.this.aP7 = aP7;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      GXt_boolean1 = AV8IsAuthorized ;
      GXv_boolean2[0] = GXt_boolean1 ;
      new com.projectthani.wwpbaseobjects.secisauthbyfunctionalitykey(remoteHandle, context).execute( "WWSede", GXv_boolean2) ;
      sedeloaddvcombo.this.GXt_boolean1 = GXv_boolean2[0] ;
      AV8IsAuthorized = GXt_boolean1 ;
      if ( AV8IsAuthorized )
      {
         GXv_SdtWWPContext3[0] = AV9WWPContext;
         new com.projectthani.wwpbaseobjects.loadwwpcontext(remoteHandle, context).execute( GXv_SdtWWPContext3) ;
         AV9WWPContext = GXv_SdtWWPContext3[0] ;
         AV11MaxItems = 100 ;
         if ( GXutil.strcmp(AV17ComboName, "ClinicaId") == 0 )
         {
            /* Execute user subroutine: 'LOADCOMBOITEMS_CLINICAID' */
            S111 ();
            if ( returnInSub )
            {
               returnInSub = true;
               cleanup();
               if (true) return;
            }
         }
         else if ( GXutil.strcmp(AV17ComboName, "UbigeoCode") == 0 )
         {
            /* Execute user subroutine: 'LOADCOMBOITEMS_UBIGEOCODE' */
            S121 ();
            if ( returnInSub )
            {
               returnInSub = true;
               cleanup();
               if (true) return;
            }
         }
      }
      cleanup();
   }

   public void S111( )
   {
      /* 'LOADCOMBOITEMS_CLINICAID' Routine */
      returnInSub = false ;
      if ( AV21IsDynamicCall )
      {
         pr_default.dynParam(0, new Object[]{ new Object[]{
                                              AV12SearchTxt ,
                                              Long.valueOf(A118ClinicaRUC) } ,
                                              new int[]{
                                              TypeConstants.STRING, TypeConstants.LONG
                                              }
         });
         lV12SearchTxt = GXutil.concat( GXutil.rtrim( AV12SearchTxt), "%", "") ;
         /* Using cursor P003K2 */
         pr_default.execute(0, new Object[] {lV12SearchTxt});
         while ( (pr_default.getStatus(0) != 101) )
         {
            A118ClinicaRUC = P003K2_A118ClinicaRUC[0] ;
            A28ClinicaId = P003K2_A28ClinicaId[0] ;
            AV15Combo_DataItem = (com.projectthani.wwpbaseobjects.SdtDVB_SDTComboData_Item)new com.projectthani.wwpbaseobjects.SdtDVB_SDTComboData_Item(remoteHandle, context);
            AV15Combo_DataItem.setgxTv_SdtDVB_SDTComboData_Item_Id( GXutil.trim( GXutil.str( A28ClinicaId, 4, 0)) );
            AV15Combo_DataItem.setgxTv_SdtDVB_SDTComboData_Item_Title( GXutil.trim( localUtil.format( DecimalUtil.doubleToDec(A118ClinicaRUC), "ZZZZZZZZZZ9")) );
            AV14Combo_Data.add(AV15Combo_DataItem, 0);
            if ( AV14Combo_Data.size() > AV11MaxItems )
            {
               /* Exit For each command. Update data (if necessary), close cursors & exit. */
               if (true) break;
            }
            pr_default.readNext(0);
         }
         pr_default.close(0);
         AV13Combo_DataJson = AV14Combo_Data.toJSonString(false) ;
      }
      else
      {
         if ( GXutil.strcmp(AV19TrnMode, "INS") != 0 )
         {
            if ( GXutil.strcmp(AV19TrnMode, "GET") != 0 )
            {
               /* Using cursor P003K3 */
               pr_default.execute(1, new Object[] {Short.valueOf(AV26SedeId)});
               while ( (pr_default.getStatus(1) != 101) )
               {
                  A30SedeId = P003K3_A30SedeId[0] ;
                  A28ClinicaId = P003K3_A28ClinicaId[0] ;
                  A118ClinicaRUC = P003K3_A118ClinicaRUC[0] ;
                  A118ClinicaRUC = P003K3_A118ClinicaRUC[0] ;
                  AV16SelectedValue = ((0==A28ClinicaId) ? "" : GXutil.trim( GXutil.str( A28ClinicaId, 4, 0))) ;
                  AV22SelectedText = ((0==A118ClinicaRUC) ? "" : GXutil.trim( localUtil.format( DecimalUtil.doubleToDec(A118ClinicaRUC), "ZZZZZZZZZZ9"))) ;
                  /* Exiting from a For First loop. */
                  if (true) break;
               }
               pr_default.close(1);
            }
            else
            {
               AV24ClinicaId = (short)(GXutil.lval( AV12SearchTxt)) ;
               /* Using cursor P003K4 */
               pr_default.execute(2, new Object[] {Short.valueOf(AV24ClinicaId)});
               while ( (pr_default.getStatus(2) != 101) )
               {
                  A28ClinicaId = P003K4_A28ClinicaId[0] ;
                  A118ClinicaRUC = P003K4_A118ClinicaRUC[0] ;
                  AV22SelectedText = GXutil.trim( localUtil.format( DecimalUtil.doubleToDec(A118ClinicaRUC), "ZZZZZZZZZZ9")) ;
                  /* Exit For each command. Update data (if necessary), close cursors & exit. */
                  if (true) break;
                  /* Exiting from a For First loop. */
                  if (true) break;
               }
               pr_default.close(2);
            }
         }
      }
   }

   public void S121( )
   {
      /* 'LOADCOMBOITEMS_UBIGEOCODE' Routine */
      returnInSub = false ;
      if ( AV21IsDynamicCall )
      {
         pr_default.dynParam(3, new Object[]{ new Object[]{
                                              AV12SearchTxt ,
                                              A186UbigeoDepartamento ,
                                              A187UbigeoProvincia ,
                                              A188UbigeoDistrito } ,
                                              new int[]{
                                              TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING
                                              }
         });
         lV12SearchTxt = GXutil.concat( GXutil.rtrim( AV12SearchTxt), "%", "") ;
         /* Using cursor P003K5 */
         pr_default.execute(3, new Object[] {lV12SearchTxt});
         while ( (pr_default.getStatus(3) != 101) )
         {
            A185UbigeoNombre = P003K5_A185UbigeoNombre[0] ;
            A44UbigeoCode = P003K5_A44UbigeoCode[0] ;
            A186UbigeoDepartamento = P003K5_A186UbigeoDepartamento[0] ;
            A187UbigeoProvincia = P003K5_A187UbigeoProvincia[0] ;
            A188UbigeoDistrito = P003K5_A188UbigeoDistrito[0] ;
            AV15Combo_DataItem = (com.projectthani.wwpbaseobjects.SdtDVB_SDTComboData_Item)new com.projectthani.wwpbaseobjects.SdtDVB_SDTComboData_Item(remoteHandle, context);
            AV15Combo_DataItem.setgxTv_SdtDVB_SDTComboData_Item_Id( A44UbigeoCode );
            AV15Combo_DataItem.setgxTv_SdtDVB_SDTComboData_Item_Title( A185UbigeoNombre );
            AV14Combo_Data.add(AV15Combo_DataItem, 0);
            if ( AV14Combo_Data.size() > AV11MaxItems )
            {
               /* Exit For each command. Update data (if necessary), close cursors & exit. */
               if (true) break;
            }
            pr_default.readNext(3);
         }
         pr_default.close(3);
         AV13Combo_DataJson = AV14Combo_Data.toJSonString(false) ;
      }
      else
      {
         if ( GXutil.strcmp(AV19TrnMode, "INS") != 0 )
         {
            if ( GXutil.strcmp(AV19TrnMode, "GET") != 0 )
            {
               /* Using cursor P003K6 */
               pr_default.execute(4, new Object[] {Short.valueOf(AV26SedeId)});
               while ( (pr_default.getStatus(4) != 101) )
               {
                  A30SedeId = P003K6_A30SedeId[0] ;
                  A44UbigeoCode = P003K6_A44UbigeoCode[0] ;
                  A188UbigeoDistrito = P003K6_A188UbigeoDistrito[0] ;
                  A187UbigeoProvincia = P003K6_A187UbigeoProvincia[0] ;
                  A186UbigeoDepartamento = P003K6_A186UbigeoDepartamento[0] ;
                  A188UbigeoDistrito = P003K6_A188UbigeoDistrito[0] ;
                  A187UbigeoProvincia = P003K6_A187UbigeoProvincia[0] ;
                  A186UbigeoDepartamento = P003K6_A186UbigeoDepartamento[0] ;
                  A185UbigeoNombre = A186UbigeoDepartamento + " / " + A187UbigeoProvincia + " / " + A188UbigeoDistrito ;
                  AV16SelectedValue = A44UbigeoCode ;
                  AV22SelectedText = A185UbigeoNombre ;
                  /* Exiting from a For First loop. */
                  if (true) break;
               }
               pr_default.close(4);
            }
            else
            {
               AV25UbigeoCode = AV12SearchTxt ;
               /* Using cursor P003K7 */
               pr_default.execute(5, new Object[] {AV25UbigeoCode});
               while ( (pr_default.getStatus(5) != 101) )
               {
                  A44UbigeoCode = P003K7_A44UbigeoCode[0] ;
                  A188UbigeoDistrito = P003K7_A188UbigeoDistrito[0] ;
                  A187UbigeoProvincia = P003K7_A187UbigeoProvincia[0] ;
                  A186UbigeoDepartamento = P003K7_A186UbigeoDepartamento[0] ;
                  A185UbigeoNombre = A186UbigeoDepartamento + " / " + A187UbigeoProvincia + " / " + A188UbigeoDistrito ;
                  AV22SelectedText = A185UbigeoNombre ;
                  /* Exit For each command. Update data (if necessary), close cursors & exit. */
                  if (true) break;
                  /* Exiting from a For First loop. */
                  if (true) break;
               }
               pr_default.close(5);
            }
         }
      }
   }

   protected void cleanup( )
   {
      this.aP5[0] = sedeloaddvcombo.this.AV16SelectedValue;
      this.aP6[0] = sedeloaddvcombo.this.AV22SelectedText;
      this.aP7[0] = sedeloaddvcombo.this.AV13Combo_DataJson;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV16SelectedValue = "" ;
      AV22SelectedText = "" ;
      AV13Combo_DataJson = "" ;
      GXv_boolean2 = new boolean[1] ;
      AV9WWPContext = new com.projectthani.wwpbaseobjects.SdtWWPContext(remoteHandle, context);
      GXv_SdtWWPContext3 = new com.projectthani.wwpbaseobjects.SdtWWPContext[1] ;
      scmdbuf = "" ;
      lV12SearchTxt = "" ;
      P003K2_A118ClinicaRUC = new long[1] ;
      P003K2_A28ClinicaId = new short[1] ;
      AV15Combo_DataItem = new com.projectthani.wwpbaseobjects.SdtDVB_SDTComboData_Item(remoteHandle, context);
      AV14Combo_Data = new GXBaseCollection<com.projectthani.wwpbaseobjects.SdtDVB_SDTComboData_Item>(com.projectthani.wwpbaseobjects.SdtDVB_SDTComboData_Item.class, "Item", "", remoteHandle);
      P003K3_A30SedeId = new short[1] ;
      P003K3_A28ClinicaId = new short[1] ;
      P003K3_A118ClinicaRUC = new long[1] ;
      P003K4_A28ClinicaId = new short[1] ;
      P003K4_A118ClinicaRUC = new long[1] ;
      A186UbigeoDepartamento = "" ;
      A187UbigeoProvincia = "" ;
      A188UbigeoDistrito = "" ;
      P003K5_A185UbigeoNombre = new String[] {""} ;
      P003K5_A44UbigeoCode = new String[] {""} ;
      P003K5_A186UbigeoDepartamento = new String[] {""} ;
      P003K5_A187UbigeoProvincia = new String[] {""} ;
      P003K5_A188UbigeoDistrito = new String[] {""} ;
      A185UbigeoNombre = "" ;
      A44UbigeoCode = "" ;
      P003K6_A30SedeId = new short[1] ;
      P003K6_A44UbigeoCode = new String[] {""} ;
      P003K6_A188UbigeoDistrito = new String[] {""} ;
      P003K6_A187UbigeoProvincia = new String[] {""} ;
      P003K6_A186UbigeoDepartamento = new String[] {""} ;
      AV25UbigeoCode = "" ;
      P003K7_A44UbigeoCode = new String[] {""} ;
      P003K7_A188UbigeoDistrito = new String[] {""} ;
      P003K7_A187UbigeoProvincia = new String[] {""} ;
      P003K7_A186UbigeoDepartamento = new String[] {""} ;
      pr_default = new DataStoreProvider(context, remoteHandle, new com.projectthani.sedeloaddvcombo__default(),
         new Object[] {
             new Object[] {
            P003K2_A118ClinicaRUC, P003K2_A28ClinicaId
            }
            , new Object[] {
            P003K3_A30SedeId, P003K3_A28ClinicaId, P003K3_A118ClinicaRUC
            }
            , new Object[] {
            P003K4_A28ClinicaId, P003K4_A118ClinicaRUC
            }
            , new Object[] {
            P003K5_A185UbigeoNombre, P003K5_A44UbigeoCode, P003K5_A186UbigeoDepartamento, P003K5_A187UbigeoProvincia, P003K5_A188UbigeoDistrito
            }
            , new Object[] {
            P003K6_A30SedeId, P003K6_A44UbigeoCode, P003K6_A188UbigeoDistrito, P003K6_A187UbigeoProvincia, P003K6_A186UbigeoDepartamento
            }
            , new Object[] {
            P003K7_A44UbigeoCode, P003K7_A188UbigeoDistrito, P003K7_A187UbigeoProvincia, P003K7_A186UbigeoDepartamento
            }
         }
      );
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private short AV26SedeId ;
   private short A28ClinicaId ;
   private short A30SedeId ;
   private short AV24ClinicaId ;
   private short Gx_err ;
   private int AV11MaxItems ;
   private long A118ClinicaRUC ;
   private String AV19TrnMode ;
   private String scmdbuf ;
   private String A44UbigeoCode ;
   private String AV25UbigeoCode ;
   private boolean AV21IsDynamicCall ;
   private boolean AV8IsAuthorized ;
   private boolean GXt_boolean1 ;
   private boolean GXv_boolean2[] ;
   private boolean returnInSub ;
   private String AV13Combo_DataJson ;
   private String AV17ComboName ;
   private String AV12SearchTxt ;
   private String AV16SelectedValue ;
   private String AV22SelectedText ;
   private String lV12SearchTxt ;
   private String A186UbigeoDepartamento ;
   private String A187UbigeoProvincia ;
   private String A188UbigeoDistrito ;
   private String A185UbigeoNombre ;
   private String[] aP7 ;
   private String[] aP5 ;
   private String[] aP6 ;
   private IDataStoreProvider pr_default ;
   private long[] P003K2_A118ClinicaRUC ;
   private short[] P003K2_A28ClinicaId ;
   private short[] P003K3_A30SedeId ;
   private short[] P003K3_A28ClinicaId ;
   private long[] P003K3_A118ClinicaRUC ;
   private short[] P003K4_A28ClinicaId ;
   private long[] P003K4_A118ClinicaRUC ;
   private String[] P003K5_A185UbigeoNombre ;
   private String[] P003K5_A44UbigeoCode ;
   private String[] P003K5_A186UbigeoDepartamento ;
   private String[] P003K5_A187UbigeoProvincia ;
   private String[] P003K5_A188UbigeoDistrito ;
   private short[] P003K6_A30SedeId ;
   private String[] P003K6_A44UbigeoCode ;
   private String[] P003K6_A188UbigeoDistrito ;
   private String[] P003K6_A187UbigeoProvincia ;
   private String[] P003K6_A186UbigeoDepartamento ;
   private String[] P003K7_A44UbigeoCode ;
   private String[] P003K7_A188UbigeoDistrito ;
   private String[] P003K7_A187UbigeoProvincia ;
   private String[] P003K7_A186UbigeoDepartamento ;
   private GXBaseCollection<com.projectthani.wwpbaseobjects.SdtDVB_SDTComboData_Item> AV14Combo_Data ;
   private com.projectthani.wwpbaseobjects.SdtWWPContext AV9WWPContext ;
   private com.projectthani.wwpbaseobjects.SdtWWPContext GXv_SdtWWPContext3[] ;
   private com.projectthani.wwpbaseobjects.SdtDVB_SDTComboData_Item AV15Combo_DataItem ;
}

final  class sedeloaddvcombo__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   protected Object[] conditional_P003K2( ModelContext context ,
                                          int remoteHandle ,
                                          com.genexus.IHttpContext httpContext ,
                                          String AV12SearchTxt ,
                                          long A118ClinicaRUC )
   {
      java.lang.StringBuffer sWhereString = new java.lang.StringBuffer();
      String scmdbuf;
      byte[] GXv_int4 = new byte[1];
      Object[] GXv_Object5 = new Object[2];
      scmdbuf = "SELECT [ClinicaRUC], [ClinicaId] FROM [Clinica]" ;
      if ( ! (GXutil.strcmp("", AV12SearchTxt)==0) )
      {
         addWhere(sWhereString, "(CONVERT( char(11), CAST([ClinicaRUC] AS decimal(11,0))) like '%' + ?)");
      }
      else
      {
         GXv_int4[0] = (byte)(1) ;
      }
      scmdbuf += sWhereString ;
      scmdbuf += " ORDER BY [ClinicaRUC]" ;
      GXv_Object5[0] = scmdbuf ;
      GXv_Object5[1] = GXv_int4 ;
      return GXv_Object5 ;
   }

   protected Object[] conditional_P003K5( ModelContext context ,
                                          int remoteHandle ,
                                          com.genexus.IHttpContext httpContext ,
                                          String AV12SearchTxt ,
                                          String A186UbigeoDepartamento ,
                                          String A187UbigeoProvincia ,
                                          String A188UbigeoDistrito )
   {
      java.lang.StringBuffer sWhereString = new java.lang.StringBuffer();
      String scmdbuf;
      byte[] GXv_int6 = new byte[1];
      Object[] GXv_Object7 = new Object[2];
      scmdbuf = "SELECT [UbigeoDepartamento] + ' / ' + [UbigeoProvincia] + ' / ' + [UbigeoDistrito] AS UbigeoNombre, [UbigeoCode], [UbigeoDepartamento], [UbigeoProvincia], [UbigeoDistrito]" ;
      scmdbuf += " FROM [Ubigeo]" ;
      if ( ! (GXutil.strcmp("", AV12SearchTxt)==0) )
      {
         addWhere(sWhereString, "([UbigeoDepartamento] + ' / ' + [UbigeoProvincia] + ' / ' + [UbigeoDistrito] like '%' + ?)");
      }
      else
      {
         GXv_int6[0] = (byte)(1) ;
      }
      scmdbuf += sWhereString ;
      scmdbuf += " ORDER BY [UbigeoNombre]" ;
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
                  return conditional_P003K2(context, remoteHandle, httpContext, (String)dynConstraints[0] , ((Number) dynConstraints[1]).longValue() );
            case 3 :
                  return conditional_P003K5(context, remoteHandle, httpContext, (String)dynConstraints[0] , (String)dynConstraints[1] , (String)dynConstraints[2] , (String)dynConstraints[3] );
      }
      return super.getDynamicStatement(cursor, context, remoteHandle, httpContext, dynConstraints);
   }

   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P003K2", "scmdbuf",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("P003K3", "SELECT T1.[SedeId], T1.[ClinicaId], T2.[ClinicaRUC] FROM ([Sede] T1 INNER JOIN [Clinica] T2 ON T2.[ClinicaId] = T1.[ClinicaId]) WHERE T1.[SedeId] = ? ORDER BY T1.[SedeId] ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("P003K4", "SELECT TOP 1 [ClinicaId], [ClinicaRUC] FROM [Clinica] WHERE [ClinicaId] = ? ORDER BY [ClinicaId] ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("P003K5", "scmdbuf",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("P003K6", "SELECT T1.[SedeId], T1.[UbigeoCode], T2.[UbigeoDistrito], T2.[UbigeoProvincia], T2.[UbigeoDepartamento] FROM ([Sede] T1 INNER JOIN [Ubigeo] T2 ON T2.[UbigeoCode] = T1.[UbigeoCode]) WHERE T1.[SedeId] = ? ORDER BY T1.[SedeId] ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("P003K7", "SELECT TOP 1 [UbigeoCode], [UbigeoDistrito], [UbigeoProvincia], [UbigeoDepartamento] FROM [Ubigeo] WHERE [UbigeoCode] = ? ORDER BY [UbigeoCode] ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
      };
   }

   public void getResults( int cursor ,
                           IFieldGetter rslt ,
                           Object[] buf ) throws SQLException
   {
      switch ( cursor )
      {
            case 0 :
               ((long[]) buf[0])[0] = rslt.getLong(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               return;
            case 1 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((long[]) buf[2])[0] = rslt.getLong(3);
               return;
            case 2 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               ((long[]) buf[1])[0] = rslt.getLong(2);
               return;
            case 3 :
               ((String[]) buf[0])[0] = rslt.getVarchar(1);
               ((String[]) buf[1])[0] = rslt.getString(2, 10);
               ((String[]) buf[2])[0] = rslt.getVarchar(3);
               ((String[]) buf[3])[0] = rslt.getVarchar(4);
               ((String[]) buf[4])[0] = rslt.getVarchar(5);
               return;
            case 4 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               ((String[]) buf[1])[0] = rslt.getString(2, 10);
               ((String[]) buf[2])[0] = rslt.getVarchar(3);
               ((String[]) buf[3])[0] = rslt.getVarchar(4);
               ((String[]) buf[4])[0] = rslt.getVarchar(5);
               return;
            case 5 :
               ((String[]) buf[0])[0] = rslt.getString(1, 10);
               ((String[]) buf[1])[0] = rslt.getVarchar(2);
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
                  stmt.setVarchar(sIdx, (String)parms[1], 40);
               }
               return;
            case 1 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               return;
            case 2 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               return;
            case 3 :
               sIdx = (short)(0) ;
               if ( ((Number) parms[0]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[1], 40);
               }
               return;
            case 4 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               return;
            case 5 :
               stmt.setString(1, (String)parms[0], 10);
               return;
      }
   }

}

