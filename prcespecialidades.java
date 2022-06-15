package com.projectthani ;
import com.projectthani.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class prcespecialidades extends GXProcedure
{
   public prcespecialidades( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( prcespecialidades.class ), "" );
   }

   public prcespecialidades( int remoteHandle ,
                             ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public GXBaseCollection<com.projectthani.SdtSDTEspecialidad> executeUdp( )
   {
      prcespecialidades.this.aP0 = new GXBaseCollection[] {new GXBaseCollection<com.projectthani.SdtSDTEspecialidad>()};
      execute_int(aP0);
      return aP0[0];
   }

   public void execute( GXBaseCollection<com.projectthani.SdtSDTEspecialidad>[] aP0 )
   {
      execute_int(aP0);
   }

   private void execute_int( GXBaseCollection<com.projectthani.SdtSDTEspecialidad>[] aP0 )
   {
      prcespecialidades.this.aP0 = aP0;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      /* Using cursor P005F2 */
      pr_default.execute(0);
      while ( (pr_default.getStatus(0) != 101) )
      {
         A32EspecialidadId = P005F2_A32EspecialidadId[0] ;
         A71EspecialidadNombre = P005F2_A71EspecialidadNombre[0] ;
         AV8Especialidad = (com.projectthani.SdtSDTEspecialidad)new com.projectthani.SdtSDTEspecialidad(remoteHandle, context);
         AV8Especialidad.setgxTv_SdtSDTEspecialidad_Especialidadid( A32EspecialidadId );
         AV8Especialidad.setgxTv_SdtSDTEspecialidad_Especialidadnombre( A71EspecialidadNombre );
         AV8Especialidad.setgxTv_SdtSDTEspecialidad_Especialidadcheck( false );
         AV9Especialidades.add(AV8Especialidad, 0);
         pr_default.readNext(0);
      }
      pr_default.close(0);
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP0[0] = prcespecialidades.this.AV9Especialidades;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV9Especialidades = new GXBaseCollection<com.projectthani.SdtSDTEspecialidad>(com.projectthani.SdtSDTEspecialidad.class, "SDTEspecialidad", "ProjectThani", remoteHandle);
      scmdbuf = "" ;
      P005F2_A32EspecialidadId = new short[1] ;
      P005F2_A71EspecialidadNombre = new String[] {""} ;
      A71EspecialidadNombre = "" ;
      AV8Especialidad = new com.projectthani.SdtSDTEspecialidad(remoteHandle, context);
      pr_default = new DataStoreProvider(context, remoteHandle, new com.projectthani.prcespecialidades__default(),
         new Object[] {
             new Object[] {
            P005F2_A32EspecialidadId, P005F2_A71EspecialidadNombre
            }
         }
      );
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private short A32EspecialidadId ;
   private short Gx_err ;
   private String scmdbuf ;
   private String A71EspecialidadNombre ;
   private GXBaseCollection<com.projectthani.SdtSDTEspecialidad>[] aP0 ;
   private IDataStoreProvider pr_default ;
   private short[] P005F2_A32EspecialidadId ;
   private String[] P005F2_A71EspecialidadNombre ;
   private GXBaseCollection<com.projectthani.SdtSDTEspecialidad> AV9Especialidades ;
   private com.projectthani.SdtSDTEspecialidad AV8Especialidad ;
}

final  class prcespecialidades__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P005F2", "SELECT [EspecialidadId], [EspecialidadNombre] FROM [Especialidad] ORDER BY [EspecialidadId] ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
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
      }
   }

   public void setParameters( int cursor ,
                              IFieldSetter stmt ,
                              Object[] parms ) throws SQLException
   {
      switch ( cursor )
      {
      }
   }

}

