package com.projectthani ;
import com.projectthani.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class dpgetdiagnosticosbydescripcion extends GXProcedure
{
   public dpgetdiagnosticosbydescripcion( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( dpgetdiagnosticosbydescripcion.class ), "" );
   }

   public dpgetdiagnosticosbydescripcion( int remoteHandle ,
                                          ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public GXBaseCollection<com.projectthani.SdtSDTDiagnosticoGrid> executeUdp( String aP0 )
   {
      dpgetdiagnosticosbydescripcion.this.aP1 = new GXBaseCollection[] {new GXBaseCollection<com.projectthani.SdtSDTDiagnosticoGrid>()};
      execute_int(aP0, aP1);
      return aP1[0];
   }

   public void execute( String aP0 ,
                        GXBaseCollection<com.projectthani.SdtSDTDiagnosticoGrid>[] aP1 )
   {
      execute_int(aP0, aP1);
   }

   private void execute_int( String aP0 ,
                             GXBaseCollection<com.projectthani.SdtSDTDiagnosticoGrid>[] aP1 )
   {
      dpgetdiagnosticosbydescripcion.this.AV5DiagnosticoDescripcion = aP0;
      dpgetdiagnosticosbydescripcion.this.aP1 = aP1;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      /* Using cursor P000D2 */
      pr_default.execute(0, new Object[] {AV5DiagnosticoDescripcion});
      while ( (pr_default.getStatus(0) != 101) )
      {
         A23DiagnosticoId = P000D2_A23DiagnosticoId[0] ;
         A108DiagnosticoDescripcion = P000D2_A108DiagnosticoDescripcion[0] ;
         A107DiagnosticoCodigo = P000D2_A107DiagnosticoCodigo[0] ;
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
      this.aP1[0] = dpgetdiagnosticosbydescripcion.this.Gxm2rootcol;
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
      P000D2_A23DiagnosticoId = new int[1] ;
      P000D2_A108DiagnosticoDescripcion = new String[] {""} ;
      P000D2_A107DiagnosticoCodigo = new String[] {""} ;
      A108DiagnosticoDescripcion = "" ;
      A107DiagnosticoCodigo = "" ;
      A132DiagnosticoLongDesc = "" ;
      Gxm1sdtdiagnosticogrid = new com.projectthani.SdtSDTDiagnosticoGrid(remoteHandle, context);
      pr_default = new DataStoreProvider(context, remoteHandle, new com.projectthani.dpgetdiagnosticosbydescripcion__default(),
         new Object[] {
             new Object[] {
            P000D2_A23DiagnosticoId, P000D2_A108DiagnosticoDescripcion, P000D2_A107DiagnosticoCodigo
            }
         }
      );
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private short Gx_err ;
   private int A23DiagnosticoId ;
   private String scmdbuf ;
   private String AV5DiagnosticoDescripcion ;
   private String A108DiagnosticoDescripcion ;
   private String A107DiagnosticoCodigo ;
   private String A132DiagnosticoLongDesc ;
   private GXBaseCollection<com.projectthani.SdtSDTDiagnosticoGrid>[] aP1 ;
   private IDataStoreProvider pr_default ;
   private int[] P000D2_A23DiagnosticoId ;
   private String[] P000D2_A108DiagnosticoDescripcion ;
   private String[] P000D2_A107DiagnosticoCodigo ;
   private GXBaseCollection<com.projectthani.SdtSDTDiagnosticoGrid> Gxm2rootcol ;
   private com.projectthani.SdtSDTDiagnosticoGrid Gxm1sdtdiagnosticogrid ;
}

final  class dpgetdiagnosticosbydescripcion__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P000D2", "SELECT [DiagnosticoId], [DiagnosticoDescripcion], [DiagnosticoCodigo] FROM [Diagnostico] WHERE (CHARINDEX(RTRIM(?), [DiagnosticoDescripcion])) = 1 ORDER BY [DiagnosticoId] ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
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
               ((String[]) buf[1])[0] = rslt.getVarchar(2);
               ((String[]) buf[2])[0] = rslt.getVarchar(3);
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
               stmt.setVarchar(1, (String)parms[0], 1000);
               return;
      }
   }

}

