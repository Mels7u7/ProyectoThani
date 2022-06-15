package com.projectthani ;
import com.projectthani.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class logaccesosloaddvcombo extends GXProcedure
{
   public logaccesosloaddvcombo( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( logaccesosloaddvcombo.class ), "" );
   }

   public logaccesosloaddvcombo( int remoteHandle ,
                                 ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public String executeUdp( String aP0 ,
                             String aP1 ,
                             boolean aP2 ,
                             short aP3 ,
                             short aP4 ,
                             String aP5 ,
                             String[] aP6 ,
                             String[] aP7 )
   {
      logaccesosloaddvcombo.this.aP8 = new String[] {""};
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5, aP6, aP7, aP8);
      return aP8[0];
   }

   public void execute( String aP0 ,
                        String aP1 ,
                        boolean aP2 ,
                        short aP3 ,
                        short aP4 ,
                        String aP5 ,
                        String[] aP6 ,
                        String[] aP7 ,
                        String[] aP8 )
   {
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5, aP6, aP7, aP8);
   }

   private void execute_int( String aP0 ,
                             String aP1 ,
                             boolean aP2 ,
                             short aP3 ,
                             short aP4 ,
                             String aP5 ,
                             String[] aP6 ,
                             String[] aP7 ,
                             String[] aP8 )
   {
      logaccesosloaddvcombo.this.AV17ComboName = aP0;
      logaccesosloaddvcombo.this.AV19TrnMode = aP1;
      logaccesosloaddvcombo.this.AV21IsDynamicCall = aP2;
      logaccesosloaddvcombo.this.AV26LogAccesosId = aP3;
      logaccesosloaddvcombo.this.AV27Cond_SecUserId = aP4;
      logaccesosloaddvcombo.this.AV12SearchTxt = aP5;
      logaccesosloaddvcombo.this.aP6 = aP6;
      logaccesosloaddvcombo.this.aP7 = aP7;
      logaccesosloaddvcombo.this.aP8 = aP8;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      GXt_boolean1 = AV8IsAuthorized ;
      GXv_boolean2[0] = GXt_boolean1 ;
      new com.projectthani.wwpbaseobjects.secisauthbyfunctionalitykey(remoteHandle, context).execute( "WWLogAccesos", GXv_boolean2) ;
      logaccesosloaddvcombo.this.GXt_boolean1 = GXv_boolean2[0] ;
      AV8IsAuthorized = GXt_boolean1 ;
      if ( AV8IsAuthorized )
      {
         GXv_SdtWWPContext3[0] = AV9WWPContext;
         new com.projectthani.wwpbaseobjects.loadwwpcontext(remoteHandle, context).execute( GXv_SdtWWPContext3) ;
         AV9WWPContext = GXv_SdtWWPContext3[0] ;
         AV11MaxItems = 100 ;
         if ( GXutil.strcmp(AV17ComboName, "SecUserId") == 0 )
         {
            /* Execute user subroutine: 'LOADCOMBOITEMS_SECUSERID' */
            S111 ();
            if ( returnInSub )
            {
               returnInSub = true;
               cleanup();
               if (true) return;
            }
         }
         else if ( GXutil.strcmp(AV17ComboName, "SecRoleId") == 0 )
         {
            /* Execute user subroutine: 'LOADCOMBOITEMS_SECROLEID' */
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
      /* 'LOADCOMBOITEMS_SECUSERID' Routine */
      returnInSub = false ;
      if ( AV21IsDynamicCall )
      {
         pr_default.dynParam(0, new Object[]{ new Object[]{
                                              AV12SearchTxt ,
                                              A14SecUserName } ,
                                              new int[]{
                                              TypeConstants.STRING, TypeConstants.STRING
                                              }
         });
         lV12SearchTxt = GXutil.concat( GXutil.rtrim( AV12SearchTxt), "%", "") ;
         /* Using cursor P00372 */
         pr_default.execute(0, new Object[] {lV12SearchTxt});
         while ( (pr_default.getStatus(0) != 101) )
         {
            A14SecUserName = P00372_A14SecUserName[0] ;
            A6SecUserId = P00372_A6SecUserId[0] ;
            AV15Combo_DataItem = (com.projectthani.wwpbaseobjects.SdtDVB_SDTComboData_Item)new com.projectthani.wwpbaseobjects.SdtDVB_SDTComboData_Item(remoteHandle, context);
            AV15Combo_DataItem.setgxTv_SdtDVB_SDTComboData_Item_Id( GXutil.trim( GXutil.str( A6SecUserId, 4, 0)) );
            AV15Combo_DataItem.setgxTv_SdtDVB_SDTComboData_Item_Title( A14SecUserName );
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
               /* Using cursor P00373 */
               pr_default.execute(1, new Object[] {Short.valueOf(AV26LogAccesosId)});
               while ( (pr_default.getStatus(1) != 101) )
               {
                  A41LogAccesosId = P00373_A41LogAccesosId[0] ;
                  A6SecUserId = P00373_A6SecUserId[0] ;
                  A14SecUserName = P00373_A14SecUserName[0] ;
                  A14SecUserName = P00373_A14SecUserName[0] ;
                  AV16SelectedValue = ((0==A6SecUserId) ? "" : GXutil.trim( GXutil.str( A6SecUserId, 4, 0))) ;
                  AV22SelectedText = A14SecUserName ;
                  /* Exiting from a For First loop. */
                  if (true) break;
               }
               pr_default.close(1);
            }
            else
            {
               AV24SecUserId = (short)(GXutil.lval( AV12SearchTxt)) ;
               /* Using cursor P00374 */
               pr_default.execute(2, new Object[] {Short.valueOf(AV24SecUserId)});
               while ( (pr_default.getStatus(2) != 101) )
               {
                  A6SecUserId = P00374_A6SecUserId[0] ;
                  A14SecUserName = P00374_A14SecUserName[0] ;
                  AV22SelectedText = A14SecUserName ;
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
      /* 'LOADCOMBOITEMS_SECROLEID' Routine */
      returnInSub = false ;
      if ( AV21IsDynamicCall )
      {
         pr_default.dynParam(3, new Object[]{ new Object[]{
                                              AV12SearchTxt ,
                                              Short.valueOf(A4SecRoleId) ,
                                              Short.valueOf(AV27Cond_SecUserId) ,
                                              Short.valueOf(A6SecUserId) } ,
                                              new int[]{
                                              TypeConstants.STRING, TypeConstants.SHORT, TypeConstants.SHORT, TypeConstants.SHORT
                                              }
         });
         lV12SearchTxt = GXutil.concat( GXutil.rtrim( AV12SearchTxt), "%", "") ;
         /* Using cursor P00375 */
         pr_default.execute(3, new Object[] {Short.valueOf(AV27Cond_SecUserId), lV12SearchTxt});
         while ( (pr_default.getStatus(3) != 101) )
         {
            A4SecRoleId = P00375_A4SecRoleId[0] ;
            A6SecUserId = P00375_A6SecUserId[0] ;
            AV15Combo_DataItem = (com.projectthani.wwpbaseobjects.SdtDVB_SDTComboData_Item)new com.projectthani.wwpbaseobjects.SdtDVB_SDTComboData_Item(remoteHandle, context);
            AV15Combo_DataItem.setgxTv_SdtDVB_SDTComboData_Item_Id( GXutil.trim( GXutil.str( A4SecRoleId, 4, 0)) );
            AV15Combo_DataItem.setgxTv_SdtDVB_SDTComboData_Item_Title( GXutil.trim( localUtil.format( DecimalUtil.doubleToDec(A4SecRoleId), "ZZZ9")) );
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
            /* Using cursor P00376 */
            pr_default.execute(4, new Object[] {Short.valueOf(AV26LogAccesosId)});
            while ( (pr_default.getStatus(4) != 101) )
            {
               A41LogAccesosId = P00376_A41LogAccesosId[0] ;
               A4SecRoleId = P00376_A4SecRoleId[0] ;
               AV16SelectedValue = ((0==A4SecRoleId) ? "" : GXutil.trim( GXutil.str( A4SecRoleId, 4, 0))) ;
               AV22SelectedText = AV16SelectedValue ;
               /* Exiting from a For First loop. */
               if (true) break;
            }
            pr_default.close(4);
         }
      }
   }

   protected void cleanup( )
   {
      this.aP6[0] = logaccesosloaddvcombo.this.AV16SelectedValue;
      this.aP7[0] = logaccesosloaddvcombo.this.AV22SelectedText;
      this.aP8[0] = logaccesosloaddvcombo.this.AV13Combo_DataJson;
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
      A14SecUserName = "" ;
      P00372_A14SecUserName = new String[] {""} ;
      P00372_A6SecUserId = new short[1] ;
      AV15Combo_DataItem = new com.projectthani.wwpbaseobjects.SdtDVB_SDTComboData_Item(remoteHandle, context);
      AV14Combo_Data = new GXBaseCollection<com.projectthani.wwpbaseobjects.SdtDVB_SDTComboData_Item>(com.projectthani.wwpbaseobjects.SdtDVB_SDTComboData_Item.class, "Item", "", remoteHandle);
      P00373_A41LogAccesosId = new short[1] ;
      P00373_A6SecUserId = new short[1] ;
      P00373_A14SecUserName = new String[] {""} ;
      P00374_A6SecUserId = new short[1] ;
      P00374_A14SecUserName = new String[] {""} ;
      P00375_A4SecRoleId = new short[1] ;
      P00375_A6SecUserId = new short[1] ;
      P00376_A41LogAccesosId = new short[1] ;
      P00376_A4SecRoleId = new short[1] ;
      pr_default = new DataStoreProvider(context, remoteHandle, new com.projectthani.logaccesosloaddvcombo__default(),
         new Object[] {
             new Object[] {
            P00372_A14SecUserName, P00372_A6SecUserId
            }
            , new Object[] {
            P00373_A41LogAccesosId, P00373_A6SecUserId, P00373_A14SecUserName
            }
            , new Object[] {
            P00374_A6SecUserId, P00374_A14SecUserName
            }
            , new Object[] {
            P00375_A4SecRoleId, P00375_A6SecUserId
            }
            , new Object[] {
            P00376_A41LogAccesosId, P00376_A4SecRoleId
            }
         }
      );
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private short AV26LogAccesosId ;
   private short AV27Cond_SecUserId ;
   private short A6SecUserId ;
   private short A41LogAccesosId ;
   private short AV24SecUserId ;
   private short A4SecRoleId ;
   private short Gx_err ;
   private int AV11MaxItems ;
   private String AV19TrnMode ;
   private String scmdbuf ;
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
   private String A14SecUserName ;
   private String[] aP8 ;
   private String[] aP6 ;
   private String[] aP7 ;
   private IDataStoreProvider pr_default ;
   private String[] P00372_A14SecUserName ;
   private short[] P00372_A6SecUserId ;
   private short[] P00373_A41LogAccesosId ;
   private short[] P00373_A6SecUserId ;
   private String[] P00373_A14SecUserName ;
   private short[] P00374_A6SecUserId ;
   private String[] P00374_A14SecUserName ;
   private short[] P00375_A4SecRoleId ;
   private short[] P00375_A6SecUserId ;
   private short[] P00376_A41LogAccesosId ;
   private short[] P00376_A4SecRoleId ;
   private GXBaseCollection<com.projectthani.wwpbaseobjects.SdtDVB_SDTComboData_Item> AV14Combo_Data ;
   private com.projectthani.wwpbaseobjects.SdtWWPContext AV9WWPContext ;
   private com.projectthani.wwpbaseobjects.SdtWWPContext GXv_SdtWWPContext3[] ;
   private com.projectthani.wwpbaseobjects.SdtDVB_SDTComboData_Item AV15Combo_DataItem ;
}

final  class logaccesosloaddvcombo__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   protected Object[] conditional_P00372( ModelContext context ,
                                          int remoteHandle ,
                                          com.genexus.IHttpContext httpContext ,
                                          String AV12SearchTxt ,
                                          String A14SecUserName )
   {
      java.lang.StringBuffer sWhereString = new java.lang.StringBuffer();
      String scmdbuf;
      byte[] GXv_int4 = new byte[1];
      Object[] GXv_Object5 = new Object[2];
      scmdbuf = "SELECT [SecUserName], [SecUserId] FROM [SecUser]" ;
      if ( ! (GXutil.strcmp("", AV12SearchTxt)==0) )
      {
         addWhere(sWhereString, "([SecUserName] like '%' + ?)");
      }
      else
      {
         GXv_int4[0] = (byte)(1) ;
      }
      scmdbuf += sWhereString ;
      scmdbuf += " ORDER BY [SecUserName]" ;
      GXv_Object5[0] = scmdbuf ;
      GXv_Object5[1] = GXv_int4 ;
      return GXv_Object5 ;
   }

   protected Object[] conditional_P00375( ModelContext context ,
                                          int remoteHandle ,
                                          com.genexus.IHttpContext httpContext ,
                                          String AV12SearchTxt ,
                                          short A4SecRoleId ,
                                          short AV27Cond_SecUserId ,
                                          short A6SecUserId )
   {
      java.lang.StringBuffer sWhereString = new java.lang.StringBuffer();
      String scmdbuf;
      byte[] GXv_int6 = new byte[2];
      Object[] GXv_Object7 = new Object[2];
      scmdbuf = "SELECT [SecRoleId], [SecUserId] FROM [SecUserRole]" ;
      addWhere(sWhereString, "([SecUserId] = ?)");
      if ( ! (GXutil.strcmp("", AV12SearchTxt)==0) )
      {
         addWhere(sWhereString, "(CONVERT( char(4), CAST([SecRoleId] AS decimal(4,0))) like '%' + ?)");
      }
      else
      {
         GXv_int6[1] = (byte)(1) ;
      }
      scmdbuf += sWhereString ;
      scmdbuf += " ORDER BY [SecUserId], [SecRoleId]" ;
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
                  return conditional_P00372(context, remoteHandle, httpContext, (String)dynConstraints[0] , (String)dynConstraints[1] );
            case 3 :
                  return conditional_P00375(context, remoteHandle, httpContext, (String)dynConstraints[0] , ((Number) dynConstraints[1]).shortValue() , ((Number) dynConstraints[2]).shortValue() , ((Number) dynConstraints[3]).shortValue() );
      }
      return super.getDynamicStatement(cursor, context, remoteHandle, httpContext, dynConstraints);
   }

   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P00372", "scmdbuf",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("P00373", "SELECT T1.[LogAccesosId], T1.[SecUserId], T2.[SecUserName] FROM ([LogAccesos] T1 INNER JOIN [SecUser] T2 ON T2.[SecUserId] = T1.[SecUserId]) WHERE T1.[LogAccesosId] = ? ORDER BY T1.[LogAccesosId] ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("P00374", "SELECT TOP 1 [SecUserId], [SecUserName] FROM [SecUser] WHERE [SecUserId] = ? ORDER BY [SecUserId] ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("P00375", "scmdbuf",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("P00376", "SELECT [LogAccesosId], [SecRoleId] FROM [LogAccesos] WHERE [LogAccesosId] = ? ORDER BY [LogAccesosId] ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
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
               return;
            case 1 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((String[]) buf[2])[0] = rslt.getVarchar(3);
               return;
            case 2 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               ((String[]) buf[1])[0] = rslt.getVarchar(2);
               return;
            case 3 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               return;
            case 4 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
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
                  stmt.setShort(sIdx, ((Number) parms[2]).shortValue());
               }
               if ( ((Number) parms[1]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[3], 40);
               }
               return;
            case 4 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               return;
      }
   }

}

