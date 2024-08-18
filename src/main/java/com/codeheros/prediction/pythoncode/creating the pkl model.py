import numpy as np
import pandas as pd
from sklearn.neighbors import KNeighborsClassifier
from sklearn.model_selection import GridSearchCV
import pickle

# Load dataset
iris = pd.read_csv('./iris.csv')

# Drop the 'id' column
iris.drop('id', axis=1, inplace=True)

# Define features and target variable
X = iris[['sepal_len', 'sepal_wd', 'petal_len', 'petal_wd']]
y = iris['species']

# Create a KNN model
knn = KNeighborsClassifier()

# Create a dictionary of all values we want to test for n_neighbors
param_grid = {'n_neighbors': np.arange(2, 15)}

# Use GridSearchCV to test all values for n_neighbors
knn_gscv = GridSearchCV(knn, param_grid, cv=4)

# Fit model to the entire dataset
knn_gscv.fit(X, y)

# Retrieve the best model with the best parameters
best_knn = knn_gscv.best_estimator_

# Save the model using pickle
with open('iris_knn_model.pkl', 'wb') as model_file:
    pickle.dump(best_knn, model_file)

print("Model training complete and saved as 'iris_knn_model.pkl'")
