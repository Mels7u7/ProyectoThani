package com.projectthani ;
import com.projectthani.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class prcgetprofesionalservicios extends GXProcedure
{
   public prcgetprofesionalservicios( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( prcgetprofesionalservicios.class ), "" );
   }

   public prcgetprofesionalservicios( int remoteHandle ,
                                      ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public GXBaseCollection<com.projectthani.SdtSDTProfesionalServiciosPerfil> executeUdp( int aP0 )
   {
      prcgetprofesionalservicios.this.aP1 = new GXBaseCollection[] {new GXBaseCollection<com.projectthani.SdtSDTProfesionalServiciosPerfil>()};
      execute_int(aP0, aP1);
      return aP1[0];
   }

   public void execute( int aP0 ,
                        GXBaseCollection<com.projectthani.SdtSDTProfesionalServiciosPerfil>[] aP1 )
   {
      execute_int(aP0, aP1);
   }

   private void execute_int( int aP0 ,
                             GXBaseCollection<com.projectthani.SdtSDTProfesionalServiciosPerfil>[] aP1 )
   {
      prcgetprofesionalservicios.this.AV9ProfesionalId = aP0;
      prcgetprofesionalservicios.this.aP1 = aP1;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      /* Using cursor P00732 */
      pr_default.execute(0, new Object[] {Integer.valueOf(AV9ProfesionalId)});
      while ( (pr_default.getStatus(0) != 101) )
      {
         A31ProfesionalId = P00732_A31ProfesionalId[0] ;
         A58ServiciosId = P00732_A58ServiciosId[0] ;
         A210ServiciosNombre = P00732_A210ServiciosNombre[0] ;
         AV10Servicios = (com.projectthani.SdtSDTProfesionalServiciosPerfil)new com.projectthani.SdtSDTProfesionalServiciosPerfil(remoteHandle, context);
         AV10Servicios.setgxTv_SdtSDTProfesionalServiciosPerfil_Id( A58ServiciosId );
         AV10Servicios.setgxTv_SdtSDTProfesionalServiciosPerfil_Nombreservicio( A210ServiciosNombre );
         AV8ListaServicios.add(AV10Servicios, 0);
         pr_default.readNext(0);
      }
      pr_default.close(0);
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP1[0] = prcgetprofesionalservicios.this.AV8ListaServicios;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV8ListaServicios = new GXBaseCollection<com.projectthani.SdtSDTProfesionalServiciosPerfil>(com.projectthani.SdtSDTProfesionalServiciosPerfil.class, "SDTProfesionalServiciosPerfil", "ProjectThani", remoteHandle);
      scmdbuf = "" ;
      P00732_A31ProfesionalId = new int[1] ;
      P00732_A58ServiciosId = new java.util.UUID[] {java.util.UUID.fromString("00000000-0000-0000-0000-000000000000")} ;
      P00732_A210ServiciosNombre = new String[] {""} ;
      A58ServiciosId = java.util.UUID.fromString("00000000-0000-0000-0000-000000000000") ;
      A210ServiciosNombre = "" ;
      AV10Servicios = new com.projectthani.SdtSDTProfesionalServiciosPerfil(remoteHandle, context);
      pr_default = new DataStoreProvider(context, remoteHandle, new com.projectthani.prcgetprofesionalservicios__default(),
         new Object[] {
             new Object[] {
            P00732_A31ProfesionalId, P00732_A58ServiciosId, P00732_A210ServiciosNombre
            }
         }
      );
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private short Gx_err ;
   private int AV9ProfesionalId ;
   private int A31ProfesionalId ;
   private String scmdbuf ;
   private String A210ServiciosNombre ;
   private java.util.UUID A58ServiciosId ;
   private GXBaseCollection<com.projectthani.SdtSDTProfesionalServiciosPerfil>[] aP1 ;
   private IDataStoreProvider pr_default ;
   private int[] P00732_A31ProfesionalId ;
   private java.util.UUID[] P00732_A58ServiciosId ;
   private String[] P00732_A210ServiciosNombre ;
   private GXBaseCollection<com.projectthani.SdtSDTProfesionalServiciosPerfil> AV8ListaServicios ;
   private com.projectthani.SdtSDTProfesionalServiciosPerfil AV10Servicios ;
}

final  class prcgetprofesionalservicios__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P00732", "SELECT [ProfesionalId], [ServiciosId], [ServiciosNombre] FROM [ProfesionalServicios] WHERE [ProfesionalId] = ? ORDER BY [ProfesionalId] ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
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
               ((java.util.UUID[]) buf[1])[0] = rslt.getGUID(2);
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
               stmt.setInt(1, ((Number) parms[0]).intValue());
               return;
      }
   }

}

