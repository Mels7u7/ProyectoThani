package com.projectthani ;
import com.projectthani.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class prcpacientefrecuente extends GXProcedure
{
   public prcpacientefrecuente( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( prcpacientefrecuente.class ), "" );
   }

   public prcpacientefrecuente( int remoteHandle ,
                                ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public String executeUdp( int aP0 )
   {
      prcpacientefrecuente.this.aP1 = new String[] {""};
      execute_int(aP0, aP1);
      return aP1[0];
   }

   public void execute( int aP0 ,
                        String[] aP1 )
   {
      execute_int(aP0, aP1);
   }

   private void execute_int( int aP0 ,
                             String[] aP1 )
   {
      prcpacientefrecuente.this.AV9PacienteId = aP0;
      prcpacientefrecuente.this.aP1 = aP1;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      AV8isFrecuente = "0" ;
      /* Using cursor P006Q2 */
      pr_default.execute(0, new Object[] {Integer.valueOf(AV9PacienteId), Gx_date});
      while ( (pr_default.getStatus(0) != 101) )
      {
         A92CitaFechaReserva = P006Q2_A92CitaFechaReserva[0] ;
         n92CitaFechaReserva = P006Q2_n92CitaFechaReserva[0] ;
         A20PacienteId = P006Q2_A20PacienteId[0] ;
         A19CitaId = P006Q2_A19CitaId[0] ;
         AV8isFrecuente = "1" ;
         pr_default.readNext(0);
      }
      pr_default.close(0);
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP1[0] = prcpacientefrecuente.this.AV8isFrecuente;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV8isFrecuente = "" ;
      scmdbuf = "" ;
      Gx_date = GXutil.nullDate() ;
      P006Q2_A92CitaFechaReserva = new java.util.Date[] {GXutil.nullDate()} ;
      P006Q2_n92CitaFechaReserva = new boolean[] {false} ;
      P006Q2_A20PacienteId = new int[1] ;
      P006Q2_A19CitaId = new int[1] ;
      A92CitaFechaReserva = GXutil.resetTime( GXutil.nullDate() );
      pr_default = new DataStoreProvider(context, remoteHandle, new com.projectthani.prcpacientefrecuente__default(),
         new Object[] {
             new Object[] {
            P006Q2_A92CitaFechaReserva, P006Q2_n92CitaFechaReserva, P006Q2_A20PacienteId, P006Q2_A19CitaId
            }
         }
      );
      Gx_date = GXutil.today( ) ;
      /* GeneXus formulas. */
      Gx_date = GXutil.today( ) ;
      Gx_err = (short)(0) ;
   }

   private short Gx_err ;
   private int AV9PacienteId ;
   private int A20PacienteId ;
   private int A19CitaId ;
   private String scmdbuf ;
   private java.util.Date A92CitaFechaReserva ;
   private java.util.Date Gx_date ;
   private boolean n92CitaFechaReserva ;
   private String AV8isFrecuente ;
   private String[] aP1 ;
   private IDataStoreProvider pr_default ;
   private java.util.Date[] P006Q2_A92CitaFechaReserva ;
   private boolean[] P006Q2_n92CitaFechaReserva ;
   private int[] P006Q2_A20PacienteId ;
   private int[] P006Q2_A19CitaId ;
}

final  class prcpacientefrecuente__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P006Q2", "SELECT [CitaFechaReserva], [PacienteId], [CitaId] FROM [Cita] WHERE ([PacienteId] = ?) AND ([CitaFechaReserva] >= DATEADD( dd,( -7), ?)) ORDER BY [PacienteId] ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
      };
   }

   public void getResults( int cursor ,
                           IFieldGetter rslt ,
                           Object[] buf ) throws SQLException
   {
      switch ( cursor )
      {
            case 0 :
               ((java.util.Date[]) buf[0])[0] = rslt.getGXDateTime(1);
               ((boolean[]) buf[1])[0] = rslt.wasNull();
               ((int[]) buf[2])[0] = rslt.getInt(2);
               ((int[]) buf[3])[0] = rslt.getInt(3);
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
               stmt.setDate(2, (java.util.Date)parms[1]);
               return;
      }
   }

}

