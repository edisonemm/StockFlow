# StockFlow - Phase 1

> Sistema de gestión de inventario para pequeños negocios. Aplicación de consola en Java puro implementando arquitectura en capas.

![Java](https://img.shields.io/badge/Java-17%2B-orange)
![Maven](https://img.shields.io/badge/Maven-3.9%2B-blue)
![License](https://img.shields.io/badge/License-MIT-green)

## 📋 Descripción

**StockFlow** es una aplicación de consola desarrollada en Java que permite a propietarios de pequeños negocios (tiendas, bodegas, distribuidoras) gestionar su inventario de forma eficiente. 

Con StockFlow puedes:
- ✅ Registrar nuevos productos
- ✅ Actualizar cantidades en stock
- ✅ Buscar productos por código o nombre
- ✅ Recibir alertas automáticas cuando el stock es bajo
- ✅ Generar reportes completos del inventario
- ✅ Visualizar el valor total del inventario

## 🚀 Características

| Funcionalidad | Descripción |
|---|---|
| **CRUD Completo** | Crear, leer, actualizar y eliminar productos |
| **Búsqueda Avanzada** | Busca por código o nombre (flexible) |
| **Alertas de Stock** | Notificaciones automáticas de inventario bajo |
| **Reportes** | Resumen del inventario con valor total |
| **Validación** | Todas las entradas se validan antes de procesar |
| **Arquitectura Clara** | Separación de responsabilidades en capas |

## 🏗️ Arquitectura

StockFlow implementa **Layered Architecture** (arquitectura en capas):

```
┌─────────────────────────────────┐
│         Menu (UI)               │ ← Presentación
├─────────────────────────────────┤
│    InventarioService            │ ← Lógica de negocio
├─────────────────────────────────┤
│    Producto (Model)             │ ← Entidad de datos
└─────────────────────────────────┘
```

### Clases

- **`Producto.java`** — Entidad que representa un producto con atributos como nombre, código, cantidad, precio y stock mínimo
- **`InventarioService.java`** — Lógica de negocio: validaciones, búsquedas, cálculos y alertas
- **`Menu.java`** — Interfaz de consola: menús, entrada de usuario, visualización de resultados
- **`Main.java`** — Punto de entrada de la aplicación

## 📦 Requisitos

- **Java 17** o superior
- **Maven 3.9** o superior

## 🔧 Instalación

### Opción 1: Clonar el repositorio

```bash
git clone https://github.com/tuusuario/stockflow.git
cd stockflow
```

### Opción 2: Descargar ZIP

Descarga el repositorio como ZIP y extrae en tu computadora.

## ▶️ Cómo Ejecutar

### Desde IntelliJ IDEA

1. Abre el proyecto en IntelliJ
2. Haz clic en el botón **Run** (▶️) en `Main.java`
3. La aplicación se abrirá en consola

### Desde Terminal

```bash
javac -d bin src/com/stockflow/**/*.java
java -cp bin com.stockflow.Main
```

## 💻 Uso

Cuando ejecutes la aplicación, verás este menú:

```
╔════════════════════════════════════╗
║         STOCKFLOW - MAIN MENU      ║
╠════════════════════════════════════╣
║  1. Add Product                    ║
║  2. View Inventory                 ║
║  3. Search Product                 ║
║  4. Update Stock                   ║
║  5. Delete Product                 ║
║  6. Low Stock Alerts               ║
║  7. Generate Report                ║
║  0. Exit                           ║
╚════════════════════════════════════╝
```

### Ejemplos de uso

**Agregar un producto:**
```
Select an option: 1
Product name: Coca-Cola
Product code: COCA001
Quantity: 50
Price: 2.50
Minimum stock: 10
✅ Product added successfully.
```

**Ver alertas de stock bajo:**
```
Select an option: 6
⚠️ Products with low stock:
[a1b2c3d4] Sprite (Code: SPRITE001) | Stock: 5 | Price: $2.50 | Total: $12.50 ⚠️ LOW STOCK
```

**Generar reporte:**
```
Select an option: 7
========== INVENTORY REPORT ==========
Total Products: 5
Total Inventory Value: $1500.00
Products with Low Stock: 2
... (lista de todos los productos)
=======================================
```

## 📁 Estructura del Proyecto

```
stockflow/
├── src/
│   └── com/stockflow/
│       ├── Main.java
│       ├── model/
│       │   └── Producto.java
│       ├── service/
│       │   └── InventarioService.java
│       └── ui/
│           └── Menu.java
├── .gitignore
├── README.md
└── pom.xml (si usas Maven)
```

## 🎓 Conceptos Java Aplicados

- ✅ Programación Orientada a Objetos (clases, objetos, encapsulamiento)
- ✅ Colecciones (ArrayList, Stream API)
- ✅ Manejo de excepciones (try-catch)
- ✅ Validación de datos
- ✅ Arquitectura en capas
- ✅ Lambda expressions

## 🗺️ Roadmap

| Fase | Estado | Descripción |
|---|---|---|
| **Fase 1** | ✅ Completa | Aplicación de consola con CRUD y alertas |
| **Fase 2** | 🔄 En desarrollo | API REST con Spring Boot y base de datos |
| **Fase 3** | ⏳ Próximamente | Frontend React conectado a la API |

## 📄 Documentación

La documentación completa está en los archivos:
- `StockFlow_Requisitos.pdf` — Especificación de requisitos funcionales
- `StockFlow_Diseno.pdf` — Arquitectura y diagrama de clases

## 👨‍💻 Autor

**Edison Monsalve Mesa**  
- Correo: edisonmonsalve21@gmail.com
- Teléfono: +57 314 563 40 68
- LinkedIn: [linkedin.com/in/edisonmonsalve](https://linkedin.com)
- GitHub: [github.com/edisonmonsalve](https://github.com)

Tecnólogo en Análisis y Desarrollo de Software — SENA

## 📝 Licencia

Este proyecto está bajo la licencia MIT. Puedes usar, modificar y distribuir libremente.

## 🤝 Contribuciones

¿Encontraste un bug? ¿Tienes una idea de mejora?

1. Fork el repositorio
2. Crea una rama: `git checkout -b feature/mejora`
3. Commit tus cambios: `git commit -m "Add mejora"`
4. Push a la rama: `git push origin feature/mejora`
5. Abre un Pull Request

## 📞 Soporte

Si tienes preguntas o problemas:
- Abre un **Issue** en GitHub
- Contáctame por correo: edisonmonsalve21@gmail.com

---

**Made with ❤️ by Edison Monsalve | June 2026**
