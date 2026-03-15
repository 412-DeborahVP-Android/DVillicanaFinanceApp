package com.example.dvillicaafinanceapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Face
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.LeadingIconTab
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.modifier.modifierLocalOf
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.dvillicaafinanceapp.ui.theme.DVillicañaFinanceAppTheme
import com.example.dvillicaafinanceapp.ui.theme.naranjaPastel
import com.example.dvillicaafinanceapp.ui.theme.verdePastel
import com.example.dvillicaafinanceapp.ui.theme.moradoPastel
import com.example.dvillicaafinanceapp.ui.theme.fondo

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            DVillicañaFinanceAppTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    HomeScreen(innerPadding)
                }
            }
        }
    }
}

val user = User(
    name = "Deborah",
    balance = 280.99
)

val summaryCards = listOf(
    SummaryCard("Ventas", 280.99, naranjaPastel),
    SummaryCard("Ganancias", 280.99, moradoPastel)
)

val transactions = listOf(
    Transaction("Supermarket", "Groceries",
        45.99, "10:30 AM", icon = Icons.Default.ShoppingCart),
    Transaction("Gas Station", "Fuel",
        -30.5, "12:15 PM", icon = Icons.Default.ShoppingCart),
    Transaction("Coffee Shop", "Food & Drinks",
        5.75, "8:00 AM", icon = Icons.Default.ShoppingCart),
    Transaction("Electronic Store", "Electronics",
        120.00, "3:45 PM", icon = Icons.Default.ShoppingCart),
    Transaction("Bookstore", "Books",
        25.99, "2:00 PM", icon = Icons.Default.ShoppingCart),
    Transaction("Restaurant", "Dining",
        60.00, "7:30 PM", icon = Icons.Default.ShoppingCart)
)
@Composable
fun HomeScreen(innerPadding: PaddingValues){
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(fondo)
            .padding(paddingValues = innerPadding)
    ) {
        //Encabezado
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 50.dp)
                .padding(start = 20.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Box(
                modifier = Modifier
                    .clip(CircleShape)
                    .background(naranjaPastel)
                    .height(70.dp)
                    .width(70.dp),
                contentAlignment = Alignment.Center
            ){
                Icon(
                    imageVector =Icons.Default.AccountCircle,
                    contentDescription = "Usuario",
                    modifier = Modifier
                        .size(50.dp)
                )
            }
            Column() {
                Text(text = "Hola, ${user.name}",
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold)
                Text(text = "Bienvenida",
                    fontWeight = FontWeight.Medium,
                    color = Color.Gray,
                    modifier = Modifier.padding(top = 10.dp))
            }
            Spacer(modifier = Modifier.weight(1f))
            IconButton(
                onClick = {},
                modifier = Modifier.padding(end = 20.dp)
                ){
                Icon(
                    imageVector =Icons.Default.Menu,
                    contentDescription = "Menu",
                    modifier = Modifier.size(35.dp)
                )
            }
        }
        //Tarjetas de resumen
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(20.dp)
        ) {
            Card(
                modifier = Modifier
                    .height(250.dp)
                    .weight(1f),
                shape = RoundedCornerShape(20.dp),
                colors = CardDefaults.cardColors(containerColor = verdePastel)
            ) {
                Column(
                    modifier = Modifier.fillMaxSize(),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Icon(
                        imageVector = Icons.Default.Face,
                        contentDescription = "userActivity",
                        modifier = Modifier.size(30.dp)
                    )
                    Text(text = "Actividad",
                        fontWeight = FontWeight.Bold)
                    Text(text = "de la Semana",
                        fontWeight = FontWeight.Medium,
                        color = Color.Gray)
                }

            }
            Spacer(modifier = Modifier.width(16.dp))
            Column(modifier = Modifier
                .weight(1f)
                .height(250.dp),
                verticalArrangement = Arrangement.spacedBy(16.dp)) {
                Card(
                    modifier = Modifier
                        .weight(1f)
                        .fillMaxWidth(),
                    shape = RoundedCornerShape(20.dp),
                    colors = CardDefaults.cardColors(containerColor = summaryCards[0].backgroundColor)
                ) {
                    Box(
                        modifier = Modifier.fillMaxSize(),
                        contentAlignment = Alignment.Center
                    ) {
                        Column(
                            horizontalAlignment = Alignment.CenterHorizontally
                        ) {
                            Text(
                                text = summaryCards[0].title, color = Color.Gray
                            )
                            Text("$${summaryCards[0].amount}", fontWeight = FontWeight.Bold)
                        }
                    }
                }

                Card(
                    modifier = Modifier
                        .weight(1f)
                        .fillMaxWidth(),
                    shape = RoundedCornerShape(20.dp),
                    colors = CardDefaults.cardColors(containerColor = summaryCards[1].backgroundColor)
                ) {
                    Box(
                        modifier = Modifier.fillMaxSize(),
                        contentAlignment = Alignment.Center
                    ) {
                        Column(
                            horizontalAlignment = Alignment.CenterHorizontally
                        ) {
                            Text(text = summaryCards[1].title, color = Color.Gray)
                            Text("$${summaryCards[1].amount}", fontWeight = FontWeight.Bold)
                        }
                    }
                }
            }

        }
        //Transacciones
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 20.dp)
        ){
            Text(
                text = "Transactions",
                fontWeight = FontWeight.Bold,
                fontSize = 20.sp,
                modifier = Modifier.weight(1f))
            Text(
                text = "See All",
                color = Color.Gray,
                fontSize = 20.sp,
                modifier = Modifier.padding(end = 20.dp)
            )
        }

    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun GreetingPreview() {
    DVillicañaFinanceAppTheme {
        HomeScreen(innerPadding = PaddingValues())
    }
}