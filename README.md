# OpenAni

<div align="center">

![OpenAni](https://media1.tenor.com/m/cX92mi1p-NYAAAAd/coding-anime.gif)

</div>

> Una plataforma moderna para los amantes del anime sin límites, sin cuotas, sin restricciones.

OpenAni es una aplicación móvil de código abierto diseñada para los amantes de la cultura asiática que buscan una alternativa frente al alto coste de las plataformas de streaming actuales. La aplicación funciona como un portal para acceder a la API de nyaa.si permitiendo la descarga de anime y manga con la máxima calidad.

<div align="center">

![Android Studio](https://img.shields.io/badge/Android%20Studio-Java%2FKotlin-3479EB?style=flat-square&logo=androidstudio&logoColor=3479EB&logoSize=auto)
![License](https://img.shields.io/badge/License-Open%20Source-16081C?style=flat-square)
![Status](https://img.shields.io/badge/Status-Active-09081D?style=flat-square)

</div>

---

## Vista previa de la aplicación

<div style="display: flex; justify-content: center;">
<img src="https://github.com/astememe/OpenAni/blob/master/README_Images/Register.png?raw=true" style="width: 23%; margin: 2px;">
<img src="https://github.com/astememe/OpenAni/blob/master/README_Images/Home%20Anime.png?raw=true" style="width: 23%; margin: 2px;">
<img src="https://github.com/astememe/OpenAni/blob/master/README_Images/Download.png?raw=true" style="width: 23%; margin: 2px;">
<img src="https://github.com/astememe/OpenAni/blob/master/README_Images/Account.png?raw=true" style="width: 23%; margin: 2px;">
</div>

---


## Características Principales

<div align="center">

| Característica | Descripción |
|---|---|
| **Catálogo Ilimitado** | Biblioteca masiva de anime y manga |
| **Calidad Superior** | Archivos verificados con resolución original |
| **Búsqueda Avanzada** | Filtros por categoría y nombre |
| **Valoración Comunitaria** | Sistema de likes/dislikes para elegir descargas |

</div>

---

## Plataformas Soportadas

<div align="center">

| Plataforma | Implementación | Detalles Técnicos |
|:---:|---|---|
| ![Android](https://img.shields.io/badge/Android-3DDC84?style=for-the-badge&logo=android&logoColor=white) | **Android Studio** | • Java/Kotlin<br>• Retrofit + Gson<br>• Glide & RecycleView |
| ![iOS](https://img.shields.io/badge/iOS-000000?style=for-the-badge&logo=apple&logoColor=white) | **iOS/Web** | • React Native<br>• TypeScript<br>• Axios & Navigator<br>• FontAwesome Icons |

> Ambas versiones sincronizadas con base de datos Django centralizada

</div>

---

## Diseño Visual

### Paleta de Colores

<div align="center">

| Color | Código | Uso |
|-------|--------|-----|
| Martinique | `#32304B` | Fondo principal |
| Haiti | `#141237` | Relleno de tarjetas |
| Variación Oscura | `#09081D` | Bordes y decoraciones |
| Gallery | `#F0F0F0` | Texto e iconos |
| Variación Morada | `#16081C` | Botones y elementos |

</div>

### Tipografía

**Zud Juice** - Fuente oficial utilizada en scanlations de manga.

---


## Requisitos del Sistema

```
✓ Dispositivo móvil inteligente (Android/iOS)
✓ Conexión a Internet estable
✓ Almacenamiento suficiente para descargas
✓ Conocimientos técnicos básicos (manejo de torrents)
✓ Cliente torrent externo (BitTorrent, uTorrent, Flud, etc.)
```

---

## Arquitectura Técnica

| Componente | Tecnología |
|---|---|
| **Backend** | Django con API REST |
| **Base de Datos** | Entidades de Usuario, Torrent y Comentarios con relaciones de favoritos |
| **Android** | Retrofit y Gson para gestión de JSONs, Glide para imágenes, RecycleView para listas |
| **React Native** | Axios para APIs, React Navigator para navegación, FontAwesome para iconos |

### Características de la Base de Datos

| Entidad | Descripción |
|---|---|
| **User** | Registro, perfil, favoritos y comentarios |
| **Torrent** | Información de nyaa.si, sistema de votación |
| **Comment** | Comentarios sociales con likes/dislikes automáticos |
- **Relaciones:** Favorites, Writes, Have
---

## Licencia

OpenAni es un proyecto de código abierto.
