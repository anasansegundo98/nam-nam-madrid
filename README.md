# <img src="Logo-Photoroom.png" width="35" alt="Logotipo Ñam Ñam"> Ñam Ñam Madrid 


> Guía colaborativa para descubrir los mejores restaurantes de Madrid a través de experiencias reales y fotos de comida.

---

## 📖 Sobre el Proyecto

**Ñam Ñam Madrid** es una plataforma web colaborativa que permite a los madrileños compartir y descubrir restaurantes mediante fotos reales y valoraciones auténticas. A diferencia de otras plataformas, nos enfocamos en la experiencia visual y la comunidad local.

---

## ✨ Características Principales

- 🍕 Explora restaurantes por zona, tipo de cocina y rango de precio
- 📸 Sube fotos de tus platos favoritos
- ⭐ Valora y comenta tus experiencias gastronómicas
- ❤️ Guarda favoritos para visitarlos después
- 🗺️ Integración con Google Maps para ubicaciones exactas
- 🔥 Descubre tendencias y los restaurantes mejor valorados
- 👥 Comunidad moderada para mantener calidad del contenido

---

## 🛠️ Tech Stack

| Capa | Tecnologías |
|------|-------------|
| **Backend** | Java, Servlets, JSP, JSTL |
| **Frontend** | HTML5, CSS3, JavaScript, Bootstrap |
| **Base de Datos** | MySQL 8.0 |
| **Herramientas** | Maven, Apache Tomcat |

---

## 🏗️ Arquitectura

El proyecto sigue una arquitectura en 3 capas:

```
┌─────────────────────────────────────┐
│  CAPA PRESENTACIÓN (JSP)            │
│  - Páginas públicas                 │
│  - Páginas de usuario               │
│  - Panel administrativo             │
│  - JSTL para lógica de vista        │
└──────────────┬──────────────────────┘
               │
┌──────────────▼──────────────────────┐
│  CAPA NEGOCIO (Servlets)            │
│  - RestauranteServlet               │
│  - UsuarioServlet                   │
│  - FotoServlet                      │
│  - Validaciones                     │
│  - Lógica de negocio                │
└──────────────┬──────────────────────┘
               │
┌──────────────▼──────────────────────┐
│  CAPA DATOS (DAO)                   │
│  - RestauranteDAO                   │
│  - UsuarioDAO                       │
│  - FotoDAO                          │
│  - Conexión BD (JDBC)               │
│  - Operaciones CRUD                 │
└─────────────────────────────────────┘
```

---

## 🗄️ Modelo de Datos

### Diagrama Entidad-Relación

```
usuarios (1) ──── (N) restaurantes
usuarios (1) ──── (N) fotos_comida
usuarios (1) ──── (N) valoraciones
usuarios (N) ──── (N) favoritos

restaurantes (1) ──── (N) fotos_comida
restaurantes (1) ──── (N) valoraciones
restaurantes (N) ──── (1) categorias_cocina
restaurantes (N) ──── (1) zonas_madrid
```

### Tablas Principales

| Tabla | Descripción |
|-------|-------------|
| `usuarios` | Sistema de autenticación y roles (USER/ADMIN). Perfil con estadísticas. |
| `restaurantes` | Información completa: categoría, zona, precio, ubicación. Campo destacado para admin. |
| `fotos_comida` | Galería visual de platos subidas por usuarios, asociadas a restaurantes. |
| `valoraciones` | Sistema de ratings (1-5 estrellas), comentarios y fecha de visita. |
| `favoritos` | Lista personalizada por usuario. Relación N:M entre usuarios y restaurantes. |

---

## 🚀 Instalación y Configuración

### Requisitos Previos

- Java JDK 11 o superior
- Apache Tomcat 10.x
- MySQL 8.0
- Maven 3.8+
- IDE (Eclipse, IntelliJ IDEA, VS Code)

### Paso 1: Clonar el repositorio

```bash
git clone https://github.com/tu-usuario/nam-nam-madrid.git
cd nam-nam-madrid
```

### Paso 2: Configurar Base de Datos

```bash
# Crear la base de datos
mysql -u root -p

CREATE DATABASE nam_nam_db CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci;
USE nam_nam_db;

# Importar el schema
SOURCE database/schema.sql;

# Importar datos de ejemplo (opcional)
SOURCE database/seed_data.sql;
```

### Paso 3: Configurar Conexión

Edita el archivo `src/main/java/com/namnam/util/DatabaseConnection.java`:

```java
private static final String DB_URL = "jdbc:mysql://localhost:3306/nam_nam_db";
private static final String DB_USER = "tu_usuario";
private static final String DB_PASSWORD = "tu_password";
```

### Paso 4: Compilar y Ejecutar

```bash
# Compilar con Maven
mvn clean install

# Desplegar en Tomcat
cp target/nam-nam.war $TOMCAT_HOME/webapps/

# Iniciar Tomcat
$TOMCAT_HOME/bin/startup.sh
```

> La aplicación estará disponible en: **http://localhost:8080/nam-nam/**

---

## 📱 Funcionalidades

### 🌍 Zona Pública (sin registro)

