package com.projectthani ;
import com.projectthani.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class prcgetnextnro extends GXProcedure
{
   public prcgetnextnro( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( prcgetnextnro.class ), "" );
   }

   public prcgetnextnro( int remoteHandle ,
                         ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public int executeUdp( short aP0 )
   {
      prcgetnextnro.this.aP1 = new int[] {0};
      execute_int(aP0, aP1);
      return aP1[0];
   }

   public void execute( short aP0 ,
                        int[] aP1 )
   {
      execute_int(aP0, aP1);
   }

   private void execute_int( short aP0 ,
                             int[] aP1 )
   {
      prcgetnextnro.this.AV8PagoTipoDocumento = aP0;
      prcgetnextnro.this.aP1 = aP1;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      /* Using cursor P007D2 */
      pr_default.execute(0, new Object[] {Short.valueOf(AV8PagoTipoDocumento)});
      while ( (pr_default.getStatus(0) != 101) )
      {
         A246PagoEstadoR = P007D2_A246PagoEstadoR[0] ;
         A244PagoTipoDocumento = P007D2_A244PagoTipoDocumento[0] ;
         A245PagoNumero = P007D2_A245PagoNumero[0] ;
         A47PagoId = P007D2_A47PagoId[0] ;
         AV9PagoNumero = A245PagoNumero ;
         /* Exit For each command. Update data (if necessary), close cursors & exit. */
         if (true) break;
         pr_default.readNext(0);
      }
      pr_default.close(0);
      AV9PagoNumero = (int)(AV9PagoNumero+1) ;
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP1[0] = prcgetnextnro.this.AV9PagoNumero;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      scmdbuf = "" ;
      P007D2_A246PagoEstadoR = new String[] {""} ;
      P007D2_A244PagoTipoDocumento = new short[1] ;
      P007D2_A245PagoNumero = new int[1] ;
      P007D2_A47PagoId = new int[1] ;
      A246PagoEstadoR = "" ;
      pr_default = new DataStoreProvider(context, remoteHandle, new com.projectthani.prcgetnextnro__default(),
         new Object[] {
             new Object[] {
            P007D2_A246PagoEstadoR, P007D2_A244PagoTipoDocumento, P007D2_A245PagoNumero, P007D2_A47PagoId
            }
         }
      );
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private short AV8PagoTipoDocumento ;
   private short A244PagoTipoDocumento ;
   private short Gx_err ;
   private int AV9PagoNumero ;
   private int A245PagoNumero ;
   private int A47PagoId ;
   private String scmdbuf ;
   private String A246PagoEstadoR ;
   private int[] aP1 ;
   private IDataStoreProvider pr_default ;
   private String[] P007D2_A246PagoEstadoR ;
   private short[] P007D2_A244PagoTipoDocumento ;
   private int[] P007D2_A245PagoNumero ;
   private int[] P007D2_A47PagoId ;
}

final  class prcgetnextnro__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P007D2", "SELECT TOP 1 [PagoEstadoR], [PagoTipoDocumento], [PagoNumero], [PagoId] FROM [Pago] WHERE ([PagoEstadoR] = 'A') AND ([PagoTipoDocumento] = ?) ORDER BY [PagoNumero] DESC ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
      };
   }

   public void getResults( int cursor ,
                           IFieldGetter rslt ,
                           Object[] buf ) throws SQLException
   {
      switch ( cursor )
      {
            case 0 :
               ((String[]) buf[0])[0] = rslt.getString(1, 1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((int[]) buf[2])[0] = rslt.getInt(3);
               ((int[]) buf[3])[0] = rslt.getInt(4);
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
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               return;
      }
   }

}

