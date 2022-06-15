package com.projectthani ;
import com.projectthani.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class dpespecialidaddisponibilidad extends GXProcedure
{
   public dpespecialidaddisponibilidad( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( dpespecialidaddisponibilidad.class ), "" );
   }

   public dpespecialidaddisponibilidad( int remoteHandle ,
                                        ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public GXBaseCollection<com.projectthani.SdtSDTEspecialidad> executeUdp( int aP0 )
   {
      dpespecialidaddisponibilidad.this.aP1 = new GXBaseCollection[] {new GXBaseCollection<com.projectthani.SdtSDTEspecialidad>()};
      execute_int(aP0, aP1);
      return aP1[0];
   }

   public void execute( int aP0 ,
                        GXBaseCollection<com.projectthani.SdtSDTEspecialidad>[] aP1 )
   {
      execute_int(aP0, aP1);
   }

   private void execute_int( int aP0 ,
                             GXBaseCollection<com.projectthani.SdtSDTEspecialidad>[] aP1 )
   {
      dpespecialidaddisponibilidad.this.AV5ProfesionalId = aP0;
      dpespecialidaddisponibilidad.this.aP1 = aP1;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      /* Using cursor P000G2 */
      pr_default.execute(0, new Object[] {Integer.valueOf(AV5ProfesionalId)});
      while ( (pr_default.getStatus(0) != 101) )
      {
         A31ProfesionalId = P000G2_A31ProfesionalId[0] ;
         A32EspecialidadId = P000G2_A32EspecialidadId[0] ;
         A71EspecialidadNombre = P000G2_A71EspecialidadNombre[0] ;
         A140EspecialidadCodigo = P000G2_A140EspecialidadCodigo[0] ;
         A71EspecialidadNombre = P000G2_A71EspecialidadNombre[0] ;
         A140EspecialidadCodigo = P000G2_A140EspecialidadCodigo[0] ;
         Gxm1sdtespecialidad = (com.projectthani.SdtSDTEspecialidad)new com.projectthani.SdtSDTEspecialidad(remoteHandle, context);
         Gxm2rootcol.add(Gxm1sdtespecialidad, 0);
         Gxm1sdtespecialidad.setgxTv_SdtSDTEspecialidad_Especialidadid( A32EspecialidadId );
         Gxm1sdtespecialidad.setgxTv_SdtSDTEspecialidad_Especialidadnombre( A71EspecialidadNombre );
         Gxm1sdtespecialidad.setgxTv_SdtSDTEspecialidad_Especialidadcodigo( A140EspecialidadCodigo );
         pr_default.readNext(0);
      }
      pr_default.close(0);
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP1[0] = dpespecialidaddisponibilidad.this.Gxm2rootcol;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      Gxm2rootcol = new GXBaseCollection<com.projectthani.SdtSDTEspecialidad>(com.projectthani.SdtSDTEspecialidad.class, "SDTEspecialidad", "ProjectThani", remoteHandle);
      scmdbuf = "" ;
      P000G2_A31ProfesionalId = new int[1] ;
      P000G2_A32EspecialidadId = new short[1] ;
      P000G2_A71EspecialidadNombre = new String[] {""} ;
      P000G2_A140EspecialidadCodigo = new String[] {""} ;
      A71EspecialidadNombre = "" ;
      A140EspecialidadCodigo = "" ;
      Gxm1sdtespecialidad = new com.projectthani.SdtSDTEspecialidad(remoteHandle, context);
      pr_default = new DataStoreProvider(context, remoteHandle, new com.projectthani.dpespecialidaddisponibilidad__default(),
         new Object[] {
             new Object[] {
            P000G2_A31ProfesionalId, P000G2_A32EspecialidadId, P000G2_A71EspecialidadNombre, P000G2_A140EspecialidadCodigo
            }
         }
      );
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private short A32EspecialidadId ;
   private short Gx_err ;
   private int AV5ProfesionalId ;
   private int A31ProfesionalId ;
   private String scmdbuf ;
   private String A71EspecialidadNombre ;
   private String A140EspecialidadCodigo ;
   private GXBaseCollection<com.projectthani.SdtSDTEspecialidad>[] aP1 ;
   private IDataStoreProvider pr_default ;
   private int[] P000G2_A31ProfesionalId ;
   private short[] P000G2_A32EspecialidadId ;
   private String[] P000G2_A71EspecialidadNombre ;
   private String[] P000G2_A140EspecialidadCodigo ;
   private GXBaseCollection<com.projectthani.SdtSDTEspecialidad> Gxm2rootcol ;
   private com.projectthani.SdtSDTEspecialidad Gxm1sdtespecialidad ;
}

final  class dpespecialidaddisponibilidad__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P000G2", "SELECT T1.[ProfesionalId], T1.[EspecialidadId], T2.[EspecialidadNombre], T2.[EspecialidadCodigo] FROM ([ProfesionalEspecialidad] T1 INNER JOIN [Especialidad] T2 ON T2.[EspecialidadId] = T1.[EspecialidadId]) WHERE T1.[ProfesionalId] = ? ORDER BY T1.[ProfesionalId] ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
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
               ((String[]) buf[2])[0] = rslt.getVarchar(3);
               ((String[]) buf[3])[0] = rslt.getVarchar(4);
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

