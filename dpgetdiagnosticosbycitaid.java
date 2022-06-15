package com.projectthani ;
import com.projectthani.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class dpgetdiagnosticosbycitaid extends GXProcedure
{
   public dpgetdiagnosticosbycitaid( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( dpgetdiagnosticosbycitaid.class ), "" );
   }

   public dpgetdiagnosticosbycitaid( int remoteHandle ,
                                     ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public GXBaseCollection<com.projectthani.SdtSDTDiagnosticoGrid> executeUdp( int aP0 )
   {
      dpgetdiagnosticosbycitaid.this.aP1 = new GXBaseCollection[] {new GXBaseCollection<com.projectthani.SdtSDTDiagnosticoGrid>()};
      execute_int(aP0, aP1);
      return aP1[0];
   }

   public void execute( int aP0 ,
                        GXBaseCollection<com.projectthani.SdtSDTDiagnosticoGrid>[] aP1 )
   {
      execute_int(aP0, aP1);
   }

   private void execute_int( int aP0 ,
                             GXBaseCollection<com.projectthani.SdtSDTDiagnosticoGrid>[] aP1 )
   {
      dpgetdiagnosticosbycitaid.this.AV5CitaId = aP0;
      dpgetdiagnosticosbycitaid.this.aP1 = aP1;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      /* Using cursor P000M2 */
      pr_default.execute(0, new Object[] {Integer.valueOf(AV5CitaId)});
      while ( (pr_default.getStatus(0) != 101) )
      {
         A19CitaId = P000M2_A19CitaId[0] ;
         A23DiagnosticoId = P000M2_A23DiagnosticoId[0] ;
         A108DiagnosticoDescripcion = P000M2_A108DiagnosticoDescripcion[0] ;
         A107DiagnosticoCodigo = P000M2_A107DiagnosticoCodigo[0] ;
         A22CitaDiagnosticoId = P000M2_A22CitaDiagnosticoId[0] ;
         A108DiagnosticoDescripcion = P000M2_A108DiagnosticoDescripcion[0] ;
         A107DiagnosticoCodigo = P000M2_A107DiagnosticoCodigo[0] ;
         A132DiagnosticoLongDesc = A107DiagnosticoCodigo + " - " + A108DiagnosticoDescripcion ;
         Gxm1sdtdiagnosticogrid = (com.projectthani.SdtSDTDiagnosticoGrid)new com.projectthani.SdtSDTDiagnosticoGrid(remoteHandle, context);
         Gxm2rootcol.add(Gxm1sdtdiagnosticogrid, 0);
         Gxm1sdtdiagnosticogrid.setgxTv_SdtSDTDiagnosticoGrid_Diagnosticoid( A23DiagnosticoId );
         Gxm1sdtdiagnosticogrid.setgxTv_SdtSDTDiagnosticoGrid_Diagnosticodescripcion( A108DiagnosticoDescripcion );
         Gxm1sdtdiagnosticogrid.setgxTv_SdtSDTDiagnosticoGrid_Diagnosticocodigo( A107DiagnosticoCodigo );
         Gxm1sdtdiagnosticogrid.setgxTv_SdtSDTDiagnosticoGrid_Diagnosticolongdesc( A132DiagnosticoLongDesc );
         pr_default.readNext(0);
      }
      pr_default.close(0);
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP1[0] = dpgetdiagnosticosbycitaid.this.Gxm2rootcol;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      Gxm2rootcol = new GXBaseCollection<com.projectthani.SdtSDTDiagnosticoGrid>(com.projectthani.SdtSDTDiagnosticoGrid.class, "SDTDiagnosticoGrid", "ProjectThani", remoteHandle);
      scmdbuf = "" ;
      P000M2_A19CitaId = new int[1] ;
      P000M2_A23DiagnosticoId = new int[1] ;
      P000M2_A108DiagnosticoDescripcion = new String[] {""} ;
      P000M2_A107DiagnosticoCodigo = new String[] {""} ;
      P000M2_A22CitaDiagnosticoId = new int[1] ;
      A108DiagnosticoDescripcion = "" ;
      A107DiagnosticoCodigo = "" ;
      A132DiagnosticoLongDesc = "" ;
      Gxm1sdtdiagnosticogrid = new com.projectthani.SdtSDTDiagnosticoGrid(remoteHandle, context);
      pr_default = new DataStoreProvider(context, remoteHandle, new com.projectthani.dpgetdiagnosticosbycitaid__default(),
         new Object[] {
             new Object[] {
            P000M2_A19CitaId, P000M2_A23DiagnosticoId, P000M2_A108DiagnosticoDescripcion, P000M2_A107DiagnosticoCodigo, P000M2_A22CitaDiagnosticoId
            }
         }
      );
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private short Gx_err ;
   private int AV5CitaId ;
   private int A19CitaId ;
   private int A23DiagnosticoId ;
   private int A22CitaDiagnosticoId ;
   private String scmdbuf ;
   private String A108DiagnosticoDescripcion ;
   private String A107DiagnosticoCodigo ;
   private String A132DiagnosticoLongDesc ;
   private GXBaseCollection<com.projectthani.SdtSDTDiagnosticoGrid>[] aP1 ;
   private IDataStoreProvider pr_default ;
   private int[] P000M2_A19CitaId ;
   private int[] P000M2_A23DiagnosticoId ;
   private String[] P000M2_A108DiagnosticoDescripcion ;
   private String[] P000M2_A107DiagnosticoCodigo ;
   private int[] P000M2_A22CitaDiagnosticoId ;
   private GXBaseCollection<com.projectthani.SdtSDTDiagnosticoGrid> Gxm2rootcol ;
   private com.projectthani.SdtSDTDiagnosticoGrid Gxm1sdtdiagnosticogrid ;
}

final  class dpgetdiagnosticosbycitaid__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P000M2", "SELECT T1.[CitaId], T1.[DiagnosticoId], T2.[DiagnosticoDescripcion], T2.[DiagnosticoCodigo], T1.[CitaDiagnosticoId] FROM ([CitaDiagnostico] T1 INNER JOIN [Diagnostico] T2 ON T2.[DiagnosticoId] = T1.[DiagnosticoId]) WHERE T1.[CitaId] = ? ORDER BY T1.[CitaId] ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
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
               ((String[]) buf[2])[0] = rslt.getVarchar(3);
               ((String[]) buf[3])[0] = rslt.getVarchar(4);
               ((int[]) buf[4])[0] = rslt.getInt(5);
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
               return;
      }
   }

}

