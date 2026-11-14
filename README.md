# Fencing Tally

Eine simple Android app zum Zählen von Punkten beim Fechten.\

## Motivation

Primär ein kleines Projekt um mich mit Software Entwicklung für Android
(Build-Prozess, Java, Views, etc.) vertraut zu machen.

## Build

### Benötigte Software

Für den Build-Prozess dieses Projektes müssen die `build-tools` der Android-SDK
und `javac` verfügbar sein. Die spezifischen Tools sind:

- `aapt`
- `javac`
- `d8`
- `zipalign`
- `apksigner`

### Befehle

Um zu verstehen wie der Build-Prozess für Androids APKs funktioniert, habe ich
ihn mit einem Makefile nachgestellt:

```bash
make build
```

Das vollständige APK ist `build/tally.apk`.
