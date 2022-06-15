package com.projectthani ;
import com.projectthani.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class prcgetprofesionaleducacion extends GXProcedure
{
   public prcgetprofesionaleducacion( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( prcgetprofesionaleducacion.class ), "" );
   }

   public prcgetprofesionaleducacion( int remoteHandle ,
                                      ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public GXBaseCollection<com.projectthani.SdtSDTProfesionalEducacionPerfil> executeUdp( int aP0 )
   {
      prcgetprofesionaleducacion.this.aP1 = new GXBaseCollection[] {new GXBaseCollection<com.projectthani.SdtSDTProfesionalEducacionPerfil>()};
      execute_int(aP0, aP1);
      return aP1[0];
   }

   public void execute( int aP0 ,
                        GXBaseCollection<com.projectthani.SdtSDTProfesionalEducacionPerfil>[] aP1 )
   {
      execute_int(aP0, aP1);
   }

   private void execute_int( int aP0 ,
                             GXBaseCollection<com.projectthani.SdtSDTProfesionalEducacionPerfil>[] aP1 )
   {
      prcgetprofesionaleducacion.this.AV10ProfesionalId = aP0;
      prcgetprofesionaleducacion.this.aP1 = aP1;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      /* Using cursor P00702 */
      pr_default.execute(0, new Object[] {Integer.valueOf(AV10ProfesionalId)});
      while ( (pr_default.getStatus(0) != 101) )
      {
         A31ProfesionalId = P00702_A31ProfesionalId[0] ;
         A55EducacionId = P00702_A55EducacionId[0] ;
         A200EducacionNombreInstitucion = P00702_A200EducacionNombreInstitucion[0] ;
         A201EducacionDesde = P00702_A201EducacionDesde[0] ;
         A202EducacionHasta = P00702_A202EducacionHasta[0] ;
         A203EducacionPaisDescripcion = P00702_A203EducacionPaisDescripcion[0] ;
         AV8Educacion = (com.projectthani.SdtSDTProfesionalEducacionPerfil)new com.projectthani.SdtSDTProfesionalEducacionPerfil(remoteHandle, context);
         AV8Educacion.setgxTv_SdtSDTProfesionalEducacionPerfil_Id( A55EducacionId );
         AV8Educacion.setgxTv_SdtSDTProfesionalEducacionPerfil_Nombreinstitucion( A200EducacionNombreInstitucion );
         AV8Educacion.setgxTv_SdtSDTProfesionalEducacionPerfil_Desde( A201EducacionDesde );
         AV8Educacion.setgxTv_SdtSDTProfesionalEducacionPerfil_Hasta( A202EducacionHasta );
         AV8Educacion.setgxTv_SdtSDTProfesionalEducacionPerfil_Paisnombre( A203EducacionPaisDescripcion );
         AV9ListaEducacion.add(AV8Educacion, 0);
         pr_default.readNext(0);
      }
      pr_default.close(0);
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP1[0] = prcgetprofesionaleducacion.this.AV9ListaEducacion;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV9ListaEducacion = new GXBaseCollection<com.projectthani.SdtSDTProfesionalEducacionPerfil>(com.projectthani.SdtSDTProfesionalEducacionPerfil.class, "SDTProfesionalEducacionPerfil", "ProjectThani", remoteHandle);
      scmdbuf = "" ;
      P00702_A31ProfesionalId = new int[1] ;
      P00702_A55EducacionId = new java.util.UUID[] {java.util.UUID.fromString("00000000-0000-0000-0000-000000000000")} ;
      P00702_A200EducacionNombreInstitucion = new String[] {""} ;
      P00702_A201EducacionDesde = new java.util.Date[] {GXutil.nullDate()} ;
      P00702_A202EducacionHasta = new java.util.Date[] {GXutil.nullDate()} ;
      P00702_A203EducacionPaisDescripcion = new String[] {""} ;
      A55EducacionId = java.util.UUID.fromString("00000000-0000-0000-0000-000000000000") ;
      A200EducacionNombreInstitucion = "" ;
      A201EducacionDesde = GXutil.nullDate() ;
      A202EducacionHasta = GXutil.nullDate() ;
      A203EducacionPaisDescripcion = "" ;
      AV8Educacion = new com.projectthani.SdtSDTProfesionalEducacionPerfil(remoteHandle, context);
      pr_default = new DataStoreProvider(context, remoteHandle, new com.projectthani.prcgetprofesionaleducacion__default(),
         new Object[] {
             new Object[] {
            P00702_A31ProfesionalId, P00702_A55EducacionId, P00702_A200EducacionNombreInstitucion, P00702_A201EducacionDesde, P00702_A202EducacionHasta, P00702_A203EducacionPaisDescripcion
            }
         }
      );
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private short Gx_err ;
   private int AV10ProfesionalId ;
   private int A31ProfesionalId ;
   private String scmdbuf ;
   private java.util.Date A201EducacionDesde ;
   private java.util.Date A202EducacionHasta ;
   private String A200EducacionNombreInstitucion ;
   private String A203EducacionPaisDescripcion ;
   private java.util.UUID A55EducacionId ;
   private GXBaseCollection<com.projectthani.SdtSDTProfesionalEducacionPerfil>[] aP1 ;
   private IDataStoreProvider pr_default ;
   private int[] P00702_A31ProfesionalId ;
   private java.util.UUID[] P00702_A55EducacionId ;
   private String[] P00702_A200EducacionNombreInstitucion ;
   private java.util.Date[] P00702_A201EducacionDesde ;
   private java.util.Date[] P00702_A202EducacionHasta ;
   private String[] P00702_A203EducacionPaisDescripcion ;
   private GXBaseCollection<com.projectthani.SdtSDTProfesionalEducacionPerfil> AV9ListaEducacion ;
   private com.projectthani.SdtSDTProfesionalEducacionPerfil AV8Educacion ;
}

final  class prcgetprofesionaleducacion__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P00702", "SELECT [ProfesionalId], [EducacionId], [EducacionNombreInstitucion], [EducacionDesde], [EducacionHasta], [EducacionPaisDescripcion] FROM [ProfesionalEducacion] WHERE [ProfesionalId] = ? ORDER BY [ProfesionalId] ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
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
               ((java.util.Date[]) buf[3])[0] = rslt.getGXDate(4);
               ((java.util.Date[]) buf[4])[0] = rslt.getGXDate(5);
               ((String[]) buf[5])[0] = rslt.getVarchar(6);
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

