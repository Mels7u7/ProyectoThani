package com.projectthani ;
import com.projectthani.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class dpsededisponibilidad extends GXProcedure
{
   public dpsededisponibilidad( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( dpsededisponibilidad.class ), "" );
   }

   public dpsededisponibilidad( int remoteHandle ,
                                ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public GXBaseCollection<com.projectthani.SdtSDTSede> executeUdp( short aP0 ,
                                                                    int aP1 )
   {
      dpsededisponibilidad.this.aP2 = new GXBaseCollection[] {new GXBaseCollection<com.projectthani.SdtSDTSede>()};
      execute_int(aP0, aP1, aP2);
      return aP2[0];
   }

   public void execute( short aP0 ,
                        int aP1 ,
                        GXBaseCollection<com.projectthani.SdtSDTSede>[] aP2 )
   {
      execute_int(aP0, aP1, aP2);
   }

   private void execute_int( short aP0 ,
                             int aP1 ,
                             GXBaseCollection<com.projectthani.SdtSDTSede>[] aP2 )
   {
      dpsededisponibilidad.this.AV5EspecialidadId = aP0;
      dpsededisponibilidad.this.AV6ProfesionalId = aP1;
      dpsededisponibilidad.this.aP2 = aP2;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      /* Using cursor P000H2 */
      pr_default.execute(0, new Object[] {Integer.valueOf(AV6ProfesionalId), Short.valueOf(AV5EspecialidadId)});
      while ( (pr_default.getStatus(0) != 101) )
      {
         A31ProfesionalId = P000H2_A31ProfesionalId[0] ;
         A32EspecialidadId = P000H2_A32EspecialidadId[0] ;
         A30SedeId = P000H2_A30SedeId[0] ;
         A75SedeNombre = P000H2_A75SedeNombre[0] ;
         A28ClinicaId = P000H2_A28ClinicaId[0] ;
         A80ClinicaNombreAbreviado = P000H2_A80ClinicaNombreAbreviado[0] ;
         A54SedeTipoConsulta = P000H2_A54SedeTipoConsulta[0] ;
         A75SedeNombre = P000H2_A75SedeNombre[0] ;
         A28ClinicaId = P000H2_A28ClinicaId[0] ;
         A80ClinicaNombreAbreviado = P000H2_A80ClinicaNombreAbreviado[0] ;
         Gxm1sdtsede = (com.projectthani.SdtSDTSede)new com.projectthani.SdtSDTSede(remoteHandle, context);
         Gxm2rootcol.add(Gxm1sdtsede, 0);
         Gxm1sdtsede.setgxTv_SdtSDTSede_Sgespecialidadsedeid( A30SedeId );
         Gxm1sdtsede.setgxTv_SdtSDTSede_Sgespecialidadsedenombre( A75SedeNombre );
         Gxm1sdtsede.setgxTv_SdtSDTSede_Sgespecialidadsedeclinicaid( A28ClinicaId );
         Gxm1sdtsede.setgxTv_SdtSDTSede_Sgespecialidadsedeclinicanombre( A80ClinicaNombreAbreviado );
         Gxm1sdtsede.setgxTv_SdtSDTSede_Sedefullname( A75SedeNombre+" / "+A80ClinicaNombreAbreviado );
         pr_default.readNext(0);
      }
      pr_default.close(0);
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP2[0] = dpsededisponibilidad.this.Gxm2rootcol;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      Gxm2rootcol = new GXBaseCollection<com.projectthani.SdtSDTSede>(com.projectthani.SdtSDTSede.class, "SDTSede", "ProjectThani", remoteHandle);
      scmdbuf = "" ;
      P000H2_A31ProfesionalId = new int[1] ;
      P000H2_A32EspecialidadId = new short[1] ;
      P000H2_A30SedeId = new short[1] ;
      P000H2_A75SedeNombre = new String[] {""} ;
      P000H2_A28ClinicaId = new short[1] ;
      P000H2_A80ClinicaNombreAbreviado = new String[] {""} ;
      P000H2_A54SedeTipoConsulta = new String[] {""} ;
      A75SedeNombre = "" ;
      A80ClinicaNombreAbreviado = "" ;
      A54SedeTipoConsulta = "" ;
      Gxm1sdtsede = new com.projectthani.SdtSDTSede(remoteHandle, context);
      pr_default = new DataStoreProvider(context, remoteHandle, new com.projectthani.dpsededisponibilidad__default(),
         new Object[] {
             new Object[] {
            P000H2_A31ProfesionalId, P000H2_A32EspecialidadId, P000H2_A30SedeId, P000H2_A75SedeNombre, P000H2_A28ClinicaId, P000H2_A80ClinicaNombreAbreviado, P000H2_A54SedeTipoConsulta
            }
         }
      );
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private short AV5EspecialidadId ;
   private short A32EspecialidadId ;
   private short A30SedeId ;
   private short A28ClinicaId ;
   private short Gx_err ;
   private int AV6ProfesionalId ;
   private int A31ProfesionalId ;
   private String scmdbuf ;
   private String A54SedeTipoConsulta ;
   private String A75SedeNombre ;
   private String A80ClinicaNombreAbreviado ;
   private GXBaseCollection<com.projectthani.SdtSDTSede>[] aP2 ;
   private IDataStoreProvider pr_default ;
   private int[] P000H2_A31ProfesionalId ;
   private short[] P000H2_A32EspecialidadId ;
   private short[] P000H2_A30SedeId ;
   private String[] P000H2_A75SedeNombre ;
   private short[] P000H2_A28ClinicaId ;
   private String[] P000H2_A80ClinicaNombreAbreviado ;
   private String[] P000H2_A54SedeTipoConsulta ;
   private GXBaseCollection<com.projectthani.SdtSDTSede> Gxm2rootcol ;
   private com.projectthani.SdtSDTSede Gxm1sdtsede ;
}

final  class dpsededisponibilidad__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P000H2", "SELECT T1.[ProfesionalId], T1.[EspecialidadId], T1.[SedeId], T2.[SedeNombre], T2.[ClinicaId], T3.[ClinicaNombreAbreviado], T1.[SedeTipoConsulta] FROM (([ProfesionalEspecialidadSede] T1 INNER JOIN [Sede] T2 ON T2.[SedeId] = T1.[SedeId]) INNER JOIN [Clinica] T3 ON T3.[ClinicaId] = T2.[ClinicaId]) WHERE T1.[ProfesionalId] = ? and T1.[EspecialidadId] = ? ORDER BY T1.[ProfesionalId], T1.[EspecialidadId] ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
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
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((short[]) buf[2])[0] = rslt.getShort(3);
               ((String[]) buf[3])[0] = rslt.getVarchar(4);
               ((short[]) buf[4])[0] = rslt.getShort(5);
               ((String[]) buf[5])[0] = rslt.getVarchar(6);
               ((String[]) buf[6])[0] = rslt.getString(7, 1);
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
               return;
      }
   }

}