- ✅ Explorar todos los restaurantes
- ✅ Ver fotos y valoraciones
- ✅ Filtrar por zona, tipo de cocina y precio
- ✅ Ver detalle completo de restaurantes
- ✅ Buscar por nombre o ubicación

### 👤 Zona Usuario (con registro)

- ✅ Añadir nuevos restaurantes
- ✅ Subir fotos de platos (máx 5 por restaurante)
- ✅ Valorar restaurantes con estrellas y comentarios
- ✅ Guardar restaurantes favoritos
- ✅ Ver perfil con estadísticas personales
- ✅ Gestionar mis restaurantes añadidos
- ✅ Ver historial de valoraciones

### 🔐 Zona Admin

- ✅ Dashboard con métricas del sistema
- ✅ Gestionar todos los restaurantes (CRUD completo)
- ✅ Moderar fotos inapropiadas
- ✅ Gestionar usuarios (ver actividad, banear)
- ✅ Destacar restaurantes en home
- ✅ Eliminar contenido reportado

---

## 🎨 Diseño Visual

### Paleta de Colores

```css
--naranja:     #FF4500  /* CTA, títulos principales */
--amarillo:    #FFD600  /* Acentos, badges */
--azul:        #0066FF  /* Elementos secundarios */
--marron:      #6B4423  /* Fondos cálidos */
--negro:       #1A1A1A  /* Texto principal */
--blanco:      #FFFFFF  /* Fondos limpios */
--gris-claro:  #F5F5F5  /* Backgrounds */
```

### Tipografía

- **Títulos:** Archivo Black (bold, impact)
- **Cuerpo:** Manrope (moderna, legible)

### Estilo

Inspirado en diseño editorial vibrante con títulos grandes y contundentes, fotos protagonistas, bloques de color sólido, animaciones suaves y grid asimétrico.

---

## 📂 Estructura del Proyecto

```
nam-nam-madrid/
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── com/namnam/
│   │   │       ├── servlets/
│   │   │       │   ├── RestauranteServlet.java
│   │   │       │   ├── UsuarioServlet.java
│   │   │       │   ├── FotoServlet.java
│   │   │       │   └── LoginServlet.java
│   │   │       ├── dao/
│   │   │       │   ├── RestauranteDAO.java
│   │   │       │   ├── UsuarioDAO.java
│   │   │       │   └── FotoDAO.java
│   │   │       ├── model/
│   │   │       │   ├── Restaurante.java
│   │   │       │   ├── Usuario.java
│   │   │       │   ├── Foto.java
│   │   │       │   └── Valoracion.java
│   │   │       ├── util/
│   │   │       │   ├── DatabaseConnection.java
│   │   │       │   └── HashUtil.java
│   │   │       └── filters/
│   │   │           ├── AuthFilter.java
│   │   │           └── AdminFilter.java
│   │   ├── webapp/
│   │   │   ├── public/
│   │   │   │   ├── index.jsp
│   │   │   │   ├── listado.jsp
│   │   │   │   ├── detalle.jsp
│   │   │   │   ├── login.jsp
│   │   │   │   └── registro.jsp
│   │   │   ├── user/
│   │   │   │   ├── perfil.jsp
│   │   │   │   ├── añadir-restaurante.jsp
│   │   │   │   ├── subir-foto.jsp
│   │   │   │   └── favoritos.jsp
│   │   │   ├── admin/
│   │   │   │   ├── dashboard.jsp
│   │   │   │   ├── gestionar-restaurantes.jsp
│   │   │   │   ├── gestionar-usuarios.jsp
│   │   │   │   └── gestionar-fotos.jsp
│   │   │   ├── css/
│   │   │   │   └── custom.css
│   │   │   ├── js/
│   │   │   │   └── main.js
│   │   │   ├── uploads/
│   │   │   └── WEB-INF/
│   │   │       └── web.xml
│   │   └── resources/
├── database/
│   ├── schema.sql
│   └── seed_data.sql
├── docs/
│   ├── screenshots/
│   └── diagrams/
├── pom.xml
└── README.md
```

---

## 🧪 Testing

```bash
# Ejecutar tests unitarios
mvn test

# Ejecutar tests de integración
mvn verify

# Generar reporte de cobertura
mvn jacoco:report
```

---

## 🚢 Deployment

### Opción 1: Railway (Recomendado)

```bash
# Instalar Railway CLI
npm i -g @railway/cli

# Login
railway login

# Deploy
railway up
```

### Opción 2: AWS / DigitalOcean

1. Configurar servidor con Tomcat
2. Configurar MySQL en la nube
3. Subir archivo `.war`
4. Configurar variables de entorno

---

## 🗺️ Roadmap

### ✅ Fase 1 - MVP (Completado)

- [x] Arquitectura 3 capas
- [x] Sistema de usuarios y roles
- [x] CRUD de restaurantes
- [x] Upload de fotos
- [x] Sistema de valoraciones
- [x] Panel administrativo

### 🚧 Fase 2 - En Desarrollo

- [ ] Integración Google Maps API
- [ ] Sistema de rutas temáticas
- [ ] Búsqueda avanzada
- [ ] Notificaciones

### 📅 Fase 3 - Futuro

- [ ] App móvil (React Native)
- [ ] API REST pública
- [ ] Sistema de reservas
- [ ] Integración con redes sociales
