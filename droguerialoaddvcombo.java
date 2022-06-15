package com.projectthani ;
import com.projectthani.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class droguerialoaddvcombo extends GXProcedure
{
   public droguerialoaddvcombo( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( droguerialoaddvcombo.class ), "" );
   }

   public droguerialoaddvcombo( int remoteHandle ,
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
      droguerialoaddvcombo.this.aP7 = new String[] {""};
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
      droguerialoaddvcombo.this.AV17ComboName = aP0;
      droguerialoaddvcombo.this.AV19TrnMode = aP1;
      droguerialoaddvcombo.this.AV21IsDynamicCall = aP2;
      droguerialoaddvcombo.this.AV24DrogueriaId = aP3;
      droguerialoaddvcombo.this.AV12SearchTxt = aP4;
      droguerialoaddvcombo.this.aP5 = aP5;
      droguerialoaddvcombo.this.aP6 = aP6;
      droguerialoaddvcombo.this.aP7 = aP7;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      GXt_boolean1 = AV8IsAuthorized ;
      GXv_boolean2[0] = GXt_boolean1 ;
      new com.projectthani.wwpbaseobjects.secisauthbyfunctionalitykey(remoteHandle, context).execute( "WWDrogueria", GXv_boolean2) ;
      droguerialoaddvcombo.this.GXt_boolean1 = GXv_boolean2[0] ;
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
      }
      cleanup();
   }

   public void S111( )
   {
      /* 'LOADCOMBOITEMS_SECUSERID' Routine */
      returnInSub = false ;
      if ( AV21IsDynamicCall )
      {
         if ( GXutil.strcmp(AV19TrnMode, "GET_DSC") == 0 )
         {
            AV26ValuesCollection.fromJSonString(AV12SearchTxt, null);
            AV25DscsCollection = new GXSimpleCollection<String>(String.class, "internal", "") ;
            AV31GXV1 = 1 ;
            while ( AV31GXV1 <= AV26ValuesCollection.size() )
            {
               AV27ValueItem = (String)AV26ValuesCollection.elementAt(-1+AV31GXV1) ;
               AV28SecUserId_Filter = (short)(GXutil.lval( AV27ValueItem)) ;
               AV32GXLvl32 = (byte)(0) ;
               /* Using cursor P002Y2 */
               pr_default.execute(0, new Object[] {Short.valueOf(AV28SecUserId_Filter)});
               while ( (pr_default.getStatus(0) != 101) )
               {
                  A6SecUserId = P002Y2_A6SecUserId[0] ;
                  A14SecUserName = P002Y2_A14SecUserName[0] ;
                  AV32GXLvl32 = (byte)(1) ;
                  AV25DscsCollection.add(A14SecUserName, 0);
                  /* Exit For each command. Update data (if necessary), close cursors & exit. */
                  if (true) break;
                  /* Exiting from a For First loop. */
                  if (true) break;
               }
               pr_default.close(0);
               if ( AV32GXLvl32 == 0 )
               {
                  AV25DscsCollection.add("", 0);
               }
               AV31GXV1 = (int)(AV31GXV1+1) ;
            }
            AV13Combo_DataJson = AV25DscsCollection.toJSonString(false) ;
         }
         else
         {
            pr_default.dynParam(1, new Object[]{ new Object[]{
                                                 AV12SearchTxt ,
                                                 A14SecUserName } ,
                                                 new int[]{
                                                 TypeConstants.STRING, TypeConstants.STRING
                                                 }
            });
            lV12SearchTxt = GXutil.concat( GXutil.rtrim( AV12SearchTxt), "%", "") ;
            /* Using cursor P002Y3 */
            pr_default.execute(1, new Object[] {lV12SearchTxt});
            while ( (pr_default.getStatus(1) != 101) )
            {
               A14SecUserName = P002Y3_A14SecUserName[0] ;
               A6SecUserId = P002Y3_A6SecUserId[0] ;
               AV15Combo_DataItem = (com.projectthani.wwpbaseobjects.SdtDVB_SDTComboData_Item)new com.projectthani.wwpbaseobjects.SdtDVB_SDTComboData_Item(remoteHandle, context);
               AV15Combo_DataItem.setgxTv_SdtDVB_SDTComboData_Item_Id( GXutil.trim( GXutil.str( A6SecUserId, 4, 0)) );
               AV15Combo_DataItem.setgxTv_SdtDVB_SDTComboData_Item_Title( A14SecUserName );
               AV14Combo_Data.add(AV15Combo_DataItem, 0);
               if ( AV14Combo_Data.size() > AV11MaxItems )
               {
                  /* Exit For each command. Update data (if necessary), close cursors & exit. */
                  if (true) break;
               }
               pr_default.readNext(1);
            }
            pr_default.close(1);
            AV13Combo_DataJson = AV14Combo_Data.toJSonString(false) ;
         }
      }
   }

   protected void cleanup( )
   {
      this.aP5[0] = droguerialoaddvcombo.this.AV16SelectedValue;
      this.aP6[0] = droguerialoaddvcombo.this.AV22SelectedText;
      this.aP7[0] = droguerialoaddvcombo.this.AV13Combo_DataJson;
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
      A14SecUserName = "" ;
      AV26ValuesCollection = new GXSimpleCollection<String>(String.class, "internal", "");
      AV25DscsCollection = new GXSimpleCollection<String>(String.class, "internal", "");
      AV27ValueItem = "" ;
      scmdbuf = "" ;
      P002Y2_A6SecUserId = new short[1] ;
      P002Y2_A14SecUserName = new String[] {""} ;
      lV12SearchTxt = "" ;
      P002Y3_A14SecUserName = new String[] {""} ;
      P002Y3_A6SecUserId = new short[1] ;
      AV15Combo_DataItem = new com.projectthani.wwpbaseobjects.SdtDVB_SDTComboData_Item(remoteHandle, context);
      AV14Combo_Data = new GXBaseCollection<com.projectthani.wwpbaseobjects.SdtDVB_SDTComboData_Item>(com.projectthani.wwpbaseobjects.SdtDVB_SDTComboData_Item.class, "Item", "", remoteHandle);
      pr_default = new DataStoreProvider(context, remoteHandle, new com.projectthani.droguerialoaddvcombo__default(),
         new Object[] {
             new Object[] {
            P002Y2_A6SecUserId, P002Y2_A14SecUserName
            }
            , new Object[] {
            P002Y3_A14SecUserName, P002Y3_A6SecUserId
            }
         }
      );
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private byte AV32GXLvl32 ;
   private short AV24DrogueriaId ;
   private short AV28SecUserId_Filter ;
   private short A6SecUserId ;
   private short Gx_err ;
   private int AV11MaxItems ;
   private int AV31GXV1 ;
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
   private String A14SecUserName ;
   private String AV27ValueItem ;
   private String lV12SearchTxt ;
   private String[] aP7 ;
   private String[] aP5 ;
   private String[] aP6 ;
   private IDataStoreProvider pr_default ;
   private short[] P002Y2_A6SecUserId ;
   private String[] P002Y2_A14SecUserName ;
   private String[] P002Y3_A14SecUserName ;
   private short[] P002Y3_A6SecUserId ;
   private GXSimpleCollection<String> AV26ValuesCollection ;
   private GXSimpleCollection<String> AV25DscsCollection ;
   private GXBaseCollection<com.projectthani.wwpbaseobjects.SdtDVB_SDTComboData_Item> AV14Combo_Data ;
   private com.projectthani.wwpbaseobjects.SdtWWPContext AV9WWPContext ;
   private com.projectthani.wwpbaseobjects.SdtWWPContext GXv_SdtWWPContext3[] ;
   private com.projectthani.wwpbaseobjects.SdtDVB_SDTComboData_Item AV15Combo_DataItem ;
}

final  class droguerialoaddvcombo__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   protected Object[] conditional_P002Y3( ModelContext context ,
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

   public Object [] getDynamicStatement( int cursor ,
                                         ModelContext context ,
                                         int remoteHandle ,
                                         com.genexus.IHttpContext httpContext ,
                                         Object [] dynConstraints )
   {
      switch ( cursor )
      {
            case 1 :
                  return conditional_P002Y3(context, remoteHandle, httpContext, (String)dynConstraints[0] , (String)dynConstraints[1] );
      }
      return super.getDynamicStatement(cursor, context, remoteHandle, httpContext, dynConstraints);
   }

   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P002Y2", "SELECT TOP 1 [SecUserId], [SecUserName] FROM [SecUser] WHERE [SecUserId] = ? ORDER BY [SecUserId] ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("P002Y3", "scmdbuf",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
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
               ((String[]) buf[1])[0] = rslt.getVarchar(2);
               return;
            case 1 :
               ((String[]) buf[0])[0] = rslt.getVarchar(1);
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
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               return;
            case 1 :
               sIdx = (short)(0) ;
               if ( ((Number) parms[0]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[1], 40);
               }
               return;
      }
   }

}

