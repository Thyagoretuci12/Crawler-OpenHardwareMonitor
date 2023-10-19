library(readr)
library(ggplot2)
trusted_data <- read_csv("trusted-data.csv")

ggplot(data = trusted_data, aes( y = ram_value)) +
  geom_bar()

ggplot(data = trusted_data, aes(x = dataHora, y = temp_value)) +
  geom_line()

ggplot(data = trusted_data, aes(x = dataHora, y = ram_value)) +
  geom_line()

plot(trusted_data$ram_value~trusted_data$temp_value)
abline(4.08181, 0.02668)

#model <- lm(trusted_data$ram_value~trusted_data$temp_value)
#model


ggplot(mapping = aes(trusted_data$temp_value, trusted_data$ram_value)) +
  geom_point() +
  geom_smooth(method = "lm")

predict(lm(trusted_data$ram_value~trusted_data$temp_value))

summary(lm(trusted_data$ram_value~trusted_data$temp_value))

#BAR PLOT TEMPxRAM
ggplot(trusted_data, aes(x = ram_value, y = temp_value)) +
  geom_bar(stat = "identity")

#GRAFICO DE PIZZA
ggplot(trusted_data, aes(x = factor(1), fill = factor(ram_value))) +
geom_bar() +
coord_polar(theta = "y")

#GRAFICO DE REGRESSAO LINEAR
ggplot(trusted_data, aes(x = temp_value, y = ram_value)) +
  geom_point() +
  geom_smooth(method = "lm", se = FALSE) +
  labs(x = "Temperatura", y = "Uso de RAM")
  