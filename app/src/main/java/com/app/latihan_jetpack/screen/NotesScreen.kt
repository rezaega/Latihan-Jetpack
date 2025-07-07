package com.app.latihan_jetpack.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.app.latihan_jetpack.model.response.NoteItem
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NotesScreenAlt(notes: List<NoteItem>) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("📝 My Notes") },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primary,
                    titleContentColor = Color.White
                ),
                modifier = Modifier.padding(24.dp)
            )
        }
    ) { paddingValues ->
        LazyColumn(
            contentPadding = paddingValues,
            modifier = Modifier
                .padding(16.dp)
                .fillMaxSize(),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            items(notes) { note ->
                NoteCardAlt(note)
            }
        }
    }
}

@Composable
fun NoteCardAlt(note: NoteItem) {
    Card(
        shape = RoundedCornerShape(16.dp),
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.secondaryContainer),
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp),
        modifier = Modifier.fillMaxWidth()
    ) {
        Row(
            modifier = Modifier.padding(16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            // Avatar bulat dengan inisial
            Box(
                modifier = Modifier
                    .size(48.dp)
                    .clip(CircleShape)
                    .background(MaterialTheme.colorScheme.primary),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = note.nm_lengkap.firstOrNull()?.uppercase() ?: "?",
                    color = Color.White,
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold
                )
            }

            Spacer(modifier = Modifier.width(16.dp))

            Column {
                Text(
                    text = note.title,
                    style = MaterialTheme.typography.titleMedium,
                    fontWeight = FontWeight.SemiBold
                )
                Text(
                    text = "By ${note.nm_lengkap} • 2025-07-05", // contoh tanggal
                    style = MaterialTheme.typography.bodySmall,
                    color = Color.Gray
                )
                Spacer(modifier = Modifier.height(4.dp))
                Text(
                    text = note.content,
                    style = MaterialTheme.typography.bodyMedium
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewNotesScreenAlt() {
    val dummyNotes = listOf(
        NoteItem(
            nm_lengkap = "Zidan",
            id_notes = "1",
            id_user = "user1",
            title = "🎯 Target Minggu Ini",
            content = "Belajar Compose dan buat mini project.",
            created_at = "",
            updated_at = ""
        ),
        NoteItem(
            nm_lengkap = "Admin",
            id_notes = "2",
            id_user = "user2",
            title = "🚀 Deployment",
            content = "Pelajari CI/CD dengan Github Actions.",
            created_at = "",
            updated_at = ""
        )
    )

    NotesScreenAlt(notes = dummyNotes)
}
