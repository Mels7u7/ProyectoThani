package com.projectthani ;
import com.projectthani.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class servicioloaddvcombo extends GXProcedure
{
   public servicioloaddvcombo( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( servicioloaddvcombo.class ), "" );
   }

   public servicioloaddvcombo( int remoteHandle ,
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
      servicioloaddvcombo.this.aP7 = new String[] {""};
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
      servicioloaddvcombo.this.AV17ComboName = aP0;
      servicioloaddvcombo.this.AV19TrnMode = aP1;
      servicioloaddvcombo.this.AV21IsDynamicCall = aP2;
      servicioloaddvcombo.this.AV25ServicioId = aP3;
      servicioloaddvcombo.this.AV12SearchTxt = aP4;
      servicioloaddvcombo.this.aP5 = aP5;
      servicioloaddvcombo.this.aP6 = aP6;
      servicioloaddvcombo.this.aP7 = aP7;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      GXt_boolean1 = AV8IsAuthorized ;
      GXv_boolean2[0] = GXt_boolean1 ;
      new com.projectthani.wwpbaseobjects.secisauthbyfunctionalitykey(remoteHandle, context).execute( "WWServicio", GXv_boolean2) ;
      servicioloaddvcombo.this.GXt_boolean1 = GXv_boolean2[0] ;
      AV8IsAuthorized = GXt_boolean1 ;
      if ( AV8IsAuthorized )
      {
         GXv_SdtWWPContext3[0] = AV9WWPContext;
         new com.projectthani.wwpbaseobjects.loadwwpcontext(remoteHandle, context).execute( GXv_SdtWWPContext3) ;
         AV9WWPContext = GXv_SdtWWPContext3[0] ;
         AV11MaxItems = 100 ;
         if ( GXutil.strcmp(AV17ComboName, "ServicioCategId") == 0 )
         {
            /* Execute user subroutine: 'LOADCOMBOITEMS_SERVICIOCATEGID' */
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
      /* 'LOADCOMBOITEMS_SERVICIOCATEGID' Routine */
      returnInSub = false ;
      if ( AV21IsDynamicCall )
      {
         pr_default.dynParam(0, new Object[]{ new Object[]{
                                              AV12SearchTxt ,
                                              A287ServicioCategNombre } ,
                                              new int[]{
                                              TypeConstants.STRING, TypeConstants.STRING
                                              }
         });
         lV12SearchTxt = GXutil.concat( GXutil.rtrim( AV12SearchTxt), "%", "") ;
         /* Using cursor P003M2 */
         pr_default.execute(0, new Object[] {lV12SearchTxt});
         while ( (pr_default.getStatus(0) != 101) )
         {
            A287ServicioCategNombre = P003M2_A287ServicioCategNombre[0] ;
            A52ServicioCategId = P003M2_A52ServicioCategId[0] ;
            AV15Combo_DataItem = (com.projectthani.wwpbaseobjects.SdtDVB_SDTComboData_Item)new com.projectthani.wwpbaseobjects.SdtDVB_SDTComboData_Item(remoteHandle, context);
            AV15Combo_DataItem.setgxTv_SdtDVB_SDTComboData_Item_Id( GXutil.trim( GXutil.str( A52ServicioCategId, 4, 0)) );
            AV15Combo_DataItem.setgxTv_SdtDVB_SDTComboData_Item_Title( A287ServicioCategNombre );
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
               /* Using cursor P003M3 */
               pr_default.execute(1, new Object[] {Short.valueOf(AV25ServicioId)});
               while ( (pr_default.getStatus(1) != 101) )
               {
                  A27ServicioId = P003M3_A27ServicioId[0] ;
                  A52ServicioCategId = P003M3_A52ServicioCategId[0] ;
                  A287ServicioCategNombre = P003M3_A287ServicioCategNombre[0] ;
                  A287ServicioCategNombre = P003M3_A287ServicioCategNombre[0] ;
                  AV16SelectedValue = ((0==A52ServicioCategId) ? "" : GXutil.trim( GXutil.str( A52ServicioCategId, 4, 0))) ;
                  AV22SelectedText = A287ServicioCategNombre ;
                  /* Exiting from a For First loop. */
                  if (true) break;
               }
               pr_default.close(1);
            }
            else
            {
               AV24ServicioCategId = (short)(GXutil.lval( AV12SearchTxt)) ;
               /* Using cursor P003M4 */
               pr_default.execute(2, new Object[] {Short.valueOf(AV24ServicioCategId)});
               while ( (pr_default.getStatus(2) != 101) )
               {
                  A52ServicioCategId = P003M4_A52ServicioCategId[0] ;
                  A287ServicioCategNombre = P003M4_A287ServicioCategNombre[0] ;
                  AV22SelectedText = A287ServicioCategNombre ;
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

   protected void cleanup( )
   {
      this.aP5[0] = servicioloaddvcombo.this.AV16SelectedValue;
      this.aP6[0] = servicioloaddvcombo.this.AV22SelectedText;
      this.aP7[0] = servicioloaddvcombo.this.AV13Combo_DataJson;
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
      A287ServicioCategNombre = "" ;
      P003M2_A287ServicioCategNombre = new String[] {""} ;
      P003M2_A52ServicioCategId = new short[1] ;
      AV15Combo_DataItem = new com.projectthani.wwpbaseobjects.SdtDVB_SDTComboData_Item(remoteHandle, context);
      AV14Combo_Data = new GXBaseCollection<com.projectthani.wwpbaseobjects.SdtDVB_SDTComboData_Item>(com.projectthani.wwpbaseobjects.SdtDVB_SDTComboData_Item.class, "Item", "", remoteHandle);
      P003M3_A27ServicioId = new short[1] ;
      P003M3_A52ServicioCategId = new short[1] ;
      P003M3_A287ServicioCategNombre = new String[] {""} ;
      P003M4_A52ServicioCategId = new short[1] ;
      P003M4_A287ServicioCategNombre = new String[] {""} ;
      pr_default = new DataStoreProvider(context, remoteHandle, new com.projectthani.servicioloaddvcombo__default(),
         new Object[] {
             new Object[] {
            P003M2_A287ServicioCategNombre, P003M2_A52ServicioCategId
            }
            , new Object[] {
            P003M3_A27ServicioId, P003M3_A52ServicioCategId, P003M3_A287ServicioCategNombre
            }
            , new Object[] {
            P003M4_A52ServicioCategId, P003M4_A287ServicioCategNombre
            }
         }
      );
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private short AV25ServicioId ;
   private short A52ServicioCategId ;
   private short A27ServicioId ;
   private short AV24ServicioCategId ;
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
   private String A287ServicioCategNombre ;
   private String[] aP7 ;
   private String[] aP5 ;
   private String[] aP6 ;
   private IDataStoreProvider pr_default ;
   private String[] P003M2_A287ServicioCategNombre ;
   private short[] P003M2_A52ServicioCategId ;
   private short[] P003M3_A27ServicioId ;
   private short[] P003M3_A52ServicioCategId ;
   private String[] P003M3_A287ServicioCategNombre ;
   private short[] P003M4_A52ServicioCategId ;
   private String[] P003M4_A287ServicioCategNombre ;
   private GXBaseCollection<com.projectthani.wwpbaseobjects.SdtDVB_SDTComboData_Item> AV14Combo_Data ;
   private com.projectthani.wwpbaseobjects.SdtWWPContext AV9WWPContext ;
   private com.projectthani.wwpbaseobjects.SdtWWPContext GXv_SdtWWPContext3[] ;
   private com.projectthani.wwpbaseobjects.SdtDVB_SDTComboData_Item AV15Combo_DataItem ;
}

final  class servicioloaddvcombo__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   protected Object[] conditional_P003M2( ModelContext context ,
                                          int remoteHandle ,
                                          com.genexus.IHttpContext httpContext ,
                                          String AV12SearchTxt ,
                                          String A287ServicioCategNombre )
   {
      java.lang.StringBuffer sWhereString = new java.lang.StringBuffer();
      String scmdbuf;
      byte[] GXv_int4 = new byte[1];
      Object[] GXv_Object5 = new Object[2];
      scmdbuf = "SELECT [ServicioCategNombre], [ServicioCategId] FROM [ServicioCateg]" ;
      if ( ! (GXutil.strcmp("", AV12SearchTxt)==0) )
      {
         addWhere(sWhereString, "([ServicioCategNombre] like '%' + ?)");
      }
      else
      {
         GXv_int4[0] = (byte)(1) ;
      }
      scmdbuf += sWhereString ;
      scmdbuf += " ORDER BY [ServicioCategNombre]" ;
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
            case 0 :
                  return conditional_P003M2(context, remoteHandle, httpContext, (String)dynConstraints[0] , (String)dynConstraints[1] );
      }
      return super.getDynamicStatement(cursor, context, remoteHandle, httpContext, dynConstraints);
   }

   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P003M2", "scmdbuf",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("P003M3", "SELECT T1.[ServicioId], T1.[ServicioCategId], T2.[ServicioCategNombre] FROM ([Servicio] T1 INNER JOIN [ServicioCateg] T2 ON T2.[ServicioCategId] = T1.[ServicioCategId]) WHERE T1.[ServicioId] = ? ORDER BY T1.[ServicioId] ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("P003M4", "SELECT TOP 1 [ServicioCategId], [ServicioCategNombre] FROM [ServicioCateg] WHERE [ServicioCategId] = ? ORDER BY [ServicioCategId] ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
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
      }
   }

}

