package com.projectthani ;
import com.projectthani.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class prcgetespecialidadbyprofesional extends GXProcedure
{
   public prcgetespecialidadbyprofesional( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( prcgetespecialidadbyprofesional.class ), "" );
   }

   public prcgetespecialidadbyprofesional( int remoteHandle ,
                                           ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public String executeUdp( int aP0 )
   {
      prcgetespecialidadbyprofesional.this.aP1 = new String[] {""};
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
      prcgetespecialidadbyprofesional.this.AV8ProfesionalId = aP0;
      prcgetespecialidadbyprofesional.this.aP1 = aP1;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      /* Using cursor P005B2 */
      pr_default.execute(0, new Object[] {Integer.valueOf(AV8ProfesionalId)});
      while ( (pr_default.getStatus(0) != 101) )
      {
         A32EspecialidadId = P005B2_A32EspecialidadId[0] ;
         A31ProfesionalId = P005B2_A31ProfesionalId[0] ;
         A71EspecialidadNombre = P005B2_A71EspecialidadNombre[0] ;
         A71EspecialidadNombre = P005B2_A71EspecialidadNombre[0] ;
         AV9Especialidades += A71EspecialidadNombre + " / " ;
         pr_default.readNext(0);
      }
      pr_default.close(0);
      AV9Especialidades = GXutil.substring( AV9Especialidades, 1, GXutil.len( AV9Especialidades)-1) ;
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP1[0] = prcgetespecialidadbyprofesional.this.AV9Especialidades;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV9Especialidades = "" ;
      scmdbuf = "" ;
      P005B2_A32EspecialidadId = new short[1] ;
      P005B2_A31ProfesionalId = new int[1] ;
      P005B2_A71EspecialidadNombre = new String[] {""} ;
      A71EspecialidadNombre = "" ;
      pr_default = new DataStoreProvider(context, remoteHandle, new com.projectthani.prcgetespecialidadbyprofesional__default(),
         new Object[] {
             new Object[] {
            P005B2_A32EspecialidadId, P005B2_A31ProfesionalId, P005B2_A71EspecialidadNombre
            }
         }
      );
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private short A32EspecialidadId ;
   private short Gx_err ;
   private int AV8ProfesionalId ;
   private int A31ProfesionalId ;
   private String scmdbuf ;
   private String AV9Especialidades ;
   private String A71EspecialidadNombre ;
   private String[] aP1 ;
   private IDataStoreProvider pr_default ;
   private short[] P005B2_A32EspecialidadId ;
   private int[] P005B2_A31ProfesionalId ;
   private String[] P005B2_A71EspecialidadNombre ;
}

final  class prcgetespecialidadbyprofesional__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P005B2", "SELECT T1.[EspecialidadId], T1.[ProfesionalId], T2.[EspecialidadNombre] FROM ([ProfesionalEspecialidad] T1 INNER JOIN [Especialidad] T2 ON T2.[EspecialidadId] = T1.[EspecialidadId]) WHERE T1.[ProfesionalId] = ? ORDER BY T1.[ProfesionalId] ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
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
               ((int[]) buf[1])[0] = rslt.getInt(2);
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

