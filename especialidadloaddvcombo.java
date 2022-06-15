package com.projectthani ;
import com.projectthani.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class especialidadloaddvcombo extends GXProcedure
{
   public especialidadloaddvcombo( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( especialidadloaddvcombo.class ), "" );
   }

   public especialidadloaddvcombo( int remoteHandle ,
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
      especialidadloaddvcombo.this.aP7 = new String[] {""};
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
      especialidadloaddvcombo.this.AV17ComboName = aP0;
      especialidadloaddvcombo.this.AV19TrnMode = aP1;
      especialidadloaddvcombo.this.AV21IsDynamicCall = aP2;
      especialidadloaddvcombo.this.AV24EspecialidadId = aP3;
      especialidadloaddvcombo.this.AV12SearchTxt = aP4;
      especialidadloaddvcombo.this.aP5 = aP5;
      especialidadloaddvcombo.this.aP6 = aP6;
      especialidadloaddvcombo.this.aP7 = aP7;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      GXt_boolean1 = AV8IsAuthorized ;
      GXv_boolean2[0] = GXt_boolean1 ;
      new com.projectthani.wwpbaseobjects.secisauthbyfunctionalitykey(remoteHandle, context).execute( "WWEspecialidad", GXv_boolean2) ;
      especialidadloaddvcombo.this.GXt_boolean1 = GXv_boolean2[0] ;
      AV8IsAuthorized = GXt_boolean1 ;
      if ( AV8IsAuthorized )
      {
         GXv_SdtWWPContext3[0] = AV9WWPContext;
         new com.projectthani.wwpbaseobjects.loadwwpcontext(remoteHandle, context).execute( GXv_SdtWWPContext3) ;
         AV9WWPContext = GXv_SdtWWPContext3[0] ;
         AV11MaxItems = 100 ;
         if ( GXutil.strcmp(AV17ComboName, "SGEspecialidadSedeId") == 0 )
         {
            /* Execute user subroutine: 'LOADCOMBOITEMS_SGESPECIALIDADSEDEID' */
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
      /* 'LOADCOMBOITEMS_SGESPECIALIDADSEDEID' Routine */
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
               AV28SedeId_Filter = (short)(GXutil.lval( AV27ValueItem)) ;
               AV32GXLvl32 = (byte)(0) ;
               /* Using cursor P006C2 */
               pr_default.execute(0, new Object[] {Short.valueOf(AV28SedeId_Filter)});
               while ( (pr_default.getStatus(0) != 101) )
               {
                  A30SedeId = P006C2_A30SedeId[0] ;
                  A75SedeNombre = P006C2_A75SedeNombre[0] ;
                  AV32GXLvl32 = (byte)(1) ;
                  AV25DscsCollection.add(A75SedeNombre, 0);
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
                                                 A75SedeNombre } ,
                                                 new int[]{
                                                 TypeConstants.STRING, TypeConstants.STRING
                                                 }
            });
            lV12SearchTxt = GXutil.concat( GXutil.rtrim( AV12SearchTxt), "%", "") ;
            /* Using cursor P006C3 */
            pr_default.execute(1, new Object[] {lV12SearchTxt});
            while ( (pr_default.getStatus(1) != 101) )
            {
               A75SedeNombre = P006C3_A75SedeNombre[0] ;
               A30SedeId = P006C3_A30SedeId[0] ;
               AV15Combo_DataItem = (com.projectthani.wwpbaseobjects.SdtDVB_SDTComboData_Item)new com.projectthani.wwpbaseobjects.SdtDVB_SDTComboData_Item(remoteHandle, context);
               AV15Combo_DataItem.setgxTv_SdtDVB_SDTComboData_Item_Id( GXutil.trim( GXutil.str( A30SedeId, 4, 0)) );
               AV15Combo_DataItem.setgxTv_SdtDVB_SDTComboData_Item_Title( A75SedeNombre );
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
      this.aP5[0] = especialidadloaddvcombo.this.AV16SelectedValue;
      this.aP6[0] = especialidadloaddvcombo.this.AV22SelectedText;
      this.aP7[0] = especialidadloaddvcombo.this.AV13Combo_DataJson;
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
      A75SedeNombre = "" ;
      AV26ValuesCollection = new GXSimpleCollection<String>(String.class, "internal", "");
      AV25DscsCollection = new GXSimpleCollection<String>(String.class, "internal", "");
      AV27ValueItem = "" ;
      scmdbuf = "" ;
      P006C2_A30SedeId = new short[1] ;
      P006C2_A75SedeNombre = new String[] {""} ;
      lV12SearchTxt = "" ;
      P006C3_A75SedeNombre = new String[] {""} ;
      P006C3_A30SedeId = new short[1] ;
      AV15Combo_DataItem = new com.projectthani.wwpbaseobjects.SdtDVB_SDTComboData_Item(remoteHandle, context);
      AV14Combo_Data = new GXBaseCollection<com.projectthani.wwpbaseobjects.SdtDVB_SDTComboData_Item>(com.projectthani.wwpbaseobjects.SdtDVB_SDTComboData_Item.class, "Item", "", remoteHandle);
      pr_default = new DataStoreProvider(context, remoteHandle, new com.projectthani.especialidadloaddvcombo__default(),
         new Object[] {
             new Object[] {
            P006C2_A30SedeId, P006C2_A75SedeNombre
            }
            , new Object[] {
            P006C3_A75SedeNombre, P006C3_A30SedeId
            }
         }
      );
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private byte AV32GXLvl32 ;
   private short AV24EspecialidadId ;
   private short AV28SedeId_Filter ;
   private short A30SedeId ;
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
   private String A75SedeNombre ;
   private String AV27ValueItem ;
   private String lV12SearchTxt ;
   private String[] aP7 ;
   private String[] aP5 ;
   private String[] aP6 ;
   private IDataStoreProvider pr_default ;
   private short[] P006C2_A30SedeId ;
   private String[] P006C2_A75SedeNombre ;
   private String[] P006C3_A75SedeNombre ;
   private short[] P006C3_A30SedeId ;
   private GXSimpleCollection<String> AV26ValuesCollection ;
   private GXSimpleCollection<String> AV25DscsCollection ;
   private GXBaseCollection<com.projectthani.wwpbaseobjects.SdtDVB_SDTComboData_Item> AV14Combo_Data ;
   private com.projectthani.wwpbaseobjects.SdtWWPContext AV9WWPContext ;
   private com.projectthani.wwpbaseobjects.SdtWWPContext GXv_SdtWWPContext3[] ;
   private com.projectthani.wwpbaseobjects.SdtDVB_SDTComboData_Item AV15Combo_DataItem ;
}

final  class especialidadloaddvcombo__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   protected Object[] conditional_P006C3( ModelContext context ,
                                          int remoteHandle ,
                                          com.genexus.IHttpContext httpContext ,
                                          String AV12SearchTxt ,
                                          String A75SedeNombre )
   {
      java.lang.StringBuffer sWhereString = new java.lang.StringBuffer();
      String scmdbuf;
      byte[] GXv_int4 = new byte[1];
      Object[] GXv_Object5 = new Object[2];
      scmdbuf = "SELECT [SedeNombre], [SedeId] FROM [Sede]" ;
      if ( ! (GXutil.strcmp("", AV12SearchTxt)==0) )
      {
         addWhere(sWhereString, "([SedeNombre] like '%' + ?)");
      }
      else
      {
         GXv_int4[0] = (byte)(1) ;
      }
      scmdbuf += sWhereString ;
      scmdbuf += " ORDER BY [SedeNombre]" ;
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
                  return conditional_P006C3(context, remoteHandle, httpContext, (String)dynConstraints[0] , (String)dynConstraints[1] );
      }
      return super.getDynamicStatement(cursor, context, remoteHandle, httpContext, dynConstraints);
   }

   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P006C2", "SELECT TOP 1 [SedeId], [SedeNombre] FROM [Sede] WHERE [SedeId] = ? ORDER BY [SedeId] ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("P006C3", "scmdbuf",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
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

