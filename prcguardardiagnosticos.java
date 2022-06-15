package com.projectthani ;
import com.projectthani.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class prcguardardiagnosticos extends GXProcedure
{
   public prcguardardiagnosticos( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( prcguardardiagnosticos.class ), "" );
   }

   public prcguardardiagnosticos( int remoteHandle ,
                                  ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   public void execute( GXBaseCollection<com.projectthani.SdtSDTDiagnosticoGrid> aP0 ,
                        int aP1 )
   {
      execute_int(aP0, aP1);
   }

   private void execute_int( GXBaseCollection<com.projectthani.SdtSDTDiagnosticoGrid> aP0 ,
                             int aP1 )
   {
      prcguardardiagnosticos.this.AV8SDTDiagnosticoGrid = aP0;
      prcguardardiagnosticos.this.AV10CitaId = aP1;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      AV14GXV1 = 1 ;
      while ( AV14GXV1 <= AV8SDTDiagnosticoGrid.size() )
      {
         AV9SDTDiagnosticoGridItem = (com.projectthani.SdtSDTDiagnosticoGrid)((com.projectthani.SdtSDTDiagnosticoGrid)AV8SDTDiagnosticoGrid.elementAt(-1+AV14GXV1));
         AV11isDuplicado = false ;
         /* Using cursor P006E2 */
         pr_default.execute(0, new Object[] {Integer.valueOf(AV10CitaId), Integer.valueOf(AV9SDTDiagnosticoGridItem.getgxTv_SdtSDTDiagnosticoGrid_Diagnosticoid())});
         while ( (pr_default.getStatus(0) != 101) )
         {
            A23DiagnosticoId = P006E2_A23DiagnosticoId[0] ;
            A19CitaId = P006E2_A19CitaId[0] ;
            A22CitaDiagnosticoId = P006E2_A22CitaDiagnosticoId[0] ;
            AV11isDuplicado = true ;
            pr_default.readNext(0);
         }
         pr_default.close(0);
         if ( ! AV11isDuplicado )
         {
            /*
               INSERT RECORD ON TABLE CitaDiagnostico

            */
            A19CitaId = AV10CitaId ;
            A23DiagnosticoId = AV9SDTDiagnosticoGridItem.getgxTv_SdtSDTDiagnosticoGrid_Diagnosticoid() ;
            A109CitaDiagnosticoEstado = "A" ;
            /* Using cursor P006E3 */
            pr_default.execute(1, new Object[] {Integer.valueOf(A19CitaId), Integer.valueOf(A23DiagnosticoId), A109CitaDiagnosticoEstado});
            A22CitaDiagnosticoId = P006E3_A22CitaDiagnosticoId[0] ;
            Application.getSmartCacheProvider(remoteHandle).setUpdated("CitaDiagnostico");
            if ( (pr_default.getStatus(1) == 1) )
            {
               Gx_err = (short)(1) ;
               Gx_emsg = localUtil.getMessages().getMessage("GXM_noupdate") ;
            }
            else
            {
               Gx_err = (short)(0) ;
               Gx_emsg = "" ;
            }
            /* End Insert */
         }
         AV14GXV1 = (int)(AV14GXV1+1) ;
      }
      cleanup();
   }

   protected void cleanup( )
   {
      Application.commitDataStores(context, remoteHandle, pr_default, "prcguardardiagnosticos");
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV9SDTDiagnosticoGridItem = new com.projectthani.SdtSDTDiagnosticoGrid(remoteHandle, context);
      scmdbuf = "" ;
      P006E2_A23DiagnosticoId = new int[1] ;
      P006E2_A19CitaId = new int[1] ;
      P006E2_A22CitaDiagnosticoId = new int[1] ;
      A109CitaDiagnosticoEstado = "" ;
      P006E3_A22CitaDiagnosticoId = new int[1] ;
      Gx_emsg = "" ;
      pr_default = new DataStoreProvider(context, remoteHandle, new com.projectthani.prcguardardiagnosticos__default(),
         new Object[] {
             new Object[] {
            P006E2_A23DiagnosticoId, P006E2_A19CitaId, P006E2_A22CitaDiagnosticoId
            }
            , new Object[] {
            P006E3_A22CitaDiagnosticoId
            }
         }
      );
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private short Gx_err ;
   private int AV10CitaId ;
   private int AV14GXV1 ;
   private int A23DiagnosticoId ;
   private int A19CitaId ;
   private int A22CitaDiagnosticoId ;
   private int GX_INS18 ;
   private String scmdbuf ;
   private String Gx_emsg ;
   private boolean AV11isDuplicado ;
   private String A109CitaDiagnosticoEstado ;
   private IDataStoreProvider pr_default ;
   private int[] P006E2_A23DiagnosticoId ;
   private int[] P006E2_A19CitaId ;
   private int[] P006E2_A22CitaDiagnosticoId ;
   private int[] P006E3_A22CitaDiagnosticoId ;
   private GXBaseCollection<com.projectthani.SdtSDTDiagnosticoGrid> AV8SDTDiagnosticoGrid ;
   private com.projectthani.SdtSDTDiagnosticoGrid AV9SDTDiagnosticoGridItem ;
}

final  class prcguardardiagnosticos__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P006E2", "SELECT [DiagnosticoId], [CitaId], [CitaDiagnosticoId] FROM [CitaDiagnostico] WHERE ([CitaId] = ?) AND ([DiagnosticoId] = ?) ORDER BY [CitaId] ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("P006E3", "INSERT INTO [CitaDiagnostico]([CitaId], [DiagnosticoId], [CitaDiagnosticoEstado]) VALUES(?, ?, ?); SELECT SCOPE_IDENTITY()", GX_NOMASK + GX_MASKLOOPLOCK)
      };
   }

   public void getResults( int cursor ,
                           IFieldGetter rslt ,
                           Object[] buf ) throws SQLException
   {
      switch ( cursor )
      {
            case 0 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((int[]) buf[1])[0] = rslt.getInt(2);
               ((int[]) buf[2])[0] = rslt.getInt(3);
               return;
            case 1 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               return;
      }
   }

   public void setParameters( int cursor ,
                              IFieldSetter stmt ,
                              Object[] parms ) throws SQLException
   {
      switch ( cursor )
      {
            case 0 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setInt(2, ((Number) parms[1]).intValue());
               return;
            case 1 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setInt(2, ((Number) parms[1]).intValue());
               stmt.setVarchar(3, (String)parms[2], 1, false);
               return;
      }
   }

}

