import pandas as pd
import numpy as np
import matplotlib.pyplot as plt
from sklearn.linear_model import LinearRegression
from sklearn.metrics import r2_score, mean_squared_error
from sklearn.model_selection import train_test_split
from sklearn import metrics

# imports dataset from a CSV file
house_data = pd.read_csv('kc_house_data.csv')

# prnts first five rows of data
print(house_data.head())

# assigns independent variable
X_kc = house_data[['sqft_living']]
# assigns dependent variable
y_kc = house_data['price']

# scatter plot to visualize the relationship between sqft_lving and Price
plt.figure(figsize=(12,6))
plt.scatter(X_kc, y_kc, alpha=0.5, color='blue')
plt.xlabel('sqft_living')
plt.ylabel('Price')
plt.title("Sqft Living vs Price")
plt.ticklabel_format(axis="y", style="plain")
plt.show()

# splits data into training and testing sets using 80% for training and 20% for testing
# Ensures model is learning real data patterns
X_train_kc, X_test_kc, y_train_kc, y_test_kc = train_test_split(
    X_kc, y_kc, test_size=0.2, random_state=0
)

# creates simple linear regression model
# a way to find a pattern in data based on a singular factor
# assumes house prices are only influenced by sqft
lin_reg_kc = LinearRegression()

# Trains the model using training data
lin_reg_kc.fit(X_train_kc, y_train_kc)

# makes prediction on test data
y_pred_kc = lin_reg_kc.predict(X_test_kc)

# prints values to assists the models performance
# average absolute difference between actual and predicted house prices
# average amount models prediction was off in dollars
print('Mean Absolute Error:', metrics.mean_absolute_error(y_test_kc, y_pred_kc))

# squared differences between actual and predicted prices
print('Mean Squared Error:', metrics.mean_squared_error(y_test_kc, y_pred_kc))

# converts the error measure back to the same unit as the original(dollar)
print('Root Mean Squared Error:', np.sqrt(metrics.mean_squared_error(y_test_kc, y_pred_kc)))

# how much variation in house prices is explained by the model
# ranges [0,1] closer to 1 the better match the model is
print('R2 Score:', r2_score(y_test_kc, y_pred_kc))

# price of house with zero sqft
print('Intercept:', lin_reg_kc.intercept_)

# how much prices increase every one sqft
print('Coefficient of line:', lin_reg_kc.coef_)

# creates index numbers for each test case
c_kc = [i for i in range(1,len(y_test_kc)+1,1)]

# graph to compare actual vs predicted price at a forty-five-degree angle. Line down the center marks where actual = predicted
plt.figure(figsize=(12,6))
plt.scatter(y_test_kc, y_pred_kc, alpha=0.5, color='green')
plt.plot([min(y_test_kc), max(y_test_kc)], [min(y_test_kc), max(y_test_kc)], color='red', linestyle='--')
plt.xlabel('Actual Price')
plt.ylabel('Predicted Price')
plt.title('Actual vs Predicted House Prices')
plt.ticklabel_format(axis="y", style="plain")
plt.ticklabel_format(axis="x", style="plain")
plt.show()

# residual plot graphs the differences between predicted price and errors
plt.figure(figsize=(12,6))
plt.scatter(y_pred_kc, y_test_kc - y_pred_kc, alpha=0.5, color='orange')
plt.axhline(y=0, color='blue', linestyle='dashed', linewidth=2)
plt.xlabel('Predicted Price')
plt.ylabel('Residual (Actual - Predicted)')
plt.title('Residual Plot')
plt.ticklabel_format(axis="y", style="plain")
plt.ticklabel_format(axis="x", style="plain")
plt.show()


# How does the simple linear regression model results (using sqft_living) compare to the multiple regression we ran in the tutorial.
# Which model (which features) better capture the variation in y based on the variation in the feature(s)?
# Justify your response based on output from your model(s).

response = '''
    Based on the R2 values for both the simple and the multiple regression, it can be hypothesis that having multiple
    factors can increase the fit of a model. Our simple linear regression had an R2 value of 0.479 and the multiple of 
    0.539. As we know the closer an R2 value is to 1 the better fit the model is. 
    
    Interestingly the intercepts of each model are very different. This supports the idea that using more features
    provides a more accurate pricing model.
'''
print(response)
