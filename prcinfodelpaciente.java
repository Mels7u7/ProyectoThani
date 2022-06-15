package com.projectthani ;
import com.projectthani.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class prcinfodelpaciente extends GXProcedure
{
   public prcinfodelpaciente( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( prcinfodelpaciente.class ), "" );
   }

   public prcinfodelpaciente( int remoteHandle ,
                              ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public GXBaseCollection<com.projectthani.SdtSDTDatosDelPaciente> executeUdp( int aP0 )
   {
      prcinfodelpaciente.this.aP1 = new GXBaseCollection[] {new GXBaseCollection<com.projectthani.SdtSDTDatosDelPaciente>()};
      execute_int(aP0, aP1);
      return aP1[0];
   }

   public void execute( int aP0 ,
                        GXBaseCollection<com.projectthani.SdtSDTDatosDelPaciente>[] aP1 )
   {
      execute_int(aP0, aP1);
   }

   private void execute_int( int aP0 ,
                             GXBaseCollection<com.projectthani.SdtSDTDatosDelPaciente>[] aP1 )
   {
      prcinfodelpaciente.this.AV14PacienteId = aP0;
      prcinfodelpaciente.this.aP1 = aP1;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      /* Using cursor P006U2 */
      pr_default.execute(0, new Object[] {Integer.valueOf(AV14PacienteId)});
      while ( (pr_default.getStatus(0) != 101) )
      {
         A20PacienteId = P006U2_A20PacienteId[0] ;
         A104PacienteApellidoMaterno = P006U2_A104PacienteApellidoMaterno[0] ;
         A103PacienteApellidoPaterno = P006U2_A103PacienteApellidoPaterno[0] ;
         A105PacienteNombres = P006U2_A105PacienteNombres[0] ;
         A215PacienteDireccion = P006U2_A215PacienteDireccion[0] ;
         A216PacienteSexo = P006U2_A216PacienteSexo[0] ;
         A213PacienteFechaNacimiento = P006U2_A213PacienteFechaNacimiento[0] ;
         AV8Datos = (com.projectthani.SdtSDTDatosDelPaciente)new com.projectthani.SdtSDTDatosDelPaciente(remoteHandle, context);
         AV8Datos.setgxTv_SdtSDTDatosDelPaciente_Idpaciente( (short)(A20PacienteId) );
         AV8Datos.setgxTv_SdtSDTDatosDelPaciente_Nombresapellidos( A105PacienteNombres+" "+A103PacienteApellidoPaterno+" "+A104PacienteApellidoMaterno );
         AV8Datos.setgxTv_SdtSDTDatosDelPaciente_Direccion( "<i class=\"fas fa-map-marker-alt\"></i>  "+A215PacienteDireccion );
         if ( GXutil.strcmp(A216PacienteSexo, "F") == 0 )
         {
            AV8Datos.setgxTv_SdtSDTDatosDelPaciente_Fotografia( httpContext.convertURL( context.getHttpContext().getImagePath( "d1890f06-46aa-4333-8fe8-08b712ecd654", "", context.getHttpContext().getTheme( ))) );
         }
         else
         {
            AV8Datos.setgxTv_SdtSDTDatosDelPaciente_Fotografia( httpContext.convertURL( context.getHttpContext().getImagePath( "81e9701f-8a03-4c1e-9889-787d607f98eb", "", context.getHttpContext().getTheme( ))) );
         }
         AV16Year = (short)(GXutil.year( A213PacienteFechaNacimiento)) ;
         AV10Day = (short)(GXutil.day( A213PacienteFechaNacimiento)) ;
         AV18Mes = (short)(GXutil.month( A213PacienteFechaNacimiento)) ;
         AV19FechaNacimiento = A213PacienteFechaNacimiento ;
         AV13Month = localUtil.cmonth( localUtil.ctod( localUtil.dtoc( AV19FechaNacimiento, 3, "/"), 3), "spa") ;
         AV17YearToday = (short)(GXutil.year( Gx_date)) ;
         AV11Edad = (short)(AV17YearToday-AV16Year) ;
         AV12FechaActual = GXutil.str( AV10Day, 4, 0) + " de " + GXutil.lower( AV13Month) + " del " + GXutil.str( AV16Year, 4, 0) + ", " + GXutil.str( AV11Edad, 4, 0) + " años" ;
         AV8Datos.setgxTv_SdtSDTDatosDelPaciente_Fechanacimientoedad( "<i class=\"fas fa-birthday-cake\"></i>  "+AV12FechaActual );
         AV9DatosArray.add(AV8Datos, 0);
         /* Exiting from a For First loop. */
         if (true) break;
      }
      pr_default.close(0);
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP1[0] = prcinfodelpaciente.this.AV9DatosArray;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV9DatosArray = new GXBaseCollection<com.projectthani.SdtSDTDatosDelPaciente>(com.projectthani.SdtSDTDatosDelPaciente.class, "SDTDatosDelPaciente", "ProjectThani", remoteHandle);
      scmdbuf = "" ;
      P006U2_A20PacienteId = new int[1] ;
      P006U2_A104PacienteApellidoMaterno = new String[] {""} ;
      P006U2_A103PacienteApellidoPaterno = new String[] {""} ;
      P006U2_A105PacienteNombres = new String[] {""} ;
      P006U2_A215PacienteDireccion = new String[] {""} ;
      P006U2_A216PacienteSexo = new String[] {""} ;
      P006U2_A213PacienteFechaNacimiento = new java.util.Date[] {GXutil.nullDate()} ;
      A104PacienteApellidoMaterno = "" ;
      A103PacienteApellidoPaterno = "" ;
      A105PacienteNombres = "" ;
      A215PacienteDireccion = "" ;
      A216PacienteSexo = "" ;
      A213PacienteFechaNacimiento = GXutil.nullDate() ;
      AV8Datos = new com.projectthani.SdtSDTDatosDelPaciente(remoteHandle, context);
      AV19FechaNacimiento = GXutil.nullDate() ;
      AV13Month = "" ;
      Gx_date = GXutil.nullDate() ;
      AV12FechaActual = "" ;
      pr_default = new DataStoreProvider(context, remoteHandle, new com.projectthani.prcinfodelpaciente__default(),
         new Object[] {
             new Object[] {
            P006U2_A20PacienteId, P006U2_A104PacienteApellidoMaterno, P006U2_A103PacienteApellidoPaterno, P006U2_A105PacienteNombres, P006U2_A215PacienteDireccion, P006U2_A216PacienteSexo, P006U2_A213PacienteFechaNacimiento
            }
         }
      );
      Gx_date = GXutil.today( ) ;
      /* GeneXus formulas. */
      Gx_date = GXutil.today( ) ;
      Gx_err = (short)(0) ;
   }

   private short AV16Year ;
   private short AV10Day ;
   private short AV18Mes ;
   private short AV17YearToday ;
   private short AV11Edad ;
   private short Gx_err ;
   private int AV14PacienteId ;
   private int A20PacienteId ;
   private String scmdbuf ;
   private String A216PacienteSexo ;
   private java.util.Date A213PacienteFechaNacimiento ;
   private java.util.Date AV19FechaNacimiento ;
   private java.util.Date Gx_date ;
   private String A104PacienteApellidoMaterno ;
   private String A103PacienteApellidoPaterno ;
   private String A105PacienteNombres ;
   private String A215PacienteDireccion ;
   private String AV13Month ;
   private String AV12FechaActual ;
   private GXBaseCollection<com.projectthani.SdtSDTDatosDelPaciente>[] aP1 ;
   private IDataStoreProvider pr_default ;
   private int[] P006U2_A20PacienteId ;
   private String[] P006U2_A104PacienteApellidoMaterno ;
   private String[] P006U2_A103PacienteApellidoPaterno ;
   private String[] P006U2_A105PacienteNombres ;
   private String[] P006U2_A215PacienteDireccion ;
   private String[] P006U2_A216PacienteSexo ;
   private java.util.Date[] P006U2_A213PacienteFechaNacimiento ;
   private GXBaseCollection<com.projectthani.SdtSDTDatosDelPaciente> AV9DatosArray ;
   private com.projectthani.SdtSDTDatosDelPaciente AV8Datos ;
}

final  class prcinfodelpaciente__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P006U2", "SELECT [PacienteId], [PacienteApellidoMaterno], [PacienteApellidoPaterno], [PacienteNombres], [PacienteDireccion], [PacienteSexo], [PacienteFechaNacimiento] FROM [Paciente] WHERE [PacienteId] = ? ORDER BY [PacienteId] ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
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
               ((String[]) buf[3])[0] = rslt.getVarchar(4);
               ((String[]) buf[4])[0] = rslt.getVarchar(5);
               ((String[]) buf[5])[0] = rslt.getString(6, 1);
               ((java.util.Date[]) buf[6])[0] = rslt.getGXDate(7);
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

