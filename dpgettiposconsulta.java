package com.projectthani ;
import com.projectthani.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class dpgettiposconsulta extends GXProcedure
{
   public dpgettiposconsulta( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( dpgettiposconsulta.class ), "" );
   }

   public dpgettiposconsulta( int remoteHandle ,
                              ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public GXBaseCollection<com.projectthani.SdtSDTTipoConsulta> executeUdp( int aP0 ,
                                                                            short aP1 ,
                                                                            short aP2 )
   {
      dpgettiposconsulta.this.aP3 = new GXBaseCollection[] {new GXBaseCollection<com.projectthani.SdtSDTTipoConsulta>()};
      execute_int(aP0, aP1, aP2, aP3);
      return aP3[0];
   }

   public void execute( int aP0 ,
                        short aP1 ,
                        short aP2 ,
                        GXBaseCollection<com.projectthani.SdtSDTTipoConsulta>[] aP3 )
   {
      execute_int(aP0, aP1, aP2, aP3);
   }

   private void execute_int( int aP0 ,
                             short aP1 ,
                             short aP2 ,
                             GXBaseCollection<com.projectthani.SdtSDTTipoConsulta>[] aP3 )
   {
      dpgettiposconsulta.this.AV6ProfesionalId = aP0;
      dpgettiposconsulta.this.AV7EspecialidadId = aP1;
      dpgettiposconsulta.this.AV5SedeId = aP2;
      dpgettiposconsulta.this.aP3 = aP3;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      /* Using cursor P000I2 */
      pr_default.execute(0, new Object[] {Integer.valueOf(AV6ProfesionalId), Short.valueOf(AV7EspecialidadId), Short.valueOf(AV5SedeId)});
      while ( (pr_default.getStatus(0) != 101) )
      {
         A30SedeId = P000I2_A30SedeId[0] ;
         A32EspecialidadId = P000I2_A32EspecialidadId[0] ;
         A31ProfesionalId = P000I2_A31ProfesionalId[0] ;
         A54SedeTipoConsulta = P000I2_A54SedeTipoConsulta[0] ;
         Gxm1sdttipoconsulta = (com.projectthani.SdtSDTTipoConsulta)new com.projectthani.SdtSDTTipoConsulta(remoteHandle, context);
         Gxm2rootcol.add(Gxm1sdttipoconsulta, 0);
         Gxm1sdttipoconsulta.setgxTv_SdtSDTTipoConsulta_Sedetipoconsulta( A54SedeTipoConsulta );
         Gxm1sdttipoconsulta.setgxTv_SdtSDTTipoConsulta_Sedetipoconsultadescripcion( com.projectthani.gxdomaintipocita.getDescription(httpContext,(String)A54SedeTipoConsulta) );
         pr_default.readNext(0);
      }
      pr_default.close(0);
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP3[0] = dpgettiposconsulta.this.Gxm2rootcol;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      Gxm2rootcol = new GXBaseCollection<com.projectthani.SdtSDTTipoConsulta>(com.projectthani.SdtSDTTipoConsulta.class, "SDTTipoConsulta", "ProjectThani", remoteHandle);
      scmdbuf = "" ;
      P000I2_A30SedeId = new short[1] ;
      P000I2_A32EspecialidadId = new short[1] ;
      P000I2_A31ProfesionalId = new int[1] ;
      P000I2_A54SedeTipoConsulta = new String[] {""} ;
      A54SedeTipoConsulta = "" ;
      Gxm1sdttipoconsulta = new com.projectthani.SdtSDTTipoConsulta(remoteHandle, context);
      pr_default = new DataStoreProvider(context, remoteHandle, new com.projectthani.dpgettiposconsulta__default(),
         new Object[] {
             new Object[] {
            P000I2_A30SedeId, P000I2_A32EspecialidadId, P000I2_A31ProfesionalId, P000I2_A54SedeTipoConsulta
            }
         }
      );
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private short AV7EspecialidadId ;
   private short AV5SedeId ;
   private short A30SedeId ;
   private short A32EspecialidadId ;
   private short Gx_err ;
   private int AV6ProfesionalId ;
   private int A31ProfesionalId ;
   private String scmdbuf ;
   private String A54SedeTipoConsulta ;
   private GXBaseCollection<com.projectthani.SdtSDTTipoConsulta>[] aP3 ;
   private IDataStoreProvider pr_default ;
   private short[] P000I2_A30SedeId ;
   private short[] P000I2_A32EspecialidadId ;
   private int[] P000I2_A31ProfesionalId ;
   private String[] P000I2_A54SedeTipoConsulta ;
   private GXBaseCollection<com.projectthani.SdtSDTTipoConsulta> Gxm2rootcol ;
   private com.projectthani.SdtSDTTipoConsulta Gxm1sdttipoconsulta ;
}

final  class dpgettiposconsulta__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P000I2", "SELECT [SedeId], [EspecialidadId], [ProfesionalId], [SedeTipoConsulta] FROM [ProfesionalEspecialidadSede] WHERE [ProfesionalId] = ? and [EspecialidadId] = ? and [SedeId] = ? ORDER BY [ProfesionalId], [EspecialidadId], [SedeId] ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
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
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((int[]) buf[2])[0] = rslt.getInt(3);
               ((String[]) buf[3])[0] = rslt.getString(4, 1);
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
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setShort(3, ((Number) parms[2]).shortValue());
               return;
      }
   }

}

